/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\t\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\006\020\r\032\0020\005R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\f¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/event/MotionEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "eventState", "Lnet/ccbluex/liquidbounce/event/EventState;", "onGround", "", "(Lnet/ccbluex/liquidbounce/event/EventState;Z)V", "getEventState", "()Lnet/ccbluex/liquidbounce/event/EventState;", "getOnGround", "()Z", "setOnGround", "(Z)V", "isPre", "XSJClient"})
/*    */ public final class MotionEvent
/*    */   extends Event
/*    */ {
/*    */   @NotNull
/*    */   private final EventState eventState;
/*    */   private boolean onGround;
/*    */   
/*    */   public MotionEvent(@NotNull EventState eventState, boolean onGround) {
/* 73 */     this.eventState = eventState; this.onGround = onGround; } public final void setOnGround(boolean <set-?>) { this.onGround = <set-?>; } public final boolean getOnGround() { return this.onGround; } @NotNull public final EventState getEventState() { return this.eventState; }
/*    */    public final boolean isPre() {
/* 75 */     return (this.eventState == EventState.PRE);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\MotionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */