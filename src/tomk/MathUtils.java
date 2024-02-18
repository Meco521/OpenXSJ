/*    */ package tomk;
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
/* 12 */   private static final float[] ASIN_TABLE = new float[65536];
/*    */   
/*    */   public static float getRandomInRange(float min, float max) {
/* 15 */     SecureRandom random = new SecureRandom();
/* 16 */     return random.nextFloat() * (max - min) + min;
/*    */   }
/*    */   
/*    */   public static double getRandomInRange(double min, double max) {
/* 20 */     SecureRandom random = new SecureRandom();
/* 21 */     return random.nextDouble() * (max - min) + min;
/*    */   }
/*    */   
/*    */   public static double lerp(double old, double newVal, double amount) {
/* 25 */     return (1.0D - amount) * old + amount * newVal;
/*    */   }
/*    */   
/*    */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/* 29 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*    */   }
/*    */   
/*    */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/* 33 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*    */   }
/*    */   
/*    */   public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
/* 37 */     return interpolate(oldValue, newValue, (float)interpolationValue).intValue();
/*    */   }
/*    */   
/*    */   public static float calculateGaussianValue(float x, float sigma) {
/* 41 */     double PI = 3.141592653D;
/* 42 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/* 43 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*    */   }
/*    */   
/*    */   public static double roundToHalf(double d) {
/* 47 */     return Math.round(d * 2.0D) / 2.0D;
/*    */   }
/*    */   
/*    */   public static double round(double num, double increment) {
/* 51 */     BigDecimal bd = new BigDecimal(num);
/* 52 */     bd = bd.setScale((int)increment, RoundingMode.HALF_UP);
/* 53 */     return bd.doubleValue();
/*    */   }
/*    */   
/*    */   public static double round(double value, int places) {
/* 57 */     if (places < 0) {
/* 58 */       throw new IllegalArgumentException();
/*    */     }
/* 60 */     BigDecimal bd = new BigDecimal(value);
/* 61 */     bd = bd.setScale(places, RoundingMode.HALF_UP);
/* 62 */     return bd.doubleValue();
/*    */   }
/*    */   
/*    */   public static float roundToFloat(double d) {
/* 66 */     return (float)(Math.round(d * 1.0E8D) / 1.0E8D);
/*    */   }
/*    */ 
/*    */   
/*    */   static {
/* 71 */     for (int i = 0; i < 65536; i++)
/*    */     {
/* 73 */       ASIN_TABLE[i] = (float)Math.asin(i / 32767.5D - 1.0D);
/*    */     }
/*    */     
/* 76 */     for (int j = -1; j < 2; j++)
/*    */     {
/* 78 */       ASIN_TABLE[(int)((j + 1.0D) * 32767.5D) & 0xFFFF] = (float)Math.asin(j); } 
/*    */   }
/*    */   
/*    */   public static float getRandomFloat(float max, float min) {
/* 82 */     SecureRandom random = new SecureRandom();
/* 83 */     return random.nextFloat() * (max - min) + min;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\MathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */