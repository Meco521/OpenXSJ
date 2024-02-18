/*     */ package net.ccbluex.liquidbounce.ui.client.fonts.impl;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontFamily;
/*     */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontManager;
/*     */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontRenderer;
/*     */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontType;
/*     */ import tomk.utils.ClientMain;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Fonts
/*     */ {
/*  18 */   public static final FontManager FONT_MANAGER = ClientMain.getInstance().getFontManager();
/*     */   
/*  20 */   public static interface font { public static final FontFamily font2 = Fonts.FONT_MANAGER.fontFamily(FontType.Font);
/*  21 */     public static final class font35 { public static final FontRenderer font35 = Fonts.font.font2.ofSize(18); }
/*  22 */     public static final class font40 { public static final FontRenderer font40 = Fonts.font.font2.ofSize(20); } }
/*     */ 
/*     */   
/*     */   public static interface Tahoma {
/*  26 */     public static final FontFamily Tahoma = Fonts.FONT_MANAGER.fontFamily(FontType.Tahoma);
/*     */     
/*  28 */     public static final class Tahoma_11 { public static final FontRenderer Tahoma_11 = Fonts.Tahoma.Tahoma.ofSize(11); }
/*  29 */     public static final class Tahoma_12 { public static final FontRenderer Tahoma_12 = Fonts.Tahoma.Tahoma.ofSize(12); }
/*  30 */     public static final class Tahoma_14 { public static final FontRenderer Tahoma_14 = Fonts.Tahoma.Tahoma.ofSize(14); }
/*  31 */     public static final class Tahoma_16 { public static final FontRenderer Tahoma_16 = Fonts.Tahoma.Tahoma.ofSize(16); }
/*  32 */     public static final class Tahoma_18 { public static final FontRenderer Tahoma_18 = Fonts.Tahoma.Tahoma.ofSize(18); }
/*  33 */     public static final class Tahoma_20 { public static final FontRenderer Tahoma_20 = Fonts.Tahoma.Tahoma.ofSize(20); }
/*  34 */     public static final class Tahoma_22 { public static final FontRenderer Tahoma_22 = Fonts.Tahoma.Tahoma.ofSize(22); }
/*  35 */     public static final class Tahoma_26 { public static final FontRenderer Tahoma_26 = Fonts.Tahoma.Tahoma.ofSize(26); }
/*  36 */     public static final class Tahoma_28 { public static final FontRenderer Tahoma_28 = Fonts.Tahoma.Tahoma.ofSize(28); }
/*  37 */     public static final class Tahoma_35 { public static final FontRenderer Tahoma_35 = Fonts.Tahoma.Tahoma.ofSize(35); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface Newuiicon {
/*  42 */     public static final FontFamily Newuiicon = Fonts.FONT_MANAGER.fontFamily(FontType.Newuiicon);
/*     */     
/*  44 */     public static final class Newuiicon118 { public static final FontRenderer Newuiicon118 = Fonts.Newuiicon.Newuiicon.ofSize(18); }
/*  45 */     public static final class Newuiicon116 { public static final FontRenderer Newuiicon116 = Fonts.Newuiicon.Newuiicon.ofSize(15); }
/*  46 */     public static final class SFBOLD_16 { public static final FontRenderer SFBOLD_16 = Fonts.Newuiicon.Newuiicon.ofSize(16); }
/*  47 */     public static final class SFBOLD_18 { public static final FontRenderer SFBOLD_18 = Fonts.Newuiicon.Newuiicon.ofSize(18); }
/*  48 */     public static final class SFBOLD_20 { public static final FontRenderer SFBOLD_20 = Fonts.Newuiicon.Newuiicon.ofSize(20); }
/*  49 */     public static final class SFBOLD_22 { public static final FontRenderer SFBOLD_22 = Fonts.Newuiicon.Newuiicon.ofSize(22); }
/*  50 */     public static final class SFBOLD_26 { public static final FontRenderer SFBOLD_26 = Fonts.Newuiicon.Newuiicon.ofSize(26); }
/*  51 */     public static final class SFBOLD_28 { public static final FontRenderer SFBOLD_28 = Fonts.Newuiicon.Newuiicon.ofSize(28); }
/*  52 */     public static final class SFBOLD_35 { public static final FontRenderer SFBOLD_35 = Fonts.Newuiicon.Newuiicon.ofSize(35); } }
/*     */   
/*     */   public static interface ICON {
/*  55 */     public static final FontFamily ICON = Fonts.FONT_MANAGER.fontFamily(FontType.ICON);
/*     */     
/*  57 */     public static final class ICON26 { public static final FontRenderer ICON26 = Fonts.ICON.ICON.ofSize(26); }
/*  58 */     public static final class ICON18 { public static final FontRenderer ICON18 = Fonts.ICON.ICON.ofSize(18); }
/*     */   }
/*     */   
/*     */   public static interface jello {
/*  62 */     public static final FontFamily jello = Fonts.FONT_MANAGER.fontFamily(FontType.Jello);
/*  63 */     public static final class jello18 { public static final FontRenderer jello18 = Fonts.jello.jello.ofSize(18); }
/*  64 */     public static final class jello20 { public static final FontRenderer jello20 = Fonts.jello.jello.ofSize(20); }
/*  65 */     public static final class jello45 { public static final FontRenderer jello45 = Fonts.jello.jello.ofSize(45); }
/*     */   
/*     */   }
/*     */   
/*  69 */   public static interface tenacity { public static final FontFamily tenacity = Fonts.FONT_MANAGER.fontFamily(FontType.tenacity);
/*  70 */     public static final class tenacity18 { public static final FontRenderer tenacity18 = Fonts.tenacity.tenacity.ofSize(18); }
/*  71 */     public static final class tenacity16 { public static final FontRenderer tenacity16 = Fonts.tenacity.tenacity.ofSize(18); }
/*  72 */     public static final class tenacity14 { public static final FontRenderer tenacity14 = Fonts.tenacity.tenacity.ofSize(14); }
/*  73 */     public static final class tenacity20 { public static final FontRenderer tenacity20 = Fonts.tenacity.tenacity.ofSize(20); }
/*  74 */     public static final class tenacity22 { public static final FontRenderer tenacity22 = Fonts.tenacity.tenacity.ofSize(22); } }
/*     */   
/*     */   public static interface tenacitybold {
/*  77 */     public static final FontFamily tenacitybold = Fonts.FONT_MANAGER.fontFamily(FontType.tenacitybold);
/*  78 */     public static final class tenacitybold22 { public static final FontRenderer tenacitybold22 = Fonts.tenacitybold.tenacitybold.ofSize(22); }
/*  79 */     public static final class tenacitybold13 { public static final FontRenderer tenacitybold13 = Fonts.tenacitybold.tenacitybold.ofSize(13); }
/*  80 */     public static final class tenacitybold20 { public static final FontRenderer tenacitybold20 = Fonts.tenacitybold.tenacitybold.ofSize(20); }
/*  81 */     public static final class tenacitybold16 { public static final FontRenderer tenacitybold16 = Fonts.tenacitybold.tenacitybold.ofSize(16); }
/*  82 */     public static final class tenacitybold18 { public static final FontRenderer tenacitybold18 = Fonts.tenacitybold.tenacitybold.ofSize(18); }
/*  83 */     public static final class tenacitybold26 { public static final FontRenderer tenacitybold26 = Fonts.tenacitybold.tenacitybold.ofSize(26); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface DebugIcon {
/*  88 */     public static final FontFamily DebugIcon = Fonts.FONT_MANAGER.fontFamily(FontType.Debug_Icon);
/*  89 */     public static final class DebugIcon_30 { public static final FontRenderer DebugIcon_30 = Fonts.DebugIcon.DebugIcon.ofSize(30); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface ICONFONT {
/*  94 */     public static final FontFamily ICONFONT = Fonts.FONT_MANAGER.fontFamily(FontType.ICONFONT);
/*     */     
/*  96 */     public static final class ICONFONT_16 { public static final FontRenderer ICONFONT_16 = Fonts.ICONFONT.ICONFONT.ofSize(16); }
/*  97 */     public static final class ICONFONT_20 { public static final FontRenderer ICONFONT_20 = Fonts.ICONFONT.ICONFONT.ofSize(20); }
/*  98 */     public static final class ICONFONT_24 { public static final FontRenderer ICONFONT_24 = Fonts.ICONFONT.ICONFONT.ofSize(24); }
/*  99 */     public static final class ICONFONT_32 { public static final FontRenderer ICONFONT_32 = Fonts.ICONFONT.ICONFONT.ofSize(32); }
/* 100 */     public static final class ICONFONT_35 { public static final FontRenderer ICONFONT_35 = Fonts.ICONFONT.ICONFONT.ofSize(35); }
/* 101 */     public static final class ICONFONT_50 { public static final FontRenderer ICONFONT_50 = Fonts.ICONFONT.ICONFONT.ofSize(50); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface CheckFont {
/* 106 */     public static final FontFamily CheckFont = Fonts.FONT_MANAGER.fontFamily(FontType.Check);
/*     */     
/* 108 */     public static final class CheckFont_16 { public static final FontRenderer CheckFont_16 = Fonts.CheckFont.CheckFont.ofSize(16); }
/* 109 */     public static final class CheckFont_20 { public static final FontRenderer CheckFont_20 = Fonts.CheckFont.CheckFont.ofSize(20); }
/* 110 */     public static final class CheckFont_24 { public static final FontRenderer CheckFont_24 = Fonts.CheckFont.CheckFont.ofSize(24); }
/* 111 */     public static final class CheckFont_32 { public static final FontRenderer CheckFont_32 = Fonts.CheckFont.CheckFont.ofSize(32); }
/* 112 */     public static final class CheckFont_35 { public static final FontRenderer CheckFont_35 = Fonts.CheckFont.CheckFont.ofSize(35); }
/* 113 */     public static final class CheckFont_50 { public static final FontRenderer CheckFont_50 = Fonts.CheckFont.CheckFont.ofSize(50); }
/*     */   }
/*     */   
/*     */   public static interface SF {
/* 117 */     public static final FontFamily SF = Fonts.FONT_MANAGER.fontFamily(FontType.SF);
/* 118 */     public static final class SF_9 { public static final FontRenderer SF_9 = Fonts.SF.SF.ofSize(9); }
/* 119 */     public static final class SF_11 { public static final FontRenderer SF_11 = Fonts.SF.SF.ofSize(11); }
/* 120 */     public static final class SF_14 { public static final FontRenderer SF_14 = Fonts.SF.SF.ofSize(14); }
/* 121 */     public static final class SF_15 { public static final FontRenderer SF_15 = Fonts.SF.SF.ofSize(15); }
/* 122 */     public static final class SF_16 { public static final FontRenderer SF_16 = Fonts.SF.SF.ofSize(16); }
/* 123 */     public static final class SF_17 { public static final FontRenderer SF_17 = Fonts.SF.SF.ofSize(17); }
/* 124 */     public static final class SF_18 { public static final FontRenderer SF_18 = Fonts.SF.SF.ofSize(18); }
/* 125 */     public static final class SF_19 { public static final FontRenderer SF_19 = Fonts.SF.SF.ofSize(19); }
/* 126 */     public static final class SF_20 { public static final FontRenderer SF_20 = Fonts.SF.SF.ofSize(20); }
/* 127 */     public static final class SF_21 { public static final FontRenderer SF_21 = Fonts.SF.SF.ofSize(21); }
/* 128 */     public static final class SF_22 { public static final FontRenderer SF_22 = Fonts.SF.SF.ofSize(22); }
/* 129 */     public static final class SF_23 { public static final FontRenderer SF_23 = Fonts.SF.SF.ofSize(23); }
/* 130 */     public static final class SF_24 { public static final FontRenderer SF_24 = Fonts.SF.SF.ofSize(24); }
/* 131 */     public static final class SF_25 { public static final FontRenderer SF_25 = Fonts.SF.SF.ofSize(25); }
/* 132 */     public static final class SF_26 { public static final FontRenderer SF_26 = Fonts.SF.SF.ofSize(26); }
/* 133 */     public static final class SF_27 { public static final FontRenderer SF_27 = Fonts.SF.SF.ofSize(27); }
/* 134 */     public static final class SF_28 { public static final FontRenderer SF_28 = Fonts.SF.SF.ofSize(28); }
/* 135 */     public static final class SF_29 { public static final FontRenderer SF_29 = Fonts.SF.SF.ofSize(29); }
/* 136 */     public static final class SF_30 { public static final FontRenderer SF_30 = Fonts.SF.SF.ofSize(30); }
/* 137 */     public static final class SF_31 { public static final FontRenderer SF_31 = Fonts.SF.SF.ofSize(31); }
/* 138 */     public static final class SF_50 { public static final FontRenderer SF_50 = Fonts.SF.SF.ofSize(45); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface Icons
/*     */   {
/* 144 */     public static final FontFamily icons = Fonts.FONT_MANAGER.fontFamily(FontType.icons);
/* 145 */     public static final class icons_18 { public static final FontRenderer icons_18 = Fonts.Icons.icons.ofSize(18); }
/* 146 */     public static final class icons_20 { public static final FontRenderer icons_20 = Fonts.Icons.icons.ofSize(20); }
/* 147 */     public static final class icons_24 { public static final FontRenderer icons_24 = Fonts.Icons.icons.ofSize(24); }
/* 148 */     public static final class icons_32 { public static final FontRenderer icons_32 = Fonts.Icons.icons.ofSize(32); }
/* 149 */     public static final class icons_35 { public static final FontRenderer icons_35 = Fonts.Icons.icons.ofSize(35); }
/* 150 */     public static final class icons_40 { public static final FontRenderer icons_40 = Fonts.Icons.icons.ofSize(40); }
/* 151 */     public static final class icons_55 { public static final FontRenderer icons_55 = Fonts.Icons.icons.ofSize(55); }
/*     */   }
/*     */   
/*     */   public static interface tenacityCheck {
/* 155 */     public static final FontFamily tenacitycheck = Fonts.FONT_MANAGER.fontFamily(FontType.tenacityCheck);
/* 156 */     public static final class tenacitycheck35 { public static final FontRenderer tenacitycheck35 = Fonts.tenacityCheck.tenacitycheck.ofSize(35); }
/*     */   }
/*     */   
/*     */   public static interface CsgoIcon {
/* 160 */     public static final FontFamily csgoicon = Fonts.FONT_MANAGER.fontFamily(FontType.csgoicon);
/* 161 */     public static final class csgoicon_18 { public static final FontRenderer csgoicon_18 = Fonts.CsgoIcon.csgoicon.ofSize(18); }
/* 162 */     public static final class csgoicon_20 { public static final FontRenderer csgoicon_20 = Fonts.CsgoIcon.csgoicon.ofSize(20); }
/* 163 */     public static final class csgoicon_24 { public static final FontRenderer csgoicon_24 = Fonts.CsgoIcon.csgoicon.ofSize(24); }
/* 164 */     public static final class csgoicon_32 { public static final FontRenderer csgoicon_32 = Fonts.CsgoIcon.csgoicon.ofSize(32); }
/* 165 */     public static final class csgoicon_35 { public static final FontRenderer csgoicon_35 = Fonts.CsgoIcon.csgoicon.ofSize(35); }
/* 166 */     public static final class csgoicon_40 { public static final FontRenderer csgoicon_40 = Fonts.CsgoIcon.csgoicon.ofSize(40); }
/* 167 */     public static final class csgoicon_55 { public static final FontRenderer csgoicon_55 = Fonts.CsgoIcon.csgoicon.ofSize(55); }
/*     */   
/*     */   }
/*     */   
/*     */   public static interface SFBOLD
/*     */   {
/* 173 */     public static final FontFamily SFBOLD = Fonts.FONT_MANAGER.fontFamily(FontType.SFBOLD);
/*     */     
/* 175 */     public static final class SFBOLD_14 { public static final FontRenderer SFBOLD_14 = Fonts.SFBOLD.SFBOLD.ofSize(14); }
/* 176 */     public static final class SFBOLD_15 { public static final FontRenderer SFBOLD_15 = Fonts.SFBOLD.SFBOLD.ofSize(15); }
/* 177 */     public static final class SFBOLD_16 { public static final FontRenderer SFBOLD_16 = Fonts.SFBOLD.SFBOLD.ofSize(16); }
/* 178 */     public static final class SFBOLD_18 { public static final FontRenderer SFBOLD_18 = Fonts.SFBOLD.SFBOLD.ofSize(18); }
/* 179 */     public static final class SFBOLD_20 { public static final FontRenderer SFBOLD_20 = Fonts.SFBOLD.SFBOLD.ofSize(20); }
/* 180 */     public static final class SFBOLD_22 { public static final FontRenderer SFBOLD_22 = Fonts.SFBOLD.SFBOLD.ofSize(22); }
/* 181 */     public static final class SFBOLD_26 { public static final FontRenderer SFBOLD_26 = Fonts.SFBOLD.SFBOLD.ofSize(26); }
/* 182 */     public static final class SFBOLD_28 { public static final FontRenderer SFBOLD_28 = Fonts.SFBOLD.SFBOLD.ofSize(28); }
/* 183 */     public static final class SFBOLD_35 { public static final FontRenderer SFBOLD_35 = Fonts.SFBOLD.SFBOLD.ofSize(35); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\fonts\impl\Fonts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */