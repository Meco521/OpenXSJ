/*    */ package me.utils.timer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimeHelper
/*    */ {
/*  8 */   public long lastMs = 0L;
/*    */   private long prevMS;
/*    */   
/*    */   public boolean isDelayComplete(long delay) {
/* 12 */     return (System.currentTimeMillis() - this.lastMs > delay);
/*    */   }
/*    */   
/*    */   public boolean isDelayComplete(double delay) {
/* 16 */     return ((System.currentTimeMillis() - this.lastMs) > delay);
/*    */   }
/*    */   
/*    */   public long getCurrentMS() {
/* 20 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 24 */     this.lastMs = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public long getLastMs() {
/* 28 */     return this.lastMs;
/*    */   }
/*    */   
/*    */   public void setLastMs(int i) {
/* 32 */     this.lastMs = System.currentTimeMillis() + i;
/*    */   }
/*    */   
/*    */   public boolean hasReached(long milliseconds) {
/* 36 */     return (System.currentTimeMillis() - this.lastMs >= milliseconds);
/*    */   }
/*    */   public boolean hasReached(double milliseconds) {
/* 39 */     return ((System.currentTimeMillis() - this.lastMs) >= milliseconds);
/*    */   }
/*    */   public boolean delay(float milliSec) {
/* 42 */     return ((float)(getTime() - this.prevMS) >= milliSec);
/*    */   }
/*    */   
/*    */   public long getTime() {
/* 46 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public long getDifference() {
/* 50 */     return getTime() - this.prevMS;
/*    */   }
/*    */   
/*    */   public boolean check(float milliseconds) {
/* 54 */     return ((float)getTime() >= milliseconds);
/*    */   }
/*    */   
/*    */   public long getCurrentTime() {
/* 58 */     return System.currentTimeMillis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\timer\TimeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */