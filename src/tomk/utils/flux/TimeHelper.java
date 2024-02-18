/*    */ package tomk.utils.flux;
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
/* 12 */     if (System.currentTimeMillis() - this.lastMs > delay) {
/* 13 */       return true;
/*    */     }
/* 15 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isDelayComplete(double delay) {
/* 19 */     return ((System.currentTimeMillis() - this.lastMs) > delay);
/*    */   }
/*    */   
/*    */   public long getCurrentMS() {
/* 23 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 27 */     this.lastMs = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public long getLastMs() {
/* 31 */     return this.lastMs;
/*    */   }
/*    */   public long getElapsedTime() {
/* 34 */     return System.currentTimeMillis() - this.lastMs;
/*    */   }
/*    */   public void setLastMs(int i) {
/* 37 */     this.lastMs = System.currentTimeMillis() + i;
/*    */   }
/*    */   
/*    */   public boolean hasReached(long milliseconds) {
/* 41 */     return (System.currentTimeMillis() - this.lastMs >= milliseconds);
/*    */   }
/*    */   public boolean hasReached(double milliseconds) {
/* 44 */     return ((System.currentTimeMillis() - this.lastMs) >= milliseconds);
/*    */   }
/*    */   public boolean delay(float milliSec) {
/* 47 */     return ((float)(getTime() - this.prevMS) >= milliSec);
/*    */   }
/*    */   public boolean delay(float nextDelay, boolean reset) {
/* 50 */     if ((float)(System.currentTimeMillis() - this.lastMs) >= nextDelay) {
/* 51 */       if (reset) {
/* 52 */         reset();
/*    */       }
/* 54 */       return true;
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */   public boolean delay(long nextDelay) {
/* 59 */     return (System.currentTimeMillis() - this.lastMs >= nextDelay);
/*    */   }
/*    */   public long getTime() {
/* 62 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public long getDifference() {
/* 66 */     return getTime() - this.prevMS;
/*    */   }
/*    */   
/*    */   public boolean check(float milliseconds) {
/* 70 */     return ((float)getTime() >= milliseconds);
/*    */   }
/*    */   
/*    */   public long getCurrentTime() {
/* 74 */     return System.currentTimeMillis();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\flux\TimeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */