/*    */ package novoline.font;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FontManager
/*    */ {
/*    */   FontFamily fontFamily(FontType paramFontType);
/*    */   
/*    */   default FontRenderer font(FontType fontType, int size) {
/* 14 */     return fontFamily(fontType).ofSize(size);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\FontManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */