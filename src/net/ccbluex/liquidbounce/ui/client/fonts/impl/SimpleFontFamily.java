/*    */ package net.ccbluex.liquidbounce.ui.client.fonts.impl;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontFamily;
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontRenderer;
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontType;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class SimpleFontFamily
/*    */   implements FontFamily
/*    */ {
/*    */   private final FontType fontType;
/*    */   private final Font awtFont;
/*    */   
/*    */   private SimpleFontFamily(FontType fontType, Font awtFont) {
/* 17 */     this.fontType = fontType;
/* 18 */     this.awtFont = awtFont;
/*    */   }
/*    */   
/*    */   static FontFamily create(FontType fontType, Font awtFont) {
/* 22 */     return new SimpleFontFamily(fontType, awtFont);
/*    */   }
/*    */ 
/*    */   
/*    */   public FontRenderer ofSize(int size) {
/* 27 */     return SimpleFontRenderer.create(this.awtFont.deriveFont(0, size));
/*    */   }
/*    */   
/*    */   public FontType font() {
/* 31 */     return this.fontType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\fonts\impl\SimpleFontFamily.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */