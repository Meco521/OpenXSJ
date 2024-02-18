/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.ThreadLocalRandom;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MathUtil
/*     */ {
/*  12 */   public static Random random = new Random();
/*     */   
/*     */   public static float wrapAngleTo180_float(float value) {
/*  15 */     value %= 360.0F;
/*     */     
/*  17 */     if (value >= 180.0F)
/*     */     {
/*  19 */       value -= 360.0F;
/*     */     }
/*     */     
/*  22 */     if (value < -180.0F)
/*     */     {
/*  24 */       value += 360.0F;
/*     */     }
/*     */     
/*  27 */     return value;
/*     */   }
/*     */   public static double toDecimalLength(double in, int places) {
/*  30 */     return Double.parseDouble(String.format("%." + places + "f", new Object[] { Double.valueOf(in) }));
/*     */   }
/*     */   public static double roundToHalf(double d) {
/*  33 */     return Math.round(d * 2.0D) / 2.0D;
/*     */   }
/*     */   public static double incValue(double val, double inc) {
/*  36 */     double one = 1.0D / inc;
/*  37 */     return Math.round(val * one) / one;
/*     */   }
/*     */   public static double round(double in, int places) {
/*  40 */     places = (int)MathHelper.func_151237_a(places, 0.0D, 2.147483647E9D);
/*  41 */     return Double.parseDouble(String.format("%." + places + "f", new Object[] { Double.valueOf(in) }));
/*     */   }
/*     */   
/*     */   public static String removeColorCode(String text) {
/*  45 */     String finalText = text;
/*  46 */     if (text.contains("§")) {
/*  47 */       for (int i = 0; i < finalText.length(); i++) {
/*  48 */         if (Character.toString(finalText.charAt(i)).equals("§")) {
/*     */           try {
/*  50 */             String part1 = finalText.substring(0, i);
/*  51 */             String part2 = finalText.substring(Math.min(i + 2, finalText.length()));
/*  52 */             finalText = part1 + part2;
/*  53 */           } catch (Exception exception) {}
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  59 */     return finalText;
/*     */   }
/*     */   
/*     */   public static int reAlpha(int color, float alpha) {
/*  63 */     Color c = new Color(color);
/*  64 */     float r = 0.003921569F * c.getRed();
/*  65 */     float g = 0.003921569F * c.getGreen();
/*  66 */     float b = 0.003921569F * c.getBlue();
/*  67 */     return (new Color(r, g, b, alpha)).getRGB();
/*     */   }
/*     */   
/*     */   public static boolean parsable(String s, byte type) {
/*     */     try {
/*  72 */       switch (type) {
/*     */         case 0:
/*  74 */           Short.parseShort(s);
/*     */           break;
/*     */         
/*     */         case 1:
/*  78 */           Byte.parseByte(s);
/*     */           break;
/*     */         
/*     */         case 2:
/*  82 */           Integer.parseInt(s);
/*     */           break;
/*     */         
/*     */         case 3:
/*  86 */           Float.parseFloat(s);
/*     */           break;
/*     */         
/*     */         case 4:
/*  90 */           Double.parseDouble(s);
/*     */           break;
/*     */         
/*     */         case 5:
/*  94 */           Long.parseLong(s);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/* 100 */     } catch (NumberFormatException e) {
/* 101 */       e.printStackTrace();
/* 102 */       return false;
/*     */     } 
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public static double square(double in) {
/* 108 */     return in * in;
/*     */   }
/*     */   
/*     */   public static double randomDouble(double min, double max) {
/* 112 */     return ThreadLocalRandom.current().nextDouble(min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float randomFloat(float min, float max) {
/* 118 */     return min + random.nextFloat() * (max - min);
/*     */   }
/*     */   
/*     */   public static double getIncremental(double val, double inc) {
/* 122 */     double one = 1.0D / inc;
/* 123 */     return Math.round(val * one) / one;
/*     */   }
/*     */   
/*     */   public static double randomNumber(double max, double min) {
/* 127 */     return Math.random() * (max - min) + min;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getRandom(double d, double d2) {
/* 132 */     Random random = new Random();
/* 133 */     double d4 = d2 - d;
/* 134 */     double d5 = random.nextDouble() * d4;
/* 135 */     if (d5 > d2)
/* 136 */       d5 = d2; 
/*     */     double d3;
/* 138 */     if ((d3 = d5 + d) > d2) {
/* 139 */       d3 = d2;
/*     */     }
/* 141 */     return d3;
/*     */   }
/*     */   
/*     */   public static int getRandom(int n, int n2) {
/* 145 */     if (n2 < n) {
/* 146 */       return 0;
/*     */     }
/* 148 */     return n + random.nextInt(n2 - n + 1);
/*     */   }
/*     */   
/*     */   public static Random getRandom() {
/* 152 */     return random;
/*     */   }
/*     */   
/*     */   public static class NumberType
/*     */   {
/*     */     public static final byte SHORT = 0;
/*     */     public static final byte BYTE = 1;
/*     */     public static final byte INT = 2;
/*     */     public static final byte FLOAT = 3;
/*     */     public static final byte DOUBLE = 4;
/*     */     public static final byte LONG = 5;
/*     */     
/*     */     public static byte getByType(Class<?> cls) {
/* 165 */       if (cls == Short.class) {
/* 166 */         return 0;
/*     */       }
/* 168 */       if (cls == Byte.class) {
/* 169 */         return 1;
/*     */       }
/* 171 */       if (cls == Integer.class) {
/* 172 */         return 2;
/*     */       }
/* 174 */       if (cls == Float.class) {
/* 175 */         return 3;
/*     */       }
/* 177 */       if (cls == Double.class) {
/* 178 */         return 4;
/*     */       }
/* 180 */       if (cls == Long.class) {
/* 181 */         return 5;
/*     */       }
/* 183 */       return -1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\MathUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */