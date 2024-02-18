/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\b\020\005\032\0020\004H\026J\020\020\006\032\0020\0042\006\020\007\032\0020\bH\026J\b\020\t\032\0020\004H\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACGround2;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onDisable", "", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACGround2 extends SpeedMode {
/*    */   public AACGround2() {
/*  9 */     super("AACGround2");
/*    */   } public void onMotion() {}
/*    */   public void onUpdate() {
/* 12 */     if (!MovementUtils.isMoving()) {
/*    */       return;
/*    */     }
/* 15 */     if ((Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class) == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getTimer().setTimerSpeed(((Number)((Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class)).getAacGroundTimerValue().get()).floatValue());
/* 16 */     MovementUtils.strafe(0.02F);
/*    */   }
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 19 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onDisable() {
/* 21 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACGround2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */