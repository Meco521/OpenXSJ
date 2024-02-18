/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\t\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\n\020\007\"\004\b\013\020\t¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "strafe", "", "forward", "(FF)V", "getForward", "()F", "setForward", "(F)V", "getStrafe", "setStrafe", "XSJClient"})
/*    */ public final class SlowDownEvent
/*    */   extends Event
/*    */ {
/*    */   private float strafe;
/*    */   private float forward;
/*    */   
/*    */   public final float getStrafe() {
/* 86 */     return this.strafe; } public final void setStrafe(float <set-?>) { this.strafe = <set-?>; } public final float getForward() { return this.forward; } public final void setForward(float <set-?>) { this.forward = <set-?>; } public SlowDownEvent(float strafe, float forward) { this.strafe = strafe; this.forward = forward; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\SlowDownEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */