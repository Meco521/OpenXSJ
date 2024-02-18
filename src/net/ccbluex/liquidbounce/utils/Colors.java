/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.NumberFormat;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ 
/*     */ public class Colors
/*     */ {
/*     */   public static int getColor(Color color) {
/*  10 */     return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*     */   }
/*     */   
/*     */   public static int getColor(int brightness) {
/*  14 */     return getColor(brightness, brightness, brightness, 255);
/*     */   }
/*     */   
/*     */   public static int getColor(int brightness, int alpha) {
/*  18 */     return getColor(brightness, brightness, brightness, alpha);
/*     */   }
/*     */   
/*     */   public static int getColor(int red, int green, int blue) {
/*  22 */     return getColor(red, green, blue, 255);
/*     */   }
/*     */   public static Color getHealthColor(EntityLivingBase entityLivingBase) {
/*  25 */     float health = entityLivingBase.func_110143_aJ();
/*  26 */     float[] fractions = { 0.0F, 0.15F, 0.55F, 0.7F, 0.9F };
/*  27 */     Color[] colors = { new Color(133, 0, 0), Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN };
/*  28 */     float progress = health / entityLivingBase.func_110138_aP();
/*  29 */     return (health >= 0.0F) ? blendColors(fractions, colors, progress).brighter() : colors[0];
/*     */   }
/*     */   public static Color blendColors(float[] fractions, Color[] colors, float progress) {
/*  32 */     if (fractions == null) throw new IllegalArgumentException("Fractions can't be null"); 
/*  33 */     if (colors == null) throw new IllegalArgumentException("Colours can't be null"); 
/*  34 */     if (fractions.length != colors.length)
/*  35 */       throw new IllegalArgumentException("Fractions and colours must have equal number of elements"); 
/*  36 */     int[] indicies = getFractionIndicies(fractions, progress);
/*  37 */     float[] range = { fractions[indicies[0]], fractions[indicies[1]] };
/*  38 */     Color[] colorRange = { colors[indicies[0]], colors[indicies[1]] };
/*  39 */     float max = range[1] - range[0];
/*  40 */     float value = progress - range[0];
/*  41 */     float weight = value / max;
/*  42 */     return blend(colorRange[0], colorRange[1], (1.0F - weight));
/*     */   }
/*     */   public static Color blend(Color color1, Color color2, double ratio) {
/*  45 */     float r = (float)ratio;
/*  46 */     float ir = 1.0F - r;
/*  47 */     float[] rgb1 = new float[3];
/*  48 */     float[] rgb2 = new float[3];
/*  49 */     color1.getColorComponents(rgb1);
/*  50 */     color2.getColorComponents(rgb2);
/*  51 */     float red = rgb1[0] * r + rgb2[0] * ir;
/*  52 */     float green = rgb1[1] * r + rgb2[1] * ir;
/*  53 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/*  54 */     if (red < 0.0F) {
/*  55 */       red = 0.0F;
/*  56 */     } else if (red > 255.0F) {
/*  57 */       red = 255.0F;
/*     */     } 
/*  59 */     if (green < 0.0F) {
/*  60 */       green = 0.0F;
/*  61 */     } else if (green > 255.0F) {
/*  62 */       green = 255.0F;
/*     */     } 
/*  64 */     if (blue < 0.0F) {
/*  65 */       blue = 0.0F;
/*  66 */     } else if (blue > 255.0F) {
/*  67 */       blue = 255.0F;
/*     */     } 
/*  69 */     Color color = null;
/*     */     try {
/*  71 */       color = new Color(red, green, blue);
/*  72 */     } catch (IllegalArgumentException exp) {
/*  73 */       NumberFormat nf = NumberFormat.getNumberInstance();
/*  74 */       System.out.println(nf.format(red) + "; " + nf.format(green) + "; " + nf.format(blue));
/*  75 */       exp.printStackTrace();
/*     */     } 
/*  77 */     return color;
/*     */   }
/*     */   
/*     */   public static int[] getFractionIndicies(float[] fractions, float progress) {
/*  81 */     int[] range = new int[2]; int startPoint;
/*  82 */     for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
/*     */     
/*  84 */     if (startPoint >= fractions.length) {
/*  85 */       startPoint = fractions.length - 1;
/*     */     }
/*  87 */     range[0] = startPoint - 1;
/*  88 */     range[1] = startPoint;
/*  89 */     return range;
/*     */   }
/*     */   public static int getColor(int red, int green, int blue, int alpha) {
/*  92 */     int color = 0;
/*  93 */     color |= alpha << 24;
/*  94 */     color |= red << 16;
/*  95 */     color |= green << 8;
/*  96 */     color |= blue;
/*  97 */     return color;
/*     */   }
/*     */   
/*     */   public static int getRainbow(int speed, int offset) {
/* 101 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 102 */     return Color.getHSBColor(hue /= speed, 0.4F, 1.0F).getRGB();
/*     */   }
/*     */   
/*     */   public static int getRainbow2(int speed, int offset) {
/* 106 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 107 */     return Color.getHSBColor(hue /= speed, 0.5F, 0.555F).getRGB();
/*     */   }
/*     */   
/*     */   public static int getRainbow3(int speed, int offset) {
/* 111 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 112 */     return Color.getHSBColor(hue /= speed, 0.8F, 1.001F).getRGB();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\Colors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */