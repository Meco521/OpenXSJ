/*    */ package tomk.fonts.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FontType
/*    */ {
/* 11 */   FIXEDSYS("tahoma.ttf"),
/* 12 */   ICONFONT("stylesicons.ttf"),
/*    */   
/* 14 */   Check("check.ttf"),
/* 15 */   SF("SF.ttf"),
/* 16 */   SFBOLD("SFBOLD.ttf"),
/* 17 */   JelloMedium("jellomedium.ttf"),
/* 18 */   Tahoma("tahoma.ttf"),
/* 19 */   JelloLight("jellolight.ttf"),
/* 20 */   csgoicon("icomoon.ttf");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String fileName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   FontType(String fileName) {
/* 32 */     this.fileName = fileName;
/*    */   }
/*    */   public String fileName() {
/* 35 */     return this.fileName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\fonts\api\FontType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */