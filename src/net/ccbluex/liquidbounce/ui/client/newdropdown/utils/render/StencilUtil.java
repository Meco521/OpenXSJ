/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.shader.Framebuffer;
/*    */ import org.lwjgl.opengl.EXTFramebufferObject;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class StencilUtil
/*    */ {
/* 11 */   static Minecraft mc = Minecraft.func_71410_x();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void checkSetupFBO(Framebuffer framebuffer) {
/* 18 */     if (framebuffer != null && 
/* 19 */       framebuffer.field_147624_h > -1) {
/* 20 */       setupFBO(framebuffer);
/* 21 */       framebuffer.field_147624_h = -1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void bindReadStencilBuffer(int ref) {
/* 26 */     GL11.glColorMask(true, true, true, true);
/* 27 */     GL11.glStencilFunc(514, ref, 1);
/* 28 */     GL11.glStencilOp(7680, 7680, 7680);
/*    */   }
/*    */   public static void initStencil() {
/* 31 */     initStencil(mc.func_147110_a());
/*    */   }
/*    */   public static void initStencil(Framebuffer framebuffer) {
/* 34 */     framebuffer.func_147610_a(false);
/* 35 */     checkSetupFBO(framebuffer);
/* 36 */     GL11.glClear(1024);
/* 37 */     GL11.glEnable(2960);
/*    */   }
/*    */   public static void bindWriteStencilBuffer() {
/* 40 */     GL11.glStencilFunc(519, 1, 1);
/* 41 */     GL11.glStencilOp(7681, 7681, 7681);
/* 42 */     GL11.glColorMask(false, false, false, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setupFBO(Framebuffer framebuffer) {
/* 50 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(framebuffer.field_147624_h);
/* 51 */     int stencilDepthBufferID = EXTFramebufferObject.glGenRenderbuffersEXT();
/* 52 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencilDepthBufferID);
/* 53 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, mc.field_71443_c, mc.field_71440_d);
/* 54 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencilDepthBufferID);
/* 55 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencilDepthBufferID);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initStencilToWrite() {
/* 63 */     mc.func_147110_a().func_147610_a(false);
/* 64 */     checkSetupFBO(mc.func_147110_a());
/* 65 */     GL11.glClear(1024);
/* 66 */     GL11.glEnable(2960);
/*    */     
/* 68 */     GL11.glStencilFunc(519, 1, 1);
/* 69 */     GL11.glStencilOp(7681, 7681, 7681);
/* 70 */     GL11.glColorMask(false, false, false, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void readStencilBuffer(int ref) {
/* 79 */     GL11.glColorMask(true, true, true, true);
/* 80 */     GL11.glStencilFunc(514, ref, 1);
/* 81 */     GL11.glStencilOp(7680, 7680, 7680);
/*    */   }
/*    */   
/*    */   public static void uninitStencilBuffer() {
/* 85 */     GL11.glDisable(2960);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\render\StencilUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */