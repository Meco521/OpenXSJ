/*    */ package tomk.utils;
/*    */ 
/*    */ import lynn.utils.animation.AnimationUtil;
/*    */ import lynn.utils.animation.AnimationUtils;
/*    */ 
/*    */ public final class Translate {
/*    */   private float x;
/*    */   private float y;
/*    */   private boolean first = false;
/*    */   
/*    */   public Translate(float x, float y) {
/* 12 */     this.x = x;
/* 13 */     this.y = y;
/*    */   }
/*    */   
/*    */   public final void interpolate(float targetX, float targetY, double smoothing) {
/* 17 */     if (this.first) {
/* 18 */       this.x = AnimationUtil.animate(targetX, this.x, smoothing);
/* 19 */       this.y = AnimationUtil.animate(targetY, this.y, smoothing);
/*    */     } else {
/* 21 */       this.x = targetX;
/* 22 */       this.y = targetY;
/* 23 */       this.first = true;
/*    */     } 
/*    */   }
/*    */   public void translate(float targetX, float targetY) {
/* 27 */     this.x = AnimationUtils.lstransition(this.x, targetX, 0.0D);
/* 28 */     this.y = AnimationUtils.lstransition(this.y, targetY, 0.0D);
/*    */   }
/*    */   public void translate(float targetX, float targetY, double speed) {
/* 31 */     this.x = AnimationUtils.lstransition(this.x, targetX, speed);
/* 32 */     this.y = AnimationUtils.lstransition(this.y, targetY, speed);
/*    */   }
/*    */   public final void interpolate2(float targetX, float targetY, double smoothing) {
/* 35 */     this.x = targetX;
/* 36 */     this.y = AnimationUtil.animate(targetY, this.y, smoothing);
/*    */   }
/*    */   
/*    */   public float getX() {
/* 40 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 44 */     this.x = x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 48 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 52 */     this.y = y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\Translate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */