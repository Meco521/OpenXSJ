/*     */ package net.ccbluex.liquidbounce.utils.render.blur;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import lynn.utils.ShaderUtil;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.GLUtil;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.normal.Utils;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KawaseBloom
/*     */   implements Utils
/*     */ {
/*  23 */   public static ShaderUtil kawaseDown = new ShaderUtil("kawaseDownBloom");
/*  24 */   public static ShaderUtil kawaseUp = new ShaderUtil("kawaseUpBloom");
/*     */   
/*  26 */   public static Framebuffer framebuffer = new Framebuffer(1, 1, true);
/*     */ 
/*     */   
/*     */   private static int currentIterations;
/*     */   
/*  31 */   private static final List<Framebuffer> framebufferList = new ArrayList<>();
/*     */   
/*     */   private static void initFramebuffers(float iterations) {
/*  34 */     for (Framebuffer framebuffer : framebufferList) {
/*  35 */       framebuffer.func_147608_a();
/*     */     }
/*  37 */     framebufferList.clear();
/*     */ 
/*     */     
/*  40 */     framebufferList.add(KawaseBloom.framebuffer = RenderUtils.TcreateFrameBuffer(null, true));
/*     */ 
/*     */     
/*  43 */     for (int i = 1; i <= iterations; i++) {
/*  44 */       Framebuffer currentBuffer = new Framebuffer((int)(MinecraftInstance.mc2.field_71443_c / Math.pow(2.0D, i)), (int)(MinecraftInstance.mc2.field_71440_d / Math.pow(2.0D, i)), true);
/*  45 */       currentBuffer.func_147607_a(9729);
/*     */       
/*  47 */       GlStateManager.func_179144_i(currentBuffer.field_147617_g);
/*  48 */       GL11.glTexParameteri(3553, 10242, 33648);
/*  49 */       GL11.glTexParameteri(3553, 10243, 33648);
/*  50 */       GlStateManager.func_179144_i(0);
/*     */       
/*  52 */       framebufferList.add(currentBuffer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderBlur(int framebufferTexture, int iterations, int offset) {
/*  58 */     GlStateManager.func_179147_l();
/*  59 */     GlStateManager.func_179131_c(0.0F, 0.0F, 0.0F, 1.0F);
/*  60 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  61 */     if (currentIterations != iterations || framebuffer.field_147621_c != MinecraftInstance.mc2.field_71443_c || framebuffer.field_147618_d != MinecraftInstance.mc2.field_71440_d) {
/*  62 */       initFramebuffers(iterations);
/*  63 */       currentIterations = iterations;
/*     */     } 
/*  65 */     RenderUtils.setAlphaLimit(0.0F);
/*     */     
/*  67 */     renderFBO(framebufferList.get(1), framebufferTexture, kawaseDown, offset);
/*     */     int i;
/*  69 */     for (i = 1; i < iterations; i++) {
/*  70 */       renderFBO(framebufferList.get(i + 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseDown, offset);
/*     */     }
/*     */     
/*  73 */     for (i = iterations; i > 1; i--) {
/*  74 */       renderFBO(framebufferList.get(i - 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseUp, offset);
/*     */     }
/*  76 */     Framebuffer lastBuffer = framebufferList.get(0);
/*  77 */     lastBuffer.func_147614_f();
/*  78 */     lastBuffer.func_147610_a(false);
/*  79 */     kawaseUp.init();
/*  80 */     kawaseUp.setUniformf("offset", new float[] { offset, offset });
/*  81 */     kawaseUp.setUniformi("inTexture", new int[] { 0 });
/*  82 */     kawaseUp.setUniformi("check", new int[] { 1 });
/*  83 */     kawaseUp.setUniformi("textureToCheck", new int[] { 16 });
/*  84 */     kawaseUp.setUniformf("halfpixel", new float[] { 1.0F / lastBuffer.field_147621_c, 1.0F / lastBuffer.field_147618_d });
/*  85 */     kawaseUp.setUniformf("iResolution", new float[] { lastBuffer.field_147621_c, lastBuffer.field_147618_d });
/*  86 */     GlStateManager.func_179138_g(34000);
/*  87 */     RenderUtils.bindTexture(framebufferTexture);
/*  88 */     GlStateManager.func_179138_g(33984);
/*  89 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(1)).field_147617_g);
/*  90 */     ShaderUtil.drawQuads();
/*  91 */     kawaseUp.unload();
/*     */     
/*  93 */     MinecraftInstance.mc2.func_147110_a().func_147610_a(false);
/*  94 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(0)).field_147617_g);
/*  95 */     RenderUtils.setAlphaLimit(0.0F);
/*  96 */     GLUtil.startBlend();
/*  97 */     ShaderUtil.drawQuads();
/*  98 */     GlStateManager.func_179144_i(0);
/*  99 */     RenderUtils.setAlphaLimit(0.0F);
/* 100 */     GLUtil.startBlend();
/*     */   }
/*     */   public static void renderBlur2(int framebufferTexture, int iterations, int offset) {
/* 103 */     if (currentIterations != iterations || framebuffer.field_147621_c != MinecraftInstance.mc2.field_71443_c || framebuffer.field_147618_d != MinecraftInstance.mc2.field_71440_d) {
/* 104 */       initFramebuffers(iterations);
/* 105 */       currentIterations = iterations;
/*     */     } 
/*     */     
/* 108 */     RenderUtils.setAlphaLimit(0.0F);
/* 109 */     GlStateManager.func_179147_l();
/* 110 */     GlStateManager.func_179112_b(1, 1);
/*     */     
/* 112 */     GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 113 */     renderFBO(framebufferList.get(1), framebufferTexture, kawaseDown, offset);
/*     */     
/*     */     int i;
/* 116 */     for (i = 1; i < iterations; i++) {
/* 117 */       renderFBO(framebufferList.get(i + 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseDown, offset);
/*     */     }
/*     */ 
/*     */     
/* 121 */     for (i = iterations; i > 1; i--) {
/* 122 */       renderFBO(framebufferList.get(i - 1), ((Framebuffer)framebufferList.get(i)).field_147617_g, kawaseUp, offset);
/*     */     }
/*     */     
/* 125 */     Framebuffer lastBuffer = framebufferList.get(0);
/* 126 */     lastBuffer.func_147614_f();
/* 127 */     lastBuffer.func_147610_a(false);
/* 128 */     kawaseUp.init();
/* 129 */     kawaseUp.setUniformf("offset", new float[] { offset, offset });
/* 130 */     kawaseUp.setUniformi("inTexture", new int[] { 0 });
/* 131 */     kawaseUp.setUniformi("check", new int[] { 1 });
/* 132 */     kawaseUp.setUniformi("textureToCheck", new int[] { 16 });
/* 133 */     kawaseUp.setUniformf("halfpixel", new float[] { 1.0F / lastBuffer.field_147621_c, 1.0F / lastBuffer.field_147618_d });
/* 134 */     kawaseUp.setUniformf("iResolution", new float[] { lastBuffer.field_147621_c, lastBuffer.field_147618_d });
/* 135 */     GlStateManager.func_179138_g(34000);
/* 136 */     RenderUtils.bindTexture(framebufferTexture);
/* 137 */     GlStateManager.func_179138_g(33984);
/* 138 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(1)).field_147617_g);
/* 139 */     ShaderUtil.drawQuads();
/* 140 */     kawaseUp.unload();
/*     */ 
/*     */     
/* 143 */     GlStateManager.func_179082_a(0.0F, 0.0F, 0.0F, 0.0F);
/* 144 */     mc.getFramebuffer().bindFramebuffer(false);
/* 145 */     RenderUtils.bindTexture(((Framebuffer)framebufferList.get(0)).field_147617_g);
/* 146 */     RenderUtils.setAlphaLimit(0.0F);
/* 147 */     GLUtil.startBlend();
/* 148 */     ShaderUtil.drawQuads();
/* 149 */     GlStateManager.func_179144_i(0);
/* 150 */     RenderUtils.setAlphaLimit(0.0F);
/* 151 */     GLUtil.startBlend();
/*     */   }
/*     */   
/*     */   private static void renderFBO(Framebuffer framebuffer, int framebufferTexture, ShaderUtil shader, float offset) {
/* 155 */     framebuffer.func_147614_f();
/* 156 */     framebuffer.func_147610_a(false);
/* 157 */     shader.init();
/* 158 */     RenderUtils.bindTexture(framebufferTexture);
/* 159 */     shader.setUniformf("offset", new float[] { offset, offset });
/* 160 */     shader.setUniformi("inTexture", new int[] { 0 });
/* 161 */     shader.setUniformi("check", new int[] { 0 });
/* 162 */     shader.setUniformf("halfpixel", new float[] { 1.0F / framebuffer.field_147621_c, 1.0F / framebuffer.field_147618_d });
/* 163 */     shader.setUniformf("iResolution", new float[] { framebuffer.field_147621_c, framebuffer.field_147618_d });
/* 164 */     ShaderUtil.drawQuads();
/* 165 */     shader.unload();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\blur\KawaseBloom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */