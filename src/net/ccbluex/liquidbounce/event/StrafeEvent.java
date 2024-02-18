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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\021\020\005\032\0020\003¢\006\b\n\000\032\004\b\t\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\n\020\b¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "strafe", "", "forward", "friction", "(FFF)V", "getForward", "()F", "getFriction", "getStrafe", "XSJClient"})
/*    */ public final class StrafeEvent
/*    */   extends CancellableEvent
/*    */ {
/*    */   private final float strafe;
/*    */   private final float forward;
/*    */   private final float friction;
/*    */   
/*    */   public final float getStrafe() {
/* 91 */     return this.strafe; } public final float getForward() { return this.forward; } public final float getFriction() { return this.friction; } public StrafeEvent(float strafe, float forward, float friction) { this.strafe = strafe; this.forward = forward; this.friction = friction; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\StrafeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */