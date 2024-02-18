/*     */ package net.ccbluex.liquidbounce.ui.client.font1;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import net.ccbluex.liquidbounce.ui.font.FontDrawer;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CFontRenderer
/*     */   extends CFont
/*     */ {
/*  23 */   protected CFont.CharData[] boldChars = new CFont.CharData[256];
/*  24 */   protected CFont.CharData[] italicChars = new CFont.CharData[256];
/*  25 */   protected CFont.CharData[] boldItalicChars = new CFont.CharData[256];
/*  26 */   private final int[] colorCode = new int[32];
/*  27 */   private final String colorcodeIdentifiers = "0123456789abcdefklmnor";
/*     */   protected DynamicTexture texBold;
/*     */   protected DynamicTexture texItalic;
/*     */   protected DynamicTexture texItalicBold;
/*     */   
/*     */   public CFontRenderer(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  33 */     super(font, antiAlias, fractionalMetrics);
/*  34 */     setupMinecraftColorcodes();
/*  35 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   public float drawStringWithShadow(String text, double x, double y, int color) {
/*  39 */     return Math.max(drawString(text, x + 0.5D, y + 0.5D, color, true), drawString(text, x, y, color, false));
/*     */   }
/*     */   
/*     */   public float drawString(String text, float x, float y, int color) {
/*  43 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  44 */     RenderUtils.glColor(color);
/*  45 */     return drawString(text, x, y, color, false);
/*     */   }
/*     */   public float drawStringWithShadow2(String text, double x, double y, int color) {
/*  48 */     return Math.max(drawString(text, x + 0.5D, y + 0.5D, color, true), drawString(text, x, y, color, true));
/*     */   }
/*     */   
/*     */   public float drawCenteredString(String text, double x, double y, int color) {
/*  52 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  53 */     return drawString(text, (float)(x - (getStringWidth(text) / 2)), (float)y, color);
/*     */   }
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, float x, float y, int color) {
/*  57 */     return drawStringWithShadow(text, (x - (getStringWidth(text) / 2)), y, color);
/*     */   }
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, double x, double y, int color) {
/*  61 */     return drawStringWithShadow(text, x - (getStringWidth(text) / 2), y, color);
/*     */   }
/*     */   public static boolean isChinese(char c) {
/*  64 */     String s = String.valueOf(c);
/*  65 */     if (!"1234567890abcdefghijklmnopqrstuvwxyz!<>@#$%^&*()-_=+[]{}|\\/'\",.~`".contains(s.toLowerCase())) {
/*  66 */       return true;
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isContainChinese(String str) {
/*  73 */     Pattern p = Pattern.compile("[一-龥]");
/*  74 */     Matcher m = p.matcher(str);
/*  75 */     return m.find();
/*     */   }
/*     */   
/*     */   public static char validateLegalString(String content) {
/*  79 */     String illegal = "`~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆";
/*  80 */     char isLegalChar = 't';
/*     */     
/*  82 */     for (int i = 0; i < content.length(); i++) {
/*  83 */       for (int j = 0; j < illegal.length(); j++) {
/*  84 */         if (content.charAt(i) == illegal.charAt(j)) {
/*  85 */           isLegalChar = content.charAt(i);
/*  86 */           return isLegalChar;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     return isLegalChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getColor(String str) {
/*  98 */     switch (str.hashCode()) {
/*     */       case 48:
/* 100 */         if (str.equals("0")) {
/* 101 */           return (new Color(0, 0, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 49:
/* 105 */         if (str.equals("1")) {
/* 106 */           return (new Color(0, 0, 189)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 50:
/* 110 */         if (str.equals("2")) {
/* 111 */           return (new Color(0, 192, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 51:
/* 115 */         if (str.equals("3")) {
/* 116 */           return (new Color(0, 190, 190)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 52:
/* 120 */         if (str.equals("4")) {
/* 121 */           return (new Color(190, 0, 0)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 53:
/* 125 */         if (str.equals("5")) {
/* 126 */           return (new Color(189, 0, 188)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 54:
/* 130 */         if (str.equals("6")) {
/* 131 */           return (new Color(218, 163, 47)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 55:
/* 135 */         if (str.equals("7")) {
/* 136 */           return (new Color(190, 190, 190)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 56:
/* 140 */         if (str.equals("8")) {
/* 141 */           return (new Color(63, 63, 63)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 57:
/* 145 */         if (str.equals("9")) {
/* 146 */           return (new Color(63, 64, 253)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 97:
/* 150 */         if (str.equals("a")) {
/* 151 */           return (new Color(63, 254, 63)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 98:
/* 155 */         if (str.equals("b")) {
/* 156 */           return (new Color(62, 255, 254)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 99:
/* 160 */         if (str.equals("c")) {
/* 161 */           return (new Color(254, 61, 62)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 100:
/* 165 */         if (str.equals("d")) {
/* 166 */           return (new Color(255, 64, 255)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 101:
/* 170 */         if (str.equals("e")) {
/* 171 */           return (new Color(254, 254, 62)).getRGB();
/*     */         }
/*     */         break;
/*     */       case 102:
/* 175 */         if (str.equals("f")) {
/* 176 */           return (new Color(255, 255, 255)).getRGB();
/*     */         }
/*     */         break;
/*     */     } 
/* 180 */     return (new Color(255, 255, 255)).getRGB();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float drawString(String text, float x, float y, int color, boolean shadow) {
/* 186 */     return drawString(text, Double.valueOf(x).doubleValue(), Double.valueOf(y).doubleValue(), color, shadow);
/*     */   }
/*     */   public float drawString(String text, double x, double y, int color, boolean shadow) {
/* 189 */     GlStateManager.func_179147_l();
/* 190 */     GlStateManager.func_179084_k();
/* 191 */     double x2 = x - 1.0D;
/* 192 */     if (text == null) {
/* 193 */       return 0.0F;
/*     */     }
/* 195 */     if (color == 553648127) {
/* 196 */       color = 16777215;
/*     */     }
/* 198 */     if ((color & 0xFC000000) == 0) {
/* 199 */       color |= 0xFF000000;
/*     */     }
/* 201 */     if (shadow) {
/* 202 */       color = (new Color(0, 0, 0)).getRGB();
/*     */     }
/* 204 */     CFont.CharData[] currentData = this.charData;
/* 205 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 206 */     boolean bold = false;
/* 207 */     boolean italic = false;
/* 208 */     boolean strikethrough = false;
/* 209 */     boolean underline = false;
/* 210 */     char c = (char)(int)(x2 * 2.0D);
/* 211 */     double y2 = (y - 3.0D) * 2.0D;
/*     */     
/* 213 */     GL11.glPushMatrix();
/* 214 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 215 */     GlStateManager.func_179147_l();
/* 216 */     GlStateManager.func_179112_b(770, 771);
/* 217 */     GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 218 */     int size = text.length();
/* 219 */     GlStateManager.func_179098_w();
/* 220 */     GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 221 */     GL11.glBindTexture(3553, this.tex.func_110552_b());
/* 222 */     int i = 0;
/* 223 */     while (i < size) {
/* 224 */       char character = text.charAt(i);
/* 225 */       if (character == '§' && i < size) {
/* 226 */         int colorIndex = 21;
/*     */         try {
/* 228 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/* 229 */         } catch (Exception e) {
/* 230 */           e.printStackTrace();
/*     */         } 
/* 232 */         if (colorIndex < 16) {
/* 233 */           bold = false;
/* 234 */           italic = false;
/* 235 */           underline = false;
/* 236 */           strikethrough = false;
/* 237 */           GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 238 */           currentData = this.charData;
/* 239 */           if (colorIndex < 0 || colorIndex > 15) {
/* 240 */             colorIndex = 15;
/*     */           }
/* 242 */           if (shadow) {
/* 243 */             colorIndex += 16;
/*     */           }
/* 245 */           int colorcode = this.colorCode[colorIndex];
/* 246 */           GlStateManager.func_179131_c((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 247 */         } else if (colorIndex != 16) {
/* 248 */           if (colorIndex == 17) {
/* 249 */             bold = true;
/* 250 */             if (italic) {
/* 251 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 252 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 254 */               GlStateManager.func_179144_i(this.texBold.func_110552_b());
/* 255 */               currentData = this.boldChars;
/*     */             } 
/* 257 */           } else if (colorIndex == 18) {
/* 258 */             strikethrough = true;
/* 259 */           } else if (colorIndex == 19) {
/* 260 */             underline = true;
/* 261 */           } else if (colorIndex == 20) {
/* 262 */             italic = true;
/* 263 */             if (bold) {
/* 264 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 265 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 267 */               GlStateManager.func_179144_i(this.texItalic.func_110552_b());
/* 268 */               currentData = this.italicChars;
/*     */             } 
/* 270 */           } else if (colorIndex == 21) {
/* 271 */             bold = false;
/* 272 */             italic = false;
/* 273 */             underline = false;
/* 274 */             strikethrough = false;
/* 275 */             GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 276 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 277 */             currentData = this.charData;
/*     */           } 
/*     */         } 
/* 280 */         i++;
/* 281 */       } else if (character < currentData.length && character >= '\000') {
/* 282 */         GL11.glBegin(4);
/* 283 */         drawChar(currentData, character, c, (float)y2);
/* 284 */         GL11.glEnd();
/* 285 */         if (strikethrough) {
/* 286 */           drawLine(c, y2 + ((currentData[character]).height / 2), c + (currentData[character]).width - 8.0D, y2 + ((currentData[character]).height / 2), 1.0F);
/*     */         }
/* 288 */         if (underline) {
/* 289 */           drawLine(c, y2 + (currentData[character]).height - 2.0D, c + (currentData[character]).width - 8.0D, y2 + (currentData[character]).height - 2.0D, 1.0F);
/*     */         }
/* 291 */         c = (char)(int)(c + ((currentData[character]).width - 8 + this.charOffset));
/*     */       } 
/* 293 */       i++;
/*     */     } 
/* 295 */     GL11.glHint(3155, 4352);
/* 296 */     GL11.glPopMatrix();
/*     */     
/* 298 */     return c / 2.0F;
/*     */   }
/*     */   public void DisplayFont2(FontDrawer font, String str, int x, int y, int color) {
/* 301 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   
/*     */   public void DisplayFont2(String str, float x, float y, int color, FontDrawer font) {
/* 305 */     font.drawString(str, x, y, color);
/*     */   }
/*     */   public int drawStringi(String text, double x, double y, int color, boolean shadow) {
/* 308 */     GlStateManager.func_179147_l();
/* 309 */     GlStateManager.func_179084_k();
/* 310 */     double x2 = x - 1.0D;
/* 311 */     if (text == null) {
/* 312 */       return 0;
/*     */     }
/* 314 */     if (color == 553648127) {
/* 315 */       color = 16777215;
/*     */     }
/* 317 */     if ((color & 0xFC000000) == 0) {
/* 318 */       color |= 0xFF000000;
/*     */     }
/* 320 */     if (shadow) {
/* 321 */       color = (new Color(0, 0, 0)).getRGB();
/*     */     }
/* 323 */     CFont.CharData[] currentData = this.charData;
/* 324 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 325 */     boolean bold = false;
/* 326 */     boolean italic = false;
/* 327 */     boolean strikethrough = false;
/* 328 */     boolean underline = false;
/* 329 */     char c = (char)(int)(x2 * 2.0D);
/* 330 */     double y2 = (y - 3.0D) * 2.0D;
/*     */     
/* 332 */     GL11.glPushMatrix();
/* 333 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 334 */     GlStateManager.func_179147_l();
/* 335 */     GlStateManager.func_179112_b(770, 771);
/* 336 */     GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 337 */     int size = text.length();
/* 338 */     GlStateManager.func_179098_w();
/* 339 */     GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 340 */     GL11.glBindTexture(3553, this.tex.func_110552_b());
/* 341 */     int i = 0;
/* 342 */     while (i < size) {
/* 343 */       char character = text.charAt(i);
/* 344 */       if (character == '§' && i < size) {
/* 345 */         int colorIndex = 21;
/*     */         try {
/* 347 */           colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/* 348 */         } catch (Exception e) {
/* 349 */           e.printStackTrace();
/*     */         } 
/* 351 */         if (colorIndex < 16) {
/* 352 */           bold = false;
/* 353 */           italic = false;
/* 354 */           underline = false;
/* 355 */           strikethrough = false;
/* 356 */           GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 357 */           currentData = this.charData;
/* 358 */           if (colorIndex < 0 || colorIndex > 15) {
/* 359 */             colorIndex = 15;
/*     */           }
/* 361 */           if (shadow) {
/* 362 */             colorIndex += 16;
/*     */           }
/* 364 */           int colorcode = this.colorCode[colorIndex];
/* 365 */           GlStateManager.func_179131_c((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 366 */         } else if (colorIndex != 16) {
/* 367 */           if (colorIndex == 17) {
/* 368 */             bold = true;
/* 369 */             if (italic) {
/* 370 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 371 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 373 */               GlStateManager.func_179144_i(this.texBold.func_110552_b());
/* 374 */               currentData = this.boldChars;
/*     */             } 
/* 376 */           } else if (colorIndex == 18) {
/* 377 */             strikethrough = true;
/* 378 */           } else if (colorIndex == 19) {
/* 379 */             underline = true;
/* 380 */           } else if (colorIndex == 20) {
/* 381 */             italic = true;
/* 382 */             if (bold) {
/* 383 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 384 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 386 */               GlStateManager.func_179144_i(this.texItalic.func_110552_b());
/* 387 */               currentData = this.italicChars;
/*     */             } 
/* 389 */           } else if (colorIndex == 21) {
/* 390 */             bold = false;
/* 391 */             italic = false;
/* 392 */             underline = false;
/* 393 */             strikethrough = false;
/* 394 */             GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 395 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 396 */             currentData = this.charData;
/*     */           } 
/*     */         } 
/* 399 */         i++;
/* 400 */       } else if (character < currentData.length && character >= '\000') {
/* 401 */         GL11.glBegin(4);
/* 402 */         drawChar(currentData, character, c, (float)y2);
/* 403 */         GL11.glEnd();
/* 404 */         if (strikethrough) {
/* 405 */           drawLine(c, y2 + ((currentData[character]).height / 2), c + (currentData[character]).width - 8.0D, y2 + ((currentData[character]).height / 2), 1.0F);
/*     */         }
/* 407 */         if (underline) {
/* 408 */           drawLine(c, y2 + (currentData[character]).height - 2.0D, c + (currentData[character]).width - 8.0D, y2 + (currentData[character]).height - 2.0D, 1.0F);
/*     */         }
/* 410 */         c = (char)(int)(c + ((currentData[character]).width - 8 + this.charOffset));
/*     */       } 
/* 412 */       i++;
/*     */     } 
/* 414 */     GL11.glHint(3155, 4352);
/* 415 */     GL11.glPopMatrix();
/*     */     
/* 417 */     return c / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStringWidth(String text) {
/* 422 */     if (text == null) {
/* 423 */       return 0;
/*     */     }
/* 425 */     int width = 0;
/* 426 */     CFont.CharData[] currentData = this.charData;
/* 427 */     boolean bold = false;
/* 428 */     boolean italic = false;
/* 429 */     int size = text.length();
/* 430 */     int i = 0;
/* 431 */     while (i < size) {
/* 432 */       char character = text.charAt(i);
/* 433 */       if (character == '§' && i < size) {
/* 434 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/* 435 */         if (colorIndex < 16) {
/* 436 */           bold = false;
/* 437 */           italic = false;
/* 438 */         } else if (colorIndex == 17) {
/* 439 */           bold = true;
/* 440 */           currentData = italic ? this.boldItalicChars : this.boldChars;
/* 441 */         } else if (colorIndex == 20) {
/* 442 */           italic = true;
/* 443 */           currentData = bold ? this.boldItalicChars : this.italicChars;
/* 444 */         } else if (colorIndex == 21) {
/* 445 */           bold = false;
/* 446 */           italic = false;
/* 447 */           currentData = this.charData;
/*     */         } 
/* 449 */         i++;
/* 450 */       } else if (character < currentData.length && character >= '\000') {
/* 451 */         width += (currentData[character]).width - 8 + this.charOffset;
/*     */       } 
/* 453 */       i++;
/*     */     } 
/* 455 */     return width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font font) {
/* 460 */     setFont(font);
/* 461 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 466 */     setAntiAlias(antiAlias);
/* 467 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 472 */     setFractionalMetrics(fractionalMetrics);
/* 473 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   private void setupBoldItalicIDs() {
/* 477 */     this.texBold = setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 478 */     this.texItalic = setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/*     */   }
/*     */   
/*     */   private void drawLine(double x, double y, double x1, double y1, float width) {
/* 482 */     GL11.glDisable(3553);
/* 483 */     GL11.glLineWidth(width);
/* 484 */     GL11.glBegin(1);
/* 485 */     GL11.glVertex2d(x, y);
/* 486 */     GL11.glVertex2d(x1, y1);
/* 487 */     GL11.glEnd();
/* 488 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public List<String> wrapWords(String text, double width) {
/* 492 */     ArrayList<String> finalWords = new ArrayList<>();
/* 493 */     if (getStringWidth(text) > width) {
/* 494 */       String[] words = text.split(" ");
/* 495 */       String currentWord = "";
/* 496 */       char c = Character.MAX_VALUE;
/* 497 */       for (String word : words) {
/* 498 */         for (int i = 0; i < (word.toCharArray()).length; i++) {
/* 499 */           if (word.toCharArray()[i] == '§' && i < (word.toCharArray()).length - 1) {
/* 500 */             c = word.toCharArray()[i + 1];
/*     */           }
/*     */         } 
/* 503 */         if (getStringWidth(String.valueOf(currentWord) + word + " ") < width) {
/* 504 */           currentWord = String.valueOf(currentWord) + word + " ";
/*     */         } else {
/* 506 */           finalWords.add(currentWord);
/* 507 */           currentWord = String.valueOf(167 + c) + word + " ";
/*     */         } 
/*     */       } 
/* 510 */       if (currentWord.length() > 0) {
/* 511 */         if (getStringWidth(currentWord) < width) {
/* 512 */           finalWords.add(String.valueOf(167 + c) + currentWord + " ");
/*     */         } else {
/* 514 */           for (String s : formatString(currentWord, width)) {
/* 515 */             finalWords.add(s);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } else {
/* 520 */       finalWords.add(text);
/*     */     } 
/* 522 */     return finalWords;
/*     */   }
/*     */   
/*     */   public List<String> formatString(String string, double width) {
/* 526 */     ArrayList<String> finalWords = new ArrayList<>();
/* 527 */     String currentWord = "";
/* 528 */     int lastColorCode = 65535;
/* 529 */     char[] chars = string.toCharArray();
/* 530 */     for (int i = 0; i < chars.length; i++) {
/* 531 */       char c = chars[i];
/* 532 */       if (c == '§' && i < chars.length - 1) {
/* 533 */         lastColorCode = chars[i + 1];
/*     */       }
/* 535 */       if (getStringWidth(String.valueOf(currentWord) + c) < width) {
/* 536 */         currentWord = String.valueOf(currentWord) + c;
/*     */       } else {
/* 538 */         finalWords.add(currentWord);
/* 539 */         currentWord = String.valueOf(167 + lastColorCode) + String.valueOf(c);
/*     */       } 
/*     */     } 
/* 542 */     if (currentWord.length() > 0) {
/* 543 */       finalWords.add(currentWord);
/*     */     }
/* 545 */     return finalWords;
/*     */   }
/*     */   
/*     */   private void setupMinecraftColorcodes() {
/* 549 */     for (int index = 0; index < 32; index++) {
/* 550 */       int noClue = (index >> 3 & 0x1) * 85;
/* 551 */       int red = (index >> 2 & 0x1) * 170 + noClue;
/* 552 */       int green = (index >> 1 & 0x1) * 170 + noClue;
/* 553 */       int blue = (index >> 0 & 0x1) * 170 + noClue;
/* 554 */       if (index == 6) {
/* 555 */         red += 85;
/*     */       }
/* 557 */       if (index >= 16) {
/* 558 */         red /= 4;
/* 559 */         green /= 4;
/* 560 */         blue /= 4;
/*     */       } 
/* 562 */       this.colorCode[index] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\font1\CFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */