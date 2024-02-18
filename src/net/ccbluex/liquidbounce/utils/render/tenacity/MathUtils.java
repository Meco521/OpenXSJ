/*    */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
/*    */ import java.security.SecureRandom;
/*    */ 
/*    */ public class MathUtils
/*    */ {
/*    */   public static int getRandomInRange(int min, int max) {
/* 10 */     return (int)(Math.random() * (max - min) + min);
/*    */   }
/*    */   
/*    */   public static float getRandomInRange(float min, float max) {
/* 14 */     SecureRandom random = new SecureRandom();
/* 15 */     return random.nextFloat() * (max - min) + min;
/*    */   }
/*    */   
/*    */   public static double getRandomInRange(double min, double max) {
/* 19 */     SecureRandom random = new SecureRandom();
/* 20 */     return random.nextDouble() * (max - min) + min;
/*    */   }
/*    */   
/*    */   public static double lerp(double old, double newVal, double amount) {
/* 24 */     return (1.0D - amount) * old + amount * newVal;
/*    */   }
/*    */   public static float roundToFloat(double d) {
/* 27 */     return (float)(Math.round(d * 1.0E8D) / 1.0E8D);
/*    */   }
/*    */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/* 30 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*    */   }
/*    */   
/*    */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/* 34 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*    */   }
/*    */   
/*    */   public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
/* 38 */     return interpolate(oldValue, newValue, (float)interpolationValue).intValue();
/*    */   }
/*    */   
/*    */   public static float calculateGaussianValue(float x, float sigma) {
/* 42 */     double PI = 3.141592653D;
/* 43 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/* 44 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*    */   }
/*    */   
/*    */   public static double roundToHalf(double d) {
/* 48 */     return Math.round(d * 2.0D) / 2.0D;
/*    */   }
/*    */   
/*    */   public static double round(double num, double increment) {
/* 52 */     BigDecimal bd = new BigDecimal(num);
/* 53 */     bd = bd.setScale((int)increment, RoundingMode.HALF_UP);
/* 54 */     return bd.doubleValue();
/*    */   }
/*    */   
/*    */   public static double round(double value, int places) {
/* 58 */     if (places < 0) {
/* 59 */       throw new IllegalArgumentException();
/*    */     }
/* 61 */     BigDecimal bd = new BigDecimal(value);
/* 62 */     bd = bd.setScale(places, RoundingMode.HALF_UP);
/* 63 */     return bd.doubleValue();
/*    */   }
/*    */   
/*    */   public static float getRandomFloat(float max, float min) {
/* 67 */     SecureRandom random = new SecureRandom();
/* 68 */     return random.nextFloat() * (max - min) + min;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\MathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */