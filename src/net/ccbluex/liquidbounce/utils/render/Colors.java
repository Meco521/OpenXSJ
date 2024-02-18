/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.NumberFormat;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ 
/*     */ public enum Colors
/*     */ {
/*   9 */   BLACK(-16711423),
/*  10 */   BLUE(-12028161),
/*  11 */   DARKBLUE(-12621684),
/*  12 */   GREEN(-9830551),
/*  13 */   DARKGREEN(-9320847),
/*  14 */   WHITE(-65794),
/*  15 */   AQUA(-7820064),
/*  16 */   DARKAQUA(-12621684),
/*  17 */   GREY(-9868951),
/*  18 */   DARKGREY(-14342875),
/*  19 */   RED(-65536),
/*  20 */   DARKRED(-8388608),
/*  21 */   ORANGE(-29696),
/*  22 */   DARKORANGE(-2263808),
/*  23 */   YELLOW(-256),
/*  24 */   DARKYELLOW(-2702025),
/*  25 */   MAGENTA(-18751),
/*  26 */   DARKMAGENTA(-2252579);
/*     */   
/*     */   public int c;
/*     */   
/*     */   Colors(int co) {
/*  31 */     this.c = co;
/*     */   }
/*     */   public static int getColor(Color color) {
/*  34 */     return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getColor(int brightness) {
/*  39 */     return getColor(brightness, brightness, brightness, 255);
/*     */   }
/*     */   
/*     */   public static int getColor(int brightness, int alpha) {
/*  43 */     return getColor(brightness, brightness, brightness, alpha);
/*     */   }
/*     */   
/*     */   public static int getColor(int red, int green, int blue) {
/*  47 */     return getColor(red, green, blue, 255);
/*     */   }
/*     */   public static Color getHealthColor(EntityLivingBase entityLivingBase) {
/*  50 */     float health = entityLivingBase.func_110143_aJ();
/*  51 */     float[] fractions = { 0.0F, 0.15F, 0.55F, 0.7F, 0.9F };
/*  52 */     Color[] colors = { new Color(133, 0, 0), Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN };
/*  53 */     float progress = health / entityLivingBase.func_110138_aP();
/*  54 */     return (health >= 0.0F) ? blendColors(fractions, colors, progress).brighter() : colors[0];
/*     */   }
/*     */   public static Color blendColors(float[] fractions, Color[] colors, float progress) {
/*  57 */     if (fractions == null) throw new IllegalArgumentException("Fractions can't be null"); 
/*  58 */     if (colors == null) throw new IllegalArgumentException("Colours can't be null"); 
/*  59 */     if (fractions.length != colors.length)
/*  60 */       throw new IllegalArgumentException("Fractions and colours must have equal number of elements"); 
/*  61 */     int[] indicies = getFractionIndicies(fractions, progress);
/*  62 */     float[] range = { fractions[indicies[0]], fractions[indicies[1]] };
/*  63 */     Color[] colorRange = { colors[indicies[0]], colors[indicies[1]] };
/*  64 */     float max = range[1] - range[0];
/*  65 */     float value = progress - range[0];
/*  66 */     float weight = value / max;
/*  67 */     return blend(colorRange[0], colorRange[1], (1.0F - weight));
/*     */   }
/*     */   public static Color blend(Color color1, Color color2, double ratio) {
/*  70 */     float r = (float)ratio;
/*  71 */     float ir = 1.0F - r;
/*  72 */     float[] rgb1 = new float[3];
/*  73 */     float[] rgb2 = new float[3];
/*  74 */     color1.getColorComponents(rgb1);
/*  75 */     color2.getColorComponents(rgb2);
/*  76 */     float red = rgb1[0] * r + rgb2[0] * ir;
/*  77 */     float green = rgb1[1] * r + rgb2[1] * ir;
/*  78 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/*  79 */     if (red < 0.0F) {
/*  80 */       red = 0.0F;
/*  81 */     } else if (red > 255.0F) {
/*  82 */       red = 255.0F;
/*     */     } 
/*  84 */     if (green < 0.0F) {
/*  85 */       green = 0.0F;
/*  86 */     } else if (green > 255.0F) {
/*  87 */       green = 255.0F;
/*     */     } 
/*  89 */     if (blue < 0.0F) {
/*  90 */       blue = 0.0F;
/*  91 */     } else if (blue > 255.0F) {
/*  92 */       blue = 255.0F;
/*     */     } 
/*  94 */     Color color = null;
/*     */     try {
/*  96 */       color = new Color(red, green, blue);
/*  97 */     } catch (IllegalArgumentException exp) {
/*  98 */       NumberFormat nf = NumberFormat.getNumberInstance();
/*  99 */       System.out.println(nf.format(red) + "; " + nf.format(green) + "; " + nf.format(blue));
/* 100 */       exp.printStackTrace();
/*     */     } 
/* 102 */     return color;
/*     */   }
/*     */   
/*     */   public static int[] getFractionIndicies(float[] fractions, float progress) {
/* 106 */     int[] range = new int[2]; int startPoint;
/* 107 */     for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
/*     */     
/* 109 */     if (startPoint >= fractions.length) {
/* 110 */       startPoint = fractions.length - 1;
/*     */     }
/* 112 */     range[0] = startPoint - 1;
/* 113 */     range[1] = startPoint;
/* 114 */     return range;
/*     */   }
/*     */   public static int getColor(int red, int green, int blue, int alpha) {
/* 117 */     int color = 0;
/* 118 */     color |= alpha << 24;
/* 119 */     color |= red << 16;
/* 120 */     color |= green << 8;
/* 121 */     color |= blue;
/* 122 */     return color;
/*     */   }
/*     */   
/*     */   public static int getRainbow(int speed, int offset) {
/* 126 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 127 */     return Color.getHSBColor(hue /= speed, 0.4F, 1.0F).getRGB();
/*     */   }
/*     */   
/*     */   public static int getRainbow2(int speed, int offset) {
/* 131 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 132 */     return Color.getHSBColor(hue /= speed, 0.5F, 0.555F).getRGB();
/*     */   }
/*     */   
/*     */   public static int getRainbow3(int speed, int offset) {
/* 136 */     float hue = (float)((System.currentTimeMillis() + offset) % speed);
/* 137 */     return Color.getHSBColor(hue /= speed, 0.8F, 1.001F).getRGB();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\Colors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */