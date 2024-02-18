/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.objects;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiPageButtonList;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import tomk.fonts.api.FontRenderer;
/*     */ import tomk.utils.LiYingUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PasswordField
/*     */   extends Gui
/*     */ {
/*     */   private final int id;
/*     */   private final int height;
/*     */   private final FontRenderer fontRenderer;
/*     */   public int width;
/*  28 */   public int bottomBarColor = -1; public int textColor = -1; public int cursorColor = -1;
/*     */   
/*     */   public int xPosition;
/*     */   
/*     */   public int yPosition;
/*     */   
/*     */   public String placeholder;
/*     */   
/*     */   public double placeHolderTextX;
/*     */   
/*  38 */   private String text = "";
/*  39 */   private int maxStringLength = 32;
/*     */ 
/*     */   
/*     */   private int cursorCounter;
/*     */ 
/*     */   
/*     */   private boolean enableBackgroundDrawing = true;
/*     */ 
/*     */   
/*     */   private boolean canLoseFocus = true;
/*     */ 
/*     */   
/*     */   private boolean isFocused;
/*     */ 
/*     */   
/*     */   private boolean isEnabled = true;
/*     */ 
/*     */   
/*     */   private int lineScrollOffset;
/*     */   
/*     */   private int cursorPosition;
/*     */   
/*     */   private int selectionEnd;
/*     */   
/*  63 */   private int enabledColor = 14737632;
/*  64 */   private int disabledColor = 7368816;
/*     */   
/*     */   private boolean visible = true;
/*     */   
/*     */   private GuiPageButtonList.GuiResponder field_175210_x;
/*     */   
/*     */   private Predicate<String> field_175209_y = s -> true;
/*     */   
/*     */   public PasswordField(String placeholder, int componentId, int x, int y, int par5Width, int par6Height, FontRenderer fr) {
/*  73 */     this.placeholder = placeholder;
/*  74 */     this.id = componentId;
/*  75 */     this.xPosition = x;
/*  76 */     this.yPosition = y;
/*  77 */     this.width = par5Width;
/*  78 */     this.height = par6Height;
/*  79 */     this.fontRenderer = fr;
/*  80 */     this.placeHolderTextX = ((this.xPosition + this.width) / 2.0F);
/*     */   }
/*     */   
/*     */   public PasswordField(String placeholder, int componentId, int x, int y, int par5Width, int par6Height, FontRenderer fr, int textColor) {
/*  84 */     this.placeholder = placeholder;
/*  85 */     this.id = componentId;
/*  86 */     this.xPosition = x;
/*  87 */     this.yPosition = y;
/*  88 */     this.width = par5Width;
/*  89 */     this.height = par6Height;
/*  90 */     this.fontRenderer = fr;
/*  91 */     this.textColor = textColor;
/*  92 */     this.placeHolderTextX = ((this.xPosition + this.width) / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_175207_a(GuiPageButtonList.GuiResponder p_175207_1_) {
/*  97 */     this.field_175210_x = p_175207_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateCursorCounter() {
/* 104 */     this.cursorCounter++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 111 */     return this.text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String p_146180_1_) {
/* 118 */     if (this.field_175209_y.apply(p_146180_1_)) {
/* 119 */       if (p_146180_1_.length() > this.maxStringLength) {
/* 120 */         this.text = p_146180_1_.substring(0, this.maxStringLength);
/*     */       } else {
/* 122 */         this.text = p_146180_1_;
/*     */       } 
/*     */       
/* 125 */       setCursorPositionEnd();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectedText() {
/* 133 */     int i = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/* 134 */     int j = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/* 135 */     return this.text.substring(i, j);
/*     */   }
/*     */   
/*     */   public void func_175205_a(Predicate<String> p_175205_1_) {
/* 139 */     this.field_175209_y = p_175205_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeText(String text) {
/*     */     int l;
/* 146 */     String s = "";
/* 147 */     String s1 = ChatAllowedCharacters.func_71565_a(text);
/* 148 */     int i = Math.min(this.cursorPosition, this.selectionEnd);
/* 149 */     int j = Math.max(this.cursorPosition, this.selectionEnd);
/* 150 */     int k = this.maxStringLength - this.text.length() - i - j;
/*     */ 
/*     */     
/* 153 */     if (this.text.length() > 0) {
/* 154 */       s = s + this.text.substring(0, i);
/*     */     }
/*     */     
/* 157 */     if (k < s1.length()) {
/* 158 */       s = s + s1.substring(0, k);
/* 159 */       l = k;
/*     */     } else {
/* 161 */       s = s + s1;
/* 162 */       l = s1.length();
/*     */     } 
/*     */     
/* 165 */     if (this.text.length() > 0 && j < this.text.length()) {
/* 166 */       s = s + this.text.substring(j);
/*     */     }
/*     */     
/* 169 */     if (this.field_175209_y.apply(s)) {
/* 170 */       this.text = s;
/* 171 */       moveCursorBy(i - this.selectionEnd + l);
/*     */       
/* 173 */       if (this.field_175210_x != null) {
/* 174 */         this.field_175210_x.func_175319_a(this.id, this.text);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteWords(int p_146177_1_) {
/* 184 */     if (this.text.length() != 0) {
/* 185 */       if (this.selectionEnd != this.cursorPosition) {
/* 186 */         writeText("");
/*     */       } else {
/* 188 */         deleteFromCursor(getNthWordFromCursor(p_146177_1_) - this.cursorPosition);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void drawTextBox() {
/* 194 */     drawTextBox(this.text, false);
/*     */   }
/*     */   
/*     */   public void drawPasswordBox() {
/* 198 */     drawTextBox(this.text, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteFromCursor(int p_146175_1_) {
/* 205 */     if (this.text.length() != 0) {
/* 206 */       if (this.selectionEnd != this.cursorPosition) {
/* 207 */         writeText("");
/*     */       } else {
/* 209 */         boolean flag = (p_146175_1_ < 0);
/* 210 */         int i = flag ? (this.cursorPosition + p_146175_1_) : this.cursorPosition;
/* 211 */         int j = flag ? this.cursorPosition : (this.cursorPosition + p_146175_1_);
/* 212 */         String s = "";
/*     */         
/* 214 */         if (i >= 0) {
/* 215 */           s = this.text.substring(0, i);
/*     */         }
/*     */         
/* 218 */         if (j < this.text.length()) {
/* 219 */           s = s + this.text.substring(j);
/*     */         }
/*     */         
/* 222 */         if (this.field_175209_y.apply(s)) {
/* 223 */           this.text = s;
/*     */           
/* 225 */           if (flag) {
/* 226 */             moveCursorBy(p_146175_1_);
/*     */           }
/*     */           
/* 229 */           if (this.field_175210_x != null) {
/* 230 */             this.field_175210_x.func_175319_a(this.id, this.text);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public int getId() {
/* 238 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNthWordFromCursor(int p_146187_1_) {
/* 245 */     return getNthWordFromPos(p_146187_1_, getCursorPosition());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNthWordFromPos(int p_146183_1_, int p_146183_2_) {
/* 252 */     return func_146197_a(p_146183_1_, p_146183_2_, true);
/*     */   }
/*     */   
/*     */   public int func_146197_a(int p_146197_1_, int p_146197_2_, boolean p_146197_3_) {
/* 256 */     int i = p_146197_2_;
/* 257 */     boolean flag = (p_146197_1_ < 0);
/* 258 */     int j = Math.abs(p_146197_1_);
/*     */     
/* 260 */     for (int k = 0; k < j; k++) {
/* 261 */       if (!flag) {
/* 262 */         int l = this.text.length();
/* 263 */         i = this.text.indexOf(' ', i);
/*     */         
/* 265 */         if (i == -1) {
/* 266 */           i = l;
/*     */         } else {
/* 268 */           while (p_146197_3_ && i < l && this.text.charAt(i) == ' ') {
/* 269 */             i++;
/*     */           }
/*     */         } 
/*     */       } else {
/* 273 */         while (p_146197_3_ && i > 0 && this.text.charAt(i - 1) == ' ') {
/* 274 */           i--;
/*     */         }
/*     */         
/* 277 */         while (i > 0 && this.text.charAt(i - 1) != ' ') {
/* 278 */           i--;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 283 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveCursorBy(int p_146182_1_) {
/* 290 */     setCursorPosition(this.selectionEnd + p_146182_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorPositionZero() {
/* 297 */     setCursorPosition(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorPositionEnd() {
/* 304 */     setCursorPosition(this.text.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean textboxKeyTyped(char p_146201_1_, int p_146201_2_) {
/* 311 */     if (!this.isFocused)
/* 312 */       return false; 
/* 313 */     if (GuiScreen.func_175278_g(p_146201_2_)) {
/* 314 */       setCursorPositionEnd();
/* 315 */       setSelectionPos(0);
/* 316 */       return true;
/* 317 */     }  if (GuiScreen.func_175280_f(p_146201_2_)) {
/* 318 */       GuiScreen.func_146275_d(getSelectedText());
/* 319 */       return true;
/* 320 */     }  if (GuiScreen.func_175279_e(p_146201_2_)) {
/* 321 */       if (this.isEnabled) {
/* 322 */         writeText(GuiScreen.func_146277_j());
/*     */       }
/*     */       
/* 325 */       return true;
/* 326 */     }  if (GuiScreen.func_175277_d(p_146201_2_)) {
/* 327 */       GuiScreen.func_146275_d(getSelectedText());
/*     */       
/* 329 */       if (this.isEnabled) {
/* 330 */         writeText("");
/*     */       }
/*     */       
/* 333 */       return true;
/*     */     } 
/* 335 */     switch (p_146201_2_) {
/*     */       case 14:
/* 337 */         if (GuiScreen.func_146271_m()) {
/* 338 */           if (this.isEnabled) {
/* 339 */             deleteWords(-1);
/*     */           }
/* 341 */         } else if (this.isEnabled) {
/* 342 */           deleteFromCursor(-1);
/*     */         } 
/*     */         
/* 345 */         return true;
/*     */       
/*     */       case 199:
/* 348 */         if (GuiScreen.func_146272_n()) {
/* 349 */           setSelectionPos(0);
/*     */         } else {
/* 351 */           setCursorPositionZero();
/*     */         } 
/*     */         
/* 354 */         return true;
/*     */       
/*     */       case 203:
/* 357 */         if (GuiScreen.func_146272_n()) {
/* 358 */           if (GuiScreen.func_146271_m()) {
/* 359 */             setSelectionPos(getNthWordFromPos(-1, getSelectionEnd()));
/*     */           } else {
/* 361 */             setSelectionPos(getSelectionEnd() - 1);
/*     */           } 
/* 363 */         } else if (GuiScreen.func_146271_m()) {
/* 364 */           setCursorPosition(getNthWordFromCursor(-1));
/*     */         } else {
/* 366 */           moveCursorBy(-1);
/*     */         } 
/*     */         
/* 369 */         return true;
/*     */       
/*     */       case 205:
/* 372 */         if (GuiScreen.func_146272_n()) {
/* 373 */           if (GuiScreen.func_146271_m()) {
/* 374 */             setSelectionPos(getNthWordFromPos(1, getSelectionEnd()));
/*     */           } else {
/* 376 */             setSelectionPos(getSelectionEnd() + 1);
/*     */           } 
/* 378 */         } else if (GuiScreen.func_146271_m()) {
/* 379 */           setCursorPosition(getNthWordFromCursor(1));
/*     */         } else {
/* 381 */           moveCursorBy(1);
/*     */         } 
/*     */         
/* 384 */         return true;
/*     */       
/*     */       case 207:
/* 387 */         if (GuiScreen.func_146272_n()) {
/* 388 */           setSelectionPos(this.text.length());
/*     */         } else {
/* 390 */           setCursorPositionEnd();
/*     */         } 
/*     */         
/* 393 */         return true;
/*     */       
/*     */       case 211:
/* 396 */         if (GuiScreen.func_146271_m()) {
/* 397 */           if (this.isEnabled) {
/* 398 */             deleteWords(1);
/*     */           }
/* 400 */         } else if (this.isEnabled) {
/* 401 */           deleteFromCursor(1);
/*     */         } 
/*     */         
/* 404 */         return true;
/*     */     } 
/*     */     
/* 407 */     if (ChatAllowedCharacters.func_71566_a(p_146201_1_)) {
/* 408 */       if (this.isEnabled) {
/* 409 */         writeText(Character.toString(p_146201_1_));
/*     */       }
/*     */       
/* 412 */       return true;
/*     */     } 
/* 414 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int p_146192_1_, int p_146192_2_, int p_146192_3_) {
/* 424 */     boolean flag = (p_146192_1_ >= this.xPosition && p_146192_1_ < this.xPosition + this.width && p_146192_2_ >= this.yPosition && p_146192_2_ < this.yPosition + this.height);
/*     */     
/* 426 */     if (this.canLoseFocus) {
/* 427 */       setFocused(flag);
/*     */     }
/*     */     
/* 430 */     if (this.isFocused && flag && p_146192_3_ == 0) {
/* 431 */       int i = p_146192_1_ - this.xPosition;
/*     */       
/* 433 */       if (this.enableBackgroundDrawing) {
/* 434 */         i -= 4;
/*     */       }
/*     */       
/* 437 */       String s = this.fontRenderer.trimStringToWidth(this.text.substring(this.lineScrollOffset), getWidth());
/* 438 */       setCursorPosition(this.fontRenderer.trimStringToWidth(s, i).length() + this.lineScrollOffset);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawTextBox(String text, boolean password) {
/* 446 */     if (password) {
/* 447 */       text = text.replaceAll(".", "*");
/*     */     }
/* 449 */     if (getVisible()) {
/* 450 */       if (getEnableBackgroundDrawing()) {
/* 451 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 452 */         func_73734_a(this.xPosition, this.yPosition + this.height, this.xPosition + this.width, this.yPosition + this.height + 1, this.bottomBarColor);
/*     */       } 
/*     */       
/* 455 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 456 */       int i = this.textColor;
/* 457 */       int j = this.cursorPosition - this.lineScrollOffset;
/* 458 */       int k = this.selectionEnd - this.lineScrollOffset;
/* 459 */       String s = this.fontRenderer.trimStringToWidth(text.substring(this.lineScrollOffset), getWidth());
/* 460 */       boolean flag = (j >= 0 && j <= s.length());
/* 461 */       boolean flag1 = (this.isFocused && this.cursorCounter / 6 % 2 == 0 && flag);
/* 462 */       int l = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
/* 463 */       int i1 = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 4) : this.yPosition;
/* 464 */       int j1 = l;
/*     */       
/* 466 */       if (!this.isFocused && this.placeholder != null && text.isEmpty()) {
/* 467 */         this.fontRenderer.drawCenteredString(this.placeholder, (float)this.placeHolderTextX, i1, this.textColor);
/*     */       }
/*     */       
/* 470 */       if (k > s.length()) {
/* 471 */         k = s.length();
/*     */       }
/*     */       
/* 474 */       if (s.length() > 0) {
/* 475 */         String s1 = flag ? s.substring(0, j) : s;
/* 476 */         j1 = (int)this.fontRenderer.drawString(s1, l, i1, i);
/*     */       } 
/*     */       
/* 479 */       boolean flag2 = (this.cursorPosition < text.length() || text.length() >= getMaxStringLength());
/* 480 */       int k1 = j1;
/*     */       
/* 482 */       if (!flag) {
/* 483 */         k1 = (j > 0) ? (l + this.width) : l;
/* 484 */       } else if (flag2) {
/* 485 */         k1 = j1 - 1;
/* 486 */         j1--;
/*     */       } 
/*     */       
/* 489 */       if (s.length() > 0 && flag && j < s.length()) {
/* 490 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 491 */         j1 = (int)this.fontRenderer.drawString(s.substring(j), j1 + 6.0F, i1, i);
/*     */       } 
/*     */       
/* 494 */       if (flag1) {
/* 495 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 496 */         if (flag2) {
/* 497 */           Gui.func_73734_a(k1 + 4, i1 - 1, k1 + 5, i1 + 1 + this.fontRenderer.getHeight(), this.cursorColor);
/*     */         } else {
/* 499 */           this.fontRenderer.drawString("|", k1 + 4.0F, i1, this.textColor);
/*     */         } 
/*     */       } 
/*     */       
/* 503 */       if (k != j) {
/* 504 */         int l1 = l + this.fontRenderer.stringWidth(s.substring(0, k));
/* 505 */         drawCursorVertical(k1, i1 - 1, l1 - 1, i1 + 1 + this.fontRenderer.getHeight());
/*     */       } 
/*     */       
/* 508 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawCursorVertical(int p_146188_1_, int p_146188_2_, int p_146188_3_, int p_146188_4_) {
/* 516 */     if (p_146188_1_ < p_146188_3_) {
/* 517 */       int i = p_146188_1_;
/* 518 */       p_146188_1_ = p_146188_3_;
/* 519 */       p_146188_3_ = i;
/*     */     } 
/*     */     
/* 522 */     if (p_146188_2_ < p_146188_4_) {
/* 523 */       int j = p_146188_2_;
/* 524 */       p_146188_2_ = p_146188_4_;
/* 525 */       p_146188_4_ = j;
/*     */     } 
/*     */     
/* 528 */     if (p_146188_3_ > this.xPosition + this.width) {
/* 529 */       p_146188_3_ = this.xPosition + this.width;
/*     */     }
/*     */     
/* 532 */     if (p_146188_1_ > this.xPosition + this.width) {
/* 533 */       p_146188_1_ = this.xPosition + this.width;
/*     */     }
/*     */     
/* 536 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 537 */     IWorldRenderer worldrenderer = Retreat.INSTANCE.getWrapper().getClassProvider().getTessellatorInstance().getWorldRenderer();
/* 538 */     GlStateManager.func_179131_c(0.0F, 0.0F, 255.0F, 255.0F);
/* 539 */     GlStateManager.func_179090_x();
/* 540 */     GlStateManager.func_179115_u();
/* 541 */     GlStateManager.func_179116_f(5387);
/* 542 */     worldrenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_COLOR));
/* 543 */     worldrenderer.pos(p_146188_1_, p_146188_4_, 0.0D).endVertex();
/* 544 */     worldrenderer.pos(p_146188_3_, p_146188_4_, 0.0D).endVertex();
/* 545 */     worldrenderer.pos(p_146188_3_, p_146188_2_, 0.0D).endVertex();
/* 546 */     worldrenderer.pos(p_146188_1_, p_146188_2_, 0.0D).endVertex();
/* 547 */     tessellator.func_78381_a();
/* 548 */     GlStateManager.func_179134_v();
/* 549 */     GlStateManager.func_179098_w();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxStringLength() {
/* 556 */     return this.maxStringLength;
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int p_146203_1_) {
/* 560 */     this.maxStringLength = p_146203_1_;
/*     */     
/* 562 */     if (this.text.length() > p_146203_1_) {
/* 563 */       this.text = this.text.substring(0, p_146203_1_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCursorPosition() {
/* 572 */     return this.cursorPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorPosition(int p_146190_1_) {
/* 579 */     this.cursorPosition = p_146190_1_;
/* 580 */     int i = this.text.length();
/* 581 */     this.cursorPosition = LiYingUtil.clamp_int(this.cursorPosition, 0, i);
/* 582 */     setSelectionPos(this.cursorPosition);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEnableBackgroundDrawing() {
/* 589 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnableBackgroundDrawing(boolean p_146185_1_) {
/* 596 */     this.enableBackgroundDrawing = p_146185_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextColor(int p_146193_1_) {
/* 603 */     this.enabledColor = p_146193_1_;
/*     */   }
/*     */   
/*     */   public void setDisabledTextColour(int p_146204_1_) {
/* 607 */     this.disabledColor = p_146204_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFocused() {
/* 614 */     return this.isFocused;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFocused(boolean p_146195_1_) {
/* 621 */     if (p_146195_1_ && !this.isFocused) {
/* 622 */       this.cursorCounter = 0;
/*     */     }
/*     */     
/* 625 */     this.isFocused = p_146195_1_;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean p_146184_1_) {
/* 629 */     this.isEnabled = p_146184_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSelectionEnd() {
/* 636 */     return this.selectionEnd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 643 */     return getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectionPos(int p_146199_1_) {
/* 650 */     int i = this.text.length();
/*     */     
/* 652 */     if (p_146199_1_ > i) {
/* 653 */       p_146199_1_ = i;
/*     */     }
/*     */     
/* 656 */     if (p_146199_1_ < 0) {
/* 657 */       p_146199_1_ = 0;
/*     */     }
/*     */     
/* 660 */     this.selectionEnd = p_146199_1_;
/*     */     
/* 662 */     if (this.fontRenderer != null) {
/* 663 */       if (this.lineScrollOffset > i) {
/* 664 */         this.lineScrollOffset = i;
/*     */       }
/*     */       
/* 667 */       int j = getWidth();
/* 668 */       String s = this.fontRenderer.trimStringToWidth(this.text.substring(this.lineScrollOffset), j);
/* 669 */       int k = s.length() + this.lineScrollOffset;
/*     */       
/* 671 */       if (p_146199_1_ == this.lineScrollOffset) {
/* 672 */         this.lineScrollOffset -= this.fontRenderer.trimStringToWidth(this.text, j, true).length();
/*     */       }
/*     */       
/* 675 */       if (p_146199_1_ > k) {
/* 676 */         this.lineScrollOffset += p_146199_1_ - k;
/* 677 */       } else if (p_146199_1_ <= this.lineScrollOffset) {
/* 678 */         this.lineScrollOffset -= this.lineScrollOffset - p_146199_1_;
/*     */       } 
/*     */       
/* 681 */       this.lineScrollOffset = LiYingUtil.clamp_int(this.lineScrollOffset, 0, i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCanLoseFocus(boolean p_146205_1_) {
/* 689 */     this.canLoseFocus = p_146205_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getVisible() {
/* 696 */     return this.visible;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible(boolean p_146189_1_) {
/* 703 */     this.visible = p_146189_1_;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\objects\PasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */