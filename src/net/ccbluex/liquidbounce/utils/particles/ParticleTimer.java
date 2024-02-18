/*    */ package net.ccbluex.liquidbounce.utils.particles;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParticleTimer
/*    */ {
/*    */   public long lastMS;
/*    */   private long time;
/*    */   private long prevTime;
/*    */   
/*    */   private long getCurrentMS() {
/* 13 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public boolean hasReached(double milliseconds) {
/* 17 */     if ((getCurrentMS() - this.lastMS) >= milliseconds) {
/* 18 */       return true;
/*    */     }
/* 20 */     return false;
/*    */   }
/*    */   public void setTime(long time) {
/* 23 */     this.lastMS = time;
/*    */   }
/*    */   public boolean hasTimeElapsed(long time) {
/* 26 */     return (System.currentTimeMillis() - this.lastMS > time);
/*    */   }
/*    */   public boolean hasPassed(double milli) {
/* 29 */     return ((System.currentTimeMillis() - this.prevTime) >= milli);
/*    */   }
/*    */   public boolean sleep(long time) {
/* 32 */     if (time() >= time) {
/* 33 */       reset();
/* 34 */       return true;
/*    */     } 
/* 36 */     return false;
/*    */   }
/*    */   public long time() {
/* 39 */     return System.nanoTime() / 1000000L - this.time;
/*    */   }
/*    */   public final long getElapsedTime() {
/* 42 */     return getCurrentMS() - this.lastMS;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 46 */     this.lastMS = getCurrentMS();
/*    */   }
/*    */   
/*    */   public boolean delay(float milliSec) {
/* 50 */     if ((float)(getTime() - this.lastMS) >= milliSec) {
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public long getTime() {
/* 57 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public boolean isDelayComplete(long delay) {
/* 61 */     if (System.currentTimeMillis() - this.lastMS > delay)
/* 62 */       return true; 
/* 63 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\particles\ParticleTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */