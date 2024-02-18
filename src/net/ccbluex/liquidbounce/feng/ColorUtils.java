/*    */ package net.ccbluex.liquidbounce.feng;
/*    */ 
/*    */ public class ColorUtils {
/*  4 */   public static final int RED = getRGB(255, 0, 0);
/*  5 */   public static final int GREED = getRGB(0, 255, 0);
/*  6 */   public static final int BLUE = getRGB(0, 0, 255);
/*  7 */   public static final int WHITE = getRGB(255, 255, 255);
/*  8 */   public static final int BLACK = getRGB(0, 0, 0);
/*  9 */   public static final int NO_COLOR = getRGB(0, 0, 0, 0);
/*    */   
/*    */   public static int getRGB(int r, int g, int b) {
/* 12 */     return getRGB(r, g, b, 255);
/*    */   }
/*    */   
/*    */   public static int getRGB(int r, int g, int b, int a) {
/* 16 */     return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
/*    */   }
/*    */   
/*    */   public static int[] splitRGB(int rgb) {
/* 20 */     return new int[] { rgb >> 16 & 0xFF, rgb >> 8 & 0xFF, rgb & 0xFF };
/*    */   }
/*    */   
/*    */   public static int getRGB(int rgb) {
/* 24 */     return 0xFF000000 | rgb;
/*    */   }
/*    */   
/*    */   public static int reAlpha(int rgb, int alpha) {
/* 28 */     return getRGB(getRed(rgb), getGreen(rgb), getBlue(rgb), alpha);
/*    */   }
/*    */   
/*    */   public static int getRed(int rgb) {
/* 32 */     return rgb >> 16 & 0xFF;
/*    */   }
/*    */   
/*    */   public static int getGreen(int rgb) {
/* 36 */     return rgb >> 8 & 0xFF;
/*    */   }
/*    */   
/*    */   public static int getBlue(int rgb) {
/* 40 */     return rgb & 0xFF;
/*    */   }
/*    */   
/*    */   public static int getAlpha(int rgb) {
/* 44 */     return rgb >> 24 & 0xFF;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\feng\ColorUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */