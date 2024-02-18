/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\b\020\005\032\0020\004H\026J\b\020\006\032\0020\004H\026J\020\020\007\032\0020\0042\006\020\b\032\0020\tH\026J\b\020\n\032\0020\004H\026J\b\020\013\032\0020\004H\026¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC4SlowHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class AAC4SlowHop extends SpeedMode {
/*    */   public AAC4SlowHop() {
/*  7 */     super("AAC4SlowHop");
/*    */   } public void onDisable() {
/*  9 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 10 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F);
/*    */   }
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public void onUpdate() {
/* 15 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isInWater())
/*    */       return; 
/* 17 */     if (MovementUtils.isMoving()) {
/* 18 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 19 */         MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false);
/* 20 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/*    */       } 
/* 22 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() <= 0.1D) {
/* 23 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F);
/* 24 */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.4F);
/*    */         }  }
/* 26 */        if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 0.1D) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() < 1.3D) {
/* 27 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.0205F);
/* 28 */           MinecraftInstance.mc.getTimer().setTimerSpeed(0.65F);
/*    */         }  }
/* 30 */        if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() >= 1.3D) {
/* 31 */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 32 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F);
/*    */       } 
/*    */     } else {
/* 35 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(0.0D);
/* 36 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(0.0D);
/*    */     } 
/*    */   } public void onMove(@NotNull MoveEvent event) {
/* 39 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */   
/*    */   public void onEnable() {}
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC4SlowHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */