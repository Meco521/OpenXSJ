/*    */ package tomk.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ 
/*    */ public class AnimationUtils {
/*    */   public static float animate(float target, float current, float speed) {
/*  7 */     if (current == target) return current;
/*    */     
/*  9 */     boolean larger = (target > current);
/* 10 */     if (speed < 0.0F) {
/* 11 */       speed = 0.0F;
/* 12 */     } else if (speed > 1.0F) {
/* 13 */       speed = 1.0F;
/*    */     } 
/*    */     
/* 16 */     double dif = Math.max(target, current) - Math.min(target, current);
/* 17 */     double factor = dif * speed;
/* 18 */     if (factor < 0.1D) {
/* 19 */       factor = 0.1D;
/*    */     }
/*    */     
/* 22 */     if (larger) {
/* 23 */       current += (float)factor;
/* 24 */       if (current >= target) current = target; 
/* 25 */     } else if (target < current) {
/* 26 */       current -= (float)factor;
/* 27 */       if (current <= target) current = target;
/*    */     
/*    */     } 
/* 30 */     return current;
/*    */   }
/*    */   public static float lstransition(float now, float desired, double speed) {
/* 33 */     double dif = Math.abs(desired - now);
/* 34 */     float a = (float)Math.abs((desired - desired - Math.abs(desired - now)) / (100.0D - speed * 10.0D));
/* 35 */     float x = now;
/*    */     
/* 37 */     if (dif > 0.0D) {
/* 38 */       if (now < desired) {
/* 39 */         x = now + a * RenderUtils.deltaTime;
/* 40 */       } else if (now > desired) {
/* 41 */         x = now - a * RenderUtils.deltaTime;
/*    */       } 
/*    */     } else {
/* 44 */       x = desired;
/*    */     } 
/*    */     
/* 47 */     if (Math.abs(desired - x) < 0.01D && x != desired) {
/* 48 */       x = desired;
/*    */     }
/*    */     
/* 51 */     return x;
/*    */   }
/*    */   
/*    */   public static float easeOut(float t, float d) {
/* 55 */     return (t = t / d - 1.0F) * t * t + 1.0F;
/*    */   }
/*    */   
/*    */   public static float easeOutElastic(float x) {
/* 59 */     double c4 = 2.0943951023931953D;
/*    */     
/* 61 */     return (x == 0.0F) ? 0.0F : (float)((x == 1.0F) ? 1.0D : (Math.pow(2.0D, (-10.0F * x)) * Math.sin(((x * 10.0F) - 0.75D) * c4) + 1.0D));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\render\AnimationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */