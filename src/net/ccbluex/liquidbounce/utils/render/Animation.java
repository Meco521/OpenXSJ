/*    */ package net.ccbluex.liquidbounce.utils.render;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\t\n\002\b\t\n\002\030\002\n\002\b\f\030\0002\0020\001:\001\037B-\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\007\022\006\020\t\032\0020\n¢\006\002\020\013J\006\020\036\032\0020\000R\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\f\020\rR\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\016\020\017R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\020\020\021R\016\020\022\032\0020\nX\016¢\006\002\n\000R\032\020\023\032\0020\024X\016¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R\021\020\b\032\0020\007¢\006\b\n\000\032\004\b\031\020\017R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\032\020\033R\021\020\034\032\0020\0078F¢\006\006\032\004\b\035\020\017¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/Animation;", "", "type", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "order", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "from", "", "to", "duration", "", "(Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;DDJ)V", "getDuration", "()J", "getFrom", "()D", "getOrder", "()Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "startTime", "state", "Lnet/ccbluex/liquidbounce/utils/render/Animation$EnumAnimationState;", "getState", "()Lnet/ccbluex/liquidbounce/utils/render/Animation$EnumAnimationState;", "setState", "(Lnet/ccbluex/liquidbounce/utils/render/Animation$EnumAnimationState;)V", "getTo", "getType", "()Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "value", "getValue", "start", "EnumAnimationState", "XSJClient"}) public final class Animation { @NotNull private EnumAnimationState state; private long startTime; @NotNull
/*    */   private final EaseUtils.EnumEasingType type; @NotNull
/*  3 */   private final EaseUtils.EnumEasingOrder order; private final double from; private final double to; private final long duration; public Animation(@NotNull EaseUtils.EnumEasingType type, @NotNull EaseUtils.EnumEasingOrder order, double from, double to, long duration) { this.type = type; this.order = order; this.from = from; this.to = to; this.duration = duration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 10 */     this.state = EnumAnimationState.NOT_STARTED; } @NotNull public final EaseUtils.EnumEasingType getType() { return this.type; } @NotNull public final EaseUtils.EnumEasingOrder getOrder() { return this.order; } @NotNull public final EnumAnimationState getState() { return this.state; } public final double getFrom() { return this.from; } public final double getTo() { return this.to; } public final long getDuration() { return this.duration; } public final void setState(@NotNull EnumAnimationState <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.state = <set-?>; }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final Animation start() {
/* 15 */     if (this.state != EnumAnimationState.NOT_STARTED) {
/* 16 */       throw (Throwable)new IllegalStateException("Animation already started!");
/*    */     }
/*    */     
/* 19 */     this.startTime = System.currentTimeMillis();
/* 20 */     this.state = EnumAnimationState.DURING;
/*    */     
/* 22 */     return this;
/*    */   }
/*    */   public final double getValue() {
/*    */     double percent;
/* 26 */     switch (Animation$WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()]) { case 1:
/*    */       
/*    */       case 2:
/* 29 */         percent = (System.currentTimeMillis() - this.startTime) / this.duration;
/*    */         
/* 31 */         this.state = EnumAnimationState.STOPPED;
/* 32 */         return (percent > true) ? this.to : (
/*    */           
/* 34 */           this.from + (this.to - this.from) * EaseUtils.INSTANCE.apply(this.type, this.order, percent));
/*    */       case 3:
/*    */        }
/* 37 */      throw new NoWhenBranchMatchedException();
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/Animation$EnumAnimationState;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "DURING", "STOPPED", "XSJClient"})
/*    */   public enum EnumAnimationState {
/*    */     NOT_STARTED, DURING, STOPPED;
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\Animation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */