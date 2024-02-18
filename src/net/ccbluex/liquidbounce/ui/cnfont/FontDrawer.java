/*     */ package net.ccbluex.liquidbounce.ui.cnfont;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.ccbluex.liquidbounce.injection.backend.ClassProviderImpl;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public final class FontDrawer {
/*  20 */   private static final Map<Integer, Font> RUNTIME_FONT_MAP = new HashMap<>();
/*  21 */   private static final int[] COLORS = new int[32];
/*  22 */   private static final int SHADOW_COLOR = ColorUtils.getRGB(0, 0, 0, 50);
/*     */   public static boolean RuntimeFontAntiAliasing = true;
/*     */   private float red;
/*     */   private float blue;
/*     */   private float green;
/*     */   private float alpha;
/*     */   
/*     */   static {
/*  30 */     for (int i = 0; i < COLORS.length; i++) {
/*  31 */       int offset = (i >> 3 & 0x1) * 85;
/*  32 */       int red = (i >> 2 & 0x1) * 170 + offset;
/*  33 */       int green = (i >> 1 & 0x1) * 170 + offset;
/*  34 */       int blue = (i & 0x1) * 170 + offset;
/*  35 */       if (i == 6) {
/*  36 */         red += 85;
/*     */       }
/*     */       
/*  39 */       if (i >= 16) {
/*  40 */         red /= 4;
/*  41 */         green /= 4;
/*  42 */         blue /= 4;
/*     */       } 
/*     */       
/*  45 */       COLORS[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  50 */   private final Glyph[] glyphs = new Glyph[65536];
/*     */   private final Font font;
/*     */   private final Font runtimeFont;
/*     */   private final int imageSize;
/*     */   private final int halfHeight;
/*     */   private final boolean antiAliasing;
/*     */   public int FONT_HEIGHT;
/*     */   
/*     */   public FontDrawer(Font font, boolean antiAliasing) {
/*  59 */     this.font = font;
/*  60 */     this.FONT_HEIGHT = font.getSize();
/*  61 */     this.imageSize = font.getSize() + 4;
/*  62 */     this.halfHeight = font.getSize() / 2;
/*  63 */     this.antiAliasing = antiAliasing;
/*  64 */     this.runtimeFont = getRuntimeFont();
/*     */   }
/*     */   
/*     */   private static void setRenderingHints(Graphics2D g, boolean antiAliasing) {
/*  68 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
/*  69 */     if (antiAliasing) {
/*  70 */       g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
/*     */     } else {
/*  72 */       g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*     */     } 
/*     */     
/*  75 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void drawLine(double left, double top, double right, double bottom) {
/*  80 */     if (left < right) {
/*  81 */       double j = left;
/*  82 */       left = right;
/*  83 */       right = j;
/*     */     } 
/*     */     
/*  86 */     if (top < bottom) {
/*  87 */       double j = top;
/*  88 */       top = bottom;
/*  89 */       bottom = j;
/*     */     } 
/*     */     
/*  92 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  93 */     IWorldRenderer worldrenderer = ClassProviderImpl.INSTANCE.getTessellatorInstance().getWorldRenderer();
/*  94 */     if (GL11.glIsEnabled(3553)) {
/*  95 */       GlStateManager.func_179090_x();
/*     */     }
/*     */     
/*  98 */     worldrenderer.begin(7, ClassProviderImpl.INSTANCE.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*  99 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 100 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/* 101 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/* 102 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/* 103 */     tessellator.func_78381_a();
/* 104 */     if (!GL11.glIsEnabled(3553)) {
/* 105 */       GlStateManager.func_179098_w();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public float DisplayFontWidths(FontDrawer font, String str) {
/* 111 */     return font.getStringWidth(str);
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 115 */     return this.font;
/*     */   }
/*     */   
/*     */   public float DisplayFontWidths(String str, FontDrawer font) {
/* 119 */     return font.getStringWidth(str);
/*     */   }
/*     */   
/*     */   public FontDrawer getDefaultFont() {
/* 123 */     return this;
/*     */   }
/*     */   
/*     */   public void DisplayFonts(FontDrawer font, String str, float x, float y, int color) {
/* 127 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFonts(FontDrawer font, String str, int x, int y, int color) {
/* 131 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFonts(String str, float x, float y, int color, FontDrawer font) {
/* 135 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFonts(String str, float x, float y, int color) {
/* 139 */     drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(String str, float x, float y, int color) {
/* 143 */     drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(FontDrawer font, String str, float x, float y, int color) {
/* 147 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(FontDrawer font, String str, int x, int y, int color) {
/* 151 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont(String str, float x, float y, int color, FontDrawer font) {
/* 155 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont2(FontDrawer font, String str, float x, float y, int color, boolean b) {
/* 159 */     if (b) {
/* 160 */       font.drawStringWithShadow(str, x, y, color);
/*     */     } else {
/* 162 */       font.drawString(str, x, y, color);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void DisplayFont2(FontDrawer font, String str, int x, int y, int color) {
/* 168 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont2(String str, float x, float y, int color, FontDrawer font) {
/* 172 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   private Font getRuntimeFont() {
/* 176 */     Font runtimeFont = RUNTIME_FONT_MAP.get(Integer.valueOf(this.FONT_HEIGHT));
/* 177 */     if (runtimeFont == null) {
/* 178 */       runtimeFont = new Font("SansSerif", 0, this.FONT_HEIGHT);
/* 179 */       RUNTIME_FONT_MAP.put(Integer.valueOf(this.FONT_HEIGHT), runtimeFont);
/*     */     } 
/*     */     
/* 182 */     return runtimeFont;
/*     */   }
/*     */   
/*     */   public int getStringWidth(String s) {
/* 186 */     if (s != null && !s.isEmpty()) {
/*     */       
/* 188 */       int ret = 0;
/*     */       
/* 190 */       for (int i = 0; i < s.length(); i++) {
/* 191 */         ret += (getGlyph(s.charAt(i))).halfWidth;
/*     */       }
/*     */       
/* 194 */       return ret + 2;
/*     */     } 
/* 196 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 201 */     return this.FONT_HEIGHT;
/*     */   }
/*     */   
/*     */   public int getHalfHeight() {
/* 205 */     return this.halfHeight;
/*     */   }
/*     */   
/*     */   public void drawCenteredStringWithShadow(String s, double x, double y, int color) {
/* 209 */     drawStringWithShadow(s, x - getStringWidth(s) / 2.0D, y, color);
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String s, float x, float y, int color) {
/* 213 */     return drawStringWithShadow(s, x, y, color);
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String s, double x, double y, int color) {
/* 217 */     drawString(s, x + 0.5D, y + 0.5D, SHADOW_COLOR, true);
/* 218 */     return drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public void drawStringWithShadowDirect(String s, double x, double y, int color) {
/* 222 */     drawStringDirect(s, x + 0.5D, y + 0.5D, SHADOW_COLOR);
/* 223 */     drawStringDirect(s, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, double x, double y, int color) {
/* 227 */     drawString(s, x - getStringWidth(s) / 2.0D, y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, double x, double y, int color, boolean b) {
/* 231 */     drawString(s, x - getStringWidth(s) / 2.0D, y, color, b);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, float x, float y, int color, boolean b) {
/* 235 */     drawString(s, x - getStringWidth(s) / 2.0D, y, color, b);
/*     */   }
/*     */   
/*     */   public void drawStringDirect(String s, double x, double y, int color) {
/* 239 */     if (s != null && !s.isEmpty()) {
/* 240 */       preDraw();
/* 241 */       GLUtils.color(color);
/* 242 */       x = (x - 2.0D) * 2.0D;
/* 243 */       y = (y - 1.0D) * 2.0D;
/*     */       
/* 245 */       for (int i = 0; i < s.length(); i++) {
/* 246 */         Glyph glyph = getGlyph(s.charAt(i));
/* 247 */         glyph.draw(x, y, false);
/* 248 */         x += glyph.width;
/*     */       } 
/*     */       
/* 251 */       postDraw();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawString(String s, double x, double y, int color) {
/* 256 */     drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public int drawString(String s, int x, int y, int color) {
/* 260 */     return drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public void drawString(String s, float x, float y, int color) {
/* 264 */     drawString(s, x, y, color, false);
/*     */   }
/*     */   
/*     */   public int drawString(String s, int x, int y, int color, boolean shadow) {
/* 268 */     return drawString(s, x, y, color, shadow);
/*     */   }
/*     */   
/*     */   public int drawString(String s, float x, float y, int color, boolean shadow) {
/* 272 */     return drawString(s, x, y, color, shadow);
/*     */   }
/*     */   
/*     */   public int drawString(String s, double x, double y, int color, boolean shadow) {
/* 276 */     GlStateManager.func_179141_d();
/* 277 */     if (s != null && !s.isEmpty()) {
/* 278 */       if (this.font.getSize() == 18) {
/* 279 */         this.FONT_HEIGHT = 18;
/*     */       }
/* 281 */       s = StringUtils.filterEmoji(s);
/* 282 */       preDraw();
/* 283 */       this.red = (color >> 16 & 0xFF) / 255.0F;
/* 284 */       this.blue = (color >> 8 & 0xFF) / 255.0F;
/* 285 */       this.green = (color & 0xFF) / 255.0F;
/* 286 */       this.alpha = (color >> 24 & 0xFF) / 255.0F;
/* 287 */       GlStateManager.func_179131_c(this.red, this.blue, this.green, this.alpha);
/* 288 */       x = (x - 2.0D) * 2.0D;
/* 289 */       y = (y - 1.0D) * 2.0D;
/* 290 */       boolean bold = false;
/* 291 */       boolean italic = false;
/* 292 */       boolean strikethrough = false;
/* 293 */       boolean underline = false;
/*     */       
/* 295 */       for (int i = 0; i < s.length(); i++) {
/* 296 */         char c = s.charAt(i);
/*     */         
/* 298 */         if (c == '§') {
/* 299 */           i++;
/* 300 */           if (i >= s.length()) {
/* 301 */             Glyph glyph = getGlyph('§');
/* 302 */             drawGlyph(glyph, x, y, bold, strikethrough, underline, italic);
/* 303 */             x += glyph.width;
/*     */           } 
/*     */           
/* 306 */           if (!shadow) {
/* 307 */             int colorIndex = 21;
/* 308 */             if (i < s.length()) {
/* 309 */               colorIndex = "0123456789abcdefklmnor".indexOf(s.charAt(i));
/*     */             }
/*     */             
/* 312 */             switch (colorIndex) {
/*     */               case 17:
/* 314 */                 bold = true;
/*     */                 break;
/*     */               case 18:
/* 317 */                 strikethrough = true;
/*     */                 break;
/*     */               case 19:
/* 320 */                 underline = true;
/*     */                 break;
/*     */               case 20:
/* 323 */                 italic = true;
/*     */                 break;
/*     */               case 21:
/* 326 */                 bold = false;
/* 327 */                 italic = false;
/* 328 */                 underline = false;
/* 329 */                 strikethrough = false;
/* 330 */                 GLUtils.color(color);
/*     */                 break;
/*     */               default:
/* 333 */                 if (colorIndex < 16) {
/* 334 */                   if (colorIndex == -1) {
/* 335 */                     colorIndex = 15;
/*     */                   }
/*     */                   
/* 338 */                   int finalColor = COLORS[colorIndex];
/* 339 */                   GLUtils.color(ColorUtils.getRed(finalColor), ColorUtils.getGreen(finalColor), ColorUtils.getBlue(finalColor), ColorUtils.getAlpha(color));
/*     */                 }  break;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 344 */           Glyph glyph = getGlyph(c);
/* 345 */           drawGlyph(glyph, x, y, bold, strikethrough, underline, italic);
/* 346 */           x += glyph.width;
/*     */         } 
/*     */       } 
/*     */       
/* 350 */       postDraw();
/* 351 */       return getStringWidth(s);
/*     */     } 
/* 353 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawGlyph(Glyph glyph, double x, double y, boolean bold, boolean strikethrough, boolean underline, boolean italic) {
/* 358 */     if (bold) {
/* 359 */       glyph.draw(x + 1.0D, y, italic);
/*     */     }
/*     */     
/* 362 */     glyph.draw(x, y, italic);
/* 363 */     if (strikethrough) {
/* 364 */       double mid = y + this.FONT_HEIGHT / 2.0D;
/* 365 */       drawLine(x, mid - 1.0D, x + glyph.width, mid + 1.0D);
/*     */     } 
/*     */     
/* 368 */     if (underline) {
/* 369 */       drawLine(x, y + this.FONT_HEIGHT - 1.0D, x + glyph.width, y + this.FONT_HEIGHT + 1.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void preDraw() {
/* 375 */     GLUtils.pushMatrix();
/* 376 */     GlStateManager.func_179147_l();
/* 377 */     GlStateManager.func_179112_b(770, 771);
/* 378 */     if (!GL11.glIsEnabled(3553)) {
/* 379 */       GlStateManager.func_179098_w();
/*     */     }
/*     */     
/* 382 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/*     */   }
/*     */   
/*     */   private void postDraw() {
/* 386 */     GlStateManager.func_179084_k();
/* 387 */     GLUtils.popMatrix();
/* 388 */     GLUtils.resetColor();
/*     */   }
/*     */   
/*     */   public String trimStringToWidth(String p_trimStringToWidth_1_, int p_trimStringToWidth_2_, boolean p_trimStringToWidth_3_) {
/* 392 */     StringBuilder stringbuilder = new StringBuilder();
/* 393 */     int i = 0;
/* 394 */     int j = p_trimStringToWidth_3_ ? (p_trimStringToWidth_1_.length() - 1) : 0;
/* 395 */     int k = p_trimStringToWidth_3_ ? -1 : 1;
/* 396 */     boolean flag = false;
/* 397 */     boolean flag1 = false;
/*     */     int l;
/* 399 */     for (l = j; l >= 0 && l < p_trimStringToWidth_1_.length() && i < p_trimStringToWidth_2_; l += k) {
/* 400 */       char c0 = p_trimStringToWidth_1_.charAt(l);
/* 401 */       int i1 = getStringWidth(String.valueOf(c0));
/* 402 */       if (flag) {
/* 403 */         flag = false;
/* 404 */         if (c0 != 'l' && c0 != 'L') {
/* 405 */           if (c0 == 'r' || c0 == 'R') {
/* 406 */             flag1 = false;
/*     */           }
/*     */         } else {
/* 409 */           flag1 = true;
/*     */         } 
/* 411 */       } else if (i1 < 0) {
/* 412 */         flag = true;
/*     */       } else {
/* 414 */         i += i1;
/* 415 */         if (flag1) {
/* 416 */           i++;
/*     */         }
/*     */       } 
/*     */       
/* 420 */       if (i > p_trimStringToWidth_2_) {
/*     */         break;
/*     */       }
/*     */       
/* 424 */       if (p_trimStringToWidth_3_) {
/* 425 */         stringbuilder.insert(0, c0);
/*     */       } else {
/* 427 */         stringbuilder.append(c0);
/*     */       } 
/*     */     } 
/*     */     
/* 431 */     return stringbuilder.toString();
/*     */   }
/*     */   
/*     */   private Glyph getGlyph(char c) {
/* 435 */     Glyph glyph = this.glyphs[c];
/* 436 */     if (glyph == null) {
/* 437 */       this.glyphs[c] = glyph = createGlyph(c);
/*     */     }
/*     */     
/* 440 */     return glyph;
/*     */   }
/*     */   
/*     */   private Glyph createGlyph(char c) {
/* 444 */     String s = String.valueOf(c);
/* 445 */     BufferedImage image = new BufferedImage(this.imageSize, this.imageSize, 2);
/* 446 */     Graphics2D g = image.createGraphics();
/* 447 */     int offset = 0;
/* 448 */     if (this.font.canDisplay(c)) {
/* 449 */       setRenderingHints(g, this.antiAliasing);
/* 450 */       g.setFont(this.font);
/*     */     } else {
/* 452 */       setRenderingHints(g, RuntimeFontAntiAliasing);
/* 453 */       g.setFont(this.runtimeFont);
/* 454 */       offset = 1;
/*     */     } 
/*     */     
/* 457 */     FontMetrics fontMetrics = g.getFontMetrics();
/* 458 */     g.setColor(Color.WHITE);
/* 459 */     g.drawString(s, 0, this.FONT_HEIGHT - 1 + offset);
/* 460 */     g.dispose();
/* 461 */     return new Glyph(new DynamicTexture(image), (fontMetrics.getStringBounds(s, g).getBounds()).width);
/*     */   }
/*     */   
/*     */   final class Glyph {
/*     */     public final DynamicTexture texture;
/*     */     public final int width;
/*     */     public final int halfWidth;
/*     */     
/*     */     public Glyph(DynamicTexture texture, int width) {
/* 470 */       this.texture = texture;
/* 471 */       this.width = width;
/* 472 */       this.halfWidth = width / 2;
/*     */     }
/*     */     
/*     */     public void draw(double x, double y, boolean italic) {
/* 476 */       GlStateManager.func_179144_i(this.texture.func_110552_b());
/* 477 */       double offset = italic ? 2.0D : 0.0D;
/* 478 */       GL11.glBegin(5);
/* 479 */       GL11.glTexCoord2d(0.0D, 0.0D);
/* 480 */       GL11.glVertex3d(x + offset, y, 0.0D);
/* 481 */       GL11.glTexCoord2d(0.0D, 1.0D);
/* 482 */       GL11.glVertex3d(x - offset, y + FontDrawer.this.imageSize, 0.0D);
/* 483 */       GL11.glTexCoord2d(1.0D, 0.0D);
/* 484 */       GL11.glVertex3d(x + FontDrawer.this.imageSize + offset, y, 0.0D);
/* 485 */       GL11.glTexCoord2d(1.0D, 1.0D);
/* 486 */       GL11.glVertex3d(x + FontDrawer.this.imageSize - offset, y + FontDrawer.this.imageSize, 0.0D);
/* 487 */       GL11.glEnd();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\cnfont\FontDrawer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */