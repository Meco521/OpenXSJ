/*     */ package net.ccbluex.liquidbounce.utils.novoline.onlooker;
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
/*  15 */   static Color startColor = new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue(), 255);
/*  16 */   static Color endColor = new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue(), 255);
/*     */   public static void drawOutline(float x, float y, float width, float height, float radius, float line) {
/*  18 */     enableRender2D();
/*  19 */     GL11.glLineWidth(line);
/*  20 */     GL11.glBegin(3);
/*  21 */     float edgeRadius = radius;
/*  22 */     float centerX = x + edgeRadius;
/*  23 */     float centerY = y + edgeRadius;
/*  24 */     int vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F);
/*     */     
/*  26 */     int colorI = 0;
/*     */     
/*  28 */     centerX = width;
/*  29 */     centerY = height + edgeRadius;
/*  30 */     vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F); int i;
/*  31 */     for (i = 0; i <= vertices; i++) {
/*  32 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  33 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  34 */       double angleRadians = 6.283185307179586D * i / (vertices * 4);
/*  35 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  36 */       colorI++;
/*     */     } 
/*     */     
/*  39 */     GL11.glEnd();
/*  40 */     GL11.glLineWidth(line);
/*  41 */     GL11.glBegin(3);
/*  42 */     centerX = width + edgeRadius;
/*  43 */     centerY = height + edgeRadius;
/*  44 */     for (i = 0; i <= height - y; i++) {
/*  45 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  46 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  47 */       GL11.glVertex2d(centerX, (centerY - i));
/*  48 */       colorI++;
/*     */     } 
/*  50 */     GL11.glEnd();
/*  51 */     GL11.glLineWidth(line);
/*  52 */     GL11.glBegin(3);
/*  53 */     centerX = width;
/*  54 */     centerY = y + edgeRadius;
/*  55 */     for (i = 0; i <= vertices; i++) {
/*  56 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  57 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  58 */       double angleRadians = 6.283185307179586D * (i + 90) / (vertices * 4);
/*  59 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  60 */       colorI++;
/*     */     } 
/*  62 */     GL11.glEnd();
/*  63 */     GL11.glLineWidth(line);
/*  64 */     GL11.glBegin(3);
/*  65 */     centerX = width;
/*  66 */     centerY = y;
/*  67 */     for (i = 0; i <= width - x; i++) {
/*  68 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  69 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  70 */       GL11.glVertex2d((centerX - i), centerY);
/*  71 */       colorI++;
/*     */     } 
/*  73 */     GL11.glEnd();
/*  74 */     GL11.glLineWidth(line);
/*  75 */     GL11.glBegin(3);
/*  76 */     centerX = x;
/*  77 */     centerY = y + edgeRadius;
/*  78 */     for (i = 0; i <= vertices; i++) {
/*  79 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/*  80 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  81 */       colorI++;
/*     */     } 
/*  83 */     colorI = 0;
/*  84 */     GL11.glEnd();
/*  85 */     GL11.glLineWidth(line);
/*  86 */     GL11.glBegin(3);
/*  87 */     centerX = width;
/*  88 */     centerY = height + vertices;
/*  89 */     for (i = 0; i <= width - x; i++) {
/*  90 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/*  91 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  92 */       GL11.glVertex2d((centerX - i), centerY);
/*  93 */       colorI++;
/*     */     } 
/*  95 */     GL11.glEnd();
/*  96 */     GL11.glLineWidth(line);
/*  97 */     GL11.glBegin(3);
/*  98 */     centerX = x;
/*  99 */     centerY = height + edgeRadius;
/* 100 */     for (i = 0; i <= vertices; i++) {
/* 101 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 102 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 103 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 104 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY - Math.cos(angleRadians) * edgeRadius);
/* 105 */       colorI++;
/*     */     } 
/* 107 */     GL11.glEnd();
/* 108 */     GL11.glLineWidth(line);
/* 109 */     GL11.glBegin(3);
/* 110 */     centerX = x - edgeRadius;
/* 111 */     centerY = height + edgeRadius;
/*     */     
/* 113 */     for (i = 0; i <= height - y; i++) {
/* 114 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 115 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 116 */       GL11.glVertex2d(centerX, (centerY - i));
/* 117 */       colorI++;
/*     */     } 
/* 119 */     GL11.glEnd();
/* 120 */     disableRender2D();
/*     */   }
/*     */   
/*     */   public static void drawOutline2(float x, float y, float width, float height, float radius, float line, float offset) {
/* 124 */     enableRender2D();
/* 125 */     GL11.glLineWidth(line);
/* 126 */     GL11.glBegin(3);
/* 127 */     float edgeRadius = radius;
/* 128 */     float centerX = x + edgeRadius;
/* 129 */     float centerY = y + edgeRadius;
/* 130 */     int vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F);
/*     */     
/* 132 */     int colorI = 0;
/*     */     
/* 134 */     centerX = width;
/* 135 */     centerY = height + edgeRadius;
/* 136 */     vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F); int i;
/* 137 */     for (i = 0; i <= vertices; i++) {
/* 138 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 139 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 140 */       double angleRadians = 6.283185307179586D * i / (vertices * 4);
/* 141 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/* 142 */       colorI++;
/*     */     } 
/*     */     
/* 145 */     GL11.glEnd();
/* 146 */     GL11.glLineWidth(line);
/* 147 */     GL11.glBegin(3);
/* 148 */     centerX = width + edgeRadius;
/* 149 */     centerY = height + edgeRadius;
/* 150 */     for (i = 0; i <= height - y; i++) {
/* 151 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 152 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 153 */       GL11.glVertex2d(centerX, (centerY - i));
/* 154 */       colorI++;
/*     */     } 
/* 156 */     GL11.glEnd();
/* 157 */     GL11.glLineWidth(line);
/* 158 */     GL11.glBegin(3);
/* 159 */     centerX = width;
/* 160 */     centerY = y + edgeRadius;
/* 161 */     for (i = 0; i <= vertices; i++) {
/* 162 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 163 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 164 */       double angleRadians = 6.283185307179586D * (i + 90) / (vertices * 4);
/* 165 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/* 166 */       colorI++;
/*     */     } 
/* 168 */     GL11.glEnd();
/* 169 */     GL11.glLineWidth(line);
/* 170 */     GL11.glBegin(3);
/* 171 */     centerX = width;
/* 172 */     centerY = y;
/* 173 */     for (i = 0; i <= width - x; i++) {
/* 174 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 175 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 176 */       GL11.glVertex2d((centerX - i), centerY);
/* 177 */       colorI++;
/*     */     } 
/* 179 */     GL11.glEnd();
/* 180 */     GL11.glLineWidth(line);
/* 181 */     GL11.glBegin(3);
/* 182 */     centerX = x;
/* 183 */     centerY = y + edgeRadius;
/* 184 */     for (i = 0; i <= vertices; i++) {
/* 185 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 186 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/* 187 */       colorI++;
/*     */     } 
/* 189 */     colorI = 0;
/* 190 */     GL11.glEnd();
/* 191 */     GL11.glLineWidth(line);
/* 192 */     GL11.glBegin(3);
/* 193 */     centerX = width;
/* 194 */     centerY = height + vertices + offset;
/* 195 */     for (i = 0; i <= width - x; i++) {
/* 196 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 197 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 198 */       GL11.glVertex2d((centerX - i), centerY);
/* 199 */       colorI++;
/*     */     } 
/* 201 */     GL11.glEnd();
/* 202 */     GL11.glLineWidth(line);
/* 203 */     GL11.glBegin(3);
/* 204 */     centerX = x;
/* 205 */     centerY = height + edgeRadius;
/* 206 */     for (i = 0; i <= vertices; i++) {
/* 207 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 208 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 209 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 210 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY - Math.cos(angleRadians) * edgeRadius);
/* 211 */       colorI++;
/*     */     } 
/* 213 */     GL11.glEnd();
/* 214 */     GL11.glLineWidth(line);
/* 215 */     GL11.glBegin(3);
/* 216 */     centerX = x - edgeRadius;
/* 217 */     centerY = height + edgeRadius;
/*     */     
/* 219 */     for (i = 0; i <= height - y; i++) {
/* 220 */       setColor(fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2
/* 221 */               .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 222 */       GL11.glVertex2d(centerX, (centerY - i));
/* 223 */       colorI++;
/*     */     } 
/* 225 */     GL11.glEnd();
/* 226 */     disableRender2D();
/*     */   }
/*     */   
/*     */   public static Color blend(Color color1, Color color2, double ratio) {
/* 230 */     float r = (float)ratio;
/* 231 */     float ir = 1.0F - r;
/* 232 */     float[] rgb1 = new float[3];
/* 233 */     float[] rgb2 = new float[3];
/* 234 */     color1.getColorComponents(rgb1);
/* 235 */     color2.getColorComponents(rgb2);
/* 236 */     float red = rgb1[0] * r + rgb2[0] * ir;
/* 237 */     float green = rgb1[1] * r + rgb2[1] * ir;
/* 238 */     float blue = rgb1[2] * r + rgb2[2] * ir;
/* 239 */     if (red < 0.0F) {
/* 240 */       red = 0.0F;
/* 241 */     } else if (red > 255.0F) {
/* 242 */       red = 255.0F;
/*     */     } 
/* 244 */     if (green < 0.0F) {
/* 245 */       green = 0.0F;
/* 246 */     } else if (green > 255.0F) {
/* 247 */       green = 255.0F;
/*     */     } 
/* 249 */     if (blue < 0.0F) {
/* 250 */       blue = 0.0F;
/* 251 */     } else if (blue > 255.0F) {
/* 252 */       blue = 255.0F;
/*     */     } 
/* 254 */     Color color3 = null;
/*     */     try {
/* 256 */       color3 = new Color(red, green, blue);
/* 257 */     } catch (IllegalArgumentException exp) {
/* 258 */       NumberFormat nf = NumberFormat.getNumberInstance();
/* 259 */       exp.printStackTrace();
/*     */     } 
/* 261 */     return color3;
/*     */   }
/*     */   
/*     */   public static void setColor(int colorHex) {
/* 265 */     float alpha = (colorHex >> 24 & 0xFF) / 255.0F;
/* 266 */     float red = (colorHex >> 16 & 0xFF) / 255.0F;
/* 267 */     float green = (colorHex >> 8 & 0xFF) / 255.0F;
/* 268 */     float blue = (colorHex & 0xFF) / 255.0F;
/* 269 */     GL11.glColor4f(red, green, blue, alpha);
/*     */   }
/*     */   public static int fadeBetween(int startColour, int endColour, double progress) {
/* 272 */     if (progress > 1.0D) progress = 1.0D - progress % 1.0D; 
/* 273 */     return fadeTo(startColour, endColour, progress);
/*     */   }
/*     */   
/*     */   public static int fadeBetween(int startColour, int endColour, long offset) {
/* 277 */     return fadeBetween(startColour, endColour, ((System.currentTimeMillis() + offset) % 2000L) / 1000.0D);
/*     */   }
/*     */   
/*     */   public static int fadeBetween(int startColour, int endColour) {
/* 281 */     return fadeBetween(startColour, endColour, 0L);
/*     */   }
/*     */   
/*     */   public static int fadeTo(int startColour, int endColour, double progress) {
/* 285 */     double invert = 1.0D - progress;
/* 286 */     int r = (int)((startColour >> 16 & 0xFF) * invert + (endColour >> 16 & 0xFF) * progress);
/*     */     
/* 288 */     int g = (int)((startColour >> 8 & 0xFF) * invert + (endColour >> 8 & 0xFF) * progress);
/*     */     
/* 290 */     int b = (int)((startColour & 0xFF) * invert + (endColour & 0xFF) * progress);
/*     */     
/* 292 */     int a = (int)((startColour >> 24 & 0xFF) * invert + (endColour >> 24 & 0xFF) * progress);
/*     */     
/* 294 */     return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void enableRender2D() {
/* 301 */     GL11.glEnable(3042);
/* 302 */     GL11.glDisable(2884);
/* 303 */     GL11.glDisable(3553);
/* 304 */     GL11.glEnable(2848);
/* 305 */     GL11.glShadeModel(7425);
/* 306 */     GL11.glBlendFunc(770, 771);
/* 307 */     GL11.glPushMatrix();
/*     */   }
/*     */   
/*     */   public static void disableRender2D() {
/* 311 */     GL11.glPopMatrix();
/*     */     
/* 313 */     GL11.glDisable(3042);
/* 314 */     GL11.glEnable(2884);
/* 315 */     GL11.glEnable(3553);
/* 316 */     GL11.glDisable(2848);
/* 317 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 318 */     GlStateManager.func_179103_j(7424);
/* 319 */     GlStateManager.func_179084_k();
/* 320 */     GlStateManager.func_179098_w();
/*     */   }
/*     */   public static int[] getScaledMouseCoordinates(Minecraft mc, int mouseX, int mouseY) {
/* 323 */     int x = mouseX;
/* 324 */     int y = mouseY;
/* 325 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 327 */         x <<= 1;
/* 328 */         y <<= 1;
/*     */         break;
/*     */       case 1:
/* 331 */         x = (int)(x * 0.5D);
/* 332 */         y = (int)(y * 0.5D);
/*     */         break;
/*     */       case 3:
/* 335 */         x = (int)(x * 1.5D);
/* 336 */         y = (int)(y * 1.5D); break;
/*     */     } 
/* 338 */     return new int[] { x, y };
/*     */   }
/*     */ 
/*     */   
/*     */   public static double[] getScaledMouseCoordinates(Minecraft mc, double mouseX, double mouseY) {
/* 343 */     double x = mouseX;
/* 344 */     double y = mouseY;
/* 345 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 347 */         x *= 2.0D;
/* 348 */         y *= 2.0D;
/*     */         break;
/*     */       case 1:
/* 351 */         x *= 0.5D;
/* 352 */         y *= 0.5D;
/*     */         break;
/*     */       case 3:
/* 355 */         x *= 1.5D;
/* 356 */         y *= 1.5D; break;
/*     */     } 
/* 358 */     return new double[] { x, y };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void scale(Minecraft mc) {
/* 364 */     switch (mc.field_71474_y.field_74335_Z) {
/*     */       case 0:
/* 366 */         GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/*     */         break;
/*     */       case 1:
/* 369 */         GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
/*     */         break;
/*     */       case 3:
/* 372 */         GlStateManager.func_179139_a(0.6666666666666667D, 0.6666666666666667D, 0.6666666666666667D);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\novoline\onlooker\ScaleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */