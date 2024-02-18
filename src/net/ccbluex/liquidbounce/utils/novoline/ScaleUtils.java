/*     */ package net.ccbluex.liquidbounce.utils.novoline;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.NumberFormat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScaleUtils
/*     */ {
/*  15 */   static Color startColor = new Color(-393028);
/*  16 */   static Color endColor = new Color(-16718593);
/*     */   
/*     */   public static Color blend(Color color1, Color color2, double ratio) {
/*  19 */     float r = (float)ratio;
/*  20 */     float ir = 1.0F - r;
/*  21 */     float[] rgb1 = new float[3];
/*  22 */     float[] rgb2 = new float[3];
/*  23 */     color1.getColorComponents(rgb1);
/*  24 */     color2.getColorComponents(rgb2);
/*  25 */     float red = rgb1[0] * r + rgb2[0] * ir;
/*  26 */     float green = rgb1[1] * r + rgb2[1] * ir;
/*  27 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/*  28 */     if (red < 0.0F) {
/*  29 */       red = 0.0F;
/*  30 */     } else if (red > 255.0F) {
/*  31 */       red = 255.0F;
/*     */     } 
/*  33 */     if (green < 0.0F) {
/*  34 */       green = 0.0F;
/*  35 */     } else if (green > 255.0F) {
/*  36 */       green = 255.0F;
/*     */     } 
/*  38 */     if (blue < 0.0F) {
/*  39 */       blue = 0.0F;
/*  40 */     } else if (blue > 255.0F) {
/*  41 */       blue = 255.0F;
/*     */     } 
/*  43 */     Color color3 = null;
/*     */     try {
/*  45 */       color3 = new Color(red, green, blue);
/*  46 */     } catch (IllegalArgumentException exp) {
/*  47 */       NumberFormat nf = NumberFormat.getNumberInstance();
/*  48 */       exp.printStackTrace();
/*     */     } 
/*  50 */     return color3;
/*     */   }
/*     */   public static void drawOutline2(float x, float y, float width, float height, float radius, float line, float offset) {
/*  53 */     enableRender2D();
/*  54 */     GL11.glLineWidth(line);
/*  55 */     GL11.glBegin(3);
/*  56 */     float edgeRadius = radius;
/*  57 */     float centerX = x + edgeRadius;
/*  58 */     float centerY = y + edgeRadius;
/*  59 */     int vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F);
/*     */     
/*  61 */     int colorI = 0;
/*     */     
/*  63 */     centerX = width;
/*  64 */     centerY = height + edgeRadius;
/*  65 */     vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F); int i;
/*  66 */     for (i = 0; i <= vertices; i++) {
/*  67 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  68 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  69 */       double angleRadians = 6.283185307179586D * i / (vertices * 4);
/*  70 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  71 */       colorI++;
/*     */     } 
/*     */     
/*  74 */     GL11.glEnd();
/*  75 */     GL11.glLineWidth(line);
/*  76 */     GL11.glBegin(3);
/*  77 */     centerX = width + edgeRadius;
/*  78 */     centerY = height + edgeRadius;
/*  79 */     for (i = 0; i <= height - y; i++) {
/*  80 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  81 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  82 */       GL11.glVertex2d(centerX, (centerY - i));
/*  83 */       colorI++;
/*     */     } 
/*  85 */     GL11.glEnd();
/*  86 */     GL11.glLineWidth(line);
/*  87 */     GL11.glBegin(3);
/*  88 */     centerX = width;
/*  89 */     centerY = y + edgeRadius;
/*  90 */     for (i = 0; i <= vertices; i++) {
/*  91 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  92 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  93 */       double angleRadians = 6.283185307179586D * (i + 90) / (vertices * 4);
/*  94 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  95 */       colorI++;
/*     */     } 
/*  97 */     GL11.glEnd();
/*  98 */     GL11.glLineWidth(line);
/*  99 */     GL11.glBegin(3);
/* 100 */     centerX = width;
/* 101 */     centerY = y;
/* 102 */     for (i = 0; i <= width - x; i++) {
/* 103 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 104 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 105 */       GL11.glVertex2d((centerX - i), centerY);
/* 106 */       colorI++;
/*     */     } 
/* 108 */     GL11.glEnd();
/* 109 */     GL11.glLineWidth(line);
/* 110 */     GL11.glBegin(3);
/* 111 */     centerX = x;
/* 112 */     centerY = y + edgeRadius;
/* 113 */     for (i = 0; i <= vertices; i++) {
/* 114 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 115 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/* 116 */       colorI++;
/*     */     } 
/* 118 */     colorI = 0;
/* 119 */     GL11.glEnd();
/* 120 */     GL11.glLineWidth(line);
/* 121 */     GL11.glBegin(3);
/* 122 */     centerX = width;
/* 123 */     centerY = height + vertices + offset;
/* 124 */     for (i = 0; i <= width - x; i++) {
/* 125 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 126 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 127 */       GL11.glVertex2d((centerX - i), centerY);
/* 128 */       colorI++;
/*     */     } 
/* 130 */     GL11.glEnd();
/* 131 */     GL11.glLineWidth(line);
/* 132 */     GL11.glBegin(3);
/* 133 */     centerX = x;
/* 134 */     centerY = height + edgeRadius;
/* 135 */     for (i = 0; i <= vertices; i++) {
/* 136 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 137 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 138 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 139 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY - Math.cos(angleRadians) * edgeRadius);
/* 140 */       colorI++;
/*     */     } 
/* 142 */     GL11.glEnd();
/* 143 */     GL11.glLineWidth(line);
/* 144 */     GL11.glBegin(3);
/* 145 */     centerX = x - edgeRadius;
/* 146 */     centerY = height + edgeRadius;
/*     */     
/* 148 */     for (i = 0; i <= height - y; i++) {
/* 149 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 150 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 151 */       GL11.glVertex2d(centerX, (centerY - i));
/* 152 */       colorI++;
/*     */     } 
/* 154 */     GL11.glEnd();
/* 155 */     disableRender2D();
/*     */   }
/*     */   
/*     */   public static void setColor(int colorHex) {
/* 159 */     float alpha = (colorHex >> 24 & 0xFF) / 255.0F;
/* 160 */     float red = (colorHex >> 16 & 0xFF) / 255.0F;
/* 161 */     float green = (colorHex >> 8 & 0xFF) / 255.0F;
/* 162 */     float blue = (colorHex & 0xFF) / 255.0F;
/* 163 */     GL11.glColor4f(red, green, blue, alpha);
/*     */   }
/*     */   public static int fadeBetween(int startColour, int endColour, double progress) {
/* 166 */     if (progress > 1.0D) progress = 1.0D - progress % 1.0D; 
/* 167 */     return fadeTo(startColour, endColour, progress);
/*     */   }
/*     */   
/*     */   public static int fadeBetween(int startColour, int endColour, long offset) {
/* 171 */     return fadeBetween(startColour, endColour, ((System.currentTimeMillis() + offset) % 2000L) / 1000.0D);
/*     */   }
/*     */   
/*     */   public static int fadeBetween(int startColour, int endColour) {
/* 175 */     return fadeBetween(startColour, endColour, 0L);
/*     */   }
/*     */   
/*     */   public static int fadeTo(int startColour, int endColour, double progress) {
/* 179 */     double invert = 1.0D - progress;
/* 180 */     int r = (int)((startColour >> 16 & 0xFF) * invert + (endColour >> 16 & 0xFF) * progress);
/*     */     
/* 182 */     int g = (int)((startColour >> 8 & 0xFF) * invert + (endColour >> 8 & 0xFF) * progress);
/*     */     
/* 184 */     int b = (int)((startColour & 0xFF) * invert + (endColour & 0xFF) * progress);
/*     */     
/* 186 */     int a = (int)((startColour >> 24 & 0xFF) * invert + (endColour >> 24 & 0xFF) * progress);
/*     */     
/* 188 */     return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void enableRender2D() {
/* 195 */     GL11.glEnable(3042);
/* 196 */     GL11.glDisable(2884);
/* 197 */     GL11.glDisable(3553);
/* 198 */     GL11.glEnable(2848);
/* 199 */     GL11.glShadeModel(7425);
/* 200 */     GL11.glBlendFunc(770, 771);
/* 201 */     GL11.glPushMatrix();
/*     */   }
/*     */   
/*     */   public static void disableRender2D() {
/* 205 */     GL11.glPopMatrix();
/*     */     
/* 207 */     GL11.glDisable(3042);
/* 208 */     GL11.glEnable(2884);
/* 209 */     GL11.glEnable(3553);
/* 210 */     GL11.glDisable(2848);
/* 211 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 212 */     GlStateManager.func_179103_j(7424);
/* 213 */     GlStateManager.func_179084_k();
/* 214 */     GlStateManager.func_179098_w();
/*     */   }
/*     */   public static int[] getScaledMouseCoordinates(Minecraft mc, int mouseX, int mouseY) {
/* 217 */     int x = mouseX;
/* 218 */     int y = mouseY;
/* 219 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 221 */         x <<= 1;
/* 222 */         y <<= 1;
/*     */         break;
/*     */       case 1:
/* 225 */         x = (int)(x * 0.5D);
/* 226 */         y = (int)(y * 0.5D);
/*     */         break;
/*     */       case 3:
/* 229 */         x = (int)(x * 1.5D);
/* 230 */         y = (int)(y * 1.5D); break;
/*     */     } 
/* 232 */     return new int[] { x, y };
/*     */   }
/*     */ 
/*     */   
/*     */   public static double[] getScaledMouseCoordinates(Minecraft mc, double mouseX, double mouseY) {
/* 237 */     double x = mouseX;
/* 238 */     double y = mouseY;
/* 239 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 241 */         x *= 2.0D;
/* 242 */         y *= 2.0D;
/*     */         break;
/*     */       case 1:
/* 245 */         x *= 0.5D;
/* 246 */         y *= 0.5D;
/*     */         break;
/*     */       case 3:
/* 249 */         x *= 1.5D;
/* 250 */         y *= 1.5D; break;
/*     */     } 
/* 252 */     return new double[] { x, y };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void scale(Minecraft mc) {
/* 258 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 260 */         GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/*     */         break;
/*     */       case 1:
/* 263 */         GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
/*     */         break;
/*     */       case 3:
/* 266 */         GlStateManager.func_179139_a(0.6666666666666667D, 0.6666666666666667D, 0.6666666666666667D);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\novoline\ScaleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */