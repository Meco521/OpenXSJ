/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.tenacity.ShaderUtil;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.shader.Framebuffer;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import org.lwjgl.opengl.GL13;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BloomUtil
/*    */   extends MinecraftInstance
/*    */ {
/* 20 */   public static ShaderUtil gaussianBloom = new ShaderUtil("tomk/shader/fragment/bloom.frag");
/*    */   
/* 22 */   public static Framebuffer framebuffer = new Framebuffer(1, 1, false);
/*    */   
/*    */   public static float calculateGaussianValue(float x, float sigma) {
/* 25 */     double PI = 3.141592653D;
/* 26 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/* 27 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*    */   }
/*    */   
/*    */   public static void renderBlur(int sourceTexture, int radius, int offset) {
/* 31 */     GlStateManager.func_179147_l();
/* 32 */     GlStateManager.func_179131_c(0.0F, 0.0F, 0.0F, 1.0F);
/* 33 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 34 */     framebuffer = RenderUtils.createFrameBuffer(framebuffer);
/* 35 */     FloatBuffer weightBuffer = BufferUtils.createFloatBuffer(256);
/* 36 */     for (int i = 0; i <= radius; i++) {
/* 37 */       weightBuffer.put(calculateGaussianValue(i, radius));
/*    */     }
/* 39 */     weightBuffer.rewind();
/*    */     
/* 41 */     RenderUtils.setAlphaLimit(0.0F);
/*    */     
/* 43 */     framebuffer.func_147614_f();
/* 44 */     framebuffer.func_147610_a(true);
/* 45 */     gaussianBloom.init();
/* 46 */     setupUniforms(radius, offset, 0, weightBuffer);
/* 47 */     RenderUtils.bindTexture(sourceTexture);
/* 48 */     ShaderUtil.drawQuads();
/* 49 */     gaussianBloom.unload();
/* 50 */     framebuffer.func_147609_e();
/*    */ 
/*    */     
/* 53 */     mc.getFramebuffer().bindFramebuffer(true);
/*    */     
/* 55 */     gaussianBloom.init();
/* 56 */     setupUniforms(radius, 0, offset, weightBuffer);
/* 57 */     GL13.glActiveTexture(34000);
/* 58 */     RenderUtils.bindTexture(sourceTexture);
/* 59 */     GL13.glActiveTexture(33984);
/* 60 */     RenderUtils.bindTexture(framebuffer.field_147617_g);
/* 61 */     ShaderUtil.drawQuads();
/* 62 */     gaussianBloom.unload();
/*    */     
/* 64 */     GlStateManager.func_179092_a(516, 0.1F);
/* 65 */     GlStateManager.func_179141_d();
/*    */     
/* 67 */     GlStateManager.func_179144_i(0);
/*    */   }
/*    */   
/*    */   public static void setupUniforms(int radius, int directionX, int directionY, FloatBuffer weights) {
/* 71 */     gaussianBloom.setUniformi("inTexture", new int[] { 0 });
/* 72 */     gaussianBloom.setUniformi("textureToCheck", new int[] { 16 });
/* 73 */     gaussianBloom.setUniformf("radius", new float[] { radius });
/* 74 */     gaussianBloom.setUniformf("texelSize", new float[] { 1.0F / mc.getDisplayWidth(), 1.0F / mc.getDisplayHeight() });
/* 75 */     gaussianBloom.setUniformf("direction", new float[] { directionX, directionY });
/* 76 */     GL20.glUniform1(gaussianBloom.getUniform("weights"), weights);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\BloomUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */