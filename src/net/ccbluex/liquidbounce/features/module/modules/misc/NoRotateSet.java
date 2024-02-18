/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketPosLook;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ 
/*    */ @ModuleInfo(name = "NoRotateSet", description = "Prevents the server from rotating your head.", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/NoRotateSet;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "confirmValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "illegalRotationValue", "noZeroValue", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class NoRotateSet extends Module {
/* 13 */   private final BoolValue confirmValue = new BoolValue("Confirm", true);
/* 14 */   private final BoolValue illegalRotationValue = new BoolValue("ConfirmIllegalRotation", false);
/* 15 */   private final BoolValue noZeroValue = new BoolValue("NoZero", false);
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 19 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 21 */       if (MinecraftInstance.classProvider.isSPacketPlayerPosLook(event.getPacket())) {
/* 22 */         ISPacketPosLook packet = event.getPacket().asSPacketPosLook();
/*    */         
/* 24 */         if (((Boolean)this.noZeroValue.get()).booleanValue() && packet.getYaw() == 0.0F && packet.getPitch() == 0.0F) {
/*    */           return;
/*    */         }
/* 27 */         if (((Boolean)this.illegalRotationValue.get()).booleanValue() || (packet.getPitch() <= 90 && packet.getPitch() >= -90 && RotationUtils.serverRotation != null && packet.getYaw() != RotationUtils.serverRotation.getYaw() && packet.getPitch() != RotationUtils.serverRotation.getPitch()))
/*    */         {
/*    */ 
/*    */           
/* 31 */           if (((Boolean)this.confirmValue.get()).booleanValue()) {
/* 32 */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerLook(packet.getYaw(), packet.getPitch(), thePlayer.getOnGround()));
/*    */           }
/*    */         }
/* 35 */         packet.setYaw(thePlayer.getRotationYaw());
/* 36 */         packet.setPitch(thePlayer.getRotationPitch());
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\NoRotateSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */