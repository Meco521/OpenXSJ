/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.vulcan;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\0020\bH\026J\020\020\t\032\0020\b2\006\020\n\032\0020\013H\026J\b\020\f\032\0020\bH\026J\b\020\r\032\0020\bH\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanYPort;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "ticks", "", "wasTimer", "", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class VulcanYPort extends SpeedMode {
/*    */   private boolean wasTimer;
/*    */   
/*    */   public VulcanYPort() {
/*  9 */     super("VulcanYPort");
/*    */   }
/*    */   private int ticks;
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 15 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onUpdate() {
/*    */     int i;
/* 18 */     this.ticks = (i = this.ticks) + 1;
/* 19 */     if (this.wasTimer) {
/* 20 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 21 */       this.wasTimer = false;
/*    */     } 
/* 23 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setJumpMovementFactor(0.0245F);
/* 24 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround() && this.ticks > 3) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionY() > false) {
/* 25 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(-0.27D);
/*    */       }  }
/*    */     
/* 28 */     MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindJump()));
/* 29 */     if (MovementUtils.INSTANCE.getSpeed() < 0.215F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround())
/* 30 */         MovementUtils.strafe(0.215F);  }
/*    */     
/* 32 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && MovementUtils.isMoving()) {
/* 33 */       this.ticks = 0;
/* 34 */       MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false);
/* 35 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/* 36 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isAirBorne()) {
/*    */         return;
/*    */       }
/* 39 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.4F);
/* 40 */       this.wasTimer = true;
/* 41 */       if (MovementUtils.INSTANCE.getSpeed() < 0.48F) {
/* 42 */         MovementUtils.strafe(0.48F);
/*    */       } else {
/* 44 */         MovementUtils.strafe((float)(MovementUtils.INSTANCE.getSpeed() * 0.985D));
/*    */       } 
/* 46 */     } else if (!MovementUtils.isMoving()) {
/* 47 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 48 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(0.0D);
/* 49 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(0.0D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\vulcan\VulcanYPort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */