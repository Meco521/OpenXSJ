/*    */ package lynn.utils.blur;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import lynn.utils.LiYingUtil;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.shader.Framebuffer;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GaussianBlur
/*    */ {
/* 21 */   public static ShaderUtil blurShader = new ShaderUtil("shaders/gaussian.frag");
/*    */   
/* 23 */   public static Framebuffer framebuffer = new Framebuffer(1, 1, false);
/*    */   public static float calculateGaussianValue(float x, float sigma) {
/* 25 */     double PI = 3.141592653D;
/* 26 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/* 27 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*    */   }
/*    */   public static void rendershadow(int radius) {
/* 30 */     framebuffer = RenderUtils.createFrameBuffer(framebuffer);
/* 31 */     GlStateManager.func_179141_d();
/* 32 */     GlStateManager.func_179092_a(516, 0.0F);
/* 33 */     GlStateManager.func_179147_l();
/* 34 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 35 */     FloatBuffer weightBuffer = BufferUtils.createFloatBuffer(256);
/* 36 */     for (int i = 0; i <= radius; i++)
/* 37 */       weightBuffer.put(calculateGaussianValue(i, radius)); 
/*    */   }
/*    */   public static void setupUniforms(float dir1, float dir2, float radius) {
/* 40 */     blurShader.setUniformi("textureIn", new int[] { 0 });
/* 41 */     blurShader.setUniformf("texelSize", new float[] { 1.0F / (Minecraft.func_71410_x()).field_71443_c, 1.0F / (Minecraft.func_71410_x()).field_71440_d });
/* 42 */     blurShader.setUniformf("direction", new float[] { dir1, dir2 });
/* 43 */     blurShader.setUniformf("radius", new float[] { radius });
/*    */     
/* 45 */     FloatBuffer weightBuffer = BufferUtils.createFloatBuffer(256);
/* 46 */     for (int i = 0; i <= radius; i++) {
/* 47 */       weightBuffer.put(LiYingUtil.calculateGaussianValue(i, radius / 2.0F));
/*    */     }
/*    */     
/* 50 */     weightBuffer.rewind();
/* 51 */     GL20.glUniform1(blurShader.getUniform("weights"), weightBuffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderBlur(float radius) {
/* 56 */     GlStateManager.func_179147_l();
/* 57 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 58 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*    */ 
/*    */     
/* 61 */     framebuffer = RenderUtils.createFrameBuffer(framebuffer);
/*    */     
/* 63 */     framebuffer.func_147614_f();
/* 64 */     framebuffer.func_147610_a(true);
/* 65 */     blurShader.init();
/* 66 */     setupUniforms(1.0F, 0.0F, radius);
/*    */     
/* 68 */     RenderUtils.bindTexture((Minecraft.func_71410_x().func_147110_a()).field_147617_g);
/*    */     
/* 70 */     ShaderUtil.drawQuads();
/* 71 */     framebuffer.func_147609_e();
/* 72 */     blurShader.unload();
/*    */     
/* 74 */     Minecraft.func_71410_x().func_147110_a().func_147610_a(true);
/* 75 */     blurShader.init();
/* 76 */     setupUniforms(0.0F, 1.0F, radius);
/*    */     
/* 78 */     RenderUtils.bindTexture(framebuffer.field_147617_g);
/* 79 */     ShaderUtil.drawQuads();
/* 80 */     blurShader.unload();
/*    */     
/* 82 */     RenderUtils.resetColor();
/* 83 */     GlStateManager.func_179144_i(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\blur\GaussianBlur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */