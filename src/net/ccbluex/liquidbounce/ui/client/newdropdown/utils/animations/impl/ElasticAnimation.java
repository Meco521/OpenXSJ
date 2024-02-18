/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*    */ 
/*    */ public class ElasticAnimation
/*    */   extends Animation {
/*    */   float easeAmount;
/*    */   float smooth;
/*    */   boolean reallyElastic;
/*    */   
/*    */   public ElasticAnimation(int ms, double endPoint, float elasticity, float smooth, boolean FireElasticity) {
/* 13 */     super(ms, endPoint);
/* 14 */     this.easeAmount = elasticity;
/* 15 */     this.smooth = smooth;
/* 16 */     this.reallyElastic = FireElasticity;
/*    */   }
/*    */   
/*    */   public ElasticAnimation(int ms, double endPoint, float elasticity, float smooth, boolean FireElasticity, Direction direction) {
/* 20 */     super(ms, endPoint, direction);
/* 21 */     this.easeAmount = elasticity;
/* 22 */     this.smooth = smooth;
/* 23 */     this.reallyElastic = FireElasticity;
/*    */   }
/*    */ 
/*    */   
/*    */   protected double getEquation(double x) {
/* 28 */     double x1 = Math.pow(x / this.duration, this.smooth);
/* 29 */     double elasticity = (this.easeAmount * 0.1F);
/* 30 */     return Math.pow(2.0D, -10.0D * (this.reallyElastic ? Math.sqrt(x1) : x1)) * Math.sin((x1 - elasticity / 4.0D) * 6.283185307179586D / elasticity) + 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\animations\impl\ElasticAnimation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */