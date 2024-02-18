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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\005\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\004¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/event/JumpEvent2;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "yaw", "", "(F)V", "getYaw", "()F", "setYaw", "XSJClient"})
/*    */ public final class JumpEvent2
/*    */   extends CancellableEvent
/*    */ {
/*    */   private float yaw;
/*    */   
/*    */   public final float getYaw() {
/* 59 */     return this.yaw; } public final void setYaw(float <set-?>) { this.yaw = <set-?>; } public JumpEvent2(float yaw) { this.yaw = yaw; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\JumpEvent2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */