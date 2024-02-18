/*    */ package net.ccbluex.liquidbounce.utils.blur;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setupFBO(Framebuffer framebuffer) {
/* 31 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(framebuffer.field_147624_h);
/* 32 */     int stencilDepthBufferID = EXTFramebufferObject.glGenRenderbuffersEXT();
/* 33 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencilDepthBufferID);
/* 34 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, mc.field_71443_c, mc.field_71440_d);
/* 35 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencilDepthBufferID);
/* 36 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencilDepthBufferID);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initStencilToWrite() {
/* 44 */     mc.func_147110_a().func_147610_a(false);
/* 45 */     checkSetupFBO(mc.func_147110_a());
/* 46 */     GL11.glClear(1024);
/* 47 */     GL11.glEnable(2960);
/*    */     
/* 49 */     GL11.glStencilFunc(519, 1, 1);
/* 50 */     GL11.glStencilOp(7681, 7681, 7681);
/* 51 */     GL11.glColorMask(false, false, false, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void readStencilBuffer(int ref) {
/* 60 */     GL11.glColorMask(true, true, true, true);
/* 61 */     GL11.glStencilFunc(514, ref, 1);
/* 62 */     GL11.glStencilOp(7680, 7680, 7680);
/*    */   }
/*    */   
/*    */   public static void uninitStencilBuffer() {
/* 66 */     GL11.glDisable(2960);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\blur\StencilUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */