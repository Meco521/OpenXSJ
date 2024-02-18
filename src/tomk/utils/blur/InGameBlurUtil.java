/*     */ package tomk.utils.blur;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.ShaderEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
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
/*     */ 
/*     */ public class InGameBlurUtil
/*     */ {
/*  26 */   private static final Minecraft mc = Minecraft.func_71410_x();
/*  27 */   public static ShaderUtil gaussianProgram = new ShaderUtil("rise/shader/blur.frag");
/*  28 */   public static Framebuffer toBlurBuffer = new Framebuffer(1, 1, false);
/*  29 */   public static Framebuffer blurredBuffer = new Framebuffer(1, 1, false);
/*  30 */   private static Framebuffer blurPass2 = new Framebuffer(1, 1, false);
/*  31 */   private static Framebuffer blurPass3 = new Framebuffer(1, 1, false);
/*     */   
/*  33 */   public static ScaledResolution sr = new ScaledResolution(mc);
/*     */   
/*     */   public static void renderGaussianBlur(float radius, float compression, boolean callEvent, boolean backTrackBlurOnScreen) {
/*  36 */     sr = new ScaledResolution(mc);
/*  37 */     GlStateManager.func_179147_l();
/*  38 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  39 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     
/*  41 */     StencilUtil.initStencil();
/*  42 */     StencilUtil.bindWriteStencilBuffer();
/*     */     
/*  44 */     Retreat.eventManager.callEvent((Event)new ShaderEvent());
/*  45 */     BlurSettings.stuffToBlur(false);
/*  46 */     BlurSettings.stuffToBlur2(false);
/*  47 */     if (backTrackBlurOnScreen) {
/*  48 */       ShaderUtil.drawQuads(sr);
/*     */     }
/*     */     
/*  51 */     StencilUtil.bindReadStencilBuffer(1);
/*     */ 
/*     */     
/*  54 */     gaussianProgram.init();
/*  55 */     setupBlurUniforms(radius);
/*  56 */     blurredBuffer.func_147614_f();
/*  57 */     blurredBuffer.func_147610_a(false);
/*  58 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), compression, 0.0F);
/*  59 */     GL11.glBindTexture(3553, (mc.func_147110_a()).field_147617_g);
/*  60 */     ShaderUtil.drawQuads(sr);
/*  61 */     blurredBuffer.func_147609_e();
/*     */ 
/*     */     
/*  64 */     gaussianProgram.init();
/*  65 */     setupBlurUniforms(radius);
/*  66 */     mc.func_147110_a().func_147610_a(false);
/*  67 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), 0.0F, compression);
/*  68 */     GL11.glBindTexture(3553, blurredBuffer.field_147617_g);
/*  69 */     ShaderUtil.drawQuads(sr);
/*     */     
/*  71 */     gaussianProgram.unload();
/*  72 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */   public static void renderGaussianBlur2(float radius, float compression, boolean callEvent, boolean backTrackBlurOnScreen) {
/*  75 */     sr = new ScaledResolution(mc);
/*  76 */     GlStateManager.func_179147_l();
/*  77 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  78 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     
/*  80 */     StencilUtil.initStencil();
/*  81 */     StencilUtil.bindWriteStencilBuffer();
/*     */     
/*  83 */     int middleScreen = sr.func_78326_a() / 2;
/*  84 */     RenderUtils.drawRoundedRectfix((middleScreen - 91), (sr.func_78328_b() - 24), 182.0F, sr.func_78328_b(), 0.0F, -1);
/*     */     
/*  86 */     if (backTrackBlurOnScreen) {
/*  87 */       ShaderUtil.drawQuads(sr);
/*     */     }
/*     */     
/*  90 */     StencilUtil.bindReadStencilBuffer(1);
/*     */ 
/*     */     
/*  93 */     gaussianProgram.init();
/*  94 */     setupBlurUniforms(radius);
/*  95 */     blurredBuffer.func_147614_f();
/*  96 */     blurredBuffer.func_147610_a(false);
/*  97 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), compression, 0.0F);
/*  98 */     GL11.glBindTexture(3553, (mc.func_147110_a()).field_147617_g);
/*  99 */     ShaderUtil.drawQuads(sr);
/* 100 */     blurredBuffer.func_147609_e();
/*     */ 
/*     */     
/* 103 */     gaussianProgram.init();
/* 104 */     setupBlurUniforms(radius);
/* 105 */     mc.func_147110_a().func_147610_a(false);
/* 106 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), 0.0F, compression);
/* 107 */     GL11.glBindTexture(3553, blurredBuffer.field_147617_g);
/* 108 */     ShaderUtil.drawQuads(sr);
/*     */     
/* 110 */     gaussianProgram.unload();
/* 111 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */   
/*     */   private static void setupBlurUniforms(float radius) {
/* 115 */     GL20.glUniform1i(gaussianProgram.getUniform("texture"), 0);
/* 116 */     GL20.glUniform2f(gaussianProgram.getUniform("texelSize"), 1.0F / mc.field_71443_c, 1.0F / mc.field_71440_d);
/* 117 */     GL20.glUniform1f(gaussianProgram.getUniform("radius"), MathHelper.ceiling_float_int(2.0F * radius));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setupBuffers() {
/* 122 */     if (mc.field_71443_c != blurredBuffer.field_147621_c || mc.field_71440_d != blurredBuffer.field_147618_d) {
/* 123 */       blurredBuffer.func_147608_a();
/* 124 */       blurredBuffer = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */       
/* 126 */       blurPass2.func_147608_a();
/* 127 */       blurPass2 = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */       
/* 129 */       blurPass3.func_147608_a();
/* 130 */       blurPass3 = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */       
/* 132 */       toBlurBuffer.func_147608_a();
/* 133 */       toBlurBuffer = new Framebuffer(mc.field_71443_c, mc.field_71440_d, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void preBlur() {
/* 138 */     toBlurBuffer.func_147610_a(false);
/* 139 */     setupBuffers();
/* 140 */     GlStateManager.func_179147_l();
/* 141 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 142 */     StencilUtil.initStencil();
/* 143 */     StencilUtil.bindWriteStencilBuffer();
/*     */   }
/*     */   
/*     */   public static void postBlur(float radius, float compression) {
/* 147 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 149 */     StencilUtil.bindReadStencilBuffer(1);
/*     */     
/* 151 */     gaussianProgram.init();
/* 152 */     setupBlurUniforms(radius);
/* 153 */     blurredBuffer.func_147614_f();
/* 154 */     blurredBuffer.func_147610_a(false);
/* 155 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), compression, 0.0F);
/* 156 */     GL11.glBindTexture(3553, (mc.func_147110_a()).field_147617_g);
/* 157 */     ShaderUtil.drawQuads(sr);
/* 158 */     blurredBuffer.func_147609_e();
/*     */ 
/*     */     
/* 161 */     gaussianProgram.init();
/* 162 */     setupBlurUniforms(radius);
/* 163 */     mc.func_147110_a().func_147610_a(false);
/* 164 */     GL20.glUniform2f(gaussianProgram.getUniform("direction"), 0.0F, compression);
/* 165 */     GL11.glBindTexture(3553, blurredBuffer.field_147617_g);
/* 166 */     ShaderUtil.drawQuads(sr);
/*     */     
/* 168 */     gaussianProgram.unload();
/* 169 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void backTrackBlur(float radius, float compression) {
/* 174 */     setupBuffers();
/* 175 */     renderGaussianBlur(radius, compression, false, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\blur\InGameBlurUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */