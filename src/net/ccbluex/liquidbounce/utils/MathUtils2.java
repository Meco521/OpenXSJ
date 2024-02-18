/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.MathContext;
/*    */ import java.math.RoundingMode;
/*    */ import java.util.Random;
/*    */ 
/*    */ public final class MathUtils2 {
/*  9 */   private static final Random random = new Random();
/*    */   
/*    */   public static double round(double value, double inc) {
/* 12 */     if (inc == 0.0D) return value; 
/* 13 */     if (inc == 1.0D) return Math.round(value);
/*    */     
/* 15 */     double halfOfInc = inc / 2.0D;
/* 16 */     double floored = Math.floor(value / inc) * inc;
/*    */     
/* 18 */     if (value >= floored + halfOfInc)
/* 19 */       return (new BigDecimal(Math.ceil(value / inc) * inc))
/* 20 */         .doubleValue(); 
/* 21 */     return (new BigDecimal(floored))
/* 22 */       .doubleValue();
/*    */   }
/*    */   
/*    */   public static float calculateGaussianValue(float x, float sigma) {
/* 26 */     double PI = 3.141592653D;
/* 27 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/* 28 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*    */   }
/*    */   public static int clamp_int(int p_clamp_int_0_, int p_clamp_int_1_, int p_clamp_int_2_) {
/* 31 */     if (p_clamp_int_0_ < p_clamp_int_1_) {
/* 32 */       return p_clamp_int_1_;
/*    */     }
/* 34 */     return (p_clamp_int_0_ > p_clamp_int_2_) ? p_clamp_int_2_ : p_clamp_int_0_;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getRandomInRange(int min, int max) {
/* 39 */     return (int)(Math.random() * (max - min) + min);
/*    */   }
/*    */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/* 42 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*    */   }
/*    */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/* 45 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*    */   }
/*    */   public static double roundToHalf(double d) {
/* 48 */     return Math.round(d * 2.0D) / 2.0D;
/*    */   }
/*    */   public static double roundToPlace(double value, int places) {
/* 51 */     if (places < 0) {
/* 52 */       throw new IllegalArgumentException();
/*    */     }
/* 54 */     BigDecimal bd = new BigDecimal(value);
/* 55 */     bd = bd.setScale(places, RoundingMode.HALF_UP);
/* 56 */     return bd.doubleValue();
/*    */   }
/*    */   
/*    */   public static double roundToDecimalPlace(double value, double inc) {
/* 60 */     double halfOfInc = inc / 2.0D;
/* 61 */     double floored = StrictMath.floor(value / inc) * inc;
/* 62 */     if (value >= floored + halfOfInc) {
/* 63 */       return (new BigDecimal(StrictMath.ceil(value / inc) * inc, MathContext.DECIMAL64)).stripTrailingZeros().doubleValue();
/*    */     }
/* 65 */     return (new BigDecimal(floored, MathContext.DECIMAL64)).stripTrailingZeros().doubleValue();
/*    */   }
/*    */   public static double incValue(double val, double inc) {
/* 68 */     double one = 1.0D / inc;
/* 69 */     return Math.round(val * one) / one;
/*    */   }
/*    */   
/*    */   public static float clampValue(float value, float floor, float cap) {
/* 73 */     if (value < floor) {
/* 74 */       return floor;
/*    */     }
/* 76 */     return Math.min(value, cap);
/*    */   }
/*    */   public static double randomNumber(double max, double min) {
/* 79 */     return Math.random() * (max - min) + min;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\MathUtils2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */