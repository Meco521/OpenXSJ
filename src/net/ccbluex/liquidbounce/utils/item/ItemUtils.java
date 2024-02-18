/*     */ package net.ccbluex.liquidbounce.utils.item;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.regex.Pattern;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagCompound;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import org.jetbrains.annotations.Contract;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ItemUtils
/*     */   extends MinecraftInstance
/*     */ {
/*     */   public static IItemStack createItem(String itemArguments) {
/*     */     try {
/*  28 */       itemArguments = itemArguments.replace('&', '§');
/*  29 */       IItem item = classProvider.createItem();
/*  30 */       IItem itemInstance = item;
/*  31 */       String[] args = null;
/*  32 */       int i = 1;
/*  33 */       int j = 0;
/*     */       
/*  35 */       for (int mode = 0; mode <= Math.min(12, itemArguments.length() - 2); mode++) {
/*  36 */         args = itemArguments.substring(mode).split(Pattern.quote(" "));
/*  37 */         IResourceLocation resourcelocation = classProvider.createResourceLocation(args[0]);
/*  38 */         item = functions.getObjectFromItemRegistry(resourcelocation);
/*     */         
/*  40 */         if (item != null) {
/*     */           break;
/*     */         }
/*     */       } 
/*  44 */       if (item == null) {
/*  45 */         return null;
/*     */       }
/*  47 */       if (((String[])Objects.requireNonNull((T)args)).length >= 2 && args[1].matches("\\d+"))
/*  48 */         i = Integer.parseInt(args[1]); 
/*  49 */       if (args.length >= 3 && args[2].matches("\\d+")) {
/*  50 */         j = Integer.parseInt(args[2]);
/*     */       }
/*  52 */       IItemStack itemstack = classProvider.createItemStack(item, i, j);
/*     */       
/*  54 */       if (args.length >= 4) {
/*  55 */         StringBuilder NBT = new StringBuilder();
/*  56 */         for (int nbtcount = 3; nbtcount < args.length; nbtcount++)
/*  57 */           NBT.append(" ").append(args[nbtcount]); 
/*  58 */         itemstack.setTagCompound(classProvider.getJsonToNBTInstance().getTagFromJson(NBT.toString()));
/*     */       } 
/*     */       
/*  61 */       return itemstack;
/*  62 */     } catch (Exception exception) {
/*  63 */       exception.printStackTrace();
/*  64 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int getEnchantment(IItemStack itemStack, IEnchantment enchantment) {
/*  69 */     if (itemStack == null || itemStack.getEnchantmentTagList() == null || itemStack.getEnchantmentTagList().hasNoTags()) {
/*  70 */       return 0;
/*     */     }
/*  72 */     for (int i = 0; i < itemStack.getEnchantmentTagList().tagCount(); i++) {
/*  73 */       INBTTagCompound tagCompound = itemStack.getEnchantmentTagList().getCompoundTagAt(i);
/*     */       
/*  75 */       if ((tagCompound.hasKey("ench") && tagCompound.getShort("ench") == enchantment.getEffectId()) || (tagCompound.hasKey("id") && tagCompound.getShort("id") == enchantment.getEffectId())) {
/*  76 */         return tagCompound.getShort("lvl");
/*     */       }
/*     */     } 
/*  79 */     return 0;
/*     */   }
/*     */   
/*     */   public static int getEnchantmentCount(IItemStack itemStack) {
/*  83 */     if (itemStack == null || itemStack.getEnchantmentTagList() == null || itemStack.getEnchantmentTagList().hasNoTags()) {
/*  84 */       return 0;
/*     */     }
/*  86 */     int c = 0;
/*     */     
/*  88 */     for (int i = 0; i < itemStack.getEnchantmentTagList().tagCount(); i++) {
/*  89 */       INBTTagCompound tagCompound = itemStack.getEnchantmentTagList().getCompoundTagAt(i);
/*     */       
/*  91 */       if (tagCompound.hasKey("ench") || tagCompound.hasKey("id")) {
/*  92 */         c++;
/*     */       }
/*     */     } 
/*  95 */     return c;
/*     */   }
/*     */   
/*     */   @Contract("null -> true")
/*     */   public static boolean isStackEmpty(IItemStack stack) {
/* 100 */     return (stack == null || classProvider.isItemAir(stack.getItem()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\item\ItemUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */