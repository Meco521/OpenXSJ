/*    */ package net.ccbluex.liquidbounce.ui.client.clickgui;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ 
/*    */ public class AnimationHelper {
/*    */   public float animationX;
/*    */   
/*    */   public int getAlpha() {
/* 10 */     return this.alpha;
/*    */   } public int alpha;
/*    */   public float getAnimationX() {
/* 13 */     return this.animationX;
/*    */   }
/*    */   public void resetAlpha() {
/* 16 */     this.alpha = 0;
/*    */   }
/*    */   public AnimationHelper() {
/* 19 */     this.alpha = 0;
/*    */   }
/*    */   public void updateAlpha(int speed) {
/* 22 */     if (this.alpha < 255)
/* 23 */       this.alpha += speed; 
/*    */   }
/*    */   public AnimationHelper(BoolValue value) {
/* 26 */     this.animationX = ((Boolean)value.get()).booleanValue() ? 5.0F : -5.0F;
/*    */   }
/*    */   public AnimationHelper(Module module) {
/* 29 */     this.animationX = module.getState() ? 5.0F : -5.0F;
/*    */   }
/*    */   
/*    */   public static double animate(double target, double current, double speed) {
/* 33 */     boolean larger = (target > current), bl = larger;
/* 34 */     if (speed < 0.0D) {
/* 35 */       speed = 0.0D;
/* 36 */     } else if (speed > 1.0D) {
/* 37 */       speed = 1.0D;
/*    */     } 
/* 39 */     double dif = Math.max(target, current) - Math.min(target, current);
/* 40 */     double factor = dif * speed;
/* 41 */     if (factor < 0.1D) {
/* 42 */       factor = 0.1D;
/*    */     }
/* 44 */     current = larger ? (current += factor) : (current -= factor);
/* 45 */     return current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\AnimationHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */