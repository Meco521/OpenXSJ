/*     */ package net.ccbluex.liquidbounce.feng;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.HashMap;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.ccbluex.liquidbounce.injection.backend.ClassProviderImpl;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public final class FontDrawer {
/*  17 */   private static final Map<Integer, Font> RUNTIME_FONT_MAP = new HashMap<>();
/*  18 */   private static final int[] COLORS = new int[32];
/*  19 */   private static final int SHADOW_COLOR = ColorUtils.getRGB(0, 0, 0, 50);
/*     */   public static boolean RuntimeFontAntiAliasing = true;
/*     */   
/*     */   static {
/*  23 */     for (int i = 0; i < COLORS.length; i++) {
/*  24 */       int offset = (i >> 3 & 0x1) * 85;
/*  25 */       int red = (i >> 2 & 0x1) * 170 + offset;
/*  26 */       int green = (i >> 1 & 0x1) * 170 + offset;
/*  27 */       int blue = (i & 0x1) * 170 + offset;
/*  28 */       if (i == 6) {
/*  29 */         red += 85;
/*     */       }
/*     */       
/*  32 */       if (i >= 16) {
/*  33 */         red /= 4;
/*  34 */         green /= 4;
/*  35 */         blue /= 4;
/*     */       } 
/*     */       
/*  38 */       COLORS[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  43 */   private final Glyph[] glyphs = new Glyph[65536];
/*     */   private final Font font;
/*     */   private final Font runtimeFont;
/*     */   private final int imageSize;
/*     */   private final int halfHeight;
/*     */   private final boolean antiAliasing;
/*     */   public int FONT_HEIGHT;
/*     */   
/*     */   public FontDrawer(Font font, boolean antiAliasing) {
/*  52 */     this.font = font;
/*  53 */     this.FONT_HEIGHT = font.getSize();
/*  54 */     this.imageSize = font.getSize() + 4;
/*  55 */     this.halfHeight = font.getSize() / 2;
/*  56 */     this.antiAliasing = antiAliasing;
/*  57 */     this.runtimeFont = getRuntimeFont();
/*     */   }
/*     */   
/*     */   private static void setRenderingHints(Graphics2D g, boolean antiAliasing) {
/*  61 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
/*  62 */     if (antiAliasing) {
/*  63 */       g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
/*     */     } else {
/*  65 */       g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*     */     } 
/*     */     
/*  68 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void drawLine(double left, double top, double right, double bottom) {
/*  73 */     if (left < right) {
/*  74 */       double j = left;
/*  75 */       left = right;
/*  76 */       right = j;
/*     */     } 
/*     */     
/*  79 */     if (top < bottom) {
/*  80 */       double j = top;
/*  81 */       top = bottom;
/*  82 */       bottom = j;
/*     */     } 
/*     */     
/*  85 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  86 */     IWorldRenderer worldrenderer = ClassProviderImpl.INSTANCE.getTessellatorInstance().getWorldRenderer();
/*  87 */     if (GL11.glIsEnabled(3553)) {
/*  88 */       GlStateManager.func_179090_x();
/*     */     }
/*     */     
/*  91 */     worldrenderer.begin(7, ClassProviderImpl.INSTANCE.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*  92 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/*  93 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/*  94 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/*  95 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/*  96 */     tessellator.func_78381_a();
/*  97 */     if (!GL11.glIsEnabled(3553)) {
/*  98 */       GlStateManager.func_179098_w();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public float DisplayFontWidths(FontDrawer font, String str) {
/* 104 */     return font.getStringWidth(str);
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 108 */     return this.font;
/*     */   }
/*     */   
/*     */   public float DisplayFontWidths(String str, FontDrawer font) {
/* 112 */     return font.getStringWidth(str);
/*     */   }
/*     */   
/*     */   public FontDrawer getDefaultFont() {
/* 116 */     return this;
/*     */   }
/*     */   
/*     */   public void DisplayFonts(FontDrawer font, String str, float x, float y, int color) {
/* 120 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFonts(FontDrawer font, String str, int x, int y, int color) {
/* 124 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFonts(String str, float x, float y, int color, FontDrawer font) {
/* 128 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFonts(String str, float x, float y, int color) {
/* 132 */     drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(String str, float x, float y, int color) {
/* 136 */     drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(FontDrawer font, String str, float x, float y, int color) {
/* 140 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(FontDrawer font, String str, int x, int y, int color) {
/* 144 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(String str, float x, float y, int color, FontDrawer font) {
/* 148 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont2(FontDrawer font, String str, float x, float y, int color, boolean b) {
/* 152 */     if (b) {
/* 153 */       font.drawStringWithShadow(str, x, y, color);
/*     */     } else {
/* 155 */       font.drawString(str, x, y, color);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void DisplayFont2(FontDrawer font, String str, int x, int y, int color) {
/* 161 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont2(String str, float x, float y, int color, FontDrawer font) {
/* 165 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   private Font getRuntimeFont() {
/* 169 */     Font runtimeFont = RUNTIME_FONT_MAP.get(Integer.valueOf(this.FONT_HEIGHT));
/* 170 */     if (runtimeFont == null) {
/* 171 */       runtimeFont = new Font("SansSerif", 0, this.FONT_HEIGHT);
/* 172 */       RUNTIME_FONT_MAP.put(Integer.valueOf(this.FONT_HEIGHT), runtimeFont);
/*     */     } 
/*     */     
/* 175 */     return runtimeFont;
/*     */   }
/*     */   
/*     */   public int getStringWidth(String s) {
/* 179 */     if (s != null && !s.isEmpty()) {
/*     */       
/* 181 */       int ret = 0;
/*     */       
/* 183 */       for (int i = 0; i < s.length(); i++) {
/* 184 */         ret += (getGlyph(s.charAt(i))).halfWidth;
/*     */       }
/*     */       
/* 187 */       return ret + 2;
/*     */     } 
/* 189 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 194 */     return this.FONT_HEIGHT;
/*     */   }
/*     */   
/*     */   public int getHalfHeight() {
/* 198 */     return this.halfHeight;
/*     */   }
/*     */   
/*     */   public void drawCenteredStringWithShadow(String s, double x, double y, int color) {
/* 202 */     drawStringWithShadow(s, x - getStringWidth(s) / 2.0D, y, color);
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String s, float x, float y, int color) {
/* 206 */     return drawStringWithShadow(s, x, y, color);
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String s, double x, double y, int color) {
/* 210 */     drawString(s, x + 0.5D, y + 0.5D, SHADOW_COLOR, true);
/* 211 */     return drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public void drawStringWithShadowDirect(String s, double x, double y, int color) {
/* 215 */     drawStringDirect(s, x + 0.5D, y + 0.5D, SHADOW_COLOR);
/* 216 */     drawStringDirect(s, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, double x, double y, int color) {
/* 220 */     drawString(s, x - getStringWidth(s) / 2.0D, y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, double x, double y, int color, boolean b) {
/* 224 */     drawString(s, x - getStringWidth(s) / 2.0D, y, color, b);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, float x, float y, int color, boolean b) {
/* 228 */     drawString(s, x - getStringWidth(s) / 2.0D, y, color, b);
/*     */   }
/*     */   
/*     */   public void drawStringDirect(String s, double x, double y, int color) {
/* 232 */     if (s != null && !s.isEmpty()) {
/* 233 */       preDraw();
/* 234 */       GLUtils.color(color);
/* 235 */       x = (x - 2.0D) * 2.0D;
/* 236 */       y = (y - 1.0D) * 2.0D;
/*     */       
/* 238 */       for (int i = 0; i < s.length(); i++) {
/* 239 */         Glyph glyph = getGlyph(s.charAt(i));
/* 240 */         glyph.draw(x, y, false);
/* 241 */         x += glyph.width;
/*     */       } 
/*     */       
/* 244 */       postDraw();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawString(String s, double x, double y, int color) {
/* 249 */     drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public int drawString(String s, int x, int y, int color) {
/* 253 */     return drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public void drawString(String s, float x, float y, int color) {
/* 257 */     drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public int drawString(String s, int x, int y, int color, boolean shadow) {
/* 261 */     return drawString(s, x, y, color, shadow);
/*     */   }
/*     */   
/*     */   public int drawString(String s, float x, float y, int color, boolean shadow) {
/* 265 */     return drawString(s, x, y, color, shadow);
/*     */   }
/*     */ 
/*     */   
/*     */   public int drawString(String s, double x, double y, int color, boolean shadow) {
/* 270 */     GlStateManager.func_179117_G();
/*     */     
/* 272 */     if (s != null && !s.isEmpty()) {
/* 273 */       if (this.font.getSize() == 18) {
/* 274 */         this.FONT_HEIGHT = 18;
/*     */       }
/* 276 */       s = StringUtils.filterEmoji(s);
/* 277 */       preDraw();
/* 278 */       GLUtils.color(color);
/* 279 */       x = (x - 2.0D) * 2.0D;
/* 280 */       y = (y - 1.0D) * 2.0D;
/* 281 */       boolean bold = false;
/* 282 */       boolean italic = false;
/* 283 */       boolean strikethrough = false;
/* 284 */       boolean underline = false;
/*     */       
/* 286 */       for (int i = 0; i < s.length(); i++) {
/* 287 */         char c = s.charAt(i);
/*     */         
/* 289 */         if (c == '§') {
/* 290 */           i++;
/* 291 */           if (i >= s.length()) {
/* 292 */             Glyph glyph = getGlyph('§');
/* 293 */             drawGlyph(glyph, x, y, bold, strikethrough, underline, italic);
/* 294 */             x += glyph.width;
/*     */           } 
/*     */           
/* 297 */           if (!shadow) {
/* 298 */             int colorIndex = 21;
/* 299 */             if (i < s.length()) {
/* 300 */               colorIndex = "0123456789abcdefklmnor".indexOf(s.charAt(i));
/*     */             }
/*     */             
/* 303 */             switch (colorIndex) {
/*     */               case 17:
/* 305 */                 bold = true;
/*     */                 break;
/*     */               case 18:
/* 308 */                 strikethrough = true;
/*     */                 break;
/*     */               case 19:
/* 311 */                 underline = true;
/*     */                 break;
/*     */               case 20:
/* 314 */                 italic = true;
/*     */                 break;
/*     */               case 21:
/* 317 */                 bold = false;
/* 318 */                 italic = false;
/* 319 */                 underline = false;
/* 320 */                 strikethrough = false;
/* 321 */                 GLUtils.color(color);
/*     */                 break;
/*     */               default:
/* 324 */                 if (colorIndex < 16) {
/* 325 */                   if (colorIndex == -1) {
/* 326 */                     colorIndex = 15;
/*     */                   }
/*     */                   
/* 329 */                   int finalColor = COLORS[colorIndex];
/* 330 */                   GLUtils.color(ColorUtils.getRed(finalColor), ColorUtils.getGreen(finalColor), ColorUtils.getBlue(finalColor), ColorUtils.getAlpha(color));
/*     */                 }  break;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 335 */           Glyph glyph = getGlyph(c);
/* 336 */           drawGlyph(glyph, x, y, bold, strikethrough, underline, italic);
/* 337 */           x += glyph.width;
/*     */         } 
/*     */       } 
/*     */       
/* 341 */       postDraw();
/* 342 */       return getStringWidth(s);
/*     */     } 
/* 344 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawGlyph(Glyph glyph, double x, double y, boolean bold, boolean strikethrough, boolean underline, boolean italic) {
/* 349 */     if (bold) {
/* 350 */       glyph.draw(x + 1.0D, y, italic);
/*     */     }
/*     */     
/* 353 */     glyph.draw(x, y, italic);
/* 354 */     if (strikethrough) {
/* 355 */       double mid = y + this.FONT_HEIGHT / 2.0D;
/* 356 */       drawLine(x, mid - 1.0D, x + glyph.width, mid + 1.0D);
/*     */     } 
/*     */     
/* 359 */     if (underline) {
/* 360 */       drawLine(x, y + this.FONT_HEIGHT - 1.0D, x + glyph.width, y + this.FONT_HEIGHT + 1.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void preDraw() {
/* 366 */     GLUtils.pushMatrix();
/* 367 */     GlStateManager.func_179147_l();
/* 368 */     GlStateManager.func_179112_b(770, 771);
/* 369 */     if (!GL11.glIsEnabled(3553)) {
/* 370 */       GlStateManager.func_179098_w();
/*     */     }
/*     */     
/* 373 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/*     */   }
/*     */   
/*     */   private void postDraw() {
/* 377 */     GlStateManager.func_179084_k();
/* 378 */     GLUtils.popMatrix();
/* 379 */     GLUtils.resetColor();
/*     */   }
/*     */   
/*     */   public String trimStringToWidth(String p_trimStringToWidth_1_, int p_trimStringToWidth_2_, boolean p_trimStringToWidth_3_) {
/* 383 */     StringBuilder stringbuilder = new StringBuilder();
/* 384 */     int i = 0;
/* 385 */     int j = p_trimStringToWidth_3_ ? (p_trimStringToWidth_1_.length() - 1) : 0;
/* 386 */     int k = p_trimStringToWidth_3_ ? -1 : 1;
/* 387 */     boolean flag = false;
/* 388 */     boolean flag1 = false;
/*     */     int l;
/* 390 */     for (l = j; l >= 0 && l < p_trimStringToWidth_1_.length() && i < p_trimStringToWidth_2_; l += k) {
/* 391 */       char c0 = p_trimStringToWidth_1_.charAt(l);
/* 392 */       int i1 = getStringWidth(String.valueOf(c0));
/* 393 */       if (flag) {
/* 394 */         flag = false;
/* 395 */         if (c0 != 'l' && c0 != 'L') {
/* 396 */           if (c0 == 'r' || c0 == 'R') {
/* 397 */             flag1 = false;
/*     */           }
/*     */         } else {
/* 400 */           flag1 = true;
/*     */         } 
/* 402 */       } else if (i1 < 0) {
/* 403 */         flag = true;
/*     */       } else {
/* 405 */         i += i1;
/* 406 */         if (flag1) {
/* 407 */           i++;
/*     */         }
/*     */       } 
/*     */       
/* 411 */       if (i > p_trimStringToWidth_2_) {
/*     */         break;
/*     */       }
/*     */       
/* 415 */       if (p_trimStringToWidth_3_) {
/* 416 */         stringbuilder.insert(0, c0);
/*     */       } else {
/* 418 */         stringbuilder.append(c0);
/*     */       } 
/*     */     } 
/*     */     
/* 422 */     return stringbuilder.toString();
/*     */   }
/*     */   
/*     */   private Glyph getGlyph(char c) {
/* 426 */     Glyph glyph = this.glyphs[c];
/* 427 */     if (glyph == null) {
/* 428 */       this.glyphs[c] = glyph = createGlyph(c);
/*     */     }
/*     */     
/* 431 */     return glyph;
/*     */   }
/*     */   
/*     */   private Glyph createGlyph(char c) {
/* 435 */     String s = String.valueOf(c);
/* 436 */     BufferedImage image = new BufferedImage(this.imageSize, this.imageSize, 2);
/* 437 */     Graphics2D g = image.createGraphics();
/* 438 */     int offset = 0;
/* 439 */     if (this.font.canDisplay(c)) {
/* 440 */       setRenderingHints(g, this.antiAliasing);
/* 441 */       g.setFont(this.font);
/*     */     } else {
/* 443 */       setRenderingHints(g, RuntimeFontAntiAliasing);
/* 444 */       g.setFont(this.runtimeFont);
/* 445 */       offset = 1;
/*     */     } 
/*     */     
/* 448 */     FontMetrics fontMetrics = g.getFontMetrics();
/* 449 */     g.setColor(Color.WHITE);
/* 450 */     g.drawString(s, 0, this.FONT_HEIGHT - 1 + offset);
/* 451 */     g.dispose();
/* 452 */     return new Glyph(new DynamicTexture(image), (fontMetrics.getStringBounds(s, g).getBounds()).width);
/*     */   }
/*     */   
/*     */   final class Glyph {
/*     */     public final DynamicTexture texture;
/*     */     public final int width;
/*     */     public final int halfWidth;
/*     */     
/*     */     public Glyph(DynamicTexture texture, int width) {
/* 461 */       this.texture = texture;
/* 462 */       this.width = width;
/* 463 */       this.halfWidth = width / 2;
/*     */     }
/*     */     
/*     */     public void draw(double x, double y, boolean italic) {
/* 467 */       GlStateManager.func_179144_i(this.texture.func_110552_b());
/* 468 */       double offset = italic ? 2.0D : 0.0D;
/* 469 */       GL11.glBegin(5);
/* 470 */       GL11.glTexCoord2d(0.0D, 0.0D);
/* 471 */       GL11.glVertex3d(x + offset, y, 0.0D);
/* 472 */       GL11.glTexCoord2d(0.0D, 1.0D);
/* 473 */       GL11.glVertex3d(x - offset, y + FontDrawer.this.imageSize, 0.0D);
/* 474 */       GL11.glTexCoord2d(1.0D, 0.0D);
/* 475 */       GL11.glVertex3d(x + FontDrawer.this.imageSize + offset, y, 0.0D);
/* 476 */       GL11.glTexCoord2d(1.0D, 1.0D);
/* 477 */       GL11.glVertex3d(x + FontDrawer.this.imageSize - offset, y + FontDrawer.this.imageSize, 0.0D);
/* 478 */       GL11.glEnd();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\feng\FontDrawer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */