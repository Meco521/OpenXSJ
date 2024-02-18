/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ public class TranslateUtil {
/*    */   private float x;
/*    */   private float y;
/*    */   private long lastMS;
/*    */   
/*    */   public TranslateUtil(float x, float y) {
/*  9 */     this.x = x;
/* 10 */     this.y = y;
/* 11 */     this.lastMS = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void interpolate(float targetX, float targetY, float smoothing) {
/* 15 */     long currentMS = System.currentTimeMillis();
/* 16 */     long delta = currentMS - this.lastMS;
/* 17 */     this.lastMS = currentMS;
/* 18 */     int deltaX = (int)(Math.abs(targetX - this.x) * smoothing);
/* 19 */     int deltaY = (int)(Math.abs(targetY - this.y) * smoothing);
/* 20 */     this.x = calculateCompensation(targetX, this.x, delta, deltaX);
/* 21 */     this.y = calculateCompensation(targetY, this.y, delta, deltaY);
/*    */   }
/*    */   
/*    */   public float getX() {
/* 25 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 29 */     this.x = x;
/*    */   }
/*    */   
/*    */   public void setXY(float x, float y) {
/* 33 */     this.x = x;
/* 34 */     this.y = y;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 38 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 42 */     this.y = y;
/*    */   }
/*    */   
/*    */   public float calculateCompensation(float target, float current, long delta, int speed) {
/* 46 */     float diff = current - target;
/* 47 */     if (delta < 1L) {
/* 48 */       delta = 1L;
/*    */     }
/*    */     
/* 51 */     if (diff > speed) {
/* 52 */       double dell = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
/* 53 */       current = (float)(current - dell);
/* 54 */       if (current < target) {
/* 55 */         current = target;
/*    */       }
/* 57 */     } else if (diff < -speed) {
/* 58 */       double dell = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
/* 59 */       current = (float)(current + dell);
/* 60 */       if (current > target) {
/* 61 */         current = target;
/*    */       }
/*    */     } else {
/* 64 */       current = target;
/*    */     } 
/* 66 */     return current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\TranslateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */