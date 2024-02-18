/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*    */ 
/*    */ public class DecelerateAnimation
/*    */   extends Animation
/*    */ {
/*    */   public DecelerateAnimation(int ms, double endPoint) {
/* 10 */     super(ms, endPoint);
/*    */   }
/*    */   
/*    */   public DecelerateAnimation(int ms, double endPoint, Direction direction) {
/* 14 */     super(ms, endPoint, direction);
/*    */   }
/*    */   
/*    */   protected double getEquation(double x) {
/* 18 */     double x1 = x / this.duration;
/* 19 */     return 1.0D - (x1 - 1.0D) * (x1 - 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\animations\impl\DecelerateAnimation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */