/*    */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GradientUtil
/*    */   extends MinecraftInstance
/*    */ {
/* 17 */   private static final ShaderUtil gradientMaskShader = new ShaderUtil("tomk/shader/fragment/gradientmask.frag");
/* 18 */   private static final ShaderUtil gradientShader = new ShaderUtil("tomk/shader/fragment/gradient.frag");
/*    */ 
/*    */   
/*    */   public static void drawGradient(float x, float y, float width, float height, float alpha, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight) {
/* 22 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*    */     
/* 24 */     RenderUtils.resetColor();
/* 25 */     GlStateManager.func_179147_l();
/* 26 */     GlStateManager.func_179112_b(770, 771);
/* 27 */     gradientShader.init();
/* 28 */     gradientShader.setUniformf("location", new float[] { x * sr.func_78325_e(), (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/* 29 */     gradientShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/* 30 */     gradientShader.setUniformf("alpha", new float[] { alpha });
/*    */     
/* 32 */     gradientShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F });
/*    */     
/* 34 */     gradientShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F });
/*    */     
/* 36 */     gradientShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F });
/*    */     
/* 38 */     gradientShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F });
/*    */ 
/*    */     
/* 41 */     ShaderUtil.drawQuads(x, y, width, height);
/*    */     
/* 43 */     gradientShader.unload();
/* 44 */     GlStateManager.func_179084_k();
/*    */   }
/*    */   
/*    */   public static void drawGradientLR(float x, float y, float width, float height, float alpha, Color left, Color right) {
/* 48 */     drawGradient(x, y, width, height, alpha, left, left, right, right);
/*    */   }
/*    */   
/*    */   public static void drawGradientTB(float x, float y, float width, float height, float alpha, Color top, Color bottom) {
/* 52 */     drawGradient(x, y, width, height, alpha, bottom, top, bottom, top);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void applyGradientHorizontal(float x, float y, float width, float height, float alpha, Color left, Color right, Runnable content) {
/* 57 */     applyGradient(x, y, width, height, alpha, left, left, right, right, content);
/*    */   }
/*    */   
/*    */   public static void applyGradientVertical(float x, float y, float width, float height, float alpha, Color top, Color bottom, Runnable content) {
/* 61 */     applyGradient(x, y, width, height, alpha, bottom, top, bottom, top, content);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void applyGradientCornerRL(float x, float y, float width, float height, float alpha, Color bottomLeft, Color topRight, Runnable content) {
/* 66 */     Color mixedColor = ColorUtil.interpolateColorC(topRight, bottomLeft, 0.5F);
/* 67 */     applyGradient(x, y, width, height, alpha, bottomLeft, mixedColor, mixedColor, topRight, content);
/*    */   }
/*    */   
/*    */   public static void applyGradient(float x, float y, float width, float height, float alpha, Color bottomLeft, Color topLeft, Color bottomRight, Color topRight, Runnable content) {
/* 71 */     RenderUtils.resetColor();
/* 72 */     GlStateManager.func_179147_l();
/* 73 */     GlStateManager.func_179112_b(770, 771);
/* 74 */     gradientMaskShader.init();
/*    */     
/* 76 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*    */     
/* 78 */     gradientMaskShader.setUniformf("location", new float[] { x * sr.func_78325_e(), (Minecraft.func_71410_x()).field_71440_d - height * sr.func_78325_e() - y * sr.func_78325_e() });
/* 79 */     gradientMaskShader.setUniformf("rectSize", new float[] { width * sr.func_78325_e(), height * sr.func_78325_e() });
/* 80 */     gradientMaskShader.setUniformf("alpha", new float[] { alpha });
/* 81 */     gradientMaskShader.setUniformi("tex", new int[] { 0 });
/*    */     
/* 83 */     gradientMaskShader.setUniformf("color1", new float[] { bottomLeft.getRed() / 255.0F, bottomLeft.getGreen() / 255.0F, bottomLeft.getBlue() / 255.0F });
/*    */     
/* 85 */     gradientMaskShader.setUniformf("color2", new float[] { topLeft.getRed() / 255.0F, topLeft.getGreen() / 255.0F, topLeft.getBlue() / 255.0F });
/*    */     
/* 87 */     gradientMaskShader.setUniformf("color3", new float[] { bottomRight.getRed() / 255.0F, bottomRight.getGreen() / 255.0F, bottomRight.getBlue() / 255.0F });
/*    */     
/* 89 */     gradientMaskShader.setUniformf("color4", new float[] { topRight.getRed() / 255.0F, topRight.getGreen() / 255.0F, topRight.getBlue() / 255.0F });
/*    */ 
/*    */     
/* 92 */     content.run();
/*    */     
/* 94 */     gradientMaskShader.unload();
/* 95 */     GlStateManager.func_179084_k();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\GradientUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */