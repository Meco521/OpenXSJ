/*    */ package net.ccbluex.liquidbounce.utils.ui;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.shader.Framebuffer;
/*    */ import org.lwjgl.opengl.EXTFramebufferObject;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class Stencil
/*    */ {
/* 11 */   public static Minecraft mc = Minecraft.func_71410_x();
/*    */   
/*    */   public static int nextColor;
/*    */   
/*    */   public static void write(boolean renderClipLayer) {
/* 16 */     checkSetupFBO();
/* 17 */     GL11.glClearStencil(0);
/* 18 */     GL11.glClear(1024);
/* 19 */     GL11.glEnable(2960);
/* 20 */     GL11.glStencilFunc(519, 1, 65535);
/* 21 */     GL11.glStencilOp(7680, 7680, 7681);
/* 22 */     if (!renderClipLayer) {
/* 23 */       GlStateManager.func_179135_a(false, false, false, false);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void erase(boolean invert) {
/* 28 */     GL11.glStencilFunc(invert ? 514 : 517, 1, 65535);
/* 29 */     GL11.glStencilOp(7680, 7680, 7681);
/* 30 */     GlStateManager.func_179135_a(true, true, true, true);
/* 31 */     GlStateManager.func_179141_d();
/* 32 */     GlStateManager.func_179147_l();
/* 33 */     GL11.glAlphaFunc(516, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void dispose() {
/* 38 */     GL11.glDisable(2960);
/* 39 */     GlStateManager.func_179118_c();
/* 40 */     GlStateManager.func_179084_k();
/*    */   }
/*    */   
/*    */   public static void checkSetupFBO() {
/* 44 */     Framebuffer fbo = Minecraft.func_71410_x().func_147110_a();
/* 45 */     if (fbo != null && fbo.field_147624_h > -1) {
/* 46 */       setupFBO(fbo);
/* 47 */       fbo.field_147624_h = -1;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setupFBO(Framebuffer fbo) {
/* 53 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(fbo.field_147624_h);
/* 54 */     int stencil_depth_buffer_ID = EXTFramebufferObject.glGenRenderbuffersEXT();
/* 55 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencil_depth_buffer_ID);
/* 56 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/* 57 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencil_depth_buffer_ID);
/* 58 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencil_depth_buffer_ID);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\util\\ui\Stencil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */