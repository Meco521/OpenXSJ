/*     */ package tomk.utils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.GLUtil;
/*     */ import net.ccbluex.liquidbounce.utils.sound.Sound;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public class LiYingUtil
/*     */ {
/*     */   public static int astolfoRainbow(int delay, int offset, int index) {
/*  28 */     double rainbowDelay = Math.ceil((System.currentTimeMillis() + (delay * index))) / offset;
/*  29 */     return Color.getHSBColor(((float)((rainbowDelay %= 360.0D) / 360.0D) < 0.5D) ? -((float)(rainbowDelay / 360.0D)) : (float)(rainbowDelay / 360.0D), 0.5F, 1.0F).getRGB();
/*     */   }
/*     */   
/*     */   public static int applyOpacity(int color, float opacity) {
/*  33 */     Color old = new Color(color);
/*  34 */     return applyOpacity(old, opacity).getRGB();
/*     */   }
/*     */   
/*     */   public static Color applyOpacity(Color color, float opacity) {
/*  38 */     opacity = Math.min(1.0F, Math.max(0.0F, opacity));
/*  39 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(color.getAlpha() * opacity));
/*     */   }
/*     */   
/*     */   public static void drawGoodCircle(double x, double y, float radius, int color) {
/*  43 */     color(color);
/*  44 */     GLUtil.setup2DRendering(() -> {
/*     */           GL11.glEnable(2832);
/*     */           GL11.glHint(3153, 4354);
/*     */           GL11.glPointSize(radius * (2 * Sound.mc.field_71474_y.field_74335_Z));
/*     */           GLUtil.render(0, ());
/*     */         });
/*     */   }
/*     */   public static void setAlphaLimit(float limit) {
/*  52 */     GlStateManager.func_179141_d();
/*  53 */     GlStateManager.func_179092_a(516, (float)(limit * 0.01D));
/*     */   }
/*     */   public static void fakeCircleGlow(float posX, float posY, float radius, Color color, float maxAlpha) {
/*  56 */     setAlphaLimit(0.0F);
/*  57 */     GL11.glShadeModel(7425);
/*  58 */     GLUtil.setup2DRendering(() -> GLUtil.render(6, ()));
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
/*  69 */     GL11.glShadeModel(7424);
/*  70 */     setAlphaLimit(1.0F);
/*     */   }
/*     */   public static void color(int color, float alpha) {
/*  73 */     float r = (color >> 16 & 0xFF) / 255.0F;
/*  74 */     float g = (color >> 8 & 0xFF) / 255.0F;
/*  75 */     float b = (color & 0xFF) / 255.0F;
/*  76 */     GlStateManager.func_179131_c(r, g, b, alpha);
/*     */   }
/*     */   
/*  79 */   private static final Random random = new Random();
/*     */   
/*     */   public static double round(double value, double inc) {
/*  82 */     if (inc == 0.0D) return value; 
/*  83 */     if (inc == 1.0D) return Math.round(value);
/*     */     
/*  85 */     double halfOfInc = inc / 2.0D;
/*  86 */     double floored = Math.floor(value / inc) * inc;
/*     */     
/*  88 */     if (value >= floored + halfOfInc)
/*  89 */       return (new BigDecimal(Math.ceil(value / inc) * inc))
/*  90 */         .doubleValue(); 
/*  91 */     return (new BigDecimal(floored))
/*  92 */       .doubleValue();
/*     */   }
/*     */   
/*     */   public static float calculateGaussianValue(float x, float sigma) {
/*  96 */     double PI = 3.141592653D;
/*  97 */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/*  98 */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*     */   }
/*     */   
/*     */   public static int clamp_int(int p_clamp_int_0_, int p_clamp_int_1_, int p_clamp_int_2_) {
/* 102 */     if (p_clamp_int_0_ < p_clamp_int_1_) {
/* 103 */       return p_clamp_int_1_;
/*     */     }
/* 105 */     return (p_clamp_int_0_ > p_clamp_int_2_) ? p_clamp_int_2_ : p_clamp_int_0_;
/*     */   }
/*     */   
/*     */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/* 109 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*     */   }
/*     */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/* 112 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*     */   }
/*     */   public static double roundToHalf(double d) {
/* 115 */     return Math.round(d * 2.0D) / 2.0D;
/*     */   }
/*     */   public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
/* 118 */     return interpolate(oldValue, newValue, (float)interpolationValue).intValue();
/*     */   }
/*     */   public static int getRandomInRange(int min, int max) {
/* 121 */     return (int)(Math.random() * (max - min) + min);
/*     */   }
/*     */   public static void color(int color) {
/* 124 */     color(color, (color >> 24 & 0xFF) / 255.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\LiYingUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */