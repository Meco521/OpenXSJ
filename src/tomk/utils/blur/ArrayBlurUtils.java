/*     */ package tomk.utils.blur;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.ui.Stencil;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.client.shader.Shader;
/*     */ import net.minecraft.client.shader.ShaderGroup;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\000\n\002\020\007\n\002\b\b\n\002\030\002\n\000\n\002\020\002\n\002\b\006\n\002\020\013\n\000\n\002\030\002\n\002\b\022\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002JF\020\024\032\0020\0252\006\020\026\032\0020\n2\006\020\027\032\0020\n2\006\020\030\032\0020\n2\006\020\031\032\0020\n2\006\020\032\032\0020\n2\006\020\033\032\0020\0342\f\020\035\032\b\022\004\022\0020\0250\036H\007J0\020\037\032\0020\0252\006\020 \032\0020\n2\006\020!\032\0020\n2\006\020\"\032\0020\n2\006\020#\032\0020\n2\006\020\032\032\0020\nH\007J8\020$\032\0020\0252\006\020 \032\0020\n2\006\020!\032\0020\n2\006\020\"\032\0020\n2\006\020#\032\0020\n2\006\020%\032\0020\n2\006\020\032\032\0020\nH\007JJ\020&\032\0020\0252\006\020'\032\0020\n2\006\020 \032\0020\n2\006\020!\032\0020\n2\006\020(\032\0020\n2\006\020)\032\0020\n2\006\020*\032\0020\n2\006\020+\032\0020\n2\b\b\002\020,\032\0020\034H\002J\b\020-\032\0020\025H\002J\036\020.\032\0020\0342\006\020/\032\0020\b2\006\020*\032\0020\b2\006\020+\032\0020\bR\026\020\003\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000R\026\020\006\032\n \005*\004\030\0010\0040\004X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\bX\016¢\006\002\n\000R\016\020\f\032\0020\nX\016¢\006\002\n\000R\016\020\r\032\0020\nX\016¢\006\002\n\000R\016\020\016\032\0020\bX\016¢\006\002\n\000R\016\020\017\032\0020\bX\016¢\006\002\n\000R\016\020\020\032\0020\nX\016¢\006\002\n\000R\016\020\021\032\0020\nX\016¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000¨\0060"}, d2 = {"Ltomk/utils/blur/ArrayBlurUtils;", "", "()V", "framebuffer", "Lnet/minecraft/client/shader/Framebuffer;", "kotlin.jvm.PlatformType", "frbuffer", "lastFactor", "", "lastH", "", "lastHeight", "lastStrength", "lastW", "lastWeight", "lastWidth", "lastX", "lastY", "shaderGroup", "Lnet/minecraft/client/shader/ShaderGroup;", "blur", "", "posX", "posY", "posXEnd", "posYEnd", "blurStrength", "displayClipMask", "", "triggerMethod", "Lkotlin/Function0;", "blurArea", "x", "y", "x2", "y2", "blurAreaRounded", "rad", "setValues", "strength", "w", "h", "width", "height", "force", "setupFramebuffers", "sizeHasChanged", "scaleFactor", "XSJClient"})
/*     */ public final class ArrayBlurUtils {
/*     */   static {
/*  22 */     ArrayBlurUtils arrayBlurUtils = new ArrayBlurUtils();
/*     */     
/*  24 */     Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()");
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class ArrayBlurUtils$blurArea$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 143 */       GlStateManager.func_179147_l();
/* 144 */       GlStateManager.func_179090_x();
/* 145 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 146 */       RenderUtils.quickDrawRect(this.$x, this.$y, this.$x2, this.$y2);
/* 147 */       GlStateManager.func_179098_w();
/* 148 */       GlStateManager.func_179084_k();
/*     */     } ArrayBlurUtils$blurArea$1(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 153 */   static final class ArrayBlurUtils$blurAreaRounded$1 extends Lambda implements Function0<Unit> { public final void invoke() { GlStateManager.func_179147_l();
/* 154 */       GlStateManager.func_179090_x();
/* 155 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 156 */       RenderUtils.fastRoundedRect(this.$x, this.$y, this.$x2, this.$y2, this.$rad);
/* 157 */       GlStateManager.func_179098_w();
/* 158 */       GlStateManager.func_179084_k(); } ArrayBlurUtils$blurAreaRounded$1(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5) {
/*     */       super(0);
/*     */     } } public final boolean sizeHasChanged(int scaleFactor, int width, int height) {
/* 161 */     return (lastFactor != scaleFactor || lastWidth != width || lastHeight != height);
/*     */   }
/*     */   
/*     */   private static final ShaderGroup shaderGroup = new ShaderGroup(Minecraft.func_71410_x().func_110434_K(), Minecraft.func_71410_x().func_110442_L(), Minecraft.func_71410_x().func_147110_a(), new ResourceLocation("shaders/post/blurarea.json"));
/*     */   private static final Framebuffer framebuffer = shaderGroup.field_148035_a;
/*     */   private static final Framebuffer frbuffer = shaderGroup.func_177066_a("result");
/*     */   private static int lastFactor;
/*     */   private static int lastWidth;
/*     */   private static int lastHeight;
/*     */   private static int lastWeight;
/*     */   private static float lastX;
/*     */   private static float lastY;
/*     */   private static float lastW;
/*     */   private static float lastH;
/*     */   private static float lastStrength = 5.0F;
/*     */   public static final ArrayBlurUtils INSTANCE;
/*     */   
/*     */   private final void setupFramebuffers() {
/*     */     try {
/*     */       shaderGroup.func_148026_a((Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
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
/*     */       Intrinsics.checkExpressionValueIsNotNull(shaderGroup.field_148031_d.get(b1), "shaderGroup.listShaders[i]");
/*     */       if (((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("Radius") != null) {
/*     */         ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("Radius").func_148090_a(strength);
/*     */       } else {
/*     */         ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("Radius");
/*     */       } 
/*     */       Intrinsics.checkExpressionValueIsNotNull(shaderGroup.field_148031_d.get(b1), "shaderGroup.listShaders[i]");
/*     */       if (((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("BlurXY") != null) {
/*     */         ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("BlurXY").func_148087_a(x, height - y - h);
/*     */       } else {
/*     */         ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("BlurXY");
/*     */       } 
/*     */       Intrinsics.checkExpressionValueIsNotNull(shaderGroup.field_148031_d.get(b1), "shaderGroup.listShaders[i]");
/*     */       if (((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("BlurCoord") != null) {
/*     */         ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("BlurCoord").func_148087_a(w, h);
/*     */       } else {
/*     */         ((Shader)shaderGroup.field_148031_d.get(b1)).func_148043_c().func_147991_a("BlurCoord");
/*     */       } 
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
/*     */     ScaledResolution sc = new ScaledResolution(Minecraft.func_71410_x());
/*     */     int scaleFactor = sc.func_78325_e();
/*     */     int width = sc.func_78326_a();
/*     */     int height = sc.func_78328_b();
/*     */     if (INSTANCE.sizeHasChanged(scaleFactor, width, height)) {
/*     */       INSTANCE.setupFramebuffers();
/*     */       INSTANCE.setValues(blurStrength, x, y, x2 - x, y2 - y, width, height, true);
/*     */     } 
/*     */     lastFactor = scaleFactor;
/*     */     lastWidth = width;
/*     */     lastHeight = height;
/*     */     setValues$default(INSTANCE, blurStrength, x, y, x2 - x, y2 - y, width, height, false, 128, null);
/*     */     framebuffer.func_147610_a(true);
/*     */     shaderGroup.func_148018_a((Minecraft.func_71410_x()).field_71428_T.field_194147_b);
/*     */     Minecraft.func_71410_x().func_147110_a().func_147610_a(true);
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
/*     */     BufferBuilder worldrenderer = tessellator.func_178180_c();
/*     */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */     worldrenderer.func_181662_b(0.0D, height, 0.0D).func_187315_a(0.0D, 0.0D).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     worldrenderer.func_181662_b(width, height, 0.0D).func_187315_a(f2, 0.0D).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     worldrenderer.func_181662_b(width, 0.0D, 0.0D).func_187315_a(f2, f3).func_181669_b(255, 255, 255, 255).func_181675_d();
/*     */     worldrenderer.func_181662_b(0.0D, 0.0D, 0.0D).func_187315_a(0.0D, f3).func_181669_b(255, 255, 255, 255).func_181675_d();
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
/*     */     blur(x, y, x2, y2, blurStrength, false, new ArrayBlurUtils$blurArea$1(x, y, x2, y2));
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final void blurAreaRounded(float x, float y, float x2, float y2, float rad, float blurStrength) {
/*     */     blur(x, y, x2, y2, blurStrength, false, new ArrayBlurUtils$blurAreaRounded$1(x, y, x2, y2, rad));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\blur\ArrayBlurUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */