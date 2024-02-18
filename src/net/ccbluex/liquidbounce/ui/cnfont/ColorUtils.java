/*    */ package net.ccbluex.liquidbounce.ui.cnfont;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ public class ColorUtils
/*    */ {
/*  9 */   public static final int RED = getRGB(255, 0, 0);
/* 10 */   public static final int GREED = getRGB(0, 255, 0);
/* 11 */   public static final int BLUE = getRGB(0, 0, 255);
/* 12 */   public static final int WHITE = getRGB(255, 255, 255);
/* 13 */   public static final int BLACK = getRGB(0, 0, 0);
/* 14 */   public static final int NO_COLOR = getRGB(0, 0, 0, 0);
/*    */   
/*    */   public static int getRGB(int r, int g, int b) {
/* 17 */     return getRGB(r, g, b, 255);
/*    */   }
/*    */   
/*    */   public static int getRGB(int r, int g, int b, int a) {
/* 21 */     return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
/*    */   }
/* 23 */   public static int rainbowTick = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public static int astolfoRainbow(int delay, int offset, int index) {
/* 28 */     Color rainbow = new Color(Color.HSBtoRGB(
/* 29 */           (float)((Minecraft.func_71410_x()).field_71439_g.field_70173_aa / 50.0D + Math.sin(rainbowTick / 50.0D * 1.6D)) % 1.0F, 0.5F, 1.0F));
/*    */ 
/*    */     
/* 32 */     return rainbow.getRGB();
/*    */   }
/*    */   public static int[] splitRGB(int rgb) {
/* 35 */     return new int[] { rgb >> 16 & 0xFF, rgb >> 8 & 0xFF, rgb & 0xFF };
/*    */   }
/*    */   
/*    */   public static int getRGB(int rgb) {
/* 39 */     return 0xFF000000 | rgb;
/*    */   }
/*    */   public static int getColor(Color color) {
/* 42 */     return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*    */   }
/*    */   
/*    */   public static int getColor(Color leftColor, int brightness) {
/* 46 */     return getColor(brightness, brightness, brightness, 255);
/*    */   }
/*    */   
/*    */   public static int getColor(int brightness, int alpha) {
/* 50 */     return getColor(brightness, brightness, brightness, alpha);
/*    */   }
/*    */   
/*    */   public static int getColor(int red, int green, int blue) {
/* 54 */     return getColor(red, green, blue, 255);
/*    */   }
/*    */   
/*    */   public static int getColor(int red, int green, int blue, int alpha) {
/* 58 */     byte color = 0;
/* 59 */     int color1 = color | alpha << 24;
/* 60 */     color1 |= red << 16;
/* 61 */     color1 |= green << 8;
/* 62 */     color1 |= blue;
/* 63 */     return color1;
/*    */   }
/*    */   public static int reAlpha(int rgb, int alpha) {
/* 66 */     return getRGB(getRed(rgb), getGreen(rgb), getBlue(rgb), alpha);
/*    */   }
/*    */   
/*    */   public static int getRed(int rgb) {
/* 70 */     return rgb >> 16 & 0xFF;
/*    */   }
/*    */   
/*    */   public static int getGreen(int rgb) {
/* 74 */     return rgb >> 8 & 0xFF;
/*    */   }
/*    */   
/*    */   public static int getBlue(int rgb) {
/* 78 */     return rgb & 0xFF;
/*    */   }
/*    */   
/*    */   public static int getAlpha(int rgb) {
/* 82 */     return rgb >> 24 & 0xFF;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\cnfont\ColorUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */