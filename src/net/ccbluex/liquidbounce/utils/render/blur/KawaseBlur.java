/*     */ package net.ccbluex.liquidbounce.utils.render.blur;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import lynn.utils.ShaderUtil;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.GLUtil;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KawaseBlur
/*     */   extends MinecraftInstance
/*     */ {
/*  20 */   private static final List<Framebuffer> framebufferList = new ArrayList<>();
/*  21 */   public static ShaderUtil kawaseDown = new ShaderUtil("kawaseDown");
/*  22 */   public static ShaderUtil kawaseUp = new ShaderUtil("kawaseUp");
/*  23 */   public static Framebuffer framebuffer = new Framebuffer(1, 1, false);
/*     */   private static int currentIterations;
/*     */   
/*     */   public static void setupUniforms(float offset) {
/*  27 */     kawaseDown.setUniformf("offset", new float[] { offset, offset });
/*  28 */     kawaseUp.setUniformf("offset", new float[] { offset, offset });
/*     */   }
/*     */   
/*     */   private static void initFramebuffers(float iterations) {
/*  32 */     for (Framebuffer framebuffer : framebufferList) {
/*  33 */       framebuffer.func_147608_a();
/*     */     }
/*  35 */     framebufferList.clear();
/*     */ 
/*     */     
/*  38 */     framebufferList.add(KawaseBlur.framebuffer = RenderUtils.TcreateFrameBuffer(null));
/*     */ 
/*     */     
/*  41 */     for (int i = 1; i <= iterations; i++) {
/*  42 */       Framebuffer currentBuffer = new Framebuffer((int)(minecraft.field_71443_c / Math.pow(2.0D, i)), (int)(minecraft.field_71440_d / Math.pow(2.0D, i)), false);
/*  43 */       currentBuffer.func_147607_a(9729);
/*  44 */       GlStateManager.func_179144_i(currentBuffer.field_147617_g);
/*  45 */       GL11.glTexParameteri(3553, 10242, 33648);
/*  46 */       GL11.glTexParameteri(3553, 10243, 33648);
/*  47 */       GlStateManager.func_179144_i(0);
/*     */       
/*  49 */       framebufferList.add(currentBuffer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderBlur(int stencilFrameBufferTexture, int iterations, int offset) {
/*  56 */     GlStateManager.func_179147_l();
/*  57 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  58 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  59 */     if (currentIterations != iterations || framebuffer.field_147621_c != mc2.field_71443_c || framebuffer.field_147618_d != mc2.field_71440_d) {
/*  60 */       initFramebuffers(iterations);
/*  61 */       currentIterations = iterations;
/*     */     } 
/*  63 */     renderFBO(framebufferList.get(1), (mc2.func_147110_a()).field_147617_g, kawaseDown, offset);
/*     */     
/*     */     int i;
/*  66 */     for (i = 1; i < iterations; i++) {
/*  67 */       renderFBO(framebufferList.get(i + 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseDown, offset);
/*     */     }
/*     */ 
/*     */     
/*  71 */     for (i = iterations; i > 1; i--) {
/*  72 */       renderFBO(framebufferList.get(i - 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseUp, offset);
/*     */     }
/*     */ 
/*     */     
/*  76 */     Framebuffer lastBuffer = framebufferList.get(0);
/*  77 */     lastBuffer.func_147614_f();
/*     */     
/*  79 */     lastBuffer.func_147610_a(false);
/*  80 */     kawaseUp.init();
/*  81 */     kawaseUp.setUniformf("offset", new float[] { offset, offset });
/*  82 */     kawaseUp.setUniformi("inTexture", new int[] { 0 });
/*  83 */     kawaseUp.setUniformi("check", new int[] { 1 });
/*  84 */     kawaseUp.setUniformi("textureToCheck", new int[] { 16 });
/*  85 */     kawaseUp.setUniformf("halfpixel", new float[] { 1.0F / lastBuffer.field_147621_c, 1.0F / lastBuffer.field_147618_d });
/*  86 */     kawaseUp.setUniformf("iResolution", new float[] { lastBuffer.field_147621_c, lastBuffer.field_147618_d });
/*  87 */     GL13.glActiveTexture(34000);
/*  88 */     RenderUtils.bindTexture(stencilFrameBufferTexture);
/*  89 */     GL13.glActiveTexture(33984);
/*  90 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(1)).field_147617_g);
/*  91 */     ShaderUtil.drawQuads();
/*  92 */     kawaseUp.unload();
/*     */     
/*  94 */     mc2.func_147110_a().func_147610_a(true);
/*  95 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(0)).field_147617_g);
/*  96 */     RenderUtils.setAlphaLimit(0.0F);
/*  97 */     GLUtil.startBlend();
/*  98 */     ShaderUtil.drawQuads();
/*  99 */     GlStateManager.func_179144_i(0);
/*     */   }
/*     */   public static void renderBlur2(int stencilFrameBufferTexture, int iterations, int offset) {
/* 102 */     if (currentIterations != iterations || framebuffer.field_147621_c != mc2.field_71443_c || framebuffer.field_147618_d != mc2.field_71440_d) {
/* 103 */       initFramebuffers(iterations);
/* 104 */       currentIterations = iterations;
/*     */     } 
/*     */     
/* 107 */     renderFBO(framebufferList.get(1), (mc2.func_147110_a()).field_147617_g, kawaseDown, offset);
/*     */     
/*     */     int i;
/* 110 */     for (i = 1; i < iterations; i++) {
/* 111 */       renderFBO(framebufferList.get(i + 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseDown, offset);
/*     */     }
/*     */ 
/*     */     
/* 115 */     for (i = iterations; i > 1; i--) {
/* 116 */       renderFBO(framebufferList.get(i - 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseUp, offset);
/*     */     }
/*     */ 
/*     */     
/* 120 */     Framebuffer lastBuffer = framebufferList.get(0);
/* 121 */     lastBuffer.func_147614_f();
/* 122 */     lastBuffer.func_147610_a(false);
/* 123 */     kawaseUp.init();
/* 124 */     kawaseUp.setUniformf("offset", new float[] { offset, offset });
/* 125 */     kawaseUp.setUniformi("inTexture", new int[] { 0 });
/* 126 */     kawaseUp.setUniformi("check", new int[] { 1 });
/* 127 */     kawaseUp.setUniformi("textureToCheck", new int[] { 16 });
/* 128 */     kawaseUp.setUniformf("halfpixel", new float[] { 1.0F / lastBuffer.field_147621_c, 1.0F / lastBuffer.field_147618_d });
/* 129 */     kawaseUp.setUniformf("iResolution", new float[] { lastBuffer.field_147621_c, lastBuffer.field_147618_d });
/* 130 */     GL13.glActiveTexture(34000);
/* 131 */     RenderUtils.bindTexture(stencilFrameBufferTexture);
/* 132 */     GL13.glActiveTexture(33984);
/* 133 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(1)).field_147617_g);
/* 134 */     ShaderUtil.drawQuads();
/* 135 */     kawaseUp.unload();
/*     */ 
/*     */     
/* 138 */     mc.getFramebuffer().bindFramebuffer(true);
/* 139 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(0)).field_147617_g);
/* 140 */     RenderUtils.setAlphaLimit(0.0F);
/* 141 */     GLUtil.startBlend();
/* 142 */     ShaderUtil.drawQuads();
/* 143 */     GlStateManager.func_179144_i(0);
/* 144 */     GlStateManager.func_179117_G();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderFBO(Framebuffer framebuffer, int framebufferTexture, ShaderUtil shader, float offset) {
/* 149 */     framebuffer.func_147614_f();
/* 150 */     framebuffer.func_147610_a(false);
/* 151 */     shader.init();
/* 152 */     RenderUtils.bindTexture(framebufferTexture);
/* 153 */     shader.setUniformf("offset", new float[] { offset, offset });
/* 154 */     shader.setUniformi("inTexture", new int[] { 0 });
/* 155 */     shader.setUniformi("check", new int[] { 0 });
/* 156 */     shader.setUniformf("halfpixel", new float[] { 1.0F / framebuffer.field_147621_c, 1.0F / framebuffer.field_147618_d });
/* 157 */     shader.setUniformf("iResolution", new float[] { framebuffer.field_147621_c, framebuffer.field_147618_d });
/* 158 */     ShaderUtil.drawQuads();
/* 159 */     shader.unload();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\blur\KawaseBlur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */