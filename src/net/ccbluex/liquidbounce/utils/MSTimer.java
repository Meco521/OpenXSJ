/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\002\b\007\n\002\020\013\n\000\n\002\020\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\016\020\t\032\0020\0042\006\020\n\032\0020\004J\016\020\013\032\0020\f2\006\020\n\032\0020\004J\006\020\r\032\0020\016J\006\020\017\032\0020\004R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/MSTimer;", "", "()V", "time", "", "getTime", "()J", "setTime", "(J)V", "hasTimeLeft", "MS", "hasTimePassed", "", "reset", "", "timePassed", "XSJClient"})
/*    */ public final class MSTimer
/*    */ {
/*  9 */   private long time = -1L; public final long getTime() { return this.time; } public final void setTime(long <set-?>) { this.time = <set-?>; }
/*    */   
/*    */   public final boolean hasTimePassed(long MS) {
/* 12 */     return (System.currentTimeMillis() >= this.time + MS);
/*    */   }
/*    */   
/*    */   public final long hasTimeLeft(long MS) {
/* 16 */     return MS + this.time - System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public final long timePassed() {
/* 20 */     return System.currentTimeMillis() - this.time;
/*    */   }
/*    */   
/*    */   public final void reset() {
/* 24 */     this.time = System.currentTimeMillis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\MSTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */