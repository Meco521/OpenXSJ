/*     */ package novoline.font;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SimpleFontRenderer
/*     */   implements FontRenderer
/*     */ {
/*  22 */   private static final int[] COLOR_CODES = setupMinecraftColorCodes();
/*     */   
/*     */   private static final String COLORS = "0123456789abcdefklmnor";
/*     */   
/*     */   private static final char COLOR_PREFIX = '§';
/*     */   private static final short CHARS = 256;
/*     */   private static final float IMG_SIZE = 512.0F;
/*     */   private static final float CHAR_OFFSET = 0.0F;
/*  30 */   private final CharData[] charData = new CharData[256];
/*  31 */   private final CharData[] boldChars = new CharData[256];
/*  32 */   private final CharData[] italicChars = new CharData[256];
/*  33 */   private final CharData[] boldItalicChars = new CharData[256];
/*     */   
/*     */   private final Font awtFont;
/*     */   
/*     */   private final boolean antiAlias;
/*     */   private final boolean fractionalMetrics;
/*     */   private DynamicTexture texturePlain;
/*     */   private DynamicTexture textureBold;
/*     */   private DynamicTexture textureItalic;
/*     */   private DynamicTexture textureItalicBold;
/*  43 */   private int fontHeight = -1;
/*     */ 
/*     */   
/*     */   private SimpleFontRenderer(Font awtFont, boolean antiAlias, boolean fractionalMetrics) {
/*  47 */     this.awtFont = awtFont;
/*  48 */     this.antiAlias = antiAlias;
/*  49 */     this.fractionalMetrics = fractionalMetrics;
/*  50 */     setupBoldItalicFonts();
/*     */   }
/*     */   
/*     */   static FontRenderer create(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  54 */     return new SimpleFontRenderer(font, antiAlias, fractionalMetrics);
/*     */   }
/*     */   
/*     */   public static FontRenderer create(Font font) {
/*  58 */     return create(font, true, true);
/*     */   }
/*     */   
/*     */   private DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  62 */     return new DynamicTexture(generateFontImage(font, antiAlias, fractionalMetrics, chars));
/*     */   }
/*     */   
/*     */   private BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  66 */     int imgSize = 512;
/*  67 */     BufferedImage bufferedImage = new BufferedImage(512, 512, 2);
/*  68 */     Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
/*     */     
/*  70 */     graphics.setFont(font);
/*  71 */     graphics.setColor(new Color(255, 255, 255, 0));
/*  72 */     graphics.fillRect(0, 0, 512, 512);
/*  73 */     graphics.setColor(Color.WHITE);
/*     */     
/*  75 */     graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*  76 */     graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  77 */     graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*     */     
/*  79 */     if (this.fractionalMetrics) {
/*  80 */       graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */     } else {
/*  82 */       graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*     */     } 
/*     */     
/*  85 */     FontMetrics fontMetrics = graphics.getFontMetrics();
/*  86 */     int charHeight = 0, positionX = 0, positionY = 1;
/*     */     
/*  88 */     for (int i = 0; i < chars.length; i++) {
/*  89 */       char ch = (char)i;
/*  90 */       CharData charData = new CharData();
/*  91 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), graphics);
/*     */       
/*  93 */       charData.width = (dimensions.getBounds()).width + 8;
/*  94 */       charData.height = (dimensions.getBounds()).height;
/*     */       
/*  96 */       if (positionX + charData.width >= 512) {
/*  97 */         positionX = 0;
/*  98 */         positionY += charHeight;
/*  99 */         charHeight = 0;
/*     */       } 
/*     */       
/* 102 */       if (charData.height > charHeight) {
/* 103 */         charHeight = charData.height;
/*     */       }
/*     */       
/* 106 */       charData.storedX = positionX;
/* 107 */       charData.storedY = positionY;
/*     */       
/* 109 */       if (charData.height > this.fontHeight) {
/* 110 */         this.fontHeight = charData.height;
/*     */       }
/*     */       
/* 113 */       chars[i] = charData;
/*     */       
/* 115 */       graphics.drawString(String.valueOf(ch), positionX + 2, positionY + fontMetrics.getAscent());
/* 116 */       positionX += charData.width;
/*     */     } 
/*     */     
/* 119 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   private void setupBoldItalicFonts() {
/* 123 */     this.texturePlain = setupTexture(this.awtFont, this.antiAlias, this.fractionalMetrics, this.charData);
/* 124 */     this.textureBold = setupTexture(this.awtFont.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 125 */     this.textureItalic = setupTexture(this.awtFont.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/* 126 */     this.textureItalicBold = setupTexture(this.awtFont.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float drawString(CharSequence text, double x, double y, int color, boolean dropShadow) {
/* 132 */     if (dropShadow) {
/* 133 */       float shadowWidth = drawStringInternal(text, x + 0.5D, y + 0.5D, color, true);
/* 134 */       return Math.max(shadowWidth, drawStringInternal(text, x, y, color, false));
/*     */     } 
/* 136 */     return drawStringInternal(text, x, y, color, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public float drawString(CharSequence text, float x, float y, int color, boolean dropShadow) {
/* 141 */     if (dropShadow) {
/* 142 */       float shadowWidth = drawStringInternal(text, x + 0.5D, y + 0.5D, color, true);
/* 143 */       return Math.max(shadowWidth, drawStringInternal(text, x, y, color, false));
/*     */     } 
/* 145 */     return drawStringInternal(text, x, y, color, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float drawStringInternal(CharSequence text, double x, double y, int color, boolean shadow) {
/* 151 */     x--;
/*     */     
/* 153 */     if (text == null) return 0.0F; 
/* 154 */     if (color == 553648127) color = 16777215; 
/* 155 */     if ((color & 0xFC000000) == 0) color |= 0xFF000000;
/*     */ 
/*     */     
/* 158 */     if (shadow) {
/* 159 */       color = (color & 0xFCFCFC) >> 2 | color & 0xFF000000;
/*     */     }
/*     */     
/* 162 */     CharData[] charData = this.charData;
/* 163 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 164 */     boolean randomCase = false;
/*     */     
/* 166 */     x *= 2.0D;
/* 167 */     y = (y - 3.0D) * 2.0D;
/*     */ 
/*     */     
/* 170 */     GL11.glPushMatrix();
/* 171 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 172 */     GlStateManager.func_179147_l();
/* 173 */     GlStateManager.func_179112_b(770, 771);
/* 174 */     GL11.glColor4f((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 175 */     GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 176 */     GlStateManager.func_179098_w();
/* 177 */     GlStateManager.func_179144_i(this.texturePlain.func_110552_b());
/*     */     
/* 179 */     GL11.glBindTexture(3553, this.texturePlain.func_110552_b());
/* 180 */     GL11.glTexParameterf(3553, 10240, 9729.0F);
/*     */     
/* 182 */     boolean underline = false;
/* 183 */     boolean strikethrough = false;
/* 184 */     boolean italic = false;
/* 185 */     boolean bold = false;
/*     */     
/* 187 */     for (int i = 0, size = text.length(); i < size; i++) {
/* 188 */       char character = text.charAt(i);
/*     */       
/* 190 */       if (character == '§' && i + 1 < size) {
/*     */         
/* 192 */         int colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/*     */         
/* 194 */         if (colorIndex < 16) {
/* 195 */           bold = false;
/* 196 */           italic = false;
/* 197 */           underline = false;
/* 198 */           strikethrough = false;
/* 199 */           GlStateManager.func_179144_i(this.texturePlain.func_110552_b());
/* 200 */           charData = this.charData;
/*     */           
/* 202 */           if (colorIndex < 0) colorIndex = 15; 
/* 203 */           if (shadow) colorIndex += 16;
/*     */           
/* 205 */           int colorCode = COLOR_CODES[colorIndex];
/* 206 */           GlStateManager.func_179131_c((colorCode >> 16 & 0xFF) / 255.0F, (colorCode >> 8 & 0xFF) / 255.0F, (colorCode & 0xFF) / 255.0F, 255.0F);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 211 */         else if (colorIndex == 17) {
/* 212 */           bold = true;
/*     */           
/* 214 */           if (italic) {
/* 215 */             GlStateManager.func_179144_i(this.textureItalicBold.func_110552_b());
/* 216 */             charData = this.boldItalicChars;
/*     */           } else {
/* 218 */             GlStateManager.func_179144_i(this.textureBold.func_110552_b());
/* 219 */             charData = this.boldChars;
/*     */           } 
/* 221 */         } else if (colorIndex == 18) {
/* 222 */           strikethrough = true;
/* 223 */         } else if (colorIndex == 19) {
/* 224 */           underline = true;
/* 225 */         } else if (colorIndex == 20) {
/* 226 */           italic = true;
/*     */           
/* 228 */           if (bold) {
/* 229 */             GlStateManager.func_179144_i(this.textureItalicBold.func_110552_b());
/* 230 */             charData = this.boldItalicChars;
/*     */           } else {
/* 232 */             GlStateManager.func_179144_i(this.textureItalic.func_110552_b());
/* 233 */             charData = this.italicChars;
/*     */           } 
/* 235 */         } else if (colorIndex == 21) {
/* 236 */           bold = false;
/* 237 */           italic = false;
/* 238 */           underline = false;
/* 239 */           strikethrough = false;
/*     */           
/* 241 */           GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, 255.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 246 */           GlStateManager.func_179144_i(this.texturePlain.func_110552_b());
/*     */           
/* 248 */           charData = this.charData;
/*     */         } 
/*     */ 
/*     */         
/* 252 */         i++;
/* 253 */       } else if (character < charData.length) {
/* 254 */         GL11.glBegin(4);
/* 255 */         drawChar(charData, character, (float)x, (float)y);
/* 256 */         GL11.glEnd();
/*     */         
/* 258 */         if (strikethrough) {
/* 259 */           drawLine(x, y + ((charData[character])
/* 260 */               .height / 2.0F), x + (charData[character])
/* 261 */               .width - 8.0D, y + ((charData[character])
/* 262 */               .height / 2.0F), 1.0F);
/*     */         }
/*     */ 
/*     */         
/* 266 */         if (underline) {
/* 267 */           drawLine(x, y + (charData[character])
/* 268 */               .height - 2.0D, x + (charData[character])
/* 269 */               .width - 8.0D, y + (charData[character])
/* 270 */               .height - 2.0D, 1.0F);
/*     */         }
/*     */ 
/*     */         
/* 274 */         x += ((charData[character]).width - ((character == ' ') ? 8 : 9));
/*     */       } 
/*     */     } 
/*     */     
/* 278 */     GL11.glTexParameterf(3553, 10240, 9728.0F);
/* 279 */     GL11.glHint(3155, 4352);
/* 280 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 283 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String trimStringToWidth(CharSequence text, int width, boolean reverse) {
/* 290 */     StringBuilder builder = new StringBuilder();
/*     */     
/* 292 */     float f = 0.0F;
/* 293 */     int i = reverse ? (text.length() - 1) : 0;
/* 294 */     int j = reverse ? -1 : 1;
/* 295 */     boolean flag = false;
/* 296 */     boolean flag1 = false;
/*     */     int k;
/* 298 */     for (k = i; k >= 0 && k < text.length() && f < width; k += j) {
/* 299 */       char c0 = text.charAt(k);
/* 300 */       float f1 = stringWidth(String.valueOf(c0));
/*     */       
/* 302 */       if (flag) {
/* 303 */         flag = false;
/*     */         
/* 305 */         if (c0 != 'l' && c0 != 'L') {
/* 306 */           if (c0 == 'r' || c0 == 'R') {
/* 307 */             flag1 = false;
/*     */           }
/*     */         } else {
/* 310 */           flag1 = true;
/*     */         } 
/* 312 */       } else if (f1 < 0.0F) {
/* 313 */         flag = true;
/*     */       } else {
/* 315 */         f += f1;
/* 316 */         if (flag1) f++;
/*     */       
/*     */       } 
/* 319 */       if (f > width)
/*     */         break; 
/* 321 */       if (reverse) {
/* 322 */         builder.insert(0, c0);
/*     */       } else {
/* 324 */         builder.append(c0);
/*     */       } 
/*     */     } 
/*     */     
/* 328 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int stringWidth(CharSequence text) {
/* 333 */     if (text == null) return 0; 
/* 334 */     int width = 0;
/* 335 */     CharData[] currentData = this.charData;
/* 336 */     boolean bold = false;
/* 337 */     boolean italic = false;
/*     */     
/* 339 */     for (int i = 0, size = text.length(); i < size; i++) {
/* 340 */       char character = text.charAt(i);
/*     */       
/* 342 */       if (character == '§' && i + 1 < size) {
/* 343 */         int colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/*     */         
/* 345 */         if (colorIndex < 16) {
/* 346 */           bold = false;
/* 347 */           italic = false;
/* 348 */         } else if (colorIndex == 17) {
/* 349 */           bold = true;
/* 350 */           if (italic) { currentData = this.boldItalicChars; }
/* 351 */           else { currentData = this.boldChars; } 
/* 352 */         } else if (colorIndex == 20) {
/* 353 */           italic = true;
/* 354 */           if (bold) { currentData = this.boldItalicChars; }
/* 355 */           else { currentData = this.italicChars; } 
/* 356 */         } else if (colorIndex == 21) {
/* 357 */           bold = false;
/* 358 */           italic = false;
/* 359 */           currentData = this.charData;
/*     */         } 
/*     */ 
/*     */         
/* 363 */         i++;
/* 364 */       } else if (character < currentData.length) {
/* 365 */         width += (currentData[character]).width - ((character == ' ') ? 8 : 9);
/*     */       } 
/*     */     } 
/*     */     
/* 369 */     return width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float charWidth(char s) {
/* 374 */     return (((this.charData[s]).width - 8) / 2);
/*     */   }
/*     */   
/*     */   public CharData[] getCharData() {
/* 378 */     return this.charData;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int[] setupMinecraftColorCodes() {
/* 383 */     int[] colorCodes = new int[32];
/*     */     
/* 385 */     for (int i = 0; i < 32; i++) {
/* 386 */       int noClue = (i >> 3 & 0x1) * 85;
/* 387 */       int red = (i >> 2 & 0x1) * 170 + noClue;
/* 388 */       int green = (i >> 1 & 0x1) * 170 + noClue;
/* 389 */       int blue = (i & 0x1) * 170 + noClue;
/*     */       
/* 391 */       if (i == 6) {
/* 392 */         red += 85;
/*     */       }
/*     */       
/* 395 */       if (i >= 16) {
/* 396 */         red >>= 2;
/* 397 */         green >>= 2;
/* 398 */         blue >>= 2;
/*     */       } 
/*     */       
/* 401 */       colorCodes[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */     
/* 404 */     return colorCodes;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class CharData
/*     */   {
/*     */     private int width;
/*     */     
/*     */     private int height;
/*     */     
/*     */     private int storedX;
/*     */     private int storedY;
/*     */     
/*     */     private CharData() {}
/*     */   }
/*     */   
/*     */   private static void drawChar(CharData[] chars, char c, float x, float y) {
/* 421 */     drawQuad(x, y, (chars[c]).width, (chars[c]).height, (chars[c]).storedX, (chars[c]).storedY, (chars[c]).width, (chars[c]).height);
/*     */   }
/*     */   
/*     */   private static void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/* 425 */     float renderSRCX = srcX / 512.0F;
/* 426 */     float renderSRCY = srcY / 512.0F;
/* 427 */     float renderSRCWidth = srcWidth / 512.0F;
/* 428 */     float renderSRCHeight = srcHeight / 512.0F;
/*     */ 
/*     */     
/* 431 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 432 */     GL11.glVertex2d((x + width), y);
/* 433 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/* 434 */     GL11.glVertex2d(x, y);
/* 435 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 436 */     GL11.glVertex2d(x, (y + height));
/* 437 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 438 */     GL11.glVertex2d(x, (y + height));
/* 439 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 440 */     GL11.glVertex2d((x + width), (y + height));
/* 441 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 442 */     GL11.glVertex2d((x + width), y);
/*     */   }
/*     */   
/*     */   private static void drawLine(double x, double y, double x1, double y1, float width) {
/* 446 */     GL11.glDisable(3553);
/* 447 */     GL11.glLineWidth(width);
/* 448 */     GL11.glBegin(1);
/* 449 */     GL11.glVertex2d(x, y);
/* 450 */     GL11.glVertex2d(x1, y1);
/* 451 */     GL11.glEnd();
/* 452 */     GL11.glEnable(3553);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 459 */     return this.awtFont.getFamily();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 464 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAntiAlias() {
/* 469 */     return this.antiAlias;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFractionalMetrics() {
/* 474 */     return this.fractionalMetrics;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\SimpleFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */