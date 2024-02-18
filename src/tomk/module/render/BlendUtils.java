/*    */ package tomk.module.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BlendUtils
/*    */ {
/* 11 */   GREEN("§A"),
/* 12 */   GOLD("§6"),
/* 13 */   RED("§C");
/*    */   
/*    */   String colorCode;
/*    */   
/*    */   BlendUtils(String colorCode) {
/* 18 */     this.colorCode = colorCode;
/*    */   }
/*    */   
/*    */   public static Color getColorWithOpacity(Color color, int alpha) {
/* 22 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
/*    */   }
/*    */   
/*    */   public static Color getHealthColor(float health, float maxHealth) {
/* 26 */     float[] fractions = { 0.0F, 0.5F, 1.0F };
/* 27 */     Color[] colors = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
/* 28 */     float progress = health / maxHealth;
/* 29 */     return blendColors(fractions, colors, progress).brighter();
/*    */   }
/*    */   
/*    */   public static Color blendColors(float[] fractions, Color[] colors, float progress) {
/* 33 */     if (fractions.length == colors.length) {
/* 34 */       int[] indices = getFractionIndices(fractions, progress);
/* 35 */       float[] range = { fractions[indices[0]], fractions[indices[1]] };
/* 36 */       Color[] colorRange = { colors[indices[0]], colors[indices[1]] };
/* 37 */       float max = range[1] - range[0];
/* 38 */       float value = progress - range[0];
/* 39 */       float weight = value / max;
/* 40 */       Color color = blend(colorRange[0], colorRange[1], (1.0F - weight));
/* 41 */       return color;
/*    */     } 
/* 43 */     throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
/*    */   }
/*    */ 
/*    */   
/*    */   public static int[] getFractionIndices(float[] fractions, float progress) {
/* 48 */     int[] range = new int[2];
/*    */     
/*    */     int startPoint;
/* 51 */     for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
/*    */ 
/*    */     
/* 54 */     if (startPoint >= fractions.length) {
/* 55 */       startPoint = fractions.length - 1;
/*    */     }
/*    */     
/* 58 */     range[0] = startPoint - 1;
/* 59 */     range[1] = startPoint;
/* 60 */     return range;
/*    */   }
/*    */   
/*    */   public static Color blend(Color color1, Color color2, double ratio) {
/* 64 */     float r = (float)ratio;
/* 65 */     float ir = 1.0F - r;
/* 66 */     float[] rgb1 = color1.getColorComponents(new float[3]);
/* 67 */     float[] rgb2 = color2.getColorComponents(new float[3]);
/* 68 */     float red = rgb1[0] * r + rgb2[0] * ir;
/* 69 */     float green = rgb1[1] * r + rgb2[1] * ir;
/* 70 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/* 71 */     if (red < 0.0F) {
/* 72 */       red = 0.0F;
/* 73 */     } else if (red > 255.0F) {
/* 74 */       red = 255.0F;
/*    */     } 
/*    */     
/* 77 */     if (green < 0.0F) {
/* 78 */       green = 0.0F;
/* 79 */     } else if (green > 255.0F) {
/* 80 */       green = 255.0F;
/*    */     } 
/*    */     
/* 83 */     if (blue < 0.0F) {
/* 84 */       blue = 0.0F;
/* 85 */     } else if (blue > 255.0F) {
/* 86 */       blue = 255.0F;
/*    */     } 
/*    */     
/* 89 */     Color color3 = null;
/*    */     
/*    */     try {
/* 92 */       color3 = new Color(red, green, blue);
/* 93 */     } catch (IllegalArgumentException illegalArgumentException) {}
/*    */ 
/*    */     
/* 96 */     return color3;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\BlendUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */