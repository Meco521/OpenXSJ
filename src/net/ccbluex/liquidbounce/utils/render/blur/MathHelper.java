/*     */ package net.ccbluex.liquidbounce.utils.render.blur;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.MathUtils;
/*     */ import net.minecraft.util.math.Vec3i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MathHelper
/*     */ {
/*  13 */   public static final float SQRT_2 = sqrt_float(2.0F);
/*     */   private static final int SIN_BITS = 12;
/*     */   private static final int SIN_MASK = 4095;
/*     */   private static final int SIN_COUNT = 4096;
/*     */   private static final int SIN_COUNT_D4 = 1024;
/*  18 */   public static final float PI = MathUtils.roundToFloat(Math.PI);
/*  19 */   public static final float PI2 = MathUtils.roundToFloat(6.283185307179586D);
/*  20 */   public static final float PId2 = MathUtils.roundToFloat(1.5707963267948966D);
/*  21 */   private static final float radToIndex = MathUtils.roundToFloat(651.8986469044033D);
/*  22 */   public static final float deg2Rad = MathUtils.roundToFloat(0.017453292519943295D);
/*  23 */   private static final float[] SIN_TABLE_FAST = new float[4096];
/*     */ 
/*     */   
/*     */   public static boolean fastMath = false;
/*     */ 
/*     */   
/*  29 */   private static final float[] SIN_TABLE = new float[65536];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float sin(float p_76126_0_) {
/*  47 */     return fastMath ? SIN_TABLE_FAST[(int)(p_76126_0_ * radToIndex) & 0xFFF] : SIN_TABLE[(int)(p_76126_0_ * 10430.378F) & 0xFFFF];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float cos(float value) {
/*  54 */     return fastMath ? SIN_TABLE_FAST[(int)(value * radToIndex + 1024.0F) & 0xFFF] : SIN_TABLE[(int)(value * 10430.378F + 16384.0F) & 0xFFFF];
/*     */   }
/*     */   
/*     */   public static float sqrt_float(float value) {
/*  58 */     return (float)Math.sqrt(value);
/*     */   }
/*     */   
/*     */   public static float sqrt_double(double value) {
/*  62 */     return (float)Math.sqrt(value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int floor_float(float value) {
/*  69 */     int i = (int)value;
/*  70 */     return (value < i) ? (i - 1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int truncateDoubleToInt(double value) {
/*  77 */     return (int)(value + 1024.0D) - 1024;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int floor_double(double value) {
/*  84 */     int i = (int)value;
/*  85 */     return (value < i) ? (i - 1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long floor_double_long(double value) {
/*  92 */     long i = (long)value;
/*  93 */     return (value < i) ? (i - 1L) : i;
/*     */   }
/*     */   
/*     */   public static int func_154353_e(double value) {
/*  97 */     return (int)((value >= 0.0D) ? value : (-value + 1.0D));
/*     */   }
/*     */   
/*     */   public static float abs(float value) {
/* 101 */     return (value >= 0.0F) ? value : -value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int abs_int(int value) {
/* 108 */     return (value >= 0) ? value : -value;
/*     */   }
/*     */   
/*     */   public static int ceiling_float_int(float value) {
/* 112 */     int i = (int)value;
/* 113 */     return (value > i) ? (i + 1) : i;
/*     */   }
/*     */   
/*     */   public static int ceiling_double_int(double value) {
/* 117 */     int i = (int)value;
/* 118 */     return (value > i) ? (i + 1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int clamp_int(int num, int min, int max) {
/* 126 */     return (num < min) ? min : ((num > max) ? max : num);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float clamp_float(float num, float min, float max) {
/* 134 */     return (num < min) ? min : Math.min(num, max);
/*     */   }
/*     */   
/*     */   public static double clamp_double(double num, double min, double max) {
/* 138 */     return (num < min) ? min : ((num > max) ? max : num);
/*     */   }
/*     */   
/*     */   public static double denormalizeClamp(double p_151238_0_, double p_151238_2_, double p_151238_4_) {
/* 142 */     return (p_151238_4_ < 0.0D) ? p_151238_0_ : ((p_151238_4_ > 1.0D) ? p_151238_2_ : (p_151238_0_ + (p_151238_2_ - p_151238_0_) * p_151238_4_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double abs_max(double p_76132_0_, double p_76132_2_) {
/* 149 */     if (p_76132_0_ < 0.0D) {
/* 150 */       p_76132_0_ = -p_76132_0_;
/*     */     }
/*     */     
/* 153 */     if (p_76132_2_ < 0.0D) {
/* 154 */       p_76132_2_ = -p_76132_2_;
/*     */     }
/*     */     
/* 157 */     return (p_76132_0_ > p_76132_2_) ? p_76132_0_ : p_76132_2_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int bucketInt(int p_76137_0_, int p_76137_1_) {
/* 164 */     return (p_76137_0_ < 0) ? (-((-p_76137_0_ - 1) / p_76137_1_) - 1) : (p_76137_0_ / p_76137_1_);
/*     */   }
/*     */   
/*     */   public static int getRandomIntegerInRange(Random p_76136_0_, int p_76136_1_, int p_76136_2_) {
/* 168 */     return (p_76136_1_ >= p_76136_2_) ? p_76136_1_ : (p_76136_0_.nextInt(p_76136_2_ - p_76136_1_ + 1) + p_76136_1_);
/*     */   }
/*     */   
/*     */   public static float randomFloatClamp(Random p_151240_0_, float p_151240_1_, float p_151240_2_) {
/* 172 */     return (p_151240_1_ >= p_151240_2_) ? p_151240_1_ : (p_151240_0_.nextFloat() * (p_151240_2_ - p_151240_1_) + p_151240_1_);
/*     */   }
/*     */   
/*     */   public static double getRandomDoubleInRange(Random p_82716_0_, double p_82716_1_, double p_82716_3_) {
/* 176 */     return (p_82716_1_ >= p_82716_3_) ? p_82716_1_ : (p_82716_0_.nextDouble() * (p_82716_3_ - p_82716_1_) + p_82716_1_);
/*     */   }
/*     */   
/*     */   public static double average(long[] values) {
/* 180 */     long i = 0L;
/*     */     
/* 182 */     for (long j : values) {
/* 183 */       i += j;
/*     */     }
/*     */     
/* 186 */     return i / values.length;
/*     */   }
/*     */   
/*     */   public static boolean epsilonEquals(float p_180185_0_, float p_180185_1_) {
/* 190 */     return (abs(p_180185_1_ - p_180185_0_) < 1.0E-5F);
/*     */   }
/*     */   
/*     */   public static int normalizeAngle(int p_180184_0_, int p_180184_1_) {
/* 194 */     return (p_180184_0_ % p_180184_1_ + p_180184_1_) % p_180184_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float wrapAngleTo180_float(float value) {
/* 201 */     value %= 360.0F;
/*     */     
/* 203 */     if (value >= 180.0F) {
/* 204 */       value -= 360.0F;
/*     */     }
/*     */     
/* 207 */     if (value < -180.0F) {
/* 208 */       value += 360.0F;
/*     */     }
/*     */     
/* 211 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double wrapAngleTo180_double(double value) {
/* 218 */     value %= 360.0D;
/*     */     
/* 220 */     if (value >= 180.0D) {
/* 221 */       value -= 360.0D;
/*     */     }
/*     */     
/* 224 */     if (value < -180.0D) {
/* 225 */       value += 360.0D;
/*     */     }
/*     */     
/* 228 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int parseIntWithDefault(String p_82715_0_, int p_82715_1_) {
/*     */     try {
/* 236 */       return Integer.parseInt(p_82715_0_);
/* 237 */     } catch (Throwable var3) {
/* 238 */       return p_82715_1_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int parseIntWithDefaultAndMax(String p_82714_0_, int p_82714_1_, int p_82714_2_) {
/* 246 */     return Math.max(p_82714_2_, parseIntWithDefault(p_82714_0_, p_82714_1_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double parseDoubleWithDefault(String p_82712_0_, double p_82712_1_) {
/*     */     try {
/* 254 */       return Double.parseDouble(p_82712_0_);
/* 255 */     } catch (Throwable var4) {
/* 256 */       return p_82712_1_;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static double parseDoubleWithDefaultAndMax(String p_82713_0_, double p_82713_1_, double p_82713_3_) {
/* 261 */     return Math.max(p_82713_3_, parseDoubleWithDefault(p_82713_0_, p_82713_1_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int roundUpToPowerOfTwo(int value) {
/* 268 */     int i = value - 1;
/* 269 */     i |= i >> 1;
/* 270 */     i |= i >> 2;
/* 271 */     i |= i >> 4;
/* 272 */     i |= i >> 8;
/* 273 */     i |= i >> 16;
/* 274 */     return i + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isPowerOfTwo(int value) {
/* 281 */     return (value != 0 && (value & value - 1) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int calculateLogBaseTwoDeBruijn(int value) {
/* 290 */     value = isPowerOfTwo(value) ? value : roundUpToPowerOfTwo(value);
/* 291 */     return multiplyDeBruijnBitPosition[(int)(value * 125613361L >> 27L) & 0x1F];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int calculateLogBaseTwo(int value) {
/* 299 */     return calculateLogBaseTwoDeBruijn(value) - (isPowerOfTwo(value) ? 0 : 1);
/*     */   }
/*     */   
/*     */   public static int func_154354_b(int p_154354_0_, int p_154354_1_) {
/* 303 */     if (p_154354_1_ == 0)
/* 304 */       return 0; 
/* 305 */     if (p_154354_0_ == 0) {
/* 306 */       return p_154354_1_;
/*     */     }
/* 308 */     if (p_154354_0_ < 0) {
/* 309 */       p_154354_1_ *= -1;
/*     */     }
/*     */     
/* 312 */     int i = p_154354_0_ % p_154354_1_;
/* 313 */     return (i == 0) ? p_154354_0_ : (p_154354_0_ + p_154354_1_ - i);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int func_180183_b(float p_180183_0_, float p_180183_1_, float p_180183_2_) {
/* 318 */     return func_180181_b(floor_float(p_180183_0_ * 255.0F), floor_float(p_180183_1_ * 255.0F), floor_float(p_180183_2_ * 255.0F));
/*     */   }
/*     */   
/*     */   public static int func_180181_b(int p_180181_0_, int p_180181_1_, int p_180181_2_) {
/* 322 */     int i = (p_180181_0_ << 8) + p_180181_1_;
/* 323 */     i = (i << 8) + p_180181_2_;
/* 324 */     return i;
/*     */   }
/*     */   
/*     */   public static int func_180188_d(int p_180188_0_, int p_180188_1_) {
/* 328 */     int i = (p_180188_0_ & 0xFF0000) >> 16;
/* 329 */     int j = (p_180188_1_ & 0xFF0000) >> 16;
/* 330 */     int k = (p_180188_0_ & 0xFF00) >> 8;
/* 331 */     int l = (p_180188_1_ & 0xFF00) >> 8;
/* 332 */     int i1 = (p_180188_0_ & 0xFF) >> 0;
/* 333 */     int j1 = (p_180188_1_ & 0xFF) >> 0;
/* 334 */     int k1 = (int)(i * j / 255.0F);
/* 335 */     int l1 = (int)(k * l / 255.0F);
/* 336 */     int i2 = (int)(i1 * j1 / 255.0F);
/* 337 */     return p_180188_0_ & 0xFF000000 | k1 << 16 | l1 << 8 | i2;
/*     */   }
/*     */   
/*     */   public static double func_181162_h(double p_181162_0_) {
/* 341 */     return p_181162_0_ - Math.floor(p_181162_0_);
/*     */   }
/*     */   
/*     */   public static long getPositionRandom(Vec3i pos) {
/* 345 */     return getCoordinateRandom(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
/*     */   }
/*     */   
/*     */   public static long getCoordinateRandom(int x, int y, int z) {
/* 349 */     long i = (x * 3129871) ^ z * 116129781L ^ y;
/* 350 */     i = i * i * 42317861L + i * 11L;
/* 351 */     return i;
/*     */   }
/*     */   
/*     */   public static UUID getRandomUuid(Random rand) {
/* 355 */     long i = rand.nextLong() & 0xFFFFFFFFFFFF0FFFL | 0x4000L;
/* 356 */     long j = rand.nextLong() & 0x3FFFFFFFFFFFFFFFL | Long.MIN_VALUE;
/* 357 */     return new UUID(i, j);
/*     */   }
/*     */   
/*     */   public static double func_181160_c(double p_181160_0_, double p_181160_2_, double p_181160_4_) {
/* 361 */     return (p_181160_0_ - p_181160_2_) / (p_181160_4_ - p_181160_2_);
/*     */   }
/*     */   
/*     */   public static double func_181159_b(double p_181159_0_, double p_181159_2_) {
/* 365 */     double d0 = p_181159_2_ * p_181159_2_ + p_181159_0_ * p_181159_0_;
/*     */     
/* 367 */     if (Double.isNaN(d0)) {
/* 368 */       return Double.NaN;
/*     */     }
/* 370 */     boolean flag = (p_181159_0_ < 0.0D);
/*     */     
/* 372 */     if (flag) {
/* 373 */       p_181159_0_ = -p_181159_0_;
/*     */     }
/*     */     
/* 376 */     boolean flag1 = (p_181159_2_ < 0.0D);
/*     */     
/* 378 */     if (flag1) {
/* 379 */       p_181159_2_ = -p_181159_2_;
/*     */     }
/*     */     
/* 382 */     boolean flag2 = (p_181159_0_ > p_181159_2_);
/*     */     
/* 384 */     if (flag2) {
/* 385 */       double d1 = p_181159_2_;
/* 386 */       p_181159_2_ = p_181159_0_;
/* 387 */       p_181159_0_ = d1;
/*     */     } 
/*     */     
/* 390 */     double d9 = func_181161_i(d0);
/* 391 */     p_181159_2_ *= d9;
/* 392 */     p_181159_0_ *= d9;
/* 393 */     double d2 = field_181163_d + p_181159_0_;
/* 394 */     int i = (int)Double.doubleToRawLongBits(d2);
/* 395 */     double d3 = field_181164_e[i];
/* 396 */     double d4 = field_181165_f[i];
/* 397 */     double d5 = d2 - field_181163_d;
/* 398 */     double d6 = p_181159_0_ * d4 - p_181159_2_ * d5;
/* 399 */     double d7 = (6.0D + d6 * d6) * d6 * 0.16666666666666666D;
/* 400 */     double d8 = d3 + d7;
/*     */     
/* 402 */     if (flag2) {
/* 403 */       d8 = 1.5707963267948966D - d8;
/*     */     }
/*     */     
/* 406 */     if (flag1) {
/* 407 */       d8 = Math.PI - d8;
/*     */     }
/*     */     
/* 410 */     if (flag) {
/* 411 */       d8 = -d8;
/*     */     }
/*     */     
/* 414 */     return d8;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double func_181161_i(double p_181161_0_) {
/* 419 */     double d0 = 0.5D * p_181161_0_;
/* 420 */     long i = Double.doubleToRawLongBits(p_181161_0_);
/* 421 */     i = 6910469410427058090L - (i >> 1L);
/* 422 */     p_181161_0_ = Double.longBitsToDouble(i);
/* 423 */     p_181161_0_ *= 1.5D - d0 * p_181161_0_ * p_181161_0_;
/* 424 */     return p_181161_0_;
/*     */   }
/*     */   public static int func_181758_c(float p_181758_0_, float p_181758_1_, float p_181758_2_) {
/*     */     float f4, f5, f6;
/* 428 */     int j, k, l, i = (int)(p_181758_0_ * 6.0F) % 6;
/* 429 */     float f = p_181758_0_ * 6.0F - i;
/* 430 */     float f1 = p_181758_2_ * (1.0F - p_181758_1_);
/* 431 */     float f2 = p_181758_2_ * (1.0F - f * p_181758_1_);
/* 432 */     float f3 = p_181758_2_ * (1.0F - (1.0F - f) * p_181758_1_);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 437 */     switch (i) {
/*     */       case 0:
/* 439 */         f4 = p_181758_2_;
/* 440 */         f5 = f3;
/* 441 */         f6 = f1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 478 */         j = clamp_int((int)(f4 * 255.0F), 0, 255);
/* 479 */         k = clamp_int((int)(f5 * 255.0F), 0, 255);
/* 480 */         l = clamp_int((int)(f6 * 255.0F), 0, 255);
/* 481 */         return j << 16 | k << 8 | l;case 1: f4 = f2; f5 = p_181758_2_; f6 = f1; j = clamp_int((int)(f4 * 255.0F), 0, 255); k = clamp_int((int)(f5 * 255.0F), 0, 255); l = clamp_int((int)(f6 * 255.0F), 0, 255); return j << 16 | k << 8 | l;case 2: f4 = f1; f5 = p_181758_2_; f6 = f3; j = clamp_int((int)(f4 * 255.0F), 0, 255); k = clamp_int((int)(f5 * 255.0F), 0, 255); l = clamp_int((int)(f6 * 255.0F), 0, 255); return j << 16 | k << 8 | l;case 3: f4 = f1; f5 = f2; f6 = p_181758_2_; j = clamp_int((int)(f4 * 255.0F), 0, 255); k = clamp_int((int)(f5 * 255.0F), 0, 255); l = clamp_int((int)(f6 * 255.0F), 0, 255); return j << 16 | k << 8 | l;case 4: f4 = f3; f5 = f1; f6 = p_181758_2_; j = clamp_int((int)(f4 * 255.0F), 0, 255); k = clamp_int((int)(f5 * 255.0F), 0, 255); l = clamp_int((int)(f6 * 255.0F), 0, 255); return j << 16 | k << 8 | l;case 5: f4 = p_181758_2_; f5 = f1; f6 = f2; j = clamp_int((int)(f4 * 255.0F), 0, 255); k = clamp_int((int)(f5 * 255.0F), 0, 255); l = clamp_int((int)(f6 * 255.0F), 0, 255); return j << 16 | k << 8 | l;
/*     */     } 
/*     */     throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + p_181758_0_ + ", " + p_181758_1_ + ", " + p_181758_2_);
/*     */   } static {
/* 485 */     for (int i = 0; i < 65536; i++) {
/* 486 */       SIN_TABLE[i] = (float)Math.sin(i * Math.PI * 2.0D / 65536.0D);
/*     */     }
/*     */     
/* 489 */     for (int j = 0; j < SIN_TABLE_FAST.length; j++)
/* 490 */       SIN_TABLE_FAST[j] = MathUtils.roundToFloat(Math.sin(j * Math.PI * 2.0D / 4096.0D)); 
/*     */   }
/*     */   
/* 493 */   private static final int[] multiplyDeBruijnBitPosition = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
/* 494 */   private static final double field_181163_d = Double.longBitsToDouble(4805340802404319232L);
/* 495 */   private static final double[] field_181164_e = new double[257];
/* 496 */   private static final double[] field_181165_f = new double[257];
/*     */   static {
/* 498 */     for (int k = 0; k < 257; k++) {
/* 499 */       double d0 = k / 256.0D;
/* 500 */       double d1 = Math.asin(d0);
/* 501 */       field_181165_f[k] = Math.cos(d1);
/* 502 */       field_181164_e[k] = d1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\blur\MathHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */