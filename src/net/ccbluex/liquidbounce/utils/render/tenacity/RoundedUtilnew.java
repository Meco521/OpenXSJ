/*     */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import lynn.utils.ShaderUtil;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.GLUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoundedUtilnew
/*     */ {
/*  15 */   public static ShaderUtil roundedShader = new ShaderUtil("roundedRect");
/*  16 */   public static ShaderUtil roundedOutlineShader = new ShaderUtil("roundRectOutline");
/*  17 */   private static final ShaderUtil roundedTexturedShader = new ShaderUtil("roundRectTexture");
/*  18 */   private static final ShaderUtil roundedGradientShader = new ShaderUtil("roundedRectGradient");
/*     */ 
/*     */   
/*     */   public static void drawRound(float x, float y, float width, float height, float radius, Color color) {
/*  22 */     drawRound(x, y, width, height, radius, false, color);
/*     */   }
/*     */   
/*     */   public static void drawGradientHorizontal(float x, float y, float width, float height, float radius, Color left, Color right) {
/*  26 */     drawGradientRound(x, y, width, height, radius, left, left, right, right);
/*     */   }
/*     */   public static void drawGradientVertical(float x, float y, float width, float height, float radius, Color top, Color bottom) {
/*  29 */     drawGradientRound(x, y, width, height, radius, bottom, top, bottom, top);
/*     */   }
/*     */   public static void drawGradientCornerLR(float x, float y, float width, float height, float radius, Color topLeft, Color bottomRight) {
/*  32 */     Color mixedColor = ColorUtil.interpolateColorC(topLeft, bottomRight, 0.5F);
/*  33 */     drawGradientRound(x, y, width, height, radius, mixedColor, topLeft, bottomRight, mixedColor);
/*     */   }
/*     */   
/*     */   public static void drawGradientCornerRL(float x, float y, float width, float height, float radius, Color bottomLeft, Color topRight) {
/*  37 */     Color mixedColor = ColorUtil.interpolateColorC(topRight, bottomLeft, 0.5F);
/*  38 */     drawGradientRound(x, y, width, height, radius, bottomLeft, mixedColor, mixedColor, topRight);
/*     */   }
/*     */   
/*     */   public static void drawGradientRound(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/*  42 */     RenderUtils.setAlphaLimit(0.0F);
/*  43 */     RenderUtils.resetColor();
/*  44 */     GLUtil.startBlend();
/*  45 */     roundedGradientShader.init();
/*  46 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedGradientShader);
/*     */     
/*  48 */     roundedGradientShader.setUniformf("color1", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F, topLeft.getAlpha() / 255.0F });
/*     */     
/*  50 */     roundedGradientShader.setUniformf("color2", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F, bottomLeft.getAlpha() / 255.0F });
/*     */     
/*  52 */     roundedGradientShader.setUniformf("color3", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F, topRight.getAlpha() / 255.0F });
/*     */     
/*  54 */     roundedGradientShader.setUniformf("color4", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F, bottomRight.getAlpha() / 255.0F });
/*  55 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/*  56 */     roundedGradientShader.unload();
/*  57 */     GLUtil.endBlend();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawRound(float x, float y, float width, float height, float radius, boolean blur, Color color) {
/*  64 */     RenderUtils.resetColor();
/*  65 */     GLUtil.startBlend();
/*  66 */     GL11.glBlendFunc(770, 771);
/*  67 */     RenderUtils.setAlphaLimit(0.0F);
/*  68 */     roundedShader.init();
/*     */     
/*  70 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedShader);
/*  71 */     roundedShader.setUniformi("blur", new int[] { blur ? 1 : 0 });
/*  72 */     roundedShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/*     */     
/*  74 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/*  75 */     roundedShader.unload();
/*  76 */     GLUtil.endBlend();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundOutline(float x, float y, float width, float height, float radius, float outlineThickness, Color color, Color outlineColor) {
/*  81 */     RenderUtils.resetColor();
/*  82 */     GLUtil.startBlend();
/*  83 */     GL11.glBlendFunc(770, 771);
/*  84 */     RenderUtils.setAlphaLimit(0.0F);
/*  85 */     roundedOutlineShader.init();
/*     */     
/*  87 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*  88 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedOutlineShader);
/*  89 */     roundedOutlineShader.setUniformf("outlineThickness", new float[] { outlineThickness * sr.func_78325_e() });
/*  90 */     roundedOutlineShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/*  91 */     roundedOutlineShader.setUniformf("outlineColor", new float[] { outlineColor.getRed() / 255.0F, outlineColor.getGreen() / 255.0F, outlineColor.getBlue() / 255.0F, outlineColor.getAlpha() / 255.0F });
/*     */ 
/*     */     
/*  94 */     ShaderUtil.drawQuads(x - 2.0F + outlineThickness, y - 2.0F + outlineThickness, width + 4.0F + outlineThickness * 2.0F, height + 4.0F + outlineThickness * 2.0F);
/*  95 */     roundedOutlineShader.unload();
/*  96 */     GLUtil.endBlend();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundTextured(float x, float y, float width, float height, float radius, float alpha) {
/* 101 */     RenderUtils.resetColor();
/* 102 */     RenderUtils.setAlphaLimit(0.0F);
/* 103 */     GLUtil.startBlend();
/* 104 */     roundedTexturedShader.init();
/* 105 */     roundedTexturedShader.setUniformi("textureIn", new int[] { 0 });
/* 106 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedTexturedShader);
/* 107 */     roundedTexturedShader.setUniformf("alpha", new float[] { alpha });
/* 108 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/* 109 */     roundedTexturedShader.unload();
/* 110 */     GLUtil.endBlend();
/*     */   }
/*     */   
/*     */   private static void setupRoundedRectUniforms(float x, float y, float width, float height, float radius, ShaderUtil roundedTexturedShader) {
/* 114 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 115 */     roundedTexturedShader.setUniformf("location", new float[] { x * sr.func_78325_e(), 
/* 116 */           (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/* 117 */     roundedTexturedShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/* 118 */     roundedTexturedShader.setUniformf("radius", new float[] { radius * sr.func_78325_e() });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\RoundedUtilnew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */