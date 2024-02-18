/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\026J\b\020\b\032\0020\004H\026¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACPort;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACPort extends SpeedMode {
/*    */   public AACPort() {
/* 13 */     super("AACPort");
/*    */   }
/*    */   public void onMotion() {}
/* 16 */   public void onUpdate() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 18 */       if (!MovementUtils.isMoving()) {
/*    */         return;
/*    */       }
/* 21 */       float f = thePlayer.getRotationYaw() * 0.017453292F;
/* 22 */       double d = 0.2D;
/*    */       while (true) {
/* 24 */         if ((Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class) == null) Intrinsics.throwNpe();  if (d <= ((Number)((Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class)).getPortMax().get()).doubleValue()) {
/* 25 */           double d1 = thePlayer.getPosX(); boolean bool1 = false; float f1 = (float)Math.sin(f); double x = d1 - f1 * d;
/* 26 */           d1 = thePlayer.getPosZ(); boolean bool2 = false; f1 = (float)Math.cos(f); double z = d1 + f1 * d;
/*    */           
/* 28 */           if (thePlayer.getPosY() < (int)thePlayer.getPosY() + 0.5D && !MinecraftInstance.classProvider.isBlockAir(BlockUtils.getBlock(new WBlockPos(x, thePlayer.getPosY(), z))))
/*    */             break; 
/* 30 */           thePlayer.getSendQueue().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(x, thePlayer.getPosY(), z, true));
/* 31 */           d += 0.2D; continue;
/*    */         }  break;
/*    */       }  return; }
/*    */     
/* 35 */     MinecraftInstance.mc.getThePlayer(); } public void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACPort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */