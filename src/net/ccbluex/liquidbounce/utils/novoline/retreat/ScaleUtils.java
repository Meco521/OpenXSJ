/*     */ package net.ccbluex.liquidbounce.utils.novoline.retreat;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.NumberFormat;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScaleUtils
/*     */ {
/*     */   public static void drawOutline(float x, float y, float width, float height, float radius, float line, float offset) {
/*  22 */     enableRender2D();
/*  23 */     GL11.glLineWidth(line);
/*  24 */     GL11.glBegin(3);
/*  25 */     float edgeRadius = radius;
/*  26 */     float centerX = x + edgeRadius;
/*  27 */     float centerY = y + edgeRadius;
/*  28 */     int vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F);
/*     */     
/*  30 */     int colorI = 0;
/*     */     
/*  32 */     centerX = width;
/*  33 */     centerY = height + edgeRadius;
/*  34 */     vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F); int i;
/*  35 */     for (i = 0; i <= vertices; i++) {
/*  36 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/*  37 */       double angleRadians = 6.283185307179586D * i / (vertices * 4);
/*  38 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  39 */       colorI++;
/*     */     } 
/*     */     
/*  42 */     GL11.glEnd();
/*  43 */     GL11.glLineWidth(line);
/*  44 */     GL11.glBegin(3);
/*  45 */     centerX = width + edgeRadius;
/*  46 */     centerY = height + edgeRadius;
/*  47 */     for (i = 0; i <= height - y; i++) {
/*  48 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/*  49 */       GL11.glVertex2d(centerX, (centerY - i));
/*  50 */       colorI++;
/*     */     } 
/*  52 */     GL11.glEnd();
/*  53 */     GL11.glLineWidth(line);
/*  54 */     GL11.glBegin(3);
/*  55 */     centerX = width;
/*  56 */     centerY = y + edgeRadius;
/*  57 */     for (i = 0; i <= vertices; i++) {
/*  58 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/*  59 */       double angleRadians = 6.283185307179586D * (i + 90) / (vertices * 4);
/*  60 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  61 */       colorI++;
/*     */     } 
/*  63 */     GL11.glEnd();
/*  64 */     GL11.glLineWidth(line);
/*  65 */     GL11.glBegin(3);
/*  66 */     centerX = width;
/*  67 */     centerY = y;
/*  68 */     for (i = 0; i <= width - x; i++) {
/*  69 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/*  70 */       GL11.glVertex2d((centerX - i), centerY);
/*  71 */       colorI++;
/*     */     } 
/*  73 */     GL11.glEnd();
/*  74 */     GL11.glLineWidth(line);
/*  75 */     GL11.glBegin(3);
/*  76 */     centerX = x;
/*  77 */     centerY = y + edgeRadius;
/*  78 */     for (i = 0; i <= vertices; i++) {
/*  79 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/*  80 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/*  81 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  82 */       colorI++;
/*     */     } 
/*  84 */     colorI = 0;
/*  85 */     GL11.glEnd();
/*  86 */     GL11.glLineWidth(line);
/*  87 */     GL11.glBegin(3);
/*  88 */     centerX = width;
/*  89 */     centerY = height + vertices + offset;
/*  90 */     for (i = 0; i <= width - x; i++) {
/*  91 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/*  92 */       GL11.glVertex2d((centerX - i), centerY);
/*  93 */       colorI++;
/*     */     } 
/*  95 */     GL11.glEnd();
/*  96 */     GL11.glLineWidth(line);
/*  97 */     GL11.glBegin(3);
/*  98 */     centerX = x;
/*  99 */     centerY = height + edgeRadius;
/* 100 */     for (i = 0; i <= vertices; i++) {
/* 101 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 102 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 103 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY - Math.cos(angleRadians) * edgeRadius);
/* 104 */       colorI++;
/*     */     } 
/* 106 */     GL11.glEnd();
/* 107 */     GL11.glLineWidth(line);
/* 108 */     GL11.glBegin(3);
/* 109 */     centerX = x - edgeRadius;
/* 110 */     centerY = height + edgeRadius;
/*     */     
/* 112 */     for (i = 0; i <= height - y; i++) {
/* 113 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 114 */       GL11.glVertex2d(centerX, (centerY - i));
/* 115 */       colorI++;
/*     */     } 
/* 117 */     GL11.glEnd();
/* 118 */     disableRender2D();
/*     */   }
/*     */   public static Color blend(Color color1, Color color2, double ratio) {
/* 121 */     float r = (float)ratio;
/* 122 */     float ir = 1.0F - r;
/* 123 */     float[] rgb1 = new float[3];
/* 124 */     float[] rgb2 = new float[3];
/* 125 */     color1.getColorComponents(rgb1);
/* 126 */     color2.getColorComponents(rgb2);
/* 127 */     float red = rgb1[0] * r + rgb2[0] * ir;
/* 128 */     float green = rgb1[1] * r + rgb2[1] * ir;
/* 129 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/* 130 */     if (red < 0.0F) {
/* 131 */       red = 0.0F;
/* 132 */     } else if (red > 255.0F) {
/* 133 */       red = 255.0F;
/*     */     } 
/* 135 */     if (green < 0.0F) {
/* 136 */       green = 0.0F;
/* 137 */     } else if (green > 255.0F) {
/* 138 */       green = 255.0F;
/*     */     } 
/* 140 */     if (blue < 0.0F) {
/* 141 */       blue = 0.0F;
/* 142 */     } else if (blue > 255.0F) {
/* 143 */       blue = 255.0F;
/*     */     } 
/* 145 */     Color color3 = null;
/*     */     try {
/* 147 */       color3 = new Color(red, green, blue);
/* 148 */     } catch (IllegalArgumentException exp) {
/* 149 */       NumberFormat nf = NumberFormat.getNumberInstance();
/* 150 */       exp.printStackTrace();
/*     */     } 
/* 152 */     return color3;
/*     */   }
/*     */   
/*     */   public static void setColor(int colorHex) {
/* 156 */     float alpha = (colorHex >> 24 & 0xFF) / 255.0F;
/* 157 */     float red = (colorHex >> 16 & 0xFF) / 255.0F;
/* 158 */     float green = (colorHex >> 8 & 0xFF) / 255.0F;
/* 159 */     float blue = (colorHex & 0xFF) / 255.0F;
/* 160 */     GL11.glColor4f(red, green, blue, alpha);
/*     */   }
/*     */   public static int fadeBetween(int startColour, int endColour, double progress) {
/* 163 */     if (progress > 1.0D) progress = 1.0D - progress % 1.0D; 
/* 164 */     return fadeTo(startColour, endColour, progress);
/*     */   }
/*     */   
/*     */   public static int fadeBetween(int startColour, int endColour, long offset) {
/* 168 */     return fadeBetween(startColour, endColour, ((System.currentTimeMillis() + offset) % 2000L) / 1000.0D);
/*     */   }
/*     */   
/*     */   public static int fadeBetween(int startColour, int endColour) {
/* 172 */     return fadeBetween(startColour, endColour, 0L);
/*     */   }
/*     */   
/*     */   public static int fadeTo(int startColour, int endColour, double progress) {
/* 176 */     double invert = 1.0D - progress;
/* 177 */     int r = (int)((startColour >> 16 & 0xFF) * invert + (endColour >> 16 & 0xFF) * progress);
/*     */     
/* 179 */     int g = (int)((startColour >> 8 & 0xFF) * invert + (endColour >> 8 & 0xFF) * progress);
/*     */     
/* 181 */     int b = (int)((startColour & 0xFF) * invert + (endColour & 0xFF) * progress);
/*     */     
/* 183 */     int a = (int)((startColour >> 24 & 0xFF) * invert + (endColour >> 24 & 0xFF) * progress);
/*     */     
/* 185 */     return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void enableRender2D() {
/* 192 */     GL11.glEnable(3042);
/* 193 */     GL11.glDisable(2884);
/* 194 */     GL11.glDisable(3553);
/* 195 */     GL11.glEnable(2848);
/* 196 */     GL11.glShadeModel(7425);
/* 197 */     GL11.glBlendFunc(770, 771);
/* 198 */     GL11.glPushMatrix();
/*     */   }
/*     */   
/*     */   public static void disableRender2D() {
/* 202 */     GL11.glPopMatrix();
/*     */     
/* 204 */     GL11.glDisable(3042);
/* 205 */     GL11.glEnable(2884);
/* 206 */     GL11.glEnable(3553);
/* 207 */     GL11.glDisable(2848);
/* 208 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 209 */     GlStateManager.func_179103_j(7424);
/* 210 */     GlStateManager.func_179084_k();
/* 211 */     GlStateManager.func_179098_w();
/*     */   }
/*     */   public static int[] getScaledMouseCoordinates(Minecraft mc, int mouseX, int mouseY) {
/* 214 */     int x = mouseX;
/* 215 */     int y = mouseY;
/* 216 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 218 */         x <<= 1;
/* 219 */         y <<= 1;
/*     */         break;
/*     */       case 1:
/* 222 */         x = (int)(x * 0.5D);
/* 223 */         y = (int)(y * 0.5D);
/*     */         break;
/*     */       case 3:
/* 226 */         x = (int)(x * 1.5D);
/* 227 */         y = (int)(y * 1.5D); break;
/*     */     } 
/* 229 */     return new int[] { x, y };
/*     */   }
/*     */   public static void drawGidentOutlinedRoundedRect3(double x, double y, double width, double height, double radius, float linewidth) {
/* 232 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/* 234 */     GlStateManager.func_179147_l();
/* 235 */     GlStateManager.func_179090_x();
/* 236 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 237 */     double x1 = x + width;
/* 238 */     double y1 = y + height;
/* 239 */     int colorI = 0;
/* 240 */     GL11.glPushAttrib(0);
/* 241 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*     */     
/* 243 */     x *= 2.0D;
/* 244 */     y *= 2.0D;
/* 245 */     x1 *= 2.0D;
/* 246 */     y1 *= 2.0D;
/* 247 */     GL11.glLineWidth(linewidth);
/*     */     
/* 249 */     GL11.glDisable(3553);
/* 250 */     GL11.glEnable(2848);
/* 251 */     GL11.glBegin(2);
/*     */     
/*     */     int i;
/* 254 */     for (i = 0; i <= 90; i += 3) {
/* 255 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 256 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/* 257 */       colorI++;
/*     */     } 
/* 259 */     for (i = 0; i <= y; i += 3) {
/* 260 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 261 */       GL11.glVertex2d(x, y1 - radius);
/* 262 */       colorI++;
/*     */     } 
/*     */     
/* 265 */     for (i = 90; i <= 180; i += 3) {
/* 266 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 267 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/* 268 */       colorI++;
/*     */     } 
/* 270 */     for (i = 90; i <= 180; i += 3) {
/* 271 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 272 */       GL11.glVertex2d(x + radius, y1);
/* 273 */       colorI++;
/*     */     } 
/*     */     
/* 276 */     for (i = 0; i <= 90; i += 3) {
/* 277 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 278 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius);
/* 279 */       colorI++;
/*     */     } 
/* 281 */     for (i = 0; i <= 90; i += 3) {
/* 282 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 283 */       GL11.glVertex2d(x1, y1 - radius);
/* 284 */       colorI++;
/*     */     } 
/*     */     
/* 287 */     for (i = 90; i <= 180; i += 3) {
/* 288 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 289 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
/* 290 */       colorI++;
/*     */     } 
/*     */     
/* 293 */     for (i = 90; i <= 180; i += 3) {
/* 294 */       RenderUtils.setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 295 */       GL11.glVertex2d(x1 - radius, y);
/* 296 */       colorI++;
/*     */     } 
/*     */     
/* 299 */     GL11.glEnd();
/*     */     
/* 301 */     GL11.glEnable(3553);
/* 302 */     GL11.glDisable(2848);
/* 303 */     GL11.glEnable(3553);
/*     */     
/* 305 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/*     */     
/* 307 */     GL11.glPopAttrib();
/* 308 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 309 */     GlStateManager.func_179098_w();
/* 310 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double[] getScaledMouseCoordinates(Minecraft mc, double mouseX, double mouseY) {
/* 317 */     double x = mouseX;
/* 318 */     double y = mouseY;
/* 319 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 321 */         x *= 2.0D;
/* 322 */         y *= 2.0D;
/*     */         break;
/*     */       case 1:
/* 325 */         x *= 0.5D;
/* 326 */         y *= 0.5D;
/*     */         break;
/*     */       case 3:
/* 329 */         x *= 1.5D;
/* 330 */         y *= 1.5D; break;
/*     */     } 
/* 332 */     return new double[] { x, y };
/*     */   }
/*     */ 
/*     */   
/*     */   public static void scale(Minecraft mc) {
/* 337 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 339 */         GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/*     */         break;
/*     */       case 1:
/* 342 */         GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
/*     */         break;
/*     */       case 3:
/* 345 */         GlStateManager.func_179139_a(0.6666666666666667D, 0.6666666666666667D, 0.6666666666666667D);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\novoline\retreat\ScaleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */