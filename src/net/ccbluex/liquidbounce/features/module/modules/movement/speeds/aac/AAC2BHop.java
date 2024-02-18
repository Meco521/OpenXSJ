/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\026J\b\020\b\032\0020\004H\026¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC2BHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AAC2BHop extends SpeedMode {
/*    */   public AAC2BHop() {
/*  7 */     super("AAC2BHop");
/*    */   }
/*    */   public void onMotion() {
/* 10 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */     
/* 12 */     if (thePlayer.isInWater()) {
/*    */       return;
/*    */     }
/* 15 */     if (MovementUtils.isMoving()) {
/* 16 */       if (thePlayer.getOnGround()) {
/* 17 */         thePlayer.jump();
/* 18 */         thePlayer.setMotionX(thePlayer.getMotionX() * 1.02D);
/* 19 */         thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.02D);
/* 20 */       } else if (thePlayer.getMotionY() > -0.2D) {
/* 21 */         thePlayer.setJumpMovementFactor(0.08F);
/* 22 */         thePlayer.setMotionY(thePlayer.getMotionY() + 0.01431D);
/* 23 */         thePlayer.setJumpMovementFactor(0.07F);
/*    */       } 
/*    */     } else {
/* 26 */       thePlayer.setMotionX(0.0D);
/* 27 */       thePlayer.setMotionZ(0.0D);
/*    */     } 
/*    */   }
/*    */   public void onUpdate() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 32 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC2BHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */