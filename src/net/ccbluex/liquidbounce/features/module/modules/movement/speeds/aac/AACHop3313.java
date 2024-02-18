/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\b\020\005\032\0020\004H\026J\020\020\006\032\0020\0042\006\020\007\032\0020\bH\026J\b\020\t\032\0020\004H\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACHop3313;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onDisable", "", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACHop3313 extends SpeedMode {
/*    */   public AACHop3313() {
/* 12 */     super("AACHop3.3.13");
/*    */   }
/*    */   public void onMotion() {}
/* 15 */   public void onUpdate() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */ 
/*    */       
/* 18 */       if (!MovementUtils.isMoving() || thePlayer.isInWater() || thePlayer.isInLava() || thePlayer.isOnLadder() || thePlayer.isRiding() || thePlayer.getHurtTime() > 0)
/* 19 */         return;  if (thePlayer.getOnGround() && thePlayer.isCollidedVertically())
/*    */       
/* 21 */       { float yawRad = thePlayer.getRotationYaw() * 0.017453292F;
/* 22 */         double d = thePlayer.getMotionX(); IEntityPlayerSP iEntityPlayerSP = thePlayer; boolean bool = false; float f1 = (float)Math.sin(yawRad); iEntityPlayerSP.setMotionX(d - (f1 * 0.202F));
/* 23 */         d = thePlayer.getMotionZ(); iEntityPlayerSP = thePlayer; bool = false; f1 = (float)Math.cos(yawRad); iEntityPlayerSP.setMotionZ(d + (f1 * 0.202F));
/* 24 */         thePlayer.setMotionY(0.405D);
/* 25 */         Retreat.INSTANCE.getEventManager().callEvent((Event)new JumpEvent(0.405F));
/* 26 */         MovementUtils.strafe$default(0.0F, 1, null); }
/* 27 */       else if (thePlayer.getFallDistance() < 0.31F)
/* 28 */       { if (MinecraftInstance.classProvider.isBlockCarpet(BlockUtils.getBlock(thePlayer.getPosition()))) {
/*    */           return;
/*    */         }
/*    */         
/* 32 */         thePlayer.setJumpMovementFactor((thePlayer.getMoveStrafing() == 0.0F) ? 0.027F : 0.021F);
/* 33 */         thePlayer.setMotionX(thePlayer.getMotionX() * 1.001D);
/* 34 */         thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.001D);
/*    */ 
/*    */         
/* 37 */         if (!thePlayer.isCollidedHorizontally()) thePlayer.setMotionY(thePlayer.getMotionY() - 0.014999993F);  }
/* 38 */       else { thePlayer.setJumpMovementFactor(0.02F); }
/*    */        return; }
/*    */     
/* 41 */     MinecraftInstance.mc.getThePlayer(); } public void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); }
/*    */    public void onDisable() {
/* 43 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setJumpMovementFactor(0.02F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACHop3313.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */