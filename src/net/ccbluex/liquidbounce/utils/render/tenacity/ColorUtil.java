/*     */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ColorUtil
/*     */ {
/*     */   public static Color[] getAnalogousColor(Color color) {
/*  13 */     Color[] colors = new Color[2];
/*  14 */     float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
/*     */     
/*  16 */     float degree = 0.083333336F;
/*     */     
/*  18 */     float newHueAdded = hsb[0] + degree;
/*  19 */     colors[0] = new Color(Color.HSBtoRGB(newHueAdded, hsb[1], hsb[2]));
/*     */     
/*  21 */     float newHueSubtracted = hsb[0] - degree;
/*     */     
/*  23 */     colors[1] = new Color(Color.HSBtoRGB(newHueSubtracted, hsb[1], hsb[2]));
/*     */     
/*  25 */     return colors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color hslToRGB(float[] hsl) {
/*     */     float red, green, blue;
/*  33 */     if (hsl[1] == 0.0F) {
/*  34 */       red = green = blue = 1.0F;
/*     */     } else {
/*  36 */       float q = (hsl[2] < 0.5D) ? (hsl[2] * (1.0F + hsl[1])) : (hsl[2] + hsl[1] - hsl[2] * hsl[1]);
/*  37 */       float p = 2.0F * hsl[2] - q;
/*     */       
/*  39 */       red = hueToRGB(p, q, hsl[0] + 0.33333334F);
/*  40 */       green = hueToRGB(p, q, hsl[0]);
/*  41 */       blue = hueToRGB(p, q, hsl[0] - 0.33333334F);
/*     */     } 
/*     */     
/*  44 */     red *= 255.0F;
/*  45 */     green *= 255.0F;
/*  46 */     blue *= 255.0F;
/*     */     
/*  48 */     return new Color((int)red, (int)green, (int)blue);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float hueToRGB(float p, float q, float t) {
/*  53 */     float newT = t;
/*  54 */     if (newT < 0.0F) newT++; 
/*  55 */     if (newT > 1.0F) newT--; 
/*  56 */     if (newT < 0.16666667F) return p + (q - p) * 6.0F * newT; 
/*  57 */     if (newT < 0.5F) return q; 
/*  58 */     if (newT < 0.6666667F) return p + (q - p) * (0.6666667F - newT) * 6.0F; 
/*  59 */     return p;
/*     */   }
/*     */   
/*     */   public static float[] rgbToHSL(Color rgb) {
/*  63 */     float red = rgb.getRed() / 255.0F;
/*  64 */     float green = rgb.getGreen() / 255.0F;
/*  65 */     float blue = rgb.getBlue() / 255.0F;
/*     */     
/*  67 */     float max = Math.max(Math.max(red, green), blue);
/*  68 */     float min = Math.min(Math.min(red, green), blue);
/*  69 */     float c = (max + min) / 2.0F;
/*  70 */     float[] hsl = { c, c, c };
/*     */     
/*  72 */     if (max == min) {
/*  73 */       hsl[1] = 0.0F; hsl[0] = 0.0F;
/*     */     } else {
/*  75 */       float d = max - min;
/*  76 */       hsl[1] = (hsl[2] > 0.5D) ? (d / (2.0F - max - min)) : (d / (max + min));
/*     */       
/*  78 */       if (max == red) {
/*  79 */         hsl[0] = (green - blue) / d + ((green < blue) ? 6 : false);
/*  80 */       } else if (max == blue) {
/*  81 */         hsl[0] = (blue - red) / d + 2.0F;
/*  82 */       } else if (max == green) {
/*  83 */         hsl[0] = (red - green) / d + 4.0F;
/*     */       } 
/*  85 */       hsl[0] = hsl[0] / 6.0F;
/*     */     } 
/*  87 */     return hsl;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color imitateTransparency(Color backgroundColor, Color accentColor, float percentage) {
/*  92 */     return new Color(interpolateColor(backgroundColor, accentColor, 255.0F * percentage / 255.0F));
/*     */   }
/*     */   
/*     */   public static int applyOpacity(int color, float opacity) {
/*  96 */     Color old = new Color(color);
/*  97 */     return applyOpacity(old, opacity).getRGB();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color applyOpacity(Color color, float opacity) {
/* 102 */     opacity = Math.min(1.0F, Math.max(0.0F, opacity));
/* 103 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(color.getAlpha() * opacity));
/*     */   }
/*     */   
/*     */   public static Color darker(Color color, float FACTOR) {
/* 107 */     return new Color(Math.max((int)(color.getRed() * FACTOR), 0), 
/* 108 */         Math.max((int)(color.getGreen() * FACTOR), 0), 
/* 109 */         Math.max((int)(color.getBlue() * FACTOR), 0), color
/* 110 */         .getAlpha());
/*     */   }
/*     */   
/*     */   public static Color brighter(Color color, float FACTOR) {
/* 114 */     int r = color.getRed();
/* 115 */     int g = color.getGreen();
/* 116 */     int b = color.getBlue();
/* 117 */     int alpha = color.getAlpha();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     int i = (int)(1.0D / (1.0D - FACTOR));
/* 125 */     if (r == 0 && g == 0 && b == 0) {
/* 126 */       return new Color(i, i, i, alpha);
/*     */     }
/* 128 */     if (r > 0 && r < i) r = i; 
/* 129 */     if (g > 0 && g < i) g = i; 
/* 130 */     if (b > 0 && b < i) b = i;
/*     */     
/* 132 */     return new Color(Math.min((int)(r / FACTOR), 255), 
/* 133 */         Math.min((int)(g / FACTOR), 255), 
/* 134 */         Math.min((int)(b / FACTOR), 255), alpha);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color averageColor(BufferedImage bi, int width, int height, int pixelStep) {
/* 143 */     int[] color = new int[3]; int x;
/* 144 */     for (x = 0; x < width; x += pixelStep) {
/* 145 */       int y; for (y = 0; y < height; y += pixelStep) {
/* 146 */         Color pixel = new Color(bi.getRGB(x, y));
/* 147 */         color[0] = color[0] + pixel.getRed();
/* 148 */         color[1] = color[1] + pixel.getGreen();
/* 149 */         color[2] = color[2] + pixel.getBlue();
/*     */       } 
/*     */     } 
/* 152 */     int num = width * height / pixelStep * pixelStep;
/* 153 */     return new Color(color[0] / num, color[1] / num, color[2] / num);
/*     */   }
/*     */   
/*     */   public static Color rainbow(int speed, int index, float saturation, float brightness, float opacity) {
/* 157 */     int angle = (int)((System.currentTimeMillis() / speed + index) % 360L);
/* 158 */     float hue = angle / 360.0F;
/* 159 */     Color color = new Color(Color.HSBtoRGB(hue, saturation, brightness));
/* 160 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, (int)(opacity * 255.0F))));
/*     */   }
/*     */   
/*     */   public static Color interpolateColorsBackAndForth(int speed, int index, Color start, Color end, boolean trueColor) {
/* 164 */     int angle = (int)((System.currentTimeMillis() / speed + index) % 360L);
/* 165 */     angle = ((angle >= 180) ? (360 - angle) : angle) * 2;
/* 166 */     return trueColor ? interpolateColorHue(start, end, angle / 360.0F) : interpolateColorC(start, end, angle / 360.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int interpolateColor(Color color1, Color color2, float amount) {
/* 171 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/* 172 */     return interpolateColorC(color1, color2, amount).getRGB();
/*     */   }
/*     */   
/*     */   public static int interpolateColor(int color1, int color2, float amount) {
/* 176 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/* 177 */     Color cColor1 = new Color(color1);
/* 178 */     Color cColor2 = new Color(color2);
/* 179 */     return interpolateColorC(cColor1, cColor2, amount).getRGB();
/*     */   }
/*     */   
/*     */   public static Color interpolateColorC(Color color1, Color color2, float amount) {
/* 183 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/* 184 */     return new Color(MathUtils.interpolateInt(color1.getRed(), color2.getRed(), amount), 
/* 185 */         MathUtils.interpolateInt(color1.getGreen(), color2.getGreen(), amount), 
/* 186 */         MathUtils.interpolateInt(color1.getBlue(), color2.getBlue(), amount), 
/* 187 */         MathUtils.interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*     */   }
/*     */   
/*     */   public static Color interpolateColorHue(Color color1, Color color2, float amount) {
/* 191 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/*     */     
/* 193 */     float[] color1HSB = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
/* 194 */     float[] color2HSB = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
/*     */     
/* 196 */     Color resultColor = Color.getHSBColor(MathUtils.interpolateFloat(color1HSB[0], color2HSB[0], amount), 
/* 197 */         MathUtils.interpolateFloat(color1HSB[1], color2HSB[1], amount), MathUtils.interpolateFloat(color1HSB[2], color2HSB[2], amount));
/*     */     
/* 199 */     return new Color(resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue(), 
/* 200 */         MathUtils.interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color fade(int speed, int index, Color color, float alpha) {
/* 206 */     float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
/* 207 */     int angle = (int)((System.currentTimeMillis() / speed + index) % 360L);
/* 208 */     angle = ((angle > 180) ? (360 - angle) : angle) + 180;
/*     */     
/* 210 */     Color colorHSB = new Color(Color.HSBtoRGB(hsb[0], hsb[1], angle / 360.0F));
/*     */     
/* 212 */     return new Color(colorHSB.getRed(), colorHSB.getGreen(), colorHSB.getBlue(), Math.max(0, Math.min(255, (int)(alpha * 255.0F))));
/*     */   }
/*     */ 
/*     */   
/*     */   private static float getAnimationEquation(int index, int speed) {
/* 217 */     int angle = (int)((System.currentTimeMillis() / speed + index) % 360L);
/* 218 */     return (((angle > 180) ? (360 - angle) : angle) + 180) / 360.0F;
/*     */   }
/*     */   
/*     */   public static int[] createColorArray(int color) {
/* 222 */     return new int[] { bitChangeColor(color, 16), bitChangeColor(color, 8), bitChangeColor(color, 0), bitChangeColor(color, 24) };
/*     */   }
/*     */   
/*     */   public static int getOppositeColor(int color) {
/* 226 */     int R = bitChangeColor(color, 0);
/* 227 */     int G = bitChangeColor(color, 8);
/* 228 */     int B = bitChangeColor(color, 16);
/* 229 */     int A = bitChangeColor(color, 24);
/* 230 */     R = 255 - R;
/* 231 */     G = 255 - G;
/* 232 */     B = 255 - B;
/* 233 */     return R + (G << 8) + (B << 16) + (A << 24);
/*     */   }
/*     */   
/*     */   private static int bitChangeColor(int color, int bitChange) {
/* 237 */     return color >> bitChange & 0xFF;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\ColorUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */