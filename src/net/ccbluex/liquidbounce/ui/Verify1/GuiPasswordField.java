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
/*     */ public final class GuiPasswordField
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
/*     */   public GuiPasswordField(FontRenderer p_i1032_1_, int p_i1032_2_, int p_i1032_3_, int p_i1032_4_, int p_i1032_5_) {
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
/* 128 */         j1 = (int)FontLoaders.xyz18.drawString(s1.replaceAll(".", "*"), l, (i1 + 4), (new Color(255, 255, 255)).getRGB());
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
/* 142 */         FontLoaders.xyz18.drawString(s.substring(j).replaceAll(".", "*"), (j1 + 2), (i1 + 4), (new Color(255, 255, 255)).getRGB());
/*     */       }
/*     */       
/* 145 */       if (flag1) {
/* 146 */         if (flag2) {
/* 147 */           Gui.func_73734_a(j1, i1, k1 + 1, i1 + 1 + this.fontRendererInstance.field_78288_b, -3092272);
/*     */         } else {
/* 149 */           FontLoaders.xyz20.drawString("_", k1, i1, i);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void deleteFromCursor(int p_146175_1_) {
/* 157 */     if (this.text.length() != 0) {
/* 158 */       if (this.selectionEnd != this.cursorPosition) {
/* 159 */         writeText("");
/*     */       } else {
/* 161 */         boolean flag = (p_146175_1_ < 0);
/* 162 */         int i = flag ? (this.cursorPosition + p_146175_1_) : this.cursorPosition;
/* 163 */         int j = flag ? this.cursorPosition : (this.cursorPosition + p_146175_1_);
/* 164 */         String s = "";
/*     */         
/* 166 */         if (i >= 0) {
/* 167 */           s = this.text.substring(0, i);
/*     */         }
/*     */         
/* 170 */         if (j < this.text.length()) {
/* 171 */           s = s + this.text.substring(j);
/*     */         }
/*     */         
/* 174 */         this.text = s;
/* 175 */         if (flag) {
/* 176 */           moveCursorBy(p_146175_1_);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getVisible() {
/* 184 */     return this.visible;
/*     */   }
/*     */   
/*     */   public void deleteWords(int p_146177_1_) {
/* 188 */     if (this.text.length() != 0) {
/* 189 */       if (this.selectionEnd != this.cursorPosition) {
/* 190 */         writeText("");
/*     */       } else {
/* 192 */         deleteFromCursor(getNthWordFromCursor(p_146177_1_) - this.cursorPosition);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getEnableBackgroundDrawing() {
/* 199 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */   
/*     */   public void moveCursorBy(int p_146182_1_) {
/* 203 */     setCursorPosition(this.selectionEnd + p_146182_1_);
/*     */   }
/*     */   
/*     */   public int getNthWordFromPos(int p_146183_1_, int p_146183_2_) {
/* 207 */     return func_146197_a(p_146183_1_, getCursorPosition(), true);
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean p_146184_1_) {
/* 211 */     this.isEnabled = p_146184_1_;
/*     */   }
/*     */   
/*     */   public void setEnableBackgroundDrawing(boolean p_146185_1_) {
/* 215 */     this.enableBackgroundDrawing = p_146185_1_;
/*     */   }
/*     */   
/*     */   public int getSelectionEnd() {
/* 219 */     return this.selectionEnd;
/*     */   }
/*     */   
/*     */   public int getNthWordFromCursor(int p_146187_1_) {
/* 223 */     return getNthWordFromPos(p_146187_1_, getCursorPosition());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawCursorVertical(int p_146188_1_, int p_146188_2_, int p_146188_3_, int p_146188_4_) {
/* 229 */     if (p_146188_1_ < p_146188_3_) {
/* 230 */       int tessellator = p_146188_1_;
/* 231 */       p_146188_1_ = p_146188_3_;
/* 232 */       p_146188_3_ = tessellator;
/*     */     } 
/*     */     
/* 235 */     if (p_146188_2_ < p_146188_4_) {
/* 236 */       int tessellator = p_146188_2_;
/* 237 */       p_146188_2_ = p_146188_4_;
/* 238 */       p_146188_4_ = tessellator;
/*     */     } 
/*     */     
/* 241 */     if (p_146188_3_ > this.xPosition + this.width) {
/* 242 */       p_146188_3_ = this.xPosition + this.width;
/*     */     }
/*     */     
/* 245 */     if (p_146188_1_ > this.xPosition + this.width) {
/* 246 */       p_146188_1_ = this.xPosition + this.width;
/*     */     }
/*     */     
/* 249 */     Tessellator tessellator1 = Tessellator.func_178181_a();
/* 250 */     BufferBuilder BufferBuilder = tessellator1.func_178180_c();
/*     */     
/* 252 */     GlStateManager.func_179131_c(0.0F, 0.0F, 255.0F, 255.0F);
/* 253 */     GlStateManager.func_179090_x();
/* 254 */     GlStateManager.func_179115_u();
/* 255 */     GlStateManager.func_179116_f(5387);
/* 256 */     BufferBuilder.func_181668_a(7, DefaultVertexFormats.field_181705_e);
/* 257 */     BufferBuilder.func_181662_b(p_146188_1_, p_146188_4_, 0.0D).func_181675_d();
/* 258 */     BufferBuilder.func_181662_b(p_146188_3_, p_146188_4_, 0.0D).func_181675_d();
/* 259 */     BufferBuilder.func_181662_b(p_146188_3_, p_146188_2_, 0.0D).func_181675_d();
/* 260 */     BufferBuilder.func_181662_b(p_146188_1_, p_146188_2_, 0.0D).func_181675_d();
/* 261 */     tessellator1.func_78381_a();
/* 262 */     GlStateManager.func_179134_v();
/* 263 */     GlStateManager.func_179098_w();
/*     */   }
/*     */   
/*     */   public void setVisible(boolean p_146189_1_) {
/* 267 */     this.visible = p_146189_1_;
/*     */   }
/*     */   
/*     */   public void setCursorPosition(int p_146190_1_) {
/* 271 */     this.cursorPosition = p_146190_1_;
/* 272 */     int i = this.text.length();
/*     */     
/* 274 */     if (this.cursorPosition < 0) {
/* 275 */       this.cursorPosition = 0;
/*     */     }
/*     */     
/* 278 */     if (this.cursorPosition > i) {
/* 279 */       this.cursorPosition = i;
/*     */     }
/*     */     
/* 282 */     setSelectionPos(this.cursorPosition);
/*     */   }
/*     */   public void writeText(String p_146191_1_) {
/*     */     int l;
/* 286 */     String s = "";
/* 287 */     String s1 = ChatAllowedCharacters.func_71565_a(p_146191_1_);
/* 288 */     int i = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/* 289 */     int j = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/* 290 */     int k = this.maxStringLength - this.text.length() - i - this.selectionEnd;
/*     */     
/* 292 */     if (this.text.length() > 0) {
/* 293 */       s = s + this.text.substring(0, i);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 298 */     if (k < s1.length()) {
/* 299 */       s = s + s1.substring(0, k);
/* 300 */       l = k;
/*     */     } else {
/* 302 */       s = s + s1;
/* 303 */       l = s1.length();
/*     */     } 
/*     */     
/* 306 */     if (this.text.length() > 0 && j < this.text.length()) {
/* 307 */       s = s + this.text.substring(j);
/*     */     }
/*     */     
/* 310 */     this.text = s;
/* 311 */     moveCursorBy(i - this.selectionEnd + l);
/*     */   }
/*     */   
/*     */   public void setTextColor(int p_146193_1_) {
/* 315 */     this.enabledColor = p_146193_1_;
/*     */   }
/*     */   
/*     */   public void setCursorPositionZero() {
/* 319 */     setCursorPosition(0);
/*     */   }
/*     */   
/*     */   public int func_146197_a(int p_146197_1_, int p_146197_2_, boolean p_146197_3_) {
/* 323 */     int i = p_146197_2_;
/* 324 */     boolean flag = (p_146197_1_ < 0);
/* 325 */     int j = Math.abs(p_146197_1_);
/*     */     
/* 327 */     for (int k = 0; k < j; k++) {
/* 328 */       if (flag) {
/*     */ 
/*     */         
/*     */         do {
/* 332 */           i--;
/* 333 */         } while (!p_146197_3_ || 
/* 334 */           i <= 0 || 
/* 335 */           this.text.charAt(i - 1) == ' ');
/*     */         
/*     */         do {
/* 338 */           i--;
/* 339 */         } while (i > 0 && this.text.charAt(i - 1) != ' ');
/*     */       } else {
/* 341 */         int l = this.text.length();
/*     */         
/* 343 */         i = this.text.indexOf(' ', i);
/* 344 */         if (i == -1) {
/* 345 */           i = l;
/*     */         } else {
/* 347 */           while (p_146197_3_ && i < l && this.text.charAt(i) == ' ') {
/* 348 */             i++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 354 */     return i;
/*     */   }
/*     */   
/*     */   public int getCursorPosition() {
/* 358 */     return this.cursorPosition;
/*     */   }
/*     */   
/*     */   public void setSelectionPos(int p_146199_1_) {
/* 362 */     int i = this.text.length();
/*     */     
/* 364 */     if (p_146199_1_ > i) {
/* 365 */       p_146199_1_ = i;
/*     */     }
/*     */     
/* 368 */     if (p_146199_1_ < 0) {
/* 369 */       p_146199_1_ = 0;
/*     */     }
/*     */     
/* 372 */     this.selectionEnd = p_146199_1_;
/* 373 */     if (this.fontRendererInstance != null) {
/* 374 */       if (this.lineScrollOffset > i) {
/* 375 */         this.lineScrollOffset = i;
/*     */       }
/*     */       
/* 378 */       int j = getWidth();
/* 379 */       String s = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), j);
/* 380 */       int k = s.length() + this.lineScrollOffset;
/*     */       
/* 382 */       if (p_146199_1_ == this.lineScrollOffset) {
/* 383 */         this.lineScrollOffset -= this.fontRendererInstance.func_78262_a(this.text, j, true).length();
/*     */       }
/*     */       
/* 386 */       if (p_146199_1_ > k) {
/* 387 */         this.lineScrollOffset += p_146199_1_ - k;
/* 388 */       } else if (p_146199_1_ <= this.lineScrollOffset) {
/* 389 */         this.lineScrollOffset -= this.lineScrollOffset - p_146199_1_;
/*     */       } 
/*     */       
/* 392 */       if (this.lineScrollOffset < 0) {
/* 393 */         this.lineScrollOffset = 0;
/*     */       }
/*     */       
/* 396 */       if (this.lineScrollOffset > i) {
/* 397 */         this.lineScrollOffset = i;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 404 */     return getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
/*     */   }
/*     */   
/*     */   public void setCursorPositionEnd() {
/* 408 */     setCursorPosition(this.text.length());
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int p_146203_1_) {
/* 412 */     this.maxStringLength = p_146203_1_;
/* 413 */     if (this.text.length() > p_146203_1_) {
/* 414 */       this.text = this.text.substring(0, p_146203_1_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabledTextColour(int p_146204_1_) {
/* 420 */     this.disabledColor = p_146204_1_;
/*     */   }
/*     */   
/*     */   public void setCanLoseFocus(boolean p_146205_1_) {
/* 424 */     this.canLoseFocus = p_146205_1_;
/*     */   }
/*     */   
/*     */   public String getSelectedText() {
/* 428 */     int i = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/* 429 */     int j = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*     */     
/* 431 */     return this.text.substring(i, j);
/*     */   }
/*     */   
/*     */   public int getMaxStringLength() {
/* 435 */     return this.maxStringLength;
/*     */   }
/*     */   
/*     */   public String getText() {
/* 439 */     return this.text;
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 443 */     return this.isFocused;
/*     */   }
/*     */   
/*     */   public void mouseClicked(int p_146192_1_, int p_146192_2_, int p_146192_3_) {
/* 447 */     boolean flag = (p_146192_1_ >= this.xPosition && p_146192_1_ < this.xPosition + this.width && p_146192_2_ >= this.yPosition && p_146192_2_ < this.yPosition + this.height);
/*     */     
/* 449 */     if (this.canLoseFocus) {
/* 450 */       setFocused(flag);
/*     */     }
/*     */     
/* 453 */     if (this.isFocused && p_146192_3_ == 0) {
/* 454 */       int i = p_146192_1_ - this.xPosition;
/*     */       
/* 456 */       if (this.enableBackgroundDrawing) {
/* 457 */         i -= 4;
/*     */       }
/*     */       
/* 460 */       String s = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), getWidth());
/*     */       
/* 462 */       setCursorPosition(this.fontRendererInstance.func_78269_a(s, i).length() + this.lineScrollOffset);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFocused(boolean p_146195_1_) {
/* 468 */     if (p_146195_1_ && !this.isFocused) {
/* 469 */       this.cursorCounter = 0;
/*     */     }
/*     */     
/* 472 */     this.isFocused = p_146195_1_;
/*     */   }
/*     */   
/*     */   public void setText(String p_146180_1_) {
/* 476 */     if (p_146180_1_.length() > this.maxStringLength) {
/* 477 */       this.text = p_146180_1_.substring(0, this.maxStringLength);
/*     */     } else {
/* 479 */       this.text = p_146180_1_;
/*     */     } 
/*     */     
/* 482 */     setCursorPositionEnd();
/*     */   }
/*     */   
/*     */   public boolean textboxKeyTyped(char p_146201_1_, int p_146201_2_) {
/* 486 */     if (!this.isFocused) {
/* 487 */       return false;
/*     */     }
/* 489 */     switch (p_146201_1_) {
/*     */       case '\001':
/* 491 */         setCursorPositionEnd();
/* 492 */         setSelectionPos(0);
/* 493 */         return true;
/*     */       
/*     */       case '\003':
/* 496 */         GuiScreen.func_146275_d(getSelectedText());
/* 497 */         return true;
/*     */       
/*     */       case '\026':
/* 500 */         if (this.isEnabled) {
/* 501 */           writeText(GuiScreen.func_146277_j());
/*     */         }
/*     */         
/* 504 */         return true;
/*     */       
/*     */       case '\030':
/* 507 */         GuiScreen.func_146275_d(getSelectedText());
/* 508 */         if (this.isEnabled) {
/* 509 */           writeText("");
/*     */         }
/*     */         
/* 512 */         return true;
/*     */     } 
/*     */     
/* 515 */     switch (p_146201_2_) {
/*     */       case 14:
/* 517 */         if (GuiScreen.func_146271_m()) {
/* 518 */           if (this.isEnabled) {
/* 519 */             deleteWords(-1);
/*     */           }
/* 521 */         } else if (this.isEnabled) {
/* 522 */           deleteFromCursor(-1);
/*     */         } 
/*     */         
/* 525 */         return true;
/*     */       
/*     */       case 199:
/* 528 */         if (GuiScreen.func_146272_n()) {
/* 529 */           setSelectionPos(0);
/*     */         } else {
/* 531 */           setCursorPositionZero();
/*     */         } 
/*     */         
/* 534 */         return true;
/*     */       
/*     */       case 203:
/* 537 */         if (GuiScreen.func_146272_n()) {
/* 538 */           if (GuiScreen.func_146271_m()) {
/* 539 */             setSelectionPos(getNthWordFromPos(-1, getSelectionEnd()));
/*     */           } else {
/* 541 */             setSelectionPos(getSelectionEnd() - 1);
/*     */           } 
/* 543 */         } else if (GuiScreen.func_146271_m()) {
/* 544 */           setCursorPosition(getNthWordFromCursor(-1));
/*     */         } else {
/* 546 */           moveCursorBy(-1);
/*     */         } 
/*     */         
/* 549 */         return true;
/*     */       
/*     */       case 205:
/* 552 */         if (GuiScreen.func_146272_n()) {
/* 553 */           if (GuiScreen.func_146271_m()) {
/* 554 */             setSelectionPos(getNthWordFromPos(1, getSelectionEnd()));
/*     */           } else {
/* 556 */             setSelectionPos(getSelectionEnd() + 1);
/*     */           } 
/* 558 */         } else if (GuiScreen.func_146271_m()) {
/* 559 */           setCursorPosition(getNthWordFromCursor(1));
/*     */         } else {
/* 561 */           moveCursorBy(1);
/*     */         } 
/*     */         
/* 564 */         return true;
/*     */       
/*     */       case 207:
/* 567 */         if (GuiScreen.func_146272_n()) {
/* 568 */           setSelectionPos(this.text.length());
/*     */         } else {
/* 570 */           setCursorPositionEnd();
/*     */         } 
/*     */         
/* 573 */         return true;
/*     */       
/*     */       case 211:
/* 576 */         if (GuiScreen.func_146271_m()) {
/* 577 */           if (this.isEnabled) {
/* 578 */             deleteWords(1);
/*     */           }
/* 580 */         } else if (this.isEnabled) {
/* 581 */           deleteFromCursor(1);
/*     */         } 
/*     */         
/* 584 */         return true;
/*     */     } 
/*     */     
/* 587 */     if (ChatAllowedCharacters.func_71566_a(p_146201_1_)) {
/* 588 */       if (this.isEnabled) {
/* 589 */         writeText(Character.toString(p_146201_1_));
/*     */       }
/*     */       
/* 592 */       return true;
/*     */     } 
/* 594 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCursorCounter() {
/* 602 */     this.cursorCounter++;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify1\GuiPasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */