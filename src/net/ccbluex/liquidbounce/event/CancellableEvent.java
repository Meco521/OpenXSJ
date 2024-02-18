/*    */ package net.ccbluex.liquidbounce.event;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\002\n\000\b\026\030\0002\0020\001B\005¢\006\002\020\002J\006\020\007\032\0020\bR\036\020\005\032\0020\0042\006\020\003\032\0020\004@BX\016¢\006\b\n\000\032\004\b\005\020\006¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "Lnet/ccbluex/liquidbounce/event/Event;", "()V", "<set-?>", "", "isCancelled", "()Z", "cancelEvent", "", "XSJClient"})
/*    */ public class CancellableEvent
/*    */   extends Event
/*    */ {
/*    */   private boolean isCancelled;
/*    */   
/*    */   public final boolean isCancelled() {
/* 12 */     return this.isCancelled;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void cancelEvent() {
/* 19 */     this.isCancelled = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\event\CancellableEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */