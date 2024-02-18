/*    */ package net.ccbluex.liquidbounce.utils.timer;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*    */ 
/*    */ public final class TimeUtils {
/*    */   private long lastMS;
/*  7 */   private final long currentMS = System.currentTimeMillis();
/*    */   
/*    */   public static long randomDelay(int minDelay, int maxDelay) {
/* 10 */     return RandomUtils.nextInt(minDelay, maxDelay);
/*    */   }
/* 12 */   private long time = -1L;
/*    */   public long getPassedTimeMs() {
/* 14 */     return getMs(System.nanoTime() - this.time);
/*    */   }
/*    */   public boolean passedMs(Float ms) {
/* 17 */     return ((float)getMs(System.nanoTime() - this.time) >= ms.floatValue());
/*    */   }
/*    */   public long getMs(long time) {
/* 20 */     return time / 1000000L;
/*    */   }
/*    */   
/*    */   public static long randomClickDelay(int minCPS, int maxCPS) {
/* 24 */     return (long)(Math.random() * (1000 / minCPS - 1000 / maxCPS + 1) + (1000 / maxCPS));
/*    */   }
/*    */   
/*    */   public static long getTime() {
/* 28 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   private long getCurrentMS() {
/* 32 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public boolean hasReached(double milliseconds) {
/* 36 */     return ((getCurrentMS() - this.lastMS) >= milliseconds);
/*    */   }
/*    */   
/*    */   public boolean hasreached(long milliseconds) {
/* 40 */     return ((getCurrentMS() - this.lastMS) >= milliseconds);
/*    */   }
/*    */   
/*    */   public long elapsed() {
/* 44 */     return System.currentTimeMillis() - this.currentMS;
/*    */   }
/*    */   
/*    */   public boolean hasElapsed(long milliseconds) {
/* 48 */     return (elapsed() > milliseconds);
/*    */   }
/*    */   
/*    */   public void reset() {
/* 52 */     this.lastMS = getCurrentMS();
/*    */   }
/*    */   
/*    */   public boolean delay(float milliSec) {
/* 56 */     return ((float)(getTime() - this.lastMS) >= milliSec);
/*    */   }
/*    */   
/*    */   public boolean sleep(long time) {
/* 60 */     if (getTime() >= time) {
/* 61 */       reset();
/* 62 */       return true;
/*    */     } 
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public boolean sleep(double time) {
/* 68 */     if (getTime() >= time) {
/* 69 */       reset();
/* 70 */       return true;
/*    */     } 
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\timer\TimeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */