/*     */ package net.ccbluex.liquidbounce.font;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class CFontRenderer
/*     */   extends CFont
/*     */ {
/*  17 */   private final int[] colorCode = new int[32];
/*  18 */   private final String colorcodeIdentifiers = "0123456789abcdefklmnor";
/*  19 */   protected CFont.CharData[] boldChars = new CFont.CharData[256];
/*  20 */   protected CFont.CharData[] italicChars = new CFont.CharData[256];
/*  21 */   protected CFont.CharData[] boldItalicChars = new CFont.CharData[256];
/*     */   protected DynamicTexture texBold;
/*     */   protected DynamicTexture texItalic;
/*     */   protected DynamicTexture texItalicBold;
/*     */   
/*     */   public CFontRenderer(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  27 */     super(font, antiAlias, fractionalMetrics);
/*  28 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   public static boolean isChinese(char c) {
/*  32 */     String s = String.valueOf(c);
/*  33 */     return !"1234567890abcdefghijklmnopqrstuvwxyz!<>@#$%^&*()-_=+[]{}|\\/'\",.~`".contains(s.toLowerCase());
/*     */   }
/*     */   
/*     */   public static boolean isChinese(String s) {
/*  37 */     return !"1234567890abcdefghijklmnopqrstuvwxyz!<>@#$%^&*()-_=+[]{}|\\/'\",.~`".contains(s.toLowerCase());
/*     */   }
/*     */   
/*     */   public static char validateLegalString(String content) {
/*  41 */     String illegal = "`~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆";
/*  42 */     char isLegalChar = 't';
/*     */     
/*  44 */     for (int i = 0; i < content.length(); i++) {
/*  45 */       for (int j = 0; j < illegal.length(); j++) {
/*  46 */         if (content.charAt(i) == illegal.charAt(j)) {
/*  47 */           isLegalChar = content.charAt(i);
/*  48 */           return isLegalChar;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  53 */     return isLegalChar;
/*     */   }
/*     */   
/*     */   public static int DisplayFontWidth(String str, CFontRenderer font) {
/*  57 */     int x = 0;
/*  58 */     for (int iF = 0; iF < str.length(); iF++) {
/*  59 */       String s = String.valueOf(str.toCharArray()[iF]);
/*  60 */       if (s.contains("§") && iF + 1 <= str.length()) {
/*  61 */         iF++;
/*  62 */       } else if (!isChinese(s.charAt(0))) {
/*  63 */         x = (int)(x + font.getStringWidth(s));
/*     */       } else {
/*  65 */         x = (int)(x + Fonts.font35.getStringWidth(s));
/*     */       } 
/*     */     } 
/*  68 */     return x + 5;
/*     */   }
/*     */   
/*     */   public static float DisplayFont(CFontRenderer font, String str, float x, float y, int color) {
/*  72 */     return DisplayFont(str, x, y, color, font);
/*     */   }
/*     */   
/*     */   public static float DisplayFonts(CFontRenderer font, String str, float x, float y, int color) {
/*  76 */     return DisplayFont(str, x, y, color, font);
/*     */   }
/*     */   
/*     */   public static float DisplayFont(String str, float x, float y, int color, boolean shadow, CFontRenderer font) {
/*  80 */     str = " " + str;
/*     */     
/*  82 */     for (int iF = 0; iF < str.length(); iF++) {
/*  83 */       String s = String.valueOf(str.toCharArray()[iF]);
/*  84 */       if (s.contains("§") && iF + 1 <= str.length()) {
/*  85 */         color = getColor(String.valueOf(str.toCharArray()[iF + 1]));
/*  86 */         iF++;
/*  87 */       } else if (!isChinese(s.charAt(0))) {
/*  88 */         font.drawString(s, x + 0.5F, y + 1.5F, (new Color(0, 0, 0, 100)).getRGB());
/*  89 */         font.drawString(s, x - 0.5F, y + 0.5F, color);
/*  90 */         x += font.getStringWidth(s);
/*     */       } else {
/*  92 */         Fonts.font35.drawString(s, x + 1.5F, y + 2.0F, (new Color(0, 0, 0, 50)).getRGB());
/*  93 */         Fonts.font35.drawString(s, x + 0.5F, y + 1.0F, color);
/*  94 */         x += Fonts.font35.getStringWidth(s);
/*     */       } 
/*     */     } 
/*  97 */     return x;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float DisplayFont(String str, float x, float y, int color, CFontRenderer font) {
/* 102 */     str = " " + str;
/* 103 */     for (int iF = 0; iF < str.length(); iF++) {
/* 104 */       String s = String.valueOf(str.toCharArray()[iF]);
/* 105 */       if (s.contains("§") && iF + 1 <= str.length()) {
/* 106 */         color = getColor(String.valueOf(str.toCharArray()[iF + 1]));
/* 107 */         iF++;
/* 108 */       } else if (!isChinese(s.charAt(0))) {
/* 109 */         font.drawString(s, x - 0.5F, y + 1.0F, color);
/* 110 */         x += font.getStringWidth(s);
/*     */       } else {
/* 112 */         Fonts.font35.drawString(s, x + 0.5F, y + 1.0F, color);
/* 113 */         x += Fonts.font35.getStringWidth(s);
/*     */       } 
/*     */     } 
/* 116 */     return x;
/*     */   }
/*     */   
/*     */   public static int getColor(String str) {
/* 120 */     switch (str.hashCode()) {
/*     */       case 48:
/* 122 */         if (str.equals("0")) {
/* 123 */           return (new Color(0, 0, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 49:
/* 127 */         if (str.equals("1")) {
/* 128 */           return (new Color(0, 0, 189)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 50:
/* 132 */         if (str.equals("2")) {
/* 133 */           return (new Color(0, 192, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 51:
/* 137 */         if (str.equals("3")) {
/* 138 */           return (new Color(0, 190, 190)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 52:
/* 142 */         if (str.equals("4")) {
/* 143 */           return (new Color(190, 0, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 53:
/* 147 */         if (str.equals("5")) {
/* 148 */           return (new Color(189, 0, 188)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 54:
/* 152 */         if (str.equals("6")) {
/* 153 */           return (new Color(218, 163, 47)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 55:
/* 157 */         if (str.equals("7")) {
/* 158 */           return (new Color(190, 190, 190)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 56:
/* 162 */         if (str.equals("8")) {
/* 163 */           return (new Color(63, 63, 63)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 57:
/* 167 */         if (str.equals("9")) {
/* 168 */           return (new Color(63, 64, 253)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 97:
/* 172 */         if (str.equals("a")) {
/* 173 */           return (new Color(63, 254, 63)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 98:
/* 177 */         if (str.equals("b")) {
/* 178 */           return (new Color(62, 255, 254)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 99:
/* 182 */         if (str.equals("c")) {
/* 183 */           return (new Color(254, 61, 62)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 100:
/* 187 */         if (str.equals("d")) {
/* 188 */           return (new Color(255, 64, 255)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 101:
/* 192 */         if (str.equals("e")) {
/* 193 */           return (new Color(254, 254, 62)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 102:
/* 197 */         if (str.equals("f")) {
/* 198 */           return (new Color(255, 255, 255)).getRGB();
/*     */         }
/*     */         break;
/*     */     } 
/* 202 */     return (new Color(255, 255, 255)).getRGB();
/*     */   }
/*     */   
/*     */   public float drawStringWithShadow(String text, double x, double y, int color) {
/* 206 */     return Math.max(drawString(text, x + 0.5D, y + 0.5D, color, true), drawString(text, x, y, color, false));
/*     */   }
/*     */   
/*     */   public void drawStringWithShadow2(String text, double x, double y, int color) {
/* 210 */     drawString(text, x + 0.5D, y + 0.5D, color, true);
/* 211 */     drawString(text, x, y, color, false);
/*     */   }
/*     */   
/*     */   public float drawString(String text, float x, float y, int color) {
/* 215 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 216 */     return drawString(text, x, y, color, false);
/*     */   }
/*     */   
/*     */   public float drawCenteredString(String text, double x, double y, int color) {
/* 220 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 221 */     return drawString(text, (float)(x - (getStringWidth(text) / 2)), (float)y, color);
/*     */   }
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, float x, float y, int color) {
/* 225 */     return drawStringWithShadow(text, (x - (getStringWidth(text) / 2)), y, color);
/*     */   }
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, double x, double y, int color) {
/* 229 */     return drawStringWithShadow(text, x - (getStringWidth(text) / 2), y, color);
/*     */   }
/*     */   
/*     */   public int DisplayFontWidths(CFontRenderer font, String str) {
/* 233 */     return DisplayFontWidths(str, font);
/*     */   }
/*     */   
/*     */   public int DisplayFontWidths(String str, CFontRenderer font) {
/* 237 */     int x = 0;
/* 238 */     for (int iF = 0; iF < str.length(); iF++) {
/* 239 */       String s = String.valueOf(str.toCharArray()[iF]);
/* 240 */       if (s.contains("§") && iF + 1 <= str.length()) {
/* 241 */         iF++;
/* 242 */       } else if (!isChinese(s.charAt(0))) {
/* 243 */         x = (int)(x + font.getStringWidth(s));
/*     */       } else {
/* 245 */         x = (int)(x + Fonts.font35.getStringWidth(s));
/*     */       } 
/*     */     } 
/* 248 */     return x + 5;
/*     */   }
/*     */   
/*     */   public float DisplayFont2(CFontRenderer font, String str, float x, float y, int color, boolean shadow) {
/* 252 */     if (shadow) {
/* 253 */       return DisplayFont(str, x, y, color, shadow, font);
/*     */     }
/* 255 */     return DisplayFont(str, x, y, color, font);
/*     */   }
/*     */ 
/*     */   
/*     */   public float DisplayFonts(String str, float x, float y, int color, CFontRenderer font) {
/* 260 */     str = " " + str;
/* 261 */     for (int iF = 0; iF < str.length(); iF++) {
/* 262 */       String s = String.valueOf(str.toCharArray()[iF]);
/* 263 */       if (s.contains("§") && iF + 1 <= str.length()) {
/* 264 */         color = getColor(String.valueOf(str.toCharArray()[iF + 1]));
/* 265 */         iF++;
/* 266 */       } else if (!isChinese(s.charAt(0))) {
/* 267 */         font.drawString(s, x - 0.5F, y + 1.0F, color);
/* 268 */         x += font.getStringWidth(s);
/*     */       } else {
/* 270 */         Fonts.font35.drawString(s, x + 0.5F, y + 1.0F, color);
/* 271 */         x += Fonts.font35.getStringWidth(s);
/*     */       } 
/*     */     } 
/* 274 */     return x;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float drawString(String text, float x, float y, int color, boolean shadow) {
/* 280 */     return drawString(text, x, y, color, shadow);
/*     */   }
/*     */   
/*     */   public boolean containsChinese(String str) {
/* 284 */     Pattern p = Pattern.compile("[一-龥]");
/* 285 */     Matcher m = p.matcher(str);
/* 286 */     return m.find();
/*     */   }
/*     */ 
/*     */   
/*     */   public float drawString(String text, double x, double y, int color, boolean shadow) {
/* 291 */     if (containsChinese(text)) {
/* 292 */       return FontLoaders.F16.drawString(text, x, y, color, shadow);
/*     */     }
/*     */     
/* 295 */     double x2 = x - 1.0D;
/* 296 */     if (text == null) {
/* 297 */       return 0.0F;
/*     */     }
/* 299 */     if (color == 553648127) {
/* 300 */       color = 16777215;
/*     */     }
/* 302 */     if ((color & 0xFC000000) == 0) {
/* 303 */       color |= 0xFF000000;
/*     */     }
/* 305 */     if (shadow) {
/* 306 */       color = (new Color(0, 0, 0)).getRGB();
/*     */     }
/* 308 */     CFont.CharData[] currentData = this.charData;
/* 309 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 310 */     boolean bold = false;
/* 311 */     boolean italic = false;
/* 312 */     boolean strikethrough = false;
/* 313 */     boolean underline = false;
/* 314 */     char c = (char)(int)(x2 * 2.0D);
/* 315 */     double y2 = (y - 3.0D) * 2.0D;
/*     */     
/* 317 */     boolean texture = GL11.glIsEnabled(3553);
/* 318 */     boolean blend = GL11.glIsEnabled(3042);
/* 319 */     GL11.glPushMatrix();
/* 320 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 321 */     if (!blend) GlStateManager.func_179147_l(); 
/* 322 */     GlStateManager.func_179112_b(770, 771);
/* 323 */     GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 324 */     int size = text.length();
/* 325 */     if (!texture) GL11.glEnable(3553); 
/* 326 */     GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 327 */     int i = 0;
/* 328 */     while (i < size) {
/* 329 */       char character = text.charAt(i);
/* 330 */       if (character == '§' && i < size) {
/* 331 */         int colorIndex = 21;
/*     */         try {
/* 333 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/* 334 */         } catch (Exception e) {
/* 335 */           e.printStackTrace();
/*     */         } 
/* 337 */         if (colorIndex < 16) {
/* 338 */           bold = false;
/* 339 */           italic = false;
/* 340 */           underline = false;
/* 341 */           strikethrough = false;
/* 342 */           GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 343 */           currentData = this.charData;
/* 344 */           if (colorIndex < 0 || colorIndex > 15) {
/* 345 */             colorIndex = 15;
/*     */           }
/* 347 */           if (shadow) {
/* 348 */             colorIndex += 16;
/*     */           }
/* 350 */           int colorcode = this.colorCode[colorIndex];
/* 351 */           GlStateManager.func_179131_c((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 352 */         } else if (colorIndex != 16) {
/* 353 */           if (colorIndex == 17) {
/* 354 */             bold = true;
/* 355 */             if (italic) {
/* 356 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 357 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 359 */               GlStateManager.func_179144_i(this.texBold.func_110552_b());
/* 360 */               currentData = this.boldChars;
/*     */             } 
/* 362 */           } else if (colorIndex == 18) {
/* 363 */             strikethrough = true;
/* 364 */           } else if (colorIndex == 19) {
/* 365 */             underline = true;
/* 366 */           } else if (colorIndex == 20) {
/* 367 */             italic = true;
/* 368 */             if (bold) {
/* 369 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 370 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 372 */               GlStateManager.func_179144_i(this.texItalic.func_110552_b());
/* 373 */               currentData = this.italicChars;
/*     */             } 
/* 375 */           } else if (colorIndex == 21) {
/* 376 */             bold = false;
/* 377 */             italic = false;
/* 378 */             underline = false;
/* 379 */             strikethrough = false;
/* 380 */             GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 381 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 382 */             currentData = this.charData;
/*     */           } 
/*     */         } 
/* 385 */         i++;
/* 386 */       } else if (character < currentData.length && character >= '\000') {
/* 387 */         GL11.glBegin(4);
/* 388 */         drawChar(currentData, character, c, (float)y2);
/* 389 */         GL11.glEnd();
/* 390 */         if (strikethrough) {
/* 391 */           drawLine(c, y2 + ((currentData[character]).height / 2), c + (currentData[character]).width - 8.0D, y2 + ((currentData[character]).height / 2), 1.0F);
/*     */         }
/* 393 */         if (underline) {
/* 394 */           drawLine(c, y2 + (currentData[character]).height - 2.0D, c + (currentData[character]).width - 8.0D, y2 + (currentData[character]).height - 2.0D, 1.0F);
/*     */         }
/* 396 */         c = (char)(int)(c + ((currentData[character]).width - 8 + this.charOffset));
/*     */       } 
/* 398 */       i++;
/*     */     } 
/* 400 */     if (!blend) GlStateManager.func_179084_k(); 
/* 401 */     if (!texture) GL11.glDisable(3553); 
/* 402 */     GL11.glHint(3155, 4352);
/* 403 */     GL11.glPopMatrix();
/*     */     
/* 405 */     return c / 2.0F;
/*     */   }
/*     */   
/*     */   public int drawStringi(String text, double x, double y, int color, boolean shadow) {
/* 409 */     double x2 = x - 1.0D;
/* 410 */     if (text == null) {
/* 411 */       return 0;
/*     */     }
/* 413 */     if (color == 553648127) {
/* 414 */       color = 16777215;
/*     */     }
/* 416 */     if ((color & 0xFC000000) == 0) {
/* 417 */       color |= 0xFF000000;
/*     */     }
/* 419 */     if (shadow) {
/* 420 */       color = (new Color(0, 0, 0)).getRGB();
/*     */     }
/* 422 */     CFont.CharData[] currentData = this.charData;
/* 423 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 424 */     boolean bold = false;
/* 425 */     boolean italic = false;
/* 426 */     boolean strikethrough = false;
/* 427 */     boolean underline = false;
/* 428 */     char c = (char)(int)(x2 * 2.0D);
/* 429 */     double y2 = (y - 3.0D) * 2.0D;
/*     */     
/* 431 */     boolean texture = GL11.glIsEnabled(3553);
/* 432 */     boolean blend = GL11.glIsEnabled(3042);
/* 433 */     GL11.glPushMatrix();
/* 434 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 435 */     if (!blend) GlStateManager.func_179147_l(); 
/* 436 */     GlStateManager.func_179112_b(770, 771);
/* 437 */     GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 438 */     int size = text.length();
/* 439 */     if (!texture) GL11.glEnable(3553); 
/* 440 */     GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 441 */     int i = 0;
/* 442 */     while (i < size) {
/* 443 */       char character = text.charAt(i);
/* 444 */       if (character == '§' && i < size) {
/* 445 */         int colorIndex = 21;
/*     */         try {
/* 447 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/* 448 */         } catch (Exception e) {
/* 449 */           e.printStackTrace();
/*     */         } 
/* 451 */         if (colorIndex < 16) {
/* 452 */           bold = false;
/* 453 */           italic = false;
/* 454 */           underline = false;
/* 455 */           strikethrough = false;
/* 456 */           GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 457 */           currentData = this.charData;
/* 458 */           if (colorIndex < 0 || colorIndex > 15) {
/* 459 */             colorIndex = 15;
/*     */           }
/* 461 */           if (shadow) {
/* 462 */             colorIndex += 16;
/*     */           }
/* 464 */           int colorcode = this.colorCode[colorIndex];
/* 465 */           GlStateManager.func_179131_c((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 466 */         } else if (colorIndex != 16) {
/* 467 */           if (colorIndex == 17) {
/* 468 */             bold = true;
/* 469 */             if (italic) {
/* 470 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 471 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 473 */               GlStateManager.func_179144_i(this.texBold.func_110552_b());
/* 474 */               currentData = this.boldChars;
/*     */             } 
/* 476 */           } else if (colorIndex == 18) {
/* 477 */             strikethrough = true;
/* 478 */           } else if (colorIndex == 19) {
/* 479 */             underline = true;
/* 480 */           } else if (colorIndex == 20) {
/* 481 */             italic = true;
/* 482 */             if (bold) {
/* 483 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 484 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 486 */               GlStateManager.func_179144_i(this.texItalic.func_110552_b());
/* 487 */               currentData = this.italicChars;
/*     */             } 
/* 489 */           } else if (colorIndex == 21) {
/* 490 */             bold = false;
/* 491 */             italic = false;
/* 492 */             underline = false;
/* 493 */             strikethrough = false;
/* 494 */             GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 495 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 496 */             currentData = this.charData;
/*     */           } 
/*     */         } 
/* 499 */         i++;
/* 500 */       } else if (character < currentData.length && character >= '\000') {
/* 501 */         GL11.glBegin(4);
/* 502 */         drawChar(currentData, character, c, (float)y2);
/* 503 */         GL11.glEnd();
/* 504 */         if (strikethrough) {
/* 505 */           drawLine(c, y2 + ((currentData[character]).height / 2), c + (currentData[character]).width - 8.0D, y2 + ((currentData[character]).height / 2), 1.0F);
/*     */         }
/* 507 */         if (underline) {
/* 508 */           drawLine(c, y2 + (currentData[character]).height - 2.0D, c + (currentData[character]).width - 8.0D, y2 + (currentData[character]).height - 2.0D, 1.0F);
/*     */         }
/* 510 */         c = (char)(int)(c + ((currentData[character]).width - 8 + this.charOffset));
/*     */       } 
/* 512 */       i++;
/*     */     } 
/* 514 */     if (!blend) GlStateManager.func_179084_k(); 
/* 515 */     if (!texture) GL11.glDisable(3553); 
/* 516 */     GL11.glHint(3155, 4352);
/* 517 */     GL11.glPopMatrix();
/*     */     
/* 519 */     return c / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStringWidth(String text) {
/* 524 */     if (text == null) {
/* 525 */       return 0;
/*     */     }
/* 527 */     int width = 0;
/* 528 */     CFont.CharData[] currentData = this.charData;
/* 529 */     boolean bold = false;
/* 530 */     boolean italic = false;
/* 531 */     int size = text.length();
/* 532 */     int i = 0;
/* 533 */     while (i < size) {
/* 534 */       char character = text.charAt(i);
/* 535 */       if (character == '§' && i < size) {
/* 536 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/* 537 */         if (colorIndex < 16) {
/* 538 */           bold = false;
/* 539 */           italic = false;
/* 540 */         } else if (colorIndex == 17) {
/* 541 */           bold = true;
/* 542 */           currentData = italic ? this.boldItalicChars : this.boldChars;
/* 543 */         } else if (colorIndex == 20) {
/* 544 */           italic = true;
/* 545 */           currentData = bold ? this.boldItalicChars : this.italicChars;
/* 546 */         } else if (colorIndex == 21) {
/* 547 */           bold = false;
/* 548 */           italic = false;
/* 549 */           currentData = this.charData;
/*     */         } 
/* 551 */         i++;
/* 552 */       } else if (character < currentData.length && character >= '\000') {
/* 553 */         width += (currentData[character]).width - 8 + this.charOffset;
/*     */       } 
/* 555 */       i++;
/*     */     } 
/* 557 */     return width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font font) {
/* 562 */     setFont(font);
/* 563 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 568 */     setAntiAlias(antiAlias);
/* 569 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 574 */     setFractionalMetrics(fractionalMetrics);
/* 575 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   private void setupBoldItalicIDs() {
/* 579 */     this.texBold = setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 580 */     this.texItalic = setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/*     */   }
/*     */   
/*     */   private void drawLine(double x, double y, double x1, double y1, float width) {
/* 584 */     GL11.glDisable(3553);
/* 585 */     GL11.glLineWidth(width);
/* 586 */     GL11.glBegin(1);
/* 587 */     GL11.glVertex2d(x, y);
/* 588 */     GL11.glVertex2d(x1, y1);
/* 589 */     GL11.glEnd();
/* 590 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public List<String> wrapWords(String text, double width) {
/* 594 */     ArrayList<String> finalWords = new ArrayList<>();
/* 595 */     if (getStringWidth(text) > width) {
/* 596 */       String[] words = text.split(" ");
/* 597 */       String currentWord = "";
/* 598 */       char c = Character.MAX_VALUE;
/* 599 */       for (String word : words) {
/* 600 */         for (int i = 0; i < (word.toCharArray()).length; i++) {
/* 601 */           if (word.toCharArray()[i] == '§' && i < (word.toCharArray()).length - 1) {
/* 602 */             c = word.toCharArray()[i + 1];
/*     */           }
/*     */         } 
/* 605 */         if (getStringWidth(currentWord + word + " ") < width) {
/* 606 */           currentWord = currentWord + word + " ";
/*     */         } else {
/* 608 */           finalWords.add(currentWord);
/* 609 */           currentWord = (167 + c) + word + " ";
/*     */         } 
/*     */       } 
/* 612 */       if (currentWord.length() > 0) {
/* 613 */         if (getStringWidth(currentWord) < width) {
/* 614 */           finalWords.add((167 + c) + currentWord + " ");
/*     */         } else {
/* 616 */           for (String s : formatString(currentWord, width)) {
/* 617 */             finalWords.add(s);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } else {
/* 622 */       finalWords.add(text);
/*     */     } 
/* 624 */     return finalWords;
/*     */   }
/*     */   
/*     */   public List<String> formatString(String string, double width) {
/* 628 */     ArrayList<String> finalWords = new ArrayList<>();
/* 629 */     String currentWord = "";
/* 630 */     int lastColorCode = 65535;
/* 631 */     char[] chars = string.toCharArray();
/* 632 */     for (int i = 0; i < chars.length; i++) {
/* 633 */       char c = chars[i];
/* 634 */       if (c == '§' && i < chars.length - 1) {
/* 635 */         lastColorCode = chars[i + 1];
/*     */       }
/* 637 */       if (getStringWidth(currentWord + c) < width) {
/* 638 */         currentWord = currentWord + c;
/*     */       } else {
/* 640 */         finalWords.add(currentWord);
/* 641 */         currentWord = String.valueOf(167 + lastColorCode) + c;
/*     */       } 
/*     */     } 
/* 644 */     if (currentWord.length() > 0) {
/* 645 */       finalWords.add(currentWord);
/*     */     }
/* 647 */     return finalWords;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\font\CFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */