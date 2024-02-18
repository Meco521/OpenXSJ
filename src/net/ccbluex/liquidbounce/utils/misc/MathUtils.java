/*     */ package net.ccbluex.liquidbounce.utils.misc;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.MathContext;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Random;
/*     */ 
/*     */ public final class MathUtils {
/*   9 */   private static final Random random = new Random();
/*     */   
/*     */   public static double round(double value, double inc) {
/*  12 */     if (inc == 0.0D) return value; 
/*  13 */     if (inc == 1.0D) return Math.round(value);
/*     */     
/*  15 */     double halfOfInc = inc / 2.0D;
/*  16 */     double floored = Math.floor(value / inc) * inc;
/*     */     
/*  18 */     if (value >= floored + halfOfInc)
/*  19 */       return (new BigDecimal(Math.ceil(value / inc) * inc))
/*  20 */         .doubleValue(); 
/*  21 */     return (new BigDecimal(floored))
/*  22 */       .doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static char replaceString(char c, int n) {
/*  27 */     c = (char)(c ^ n);
/*  28 */     return c;
/*     */   }
/*     */   
/*     */   public static float calculateGaussianValue(float x, float sigma) {
/*  32 */     double PI = 3.141592653D;
/*  33 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/*  34 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*     */   }
/*     */   
/*     */   public static int clamp_int(int p_clamp_int_0_, int p_clamp_int_1_, int p_clamp_int_2_) {
/*  38 */     if (p_clamp_int_0_ < p_clamp_int_1_) {
/*  39 */       return p_clamp_int_1_;
/*     */     }
/*  41 */     return Math.min(p_clamp_int_0_, p_clamp_int_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getRandomInRange(int min, int max) {
/*  46 */     return (int)(Math.random() * (max - min) + min);
/*     */   }
/*     */   
/*     */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/*  50 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*     */   }
/*     */   
/*     */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/*  54 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*     */   }
/*     */   
/*     */   public static double roundToHalf(double d) {
/*  58 */     return Math.round(d * 2.0D) / 2.0D;
/*     */   }
/*     */   
/*     */   public static double roundToPlace(double value, int places) {
/*  62 */     if (places < 0) {
/*  63 */       throw new IllegalArgumentException();
/*     */     }
/*  65 */     BigDecimal bd = new BigDecimal(value);
/*  66 */     bd = bd.setScale(places, RoundingMode.HALF_UP);
/*  67 */     return bd.doubleValue();
/*     */   }
/*     */   
/*     */   public static double roundToDecimalPlace(double value, double inc) {
/*  71 */     double halfOfInc = inc / 2.0D;
/*  72 */     double floored = StrictMath.floor(value / inc) * inc;
/*  73 */     if (value >= floored + halfOfInc) {
/*  74 */       return (new BigDecimal(StrictMath.ceil(value / inc) * inc, MathContext.DECIMAL64)).stripTrailingZeros().doubleValue();
/*     */     }
/*  76 */     return (new BigDecimal(floored, MathContext.DECIMAL64)).stripTrailingZeros().doubleValue();
/*     */   }
/*     */   
/*     */   public static double incValue(double val, double inc) {
/*  80 */     double one = 1.0D / inc;
/*  81 */     return Math.round(val * one) / one;
/*     */   }
/*     */   
/*     */   public static float clampValue(float value, float floor, float cap) {
/*  85 */     if (value < floor) {
/*  86 */       return floor;
/*     */     }
/*  88 */     return Math.min(value, cap);
/*     */   }
/*     */   
/*     */   public static float wrapAngleTo180_float(float value) {
/*  92 */     value %= 360.0F;
/*     */     
/*  94 */     if (value >= 180.0F)
/*     */     {
/*  96 */       value -= 360.0F;
/*     */     }
/*     */     
/*  99 */     if (value < -180.0F)
/*     */     {
/* 101 */       value += 360.0F;
/*     */     }
/*     */     
/* 104 */     return value;
/*     */   }
/*     */   
/*     */   public static double randomNumber(double max, double min) {
/* 108 */     return Math.random() * (max - min) + min;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\MathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */