/*    */ package novoline.font;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Fonts
/*    */ {
/*    */   public static final String BUG = "a";
/*    */   public static final String LIST = "b";
/*    */   public static final String BOMB = "c";
/*    */   public static final String EYE = "d";
/*    */   public static final String PERSON = "e";
/*    */   public static final String WHEELCHAIR = "f";
/*    */   public static final String SCRIPT = "g";
/*    */   public static final String SKIP_LEFT = "h";
/*    */   public static final String PAUSE = "i";
/*    */   public static final String PLAY = "j";
/*    */   public static final String SKIP_RIGHT = "k";
/*    */   public static final String SHUFFLE = "l";
/*    */   public static final String INFO = "m";
/*    */   public static final String SETTINGS = "n";
/*    */   public static final String CHECKMARK = "o";
/*    */   public static final String XMARK = "p";
/*    */   public static final String TRASH = "q";
/*    */   public static final String WARNING = "r";
/*    */   public static final String FOLDER = "s";
/*    */   public static final String LOAD = "t";
/*    */   public static final String SAVE = "u";
/* 33 */   public static final FontManager FONT_MANAGER = Client.getFontManager();
/*    */   
/*    */   public static interface NovolineIcon {
/* 36 */     public static final FontFamily NovolineIcon = Fonts.FONT_MANAGER.fontFamily(FontType.Novoicon);
/* 37 */     public static final class NovolineIcon75 { public static final FontRenderer NovolineIcon75 = Fonts.NovolineIcon.NovolineIcon.ofSize(75); }
/* 38 */     public static final class NovolineIcon45 { public static final FontRenderer NovolineIcon45 = Fonts.NovolineIcon.NovolineIcon.ofSize(35); }
/*    */   
/*    */   }
/*    */   
/*    */   public static interface notification {
/* 43 */     public static final FontFamily notification = Fonts.FONT_MANAGER.fontFamily(FontType.Notification);
/* 44 */     public static final class notification35 { public static final FontRenderer notification35 = Fonts.notification.notification.ofSize(35); }
/*    */   }
/*    */   
/* 47 */   public static interface tenacity { public static final FontFamily tenacity = Fonts.FONT_MANAGER.fontFamily(FontType.tenacity);
/* 48 */     public static final class tenacity18 { public static final FontRenderer tenacity18 = Fonts.tenacity.tenacity.ofSize(18); }
/* 49 */     public static final class tenacity22 { public static final FontRenderer tenacity22 = Fonts.tenacity.tenacity.ofSize(22); } }
/*    */   
/*    */   public static interface tenacityblod {
/* 52 */     public static final FontFamily tenacityblod = Fonts.FONT_MANAGER.fontFamily(FontType.tenacityBlod);
/* 53 */     public static final class tenacityblod22 { public static final FontRenderer tenacityblod22 = Fonts.tenacityblod.tenacityblod.ofSize(22); }
/*    */   }
/*    */   
/*    */   public static interface CsgoIcon {
/* 57 */     public static final FontFamily csgoicon = Fonts.FONT_MANAGER.fontFamily(FontType.csgoicon);
/* 58 */     public static final class csgoicon_18 { public static final FontRenderer csgoicon_18 = Fonts.CsgoIcon.csgoicon.ofSize(18); }
/* 59 */     public static final class csgoicon_20 { public static final FontRenderer csgoicon_20 = Fonts.CsgoIcon.csgoicon.ofSize(20); }
/* 60 */     public static final class csgoicon_24 { public static final FontRenderer csgoicon_24 = Fonts.CsgoIcon.csgoicon.ofSize(24); }
/* 61 */     public static final class csgoicon_32 { public static final FontRenderer csgoicon_32 = Fonts.CsgoIcon.csgoicon.ofSize(32); }
/* 62 */     public static final class csgoicon_35 { public static final FontRenderer csgoicon_35 = Fonts.CsgoIcon.csgoicon.ofSize(35); }
/* 63 */     public static final class csgoicon_40 { public static final FontRenderer csgoicon_40 = Fonts.CsgoIcon.csgoicon.ofSize(40); }
/* 64 */     public static final class csgoicon_55 { public static final FontRenderer csgoicon_55 = Fonts.CsgoIcon.csgoicon.ofSize(55); }
/*    */   
/*    */   }
/*    */   
/*    */   public static interface tenacityCheck {
/* 69 */     public static final FontFamily tenacitycheck = Fonts.FONT_MANAGER.fontFamily(FontType.tenacityCheck);
/* 70 */     public static final class tenacitycheck35 { public static final FontRenderer tenacitycheck35 = Fonts.tenacityCheck.tenacitycheck.ofSize(35); } }
/*    */   
/*    */   public static interface posterama {
/* 73 */     public static final FontFamily posterama = Fonts.FONT_MANAGER.fontFamily(FontType.posterama);
/* 74 */     public static final class posterama13 { public static final FontRenderer posterama13 = Fonts.posterama.posterama.ofSize(13); }
/* 75 */     public static final class posterama20 { public static final FontRenderer posterama20 = Fonts.posterama.posterama.ofSize(20); }
/* 76 */     public static final class posterama16 { public static final FontRenderer posterama16 = Fonts.posterama.posterama.ofSize(16); }
/* 77 */     public static final class posterama18 { public static final FontRenderer posterama18 = Fonts.posterama.posterama.ofSize(18); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\Fonts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */