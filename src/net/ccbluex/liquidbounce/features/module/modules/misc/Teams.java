/*     */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemArmor;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "Teams", description = "Prevents Killaura from attacking team mates.", category = ModuleCategory.MISC)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\016\020\f\032\0020\r2\006\020\016\032\0020\017R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/Teams;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AntiBot1Value", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "armorColor2Value", "armorColorValue", "armorIndexValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorValue", "gommeSWValue", "scoreboardValue", "isInYourTeam", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "XSJClient"})
/*     */ public final class Teams extends Module {
/*  21 */   private final BoolValue scoreboardValue = new BoolValue("ScoreboardTeam", true);
/*  22 */   private final BoolValue colorValue = new BoolValue("Color", true);
/*  23 */   private final BoolValue gommeSWValue = new BoolValue("GommeSW", false);
/*  24 */   private final BoolValue armorColorValue = new BoolValue("ArmorColor", false);
/*  25 */   private final BoolValue armorColor2Value = new BoolValue("Hyt4v4", false);
/*  26 */   private final BoolValue AntiBot1Value = new BoolValue("Hyt4v4Anti", false);
/*  27 */   private final IntegerValue armorIndexValue = new IntegerValue("ArmorIndex", 3, 0, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInYourTeam(@NotNull IEntityLivingBase entity) {
/*  33 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  35 */       if (((Boolean)this.scoreboardValue.get()).booleanValue() && thePlayer.getTeam() != null && entity.getTeam() != null) {
/*  36 */         if (thePlayer.getTeam() == null) Intrinsics.throwNpe();  if (entity.getTeam() == null) Intrinsics.throwNpe();  if (thePlayer.getTeam().isSameTeam(entity.getTeam()))
/*  37 */           return true; 
/*     */       } 
/*  39 */       IIChatComponent displayName = thePlayer.getDisplayName();
/*     */ 
/*     */       
/*  42 */       if (((Boolean)this.AntiBot1Value.get()).booleanValue()) {
/*  43 */         if (thePlayer.getInventory().getArmorInventory().get(3) != null) {
/*  44 */           IItemStack myHead = (IItemStack)thePlayer.getInventory().getArmorInventory().get(3);
/*  45 */           if (myHead == null) Intrinsics.throwNpe();  if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor iItemArmor = myHead.getItem().asItemArmor();
/*     */         } 
/*  47 */         IEntityPlayer entityPlayer = entity.asEntityPlayer();
/*     */         
/*  49 */         if (thePlayer.getInventory().getArmorInventory().get(3) != null && entityPlayer.getInventory().getArmorInventory().get(3) != null) {
/*  50 */           IItemStack myHead = (IItemStack)thePlayer.getInventory().getArmorInventory().get(3);
/*  51 */           if (myHead == null) Intrinsics.throwNpe();  if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor myItemArmor = myHead.getItem().asItemArmor();
/*     */ 
/*     */           
/*  54 */           IItemStack entityHead = (IItemStack)entityPlayer.getInventory().getArmorInventory().get(3);
/*  55 */           if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor entityItemArmor = myHead.getItem().asItemArmor();
/*     */           
/*  57 */           if (entityHead == null) Intrinsics.throwNpe();  if (Intrinsics.areEqual(String.valueOf(entityItemArmor.getColor(entityHead)), "10511680")) {
/*  58 */             return true;
/*     */           }
/*  60 */           if (myItemArmor.getColor(myHead) == entityItemArmor.getColor(entityHead)) {
/*  61 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  66 */       if (((Boolean)this.armorColor2Value.get()).booleanValue()) {
/*  67 */         if (thePlayer.getInventory().getArmorInventory().get(3) != null) {
/*  68 */           IItemStack myHead = (IItemStack)thePlayer.getInventory().getArmorInventory().get(3);
/*  69 */           if (myHead == null) Intrinsics.throwNpe();  if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor iItemArmor = myHead.getItem().asItemArmor();
/*     */         } 
/*  71 */         IEntityPlayer entityPlayer = entity.asEntityPlayer();
/*     */         
/*  73 */         if (thePlayer.getInventory().getArmorInventory().get(3) != null && entityPlayer.getInventory().getArmorInventory().get(3) != null) {
/*  74 */           IItemStack myHead = (IItemStack)thePlayer.getInventory().getArmorInventory().get(3);
/*  75 */           if (myHead == null) Intrinsics.throwNpe();  if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor myItemArmor = myHead.getItem().asItemArmor();
/*     */ 
/*     */           
/*  78 */           IItemStack entityHead = (IItemStack)entityPlayer.getInventory().getArmorInventory().get(3);
/*  79 */           if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor entityItemArmor = myHead.getItem().asItemArmor();
/*     */           
/*  81 */           if (entityHead == null) Intrinsics.throwNpe();  if (myItemArmor.getColor(myHead) == entityItemArmor.getColor(entityHead)) {
/*  82 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  87 */       if (((Boolean)this.armorColorValue.get()).booleanValue()) {
/*  88 */         IEntityPlayer entityPlayer = entity.asEntityPlayer();
/*  89 */         if (thePlayer.getInventory().getArmorInventory().get(((Number)this.armorIndexValue.get()).intValue()) != null && entityPlayer.getInventory().getArmorInventory().get(((Number)this.armorIndexValue.get()).intValue()) != null) {
/*  90 */           IItemStack myHead = (IItemStack)thePlayer.getInventory().getArmorInventory().get(((Number)this.armorIndexValue.get()).intValue());
/*  91 */           if (myHead == null) Intrinsics.throwNpe();  if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor myItemArmor = myHead.getItem().asItemArmor();
/*     */ 
/*     */           
/*  94 */           IItemStack entityHead = (IItemStack)entityPlayer.getInventory().getArmorInventory().get(((Number)this.armorIndexValue.get()).intValue());
/*  95 */           if (myHead.getItem() == null) Intrinsics.throwNpe();  IItemArmor entityItemArmor = myHead.getItem().asItemArmor();
/*     */           
/*  97 */           if (entityHead == null) Intrinsics.throwNpe();  if (myItemArmor.getColor(myHead) == entityItemArmor.getColor(entityHead)) {
/*  98 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 103 */       if (((Boolean)this.gommeSWValue.get()).booleanValue() && displayName != null && entity.getDisplayName() != null) {
/* 104 */         if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String targetName = StringsKt.replace$default(entity.getDisplayName().getFormattedText(), "§r", "", false, 4, null);
/* 105 */         String clientName = StringsKt.replace$default(displayName.getFormattedText(), "§r", "", false, 4, null);
/* 106 */         if (StringsKt.startsWith$default(targetName, "T", false, 2, null) && StringsKt.startsWith$default(clientName, "T", false, 2, null)) {
/* 107 */           char c = targetName.charAt(1); boolean bool = false; if (Character.isDigit(c)) { c = clientName.charAt(1); bool = false; if (Character.isDigit(c))
/* 108 */               return (targetName.charAt(1) == clientName.charAt(1));  }
/*     */         
/*     */         } 
/* 111 */       }  if (((Boolean)this.colorValue.get()).booleanValue() && displayName != null && entity.getDisplayName() != null) {
/* 112 */         if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String targetName = StringsKt.replace$default(entity.getDisplayName().getFormattedText(), "§r", "", false, 4, null);
/* 113 */         String clientName = StringsKt.replace$default(displayName.getFormattedText(), "§r", "", false, 4, null);
/* 114 */         return StringsKt.startsWith$default(targetName, '§' + clientName.charAt(1), false, 2, null);
/*     */       } 
/*     */       
/* 117 */       return false; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\Teams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */