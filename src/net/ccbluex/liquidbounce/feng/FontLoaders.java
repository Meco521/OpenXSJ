/*    */ package net.ccbluex.liquidbounce.feng;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FontLoaders
/*    */ {
/*    */   public static FontDrawer C12;
/*    */   public static FontDrawer C14;
/*    */   public static FontDrawer C16;
/*    */   public static FontDrawer C18;
/*    */   public static FontDrawer C20;
/*    */   public static FontDrawer C22;
/*    */   public static FontDrawer C24;
/*    */   public static FontDrawer F18;
/*    */   public static FontDrawer msFont13;
/*    */   public static FontDrawer msFont16;
/*    */   public static FontDrawer Check;
/*    */   public static List<FontDrawer> fonts;
/*    */   
/*    */   public static FontDrawer getFontRender(int size) {
/* 27 */     return fonts.get(size - 10);
/*    */   }
/*    */   
/*    */   public static void initFonts() {
/* 31 */     Check = new FontDrawer(getCheck(35), true);
/* 32 */     F18 = new FontDrawer(getComfortaa(18), true);
/* 33 */     C22 = new FontDrawer(getComfortaa(22), true);
/* 34 */     C24 = new FontDrawer(getComfortaa(24), true);
/* 35 */     C20 = new FontDrawer(getComfortaa(20), true);
/* 36 */     C18 = new FontDrawer(getComfortaa(18), true);
/* 37 */     C16 = new FontDrawer(getComfortaa(16), true);
/* 38 */     C14 = new FontDrawer(getComfortaa(14), true);
/* 39 */     C12 = new FontDrawer(getComfortaa(12), true);
/* 40 */     msFont16 = new FontDrawer(getHarmonyOS_Sans_SC_Regular(16), true);
/* 41 */     msFont13 = new FontDrawer(getHarmonyOS_Sans_SC_Regular(13), true);
/* 42 */     fonts = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public static Font getFont(int size) {
/*    */     Font font;
/*    */     try {
/* 48 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/misans.ttf")).func_110527_b()).deriveFont(0, size);
/* 49 */     } catch (Exception ex) {
/* 50 */       ex.printStackTrace();
/* 51 */       System.out.println("Error loading font");
/* 52 */       font = new Font("default", 0, size);
/*    */     } 
/* 54 */     return font;
/*    */   }
/*    */   public static Font getHarmonyOS_Sans_SC_Regular(int size) {
/*    */     Font font;
/*    */     try {
/* 59 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/HarmonyOS_Sans_SC_Regular.ttf")).func_110527_b()).deriveFont(0, size);
/* 60 */     } catch (Exception ex) {
/* 61 */       ex.printStackTrace();
/* 62 */       System.out.println("Error loading font");
/* 63 */       font = new Font("default", 0, size);
/*    */     } 
/* 65 */     return font;
/*    */   }
/*    */   public static Font getComfortaa(int size) {
/*    */     Font font;
/*    */     try {
/* 70 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/misans.ttf")).func_110527_b()).deriveFont(0, size);
/* 71 */     } catch (Exception ex) {
/* 72 */       ex.printStackTrace();
/* 73 */       System.out.println("Error loading font");
/* 74 */       font = new Font("default", 0, size);
/*    */     } 
/* 76 */     return font;
/*    */   }
/*    */   public static Font getCheck(int size) {
/*    */     Font font;
/*    */     try {
/* 81 */       font = Font.createFont(0, Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/check.ttf")).func_110527_b()).deriveFont(0, size);
/* 82 */     } catch (Exception ex) {
/* 83 */       ex.printStackTrace();
/* 84 */       System.out.println("Error loading font");
/* 85 */       font = new Font("default", 0, size);
/*    */     } 
/* 87 */     return font;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\feng\FontLoaders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */