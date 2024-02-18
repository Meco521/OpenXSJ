/*      */ package net.ccbluex.liquidbounce.utils.render;
/*      */ import java.awt.Color;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.util.HashMap;
/*      */ import net.ccbluex.liquidbounce.Retreat;
/*      */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*      */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*      */ import net.ccbluex.liquidbounce.utils.novoline.ScaleUtils;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.gui.Gui;
/*      */ import net.minecraft.client.renderer.BufferBuilder;
/*      */ import net.minecraft.client.renderer.GlStateManager;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*      */ import net.minecraft.client.shader.Framebuffer;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.math.MathHelper;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ import org.lwjgl.opengl.GL14;
/*      */ 
/*      */ public final class RenderUtils extends MinecraftInstance {
/*   45 */   private static final Map<Integer, Boolean> glCapMap = new HashMap<>();
/*   46 */   private static final int[] DISPLAY_LISTS_2D = new int[4]; public static int deltaTime; public static float zLevel;
/*      */   
/*      */   public static void drawScaledCustomSizeModalCircle(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height, float tileWidth, float tileHeight) {
/*   49 */     float f = 1.0F / tileWidth;
/*   50 */     float f1 = 1.0F / tileHeight;
/*   51 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/*   52 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*   53 */     worldrenderer.begin(9, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/*   54 */     float xRadius = width / 2.0F;
/*   55 */     float yRadius = height / 2.0F;
/*   56 */     float uRadius = ((u + uWidth) * f - u * f) / 2.0F;
/*   57 */     float vRadius = ((v + vHeight) * f1 - v * f1) / 2.0F;
/*   58 */     for (int i = 0; i <= 360; i += 5) {
/*   59 */       double xPosOffset = Math.sin(i * Math.PI / 180.0D);
/*   60 */       double yPosOffset = Math.cos(i * Math.PI / 180.0D);
/*   61 */       worldrenderer.pos((x + xRadius) + xPosOffset * xRadius, (y + yRadius) + yPosOffset * yRadius, 0.0D)
/*   62 */         .tex((u * f + uRadius) + xPosOffset * uRadius, (v * f1 + vRadius) + yPosOffset * vRadius).endVertex();
/*      */     } 
/*   64 */     tessellator.draw();
/*      */   }
/*      */   public static Color applyOpacity(Color color, float opacity) {
/*   67 */     opacity = Math.min(1.0F, Math.max(0.0F, opacity));
/*   68 */     return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(color.getAlpha() * opacity));
/*      */   }
/*      */   public static void drawGradientRect(double left, double top, double right, double bottom, int startColor, int endColor) {
/*   71 */     float f = (startColor >> 24 & 0xFF) / 255.0F;
/*   72 */     float f1 = (startColor >> 16 & 0xFF) / 255.0F;
/*   73 */     float f2 = (startColor >> 8 & 0xFF) / 255.0F;
/*   74 */     float f3 = (startColor & 0xFF) / 255.0F;
/*   75 */     float f4 = (endColor >> 24 & 0xFF) / 255.0F;
/*   76 */     float f5 = (endColor >> 16 & 0xFF) / 255.0F;
/*   77 */     float f6 = (endColor >> 8 & 0xFF) / 255.0F;
/*   78 */     float f7 = (endColor & 0xFF) / 255.0F;
/*   79 */     GlStateManager.func_179090_x();
/*   80 */     GlStateManager.func_179147_l();
/*   81 */     GlStateManager.func_179118_c();
/*   82 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*   83 */     GlStateManager.func_179103_j(7425);
/*   84 */     Tessellator tessellator = Tessellator.func_178181_a();
/*   85 */     IWorldRenderer worldrenderer = Retreat.INSTANCE.getWrapper().getClassProvider().getTessellatorInstance().getWorldRenderer();
/*   86 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_COLOR));
/*   87 */     worldrenderer.pos(right, top, zLevel).color(f1, f2, f3, f).endVertex();
/*   88 */     worldrenderer.pos(left, top, zLevel).color(f1, f2, f3, f).endVertex();
/*   89 */     worldrenderer.pos(left, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/*   90 */     worldrenderer.pos(right, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/*   91 */     tessellator.func_78381_a();
/*   92 */     GlStateManager.func_179103_j(7424);
/*   93 */     GlStateManager.func_179084_k();
/*   94 */     GlStateManager.func_179141_d();
/*   95 */     GlStateManager.func_179098_w();
/*      */   }
/*      */   
/*      */   public static void drawGradientRect2(double x, double y, double width, double height, int startColor, int endColor) {
/*   99 */     drawGradientRect(x, y, x + width, y + height, startColor, endColor);
/*      */   }
/*      */   public static Color[] getAnalogousColor(Color color) {
/*  102 */     Color[] colors = new Color[2];
/*  103 */     float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
/*      */     
/*  105 */     float degree = 0.083333336F;
/*      */     
/*  107 */     float newHueAdded = hsb[0] + degree;
/*  108 */     colors[0] = new Color(Color.HSBtoRGB(newHueAdded, hsb[1], hsb[2]));
/*      */     
/*  110 */     float newHueSubtracted = hsb[0] - degree;
/*      */     
/*  112 */     colors[1] = new Color(Color.HSBtoRGB(newHueSubtracted, hsb[1], hsb[2]));
/*      */     
/*  114 */     return colors;
/*      */   }
/*      */   public static void drawOutLineRect(double x, double y, double x1, double y1, double width, int internalColor, int borderColor) {
/*  117 */     drawRect((float)(x + width), (float)(y + width), (float)(x1 - width), (float)(y1 - width), internalColor);
/*  118 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  119 */     drawRect((float)(x + width), (float)y, (float)(x1 - width), (float)(y + width), borderColor);
/*  120 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  121 */     drawRect((float)x, (float)y, (float)(x + width), (float)y1, borderColor);
/*  122 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  123 */     drawRect((float)(x1 - width), (float)y, (float)x1, (float)y1, borderColor);
/*  124 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  125 */     drawRect((float)(x + width), (float)(y1 - width), (float)(x1 - width), (float)y1, borderColor);
/*  126 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static Framebuffer TcreateFrameBuffer(Framebuffer framebuffer) {
/*  129 */     return TcreateFrameBuffer(framebuffer, false);
/*      */   }
/*      */   public static void drawRoundedRectArraylistfix(float x, float y, float width, float height, float radius, int color) {
/*  132 */     drawRoundedRect2(x, y, width, height + 0.2F, radius, 10, color);
/*      */   }
/*      */   public static Framebuffer TcreateFrameBuffer(Framebuffer framebuffer, boolean depth) {
/*  135 */     if (needsNewFramebuffer(framebuffer)) {
/*  136 */       if (framebuffer != null) {
/*  137 */         framebuffer.func_147608_a();
/*      */       }
/*  139 */       return new Framebuffer(mc2.field_71443_c, mc2.field_71440_d, depth);
/*      */     } 
/*  141 */     return framebuffer;
/*      */   }
/*      */   public static boolean needsNewFramebuffer(Framebuffer framebuffer) {
/*  144 */     return (framebuffer == null || framebuffer.field_147621_c != mc.getDisplayWidth() || framebuffer.field_147618_d != mc.getDisplayHeight());
/*      */   }
/*      */   public static void drawImage(ResourceLocation image, float x, float y, int width, int height, float alpha) {
/*  147 */     GlStateManager.func_179118_c();
/*  148 */     GlStateManager.func_179101_C();
/*  149 */     GlStateManager.func_179140_f();
/*  150 */     GL11.glDisable(2929);
/*  151 */     GL11.glEnable(3042);
/*  152 */     GL11.glDepthMask(false);
/*  153 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  154 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
/*  155 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(image);
/*  156 */     Gui.func_146110_a((int)x, (int)y, 0.0F, 0.0F, width, height, width, height);
/*  157 */     GL11.glDepthMask(true);
/*  158 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawTriAngle(float cx, float cy, float r, float n, Color color, boolean polygon) {
/*  161 */     cx = (float)(cx * 2.0D);
/*  162 */     cy = (float)(cy * 2.0D);
/*  163 */     double b = 6.2831852D / n;
/*  164 */     double p = Math.cos(b);
/*  165 */     double s = Math.sin(b);
/*  166 */     r = (float)(r * 2.0D);
/*  167 */     double x = r;
/*  168 */     double y = 0.0D;
/*      */     
/*  170 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/*  171 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  172 */     GL11.glLineWidth(1.0F);
/*  173 */     enableGlCap(2848);
/*  174 */     GlStateManager.func_179147_l();
/*  175 */     GlStateManager.func_179090_x();
/*  176 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  177 */     GlStateManager.func_179117_G();
/*  178 */     glColor(color);
/*  179 */     GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/*  180 */     worldrenderer.begin(polygon ? 9 : 2, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */     
/*  182 */     int ii = 0;
/*  183 */     while (ii < n) {
/*  184 */       worldrenderer.pos(x + cx, y + cy, 0.0D).endVertex();
/*  185 */       double t = x;
/*  186 */       x = p * x - s * y;
/*  187 */       y = s * t + p * y;
/*  188 */       ii++;
/*      */     } 
/*  190 */     tessellator.draw();
/*  191 */     GlStateManager.func_179098_w();
/*  192 */     GlStateManager.func_179084_k();
/*  193 */     GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
/*  194 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static void arcEllipse(float x, float y, float start, float end, float w, float h, int color) {
/*  197 */     GlStateManager.func_179124_c(0.0F, 0.0F, 0.0F);
/*  198 */     GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
/*      */     
/*  200 */     if (start > end) {
/*  201 */       float temp = end;
/*  202 */       end = start;
/*  203 */       start = temp;
/*      */     } 
/*  205 */     float var11 = (color >> 24 & 0xFF) / 255.0F;
/*  206 */     float var12 = (color >> 16 & 0xFF) / 255.0F;
/*  207 */     float var13 = (color >> 8 & 0xFF) / 255.0F;
/*  208 */     float var14 = (color & 0xFF) / 255.0F;
/*  209 */     GlStateManager.func_179147_l();
/*  210 */     GlStateManager.func_179090_x();
/*  211 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  212 */     GlStateManager.func_179131_c(var12, var13, var14, var11);
/*  213 */     if (var11 > 0.5F) {
/*  214 */       GL11.glEnable(2848);
/*  215 */       GL11.glLineWidth(2.0F);
/*  216 */       GL11.glBegin(3); float f;
/*  217 */       for (f = end; f >= start; f -= 4.0F) {
/*  218 */         float ldx = (float)(Math.cos((float)(f * Math.PI / 180.0D)) * w * 1.0010000467300415D);
/*  219 */         float ldy = (float)Math.sin(f * Math.PI / 180.0D) * h * 1.001F;
/*  220 */         GL11.glVertex2f(x + ldx, y + ldy);
/*      */       } 
/*  222 */       GL11.glEnd();
/*  223 */       GL11.glDisable(2848);
/*      */     } 
/*  225 */     GL11.glBegin(6); float i;
/*  226 */     for (i = end; i >= start; i -= 4.0F) {
/*  227 */       float ldx = (float)(Math.cos((float)(i * Math.PI / 180.0D)) * w);
/*  228 */       float ldy = (float)Math.sin(i * Math.PI / 180.0D) * h;
/*  229 */       GL11.glVertex2f(x + ldx, y + ldy);
/*      */     } 
/*  231 */     GL11.glEnd();
/*  232 */     GlStateManager.func_179098_w();
/*  233 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   public static void arcEllipse(float x, float y, float start, float end, float w, float h, Color color) {
/*  236 */     GlStateManager.func_179124_c(0.0F, 0.0F, 0.0F);
/*  237 */     GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
/*      */     
/*  239 */     if (start > end) {
/*  240 */       float temp = end;
/*  241 */       end = start;
/*  242 */       start = temp;
/*      */     } 
/*  244 */     GlStateManager.func_179147_l();
/*  245 */     GlStateManager.func_179090_x();
/*  246 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  247 */     GlStateManager.func_179131_c(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*  248 */     if (color.getAlpha() > 0.5F) {
/*  249 */       GL11.glEnable(2848);
/*  250 */       GL11.glLineWidth(2.0F);
/*  251 */       GL11.glBegin(3); float f;
/*  252 */       for (f = end; f >= start; f -= 4.0F) {
/*  253 */         float ldx = (float)(Math.cos((float)(f * Math.PI / 180.0D)) * w * 1.0010000467300415D);
/*  254 */         float ldy = MathHelper.func_76126_a((float)(f * Math.PI / 180.0D)) * h * 1.001F;
/*  255 */         GL11.glVertex2f(x + ldx, y + ldy);
/*      */       } 
/*  257 */       GL11.glEnd();
/*  258 */       GL11.glDisable(2848);
/*      */     } 
/*  260 */     GL11.glBegin(6); float i;
/*  261 */     for (i = end; i >= start; i -= 4.0F) {
/*  262 */       float ldx = (float)(Math.cos((float)(i * Math.PI / 180.0D)) * w);
/*  263 */       float ldy = MathHelper.func_76126_a((float)(i * Math.PI / 180.0D)) * h;
/*  264 */       GL11.glVertex2f(x + ldx, y + ldy);
/*      */     } 
/*  266 */     GL11.glEnd();
/*  267 */     GlStateManager.func_179098_w();
/*  268 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   
/*      */   public static void arc(float x, float y, float start, float end, float radius, int color) {
/*  272 */     arcEllipse(x, y, start, end, radius, radius, color);
/*      */   }
/*      */   public static void circle(float x, float y, float radius, int fill) {
/*  275 */     arc(x, y, 0.0F, 360.0F, radius, fill);
/*      */   }
/*      */   
/*      */   public static void customRounded(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float rTL, float rTR, float rBR, float rBL, int color) {
/*  279 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/*  280 */     float red = (color >> 16 & 0xFF) / 255.0F;
/*  281 */     float green = (color >> 8 & 0xFF) / 255.0F;
/*  282 */     float blue = (color & 0xFF) / 255.0F;
/*      */ 
/*      */     
/*  285 */     if (paramXStart > paramXEnd) {
/*  286 */       float z = paramXStart;
/*  287 */       paramXStart = paramXEnd;
/*  288 */       paramXEnd = z;
/*      */     } 
/*      */     
/*  291 */     if (paramYStart > paramYEnd) {
/*  292 */       float z = paramYStart;
/*  293 */       paramYStart = paramYEnd;
/*  294 */       paramYEnd = z;
/*      */     } 
/*      */     
/*  297 */     double xTL = (paramXStart + rTL);
/*  298 */     double yTL = (paramYStart + rTL);
/*      */     
/*  300 */     double xTR = (paramXEnd - rTR);
/*  301 */     double yTR = (paramYStart + rTR);
/*      */     
/*  303 */     double xBR = (paramXEnd - rBR);
/*  304 */     double yBR = (paramYEnd - rBR);
/*      */     
/*  306 */     double xBL = (paramXStart + rBL);
/*  307 */     double yBL = (paramYEnd - rBL);
/*      */     
/*  309 */     GL11.glPushMatrix();
/*  310 */     GL11.glEnable(3042);
/*  311 */     GL11.glDisable(3553);
/*  312 */     GL11.glBlendFunc(770, 771);
/*  313 */     GL11.glEnable(2848);
/*  314 */     GL11.glLineWidth(1.0F);
/*      */     
/*  316 */     GL11.glColor4f(red, green, blue, alpha);
/*  317 */     GL11.glBegin(9);
/*      */     
/*  319 */     double degree = 0.017453292519943295D; double i;
/*  320 */     for (i = 0.0D; i <= 90.0D; i += 0.25D)
/*  321 */       GL11.glVertex2d(xBR + Math.sin(i * degree) * rBR, yBR + Math.cos(i * degree) * rBR); 
/*  322 */     for (i = 90.0D; i <= 180.0D; i += 0.25D)
/*  323 */       GL11.glVertex2d(xTR + Math.sin(i * degree) * rTR, yTR + Math.cos(i * degree) * rTR); 
/*  324 */     for (i = 180.0D; i <= 270.0D; i += 0.25D)
/*  325 */       GL11.glVertex2d(xTL + Math.sin(i * degree) * rTL, yTL + Math.cos(i * degree) * rTL); 
/*  326 */     for (i = 270.0D; i <= 360.0D; i += 0.25D)
/*  327 */       GL11.glVertex2d(xBL + Math.sin(i * degree) * rBL, yBL + Math.cos(i * degree) * rBL); 
/*  328 */     GL11.glEnd();
/*      */     
/*  330 */     GL11.glEnable(3553);
/*  331 */     GL11.glDisable(3042);
/*  332 */     GL11.glDisable(2848);
/*  333 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawImage2(String image, int x, int y, int width, int height) {
/*  337 */     GL11.glDisable(2929);
/*  338 */     GL11.glEnable(3042);
/*  339 */     GL11.glDepthMask(false);
/*  340 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  341 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  342 */     mc.getTextureManager().bindTexture(classProvider.createResourceLocation(image));
/*  343 */     Gui.func_146110_a(x, y, 0.0F, 0.0F, width, height, width, height);
/*  344 */     GL11.glDepthMask(true);
/*  345 */     GL11.glDisable(3042);
/*  346 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawRoundedRectfix(float x, float y, float width, float height, float radius, int color) {
/*  349 */     drawRoundedRect2(x, y, x + width, y + height, radius, 10, color);
/*      */   }
/*      */   
/*      */   public static void drawImage2(@NotNull ResourceLocation resourceLocation, int i, int i1, int i2, int i3) {}
/*      */   
/*      */   public static void drawImage2(ResourceLocation image, float x, float y, int width, int height) {
/*  355 */     GL11.glDisable(2929);
/*  356 */     GL11.glEnable(3042);
/*  357 */     GL11.glDepthMask(false);
/*  358 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  359 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  360 */     GL11.glTranslatef(x, y, x);
/*  361 */     mc.getTextureManager().bindTexture2(image);
/*  362 */     Gui.func_146110_a(0, 0, 0.0F, 0.0F, width, height, width, height);
/*  363 */     GL11.glTranslatef(-x, -y, -x);
/*  364 */     GL11.glDepthMask(false);
/*  365 */     GL11.glDisable(3042);
/*  366 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawmage(ResourceLocation image, int x, int y, int width, int height, float alpha) {
/*  369 */     GL11.glDisable(2929);
/*  370 */     GL11.glEnable(3042);
/*  371 */     GL11.glDepthMask(false);
/*  372 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  373 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
/*      */     
/*  375 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(image);
/*  376 */     Gui.func_146110_a(x, y, 0.0F, 0.0F, width, height, width, height);
/*  377 */     GL11.glDepthMask(true);
/*  378 */     GL11.glDisable(3042);
/*  379 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawImage3(ResourceLocation image, float x, float y, int width, int height, float r, float g, float b, float al) {
/*  382 */     GL11.glDisable(2929);
/*  383 */     GL11.glEnable(3042);
/*  384 */     GL11.glDepthMask(false);
/*  385 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  386 */     GL11.glColor4f(r, g, b, al);
/*  387 */     GL11.glTranslatef(x, y, x);
/*  388 */     mc.getTextureManager().bindTexture2(image);
/*  389 */     Gui.func_146110_a(0, 0, 0.0F, 0.0F, width, height, width, height);
/*  390 */     GL11.glTranslatef(-x, -y, -x);
/*  391 */     GL11.glDepthMask(false);
/*  392 */     GL11.glDisable(3042);
/*  393 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void glColor4(int hex) {
/*  396 */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/*  397 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/*  398 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/*  399 */     float blue = (hex & 0xFF) / 255.0F;
/*      */     
/*  401 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*      */   }
/*      */   public static void drawShadowImage(int x, int y, int width, int height, ResourceLocation image) {
/*  404 */     GlStateManager.func_179147_l();
/*  405 */     GlStateManager.func_179118_c();
/*  406 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  407 */     mc.getTextureManager().bindTexture2(image);
/*  408 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.7F);
/*  409 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/*  410 */     GlStateManager.func_179084_k();
/*  411 */     GlStateManager.func_179141_d();
/*      */   }
/*      */   public static void drawHead(IResourceLocation skin, int x, int y, int width, int height) {
/*  414 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  415 */     mc.getTextureManager().bindTexture(skin);
/*  416 */     drawScaledCustomSizeModalRect(x, y, 8.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */     
/*  418 */     drawScaledCustomSizeModalRect(x, y, 40.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */   }
/*      */   
/*      */   public static void quickDrawHead(IResourceLocation skin, int x, int y, int width, int height) {
/*  422 */     mc.getTextureManager().bindTexture(skin);
/*  423 */     drawScaledCustomSizeModalRect(x, y, 8.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */     
/*  425 */     drawScaledCustomSizeModalRect(x, y, 40.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */   }
/*      */   
/*      */   public static void quickDrawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
/*  429 */     GL11.glBegin(7);
/*  430 */     glColor(col1);
/*  431 */     GL11.glVertex2d(left, top);
/*  432 */     GL11.glVertex2d(left, bottom);
/*      */     
/*  434 */     glColor(col2);
/*  435 */     GL11.glVertex2d(right, bottom);
/*  436 */     GL11.glVertex2d(right, top);
/*  437 */     GL11.glEnd();
/*      */   }
/*      */   public static void drawEntityOnScreen(int posX, int posY, int scale, IEntityLivingBase entity) {
/*  440 */     GlStateManager.func_179094_E();
/*  441 */     GlStateManager.func_179142_g();
/*      */     
/*  443 */     GlStateManager.func_179137_b(posX, posY, 50.0D);
/*  444 */     GlStateManager.func_179152_a(-scale, scale, scale);
/*  445 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  446 */     GlStateManager.func_179114_b(135.0F, 0.0F, 1.0F, 0.0F);
/*  447 */     RenderHelper.func_74519_b();
/*  448 */     GlStateManager.func_179114_b(-135.0F, 0.0F, 1.0F, 0.0F);
/*  449 */     GlStateManager.func_179137_b(0.0D, 0.0D, 0.0D);
/*      */     
/*  451 */     float renderYawOffset = entity.getRenderYawOffset();
/*  452 */     float rotationYaw = entity.getRotationYaw();
/*  453 */     float rotationPitch = entity.getRotationPitch();
/*  454 */     float prevRotationYawHead = entity.getPrevRotationYawHead();
/*  455 */     float rotationYawHead = entity.getRotationYawHead();
/*      */ 
/*      */     
/*  458 */     entity.setRenderYawOffset(0.0F);
/*  459 */     entity.setRotationYaw(0.0F);
/*  460 */     entity.setRotationPitch(90.0F);
/*  461 */     entity.setRotationYawHead(entity.getRotationYaw());
/*  462 */     entity.setPrevRotationYawHead(entity.getRotationYaw());
/*      */     
/*  464 */     IRenderManager rendermanager = mc.getRenderManager();
/*  465 */     rendermanager.setPlayerViewY(180.0F);
/*  466 */     rendermanager.setRenderShadow(false);
/*  467 */     rendermanager.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/*  468 */     rendermanager.setRenderShadow(true);
/*      */     
/*  470 */     entity.setRenderYawOffset(renderYawOffset);
/*  471 */     entity.setRotationYaw(rotationYaw);
/*  472 */     entity.setRotationPitch(rotationPitch);
/*  473 */     entity.setPrevRotationYawHead(prevRotationYawHead);
/*  474 */     entity.setRotationYawHead(rotationYawHead);
/*      */     
/*  476 */     GlStateManager.func_179121_F();
/*  477 */     RenderHelper.func_74518_a();
/*  478 */     GlStateManager.func_179101_C();
/*  479 */     GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
/*  480 */     GlStateManager.func_179090_x();
/*  481 */     GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
/*      */   }
/*      */   public static void illlIIIIiii(float x, float y, float start, float end, float w, float h, int color, float lineWidth) {
/*  484 */     if (start > end) {
/*  485 */       float temp = end;
/*  486 */       end = start;
/*  487 */       start = temp;
/*      */     } 
/*  489 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/*  490 */     float red = (color >> 16 & 0xFF) / 255.0F;
/*  491 */     float green = (color >> 8 & 0xFF) / 255.0F;
/*  492 */     float blue = (color & 0xFF) / 255.0F;
/*  493 */     GlStateManager.func_179147_l();
/*  494 */     GlStateManager.func_179090_x();
/*  495 */     GlStateManager.func_179120_a(770, 771, 0, 1);
/*  496 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*  497 */     GL11.glEnable(2881);
/*  498 */     GL11.glEnable(2848);
/*  499 */     GL11.glLineWidth(lineWidth);
/*  500 */     GL11.glBegin(3); float i;
/*  501 */     for (i = end; i >= start; i -= 4.0F) {
/*  502 */       GL11.glVertex2d(x + Math.cos(i * Math.PI / 180.0D) * w * 1.001D, y + Math.sin(i * Math.PI / 180.0D) * h * 1.001D);
/*      */     }
/*  504 */     GL11.glEnd();
/*  505 */     GL11.glDisable(2848);
/*  506 */     GL11.glDisable(2881);
/*  507 */     GlStateManager.func_179098_w();
/*  508 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   public static void arcIiiilllIIiii(float x, float y, float start, float end, float radius, int color, float lineWidth) {
/*  511 */     illlIIIIiii(x, y, start, end, radius, radius, color, lineWidth);
/*      */   }
/*      */   public static void drawEntityBox(IEntity entity, Color color, boolean outline, boolean box, float outlineWidth) {
/*  514 */     IRenderManager renderManager = mc.getRenderManager();
/*  515 */     ITimer timer = mc.getTimer();
/*      */     
/*  517 */     GL11.glBlendFunc(770, 771);
/*  518 */     enableGlCap(3042);
/*  519 */     disableGlCap(new int[] { 3553, 2929 });
/*  520 */     GL11.glDepthMask(false);
/*      */ 
/*      */     
/*  523 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX();
/*      */     
/*  525 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY();
/*      */     
/*  527 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ();
/*      */     
/*  529 */     IAxisAlignedBB entityBox = entity.getEntityBoundingBox();
/*  530 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(entityBox
/*  531 */         .getMinX() - entity.getPosX() + x - 0.05D, entityBox
/*  532 */         .getMaxY() - entity.getPosY() + y, entityBox
/*  533 */         .getMinZ() - entity.getPosZ() + z - 0.05D, entityBox
/*  534 */         .getMaxX() - entity.getPosX() + x + 0.05D, entityBox
/*  535 */         .getMaxY() - entity.getPosY() + y + 0.15D, entityBox
/*  536 */         .getMaxZ() - entity.getPosZ() + z + 0.05D);
/*      */ 
/*      */     
/*  539 */     if (outline) {
/*  540 */       GL11.glLineWidth(outlineWidth);
/*  541 */       enableGlCap(2848);
/*  542 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), box ? 170 : 255);
/*  543 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } 
/*      */     
/*  546 */     if (box) {
/*  547 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), outline ? 26 : 35);
/*  548 */       drawFilledBox(axisAlignedBB);
/*      */     } 
/*      */     
/*  551 */     GlStateManager.func_179117_G();
/*  552 */     GL11.glDepthMask(true);
/*  553 */     resetCaps();
/*      */   }
/*      */   
/*      */   public static void drawOutFullCircle(float x, float y, float radius, int fill, float lineWidth) {
/*  557 */     arcIiiilllIIiii(x, y, 0.0F, 360.0F, radius, fill, lineWidth);
/*      */   }
/*      */   
/*      */   public static void drawOutFullCircle(float x, float y, float radius, int fill, float lineWidth, float start, float end) {
/*  561 */     arcIiiilllIIiii(x, y, start, end, radius, fill, lineWidth);
/*      */   }
/*      */   public static Color interpolateColorsBackAndForth(int speed, int index, Color start, Color end, boolean trueColor) {
/*  564 */     int angle = (int)((System.currentTimeMillis() / speed + index) % 360L);
/*  565 */     angle = ((angle >= 180) ? (360 - angle) : angle) * 2;
/*  566 */     return trueColor ? interpolateColorHue(start, end, angle / 360.0F) : interpolateColorC(start, end, angle / 360.0F);
/*      */   }
/*      */   public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
/*  569 */     return interpolate(oldValue, newValue, (float)interpolationValue).intValue();
/*      */   }
/*      */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/*  572 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*      */   }
/*      */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/*  575 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*      */   }
/*      */   public static Color interpolateColorHue(Color color1, Color color2, float amount) {
/*  578 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/*      */     
/*  580 */     float[] color1HSB = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
/*  581 */     float[] color2HSB = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
/*      */     
/*  583 */     Color resultColor = Color.getHSBColor(interpolateFloat(color1HSB[0], color2HSB[0], amount), 
/*  584 */         interpolateFloat(color1HSB[1], color2HSB[1], amount), interpolateFloat(color1HSB[2], color2HSB[2], amount));
/*      */     
/*  586 */     return new Color(resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue(), 
/*  587 */         interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*      */   }
/*      */   public static Color interpolateColorC(Color color1, Color color2, float amount) {
/*  590 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/*  591 */     return new Color(interpolateInt(color1.getRed(), color2.getRed(), amount), 
/*  592 */         interpolateInt(color1.getGreen(), color2.getGreen(), amount), 
/*  593 */         interpolateInt(color1.getBlue(), color2.getBlue(), amount), 
/*  594 */         interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*      */   }
/*      */   public static void drawSmoothRect(double left, double top, double right, double bottom, int color) {
/*  597 */     GlStateManager.func_179117_G();
/*  598 */     GL11.glEnable(3042);
/*  599 */     GL11.glEnable(2848);
/*  600 */     drawRect(left, top, right, bottom, color);
/*  601 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*  602 */     drawRect(left * 2.0D - 1.0D, top * 2.0D, left * 2.0D, bottom * 2.0D - 1.0D, color);
/*  603 */     drawRect(left * 2.0D, top * 2.0D - 1.0D, right * 2.0D, top * 2.0D, color);
/*  604 */     drawRect(right * 2.0D, top * 2.0D, right * 2.0D + 1.0D, bottom * 2.0D - 1.0D, color);
/*  605 */     GL11.glDisable(3042);
/*  606 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/*      */   }
/*      */   public static void enable(int glTarget) {
/*  609 */     GL11.glEnable(glTarget);
/*      */   }
/*      */   
/*      */   public static void disable(int glTarget) {
/*  613 */     GL11.glDisable(glTarget);
/*      */   }
/*      */   public static void start() {
/*  616 */     enable(3042);
/*  617 */     GL11.glBlendFunc(770, 771);
/*  618 */     disable(3553);
/*  619 */     disable(2884);
/*  620 */     GlStateManager.func_179118_c();
/*  621 */     GlStateManager.func_179097_i();
/*      */   }
/*      */   
/*      */   public static void stop() {
/*  625 */     GlStateManager.func_179141_d();
/*  626 */     GlStateManager.func_179126_j();
/*  627 */     enable(2884);
/*  628 */     enable(3553);
/*  629 */     disable(3042);
/*  630 */     color(Color.white);
/*      */   }
/*      */   
/*      */   public static void startSmooth() {
/*  634 */     enable(2881);
/*  635 */     enable(2848);
/*  636 */     enable(2832);
/*      */   }
/*      */   
/*      */   public static void endSmooth() {
/*  640 */     disable(2832);
/*  641 */     disable(2848);
/*  642 */     disable(2881);
/*      */   }
/*      */   public static void begin(int glMode) {
/*  645 */     GL11.glBegin(glMode);
/*      */   }
/*      */   
/*      */   public static void end() {
/*  649 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void vertex(double x, double y) {
/*  653 */     GL11.glVertex2d(x, y);
/*      */   }
/*      */   
/*      */   public static void translate(double x, double y) {
/*  657 */     GL11.glTranslated(x, y, 0.0D);
/*      */   }
/*      */   
/*      */   public static void scale(double x, double y) {
/*  661 */     GL11.glScaled(x, y, 1.0D);
/*      */   }
/*      */   
/*      */   public static void rotate(double x, double y, double z, double angle) {
/*  665 */     GL11.glRotated(angle, x, y, z);
/*      */   }
/*      */   public static void gradientSideways(double x, double y, double width, double height, boolean filled, Color color1, Color color2) {
/*  668 */     start();
/*  669 */     GL11.glShadeModel(7425);
/*  670 */     GlStateManager.func_179118_c();
/*  671 */     if (color1 != null) {
/*  672 */       color(color1);
/*      */     }
/*      */     
/*  675 */     begin(filled ? 6 : 1);
/*  676 */     vertex(x, y);
/*  677 */     vertex(x, y + height);
/*  678 */     if (color2 != null) {
/*  679 */       color(color2);
/*      */     }
/*      */     
/*  682 */     vertex(x + width, y + height);
/*  683 */     vertex(x + width, y);
/*  684 */     end();
/*  685 */     GlStateManager.func_179141_d();
/*  686 */     GL11.glShadeModel(7424);
/*  687 */     stop();
/*      */   }
/*      */   public static void gradientSideways(double x, double y, double width, double height, Color color1, Color color2) {
/*  690 */     gradientSideways(x, y, width, height, true, color1, color2);
/*      */   }
/*      */   public static double getAnimationState2(double animation, double finalState, double speed) {
/*  693 */     float add = (float)(0.01D * speed);
/*  694 */     if (animation < finalState) {
/*  695 */       if (animation + add < finalState) {
/*  696 */         animation += add;
/*      */       } else {
/*  698 */         animation = finalState;
/*      */       } 
/*  700 */     } else if (animation - add > finalState) {
/*  701 */       animation -= add;
/*      */     } else {
/*  703 */       animation = finalState;
/*      */     } 
/*  705 */     return animation;
/*      */   }
/*      */   
/*      */   public static void drawRoundRect(float d, float e, float g, float h, int color) {
/*  709 */     drawRect(d + 1.0F, e, g, h, color);
/*  710 */     drawRect(d, e + 0.75D, d, h, color);
/*  711 */     drawRect(d, (e + 1.0F), (d + 1.0F), h - 0.5D, color);
/*  712 */     drawRect(d - 0.75D, e + 1.5D, d, h - 1.25D, color);
/*      */   }
/*      */   public static void ArrayListBGGradient(double left, double top, double right, double bottom, int col1, int col2) {
/*  715 */     float f = (col1 >> 24 & 0xFF) / 230.0F;
/*  716 */     float f1 = (col1 >> 16 & 0xFF) / 230.0F;
/*  717 */     float f2 = (col1 >> 8 & 0xFF) / 230.0F;
/*  718 */     float f3 = (col1 & 0xFF) / 230.0F;
/*  719 */     float f4 = (col2 >> 24 & 0xFF) / 230.0F;
/*  720 */     float f5 = (col2 >> 16 & 0xFF) / 230.0F;
/*  721 */     float f6 = (col2 >> 8 & 0xFF) / 230.0F;
/*  722 */     float f7 = (col2 & 0xFF) / 230.0F;
/*  723 */     GL11.glEnable(3042);
/*  724 */     GL11.glDisable(3553);
/*  725 */     GL11.glBlendFunc(770, 771);
/*  726 */     GL11.glEnable(2848);
/*  727 */     GL11.glShadeModel(7425);
/*  728 */     GL11.glPushMatrix();
/*  729 */     GL11.glBegin(7);
/*  730 */     GL11.glColor4f(f1, f2, f3, f);
/*  731 */     GL11.glVertex2d(left, top);
/*  732 */     GL11.glVertex2d(left, bottom);
/*  733 */     GL11.glColor4f(f5, f6, f7, f4);
/*  734 */     GL11.glVertex2d(right, bottom);
/*  735 */     GL11.glVertex2d(right, top);
/*  736 */     GL11.glEnd();
/*  737 */     GL11.glPopMatrix();
/*  738 */     GL11.glEnable(3553);
/*  739 */     GL11.glDisable(3042);
/*  740 */     GL11.glDisable(2848);
/*  741 */     GL11.glShadeModel(7424);
/*      */   }
/*  743 */   public static Framebuffer bloomFramebuffer = new Framebuffer(1, 1, false);
/*      */   public static void doGlScissor(int x, int y, float width, float height) {
/*  745 */     int scaleFactor = 1;
/*  746 */     float sc = 2.0F;
/*      */     
/*  748 */     while (scaleFactor < sc && mc.getDisplayWidth() / (scaleFactor + 1) >= 320 && mc.getDisplayHeight() / (scaleFactor + 1) >= 240) {
/*  749 */       scaleFactor++;
/*      */     }
/*      */     
/*  752 */     GL11.glScissor(x * scaleFactor, (int)(mc.getDisplayHeight() - (y + height) * scaleFactor), (int)(width * scaleFactor), (int)(height * scaleFactor));
/*      */   }
/*      */   public static void setColor(int color) {
/*  755 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/*  756 */     float red = (color >> 16 & 0xFF) / 255.0F;
/*  757 */     float green = (color >> 8 & 0xFF) / 255.0F;
/*  758 */     float blue = (color & 0xFF) / 255.0F;
/*  759 */     GL11.glColor4f(red, green, blue, alpha);
/*      */   }
/*      */   
/*      */   public static void drawBlockBox2(WBlockPos blockPos, Color color, boolean outline, boolean box, float outlineWidth) {
/*  763 */     IRenderManager renderManager = mc.getRenderManager();
/*  764 */     ITimer timer = mc.getTimer();
/*      */     
/*  766 */     double x = blockPos.getX() - renderManager.getRenderPosX();
/*  767 */     double y = blockPos.getY() - renderManager.getRenderPosY();
/*  768 */     double z = blockPos.getZ() - renderManager.getRenderPosZ();
/*      */     
/*  770 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
/*  771 */     IBlock block = BlockUtils.getBlock(blockPos);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  777 */     if (block != null) {
/*  778 */       IEntityPlayerSP iEntityPlayerSP = mc.getThePlayer();
/*      */       
/*  780 */       double posX = iEntityPlayerSP.getLastTickPosX() + (iEntityPlayerSP.getPosX() - iEntityPlayerSP.getLastTickPosX()) * timer.getRenderPartialTicks();
/*  781 */       double posY = iEntityPlayerSP.getLastTickPosY() + (iEntityPlayerSP.getPosY() - iEntityPlayerSP.getLastTickPosY()) * timer.getRenderPartialTicks();
/*  782 */       double posZ = iEntityPlayerSP.getLastTickPosZ() + (iEntityPlayerSP.getPosZ() - iEntityPlayerSP.getLastTickPosZ()) * timer.getRenderPartialTicks();
/*      */ 
/*      */ 
/*      */       
/*  786 */       axisAlignedBB = block.getSelectedBoundingBox((IWorld)mc.getTheWorld(), mc.getTheWorld().getBlockState(blockPos), blockPos).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-posX, -posY, -posZ);
/*      */     } 
/*      */     
/*  789 */     GL11.glBlendFunc(770, 771);
/*  790 */     enableGlCap(3042);
/*  791 */     disableGlCap(new int[] { 3553, 2929 });
/*  792 */     GL11.glDepthMask(false);
/*      */     
/*  794 */     if (box) {
/*  795 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), (color.getAlpha() != 255) ? color.getAlpha() : (outline ? 26 : 35));
/*  796 */       drawFilledBox(axisAlignedBB);
/*      */     } 
/*      */     
/*  799 */     if (outline) {
/*  800 */       GL11.glLineWidth(outlineWidth);
/*  801 */       enableGlCap(2848);
/*  802 */       glColor(color);
/*      */       
/*  804 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } 
/*      */     
/*  807 */     GlStateManager.func_179117_G();
/*  808 */     GL11.glDepthMask(true);
/*  809 */     resetCaps();
/*      */   }
/*      */   public static void startDrawing() {
/*  812 */     GL11.glEnable(3042);
/*  813 */     GL11.glEnable(3042);
/*  814 */     GL11.glBlendFunc(770, 771);
/*  815 */     GL11.glEnable(2848);
/*  816 */     GL11.glDisable(3553);
/*  817 */     GL11.glDisable(2929);
/*  818 */     (Minecraft.func_71410_x()).field_71460_t.func_78479_a((Minecraft.func_71410_x()).field_71428_T.field_194147_b, 0);
/*      */   }
/*      */   public static void stopDrawing() {
/*  821 */     GL11.glDisable(3042);
/*  822 */     GL11.glEnable(3553);
/*  823 */     GL11.glDisable(2848);
/*  824 */     GL11.glDisable(3042);
/*  825 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static int reAlpha(int color, float alpha) {
/*  828 */     Color c = new Color(color);
/*  829 */     float r = 0.003921569F * c.getRed();
/*  830 */     float g = 0.003921569F * c.getGreen();
/*  831 */     float b = 0.003921569F * c.getBlue();
/*  832 */     return (new Color(r, g, b, alpha)).getRGB();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void newDrawRect(float left, float top, float right, float bottom, int color) {
/*  837 */     if (left < right) {
/*      */       
/*  839 */       float i = left;
/*  840 */       left = right;
/*  841 */       right = i;
/*      */     } 
/*      */     
/*  844 */     if (top < bottom) {
/*      */       
/*  846 */       float j = top;
/*  847 */       top = bottom;
/*  848 */       bottom = j;
/*      */     } 
/*      */     
/*  851 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/*  852 */     float f = (color >> 16 & 0xFF) / 255.0F;
/*  853 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/*  854 */     float f2 = (color & 0xFF) / 255.0F;
/*  855 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  856 */     BufferBuilder worldrenderer = tessellator.func_178180_c();
/*  857 */     GlStateManager.func_179147_l();
/*  858 */     GlStateManager.func_179090_x();
/*  859 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  860 */     GlStateManager.func_179131_c(f, f1, f2, f3);
/*  861 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
/*  862 */     worldrenderer.func_181662_b(left, bottom, 0.0D).func_181675_d();
/*  863 */     worldrenderer.func_181662_b(right, bottom, 0.0D).func_181675_d();
/*  864 */     worldrenderer.func_181662_b(right, top, 0.0D).func_181675_d();
/*  865 */     worldrenderer.func_181662_b(left, top, 0.0D).func_181675_d();
/*  866 */     tessellator.func_78381_a();
/*  867 */     GlStateManager.func_179098_w();
/*  868 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   public static void quickRenderCircle(double x, double y, double start, double end, double w, double h) {
/*  871 */     if (start > end) {
/*  872 */       double temp = end;
/*  873 */       end = start;
/*  874 */       start = temp;
/*      */     } 
/*      */     
/*  877 */     GL11.glBegin(6);
/*  878 */     GL11.glVertex2d(x, y); double i;
/*  879 */     for (i = end; i >= start; i -= 4.0D) {
/*  880 */       double ldx = Math.cos(i * Math.PI / 180.0D) * w;
/*  881 */       double ldy = Math.sin(i * Math.PI / 180.0D) * h;
/*  882 */       GL11.glVertex2d(x + ldx, y + ldy);
/*      */     } 
/*  884 */     GL11.glVertex2d(x, y);
/*  885 */     GL11.glEnd();
/*      */   }
/*      */   public static void drawCircle3(float x, float y, float radius, float lineWidth, int start, int end, Color color) {
/*  888 */     GlStateManager.func_179147_l();
/*  889 */     GlStateManager.func_179090_x();
/*  890 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  891 */     glColor(color);
/*      */     
/*  893 */     GL11.glEnable(2848);
/*  894 */     GL11.glLineWidth(lineWidth);
/*  895 */     GL11.glBegin(3); float i;
/*  896 */     for (i = end; i >= start; i -= 4.0F)
/*      */     {
/*  898 */       GL11.glVertex2f((float)(x + Math.cos(i * Math.PI / 180.0D) * (radius * 1.001F)), (float)(y + Math.sin(i * Math.PI / 180.0D) * (radius * 1.001F)));
/*      */     }
/*  900 */     GL11.glEnd();
/*  901 */     GL11.glDisable(2848);
/*      */     
/*  903 */     GlStateManager.func_179098_w();
/*  904 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   public static void drawCircleRect(float x, float y, float x1, float y1, float radius, int color) {
/*  907 */     GlStateManager.func_179147_l();
/*  908 */     GlStateManager.func_179090_x();
/*  909 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  910 */     glColor(color);
/*      */ 
/*      */     
/*  913 */     quickRenderCircle((x1 - radius), (y1 - radius), 0.0D, 90.0D, radius, radius);
/*  914 */     quickRenderCircle((x + radius), (y1 - radius), 90.0D, 180.0D, radius, radius);
/*  915 */     quickRenderCircle((x + radius), (y + radius), 180.0D, 270.0D, radius, radius);
/*  916 */     quickRenderCircle((x1 - radius), (y + radius), 270.0D, 360.0D, radius, radius);
/*      */ 
/*      */     
/*  919 */     quickDrawRect(x + radius, y + radius, x1 - radius, y1 - radius);
/*  920 */     quickDrawRect(x, y + radius, x + radius, y1 - radius);
/*  921 */     quickDrawRect(x1 - radius, y + radius, x1, y1 - radius);
/*  922 */     quickDrawRect(x + radius, y, x1 - radius, y + radius);
/*  923 */     quickDrawRect(x + radius, y1 - radius, x1 - radius, y1);
/*      */     
/*  925 */     GlStateManager.func_179098_w();
/*  926 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   public static int SkyRainbow(int var2, float st, float bright) {
/*  929 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  930 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright).getRGB();
/*      */   }
/*      */   public static int getRainbowOpaque(int seconds, float saturation, float brightness, int index) {
/*  933 */     float hue = (float)((System.currentTimeMillis() + index) % (seconds * 1000)) / (seconds * 1000);
/*  934 */     int color = Color.HSBtoRGB(hue, saturation, brightness);
/*  935 */     return color;
/*      */   }
/*      */   public static Color skyRainbow(int var2, float bright, float st, double speed) {
/*  938 */     double v1 = Math.ceil(System.currentTimeMillis() / speed + (var2 * 109L)) / 5.0D;
/*  939 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor1(int color) {}
/*      */   
/*      */   public static Color skyRainbow(int var2, float st, float bright) {
/*  946 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  947 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*      */   }
/*      */   public static void fastRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius) {
/*  950 */     float z = 0.0F;
/*  951 */     if (paramXStart > paramXEnd) {
/*  952 */       z = paramXStart;
/*  953 */       paramXStart = paramXEnd;
/*  954 */       paramXEnd = z;
/*      */     } 
/*      */     
/*  957 */     if (paramYStart > paramYEnd) {
/*  958 */       z = paramYStart;
/*  959 */       paramYStart = paramYEnd;
/*  960 */       paramYEnd = z;
/*      */     } 
/*      */     
/*  963 */     double x1 = (paramXStart + radius);
/*  964 */     double y1 = (paramYStart + radius);
/*  965 */     double x2 = (paramXEnd - radius);
/*  966 */     double y2 = (paramYEnd - radius);
/*      */     
/*  968 */     GL11.glEnable(2848);
/*  969 */     GL11.glLineWidth(1.0F);
/*      */     
/*  971 */     GL11.glBegin(9);
/*      */     
/*  973 */     double degree = 0.017453292519943295D; double i;
/*  974 */     for (i = 0.0D; i <= 90.0D; i++)
/*  975 */       GL11.glVertex2d(x2 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius); 
/*  976 */     for (i = 90.0D; i <= 180.0D; i++)
/*  977 */       GL11.glVertex2d(x2 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius); 
/*  978 */     for (i = 180.0D; i <= 270.0D; i++)
/*  979 */       GL11.glVertex2d(x1 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius); 
/*  980 */     for (i = 270.0D; i <= 360.0D; i++)
/*  981 */       GL11.glVertex2d(x1 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius); 
/*  982 */     GL11.glEnd();
/*  983 */     GL11.glDisable(2848);
/*      */   }
/*      */   
/*      */   public static void autoExhibition(double x, double y, double x1, double y1, double size) {
/*  987 */     rectangleBordered(x, y, x1 + size, y1 + size, 0.5D, Colors.getColor(90), Colors.getColor(0));
/*  988 */     rectangleBordered(x + 1.0D, y + 1.0D, x1 + size - 1.0D, y1 + size - 1.0D, 1.0D, Colors.getColor(90), Colors.getColor(61));
/*  989 */     rectangleBordered(x + 2.5D, y + 2.5D, x1 + size - 2.5D, y1 + size - 2.5D, 0.5D, Colors.getColor(61), Colors.getColor(0));
/*      */   }
/*      */   
/*      */   public static void rectangleBordered(double x, double y, double x1, double y1, double width, int internalColor, int borderColor) {
/*  993 */     rectangle(x + width, y + width, x1 - width, y1 - width, internalColor);
/*  994 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  995 */     rectangle(x + width, y, x1 - width, y + width, borderColor);
/*  996 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  997 */     rectangle(x, y, x + width, y1, borderColor);
/*  998 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  999 */     rectangle(x1 - width, y, x1, y1, borderColor);
/* 1000 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 1001 */     rectangle(x + width, y1 - width, x1 - width, y1, borderColor);
/* 1002 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static int Astolfo(int var2, float bright, float st, int index, int offset, float client) {
/* 1005 */     double rainbowDelay = Math.ceil((System.currentTimeMillis() + (var2 * index))) / offset;
/* 1006 */     return Color.getHSBColor(((float)((rainbowDelay %= client) / client) < 0.5D) ? -((float)(rainbowDelay / client)) : (float)(rainbowDelay / client), st, bright).getRGB();
/*      */   }
/*      */   public static int getRainbow(int index, int offset, float bright, float st) {
/* 1009 */     float hue = (float)((System.currentTimeMillis() + offset * index) % 2000L);
/* 1010 */     return Color.getHSBColor(hue /= 2000.0F, st, bright).getRGB();
/*      */   }
/*      */   public static void drawGradientSidewaysH(double left, double top, double right, double bottom, int col1, int col2) {
/* 1013 */     GL11.glEnable(3042);
/* 1014 */     GL11.glDisable(3553);
/* 1015 */     GL11.glBlendFunc(770, 771);
/* 1016 */     GL11.glEnable(2848);
/* 1017 */     GL11.glShadeModel(7425);
/*      */     
/* 1019 */     quickDrawGradientSidewaysH(left, top, right, bottom, col1, col2);
/*      */     
/* 1021 */     GL11.glEnable(3553);
/* 1022 */     GL11.glDisable(3042);
/* 1023 */     GL11.glDisable(2848);
/* 1024 */     GL11.glShadeModel(7424);
/*      */   }
/*      */   
/*      */   public static void quickDrawGradientSidewaysH(double left, double top, double right, double bottom, int col1, int col2) {
/* 1028 */     GL11.glBegin(7);
/*      */     
/* 1030 */     glColor(col1);
/* 1031 */     GL11.glVertex2d(left, top);
/* 1032 */     GL11.glVertex2d(left, bottom);
/* 1033 */     glColor(col2);
/* 1034 */     GL11.glVertex2d(right, bottom);
/* 1035 */     GL11.glVertex2d(right, top);
/*      */     
/* 1037 */     GL11.glEnd();
/*      */   }
/*      */   public static void drawArc(float n, float n2, double n3, int n4, int n5, double n6, int n7) {
/* 1040 */     n3 *= 2.0D;
/* 1041 */     n *= 2.0F;
/* 1042 */     n2 *= 2.0F;
/* 1043 */     float n8 = (n4 >> 24 & 0xFF) / 255.0F;
/* 1044 */     float n9 = (n4 >> 16 & 0xFF) / 255.0F;
/* 1045 */     float n10 = (n4 >> 8 & 0xFF) / 255.0F;
/* 1046 */     float n11 = (n4 & 0xFF) / 255.0F;
/* 1047 */     GL11.glDisable(2929);
/* 1048 */     GL11.glEnable(3042);
/* 1049 */     GL11.glDisable(3553);
/* 1050 */     GL11.glBlendFunc(770, 771);
/* 1051 */     GL11.glDepthMask(true);
/* 1052 */     GL11.glEnable(2848);
/* 1053 */     GL11.glHint(3154, 4354);
/* 1054 */     GL11.glHint(3155, 4354);
/* 1055 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 1056 */     GL11.glLineWidth(n7);
/* 1057 */     GL11.glEnable(2848);
/* 1058 */     GL11.glColor4f(n9, n10, n11, n8);
/* 1059 */     GL11.glBegin(3);
/* 1060 */     int n12 = n5;
/* 1061 */     while (n12 <= n6) {
/* 1062 */       GL11.glVertex2d(n + Math.sin(n12 * Math.PI / 180.0D) * n3, n2 + Math.cos(n12 * Math.PI / 180.0D) * n3);
/* 1063 */       n12++;
/*      */     } 
/* 1065 */     GL11.glEnd();
/* 1066 */     GL11.glDisable(2848);
/* 1067 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 1068 */     GL11.glEnable(3553);
/* 1069 */     GL11.glDisable(3042);
/* 1070 */     GL11.glEnable(2929);
/* 1071 */     GL11.glDisable(2848);
/* 1072 */     GL11.glHint(3154, 4352);
/* 1073 */     GL11.glHint(3155, 4352);
/*      */   }
/*      */   static {
/* 1076 */     for (int i = 0; i < DISPLAY_LISTS_2D.length; i++) {
/* 1077 */       DISPLAY_LISTS_2D[i] = GL11.glGenLists(1);
/*      */     }
/*      */     
/* 1080 */     GL11.glNewList(DISPLAY_LISTS_2D[0], 4864);
/*      */     
/* 1082 */     quickDrawRect(-7.0F, 2.0F, -4.0F, 3.0F);
/* 1083 */     quickDrawRect(4.0F, 2.0F, 7.0F, 3.0F);
/* 1084 */     quickDrawRect(-7.0F, 0.5F, -6.0F, 3.0F);
/* 1085 */     quickDrawRect(6.0F, 0.5F, 7.0F, 3.0F);
/*      */     
/* 1087 */     GL11.glEndList();
/*      */     
/* 1089 */     GL11.glNewList(DISPLAY_LISTS_2D[1], 4864);
/*      */     
/* 1091 */     quickDrawRect(-7.0F, 3.0F, -4.0F, 3.3F);
/* 1092 */     quickDrawRect(4.0F, 3.0F, 7.0F, 3.3F);
/* 1093 */     quickDrawRect(-7.3F, 0.5F, -7.0F, 3.3F);
/* 1094 */     quickDrawRect(7.0F, 0.5F, 7.3F, 3.3F);
/*      */     
/* 1096 */     GL11.glEndList();
/*      */     
/* 1098 */     GL11.glNewList(DISPLAY_LISTS_2D[2], 4864);
/*      */     
/* 1100 */     quickDrawRect(4.0F, -20.0F, 7.0F, -19.0F);
/* 1101 */     quickDrawRect(-7.0F, -20.0F, -4.0F, -19.0F);
/* 1102 */     quickDrawRect(6.0F, -20.0F, 7.0F, -17.5F);
/* 1103 */     quickDrawRect(-7.0F, -20.0F, -6.0F, -17.5F);
/*      */     
/* 1105 */     GL11.glEndList();
/*      */     
/* 1107 */     GL11.glNewList(DISPLAY_LISTS_2D[3], 4864);
/*      */     
/* 1109 */     quickDrawRect(7.0F, -20.0F, 7.3F, -17.5F);
/* 1110 */     quickDrawRect(-7.3F, -20.0F, -7.0F, -17.5F);
/* 1111 */     quickDrawRect(4.0F, -20.3F, 7.3F, -20.0F);
/* 1112 */     quickDrawRect(-7.3F, -20.3F, -4.0F, -20.0F);
/*      */     
/* 1114 */     GL11.glEndList();
/*      */   }
/*      */   public static void drawCircleESP(IEntity entity, double rad, int color, boolean shade) {
/* 1117 */     GL11.glPushMatrix();
/* 1118 */     GL11.glDisable(3553);
/* 1119 */     GL11.glEnable(2848);
/* 1120 */     GL11.glEnable(2832);
/* 1121 */     GL11.glEnable(3042);
/* 1122 */     GL11.glBlendFunc(770, 771);
/* 1123 */     GL11.glHint(3154, 4354);
/* 1124 */     GL11.glHint(3155, 4354);
/* 1125 */     GL11.glHint(3153, 4354);
/* 1126 */     GL11.glDepthMask(false);
/* 1127 */     GlStateManager.func_179092_a(516, 0.0F);
/* 1128 */     if (shade) GL11.glShadeModel(7425); 
/* 1129 */     GlStateManager.func_179129_p();
/* 1130 */     GL11.glBegin(5);
/*      */     
/* 1132 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * mc.getTimer().getRenderPartialTicks() - mc.getRenderManager().getRenderPosX();
/* 1133 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * mc.getTimer().getRenderPartialTicks() - mc.getRenderManager().getRenderPosY() + Math.sin(System.currentTimeMillis() / 200.0D) + 1.0D;
/* 1134 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * mc.getTimer().getRenderPartialTicks() - mc.getRenderManager().getRenderPosZ();
/*      */     
/*      */     float i;
/*      */     
/* 1138 */     for (i = 0.0F; i < 6.283185307179586D; i = (float)(i + 0.09817477042468103D)) {
/* 1139 */       double vecX = x + rad * Math.cos(i);
/* 1140 */       double vecZ = z + rad * Math.sin(i);
/*      */       
/* 1142 */       Color c = ColorUtils.rainbow();
/*      */       
/* 1144 */       if (shade) {
/* 1145 */         GL11.glColor4f(c.getRed() / 255.0F, c
/* 1146 */             .getGreen() / 255.0F, c
/* 1147 */             .getBlue() / 255.0F, 0.0F);
/*      */ 
/*      */         
/* 1150 */         GL11.glVertex3d(vecX, y - Math.cos(System.currentTimeMillis() / 200.0D) / 2.0D, vecZ);
/* 1151 */         GL11.glColor4f(c.getRed() / 255.0F, c
/* 1152 */             .getGreen() / 255.0F, c
/* 1153 */             .getBlue() / 255.0F, 0.85F);
/*      */       } 
/*      */ 
/*      */       
/* 1157 */       GL11.glVertex3d(vecX, y, vecZ);
/*      */     } 
/*      */     
/* 1160 */     GL11.glEnd();
/* 1161 */     if (shade) GL11.glShadeModel(7424); 
/* 1162 */     GL11.glDepthMask(true);
/* 1163 */     GL11.glEnable(2929);
/* 1164 */     GlStateManager.func_179092_a(516, 0.1F);
/* 1165 */     GlStateManager.func_179089_o();
/* 1166 */     GL11.glDisable(2848);
/* 1167 */     GL11.glDisable(2848);
/* 1168 */     GL11.glEnable(2832);
/* 1169 */     GL11.glEnable(3553);
/* 1170 */     GL11.glPopMatrix();
/* 1171 */     GL11.glColor3f(255.0F, 255.0F, 255.0F);
/*      */   }
/*      */   
/*      */   public static void setAlphaLimit(float limit) {
/* 1175 */     GlStateManager.func_179141_d();
/* 1176 */     GlStateManager.func_179092_a(516, (float)(limit * 0.01D));
/*      */   }
/*      */   
/*      */   public static void rectangle(double left, double top, double right, double bottom, int color) {
/* 1180 */     if (left < right) {
/* 1181 */       double var5 = left;
/* 1182 */       left = right;
/* 1183 */       right = var5;
/*      */     } 
/* 1185 */     if (top < bottom) {
/* 1186 */       double var5 = top;
/* 1187 */       top = bottom;
/* 1188 */       bottom = var5;
/*      */     } 
/* 1190 */     float var11 = (color >> 24 & 0xFF) / 255.0F;
/* 1191 */     float var6 = (color >> 16 & 0xFF) / 255.0F;
/* 1192 */     float var7 = (color >> 8 & 0xFF) / 255.0F;
/* 1193 */     float var8 = (color & 0xFF) / 255.0F;
/* 1194 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1195 */     IWorldRenderer worldRenderer = tessellator.getWorldRenderer();
/* 1196 */     GlStateManager.func_179147_l();
/* 1197 */     GlStateManager.func_179090_x();
/* 1198 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 1199 */     GlStateManager.func_179131_c(var6, var7, var8, var11);
/* 1200 */     worldRenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 1201 */     worldRenderer.pos(left, bottom, 0.0D).endVertex();
/* 1202 */     worldRenderer.pos(right, bottom, 0.0D).endVertex();
/* 1203 */     worldRenderer.pos(right, top, 0.0D).endVertex();
/* 1204 */     worldRenderer.pos(left, top, 0.0D).endVertex();
/* 1205 */     Tessellator.func_178181_a().func_78381_a();
/* 1206 */     GlStateManager.func_179098_w();
/* 1207 */     GlStateManager.func_179084_k();
/* 1208 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static int loadGlTexture(BufferedImage bufferedImage) {
/* 1211 */     int textureId = GL11.glGenTextures();
/*      */     
/* 1213 */     GL11.glBindTexture(3553, textureId);
/*      */     
/* 1215 */     GL11.glTexParameteri(3553, 10242, 10497);
/* 1216 */     GL11.glTexParameteri(3553, 10243, 10497);
/* 1217 */     GL11.glTexParameteri(3553, 10241, 9729);
/* 1218 */     GL11.glTexParameteri(3553, 10240, 9729);
/*      */     
/* 1220 */     GL11.glTexImage2D(3553, 0, 6408, bufferedImage.getWidth(), bufferedImage.getHeight(), 0, 6408, 5121, 
/* 1221 */         ImageUtils.readImageToBuffer(bufferedImage));
/*      */     
/* 1223 */     GL11.glBindTexture(3553, 0);
/*      */     
/* 1225 */     return textureId;
/*      */   }
/*      */   public static Color getGradientOffset2(Color color1, Color color2, double gident) {
/* 1228 */     if (gident > 1.0D) {
/* 1229 */       double f1 = gident % 1.0D;
/* 1230 */       int f2 = (int)gident;
/* 1231 */       gident = (f2 % 2 == 0) ? f1 : (1.0D - f1);
/*      */     } 
/* 1233 */     double f3 = 1.0D - gident;
/* 1234 */     int f4 = (int)(color1.getRed() * f3 + color2.getRed() * gident);
/* 1235 */     int f5 = (int)(color1.getGreen() * f3 + color2.getGreen() * gident);
/* 1236 */     int f6 = (int)(color1.getBlue() * f3 + color2.getBlue() * gident);
/* 1237 */     return new Color(f4, f5, f6);
/*      */   }
/*      */   
/*      */   public static boolean glEnableBlend() {
/* 1241 */     boolean wasEnabled = GL11.glIsEnabled(3042);
/*      */     
/* 1243 */     if (!wasEnabled) {
/* 1244 */       GL11.glEnable(3042);
/* 1245 */       GL14.glBlendFuncSeparate(770, 771, 1, 0);
/*      */     } 
/*      */     
/* 1248 */     return wasEnabled;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDrawFramebuffer(int framebufferTexture, int width, int height) {
/* 1253 */     GL11.glBindTexture(3553, framebufferTexture);
/*      */     
/* 1255 */     GL11.glDisable(3008);
/*      */     
/* 1257 */     boolean restore = glEnableBlend();
/*      */     
/* 1259 */     GL11.glBegin(7);
/*      */     
/* 1261 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 1262 */     GL11.glVertex2f(0.0F, 0.0F);
/*      */     
/* 1264 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 1265 */     GL11.glVertex2f(0.0F, height);
/*      */     
/* 1267 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 1268 */     GL11.glVertex2f(width, height);
/*      */     
/* 1270 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 1271 */     GL11.glVertex2f(width, 0.0F);
/*      */     
/* 1273 */     GL11.glEnd();
/*      */     
/* 1275 */     glRestoreBlend(restore);
/*      */     
/* 1277 */     GL11.glEnable(3008);
/*      */   }
/*      */   
/*      */   public static void glRestoreBlend(boolean wasEnabled) {
/* 1281 */     if (!wasEnabled) {
/* 1282 */       GL11.glDisable(3042);
/*      */     }
/*      */   }
/*      */   
/*      */   public static void drawTexturedRectWithCustomAlpha(float x, float y, float width, float height, String image, float alpha) {
/* 1287 */     GL11.glPushMatrix();
/* 1288 */     boolean enableBlend = GL11.glIsEnabled(3042);
/* 1289 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/* 1290 */     if (!enableBlend) GL11.glEnable(3042); 
/* 1291 */     if (!disableAlpha) GL11.glDisable(3008); 
/* 1292 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, alpha);
/* 1293 */     minecraft.func_110434_K().func_110577_a(new ResourceLocation("shaders/" + image + ".png"));
/* 1294 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/* 1295 */     if (!enableBlend) GL11.glDisable(3042); 
/* 1296 */     if (!disableAlpha) GL11.glEnable(3008); 
/* 1297 */     GlStateManager.func_179117_G();
/* 1298 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawModalRectWithCustomSizedTexture(float x, float y, float u, float v, float width, float height, float textureWidth, float textureHeight) {
/* 1302 */     float f = 1.0F / textureWidth;
/* 1303 */     float f1 = 1.0F / textureHeight;
/* 1304 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1305 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 1306 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 1307 */     worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + height) * f1)).endVertex();
/* 1308 */     worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + width) * f), ((v + height) * f1)).endVertex();
/* 1309 */     worldrenderer.pos((x + width), y, 0.0D).tex(((u + width) * f), (v * f1)).endVertex();
/* 1310 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/* 1311 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void drawShadowWithCustomAlpha(float x, float y, float width, float height, float alpha) {
/* 1315 */     drawTexturedRectWithCustomAlpha(x - 9.0F, y - 9.0F, 9.0F, 9.0F, "paneltopleft", alpha);
/* 1316 */     drawTexturedRectWithCustomAlpha(x - 9.0F, y + height, 9.0F, 9.0F, "panelbottomleft", alpha);
/* 1317 */     drawTexturedRectWithCustomAlpha(x + width, y + height, 9.0F, 9.0F, "panelbottomright", alpha);
/* 1318 */     drawTexturedRectWithCustomAlpha(x + width, y - 9.0F, 9.0F, 9.0F, "paneltopright", alpha);
/* 1319 */     drawTexturedRectWithCustomAlpha(x - 9.0F, y, 9.0F, height, "panelleft", alpha);
/* 1320 */     drawTexturedRectWithCustomAlpha(x + width, y, 9.0F, height, "panelright", alpha);
/* 1321 */     drawTexturedRectWithCustomAlpha(x, y - 9.0F, width, 9.0F, "paneltop", alpha);
/* 1322 */     drawTexturedRectWithCustomAlpha(x, y + height, width, 9.0F, "panelbottom", alpha);
/*      */   }
/*      */   public static void drawShadow(float x, float y, float width, float height) {
/* 1325 */     drawTexturedRect(x - 9.0F, y - 9.0F, 9.0F, 9.0F, "paneltopleft");
/* 1326 */     drawTexturedRect(x - 9.0F, y + height, 9.0F, 9.0F, "panelbottomleft");
/* 1327 */     drawTexturedRect(x + width, y + height, 9.0F, 9.0F, "panelbottomright");
/* 1328 */     drawTexturedRect(x + width, y - 9.0F, 9.0F, 9.0F, "paneltopright");
/* 1329 */     drawTexturedRect(x - 9.0F, y, 9.0F, height, "panelleft");
/* 1330 */     drawTexturedRect(x + width, y, 9.0F, height, "panelright");
/* 1331 */     drawTexturedRect(x, y - 9.0F, width, 9.0F, "paneltop");
/* 1332 */     drawTexturedRect(x, y + height, width, 9.0F, "panelbottom");
/*      */   }
/*      */   public static void drawTexturedRect(float x, float y, float width, float height, String image) {
/* 1335 */     GL11.glPushMatrix();
/* 1336 */     boolean enableBlend = GL11.glIsEnabled(3042);
/* 1337 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/* 1338 */     if (!enableBlend) {
/* 1339 */       GL11.glEnable(3042);
/*      */     }
/* 1341 */     if (!disableAlpha) {
/* 1342 */       GL11.glDisable(3008);
/*      */     }
/* 1344 */     minecraft.func_110434_K().func_110577_a(new ResourceLocation("shaders/" + image + ".png"));
/* 1345 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 1346 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/* 1347 */     if (!enableBlend) {
/* 1348 */       GL11.glDisable(3042);
/*      */     }
/* 1350 */     if (!disableAlpha) {
/* 1351 */       GL11.glEnable(3008);
/*      */     }
/* 1353 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Color getGradientOffset(Color color1, Color color2, double offset) {
/* 1360 */     if (offset > 1.0D) {
/* 1361 */       double d = offset % 1.0D;
/* 1362 */       int i = (int)offset;
/* 1363 */       offset = (i % 2 == 0) ? d : (1.0D - d);
/*      */     } 
/*      */     
/* 1366 */     double inverse_percent = 1.0D - offset;
/* 1367 */     int redPart = (int)(color1.getRed() * inverse_percent + color2.getRed() * offset);
/* 1368 */     int greenPart = (int)(color1.getGreen() * inverse_percent + color2.getGreen() * offset);
/* 1369 */     int bluePart = (int)(color1.getBlue() * inverse_percent + color2.getBlue() * offset);
/* 1370 */     return new Color(redPart, greenPart, bluePart);
/*      */   }
/*      */   
/*      */   public static void drawRoundedRect2(float left, float top, float right, float bottom, float radius, int points, int color) {
/* 1374 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 1375 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 1376 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 1377 */     float f2 = (color & 0xFF) / 255.0F;
/*      */     
/* 1379 */     if (left < right) left = left + right - (right = left); 
/* 1380 */     if (top < bottom) top = top + bottom - (bottom = top);
/*      */     
/* 1382 */     float[][] corners = { { right + radius, top - radius, 270.0F }, { left - radius, top - radius, 360.0F }, { left - radius, bottom + radius, 90.0F }, { right + radius, bottom + radius, 180.0F } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1388 */     GlStateManager.func_179147_l();
/* 1389 */     GlStateManager.func_179090_x();
/* 1390 */     GlStateManager.func_179092_a(516, 0.003921569F);
/* 1391 */     GlStateManager.func_179131_c(f, f1, f2, f3);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1396 */     GL11.glEnable(2848);
/*      */     
/* 1398 */     GL11.glHint(3154, 4354);
/*      */ 
/*      */     
/* 1401 */     GL11.glLineWidth(2.0F);
/*      */     
/* 1403 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 1404 */     BufferBuilder renderer = tessellator.func_178180_c();
/* 1405 */     renderer.func_181668_a(9, DefaultVertexFormats.field_181705_e);
/* 1406 */     for (float[] c : corners) {
/* 1407 */       for (int i = 0; i <= points; i++) {
/* 1408 */         double anglerad = Math.PI * (c[2] + i * 90.0F / points) / 180.0D;
/* 1409 */         renderer.func_181662_b(c[0] + Math.sin(anglerad) * radius, c[1] + Math.cos(anglerad) * radius, 0.0D).func_181675_d();
/*      */       } 
/*      */     } 
/*      */     
/* 1413 */     GL11.glDisable(2848);
/*      */     
/* 1415 */     tessellator.func_78381_a();
/* 1416 */     GlStateManager.func_179084_k();
/* 1417 */     GlStateManager.func_179098_w();
/*      */   }
/*      */   public static void drawRoundedRect2(float x, float y, float width, float height, float radius, int color) {
/* 1420 */     float x1 = x + width;
/* 1421 */     float y1 = y + height;
/* 1422 */     float f = (color >> 24 & 0xFF) / 255.0F;
/* 1423 */     float f1 = (color >> 16 & 0xFF) / 255.0F;
/* 1424 */     float f2 = (color >> 8 & 0xFF) / 255.0F;
/* 1425 */     float f3 = (color & 0xFF) / 255.0F;
/* 1426 */     GL11.glPushAttrib(0);
/* 1427 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*      */     
/* 1429 */     x *= 2.0F;
/* 1430 */     y *= 2.0F;
/* 1431 */     x1 *= 2.0F;
/* 1432 */     y1 *= 2.0F;
/*      */     
/* 1434 */     GL11.glDisable(3553);
/* 1435 */     GL11.glColor4f(f1, f2, f3, f);
/* 1436 */     GlStateManager.func_179147_l();
/* 1437 */     GL11.glEnable(2848);
/*      */     
/* 1439 */     GL11.glBegin(9);
/* 1440 */     double v = 0.017453292519943295D;
/*      */     int i;
/* 1442 */     for (i = 0; i <= 90; i += 3) {
/* 1443 */       GL11.glVertex2d((x + radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius * -1.0F), (y + radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius * -1.0F));
/*      */     }
/*      */     
/* 1446 */     for (i = 90; i <= 180; i += 3) {
/* 1447 */       GL11.glVertex2d((x + radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius * -1.0F), (y1 - radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius * -1.0F));
/*      */     }
/*      */     
/* 1450 */     for (i = 0; i <= 90; i += 3) {
/* 1451 */       GL11.glVertex2d((x1 - radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius), (y1 - radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius));
/*      */     }
/*      */     
/* 1454 */     for (i = 90; i <= 180; i += 3) {
/* 1455 */       GL11.glVertex2d((x1 - radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius), (y + radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius));
/*      */     }
/*      */     
/* 1458 */     GL11.glEnd();
/*      */     
/* 1460 */     GL11.glEnable(3553);
/* 1461 */     GL11.glDisable(2848);
/* 1462 */     GL11.glEnable(3553);
/*      */     
/* 1464 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/*      */     
/* 1466 */     GL11.glPopAttrib();
/* 1467 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static void resetColor() {
/* 1470 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public static void bindTexture(int texture) {
/* 1474 */     GL11.glBindTexture(3553, texture);
/*      */   }
/*      */   
/*      */   public static Framebuffer createFrameBuffer(Framebuffer framebuffer) {
/* 1478 */     if (framebuffer == null || framebuffer.field_147621_c != mc.getDisplayWidth() || framebuffer.field_147618_d != mc.getDisplayHeight()) {
/* 1479 */       if (framebuffer != null) {
/* 1480 */         framebuffer.func_147608_a();
/*      */       }
/* 1482 */       return new Framebuffer(mc.getDisplayWidth(), mc.getDisplayHeight(), true);
/*      */     } 
/* 1484 */     return framebuffer;
/*      */   }
/*      */   
/*      */   public static void drawOutlinedString(String str, int x, int y, int color, int color2) {
/* 1488 */     mc.getFontRendererObj().drawString(str, (int)(x - 1.0F), y, color2);
/* 1489 */     mc.getFontRendererObj().drawString(str, (int)(x + 1.0F), y, color2);
/* 1490 */     mc.getFontRendererObj().drawString(str, x, (int)(y + 1.0F), color2);
/* 1491 */     mc.getFontRendererObj().drawString(str, x, (int)(y - 1.0F), color2);
/* 1492 */     mc.getFontRendererObj().drawString(str, x, y, color);
/*      */   }
/*      */   
/*      */   public static float animate(float target, float current, float speed) {
/* 1496 */     boolean larger = (target > current);
/* 1497 */     if (speed < 0.0F) { speed = 0.0F; }
/* 1498 */     else if (speed > 1.0F) { speed = 1.0F; }
/* 1499 */      float dif = Math.abs(current - target);
/* 1500 */     float factor = dif * speed;
/* 1501 */     if (larger) { current += factor; }
/* 1502 */     else { current -= factor; }
/* 1503 */      return current;
/*      */   }
/*      */   
/*      */   public static boolean isHovered(float x, float y, float w, float h, int mouseX, int mouseY) {
/* 1507 */     return (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h);
/*      */   }
/*      */   
/*      */   public static void outlineRect(double x, double y, double x1, double y1, double width, int internalColor, int borderColor) {
/* 1511 */     drawRect(x + width, y + width, x1 - width, y1 - width, internalColor);
/* 1512 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 1513 */     drawRect(x + width, y, x1 - width, y + width, borderColor);
/* 1514 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 1515 */     drawRect(x, y, x + width, y1, borderColor);
/* 1516 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 1517 */     drawRect(x1 - width, y, x1, y1, borderColor);
/* 1518 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 1519 */     drawRect(x + width, y1 - width, x1 - width, y1, borderColor);
/* 1520 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public static void drawRect(double x, double y, double x2, double y2, int color) {
/* 1524 */     GL11.glEnable(3042);
/* 1525 */     GL11.glDisable(3553);
/* 1526 */     GL11.glBlendFunc(770, 771);
/* 1527 */     GL11.glEnable(2848);
/* 1528 */     GL11.glPushMatrix();
/* 1529 */     glColor(new Color(color));
/* 1530 */     GL11.glBegin(7);
/* 1531 */     GL11.glVertex2d(x2, y);
/* 1532 */     GL11.glVertex2d(x, y);
/* 1533 */     GL11.glVertex2d(x, y2);
/* 1534 */     GL11.glVertex2d(x2, y2);
/* 1535 */     GL11.glEnd();
/* 1536 */     GL11.glPopMatrix();
/* 1537 */     GL11.glEnable(3553);
/* 1538 */     GL11.glDisable(3042);
/* 1539 */     GL11.glDisable(2848);
/*      */   }
/*      */   
/*      */   public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
/* 1543 */     float f = (col1 >> 24 & 0xFF) / 255.0F;
/* 1544 */     float f1 = (col1 >> 16 & 0xFF) / 255.0F;
/* 1545 */     float f2 = (col1 >> 8 & 0xFF) / 255.0F;
/* 1546 */     float f3 = (col1 & 0xFF) / 255.0F;
/*      */     
/* 1548 */     float f4 = (col2 >> 24 & 0xFF) / 255.0F;
/* 1549 */     float f5 = (col2 >> 16 & 0xFF) / 255.0F;
/* 1550 */     float f6 = (col2 >> 8 & 0xFF) / 255.0F;
/* 1551 */     float f7 = (col2 & 0xFF) / 255.0F;
/*      */     
/* 1553 */     GL11.glEnable(3042);
/* 1554 */     GL11.glDisable(3553);
/* 1555 */     GL11.glBlendFunc(770, 771);
/* 1556 */     GL11.glEnable(2848);
/* 1557 */     GL11.glShadeModel(7425);
/*      */     
/* 1559 */     GL11.glPushMatrix();
/* 1560 */     GL11.glBegin(7);
/* 1561 */     GL11.glColor4f(f1, f2, f3, f);
/* 1562 */     GL11.glVertex2d(left, top);
/* 1563 */     GL11.glVertex2d(left, bottom);
/*      */     
/* 1565 */     GL11.glColor4f(f5, f6, f7, f4);
/* 1566 */     GL11.glVertex2d(right, bottom);
/* 1567 */     GL11.glVertex2d(right, top);
/* 1568 */     GL11.glEnd();
/* 1569 */     GL11.glPopMatrix();
/*      */     
/* 1571 */     GL11.glEnable(3553);
/* 1572 */     GL11.glDisable(3042);
/* 1573 */     GL11.glDisable(2848);
/* 1574 */     GL11.glShadeModel(7424);
/*      */   }
/*      */   
/*      */   public static void drawBlockBox(WBlockPos blockPos, Color color, boolean outline) {
/* 1578 */     IRenderManager renderManager = mc.getRenderManager();
/* 1579 */     ITimer timer = mc.getTimer();
/*      */     
/* 1581 */     double x = blockPos.getX() - renderManager.getRenderPosX();
/* 1582 */     double y = blockPos.getY() - renderManager.getRenderPosY();
/* 1583 */     double z = blockPos.getZ() - renderManager.getRenderPosZ();
/*      */     
/* 1585 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
/* 1586 */     IBlock block = BlockUtils.getBlock(blockPos);
/*      */     
/* 1588 */     if (block != null) {
/* 1589 */       IEntityPlayerSP iEntityPlayerSP = mc.getThePlayer();
/*      */       
/* 1591 */       double posX = iEntityPlayerSP.getLastTickPosX() + (iEntityPlayerSP.getPosX() - iEntityPlayerSP.getLastTickPosX()) * timer.getRenderPartialTicks();
/* 1592 */       double posY = iEntityPlayerSP.getLastTickPosY() + (iEntityPlayerSP.getPosY() - iEntityPlayerSP.getLastTickPosY()) * timer.getRenderPartialTicks();
/* 1593 */       double posZ = iEntityPlayerSP.getLastTickPosZ() + (iEntityPlayerSP.getPosZ() - iEntityPlayerSP.getLastTickPosZ()) * timer.getRenderPartialTicks();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1601 */       axisAlignedBB = block.getSelectedBoundingBox((IWorld)mc.getTheWorld(), mc.getTheWorld().getBlockState(blockPos), blockPos).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-posX, -posY, -posZ);
/*      */     } 
/*      */     
/* 1604 */     GL11.glBlendFunc(770, 771);
/* 1605 */     enableGlCap(3042);
/* 1606 */     disableGlCap(new int[] { 3553, 2929 });
/* 1607 */     GL11.glDepthMask(false);
/*      */     
/* 1609 */     glColor(color.getRed(), color.getGreen(), color.getBlue(), (color.getAlpha() != 255) ? color.getAlpha() : (outline ? 26 : 35));
/* 1610 */     drawFilledBox(axisAlignedBB);
/*      */     
/* 1612 */     if (outline) {
/* 1613 */       GL11.glLineWidth(1.0F);
/* 1614 */       enableGlCap(2848);
/* 1615 */       glColor(color);
/*      */       
/* 1617 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } 
/*      */     
/* 1620 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1621 */     GL11.glDepthMask(true);
/* 1622 */     resetCaps();
/*      */   }
/*      */   
/*      */   public static void drawSelectionBoundingBox(IAxisAlignedBB boundingBox) {
/* 1626 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1627 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*      */     
/* 1629 */     worldrenderer.begin(3, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */ 
/*      */     
/* 1632 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/* 1633 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/* 1634 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/* 1635 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/* 1636 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/*      */ 
/*      */     
/* 1639 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/* 1640 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/* 1641 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/* 1642 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/* 1643 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/*      */ 
/*      */     
/* 1646 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/* 1647 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/*      */     
/* 1649 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/* 1650 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/*      */     
/* 1652 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/* 1653 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/*      */     
/* 1655 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void drawEntityBox(IEntity entity, Color color, boolean outline) {
/* 1659 */     IRenderManager renderManager = mc.getRenderManager();
/* 1660 */     ITimer timer = mc.getTimer();
/*      */     
/* 1662 */     GL11.glBlendFunc(770, 771);
/* 1663 */     enableGlCap(3042);
/* 1664 */     disableGlCap(new int[] { 3553, 2929 });
/* 1665 */     GL11.glDepthMask(false);
/*      */ 
/*      */     
/* 1668 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX();
/*      */     
/* 1670 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY();
/*      */     
/* 1672 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ();
/*      */     
/* 1674 */     IAxisAlignedBB entityBox = entity.getEntityBoundingBox();
/* 1675 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(entityBox
/* 1676 */         .getMinX() - entity.getPosX() + x - 0.05D, entityBox
/* 1677 */         .getMinY() - entity.getPosY() + y, entityBox
/* 1678 */         .getMinZ() - entity.getPosZ() + z - 0.05D, entityBox
/* 1679 */         .getMaxX() - entity.getPosX() + x + 0.05D, entityBox
/* 1680 */         .getMaxY() - entity.getPosY() + y + 0.15D, entityBox
/* 1681 */         .getMaxZ() - entity.getPosZ() + z + 0.05D);
/*      */ 
/*      */     
/* 1684 */     if (outline) {
/* 1685 */       GL11.glLineWidth(1.0F);
/* 1686 */       enableGlCap(2848);
/* 1687 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), 95);
/* 1688 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } 
/*      */     
/* 1691 */     glColor(color.getRed(), color.getGreen(), color.getBlue(), outline ? 26 : 35);
/* 1692 */     drawFilledBox(axisAlignedBB);
/* 1693 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1694 */     GL11.glDepthMask(true);
/* 1695 */     resetCaps();
/*      */   }
/*      */   
/*      */   public static void drawAxisAlignedBB(IAxisAlignedBB axisAlignedBB, Color color) {
/* 1699 */     GL11.glBlendFunc(770, 771);
/* 1700 */     GL11.glEnable(3042);
/* 1701 */     GL11.glLineWidth(2.0F);
/* 1702 */     GL11.glDisable(3553);
/* 1703 */     GL11.glDisable(2929);
/* 1704 */     GL11.glDepthMask(false);
/* 1705 */     glColor(color);
/* 1706 */     drawFilledBox(axisAlignedBB);
/* 1707 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1708 */     GL11.glEnable(3553);
/* 1709 */     GL11.glEnable(2929);
/* 1710 */     GL11.glDepthMask(true);
/* 1711 */     GL11.glDisable(3042);
/*      */   }
/*      */   
/*      */   public static void drawPlatform(double y, Color color, double size) {
/* 1715 */     IRenderManager renderManager = mc.getRenderManager();
/* 1716 */     double renderY = y - renderManager.getRenderPosY();
/*      */     
/* 1718 */     drawAxisAlignedBB(classProvider.createAxisAlignedBB(size, renderY + 0.02D, size, -size, renderY, -size), color);
/*      */   }
/*      */   
/*      */   public static void drawPlatform(IEntity entity, Color color) {
/* 1722 */     IRenderManager renderManager = mc.getRenderManager();
/* 1723 */     ITimer timer = mc.getTimer();
/*      */ 
/*      */     
/* 1726 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX();
/*      */     
/* 1728 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY();
/*      */     
/* 1730 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ();
/*      */ 
/*      */ 
/*      */     
/* 1734 */     IAxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().offset(-entity.getPosX(), -entity.getPosY(), -entity.getPosZ()).offset(x, y, z);
/*      */     
/* 1736 */     drawAxisAlignedBB(classProvider
/* 1737 */         .createAxisAlignedBB(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY() + 0.2D, axisAlignedBB.getMinZ(), axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY() + 0.26D, axisAlignedBB.getMaxZ()), color);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void drawFilledBox(IAxisAlignedBB axisAlignedBB) {
/* 1743 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1744 */     IWorldRenderer worldRenderer = tessellator.getWorldRenderer();
/*      */     
/* 1746 */     worldRenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */     
/* 1748 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1749 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1750 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1751 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1752 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1753 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1754 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1755 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/*      */     
/* 1757 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1758 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1759 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1760 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1761 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1762 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1763 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1764 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/*      */     
/* 1766 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1767 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1768 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1769 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1770 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1771 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1772 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1773 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/*      */     
/* 1775 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1776 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1777 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1778 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1779 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1780 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1781 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1782 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/*      */     
/* 1784 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1785 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1786 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1787 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1788 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1789 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1790 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1791 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/*      */     
/* 1793 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1794 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1795 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1796 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1797 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1798 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1799 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1800 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1801 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void quickDrawRect(float x, float y, float x2, float y2) {
/* 1805 */     GL11.glBegin(7);
/*      */     
/* 1807 */     GL11.glVertex2d(x2, y);
/* 1808 */     GL11.glVertex2d(x, y);
/* 1809 */     GL11.glVertex2d(x, y2);
/* 1810 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 1812 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawRect(float x, float y, float x2, float y2, int color) {
/* 1816 */     GL11.glEnable(3042);
/* 1817 */     GL11.glDisable(3553);
/* 1818 */     GL11.glBlendFunc(770, 771);
/* 1819 */     GL11.glEnable(2848);
/*      */     
/* 1821 */     glColor(color);
/* 1822 */     GL11.glBegin(7);
/*      */     
/* 1824 */     GL11.glVertex2f(x2, y);
/* 1825 */     GL11.glVertex2f(x, y);
/* 1826 */     GL11.glVertex2f(x, y2);
/* 1827 */     GL11.glVertex2f(x2, y2);
/* 1828 */     GL11.glEnd();
/*      */     
/* 1830 */     GL11.glEnable(3553);
/* 1831 */     GL11.glDisable(3042);
/* 1832 */     GL11.glDisable(2848);
/*      */   }
/*      */   public static void drawRoundedCornerRect(float x, float y, float x1, float y1, float radius) {
/* 1835 */     GL11.glBegin(9);
/*      */     
/* 1837 */     float xRadius = (float)Math.min((x1 - x) * 0.5D, radius);
/* 1838 */     float yRadius = (float)Math.min((y1 - y) * 0.5D, radius);
/* 1839 */     quickPolygonCircle(x + xRadius, y + yRadius, xRadius, yRadius, 180, 270, 4);
/* 1840 */     quickPolygonCircle(x1 - xRadius, y + yRadius, xRadius, yRadius, 90, 180, 4);
/* 1841 */     quickPolygonCircle(x1 - xRadius, y1 - yRadius, xRadius, yRadius, 0, 90, 4);
/* 1842 */     quickPolygonCircle(x + xRadius, y1 - yRadius, xRadius, yRadius, 270, 360, 4);
/*      */     
/* 1844 */     GL11.glEnd();
/*      */   } private static void quickPolygonCircle(float x, float y, float xRadius, float yRadius, int start, int end, int split) {
/*      */     int i;
/* 1847 */     for (i = end; i >= start; i -= split)
/* 1848 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * xRadius, y + Math.cos(i * Math.PI / 180.0D) * yRadius); 
/*      */   }
/*      */   
/*      */   public static void drawRoundedCornerRect(float x, float y, float x1, float y1, float radius, int color) {
/* 1852 */     GL11.glEnable(3042);
/* 1853 */     GL11.glBlendFunc(770, 771);
/* 1854 */     GL11.glDisable(3553);
/* 1855 */     boolean hasCull = GL11.glIsEnabled(2884);
/* 1856 */     GL11.glDisable(2884);
/*      */     
/* 1858 */     glColor(color);
/* 1859 */     drawRoundedCornerRect(x, y, x1, y1, radius);
/*      */     
/* 1861 */     GL11.glEnable(3553);
/* 1862 */     GL11.glDisable(3042);
/* 1863 */     setGlState(2884, hasCull);
/*      */   }
/*      */   public static void drawRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius, int color) {
/* 1866 */     drawRoundedRect(paramXStart, paramYStart, paramXEnd, paramYEnd, radius, color, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isHovering(int mouseX, int mouseY, float xLeft, float yUp, float xRight, float yBottom) {
/* 1871 */     return (mouseX > xLeft && mouseX < xRight && mouseY > yUp && mouseY < yBottom);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getAnimationState(float animation, float finalState, float speed) {
/* 1876 */     float add = deltaTime * speed;
/* 1877 */     if (animation < finalState) {
/* 1878 */       if (animation + add < finalState) {
/* 1879 */         animation += add;
/*      */       } else {
/* 1881 */         animation = finalState;
/*      */       } 
/* 1883 */     } else if (animation - add > finalState) {
/* 1884 */       animation -= add;
/*      */     } else {
/* 1886 */       animation = finalState;
/*      */     } 
/* 1888 */     return animation;
/*      */   }
/*      */   public static float smoothAnimation(float ani, float finalState, float speed, float scale) {
/* 1891 */     return getAnimationState(ani, finalState, Math.max(10.0F, Math.abs(ani - finalState) * speed) * scale);
/*      */   }
/*      */   public static double getAnimationStateSmooth(double target, double current, double speed) {
/* 1894 */     boolean larger = (target > current);
/* 1895 */     if (speed < 0.0D) {
/* 1896 */       speed = 0.0D;
/* 1897 */     } else if (speed > 1.0D) {
/* 1898 */       speed = 1.0D;
/*      */     } 
/* 1900 */     if (target == current) {
/* 1901 */       return target;
/*      */     }
/* 1903 */     double dif = Math.max(target, current) - Math.min(target, current);
/* 1904 */     double factor = dif * speed;
/* 1905 */     if (factor < 0.1D) {
/* 1906 */       factor = 0.1D;
/*      */     }
/* 1908 */     if (larger) {
/* 1909 */       if (current + factor > target) {
/* 1910 */         current = target;
/*      */       } else {
/* 1912 */         current += factor;
/*      */       }
/*      */     
/* 1915 */     } else if (current - factor < target) {
/* 1916 */       current = target;
/*      */     } else {
/* 1918 */       current -= factor;
/*      */     } 
/*      */     
/* 1921 */     return current;
/*      */   }
/*      */   
/*      */   public static void drawCircle2(float x, float y, float radius, int color) {
/* 1925 */     glColor(color);
/* 1926 */     GL11.glEnable(3042);
/* 1927 */     GL11.glDisable(3553);
/* 1928 */     GL11.glBlendFunc(770, 771);
/* 1929 */     GL11.glEnable(2848);
/* 1930 */     GL11.glPushMatrix();
/* 1931 */     GL11.glLineWidth(1.0F);
/* 1932 */     GL11.glBegin(9);
/* 1933 */     for (int i = 0; i <= 360; i++)
/* 1934 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * radius, y + Math.cos(i * Math.PI / 180.0D) * radius); 
/* 1935 */     GL11.glEnd();
/* 1936 */     GL11.glPopMatrix();
/* 1937 */     GL11.glEnable(3553);
/* 1938 */     GL11.glDisable(2848);
/* 1939 */     GL11.glDisable(3042);
/* 1940 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static void drawRoundedRect3(float left, float top, float right, float bottom, float radius, int points, int color) {
/* 1943 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 1944 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 1945 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 1946 */     float f2 = (color & 0xFF) / 255.0F;
/*      */     
/* 1948 */     if (left < right) left = left + right - (right = left); 
/* 1949 */     if (top < bottom) top = top + bottom - (bottom = top);
/*      */     
/* 1951 */     float[][] corners = { { right + radius, top - radius, 270.0F }, { left - radius, top - radius, 360.0F }, { left - radius, bottom + radius, 90.0F }, { right + radius, bottom + radius, 180.0F } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1957 */     GlStateManager.func_179147_l();
/* 1958 */     GlStateManager.func_179090_x();
/* 1959 */     GlStateManager.func_179092_a(516, 0.003921569F);
/* 1960 */     GlStateManager.func_179131_c(f, f1, f2, f3);
/*      */     
/* 1962 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1963 */     IWorldRenderer renderer = tessellator.getWorldRenderer();
/* 1964 */     renderer.begin(9, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 1965 */     for (float[] c : corners) {
/* 1966 */       for (int i = 0; i <= points; i++) {
/* 1967 */         double anglerad = Math.PI * (c[2] + i * 90.0F / points) / 180.0D;
/* 1968 */         renderer.pos(c[0] + Math.sin(anglerad) * radius, c[1] + Math.cos(anglerad) * radius, 0.0D).endVertex();
/*      */       } 
/*      */     } 
/*      */     
/* 1972 */     tessellator.draw();
/* 1973 */     GlStateManager.func_179084_k();
/* 1974 */     GlStateManager.func_179098_w();
/*      */   }
/*      */   public static void drawRoundedRect3(float x, float y, float width, float height, float radius, int color) {
/* 1977 */     float x1 = x + width;
/* 1978 */     float y1 = y + height;
/* 1979 */     float f = (color >> 24 & 0xFF) / 255.0F;
/* 1980 */     float f1 = (color >> 16 & 0xFF) / 255.0F;
/* 1981 */     float f2 = (color >> 8 & 0xFF) / 255.0F;
/* 1982 */     float f3 = (color & 0xFF) / 255.0F;
/* 1983 */     GL11.glPushAttrib(0);
/* 1984 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*      */     
/* 1986 */     x *= 2.0F;
/* 1987 */     y *= 2.0F;
/* 1988 */     x1 *= 2.0F;
/* 1989 */     y1 *= 2.0F;
/*      */     
/* 1991 */     GL11.glDisable(3553);
/* 1992 */     GL11.glColor4f(f1, f2, f3, f);
/* 1993 */     GlStateManager.func_179147_l();
/* 1994 */     GL11.glEnable(2848);
/*      */     
/* 1996 */     GL11.glBegin(9);
/* 1997 */     double v = 0.017453292519943295D;
/*      */     int i;
/* 1999 */     for (i = 0; i <= 90; i += 3) {
/* 2000 */       GL11.glVertex2d((x + radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius * -1.0F), (y + radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius * -1.0F));
/*      */     }
/*      */     
/* 2003 */     for (i = 90; i <= 180; i += 3) {
/* 2004 */       GL11.glVertex2d((x + radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius * -1.0F), (y1 - radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius * -1.0F));
/*      */     }
/*      */     
/* 2007 */     for (i = 0; i <= 90; i += 3) {
/* 2008 */       GL11.glVertex2d((x1 - radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius), (y1 - radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius));
/*      */     }
/*      */     
/* 2011 */     for (i = 90; i <= 180; i += 3) {
/* 2012 */       GL11.glVertex2d((x1 - radius + MathHelper.func_76126_a((float)(i * 0.017453292519943295D)) * radius), (y + radius + MathHelper.func_76134_b((float)(i * 0.017453292519943295D)) * radius));
/*      */     }
/*      */     
/* 2015 */     GL11.glEnd();
/*      */     
/* 2017 */     GL11.glEnable(3553);
/* 2018 */     GL11.glDisable(2848);
/* 2019 */     GL11.glEnable(3553);
/*      */     
/* 2021 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/*      */     
/* 2023 */     GL11.glPopAttrib();
/* 2024 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static void drawRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius, int color, boolean popPush) {
/* 2027 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 2028 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 2029 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 2030 */     float blue = (color & 0xFF) / 255.0F;
/*      */     
/* 2032 */     float z = 0.0F;
/* 2033 */     if (paramXStart > paramXEnd) {
/* 2034 */       z = paramXStart;
/* 2035 */       paramXStart = paramXEnd;
/* 2036 */       paramXEnd = z;
/*      */     } 
/*      */     
/* 2039 */     if (paramYStart > paramYEnd) {
/* 2040 */       z = paramYStart;
/* 2041 */       paramYStart = paramYEnd;
/* 2042 */       paramYEnd = z;
/*      */     } 
/*      */     
/* 2045 */     double x1 = (paramXStart + radius);
/* 2046 */     double y1 = (paramYStart + radius);
/* 2047 */     double x2 = (paramXEnd - radius);
/* 2048 */     double y2 = (paramYEnd - radius);
/*      */     
/* 2050 */     if (popPush) GL11.glPushMatrix(); 
/* 2051 */     GL11.glEnable(3042);
/* 2052 */     GL11.glDisable(3553);
/* 2053 */     GL11.glBlendFunc(770, 771);
/* 2054 */     GL11.glEnable(2848);
/* 2055 */     GL11.glLineWidth(1.0F);
/*      */     
/* 2057 */     GL11.glColor4f(red, green, blue, alpha);
/* 2058 */     GL11.glBegin(9);
/*      */     
/* 2060 */     double degree = 0.017453292519943295D; double i;
/* 2061 */     for (i = 0.0D; i <= 90.0D; i++)
/* 2062 */       GL11.glVertex2d(x2 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius); 
/* 2063 */     for (i = 90.0D; i <= 180.0D; i++)
/* 2064 */       GL11.glVertex2d(x2 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius); 
/* 2065 */     for (i = 180.0D; i <= 270.0D; i++)
/* 2066 */       GL11.glVertex2d(x1 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius); 
/* 2067 */     for (i = 270.0D; i <= 360.0D; i++)
/* 2068 */       GL11.glVertex2d(x1 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius); 
/* 2069 */     GL11.glEnd();
/*      */     
/* 2071 */     GL11.glEnable(3553);
/* 2072 */     GL11.glDisable(3042);
/* 2073 */     GL11.glDisable(2848);
/* 2074 */     if (popPush) GL11.glPopMatrix(); 
/*      */   }
/*      */   
/*      */   public static void drawRect(int x, int y, int x2, int y2, int color) {
/* 2078 */     GL11.glEnable(3042);
/* 2079 */     GL11.glDisable(3553);
/* 2080 */     GL11.glBlendFunc(770, 771);
/* 2081 */     GL11.glEnable(2848);
/*      */     
/* 2083 */     glColor(color);
/* 2084 */     GL11.glBegin(7);
/*      */     
/* 2086 */     GL11.glVertex2i(x2, y);
/* 2087 */     GL11.glVertex2i(x, y);
/* 2088 */     GL11.glVertex2i(x, y2);
/* 2089 */     GL11.glVertex2i(x2, y2);
/* 2090 */     GL11.glEnd();
/*      */     
/* 2092 */     GL11.glEnable(3553);
/* 2093 */     GL11.glDisable(3042);
/* 2094 */     GL11.glDisable(2848);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void quickDrawRect(float x, float y, float x2, float y2, int color) {
/* 2101 */     glColor(color);
/* 2102 */     GL11.glBegin(7);
/*      */     
/* 2104 */     GL11.glVertex2d(x2, y);
/* 2105 */     GL11.glVertex2d(x, y);
/* 2106 */     GL11.glVertex2d(x, y2);
/* 2107 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 2109 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawRect(float x, float y, float x2, float y2, Color color) {
/* 2113 */     drawRect(x, y, x2, y2, color.getRGB());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void drawBorderedRect(float x, float y, float x2, float y2, float width, int color1, int color2) {
/* 2118 */     drawRect(x, y, x2, y2, color2);
/* 2119 */     drawBorder(x, y, x2, y2, width, color1);
/*      */   }
/*      */   
/*      */   public static void drawBorder(float x, float y, float x2, float y2, float width, int color1) {
/* 2123 */     GL11.glEnable(3042);
/* 2124 */     GL11.glDisable(3553);
/* 2125 */     GL11.glBlendFunc(770, 771);
/* 2126 */     GL11.glEnable(2848);
/*      */     
/* 2128 */     glColor(color1);
/* 2129 */     GL11.glLineWidth(width);
/*      */     
/* 2131 */     GL11.glBegin(2);
/*      */     
/* 2133 */     GL11.glVertex2d(x2, y);
/* 2134 */     GL11.glVertex2d(x, y);
/* 2135 */     GL11.glVertex2d(x, y2);
/* 2136 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 2138 */     GL11.glEnd();
/*      */     
/* 2140 */     GL11.glEnable(3553);
/* 2141 */     GL11.glDisable(3042);
/* 2142 */     GL11.glDisable(2848);
/*      */   }
/*      */   
/*      */   public static void quickDrawBorderedRect(float x, float y, float x2, float y2, float width, int color1, int color2) {
/* 2146 */     quickDrawRect(x, y, x2, y2, color2);
/*      */     
/* 2148 */     glColor(color1);
/* 2149 */     GL11.glLineWidth(width);
/*      */     
/* 2151 */     GL11.glBegin(2);
/*      */     
/* 2153 */     GL11.glVertex2d(x2, y);
/* 2154 */     GL11.glVertex2d(x, y);
/* 2155 */     GL11.glVertex2d(x, y2);
/* 2156 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 2158 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawLoadingCircle(float x, float y) {
/* 2162 */     for (int i = 0; i < 4; i++) {
/* 2163 */       int rot = (int)(System.nanoTime() / 5000000L * i % 360L);
/* 2164 */       drawCircle(x, y, (i * 10), rot - 180, rot);
/*      */     } 
/*      */   }
/*      */   public static void drawCircle(float x, float y, float radius, int start, int end, Color color) {
/* 2168 */     classProvider.getGlStateManager().enableBlend();
/* 2169 */     classProvider.getGlStateManager().disableTexture2D();
/* 2170 */     classProvider.getGlStateManager().tryBlendFuncSeparate(770, 771, 1, 0);
/* 2171 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*      */     
/* 2173 */     GL11.glEnable(2848);
/* 2174 */     GL11.glLineWidth(2.0F);
/* 2175 */     GL11.glBegin(3); float i;
/* 2176 */     for (i = end; i >= start; i -= 4.0F) {
/* 2177 */       GL11.glVertex2f((float)(x + Math.cos(i * Math.PI / 180.0D) * (radius * 1.001F)), (float)(y + Math.sin(i * Math.PI / 180.0D) * (radius * 1.001F)));
/*      */     }
/* 2179 */     GL11.glEnd();
/* 2180 */     GL11.glDisable(2848);
/*      */     
/* 2182 */     classProvider.getGlStateManager().enableTexture2D();
/* 2183 */     classProvider.getGlStateManager().disableBlend();
/*      */   }
/*      */   public static void drawCircle(float x, float y, float radius, int color) {
/* 2186 */     glColor(color);
/* 2187 */     GL11.glEnable(3042);
/* 2188 */     GL11.glDisable(3553);
/* 2189 */     GL11.glBlendFunc(770, 771);
/* 2190 */     GL11.glEnable(2848);
/* 2191 */     GL11.glPushMatrix();
/* 2192 */     GL11.glLineWidth(1.0F);
/* 2193 */     GL11.glBegin(9);
/* 2194 */     for (int i = 0; i <= 360; i++)
/* 2195 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * radius, y + Math.cos(i * Math.PI / 180.0D) * radius); 
/* 2196 */     GL11.glEnd();
/* 2197 */     GL11.glPopMatrix();
/* 2198 */     GL11.glEnable(3553);
/* 2199 */     GL11.glDisable(2848);
/* 2200 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   public static void drawCircle(IEntity entity, double rad, int color, boolean shade) {
/* 2203 */     GL11.glPushMatrix();
/* 2204 */     GL11.glDisable(3553);
/* 2205 */     GL11.glEnable(2848);
/* 2206 */     GL11.glEnable(2832);
/* 2207 */     GL11.glEnable(3042);
/* 2208 */     GL11.glBlendFunc(770, 771);
/* 2209 */     GL11.glHint(3154, 4354);
/* 2210 */     GL11.glHint(3155, 4354);
/* 2211 */     GL11.glHint(3153, 4354);
/* 2212 */     GL11.glDepthMask(false);
/* 2213 */     GlStateManager.func_179092_a(516, 0.0F);
/* 2214 */     if (shade) GL11.glShadeModel(7425); 
/* 2215 */     GlStateManager.func_179129_p();
/* 2216 */     GL11.glBegin(5);
/*      */     
/* 2218 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * mc.getTimer().getRenderPartialTicks() - mc.getRenderManager().getRenderPosX();
/* 2219 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * mc.getTimer().getRenderPartialTicks() - mc.getRenderManager().getRenderPosY() + Math.sin(System.currentTimeMillis() / 200.0D) + 1.0D;
/* 2220 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * mc.getTimer().getRenderPartialTicks() - mc.getRenderManager().getRenderPosZ();
/*      */     
/*      */     float i;
/*      */     
/* 2224 */     for (i = 0.0F; i < 6.283185307179586D; i = (float)(i + 0.09817477042468103D)) {
/* 2225 */       double vecX = x + rad * Math.cos(i);
/* 2226 */       double vecZ = z + rad * Math.sin(i);
/*      */       
/* 2228 */       HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*      */       
/* 2230 */       Color c = getGradientOffset(new Color(((Integer)AColorPalette.r
/* 2231 */             .get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue()), new Color(((Integer)AColorPalette.r2
/* 2232 */             .get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue()), i);
/*      */ 
/*      */       
/* 2235 */       if (shade) {
/* 2236 */         GL11.glColor4f(c.getRed() / 255.0F, c
/* 2237 */             .getGreen() / 255.0F, c
/* 2238 */             .getBlue() / 255.0F, 0.0F);
/*      */ 
/*      */         
/* 2241 */         GL11.glVertex3d(vecX, y - Math.cos(System.currentTimeMillis() / 200.0D) / 2.0D, vecZ);
/* 2242 */         GL11.glColor4f(c.getRed() / 255.0F, c
/* 2243 */             .getGreen() / 255.0F, c
/* 2244 */             .getBlue() / 255.0F, 0.85F);
/*      */       } 
/*      */ 
/*      */       
/* 2248 */       GL11.glVertex3d(vecX, y, vecZ);
/*      */     } 
/*      */     
/* 2251 */     GL11.glEnd();
/* 2252 */     if (shade) GL11.glShadeModel(7424); 
/* 2253 */     GL11.glDepthMask(true);
/* 2254 */     GL11.glEnable(2929);
/* 2255 */     GlStateManager.func_179092_a(516, 0.1F);
/* 2256 */     GlStateManager.func_179089_o();
/* 2257 */     GL11.glDisable(2848);
/* 2258 */     GL11.glDisable(2848);
/* 2259 */     GL11.glEnable(2832);
/* 2260 */     GL11.glEnable(3553);
/* 2261 */     GL11.glPopMatrix();
/* 2262 */     GL11.glColor3f(255.0F, 255.0F, 255.0F);
/*      */   }
/*      */   public static void drawCircle(float x, float y, float radius, int start, int end) {
/* 2265 */     classProvider.getGlStateManager().enableBlend();
/* 2266 */     classProvider.getGlStateManager().disableTexture2D();
/* 2267 */     classProvider.getGlStateManager().tryBlendFuncSeparate(770, 771, 1, 0);
/* 2268 */     glColor(Color.WHITE);
/*      */     
/* 2270 */     GL11.glEnable(2848);
/* 2271 */     GL11.glLineWidth(2.0F);
/* 2272 */     GL11.glBegin(3); float i;
/* 2273 */     for (i = end; i >= start; i -= 4.0F) {
/* 2274 */       GL11.glVertex2f((float)(x + Math.cos(i * Math.PI / 180.0D) * (radius * 1.001F)), (float)(y + Math.sin(i * Math.PI / 180.0D) * (radius * 1.001F)));
/*      */     }
/* 2276 */     GL11.glEnd();
/* 2277 */     GL11.glDisable(2848);
/*      */     
/* 2279 */     classProvider.getGlStateManager().enableTexture2D();
/* 2280 */     classProvider.getGlStateManager().disableBlend();
/*      */   }
/*      */   public static void enableSmoothLine(float width) {
/* 2283 */     GL11.glDisable(3008);
/* 2284 */     GL11.glEnable(3042);
/* 2285 */     GL11.glBlendFunc(770, 771);
/* 2286 */     GL11.glDisable(3553);
/* 2287 */     GL11.glDisable(2929);
/* 2288 */     GL11.glDepthMask(false);
/* 2289 */     GL11.glEnable(2884);
/* 2290 */     GL11.glEnable(2848);
/* 2291 */     GL11.glHint(3154, 4354);
/* 2292 */     GL11.glHint(3155, 4354);
/* 2293 */     GL11.glLineWidth(width);
/*      */   }
/*      */   public static void disableSmoothLine() {
/* 2296 */     GL11.glEnable(3553);
/* 2297 */     GL11.glEnable(2929);
/* 2298 */     GL11.glDisable(3042);
/* 2299 */     GL11.glEnable(3008);
/* 2300 */     GL11.glDepthMask(true);
/* 2301 */     GL11.glCullFace(1029);
/* 2302 */     GL11.glDisable(2848);
/* 2303 */     GL11.glHint(3154, 4352);
/* 2304 */     GL11.glHint(3155, 4352);
/*      */   }
/*      */   public static void drawFilledCircle(int xx, int yy, float radius, Color color) {
/* 2307 */     int sections = 50;
/* 2308 */     double dAngle = 6.283185307179586D / sections;
/*      */ 
/*      */     
/* 2311 */     GL11.glPushAttrib(8192);
/*      */     
/* 2313 */     GL11.glEnable(3042);
/* 2314 */     GL11.glDisable(3553);
/* 2315 */     GL11.glBlendFunc(770, 771);
/* 2316 */     GL11.glEnable(2848);
/* 2317 */     GL11.glBegin(6);
/*      */     
/* 2319 */     for (int i = 0; i < sections; i++) {
/* 2320 */       float x = (float)(radius * Math.sin(i * dAngle));
/* 2321 */       float y = (float)(radius * Math.cos(i * dAngle));
/*      */       
/* 2323 */       GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/* 2324 */       GL11.glVertex2f(xx + x, yy + y);
/*      */     } 
/*      */     
/* 2327 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     
/* 2329 */     GL11.glEnd();
/*      */     
/* 2331 */     GL11.glPopAttrib();
/*      */   }
/*      */   
/*      */   public static void drawImage(IResourceLocation image, int x, int y, int width, int height) {
/* 2335 */     GL11.glDisable(2929);
/* 2336 */     GL11.glEnable(3042);
/* 2337 */     GL11.glDepthMask(false);
/* 2338 */     GL14.glBlendFuncSeparate(770, 771, 1, 0);
/* 2339 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2340 */     mc.getTextureManager().bindTexture(image);
/* 2341 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/* 2342 */     GL11.glDepthMask(true);
/* 2343 */     GL11.glDisable(3042);
/* 2344 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawImage(ResourceLocation resourceLocation, int n, int n2, int n3, int n4) {
/* 2347 */     new ScaledResolution(Minecraft.func_71410_x());
/* 2348 */     GL11.glDisable(2929);
/* 2349 */     GL11.glEnable(3042);
/* 2350 */     GL11.glDepthMask(false);
/* 2351 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 2352 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2353 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(resourceLocation);
/* 2354 */     Gui.func_146110_a(n, n2, 0.0F, 0.0F, n3, n4, n3, n4);
/* 2355 */     GL11.glDepthMask(true);
/* 2356 */     GL11.glDisable(3042);
/* 2357 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawImage4(ResourceLocation image, int x, int y, int width, int height) {
/* 2360 */     GL11.glDisable(2929);
/* 2361 */     GL11.glEnable(3042);
/* 2362 */     GL11.glDepthMask(false);
/* 2363 */     GL14.glBlendFuncSeparate(770, 771, 1, 0);
/* 2364 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2365 */     mc.getTextureManager().bindTexture2(image);
/* 2366 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/* 2367 */     GL11.glDepthMask(true);
/* 2368 */     GL11.glDisable(3042);
/* 2369 */     GL11.glEnable(2929);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void drawModalRectWithCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight) {
/* 2376 */     float f = 1.0F / textureWidth;
/* 2377 */     float f1 = 1.0F / textureHeight;
/* 2378 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 2379 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 2380 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 2381 */     worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + height) * f1)).endVertex();
/* 2382 */     worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + width) * f), ((v + height) * f1)).endVertex();
/* 2383 */     worldrenderer.pos((x + width), y, 0.0D).tex(((u + width) * f), (v * f1)).endVertex();
/* 2384 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/* 2385 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void glColor(int red, int green, int blue, int alpha) {
/* 2389 */     GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, alpha / 255.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColor(Color color) {
/* 2395 */     glColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*      */   }
/*      */   
/*      */   public static void glColor(int hex) {
/* 2399 */     glColor(hex >> 16 & 0xFF, hex >> 8 & 0xFF, hex & 0xFF, hex >> 24 & 0xFF);
/*      */   }
/*      */   
/*      */   public static void draw2D(IEntityLivingBase entity, double posX, double posY, double posZ, int color, int backgroundColor) {
/* 2403 */     GL11.glPushMatrix();
/* 2404 */     GL11.glTranslated(posX, posY, posZ);
/* 2405 */     GL11.glRotated(-mc.getRenderManager().getPlayerViewY(), 0.0D, 1.0D, 0.0D);
/* 2406 */     GL11.glScaled(-0.1D, -0.1D, 0.1D);
/*      */     
/* 2408 */     GL11.glDisable(2929);
/* 2409 */     GL11.glEnable(3042);
/* 2410 */     GL11.glDisable(3553);
/* 2411 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 2413 */     GL11.glDepthMask(true);
/*      */     
/* 2415 */     glColor(color);
/*      */     
/* 2417 */     GL11.glCallList(DISPLAY_LISTS_2D[0]);
/*      */     
/* 2419 */     glColor(backgroundColor);
/*      */     
/* 2421 */     GL11.glCallList(DISPLAY_LISTS_2D[1]);
/*      */     
/* 2423 */     GL11.glTranslated(0.0D, 21.0D + -(entity.getEntityBoundingBox().getMaxY() - entity.getEntityBoundingBox().getMinY()) * 12.0D, 0.0D);
/*      */     
/* 2425 */     glColor(color);
/* 2426 */     GL11.glCallList(DISPLAY_LISTS_2D[2]);
/*      */     
/* 2428 */     glColor(backgroundColor);
/* 2429 */     GL11.glCallList(DISPLAY_LISTS_2D[3]);
/*      */ 
/*      */     
/* 2432 */     GL11.glEnable(2929);
/* 2433 */     GL11.glEnable(3553);
/* 2434 */     GL11.glDisable(3042);
/*      */     
/* 2436 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void draw2D(WBlockPos blockPos, int color, int backgroundColor) {
/* 2440 */     IRenderManager renderManager = mc.getRenderManager();
/*      */     
/* 2442 */     double posX = blockPos.getX() + 0.5D - renderManager.getRenderPosX();
/* 2443 */     double posY = blockPos.getY() - renderManager.getRenderPosY();
/* 2444 */     double posZ = blockPos.getZ() + 0.5D - renderManager.getRenderPosZ();
/*      */     
/* 2446 */     GL11.glPushMatrix();
/* 2447 */     GL11.glTranslated(posX, posY, posZ);
/* 2448 */     GL11.glRotated(-mc.getRenderManager().getPlayerViewY(), 0.0D, 1.0D, 0.0D);
/* 2449 */     GL11.glScaled(-0.1D, -0.1D, 0.1D);
/*      */     
/* 2451 */     GL11.glDisable(2929);
/* 2452 */     GL11.glEnable(3042);
/* 2453 */     GL11.glDisable(3553);
/* 2454 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 2456 */     GL11.glDepthMask(true);
/*      */     
/* 2458 */     glColor(color);
/*      */     
/* 2460 */     GL11.glCallList(DISPLAY_LISTS_2D[0]);
/*      */     
/* 2462 */     glColor(backgroundColor);
/*      */     
/* 2464 */     GL11.glCallList(DISPLAY_LISTS_2D[1]);
/*      */     
/* 2466 */     GL11.glTranslated(0.0D, 9.0D, 0.0D);
/*      */     
/* 2468 */     glColor(color);
/*      */     
/* 2470 */     GL11.glCallList(DISPLAY_LISTS_2D[2]);
/*      */     
/* 2472 */     glColor(backgroundColor);
/*      */     
/* 2474 */     GL11.glCallList(DISPLAY_LISTS_2D[3]);
/*      */ 
/*      */     
/* 2477 */     GL11.glEnable(2929);
/* 2478 */     GL11.glEnable(3553);
/* 2479 */     GL11.glDisable(3042);
/*      */     
/* 2481 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void renderNameTag(String string, double x, double y, double z) {
/* 2485 */     IRenderManager renderManager = mc.getRenderManager();
/*      */     
/* 2487 */     GL11.glPushMatrix();
/* 2488 */     GL11.glTranslated(x - renderManager.getRenderPosX(), y - renderManager.getRenderPosY(), z - renderManager.getRenderPosZ());
/* 2489 */     GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 2490 */     GL11.glRotatef(-mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 2491 */     GL11.glRotatef(mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 2492 */     GL11.glScalef(-0.05F, -0.05F, 0.05F);
/* 2493 */     setGlCap(2896, false);
/* 2494 */     setGlCap(2929, false);
/* 2495 */     setGlCap(3042, true);
/* 2496 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 2498 */     int width = Fonts.roboto35.getStringWidth(string) / 2;
/*      */     
/* 2500 */     drawRect(-width - 1, -1, width + 1, Fonts.roboto35.getFontHeight(), -2147483648);
/* 2501 */     Fonts.roboto35.drawString(string, -width, 1.5F, Color.WHITE.getRGB(), true);
/*      */     
/* 2503 */     resetCaps();
/* 2504 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2505 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawLine(double x, double y, double x1, double y1, float width) {
/* 2509 */     GL11.glDisable(3553);
/* 2510 */     GL11.glLineWidth(width);
/* 2511 */     GL11.glBegin(1);
/* 2512 */     GL11.glVertex2d(x, y);
/* 2513 */     GL11.glVertex2d(x1, y1);
/* 2514 */     GL11.glEnd();
/* 2515 */     GL11.glEnable(3553);
/*      */   }
/*      */   
/*      */   public static void makeScissorBox(float x, float y, float x2, float y2) {
/* 2519 */     IScaledResolution scaledResolution = classProvider.createScaledResolution(mc);
/* 2520 */     int factor = scaledResolution.getScaleFactor();
/* 2521 */     GL11.glScissor((int)(x * factor), (int)((scaledResolution.getScaledHeight() - y2) * factor), (int)((x2 - x) * factor), (int)((y2 - y) * factor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void resetCaps() {
/* 2531 */     glCapMap.forEach(RenderUtils::setGlState);
/*      */   }
/*      */   
/*      */   public static void enableGlCap(int cap) {
/* 2535 */     setGlCap(cap, true);
/*      */   }
/*      */   
/*      */   public static void enableGlCap(int... caps) {
/* 2539 */     for (int cap : caps)
/* 2540 */       setGlCap(cap, true); 
/*      */   }
/*      */   
/*      */   public static void disableGlCap(int cap) {
/* 2544 */     setGlCap(cap, true);
/*      */   }
/*      */   
/*      */   public static void disableGlCap(int... caps) {
/* 2548 */     for (int cap : caps)
/* 2549 */       setGlCap(cap, false); 
/*      */   }
/*      */   
/*      */   public static void setGlCap(int cap, boolean state) {
/* 2553 */     glCapMap.put(Integer.valueOf(cap), Boolean.valueOf(GL11.glGetBoolean(cap)));
/* 2554 */     setGlState(cap, state);
/*      */   }
/*      */   
/*      */   public static void setGlState(int cap, boolean state) {
/* 2558 */     if (state) {
/* 2559 */       GL11.glEnable(cap);
/*      */     } else {
/* 2561 */       GL11.glDisable(cap);
/*      */     } 
/*      */   }
/*      */   public static void drawCircle(double x, double y, double radius, float startAngle, float endAngle, int color, float lineWidth) {
/* 2565 */     GlStateManager.func_179094_E();
/* 2566 */     GlStateManager.func_179147_l();
/* 2567 */     GlStateManager.func_179090_x();
/* 2568 */     GlStateManager.func_179118_c();
/* 2569 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 2570 */     GL11.glEnable(2848);
/* 2571 */     GL11.glLineWidth(lineWidth);
/* 2572 */     GL11.glBegin(3);
/* 2573 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 2574 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 2575 */       color(color);
/* 2576 */       GL11.glVertex2d(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius);
/*      */     } 
/* 2578 */     GL11.glEnd();
/* 2579 */     GlStateManager.func_179084_k();
/* 2580 */     GlStateManager.func_179141_d();
/* 2581 */     GlStateManager.func_179098_w();
/* 2582 */     GL11.glDisable(2848);
/* 2583 */     GlStateManager.func_179121_F();
/* 2584 */     GlStateManager.func_179117_G();
/*      */   }
/*      */   
/*      */   public static void color(float red, float green, float blue, float alpha) {
/* 2588 */     GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, alpha / 255.0F);
/*      */   }
/*      */   
/*      */   public static void color(Color color) {
/* 2592 */     color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*      */   }
/*      */   
/*      */   public static void color(double red, double green, double blue, double alpha) {
/* 2596 */     GL11.glColor4d(red, green, blue, alpha);
/*      */   }
/*      */   
/*      */   public static void color(int color) {
/* 2600 */     color(color, (color >> 24 & 0xFF) / 255.0F);
/*      */   }
/*      */   
/*      */   public static void color(int color, float alpha) {
/* 2604 */     float r = (color >> 16 & 0xFF) / 255.0F;
/* 2605 */     float g = (color >> 8 & 0xFF) / 255.0F;
/* 2606 */     float b = (color & 0xFF) / 255.0F;
/* 2607 */     GlStateManager.func_179131_c(r, g, b, alpha);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height, float tileWidth, float tileHeight) {
/* 2612 */     float f = 1.0F / tileWidth;
/* 2613 */     float f1 = 1.0F / tileHeight;
/* 2614 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 2615 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 2616 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 2617 */     worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + vHeight) * f1)).endVertex();
/* 2618 */     worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + uWidth) * f), ((v + vHeight) * f1)).endVertex();
/* 2619 */     worldrenderer.pos((x + width), y, 0.0D).tex(((u + uWidth) * f), (v * f1)).endVertex();
/* 2620 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/* 2621 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void glColorHex(int hex) {
/* 2625 */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/* 2626 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 2627 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 2628 */     float blue = (hex & 0xFF) / 255.0F;
/* 2629 */     GL11.glColor4f(red, green, blue, alpha);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void draw2DBox(@NotNull IEntity entity, @NotNull Color color, @Nullable Render3DEvent event) {}
/*      */ 
/*      */   
/*      */   public static void drawWolframEntityESP(@NotNull IEntity entity, int rgb, double posX, double posY, double posZ) {}
/*      */   
/*      */   public static void originalRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius, int color) {
/* 2639 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 2640 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 2641 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 2642 */     float blue = (color & 0xFF) / 255.0F;
/*      */     
/* 2644 */     float z = 0.0F;
/* 2645 */     if (paramXStart > paramXEnd) {
/* 2646 */       z = paramXStart;
/* 2647 */       paramXStart = paramXEnd;
/* 2648 */       paramXEnd = z;
/*      */     } 
/*      */     
/* 2651 */     if (paramYStart > paramYEnd) {
/* 2652 */       z = paramYStart;
/* 2653 */       paramYStart = paramYEnd;
/* 2654 */       paramYEnd = z;
/*      */     } 
/*      */     
/* 2657 */     double x1 = (paramXStart + radius);
/* 2658 */     double y1 = (paramYStart + radius);
/* 2659 */     double x2 = (paramXEnd - radius);
/* 2660 */     double y2 = (paramYEnd - radius);
/*      */     
/* 2662 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 2663 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*      */     
/* 2665 */     GlStateManager.func_179147_l();
/* 2666 */     GlStateManager.func_179090_x();
/* 2667 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 2668 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/* 2669 */     worldrenderer.begin(9, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */     
/* 2671 */     double degree = 0.017453292519943295D; double i;
/* 2672 */     for (i = 0.0D; i <= 90.0D; i++)
/* 2673 */       worldrenderer.pos(x2 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius, 0.0D).endVertex(); 
/* 2674 */     for (i = 90.0D; i <= 180.0D; i++)
/* 2675 */       worldrenderer.pos(x2 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius, 0.0D).endVertex(); 
/* 2676 */     for (i = 180.0D; i <= 270.0D; i++)
/* 2677 */       worldrenderer.pos(x1 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius, 0.0D).endVertex(); 
/* 2678 */     for (i = 270.0D; i <= 360.0D; i++) {
/* 2679 */       worldrenderer.pos(x1 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius, 0.0D).endVertex();
/*      */     }
/* 2681 */     tessellator.draw();
/* 2682 */     GlStateManager.func_179098_w();
/* 2683 */     GlStateManager.func_179084_k();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColor(@Nullable Color hsbColor, float fl) {}
/*      */ 
/*      */   
/*      */   public static void glColor(Color color, int alpha) {
/* 2691 */     glColor(color, alpha / 255.0F);
/*      */   }
/*      */   public static void glColor(int hex, int alpha) {
/* 2694 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 2695 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 2696 */     float blue = (hex & 0xFF) / 255.0F;
/*      */     
/* 2698 */     GlStateManager.func_179131_c(red, green, blue, alpha / 255.0F);
/*      */   }
/*      */   public static void glColor(int hex, float alpha) {
/* 2701 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 2702 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 2703 */     float blue = (hex & 0xFF) / 255.0F;
/*      */     
/* 2705 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void drawLimitedCircle(float lx, float ly, float x2, float y2, int xx, int yy, float radius, Color color) {
/* 2710 */     int sections = 50;
/* 2711 */     double dAngle = 6.283185307179586D / sections;
/*      */ 
/*      */     
/* 2714 */     GL11.glPushAttrib(8192);
/*      */     
/* 2716 */     GL11.glEnable(3042);
/* 2717 */     GL11.glDisable(3553);
/* 2718 */     GL11.glBlendFunc(770, 771);
/* 2719 */     GL11.glEnable(2848);
/* 2720 */     GL11.glBegin(6);
/*      */     
/* 2722 */     glColor(color);
/* 2723 */     for (int i = 0; i < sections; i++) {
/* 2724 */       float x = (float)(radius * Math.sin(i * dAngle));
/* 2725 */       float y = (float)(radius * Math.cos(i * dAngle));
/* 2726 */       GL11.glVertex2f(Math.min(x2, Math.max(xx + x, lx)), Math.min(y2, Math.max(yy + y, ly)));
/*      */     } 
/*      */     
/* 2729 */     GlStateManager.func_179124_c(0.0F, 0.0F, 0.0F);
/*      */     
/* 2731 */     GL11.glEnd();
/*      */     
/* 2733 */     GL11.glPopAttrib();
/*      */   }
/*      */   
/*      */   public static void drawTexturedRect(float x, float y, float width, float height, String image, IScaledResolution sr) {
/* 2737 */     GL11.glPushMatrix();
/* 2738 */     GlStateManager.func_179147_l();
/* 2739 */     GlStateManager.func_179118_c();
/* 2740 */     mc.getTextureManager().bindTexture(classProvider.createResourceLocation("tomk/shadow/" + image + ".png"));
/* 2741 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 2742 */     Gui.func_146110_a((int)x, (int)y, 0.0F, 0.0F, (int)width, (int)height, (int)width, (int)height);
/* 2743 */     GlStateManager.func_179084_k();
/* 2744 */     GlStateManager.func_179141_d();
/* 2745 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawGradientSidewaysV(double left, double top, double right, double bottom, int col1, int col2) {
/* 2749 */     GL11.glEnable(3042);
/* 2750 */     GL11.glDisable(3553);
/* 2751 */     GL11.glBlendFunc(770, 771);
/* 2752 */     GL11.glEnable(2848);
/* 2753 */     GL11.glShadeModel(7425);
/*      */     
/* 2755 */     quickDrawGradientSidewaysV(left, top, right, bottom, col1, col2);
/*      */     
/* 2757 */     GL11.glEnable(3553);
/* 2758 */     GL11.glDisable(3042);
/* 2759 */     GL11.glDisable(2848);
/* 2760 */     GL11.glShadeModel(7424);
/*      */   }
/*      */   public static void quickDrawGradientSidewaysV(double left, double top, double right, double bottom, int col1, int col2) {
/* 2763 */     GL11.glBegin(7);
/*      */     
/* 2765 */     glColor(col1);
/* 2766 */     GL11.glVertex2d(right, top);
/* 2767 */     GL11.glVertex2d(left, top);
/* 2768 */     glColor(col2);
/* 2769 */     GL11.glVertex2d(left, bottom);
/* 2770 */     GL11.glVertex2d(right, bottom);
/*      */     
/* 2772 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static int Astolfo(int var2, float st, float bright) {
/* 2776 */     double currentColor = Math.ceil((System.currentTimeMillis() + (var2 * 130))) / 6.0D;
/* 2777 */     return Color.getHSBColor(((float)((currentColor %= 360.0D) / 360.0D) < 0.5D) ? -((float)(currentColor / 360.0D)) : (float)(currentColor / 360.0D), st, bright).getRGB();
/*      */   }
/*      */   
/*      */   public static void drawRectPotion(float x, float y, float x2, float y2, int color) {
/* 2781 */     GL11.glEnable(3042);
/* 2782 */     GL11.glDisable(3553);
/* 2783 */     GL11.glBlendFunc(770, 771);
/* 2784 */     GL11.glEnable(2848);
/*      */     
/* 2786 */     GL11.glPushMatrix();
/* 2787 */     glColor(color);
/*      */     
/* 2789 */     GL11.glBegin(7);
/* 2790 */     GL11.glVertex2d(x2, y);
/* 2791 */     GL11.glVertex2d(x, y);
/* 2792 */     GL11.glVertex2d(x, y2);
/* 2793 */     GL11.glVertex2d(x2, y2);
/* 2794 */     GL11.glEnd();
/*      */     
/* 2796 */     GL11.glPopMatrix();
/* 2797 */     GL11.glEnable(3553);
/* 2798 */     GL11.glDisable(3042);
/* 2799 */     GL11.glDisable(2848);
/*      */   }
/*      */   
/*      */   public static void drawGidentOutlinedRoundedRect(double x, double y, double width, double height, double radius, float linewidth) {
/* 2803 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*      */     
/* 2805 */     GlStateManager.func_179147_l();
/* 2806 */     GlStateManager.func_179090_x();
/* 2807 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 2808 */     double x1 = x + width;
/* 2809 */     double y1 = y + height;
/* 2810 */     int colorI = 0;
/* 2811 */     GL11.glPushAttrib(0);
/* 2812 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*      */     
/* 2814 */     x *= 2.0D;
/* 2815 */     y *= 2.0D;
/* 2816 */     x1 *= 2.0D;
/* 2817 */     y1 *= 2.0D;
/* 2818 */     GL11.glLineWidth(linewidth);
/*      */     
/* 2820 */     GL11.glDisable(3553);
/* 2821 */     GL11.glEnable(2848);
/* 2822 */     GL11.glBegin(2);
/*      */     
/*      */     int i;
/* 2825 */     for (i = 0; i <= 90; i += 3) {
/* 2826 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2827 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/* 2828 */       colorI++;
/*      */     } 
/* 2830 */     for (i = 0; i <= y; i += 3) {
/* 2831 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2832 */       GL11.glVertex2d(x, y1 - radius - i);
/* 2833 */       colorI++;
/*      */     } 
/*      */     
/* 2836 */     for (i = 90; i <= 180; i += 3) {
/* 2837 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2838 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/* 2839 */       colorI++;
/*      */     } 
/* 2841 */     for (i = 90; i <= 180; i += 3) {
/* 2842 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2843 */       GL11.glVertex2d(x + radius + i, y1);
/* 2844 */       colorI++;
/*      */     } 
/*      */     
/* 2847 */     for (i = 0; i <= 90; i += 3) {
/* 2848 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2849 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius);
/* 2850 */       colorI++;
/*      */     } 
/* 2852 */     for (i = 0; i <= 90; i += 3) {
/* 2853 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2854 */       GL11.glVertex2d(x1, y1 - radius - i);
/* 2855 */       colorI++;
/*      */     } 
/*      */     
/* 2858 */     for (i = 90; i <= 180; i += 3) {
/* 2859 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2860 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
/* 2861 */       colorI++;
/*      */     } 
/*      */     
/* 2864 */     for (i = 90; i <= 180; i += 3) {
/* 2865 */       setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 20L * colorI));
/* 2866 */       GL11.glVertex2d(x1 - radius - i, y);
/* 2867 */       colorI++;
/*      */     } 
/*      */     
/* 2870 */     GL11.glEnd();
/*      */     
/* 2872 */     GL11.glEnable(3553);
/* 2873 */     GL11.glDisable(2848);
/* 2874 */     GL11.glEnable(3553);
/*      */     
/* 2876 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/*      */     
/* 2878 */     GL11.glPopAttrib();
/* 2879 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2880 */     GlStateManager.func_179098_w();
/* 2881 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   
/*      */   public static void drawOutlinedRoundedRect(double x, double y, double width, double height, double radius, float linewidth, int color) {
/* 2885 */     GlStateManager.func_179147_l();
/* 2886 */     GlStateManager.func_179090_x();
/* 2887 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 2888 */     double x1 = x + width;
/* 2889 */     double y1 = y + height;
/* 2890 */     float f = (color >> 24 & 0xFF) / 255.0F;
/* 2891 */     float f1 = (color >> 16 & 0xFF) / 255.0F;
/* 2892 */     float f2 = (color >> 8 & 0xFF) / 255.0F;
/* 2893 */     float f3 = (color & 0xFF) / 255.0F;
/* 2894 */     GL11.glPushAttrib(0);
/* 2895 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*      */     
/* 2897 */     x *= 2.0D;
/* 2898 */     y *= 2.0D;
/* 2899 */     x1 *= 2.0D;
/* 2900 */     y1 *= 2.0D;
/* 2901 */     GL11.glLineWidth(linewidth);
/*      */     
/* 2903 */     GL11.glDisable(3553);
/* 2904 */     GL11.glColor4f(f1, f2, f3, f);
/* 2905 */     GL11.glEnable(2848);
/* 2906 */     GL11.glBegin(2);
/*      */     int i;
/* 2908 */     for (i = 0; i <= 90; i += 3) {
/* 2909 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/*      */     }
/*      */     
/* 2912 */     for (i = 90; i <= 180; i += 3) {
/* 2913 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/*      */     }
/*      */     
/* 2916 */     for (i = 0; i <= 90; i += 3) {
/* 2917 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius);
/*      */     }
/*      */     
/* 2920 */     for (i = 90; i <= 180; i += 3) {
/* 2921 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
/*      */     }
/*      */     
/* 2924 */     GL11.glEnd();
/*      */     
/* 2926 */     GL11.glEnable(3553);
/* 2927 */     GL11.glDisable(2848);
/* 2928 */     GL11.glEnable(3553);
/*      */     
/* 2930 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/*      */     
/* 2932 */     GL11.glPopAttrib();
/* 2933 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2934 */     GlStateManager.func_179098_w();
/* 2935 */     GlStateManager.func_179084_k();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderItemStack(IItemStack stack, int x, int y) {
/* 2940 */     GlStateManager.func_179094_E();
/* 2941 */     GlStateManager.func_179132_a(true);
/* 2942 */     GlStateManager.func_179086_m(256);
/* 2943 */     RenderHelper.func_74519_b();
/* 2944 */     (Minecraft.func_71410_x().func_175599_af()).field_77023_b = -150.0F;
/* 2945 */     GlStateManager.func_179097_i();
/* 2946 */     GlStateManager.func_179090_x();
/* 2947 */     GlStateManager.func_179147_l();
/* 2948 */     GlStateManager.func_179141_d();
/* 2949 */     GlStateManager.func_179098_w();
/* 2950 */     GlStateManager.func_179145_e();
/* 2951 */     GlStateManager.func_179126_j();
/* 2952 */     mc.getRenderItem().renderItemAndEffectIntoGUI(stack, x, y);
/* 2953 */     mc.getRenderItem().renderItemOverlays(MinecraftInstance.mc.getFontRendererObj(), stack, x, y);
/* 2954 */     Minecraft.func_71410_x();
/* 2955 */     (Minecraft.func_71410_x().func_175599_af()).field_77023_b = 0.0F;
/* 2956 */     RenderHelper.func_74518_a();
/* 2957 */     GlStateManager.func_179129_p();
/* 2958 */     GlStateManager.func_179141_d();
/* 2959 */     GlStateManager.func_179084_k();
/* 2960 */     GlStateManager.func_179140_f();
/* 2961 */     double s = 0.5D;
/* 2962 */     GlStateManager.func_179139_a(0.5D, 0.5D, 0.5D);
/* 2963 */     GlStateManager.func_179097_i();
/* 2964 */     GlStateManager.func_179126_j();
/* 2965 */     GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
/* 2966 */     GlStateManager.func_179121_F();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\RenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */