/*     */ package net.ccbluex.liquidbounce.ui.Verify1;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.ui.Verify1.font.FontLoaders;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ 
/*     */ 
/*     */ public final class GuiUserField
/*     */   extends Gui
/*     */ {
/*     */   private final int xPosition;
/*     */   private final int yPosition;
/*     */   private final FontRenderer fontRendererInstance;
/*     */   private boolean canLoseFocus = true;
/*     */   private boolean isFocused;
/*     */   private int cursorCounter;
/*     */   private boolean enableBackgroundDrawing = true;
/*  25 */   private String text = "";
/*  26 */   private int maxStringLength = 32;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private boolean visible = true;
/*  30 */   private int disabledColor = (new Color(255, 255, 255)).getRGB();
/*  31 */   private int enabledColor = (new Color(255, 255, 255)).getRGB();
/*     */   private int selectionEnd;
/*     */   private int cursorPosition;
/*     */   private int lineScrollOffset;
/*     */   private boolean isEnabled = true;
/*     */   
/*     */   public GuiUserField(FontRenderer p_i1032_1_, int p_i1032_2_, int p_i1032_3_, int p_i1032_4_, int p_i1032_5_) {
/*  38 */     this.fontRendererInstance = p_i1032_1_;
/*  39 */     this.xPosition = p_i1032_2_;
/*  40 */     this.yPosition = p_i1032_3_;
/*  41 */     this.width = p_i1032_4_;
/*  42 */     this.height = p_i1032_5_;
/*     */   }
/*     */   
/*     */   public void drawTextBox() {
/*  46 */     if (getVisible()) {
/*  47 */       if (getEnableBackgroundDrawing()) {
/*  48 */         Gui.func_73734_a(this.xPosition - 1, this.yPosition - 1, this.xPosition + this.width + 1, this.yPosition + this.height + 1, -6250336);
/*  49 */         Gui.func_73734_a(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -16777216);
/*     */       } 
/*     */       
/*  52 */       int i = this.isEnabled ? this.enabledColor : this.disabledColor;
/*  53 */       int j = this.cursorPosition - this.lineScrollOffset;
/*  54 */       int k = this.selectionEnd - this.lineScrollOffset;
/*  55 */       String s = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), getWidth());
/*  56 */       boolean flag = (j >= 0 && j <= s.length());
/*  57 */       boolean flag1 = (this.isFocused && this.cursorCounter / 6 % 2 == 0 && flag);
/*  58 */       int l = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
/*  59 */       int i1 = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
/*  60 */       int j1 = l;
/*     */       
/*  62 */       if (k > s.length()) {
/*  63 */         k = s.length();
/*     */       }
/*     */       
/*  66 */       if (s.length() > 0) {
/*  67 */         String s1 = flag ? s.substring(0, j) : s;
/*     */         
/*  69 */         j1 = this.fontRendererInstance.func_78276_b(s1.replaceAll(".", "*"), l, i1, i);
/*     */       } 
/*     */       
/*  72 */       boolean flag2 = (this.cursorPosition < this.text.length() || this.text.length() >= getMaxStringLength());
/*  73 */       int k1 = j1;
/*     */       
/*  75 */       if (!flag) {
/*  76 */         k1 = (j > 0) ? (l + this.width) : l;
/*  77 */       } else if (flag2) {
/*  78 */         k1 = j1 - 1;
/*  79 */         j1--;
/*     */       } 
/*     */       
/*  82 */       if (s.length() > 0 && flag && j < s.length()) {
/*  83 */         this.fontRendererInstance.func_78276_b(s.substring(j).replaceAll(".", "*"), j1, i1, i);
/*     */       }
/*     */       
/*  86 */       if (flag1) {
/*  87 */         if (flag2) {
/*  88 */           Gui.func_73734_a(k1, i1 - 1, k1 + 1, i1 + 1 + this.fontRendererInstance.field_78288_b, -3092272);
/*     */         } else {
/*  90 */           this.fontRendererInstance.func_78276_b("_", k1, i1, i);
/*     */         } 
/*     */       }
/*     */       
/*  94 */       if (k != j) {
/*  95 */         int l1 = l + this.fontRendererInstance.func_78256_a(s.substring(0, k).replaceAll(".", "*"));
/*     */         
/*  97 */         drawCursorVertical(k1, i1 - 1, l1 - 1, i1 + 1 + this.fontRendererInstance.field_78288_b);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTextBox2() {
/* 104 */     if (getVisible()) {
/* 105 */       int color = (new Color(0, 0, 0, 60)).getRGB();
/*     */       
/* 107 */       if (getEnableBackgroundDrawing());
/*     */ 
/*     */ 
/*     */       
/* 111 */       int i = this.isEnabled ? this.enabledColor : this.disabledColor;
/* 112 */       int j = this.cursorPosition - this.lineScrollOffset;
/* 113 */       int k = this.selectionEnd - this.lineScrollOffset;
/* 114 */       String s = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), getWidth());
/* 115 */       boolean flag = (j >= 0 && j <= s.length());
/* 116 */       boolean flag1 = (this.isFocused && this.cursorCounter / 6 % 2 == 0 && flag);
/* 117 */       int l = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
/* 118 */       int i1 = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
/* 119 */       int j1 = l;
/*     */       
/* 121 */       if (k > s.length()) {
/* 122 */         k = s.length();
/*     */       }
/*     */       
/* 125 */       if (s.length() > 0) {
/* 126 */         String s1 = flag ? s.substring(0, j) : s;
/*     */         
/* 128 */         j1 = (int)FontLoaders.xyz18.drawString(s1, l, (i1 + 1), (new Color(255, 255, 255)).getRGB());
/*     */       } 
/*     */       
/* 131 */       boolean flag2 = (this.cursorPosition < this.text.length() || this.text.length() >= getMaxStringLength());
/* 132 */       int k1 = j1;
/*     */       
/* 134 */       if (!flag) {
/* 135 */         k1 = (j > 0) ? (l + this.width) : l;
/* 136 */       } else if (flag2) {
/* 137 */         k1 = j1 - 1;
/* 138 */         j1--;
/*     */       } 
/*     */       
/* 141 */       if (s.length() > 0 && flag && j < s.length()) {
/* 142 */         FontLoaders.xyz18.drawString(s.substring(j), (j1 + 2), (i1 + 1), (new Color(250, 250, 250)).getRGB());
/*     */       }
/*     */       
/* 145 */       if (flag1) {
/* 146 */         if (flag2) {
/* 147 */           Gui.func_73734_a(j1, i1, k1 + 1, i1 + 1 + this.fontRendererInstance.field_78288_b, -3092272);
/*     */         } else {
/* 149 */           FontLoaders.xyz20.drawString("_", (k1 + 1), i1, i);
/*     */         } 
/*     */       }
/*     */       
/* 153 */       if (k != j) {
/* 154 */         int l1 = l + this.fontRendererInstance.func_78256_a(s.substring(0, k).replaceAll(".", "*"));
/*     */         
/* 156 */         drawCursorVertical(k1, i1 - 1, l1 - 1, i1 + 1 + this.fontRendererInstance.field_78288_b);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteFromCursor(int p_146175_1_) {
/* 163 */     if (this.text.length() != 0) {
/* 164 */       if (this.selectionEnd != this.cursorPosition) {
/* 165 */         writeText("");
/*     */       } else {
/* 167 */         boolean flag = (p_146175_1_ < 0);
/* 168 */         int i = flag ? (this.cursorPosition + p_146175_1_) : this.cursorPosition;
/* 169 */         int j = flag ? this.cursorPosition : (this.cursorPosition + p_146175_1_);
/* 170 */         String s = "";
/*     */         
/* 172 */         if (i >= 0) {
/* 173 */           s = this.text.substring(0, i);
/*     */         }
/*     */         
/* 176 */         if (j < this.text.length()) {
/* 177 */           s = s + this.text.substring(j);
/*     */         }
/*     */         
/* 180 */         this.text = s;
/* 181 */         if (flag) {
/* 182 */           moveCursorBy(p_146175_1_);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getVisible() {
/* 190 */     return this.visible;
/*     */   }
/*     */   
/*     */   public void deleteWords(int p_146177_1_) {
/* 194 */     if (this.text.length() != 0) {
/* 195 */       if (this.selectionEnd != this.cursorPosition) {
/* 196 */         writeText("");
/*     */       } else {
/* 198 */         deleteFromCursor(getNthWordFromCursor(p_146177_1_) - this.cursorPosition);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getEnableBackgroundDrawing() {
/* 205 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */   
/*     */   public void moveCursorBy(int p_146182_1_) {
/* 209 */     setCursorPosition(this.selectionEnd + p_146182_1_);
/*     */   }
/*     */   
/*     */   public int getNthWordFromPos(int p_146183_1_, int p_146183_2_) {
/* 213 */     return func_146197_a(p_146183_1_, getCursorPosition(), true);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean p_146184_1_) {
/* 217 */     this.isEnabled = p_146184_1_;
/*     */   }
/*     */   
/*     */   public void setEnableBackgroundDrawing(boolean p_146185_1_) {
/* 221 */     this.enableBackgroundDrawing = p_146185_1_;
/*     */   }
/*     */   
/*     */   public int getSelectionEnd() {
/* 225 */     return this.selectionEnd;
/*     */   }
/*     */   
/*     */   public int getNthWordFromCursor(int p_146187_1_) {
/* 229 */     return getNthWordFromPos(p_146187_1_, getCursorPosition());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawCursorVertical(int p_146188_1_, int p_146188_2_, int p_146188_3_, int p_146188_4_) {
/* 235 */     if (p_146188_1_ < p_146188_3_) {
/* 236 */       int tessellator = p_146188_1_;
/* 237 */       p_146188_1_ = p_146188_3_;
/* 238 */       p_146188_3_ = tessellator;
/*     */     } 
/*     */     
/* 241 */     if (p_146188_2_ < p_146188_4_) {
/* 242 */       int tessellator = p_146188_2_;
/* 243 */       p_146188_2_ = p_146188_4_;
/* 244 */       p_146188_4_ = tessellator;
/*     */     } 
/*     */     
/* 247 */     if (p_146188_3_ > this.xPosition + this.width) {
/* 248 */       p_146188_3_ = this.xPosition + this.width;
/*     */     }
/*     */     
/* 251 */     if (p_146188_1_ > this.xPosition + this.width) {
/* 252 */       p_146188_1_ = this.xPosition + this.width;
/*     */     }
/*     */     
/* 255 */     Tessellator tessellator1 = Tessellator.func_178181_a();
/* 256 */     BufferBuilder worldrenderer = tessellator1.func_178180_c();
/*     */     
/* 258 */     GlStateManager.func_179131_c(0.0F, 0.0F, 255.0F, 255.0F);
/* 259 */     GlStateManager.func_179090_x();
/* 260 */     GlStateManager.func_179115_u();
/* 261 */     GlStateManager.func_179116_f(5387);
/* 262 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
/* 263 */     worldrenderer.func_181662_b(p_146188_1_, p_146188_4_, 0.0D).func_181675_d();
/* 264 */     worldrenderer.func_181662_b(p_146188_3_, p_146188_4_, 0.0D).func_181675_d();
/* 265 */     worldrenderer.func_181662_b(p_146188_3_, p_146188_2_, 0.0D).func_181675_d();
/* 266 */     worldrenderer.func_181662_b(p_146188_1_, p_146188_2_, 0.0D).func_181675_d();
/* 267 */     tessellator1.func_78381_a();
/* 268 */     GlStateManager.func_179134_v();
/* 269 */     GlStateManager.func_179098_w();
/*     */   }
/*     */   
/*     */   public void setVisible(boolean p_146189_1_) {
/* 273 */     this.visible = p_146189_1_;
/*     */   }
/*     */   
/*     */   public void setCursorPosition(int p_146190_1_) {
/* 277 */     this.cursorPosition = p_146190_1_;
/* 278 */     int i = this.text.length();
/*     */     
/* 280 */     if (this.cursorPosition < 0) {
/* 281 */       this.cursorPosition = 0;
/*     */     }
/*     */     
/* 284 */     if (this.cursorPosition > i) {
/* 285 */       this.cursorPosition = i;
/*     */     }
/*     */     
/* 288 */     setSelectionPos(this.cursorPosition);
/*     */   }
/*     */   public void writeText(String p_146191_1_) {
/*     */     int l;
/* 292 */     String s = "";
/* 293 */     String s1 = ChatAllowedCharacters.func_71565_a(p_146191_1_);
/* 294 */     int i = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/* 295 */     int j = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/* 296 */     int k = this.maxStringLength - this.text.length() - i - this.selectionEnd;
/*     */     
/* 298 */     if (this.text.length() > 0) {
/* 299 */       s = s + this.text.substring(0, i);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 304 */     if (k < s1.length()) {
/* 305 */       s = s + s1.substring(0, k);
/* 306 */       l = k;
/*     */     } else {
/* 308 */       s = s + s1;
/* 309 */       l = s1.length();
/*     */     } 
/*     */     
/* 312 */     if (this.text.length() > 0 && j < this.text.length()) {
/* 313 */       s = s + this.text.substring(j);
/*     */     }
/*     */     
/* 316 */     this.text = s;
/* 317 */     moveCursorBy(i - this.selectionEnd + l);
/*     */   }
/*     */   
/*     */   public void setTextColor(int p_146193_1_) {
/* 321 */     this.enabledColor = p_146193_1_;
/*     */   }
/*     */   
/*     */   public void setCursorPositionZero() {
/* 325 */     setCursorPosition(0);
/*     */   }
/*     */   
/*     */   public int func_146197_a(int p_146197_1_, int p_146197_2_, boolean p_146197_3_) {
/* 329 */     int i = p_146197_2_;
/* 330 */     boolean flag = (p_146197_1_ < 0);
/* 331 */     int j = Math.abs(p_146197_1_);
/*     */     
/* 333 */     for (int k = 0; k < j; k++) {
/* 334 */       if (flag) {
/*     */ 
/*     */         
/*     */         do {
/* 338 */           i--;
/* 339 */         } while (!p_146197_3_ || 
/* 340 */           i <= 0 || 
/* 341 */           this.text.charAt(i - 1) == ' ');
/*     */         
/*     */         do {
/* 344 */           i--;
/* 345 */         } while (i > 0 && this.text.charAt(i - 1) != ' ');
/*     */       } else {
/* 347 */         int l = this.text.length();
/*     */         
/* 349 */         i = this.text.indexOf(' ', i);
/* 350 */         if (i == -1) {
/* 351 */           i = l;
/*     */         } else {
/* 353 */           while (p_146197_3_ && i < l && this.text.charAt(i) == ' ') {
/* 354 */             i++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     return i;
/*     */   }
/*     */   
/*     */   public int getCursorPosition() {
/* 364 */     return this.cursorPosition;
/*     */   }
/*     */   
/*     */   public void setSelectionPos(int p_146199_1_) {
/* 368 */     int i = this.text.length();
/*     */     
/* 370 */     if (p_146199_1_ > i) {
/* 371 */       p_146199_1_ = i;
/*     */     }
/*     */     
/* 374 */     if (p_146199_1_ < 0) {
/* 375 */       p_146199_1_ = 0;
/*     */     }
/*     */     
/* 378 */     this.selectionEnd = p_146199_1_;
/* 379 */     if (this.fontRendererInstance != null) {
/* 380 */       if (this.lineScrollOffset > i) {
/* 381 */         this.lineScrollOffset = i;
/*     */       }
/*     */       
/* 384 */       int j = getWidth();
/* 385 */       String s = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), j);
/* 386 */       int k = s.length() + this.lineScrollOffset;
/*     */       
/* 388 */       if (p_146199_1_ == this.lineScrollOffset) {
/* 389 */         this.lineScrollOffset -= this.fontRendererInstance.func_78262_a(this.text, j, true).length();
/*     */       }
/*     */       
/* 392 */       if (p_146199_1_ > k) {
/* 393 */         this.lineScrollOffset += p_146199_1_ - k;
/* 394 */       } else if (p_146199_1_ <= this.lineScrollOffset) {
/* 395 */         this.lineScrollOffset -= this.lineScrollOffset - p_146199_1_;
/*     */       } 
/*     */       
/* 398 */       if (this.lineScrollOffset < 0) {
/* 399 */         this.lineScrollOffset = 0;
/*     */       }
/*     */       
/* 402 */       if (this.lineScrollOffset > i) {
/* 403 */         this.lineScrollOffset = i;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 410 */     return getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
/*     */   }
/*     */   
/*     */   public void setCursorPositionEnd() {
/* 414 */     setCursorPosition(this.text.length());
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int p_146203_1_) {
/* 418 */     this.maxStringLength = p_146203_1_;
/* 419 */     if (this.text.length() > p_146203_1_) {
/* 420 */       this.text = this.text.substring(0, p_146203_1_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabledTextColour(int p_146204_1_) {
/* 426 */     this.disabledColor = p_146204_1_;
/*     */   }
/*     */   
/*     */   public void setCanLoseFocus(boolean p_146205_1_) {
/* 430 */     this.canLoseFocus = p_146205_1_;
/*     */   }
/*     */   
/*     */   public String getSelectedText() {
/* 434 */     int i = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/* 435 */     int j = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*     */     
/* 437 */     return this.text.substring(i, j);
/*     */   }
/*     */   
/*     */   public int getMaxStringLength() {
/* 441 */     return this.maxStringLength;
/*     */   }
/*     */   
/*     */   public String getText() {
/* 445 */     return this.text;
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 449 */     return this.isFocused;
/*     */   }
/*     */   
/*     */   public void mouseClicked(int p_146192_1_, int p_146192_2_, int p_146192_3_) {
/* 453 */     boolean flag = (p_146192_1_ >= this.xPosition && p_146192_1_ < this.xPosition + this.width && p_146192_2_ >= this.yPosition && p_146192_2_ < this.yPosition + this.height);
/*     */     
/* 455 */     if (this.canLoseFocus) {
/* 456 */       setFocused(flag);
/*     */     }
/*     */     
/* 459 */     if (this.isFocused && p_146192_3_ == 0) {
/* 460 */       int i = p_146192_1_ - this.xPosition;
/*     */       
/* 462 */       if (this.enableBackgroundDrawing) {
/* 463 */         i -= 4;
/*     */       }
/*     */       
/* 466 */       String s = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), getWidth());
/*     */       
/* 468 */       setCursorPosition(this.fontRendererInstance.func_78269_a(s, i).length() + this.lineScrollOffset);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFocused(boolean p_146195_1_) {
/* 474 */     if (p_146195_1_ && !this.isFocused) {
/* 475 */       this.cursorCounter = 0;
/*     */     }
/*     */     
/* 478 */     this.isFocused = p_146195_1_;
/*     */   }
/*     */   
/*     */   public void setText(String p_146180_1_) {
/* 482 */     if (p_146180_1_.length() > this.maxStringLength) {
/* 483 */       this.text = p_146180_1_.substring(0, this.maxStringLength);
/*     */     } else {
/* 485 */       this.text = p_146180_1_;
/*     */     } 
/*     */     
/* 488 */     setCursorPositionEnd();
/*     */   }
/*     */   
/*     */   public boolean textboxKeyTyped(char p_146201_1_, int p_146201_2_) {
/* 492 */     if (!this.isFocused) {
/* 493 */       return false;
/*     */     }
/* 495 */     switch (p_146201_1_) {
/*     */       case '\001':
/* 497 */         setCursorPositionEnd();
/* 498 */         setSelectionPos(0);
/* 499 */         return true;
/*     */       
/*     */       case '\003':
/* 502 */         GuiScreen.func_146275_d(getSelectedText());
/* 503 */         return true;
/*     */       
/*     */       case '\026':
/* 506 */         if (this.isEnabled) {
/* 507 */           writeText(GuiScreen.func_146277_j());
/*     */         }
/*     */         
/* 510 */         return true;
/*     */       
/*     */       case '\030':
/* 513 */         GuiScreen.func_146275_d(getSelectedText());
/* 514 */         if (this.isEnabled) {
/* 515 */           writeText("");
/*     */         }
/*     */         
/* 518 */         return true;
/*     */     } 
/*     */     
/* 521 */     switch (p_146201_2_) {
/*     */       case 14:
/* 523 */         if (GuiScreen.func_146271_m()) {
/* 524 */           if (this.isEnabled) {
/* 525 */             deleteWords(-1);
/*     */           }
/* 527 */         } else if (this.isEnabled) {
/* 528 */           deleteFromCursor(-1);
/*     */         } 
/*     */         
/* 531 */         return true;
/*     */       
/*     */       case 199:
/* 534 */         if (GuiScreen.func_146272_n()) {
/* 535 */           setSelectionPos(0);
/*     */         } else {
/* 537 */           setCursorPositionZero();
/*     */         } 
/*     */         
/* 540 */         return true;
/*     */       
/*     */       case 203:
/* 543 */         if (GuiScreen.func_146272_n()) {
/* 544 */           if (GuiScreen.func_146271_m()) {
/* 545 */             setSelectionPos(getNthWordFromPos(-1, getSelectionEnd()));
/*     */           } else {
/* 547 */             setSelectionPos(getSelectionEnd() - 1);
/*     */           } 
/* 549 */         } else if (GuiScreen.func_146271_m()) {
/* 550 */           setCursorPosition(getNthWordFromCursor(-1));
/*     */         } else {
/* 552 */           moveCursorBy(-1);
/*     */         } 
/*     */         
/* 555 */         return true;
/*     */       
/*     */       case 205:
/* 558 */         if (GuiScreen.func_146272_n()) {
/* 559 */           if (GuiScreen.func_146271_m()) {
/* 560 */             setSelectionPos(getNthWordFromPos(1, getSelectionEnd()));
/*     */           } else {
/* 562 */             setSelectionPos(getSelectionEnd() + 1);
/*     */           } 
/* 564 */         } else if (GuiScreen.func_146271_m()) {
/* 565 */           setCursorPosition(getNthWordFromCursor(1));
/*     */         } else {
/* 567 */           moveCursorBy(1);
/*     */         } 
/*     */         
/* 570 */         return true;
/*     */       
/*     */       case 207:
/* 573 */         if (GuiScreen.func_146272_n()) {
/* 574 */           setSelectionPos(this.text.length());
/*     */         } else {
/* 576 */           setCursorPositionEnd();
/*     */         } 
/*     */         
/* 579 */         return true;
/*     */       
/*     */       case 211:
/* 582 */         if (GuiScreen.func_146271_m()) {
/* 583 */           if (this.isEnabled) {
/* 584 */             deleteWords(1);
/*     */           }
/* 586 */         } else if (this.isEnabled) {
/* 587 */           deleteFromCursor(1);
/*     */         } 
/*     */         
/* 590 */         return true;
/*     */     } 
/*     */     
/* 593 */     if (ChatAllowedCharacters.func_71566_a(p_146201_1_)) {
/* 594 */       if (this.isEnabled) {
/* 595 */         writeText(Character.toString(p_146201_1_));
/*     */       }
/*     */       
/* 598 */       return true;
/*     */     } 
/* 600 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCursorCounter() {
/* 608 */     this.cursorCounter++;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify1\GuiUserField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */