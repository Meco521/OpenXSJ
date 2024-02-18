/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Timer", description = "Changes the speed of the entire game.", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\t\032\0020\nH\026J\020\020\013\032\0020\n2\006\020\f\032\0020\rH\007J\020\020\016\032\0020\n2\006\020\f\032\0020\017H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\007\020\b¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Timer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onMoveValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "speedValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getSpeedValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*    */ public final class Timer extends Module {
/*    */   @NotNull
/* 16 */   private final FloatValue speedValue = new FloatValue("Speed", 2.0F, 0.1F, 10.0F); @NotNull public final FloatValue getSpeedValue() { return this.speedValue; }
/* 17 */    private final BoolValue onMoveValue = new BoolValue("OnMove", true);
/*    */   
/*    */   public void onDisable() {
/* 20 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*    */       return;
/*    */     }
/* 23 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 28 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MovementUtils.isMoving() || !((Boolean)this.onMoveValue.get()).booleanValue()) {
/* 29 */       MinecraftInstance.mc.getTimer().setTimerSpeed(((Number)this.speedValue.get()).floatValue());
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onWorld(@NotNull WorldEvent event) {
/* 38 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getWorldClient() != null) {
/*    */       return;
/*    */     }
/* 41 */     setState(false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Timer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */