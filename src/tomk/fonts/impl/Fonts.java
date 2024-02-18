/*     */ package tomk.fonts.impl;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.utils.ClientMain;
/*     */ import tomk.fonts.api.FontFamily;
/*     */ import tomk.fonts.api.FontManager;
/*     */ import tomk.fonts.api.FontRenderer;
/*     */ import tomk.fonts.api.FontType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Fonts
/*     */ {
/*  17 */   public static final FontManager FONT_MANAGER = ClientMain.getInstance().getFontManager();
/*     */   
/*     */   public static interface JelloMedium {
/*  20 */     public static final FontFamily JelloMedium = Fonts.FONT_MANAGER.fontFamily(FontType.JelloMedium);
/*  21 */     public static final class JelloMedium_16 { public static final FontRenderer JelloMedium_16 = Fonts.JelloMedium.JelloMedium.ofSize(16); }
/*  22 */     public static final class JelloMedium_28 { public static final FontRenderer JelloMedium_28 = Fonts.JelloMedium.JelloMedium.ofSize(20); }
/*  23 */     public static final class JelloMedium_22 { public static final FontRenderer JelloMedium_22 = Fonts.JelloMedium.JelloMedium.ofSize(24); }
/*  24 */     public static final class JelloMedium_32 { public static final FontRenderer JelloMedium_32 = Fonts.JelloMedium.JelloMedium.ofSize(32); }
/*  25 */     public static final class JelloMedium_35 { public static final FontRenderer JelloMedium_35 = Fonts.JelloMedium.JelloMedium.ofSize(35); }
/*  26 */     public static final class JelloMedium_50 { public static final FontRenderer JelloMedium_50 = Fonts.JelloMedium.JelloMedium.ofSize(50); } }
/*     */   
/*     */   public static interface JelloLight {
/*  29 */     public static final FontFamily JelloMedium = Fonts.FONT_MANAGER.fontFamily(FontType.JelloLight);
/*  30 */     public static final class JelloLight_24 { public static final FontRenderer JelloLight_24 = Fonts.JelloLight.JelloMedium.ofSize(24); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface ICONFONT {
/*  35 */     public static final FontFamily ICONFONT = Fonts.FONT_MANAGER.fontFamily(FontType.ICONFONT);
/*     */     
/*  37 */     public static final class ICONFONT_16 { public static final FontRenderer ICONFONT_16 = Fonts.ICONFONT.ICONFONT.ofSize(16); }
/*  38 */     public static final class ICONFONT_20 { public static final FontRenderer ICONFONT_20 = Fonts.ICONFONT.ICONFONT.ofSize(20); }
/*  39 */     public static final class ICONFONT_24 { public static final FontRenderer ICONFONT_24 = Fonts.ICONFONT.ICONFONT.ofSize(24); }
/*  40 */     public static final class ICONFONT_32 { public static final FontRenderer ICONFONT_32 = Fonts.ICONFONT.ICONFONT.ofSize(32); }
/*  41 */     public static final class ICONFONT_35 { public static final FontRenderer ICONFONT_35 = Fonts.ICONFONT.ICONFONT.ofSize(35); }
/*  42 */     public static final class ICONFONT_50 { public static final FontRenderer ICONFONT_50 = Fonts.ICONFONT.ICONFONT.ofSize(50); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface CheckFont {
/*  47 */     public static final FontFamily CheckFont = Fonts.FONT_MANAGER.fontFamily(FontType.Check);
/*     */     
/*  49 */     public static final class CheckFont_16 { public static final FontRenderer CheckFont_16 = Fonts.CheckFont.CheckFont.ofSize(16); }
/*  50 */     public static final class CheckFont_20 { public static final FontRenderer CheckFont_20 = Fonts.CheckFont.CheckFont.ofSize(20); }
/*  51 */     public static final class CheckFont_24 { public static final FontRenderer CheckFont_24 = Fonts.CheckFont.CheckFont.ofSize(24); }
/*  52 */     public static final class CheckFont_32 { public static final FontRenderer CheckFont_32 = Fonts.CheckFont.CheckFont.ofSize(32); }
/*  53 */     public static final class CheckFont_35 { public static final FontRenderer CheckFont_35 = Fonts.CheckFont.CheckFont.ofSize(35); }
/*  54 */     public static final class CheckFont_50 { public static final FontRenderer CheckFont_50 = Fonts.CheckFont.CheckFont.ofSize(50); }
/*     */   }
/*     */   
/*     */   public static interface SF {
/*  58 */     public static final FontFamily SF = Fonts.FONT_MANAGER.fontFamily(FontType.SF);
/*  59 */     public static final class SF_9 { public static final FontRenderer SF_9 = Fonts.SF.SF.ofSize(9); }
/*  60 */     public static final class SF_11 { public static final FontRenderer SF_11 = Fonts.SF.SF.ofSize(11); }
/*  61 */     public static final class SF_14 { public static final FontRenderer SF_14 = Fonts.SF.SF.ofSize(14); }
/*  62 */     public static final class SF_15 { public static final FontRenderer SF_15 = Fonts.SF.SF.ofSize(15); }
/*  63 */     public static final class SF_16 { public static final FontRenderer SF_16 = Fonts.SF.SF.ofSize(16); }
/*  64 */     public static final class SF_17 { public static final FontRenderer SF_17 = Fonts.SF.SF.ofSize(17); }
/*  65 */     public static final class SF_18 { public static final FontRenderer SF_18 = Fonts.SF.SF.ofSize(18); }
/*  66 */     public static final class SF_19 { public static final FontRenderer SF_19 = Fonts.SF.SF.ofSize(19); }
/*  67 */     public static final class SF_20 { public static final FontRenderer SF_20 = Fonts.SF.SF.ofSize(20); }
/*  68 */     public static final class SF_21 { public static final FontRenderer SF_21 = Fonts.SF.SF.ofSize(21); }
/*  69 */     public static final class SF_22 { public static final FontRenderer SF_22 = Fonts.SF.SF.ofSize(22); }
/*  70 */     public static final class SF_23 { public static final FontRenderer SF_23 = Fonts.SF.SF.ofSize(23); }
/*  71 */     public static final class SF_24 { public static final FontRenderer SF_24 = Fonts.SF.SF.ofSize(24); }
/*  72 */     public static final class SF_25 { public static final FontRenderer SF_25 = Fonts.SF.SF.ofSize(25); }
/*  73 */     public static final class SF_26 { public static final FontRenderer SF_26 = Fonts.SF.SF.ofSize(26); }
/*  74 */     public static final class SF_27 { public static final FontRenderer SF_27 = Fonts.SF.SF.ofSize(27); }
/*  75 */     public static final class SF_28 { public static final FontRenderer SF_28 = Fonts.SF.SF.ofSize(28); }
/*  76 */     public static final class SF_29 { public static final FontRenderer SF_29 = Fonts.SF.SF.ofSize(29); }
/*  77 */     public static final class SF_30 { public static final FontRenderer SF_30 = Fonts.SF.SF.ofSize(30); }
/*  78 */     public static final class SF_31 { public static final FontRenderer SF_31 = Fonts.SF.SF.ofSize(31); }
/*  79 */     public static final class SF_50 { public static final FontRenderer SF_50 = Fonts.SF.SF.ofSize(45); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface CsgoIcon
/*     */   {
/*  87 */     public static final FontFamily csgoicon = Fonts.FONT_MANAGER.fontFamily(FontType.csgoicon);
/*  88 */     public static final class csgoicon_18 { public static final FontRenderer csgoicon_18 = Fonts.CsgoIcon.csgoicon.ofSize(18); }
/*  89 */     public static final class csgoicon_20 { public static final FontRenderer csgoicon_20 = Fonts.CsgoIcon.csgoicon.ofSize(20); }
/*  90 */     public static final class csgoicon_24 { public static final FontRenderer csgoicon_24 = Fonts.CsgoIcon.csgoicon.ofSize(24); }
/*  91 */     public static final class csgoicon_32 { public static final FontRenderer csgoicon_32 = Fonts.CsgoIcon.csgoicon.ofSize(32); }
/*  92 */     public static final class csgoicon_35 { public static final FontRenderer csgoicon_35 = Fonts.CsgoIcon.csgoicon.ofSize(35); }
/*  93 */     public static final class csgoicon_40 { public static final FontRenderer csgoicon_40 = Fonts.CsgoIcon.csgoicon.ofSize(40); }
/*  94 */     public static final class csgoicon_55 { public static final FontRenderer csgoicon_55 = Fonts.CsgoIcon.csgoicon.ofSize(55); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface Tahoma
/*     */   {
/* 100 */     public static final FontFamily Tahoma = Fonts.FONT_MANAGER.fontFamily(FontType.Tahoma);
/*     */     
/* 102 */     public static final class Tahoma_11 { public static final FontRenderer Tahoma_11 = Fonts.Tahoma.Tahoma.ofSize(11); }
/* 103 */     public static final class Tahoma_12 { public static final FontRenderer Tahoma_12 = Fonts.Tahoma.Tahoma.ofSize(12); }
/* 104 */     public static final class Tahoma_14 { public static final FontRenderer Tahoma_14 = Fonts.Tahoma.Tahoma.ofSize(14); }
/* 105 */     public static final class Tahoma_16 { public static final FontRenderer Tahoma_16 = Fonts.Tahoma.Tahoma.ofSize(16); }
/* 106 */     public static final class Tahoma_18 { public static final FontRenderer Tahoma_18 = Fonts.Tahoma.Tahoma.ofSize(18); }
/* 107 */     public static final class Tahoma_20 { public static final FontRenderer Tahoma_20 = Fonts.Tahoma.Tahoma.ofSize(20); }
/* 108 */     public static final class Tahoma_22 { public static final FontRenderer Tahoma_22 = Fonts.Tahoma.Tahoma.ofSize(22); }
/* 109 */     public static final class Tahoma_26 { public static final FontRenderer Tahoma_26 = Fonts.Tahoma.Tahoma.ofSize(26); }
/* 110 */     public static final class Tahoma_28 { public static final FontRenderer Tahoma_28 = Fonts.Tahoma.Tahoma.ofSize(28); }
/* 111 */     public static final class Tahoma_35 { public static final FontRenderer Tahoma_35 = Fonts.Tahoma.Tahoma.ofSize(35); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface SFBOLD {
/* 116 */     public static final FontFamily SFBOLD = Fonts.FONT_MANAGER.fontFamily(FontType.SFBOLD);
/*     */     
/* 118 */     public static final class SFBOLD_14 { public static final FontRenderer SFBOLD_14 = Fonts.SFBOLD.SFBOLD.ofSize(11); }
/* 119 */     public static final class SFBOLD_15 { public static final FontRenderer SFBOLD_15 = Fonts.SFBOLD.SFBOLD.ofSize(12); }
/* 120 */     public static final class SFBOLD_16 { public static final FontRenderer SFBOLD_16 = Fonts.SFBOLD.SFBOLD.ofSize(16); }
/* 121 */     public static final class SFBOLD_18 { public static final FontRenderer SFBOLD_18 = Fonts.SFBOLD.SFBOLD.ofSize(18); }
/* 122 */     public static final class SFBOLD_20 { public static final FontRenderer SFBOLD_20 = Fonts.SFBOLD.SFBOLD.ofSize(20); }
/* 123 */     public static final class SFBOLD_22 { public static final FontRenderer SFBOLD_22 = Fonts.SFBOLD.SFBOLD.ofSize(22); }
/* 124 */     public static final class SFBOLD_26 { public static final FontRenderer SFBOLD_26 = Fonts.SFBOLD.SFBOLD.ofSize(26); }
/* 125 */     public static final class SFBOLD_28 { public static final FontRenderer SFBOLD_28 = Fonts.SFBOLD.SFBOLD.ofSize(28); }
/* 126 */     public static final class SFBOLD_35 { public static final FontRenderer SFBOLD_35 = Fonts.SFBOLD.SFBOLD.ofSize(35); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\fonts\impl\Fonts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */