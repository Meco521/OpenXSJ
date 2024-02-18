/*    */ package novoline.font;
/*    */ 
/*    */ 
/*    */ public enum FontType
/*    */ {
/*  6 */   Jello_Light("jellolight.ttf"),
/*  7 */   Jello_Medium("jellomedium.ttf"),
/*  8 */   Jello_Regular("jelloregular.ttf"),
/*  9 */   SF("sf.ttf"),
/* 10 */   SFBOLD("sfbold.ttf"),
/* 11 */   SFTHIN("SFREGULAR.ttf"),
/* 12 */   Check("check.ttf"),
/* 13 */   ICONFONT("stylesicons.ttf"),
/* 14 */   flux("flux.ttf"),
/* 15 */   posterama("posterama.ttf"),
/* 16 */   csgoicon("icomoon.ttf"),
/* 17 */   Tahoma("tahoma.ttf"),
/*    */   
/* 19 */   NeverLoserf("neverlose500.ttf"),
/*    */   
/* 21 */   Novoicon("iconnovo.ttf"),
/* 22 */   Neverlose_icon("neverlose_icon.ttf"),
/*    */   
/* 24 */   Debug_Icon("Icon.ttf"),
/*    */   
/* 26 */   Notification("notification-icon.ttf"),
/* 27 */   Novo2("novogui.ttf"),
/* 28 */   tenacity("tenacity.ttf"),
/* 29 */   tenacityBlod("tenacityblod.ttf"),
/* 30 */   tenacityCheck("check.ttf");
/*    */   
/*    */   private final String fileName;
/*    */ 
/*    */   
/*    */   FontType(String fileName) {
/* 36 */     this.fileName = fileName;
/*    */   }
/*    */   public String fileName() {
/* 39 */     return this.fileName;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\FontType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */