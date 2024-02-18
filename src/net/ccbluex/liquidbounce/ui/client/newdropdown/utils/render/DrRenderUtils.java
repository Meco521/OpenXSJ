/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Utils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrRenderUtils
/*     */   implements Utils
/*     */ {
/*     */   public static float zLevel;
/*     */   
/*     */   public static void drawModalRectWithCustomSizedTexture(float x, float y, float u, float v, float width, float height, float textureWidth, float textureHeight) {
/*  25 */     float f = 1.0F / textureWidth;
/*  26 */     float f1 = 1.0F / textureHeight;
/*  27 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  28 */     IWorldRenderer worldrenderer = Retreat.INSTANCE.getWrapper().getClassProvider().getTessellatorInstance().getWorldRenderer();
/*  29 */     worldrenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_COLOR));
/*  30 */     worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + height) * f1)).endVertex();
/*  31 */     worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + width) * f), ((v + height) * f1)).endVertex();
/*  32 */     worldrenderer.pos((x + width), y, 0.0D).tex(((u + width) * f), (v * f1)).endVertex();
/*  33 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/*  34 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawGradientRect2(double x, double y, double width, double height, int startColor, int endColor) {
/*  39 */     drawGradientRect(x, y, x + width, y + height, startColor, endColor);
/*     */   }
/*     */   
/*     */   public static void drawGradientRect(double left, double top, double right, double bottom, int startColor, int endColor) {
/*  43 */     float f = (startColor >> 24 & 0xFF) / 255.0F;
/*  44 */     float f1 = (startColor >> 16 & 0xFF) / 255.0F;
/*  45 */     float f2 = (startColor >> 8 & 0xFF) / 255.0F;
/*  46 */     float f3 = (startColor & 0xFF) / 255.0F;
/*  47 */     float f4 = (endColor >> 24 & 0xFF) / 255.0F;
/*  48 */     float f5 = (endColor >> 16 & 0xFF) / 255.0F;
/*  49 */     float f6 = (endColor >> 8 & 0xFF) / 255.0F;
/*  50 */     float f7 = (endColor & 0xFF) / 255.0F;
/*  51 */     GlStateManager.func_179090_x();
/*  52 */     GlStateManager.func_179147_l();
/*  53 */     GlStateManager.func_179118_c();
/*  54 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  55 */     GlStateManager.func_179103_j(7425);
/*  56 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  57 */     IWorldRenderer worldrenderer = Retreat.INSTANCE.getWrapper().getClassProvider().getTessellatorInstance().getWorldRenderer();
/*  58 */     worldrenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_COLOR));
/*  59 */     worldrenderer.pos(right, top, zLevel).color(f1, f2, f3, f).endVertex();
/*  60 */     worldrenderer.pos(left, top, zLevel).color(f1, f2, f3, f).endVertex();
/*  61 */     worldrenderer.pos(left, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/*  62 */     worldrenderer.pos(right, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/*  63 */     tessellator.func_78381_a();
/*  64 */     GlStateManager.func_179103_j(7424);
/*  65 */     GlStateManager.func_179084_k();
/*  66 */     GlStateManager.func_179141_d();
/*  67 */     GlStateManager.func_179098_w();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawGradientRectSideways2(double x, double y, double width, double height, int startColor, int endColor) {
/*  72 */     drawGradientRectSideways(x, y, x + width, y + height, startColor, endColor);
/*     */   }
/*     */   
/*     */   public static void drawGradientRectSideways(double left, double top, double right, double bottom, int startColor, int endColor) {
/*  76 */     float f = (startColor >> 24 & 0xFF) / 255.0F;
/*  77 */     float f1 = (startColor >> 16 & 0xFF) / 255.0F;
/*  78 */     float f2 = (startColor >> 8 & 0xFF) / 255.0F;
/*  79 */     float f3 = (startColor & 0xFF) / 255.0F;
/*  80 */     float f4 = (endColor >> 24 & 0xFF) / 255.0F;
/*  81 */     float f5 = (endColor >> 16 & 0xFF) / 255.0F;
/*  82 */     float f6 = (endColor >> 8 & 0xFF) / 255.0F;
/*  83 */     float f7 = (endColor & 0xFF) / 255.0F;
/*  84 */     GlStateManager.func_179090_x();
/*  85 */     GlStateManager.func_179147_l();
/*  86 */     GlStateManager.func_179118_c();
/*  87 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  88 */     GlStateManager.func_179103_j(7425);
/*  89 */     ITessellator tessellator = Retreat.INSTANCE.getWrapper().getClassProvider().getTessellatorInstance();
/*  90 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  91 */     worldrenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_COLOR));
/*  92 */     worldrenderer.pos(right, top, zLevel).color(f5, f6, f7, f4).endVertex();
/*  93 */     worldrenderer.pos(left, top, zLevel).color(f1, f2, f3, f).endVertex();
/*  94 */     worldrenderer.pos(left, bottom, zLevel).color(f1, f2, f3, f).endVertex();
/*  95 */     worldrenderer.pos(right, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/*  96 */     tessellator.draw();
/*  97 */     GlStateManager.func_179103_j(7424);
/*  98 */     GlStateManager.func_179084_k();
/*  99 */     GlStateManager.func_179141_d();
/* 100 */     GlStateManager.func_179098_w();
/*     */   }
/*     */   public static void scissor(double x, double y, double width, double height) {
/* 103 */     IScaledResolution sr = Retreat.INSTANCE.getWrapper().getClassProvider().createScaledResolution(mc);
/*     */     
/* 105 */     double scale = sr.getScaleFactor();
/* 106 */     double finalHeight = height * scale;
/* 107 */     double finalY = (sr.getScaledHeight() - y) * scale;
/* 108 */     double finalX = x * scale;
/* 109 */     double finalWidth = width * scale;
/* 110 */     GL11.glScissor((int)finalX, (int)(finalY - finalHeight), (int)finalWidth, (int)finalHeight);
/*     */   }
/*     */   public static int interpolateColor(int color1, int color2, float amount) {
/* 113 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/* 114 */     Color cColor1 = new Color(color1);
/* 115 */     Color cColor2 = new Color(color2);
/* 116 */     return interpolateColorC(cColor1, cColor2, amount).getRGB();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderRoundedRect(float x, float y, float width, float height, float radius, int color) {
/* 121 */     drawGoodCircle((x + radius), (y + radius), radius, color);
/* 122 */     drawGoodCircle((x + width - radius), (y + radius), radius, color);
/* 123 */     drawGoodCircle((x + radius), (y + height - radius), radius, color);
/* 124 */     drawGoodCircle((x + width - radius), (y + height - radius), radius, color);
/*     */     
/* 126 */     drawRect2((x + radius), y, (width - radius * 2.0F), height, color);
/* 127 */     drawRect2(x, (y + radius), width, (height - radius * 2.0F), color);
/*     */   }
/*     */   
/*     */   public static Color darker(Color color, float FACTOR) {
/* 131 */     return new Color(Math.max((int)(color.getRed() * FACTOR), 0), 
/* 132 */         Math.max((int)(color.getGreen() * FACTOR), 0), 
/* 133 */         Math.max((int)(color.getBlue() * FACTOR), 0), color
/* 134 */         .getAlpha());
/*     */   }
/*     */   
/*     */   public static void drawClickGuiArrow(float x, float y, float size, Animation animation, int color) {
/* 138 */     GL11.glTranslatef(x, y, 0.0F);
/* 139 */     GLUtil.setup2DRendering(() -> GLUtil.render(5, ()));
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
/* 155 */     GL11.glTranslatef(-x, -y, 0.0F);
/*     */   }
/*     */   public static Color interpolateColorC(Color color1, Color color2, float amount) {
/* 158 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/* 159 */     return new Color(interpolateInt(color1.getRed(), color2.getRed(), amount), 
/* 160 */         interpolateInt(color1.getGreen(), color2.getGreen(), amount), 
/* 161 */         interpolateInt(color1.getBlue(), color2.getBlue(), amount), 
/* 162 */         interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*     */   }
/*     */   
/*     */   public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
/* 166 */     return interpolate(oldValue, newValue, (float)interpolationValue).intValue();
/*     */   }
/*     */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/* 169 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*     */   }
/*     */   
/*     */   public static boolean isHovering(float x, float y, float width, float height, int mouseX, int mouseY) {
/* 173 */     return (mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height);
/*     */   }
/*     */   public static Color applyOpacity(Color color, float opacity) {
/* 176 */     opacity = Math.min(1.0F, Math.max(0.0F, opacity));
/* 177 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(color.getAlpha() * opacity));
/*     */   }
/*     */   public static int applyOpacity(int color, float opacity) {
/* 180 */     Color old = new Color(color);
/* 181 */     return applyOpacity(old, opacity).getRGB();
/*     */   }
/*     */   
/*     */   public static void drawGoodCircle(double x, double y, float radius, int color) {
/* 185 */     color(color);
/* 186 */     GLUtil.setup2DRendering(() -> {
/*     */           GL11.glEnable(2832);
/*     */           GL11.glHint(3153, 4354);
/*     */           GL11.glPointSize(radius * (2 * mc.getGameSettings().getGuiScale()));
/*     */           GLUtil.render(0, ());
/*     */         });
/*     */   }
/*     */   
/*     */   public static double animate(double endPoint, double current, double speed) {
/* 195 */     boolean shouldContinueAnimation = (endPoint > current);
/* 196 */     if (speed < 0.0D) {
/* 197 */       speed = 0.0D;
/* 198 */     } else if (speed > 1.0D) {
/* 199 */       speed = 1.0D;
/*     */     } 
/*     */     
/* 202 */     double dif = Math.max(endPoint, current) - Math.min(endPoint, current);
/* 203 */     double factor = dif * speed;
/* 204 */     return current + (shouldContinueAnimation ? factor : -factor);
/*     */   }
/*     */   public static void fakeCircleGlow(float posX, float posY, float radius, Color color, float maxAlpha) {
/* 207 */     setAlphaLimit(0.0F);
/* 208 */     GL11.glShadeModel(7425);
/* 209 */     GLUtil.setup2DRendering(() -> GLUtil.render(6, ()));
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
/* 220 */     GL11.glShadeModel(7424);
/* 221 */     setAlphaLimit(1.0F);
/*     */   }
/*     */   
/*     */   public static Color brighter(Color color, float FACTOR) {
/* 225 */     int r = color.getRed();
/* 226 */     int g = color.getGreen();
/* 227 */     int b = color.getBlue();
/* 228 */     int alpha = color.getAlpha();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     int i = (int)(1.0D / (1.0D - FACTOR));
/* 236 */     if (r == 0 && g == 0 && b == 0) {
/* 237 */       return new Color(i, i, i, alpha);
/*     */     }
/* 239 */     if (r > 0 && r < i) r = i; 
/* 240 */     if (g > 0 && g < i) g = i; 
/* 241 */     if (b > 0 && b < i) b = i;
/*     */     
/* 243 */     return new Color(Math.min((int)(r / FACTOR), 255), 
/* 244 */         Math.min((int)(g / FACTOR), 255), 
/* 245 */         Math.min((int)(b / FACTOR), 255), alpha);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void scale(float x, float y, float scale, Runnable data) {
/* 250 */     GL11.glPushMatrix();
/* 251 */     GL11.glTranslatef(x, y, 0.0F);
/* 252 */     GL11.glScalef(scale, scale, 1.0F);
/* 253 */     GL11.glTranslatef(-x, -y, 0.0F);
/* 254 */     data.run();
/* 255 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void resetColor() {
/* 260 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void drawRect2(double x, double y, double width, double height, int color) {
/* 264 */     resetColor();
/* 265 */     GLUtil.setup2DRendering(() -> GLUtil.render(7, ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void color(int color, float alpha) {
/* 275 */     float r = (color >> 16 & 0xFF) / 255.0F;
/* 276 */     float g = (color >> 8 & 0xFF) / 255.0F;
/* 277 */     float b = (color & 0xFF) / 255.0F;
/* 278 */     GlStateManager.func_179131_c(r, g, b, alpha);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setAlphaLimit(float limit) {
/* 283 */     GlStateManager.func_179141_d();
/* 284 */     GlStateManager.func_179092_a(516, (float)(limit * 0.01D));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void color(int color) {
/* 289 */     color(color, (color >> 24 & 0xFF) / 255.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\render\DrRenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */