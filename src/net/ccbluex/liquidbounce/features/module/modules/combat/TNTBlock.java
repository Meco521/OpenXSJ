/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ @ModuleInfo(name = "TNTBlock", description = "Automatically blocks with your sword when TNT around you explodes.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\022\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/TNTBlock;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoSwordValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "blocked", "", "fuseValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "rangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onMotionUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "XSJClient"})
/*    */ public final class TNTBlock extends Module {
/* 14 */   private final IntegerValue fuseValue = new IntegerValue("Fuse", 10, 0, 80);
/* 15 */   private final FloatValue rangeValue = new FloatValue("Range", 9.0F, 1.0F, 20.0F);
/* 16 */   private final BoolValue autoSwordValue = new BoolValue("AutoSword", true);
/*    */   private boolean blocked;
/*    */   
/*    */   @EventTarget
/*    */   public final void onMotionUpdate(@Nullable MotionEvent event) {
/* 21 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 22 */       if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*    */         
/* 24 */         for (IEntity entity : theWorld.getLoadedEntityList()) {
/* 25 */           if (MinecraftInstance.classProvider.isEntityTNTPrimed(entity) && thePlayer.getDistanceToEntity(entity) <= ((Number)this.rangeValue.get()).floatValue()) {
/* 26 */             IEntityTNTPrimed tntPrimed = entity.asEntityTNTPrimed();
/*    */             
/* 28 */             if (tntPrimed.getFuse() <= ((Number)this.fuseValue.get()).intValue()) {
/* 29 */               if (((Boolean)this.autoSwordValue.get()).booleanValue()) {
/* 30 */                 int slot = -1;
/* 31 */                 float bestDamage = 1.0F;
/* 32 */                 for (byte b1 = 0, b2 = 8; b1 <= b2; b1++) {
/* 33 */                   IItemStack itemStack = thePlayer.getInventory().getStackInSlot(b1);
/*    */                   
/* 35 */                   if (itemStack != null && MinecraftInstance.classProvider.isItemSword(itemStack.getItem())) {
/* 36 */                     if (itemStack.getItem() == null) Intrinsics.throwNpe();  float itemDamage = itemStack.getItem().asItemSword().getDamageVsEntity() + 4.0F;
/*    */                     
/* 38 */                     if (itemDamage > bestDamage) {
/* 39 */                       bestDamage = itemDamage;
/* 40 */                       slot = b1;
/*    */                     } 
/*    */                   } 
/*    */                 } 
/*    */                 
/* 45 */                 if (slot != -1 && slot != thePlayer.getInventory().getCurrentItem()) {
/* 46 */                   thePlayer.getInventory().setCurrentItem(slot);
/* 47 */                   MinecraftInstance.mc.getPlayerController().updateController();
/*    */                 } 
/*    */               } 
/*    */               
/* 51 */               if (thePlayer.getHeldItem() != null) { if (thePlayer.getHeldItem() == null) Intrinsics.throwNpe();  if (MinecraftInstance.classProvider.isItemSword(thePlayer.getHeldItem().getItem())) {
/* 52 */                   MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(true);
/* 53 */                   this.blocked = true;
/*    */                 }  }
/*    */ 
/*    */               
/*    */               return;
/*    */             } 
/*    */           } 
/*    */         } 
/* 61 */         if (this.blocked && !MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindUseItem())) {
/* 62 */           MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(false);
/* 63 */           this.blocked = false;
/*    */         } 
/*    */         return; }
/*    */       
/*    */       MinecraftInstance.mc.getTheWorld();
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\TNTBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */