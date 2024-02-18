/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*    */ 
/*    */ public class EaseInOutQuad
/*    */   extends Animation
/*    */ {
/*    */   public EaseInOutQuad(int ms, double endPoint) {
/* 10 */     super(ms, endPoint);
/*    */   }
/*    */   
/*    */   public EaseInOutQuad(int ms, double endPoint, Direction direction) {
/* 14 */     super(ms, endPoint, direction);
/*    */   }
/*    */   
/*    */   protected double getEquation(double x1) {
/* 18 */     double x = x1 / this.duration;
/* 19 */     return (x < 0.5D) ? (2.0D * Math.pow(x, 2.0D)) : (1.0D - Math.pow(-2.0D * x + 2.0D, 2.0D) / 2.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\animations\impl\EaseInOutQuad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */