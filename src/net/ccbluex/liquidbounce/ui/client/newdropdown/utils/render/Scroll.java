/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.SmoothStepAnimation;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Scroll
/*    */ {
/* 16 */   private float maxScroll = Float.MAX_VALUE; private float minScroll = 0.0F; private float rawScroll;
/*    */   
/*    */   public void setMaxScroll(float maxScroll) {
/* 19 */     this.maxScroll = maxScroll;
/*    */   }
/*    */   private float scroll;
/*    */   public float getMaxScroll() {
/* 23 */     return this.maxScroll;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   private Animation scrollAnimation = (Animation)new SmoothStepAnimation(0, 0.0D, Direction.BACKWARDS);
/*    */   
/*    */   public void onScroll(int ms) {
/* 32 */     this.scroll = (float)(this.rawScroll - this.scrollAnimation.getOutput());
/* 33 */     this.rawScroll += Mouse.getDWheel() / 4.0F;
/* 34 */     this.rawScroll = Math.max(Math.min(this.minScroll, this.rawScroll), -this.maxScroll);
/* 35 */     this.scrollAnimation = (Animation)new SmoothStepAnimation(ms, (this.rawScroll - this.scroll), Direction.BACKWARDS);
/*    */   }
/*    */   
/*    */   public boolean isScrollAnimationDone() {
/* 39 */     return this.scrollAnimation.isDone();
/*    */   }
/*    */   
/*    */   public float getScroll() {
/* 43 */     this.scroll = (float)(this.rawScroll - this.scrollAnimation.getOutput());
/* 44 */     return this.scroll;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\render\Scroll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */