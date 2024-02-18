/*    */ package net.ccbluex.liquidbounce.ui.client.fonts.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FontType
/*    */ {
/*  9 */   tenacity("gcf.ttf"),
/* 10 */   tenacitybold("bold.ttf"),
/* 11 */   tenacityCheck("check.ttf"),
/* 12 */   Tahoma("tahoma.ttf"),
/*    */   
/* 14 */   Font("misans.ttf"),
/* 15 */   ICON("logoicon.ttf"),
/* 16 */   Newuiicon("icon.ttf"),
/* 17 */   Jello("jellolight2.ttf"),
/* 18 */   ICONFONT("stylesicons.ttf"),
/*    */   
/* 20 */   Check("check.ttf"),
/* 21 */   icons("icons.ttf"),
/* 22 */   SF("sfui.ttf"),
/* 23 */   SFBOLD("sfbold.ttf"),
/* 24 */   Debug_Icon("icon.ttf"),
/* 25 */   csgoicon("icomoon.ttf");
/*    */ 
/*    */   
/*    */   private final String fileName;
/*    */ 
/*    */   
/*    */   FontType(String fileName) {
/* 32 */     this.fileName = fileName;
/*    */   }
/*    */   public String fileName() {
/* 35 */     return this.fileName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\fonts\api\FontType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */