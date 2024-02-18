/*     */ package net.ccbluex.liquidbounce.ui.Verify1.font;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*  20 */   protected CFont.CharData[] boldChars = new CFont.CharData[256];
/*  21 */   protected CFont.CharData[] italicChars = new CFont.CharData[256];
/*  22 */   protected CFont.CharData[] boldItalicChars = new CFont.CharData[256];
/*  23 */   private final int[] colorCode = new int[32];
/*  24 */   private final String colorcodeIdentifiers = "0123456789abcdefklmnor";
/*     */   protected DynamicTexture texBold;
/*     */   protected DynamicTexture texItalic;
/*     */   protected DynamicTexture texItalicBold;
/*     */   
/*     */   public CFontRenderer(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  30 */     super(font, antiAlias, fractionalMetrics);
/*  31 */     setupMinecraftColorcodes();
/*  32 */     setupBoldItalicIDs();
/*     */   }
/*     */   public String trimStringToWidth(String text, int lol, boolean wangbanxian) {
/*  35 */     text = text.replaceAll("Ã�?", "");
/*  36 */     return (text + "shabi").replaceAll("shabi", "");
/*     */   }
/*     */   
/*     */   public String trimStringToWidth(String text, int wangbanxian) {
/*  40 */     text = text.replaceAll("Ã�?", "");
/*  41 */     return (text + "shabi").replaceAll("shabi", "");
/*     */   }
/*     */   public float drawStringWithShadow(String text, double x, double y, int color) {
/*  44 */     float shadowWidth = drawString(text, x + 0.5D, y + 0.5D, color, true);
/*  45 */     return Math.max(shadowWidth, drawString(text, x, y, color, false));
/*     */   }
/*     */   
/*     */   public float drawString(String text, float x, float y, int color) {
/*  49 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*     */     
/*  51 */     RenderUtils.color(color);
/*     */     
/*  53 */     return drawString(text, x, y, color, false);
/*     */   }
/*     */   
/*     */   public float drawCenteredString(String text, double x, double y, int color) {
/*  57 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*     */     
/*  59 */     return drawString(text, (float)(x - (getStringWidth(text) / 2)), (float)y, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, float x, float y, int color) {
/*  64 */     return drawStringWithShadow(text, (x - (getStringWidth(text) / 2)), y, color);
/*     */   }
/*     */   
/*     */   public float drawCenteredStringWithShadow(String text, double x, double y, int color) {
/*  68 */     return drawStringWithShadow(text, x - (getStringWidth(text) / 2), y, color);
/*     */   }
/*     */   
/*     */   public float drawString(String text, double x, double y, int color, boolean shadow) {
/*  72 */     GlStateManager.func_179147_l();
/*  73 */     GlStateManager.func_179084_k();
/*  74 */     x--;
/*  75 */     if (text == null) {
/*  76 */       return 0.0F;
/*     */     }
/*  78 */     if (color == 553648127) {
/*  79 */       color = 16777215;
/*     */     }
/*  81 */     if ((color & 0xFC000000) == 0) {
/*  82 */       color |= 0xFF000000;
/*     */     }
/*  84 */     if (shadow) {
/*  85 */       color = (new Color(0, 0, 0)).getRGB();
/*     */     }
/*  87 */     CFont.CharData[] currentData = this.charData;
/*  88 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/*  89 */     boolean randomCase = false;
/*  90 */     boolean bold = false;
/*  91 */     boolean italic = false;
/*  92 */     boolean strikethrough = false;
/*  93 */     boolean underline = false;
/*  94 */     boolean render = true;
/*  95 */     x *= 2.0D;
/*  96 */     y = (y - 3.0D) * 2.0D;
/*  97 */     if (render) {
/*  98 */       GL11.glPushMatrix();
/*  99 */       GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 100 */       GlStateManager.func_179147_l();
/* 101 */       GlStateManager.func_179112_b(770, 771);
/* 102 */       GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 103 */       int size = text.length();
/* 104 */       GlStateManager.func_179098_w();
/* 105 */       GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 106 */       GL11.glBindTexture(3553, this.tex.func_110552_b());
/* 107 */       int i = 0;
/* 108 */       while (i < size) {
/* 109 */         char character = text.charAt(i);
/* 110 */         if (character == '§' && i < size) {
/* 111 */           int colorIndex = 21;
/*     */           try {
/* 113 */             colorIndex = "0123456789abcdefklmnor".indexOf(text.charAt(i + 1));
/*     */           }
/* 115 */           catch (Exception e) {
/* 116 */             e.printStackTrace();
/*     */           } 
/* 118 */           if (colorIndex < 16) {
/* 119 */             bold = false;
/* 120 */             italic = false;
/* 121 */             randomCase = false;
/* 122 */             underline = false;
/* 123 */             strikethrough = false;
/* 124 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 125 */             currentData = this.charData;
/* 126 */             if (colorIndex < 0 || colorIndex > 15) {
/* 127 */               colorIndex = 15;
/*     */             }
/* 129 */             if (shadow) {
/* 130 */               colorIndex += 16;
/*     */             }
/* 132 */             int colorcode = this.colorCode[colorIndex];
/* 133 */             GlStateManager.func_179131_c((colorcode >> 16 & 0xFF) / 255.0F, (colorcode >> 8 & 0xFF) / 255.0F, (colorcode & 0xFF) / 255.0F, alpha);
/* 134 */           } else if (colorIndex == 16) {
/* 135 */             randomCase = true;
/* 136 */           } else if (colorIndex == 17) {
/* 137 */             bold = true;
/* 138 */             if (italic) {
/* 139 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 140 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 142 */               GlStateManager.func_179144_i(this.texBold.func_110552_b());
/* 143 */               currentData = this.boldChars;
/*     */             } 
/* 145 */           } else if (colorIndex == 18) {
/* 146 */             strikethrough = true;
/* 147 */           } else if (colorIndex == 19) {
/* 148 */             underline = true;
/* 149 */           } else if (colorIndex == 20) {
/* 150 */             italic = true;
/* 151 */             if (bold) {
/* 152 */               GlStateManager.func_179144_i(this.texItalicBold.func_110552_b());
/* 153 */               currentData = this.boldItalicChars;
/*     */             } else {
/* 155 */               GlStateManager.func_179144_i(this.texItalic.func_110552_b());
/* 156 */               currentData = this.italicChars;
/*     */             } 
/* 158 */           } else if (colorIndex == 21) {
/* 159 */             bold = false;
/* 160 */             italic = false;
/* 161 */             randomCase = false;
/* 162 */             underline = false;
/* 163 */             strikethrough = false;
/* 164 */             GlStateManager.func_179131_c((color >> 16 & 0xFF) / 255.0F, (color >> 8 & 0xFF) / 255.0F, (color & 0xFF) / 255.0F, alpha);
/* 165 */             GlStateManager.func_179144_i(this.tex.func_110552_b());
/* 166 */             currentData = this.charData;
/*     */           } 
/* 168 */           i++;
/* 169 */         } else if (character < currentData.length && character >= '\000') {
/* 170 */           GL11.glBegin(4);
/* 171 */           drawChar(currentData, character, (float)x, (float)y);
/* 172 */           GL11.glEnd();
/* 173 */           if (strikethrough) {
/* 174 */             drawLine(x, y + ((currentData[character]).height / 2), x + (currentData[character]).width - 8.0D, y + ((currentData[character]).height / 2), 1.0F);
/*     */           }
/* 176 */           if (underline) {
/* 177 */             drawLine(x, y + (currentData[character]).height - 2.0D, x + (currentData[character]).width - 8.0D, y + (currentData[character]).height - 2.0D, 1.0F);
/*     */           }
/* 179 */           x += ((currentData[character]).width - 8 + this.charOffset);
/*     */         } 
/* 181 */         i++;
/*     */       } 
/* 183 */       GL11.glHint(3155, 4352);
/* 184 */       GL11.glPopMatrix();
/*     */     } 
/* 186 */     return (float)x / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStringWidth(String text) {
/* 191 */     if (text == null) {
/* 192 */       return 0;
/*     */     }
/* 194 */     int width = 0;
/* 195 */     CFont.CharData[] currentData = this.charData;
/* 196 */     boolean bold = false;
/* 197 */     boolean italic = false;
/* 198 */     int size = text.length();
/* 199 */     int i = 0;
/* 200 */     while (i < size) {
/* 201 */       char character = text.charAt(i);
/* 202 */       if (character == '§' && i < size) {
/* 203 */         int colorIndex = "0123456789abcdefklmnor".indexOf(character);
/* 204 */         if (colorIndex < 16) {
/* 205 */           bold = false;
/* 206 */           italic = false;
/* 207 */         } else if (colorIndex == 17) {
/* 208 */           bold = true;
/* 209 */           currentData = italic ? this.boldItalicChars : this.boldChars;
/* 210 */         } else if (colorIndex == 20) {
/* 211 */           italic = true;
/* 212 */           currentData = bold ? this.boldItalicChars : this.italicChars;
/* 213 */         } else if (colorIndex == 21) {
/* 214 */           bold = false;
/* 215 */           italic = false;
/* 216 */           currentData = this.charData;
/*     */         } 
/* 218 */         i++;
/* 219 */       } else if (character < currentData.length && character >= '\000') {
/* 220 */         width += (currentData[character]).width - 8 + this.charOffset;
/*     */       } 
/* 222 */       i++;
/*     */     } 
/* 224 */     return width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font font) {
/* 229 */     super.setFont(font);
/* 230 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 235 */     super.setAntiAlias(antiAlias);
/* 236 */     setupBoldItalicIDs();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 241 */     super.setFractionalMetrics(fractionalMetrics);
/* 242 */     setupBoldItalicIDs();
/*     */   }
/*     */   
/*     */   private void setupBoldItalicIDs() {
/* 246 */     this.texBold = setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
/* 247 */     this.texItalic = setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
/*     */   }
/*     */   
/*     */   private void drawLine(double x, double y, double x1, double y1, float width) {
/* 251 */     GL11.glDisable(3553);
/* 252 */     GL11.glLineWidth(width);
/* 253 */     GL11.glBegin(1);
/* 254 */     GL11.glVertex2d(x, y);
/* 255 */     GL11.glVertex2d(x1, y1);
/* 256 */     GL11.glEnd();
/* 257 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public List<String> wrapWords(String text, double width) {
/* 261 */     ArrayList<String> finalWords = new ArrayList<>();
/* 262 */     if (getStringWidth(text) > width) {
/* 263 */       String[] words = text.split(" ");
/* 264 */       String currentWord = "";
/* 265 */       int lastColorCode = 65535;
/* 266 */       String[] arrstring = words;
/* 267 */       int n = arrstring.length;
/* 268 */       int n2 = 0;
/* 269 */       while (n2 < n) {
/* 270 */         String word = arrstring[n2];
/* 271 */         int i = 0;
/* 272 */         while (i < (word.toCharArray()).length) {
/* 273 */           char c = word.toCharArray()[i];
/* 274 */           if (c == '§' && i < (word.toCharArray()).length - 1) {
/* 275 */             lastColorCode = word.toCharArray()[i + 1];
/*     */           }
/* 277 */           i++;
/*     */         } 
/* 279 */         if (getStringWidth(String.valueOf(currentWord) + word + " ") < width) {
/* 280 */           currentWord = String.valueOf(currentWord) + word + " ";
/*     */         } else {
/* 282 */           finalWords.add(currentWord);
/* 283 */           currentWord = String.valueOf(167 + lastColorCode) + word + " ";
/*     */         } 
/* 285 */         n2++;
/*     */       } 
/* 287 */       if (currentWord.length() > 0) {
/* 288 */         if (getStringWidth(currentWord) < width) {
/* 289 */           finalWords.add(String.valueOf(167 + lastColorCode) + currentWord + " ");
/* 290 */           currentWord = "";
/*     */         } else {
/* 292 */           for (String s : formatString(currentWord, width)) {
/* 293 */             finalWords.add(s);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } else {
/* 298 */       finalWords.add(text);
/*     */     } 
/* 300 */     return finalWords;
/*     */   }
/*     */   
/*     */   public List<String> formatString(String string, double width) {
/* 304 */     ArrayList<String> finalWords = new ArrayList<>();
/* 305 */     String currentWord = "";
/* 306 */     int lastColorCode = 65535;
/* 307 */     char[] chars = string.toCharArray();
/* 308 */     int i = 0;
/* 309 */     while (i < chars.length) {
/* 310 */       char c = chars[i];
/* 311 */       if (c == '§' && i < chars.length - 1) {
/* 312 */         lastColorCode = chars[i + 1];
/*     */       }
/* 314 */       if (getStringWidth(String.valueOf(currentWord) + c) < width) {
/* 315 */         currentWord = String.valueOf(currentWord) + c;
/*     */       } else {
/* 317 */         finalWords.add(currentWord);
/* 318 */         currentWord = String.valueOf(167 + lastColorCode) + String.valueOf(c);
/*     */       } 
/* 320 */       i++;
/*     */     } 
/* 322 */     if (currentWord.length() > 0) {
/* 323 */       finalWords.add(currentWord);
/*     */     }
/* 325 */     return finalWords;
/*     */   }
/*     */   
/*     */   private void setupMinecraftColorcodes() {
/* 329 */     int index = 0;
/* 330 */     while (index < 32) {
/* 331 */       int noClue = (index >> 3 & 0x1) * 85;
/* 332 */       int red = (index >> 2 & 0x1) * 170 + noClue;
/* 333 */       int green = (index >> 1 & 0x1) * 170 + noClue;
/* 334 */       int blue = (index >> 0 & 0x1) * 170 + noClue;
/* 335 */       if (index == 6) {
/* 336 */         red += 85;
/*     */       }
/* 338 */       if (index >= 16) {
/* 339 */         red /= 4;
/* 340 */         green /= 4;
/* 341 */         blue /= 4;
/*     */       } 
/* 343 */       this.colorCode[index] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/* 344 */       index++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify1\font\CFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */