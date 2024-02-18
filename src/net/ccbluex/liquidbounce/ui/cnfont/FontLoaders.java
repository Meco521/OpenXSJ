/*     */ package net.ccbluex.liquidbounce.ui.cnfont;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FontLoaders
/*     */ {
/*     */   public static FontDrawer F40;
/*     */   public static FontDrawer F18;
/*     */   public static FontDrawer xyz20;
/*     */   public static FontDrawer jelloFontMedium16;
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
/*     */   public static FontDrawer F35;
/*     */   public static FontDrawer F22;
/*     */   public static FontDrawer F10;
/*     */   public static FontDrawer F24;
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
/*     */   public static FontDrawer F16;
/*     */   public static FontDrawer j30;
/*     */   public static FontDrawer S16;
/*     */   public static FontDrawer j20;
/*     */   public static FontDrawer T24;
/*     */   public static FontDrawer T40;
/*     */   public static FontDrawer T22;
/*     */   public static FontDrawer T20;
/*     */   public static FontDrawer T16;
/*     */   public static FontDrawer T18;
/*     */   public static FontDrawer Tcheck;
/*     */   
/*     */   public static void initFonts() {
/*  62 */     F18 = getFont("misans", 18, true);
/*  63 */     F10 = getFont("misans.ttf", 10, true);
/*  64 */     F16 = getFont("misans.ttf", 16, true);
/*  65 */     F14 = getFont("misans.ttf", 14, true);
/*  66 */     F35 = getFont("misans.ttf", 35, true);
/*  67 */     F40 = getFont("misans.ttf", 40, true);
/*  68 */     F22 = getFont("misans.ttf", 22, true);
/*  69 */     F24 = getFont("misans.ttf", 24, true);
/*  70 */     SB20 = getFont("sfbold.ttf", 20, true);
/*  71 */     SB30 = getFont("sfbold.ttf", 30, true);
/*  72 */     SB35 = getFont("sfbold.ttf", 35, true);
/*     */     
/*  74 */     SB15 = getFont("sfbold.ttf", 15, true);
/*  75 */     SB18 = getFont("sfbold.ttf", 18, true);
/*  76 */     jellor16 = getFont("jelloregular.ttf", 16, true);
/*  77 */     jellor18 = getFont("jelloregular.ttf", 18, true);
/*  78 */     jellom18 = getFont("jellomedium.ttf", 18, true);
/*  79 */     jellolight18 = getFont("jellolight.ttf", 18, true);
/*  80 */     jellolightBig = getFont("jellomedium.ttf", 45, true);
/*     */     
/*  82 */     S16 = getFont("sfui.ttf", 16, true);
/*  83 */     S22 = getFont("sfui.ttf", 22, true);
/*  84 */     JB = getFont("misans.ttf", 45, true);
/*  85 */     R20 = getFont("regular.ttf", 20, true);
/*  86 */     R22 = getFont("regular.ttf", 22, true);
/*  87 */     F26 = getFont("misans.ttf", 22, true);
/*  88 */     F28 = getFont("misans.ttf", 20, true);
/*  89 */     j30 = getFont("jellolight.ttf", 30, true);
/*  90 */     j20 = getFont("jellolight.ttf", 20, true);
/*  91 */     T24 = getFont("bold.ttf", 24, true);
/*  92 */     T20 = getFont("bold.ttf", 20, true);
/*  93 */     T16 = getFont("bold.ttf", 16, true);
/*  94 */     T18 = getFont("bold.ttf", 18, true);
/*  95 */     T22 = getFont("bold.ttf", 22, true);
/*  96 */     T40 = getFont("bold.ttf", 40, true);
/*  97 */     Tcheck = getFont("check.ttf", 36, true);
/*     */     
/*  99 */     N2Icon24 = getFont("icon2.ttf", 24, true);
/* 100 */     NL14 = getFont("sfui.ttf", 14, true);
/* 101 */     NL18 = getFont("sfui.ttf", 18, true);
/* 102 */     NL16 = getFont("sfui.ttf", 16, true);
/* 103 */     NL20 = getFont("sfui.ttf", 20, true);
/* 104 */     NL24 = getFont("sfui.ttf", 24, true);
/* 105 */     NL35 = getFont("sfui.ttf", 35, true);
/* 106 */     NIcon24 = getFont("icon.ttf", 24, true);
/* 107 */     Check24 = getFont("check.ttf", 24, true);
/* 108 */     xyz18 = getFont("misans.ttf", 18, true);
/* 109 */     xyz20 = getFont("misans.ttf", 20, true);
/* 110 */     jelloFontMedium16 = getFont("jellomedium.ttf", 16, true);
/* 111 */     jellolightBig2 = getFont("jellolight.ttf", 45, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FontDrawer getFont(String name, int size, boolean antiAliasing) {
/*     */     Font font;
/*     */     try {
/* 118 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("pride/font/" + name)).func_110527_b()).deriveFont(0, size);
/* 119 */     } catch (Exception ex) {
/* 120 */       ex.printStackTrace();
/* 121 */       System.out.println("Error loading font");
/* 122 */       font = new Font("default", 0, size);
/*     */     } 
/* 124 */     return new FontDrawer(font, antiAliasing);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\cnfont\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */