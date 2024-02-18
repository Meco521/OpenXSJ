/*     */ package net.ccbluex.liquidbounce.feng;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class GLUtils {
/*     */   public static int getScreenWidth() {
/*  11 */     return (Minecraft.func_71410_x()).field_71443_c / getScaleFactor();
/*     */   }
/*     */   
/*     */   public static int getScaleFactor() {
/*  15 */     int scaleFactor = 1;
/*  16 */     boolean isUnicode = Minecraft.func_71410_x().func_152349_b();
/*  17 */     int guiScale = (Minecraft.func_71410_x()).field_71474_y.field_74335_Z;
/*  18 */     if (guiScale == 0) {
/*  19 */       guiScale = 1000;
/*     */     }
/*  21 */     while (scaleFactor < guiScale && (Minecraft.func_71410_x()).field_71443_c / (scaleFactor + 1) >= 320 && (Minecraft.func_71410_x()).field_71440_d / (scaleFactor + 1) >= 240) {
/*  22 */       scaleFactor++;
/*     */     }
/*  24 */     if (isUnicode && scaleFactor % 2 != 0 && scaleFactor != 1) {
/*  25 */       scaleFactor--;
/*     */     }
/*  27 */     return scaleFactor;
/*     */   }
/*     */   public static int getScreenHeight() {
/*  30 */     return (Minecraft.func_71410_x()).field_71440_d / getScaleFactor();
/*     */   }
/*     */   
/*     */   public static int getMouseX() {
/*  34 */     return Mouse.getX() * getScreenWidth() / (Minecraft.func_71410_x()).field_71443_c;
/*     */   }
/*     */   
/*     */   public static int getMouseY() {
/*  38 */     return getScreenHeight() - Mouse.getY() * getScreenHeight() / (Minecraft.func_71410_x()).field_71443_c - 1;
/*     */   }
/*     */   public static void startScissor(int x, int y, int width, int height) {
/*  41 */     int scaleFactor = (new ScaledResolution(Minecraft.func_71410_x())).func_78325_e();
/*  42 */     GL11.glPushMatrix();
/*  43 */     GL11.glEnable(3089);
/*  44 */     GL11.glScissor(x * scaleFactor, (Minecraft.func_71410_x()).field_71440_d - (y + height) * scaleFactor, width * scaleFactor, height * scaleFactor);
/*     */   }
/*     */   
/*     */   public static void stopScissor() {
/*  48 */     GL11.glDisable(3089);
/*  49 */     GL11.glPopMatrix();
/*     */   }
/*     */   public static void startSmooth() {
/*  52 */     GL11.glEnable(2848);
/*  53 */     GL11.glEnable(2881);
/*  54 */     GL11.glEnable(2832);
/*  55 */     GL11.glEnable(3042);
/*  56 */     GL11.glBlendFunc(770, 771);
/*  57 */     GL11.glHint(3154, 4354);
/*  58 */     GL11.glHint(3155, 4354);
/*  59 */     GL11.glHint(3153, 4354);
/*     */   }
/*     */   public static void endSmooth() {
/*  62 */     GL11.glDisable(2848);
/*  63 */     GL11.glDisable(2881);
/*  64 */     GL11.glEnable(2832);
/*     */   }
/*     */   public static void pushMatrix() {
/*  67 */     GL11.glPushMatrix();
/*     */   }
/*     */   
/*     */   public static void popMatrix() {
/*  71 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public static void enable(int cap) {
/*  75 */     GL11.glEnable(cap);
/*     */   }
/*     */   
/*     */   public static void disable(int cap) {
/*  79 */     GL11.glDisable(cap);
/*     */   }
/*     */   
/*     */   public static void blendFunc(int sFactor, int dFactor) {
/*  83 */     GL11.glBlendFunc(sFactor, dFactor);
/*     */   }
/*     */   
/*     */   public static void translated(double x, double y, double z) {
/*  87 */     GL11.glTranslated(x, y, z);
/*     */   }
/*     */   
/*     */   public static void rotated(double angle, double x, double y, double z) {
/*  91 */     GL11.glRotated(angle, x, y, z);
/*     */   }
/*     */   
/*     */   public static void depthMask(boolean flag) {
/*  95 */     GL11.glDepthMask(flag);
/*     */   }
/*     */   
/*     */   public static void color(int r, int g, int b) {
/*  99 */     color(r, g, b, 255);
/*     */   }
/*     */   
/*     */   public static void color(int r, int g, int b, int a) {
/* 103 */     GlStateManager.func_179131_c(r / 255.0F, g / 255.0F, b / 255.0F, a / 255.0F);
/*     */   }
/*     */   
/*     */   public static void color(int hex) {
/* 107 */     GlStateManager.func_179131_c((hex >> 16 & 0xFF) / 255.0F, (hex >> 8 & 0xFF) / 255.0F, (hex & 0xFF) / 255.0F, (hex >> 24 & 0xFF) / 255.0F);
/*     */   }
/*     */   
/*     */   public static void resetColor() {
/* 111 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\feng\GLUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */