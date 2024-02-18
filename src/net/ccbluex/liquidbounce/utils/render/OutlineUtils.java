/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.opengl.EXTFramebufferObject;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class OutlineUtils
/*     */ {
/*     */   public static void renderOne(float lineWidth) {
/*  23 */     checkSetupFBO();
/*  24 */     GL11.glPushAttrib(1048575);
/*  25 */     GL11.glDisable(3008);
/*  26 */     GL11.glDisable(3553);
/*  27 */     GL11.glDisable(2896);
/*  28 */     GL11.glEnable(3042);
/*  29 */     GL11.glBlendFunc(770, 771);
/*  30 */     GL11.glLineWidth(lineWidth);
/*  31 */     GL11.glEnable(2848);
/*  32 */     GL11.glEnable(2960);
/*  33 */     GL11.glClear(1024);
/*  34 */     GL11.glClearStencil(15);
/*  35 */     GL11.glStencilFunc(512, 1, 15);
/*  36 */     GL11.glStencilOp(7681, 7681, 7681);
/*  37 */     GL11.glPolygonMode(1032, 6913);
/*     */   }
/*     */   
/*     */   public static void renderTwo() {
/*  41 */     GL11.glStencilFunc(512, 0, 15);
/*  42 */     GL11.glStencilOp(7681, 7681, 7681);
/*  43 */     GL11.glPolygonMode(1032, 6914);
/*     */   }
/*     */   
/*     */   public static void renderThree() {
/*  47 */     GL11.glStencilFunc(514, 1, 15);
/*  48 */     GL11.glStencilOp(7680, 7680, 7680);
/*  49 */     GL11.glPolygonMode(1032, 6913);
/*     */   }
/*     */   
/*     */   public static void renderFour(Color color) {
/*  53 */     setColor(color);
/*  54 */     GL11.glDepthMask(false);
/*  55 */     GL11.glDisable(2929);
/*  56 */     GL11.glEnable(10754);
/*  57 */     GL11.glPolygonOffset(1.0F, -2000000.0F);
/*  58 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
/*     */   }
/*     */   
/*     */   public static void renderFive() {
/*  62 */     GL11.glPolygonOffset(1.0F, 2000000.0F);
/*  63 */     GL11.glDisable(10754);
/*  64 */     GL11.glEnable(2929);
/*  65 */     GL11.glDepthMask(true);
/*  66 */     GL11.glDisable(2960);
/*  67 */     GL11.glDisable(2848);
/*  68 */     GL11.glHint(3154, 4352);
/*  69 */     GL11.glEnable(3042);
/*  70 */     GL11.glEnable(2896);
/*  71 */     GL11.glEnable(3553);
/*  72 */     GL11.glEnable(3008);
/*  73 */     GL11.glPopAttrib();
/*     */   }
/*     */   
/*     */   public static void setColor(Color color) {
/*  77 */     GL11.glColor4d((color.getRed() / 255.0F), (color.getGreen() / 255.0F), (color.getBlue() / 255.0F), (color.getAlpha() / 255.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkSetupFBO() {
/*  82 */     Framebuffer fbo = Minecraft.func_71410_x().func_147110_a();
/*     */ 
/*     */     
/*  85 */     if (fbo != null)
/*     */     {
/*  87 */       if (fbo.field_147624_h > -1) {
/*     */         
/*  89 */         setupFBO(fbo);
/*     */         
/*  91 */         fbo.field_147624_h = -1;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void setupFBO(Framebuffer fbo) {
/* 104 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(fbo.field_147624_h);
/*     */     
/* 106 */     int stencil_depth_buffer_ID = EXTFramebufferObject.glGenRenderbuffersEXT();
/*     */ 
/*     */     
/* 109 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencil_depth_buffer_ID);
/*     */ 
/*     */ 
/*     */     
/* 113 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/*     */ 
/*     */ 
/*     */     
/* 117 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencil_depth_buffer_ID);
/*     */ 
/*     */ 
/*     */     
/* 121 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencil_depth_buffer_ID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\OutlineUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */