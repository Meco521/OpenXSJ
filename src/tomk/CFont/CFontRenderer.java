/*     */ package tomk.CFont;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tomk.LanguageManager;
/*     */ 
/*     */ public class CFontRenderer
/*     */   extends CFont
/*     */ {
/*  18 */   protected CFont.CharData[] boldChars = new CFont.CharData[256];
/*  19 */   protected CFont.CharData[] italicChars = new CFont.CharData[256];
/*  20 */   protected CFont.CharData[] boldItalicChars = new CFont.CharData[256];
/*  21 */   private final int[] colorCode = new int[32];
/*  22 */   private final String colorcodeIdentifiers = "0123456789abcdefklmnor";
/*     */   protected DynamicTexture texBold;
/*     */   protected DynamicTexture texItalic;
/*     */   protected DynamicTexture texItalicBold;
/*     */   
/*     */   public CFontRenderer(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  28 */     super(font, antiAlias, fractionalMetrics);
/*  29 */     setupMinecraftColorcodes();
/*  30 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   public float drawStringWithShadow(String text, double x, double y, int color) {
/*  34 */     float shadowWidth = drawString(text, x + 0.5D, y + 0.5D, color, true);
/*     */     
/*  36 */     return Math.max(shadowWidth, drawString(text, x, y, color, false));
/*     */   }
/*     */   
/*     */   public float drawString(String text, float x, float y, int color) {
/*  40 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  41 */     RenderUtils.color(color);
/*  42 */     return drawString(text, x, y, color, false);
/*     */   }
/*     */   public float drawString(String text, int x, int y, int color) {
/*  45 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  46 */     RenderUtils.color(color);
/*  47 */     return drawString(text, x, y, color, false);
/*     */   }
/*     */   public float drawCenteredString(String text, double x, double y, int color) {
/*  50 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  51 */     return drawString(text, (float)(x - (getStringWidth(text) / 2)), (float)y, color);
/*     */   }
/*     */   public float drawCenteredString(String text, float x, float y, int color) {
/*  54 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  55 */     return drawString(text, (float)(x - (getStringWidth(text) / 2)), y, color);
/*     */   }
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, float x, float y, int color) {
/*  59 */     return drawStringWithShadow(text, (x - (getStringWidth(text) / 2)), y, color);
/*     */   }
/*     */   public static boolean isChinese(char c) {
/*  62 */     String s = String.valueOf(c);
/*  63 */     if (!"1234567890abcdefghijklmnopqrstuvwxyz!<>@#$%^&*()-_=+[]{}|\\/'\",.~`".contains(s.toLowerCase())) {
/*  64 */       return true;
/*     */     }
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, double x, double y, int color) {
/*  71 */     return drawStringWithShadow(text, x - (getStringWidth(text) / 2), y, color);
/*     */   }
/*     */   public static float DisplayFont(String str, float x, float y, int color, CFontRenderer font) {
/*  74 */     str = LanguageManager.INSTANCE.get(LanguageManager.INSTANCE.replace(str));
/*  75 */     str = " " + str;
/*  76 */     for (int iF = 0; iF < str.length(); iF++) {
/*  77 */       String s = String.valueOf(str.toCharArray()[iF]);
/*  78 */       if (s.contains("§") && iF + 1 <= str.length()) {
/*  79 */         color = getColor(String.valueOf(str.toCharArray()[iF + 1]));
/*  80 */         iF++;
/*  81 */       } else if (!isChinese(s.charAt(0))) {
/*  82 */         font.drawString(s, x - 0.5F, y + 1.0F, color);
/*  83 */         x += font.getStringWidth(s);
/*     */       } else {
/*  85 */         Fonts.font40.drawString(s, x + 0.5F, y + 1.0F, color);
/*  86 */         x += Fonts.font40.getStringWidth(s);
/*     */       } 
/*     */     } 
/*  89 */     return x;
/*     */   }
/*     */   public float DisplayFont(CFontRenderer font, String str, int x, float y, int color) {
/*  92 */     return DisplayFont(str, x, y, color, font);
/*     */   }
/*     */   
/*     */   public float DisplayFonts(CFontRenderer font, String str, int x, int y, int color) {
/*  96 */     return DisplayFont(str, x, y, color, font);
/*     */   }
/*     */   
/*     */   public float DisplayFonts(String str, float x, float y, int color, CFontRenderer font) {
/* 100 */     str = LanguageManager.INSTANCE.get(LanguageManager.INSTANCE.replace(str));
/* 101 */     str = " " + str;
/* 102 */     for (int iF = 0; iF < str.length(); iF++) {
/* 103 */       String s = String.valueOf(str.toCharArray()[iF]);
/* 104 */       if (s.contains("§") && iF + 1 <= str.length()) {
/* 105 */         color = getColor(String.valueOf(str.toCharArray()[iF + 1]));
/* 106 */         iF++;
/* 107 */       } else if (!isChinese(s.charAt(0))) {
/* 108 */         font.drawString(s, x - 0.5F, y + 1.0F, color);
/* 109 */         x += font.getStringWidth(s);
/*     */       } else {
/* 111 */         Fonts.font40.drawString(s, x + 0.5F, y + 1.0F, color);
/* 112 */         x += Fonts.font40.getStringWidth(s);
/*     */       } 
/*     */     } 
/* 115 */     return x;
/*     */   }
/*     */   public float DisplayFont2(CFontRenderer font, String str, int x, int y, int color, boolean shadow) {
/* 118 */     if (shadow) {
/* 119 */       return DisplayFont(str, x, y, color, shadow, font);
/*     */     }
/* 121 */     return DisplayFont(str, x, y, color, font);
/*     */   }
/*     */   
/*     */   public static int getColor(String str) {
/* 125 */     switch (str.hashCode()) {
/*     */       case 48:
/* 127 */         if (str.equals("0")) {
/* 128 */           return (new Color(0, 0, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 49:
/* 132 */         if (str.equals("1")) {
/* 133 */           return (new Color(0, 0, 189)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 50:
/* 137 */         if (str.equals("2")) {
/* 138 */           return (new Color(0, 192, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 51:
/* 142 */         if (str.equals("3")) {
/* 143 */           return (new Color(0, 190, 190)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 52:
/* 147 */         if (str.equals("4")) {
/* 148 */           return (new Color(190, 0, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 53:
/* 152 */         if (str.equals("5")) {
/* 153 */           return (new Color(189, 0, 188)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 54:
/* 157 */         if (str.equals("6")) {
/* 158 */           return (new Color(218, 163, 47)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 55:
/* 162 */         if (str.equals("7")) {
/* 163 */           return (new Color(190, 190, 190)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 56:
/* 167 */         if (str.equals("8")) {
/* 168 */           return (new Color(63, 63, 63)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 57:
/* 172 */         if (str.equals("9")) {
/* 173 */           return (new Color(63, 64, 253)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 97:
/* 177 */         if (str.equals("a")) {
/* 178 */           return (new Color(63, 254, 63)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 98:
/* 182 */         if (str.equals("b")) {
/* 183 */           return (new Color(62, 255, 254)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 99:
/* 187 */         if (str.equals("c")) {
/* 188 */           return (new Color(254, 61, 62)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 100:
/* 192 */         if (str.equals("d")) {
/* 193 */           return (new Color(255, 64, 255)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 101:
/* 197 */         if (str.equals("e")) {
/* 198 */           return (new Color(254, 254, 62)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 102:
/* 202 */         if (str.equals("f")) {
/* 203 */           return (new Color(255, 255, 255)).getRGB();
/*     */         }
/*     */         break;
/*     */     } 
/* 207 */     return (new Color(255, 255, 255)).getRGB();
/*     */   }
/*     */   public static float DisplayFont(String str, float x, float y, int color, boolean shadow, CFontRenderer font) {
/* 210 */     str = LanguageManager.INSTANCE.get(LanguageManager.INSTANCE.replace(str));
/* 211 */     str = " " + str;
/*     */     
/* 213 */     for (int iF = 0; iF < str.length(); iF++) {
/* 214 */       String s = String.valueOf(str.toCharArray()[iF]);
/* 215 */       if (s.contains("§") && iF + 1 <= str.length()) {
/* 216 */         color = getColor(String.valueOf(str.toCharArray()[iF + 1]));
/* 217 */         iF++;
/* 218 */       } else if (!isChinese(s.charAt(0))) {
/* 219 */         font.drawString(s, x + 0.5F, y + 1.5F, (new Color(0, 0, 0, 100)).getRGB());
/* 220 */         font.drawString(s, x - 0.5F, y + 0.5F, color);
/* 221 */         x += font.getStringWidth(s);
/*     */       } else {
/* 223 */         Fonts.font40.drawString(s, x + 1.5F, y + 2.0F, (new Color(0, 0, 0, 50)).getRGB());
/* 224 */         Fonts.font40.drawString(s, x + 0.5F, y + 1.0F, color);
/* 225 */         x += Fonts.font40.getStringWidth(s);
/*     */       } 
/*     */     } 
/* 228 */     return x;
/*     */   }
/*     */   
/*     */   public int DisplayFontWidths(String str, CFontRenderer font) {
/* 232 */     str = LanguageManager.INSTANCE.get(LanguageManager.INSTANCE.replace(str));
/* 233 */     int x = 0;
/* 234 */     for (int iF = 0; iF < str.length(); iF++) {
/* 235 */       String s = String.valueOf(str.toCharArray()[iF]);
/* 236 */       if (s.contains("§") && iF + 1 <= str.length()) {
/* 237 */         iF++;
/* 238 */       } else if (!isChinese(s.charAt(0))) {
/* 239 */         x = (int)(x + font.getStringWidth(s));
/*     */       } else {
/* 241 */         x = (int)(x + Fonts.font40.getStringWidth(s));
/*     */       } 
/*     */     } 
/* 244 */     return x + 5;
/*     */   }
/*     */   public float drawString(String text, double x, double y, int color, boolean shadow) {
/* 247 */     GlStateManager.func_179147_l();
/* 248 */     GlStateManager.func_179084_k();
/* 249 */     x--;
/* 250 */     if (text == null) {
/* 251 */       return 0.0F;
/*     */     }
/* 253 */     if (color == 553648127) {
/* 254 */       color = 16777215;
/*     */     }
/*     */     
/* 257 */     if ((color & 0xFC000000) == 0) {
/* 258 */       color |= 0xFF000000;
/*     */     }
/*     */     
/* 261 */     if (shadow) {
/* 262 */       color = (new Color(0, 0, 0)).getRGB();
/*     */     }
/*     */     
/* 265 */     CFont.CharData[] currentData = this.charData;
/* 266 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 267 */     boolean randomCase = false;
/* 268 */     boolean bold = false;
/* 269 */     boolean italic = false;
/* 270 */     boolean strikethrough = false;
/* 271 */     boolean underline = false;
/* 272 */     boolean render = true;
/*     */     
/* 274 */     x *= 2.0D;
/* 275 */     y = (y - 3.0D) * 2.0D;
/* 276 */     if (render) {
/* 277 */       GL11.glPushMatrix();
/* 278 */       GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 279 */       GlStateManager.func_179147_l();
/* 280 */       GlStateManager.func_179112_b(770, 771);
/* 281 */       GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 282 */       int size = text.length();
/*     */       
/* 284 */       GlStateManager.func_179098_w();
/* 285 */       GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 286 */       GL11.glBindTexture(3553, this.tex.func_110552_b());
/*     */       
/* 288 */       for (int i = 0; i < size; i++) {
/* 289 */         char character = text.charAt(i);
/*     */         
/* 291 */         if (character == '§' && i < size) {
/* 292 */           int colorIndex = 21;
/*     */           
/*     */           try {
/* 295 */             colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/* 296 */           } catch (Exception exception) {
/* 297 */             exception.printStackTrace();
/*     */           } 
/*     */           
/* 300 */           if (colorIndex < 16) {
/* 301 */             bold = false;
/* 302 */             italic = false;
/* 303 */             randomCase = false;
/* 304 */             underline = false;
/* 305 */             strikethrough = false;
/* 306 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 307 */             currentData = this.charData;
/* 308 */             if (colorIndex < 0 || colorIndex > 15) {
/* 309 */               colorIndex = 15;
/*     */             }
/*     */             
/* 312 */             if (shadow) {
/* 313 */               colorIndex += 16;
/*     */             }
/*     */             
/* 316 */             int colorcode = this.colorCode[colorIndex];
/*     */             
/* 318 */             GlStateManager.func_179131_c((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 319 */           } else if (colorIndex == 16) {
/* 320 */             randomCase = true;
/* 321 */           } else if (colorIndex == 17) {
/* 322 */             bold = true;
/* 323 */             if (italic) {
/* 324 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 325 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 327 */               GlStateManager.func_179144_i(this.texBold.func_110552_b());
/* 328 */               currentData = this.boldChars;
/*     */             } 
/* 330 */           } else if (colorIndex == 18) {
/* 331 */             strikethrough = true;
/* 332 */           } else if (colorIndex == 19) {
/* 333 */             underline = true;
/* 334 */           } else if (colorIndex == 20) {
/* 335 */             italic = true;
/* 336 */             if (bold) {
/* 337 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 338 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 340 */               GlStateManager.func_179144_i(this.texItalic.func_110552_b());
/* 341 */               currentData = this.italicChars;
/*     */             } 
/* 343 */           } else if (colorIndex == 21) {
/* 344 */             bold = false;
/* 345 */             italic = false;
/* 346 */             randomCase = false;
/* 347 */             underline = false;
/* 348 */             strikethrough = false;
/* 349 */             GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 350 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 351 */             currentData = this.charData;
/*     */           } 
/*     */           
/* 354 */           i++;
/* 355 */         } else if (character < currentData.length && character >= '\000') {
/* 356 */           GL11.glBegin(4);
/* 357 */           drawChar(currentData, character, (float)x, (float)y);
/* 358 */           GL11.glEnd();
/* 359 */           if (strikethrough) {
/* 360 */             drawLine(x, y + ((currentData[character]).height / 2), x + (currentData[character]).width - 8.0D, y + ((currentData[character]).height / 2), 1.0F);
/*     */           }
/*     */           
/* 363 */           if (underline) {
/* 364 */             drawLine(x, y + (currentData[character]).height - 2.0D, x + (currentData[character]).width - 8.0D, y + (currentData[character]).height - 2.0D, 1.0F);
/*     */           }
/*     */           
/* 367 */           x += ((currentData[character]).width - 8 + this.charOffset);
/*     */         } 
/*     */       } 
/*     */       
/* 371 */       GL11.glHint(3155, 4352);
/* 372 */       GL11.glPopMatrix();
/*     */     } 
/*     */     
/* 375 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStringWidth(String text) {
/* 380 */     if (text == null) {
/* 381 */       return 0;
/*     */     }
/* 383 */     int width = 0;
/* 384 */     CFont.CharData[] currentData = this.charData;
/* 385 */     boolean bold = false;
/* 386 */     boolean italic = false;
/* 387 */     int size = text.length();
/*     */     
/* 389 */     for (int i = 0; i < size; i++) {
/* 390 */       char character = text.charAt(i);
/*     */       
/* 392 */       if (character == '§' && i < size) {
/* 393 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/*     */         
/* 395 */         if (colorIndex < 16) {
/* 396 */           bold = false;
/* 397 */           italic = false;
/* 398 */         } else if (colorIndex == 17) {
/* 399 */           bold = true;
/* 400 */           currentData = italic ? this.boldItalicChars : this.boldChars;
/* 401 */         } else if (colorIndex == 20) {
/* 402 */           italic = true;
/* 403 */           currentData = bold ? this.boldItalicChars : this.italicChars;
/* 404 */         } else if (colorIndex == 21) {
/* 405 */           bold = false;
/* 406 */           italic = false;
/* 407 */           currentData = this.charData;
/*     */         } 
/*     */         
/* 410 */         i++;
/* 411 */       } else if (character < currentData.length && character >= '\000') {
/* 412 */         width += (currentData[character]).width - 8 + this.charOffset;
/*     */       } 
/*     */     } 
/*     */     
/* 416 */     return width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font font) {
/* 421 */     super.setFont(font);
/* 422 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 426 */     super.setAntiAlias(antiAlias);
/* 427 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 431 */     super.setFractionalMetrics(fractionalMetrics);
/* 432 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   private void setupBoldItalicIDs() {
/* 436 */     this.texBold = setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 437 */     this.texItalic = setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/*     */   }
/*     */   
/*     */   private void drawLine(double x, double y, double x1, double y1, float width) {
/* 441 */     GL11.glDisable(3553);
/* 442 */     GL11.glLineWidth(width);
/* 443 */     GL11.glBegin(1);
/* 444 */     GL11.glVertex2d(x, y);
/* 445 */     GL11.glVertex2d(x1, y1);
/* 446 */     GL11.glEnd();
/* 447 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public List wrapWords(String text, double width) {
/* 451 */     ArrayList<String> finalWords = new ArrayList();
/*     */     
/* 453 */     if (getStringWidth(text) > width) {
/* 454 */       String[] words = text.split(" ");
/* 455 */       String currentWord = "";
/* 456 */       char lastColorCode = Character.MAX_VALUE;
/* 457 */       String[] arrstring = words;
/* 458 */       int n = words.length;
/*     */       
/* 460 */       for (int n2 = 0; n2 < n; n2++) {
/* 461 */         String word = arrstring[n2];
/*     */         
/* 463 */         for (int s = 0; s < (word.toCharArray()).length; s++) {
/* 464 */           char c = word.toCharArray()[s];
/*     */           
/* 466 */           if (c == '§' && s < (word.toCharArray()).length - 1) {
/* 467 */             lastColorCode = word.toCharArray()[s + 1];
/*     */           }
/*     */         } 
/*     */         
/* 471 */         if (getStringWidth(currentWord + word + " ") < width) {
/* 472 */           currentWord = currentWord + word + " ";
/*     */         } else {
/* 474 */           finalWords.add(currentWord);
/* 475 */           currentWord = (167 + lastColorCode) + word + " ";
/*     */         } 
/*     */       } 
/*     */       
/* 479 */       if (currentWord.length() > 0) {
/* 480 */         if (getStringWidth(currentWord) < width) {
/* 481 */           finalWords.add((167 + lastColorCode) + currentWord + " ");
/* 482 */           currentWord = "";
/*     */         } else {
/* 484 */           Iterator<String> iterator = formatString(currentWord, width).iterator();
/*     */           
/* 486 */           while (iterator.hasNext()) {
/* 487 */             String s = iterator.next();
/*     */             
/* 489 */             finalWords.add(s);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/* 494 */       finalWords.add(text);
/*     */     } 
/*     */     
/* 497 */     return finalWords;
/*     */   }
/*     */   
/*     */   public List formatString(String string, double width) {
/* 501 */     ArrayList<String> finalWords = new ArrayList();
/* 502 */     String currentWord = "";
/* 503 */     char lastColorCode = Character.MAX_VALUE;
/* 504 */     char[] chars = string.toCharArray();
/*     */     
/* 506 */     for (int i = 0; i < chars.length; i++) {
/* 507 */       char c = chars[i];
/*     */       
/* 509 */       if (c == '§' && i < chars.length - 1) {
/* 510 */         lastColorCode = chars[i + 1];
/*     */       }
/*     */       
/* 513 */       if (getStringWidth(currentWord + c) < width) {
/* 514 */         currentWord = currentWord + c;
/*     */       } else {
/* 516 */         finalWords.add(currentWord);
/* 517 */         currentWord = (167 + lastColorCode) + String.valueOf(c);
/*     */       } 
/*     */     } 
/*     */     
/* 521 */     if (currentWord.length() > 0) {
/* 522 */       finalWords.add(currentWord);
/*     */     }
/*     */     
/* 525 */     return finalWords;
/*     */   }
/*     */   
/*     */   private void setupMinecraftColorcodes() {
/* 529 */     for (int index = 0; index < 32; index++) {
/* 530 */       int noClue = (index >> 3 & 0x1) * 85;
/* 531 */       int red = (index >> 2 & 0x1) * 170 + noClue;
/* 532 */       int green = (index >> 1 & 0x1) * 170 + noClue;
/* 533 */       int blue = (index >> 0 & 0x1) * 170 + noClue;
/*     */       
/* 535 */       if (index == 6) {
/* 536 */         red += 85;
/*     */       }
/*     */       
/* 539 */       if (index >= 16) {
/* 540 */         red /= 4;
/* 541 */         green /= 4;
/* 542 */         blue /= 4;
/*     */       } 
/*     */       
/* 545 */       this.colorCode[index] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\CFont\CFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */