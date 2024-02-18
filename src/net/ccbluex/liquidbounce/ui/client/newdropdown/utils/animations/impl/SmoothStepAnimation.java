/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*    */ 
/*    */ public class SmoothStepAnimation
/*    */   extends Animation {
/*    */   public SmoothStepAnimation(int ms, double endPoint) {
/*  9 */     super(ms, endPoint);
/*    */   }
/*    */   
/*    */   public SmoothStepAnimation(int ms, double endPoint, Direction direction) {
/* 13 */     super(ms, endPoint, direction);
/*    */   }
/*    */   
/*    */   protected double getEquation(double x) {
/* 17 */     double x1 = x / this.duration;
/* 18 */     return -2.0D * Math.pow(x1, 3.0D) + 3.0D * Math.pow(x1, 2.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\animations\impl\SmoothStepAnimation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */