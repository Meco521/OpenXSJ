/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class RoundedUtil
/*     */ {
/*  23 */   private static final ShaderUtil roundedTexturedShader = new ShaderUtil("tomk/shader/fragment/roundrecttextured.frag");
/*  24 */   static final ShaderUtil roundedGradientShader = new ShaderUtil("roundedRectGradient");
/*  25 */   public static ShaderUtil roundedShader = new ShaderUtil("roundedRect");
/*  26 */   private static ShaderUtil circle = new ShaderUtil("circle");
/*  27 */   public static ShaderUtil roundedOutlineShader = new ShaderUtil("tomk/shader/fragment/roundrectoutline.frag");
/*     */   
/*     */   public static ItemStack getHeldItem() {
/*  30 */     return null;
/*     */   }
/*     */   
/*     */   public static void drawRound(float x, float y, float width, float height, float radius, Color color) {
/*  34 */     drawRound(x, y, width, height, radius, false, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawCircle(float x, float y, float width, float height, float radius, Color color) {
/*  39 */     GlStateManager.func_179117_G();
/*  40 */     GlStateManager.func_179147_l();
/*  41 */     GlStateManager.func_179112_b(770, 771);
/*  42 */     circle.init();
/*     */     
/*  44 */     setupUniforms(x, y, width, height, radius, circle);
/*  45 */     circle.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/*     */     
/*  47 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/*  48 */     circle.unload();
/*  49 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundScale(float x, float y, float width, float height, float radius, Color color, float scale) {
/*  54 */     drawRound(x + width - width * scale, y + height / 2.0F - height / 2.0F * scale, width * scale, height * scale, radius, false, color);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawGradientHorizontal(float x, float y, float width, float height, float radius, Color left, Color right) {
/*  59 */     drawGradientRound(x, y, width, height, radius, left, left, right, right);
/*     */   }
/*     */   public static void drawGradientHorizontal2(float x, float y, float width, float height, float radius, Color left, Color right) {
/*  62 */     drawGradientRound(x, y, width - x, height - y, radius, left, left, right, right);
/*     */   }
/*     */   public static void drawRoundfix(float x, float y, float width, float height, float radius, Color color) {
/*  65 */     drawRound(x + 0.6F, y + 0.7F, width - x - 1.2F, height - y - 1.0F, radius, false, color);
/*     */   }
/*     */   public static void drawGradientRoundfix(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/*  68 */     drawGradientRound(x, y, width + 100.0F, height, radius, bottomLeft, topLeft, bottomRight, topRight);
/*     */   }
/*     */   public static void drawRound2(float x, float y, float width, float height, float radius, Color color) {
/*  71 */     drawRound(x, y, width, height, radius, false, color);
/*     */   }
/*     */   public static void drawGradientVertical(float x, float y, float width, float height, float radius, Color top, Color bottom) {
/*  74 */     drawGradientRound(x, y, width, height, radius, bottom, top, bottom, top);
/*     */   }
/*     */   public static void drawGradientRound(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/*  77 */     GlStateManager.func_179117_G();
/*  78 */     GlStateManager.func_179147_l();
/*  79 */     GlStateManager.func_179112_b(770, 771);
/*  80 */     roundedGradientShader.init();
/*  81 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedGradientShader);
/*     */     
/*  83 */     roundedGradientShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F, bottomLeft.getAlpha() / 255.0F });
/*     */     
/*  85 */     roundedGradientShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F, topLeft.getAlpha() / 255.0F });
/*     */     
/*  87 */     roundedGradientShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F, bottomRight.getAlpha() / 255.0F });
/*     */     
/*  89 */     roundedGradientShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F, topRight.getAlpha() / 255.0F });
/*  90 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/*  91 */     roundedGradientShader.unload();
/*  92 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */   public static void newdrawGradientRounde(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/*  96 */     GlStateManager.func_179117_G();
/*  97 */     GlStateManager.func_179147_l();
/*  98 */     GlStateManager.func_179112_b(770, 771);
/*  99 */     roundedGradientShader.init();
/* 100 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedGradientShader);
/*     */     
/* 102 */     roundedGradientShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F, bottomLeft.getAlpha() / 255.0F });
/*     */     
/* 104 */     roundedGradientShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F, topLeft.getAlpha() / 255.0F });
/*     */     
/* 106 */     roundedGradientShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F, bottomRight.getAlpha() / 255.0F });
/*     */     
/* 108 */     roundedGradientShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F, topRight.getAlpha() / 255.0F });
/*     */     
/* 110 */     ShaderUtil.drawQuads(x, y, width, height);
/* 111 */     roundedGradientShader.unload();
/* 112 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */   private static void setupRoundedRectUniforms(float x, float y, float width, float height, float radius, ShaderUtil roundedTexturedShader) {
/* 116 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 117 */     roundedTexturedShader.setUniformf("location", new float[] { x * sr.func_78325_e(), 
/* 118 */           (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/* 119 */     roundedTexturedShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/* 120 */     roundedTexturedShader.setUniformf("radius", new float[] { radius * sr.func_78325_e() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawGradientCircle(float x, float y, float width, float height, float radius, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/* 126 */     GlStateManager.func_179117_G();
/* 127 */     GlStateManager.func_179147_l();
/* 128 */     GlStateManager.func_179112_b(770, 771);
/* 129 */     roundedGradientShader.init();
/* 130 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedGradientShader);
/*     */     
/* 132 */     roundedGradientShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F, bottomLeft.getAlpha() / 255.0F });
/*     */     
/* 134 */     roundedGradientShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F, topLeft.getAlpha() / 255.0F });
/*     */     
/* 136 */     roundedGradientShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F, bottomRight.getAlpha() / 255.0F });
/*     */     
/* 138 */     roundedGradientShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F, topRight.getAlpha() / 255.0F });
/* 139 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/* 140 */     roundedGradientShader.unload();
/* 141 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */   public static void drawRound(float x, float y, float width, float height, float radius, boolean blur, Color color) {
/* 145 */     GlStateManager.func_179117_G();
/* 146 */     GlStateManager.func_179147_l();
/* 147 */     GlStateManager.func_179112_b(770, 771);
/* 148 */     roundedShader.init();
/*     */     
/* 150 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedShader);
/* 151 */     roundedShader.setUniformi("blur", new int[] { blur ? 1 : 0 });
/* 152 */     roundedShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/*     */     
/* 154 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/* 155 */     roundedShader.unload();
/* 156 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */   private static void setupUniforms(float x, float y, float width, float height, float radius, ShaderUtil roundedTexturedShader) {
/* 160 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 161 */     roundedTexturedShader.setUniformf("location", new float[] { x * sr.func_78325_e(), 
/* 162 */           (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/* 163 */     roundedTexturedShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/* 164 */     roundedTexturedShader.setUniformf("radius", new float[] { radius * sr.func_78325_e() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawRoundOutline(float x, float y, float width, float height, float radius, float outlineThickness, Color color, Color outlineColor) {
/* 170 */     GlStateManager.func_179117_G();
/* 171 */     GlStateManager.func_179147_l();
/* 172 */     GlStateManager.func_179112_b(770, 771);
/* 173 */     roundedOutlineShader.init();
/*     */     
/* 175 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 176 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedOutlineShader);
/* 177 */     roundedOutlineShader.setUniformf("outlineThickness", new float[] { outlineThickness * sr.func_78325_e() });
/* 178 */     roundedOutlineShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F });
/* 179 */     roundedOutlineShader.setUniformf("outlineColor", new float[] { outlineColor.getRed() / 255.0F, outlineColor.getGreen() / 255.0F, outlineColor.getBlue() / 255.0F, outlineColor.getAlpha() / 255.0F });
/*     */ 
/*     */     
/* 182 */     ShaderUtil.drawQuads(x - 2.0F + outlineThickness, y - 2.0F + outlineThickness, width + 4.0F + outlineThickness * 2.0F, height + 4.0F + outlineThickness * 2.0F);
/* 183 */     roundedOutlineShader.unload();
/* 184 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRoundTextured(float x, float y, float width, float height, float radius, float alpha) {
/* 189 */     GlStateManager.func_179117_G();
/* 190 */     roundedTexturedShader.init();
/* 191 */     roundedTexturedShader.setUniformi("textureIn", new int[] { 0 });
/* 192 */     setupRoundedRectUniforms(x, y, width, height, radius, roundedTexturedShader);
/* 193 */     roundedTexturedShader.setUniformf("alpha", new float[] { alpha });
/* 194 */     ShaderUtil.drawQuads(x - 1.0F, y - 1.0F, width + 2.0F, height + 2.0F);
/* 195 */     roundedTexturedShader.unload();
/* 196 */     GlStateManager.func_179084_k();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\RoundedUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */