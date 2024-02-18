/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VisualUtils
/*     */   extends MinecraftInstance
/*     */ {
/*     */   public static int SkyRainbow(int var2, float st, float bright) {
/*  21 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  22 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright).getRGB();
/*     */   }
/*     */   public static int width() {
/*  25 */     return (new ScaledResolution(Minecraft.func_71410_x())).func_78326_a();
/*     */   }
/*     */   public static int height() {
/*  28 */     return (new ScaledResolution(Minecraft.func_71410_x())).func_78328_b();
/*     */   }
/*     */   
/*     */   public static void color(int color) {
/*  32 */     float f = (color >> 24 & 0xFF) / 255.0F;
/*  33 */     float f1 = (color >> 16 & 0xFF) / 255.0F;
/*  34 */     float f2 = (color >> 8 & 0xFF) / 255.0F;
/*  35 */     float f3 = (color & 0xFF) / 255.0F;
/*  36 */     GL11.glColor4f(f1, f2, f3, f);
/*     */   }
/*     */   public static void drawRect(double x, double y, double x2, double y2, int color) {
/*  39 */     Gui.func_73734_a((int)x, (int)y, (int)x2, (int)y2, color);
/*     */   }
/*     */   public static int getRainbow(int index, int offset, float bright, float st) {
/*  42 */     float hue = (float)((System.currentTimeMillis() + offset * index) % 2000L);
/*  43 */     return Color.getHSBColor(hue /= 2000.0F, st, bright).getRGB();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color getGradientOffset3(Color color1, Color color2, double offset) {
/*  48 */     if (offset > 1.0D) {
/*  49 */       double d = offset % 1.0D;
/*  50 */       int i = (int)offset;
/*  51 */       offset = (i % 2 == 0) ? d : (1.0D - d);
/*     */     } 
/*     */     
/*  54 */     double inverse_percent = 1.0D - offset;
/*  55 */     int redPart = (int)(color1.getRed() * inverse_percent + color2.getRed() * offset);
/*  56 */     int greenPart = (int)(color1.getGreen() * inverse_percent + color2.getGreen() * offset);
/*  57 */     int bluePart = (int)(color1.getBlue() * inverse_percent + color2.getBlue() * offset);
/*  58 */     int alpha = color1.getAlpha() + color2.getAlpha();
/*  59 */     return new Color(redPart, greenPart, bluePart, alpha);
/*     */   }
/*     */   public static Color skyRainbow(int var2, float st, float bright) {
/*  62 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  63 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*     */   }
/*     */   public static int Astolfo(int var2, float bright, float st, int index, int offset, float client) {
/*  66 */     double rainbowDelay = Math.ceil((System.currentTimeMillis() + (var2 * index))) / offset;
/*  67 */     return Color.getHSBColor(((float)((rainbowDelay %= client) / client) < 0.5D) ? -((float)(rainbowDelay / client)) : (float)(rainbowDelay / client), st, bright).getRGB();
/*     */   }
/*     */   public static int getRainbowOpaque(int seconds, float saturation, float brightness, int index) {
/*  70 */     float hue = (float)((System.currentTimeMillis() + index) % (seconds * 1000)) / (seconds * 1000);
/*  71 */     int color = Color.HSBtoRGB(hue, saturation, brightness);
/*  72 */     return color;
/*     */   }
/*     */   
/*     */   public static int getNormalRainbow(int delay, float sat, float brg) {
/*  76 */     double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0D);
/*  77 */     rainbowState %= 360.0D;
/*  78 */     return Color.getHSBColor((float)(rainbowState / 360.0D), sat, brg).getRGB();
/*     */   }
/*     */   
/*     */   public static void glColor(int cl) {
/*  82 */     float alpha = (cl >> 24 & 0xFF) / 255.0F;
/*  83 */     float red = (cl >> 16 & 0xFF) / 255.0F;
/*  84 */     float green = (cl >> 8 & 0xFF) / 255.0F;
/*  85 */     float blue = (cl & 0xFF) / 255.0F;
/*     */     
/*  87 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static void glColor(int red, int green, int blue, int alpha) {
/*  91 */     GlStateManager.func_179131_c(red / 255.0F, green / 255.0F, blue / 255.0F, alpha / 255.0F);
/*     */   }
/*     */   
/*     */   public static void glColor(Color color) {
/*  95 */     float red = color.getRed() / 255.0F;
/*  96 */     float green = color.getGreen() / 255.0F;
/*  97 */     float blue = color.getBlue() / 255.0F;
/*  98 */     float alpha = color.getAlpha() / 255.0F;
/*     */     
/* 100 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static void glColor(int hex, int alpha) {
/* 104 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 105 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 106 */     float blue = (hex & 0xFF) / 255.0F;
/*     */     
/* 108 */     GlStateManager.func_179131_c(red, green, blue, alpha / 255.0F);
/*     */   }
/*     */   
/*     */   public static void glColor(int hex, float alpha) {
/* 112 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 113 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 114 */     float blue = (hex & 0xFF) / 255.0F;
/*     */     
/* 116 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static void glColor(Color color, float alpha) {
/* 120 */     float red = color.getRed() / 255.0F;
/* 121 */     float green = color.getGreen() / 255.0F;
/* 122 */     float blue = color.getBlue() / 255.0F;
/*     */     
/* 124 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static Color reAlpha(Color cIn, float alpha) {
/* 128 */     return new Color(cIn.getRed() / 255.0F, cIn.getGreen() / 255.0F, cIn.getBlue() / 255.0F, cIn.getAlpha() / 255.0F * alpha);
/*     */   }
/*     */   public static Color reAlpha(Color cIn, int alpha) {
/* 131 */     return new Color(cIn.getRed() / 255.0F, cIn.getGreen() / 255.0F, cIn.getBlue() / 255.0F, cIn.getAlpha() / 255.0F * alpha);
/*     */   }
/*     */   public static int reAlpha(int n, float n2) {
/* 134 */     Color color = new Color(n);
/* 135 */     return (new Color(0.003921569F * color.getRed(), 0.003921569F * color.getGreen(), 0.003921569F * color.getBlue(), n2)).getRGB();
/*     */   }
/*     */   private static void quickPolygonCircle(float x, float y, float xRadius, float yRadius, int start, int end, int split) {
/*     */     int i;
/* 139 */     for (i = end; i >= start; i -= split) {
/* 140 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * xRadius, y + Math.cos(i * Math.PI / 180.0D) * yRadius);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawCircleRect(float x, float y, float x1, float y1, float radius, int color) {
/* 145 */     glColor(color);
/* 146 */     GL11.glEnable(3042);
/* 147 */     GL11.glDisable(3553);
/* 148 */     GL11.glDisable(2884);
/* 149 */     GL11.glBlendFunc(770, 771);
/* 150 */     GL11.glEnable(2848);
/* 151 */     GL11.glPushMatrix();
/* 152 */     GL11.glLineWidth(1.0F);
/* 153 */     GL11.glBegin(9);
/*     */     
/* 155 */     float xRadius = (float)Math.min((x1 - x) * 0.5D, radius);
/* 156 */     float yRadius = (float)Math.min((y1 - y) * 0.5D, radius);
/* 157 */     quickPolygonCircle(x + xRadius, y + yRadius, xRadius, yRadius, 180, 270, 4);
/* 158 */     quickPolygonCircle(x1 - xRadius, y + yRadius, xRadius, yRadius, 90, 180, 4);
/* 159 */     quickPolygonCircle(x1 - xRadius, y1 - yRadius, xRadius, yRadius, 0, 90, 4);
/* 160 */     quickPolygonCircle(x + xRadius, y1 - yRadius, xRadius, yRadius, 270, 360, 4);
/*     */     
/* 162 */     GL11.glEnd();
/* 163 */     GL11.glPopMatrix();
/* 164 */     GL11.glEnable(3553);
/* 165 */     GL11.glEnable(2884);
/* 166 */     GL11.glDisable(2848);
/* 167 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void drawShadow(int x, int y, int width, int height) {
/* 171 */     ScaledResolution sr = new ScaledResolution((Minecraft)mc);
/* 172 */     drawTexturedRect(x - 9, y - 9, 9, 9, "paneltopleft", sr);
/* 173 */     drawTexturedRect(x - 9, y + height, 9, 9, "panelbottomleft", sr);
/* 174 */     drawTexturedRect(x + width, y + height, 9, 9, "panelbottomright", sr);
/* 175 */     drawTexturedRect(x + width, y - 9, 9, 9, "paneltopright", sr);
/* 176 */     drawTexturedRect(x - 9, y, 9, height, "panelleft", sr);
/* 177 */     drawTexturedRect(x + width, y, 9, height, "panelright", sr);
/* 178 */     drawTexturedRect(x, y - 9, width, 9, "paneltop", sr);
/* 179 */     drawTexturedRect(x, y + height, width, 9, "panelbottom", sr);
/*     */   }
/*     */   
/*     */   public static void drawTexturedRect(int x, int y, int width, int height, String image, ScaledResolution sr) {
/* 183 */     GL11.glPushMatrix();
/* 184 */     GlStateManager.func_179147_l();
/* 185 */     GlStateManager.func_179118_c();
/* 186 */     mc.getTextureManager().bindTexture(classProvider.createResourceLocation("liquidbounce/shadow/" + image + ".png"));
/* 187 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 188 */     Gui.func_146110_a(x, y, 0.0F, 0.0F, width, height, width, height);
/* 189 */     GlStateManager.func_179084_k();
/* 190 */     GlStateManager.func_179141_d();
/* 191 */     GL11.glPopMatrix();
/*     */   }
/*     */   public static Color getGradientOffset2(Color color1, Color color2, double gident) {
/* 194 */     if (gident > 1.0D) {
/* 195 */       double f1 = gident % 1.0D;
/* 196 */       int f2 = (int)gident;
/* 197 */       gident = (f2 % 2 == 0) ? f1 : (1.0D - f1);
/*     */     } 
/* 199 */     double f3 = 1.0D - gident;
/* 200 */     int f4 = (int)(color1.getRed() * f3 + color2.getRed() * gident);
/* 201 */     int f5 = (int)(color1.getGreen() * f3 + color2.getGreen() * gident);
/* 202 */     int f6 = (int)(color1.getBlue() * f3 + color2.getBlue() * gident);
/* 203 */     return new Color(f4, f5, f6);
/*     */   }
/*     */   
/*     */   public static Color getGradientOffset(Color color1, Color color2, double index) {
/* 207 */     double offs = Math.abs(System.currentTimeMillis() / 16.0D) / 60.0D + index;
/* 208 */     if (offs > 1.0D) {
/*     */       
/* 210 */       double left = offs % 1.0D;
/* 211 */       int off = (int)offs;
/* 212 */       offs = (off % 2 == 0) ? left : (1.0D - left);
/*     */     } 
/*     */     
/* 215 */     double inverse_percent = 1.0D - offs;
/* 216 */     int redPart = (int)(color1.getRed() * inverse_percent + color2.getRed() * offs);
/* 217 */     int greenPart = (int)(color1.getGreen() * inverse_percent + color2.getGreen() * offs);
/* 218 */     int bluePart = (int)(color1.getBlue() * inverse_percent + color2.getBlue() * offs);
/* 219 */     int alphaPart = (int)(color1.getAlpha() * inverse_percent + color2.getAlpha() * offs);
/* 220 */     return new Color(redPart, greenPart, bluePart, alphaPart);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\VisualUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */