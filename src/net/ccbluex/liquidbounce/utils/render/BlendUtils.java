/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BlendUtils
/*    */ {
/* 12 */   GREEN("§A"),
/* 13 */   GOLD("§6"),
/* 14 */   RED("§C");
/*    */   
/*    */   String colorCode;
/*    */   
/*    */   BlendUtils(String colorCode) {
/* 19 */     this.colorCode = colorCode;
/*    */   }
/*    */   
/*    */   public static Color getColorWithOpacity(Color color, int alpha) {
/* 23 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
/*    */   }
/*    */   
/*    */   public static Color getHealthColor(float health, float maxHealth) {
/* 27 */     float[] fractions = { 0.0F, 0.5F, 1.0F };
/* 28 */     Color[] colors = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
/* 29 */     float progress = health / maxHealth;
/* 30 */     return blendColors(fractions, colors, progress).brighter();
/*    */   }
/*    */   
/*    */   public static Color blendColors(float[] fractions, Color[] colors, float progress) {
/* 34 */     if (fractions.length == colors.length) {
/* 35 */       int[] indices = getFractionIndices(fractions, progress);
/* 36 */       float[] range = { fractions[indices[0]], fractions[indices[1]] };
/* 37 */       Color[] colorRange = { colors[indices[0]], colors[indices[1]] };
/* 38 */       float max = range[1] - range[0];
/* 39 */       float value = progress - range[0];
/* 40 */       float weight = value / max;
/* 41 */       Color color = blend(colorRange[0], colorRange[1], (1.0F - weight));
/* 42 */       return color;
/*    */     } 
/* 44 */     throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
/*    */   }
/*    */ 
/*    */   
/*    */   public static int[] getFractionIndices(float[] fractions, float progress) {
/* 49 */     int[] range = new int[2];
/*    */     
/*    */     int startPoint;
/* 52 */     for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
/*    */ 
/*    */     
/* 55 */     if (startPoint >= fractions.length) {
/* 56 */       startPoint = fractions.length - 1;
/*    */     }
/*    */     
/* 59 */     range[0] = startPoint - 1;
/* 60 */     range[1] = startPoint;
/* 61 */     return range;
/*    */   }
/*    */   
/*    */   public static Color blend(Color color1, Color color2, double ratio) {
/* 65 */     float r = (float)ratio;
/* 66 */     float ir = 1.0F - r;
/* 67 */     float[] rgb1 = color1.getColorComponents(new float[3]);
/* 68 */     float[] rgb2 = color2.getColorComponents(new float[3]);
/* 69 */     float red = rgb1[0] * r + rgb2[0] * ir;
/* 70 */     float green = rgb1[1] * r + rgb2[1] * ir;
/* 71 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/* 72 */     if (red < 0.0F) {
/* 73 */       red = 0.0F;
/* 74 */     } else if (red > 255.0F) {
/* 75 */       red = 255.0F;
/*    */     } 
/*    */     
/* 78 */     if (green < 0.0F) {
/* 79 */       green = 0.0F;
/* 80 */     } else if (green > 255.0F) {
/* 81 */       green = 255.0F;
/*    */     } 
/*    */     
/* 84 */     if (blue < 0.0F) {
/* 85 */       blue = 0.0F;
/* 86 */     } else if (blue > 255.0F) {
/* 87 */       blue = 255.0F;
/*    */     } 
/*    */     
/* 90 */     Color color3 = null;
/*    */     
/*    */     try {
/* 93 */       color3 = new Color(red, green, blue);
/* 94 */     } catch (IllegalArgumentException illegalArgumentException) {}
/*    */ 
/*    */     
/* 97 */     return color3;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\BlendUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */