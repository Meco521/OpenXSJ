/*     */ package tomk.utils.flux;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.client.shader.Shader;
/*     */ import net.minecraft.client.shader.ShaderGroup;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.EXTFramebufferObject;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class BlurBuffer
/*     */ {
/*     */   private static ShaderGroup blurShader;
/*  21 */   private static final Minecraft mc = Minecraft.func_71410_x();
/*     */   private static Framebuffer buffer;
/*     */   private static float lastScale;
/*     */   private static int lastScaleWidth;
/*     */   private static int lastScaleHeight;
/*  26 */   private static ResourceLocation shader = new ResourceLocation("shaders/post/blur.json");
/*  27 */   private static TimeHelper updateTimer = new TimeHelper();
/*  28 */   private static List<Shader> listShaders = Lists.newArrayList();
/*     */   private static boolean setupOverlay;
/*     */   
/*     */   public static void init() {
/*     */     try {
/*  33 */       buffer = new Framebuffer(mc.field_71443_c, mc.field_71440_d, true);
/*  34 */       buffer.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
/*  35 */       blurShader = new ShaderGroup(mc.func_110434_K(), mc.func_110442_L(), buffer, shader);
/*  36 */       blurShader.func_148026_a(mc.field_71443_c, mc.field_71440_d);
/*  37 */     } catch (Exception ex) {
/*  38 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void setShaderConfigs(float intensity, float blurWidth, float blurHeight) {
/*  43 */     Field field = null;
/*     */     try {
/*  45 */       Class<?> clazz = Class.forName("net.minecraft.client.shader.ShaderGroup");
/*  46 */       Field[] fields = clazz.getDeclaredFields();
/*  47 */       for (int i = 0; i <= 4; i++) {
/*  48 */         if (i == 3) {
/*  49 */           field = clazz.getDeclaredField(fields[i].getName());
/*     */         }
/*     */       } 
/*  52 */       field.setAccessible(true);
/*  53 */       listShaders = (List<Shader>)field.get(blurShader);
/*  54 */     } catch (NoSuchFieldException e) {
/*  55 */       e.printStackTrace();
/*  56 */     } catch (IllegalAccessException e) {
/*  57 */       e.printStackTrace();
/*  58 */     } catch (ClassNotFoundException e) {
/*  59 */       e.printStackTrace();
/*     */     } 
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
/*  71 */     ((Shader)listShaders.get(0)).func_148043_c().func_147991_a("Radius").func_148090_a(intensity);
/*  72 */     ((Shader)listShaders.get(1)).func_148043_c().func_147991_a("Radius").func_148090_a(intensity);
/*  73 */     ((Shader)listShaders.get(0)).func_148043_c().func_147991_a("BlurDir").func_148087_a(blurWidth, blurHeight);
/*  74 */     ((Shader)listShaders.get(1)).func_148043_c().func_147991_a("BlurDir").func_148087_a(blurHeight, blurWidth);
/*     */   }
/*     */   
/*     */   public static void blurArea(float x, float y, float width, float height, boolean setupOverlay) {
/*  78 */     ScaledResolution scale = new ScaledResolution(mc);
/*  79 */     float factor = scale.func_78325_e();
/*  80 */     int factor2 = scale.func_78326_a();
/*  81 */     int factor3 = scale.func_78328_b();
/*  82 */     if (lastScale != factor || lastScaleWidth != factor2 || lastScaleHeight != factor3 || buffer == null || blurShader == null) {
/*  83 */       init();
/*     */     }
/*  85 */     lastScale = factor;
/*  86 */     lastScaleWidth = factor2;
/*  87 */     lastScaleHeight = factor3;
/*     */ 
/*     */     
/*  90 */     GL11.glEnable(3089);
/*  91 */     RenderUtils.doGlScissor((int)x, (int)y, (int)width, (int)height);
/*  92 */     GL11.glPushMatrix();
/*  93 */     buffer.func_178038_a(mc.field_71443_c, mc.field_71440_d, true);
/*  94 */     GL11.glPopMatrix();
/*  95 */     GL11.glDisable(3089);
/*     */     
/*  97 */     if (setupOverlay) {
/*  98 */       mc.field_71460_t.func_78478_c();
/*     */     }
/*     */     
/* 101 */     GlStateManager.func_179126_j();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void blurRoundArea(float x, float y, float width, float height, float roundRadius) {
/* 106 */     ScaledResolution scale = new ScaledResolution(mc);
/* 107 */     float factor = scale.func_78325_e();
/* 108 */     int factor2 = scale.func_78326_a();
/* 109 */     int factor3 = scale.func_78328_b();
/*     */     
/* 111 */     if (lastScale != factor || lastScaleWidth != factor2 || lastScaleHeight != factor3 || buffer == null || blurShader == null) {
/* 112 */       init();
/*     */     }
/*     */     
/* 115 */     lastScale = factor;
/* 116 */     lastScaleWidth = factor2;
/* 117 */     lastScaleHeight = factor3;
/*     */ 
/*     */     
/* 120 */     GL11.glEnable(3089);
/* 121 */     RenderUtils.doGlScissor((int)x, (int)y, (int)width, (int)height);
/* 122 */     GL11.glPushMatrix();
/* 123 */     buffer.func_178038_a(mc.field_71443_c, mc.field_71440_d, true);
/* 124 */     GL11.glPopMatrix();
/* 125 */     GL11.glDisable(3089);
/*     */     
/* 127 */     if (setupOverlay) {
/* 128 */       mc.field_71460_t.func_78478_c();
/*     */     }
/*     */     
/* 131 */     GlStateManager.func_179126_j();
/*     */   }
/*     */   
/*     */   public static void updateBlurBuffer(boolean setupOverlay) {
/* 135 */     if (blurShader != null) {
/* 136 */       mc.func_147110_a().func_147609_e();
/*     */       
/* 138 */       setShaderConfigs(20.0F, 0.0F, 1.0F);
/* 139 */       buffer.func_147610_a(true);
/*     */       
/* 141 */       mc.func_147110_a().func_178038_a(mc.field_71443_c, mc.field_71440_d, true);
/*     */       
/* 143 */       if (OpenGlHelper.field_148824_g) {
/* 144 */         GlStateManager.func_179128_n(5890);
/* 145 */         GlStateManager.func_179094_E();
/* 146 */         GlStateManager.func_179096_D();
/*     */         
/* 148 */         GlStateManager.func_179121_F();
/*     */       } 
/*     */       
/* 151 */       buffer.func_147609_e();
/* 152 */       mc.func_147110_a().func_147610_a(true);
/*     */       
/* 154 */       if (mc.func_147110_a() != null && (mc.func_147110_a()).field_147624_h > -1) {
/* 155 */         setupFBO(mc.func_147110_a());
/* 156 */         (mc.func_147110_a()).field_147624_h = -1;
/*     */       } 
/*     */       
/* 159 */       if (setupOverlay) {
/* 160 */         mc.field_71460_t.func_78478_c();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setupFBO(Framebuffer fbo) {
/* 166 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(fbo.field_147624_h);
/* 167 */     int stencil_depth_buffer_ID = EXTFramebufferObject.glGenRenderbuffersEXT();
/* 168 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencil_depth_buffer_ID);
/* 169 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, mc.field_71443_c, mc.field_71440_d);
/* 170 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencil_depth_buffer_ID);
/* 171 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencil_depth_buffer_ID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\flux\BlurBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */