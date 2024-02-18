/*    */ package lynn.utils.blur;
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
/*    */   public static void initStencil() {
/* 26 */     initStencil(mc.func_147110_a());
/*    */   }
/*    */   public static void initStencil(Framebuffer framebuffer) {
/* 29 */     framebuffer.func_147610_a(false);
/* 30 */     checkSetupFBO(framebuffer);
/* 31 */     GL11.glClear(1024);
/* 32 */     GL11.glEnable(2960);
/*    */   }
/*    */   public static void bindWriteStencilBuffer() {
/* 35 */     GL11.glStencilFunc(519, 1, 1);
/* 36 */     GL11.glStencilOp(7681, 7681, 7681);
/* 37 */     GL11.glColorMask(false, false, false, false);
/*    */   }
/*    */   public static void bindReadStencilBuffer(int ref) {
/* 40 */     GL11.glColorMask(true, true, true, true);
/* 41 */     GL11.glStencilFunc(514, ref, 1);
/* 42 */     GL11.glStencilOp(7680, 7680, 7680);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setupFBO(Framebuffer framebuffer) {
/* 49 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(framebuffer.field_147624_h);
/* 50 */     int stencilDepthBufferID = EXTFramebufferObject.glGenRenderbuffersEXT();
/* 51 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencilDepthBufferID);
/* 52 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, mc.field_71443_c, mc.field_71440_d);
/* 53 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencilDepthBufferID);
/* 54 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencilDepthBufferID);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initStencilToWrite() {
/* 62 */     mc.func_147110_a().func_147610_a(false);
/* 63 */     checkSetupFBO(mc.func_147110_a());
/* 64 */     GL11.glClear(1024);
/* 65 */     GL11.glEnable(2960);
/*    */     
/* 67 */     GL11.glStencilFunc(519, 1, 1);
/* 68 */     GL11.glStencilOp(7681, 7681, 7681);
/* 69 */     GL11.glColorMask(false, false, false, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void readStencilBuffer(int ref) {
/* 78 */     GL11.glColorMask(true, true, true, true);
/* 79 */     GL11.glStencilFunc(514, ref, 1);
/* 80 */     GL11.glStencilOp(7680, 7680, 7680);
/*    */   }
/*    */   
/*    */   public static void uninitStencilBuffer() {
/* 84 */     GL11.glDisable(2960);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\blur\StencilUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */