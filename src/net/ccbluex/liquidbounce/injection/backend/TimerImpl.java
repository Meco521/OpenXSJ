/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.util.Timer;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\007\n\002\b\n\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\020\032\0020\0212\b\020\022\032\004\030\0010\023H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR$\020\n\032\0020\0062\006\020\t\032\0020\0068V@VX\016¢\006\f\032\004\b\013\020\b\"\004\b\f\020\rR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\016\020\017¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/TimerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;", "wrapped", "Lnet/minecraft/util/Timer;", "(Lnet/minecraft/util/Timer;)V", "renderPartialTicks", "", "getRenderPartialTicks", "()F", "value", "timerSpeed", "getTimerSpeed", "setTimerSpeed", "(F)V", "getWrapped", "()Lnet/minecraft/util/Timer;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class TimerImpl implements ITimer {
/*    */   @NotNull
/*  8 */   public final Timer getWrapped() { return this.wrapped; } @NotNull private final Timer wrapped; public TimerImpl(@NotNull Timer wrapped) { this.wrapped = wrapped; }
/*    */    public float getTimerSpeed() {
/* 10 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.implementations.IMixinTimer");  return ((IMixinTimer)this.wrapped).getTimerSpeed();
/*    */   } public void setTimerSpeed(float value) {
/* 12 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.implementations.IMixinTimer");  ((IMixinTimer)this.wrapped).setTimerSpeed(value);
/*    */   }
/*    */   public float getRenderPartialTicks() {
/* 15 */     return this.wrapped.field_194147_b;
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 18 */     return (other instanceof TimerImpl && Intrinsics.areEqual(((TimerImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\TimerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */