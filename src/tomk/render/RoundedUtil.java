/*     */ package tomk.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoundedUtil
/*     */ {
/*  15 */   private static final ShaderUtil roundedTexturedShader = new ShaderUtil("liquidbounce/shader/fragment/roundrecttextured.frag");
/*  16 */   private static final ShaderUtil roundedGradientShader = new ShaderUtil("roundedRectGradient");
/*  17 */   public static ShaderUtil roundedShader = new ShaderUtil("roundedRect");
/*  18 */   public static ShaderUtil roundedOutlineShader = new ShaderUtil("liquidbounce/shader/fragment/roundrectoutline.frag");
/*     */   
/*     */   public static void drawRound(float x, float y, float width, float height, float radius, Color color) {
/*  21 */     drawRound(x, y, width, height, radius, false, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundScale(float x, float y, float width, float height, float radius, Color color, float scale) {
/*  26 */     drawRound(x + width - width * scale, y + height / 2.0F - height / 2.0F * scale, width * scale, height * scale, radius, false, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawGradientHorizontal(float x, float y, float width, float height, float radius, Color left, Color right) {
/*  31 */     drawGradientRound(x, y, width, height, radius, left, left, right, right);
/*     */   }
/*     */   
/*     */   public static void drawGradientVertical(float x, float y, float width, float height, float radius, Color top, Color bottom) {
/*  35 */     drawGradientRound(x, y, width, height, radius, bottom, top, bottom, top);
/*     */   }
/*     */   
/*     */   public static void drawGradientRound(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/*  39 */     GlStateManager.func_179117_G();
/*  40 */     GlStateManager.func_179147_l();
/*  41 */     GlStateManager.func_179112_b(770, 771);
/*  42 */     roundedGradientShader.init();
/*  43 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedGradientShader);
/*     */     
/*  45 */     roundedGradientShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F, bottomLeft.getAlpha() / 255.0F });
/*     */     
/*  47 */     roundedGradientShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F, topLeft.getAlpha() / 255.0F });
/*     */     
/*  49 */     roundedGradientShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F, bottomRight.getAlpha() / 255.0F });
/*     */     
/*  51 */     roundedGradientShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F, topRight.getAlpha() / 255.0F });
/*  52 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/*  53 */     roundedGradientShader.unload();
/*  54 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRound(float x, float y, float width, float height, float radius, boolean blur, Color color) {
/*  59 */     GlStateManager.func_179117_G();
/*  60 */     GlStateManager.func_179147_l();
/*  61 */     GlStateManager.func_179112_b(770, 771);
/*  62 */     roundedShader.init();
/*     */     
/*  64 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedShader);
/*  65 */     roundedShader.setUniformi("blur", new int[] { blur ? 1 : 0 });
/*  66 */     roundedShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/*     */     
/*  68 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/*  69 */     roundedShader.unload();
/*  70 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundOutline(float x, float y, float width, float height, float radius, float outlineThickness, Color color, Color outlineColor) {
/*  75 */     GlStateManager.func_179117_G();
/*  76 */     GlStateManager.func_179147_l();
/*  77 */     GlStateManager.func_179112_b(770, 771);
/*  78 */     roundedOutlineShader.init();
/*     */     
/*  80 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*  81 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedOutlineShader);
/*  82 */     roundedOutlineShader.setUniformf("outlineThickness", new float[] { outlineThickness * sr.func_78325_e() });
/*  83 */     roundedOutlineShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/*  84 */     roundedOutlineShader.setUniformf("outlineColor", new float[] { outlineColor.getRed() / 255.0F, outlineColor.getGreen() / 255.0F, outlineColor.getBlue() / 255.0F, outlineColor.getAlpha() / 255.0F });
/*     */ 
/*     */     
/*  87 */     ShaderUtil.drawQuads(x - 2.0F + outlineThickness, y - 2.0F + outlineThickness, width + 4.0F + outlineThickness * 2.0F, height + 4.0F + outlineThickness * 2.0F);
/*  88 */     roundedOutlineShader.unload();
/*  89 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundTextured(float x, float y, float width, float height, float radius, float alpha) {
/*  94 */     GlStateManager.func_179117_G();
/*  95 */     roundedTexturedShader.init();
/*  96 */     roundedTexturedShader.setUniformi("textureIn", new int[] { 0 });
/*  97 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedTexturedShader);
/*  98 */     roundedTexturedShader.setUniformf("alpha", new float[] { alpha });
/*  99 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/* 100 */     roundedTexturedShader.unload();
/* 101 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */   private static void setupRoundedRectUniforms(float x, float y, float width, float height, float radius, ShaderUtil roundedTexturedShader) {
/* 105 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 106 */     roundedTexturedShader.setUniformf("location", new float[] { x * sr.func_78325_e(), 
/* 107 */           (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/* 108 */     roundedTexturedShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/* 109 */     roundedTexturedShader.setUniformf("radius", new float[] { radius * sr.func_78325_e() });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\render\RoundedUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */