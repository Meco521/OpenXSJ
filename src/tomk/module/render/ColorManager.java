/*    */ package tomk.module.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class ColorManager
/*    */ {
/*    */   public static int getRainbow(int speed, int offset) {
/*  9 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 10 */     return Color.getHSBColor(hue /= speed, 0.8F, 1.0F).getRGB();
/*    */   }
/*    */   
/*    */   public static int rainbow(int delay) {
/* 14 */     double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0D);
/* 15 */     rainbowState %= 360.0D;
/* 16 */     return Color.getHSBColor((float)(rainbowState / 360.0D), 0.8F, 0.7F).brighter().getRGB();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Color getChromaRainbow(double x, double y) {
/* 21 */     float v = 2000.0F;
/* 22 */     return new Color(Color.HSBtoRGB((float)((System.currentTimeMillis() - x * 10.0D * 1.0D - y * 10.0D * 1.0D) % v) / v, 0.8F, 0.8F));
/*    */   }
/*    */   
/*    */   public static int getRainbow2(int speed, int offset) {
/* 26 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 27 */     return Color.getHSBColor(hue /= speed, 0.8F, 0.8F).getRGB();
/*    */   }
/*    */   
/*    */   public static int fluxRainbow(int delay, long timeOffset, float sa) {
/* 31 */     double rainbowState = Math.ceil(((System.currentTimeMillis() + timeOffset) / 8L) + delay / 20.0D);
/* 32 */     rainbowState %= 360.0D;
/* 33 */     return Color.getHSBColor((float)(rainbowState / 360.0D), sa, 1.0F).getRGB();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int as() {
/* 38 */     int[] counter = { 0 }, arrn = counter;
/* 39 */     arrn[0] = arrn[0] + 1;
/* 40 */     return getRainbow3(counter[0] * 20);
/*    */   }
/*    */   
/*    */   public static int getRainbow3(int tick) {
/* 44 */     double d = 0.0D;
/* 45 */     double delay = Math.ceil(((System.currentTimeMillis() + (tick * 2)) / 5L));
/* 46 */     float rainbow = ((float)(d / 360.0D) < 0.5D) ? -((float)(delay / 360.0D)) : (float)((delay %= 360.0D) / 360.0D);
/* 47 */     return Color.getHSBColor(rainbow, 0.5F, 1.0F).getRGB();
/*    */   }
/* 49 */   public static int rainbowTick = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public static int astolfoRainbow(int delay, int offset, int index) {
/* 54 */     Color rainbow = new Color(Color.HSBtoRGB(
/* 55 */           (float)((Minecraft.func_71410_x()).field_71439_g.field_70173_aa / 50.0D + Math.sin(rainbowTick / 50.0D * 1.6D)) % 1.0F, 0.5F, 1.0F));
/*    */ 
/*    */     
/* 58 */     return rainbow.getRGB();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Color rainbow(long time, float count, float fade) {
/* 63 */     float hue = ((float)time + (1.0F + count) * 2.0E8F) / 1.0E10F % 1.0F;
/* 64 */     long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 1.0F, 1.0F)), 16);
/* 65 */     Color c = new Color((int)color);
/* 66 */     return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\ColorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */