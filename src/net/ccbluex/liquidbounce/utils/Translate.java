/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
/*    */ import tomk.utils.animation.AnimationUtil;
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
/*    */   public void translate(float targetX, float targetY) {
/* 16 */     this.x = AnimationUtils.lstransition(this.x, targetX, 0.0D);
/* 17 */     this.y = AnimationUtils.lstransition(this.y, targetY, 0.0D);
/*    */   }
/*    */   public void translate(float targetX, float targetY, double speed) {
/* 20 */     this.x = AnimationUtils.lstransition(this.x, targetX, speed);
/* 21 */     this.y = AnimationUtils.lstransition(this.y, targetY, speed);
/*    */   }
/*    */   
/*    */   public final void interpolate(float targetX, float targetY, double smoothing) {
/* 25 */     if (this.first) {
/* 26 */       this.x = AnimationUtil.animate(targetX, this.x, smoothing);
/* 27 */       this.y = AnimationUtil.animate(targetY, this.y, smoothing);
/*    */     } else {
/*    */       
/* 30 */       this.x = targetX;
/* 31 */       this.y = targetY;
/* 32 */       this.first = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getX() {
/* 39 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 43 */     this.x = x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 47 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 51 */     this.y = y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\Translate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */