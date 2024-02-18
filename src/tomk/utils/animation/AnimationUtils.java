/*    */ package tomk.utils.animation;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ 
/*    */ public class AnimationUtils {
/*    */   public static double delta;
/*  6 */   public static float rotateDirection = 0.0F;
/*    */   
/*    */   public static float lstransition(float now, float desired, double speed) {
/*  9 */     double dif = Math.abs(desired - now);
/* 10 */     float a = (float)Math.abs((desired - desired - Math.abs(desired - now)) / (100.0D - speed * 10.0D));
/* 11 */     float x = now;
/*    */     
/* 13 */     if (dif > 0.0D)
/* 14 */     { if (now < desired) {
/* 15 */         x += a * RenderUtils.deltaTime;
/* 16 */       } else if (now > desired) {
/* 17 */         x -= a * RenderUtils.deltaTime;
/*    */       }  }
/* 19 */     else { x = desired; }
/*    */     
/* 21 */     if (Math.abs(desired - x) < 0.01D && x != desired) {
/* 22 */       x = desired;
/*    */     }
/* 24 */     return x;
/*    */   }
/*    */   public static float getAnimationState(float animation, float finalState, float speed) {
/* 27 */     float add = (float)(delta * (speed / 1000.0F));
/* 28 */     if (animation < finalState) {
/* 29 */       if (animation + add < finalState) {
/* 30 */         animation += add;
/*    */       } else {
/* 32 */         animation = finalState;
/*    */       } 
/* 34 */     } else if (animation - add > finalState) {
/* 35 */       animation -= add;
/*    */     } else {
/* 37 */       animation = finalState;
/*    */     } 
/* 39 */     return animation;
/*    */   }
/*    */   
/*    */   public static float smoothAnimation(float ani, float finalState, float speed, float scale) {
/* 43 */     return getAnimationState(ani, finalState, Math.max(10.0F, Math.abs(ani - finalState) * speed) * scale);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\animation\AnimationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */