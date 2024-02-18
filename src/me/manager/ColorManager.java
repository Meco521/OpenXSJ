/*    */ package me.manager;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class ColorManager {
/*    */   public static int getRainbow(int speed, int offset) {
/*  7 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/*  8 */     return Color.getHSBColor(hue /= speed, 0.8F, 1.0F).getRGB();
/*    */   }
/*    */   
/*    */   public static int rainbow(int delay) {
/* 12 */     double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0D);
/* 13 */     rainbowState %= 360.0D;
/* 14 */     return Color.getHSBColor((float)(rainbowState / 360.0D), 0.8F, 0.7F).brighter().getRGB();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Color getChromaRainbow(double x, double y) {
/* 19 */     float v = 2000.0F;
/* 20 */     return new Color(Color.HSBtoRGB((float)((System.currentTimeMillis() - x * 10.0D * 1.0D - y * 10.0D * 1.0D) % v) / v, 0.8F, 0.8F));
/*    */   }
/*    */   
/*    */   public static int getRainbow2(int speed, int offset) {
/* 24 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 25 */     return Color.getHSBColor(hue /= speed, 0.8F, 0.8F).getRGB();
/*    */   }
/*    */   
/*    */   public static int fluxRainbow(int delay, long timeOffset, float sa) {
/* 29 */     double rainbowState = Math.ceil(((System.currentTimeMillis() + timeOffset) / 8L) + delay / 20.0D);
/* 30 */     rainbowState %= 360.0D;
/* 31 */     return Color.getHSBColor((float)(rainbowState / 360.0D), sa, 1.0F).getRGB();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int as() {
/* 36 */     int[] counter = { 0 }, arrn = counter;
/* 37 */     arrn[0] = arrn[0] + 1;
/* 38 */     return getRainbow3(counter[0] * 20);
/*    */   }
/*    */   
/*    */   public static int getRainbow3(int tick) {
/* 42 */     double d = 0.0D;
/* 43 */     double delay = Math.ceil(((System.currentTimeMillis() + (tick * 2)) / 5L));
/* 44 */     float rainbow = ((float)(d / 360.0D) < 0.5D) ? -((float)(delay / 360.0D)) : (float)((delay %= 360.0D) / 360.0D);
/* 45 */     return Color.getHSBColor(rainbow, 0.5F, 1.0F).getRGB();
/*    */   }
/*    */   
/*    */   public static int astolfoRainbow(int delay, int offset, int index) {
/* 49 */     double rainbowDelay = Math.ceil((System.currentTimeMillis() + (delay * index))) / offset;
/* 50 */     return Color.getHSBColor(((float)((rainbowDelay %= 360.0D) / 360.0D) < 0.5D) ? -((float)(rainbowDelay / 360.0D)) : (float)(rainbowDelay / 360.0D), 0.5F, 1.0F).getRGB();
/*    */   }
/*    */   
/*    */   public static Color rainbow(long time, float count, float fade) {
/* 54 */     float hue = ((float)time + (1.0F + count) * 2.0E8F) / 1.0E10F % 1.0F;
/* 55 */     long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 1.0F, 1.0F)), 16);
/* 56 */     Color c = new Color((int)color);
/* 57 */     return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\me\manager\ColorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */