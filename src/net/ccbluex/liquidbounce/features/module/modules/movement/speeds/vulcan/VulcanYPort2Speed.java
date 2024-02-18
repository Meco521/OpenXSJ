/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.vulcan;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\0020\bH\026J\b\020\t\032\0020\bH\026J\b\020\n\032\0020\bH\026J\020\020\013\032\0020\b2\006\020\f\032\0020\rH\026J\b\020\016\032\0020\bH\026J\b\020\017\032\0020\bH\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanYPort2Speed;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "portSwitcher", "", "wasTimer", "", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class VulcanYPort2Speed extends SpeedMode {
/*    */   private boolean wasTimer;
/*    */   
/*    */   public VulcanYPort2Speed() {
/*  8 */     super("VulcanYPort2");
/*    */   }
/*    */   private int portSwitcher;
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 14 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onEnable() {
/* 16 */     this.wasTimer = true;
/* 17 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 18 */     this.portSwitcher = 0;
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 22 */     this.wasTimer = false;
/* 23 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 24 */     this.portSwitcher = 0;
/*    */   }
/*    */   
/*    */   public void onUpdate() {
/* 28 */     if (this.wasTimer) {
/* 29 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 30 */       this.wasTimer = false;
/*    */     } 
/* 32 */     if (this.portSwitcher > 1) {
/* 33 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(-0.2784D);
/* 34 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.5F);
/* 35 */       this.wasTimer = true;
/* 36 */       if (this.portSwitcher > 1) {
/* 37 */         this.portSwitcher = 0;
/*    */       }
/*    */     } 
/* 40 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && MovementUtils.isMoving()) {
/* 41 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/* 42 */       MovementUtils.strafe$default(0.0F, 1, null);
/* 43 */       if (this.portSwitcher >= 1) {
/* 44 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.2D);
/* 45 */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.5F);
/*    */       }  int i;
/* 47 */       this.portSwitcher = (i = this.portSwitcher) + 1;
/* 48 */     } else if (MovementUtils.INSTANCE.getSpeed() < 0.225D) {
/* 49 */       MovementUtils.strafe(0.225F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\vulcan\VulcanYPort2Speed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */