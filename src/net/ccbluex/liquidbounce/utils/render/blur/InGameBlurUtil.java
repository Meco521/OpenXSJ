/*     */ package net.ccbluex.liquidbounce.utils.render.blur;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.ShaderEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.StencilUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.ShaderUtil;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InGameBlurUtil
/*     */ {
/*  27 */   private static final Minecraft mc = Minecraft.func_71410_x();
/*  28 */   public static ShaderUtil gaussianProgram = new ShaderUtil("rise/shader/blur.frag");
/*  29 */   public static Framebuffer toBlurBuffer = new Framebuffer(1, 1, false);
/*  30 */   public static Framebuffer blurredBuffer = new Framebuffer(1, 1, false);
/*  31 */   private static Framebuffer blurPass2 = new Framebuffer(1, 1, false);
/*  32 */   private static Framebuffer blurPass3 = new Framebuffer(1, 1, false);
/*     */   
/*  34 */   public static ScaledResolution sr = new ScaledResolution(mc);
/*     */   
/*     */   public static void renderGaussianBlur(float radius, float compression, boolean callEvent, boolean backTrackBlurOnScreen) {
/*  37 */     sr = new ScaledResolution(mc);
/*  38 */     GlStateManager.func_179147_l();
/*  39 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  40 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     
/*  42 */     StencilUtil.initStencil();
/*  43 */     StencilUtil.bindWriteStencilBuffer();
/*     */     
/*  45 */     Retreat.eventManager.callEvent((Event)new ShaderEvent());
/*  46 */     BlurSettings.stuffToBlur(false);
/*  47 */     BlurSettings.stuffToBlur2(false);
/*  48 */     if (backTrackBlurOnScreen) {
/*  49 */       ShaderUtil.drawQuads(sr);
/*     */     }
/*     */     
/*  52 */     StencilUtil.bindReadStencilBuffer(1);
/*     */ 
/*     */     
/*  55 */     gaussianProgram.init();
/*  56 */     setupBlurUniforms(radius);
/*  57 */     blurredBuffer.func_147614_f();
/*  58 */     blurredBuffer.func_147610_a(false);
/*  59 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), compression, 0.0F);
/*  60 */     GL11.glBindTexture(3553, (mc.func_147110_a()).field_147617_g);
/*  61 */     ShaderUtil.drawQuads(sr);
/*  62 */     blurredBuffer.func_147609_e();
/*     */ 
/*     */     
/*  65 */     gaussianProgram.init();
/*  66 */     setupBlurUniforms(radius);
/*  67 */     mc.func_147110_a().func_147610_a(false);
/*  68 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), 0.0F, compression);
/*  69 */     GL11.glBindTexture(3553, blurredBuffer.field_147617_g);
/*  70 */     ShaderUtil.drawQuads(sr);
/*     */     
/*  72 */     gaussianProgram.unload();
/*  73 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */   public static void renderGaussianBlur2(float radius, float compression, boolean callEvent, boolean backTrackBlurOnScreen) {
/*  76 */     sr = new ScaledResolution(mc);
/*  77 */     GlStateManager.func_179147_l();
/*  78 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  79 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     
/*  81 */     StencilUtil.initStencil();
/*  82 */     StencilUtil.bindWriteStencilBuffer();
/*     */     
/*  84 */     int middleScreen = sr.func_78326_a() / 2;
/*  85 */     RenderUtils.drawRoundedRectfix((middleScreen - 91), (sr.func_78328_b() - 24), 182.0F, sr.func_78328_b(), 0.0F, -1);
/*     */     
/*  87 */     if (backTrackBlurOnScreen) {
/*  88 */       ShaderUtil.drawQuads(sr);
/*     */     }
/*     */     
/*  91 */     StencilUtil.bindReadStencilBuffer(1);
/*     */ 
/*     */     
/*  94 */     gaussianProgram.init();
/*  95 */     setupBlurUniforms(radius);
/*  96 */     blurredBuffer.func_147614_f();
/*  97 */     blurredBuffer.func_147610_a(false);
/*  98 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), compression, 0.0F);
/*  99 */     GL11.glBindTexture(3553, (mc.func_147110_a()).field_147617_g);
/* 100 */     ShaderUtil.drawQuads(sr);
/* 101 */     blurredBuffer.func_147609_e();
/*     */ 
/*     */     
/* 104 */     gaussianProgram.init();
/* 105 */     setupBlurUniforms(radius);
/* 106 */     mc.func_147110_a().func_147610_a(false);
/* 107 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), 0.0F, compression);
/* 108 */     GL11.glBindTexture(3553, blurredBuffer.field_147617_g);
/* 109 */     ShaderUtil.drawQuads(sr);
/*     */     
/* 111 */     gaussianProgram.unload();
/* 112 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */   
/*     */   private static void setupBlurUniforms(float radius) {
/* 116 */     GL20.glUniform1i(gaussianProgram.getUniform("texture"), 0);
/* 117 */     GL20.glUniform2f(gaussianProgram.getUniform("texelSize"), 1.0F / mc.field_71443_c, 1.0F / mc.field_71440_d);
/* 118 */     GL20.glUniform1f(gaussianProgram.getUniform("radius"), MathHelper.ceiling_float_int(2.0F * radius));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setupBuffers() {
/* 123 */     if (mc.field_71443_c != blurredBuffer.field_147621_c || mc.field_71440_d != blurredBuffer.field_147618_d) {
/* 124 */       blurredBuffer.func_147608_a();
/* 125 */       blurredBuffer = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */       
/* 127 */       blurPass2.func_147608_a();
/* 128 */       blurPass2 = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */       
/* 130 */       blurPass3.func_147608_a();
/* 131 */       blurPass3 = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */       
/* 133 */       toBlurBuffer.func_147608_a();
/* 134 */       toBlurBuffer = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void preBlur() {
/* 139 */     toBlurBuffer.func_147610_a(false);
/* 140 */     setupBuffers();
/* 141 */     GlStateManager.func_179147_l();
/* 142 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 143 */     StencilUtil.initStencil();
/* 144 */     StencilUtil.bindWriteStencilBuffer();
/*     */   }
/*     */   
/*     */   public static void postBlur(float radius, float compression) {
/* 148 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 150 */     StencilUtil.bindReadStencilBuffer(1);
/*     */     
/* 152 */     gaussianProgram.init();
/* 153 */     setupBlurUniforms(radius);
/* 154 */     blurredBuffer.func_147614_f();
/* 155 */     blurredBuffer.func_147610_a(false);
/* 156 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), compression, 0.0F);
/* 157 */     GL11.glBindTexture(3553, (mc.func_147110_a()).field_147617_g);
/* 158 */     ShaderUtil.drawQuads(sr);
/* 159 */     blurredBuffer.func_147609_e();
/*     */ 
/*     */     
/* 162 */     gaussianProgram.init();
/* 163 */     setupBlurUniforms(radius);
/* 164 */     mc.func_147110_a().func_147610_a(false);
/* 165 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), 0.0F, compression);
/* 166 */     GL11.glBindTexture(3553, blurredBuffer.field_147617_g);
/* 167 */     ShaderUtil.drawQuads(sr);
/*     */     
/* 169 */     gaussianProgram.unload();
/* 170 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void backTrackBlur(float radius, float compression) {
/* 175 */     setupBuffers();
/* 176 */     renderGaussianBlur(radius, compression, false, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\blur\InGameBlurUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */