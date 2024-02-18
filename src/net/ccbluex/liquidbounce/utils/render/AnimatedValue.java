/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\006\n\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\016\020\035\032\0020\0302\006\020\036\032\0020\030R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\013\032\0020\fX\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020R\032\020\021\032\0020\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R&\020\027\032\0020\0302\006\020\027\032\0020\0308F@FX\016¢\006\016\n\000\032\004\b\031\020\032\"\004\b\033\020\034¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/AnimatedValue;", "", "()V", "animation", "Lnet/ccbluex/liquidbounce/utils/render/Animation;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "order", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "getOrder", "()Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "setOrder", "(Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;)V", "type", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "getType", "()Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "setType", "(Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;)V", "value", "", "getValue", "()D", "setValue", "(D)V", "sync", "valueIn", "XSJClient"})
/*    */ public final class AnimatedValue {
/*    */   private Animation animation;
/*    */   
/*    */   public final double getValue() {
/*  7 */     if (this.animation != null) {
/*  8 */       if (this.animation == null) Intrinsics.throwNpe();  this.value = this.animation.getValue();
/*  9 */       if (this.animation == null) Intrinsics.throwNpe();  if (this.animation.getState() == Animation.EnumAnimationState.STOPPED) {
/* 10 */         this.animation = (Animation)null;
/*    */       }
/*    */     } 
/* 13 */     return this.value;
/*    */   } private double value;
/*    */   public final void setValue(double value) {
/* 16 */     if (this.animation != null) { if (this.animation != null) { if (this.animation == null) Intrinsics.throwNpe();  if (this.animation.getTo() != value)
/* 17 */         { this.animation = (new Animation(this.type, this.order, this.value, value, this.duration)).start(); return; }  }  return; }  this.animation = (new Animation(this.type, this.order, this.value, value, this.duration)).start();
/*    */   }
/*    */   @NotNull
/* 20 */   private EaseUtils.EnumEasingType type = EaseUtils.EnumEasingType.NONE; @NotNull public final EaseUtils.EnumEasingType getType() { return this.type; } public final void setType(@NotNull EaseUtils.EnumEasingType <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.type = <set-?>; } @NotNull
/* 21 */   private EaseUtils.EnumEasingOrder order = EaseUtils.EnumEasingOrder.FAST_AT_START; @NotNull public final EaseUtils.EnumEasingOrder getOrder() { return this.order; } public final void setOrder(@NotNull EaseUtils.EnumEasingOrder <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.order = <set-?>; }
/* 22 */    private long duration = 300L; public final long getDuration() { return this.duration; } public final void setDuration(long <set-?>) { this.duration = <set-?>; }
/*    */   
/*    */   public final double sync(double valueIn) {
/* 25 */     setValue(valueIn);
/* 26 */     return getValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\AnimatedValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */