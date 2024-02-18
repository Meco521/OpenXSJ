/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import tomk.ui.Stencil;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\000\n\002\020\007\n\002\b\007\n\002\030\002\n\000\n\002\020\002\n\002\b\006\n\002\020\013\n\000\n\002\030\002\n\002\b\022\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002JF\020\023\032\0020\0242\006\020\025\032\0020\n2\006\020\026\032\0020\n2\006\020\027\032\0020\n2\006\020\030\032\0020\n2\006\020\031\032\0020\n2\006\020\032\032\0020\0332\f\020\034\032\b\022\004\022\0020\0240\035H\007J0\020\036\032\0020\0242\006\020\037\032\0020\n2\006\020 \032\0020\n2\006\020!\032\0020\n2\006\020\"\032\0020\n2\006\020\031\032\0020\nH\007J8\020#\032\0020\0242\006\020\037\032\0020\n2\006\020 \032\0020\n2\006\020!\032\0020\n2\006\020\"\032\0020\n2\006\020$\032\0020\n2\006\020\031\032\0020\nH\007JJ\020%\032\0020\0242\006\020&\032\0020\n2\006\020\037\032\0020\n2\006\020 \032\0020\n2\006\020'\032\0020\n2\006\020(\032\0020\n2\006\020)\032\0020\n2\006\020*\032\0020\n2\b\b\002\020+\032\0020\033H\002J\b\020,\032\0020\024H\002J\036\020-\032\0020\0332\006\020.\032\0020\b2\006\020)\032\0020\b2\006\020*\032\0020\bR\026\020\003\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000R\026\020\006\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\bX\016¢\006\002\n\000R\016\020\f\032\0020\nX\016¢\006\002\n\000R\016\020\r\032\0020\nX\016¢\006\002\n\000R\016\020\016\032\0020\bX\016¢\006\002\n\000R\016\020\017\032\0020\nX\016¢\006\002\n\000R\016\020\020\032\0020\nX\016¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000¨\006/"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/BlurUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "framebuffer", "Lnet/minecraft/client/shader/Framebuffer;", "kotlin.jvm.PlatformType", "frbuffer", "lastFactor", "", "lastH", "", "lastHeight", "lastStrength", "lastW", "lastWidth", "lastX", "lastY", "shaderGroup", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ShaderGroup;", "blur", "", "posX", "posY", "posXEnd", "posYEnd", "blurStrength", "displayClipMask", "", "triggerMethod", "Lkotlin/Function0;", "blurArea", "x", "y", "x2", "y2", "blurAreaRounded", "rad", "setValues", "strength", "w", "h", "width", "height", "force", "setupFramebuffers", "sizeHasChanged", "scaleFactor", "XSJClient"})
/*     */ public final class BlurUtils extends MinecraftInstance {
/*     */   static {
/*  19 */     BlurUtils blurUtils = new BlurUtils();
/*     */     
/*  21 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class BlurUtils$blurArea$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 141 */       GlStateManager.func_179147_l();
/* 142 */       GlStateManager.func_179090_x();
/* 143 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 144 */       RenderUtils.quickDrawRect(this.$x, this.$y, this.$x2, this.$y2);
/* 145 */       GlStateManager.func_179098_w();
/* 146 */       GlStateManager.func_179084_k();
/*     */     } BlurUtils$blurArea$1(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 151 */   static final class BlurUtils$blurAreaRounded$1 extends Lambda implements Function0<Unit> { public final void invoke() { GlStateManager.func_179147_l();
/* 152 */       GlStateManager.func_179090_x();
/* 153 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 154 */       RenderUtils.fastRoundedRect(this.$x, this.$y, this.$x2, this.$y2, this.$rad);
/* 155 */       GlStateManager.func_179098_w();
/* 156 */       GlStateManager.func_179084_k(); } BlurUtils$blurAreaRounded$1(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5) {
/*     */       super(0);
/*     */     } } private static final ShaderGroup shaderGroup = new ShaderGroup(MinecraftInstance.mc2.func_110434_K(), MinecraftInstance.mc2.func_110442_L(), MinecraftInstance.mc2.func_147110_a(), new ResourceLocation("shaders/post/blurArea.json")); public final boolean sizeHasChanged(int scaleFactor, int width, int height) {
/* 159 */     return (lastFactor != scaleFactor || lastWidth != width || lastHeight != height);
/*     */   }
/*     */   
/*     */   private static final Framebuffer framebuffer = shaderGroup.mainFramebuffer;
/*     */   private static final Framebuffer frbuffer = shaderGroup.getFramebufferRaw("result");
/*     */   private static int lastFactor;
/*     */   private static int lastWidth;
/*     */   private static int lastHeight;
/*     */   private static float lastX;
/*     */   private static float lastY;
/*     */   private static float lastW;
/*     */   private static float lastH;
/*     */   private static float lastStrength = 5.0F;
/*     */   public static final BlurUtils INSTANCE;
/*     */   
/*     */   private final void setupFramebuffers() {
/*     */     try {
/*     */       shaderGroup.createBindFramebuffers(MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight());
/*     */     } catch (Exception e) {
/*     */       ClientUtils.getLogger().error("Exception caught while setting up shader group", e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private final void setValues(float strength, float x, float y, float w, float h, float width, float height, boolean force) {
/*     */     if (!force && strength == lastStrength && lastX == x && lastY == y && lastW == w && lastH == h)
/*     */       return; 
/*     */     lastStrength = strength;
/*     */     lastX = x;
/*     */     lastY = y;
/*     */     lastW = w;
/*     */     lastH = h;
/*     */     for (byte b1 = 0, b2 = 1; b1 <= b2; b1++) {
/*     */       if (shaderGroup.listShaders.get(b1) == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.shader.Shader"); 
/*     */       if (shaderGroup.listShaders.get(b1).func_148043_c().func_147991_a("Radius") == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       shaderGroup.listShaders.get(b1).func_148043_c().func_147991_a("Radius").func_148090_a(strength);
/*     */       if (shaderGroup.listShaders.get(b1) == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.shader.Shader"); 
/*     */       if (shaderGroup.listShaders.get(b1).func_148043_c().func_147991_a("BlurXY") == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       shaderGroup.listShaders.get(b1).func_148043_c().func_147991_a("BlurXY").func_148087_a(x, height - y - h);
/*     */       if (shaderGroup.listShaders.get(b1) == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.shader.Shader"); 
/*     */       if (shaderGroup.listShaders.get(b1).func_148043_c().func_147991_a("BlurCoord") == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       shaderGroup.listShaders.get(b1).func_148043_c().func_147991_a("BlurCoord").func_148087_a(w, h);
/*     */     } 
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final void blur(float posX, float posY, float posXEnd, float posYEnd, float blurStrength, boolean displayClipMask, @NotNull Function0 triggerMethod) {
/*     */     Intrinsics.checkParameterIsNotNull(triggerMethod, "triggerMethod");
/*     */     if (!OpenGlHelper.func_148822_b())
/*     */       return; 
/*     */     float x = posX;
/*     */     float y = posY;
/*     */     float x2 = posXEnd;
/*     */     float y2 = posYEnd;
/*     */     if (x > x2) {
/*     */       float z = x;
/*     */       x = x2;
/*     */       x2 = z;
/*     */     } 
/*     */     if (y > y2) {
/*     */       float z = y;
/*     */       y = y2;
/*     */       y2 = y;
/*     */     } 
/*     */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");
/*     */     IScaledResolution sc = MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc);
/*     */     int scaleFactor = sc.getScaleFactor();
/*     */     int width = sc.getScaledWidth();
/*     */     int height = sc.getScaledHeight();
/*     */     if (INSTANCE.sizeHasChanged(scaleFactor, width, height)) {
/*     */       INSTANCE.setupFramebuffers();
/*     */       INSTANCE.setValues(blurStrength, x, y, x2 - x, y2 - y, width, height, true);
/*     */     } 
/*     */     lastFactor = scaleFactor;
/*     */     lastWidth = width;
/*     */     lastHeight = height;
/*     */     setValues$default(INSTANCE, blurStrength, x, y, x2 - x, y2 - y, width, height, false, 128, null);
/*     */     framebuffer.func_147610_a(true);
/*     */     shaderGroup.loadShaderGroup(MinecraftInstance.mc.getTimer().getRenderPartialTicks());
/*     */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */     MinecraftInstance.mc2.func_147110_a().func_147610_a(true);
/*     */     Stencil.write(displayClipMask);
/*     */     triggerMethod.invoke();
/*     */     Stencil.erase(true);
/*     */     GlStateManager.func_179147_l();
/*     */     GlStateManager.func_179112_b(770, 771);
/*     */     GlStateManager.func_179094_E();
/*     */     GlStateManager.func_179135_a(true, true, true, false);
/*     */     GlStateManager.func_179097_i();
/*     */     GlStateManager.func_179132_a(false);
/*     */     GlStateManager.func_179098_w();
/*     */     GlStateManager.func_179140_f();
/*     */     GlStateManager.func_179118_c();
/*     */     frbuffer.func_147612_c();
/*     */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     double f2 = frbuffer.field_147621_c / frbuffer.field_147622_a;
/*     */     double f3 = frbuffer.field_147618_d / frbuffer.field_147620_b;
/*     */     Tessellator tessellator = Tessellator.func_178181_a();
/*     */     Intrinsics.checkExpressionValueIsNotNull(tessellator, "tessellator");
/*     */     BufferBuilder bufferbuilder = tessellator.func_178180_c();
/*     */     bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */     bufferbuilder.func_181662_b(0.0D, height, 0.0D).func_187315_a(0.0D, 0.0D).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     bufferbuilder.func_181662_b(width, height, 0.0D).func_187315_a(f2, 0.0D).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     bufferbuilder.func_181662_b(width, 0.0D, 0.0D).func_187315_a(f2, f3).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     bufferbuilder.func_181662_b(0.0D, 0.0D, 0.0D).func_187315_a(0.0D, f3).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     tessellator.func_78381_a();
/*     */     frbuffer.func_147606_d();
/*     */     GlStateManager.func_179126_j();
/*     */     GlStateManager.func_179132_a(true);
/*     */     GlStateManager.func_179135_a(true, true, true, true);
/*     */     GlStateManager.func_179121_F();
/*     */     GlStateManager.func_179084_k();
/*     */     Stencil.dispose();
/*     */     GlStateManager.func_179141_d();
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final void blurArea(float x, float y, float x2, float y2, float blurStrength) {
/*     */     blur(x, y, x2, y2, blurStrength, false, new BlurUtils$blurArea$1(x, y, x2, y2));
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final void blurAreaRounded(float x, float y, float x2, float y2, float rad, float blurStrength) {
/*     */     blur(x, y, x2, y2, blurStrength, false, new BlurUtils$blurAreaRounded$1(x, y, x2, y2, rad));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\BlurUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */