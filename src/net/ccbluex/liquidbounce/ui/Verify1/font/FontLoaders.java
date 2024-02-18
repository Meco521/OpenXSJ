/*     */ package net.ccbluex.liquidbounce.ui.Verify1.font;
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
/*     */ public abstract class FontLoaders
/*     */ {
/*  15 */   public static CFontRenderer F14 = new CFontRenderer(getFont(14), true, true);
/*  16 */   public static CFontRenderer F16 = new CFontRenderer(getFont(16), true, true);
/*  17 */   public static CFontRenderer F18 = new CFontRenderer(getFont(18), true, true);
/*  18 */   public static CFontRenderer F20 = new CFontRenderer(getFont(20), true, true);
/*  19 */   public static CFontRenderer F22 = new CFontRenderer(getFont(22), true, true);
/*  20 */   public static CFontRenderer F23 = new CFontRenderer(getFont(23), true, true);
/*  21 */   public static CFontRenderer F24 = new CFontRenderer(getFont(24), true, true);
/*  22 */   public static CFontRenderer F30 = new CFontRenderer(getFont(30), true, true);
/*  23 */   public static CFontRenderer F40 = new CFontRenderer(getFont(40), true, true);
/*  24 */   public static CFontRenderer F90 = new CFontRenderer(getFont(90), true, true);
/*  25 */   public static CFontRenderer xyz16 = new CFontRenderer(getxyz(16), true, true);
/*  26 */   public static CFontRenderer xyz18 = new CFontRenderer(getxyz(18), true, true);
/*  27 */   public static CFontRenderer xyz20 = new CFontRenderer(getxyz(20), true, true);
/*  28 */   public static CFontRenderer xyz28 = new CFontRenderer(getxyz(28), true, true);
/*  29 */   public static CFontRenderer xyz32 = new CFontRenderer(getxyz(32), true, true);
/*  30 */   public static CFontRenderer xyz26 = new CFontRenderer(getxyz(26), true, true);
/*  31 */   public static CFontRenderer xyz70 = new CFontRenderer(getxyz(70), true, true);
/*  32 */   public static CFontRenderer C16 = new CFontRenderer(getComfortaa(16), true, true);
/*  33 */   public static CFontRenderer C18 = new CFontRenderer(getComfortaa(18), true, true);
/*  34 */   public static CFontRenderer C20 = new CFontRenderer(getComfortaa(20), true, true);
/*  35 */   public static CFontRenderer C22 = new CFontRenderer(getComfortaa(22), true, true);
/*  36 */   public static CFontRenderer C30 = new CFontRenderer(getComfortaa(30), true, true);
/*  37 */   public static CFontRenderer C50 = new CFontRenderer(getComfortaa(50), true, true);
/*  38 */   public static CFontRenderer C12 = new CFontRenderer(getComfortaa(12), true, true);
/*  39 */   public static CFontRenderer C14 = new CFontRenderer(getComfortaa(14), true, true);
/*  40 */   public static CFontRenderer C55 = new CFontRenderer(getComfortaa(55), true, true);
/*     */   
/*  42 */   public static CFontRenderer Logo = new CFontRenderer(getNovo(40), true, true);
/*     */   
/*  44 */   public static ArrayList<CFontRenderer> fonts = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public static CFontRenderer getFontRender(int size) {
/*  48 */     return fonts.get(size - 10);
/*     */   }
/*     */   
/*     */   private static Font getxyz(int size) {
/*     */     Font font;
/*     */     try {
/*  54 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("pride/font/huahuo.ttf")).func_110527_b();
/*     */       
/*  56 */       font = Font.createFont(0, ex);
/*  57 */       font = font.deriveFont(0, size);
/*  58 */     } catch (Exception exception) {
/*  59 */       exception.printStackTrace();
/*  60 */       System.out.println("Error loading font");
/*  61 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/*  64 */     return font;
/*     */   }
/*     */   public static Font getFont(int size) {
/*     */     Font font;
/*     */     try {
/*  69 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("pride/font/huahuo.ttf")).func_110527_b();
/*  70 */       font = Font.createFont(0, is);
/*  71 */       font = font.deriveFont(0, size);
/*  72 */     } catch (Exception ex) {
/*  73 */       ex.printStackTrace();
/*  74 */       System.out.println("Error loading font");
/*  75 */       font = new Font("default", 0, size);
/*     */     } 
/*  77 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Font getComfortaa(int size) {
/*     */     Font font;
/*     */     try {
/*  84 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("pride/font/huahuo.ttf")).func_110527_b();
/*  85 */       font = Font.createFont(0, is);
/*  86 */       font = font.deriveFont(0, size);
/*  87 */     } catch (Exception ex) {
/*  88 */       ex.printStackTrace();
/*  89 */       System.out.println("Error loading font");
/*  90 */       font = new Font("default", 0, size);
/*     */     } 
/*  92 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Font getNovo(int size) {
/*     */     Font font;
/*     */     try {
/*  99 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("pride/font/huahuo.ttf")).func_110527_b();
/* 100 */       font = Font.createFont(0, is);
/* 101 */       font = font.deriveFont(0, size);
/* 102 */     } catch (Exception ex) {
/* 103 */       ex.printStackTrace();
/* 104 */       System.out.println("Error loading font");
/* 105 */       font = new Font("default", 0, size);
/*     */     } 
/* 107 */     return font;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify1\font\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */