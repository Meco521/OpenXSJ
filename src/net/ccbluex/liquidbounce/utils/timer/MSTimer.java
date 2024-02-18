/*    */ package net.ccbluex.liquidbounce.utils.timer;
/*    */ 
/*    */ public final class MSTimer
/*    */ {
/*  5 */   private long time = -1L;
/*    */   
/*    */   public boolean hasTimePassed(long MS) {
/*  8 */     return (System.currentTimeMillis() >= this.time + MS);
/*    */   }
/*    */   private long lastMS;
/*    */   private long getCurrentMS() {
/* 12 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   public boolean hasReached(double milliseconds) {
/* 15 */     return ((getCurrentMS() - this.lastMS) >= milliseconds);
/*    */   }
/*    */   
/*    */   public long hasTimeLeft(long MS) {
/* 19 */     return MS + this.time - System.currentTimeMillis();
/*    */   }
/*    */   public void resetTwo() {
/* 22 */     this.lastMS = getCurrentMS();
/*    */   }
/*    */   
/*    */   public void reset() {
/* 26 */     this.time = System.currentTimeMillis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\timer\MSTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */