/*    */ package novoline.font;
/*    */ 
/*    */ import java.awt.Font;
/*    */ 
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
/* 15 */     this.fontType = fontType;
/* 16 */     this.awtFont = awtFont;
/*    */   }
/*    */   
/*    */   static FontFamily create(FontType fontType, Font awtFont) {
/* 20 */     return new SimpleFontFamily(fontType, awtFont);
/*    */   }
/*    */ 
/*    */   
/*    */   public FontRenderer ofSize(int size) {
/* 25 */     return SimpleFontRenderer.create(this.awtFont.deriveFont(0, size));
/*    */   }
/*    */   
/*    */   public FontType font() {
/* 29 */     return this.fontType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\SimpleFontFamily.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */