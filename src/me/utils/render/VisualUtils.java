/*     */ package me.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
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
/*     */ public class VisualUtils
/*     */   extends MinecraftInstance
/*     */ {
/*     */   public static int SkyRainbow(int var2, float st, float bright) {
/*  21 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  22 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright).getRGB();
/*     */   }
/*     */   public static int getRainbow(int index, int offset, float bright, float st) {
/*  25 */     float hue = (float)((System.currentTimeMillis() + offset * index) % 2000L);
/*  26 */     return Color.getHSBColor(hue /= 2000.0F, st, bright).getRGB();
/*     */   }
/*     */   public static Color skyRainbow(int var2, float st, float bright) {
/*  29 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  30 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*     */   }
/*     */   public static int Astolfo(int var2, float bright, float st, int index, int offset, float client) {
/*  33 */     double rainbowDelay = Math.ceil((System.currentTimeMillis() + (var2 * index))) / offset;
/*  34 */     return Color.getHSBColor(((float)((rainbowDelay %= client) / client) < 0.5D) ? -((float)(rainbowDelay / client)) : (float)(rainbowDelay / client), st, bright).getRGB();
/*     */   }
/*     */   public static int getRainbowOpaque(int seconds, float saturation, float brightness, int index) {
/*  37 */     float hue = (float)((System.currentTimeMillis() + index) % (seconds * 1000)) / (seconds * 1000);
/*  38 */     int color = Color.HSBtoRGB(hue, saturation, brightness);
/*  39 */     return color;
/*     */   }
/*     */   
/*     */   public static int getNormalRainbow(int delay, float sat, float brg) {
/*  43 */     double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0D);
/*  44 */     rainbowState %= 360.0D;
/*  45 */     return Color.getHSBColor((float)(rainbowState / 360.0D), sat, brg).getRGB();
/*     */   }
/*     */   
/*     */   public static void glColor(int cl) {
/*  49 */     float alpha = (cl >> 24 & 0xFF) / 255.0F;
/*  50 */     float red = (cl >> 16 & 0xFF) / 255.0F;
/*  51 */     float green = (cl >> 8 & 0xFF) / 255.0F;
/*  52 */     float blue = (cl & 0xFF) / 255.0F;
/*     */     
/*  54 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static void glColor(int red, int green, int blue, int alpha) {
/*  58 */     GlStateManager.func_179131_c(red / 255.0F, green / 255.0F, blue / 255.0F, alpha / 255.0F);
/*     */   }
/*     */   
/*     */   public static void glColor(Color color) {
/*  62 */     float red = color.getRed() / 255.0F;
/*  63 */     float green = color.getGreen() / 255.0F;
/*  64 */     float blue = color.getBlue() / 255.0F;
/*  65 */     float alpha = color.getAlpha() / 255.0F;
/*     */     
/*  67 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static void glColor(int hex, int alpha) {
/*  71 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/*  72 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/*  73 */     float blue = (hex & 0xFF) / 255.0F;
/*     */     
/*  75 */     GlStateManager.func_179131_c(red, green, blue, alpha / 255.0F);
/*     */   }
/*     */   
/*     */   public static void glColor(int hex, float alpha) {
/*  79 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/*  80 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/*  81 */     float blue = (hex & 0xFF) / 255.0F;
/*     */     
/*  83 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static void glColor(Color color, float alpha) {
/*  87 */     float red = color.getRed() / 255.0F;
/*  88 */     float green = color.getGreen() / 255.0F;
/*  89 */     float blue = color.getBlue() / 255.0F;
/*     */     
/*  91 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*     */   }
/*     */   
/*     */   public static Color reAlpha(Color cIn, float alpha) {
/*  95 */     return new Color(cIn.getRed() / 255.0F, cIn.getGreen() / 255.0F, cIn.getBlue() / 255.0F, cIn.getAlpha() / 255.0F * alpha);
/*     */   }
/*     */   public static Color reAlpha(Color cIn, int alpha) {
/*  98 */     return new Color(cIn.getRed() / 255.0F, cIn.getGreen() / 255.0F, cIn.getBlue() / 255.0F, cIn.getAlpha() / 255.0F * alpha);
/*     */   }
/*     */   public static int reAlpha(int n, float n2) {
/* 101 */     Color color = new Color(n);
/* 102 */     return (new Color(0.003921569F * color.getRed(), 0.003921569F * color.getGreen(), 0.003921569F * color.getBlue(), n2)).getRGB();
/*     */   }
/*     */   private static void quickPolygonCircle(float x, float y, float xRadius, float yRadius, int start, int end, int split) {
/*     */     int i;
/* 106 */     for (i = end; i >= start; i -= split) {
/* 107 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * xRadius, y + Math.cos(i * Math.PI / 180.0D) * yRadius);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawCircleRect(float x, float y, float x1, float y1, float radius, int color) {
/* 112 */     glColor(color);
/* 113 */     GL11.glEnable(3042);
/* 114 */     GL11.glDisable(3553);
/* 115 */     GL11.glDisable(2884);
/* 116 */     GL11.glBlendFunc(770, 771);
/* 117 */     GL11.glEnable(2848);
/* 118 */     GL11.glPushMatrix();
/* 119 */     GL11.glLineWidth(1.0F);
/* 120 */     GL11.glBegin(9);
/*     */     
/* 122 */     float xRadius = (float)Math.min((x1 - x) * 0.5D, radius);
/* 123 */     float yRadius = (float)Math.min((y1 - y) * 0.5D, radius);
/* 124 */     quickPolygonCircle(x + xRadius, y + yRadius, xRadius, yRadius, 180, 270, 4);
/* 125 */     quickPolygonCircle(x1 - xRadius, y + yRadius, xRadius, yRadius, 90, 180, 4);
/* 126 */     quickPolygonCircle(x1 - xRadius, y1 - yRadius, xRadius, yRadius, 0, 90, 4);
/* 127 */     quickPolygonCircle(x + xRadius, y1 - yRadius, xRadius, yRadius, 270, 360, 4);
/*     */     
/* 129 */     GL11.glEnd();
/* 130 */     GL11.glPopMatrix();
/* 131 */     GL11.glEnable(3553);
/* 132 */     GL11.glEnable(2884);
/* 133 */     GL11.glDisable(2848);
/* 134 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void drawShadow(int x, int y, int width, int height) {
/* 138 */     ScaledResolution sr = new ScaledResolution((Minecraft)mc);
/* 139 */     drawTexturedRect(x - 9, y - 9, 9, 9, "paneltopleft", sr);
/* 140 */     drawTexturedRect(x - 9, y + height, 9, 9, "panelbottomleft", sr);
/* 141 */     drawTexturedRect(x + width, y + height, 9, 9, "panelbottomright", sr);
/* 142 */     drawTexturedRect(x + width, y - 9, 9, 9, "paneltopright", sr);
/* 143 */     drawTexturedRect(x - 9, y, 9, height, "panelleft", sr);
/* 144 */     drawTexturedRect(x + width, y, 9, height, "panelright", sr);
/* 145 */     drawTexturedRect(x, y - 9, width, 9, "paneltop", sr);
/* 146 */     drawTexturedRect(x, y + height, width, 9, "panelbottom", sr);
/*     */   }
/*     */   
/*     */   public static void drawTexturedRect(int x, int y, int width, int height, String image, ScaledResolution sr) {
/* 150 */     GL11.glPushMatrix();
/* 151 */     GlStateManager.func_179147_l();
/* 152 */     GlStateManager.func_179118_c();
/* 153 */     mc.getTextureManager().bindTexture(classProvider.createResourceLocation("pride/shadow/" + image + ".png"));
/* 154 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 155 */     Gui.func_146110_a(x, y, 0.0F, 0.0F, width, height, width, height);
/* 156 */     GlStateManager.func_179084_k();
/* 157 */     GlStateManager.func_179141_d();
/* 158 */     GL11.glPopMatrix();
/*     */   }
/*     */   public static Color getGradientOffset2(Color color1, Color color2, double gident) {
/* 161 */     if (gident > 1.0D) {
/* 162 */       double f1 = gident % 1.0D;
/* 163 */       int f2 = (int)gident;
/* 164 */       gident = (f2 % 2 == 0) ? f1 : (1.0D - f1);
/*     */     } 
/* 166 */     double f3 = 1.0D - gident;
/* 167 */     int f4 = (int)(color1.getRed() * f3 + color2.getRed() * gident);
/* 168 */     int f5 = (int)(color1.getGreen() * f3 + color2.getGreen() * gident);
/* 169 */     int f6 = (int)(color1.getBlue() * f3 + color2.getBlue() * gident);
/* 170 */     return new Color(f4, f5, f6);
/*     */   }
/*     */   
/*     */   public static Color getGradientOffset(Color color1, Color color2, double index) {
/* 174 */     double offs = Math.abs(System.currentTimeMillis() / 16.0D) / 60.0D + index;
/* 175 */     if (offs > 1.0D) {
/*     */       
/* 177 */       double left = offs % 1.0D;
/* 178 */       int off = (int)offs;
/* 179 */       offs = (off % 2 == 0) ? left : (1.0D - left);
/*     */     } 
/*     */     
/* 182 */     double inverse_percent = 1.0D - offs;
/* 183 */     int redPart = (int)(color1.getRed() * inverse_percent + color2.getRed() * offs);
/* 184 */     int greenPart = (int)(color1.getGreen() * inverse_percent + color2.getGreen() * offs);
/* 185 */     int bluePart = (int)(color1.getBlue() * inverse_percent + color2.getBlue() * offs);
/* 186 */     int alphaPart = (int)(color1.getAlpha() * inverse_percent + color2.getAlpha() * offs);
/* 187 */     return new Color(redPart, greenPart, bluePart, alphaPart);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\render\VisualUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */