/*     */ package net.ccbluex.liquidbounce.utils.render.blur;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.misc.MathUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GaussianBlur
/*     */ {
/*  20 */   public static ShaderUtil blurShader = new ShaderUtil("tomk/shader/fragment/gaussian.frag");
/*     */   
/*  22 */   public static Framebuffer framebuffer = new Framebuffer(1, 1, false);
/*     */   public static void startBlur() {
/*  24 */     StencilUtil.initStencilToWrite();
/*     */   }
/*     */   public static void endBlur(float radius, float compression) {
/*  27 */     StencilUtil.readStencilBuffer(1);
/*     */     
/*  29 */     framebuffer = RenderUtils.createFrameBuffer(framebuffer);
/*     */     
/*  31 */     framebuffer.func_147614_f();
/*  32 */     framebuffer.func_147610_a(false);
/*  33 */     blurShader.init();
/*  34 */     setupUniforms(compression, 0.0F, radius);
/*     */     
/*  36 */     RenderUtils.bindTexture((MinecraftInstance.mc2.func_147110_a()).field_147617_g);
/*  37 */     ShaderUtil.drawQuads();
/*  38 */     framebuffer.func_147609_e();
/*  39 */     blurShader.unload();
/*     */     
/*  41 */     MinecraftInstance.mc2.func_147110_a().func_147610_a(false);
/*  42 */     blurShader.init();
/*  43 */     setupUniforms(0.0F, compression, radius);
/*     */     
/*  45 */     RenderUtils.bindTexture(framebuffer.field_147617_g);
/*  46 */     ShaderUtil.drawQuads();
/*  47 */     blurShader.unload();
/*     */     
/*  49 */     StencilUtil.uninitStencilBuffer();
/*  50 */     RenderUtils.resetColor();
/*  51 */     GlStateManager.func_179144_i(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setupUniforms(float dir1, float dir2, float radius) {
/*  57 */     blurShader.setUniformi("textureIn", new int[] { 0 });
/*  58 */     blurShader.setUniformf("texelSize", new float[] { 1.0F / (Minecraft.func_71410_x()).field_71443_c, 1.0F / (Minecraft.func_71410_x()).field_71440_d });
/*  59 */     blurShader.setUniformf("direction", new float[] { dir1, dir2 });
/*  60 */     blurShader.setUniformf("radius", new float[] { radius });
/*     */     
/*  62 */     FloatBuffer weightBuffer = BufferUtils.createFloatBuffer(256);
/*  63 */     for (int i = 0; i <= radius; i++) {
/*  64 */       weightBuffer.put(MathUtils.calculateGaussianValue(i, radius / 2.0F));
/*     */     }
/*     */     
/*  67 */     weightBuffer.rewind();
/*  68 */     GL20.glUniform1(blurShader.getUniform("weights"), weightBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderBlur(float radius) {
/*  73 */     GlStateManager.func_179147_l();
/*  74 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  75 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */ 
/*     */     
/*  78 */     framebuffer = RenderUtils.createFrameBuffer(framebuffer);
/*     */     
/*  80 */     framebuffer.func_147614_f();
/*  81 */     framebuffer.func_147610_a(true);
/*  82 */     blurShader.init();
/*  83 */     setupUniforms(1.0F, 0.0F, radius);
/*     */     
/*  85 */     RenderUtils.bindTexture((Minecraft.func_71410_x().func_147110_a()).field_147617_g);
/*     */     
/*  87 */     ShaderUtil.drawQuads();
/*  88 */     framebuffer.func_147609_e();
/*  89 */     blurShader.unload();
/*     */     
/*  91 */     Minecraft.func_71410_x().func_147110_a().func_147610_a(true);
/*  92 */     blurShader.init();
/*  93 */     setupUniforms(0.0F, 1.0F, radius);
/*     */     
/*  95 */     RenderUtils.bindTexture(framebuffer.field_147617_g);
/*  96 */     ShaderUtil.drawQuads();
/*  97 */     blurShader.unload();
/*     */     
/*  99 */     RenderUtils.resetColor();
/* 100 */     GlStateManager.func_179144_i(0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\blur\GaussianBlur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */