/*     */ package net.ccbluex.liquidbounce.ui.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.InputStream;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FontLoaders
/*     */ {
/*     */   public static FontDrawer F18;
/*     */   public static FontDrawer F15;
/*     */   public static FontDrawer F16;
/*     */   public static FontDrawer SF18;
/*     */   public static FontDrawer C22;
/*     */   public static FontDrawer C24;
/*     */   public static FontDrawer C16;
/*     */   public static FontDrawer C18;
/*     */   public static FontDrawer S18;
/*     */   public static FontDrawer S20;
/*     */   public static FontDrawer pop18;
/*     */   public static FontDrawer C12;
/*     */   public static FontDrawer tenacity22;
/*     */   public static FontDrawer tenacitybold20;
/*     */   public static FontDrawer tenacitybold17;
/*     */   public static FontDrawer tenacitybold18;
/*     */   public static FontDrawer foricotwo24;
/*     */   public static FontDrawer for18;
/*     */   public static FontDrawer xyz20;
/*     */   public static FontDrawer novologo245;
/*     */   public static FontDrawer jelloFontMedium16;
/*     */   public static FontDrawer jellolight16;
/*     */   public static FontDrawer jellolightBig2;
/*     */   public static FontDrawer xyz18;
/*     */   public static FontDrawer Check24;
/*     */   public static FontDrawer NL16;
/*     */   public static FontDrawer NL35;
/*     */   public static FontDrawer NL20;
/*     */   public static FontDrawer NL18;
/*     */   public static FontDrawer NL24;
/*     */   public static FontDrawer NIcon24;
/*     */   public static FontDrawer NL14;
/*     */   public static FontDrawer N2Icon24;
/*     */   public static FontDrawer F14;
/*     */   public static FontDrawer F20;
/*     */   public static FontDrawer F22;
/*     */   public static FontDrawer F24;
/*     */   public static FontDrawer F30;
/*     */   public static FontDrawer S22;
/*     */   public static FontDrawer JB;
/*     */   public static FontDrawer SB30;
/*     */   public static FontDrawer SB20;
/*     */   public static FontDrawer SB15;
/*     */   public static FontDrawer SB35;
/*     */   public static FontDrawer SB18;
/*     */   public static FontDrawer F26;
/*     */   public static FontDrawer jellolightBig;
/*     */   public static FontDrawer jellolight18;
/*     */   public static FontDrawer jellom18;
/*     */   public static FontDrawer jellor16;
/*     */   public static FontDrawer jellor18;
/*     */   public static FontDrawer R20;
/*     */   public static FontDrawer R22;
/*     */   public static FontDrawer F28;
/*     */   public static FontDrawer j30;
/*     */   public static FontDrawer S16;
/*     */   public static FontDrawer j20;
/*     */   public static FontDrawer T24;
/*     */   public static FontDrawer T40;
/*     */   public static FontDrawer nt18;
/*     */   public static FontDrawer rb18;
/*     */   public static FontDrawer T22;
/*     */   public static FontDrawer SF20;
/*     */   public static FontDrawer Retreat;
/*     */   public static FontDrawer T20;
/*     */   public static FontDrawer T16;
/*     */   public static FontDrawer T18;
/*     */   public static FontDrawer Tcheck;
/*     */   
/*     */   public static void initFonts() {
/*  91 */     F14 = getFont("misans.ttf", 14, true);
/*  92 */     F30 = getFont("misans.ttf", 30, true);
/*  93 */     F22 = getFont("misans.ttf", 22, true);
/*  94 */     F24 = getFont("misans.ttf", 24, true);
/*  95 */     SB20 = getFont("sfbold.ttf", 20, true);
/*  96 */     SB30 = getFont("sfbold.ttf", 30, true);
/*  97 */     SB35 = getFont("sfbold.ttf", 35, true);
/*     */     
/*  99 */     SB15 = getFont("sfbold.ttf", 15, true);
/* 100 */     SB18 = getFont("sfbold.ttf", 18, true);
/* 101 */     jellor16 = getFont("jelloregular.ttf", 16, true);
/* 102 */     jellolight16 = getFont("jellolight.ttf", 16, true);
/* 103 */     jellor18 = getFont("jelloregular.ttf", 18, true);
/* 104 */     jellom18 = getFont("jellomedium.ttf", 18, true);
/* 105 */     jellolight18 = getFont("jellolight.ttf", 18, true);
/* 106 */     jellolightBig = getFont("jellomedium.ttf", 45, true);
/* 107 */     pop18 = getFont("pop.ttf", 18, true);
/* 108 */     S16 = getFont("sfui.ttf", 16, true);
/* 109 */     S22 = getFont("sfui.ttf", 22, true);
/* 110 */     JB = getFont("misans.ttf", 45, true);
/* 111 */     F20 = getFont("misans.ttf", 20, true);
/* 112 */     R20 = getFont("regular.ttf", 20, true);
/* 113 */     R22 = getFont("regular.ttf", 22, true);
/* 114 */     F26 = getFont("misans.ttf", 22, true);
/* 115 */     F28 = getFont("misans.ttf", 20, true);
/* 116 */     j30 = getFont("jello.ttf", 30, true);
/* 117 */     j20 = getFont("jello.ttf", 20, true);
/* 118 */     T24 = getFont("bold.ttf", 24, true);
/* 119 */     T20 = getFont("bold.ttf", 20, true);
/* 120 */     T16 = getFont("bold.ttf", 16, true);
/* 121 */     T18 = getFont("bold.ttf", 18, true);
/* 122 */     T22 = getFont("bold.ttf", 22, true);
/* 123 */     T40 = getFont("bold.ttf", 40, true);
/* 124 */     nt18 = getFont("gcf.ttf", 18, true);
/* 125 */     rb18 = getFont("rubik.ttf", 18, true);
/* 126 */     Tcheck = getFont("check.ttf", 36, true);
/*     */     
/* 128 */     N2Icon24 = getFont("icon2.ttf", 24, true);
/* 129 */     NL14 = getFont("sfui.ttf", 14, true);
/* 130 */     NL18 = getFont("sfui.ttf", 18, true);
/* 131 */     NL16 = getFont("sfui.ttf", 16, true);
/* 132 */     NL20 = getFont("sfui.ttf", 20, true);
/* 133 */     NL24 = getFont("sfui.ttf", 24, true);
/* 134 */     NL35 = getFont("sfui.ttf", 35, true);
/* 135 */     NIcon24 = getFont("icon.ttf", 24, true);
/* 136 */     Check24 = getFont("check.ttf", 24, true);
/* 137 */     xyz18 = getFont("misans.ttf", 18, true);
/* 138 */     xyz20 = getFont("misans.ttf", 20, true);
/* 139 */     jelloFontMedium16 = getFont("jellomedium.ttf", 16, true);
/* 140 */     jellolightBig2 = getFont("jellolight2.ttf", 45, true);
/* 141 */     tenacitybold17 = getFont("tenacitybold", 17, true);
/* 142 */     novologo245 = getFont("iconnovo.ttf", 45, true);
/* 143 */     F15 = getFont("misans", 15, true);
/* 144 */     F16 = getFont("misans", 16, true);
/* 145 */     F18 = getFont("misans", 18, true);
/* 146 */     Retreat = new FontDrawer(getRetreat(40), true);
/* 147 */     C16 = new FontDrawer(getComfortaa(16), true);
/* 148 */     S18 = new FontDrawer(getSourceHanSans(18), true);
/* 149 */     S20 = new FontDrawer(getSourceHanSans(20), true);
/* 150 */     C22 = new FontDrawer(getComfortaa(22), true);
/* 151 */     C24 = new FontDrawer(getComfortaa(24), true);
/* 152 */     C18 = new FontDrawer(getComfortaa(18), true);
/* 153 */     SF18 = new FontDrawer(getSourceHanicon(18), true);
/* 154 */     SF20 = new FontDrawer(getSourceHanicon(20), true);
/* 155 */     C12 = new FontDrawer(getComfortaa(12), true);
/* 156 */     for18 = new FontDrawer(getNovo(18), true);
/* 157 */     foricotwo24 = new FontDrawer(forico2(24), true);
/* 158 */     tenacitybold20 = getFont("tenacitybold", 20, true);
/* 159 */     tenacitybold18 = getFont("tenacitybold", 18, true);
/* 160 */     tenacity22 = getFont("tenacity", 22, true);
/* 161 */     for18 = getFont("for", 18, true);
/* 162 */     foricotwo24 = getFont("forico2", 24, true);
/*     */   }
/*     */   
/*     */   public static Font getSourceHanicon(int size) {
/*     */     Font font;
/*     */     try {
/* 168 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("courage/font/sf.ttf")).func_110527_b()).deriveFont(0, size);
/* 169 */     } catch (Exception ex) {
/* 170 */       ex.printStackTrace();
/* 171 */       System.out.println("Error loading font");
/* 172 */       font = new Font("default", 0, size);
/*     */     } 
/* 174 */     return font;
/*     */   }
/*     */   public static Font getSourceHanSans(int size) {
/*     */     Font font;
/*     */     try {
/* 179 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("courage/font/sourcehansans.ttf")).func_110527_b()).deriveFont(0, size);
/* 180 */     } catch (Exception ex) {
/* 181 */       ex.printStackTrace();
/* 182 */       System.out.println("Error loading font");
/* 183 */       font = new Font("default", 0, size);
/*     */     } 
/* 185 */     return font;
/*     */   }
/*     */   
/*     */   public static FontDrawer getFont(String name, int size, boolean antiAliasing) {
/*     */     Font font;
/*     */     try {
/* 191 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/" + name + ".ttf")).func_110527_b()).deriveFont(0, size);
/* 192 */     } catch (Exception ex) {
/* 193 */       ex.printStackTrace();
/* 194 */       System.out.println("Error loading font");
/* 195 */       font = new Font("default", 0, size);
/*     */     } 
/* 197 */     return new FontDrawer(font, antiAliasing);
/*     */   }
/*     */   public static Font getRetreat(int size) {
/*     */     Font font;
/*     */     try {
/* 202 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/nico.ttf")).func_110527_b();
/* 203 */       font = Font.createFont(0, is);
/* 204 */       font = font.deriveFont(0, size);
/* 205 */     } catch (Exception ex) {
/* 206 */       ex.printStackTrace();
/* 207 */       System.out.println("Error loading font");
/* 208 */       font = new Font("default", 0, size);
/*     */     } 
/* 210 */     return font;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Font forico2(int size) {
/*     */     Font font;
/*     */     try {
/* 218 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/forico2.ttf")).func_110527_b();
/*     */       
/* 220 */       font = Font.createFont(0, ex);
/* 221 */       font = font.deriveFont(0, size);
/* 222 */     } catch (Exception exception) {
/* 223 */       exception.printStackTrace();
/* 224 */       System.out.println("Error loading font");
/* 225 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 228 */     return font;
/*     */   }
/*     */   
/*     */   public static Font getNovo(int size) {
/*     */     Font font;
/*     */     try {
/* 234 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/Novofont.ttf")).func_110527_b();
/* 235 */       font = Font.createFont(0, is);
/* 236 */       font = font.deriveFont(0, size);
/* 237 */     } catch (Exception ex) {
/* 238 */       ex.printStackTrace();
/* 239 */       System.out.println("Error loading font");
/* 240 */       font = new Font("default", 0, size);
/*     */     } 
/* 242 */     return font;
/*     */   }
/*     */   
/*     */   public static Font getComfortaa(int size) {
/*     */     Font font;
/*     */     try {
/* 248 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("misans.ttf")).func_110527_b()).deriveFont(0, size);
/* 249 */     } catch (Exception ex) {
/* 250 */       ex.printStackTrace();
/* 251 */       System.out.println("Error loading font");
/* 252 */       font = new Font("default", 0, size);
/*     */     } 
/* 254 */     return font;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */