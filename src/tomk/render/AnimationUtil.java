/*    */ package tomk.render;
/*    */ 
/*    */ public class AnimationUtil
/*    */ {
/*    */   public static float moveTowards(float current, float end, float smoothSpeed, float minSpeed) {
/*  6 */     float movement = (end - current) * smoothSpeed;
/*    */     
/*  8 */     if (movement > 0.0F) {
/*  9 */       movement = Math.max(minSpeed, movement);
/* 10 */       movement = Math.min(end - current, movement);
/* 11 */     } else if (movement < 0.0F) {
/* 12 */       movement = Math.min(-minSpeed, movement);
/* 13 */       movement = Math.max(end - current, movement);
/*    */     } 
/*    */     
/* 16 */     return current + movement;
/*    */   }
/*    */   
/*    */   public static float calculateCompensation(float target, float current, long delta, int speed) {
/* 20 */     float diff = current - target;
/*    */     
/* 22 */     if (delta < 1L) {
/* 23 */       delta = 1L;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 28 */     if (diff > speed) {
/* 29 */       double xD = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
/* 30 */       current = (float)(current - xD);
/* 31 */       if (current < target) {
/* 32 */         current = target;
/*    */       }
/* 34 */     } else if (diff < -speed) {
/* 35 */       double xD = ((speed * delta / 16L) < 0.25D) ? 0.5D : (speed * delta / 16L);
/* 36 */       current = (float)(current + xD);
/* 37 */       if (current > target) {
/* 38 */         current = target;
/*    */       }
/*    */     } else {
/* 41 */       current = target;
/*    */     } 
/*    */     
/* 44 */     return current;
/*    */   }
/*    */   
/*    */   public static float animate(float target, float current, double speed) {
/* 48 */     boolean larger = (target > current);
/*    */     
/* 50 */     if (speed < 0.0D) {
/* 51 */       speed = 0.0D;
/* 52 */     } else if (speed > 1.0D) {
/* 53 */       speed = 1.0D;
/*    */     } 
/*    */     
/* 56 */     float dif = Math.max(target, current) - Math.min(target, current);
/* 57 */     float factor = (float)(dif * speed);
/*    */     
/* 59 */     current = larger ? (current + factor) : (current - factor);
/* 60 */     return current;
/*    */   }
/*    */   
/*    */   public static double animate(double target, double current, double speed) {
/* 64 */     boolean larger = (target > current);
/*    */     
/* 66 */     if (speed < 0.0D) {
/* 67 */       speed = 0.0D;
/* 68 */     } else if (speed > 1.0D) {
/* 69 */       speed = 1.0D;
/*    */     } 
/*    */     
/* 72 */     double dif = Math.max(target, current) - Math.min(target, current);
/* 73 */     double factor = dif * speed;
/*    */     
/* 75 */     if (factor < 0.10000000149011612D) {
/* 76 */       factor = 0.10000000149011612D;
/*    */     }
/*    */     
/* 79 */     current = larger ? (current + factor) : (current - factor);
/* 80 */     return current;
/*    */   }
/*    */   
/*    */   public static float mvoeUD(float current, float end, float minSpeed) {
/* 84 */     return moveUD(current, end, 0.125F, minSpeed);
/*    */   }
/*    */   
/*    */   public static float moveUD(float current, float end, float smoothSpeed, float minSpeed) {
/* 88 */     float movement = (end - current) * smoothSpeed;
/*    */     
/* 90 */     if (movement > 10.0F) {
/* 91 */       movement = Math.max(minSpeed, movement);
/* 92 */       movement = Math.min(end - current, movement);
/* 93 */     } else if (movement < 10.0F) {
/* 94 */       movement = Math.min(-minSpeed, movement);
/* 95 */       movement = Math.max(end - current, movement);
/*    */     } 
/*    */     
/* 98 */     return current + movement;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\render\AnimationUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */