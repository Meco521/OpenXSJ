/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AnimationUtils
/*     */ {
/*     */   public static double delta;
/*     */   
/*     */   public static float easeOut(float t, float d) {
/*  13 */     return (t = t / d - 1.0F) * t * t + 1.0F;
/*     */   }
/*     */   public static float lstransition(float now, float desired, double speed) {
/*  16 */     double dif = Math.abs(desired - now);
/*  17 */     float a = (float)Math.abs((desired - desired - Math.abs(desired - now)) / (100.0D - speed * 10.0D));
/*  18 */     float x = now;
/*     */     
/*  20 */     if (dif > 0.0D)
/*  21 */     { if (now < desired) {
/*  22 */         x += a * RenderUtils.deltaTime;
/*  23 */       } else if (now > desired) {
/*  24 */         x -= a * RenderUtils.deltaTime;
/*     */       }  }
/*  26 */     else { x = desired; }
/*     */     
/*  28 */     if (Math.abs(desired - x) < 0.01D && x != desired) {
/*  29 */       x = desired;
/*     */     }
/*  31 */     return x;
/*     */   }
/*     */   public static double animate(double target, double current, double speed) {
/*  34 */     if (current == target) return current;
/*     */     
/*  36 */     boolean larger = (target > current);
/*  37 */     if (speed < 0.0D) {
/*  38 */       speed = 0.0D;
/*  39 */     } else if (speed > 1.0D) {
/*  40 */       speed = 1.0D;
/*     */     } 
/*     */     
/*  43 */     double dif = Math.max(target, current) - Math.min(target, current);
/*  44 */     double factor = dif * speed;
/*  45 */     if (factor < 0.1D) {
/*  46 */       factor = 0.1D;
/*     */     }
/*     */     
/*  49 */     if (larger) {
/*  50 */       current += factor;
/*  51 */       if (current >= target) current = target; 
/*  52 */     } else if (target < current) {
/*  53 */       current -= factor;
/*  54 */       if (current <= target) current = target;
/*     */     
/*     */     } 
/*  57 */     return current;
/*     */   }
/*     */   
/*     */   public static float animate(float target, float current, float speed) {
/*  61 */     if (current == target) return current;
/*     */     
/*  63 */     boolean larger = (target > current);
/*  64 */     if (speed < 0.0F) {
/*  65 */       speed = 0.0F;
/*  66 */     } else if (speed > 1.0F) {
/*  67 */       speed = 1.0F;
/*     */     } 
/*     */     
/*  70 */     double dif = Math.max(target, current) - Math.min(target, current);
/*  71 */     double factor = dif * speed;
/*  72 */     if (factor < 0.1D) {
/*  73 */       factor = 0.1D;
/*     */     }
/*     */     
/*  76 */     if (larger) {
/*  77 */       current += (float)factor;
/*  78 */       if (current >= target) current = target; 
/*  79 */     } else if (target < current) {
/*  80 */       current -= (float)factor;
/*  81 */       if (current <= target) current = target;
/*     */     
/*     */     } 
/*  84 */     return current;
/*     */   }
/*     */   
/*     */   public static double changer(double current, double add, double min, double max) {
/*  88 */     current += add;
/*  89 */     if (current > max) {
/*  90 */       current = max;
/*     */     }
/*  92 */     if (current < min) {
/*  93 */       current = min;
/*     */     }
/*     */     
/*  96 */     return current;
/*     */   }
/*     */   
/*     */   public static float changer(float current, float add, float min, float max) {
/* 100 */     current += add;
/* 101 */     if (current > max) {
/* 102 */       current = max;
/*     */     }
/* 104 */     if (current < min) {
/* 105 */       current = min;
/*     */     }
/*     */     
/* 108 */     return current;
/*     */   }
/*     */   public static float getAnimationState(float animation, float finalState, float speed) {
/* 111 */     float add = (float)(delta * (speed / 1000.0F));
/* 112 */     if (animation < finalState) {
/* 113 */       if (animation + add < finalState) {
/* 114 */         animation += add;
/*     */       } else {
/* 116 */         animation = finalState;
/*     */       } 
/* 118 */     } else if (animation - add > finalState) {
/* 119 */       animation -= add;
/*     */     } else {
/* 121 */       animation = finalState;
/*     */     } 
/* 123 */     return animation;
/*     */   }
/*     */   
/*     */   public static float smoothAnimation(float ani, float finalState, float speed, float scale) {
/* 127 */     return getAnimationState(ani, finalState, Math.max(10.0F, Math.abs(ani - finalState) * speed) * scale);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\AnimationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */