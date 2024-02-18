/*     */ package net.ccbluex.liquidbounce.font;
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
/*     */ public abstract class FontLoaders
/*     */ {
/*  14 */   public static CFontRenderer F14 = new CFontRenderer(getFont(14), true, true);
/*  15 */   public static CFontRenderer F16 = new CFontRenderer(getFont(16), true, true);
/*  16 */   public static CFontRenderer F18 = new CFontRenderer(getFont(18), true, true);
/*  17 */   public static CFontRenderer F20 = new CFontRenderer(getFont(20), true, true);
/*  18 */   public static CFontRenderer F22 = new CFontRenderer(getFont(22), true, true);
/*  19 */   public static CFontRenderer F23 = new CFontRenderer(getFont(23), true, true);
/*  20 */   public static CFontRenderer F24 = new CFontRenderer(getFont(24), true, true);
/*  21 */   public static CFontRenderer F30 = new CFontRenderer(getFont(30), true, true);
/*  22 */   public static CFontRenderer F40 = new CFontRenderer(getFont(40), true, true);
/*  23 */   public static CFontRenderer F50 = new CFontRenderer(getFont(50), true, true);
/*  24 */   public static CFontRenderer CN18 = new CFontRenderer(getcn(18), true, true);
/*  25 */   public static CFontRenderer Cn18 = new CFontRenderer(getcn(18), true, true);
/*  26 */   public static CFontRenderer xyz16 = new CFontRenderer(getxyz(16), true, true);
/*  27 */   public static CFontRenderer xyz18 = new CFontRenderer(getxyz(18), true, true);
/*  28 */   public static CFontRenderer xyz20 = new CFontRenderer(getxyz(20), true, true);
/*  29 */   public static CFontRenderer xyz28 = new CFontRenderer(getxyz(28), true, true);
/*  30 */   public static CFontRenderer xyz32 = new CFontRenderer(getxyz(32), true, true);
/*  31 */   public static CFontRenderer xyz26 = new CFontRenderer(getxyz(26), true, true);
/*     */ 
/*     */   
/*  34 */   public static CFontRenderer C12 = new CFontRenderer(getComfortaa(12), true, true);
/*  35 */   public static CFontRenderer C14 = new CFontRenderer(getComfortaa(14), true, true);
/*  36 */   public static CFontRenderer C16 = new CFontRenderer(getComfortaa(16), true, true);
/*  37 */   public static CFontRenderer C18 = new CFontRenderer(getComfortaa(18), true, true);
/*  38 */   public static CFontRenderer C20 = new CFontRenderer(getComfortaa(20), true, true);
/*  39 */   public static CFontRenderer C35 = new CFontRenderer(getComfortaa(35), true, true);
/*  40 */   public static CFontRenderer C22 = new CFontRenderer(getComfortaa(22), true, true);
/*  41 */   public static CFontRenderer Logo = new CFontRenderer(getNovo(40), true, true);
/*     */   
/*  43 */   public static CFontRenderer I10 = new CFontRenderer(getIcon(10), true, true);
/*  44 */   public static CFontRenderer I14 = new CFontRenderer(getIcon(14), true, true);
/*  45 */   public static CFontRenderer I15 = new CFontRenderer(getIcon(15), true, true);
/*  46 */   public static CFontRenderer I16 = new CFontRenderer(getIcon(16), true, true);
/*  47 */   public static CFontRenderer I18 = new CFontRenderer(getIcon(18), true, true);
/*  48 */   public static CFontRenderer I20 = new CFontRenderer(getIcon(20), true, true);
/*  49 */   public static CFontRenderer I25 = new CFontRenderer(getIcon(25), true, true);
/*  50 */   public static ArrayList<CFontRenderer> fonts = new ArrayList<>();
/*     */   
/*     */   public static CFontRenderer getFontRender(int size) {
/*  53 */     return fonts.get(size - 10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initFonts() {}
/*     */ 
/*     */   
/*     */   public static Font getFont(int size) {
/*  62 */     Font font = new Font("default", 0, size);
/*  63 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Font getComfortaa(int size) {
/*  68 */     Font font = new Font("default", 0, size);
/*  69 */     return font;
/*     */   }
/*     */   
/*     */   public static Font getIcon(int size) {
/*     */     Font font;
/*     */     try {
/*  75 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("icon.ttf")).func_110527_b();
/*  76 */       font = Font.createFont(0, is);
/*  77 */       font = font.deriveFont(0, size);
/*  78 */     } catch (Exception ex) {
/*  79 */       ex.printStackTrace();
/*  80 */       System.out.println("Error loading font");
/*  81 */       font = new Font("default", 0, size);
/*     */     } 
/*  83 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Font getxyz(int size) {
/*     */     Font font;
/*     */     try {
/*  90 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/huahuo.ttf")).func_110527_b();
/*     */       
/*  92 */       font = Font.createFont(0, ex);
/*  93 */       font = font.deriveFont(0, size);
/*  94 */     } catch (Exception exception) {
/*  95 */       exception.printStackTrace();
/*  96 */       System.out.println("Error loading font");
/*  97 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 100 */     return font;
/*     */   }
/*     */   
/*     */   private static Font getcn(int size) {
/*     */     Font font;
/*     */     try {
/* 106 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/chinese.ttf")).func_110527_b();
/*     */       
/* 108 */       font = Font.createFont(0, ex);
/* 109 */       font = font.deriveFont(0, size);
/* 110 */     } catch (Exception exception) {
/* 111 */       exception.printStackTrace();
/* 112 */       System.out.println("Error loading font");
/* 113 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 116 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Font getNovo(int size) {
/* 121 */     Font font = new Font("default", 0, size);
/* 122 */     return font;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\font\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */