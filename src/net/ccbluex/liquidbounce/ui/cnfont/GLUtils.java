/*    */ package net.ccbluex.liquidbounce.ui.cnfont;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class GLUtils {
/*    */   public static void startScissor(int x, int y, int width, int height) {
/* 10 */     int scaleFactor = (new ScaledResolution(Minecraft.func_71410_x())).func_78325_e();
/* 11 */     GL11.glPushMatrix();
/* 12 */     GL11.glEnable(3089);
/* 13 */     GL11.glScissor(x * scaleFactor, (Minecraft.func_71410_x()).field_71440_d - (y + height) * scaleFactor, width * scaleFactor, height * scaleFactor);
/*    */   }
/*    */   
/*    */   public static void stopScissor() {
/* 17 */     GL11.glDisable(3089);
/* 18 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public static void pushMatrix() {
/* 22 */     GL11.glPushMatrix();
/*    */   }
/*    */   
/*    */   public static void popMatrix() {
/* 26 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public static void enable(int cap) {
/* 30 */     GL11.glEnable(cap);
/*    */   }
/*    */   
/*    */   public static void disable(int cap) {
/* 34 */     GL11.glDisable(cap);
/*    */   }
/*    */   
/*    */   public static void blendFunc(int sFactor, int dFactor) {
/* 38 */     GL11.glBlendFunc(sFactor, dFactor);
/*    */   }
/*    */   
/*    */   public static void translated(double x, double y, double z) {
/* 42 */     GL11.glTranslated(x, y, z);
/*    */   }
/*    */   
/*    */   public static void rotated(double angle, double x, double y, double z) {
/* 46 */     GL11.glRotated(angle, x, y, z);
/*    */   }
/*    */   
/*    */   public static void depthMask(boolean flag) {
/* 50 */     GL11.glDepthMask(flag);
/*    */   }
/*    */   
/*    */   public static void color(int r, int g, int b) {
/* 54 */     color(r, g, b, 255);
/*    */   }
/*    */   
/*    */   public static void color(int r, int g, int b, int a) {
/* 58 */     GlStateManager.func_179131_c(r / 255.0F, g / 255.0F, b / 255.0F, a / 255.0F);
/*    */   }
/*    */   
/*    */   public static void color(int hex) {
/* 62 */     GlStateManager.func_179131_c((hex >> 16 & 0xFF) / 255.0F, (hex >> 8 & 0xFF) / 255.0F, (hex & 0xFF) / 255.0F, (hex >> 24 & 0xFF) / 255.0F);
/*    */   }
/*    */   
/*    */   public static void resetColor() {
/* 66 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\cnfont\GLUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */