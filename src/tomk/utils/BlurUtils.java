/*    */ package tomk.utils;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.shader.Shader;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\002\n\000\n\002\020\007\n\002\b\006\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J.\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0162\006\020\020\032\0020\0162\006\020\021\032\0020\0162\006\020\022\032\0020\016J\b\020\023\032\0020\fH\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X.¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\bX\016¢\006\002\n\000R\016\020\n\032\0020\bX\016¢\006\002\n\000¨\006\024"}, d2 = {"Ltomk/utils/BlurUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "blurShader", "Lnet/minecraft/client/shader/ShaderGroup;", "buffer", "Lnet/minecraft/client/shader/Framebuffer;", "lastScale", "", "lastScaleHeight", "lastScaleWidth", "draw", "", "x", "", "y", "width", "height", "radius", "reinitShader", "XSJClient"})
/*    */ public final class BlurUtils extends MinecraftInstance {
/* 11 */   static { BlurUtils blurUtils = new BlurUtils();
/* 12 */     Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); } private static final ShaderGroup blurShader = new ShaderGroup(Minecraft.func_71410_x().func_110434_K(), Minecraft.func_71410_x().func_110442_L(), Minecraft.func_71410_x().func_147110_a(), new ResourceLocation("shaders/post/blurarea.json"));
/*    */   
/*    */   private static Framebuffer buffer;
/*    */   private static int lastScale;
/*    */   private static int lastScaleWidth;
/*    */   private static int lastScaleHeight;
/*    */   public static final BlurUtils INSTANCE;
/*    */   
/*    */   private final void reinitShader() {
/* 21 */     blurShader.func_148026_a(MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight());
/* 22 */     buffer = new Framebuffer(MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight(), true);
/* 23 */     if (buffer == null) Intrinsics.throwUninitializedPropertyAccessException("buffer");  buffer.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public final void draw(float x, float y, float width, float height, float radius) {
/* 27 */     ScaledResolution scale = new ScaledResolution(MinecraftInstance.mc2);
/* 28 */     int factor = scale.func_78325_e();
/* 29 */     int factor2 = scale.func_78326_a();
/* 30 */     int factor3 = scale.func_78328_b();
/* 31 */     if (lastScale != factor || lastScaleWidth != factor2 || lastScaleHeight != factor3) {
/* 32 */       reinitShader();
/*    */     }
/* 34 */     lastScale = factor;
/* 35 */     lastScaleWidth = factor2;
/* 36 */     lastScaleHeight = factor3;
/* 37 */     Intrinsics.checkExpressionValueIsNotNull(blurShader.field_148031_d.get(0), "blurShader.listShaders[0]"); if (((Shader)blurShader.field_148031_d.get(0)).func_148043_c().func_147991_a("BlurXY") == null) Intrinsics.throwNpe();  ((Shader)blurShader.field_148031_d.get(0)).func_148043_c().func_147991_a("BlurXY").func_148087_a(x, factor3 - y - height);
/* 38 */     Intrinsics.checkExpressionValueIsNotNull(blurShader.field_148031_d.get(1), "blurShader.listShaders[1]"); if (((Shader)blurShader.field_148031_d.get(1)).func_148043_c().func_147991_a("BlurXY") == null) Intrinsics.throwNpe();  ((Shader)blurShader.field_148031_d.get(1)).func_148043_c().func_147991_a("BlurXY").func_148087_a(x, factor3 - y - height);
/* 39 */     Intrinsics.checkExpressionValueIsNotNull(blurShader.field_148031_d.get(0), "blurShader.listShaders[0]"); if (((Shader)blurShader.field_148031_d.get(0)).func_148043_c().func_147991_a("BlurCoord") == null) Intrinsics.throwNpe();  ((Shader)blurShader.field_148031_d.get(0)).func_148043_c().func_147991_a("BlurCoord").func_148087_a(width, height);
/* 40 */     Intrinsics.checkExpressionValueIsNotNull(blurShader.field_148031_d.get(1), "blurShader.listShaders[1]"); if (((Shader)blurShader.field_148031_d.get(1)).func_148043_c().func_147991_a("BlurCoord") == null) Intrinsics.throwNpe();  ((Shader)blurShader.field_148031_d.get(1)).func_148043_c().func_147991_a("BlurCoord").func_148087_a(width, height);
/* 41 */     Intrinsics.checkExpressionValueIsNotNull(blurShader.field_148031_d.get(0), "blurShader.listShaders[0]"); if (((Shader)blurShader.field_148031_d.get(0)).func_148043_c().func_147991_a("Radius") == null) Intrinsics.throwNpe();  ((Shader)blurShader.field_148031_d.get(0)).func_148043_c().func_147991_a("Radius").func_148090_a(radius);
/* 42 */     Intrinsics.checkExpressionValueIsNotNull(blurShader.field_148031_d.get(1), "blurShader.listShaders[1]"); if (((Shader)blurShader.field_148031_d.get(1)).func_148043_c().func_147991_a("Radius") == null) Intrinsics.throwNpe();  ((Shader)blurShader.field_148031_d.get(1)).func_148043_c().func_147991_a("Radius").func_148090_a(radius);
/* 43 */     blurShader.func_148018_a(MinecraftInstance.mc.getTimer().getRenderPartialTicks());
/* 44 */     MinecraftInstance.mc.getFramebuffer().bindFramebuffer(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\BlurUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */