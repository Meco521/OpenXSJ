/*     */ package net.ccbluex.liquidbounce.utils.item;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Comparator;
/*     */ import net.ccbluex.liquidbounce.api.enums.EnchantmentType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemArmor;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ 
/*     */ public class ArmorComparator
/*     */   extends MinecraftInstance
/*     */   implements Comparator<ArmorPiece>
/*     */ {
/*  16 */   private static final IEnchantment[] DAMAGE_REDUCTION_ENCHANTMENTS = new IEnchantment[] { classProvider.getEnchantmentEnum(EnchantmentType.PROTECTION), classProvider.getEnchantmentEnum(EnchantmentType.PROJECTILE_PROTECTION), classProvider.getEnchantmentEnum(EnchantmentType.FIRE_PROTECTION), classProvider.getEnchantmentEnum(EnchantmentType.BLAST_PROTECTION) };
/*  17 */   private static final float[] ENCHANTMENT_FACTORS = new float[] { 1.5F, 0.4F, 0.39F, 0.38F };
/*  18 */   private static final float[] ENCHANTMENT_DAMAGE_REDUCTION_FACTOR = new float[] { 0.04F, 0.08F, 0.15F, 0.08F };
/*  19 */   private static final IEnchantment[] OTHER_ENCHANTMENTS = new IEnchantment[] { classProvider.getEnchantmentEnum(EnchantmentType.FEATHER_FALLING), classProvider.getEnchantmentEnum(EnchantmentType.THORNS), classProvider.getEnchantmentEnum(EnchantmentType.RESPIRATION), classProvider.getEnchantmentEnum(EnchantmentType.AQUA_AFFINITY), classProvider.getEnchantmentEnum(EnchantmentType.UNBREAKING) };
/*  20 */   private static final float[] OTHER_ENCHANTMENT_FACTORS = new float[] { 3.0F, 1.0F, 0.1F, 0.05F, 0.01F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double round(double value, int places) {
/*  30 */     if (places < 0) {
/*  31 */       throw new IllegalArgumentException();
/*     */     }
/*  33 */     BigDecimal bd = BigDecimal.valueOf(value);
/*  34 */     bd = bd.setScale(places, RoundingMode.HALF_UP);
/*  35 */     return bd.doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compare(ArmorPiece o1, ArmorPiece o2) {
/*  43 */     int compare = Double.compare(round(getThresholdedDamageReduction(o2.getItemStack()), 3), round(getThresholdedDamageReduction(o1.getItemStack()), 3));
/*     */ 
/*     */     
/*  46 */     if (compare == 0) {
/*  47 */       int otherEnchantmentCmp = Double.compare(round(getEnchantmentThreshold(o1.getItemStack()), 3), round(getEnchantmentThreshold(o2.getItemStack()), 3));
/*     */ 
/*     */       
/*  50 */       if (otherEnchantmentCmp == 0) {
/*  51 */         int enchantmentCountCmp = Integer.compare(ItemUtils.getEnchantmentCount(o1.getItemStack()), ItemUtils.getEnchantmentCount(o2.getItemStack()));
/*     */         
/*  53 */         if (enchantmentCountCmp != 0) {
/*  54 */           return enchantmentCountCmp;
/*     */         }
/*     */         
/*  57 */         IItemArmor o1a = o1.getItemStack().getItem().asItemArmor();
/*  58 */         IItemArmor o2a = o2.getItemStack().getItem().asItemArmor();
/*     */         
/*  60 */         int durabilityCmp = Integer.compare(o1a.getArmorMaterial().getDurability(o1a.getArmorType()), o2a.getArmorMaterial().getDurability(o2a.getArmorType()));
/*     */         
/*  62 */         if (durabilityCmp != 0) {
/*  63 */           return durabilityCmp;
/*     */         }
/*     */ 
/*     */         
/*  67 */         return Integer.compare(o1a.getArmorMaterial().getEnchantability(), o2a.getArmorMaterial().getEnchantability());
/*     */       } 
/*     */       
/*  70 */       return otherEnchantmentCmp;
/*     */     } 
/*     */     
/*  73 */     return compare;
/*     */   }
/*     */   
/*     */   private float getThresholdedDamageReduction(IItemStack itemStack) {
/*  77 */     IItemArmor item = itemStack.getItem().asItemArmor();
/*     */     
/*  79 */     return getDamageReduction(item.getArmorMaterial().getDamageReductionAmount(item.getArmorType()), 0) * (1.0F - getThresholdedEnchantmentDamageReduction(itemStack));
/*     */   }
/*     */   
/*     */   private float getDamageReduction(int defensePoints, int toughness) {
/*  83 */     return 1.0F - Math.min(20.0F, Math.max(defensePoints / 5.0F, defensePoints - 1.0F / (2.0F + toughness / 4.0F))) / 25.0F;
/*     */   }
/*     */   
/*     */   private float getThresholdedEnchantmentDamageReduction(IItemStack itemStack) {
/*  87 */     float sum = 0.0F;
/*     */     
/*  89 */     for (int i = 0; i < DAMAGE_REDUCTION_ENCHANTMENTS.length; i++) {
/*  90 */       sum += ItemUtils.getEnchantment(itemStack, DAMAGE_REDUCTION_ENCHANTMENTS[i]) * ENCHANTMENT_FACTORS[i] * ENCHANTMENT_DAMAGE_REDUCTION_FACTOR[i];
/*     */     }
/*     */     
/*  93 */     return sum;
/*     */   }
/*     */ 
/*     */   
/*     */   private float getEnchantmentThreshold(IItemStack itemStack) {
/*  98 */     float sum = 0.0F;
/*     */     
/* 100 */     for (int i = 0; i < OTHER_ENCHANTMENTS.length; i++) {
/* 101 */       sum += ItemUtils.getEnchantment(itemStack, OTHER_ENCHANTMENTS[i]) * OTHER_ENCHANTMENT_FACTORS[i];
/*     */     }
/*     */     
/* 104 */     return sum;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\item\ArmorComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */