/*    */ package net.ccbluex.liquidbounce.utils.render.animation;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class AnimationHelper {
/*    */   public static int deltaTime;
/*  7 */   public static float speedTarget = 0.125F;
/*    */   
/*    */   public static float animation(float current, float targetAnimation, float speed) {
/* 10 */     return animation(current, targetAnimation, speedTarget, speed);
/*    */   }
/*    */   
/*    */   public static float animation(float animation, float target, float poxyi, float speedTarget) {
/* 14 */     float da = (target - animation) / Math.max(Minecraft.func_175610_ah(), 5.0F) * 15.0F;
/* 15 */     if (da > 0.0F) {
/* 16 */       da = Math.max(speedTarget, da);
/* 17 */       da = Math.min(target - animation, da);
/* 18 */     } else if (da < 0.0F) {
/* 19 */       da = Math.min(-speedTarget, da);
/* 20 */       da = Math.max(target - animation, da);
/*    */     } 
/* 22 */     return animation + da;
/*    */   }
/*    */ 
/*    */   
/*    */   public static double animate(double target, double current, double speed) {
/* 27 */     boolean larger = (target > current), bl = larger;
/* 28 */     if (speed < 0.0D) {
/* 29 */       speed = 0.0D;
/* 30 */     } else if (speed > 1.0D) {
/* 31 */       speed = 1.0D;
/*    */     } 
/* 33 */     double dif = Math.max(target, current) - Math.min(target, current);
/* 34 */     double factor = dif * speed;
/* 35 */     if (factor < 0.1D) {
/* 36 */       factor = 0.1D;
/*    */     }
/* 38 */     current = larger ? (current += factor) : (current -= factor);
/* 39 */     return current;
/*    */   }
/*    */   
/*    */   public static float calculateCompensation(float target, float current, long delta, double speed) {
/* 43 */     float diff = current - target;
/* 44 */     if (delta < 1L) {
/* 45 */       delta = 1L;
/*    */     }
/* 47 */     if (delta > 1000L) {
/* 48 */       delta = 16L;
/*    */     }
/* 50 */     double max = Math.max(speed * delta / 16.0D, 0.5D);
/* 51 */     if (diff > speed) {
/* 52 */       double xD = max;
/* 53 */       current = (float)(current - xD);
/* 54 */       if (current < target) {
/* 55 */         current = target;
/*    */       }
/* 57 */     } else if (diff < -speed) {
/* 58 */       double xD = max;
/* 59 */       current = (float)(current + xD);
/* 60 */       if (current > target) {
/* 61 */         current = target;
/*    */       }
/*    */     } else {
/* 64 */       current = target;
/*    */     } 
/* 66 */     return current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\animation\AnimationHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */