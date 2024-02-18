/*     */ package tomk;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.client.shader.Shader;
/*     */ import net.minecraft.client.shader.ShaderGroup;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\007\n\002\b\007\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\026\020\024\032\0020\0252\006\020\026\032\0020\0272\006\020\030\032\0020\013J*\020\031\032\0020\0252\006\020\030\032\0020\0132\f\020\032\032\b\022\004\022\0020\0250\0332\f\020\034\032\b\022\004\022\0020\0250\033R\016\020\003\032\0020\004X\004¢\006\002\n\000R\020\020\005\032\004\030\0010\006X\016¢\006\002\n\000R\020\020\007\032\004\030\0010\006X\016¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\tX\016¢\006\002\n\000R\034\020\r\032\004\030\0010\006X\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\020\020\022\032\004\030\0010\023X\016¢\006\002\n\000¨\006\035"}, d2 = {"Ltomk/ShadowUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "blurDirectory", "Lnet/minecraft/util/ResourceLocation;", "frameBuffer", "Lnet/minecraft/client/shader/Framebuffer;", "initFramebuffer", "lastHeight", "", "lastStrength", "", "lastWidth", "resultBuffer", "getResultBuffer", "()Lnet/minecraft/client/shader/Framebuffer;", "setResultBuffer", "(Lnet/minecraft/client/shader/Framebuffer;)V", "shaderGroup", "Lnet/minecraft/client/shader/ShaderGroup;", "initShaderIfRequired", "", "sc", "Lnet/minecraft/client/gui/ScaledResolution;", "strength", "shadow", "drawMethod", "Lkotlin/Function0;", "cutMethod", "XSJClient"})
/*     */ public final class ShadowUtils extends MinecraftInstance {
/*     */   private static Framebuffer initFramebuffer;
/*     */   private static Framebuffer frameBuffer;
/*     */   @Nullable
/*     */   private static Framebuffer resultBuffer;
/*     */   
/*     */   static {
/*  26 */     ShadowUtils shadowUtils = new ShadowUtils();
/*     */   } private static ShaderGroup shaderGroup; private static int lastWidth; private static int lastHeight; private static float lastStrength;
/*     */   @Nullable
/*     */   public final Framebuffer getResultBuffer() {
/*  30 */     return resultBuffer; } public final void setResultBuffer(@Nullable Framebuffer <set-?>) { resultBuffer = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private static final ResourceLocation blurDirectory = new ResourceLocation("shaders/shadow.json");
/*     */   public static final ShadowUtils INSTANCE;
/*     */   
/*     */   public final void initShaderIfRequired(@NotNull ScaledResolution sc, float strength) throws IOException {
/*  40 */     Intrinsics.checkParameterIsNotNull(sc, "sc"); int width = sc.func_78326_a();
/*  41 */     int height = sc.func_78328_b();
/*  42 */     int factor = sc.func_78325_e();
/*     */     
/*  44 */     if (lastWidth != width || lastHeight != height || initFramebuffer == null || frameBuffer == null || shaderGroup == null) {
/*  45 */       initFramebuffer = new Framebuffer(width * factor, height * factor, true);
/*  46 */       if (initFramebuffer == null) Intrinsics.throwNpe();  initFramebuffer.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
/*  47 */       if (initFramebuffer == null) Intrinsics.throwNpe();  initFramebuffer.func_147607_a(9729);
/*  48 */       Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); if (initFramebuffer == null) Intrinsics.throwNpe();  shaderGroup = new ShaderGroup(Minecraft.func_71410_x().func_110434_K(), Minecraft.func_71410_x().func_110442_L(), initFramebuffer, blurDirectory);
/*  49 */       if (shaderGroup == null) Intrinsics.throwNpe();  shaderGroup.func_148026_a(width * factor, height * factor);
/*  50 */       if (shaderGroup == null) Intrinsics.throwNpe();  frameBuffer = shaderGroup.field_148035_a;
/*  51 */       if (shaderGroup == null) Intrinsics.throwNpe();  resultBuffer = shaderGroup.func_177066_a("braindead");
/*     */       
/*  53 */       lastWidth = width;
/*  54 */       lastHeight = height;
/*  55 */       lastStrength = strength;
/*  56 */       for (byte b1 = 0, b2 = 1; b1 <= b2; b1++) {
/*  57 */         if (shaderGroup == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(shaderGroup.field_148031_d.get(b1), "shaderGroup!!.listShaders[i]"); if (((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("Radius") == null) Intrinsics.throwNpe();  ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("Radius").func_148090_a(strength);
/*     */       } 
/*  59 */     }  if (lastStrength != strength) {
/*  60 */       lastStrength = strength; int i; byte b;
/*  61 */       for (i = 0, b = 1; i <= b; i++) {
/*  62 */         if (shaderGroup == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(shaderGroup.field_148031_d.get(i), "shaderGroup!!.listShaders[i]"); if (((Shader)shaderGroup.field_148031_d.get(i)).func_148043_c().func_147991_a("Radius") == null) Intrinsics.throwNpe();  ((Shader)shaderGroup.field_148031_d.get(i)).func_148043_c().func_147991_a("Radius").func_148090_a(strength);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public final void shadow(float strength, @NotNull Function0 drawMethod, @NotNull Function0 cutMethod) {
/*  67 */     Intrinsics.checkParameterIsNotNull(drawMethod, "drawMethod"); Intrinsics.checkParameterIsNotNull(cutMethod, "cutMethod"); if (!OpenGlHelper.func_148822_b())
/*     */       return; 
/*  69 */     ScaledResolution sc = new ScaledResolution(Minecraft.func_71410_x());
/*  70 */     int width = sc.func_78326_a();
/*  71 */     int height = sc.func_78328_b();
/*  72 */     initShaderIfRequired(sc, strength);
/*     */     
/*  74 */     if (initFramebuffer != null) {
/*  75 */       if (resultBuffer != null) {
/*  76 */         if (frameBuffer != null) {
/*     */           
/*  78 */           Minecraft.func_71410_x().func_147110_a().func_147610_a(true);
/*  79 */           if (initFramebuffer == null) Intrinsics.throwNpe();  initFramebuffer.func_147614_f();
/*  80 */           if (resultBuffer == null) Intrinsics.throwNpe();  resultBuffer.func_147614_f();
/*  81 */           if (initFramebuffer == null) Intrinsics.throwNpe();  initFramebuffer.func_147610_a(true);
/*  82 */           drawMethod.invoke();
/*  83 */           if (frameBuffer == null) Intrinsics.throwNpe();  frameBuffer.func_147610_a(true);
/*  84 */           if (shaderGroup == null) Intrinsics.throwNpe();  shaderGroup.func_148018_a((Minecraft.func_71410_x()).field_71428_T.field_194147_b);
/*  85 */           Minecraft.func_71410_x().func_147110_a().func_147610_a(true);
/*     */           
/*  87 */           if (resultBuffer == null) Intrinsics.throwNpe();  if (resultBuffer == null) Intrinsics.throwNpe();  double fr_width = resultBuffer.field_147621_c / resultBuffer.field_147622_a;
/*  88 */           if (resultBuffer == null) Intrinsics.throwNpe();  if (resultBuffer == null) Intrinsics.throwNpe();  double fr_height = resultBuffer.field_147618_d / resultBuffer.field_147620_b;
/*     */           
/*  90 */           Tessellator tessellator = Tessellator.func_178181_a();
/*  91 */           Intrinsics.checkExpressionValueIsNotNull(tessellator, "tessellator"); BufferBuilder worldrenderer = tessellator.func_178180_c();
/*     */           
/*  93 */           GL11.glPushMatrix();
/*  94 */           GlStateManager.func_179140_f();
/*  95 */           GlStateManager.func_179118_c();
/*  96 */           GlStateManager.func_179098_w();
/*  97 */           GlStateManager.func_179097_i();
/*  98 */           GlStateManager.func_179132_a(false);
/*  99 */           GlStateManager.func_179135_a(true, true, true, true);
/*     */           
/* 101 */           Stencil.write(false);
/* 102 */           cutMethod.invoke();
/* 103 */           Stencil.erase(false);
/*     */           
/* 105 */           GlStateManager.func_179147_l();
/* 106 */           GlStateManager.func_179112_b(770, 771);
/* 107 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */           
/* 109 */           if (resultBuffer == null) Intrinsics.throwNpe();  resultBuffer.func_147612_c();
/* 110 */           GL11.glTexParameteri(3553, 10242, 33071);
/* 111 */           GL11.glTexParameteri(3553, 10243, 33071);
/*     */           
/* 113 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 114 */           worldrenderer.func_181662_b(0.0D, height, 0.0D).func_187315_a(0.0D, 0.0D).func_181669_b(255, 255, 255, 255).func_181675_d();
/* 115 */           worldrenderer.func_181662_b(width, height, 0.0D).func_187315_a(fr_width, 0.0D).func_181669_b(255, 255, 255, 255).func_181675_d();
/* 116 */           worldrenderer.func_181662_b(width, 0.0D, 0.0D).func_187315_a(fr_width, fr_height).func_181669_b(255, 255, 255, 255).func_181675_d();
/* 117 */           worldrenderer.func_181662_b(0.0D, 0.0D, 0.0D).func_187315_a(0.0D, fr_height).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */           
/* 119 */           tessellator.func_78381_a();
/* 120 */           if (resultBuffer == null) Intrinsics.throwNpe();  resultBuffer.func_147606_d();
/*     */           
/* 122 */           GlStateManager.func_179084_k();
/* 123 */           GlStateManager.func_179141_d();
/* 124 */           GlStateManager.func_179126_j();
/* 125 */           GlStateManager.func_179132_a(true);
/*     */           
/* 127 */           Stencil.dispose();
/* 128 */           GL11.glPopMatrix();
/*     */           
/* 130 */           GlStateManager.func_179117_G();
/* 131 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 132 */           GlStateManager.func_179147_l();
/* 133 */           GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */           return;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\ShadowUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */