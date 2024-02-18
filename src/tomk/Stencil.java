/*    */ package tomk;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.shader.Framebuffer;
/*    */ import org.lwjgl.opengl.EXTFramebufferObject;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Stencil
/*    */   extends MinecraftInstance2
/*    */ {
/*    */   public static void dispose() {
/* 18 */     GL11.glDisable(2960);
/* 19 */     GlStateManager.func_179118_c();
/* 20 */     GlStateManager.func_179084_k();
/*    */   }
/*    */   
/*    */   public static void erase(boolean invert) {
/* 24 */     GL11.glStencilFunc(invert ? 514 : 517, 1, 65535);
/* 25 */     GL11.glStencilOp(7680, 7680, 7681);
/* 26 */     GlStateManager.func_179135_a(true, true, true, true);
/* 27 */     GlStateManager.func_179141_d();
/* 28 */     GlStateManager.func_179147_l();
/* 29 */     GL11.glAlphaFunc(516, 0.0F);
/*    */   }
/*    */   
/*    */   public static void write(boolean renderClipLayer) {
/* 33 */     checkSetupFBO();
/* 34 */     GL11.glClearStencil(0);
/* 35 */     GL11.glClear(1024);
/* 36 */     GL11.glEnable(2960);
/* 37 */     GL11.glStencilFunc(519, 1, 65535);
/* 38 */     GL11.glStencilOp(7680, 7680, 7681);
/* 39 */     if (!renderClipLayer)
/* 40 */       GlStateManager.func_179135_a(false, false, false, false); 
/*    */   }
/*    */   
/*    */   public static void write(boolean renderClipLayer, Framebuffer fb, boolean clearStencil, boolean invert) {
/* 44 */     checkSetupFBO(fb);
/* 45 */     if (clearStencil) {
/* 46 */       GL11.glClearStencil(0);
/* 47 */       GL11.glClear(1024);
/* 48 */       GL11.glEnable(2960);
/*    */     } 
/* 50 */     GL11.glStencilFunc(519, invert ? 0 : 1, 65535);
/* 51 */     GL11.glStencilOp(7680, 7680, 7681);
/* 52 */     if (!renderClipLayer)
/* 53 */       GlStateManager.func_179135_a(false, false, false, false); 
/*    */   }
/*    */   
/*    */   public static void checkSetupFBO() {
/* 57 */     Framebuffer fbo = mc.func_147110_a();
/* 58 */     if (fbo.field_147624_h > -1) {
/* 59 */       setupFBO(fbo);
/* 60 */       fbo.field_147624_h = -1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void checkSetupFBO(Framebuffer fbo) {
/* 65 */     if (fbo != null && fbo.field_147624_h > -1) {
/* 66 */       setupFBO(fbo);
/* 67 */       fbo.field_147624_h = -1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void setupFBO(Framebuffer fbo) {
/* 72 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(fbo.field_147624_h);
/* 73 */     int stencil_depth_buffer_ID = EXTFramebufferObject.glGenRenderbuffersEXT();
/* 74 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencil_depth_buffer_ID);
/* 75 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/* 76 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencil_depth_buffer_ID);
/* 77 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencil_depth_buffer_ID);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\Stencil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */