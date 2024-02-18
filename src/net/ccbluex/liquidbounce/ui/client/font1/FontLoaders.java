/*     */ package net.ccbluex.liquidbounce.ui.client.font1;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FontLoaders
/*     */ {
/*  16 */   public static CFontRenderer F14 = new CFontRenderer(getFont(14), true, true);
/*  17 */   public static CFontRenderer F12 = new CFontRenderer(getFont(12), true, true);
/*  18 */   public static CFontRenderer F16 = new CFontRenderer(getFont(16), true, true);
/*  19 */   public static CFontRenderer F18 = new CFontRenderer(getFont(18), true, true);
/*  20 */   public static CFontRenderer F20 = new CFontRenderer(getFont(20), true, true);
/*  21 */   public static CFontRenderer J20 = new CFontRenderer(getJello(20), true, true);
/*  22 */   public static CFontRenderer F22 = new CFontRenderer(getFont(22), true, true);
/*  23 */   public static CFontRenderer jellomedium17 = new CFontRenderer(getJelloFont2(17.0F, true), true, true);
/*  24 */   public static CFontRenderer jellomedium14 = new CFontRenderer(getJelloFont2(14.0F, true), true, true);
/*     */   
/*  26 */   public static CFontRenderer ICON18 = new CFontRenderer(getIcon2(15), true, true);
/*  27 */   public static CFontRenderer ICONS18 = new CFontRenderer(getIconS(18), true, true);
/*  28 */   public static CFontRenderer HICONS18 = new CFontRenderer(getIconh(18), true, true);
/*  29 */   public static CFontRenderer SF16 = new CFontRenderer(getSF(16), true, true);
/*  30 */   public static CFontRenderer M20 = new CFontRenderer(getMisans(20), true, true);
/*  31 */   public static CFontRenderer jelloFontMarker = new CFontRenderer(getJelloFont(19.0F, false), true, true);
/*     */   
/*  33 */   public static CFontRenderer T40 = new CFontRenderer(gettenacitybold(40), true, true);
/*  34 */   public static CFontRenderer T18 = new CFontRenderer(gettenacitybold(18), true, true);
/*  35 */   public static CFontRenderer xyz16 = new CFontRenderer(getxyz(16), true, true);
/*  36 */   public static CFontRenderer xyz18 = new CFontRenderer(getxyz(18), true, true);
/*  37 */   public static CFontRenderer xyz20 = new CFontRenderer(getxyz(20), true, true);
/*  38 */   public static CFontRenderer xyz28 = new CFontRenderer(getxyz(28), true, true);
/*  39 */   public static CFontRenderer xyz32 = new CFontRenderer(getxyz(32), true, true);
/*  40 */   public static CFontRenderer xyz100 = new CFontRenderer(getxyz(100), true, true);
/*  41 */   public static CFontRenderer xyz40 = new CFontRenderer(getxyz(40), true, true);
/*  42 */   public static CFontRenderer xyz70 = new CFontRenderer(getxyz(70), true, true);
/*  43 */   public static CFontRenderer jelloFontBig = new CFontRenderer(getJelloFont(41.0F, true), true, true);
/*  44 */   public static CFontRenderer jellolightBig = new CFontRenderer(getJelloFont(45.0F, false), true, true);
/*     */   
/*  46 */   public static CFontRenderer jelloFont30 = new CFontRenderer(getJelloFont(30.0F, true), true, true);
/*  47 */   public static CFontRenderer jellolight22 = new CFontRenderer(getJelloFont(22.0F, false), true, true);
/*  48 */   public static CFontRenderer jellolight20 = new CFontRenderer(getJelloFont(20.0F, false), true, true);
/*  49 */   public static CFontRenderer jellolight30 = new CFontRenderer(getJelloFont(30.0F, false), true, true);
/*  50 */   public static CFontRenderer jelloFontMedium20 = new CFontRenderer(getJelloFont(20.0F, true), true, true);
/*  51 */   public static CFontRenderer jellolight18 = new CFontRenderer(getJelloFont(18.0F, false), true, true);
/*  52 */   public static CFontRenderer jellomedium18 = new CFontRenderer(getJelloFont(18.0F, true), true, true);
/*  53 */   public static CFontRenderer F23 = new CFontRenderer(getFont(23), true, true);
/*  54 */   public static CFontRenderer F24 = new CFontRenderer(getFont(24), true, true);
/*  55 */   public static CFontRenderer F30 = new CFontRenderer(getFont(30), true, true);
/*  56 */   public static CFontRenderer F40 = new CFontRenderer(getFont(40), true, true);
/*  57 */   public static CFontRenderer F50 = new CFontRenderer(getFont(50), true, true);
/*  58 */   public static CFontRenderer C12 = new CFontRenderer(getComfortaa(12), true, true);
/*  59 */   public static CFontRenderer C16 = new CFontRenderer(getComfortaa(16), true, true);
/*  60 */   public static CFontRenderer C18 = new CFontRenderer(getComfortaa(18), true, true);
/*  61 */   public static CFontRenderer C20 = new CFontRenderer(getComfortaa(20), true, true);
/*  62 */   public static CFontRenderer C35 = new CFontRenderer(getComfortaa(35), true, true);
/*  63 */   public static CFontRenderer C22 = new CFontRenderer(getComfortaa(22), true, true);
/*  64 */   public static CFontRenderer Logo = new CFontRenderer(getNovo(40), true, true);
/*  65 */   public static CFontRenderer SF18 = new CFontRenderer(getSF(18), true, true);
/*  66 */   public static CFontRenderer SF22 = new CFontRenderer(getSF(22), true, true);
/*     */   
/*  68 */   public static CFontRenderer I10 = new CFontRenderer(getIcon(10), true, true);
/*  69 */   public static CFontRenderer I14 = new CFontRenderer(getIcon(14), true, true);
/*  70 */   public static CFontRenderer I15 = new CFontRenderer(getIcon(15), true, true);
/*  71 */   public static CFontRenderer I16 = new CFontRenderer(getIcon(16), true, true);
/*  72 */   public static CFontRenderer I18 = new CFontRenderer(getIcon(18), true, true);
/*  73 */   public static CFontRenderer I20 = new CFontRenderer(getIcon(20), true, true);
/*  74 */   public static CFontRenderer I25 = new CFontRenderer(getIcon(25), true, true);
/*     */   
/*  76 */   public static ArrayList<CFontRenderer> fonts = new ArrayList<>();
/*     */   
/*     */   public static CFontRenderer getFontRender(int size) {
/*  79 */     return fonts.get(size - 10);
/*     */   }
/*     */   
/*     */   public static void initFonts() {}
/*     */   
/*     */   private static Font getJelloFont(float size, boolean bold) {
/*     */     Font font;
/*     */     try {
/*  87 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(bold ? "tomk/font/jellomedium.ttf" : "onlooker/font/jellolight.ttf")).func_110527_b();
/*  88 */       font = Font.createFont(0, is);
/*  89 */       font = font.deriveFont(0, size);
/*  90 */     } catch (Exception ex) {
/*  91 */       ex.printStackTrace();
/*  92 */       System.out.println("Error loading font");
/*  93 */       font = new Font("default", 0, 10);
/*     */     } 
/*  95 */     return font;
/*     */   }
/*     */   
/*     */   private static Font getxyz(int size) {
/*     */     Font font;
/*     */     try {
/* 101 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/huahuo.ttf")).func_110527_b();
/*     */       
/* 103 */       font = Font.createFont(0, ex);
/* 104 */       font = font.deriveFont(0, size);
/* 105 */     } catch (Exception exception) {
/* 106 */       exception.printStackTrace();
/* 107 */       System.out.println("Error loading font");
/* 108 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 111 */     return font;
/*     */   }
/*     */   public static Font getIconh(int size) {
/*     */     Font font;
/*     */     try {
/* 116 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/hicon.ttf")).func_110527_b();
/* 117 */       font = Font.createFont(0, is);
/* 118 */       font = font.deriveFont(0, size);
/* 119 */     } catch (Exception ex) {
/* 120 */       ex.printStackTrace();
/* 121 */       System.out.println("Error loading font");
/* 122 */       font = new Font("default", 0, size);
/*     */     } 
/* 124 */     return font;
/*     */   }
/*     */   public static Font getComfortaa(int size) {
/*     */     Font font;
/*     */     try {
/* 129 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("misans.ttf")).func_110527_b()).deriveFont(0, size);
/* 130 */     } catch (Exception ex) {
/* 131 */       ex.printStackTrace();
/* 132 */       System.out.println("Error loading font");
/* 133 */       font = new Font("default", 0, size);
/*     */     } 
/* 135 */     return font;
/*     */   }
/*     */   public static Font getIcon2(int size) {
/*     */     Font font;
/*     */     try {
/* 140 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/logoicon.ttf")).func_110527_b();
/* 141 */       font = Font.createFont(0, is);
/* 142 */       font = font.deriveFont(0, size);
/* 143 */     } catch (Exception ex) {
/* 144 */       ex.printStackTrace();
/* 145 */       System.out.println("Error loading font");
/* 146 */       font = new Font("default", 0, size);
/*     */     } 
/* 148 */     return font;
/*     */   }
/*     */   public static Font gettenacitybold(int size) {
/*     */     Font font;
/*     */     try {
/* 153 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/tenacitybold.ttf")).func_110527_b()).deriveFont(0, size);
/* 154 */     } catch (Exception ex) {
/* 155 */       ex.printStackTrace();
/* 156 */       System.out.println("Error loading font");
/* 157 */       font = new Font("default", 0, size);
/*     */     } 
/* 159 */     return font;
/*     */   }
/*     */   
/*     */   public static Font getNico80(int size) {
/*     */     Font font;
/*     */     try {
/* 165 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/nico.ttf")).func_110527_b()).deriveFont(0, size);
/* 166 */     } catch (Exception ex) {
/* 167 */       ex.printStackTrace();
/* 168 */       System.out.println("Error loading font");
/* 169 */       font = new Font("default", 0, size);
/*     */     } 
/* 171 */     return font;
/*     */   }
/*     */   
/*     */   public static Font getIcon(int size) {
/*     */     Font font;
/*     */     try {
/* 177 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/icon.ttf")).func_110527_b();
/* 178 */       font = Font.createFont(0, is);
/* 179 */       font = font.deriveFont(0, size);
/* 180 */     } catch (Exception ex) {
/* 181 */       ex.printStackTrace();
/* 182 */       System.out.println("Error loading font");
/* 183 */       font = new Font("default", 0, size);
/*     */     } 
/* 185 */     return font;
/*     */   }
/*     */   private static Font getJelloFont2(float size, boolean bold) {
/*     */     Font font;
/*     */     try {
/* 190 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/jellomedium.ttf")).func_110527_b();
/* 191 */       font = Font.createFont(0, is);
/* 192 */       font = font.deriveFont(0, size);
/* 193 */     } catch (Exception ex) {
/* 194 */       ex.printStackTrace();
/* 195 */       System.out.println("Error loading font");
/* 196 */       font = new Font("default", 0, 10);
/*     */     } 
/* 198 */     return font;
/*     */   }
/*     */   public static Font getIconS(int size) {
/*     */     Font font;
/*     */     try {
/* 203 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/icons.ttf")).func_110527_b();
/* 204 */       font = Font.createFont(0, is);
/* 205 */       font = font.deriveFont(0, size);
/* 206 */     } catch (Exception ex) {
/* 207 */       ex.printStackTrace();
/* 208 */       System.out.println("Error loading font");
/* 209 */       font = new Font("default", 0, size);
/*     */     } 
/* 211 */     return font;
/*     */   }
/*     */   public static Font getSF(int size) {
/*     */     Font font;
/*     */     try {
/* 216 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/sfbold.ttf")).func_110527_b();
/* 217 */       font = Font.createFont(0, is);
/* 218 */       font = font.deriveFont(0, size);
/* 219 */     } catch (Exception ex) {
/* 220 */       ex.printStackTrace();
/* 221 */       System.out.println("Error loading font");
/* 222 */       font = new Font("default", 0, size);
/*     */     } 
/* 224 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Font getNovo(int size) {
/* 229 */     Font font = new Font("default", 0, size);
/* 230 */     return font;
/*     */   }
/*     */   public static Font getFont(int size) {
/*     */     Font font;
/*     */     try {
/* 235 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/sfui.ttf")).func_110527_b()).deriveFont(0, size);
/* 236 */     } catch (Exception ex) {
/* 237 */       ex.printStackTrace();
/* 238 */       System.out.println("Error loading font");
/* 239 */       font = new Font("default", 0, size);
/*     */     } 
/* 241 */     return font;
/*     */   }
/*     */   public static Font getJello(int size) {
/*     */     Font font;
/*     */     try {
/* 246 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/jellolight2.ttf")).func_110527_b()).deriveFont(0, size);
/* 247 */     } catch (Exception ex) {
/* 248 */       ex.printStackTrace();
/* 249 */       System.out.println("Error loading font");
/* 250 */       font = new Font("default", 0, size);
/*     */     } 
/* 252 */     return font;
/*     */   }
/*     */   public static Font getMisans(int size) {
/*     */     Font font;
/*     */     try {
/* 257 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/misans.ttf")).func_110527_b()).deriveFont(0, size);
/* 258 */     } catch (Exception ex) {
/* 259 */       ex.printStackTrace();
/* 260 */       System.out.println("Error loading font");
/* 261 */       font = new Font("default", 0, size);
/*     */     } 
/* 263 */     return font;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\font1\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */