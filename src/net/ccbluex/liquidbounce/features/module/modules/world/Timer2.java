/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "Timer2", category = ModuleCategory.WORLD, description = "Skid")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\f\032\0020\rH\026J\020\020\016\032\0020\r2\006\020\017\032\0020\020H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\026\020\b\032\004\030\0010\t8VX\004¢\006\006\032\004\b\n\020\013¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Timer2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "maxSpeedValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "minSpeedValue", "onMoveValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Timer2
/*    */   extends Module {
/* 22 */   private final FloatValue maxSpeedValue = new Timer2$maxSpeedValue$1("Max-Timer", 2.0F, 0.1F, 10.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\026\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Timer2$maxSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Timer2$maxSpeedValue$1 extends FloatValue { Timer2$maxSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */      public final void onChanged(int oldValue, int newValue) {
/* 24 */       float minTimer = ((Number)Timer2.this.minSpeedValue.get()).floatValue();
/* 25 */       if (minTimer > newValue)
/* 26 */         set(Float.valueOf(minTimer)); 
/*    */     } }
/*    */ 
/*    */   
/* 30 */   private final FloatValue minSpeedValue = new Timer2$minSpeedValue$1("Min-Timer", 2.0F, 0.1F, 10.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\026\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Timer2$minSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Timer2$minSpeedValue$1 extends FloatValue { Timer2$minSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */      public final void onChanged(int oldValue, int newValue) {
/* 32 */       float maxTimer = ((Number)Timer2.this.maxSpeedValue.get()).floatValue();
/* 33 */       if (maxTimer < newValue)
/* 34 */         set(Float.valueOf(maxTimer)); 
/*    */     } }
/*    */ 
/*    */   
/* 38 */   private final BoolValue onMoveValue = new BoolValue("OnMove", true);
/*    */   
/*    */   public void onDisable() {
/* 41 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*    */       return;
/*    */     }
/*    */     
/* 45 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 50 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MovementUtils.isMoving() || !((Boolean)this.onMoveValue.get()).booleanValue()) {
/* 51 */       MinecraftInstance.mc.getTimer().setTimerSpeed(RandomUtils.INSTANCE.nextFloat(((Number)this.minSpeedValue.get()).floatValue(), ((Number)this.maxSpeedValue.get()).floatValue()));
/*    */       
/*    */       return;
/*    */     } 
/* 55 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   @Nullable
/*    */   public String getTag() {
/* 59 */     return String.valueOf(String.valueOf(RandomUtils.INSTANCE.nextFloat(((Number)this.minSpeedValue.get()).floatValue(), ((Number)this.maxSpeedValue.get()).floatValue())));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Timer2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */