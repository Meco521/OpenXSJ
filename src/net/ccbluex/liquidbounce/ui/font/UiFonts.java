/*     */ package net.ccbluex.liquidbounce.ui.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class UiFonts
/*     */   extends MinecraftInstance
/*     */ {
/*     */   @FontDetails(fontName = "Notification Icon", fontSize = 35)
/*     */   public static IFontRenderer notificationIcon70;
/*     */   @FontDetails(fontName = "NB", fontSize = 18)
/*     */   public static IFontRenderer nbicon18;
/*     */   @FontDetails(fontName = "NB", fontSize = 20)
/*     */   public static IFontRenderer nbicon20;
/*     */   @FontDetails(fontName = "NB", fontSize = 40)
/*     */   public static IFontRenderer nbicon40;
/*     */   @FontDetails(fontName = "NB", fontSize = 45)
/*     */   public static IFontRenderer nbicon45;
/*     */   @FontDetails(fontName = "Novoicon", fontSize = 180)
/*     */   public static GameFontRenderer Novoicon;
/*     */   @FontDetails(fontName = "Novoicon", fontSize = 18)
/*     */   public static IFontRenderer Novoicon_18;
/*     */   @FontDetails(fontName = "Novoicon", fontSize = 25)
/*     */   public static IFontRenderer Novoicon_25;
/*     */   @FontDetails(fontName = "Novoicon", fontSize = 23)
/*     */   public static IFontRenderer Novoicon_23;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon118;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon218;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon318;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon418;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon419;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon518;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon618;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon718;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon818;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon820;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon819;
/*     */   @FontDetails(fontName = "Newuiicon", fontSize = 18)
/*     */   public static IFontRenderer Newuiicon919;
/*     */   @FontDetails(fontName = "Newuilogo", fontSize = 20)
/*     */   public static IFontRenderer Newuilogo20;
/*     */   @FontDetails(fontName = "Novofont", fontSize = 180)
/*     */   public static GameFontRenderer Novofont;
/*     */   @FontDetails(fontName = "Notification Icon", fontSize = 40)
/*     */   public static IFontRenderer notificationIcon80;
/*     */   @FontDetails(fontName = "Neverlose900", fontSize = 18)
/*     */   public static IFontRenderer never900_35;
/*     */   @FontDetails(fontName = "Neverlose900", fontSize = 20)
/*     */   public static IFontRenderer never900_40;
/*     */   @FontDetails(fontName = "Neverlose900", fontSize = 23)
/*     */   public static IFontRenderer never900_45;
/*     */   @FontDetails(fontName = "Title", fontSize = 15)
/*     */   public static IFontRenderer title30;
/*     */   @FontDetails(fontName = "Title", fontSize = 13)
/*     */   public static IFontRenderer title25;
/*     */   @FontDetails(fontName = "Title", fontSize = 18)
/*     */   public static IFontRenderer title35;
/*     */   @FontDetails(fontName = "Title", fontSize = 20)
/*     */   public static IFontRenderer title40;
/*     */   @FontDetails(fontName = "flux", fontSize = 18)
/*     */   public static IFontRenderer flux;
/*     */   @FontDetails(fontName = "flux", fontSize = 23)
/*     */   public static IFontRenderer flux45;
/*     */   @FontDetails(fontName = "tenacity", fontSize = 23)
/*     */   public static IFontRenderer tenacity35;
/*     */   @FontDetails(fontName = "tenacity", fontSize = 23)
/*     */   public static IFontRenderer tenacity40;
/*     */   
/*     */   public static void loadFonts() {
/*  89 */     long l = System.currentTimeMillis();
/*  90 */     ClientUtils.getLogger().info("Loading Fonts.");
/*     */     
/*  92 */     tenacity35 = getFont("tenicon.ttf", 35);
/*  93 */     tenacity40 = getFont("tenicon.ttf", 40);
/*  94 */     flux = getFont("fluxicon.ttf", 18);
/*  95 */     flux45 = getFont("fluxicon.ttf", 23);
/*     */     
/*  97 */     title25 = getFont("title.ttf", 13);
/*  98 */     title30 = getFont("title.ttf", 15);
/*  99 */     title35 = getFont("title.ttf", 18);
/* 100 */     title40 = getFont("title.ttf", 20);
/*     */     
/* 102 */     never900_35 = getFont("neverlose900.ttf", 18);
/* 103 */     never900_40 = getFont("neverlose900.ttf", 20);
/* 104 */     never900_45 = getFont("neverlose900.ttf", 23);
/*     */     
/* 106 */     notificationIcon80 = getFont("novoicon2.ttf", 40);
/* 107 */     nbicon18 = getFont("newicon.ttf", 18);
/* 108 */     nbicon20 = getFont("newicon.ttf", 23);
/* 109 */     nbicon40 = getFont("newicon.ttf", 40);
/* 110 */     nbicon45 = getFont("newicon.ttf", 45);
/* 111 */     Novofont = getFont("Novofont.ttf", 80).getGameFontRenderer();
/* 112 */     notificationIcon70 = getFont("notification-icon.ttf", 35);
/* 113 */     Novoicon = getFont("Novofont.ttf", 100).getGameFontRenderer();
/* 114 */     Novoicon_18 = getFont("novosession.ttf", 13);
/* 115 */     Novoicon_25 = getFont("novosession.ttf", 25);
/* 116 */     Novoicon_23 = getFont("novosession.ttf", 18);
/*     */     
/* 118 */     Newuilogo20 = getFont("tenacitybold.ttf", 20);
/*     */     
/* 120 */     Newuiicon118 = getFont("icomoon.ttf", 18);
/*     */     
/* 122 */     Newuiicon218 = getFont("hicon.ttf", 18);
/*     */     
/* 124 */     Newuiicon318 = getFont("icon.ttf", 18);
/*     */     
/* 126 */     Newuiicon418 = getFont("fluxicon.ttf", 18);
/* 127 */     Newuiicon419 = getFont("fluxicon.ttf", 19);
/*     */     
/* 129 */     Newuiicon518 = getFont("iconnovo.ttf", 25);
/*     */     
/* 131 */     Newuiicon618 = getFont("notification-icon.ttf", 20);
/*     */     
/* 133 */     Newuiicon718 = getFont("newicon2.ttf", 26);
/*     */     
/* 135 */     Newuiicon818 = getFont("icons.ttf", 19);
/* 136 */     Newuiicon820 = getFont("icons.ttf", 20);
/* 137 */     Newuiicon819 = getFont("icons.ttf", 23);
/*     */     
/* 139 */     Newuiicon919 = getFont("logoicon.ttf", 18);
/*     */   }
/*     */   public static List<IFontRenderer> getFonts() {
/* 142 */     List<IFontRenderer> fonts = new ArrayList<>();
/*     */     
/* 144 */     for (Field fontField : Fonts.class.getDeclaredFields()) {
/*     */       try {
/* 146 */         fontField.setAccessible(true);
/*     */         
/* 148 */         Object fontObj = fontField.get(null);
/*     */         
/* 150 */         if (fontObj instanceof IFontRenderer) fonts.add((IFontRenderer)fontObj); 
/* 151 */       } catch (IllegalAccessException e) {
/* 152 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 156 */     return fonts;
/*     */   }
/*     */   private static IFontRenderer getFont(String fontName, int size) {
/*     */     Font font;
/*     */     try {
/* 161 */       InputStream inputStream = minecraft.func_110442_L().func_110536_a(new ResourceLocation("tomk/font/" + fontName)).func_110527_b();
/* 162 */       Font awtClientFont = Font.createFont(0, inputStream);
/* 163 */       awtClientFont = awtClientFont.deriveFont(0, size);
/* 164 */       inputStream.close();
/* 165 */       font = awtClientFont;
/* 166 */     } catch (Exception e) {
/* 167 */       e.printStackTrace();
/* 168 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 171 */     return classProvider.wrapFontRenderer(new GameFontRenderer(font));
/*     */   }
/*     */   
/*     */   public static class FontInfo {
/*     */     private final String name;
/*     */     private final int fontSize;
/*     */     
/*     */     public FontInfo(String name, int fontSize) {
/* 179 */       this.name = name;
/* 180 */       this.fontSize = fontSize;
/*     */     }
/*     */     
/*     */     public FontInfo(Font font) {
/* 184 */       this(font.getName(), font.getSize());
/*     */     }
/*     */     
/*     */     public String getName() {
/* 188 */       return this.name;
/*     */     }
/*     */     
/*     */     public int getFontSize() {
/* 192 */       return this.fontSize;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/* 197 */       if (this == o) return true; 
/* 198 */       if (o == null || getClass() != o.getClass()) return false;
/*     */       
/* 200 */       FontInfo fontInfo = (FontInfo)o;
/*     */       
/* 202 */       if (this.fontSize != fontInfo.fontSize) return false; 
/* 203 */       return Objects.equals(this.name, fontInfo.name);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 208 */       int result = (this.name != null) ? this.name.hashCode() : 0;
/* 209 */       result = 31 * result + this.fontSize;
/* 210 */       return result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\UiFonts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */