/*     */ package net.ccbluex.liquidbounce.ui.client.hud.Ur;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.regex.Pattern;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PaletteHelper
/*     */   extends MinecraftInstance
/*     */ {
/*  16 */   public static Pattern COLOR_PATTERN = Pattern.compile("(?i)&[0-9A-FK-OR]");
/*     */   
/*     */   public static Color getHealthColor(float health, float maxHealth) {
/*  19 */     GlStateManager.func_179094_E();
/*  20 */     float[] fractions = { 0.0F, 0.5F, 1.0F };
/*  21 */     Color[] colors = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
/*  22 */     float progress = health / maxHealth;
/*  23 */     GlStateManager.func_179121_F();
/*  24 */     return blendColors(fractions, colors, progress).brighter();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color astolfo(float yDist, float yTotal, float saturation, float speedt) {
/*  29 */     float speed = 1800.0F; float hue;
/*  30 */     for (hue = (float)(System.currentTimeMillis() % (int)speed) + (yTotal - yDist) * speedt; hue > speed; hue -= speed);
/*     */     
/*  32 */     if ((hue /= speed) > 0.5D) {
/*  33 */       hue = 0.5F - hue - 0.5F;
/*     */     }
/*  35 */     return Color.getHSBColor(hue += 0.5F, saturation, 1.0F);
/*     */   }
/*     */   
/*     */   public static int reAlpha(int color, float alpha) {
/*  39 */     Color c = new Color(color);
/*  40 */     float r = 0.003921569F * c.getRed();
/*  41 */     float g = 0.003921569F * c.getGreen();
/*  42 */     float b = 0.003921569F * c.getBlue();
/*  43 */     return (new Color(r, g, b, alpha)).getRGB();
/*     */   }
/*     */   
/*     */   public static String removeColorCode(String text) {
/*  47 */     String finalText = text;
/*  48 */     if (text.contains("??")) {
/*  49 */       for (int i = 0; i < finalText.length(); i++) {
/*  50 */         if (Character.toString(finalText.charAt(i)).equals("??")) {
/*     */           try {
/*  52 */             String part1 = finalText.substring(0, i);
/*  53 */             String part2 = finalText.substring(Math.min(i + 2, finalText.length()));
/*  54 */             finalText = part1 + part2;
/*     */           
/*     */           }
/*  57 */           catch (Exception exception) {}
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  62 */     return finalText;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int astolfoColors(int yOffset, int yTotal) {
/*  67 */     float speed = 2900.0F; float hue;
/*  68 */     for (hue = (float)(System.currentTimeMillis() % (int)speed) + ((yTotal - yOffset) * 9); hue > speed; hue -= speed);
/*     */     
/*  70 */     hue /= speed;
/*  71 */     if ((hue /= speed) > 0.5D) {
/*  72 */       hue = 0.5F - hue - 0.5F;
/*     */     }
/*  74 */     return Color.HSBtoRGB(hue += 0.5F, 0.5F, 1.0F);
/*     */   }
/*     */   
/*     */   private int getHealthColor(EntityLivingBase player) {
/*  78 */     float f = player.func_110143_aJ();
/*  79 */     float f1 = player.func_110138_aP();
/*  80 */     float f2 = Math.max(0.0F, Math.min(f, f1) / f1);
/*  81 */     return Color.HSBtoRGB(f2 / 3.0F, 1.0F, 1.0F) | 0xFF000000;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getFractionIndicies(float[] fractions, float progress) {
/*  86 */     int[] range = new int[2]; int startPoint;
/*  87 */     for (startPoint = 0; startPoint < fractions.length && fractions[startPoint] <= progress; startPoint++);
/*     */     
/*  89 */     if (startPoint >= fractions.length) {
/*  90 */       startPoint = fractions.length - 1;
/*     */     }
/*  92 */     range[0] = startPoint - 1;
/*  93 */     range[1] = startPoint;
/*  94 */     return range;
/*     */   }
/*     */   
/*     */   public static Color blendColors(float[] fractions, Color[] colors, float progress) {
/*  98 */     Color color = null;
/*  99 */     if (fractions != null && colors != null && fractions.length == colors.length) {
/* 100 */       int[] indicies = getFractionIndicies(fractions, progress);
/* 101 */       if (indicies[0] < 0 || indicies[0] >= fractions.length || indicies[1] < 0 || indicies[1] >= fractions.length) {
/* 102 */         return colors[0];
/*     */       }
/* 104 */       float[] range = { fractions[indicies[0]], fractions[indicies[1]] };
/* 105 */       Color[] colorRange = { colors[indicies[0]], colors[indicies[1]] };
/* 106 */       float max = range[1] - range[0];
/* 107 */       float value = progress - range[0];
/* 108 */       float weight = value / max;
/* 109 */       color = blend(colorRange[0], colorRange[1], (1.0F - weight));
/*     */     } 
/* 111 */     return color;
/*     */   }
/*     */   
/*     */   public static Color blend(Color color1, Color color2, double ratio) {
/* 115 */     float r = (float)ratio;
/* 116 */     float ir = 1.0F - r;
/* 117 */     float[] rgb1 = new float[3];
/* 118 */     float[] rgb2 = new float[3];
/* 119 */     color1.getColorComponents(rgb1);
/* 120 */     color2.getColorComponents(rgb2);
/* 121 */     float red = rgb1[0] * r + rgb2[0] * ir;
/* 122 */     float green = rgb1[1] * r + rgb2[1] * ir;
/* 123 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/* 124 */     if (red < 0.0F) {
/* 125 */       red = 0.0F;
/* 126 */     } else if (red > 255.0F) {
/* 127 */       red = 255.0F;
/*     */     } 
/* 129 */     if (green < 0.0F) {
/* 130 */       green = 0.0F;
/* 131 */     } else if (green > 255.0F) {
/* 132 */       green = 255.0F;
/*     */     } 
/* 134 */     if (blue < 0.0F) {
/* 135 */       blue = 0.0F;
/* 136 */     } else if (blue > 255.0F) {
/* 137 */       blue = 255.0F;
/*     */     } 
/* 139 */     Color color = new Color(red, green, blue);
/* 140 */     return color;
/*     */   }
/*     */   
/*     */   public static int getColor(Color color) {
/* 144 */     return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*     */   }
/*     */   
/*     */   public static int getColor(int bright) {
/* 148 */     return getColor(bright, bright, bright, 255);
/*     */   }
/*     */   
/*     */   public static Color getColorWithOpacity(Color color, int alpha) {
/* 152 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
/*     */   }
/*     */   
/*     */   public static int getColor(int red, int green, int blue) {
/* 156 */     return getColor(red, green, blue, 255);
/*     */   }
/*     */   
/*     */   public static int getColor(int red, int green, int blue, int alpha) {
/* 160 */     int color = 0;
/* 161 */     color |= alpha << 24;
/* 162 */     color |= red << 16;
/* 163 */     color |= green << 8;
/* 164 */     return color |= blue;
/*     */   }
/*     */   
/*     */   public static int getColor(int brightness, int alpha) {
/* 168 */     return getColor(brightness, brightness, brightness, alpha);
/*     */   }
/*     */   
/*     */   public static Color rainbow(int delay, float saturation, float brightness) {
/* 172 */     double rainbow = Math.ceil(((System.currentTimeMillis() + delay) / 16L));
/* 173 */     return Color.getHSBColor((float)((rainbow %= 360.0D) / 360.0D), saturation, brightness);
/*     */   }
/*     */   
/*     */   public static Color rainbow2(int delay, float saturation, float brightness) {
/* 177 */     double rainbow = Math.ceil((System.currentTimeMillis() / delay));
/* 178 */     return Color.getHSBColor((float)((rainbow %= 360.0D) / 360.0D), saturation, brightness);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int astolfo(int delay, float offset) {
/* 186 */     float speed = 3000.0F; float hue;
/* 187 */     for (hue = Math.abs((float)(System.currentTimeMillis() % delay) + -offset / 21.0F * 2.0F); hue > speed; hue -= speed);
/*     */     
/* 189 */     if ((hue /= speed) > 0.5D) {
/* 190 */       hue = 0.5F - hue - 0.5F;
/*     */     }
/* 192 */     return Color.HSBtoRGB(hue += 0.5F, 0.5F, 1.0F);
/*     */   }
/*     */   
/*     */   public static Color astolfo(boolean clickgui, int yOffset) {
/* 196 */     float f = 0.0F;
/*     */     
/* 198 */     float speed = clickgui ? 2000.0F : 1000.0F; float hue;
/* 199 */     for (hue = (float)(System.currentTimeMillis() % (int)speed + yOffset); hue > speed; hue -= speed);
/*     */     
/* 201 */     hue /= speed;
/* 202 */     if (f > 0.5D) {
/* 203 */       hue = 0.5F - hue - 0.5F;
/*     */     }
/* 205 */     return Color.getHSBColor(hue += 0.5F, 0.4F, 1.0F);
/*     */   }
/*     */   
/*     */   public static String stripColor(String name) {
/* 209 */     return COLOR_PATTERN.matcher(name).replaceAll("");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\Ur\PaletteHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */