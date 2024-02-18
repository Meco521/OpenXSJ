/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\004\b\000\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\013\020\rR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\016\020\017¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/event/EventHook;", "", "eventClass", "Lnet/ccbluex/liquidbounce/event/Listenable;", "method", "Ljava/lang/reflect/Method;", "eventTarget", "Lnet/ccbluex/liquidbounce/event/EventTarget;", "(Lnet/ccbluex/liquidbounce/event/Listenable;Ljava/lang/reflect/Method;Lnet/ccbluex/liquidbounce/event/EventTarget;)V", "getEventClass", "()Lnet/ccbluex/liquidbounce/event/Listenable;", "isIgnoreCondition", "", "()Z", "getMethod", "()Ljava/lang/reflect/Method;", "XSJClient"})
/*    */ public final class EventHook {
/*    */   private final boolean isIgnoreCondition;
/*    */   @NotNull
/*    */   private final Listenable eventClass;
/*    */   @NotNull
/*    */   private final Method method;
/*    */   
/* 13 */   public EventHook(@NotNull Listenable eventClass, @NotNull Method method, @NotNull EventTarget eventTarget) { this.eventClass = eventClass; this.method = method;
/* 14 */     this.isIgnoreCondition = eventTarget.ignoreCondition(); } public final boolean isIgnoreCondition() { return this.isIgnoreCondition; }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final Method getMethod() {
/*    */     return this.method;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Listenable getEventClass() {
/*    */     return this.eventClass;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\EventHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */