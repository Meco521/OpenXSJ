/*    */ package tomk.render;
/*    */ 
/*    */ 
/*    */ public final class Translate
/*    */ {
/*    */   private float x;
/*    */   private float y;
/*    */   private boolean first = false;
/*    */   
/*    */   public Translate(float x, float y) {
/* 11 */     this.x = x;
/* 12 */     this.y = y;
/*    */   }
/*    */   
/*    */   public final void interpolate(float targetX, float targetY, double smoothing) {
/* 16 */     if (this.first) {
/* 17 */       this.x = AnimationUtil.animate(targetX, this.x, smoothing);
/* 18 */       this.y = AnimationUtil.animate(targetY, this.y, smoothing);
/*    */     } else {
/* 20 */       this.x = targetX;
/* 21 */       this.y = targetY;
/* 22 */       this.first = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void translate(float targetX, float targetY) {
/* 28 */     this.x = AnimationUtils.lstransition(this.x, targetX, 0.0D);
/* 29 */     this.y = AnimationUtils.lstransition(this.y, targetY, 0.0D);
/*    */   }
/*    */   
/*    */   public void translate(float targetX, float targetY, double speed) {
/* 33 */     this.x = AnimationUtils.lstransition(this.x, targetX, speed);
/* 34 */     this.y = AnimationUtils.lstransition(this.y, targetY, speed);
/*    */   }
/*    */   
/*    */   public final void interpolate2(float targetX, float targetY, double smoothing) {
/* 38 */     this.x = targetX;
/* 39 */     this.y = AnimationUtil.animate(targetY, this.y, smoothing);
/*    */   }
/*    */   
/*    */   public float getX() {
/* 43 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 47 */     this.x = x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 51 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 55 */     this.y = y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\render\Translate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */