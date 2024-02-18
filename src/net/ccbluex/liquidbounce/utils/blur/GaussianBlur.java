/*    */ package net.ccbluex.liquidbounce.utils.blur;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import me.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MathUtils2;
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
/*    */ public class GaussianBlur
/*    */ {
/* 19 */   public static ShaderUtil blurShader = new ShaderUtil("shaders/gaussian.frag");
/*    */   
/* 21 */   public static Framebuffer framebuffer = new Framebuffer(1, 1, false);
/*    */ 
/*    */   
/*    */   public static void setupUniforms(float dir1, float dir2, float radius) {
/* 25 */     blurShader.setUniformi("textureIn", new int[] { 0 });
/* 26 */     blurShader.setUniformf("texelSize", new float[] { 1.0F / (Minecraft.func_71410_x()).field_71443_c, 1.0F / (Minecraft.func_71410_x()).field_71440_d });
/* 27 */     blurShader.setUniformf("direction", new float[] { dir1, dir2 });
/* 28 */     blurShader.setUniformf("radius", new float[] { radius });
/*    */     
/* 30 */     FloatBuffer weightBuffer = BufferUtils.createFloatBuffer(256);
/* 31 */     for (int i = 0; i <= radius; i++) {
/* 32 */       weightBuffer.put(MathUtils2.calculateGaussianValue(i, radius / 2.0F));
/*    */     }
/*    */     
/* 35 */     weightBuffer.rewind();
/* 36 */     GL20.glUniform1(blurShader.getUniform("weights"), weightBuffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderBlur(float radius) {
/* 41 */     GlStateManager.func_179147_l();
/* 42 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 43 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*    */ 
/*    */     
/* 46 */     framebuffer = RenderUtils.createFrameBuffer(framebuffer);
/*    */     
/* 48 */     framebuffer.func_147614_f();
/* 49 */     framebuffer.func_147610_a(true);
/* 50 */     blurShader.init();
/* 51 */     setupUniforms(1.0F, 0.0F, radius);
/*    */     
/* 53 */     RenderUtils.bindTexture((Minecraft.func_71410_x().func_147110_a()).field_147617_g);
/*    */     
/* 55 */     ShaderUtil.drawQuads();
/* 56 */     framebuffer.func_147609_e();
/* 57 */     blurShader.unload();
/*    */     
/* 59 */     Minecraft.func_71410_x().func_147110_a().func_147610_a(true);
/* 60 */     blurShader.init();
/* 61 */     setupUniforms(0.0F, 1.0F, radius);
/*    */     
/* 63 */     RenderUtils.bindTexture(framebuffer.field_147617_g);
/* 64 */     ShaderUtil.drawQuads();
/* 65 */     blurShader.unload();
/*    */     
/* 67 */     RenderUtils.resetColor();
/* 68 */     GlStateManager.func_179144_i(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\blur\GaussianBlur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */