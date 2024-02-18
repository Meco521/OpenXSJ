/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.function.Supplier;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public enum Palette
/*    */ {
/* 10 */   GREEN(() -> new Color(0, 255, 138)),
/* 11 */   WHITE(() -> Color.WHITE),
/* 12 */   PURPLE(() -> new Color(198, 139, 255)),
/* 13 */   DARK_PURPLE(() -> new Color(133, 46, 215)),
/* 14 */   BLUE(() -> new Color(116, 202, 255));
/*    */   
/*    */   private final Supplier<Color> colorSupplier;
/*    */   
/*    */   Palette(Supplier<Color> colorSupplier) {
/* 19 */     this.colorSupplier = colorSupplier;
/*    */   }
/*    */   
/*    */   public static Color fade(Color color) {
/* 23 */     return fade(color, 2, 100, 2.0F);
/*    */   }
/*    */   
/*    */   public static Color fade(Color color, int index, int count, float customValue) {
/* 27 */     float[] hsb = new float[3];
/* 28 */     Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
/* 29 */     float brightness = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0F + index / count * 2.0F) % customValue - 1.0F);
/* 30 */     brightness = 0.5F + 0.5F * brightness;
/* 31 */     hsb[2] = brightness % 2.0F;
/* 32 */     return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/*    */   }
/*    */   
/*    */   public static Color fade1(Color color) {
/* 36 */     return fade1(color, 2, 100);
/*    */   }
/*    */   
/*    */   public static Color fade1(Color color, int index, int count) {
/* 40 */     float[] hsb = new float[3];
/* 41 */     Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
/* 42 */     float brightness = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0F + index / count * 2.0F) % 2.0F - 1.0F);
/* 43 */     brightness = 0.5F + 0.5F * brightness;
/* 44 */     hsb[2] = brightness % 2.0F;
/* 45 */     return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/*    */   }
/*    */   
/*    */   public static Color fade2(Color color, int index, int count) {
/* 49 */     float[] hsb = new float[3];
/* 50 */     Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
/* 51 */     float brightness = Math.abs(((float)(System.currentTimeMillis() % 10000L) / 1000.0F + index / count * 2.0F) % 2.0F - 1.0F);
/* 52 */     brightness = 0.5F + 0.5F * brightness;
/* 53 */     hsb[2] = brightness % 2.0F;
/* 54 */     return new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/*    */   }
/*    */   
/*    */   public Color getColor() {
/* 58 */     return this.colorSupplier.get();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static Color fade2(int color, int indexOf, int fontHeight) {
/* 63 */     return null;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public static Object fade2(int color, @NotNull String displayText, int fontHeight) {
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\Palette.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */