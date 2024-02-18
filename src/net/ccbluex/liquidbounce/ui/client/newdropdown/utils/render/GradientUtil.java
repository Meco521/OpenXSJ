/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Utils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.blur.ShaderUtil;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GradientUtil
/*     */   implements Utils
/*     */ {
/*  17 */   private static final ShaderUtil gradientMaskShader = new ShaderUtil("shaders/gradientmask.frag");
/*  18 */   private static final ShaderUtil gradientShader = new ShaderUtil("shaders/gradient.frag");
/*     */   
/*     */   public static void drawRect2(double x, double y, double width, double height, int color) {
/*  21 */     RenderUtils.resetColor();
/*  22 */     GLUtil.setup2DRendering(() -> GLUtil.render(7, ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawGradient(float x, float y, float width, float height, float alpha, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/*  32 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*     */     
/*  34 */     DrRenderUtils.resetColor();
/*  35 */     GlStateManager.func_179147_l();
/*  36 */     GlStateManager.func_179112_b(770, 771);
/*  37 */     gradientShader.init();
/*  38 */     gradientShader.setUniformf("location", new float[] { x * sr.func_78325_e(), (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/*  39 */     gradientShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/*  40 */     gradientShader.setUniformf("alpha", new float[] { alpha });
/*     */     
/*  42 */     gradientShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F });
/*     */     
/*  44 */     gradientShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F });
/*     */     
/*  46 */     gradientShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F });
/*     */     
/*  48 */     gradientShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F });
/*     */ 
/*     */     
/*  51 */     ShaderUtil.drawQuads(x, y, width, height);
/*     */     
/*  53 */     gradientShader.unload();
/*  54 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */   public static void drawGradientLR(float x, float y, float width, float height, float alpha, Color left, Color right) {
/*  58 */     drawGradient(x, y, width, height, alpha, left, left, right, right);
/*     */   }
/*     */   
/*     */   public static void drawGradientTB(float x, float y, float width, float height, float alpha, Color top, Color bottom) {
/*  62 */     drawGradient(x, y, width, height, alpha, bottom, top, bottom, top);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void applyGradientHorizontal(float x, float y, float width, float height, float alpha, Color left, Color right, Runnable content) {
/*  67 */     applyGradient(x, y, width, height, alpha, left, left, right, right, content);
/*     */   }
/*     */   
/*     */   public static void applyGradientVertical(float x, float y, float width, float height, float alpha, Color top, Color bottom, Runnable content) {
/*  71 */     applyGradient(x, y, width, height, alpha, bottom, top, bottom, top, content);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void applyGradientCornerRL(float x, float y, float width, float height, float alpha, Color bottomLeft, Color topRight, Runnable content) {
/*  76 */     Color mixedColor = DrRenderUtils.interpolateColorC(topRight, bottomLeft, 0.5F);
/*  77 */     applyGradient(x, y, width, height, alpha, bottomLeft, mixedColor, mixedColor, topRight, content);
/*     */   }
/*     */   
/*     */   public static void applyGradient(float x, float y, float width, float height, float alpha, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight, Runnable content) {
/*  81 */     DrRenderUtils.resetColor();
/*  82 */     GlStateManager.func_179147_l();
/*  83 */     GlStateManager.func_179112_b(770, 771);
/*  84 */     gradientMaskShader.init();
/*     */     
/*  86 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*     */     
/*  88 */     gradientMaskShader.setUniformf("location", new float[] { x * sr.func_78325_e(), (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/*  89 */     gradientMaskShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/*  90 */     gradientMaskShader.setUniformf("alpha", new float[] { alpha });
/*  91 */     gradientMaskShader.setUniformi("tex", new int[] { 0 });
/*     */     
/*  93 */     gradientMaskShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F });
/*     */     
/*  95 */     gradientMaskShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F });
/*     */     
/*  97 */     gradientMaskShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F });
/*     */     
/*  99 */     gradientMaskShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F });
/*     */ 
/*     */     
/* 102 */     content.run();
/*     */     
/* 104 */     gradientMaskShader.unload();
/* 105 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\render\GradientUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */