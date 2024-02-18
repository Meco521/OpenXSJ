/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.vulcan;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\020\020\007\032\0020\0062\006\020\b\032\0020\tH\026J\b\020\n\032\0020\006H\026J\b\020\013\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "wasTimer", "", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class VulcanHop extends SpeedMode {
/*    */   public VulcanHop() {
/*  9 */     super("VulcanHop");
/*    */   } private boolean wasTimer;
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 14 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */   public void onUpdate() {
/* 17 */     if (this.wasTimer) {
/* 18 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 19 */       this.wasTimer = false;
/*    */     } 
/* 21 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (Math.abs(MinecraftInstance.mc.getThePlayer().getMovementInput().getMoveStrafe()) < 0.1F) {
/* 22 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setJumpMovementFactor(0.026499F);
/*    */     } else {
/* 24 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setJumpMovementFactor(0.0244F);
/*    */     } 
/* 26 */     MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindJump()));
/*    */     
/* 28 */     if (MovementUtils.INSTANCE.getSpeed() < 0.215F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround())
/* 29 */         MovementUtils.strafe(0.215F);  }
/*    */     
/* 31 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && MovementUtils.isMoving()) {
/* 32 */       MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false);
/* 33 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/* 34 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isAirBorne()) {
/*    */         return;
/*    */       }
/* 37 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.25F);
/* 38 */       this.wasTimer = true;
/* 39 */       MovementUtils.strafe$default(0.0F, 1, null);
/* 40 */       if (MovementUtils.INSTANCE.getSpeed() < 0.5F) {
/* 41 */         MovementUtils.strafe(0.4849F);
/*    */       }
/* 43 */     } else if (!MovementUtils.isMoving()) {
/* 44 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 45 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(0.0D);
/* 46 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(0.0D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\vulcan\VulcanHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */