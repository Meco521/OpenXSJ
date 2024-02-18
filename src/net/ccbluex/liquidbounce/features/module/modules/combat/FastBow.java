/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ @ModuleInfo(name = "FastBow", description = "Turns your bow into a machine gun.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/FastBow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "packetsValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class FastBow extends Module {
/* 17 */   private final IntegerValue packetsValue = new IntegerValue("Packets", 20, 3, 20);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 21 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 23 */       if (!thePlayer.isUsingItem()) {
/*    */         return;
/*    */       }
/* 26 */       IItemStack currentItem = thePlayer.getInventory().getCurrentItemInHand();
/*    */       
/* 28 */       if (currentItem != null && MinecraftInstance.classProvider.isItemBow(currentItem.getItem())) {
/*    */         
/* 30 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(WBlockPos.Companion.getORIGIN(), 255, currentItem, 0.0F, 0.0F, 0.0F));
/*    */         
/* 32 */         float yaw = (RotationUtils.targetRotation != null) ? 
/* 33 */           RotationUtils.targetRotation.getYaw() : 
/*    */           
/* 35 */           thePlayer.getRotationYaw();
/*    */         
/* 37 */         float pitch = (RotationUtils.targetRotation != null) ? 
/* 38 */           RotationUtils.targetRotation.getPitch() : 
/*    */           
/* 40 */           thePlayer.getRotationPitch(); byte b;
/*    */         int i;
/* 42 */         for (b = 0, i = ((Number)this.packetsValue.get()).intValue(); b < i; b++) {
/* 43 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerLook(yaw, pitch, true));
/*    */         }
/* 45 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN)));
/* 46 */         thePlayer.setItemInUseCount(currentItem.getMaxItemUseDuration() - 1);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\FastBow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */