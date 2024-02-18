/*    */ package tomk.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public enum BlendUtils {
/*  6 */   GREEN("§A"),
/*  7 */   GOLD("§6"),
/*  8 */   RED("§C");
/*    */   
/*    */   String colorCode;
/*    */   
/*    */   BlendUtils(String colorCode) {
/* 13 */     this.colorCode = colorCode;
/*    */   }
/*    */   
/*    */   public static Color getColorWithOpacity(Color color, int alpha) {
/* 17 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
/*    */   }
/*    */   
/*    */   public static Color getHealthColor(float health, float maxHealth) {
/* 21 */     float[] fractions = { 0.0F, 0.5F, 1.0F };
/* 22 */     Color[] colors = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
/* 23 */     float progress = health / maxHealth;
/* 24 */     return blendColors(fractions, colors, progress).brighter();
/*    */   }
/*    */   
/*    */   public static Color blendColors(float[] fractions, Color[] colors, float progress) {
/* 28 */     if (fractions.length == colors.length) {
/* 29 */       int[] indices = getFractionIndices(fractions, progress);
/* 30 */       float[] range = { fractions[indices[0]], fractions[indices[1]] };
/* 31 */       Color[] colorRange = { colors[indices[0]], colors[indices[1]] };
/* 32 */       float max = range[1] - range[0];
/* 33 */       float value = progress - range[0];
/* 34 */       float weight = value / max;
/* 35 */       Color color = blend(colorRange[0], colorRange[1], (1.0F - weight));
/* 36 */       return color;
/*    */     } 
/* 38 */     throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
/*    */   }
/*    */ 
/*    */   
/*    */   public static int[] getFractionIndices(float[] fractions, float progress) {
/* 43 */     int[] range = new int[2];
/*    */     
/*    */     int startPoint;
/* 46 */     for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
/*    */ 
/*    */     
/* 49 */     if (startPoint >= fractions.length) {
/* 50 */       startPoint = fractions.length - 1;
/*    */     }
/*    */     
/* 53 */     range[0] = startPoint - 1;
/* 54 */     range[1] = startPoint;
/* 55 */     return range;
/*    */   }
/*    */   
/*    */   public static Color blend(Color color1, Color color2, double ratio) {
/* 59 */     float r = (float)ratio;
/* 60 */     float ir = 1.0F - r;
/* 61 */     float[] rgb1 = color1.getColorComponents(new float[3]);
/* 62 */     float[] rgb2 = color2.getColorComponents(new float[3]);
/* 63 */     float red = rgb1[0] * r + rgb2[0] * ir;
/* 64 */     float green = rgb1[1] * r + rgb2[1] * ir;
/* 65 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/* 66 */     if (red < 0.0F) {
/* 67 */       red = 0.0F;
/* 68 */     } else if (red > 255.0F) {
/* 69 */       red = 255.0F;
/*    */     } 
/*    */     
/* 72 */     if (green < 0.0F) {
/* 73 */       green = 0.0F;
/* 74 */     } else if (green > 255.0F) {
/* 75 */       green = 255.0F;
/*    */     } 
/*    */     
/* 78 */     if (blue < 0.0F) {
/* 79 */       blue = 0.0F;
/* 80 */     } else if (blue > 255.0F) {
/* 81 */       blue = 255.0F;
/*    */     } 
/*    */     
/* 84 */     Color color3 = null;
/*    */     
/*    */     try {
/* 87 */       color3 = new Color(red, green, blue);
/* 88 */     } catch (IllegalArgumentException illegalArgumentException) {}
/*    */ 
/*    */     
/* 91 */     return color3;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\BlendUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */