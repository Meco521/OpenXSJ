/*    */ package tomk.utils.animation;
/*    */ 
/*    */ 
/*    */ public class SmoothAnimationTimer
/*    */ {
/*    */   public float target;
/*  7 */   public float speed = 0.3F;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public float value;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SmoothAnimationTimer(float target) {
/* 18 */     this.value = 0.0F; this.target = target; } public SmoothAnimationTimer(float target, float speed) { this.value = 0.0F;
/*    */     this.target = target;
/*    */     this.speed = speed; } public boolean update(boolean increment) {
/* 21 */     this.value = AnimationUtils.smoothAnimation(this.value, this.target, 60.0F, 0.3F);
/* 22 */     return (this.value == this.target);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\animation\SmoothAnimationTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */