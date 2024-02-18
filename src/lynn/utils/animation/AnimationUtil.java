/*    */ package lynn.utils.animation;
/*    */ 
/*    */ public class AnimationUtil {
/*    */   public static float easeOut(float t, float d) {
/*  5 */     return (t = t / d - 1.0F) * t * t + 1.0F;
/*    */   }
/*    */   public static float moveTowards(float current, float end, float smoothSpeed, float minSpeed) {
/*  8 */     float movement = (end - current) * smoothSpeed;
/*    */     
/* 10 */     if (movement > 0.0F) {
/* 11 */       movement = Math.max(minSpeed, movement);
/* 12 */       movement = Math.min(end - current, movement);
/* 13 */     } else if (movement < 0.0F) {
/* 14 */       movement = Math.min(-minSpeed, movement);
/* 15 */       movement = Math.max(end - current, movement);
/*    */     } 
/* 17 */     return current + movement;
/*    */   }
/*    */   public static float calculateCompensation(float target, float current, long delta, int speed) {
/* 20 */     float diff = current - target;
/* 21 */     if (delta < 1L) {
/* 22 */       delta = 1L;
/*    */     }
/*    */ 
/*    */     
/* 26 */     if (diff > speed) {
/* 27 */       double xD = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
/* 28 */       current = (float)(current - xD);
/* 29 */       if (current < target) {
/* 30 */         current = target;
/*    */       }
/* 32 */     } else if (diff < -speed) {
/* 33 */       double xD = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
/* 34 */       current = (float)(current + xD);
/* 35 */       if (current > target) {
/* 36 */         current = target;
/*    */       }
/*    */     } else {
/* 39 */       current = target;
/*    */     } 
/*    */     
/* 42 */     return current;
/*    */   }
/*    */   
/*    */   public static float animate(float target, float current, double speed) {
/* 46 */     boolean larger = (target > current);
/* 47 */     if (speed < 0.0D) {
/* 48 */       speed = 0.0D;
/* 49 */     } else if (speed > 1.0D) {
/* 50 */       speed = 1.0D;
/*    */     } 
/* 52 */     float dif = Math.max(target, current) - Math.min(target, current);
/* 53 */     float factor = (float)(dif * speed);
/* 54 */     current = larger ? (current + factor) : (current - factor);
/* 55 */     return current;
/*    */   }
/*    */   
/*    */   public static double animate(double target, double current, double speed) {
/* 59 */     boolean larger = (target > current);
/* 60 */     if (speed < 0.0D) {
/* 61 */       speed = 0.0D;
/* 62 */     } else if (speed > 1.0D) {
/* 63 */       speed = 1.0D;
/*    */     } 
/* 65 */     double dif = Math.max(target, current) - Math.min(target, current);
/* 66 */     double factor = dif * speed;
/* 67 */     if (factor < 0.10000000149011612D) {
/* 68 */       factor = 0.10000000149011612D;
/*    */     }
/* 70 */     current = larger ? (current + factor) : (current - factor);
/* 71 */     return current;
/*    */   }
/*    */   
/*    */   public static float mvoeUD(float current, float end, float minSpeed) {
/* 75 */     return moveUD(current, end, 0.125F, minSpeed);
/*    */   }
/*    */   
/*    */   public static float moveUD(float current, float end, float smoothSpeed, float minSpeed) {
/* 79 */     float movement = (end - current) * smoothSpeed;
/* 80 */     if (movement > 10.0F) {
/* 81 */       movement = Math.max(minSpeed, movement);
/* 82 */       movement = Math.min(end - current, movement);
/* 83 */     } else if (movement < 10.0F) {
/* 84 */       movement = Math.min(-minSpeed, movement);
/* 85 */       movement = Math.max(end - current, movement);
/*    */     } 
/* 87 */     return current + movement;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\animation\AnimationUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */