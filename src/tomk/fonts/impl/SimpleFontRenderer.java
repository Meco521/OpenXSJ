/*     */ package tomk.fonts.impl;
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
/*     */ import tomk.fonts.api.FontRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SimpleFontRenderer
/*     */   implements FontRenderer
/*     */ {
/*  21 */   private static final int[] COLOR_CODES = setupMinecraftColorCodes();
/*     */   
/*     */   private static final String COLORS = "0123456789abcdefklmnor";
/*     */   
/*     */   private static final char COLOR_PREFIX = '§';
/*     */   private static final short CHARS = 256;
/*     */   private static final float IMG_SIZE = 512.0F;
/*     */   private static final float CHAR_OFFSET = 0.0F;
/*  29 */   private final CharData[] charData = new CharData[256];
/*  30 */   private final CharData[] boldChars = new CharData[256];
/*  31 */   private final CharData[] italicChars = new CharData[256];
/*  32 */   private final CharData[] boldItalicChars = new CharData[256];
/*     */   
/*     */   private final Font awtFont;
/*     */   
/*     */   private final boolean antiAlias;
/*     */   private final boolean fractionalMetrics;
/*     */   private DynamicTexture texturePlain;
/*     */   private DynamicTexture textureBold;
/*     */   private DynamicTexture textureItalic;
/*     */   private DynamicTexture textureItalicBold;
/*  42 */   private int fontHeight = -1;
/*     */ 
/*     */   
/*     */   private SimpleFontRenderer(Font awtFont, boolean antiAlias, boolean fractionalMetrics) {
/*  46 */     this.awtFont = awtFont;
/*  47 */     this.antiAlias = antiAlias;
/*  48 */     this.fractionalMetrics = fractionalMetrics;
/*  49 */     setupBoldItalicFonts();
/*     */   }
/*     */   
/*     */   static FontRenderer create(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  53 */     return new SimpleFontRenderer(font, antiAlias, fractionalMetrics);
/*     */   }
/*     */   
/*     */   public static FontRenderer create(Font font) {
/*  57 */     return create(font, true, true);
/*     */   }
/*     */   
/*     */   private DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  61 */     return new DynamicTexture(generateFontImage(font, antiAlias, fractionalMetrics, chars));
/*     */   }
/*     */   
/*     */   private BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  65 */     int imgSize = 512;
/*  66 */     BufferedImage bufferedImage = new BufferedImage(512, 512, 2);
/*  67 */     Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
/*     */     
/*  69 */     graphics.setFont(font);
/*  70 */     graphics.setColor(new Color(255, 255, 255, 0));
/*  71 */     graphics.fillRect(0, 0, 512, 512);
/*  72 */     graphics.setColor(Color.WHITE);
/*     */     
/*  74 */     graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*  75 */     graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  76 */     graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*     */     
/*  78 */     if (this.fractionalMetrics) {
/*  79 */       graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
/*     */     } else {
/*  81 */       graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*     */     } 
/*     */     
/*  84 */     FontMetrics fontMetrics = graphics.getFontMetrics();
/*  85 */     int charHeight = 0, positionX = 0, positionY = 1;
/*     */     
/*  87 */     for (int i = 0; i < chars.length; i++) {
/*  88 */       char ch = (char)i;
/*  89 */       CharData charData = new CharData();
/*  90 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), graphics);
/*     */       
/*  92 */       charData.width = (dimensions.getBounds()).width + 8;
/*  93 */       charData.height = (dimensions.getBounds()).height;
/*     */       
/*  95 */       if (positionX + charData.width >= 512) {
/*  96 */         positionX = 0;
/*  97 */         positionY += charHeight;
/*  98 */         charHeight = 0;
/*     */       } 
/*     */       
/* 101 */       if (charData.height > charHeight) {
/* 102 */         charHeight = charData.height;
/*     */       }
/*     */       
/* 105 */       charData.storedX = positionX;
/* 106 */       charData.storedY = positionY;
/*     */       
/* 108 */       if (charData.height > this.fontHeight) {
/* 109 */         this.fontHeight = charData.height;
/*     */       }
/*     */       
/* 112 */       chars[i] = charData;
/*     */       
/* 114 */       graphics.drawString(String.valueOf(ch), positionX + 2, positionY + fontMetrics.getAscent());
/* 115 */       positionX += charData.width;
/*     */     } 
/*     */     
/* 118 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   private void setupBoldItalicFonts() {
/* 122 */     this.texturePlain = setupTexture(this.awtFont, this.antiAlias, this.fractionalMetrics, this.charData);
/* 123 */     this.textureBold = setupTexture(this.awtFont.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 124 */     this.textureItalic = setupTexture(this.awtFont.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/* 125 */     this.textureItalicBold = setupTexture(this.awtFont.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float drawString(CharSequence text, double x, double y, int color, boolean dropShadow) {
/* 131 */     if (dropShadow) {
/* 132 */       float shadowWidth = drawStringInternal(text, x + 0.5D, y + 0.5D, color, true);
/* 133 */       return Math.max(shadowWidth, drawStringInternal(text, x, y, color, false));
/*     */     } 
/* 135 */     return drawStringInternal(text, x, y, color, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public float drawString(CharSequence text, float x, float y, int color, boolean dropShadow) {
/* 140 */     if (dropShadow) {
/* 141 */       float shadowWidth = drawStringInternal(text, x + 0.5D, y + 0.5D, color, true);
/* 142 */       return Math.max(shadowWidth, drawStringInternal(text, x, y, color, false));
/*     */     } 
/* 144 */     return drawStringInternal(text, x, y, color, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private float drawStringInternal(CharSequence text, double x, double y, int color, boolean shadow) {
/* 149 */     x--;
/*     */     
/* 151 */     if (text == null) return 0.0F; 
/* 152 */     if (color == 553648127) color = 16777215; 
/* 153 */     if ((color & 0xFC000000) == 0) color |= 0xFF000000;
/*     */ 
/*     */     
/* 156 */     if (shadow) {
/* 157 */       color = (color & 0xFCFCFC) >> 2 | color & 0xFF000000;
/*     */     }
/*     */     
/* 160 */     CharData[] charData = this.charData;
/* 161 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 162 */     boolean randomCase = false;
/*     */     
/* 164 */     x *= 2.0D;
/* 165 */     y = (y - 3.0D) * 2.0D;
/*     */ 
/*     */     
/* 168 */     GL11.glPushMatrix();
/* 169 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 170 */     GlStateManager.func_179147_l();
/* 171 */     GlStateManager.func_179112_b(770, 771);
/* 172 */     GL11.glColor4f((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 173 */     GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 174 */     GlStateManager.func_179098_w();
/* 175 */     GlStateManager.func_179144_i(this.texturePlain.func_110552_b());
/*     */     
/* 177 */     GL11.glBindTexture(3553, this.texturePlain.func_110552_b());
/* 178 */     GL11.glTexParameterf(3553, 10240, 9729.0F);
/*     */     
/* 180 */     boolean underline = false;
/* 181 */     boolean strikethrough = false;
/* 182 */     boolean italic = false;
/* 183 */     boolean bold = false;
/*     */     
/* 185 */     for (int i = 0, size = text.length(); i < size; i++) {
/* 186 */       char character = text.charAt(i);
/*     */       
/* 188 */       if (character == '§' && i + 1 < size) {
/*     */         
/* 190 */         int colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/*     */         
/* 192 */         if (colorIndex < 16) {
/* 193 */           bold = false;
/* 194 */           italic = false;
/* 195 */           underline = false;
/* 196 */           strikethrough = false;
/* 197 */           GlStateManager.func_179144_i(this.texturePlain.func_110552_b());
/* 198 */           charData = this.charData;
/*     */           
/* 200 */           if (colorIndex < 0) colorIndex = 15; 
/* 201 */           if (shadow) colorIndex += 16;
/*     */           
/* 203 */           int colorCode = COLOR_CODES[colorIndex];
/* 204 */           GlStateManager.func_179131_c((colorCode >> 16 & 0xFF) / 255.0F, (colorCode >> 8 & 0xFF) / 255.0F, (colorCode & 0xFF) / 255.0F, 255.0F);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 209 */         else if (colorIndex == 17) {
/* 210 */           bold = true;
/*     */           
/* 212 */           if (italic) {
/* 213 */             GlStateManager.func_179144_i(this.textureItalicBold.func_110552_b());
/* 214 */             charData = this.boldItalicChars;
/*     */           } else {
/* 216 */             GlStateManager.func_179144_i(this.textureBold.func_110552_b());
/* 217 */             charData = this.boldChars;
/*     */           } 
/* 219 */         } else if (colorIndex == 18) {
/* 220 */           strikethrough = true;
/* 221 */         } else if (colorIndex == 19) {
/* 222 */           underline = true;
/* 223 */         } else if (colorIndex == 20) {
/* 224 */           italic = true;
/*     */           
/* 226 */           if (bold) {
/* 227 */             GlStateManager.func_179144_i(this.textureItalicBold.func_110552_b());
/* 228 */             charData = this.boldItalicChars;
/*     */           } else {
/* 230 */             GlStateManager.func_179144_i(this.textureItalic.func_110552_b());
/* 231 */             charData = this.italicChars;
/*     */           } 
/* 233 */         } else if (colorIndex == 21) {
/* 234 */           bold = false;
/* 235 */           italic = false;
/* 236 */           underline = false;
/* 237 */           strikethrough = false;
/*     */           
/* 239 */           GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, 255.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 244 */           GlStateManager.func_179144_i(this.texturePlain.func_110552_b());
/*     */           
/* 246 */           charData = this.charData;
/*     */         } 
/*     */ 
/*     */         
/* 250 */         i++;
/* 251 */       } else if (character < charData.length) {
/* 252 */         GL11.glBegin(4);
/* 253 */         drawChar(charData, character, (float)x, (float)y);
/* 254 */         GL11.glEnd();
/*     */         
/* 256 */         if (strikethrough) {
/* 257 */           drawLine(x, y + ((charData[character])
/* 258 */               .height / 2.0F), x + (charData[character])
/* 259 */               .width - 8.0D, y + ((charData[character])
/* 260 */               .height / 2.0F), 1.0F);
/*     */         }
/*     */ 
/*     */         
/* 264 */         if (underline) {
/* 265 */           drawLine(x, y + (charData[character])
/* 266 */               .height - 2.0D, x + (charData[character])
/* 267 */               .width - 8.0D, y + (charData[character])
/* 268 */               .height - 2.0D, 1.0F);
/*     */         }
/*     */ 
/*     */         
/* 272 */         x += ((charData[character]).width - ((character == ' ') ? 8 : 9));
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     GL11.glTexParameterf(3553, 10240, 9728.0F);
/* 277 */     GL11.glHint(3155, 4352);
/* 278 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 281 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String trimStringToWidth(CharSequence text, int width, boolean reverse) {
/* 288 */     StringBuilder builder = new StringBuilder();
/*     */     
/* 290 */     float f = 0.0F;
/* 291 */     int i = reverse ? (text.length() - 1) : 0;
/* 292 */     int j = reverse ? -1 : 1;
/* 293 */     boolean flag = false;
/* 294 */     boolean flag1 = false;
/*     */     int k;
/* 296 */     for (k = i; k >= 0 && k < text.length() && f < width; k += j) {
/* 297 */       char c0 = text.charAt(k);
/* 298 */       float f1 = stringWidth(String.valueOf(c0));
/*     */       
/* 300 */       if (flag) {
/* 301 */         flag = false;
/*     */         
/* 303 */         if (c0 != 'l' && c0 != 'L') {
/* 304 */           if (c0 == 'r' || c0 == 'R') {
/* 305 */             flag1 = false;
/*     */           }
/*     */         } else {
/* 308 */           flag1 = true;
/*     */         } 
/* 310 */       } else if (f1 < 0.0F) {
/* 311 */         flag = true;
/*     */       } else {
/* 313 */         f += f1;
/* 314 */         if (flag1) f++;
/*     */       
/*     */       } 
/* 317 */       if (f > width)
/*     */         break; 
/* 319 */       if (reverse) {
/* 320 */         builder.insert(0, c0);
/*     */       } else {
/* 322 */         builder.append(c0);
/*     */       } 
/*     */     } 
/*     */     
/* 326 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int stringWidth(CharSequence text) {
/* 331 */     if (text == null) return 0; 
/* 332 */     int width = 0;
/* 333 */     CharData[] currentData = this.charData;
/* 334 */     boolean bold = false;
/* 335 */     boolean italic = false;
/*     */     
/* 337 */     for (int i = 0, size = text.length(); i < size; i++) {
/* 338 */       char character = text.charAt(i);
/*     */       
/* 340 */       if (character == '§' && i + 1 < size) {
/* 341 */         int colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/*     */         
/* 343 */         if (colorIndex < 16) {
/* 344 */           bold = false;
/* 345 */           italic = false;
/* 346 */         } else if (colorIndex == 17) {
/* 347 */           bold = true;
/* 348 */           if (italic) { currentData = this.boldItalicChars; }
/* 349 */           else { currentData = this.boldChars; } 
/* 350 */         } else if (colorIndex == 20) {
/* 351 */           italic = true;
/* 352 */           if (bold) { currentData = this.boldItalicChars; }
/* 353 */           else { currentData = this.italicChars; } 
/* 354 */         } else if (colorIndex == 21) {
/* 355 */           bold = false;
/* 356 */           italic = false;
/* 357 */           currentData = this.charData;
/*     */         } 
/*     */ 
/*     */         
/* 361 */         i++;
/* 362 */       } else if (character < currentData.length) {
/* 363 */         width += (currentData[character]).width - ((character == ' ') ? 8 : 9);
/*     */       } 
/*     */     } 
/*     */     
/* 367 */     return width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float charWidth(char s) {
/* 372 */     return (((this.charData[s]).width - 8) / 2);
/*     */   }
/*     */   
/*     */   public CharData[] getCharData() {
/* 376 */     return this.charData;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int[] setupMinecraftColorCodes() {
/* 381 */     int[] colorCodes = new int[32];
/*     */     
/* 383 */     for (int i = 0; i < 32; i++) {
/* 384 */       int noClue = (i >> 3 & 0x1) * 85;
/* 385 */       int red = (i >> 2 & 0x1) * 170 + noClue;
/* 386 */       int green = (i >> 1 & 0x1) * 170 + noClue;
/* 387 */       int blue = (i & 0x1) * 170 + noClue;
/*     */       
/* 389 */       if (i == 6) {
/* 390 */         red += 85;
/*     */       }
/*     */       
/* 393 */       if (i >= 16) {
/* 394 */         red >>= 2;
/* 395 */         green >>= 2;
/* 396 */         blue >>= 2;
/*     */       } 
/*     */       
/* 399 */       colorCodes[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */     
/* 402 */     return colorCodes;
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
/* 419 */     drawQuad(x, y, (chars[c]).width, (chars[c]).height, (chars[c]).storedX, (chars[c]).storedY, (chars[c]).width, (chars[c]).height);
/*     */   }
/*     */   
/*     */   private static void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/* 423 */     float renderSRCX = srcX / 512.0F;
/* 424 */     float renderSRCY = srcY / 512.0F;
/* 425 */     float renderSRCWidth = srcWidth / 512.0F;
/* 426 */     float renderSRCHeight = srcHeight / 512.0F;
/*     */ 
/*     */     
/* 429 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 430 */     GL11.glVertex2d((x + width), y);
/* 431 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/* 432 */     GL11.glVertex2d(x, y);
/* 433 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 434 */     GL11.glVertex2d(x, (y + height));
/* 435 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 436 */     GL11.glVertex2d(x, (y + height));
/* 437 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 438 */     GL11.glVertex2d((x + width), (y + height));
/* 439 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 440 */     GL11.glVertex2d((x + width), y);
/*     */   }
/*     */   
/*     */   private static void drawLine(double x, double y, double x1, double y1, float width) {
/* 444 */     GL11.glDisable(3553);
/* 445 */     GL11.glLineWidth(width);
/* 446 */     GL11.glBegin(1);
/* 447 */     GL11.glVertex2d(x, y);
/* 448 */     GL11.glVertex2d(x1, y1);
/* 449 */     GL11.glEnd();
/* 450 */     GL11.glEnable(3553);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 457 */     return this.awtFont.getFamily();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 462 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAntiAlias() {
/* 467 */     return this.antiAlias;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFractionalMetrics() {
/* 472 */     return this.fractionalMetrics;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\fonts\impl\SimpleFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */