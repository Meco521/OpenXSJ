/*      */ package me.utils.render;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.ui.client.hud.Ur.PaletteHelper;
/*      */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*      */ import net.ccbluex.liquidbounce.utils.ESPUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.gui.Gui;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.client.renderer.GlStateManager;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.shader.Framebuffer;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ import org.lwjgl.opengl.GL14;
/*      */ import org.lwjgl.util.glu.Cylinder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class RenderUtils
/*      */   extends MinecraftInstance
/*      */ {
/*   46 */   private static final Map<Integer, Boolean> glCapMap = new HashMap<>();
/*   47 */   private static final int[] DISPLAY_LISTS_2D = new int[4];
/*      */   public static int deltaTime;
/*      */   
/*      */   static {
/*   51 */     for (int i = 0; i < DISPLAY_LISTS_2D.length; i++) {
/*   52 */       DISPLAY_LISTS_2D[i] = GL11.glGenLists(1);
/*      */     }
/*      */     
/*   55 */     GL11.glNewList(DISPLAY_LISTS_2D[0], 4864);
/*      */     
/*   57 */     quickDrawRect(-7.0F, 2.0F, -4.0F, 3.0F);
/*   58 */     quickDrawRect(4.0F, 2.0F, 7.0F, 3.0F);
/*   59 */     quickDrawRect(-7.0F, 0.5F, -6.0F, 3.0F);
/*   60 */     quickDrawRect(6.0F, 0.5F, 7.0F, 3.0F);
/*      */     
/*   62 */     GL11.glEndList();
/*      */     
/*   64 */     GL11.glNewList(DISPLAY_LISTS_2D[1], 4864);
/*      */     
/*   66 */     quickDrawRect(-7.0F, 3.0F, -4.0F, 3.3F);
/*   67 */     quickDrawRect(4.0F, 3.0F, 7.0F, 3.3F);
/*   68 */     quickDrawRect(-7.3F, 0.5F, -7.0F, 3.3F);
/*   69 */     quickDrawRect(7.0F, 0.5F, 7.3F, 3.3F);
/*      */     
/*   71 */     GL11.glEndList();
/*      */     
/*   73 */     GL11.glNewList(DISPLAY_LISTS_2D[2], 4864);
/*      */     
/*   75 */     quickDrawRect(4.0F, -20.0F, 7.0F, -19.0F);
/*   76 */     quickDrawRect(-7.0F, -20.0F, -4.0F, -19.0F);
/*   77 */     quickDrawRect(6.0F, -20.0F, 7.0F, -17.5F);
/*   78 */     quickDrawRect(-7.0F, -20.0F, -6.0F, -17.5F);
/*      */     
/*   80 */     GL11.glEndList();
/*      */     
/*   82 */     GL11.glNewList(DISPLAY_LISTS_2D[3], 4864);
/*      */     
/*   84 */     quickDrawRect(7.0F, -20.0F, 7.3F, -17.5F);
/*   85 */     quickDrawRect(-7.3F, -20.0F, -7.0F, -17.5F);
/*   86 */     quickDrawRect(4.0F, -20.3F, 7.3F, -20.0F);
/*   87 */     quickDrawRect(-7.3F, -20.3F, -4.0F, -20.0F);
/*      */     
/*   89 */     GL11.glEndList();
/*      */   }
/*      */   public static void drawShadow2(float x, float y, float x2, float y2) {
/*   92 */     GL11.glPushMatrix();
/*   93 */     boolean enableBlend = GL11.glIsEnabled(3042);
/*   94 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/*   95 */     if (!enableBlend) {
/*   96 */       GL11.glEnable(3042);
/*      */     }
/*   98 */     if (!disableAlpha) {
/*   99 */       GL11.glDisable(3008);
/*      */     }
/*  101 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  102 */     drawImage(new ResourceLocation("CatBounce/shadow/paneltopleft.png"), x - 9.0F, y - 9.0F, 9.0F, 9.0F);
/*  103 */     drawImage(new ResourceLocation("CatBounce/shadow/panelbottomleft.png"), x - 9.0F, y + y2 - y, 9.0F, 9.0F);
/*  104 */     drawImage(new ResourceLocation("CatBounce/shadow/panelbottomright.png"), x + x2 - x, y + y2 - y, 9.0F, 9.0F);
/*  105 */     drawImage(new ResourceLocation("CatBounce/shadow/paneltopright.png"), x + x2 - x, y - 9.0F, 9.0F, 9.0F);
/*  106 */     drawImage(new ResourceLocation("CatBounce/shadow/panelleft.png"), x - 9.0F, y, 9.0F, y2 - y);
/*  107 */     drawImage(new ResourceLocation("CatBounce/shadow/panelright.png"), x + x2 - x, y, 9.0F, y2 - y);
/*  108 */     drawImage(new ResourceLocation("CatBounce/shadow/paneltop.png"), x, y - 9.0F, x2 - x, 9.0F);
/*  109 */     drawImage(new ResourceLocation("CatBounce/shadow/panelbottom.png"), x, y + y2 - y, x2 - x, 9.0F);
/*      */     
/*  111 */     if (!enableBlend) {
/*  112 */       GL11.glDisable(3042);
/*      */     }
/*  114 */     if (!disableAlpha) {
/*  115 */       GL11.glEnable(3008);
/*      */     }
/*  117 */     GL11.glPopMatrix();
/*      */   }
/*      */   public static void drawImage(ResourceLocation image, float x, float y, float width, float height) {
/*  120 */     drawImage(image, (int)x, (int)y, (int)width, (int)height, 1.0F);
/*      */   }
/*      */   public static Color interpolateColorsBackAndForth(int speed, int index, Color start, Color end, boolean trueColor) {
/*  123 */     int angle = (int)((System.currentTimeMillis() / speed + index) % 360L);
/*  124 */     angle = ((angle >= 180) ? (360 - angle) : angle) * 2;
/*  125 */     return trueColor ? interpolateColorHue(start, end, angle / 360.0F) : interpolateColorC(start, end, angle / 360.0F);
/*      */   }
/*      */   public static Color interpolateColorHue(Color color1, Color color2, float amount) {
/*  128 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/*      */     
/*  130 */     float[] color1HSB = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
/*  131 */     float[] color2HSB = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
/*      */     
/*  133 */     Color resultColor = Color.getHSBColor(interpolateFloat(color1HSB[0], color2HSB[0], amount), 
/*  134 */         interpolateFloat(color1HSB[1], color2HSB[1], amount), interpolateFloat(color1HSB[2], color2HSB[2], amount));
/*      */     
/*  136 */     return new Color(resultColor.getRed(), resultColor.getGreen(), resultColor.getBlue(), 
/*  137 */         interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*      */   }
/*      */   public static Color interpolateColorC(Color color1, Color color2, float amount) {
/*  140 */     amount = Math.min(1.0F, Math.max(0.0F, amount));
/*  141 */     return new Color(interpolateInt(color1.getRed(), color2.getRed(), amount), 
/*  142 */         interpolateInt(color1.getGreen(), color2.getGreen(), amount), 
/*  143 */         interpolateInt(color1.getBlue(), color2.getBlue(), amount), 
/*  144 */         interpolateInt(color1.getAlpha(), color2.getAlpha(), amount));
/*      */   }
/*      */   public static float interpolateFloat(float oldValue, float newValue, double interpolationValue) {
/*  147 */     return interpolate(oldValue, newValue, (float)interpolationValue).floatValue();
/*      */   }
/*      */   public static Double interpolate(double oldValue, double newValue, double interpolationValue) {
/*  150 */     return Double.valueOf(oldValue + (newValue - oldValue) * interpolationValue);
/*      */   }
/*      */   public static int interpolateInt(int oldValue, int newValue, double interpolationValue) {
/*  153 */     return interpolate(oldValue, newValue, (float)interpolationValue).intValue();
/*      */   }
/*      */   public static void drawImage(ResourceLocation image, int x, int y, int width, int height, float alpha) {
/*  156 */     ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
/*  157 */     GL11.glDisable(2929);
/*  158 */     GL11.glEnable(3042);
/*  159 */     GL11.glDepthMask(false);
/*  160 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  161 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
/*  162 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(image);
/*  163 */     Gui.func_146110_a(x, y, 0.0F, 0.0F, width, height, width, height);
/*  164 */     GL11.glDepthMask(true);
/*  165 */     GL11.glDisable(3042);
/*  166 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawSmoothRect(double left, double top, double right, double bottom, int color) {
/*  169 */     GlStateManager.func_179117_G();
/*  170 */     GL11.glEnable(3042);
/*  171 */     GL11.glEnable(2848);
/*  172 */     drawRect(left, top, right, bottom, color);
/*  173 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*  174 */     drawRect(left * 2.0D - 1.0D, top * 2.0D, left * 2.0D, bottom * 2.0D - 1.0D, color);
/*  175 */     drawRect(left * 2.0D, top * 2.0D - 1.0D, right * 2.0D, top * 2.0D, color);
/*  176 */     drawRect(right * 2.0D, top * 2.0D, right * 2.0D + 1.0D, bottom * 2.0D - 1.0D, color);
/*  177 */     GL11.glDisable(3042);
/*  178 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/*      */   }
/*      */   public static void drawCircle(double x, double y, double radius, float startAngle, float endAngle, int color, float lineWidth) {
/*  181 */     GlStateManager.func_179094_E();
/*  182 */     GlStateManager.func_179147_l();
/*  183 */     GlStateManager.func_179090_x();
/*  184 */     GlStateManager.func_179118_c();
/*  185 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  186 */     GL11.glEnable(2848);
/*  187 */     GL11.glLineWidth(lineWidth);
/*  188 */     GL11.glBegin(3);
/*  189 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/*  190 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/*  191 */       if (color == 1337) {
/*  192 */         net.ccbluex.liquidbounce.utils.render.RenderUtils.color(PaletteHelper.astolfoColors(i * 5, 1));
/*      */       } else {
/*  194 */         net.ccbluex.liquidbounce.utils.render.RenderUtils.color(color);
/*      */       } 
/*  196 */       GL11.glVertex2d(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius);
/*      */     } 
/*  198 */     GL11.glEnd();
/*  199 */     GlStateManager.func_179084_k();
/*  200 */     GlStateManager.func_179141_d();
/*  201 */     GlStateManager.func_179098_w();
/*  202 */     GL11.glDisable(2848);
/*  203 */     GlStateManager.func_179121_F();
/*  204 */     GlStateManager.func_179117_G();
/*      */   }
/*      */   public static int SkyRainbow(int var2, float st, float bright) {
/*  207 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  208 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright).getRGB();
/*      */   }
/*      */   public static int getRainbowOpaque(int seconds, float saturation, float brightness, int index) {
/*  211 */     float hue = (float)((System.currentTimeMillis() + index) % (seconds * 1000)) / (seconds * 1000);
/*  212 */     int color = Color.HSBtoRGB(hue, saturation, brightness);
/*  213 */     return color;
/*      */   }
/*      */   public static void drawRoundRect(float x0, float y0, float x1, float y1, float radius, int color) {
/*  216 */     if (x0 == x1 || y0 == y1)
/*  217 */       return;  int Semicircle = 18;
/*  218 */     float f = 5.0F;
/*  219 */     float f2 = (color >> 24 & 0xFF) / 255.0F;
/*  220 */     float f3 = (color >> 16 & 0xFF) / 255.0F;
/*  221 */     float f4 = (color >> 8 & 0xFF) / 255.0F;
/*  222 */     float f5 = (color & 0xFF) / 255.0F;
/*  223 */     GL11.glDisable(2884);
/*  224 */     GL11.glDisable(3553);
/*  225 */     GL11.glEnable(3042);
/*  226 */     GL11.glBlendFunc(770, 771);
/*  227 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  228 */     GL11.glColor4f(f3, f4, f5, f2);
/*  229 */     GL11.glBegin(5);
/*  230 */     GL11.glVertex2f(x0 + radius, y0);
/*  231 */     GL11.glVertex2f(x0 + radius, y1);
/*  232 */     GL11.glVertex2f(x1 - radius, y0);
/*  233 */     GL11.glVertex2f(x1 - radius, y1);
/*  234 */     GL11.glEnd();
/*  235 */     GL11.glBegin(5);
/*  236 */     GL11.glVertex2f(x0, y0 + radius);
/*  237 */     GL11.glVertex2f(x0 + radius, y0 + radius);
/*  238 */     GL11.glVertex2f(x0, y1 - radius);
/*  239 */     GL11.glVertex2f(x0 + radius, y1 - radius);
/*  240 */     GL11.glEnd();
/*  241 */     GL11.glBegin(5);
/*  242 */     GL11.glVertex2f(x1, y0 + radius);
/*  243 */     GL11.glVertex2f(x1 - radius, y0 + radius);
/*  244 */     GL11.glVertex2f(x1, y1 - radius);
/*  245 */     GL11.glVertex2f(x1 - radius, y1 - radius);
/*  246 */     GL11.glEnd();
/*  247 */     GL11.glBegin(6);
/*  248 */     float f6 = x1 - radius;
/*  249 */     float f7 = y0 + radius;
/*  250 */     GL11.glVertex2f(f6, f7);
/*  251 */     int j = 0;
/*  252 */     for (j = 0; j <= 18; j++) {
/*  253 */       float f8 = j * 5.0F;
/*  254 */       GL11.glVertex2f((float)(f6 + radius * Math.cos(Math.toRadians(f8))), 
/*  255 */           (float)(f7 - radius * Math.sin(Math.toRadians(f8))));
/*      */     } 
/*  257 */     GL11.glEnd();
/*  258 */     GL11.glBegin(6);
/*  259 */     f6 = x0 + radius;
/*  260 */     f7 = y0 + radius;
/*  261 */     GL11.glVertex2f(f6, f7);
/*  262 */     for (j = 0; j <= 18; j++) {
/*  263 */       float f9 = j * 5.0F;
/*  264 */       GL11.glVertex2f((float)(f6 - radius * Math.cos(Math.toRadians(f9))), 
/*  265 */           (float)(f7 - radius * Math.sin(Math.toRadians(f9))));
/*      */     } 
/*  267 */     GL11.glEnd();
/*  268 */     GL11.glBegin(6);
/*  269 */     f6 = x0 + radius;
/*  270 */     f7 = y1 - radius;
/*  271 */     GL11.glVertex2f(f6, f7);
/*  272 */     for (j = 0; j <= 18; j++) {
/*  273 */       float f10 = j * 5.0F;
/*  274 */       GL11.glVertex2f((float)(f6 - radius * Math.cos(Math.toRadians(f10))), 
/*  275 */           (float)(f7 + radius * Math.sin(Math.toRadians(f10))));
/*      */     } 
/*  277 */     GL11.glEnd();
/*  278 */     GL11.glBegin(6);
/*  279 */     f6 = x1 - radius;
/*  280 */     f7 = y1 - radius;
/*  281 */     GL11.glVertex2f(f6, f7);
/*  282 */     for (j = 0; j <= 18; j++) {
/*  283 */       float f11 = j * 5.0F;
/*  284 */       GL11.glVertex2f((float)(f6 + radius * Math.cos(Math.toRadians(f11))), 
/*  285 */           (float)(f7 + radius * Math.sin(Math.toRadians(f11))));
/*      */     } 
/*  287 */     GL11.glEnd();
/*  288 */     GL11.glEnable(3553);
/*  289 */     GL11.glEnable(2884);
/*  290 */     GL11.glDisable(3042);
/*  291 */     GlStateManager.func_179098_w();
/*  292 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   
/*      */   public static void prepareScissorBox(float x, float y, float x2, float y2) {
/*  296 */     ScaledResolution scale = new ScaledResolution(Minecraft.func_71410_x());
/*  297 */     int factor = scale.func_78325_e();
/*  298 */     GL11.glScissor((int)(x * factor), (int)((scale.func_78328_b() - y2) * factor), (int)((x2 - x) * factor), (int)((y2 - y) * factor));
/*      */   }
/*      */   public static void drawGradientSidewaysV(double left, double top, double right, double bottom, int col1, int col2) {
/*  301 */     GL11.glEnable(3042);
/*  302 */     GL11.glDisable(3553);
/*  303 */     GL11.glBlendFunc(770, 771);
/*  304 */     GL11.glEnable(2848);
/*  305 */     GL11.glShadeModel(7425);
/*      */     
/*  307 */     quickDrawGradientSidewaysV(left, top, right, bottom, col1, col2);
/*      */     
/*  309 */     GL11.glEnable(3553);
/*  310 */     GL11.glDisable(3042);
/*  311 */     GL11.glDisable(2848);
/*  312 */     GL11.glShadeModel(7424);
/*      */   }
/*      */   public static void drawGradientSidewaysH(double left, double top, double right, double bottom, int col1, int col2) {
/*  315 */     GL11.glEnable(3042);
/*  316 */     GL11.glDisable(3553);
/*  317 */     GL11.glBlendFunc(770, 771);
/*  318 */     GL11.glEnable(2848);
/*  319 */     GL11.glShadeModel(7425);
/*      */     
/*  321 */     quickDrawGradientSidewaysH(left, top, right, bottom, col1, col2);
/*      */     
/*  323 */     GL11.glEnable(3553);
/*  324 */     GL11.glDisable(3042);
/*  325 */     GL11.glDisable(2848);
/*  326 */     GL11.glShadeModel(7424);
/*      */   }
/*      */   public static void drawRect(double x, double y, double x2, double y2, int color) {
/*  329 */     GL11.glEnable(3042);
/*  330 */     GL11.glDisable(3553);
/*  331 */     GL11.glBlendFunc(770, 771);
/*  332 */     GL11.glEnable(2848);
/*      */     
/*  334 */     glColor(color);
/*  335 */     GL11.glBegin(7);
/*      */     
/*  337 */     GL11.glVertex2d(x2, y);
/*  338 */     GL11.glVertex2d(x, y);
/*  339 */     GL11.glVertex2d(x, y2);
/*  340 */     GL11.glVertex2d(x2, y2);
/*  341 */     GL11.glEnd();
/*      */     
/*  343 */     GL11.glEnable(3553);
/*  344 */     GL11.glDisable(3042);
/*  345 */     GL11.glDisable(2848);
/*      */   }
/*      */   public static void quickDrawGradientSidewaysV(double left, double top, double right, double bottom, int col1, int col2) {
/*  348 */     GL11.glBegin(7);
/*      */     
/*  350 */     glColor(col1);
/*  351 */     GL11.glVertex2d(right, top);
/*  352 */     GL11.glVertex2d(left, top);
/*  353 */     glColor(col2);
/*  354 */     GL11.glVertex2d(left, bottom);
/*  355 */     GL11.glVertex2d(right, bottom);
/*      */     
/*  357 */     GL11.glEnd();
/*      */   }
/*      */   public static void quickDrawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
/*  360 */     GL11.glBegin(7);
/*  361 */     glColor(col1);
/*  362 */     GL11.glVertex2d(left, top);
/*  363 */     GL11.glVertex2d(left, bottom);
/*      */     
/*  365 */     glColor(col2);
/*  366 */     GL11.glVertex2d(right, bottom);
/*  367 */     GL11.glVertex2d(right, top);
/*  368 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawRoundedCornerRect(float x, float y, float x1, float y1, float radius, int color) {
/*  372 */     GL11.glEnable(3042);
/*  373 */     GL11.glBlendFunc(770, 771);
/*  374 */     GL11.glDisable(3553);
/*  375 */     boolean hasCull = GL11.glIsEnabled(2884);
/*  376 */     GL11.glDisable(2884);
/*      */     
/*  378 */     glColor(color);
/*  379 */     drawRoundedCornerRect(x, y, x1, y1, radius);
/*      */     
/*  381 */     GL11.glEnable(3553);
/*  382 */     GL11.glDisable(3042);
/*  383 */     setGlState(2884, hasCull);
/*      */   }
/*      */   public static void drawShadowWithCustomAlpha(float x, float y, float width, float height, float alpha) {
/*  386 */     drawTexturedRectWithCustomAlpha(x - 9.0F, y - 9.0F, 9.0F, 9.0F, "paneltopleft", alpha);
/*  387 */     drawTexturedRectWithCustomAlpha(x - 9.0F, y + height, 9.0F, 9.0F, "panelbottomleft", alpha);
/*  388 */     drawTexturedRectWithCustomAlpha(x + width, y + height, 9.0F, 9.0F, "panelbottomright", alpha);
/*  389 */     drawTexturedRectWithCustomAlpha(x + width, y - 9.0F, 9.0F, 9.0F, "paneltopright", alpha);
/*  390 */     drawTexturedRectWithCustomAlpha(x - 9.0F, y, 9.0F, height, "panelleft", alpha);
/*  391 */     drawTexturedRectWithCustomAlpha(x + width, y, 9.0F, height, "panelright", alpha);
/*  392 */     drawTexturedRectWithCustomAlpha(x, y - 9.0F, width, 9.0F, "paneltop", alpha);
/*  393 */     drawTexturedRectWithCustomAlpha(x, y + height, width, 9.0F, "panelbottom", alpha);
/*      */   }
/*      */   public static double getAnimationStateSmooth(double target, double current, double speed) {
/*  396 */     boolean larger = (target > current);
/*  397 */     if (speed < 0.0D) {
/*  398 */       speed = 0.0D;
/*  399 */     } else if (speed > 1.0D) {
/*  400 */       speed = 1.0D;
/*      */     } 
/*  402 */     if (target == current) {
/*  403 */       return target;
/*      */     }
/*  405 */     double dif = Math.max(target, current) - Math.min(target, current);
/*  406 */     double factor = dif * speed;
/*  407 */     if (factor < 0.1D) {
/*  408 */       factor = 0.1D;
/*      */     }
/*  410 */     if (larger) {
/*  411 */       if (current + factor > target) {
/*  412 */         current = target;
/*      */       } else {
/*  414 */         current += factor;
/*      */       }
/*      */     
/*  417 */     } else if (current - factor < target) {
/*  418 */       current = target;
/*      */     } else {
/*  420 */       current -= factor;
/*      */     } 
/*      */     
/*  423 */     return current;
/*      */   }
/*      */   public static void drawScaledCustomSizeModalCircle(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height, float tileWidth, float tileHeight) {
/*  426 */     float f = 1.0F / tileWidth;
/*  427 */     float f1 = 1.0F / tileHeight;
/*  428 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/*  429 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  430 */     worldrenderer.begin(9, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/*  431 */     float xRadius = width / 2.0F;
/*  432 */     float yRadius = height / 2.0F;
/*  433 */     float uRadius = ((u + uWidth) * f - u * f) / 2.0F;
/*  434 */     float vRadius = ((v + vHeight) * f1 - v * f1) / 2.0F;
/*  435 */     for (int i = 0; i <= 360; i += 10) {
/*  436 */       double xPosOffset = Math.sin(i * Math.PI / 180.0D);
/*  437 */       double yPosOffset = Math.cos(i * Math.PI / 180.0D);
/*  438 */       worldrenderer.pos((x + xRadius) + xPosOffset * xRadius, (y + yRadius) + yPosOffset * yRadius, 0.0D)
/*  439 */         .tex((u * f + uRadius) + xPosOffset * uRadius, (v * f1 + vRadius) + yPosOffset * vRadius).endVertex();
/*      */     } 
/*  441 */     tessellator.draw();
/*      */   }
/*      */   public static void quickDrawGradientSidewaysH(double left, double top, double right, double bottom, int col1, int col2) {
/*  444 */     GL11.glBegin(7);
/*      */     
/*  446 */     glColor(col1);
/*  447 */     GL11.glVertex2d(left, top);
/*  448 */     GL11.glVertex2d(left, bottom);
/*  449 */     glColor(col2);
/*  450 */     GL11.glVertex2d(right, bottom);
/*  451 */     GL11.glVertex2d(right, top);
/*      */     
/*  453 */     GL11.glEnd();
/*      */   }
/*      */   public static void drawTexturedRectWithCustomAlpha(float x, float y, float width, float height, String image, float alpha) {
/*  456 */     GL11.glPushMatrix();
/*  457 */     boolean enableBlend = GL11.glIsEnabled(3042);
/*  458 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/*  459 */     if (!enableBlend) GL11.glEnable(3042); 
/*  460 */     if (!disableAlpha) GL11.glDisable(3008); 
/*  461 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, alpha);
/*  462 */     mc.getTextureManager().bindTexture2(new ResourceLocation("CatBounce/shadow/" + image + ".png"));
/*  463 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/*  464 */     if (!enableBlend) GL11.glDisable(3042); 
/*  465 */     if (!disableAlpha) GL11.glEnable(3008); 
/*  466 */     GlStateManager.func_179117_G();
/*  467 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawRoundedCornerRect(float x, float y, float x1, float y1, float radius) {
/*  471 */     GL11.glBegin(9);
/*      */     
/*  473 */     float xRadius = (float)Math.min((x1 - x) * 0.5D, radius);
/*  474 */     float yRadius = (float)Math.min((y1 - y) * 0.5D, radius);
/*  475 */     quickPolygonCircle(x + xRadius, y + yRadius, xRadius, yRadius, 180, 270, 4);
/*  476 */     quickPolygonCircle(x1 - xRadius, y + yRadius, xRadius, yRadius, 90, 180, 4);
/*  477 */     quickPolygonCircle(x1 - xRadius, y1 - yRadius, xRadius, yRadius, 0, 90, 4);
/*  478 */     quickPolygonCircle(x + xRadius, y1 - yRadius, xRadius, yRadius, 270, 360, 4);
/*      */     
/*  480 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static float fastRoundedRect(float x, float y, float x2, float y2, float rad) {
/*  484 */     return 0.65F;
/*      */   } private static void quickPolygonCircle(float x, float y, float xRadius, float yRadius, int start, int end, int split) {
/*      */     int i;
/*  487 */     for (i = end; i >= start; i -= split)
/*  488 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * xRadius, y + Math.cos(i * Math.PI / 180.0D) * yRadius); 
/*      */   }
/*      */   
/*      */   public static Color skyRainbow(int var2, float st, float bright) {
/*  492 */     double v1 = Math.ceil((System.currentTimeMillis() + (var2 * 109))) / 5.0D;
/*  493 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), st, bright);
/*      */   }
/*      */   public static void quickDrawHead(IResourceLocation skin, int x, int y, int width, int height) {
/*  496 */     mc.getTextureManager().bindTexture(skin);
/*  497 */     drawScaledCustomSizeModalRect(x, y, 8.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */     
/*  499 */     drawScaledCustomSizeModalRect(x, y, 40.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */   }
/*      */   
/*      */   public static void drawCircleRect(float x, float y, float x1, float y1, float radius, int color) {
/*  503 */     GlStateManager.func_179147_l();
/*  504 */     GlStateManager.func_179090_x();
/*  505 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  506 */     glColor(color);
/*      */ 
/*      */     
/*  509 */     quickRenderCircle((x1 - radius), (y1 - radius), 0.0D, 90.0D, radius, radius);
/*  510 */     quickRenderCircle((x + radius), (y1 - radius), 90.0D, 180.0D, radius, radius);
/*  511 */     quickRenderCircle((x + radius), (y + radius), 180.0D, 270.0D, radius, radius);
/*  512 */     quickRenderCircle((x1 - radius), (y + radius), 270.0D, 360.0D, radius, radius);
/*      */ 
/*      */     
/*  515 */     quickDrawRect(x + radius, y + radius, x1 - radius, y1 - radius);
/*  516 */     quickDrawRect(x, y + radius, x + radius, y1 - radius);
/*  517 */     quickDrawRect(x1 - radius, y + radius, x1, y1 - radius);
/*  518 */     quickDrawRect(x + radius, y, x1 - radius, y + radius);
/*  519 */     quickDrawRect(x + radius, y1 - radius, x1 - radius, y1);
/*      */     
/*  521 */     GlStateManager.func_179098_w();
/*  522 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   public static void drawArc(float n, float n2, double n3, int n4, int n5, double n6, int n7) {
/*  525 */     n3 *= 2.0D;
/*  526 */     n *= 2.0F;
/*  527 */     n2 *= 2.0F;
/*  528 */     float n8 = (n4 >> 24 & 0xFF) / 255.0F;
/*  529 */     float n9 = (n4 >> 16 & 0xFF) / 255.0F;
/*  530 */     float n10 = (n4 >> 8 & 0xFF) / 255.0F;
/*  531 */     float n11 = (n4 & 0xFF) / 255.0F;
/*  532 */     GL11.glDisable(2929);
/*  533 */     GL11.glEnable(3042);
/*  534 */     GL11.glDisable(3553);
/*  535 */     GL11.glBlendFunc(770, 771);
/*  536 */     GL11.glDepthMask(true);
/*  537 */     GL11.glEnable(2848);
/*  538 */     GL11.glHint(3154, 4354);
/*  539 */     GL11.glHint(3155, 4354);
/*  540 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*  541 */     GL11.glLineWidth(n7);
/*  542 */     GL11.glEnable(2848);
/*  543 */     GL11.glColor4f(n9, n10, n11, n8);
/*  544 */     GL11.glBegin(3);
/*  545 */     int n12 = n5;
/*  546 */     while (n12 <= n6) {
/*  547 */       GL11.glVertex2d(n + Math.sin(n12 * Math.PI / 180.0D) * n3, n2 + Math.cos(n12 * Math.PI / 180.0D) * n3);
/*  548 */       n12++;
/*      */     } 
/*  550 */     GL11.glEnd();
/*  551 */     GL11.glDisable(2848);
/*  552 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/*  553 */     GL11.glEnable(3553);
/*  554 */     GL11.glDisable(3042);
/*  555 */     GL11.glEnable(2929);
/*  556 */     GL11.glDisable(2848);
/*  557 */     GL11.glHint(3154, 4352);
/*  558 */     GL11.glHint(3155, 4352);
/*      */   }
/*      */   
/*      */   public static void quickRenderCircle(double x, double y, double start, double end, double w, double h) {
/*  562 */     if (start > end) {
/*  563 */       double temp = end;
/*  564 */       end = start;
/*  565 */       start = temp;
/*      */     } 
/*      */     
/*  568 */     GL11.glBegin(6);
/*  569 */     GL11.glVertex2d(x, y); double i;
/*  570 */     for (i = end; i >= start; i -= 4.0D) {
/*  571 */       double ldx = Math.cos(i * Math.PI / 180.0D) * w;
/*  572 */       double ldy = Math.sin(i * Math.PI / 180.0D) * h;
/*  573 */       GL11.glVertex2d(x + ldx, y + ldy);
/*      */     } 
/*  575 */     GL11.glVertex2d(x, y);
/*  576 */     GL11.glEnd();
/*      */   }
/*      */   public static void drawRectPotion(float x, float y, float x2, float y2, int color) {
/*  579 */     GL11.glEnable(3042);
/*  580 */     GL11.glDisable(3553);
/*  581 */     GL11.glBlendFunc(770, 771);
/*  582 */     GL11.glEnable(2848);
/*      */     
/*  584 */     GL11.glPushMatrix();
/*  585 */     glColor(color);
/*      */     
/*  587 */     GL11.glBegin(7);
/*  588 */     GL11.glVertex2d(x2, y);
/*  589 */     GL11.glVertex2d(x, y);
/*  590 */     GL11.glVertex2d(x, y2);
/*  591 */     GL11.glVertex2d(x2, y2);
/*  592 */     GL11.glEnd();
/*      */     
/*  594 */     GL11.glPopMatrix();
/*  595 */     GL11.glEnable(3553);
/*  596 */     GL11.glDisable(3042);
/*  597 */     GL11.glDisable(2848);
/*      */   }
/*      */   public static void drawShadow1(float x, float y, float width, float height) {
/*  600 */     drawTexturedRect(x - 9.0F, y - 9.0F, 9.0F, 9.0F, "paneltopleft");
/*  601 */     drawTexturedRect(x - 9.0F, y + height, 9.0F, 9.0F, "panelbottomleft");
/*  602 */     drawTexturedRect(x + width, y + height, 9.0F, 9.0F, "panelbottomright");
/*  603 */     drawTexturedRect(x + width, y - 9.0F, 9.0F, 9.0F, "paneltopright");
/*  604 */     drawTexturedRect(x - 9.0F, y, 9.0F, height, "panelleft");
/*  605 */     drawTexturedRect(x + width, y, 9.0F, height, "panelright");
/*  606 */     drawTexturedRect(x, y - 9.0F, width, 9.0F, "paneltop");
/*  607 */     drawTexturedRect(x, y + height, width, 9.0F, "panelbottom");
/*      */   }
/*      */   public static void drawTexturedRect(float x, float y, float width, float height, String image) {
/*  610 */     GL11.glPushMatrix();
/*  611 */     boolean enableBlend = GL11.glIsEnabled(3042);
/*  612 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/*  613 */     if (!enableBlend) {
/*  614 */       GL11.glEnable(3042);
/*      */     }
/*  616 */     if (!disableAlpha) {
/*  617 */       GL11.glDisable(3008);
/*      */     }
/*  619 */     mc.getTextureManager().bindTexture(classProvider.createResourceLocation("CatBounce/old/potionrender/" + image + ".png"));
/*  620 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  621 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/*  622 */     if (!enableBlend) {
/*  623 */       GL11.glDisable(3042);
/*      */     }
/*  625 */     if (!disableAlpha) {
/*  626 */       GL11.glEnable(3008);
/*      */     }
/*  628 */     GL11.glPopMatrix();
/*      */   }
/*      */   public static void drawShadow(int x, int y, int width, int height) {
/*  631 */     IScaledResolution sr = classProvider.createScaledResolution(mc);
/*  632 */     drawTexturedRect(x - 9, y - 9, 9, 9, "paneltopleft", sr);
/*  633 */     drawTexturedRect(x - 9, y + height, 9, 9, "panelbottomleft", sr);
/*  634 */     drawTexturedRect(x + width, y + height, 9, 9, "panelbottomright", sr);
/*  635 */     drawTexturedRect(x + width, y - 9, 9, 9, "paneltopright", sr);
/*  636 */     drawTexturedRect(x - 9, y, 9, height, "panelleft", sr);
/*  637 */     drawTexturedRect(x + width, y, 9, height, "panelright", sr);
/*  638 */     drawTexturedRect(x, y - 9, width, 9, "paneltop", sr);
/*  639 */     drawTexturedRect(x, y + height, width, 9, "panelbottom", sr);
/*      */   }
/*      */   public static int Astolfo(int var2, float st, float bright) {
/*  642 */     double currentColor = Math.ceil((System.currentTimeMillis() + (var2 * 130))) / 6.0D;
/*  643 */     return Color.getHSBColor(((float)((currentColor %= 360.0D) / 360.0D) < 0.5D) ? -((float)(currentColor / 360.0D)) : (float)(currentColor / 360.0D), st, bright).getRGB();
/*      */   }
/*      */ 
/*      */   
/*      */   public static Color getGradientOffset(Color color1, Color color2, double offset) {
/*  648 */     if (offset > 1.0D) {
/*  649 */       double d = offset % 1.0D;
/*  650 */       int i = (int)offset;
/*  651 */       offset = (i % 2 == 0) ? d : (1.0D - d);
/*      */     } 
/*  653 */     double inverse_percent = 1.0D - offset;
/*  654 */     int redPart = (int)(color1.getRed() * inverse_percent + color2.getRed() * offset);
/*  655 */     int greenPart = (int)(color1.getGreen() * inverse_percent + color2.getGreen() * offset);
/*  656 */     int bluePart = (int)(color1.getBlue() * inverse_percent + color2.getBlue() * offset);
/*  657 */     return new Color(redPart, greenPart, bluePart);
/*      */   }
/*      */   public static void drawTexturedRect(int x, int y, int width, int height, String image, IScaledResolution sr) {
/*  660 */     GL11.glPushMatrix();
/*  661 */     GlStateManager.func_179147_l();
/*  662 */     GlStateManager.func_179118_c();
/*  663 */     mc.getTextureManager().bindTexture(classProvider.createResourceLocation("CatBounce/old/potionrender/" + image + ".png"));
/*  664 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  665 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/*  666 */     GlStateManager.func_179084_k();
/*  667 */     GlStateManager.func_179141_d();
/*  668 */     GL11.glPopMatrix();
/*      */   }
/*      */   public static void drawHead(IResourceLocation skin, int x, int y, int width, int height) {
/*  671 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  672 */     mc.getTextureManager().bindTexture(skin);
/*  673 */     drawScaledCustomSizeModalRect(x, y, 8.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */     
/*  675 */     drawScaledCustomSizeModalRect(x, y, 40.0F, 8.0F, 8, 8, width, height, 64.0F, 64.0F);
/*      */   }
/*      */   
/*      */   public static void drawEntityOnScreen(int posX, int posY, int scale, IEntityLivingBase entity) {
/*  679 */     GlStateManager.func_179094_E();
/*  680 */     GlStateManager.func_179142_g();
/*      */     
/*  682 */     GlStateManager.func_179137_b(posX, posY, 50.0D);
/*  683 */     GlStateManager.func_179152_a(-scale, scale, scale);
/*  684 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  685 */     GlStateManager.func_179114_b(135.0F, 0.0F, 1.0F, 0.0F);
/*  686 */     RenderHelper.func_74519_b();
/*  687 */     GlStateManager.func_179114_b(-135.0F, 0.0F, 1.0F, 0.0F);
/*  688 */     GlStateManager.func_179137_b(0.0D, 0.0D, 0.0D);
/*      */     
/*  690 */     float renderYawOffset = entity.getRenderYawOffset();
/*  691 */     float rotationYaw = entity.getRotationYaw();
/*  692 */     float rotationPitch = entity.getRotationPitch();
/*  693 */     float prevRotationYawHead = entity.getPrevRotationYawHead();
/*  694 */     float rotationYawHead = entity.getRotationYawHead();
/*      */ 
/*      */     
/*  697 */     entity.setRenderYawOffset(0.0F);
/*  698 */     entity.setRotationYaw(0.0F);
/*  699 */     entity.setRotationPitch(90.0F);
/*  700 */     entity.setRotationYawHead(entity.getRotationYaw());
/*  701 */     entity.setPrevRotationYawHead(entity.getRotationYaw());
/*      */     
/*  703 */     IRenderManager rendermanager = mc.getRenderManager();
/*  704 */     rendermanager.setPlayerViewY(180.0F);
/*  705 */     rendermanager.setRenderShadow(false);
/*  706 */     rendermanager.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/*  707 */     rendermanager.setRenderShadow(true);
/*      */     
/*  709 */     entity.setRenderYawOffset(renderYawOffset);
/*  710 */     entity.setRotationYaw(rotationYaw);
/*  711 */     entity.setRotationPitch(rotationPitch);
/*  712 */     entity.setPrevRotationYawHead(prevRotationYawHead);
/*  713 */     entity.setRotationYawHead(rotationYawHead);
/*      */     
/*  715 */     GlStateManager.func_179121_F();
/*  716 */     RenderHelper.func_74518_a();
/*  717 */     GlStateManager.func_179101_C();
/*  718 */     GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
/*  719 */     GlStateManager.func_179090_x();
/*  720 */     GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
/*      */   }
/*      */   public static void pre3D() {
/*  723 */     GL11.glPushMatrix();
/*  724 */     GL11.glEnable(3042);
/*  725 */     GL11.glBlendFunc(770, 771);
/*  726 */     GL11.glShadeModel(7425);
/*  727 */     GL11.glDisable(3553);
/*  728 */     GL11.glEnable(2848);
/*  729 */     GL11.glDisable(2929);
/*  730 */     GL11.glDisable(2896);
/*  731 */     GL11.glDepthMask(false);
/*  732 */     GL11.glHint(3154, 4354);
/*      */   }
/*      */   
/*      */   public static void post3D() {
/*  736 */     GL11.glDepthMask(true);
/*  737 */     GL11.glEnable(2929);
/*  738 */     GL11.glDisable(2848);
/*  739 */     GL11.glEnable(3553);
/*  740 */     GL11.glDisable(3042);
/*  741 */     GL11.glPopMatrix();
/*  742 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public static void bindTexture(int texture) {
/*  746 */     GL11.glBindTexture(3553, texture);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setAlphaLimit(float limit) {
/*  751 */     GlStateManager.func_179141_d();
/*  752 */     GlStateManager.func_179092_a(516, (float)(limit * 0.01D));
/*      */   }
/*      */   public static Framebuffer createFrameBuffer(Framebuffer framebuffer) {
/*  755 */     if (framebuffer == null || framebuffer.field_147621_c != mc.getDisplayWidth() || framebuffer.field_147618_d != mc.getDisplayHeight()) {
/*  756 */       if (framebuffer != null) {
/*  757 */         framebuffer.func_147608_a();
/*      */       }
/*  759 */       return new Framebuffer(mc.getDisplayWidth(), mc.getDisplayHeight(), true);
/*      */     } 
/*  761 */     return framebuffer;
/*      */   }
/*      */   
/*      */   public static void glColor(Color color, int alpha) {
/*  765 */     glColor(color, alpha / 255.0F);
/*      */   }
/*      */   
/*      */   public static void glColor(Color color, float alpha) {
/*  769 */     float red = color.getRed() / 255.0F;
/*  770 */     float green = color.getGreen() / 255.0F;
/*  771 */     float blue = color.getBlue() / 255.0F;
/*      */     
/*  773 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/*      */   }
/*      */   
/*      */   public static void glColorHex(int hex) {
/*  777 */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/*  778 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/*  779 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/*  780 */     float blue = (hex & 0xFF) / 255.0F;
/*  781 */     GL11.glColor4f(red, green, blue, alpha);
/*      */   }
/*      */   
/*      */   public static void drawGradient(double x, double y, double x2, double y2, int col1, int col2) {
/*  785 */     float f = (col1 >> 24 & 0xFF) / 255.0F;
/*  786 */     float f1 = (col1 >> 16 & 0xFF) / 255.0F;
/*  787 */     float f2 = (col1 >> 8 & 0xFF) / 255.0F;
/*  788 */     float f3 = (col1 & 0xFF) / 255.0F;
/*  789 */     float f4 = (col2 >> 24 & 0xFF) / 255.0F;
/*  790 */     float f5 = (col2 >> 16 & 0xFF) / 255.0F;
/*  791 */     float f6 = (col2 >> 8 & 0xFF) / 255.0F;
/*  792 */     float f7 = (col2 & 0xFF) / 255.0F;
/*  793 */     GL11.glEnable(3042);
/*  794 */     GL11.glDisable(3553);
/*  795 */     GL11.glBlendFunc(770, 771);
/*  796 */     GL11.glEnable(2848);
/*  797 */     GL11.glShadeModel(7425);
/*  798 */     GL11.glPushMatrix();
/*  799 */     GL11.glBegin(7);
/*  800 */     GL11.glColor4f(f1, f2, f3, f);
/*  801 */     GL11.glVertex2d(x2, y);
/*  802 */     GL11.glVertex2d(x, y);
/*  803 */     GL11.glColor4f(f5, f6, f7, f4);
/*  804 */     GL11.glVertex2d(x, y2);
/*  805 */     GL11.glVertex2d(x2, y2);
/*  806 */     GL11.glEnd();
/*  807 */     GL11.glPopMatrix();
/*  808 */     GL11.glEnable(3553);
/*  809 */     GL11.glDisable(3042);
/*  810 */     GL11.glDisable(2848);
/*  811 */     GL11.glShadeModel(7424);
/*  812 */     GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
/*      */   }
/*      */   
/*      */   public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
/*  816 */     if (left < right) {
/*  817 */       double var5 = left;
/*  818 */       left = right;
/*  819 */       right = var5;
/*      */     } 
/*  821 */     if (top < bottom) {
/*  822 */       double var5 = top;
/*  823 */       top = bottom;
/*  824 */       bottom = var5;
/*      */     } 
/*  826 */     float f = (col1 >> 24 & 0xFF) / 255.0F;
/*  827 */     float f1 = (col1 >> 16 & 0xFF) / 255.0F;
/*  828 */     float f2 = (col1 >> 8 & 0xFF) / 255.0F;
/*  829 */     float f3 = (col1 & 0xFF) / 255.0F;
/*  830 */     float f4 = (col2 >> 24 & 0xFF) / 255.0F;
/*  831 */     float f5 = (col2 >> 16 & 0xFF) / 255.0F;
/*  832 */     float f6 = (col2 >> 8 & 0xFF) / 255.0F;
/*  833 */     float f7 = (col2 & 0xFF) / 255.0F;
/*  834 */     GL11.glEnable(3042);
/*  835 */     GL11.glDisable(3553);
/*  836 */     GL11.glBlendFunc(770, 771);
/*  837 */     GL11.glEnable(2848);
/*  838 */     GL11.glShadeModel(7425);
/*  839 */     GL11.glPushMatrix();
/*  840 */     GL11.glBegin(7);
/*  841 */     GL11.glColor4f(f1, f2, f3, f);
/*  842 */     GL11.glVertex2d(left, top);
/*  843 */     GL11.glVertex2d(left, bottom);
/*  844 */     GL11.glColor4f(f5, f6, f7, f4);
/*  845 */     GL11.glVertex2d(right, bottom);
/*  846 */     GL11.glVertex2d(right, top);
/*  847 */     GL11.glEnd();
/*  848 */     GL11.glPopMatrix();
/*  849 */     GL11.glEnable(3553);
/*  850 */     GL11.glDisable(3042);
/*  851 */     GL11.glDisable(2848);
/*  852 */     GL11.glShadeModel(7424);
/*      */   }
/*      */   
/*      */   public static void rectangle(double left, double top, double right, double bottom, int color) {
/*  856 */     if (left < right) {
/*  857 */       double var5 = left;
/*  858 */       left = right;
/*  859 */       right = var5;
/*      */     } 
/*  861 */     if (top < bottom) {
/*  862 */       double var5 = top;
/*  863 */       top = bottom;
/*  864 */       bottom = var5;
/*      */     } 
/*  866 */     float var11 = (color >> 24 & 0xFF) / 255.0F;
/*  867 */     float var6 = (color >> 16 & 0xFF) / 255.0F;
/*  868 */     float var7 = (color >> 8 & 0xFF) / 255.0F;
/*  869 */     float var8 = (color & 0xFF) / 255.0F;
/*  870 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/*  871 */     IWorldRenderer worldRenderer = tessellator.getWorldRenderer();
/*  872 */     GlStateManager.func_179147_l();
/*  873 */     GlStateManager.func_179090_x();
/*  874 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  875 */     GlStateManager.func_179131_c(var6, var7, var8, var11);
/*  876 */     worldRenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*  877 */     worldRenderer.pos(left, bottom, 0.0D).endVertex();
/*  878 */     worldRenderer.pos(right, bottom, 0.0D).endVertex();
/*  879 */     worldRenderer.pos(right, top, 0.0D).endVertex();
/*  880 */     worldRenderer.pos(left, top, 0.0D).endVertex();
/*  881 */     Tessellator.func_178181_a().func_78381_a();
/*  882 */     GlStateManager.func_179098_w();
/*  883 */     GlStateManager.func_179084_k();
/*  884 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void rectangleBordered(double x, double y, double x1, double y1, double width, int internalColor, int borderColor) {
/*  889 */     rectangle(x + width, y + width, x1 - width, y1 - width, internalColor);
/*  890 */     rectangle(x + width, y, x1 - width, y + width, borderColor);
/*  891 */     rectangle(x, y, x + width, y1, borderColor);
/*  892 */     rectangle(x1 - width, y, x1, y1, borderColor);
/*  893 */     rectangle(x + width, y1 - width, x1 - width, y1, borderColor);
/*      */   }
/*      */   
/*      */   public static void drawBlockOutlineBox(WBlockPos blockPos, Color color, float lineWidth) {
/*  897 */     IRenderManager renderManager = mc.getRenderManager();
/*  898 */     ITimer timer = mc.getTimer();
/*      */     
/*  900 */     double x = blockPos.getX() - renderManager.getRenderPosX();
/*  901 */     double y = blockPos.getY() - renderManager.getRenderPosY();
/*  902 */     double z = blockPos.getZ() - renderManager.getRenderPosZ();
/*      */     
/*  904 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
/*  905 */     IBlock block = BlockUtils.getBlock(blockPos);
/*      */     
/*  907 */     if (block != null) {
/*  908 */       IEntityPlayerSP iEntityPlayerSP = mc.getThePlayer();
/*      */       
/*  910 */       double posX = iEntityPlayerSP.getLastTickPosX() + (iEntityPlayerSP.getPosX() - iEntityPlayerSP.getLastTickPosX()) * timer.getRenderPartialTicks();
/*  911 */       double posY = iEntityPlayerSP.getLastTickPosY() + (iEntityPlayerSP.getPosY() - iEntityPlayerSP.getLastTickPosY()) * timer.getRenderPartialTicks();
/*  912 */       double posZ = iEntityPlayerSP.getLastTickPosZ() + (iEntityPlayerSP.getPosZ() - iEntityPlayerSP.getLastTickPosZ()) * timer.getRenderPartialTicks();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  920 */       axisAlignedBB = block.getSelectedBoundingBox((IWorld)mc.getTheWorld(), mc.getTheWorld().getBlockState(blockPos), blockPos).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-posX, -posY, -posZ);
/*      */     } 
/*      */     
/*  923 */     GL11.glBlendFunc(770, 771);
/*  924 */     enableGlCap(3042);
/*  925 */     disableGlCap(new int[] { 3553, 2929 });
/*  926 */     GL11.glDepthMask(false);
/*      */     
/*  928 */     glColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*      */     
/*  930 */     GL11.glLineWidth(lineWidth);
/*  931 */     enableGlCap(2848);
/*  932 */     glColor(color);
/*      */     
/*  934 */     drawSelectionBoundingBox(axisAlignedBB);
/*      */     
/*  936 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  937 */     GL11.glDepthMask(true);
/*  938 */     resetCaps();
/*      */   }
/*      */   public static double getAnimationState2(double animation, double finalState, double speed) {
/*  941 */     float add = (float)(0.01D * speed);
/*  942 */     if (animation < finalState) {
/*  943 */       if (animation + add < finalState) {
/*  944 */         animation += add;
/*      */       } else {
/*  946 */         animation = finalState;
/*      */       } 
/*  948 */     } else if (animation - add > finalState) {
/*  949 */       animation -= add;
/*      */     } else {
/*  951 */       animation = finalState;
/*      */     } 
/*  953 */     return animation;
/*      */   }
/*      */   public static void drawBlockBox(WBlockPos blockPos, Color color, boolean outline) {
/*  956 */     IRenderManager renderManager = mc.getRenderManager();
/*  957 */     ITimer timer = mc.getTimer();
/*      */     
/*  959 */     double x = blockPos.getX() - renderManager.getRenderPosX();
/*  960 */     double y = blockPos.getY() - renderManager.getRenderPosY();
/*  961 */     double z = blockPos.getZ() - renderManager.getRenderPosZ();
/*      */     
/*  963 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
/*  964 */     IBlock block = BlockUtils.getBlock(blockPos);
/*      */     
/*  966 */     if (block != null) {
/*  967 */       IEntityPlayerSP iEntityPlayerSP = mc.getThePlayer();
/*      */       
/*  969 */       double posX = iEntityPlayerSP.getLastTickPosX() + (iEntityPlayerSP.getPosX() - iEntityPlayerSP.getLastTickPosX()) * timer.getRenderPartialTicks();
/*  970 */       double posY = iEntityPlayerSP.getLastTickPosY() + (iEntityPlayerSP.getPosY() - iEntityPlayerSP.getLastTickPosY()) * timer.getRenderPartialTicks();
/*  971 */       double posZ = iEntityPlayerSP.getLastTickPosZ() + (iEntityPlayerSP.getPosZ() - iEntityPlayerSP.getLastTickPosZ()) * timer.getRenderPartialTicks();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  979 */       axisAlignedBB = block.getSelectedBoundingBox((IWorld)mc.getTheWorld(), mc.getTheWorld().getBlockState(blockPos), blockPos).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-posX, -posY, -posZ);
/*      */     } 
/*      */     
/*  982 */     GL11.glBlendFunc(770, 771);
/*  983 */     enableGlCap(3042);
/*  984 */     disableGlCap(new int[] { 3553, 2929 });
/*  985 */     GL11.glDepthMask(false);
/*      */     
/*  987 */     glColor(color.getRed(), color.getGreen(), color.getBlue(), (color.getAlpha() != 255) ? color.getAlpha() : (outline ? 26 : 35));
/*  988 */     drawFilledBox(axisAlignedBB);
/*      */     
/*  990 */     if (outline) {
/*  991 */       GL11.glLineWidth(1.0F);
/*  992 */       enableGlCap(2848);
/*  993 */       glColor(color);
/*      */       
/*  995 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } 
/*      */     
/*  998 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  999 */     GL11.glDepthMask(true);
/* 1000 */     resetCaps();
/*      */   }
/*      */   
/*      */   public static void drawSelectionBoundingBox(IAxisAlignedBB boundingBox) {
/* 1004 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1005 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*      */     
/* 1007 */     worldrenderer.begin(3, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */ 
/*      */     
/* 1010 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/* 1011 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/* 1012 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/* 1013 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/* 1014 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/*      */ 
/*      */     
/* 1017 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/* 1018 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/* 1019 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/* 1020 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/* 1021 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/*      */ 
/*      */     
/* 1024 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/* 1025 */     worldrenderer.pos(boundingBox.getMinX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/*      */     
/* 1027 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMaxZ()).endVertex();
/* 1028 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMaxZ()).endVertex();
/*      */     
/* 1030 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMaxY(), boundingBox.getMinZ()).endVertex();
/* 1031 */     worldrenderer.pos(boundingBox.getMaxX(), boundingBox.getMinY(), boundingBox.getMinZ()).endVertex();
/*      */     
/* 1033 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void drawItemBox(IEntity entity, Color color, boolean outline) {
/* 1037 */     IRenderManager renderManager = mc.getRenderManager();
/* 1038 */     ITimer timer = mc.getTimer();
/*      */     
/* 1040 */     GL11.glBlendFunc(770, 771);
/* 1041 */     enableGlCap(3042);
/* 1042 */     disableGlCap(new int[] { 3553, 2929 });
/* 1043 */     GL11.glDepthMask(false);
/*      */ 
/*      */     
/* 1046 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX();
/*      */     
/* 1048 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY();
/*      */     
/* 1050 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ();
/*      */     
/* 1052 */     IAxisAlignedBB entityBox = entity.getEntityBoundingBox();
/* 1053 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(entityBox
/* 1054 */         .getMinX() - entity.getPosX() + x, entityBox
/* 1055 */         .getMinY() - entity.getPosY() + y, entityBox
/* 1056 */         .getMinZ() - entity.getPosZ() + z, entityBox
/* 1057 */         .getMaxX() - entity.getPosX() + x, entityBox
/* 1058 */         .getMaxY() - entity.getPosY() + y, entityBox
/* 1059 */         .getMaxZ() - entity.getPosZ() + z);
/*      */ 
/*      */     
/* 1062 */     GL11.glPushMatrix();
/* 1063 */     GL11.glTranslated(x, y, z);
/* 1064 */     GL11.glRotated(-entity.getRotationYaw(), 0.0D, 1.0D, 0.0D);
/* 1065 */     GL11.glTranslated(-x, -y, -z);
/* 1066 */     if (outline) {
/*      */       
/* 1068 */       GL11.glLineWidth(1.0F);
/* 1069 */       enableGlCap(2848);
/* 1070 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), 255);
/* 1071 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } else {
/* 1073 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), 35);
/* 1074 */       drawFilledBox(axisAlignedBB);
/*      */     } 
/*      */     
/* 1077 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1078 */     GL11.glDepthMask(true);
/* 1079 */     resetCaps();
/* 1080 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawEntityBox(IEntity entity, Color color, boolean outline) {
/* 1084 */     IRenderManager renderManager = mc.getRenderManager();
/* 1085 */     ITimer timer = mc.getTimer();
/*      */     
/* 1087 */     GL11.glBlendFunc(770, 771);
/* 1088 */     enableGlCap(3042);
/* 1089 */     disableGlCap(new int[] { 3553, 2929 });
/* 1090 */     GL11.glDepthMask(false);
/*      */ 
/*      */     
/* 1093 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX();
/*      */     
/* 1095 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY();
/*      */     
/* 1097 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ();
/*      */     
/* 1099 */     IAxisAlignedBB entityBox = entity.getEntityBoundingBox();
/* 1100 */     IAxisAlignedBB axisAlignedBB = classProvider.createAxisAlignedBB(entityBox
/* 1101 */         .getMinX() - entity.getPosX() + x - 0.15D, entityBox
/* 1102 */         .getMinY() - entity.getPosY() + y, entityBox
/* 1103 */         .getMinZ() - entity.getPosZ() + z - 0.15D, entityBox
/* 1104 */         .getMaxX() - entity.getPosX() + x + 0.15D, entityBox
/* 1105 */         .getMaxY() - entity.getPosY() + y + 0.15D, entityBox
/* 1106 */         .getMaxZ() - entity.getPosZ() + z + 0.15D);
/*      */ 
/*      */     
/* 1109 */     GL11.glPushMatrix();
/* 1110 */     GL11.glTranslated(x, y, z);
/* 1111 */     GL11.glRotated(-entity.getRotationYaw(), 0.0D, 1.0D, 0.0D);
/* 1112 */     GL11.glTranslated(-x, -y, -z);
/* 1113 */     if (outline) {
/* 1114 */       GL11.glLineWidth(3.0F);
/* 1115 */       enableGlCap(2848);
/* 1116 */       glColor(0, 0, 0, 255);
/* 1117 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */       
/* 1119 */       GL11.glLineWidth(1.0F);
/* 1120 */       enableGlCap(2848);
/* 1121 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), 255);
/* 1122 */       drawSelectionBoundingBox(axisAlignedBB);
/*      */     } else {
/* 1124 */       glColor(color.getRed(), color.getGreen(), color.getBlue(), 35);
/* 1125 */       drawFilledBox(axisAlignedBB);
/*      */     } 
/*      */     
/* 1128 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1129 */     GL11.glDepthMask(true);
/* 1130 */     resetCaps();
/* 1131 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawAxisAlignedBB(IAxisAlignedBB axisAlignedBB, Color color) {
/* 1135 */     GL11.glBlendFunc(770, 771);
/* 1136 */     GL11.glEnable(3042);
/* 1137 */     GL11.glLineWidth(2.0F);
/* 1138 */     GL11.glDisable(3553);
/* 1139 */     GL11.glDisable(2929);
/* 1140 */     GL11.glDepthMask(false);
/* 1141 */     glColor(color);
/* 1142 */     drawFilledBox(axisAlignedBB);
/* 1143 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1144 */     GL11.glEnable(3553);
/* 1145 */     GL11.glEnable(2929);
/* 1146 */     GL11.glDepthMask(true);
/* 1147 */     GL11.glDisable(3042);
/*      */   }
/*      */   
/*      */   public static void drawPlatform(double y, Color color, double size) {
/* 1151 */     IRenderManager renderManager = mc.getRenderManager();
/* 1152 */     double renderY = y - renderManager.getRenderPosY();
/*      */     
/* 1154 */     drawAxisAlignedBB(classProvider.createAxisAlignedBB(size, renderY + 0.02D, size, -size, renderY, -size), color);
/*      */   }
/*      */   
/*      */   public static void drawPlatform(IEntity entity, Color color) {
/* 1158 */     IRenderManager renderManager = mc.getRenderManager();
/* 1159 */     ITimer timer = mc.getTimer();
/*      */ 
/*      */     
/* 1162 */     double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX();
/*      */     
/* 1164 */     double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY();
/*      */     
/* 1166 */     double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ();
/*      */ 
/*      */ 
/*      */     
/* 1170 */     IAxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().offset(-entity.getPosX(), -entity.getPosY(), -entity.getPosZ()).offset(x, y, z);
/*      */     
/* 1172 */     drawAxisAlignedBB(classProvider
/* 1173 */         .createAxisAlignedBB(axisAlignedBB.getMinX() - 0.15D, axisAlignedBB.getMinY(), axisAlignedBB.getMinZ() - 0.15D, axisAlignedBB.getMaxX() + 0.15D, axisAlignedBB.getMaxY() + 0.1D, axisAlignedBB.getMaxZ() + 0.15D), color);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void drawFilledBox(IAxisAlignedBB axisAlignedBB) {
/* 1179 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1180 */     IWorldRenderer worldRenderer = tessellator.getWorldRenderer();
/*      */     
/* 1182 */     worldRenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */     
/* 1184 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1185 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1186 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1187 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1188 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1189 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1190 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1191 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/*      */     
/* 1193 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1194 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1195 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1196 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1197 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1198 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1199 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1200 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/*      */     
/* 1202 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1203 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1204 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1205 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1206 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1207 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1208 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1209 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/*      */     
/* 1211 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1212 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1213 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1214 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1215 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1216 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1217 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1218 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/*      */     
/* 1220 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1221 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1222 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1223 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1224 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1225 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1226 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1227 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/*      */     
/* 1229 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1230 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1231 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1232 */     worldRenderer.pos(axisAlignedBB.getMinX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1233 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMinZ()).endVertex();
/* 1234 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMinZ()).endVertex();
/* 1235 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMaxY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1236 */     worldRenderer.pos(axisAlignedBB.getMaxX(), axisAlignedBB.getMinY(), axisAlignedBB.getMaxZ()).endVertex();
/* 1237 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void quickDrawRect(float x, float y, float x2, float y2) {
/* 1241 */     GL11.glBegin(7);
/*      */     
/* 1243 */     GL11.glVertex2d(x2, y);
/* 1244 */     GL11.glVertex2d(x, y);
/* 1245 */     GL11.glVertex2d(x, y2);
/* 1246 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 1248 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawRect(float x, float y, float x2, float y2, int color) {
/* 1252 */     GL11.glEnable(3042);
/* 1253 */     GL11.glDisable(3553);
/* 1254 */     GL11.glBlendFunc(770, 771);
/* 1255 */     GL11.glEnable(2848);
/*      */     
/* 1257 */     glColor(color);
/* 1258 */     GL11.glBegin(7);
/*      */     
/* 1260 */     GL11.glVertex2f(x2, y);
/* 1261 */     GL11.glVertex2f(x, y);
/* 1262 */     GL11.glVertex2f(x, y2);
/* 1263 */     GL11.glVertex2f(x2, y2);
/* 1264 */     GL11.glEnd();
/*      */     
/* 1266 */     GL11.glEnable(3553);
/* 1267 */     GL11.glDisable(3042);
/* 1268 */     GL11.glDisable(2848);
/*      */   }
/*      */   
/*      */   public static void drawRect(int x, int y, int x2, int y2, int color) {
/* 1272 */     GL11.glEnable(3042);
/* 1273 */     GL11.glDisable(3553);
/* 1274 */     GL11.glBlendFunc(770, 771);
/* 1275 */     GL11.glEnable(2848);
/*      */     
/* 1277 */     glColor(color);
/* 1278 */     GL11.glBegin(7);
/*      */     
/* 1280 */     GL11.glVertex2i(x2, y);
/* 1281 */     GL11.glVertex2i(x, y);
/* 1282 */     GL11.glVertex2i(x, y2);
/* 1283 */     GL11.glVertex2i(x2, y2);
/* 1284 */     GL11.glEnd();
/*      */     
/* 1286 */     GL11.glEnable(3553);
/* 1287 */     GL11.glDisable(3042);
/* 1288 */     GL11.glDisable(2848);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void quickDrawRect(float x, float y, float x2, float y2, int color) {
/* 1295 */     glColor(color);
/* 1296 */     GL11.glBegin(7);
/*      */     
/* 1298 */     GL11.glVertex2d(x2, y);
/* 1299 */     GL11.glVertex2d(x, y);
/* 1300 */     GL11.glVertex2d(x, y2);
/* 1301 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 1303 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawRect(float x, float y, float x2, float y2, Color color) {
/* 1307 */     drawRect(x, y, x2, y2, color.getRGB());
/*      */   }
/*      */   
/*      */   public static void startSmooth() {
/* 1311 */     GL11.glEnable(2848);
/* 1312 */     GL11.glEnable(2881);
/* 1313 */     GL11.glEnable(2832);
/* 1314 */     GL11.glEnable(3042);
/* 1315 */     GL11.glBlendFunc(770, 771);
/* 1316 */     GL11.glHint(3154, 4354);
/* 1317 */     GL11.glHint(3155, 4354);
/* 1318 */     GL11.glHint(3153, 4354);
/*      */   }
/*      */   
/*      */   public static void endSmooth() {
/* 1322 */     GL11.glDisable(2848);
/* 1323 */     GL11.glDisable(2881);
/* 1324 */     GL11.glEnable(2832);
/*      */   }
/*      */   
/*      */   public static void drawCircle(float cx, float cy, double r, int segments, float lineWidth, int part, boolean isFull, int c) {
/* 1328 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 1329 */     r *= 2.0D;
/* 1330 */     cx *= 2.0F;
/* 1331 */     cy *= 2.0F;
/* 1332 */     float f2 = (c >> 24 & 0xFF) / 255.0F;
/* 1333 */     float f3 = (c >> 16 & 0xFF) / 255.0F;
/* 1334 */     float f4 = (c >> 8 & 0xFF) / 255.0F;
/* 1335 */     float f5 = (c & 0xFF) / 255.0F;
/* 1336 */     GL11.glEnable(3042);
/* 1337 */     startSmooth();
/* 1338 */     GL11.glLineWidth(lineWidth);
/* 1339 */     GL11.glDisable(3553);
/* 1340 */     GL11.glEnable(2848);
/* 1341 */     GL11.glBlendFunc(770, 771);
/* 1342 */     GL11.glColor4f(f3, f4, f5, f2);
/* 1343 */     GL11.glBegin(3);
/* 1344 */     for (int i = segments - part; i <= segments; i++) {
/* 1345 */       double x = Math.sin(i * Math.PI / 180.0D) * r;
/* 1346 */       double y = Math.cos(i * Math.PI / 180.0D) * r;
/* 1347 */       GL11.glVertex2d(cx + x, cy + y);
/* 1348 */       if (isFull)
/* 1349 */         GL11.glVertex2d(cx, cy); 
/*      */     } 
/* 1351 */     GL11.glEnd();
/* 1352 */     GL11.glDisable(2848);
/* 1353 */     GL11.glEnable(3553);
/* 1354 */     endSmooth();
/* 1355 */     GL11.glDisable(3042);
/* 1356 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void drawBorderedRect(float x, float y, float x2, float y2, float width, int color1, int color2) {
/* 1361 */     drawRect(x, y, x2, y2, color2);
/* 1362 */     drawBorder(x, y, x2, y2, width, color1);
/*      */   }
/*      */   
/*      */   public static void drawBorder(float x, float y, float x2, float y2, float width, int color1) {
/* 1366 */     GL11.glEnable(3042);
/* 1367 */     GL11.glDisable(3553);
/* 1368 */     GL11.glBlendFunc(770, 771);
/* 1369 */     GL11.glEnable(2848);
/*      */     
/* 1371 */     glColor(color1);
/* 1372 */     GL11.glLineWidth(width);
/*      */     
/* 1374 */     GL11.glBegin(2);
/*      */     
/* 1376 */     GL11.glVertex2d(x2, y);
/* 1377 */     GL11.glVertex2d(x, y);
/* 1378 */     GL11.glVertex2d(x, y2);
/* 1379 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 1381 */     GL11.glEnd();
/*      */     
/* 1383 */     GL11.glEnable(3553);
/* 1384 */     GL11.glDisable(3042);
/* 1385 */     GL11.glDisable(2848);
/*      */   }
/*      */   
/*      */   public static void quickDrawBorderedRect(float x, float y, float x2, float y2, float width, int color1, int color2) {
/* 1389 */     quickDrawRect(x, y, x2, y2, color2);
/*      */     
/* 1391 */     glColor(color1);
/* 1392 */     GL11.glLineWidth(width);
/*      */     
/* 1394 */     GL11.glBegin(2);
/*      */     
/* 1396 */     GL11.glVertex2d(x2, y);
/* 1397 */     GL11.glVertex2d(x, y);
/* 1398 */     GL11.glVertex2d(x, y2);
/* 1399 */     GL11.glVertex2d(x2, y2);
/*      */     
/* 1401 */     GL11.glEnd();
/*      */   }
/*      */   
/*      */   public static void drawLoadingCircle(float x, float y) {
/* 1405 */     for (int i = 0; i < 4; i++) {
/* 1406 */       int rot = (int)(System.nanoTime() / 5000000L * i % 360L);
/* 1407 */       drawCircle(x, y, (i * 10), rot - 180, rot);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void drawCircle(float x, float y, float radius, int start, int end) {
/* 1412 */     classProvider.getGlStateManager().enableBlend();
/* 1413 */     classProvider.getGlStateManager().disableTexture2D();
/* 1414 */     classProvider.getGlStateManager().tryBlendFuncSeparate(770, 771, 1, 0);
/* 1415 */     glColor(Color.WHITE);
/*      */     
/* 1417 */     GL11.glEnable(2848);
/* 1418 */     GL11.glLineWidth(2.0F);
/* 1419 */     GL11.glBegin(3); float i;
/* 1420 */     for (i = end; i >= start; i -= 4.0F) {
/* 1421 */       GL11.glVertex2f((float)(x + Math.cos(i * Math.PI / 180.0D) * (radius * 1.001F)), (float)(y + Math.sin(i * Math.PI / 180.0D) * (radius * 1.001F)));
/*      */     }
/* 1423 */     GL11.glEnd();
/* 1424 */     GL11.glDisable(2848);
/*      */     
/* 1426 */     classProvider.getGlStateManager().enableTexture2D();
/* 1427 */     classProvider.getGlStateManager().disableBlend();
/*      */   }
/*      */   
/*      */   public static void drawFilledCircle(int xx, int yy, float radius, Color color) {
/* 1431 */     int sections = 50;
/* 1432 */     double dAngle = 6.283185307179586D / sections;
/*      */ 
/*      */     
/* 1435 */     GL11.glPushAttrib(8192);
/*      */     
/* 1437 */     GL11.glEnable(3042);
/* 1438 */     GL11.glDisable(3553);
/* 1439 */     GL11.glBlendFunc(770, 771);
/* 1440 */     GL11.glEnable(2848);
/* 1441 */     GL11.glBegin(6);
/*      */     
/* 1443 */     for (int i = 0; i < sections; i++) {
/* 1444 */       float x = (float)(radius * Math.sin(i * dAngle));
/* 1445 */       float y = (float)(radius * Math.cos(i * dAngle));
/*      */       
/* 1447 */       GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/* 1448 */       GL11.glVertex2f(xx + x, yy + y);
/*      */     } 
/*      */     
/* 1451 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     
/* 1453 */     GL11.glEnd();
/*      */     
/* 1455 */     GL11.glPopAttrib();
/*      */   }
/*      */   
/*      */   public static void drawFilledCircle(float xx, float yy, float radius, Color color) {
/* 1459 */     int sections = 50;
/* 1460 */     double dAngle = 6.283185307179586D / sections;
/*      */ 
/*      */     
/* 1463 */     GL11.glPushAttrib(8192);
/*      */     
/* 1465 */     GL11.glEnable(3042);
/* 1466 */     GL11.glDisable(3553);
/* 1467 */     GL11.glBlendFunc(770, 771);
/* 1468 */     GL11.glEnable(2848);
/* 1469 */     GL11.glBegin(6);
/*      */     
/* 1471 */     for (int i = 0; i < sections; i++) {
/* 1472 */       float x = (float)(radius * Math.sin(i * dAngle));
/* 1473 */       float y = (float)(radius * Math.cos(i * dAngle));
/*      */       
/* 1475 */       GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/* 1476 */       GL11.glVertex2f(xx + x, yy + y);
/*      */     } 
/*      */     
/* 1479 */     GlStateManager.func_179124_c(0.0F, 0.0F, 0.0F);
/*      */     
/* 1481 */     GL11.glEnd();
/*      */     
/* 1483 */     GL11.glPopAttrib();
/*      */   }
/*      */   
/*      */   public static void drawImage(IResourceLocation image, int x, int y, int width, int height) {
/* 1487 */     GL11.glDisable(2929);
/* 1488 */     GL11.glEnable(3042);
/* 1489 */     GL11.glDepthMask(false);
/* 1490 */     GL14.glBlendFuncSeparate(770, 771, 1, 0);
/* 1491 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1492 */     mc.getTextureManager().bindTexture(image);
/* 1493 */     drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/* 1494 */     GL11.glDepthMask(true);
/* 1495 */     GL11.glDisable(3042);
/* 1496 */     GL11.glEnable(2929);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void drawModalRectWithCustomSizedTexture(float x, float y, float u, float v, float width, float height, float textureWidth, float textureHeight) {
/* 1503 */     float f = 1.0F / textureWidth;
/* 1504 */     float f1 = 1.0F / textureHeight;
/* 1505 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1506 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 1507 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 1508 */     worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + height) * f1)).endVertex();
/* 1509 */     worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + width) * f), ((v + height) * f1)).endVertex();
/* 1510 */     worldrenderer.pos((x + width), y, 0.0D).tex(((u + width) * f), (v * f1)).endVertex();
/* 1511 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/* 1512 */     tessellator.draw();
/*      */   }
/*      */   
/*      */   public static void drawTexturedModalRect(int p_drawTexturedModalRect_1_, int p_drawTexturedModalRect_2_, int p_drawTexturedModalRect_3_, int p_drawTexturedModalRect_4_, int p_drawTexturedModalRect_5_, int p_drawTexturedModalRect_6_) {
/* 1516 */     float lvt_7_1_ = 0.00390625F;
/* 1517 */     float lvt_8_1_ = 0.00390625F;
/* 1518 */     ITessellator lvt_9_1_ = classProvider.getTessellatorInstance();
/* 1519 */     IWorldRenderer lvt_10_1_ = lvt_9_1_.getWorldRenderer();
/* 1520 */     double zLevel = 0.0D;
/* 1521 */     lvt_10_1_.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 1522 */     lvt_10_1_.pos((p_drawTexturedModalRect_1_ + 0), (p_drawTexturedModalRect_2_ + p_drawTexturedModalRect_6_), zLevel).tex(((p_drawTexturedModalRect_3_ + 0) * 0.00390625F), ((p_drawTexturedModalRect_4_ + p_drawTexturedModalRect_6_) * 0.00390625F)).endVertex();
/* 1523 */     lvt_10_1_.pos((p_drawTexturedModalRect_1_ + p_drawTexturedModalRect_5_), (p_drawTexturedModalRect_2_ + p_drawTexturedModalRect_6_), zLevel).tex(((p_drawTexturedModalRect_3_ + p_drawTexturedModalRect_5_) * 0.00390625F), ((p_drawTexturedModalRect_4_ + p_drawTexturedModalRect_6_) * 0.00390625F)).endVertex();
/* 1524 */     lvt_10_1_.pos((p_drawTexturedModalRect_1_ + p_drawTexturedModalRect_5_), (p_drawTexturedModalRect_2_ + 0), zLevel).tex(((p_drawTexturedModalRect_3_ + p_drawTexturedModalRect_5_) * 0.00390625F), ((p_drawTexturedModalRect_4_ + 0) * 0.00390625F)).endVertex();
/* 1525 */     lvt_10_1_.pos((p_drawTexturedModalRect_1_ + 0), (p_drawTexturedModalRect_2_ + 0), zLevel).tex(((p_drawTexturedModalRect_3_ + 0) * 0.00390625F), ((p_drawTexturedModalRect_4_ + 0) * 0.00390625F)).endVertex();
/* 1526 */     lvt_9_1_.draw();
/*      */   }
/*      */   
/*      */   public static void glColor(int red, int green, int blue, int alpha) {
/* 1530 */     GL11.glColor4f(red / 255.0F, green / 255.0F, blue / 255.0F, alpha / 255.0F);
/*      */   }
/*      */   
/*      */   public static void glColor(Color color) {
/* 1534 */     glColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*      */   }
/*      */   
/*      */   private static void glColor(int hex) {
/* 1538 */     glColor(hex >> 16 & 0xFF, hex >> 8 & 0xFF, hex & 0xFF, hex >> 24 & 0xFF);
/*      */   }
/*      */   
/*      */   public static void draw2D(IEntityLivingBase entity, double posX, double posY, double posZ, int color, int backgroundColor) {
/* 1542 */     GL11.glPushMatrix();
/* 1543 */     GL11.glTranslated(posX, posY, posZ);
/* 1544 */     GL11.glRotated(-mc.getRenderManager().getPlayerViewY(), 0.0D, 1.0D, 0.0D);
/* 1545 */     GL11.glScaled(-0.1D, -0.1D, 0.1D);
/*      */     
/* 1547 */     GL11.glDisable(2929);
/* 1548 */     GL11.glEnable(3042);
/* 1549 */     GL11.glDisable(3553);
/* 1550 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 1552 */     GL11.glDepthMask(true);
/*      */     
/* 1554 */     glColor(color);
/*      */     
/* 1556 */     GL11.glCallList(DISPLAY_LISTS_2D[0]);
/*      */     
/* 1558 */     glColor(backgroundColor);
/*      */     
/* 1560 */     GL11.glCallList(DISPLAY_LISTS_2D[1]);
/*      */     
/* 1562 */     GL11.glTranslated(0.0D, 21.0D + -(entity.getEntityBoundingBox().getMaxY() - entity.getEntityBoundingBox().getMinY()) * 12.0D, 0.0D);
/*      */     
/* 1564 */     glColor(color);
/* 1565 */     GL11.glCallList(DISPLAY_LISTS_2D[2]);
/*      */     
/* 1567 */     glColor(backgroundColor);
/* 1568 */     GL11.glCallList(DISPLAY_LISTS_2D[3]);
/*      */ 
/*      */     
/* 1571 */     GL11.glEnable(2929);
/* 1572 */     GL11.glEnable(3553);
/* 1573 */     GL11.glDisable(3042);
/*      */     
/* 1575 */     GL11.glPopMatrix();
/*      */   }
/*      */   public static float drawJelloShadow() {
/* 1578 */     return 0.45F;
/*      */   }
/*      */   public static float drawImage4() {
/* 1581 */     return 0.65F;
/*      */   }
/*      */   public static void draw2D(WBlockPos blockPos, int color, int backgroundColor) {
/* 1584 */     IRenderManager renderManager = mc.getRenderManager();
/*      */     
/* 1586 */     double posX = blockPos.getX() + 0.5D - renderManager.getRenderPosX();
/* 1587 */     double posY = blockPos.getY() - renderManager.getRenderPosY();
/* 1588 */     double posZ = blockPos.getZ() + 0.5D - renderManager.getRenderPosZ();
/*      */     
/* 1590 */     GL11.glPushMatrix();
/* 1591 */     GL11.glTranslated(posX, posY, posZ);
/* 1592 */     GL11.glRotated(-mc.getRenderManager().getPlayerViewY(), 0.0D, 1.0D, 0.0D);
/* 1593 */     GL11.glScaled(-0.1D, -0.1D, 0.1D);
/*      */     
/* 1595 */     GL11.glDisable(2929);
/* 1596 */     GL11.glEnable(3042);
/* 1597 */     GL11.glDisable(3553);
/* 1598 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 1600 */     GL11.glDepthMask(true);
/*      */     
/* 1602 */     glColor(color);
/*      */     
/* 1604 */     GL11.glCallList(DISPLAY_LISTS_2D[0]);
/*      */     
/* 1606 */     glColor(backgroundColor);
/*      */     
/* 1608 */     GL11.glCallList(DISPLAY_LISTS_2D[1]);
/*      */     
/* 1610 */     GL11.glTranslated(0.0D, 9.0D, 0.0D);
/*      */     
/* 1612 */     glColor(color);
/*      */     
/* 1614 */     GL11.glCallList(DISPLAY_LISTS_2D[2]);
/*      */     
/* 1616 */     glColor(backgroundColor);
/*      */     
/* 1618 */     GL11.glCallList(DISPLAY_LISTS_2D[3]);
/*      */ 
/*      */     
/* 1621 */     GL11.glEnable(2929);
/* 1622 */     GL11.glEnable(3553);
/* 1623 */     GL11.glDisable(3042);
/*      */     
/* 1625 */     GL11.glPopMatrix();
/*      */   }
/*      */   public static void enableSmoothLine(float width) {
/* 1628 */     GL11.glDisable(3008);
/* 1629 */     GL11.glEnable(3042);
/* 1630 */     GL11.glBlendFunc(770, 771);
/* 1631 */     GL11.glDisable(3553);
/* 1632 */     GL11.glDisable(2929);
/* 1633 */     GL11.glDepthMask(false);
/* 1634 */     GL11.glEnable(2884);
/* 1635 */     GL11.glEnable(2848);
/* 1636 */     GL11.glHint(3154, 4354);
/* 1637 */     GL11.glHint(3155, 4354);
/* 1638 */     GL11.glLineWidth(width);
/*      */   }
/*      */   public static void disableSmoothLine() {
/* 1641 */     GL11.glEnable(3553);
/* 1642 */     GL11.glEnable(2929);
/* 1643 */     GL11.glDisable(3042);
/* 1644 */     GL11.glEnable(3008);
/* 1645 */     GL11.glDepthMask(true);
/* 1646 */     GL11.glCullFace(1029);
/* 1647 */     GL11.glDisable(2848);
/* 1648 */     GL11.glHint(3154, 4352);
/* 1649 */     GL11.glHint(3155, 4352);
/*      */   }
/*      */   public static void renderNameTag(String string, double x, double y, double z) {
/* 1652 */     IRenderManager renderManager = mc.getRenderManager();
/*      */     
/* 1654 */     GL11.glPushMatrix();
/* 1655 */     GL11.glTranslated(x - renderManager.getRenderPosX(), y - renderManager.getRenderPosY(), z - renderManager.getRenderPosZ());
/* 1656 */     GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 1657 */     GL11.glRotatef(-mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 1658 */     GL11.glRotatef(mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 1659 */     GL11.glScalef(-0.05F, -0.05F, 0.05F);
/* 1660 */     setGlCap(2896, false);
/* 1661 */     setGlCap(2929, false);
/* 1662 */     setGlCap(3042, true);
/* 1663 */     GL11.glBlendFunc(770, 771);
/*      */     
/* 1665 */     int width = Fonts.Posterama35.getStringWidth(string) / 2;
/*      */     
/* 1667 */     drawRect(-width - 1, -1, width + 1, Fonts.Posterama35.getFontHeight(), -2147483648);
/* 1668 */     Fonts.Posterama35.drawString(string, -width, 1.5F, Color.WHITE.getRGB(), true);
/*      */     
/* 1670 */     resetCaps();
/* 1671 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1672 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void drawLine(double x, double y, double x1, double y1, float width) {
/* 1677 */     GL11.glDisable(3553);
/* 1678 */     GL11.glLineWidth(width);
/* 1679 */     GL11.glBegin(1);
/* 1680 */     GL11.glVertex2d(x, y);
/* 1681 */     GL11.glVertex2d(x1, y1);
/* 1682 */     GL11.glEnd();
/* 1683 */     GL11.glEnable(3553);
/*      */   }
/*      */   
/*      */   public static void drawLine(float x, float y, float x1, float y1, float width) {
/* 1687 */     GL11.glDisable(3553);
/* 1688 */     GL11.glLineWidth(width);
/* 1689 */     GL11.glBegin(1);
/* 1690 */     GL11.glVertex2f(x, y);
/* 1691 */     GL11.glVertex2f(x1, y1);
/* 1692 */     GL11.glEnd();
/* 1693 */     GL11.glEnable(3553);
/*      */   }
/*      */   
/*      */   public static void makeScissorBox(float x, float y, float x2, float y2) {
/* 1697 */     IScaledResolution scaledResolution = classProvider.createScaledResolution(mc);
/* 1698 */     int factor = scaledResolution.getScaleFactor();
/* 1699 */     GL11.glScissor((int)(x * factor), (int)((scaledResolution.getScaledHeight() - y2) * factor), (int)((x2 - x) * factor), (int)((y2 - y) * factor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void resetCaps() {
/* 1709 */     glCapMap.forEach(RenderUtils::setGlState);
/*      */   }
/*      */   
/*      */   public static void enableGlCap(int cap) {
/* 1713 */     setGlCap(cap, true);
/*      */   }
/*      */   
/*      */   public static void enableGlCap(int... caps) {
/* 1717 */     for (int cap : caps)
/* 1718 */       setGlCap(cap, true); 
/*      */   }
/*      */   
/*      */   public static void disableGlCap(int cap) {
/* 1722 */     setGlCap(cap, true);
/*      */   }
/*      */   
/*      */   public static void disableGlCap(int... caps) {
/* 1726 */     for (int cap : caps)
/* 1727 */       setGlCap(cap, false); 
/*      */   }
/*      */   
/*      */   public static void setGlCap(int cap, boolean state) {
/* 1731 */     glCapMap.put(Integer.valueOf(cap), Boolean.valueOf(GL11.glGetBoolean(cap)));
/* 1732 */     setGlState(cap, state);
/*      */   }
/*      */   
/*      */   public static void setGlState(int cap, boolean state) {
/* 1736 */     if (state) {
/* 1737 */       GL11.glEnable(cap);
/*      */     } else {
/* 1739 */       GL11.glDisable(cap);
/*      */     } 
/*      */   }
/*      */   public static void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height, float tileWidth, float tileHeight) {
/* 1743 */     float f = 1.0F / tileWidth;
/* 1744 */     float f1 = 1.0F / tileHeight;
/* 1745 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1746 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 1747 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/* 1748 */     worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + vHeight) * f1)).endVertex();
/* 1749 */     worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + uWidth) * f), ((v + vHeight) * f1)).endVertex();
/* 1750 */     worldrenderer.pos((x + width), y, 0.0D).tex(((u + uWidth) * f), (v * f1)).endVertex();
/* 1751 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/* 1752 */     tessellator.draw();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void enableGL3D(float lineWidth) {
/* 1758 */     GL11.glDisable(3008);
/* 1759 */     GL11.glEnable(3042);
/* 1760 */     GL11.glBlendFunc(770, 771);
/* 1761 */     GL11.glDisable(3553);
/* 1762 */     GL11.glDisable(2929);
/* 1763 */     GL11.glDepthMask(false);
/* 1764 */     GL11.glEnable(2884);
/* 1765 */     GL11.glEnable(2848);
/* 1766 */     GL11.glHint(3154, 4354);
/* 1767 */     GL11.glHint(3155, 4354);
/* 1768 */     GL11.glLineWidth(lineWidth);
/*      */   }
/*      */   
/*      */   public static void disableGL3D() {
/* 1772 */     GL11.glEnable(3553);
/* 1773 */     GL11.glEnable(2929);
/* 1774 */     GL11.glDisable(3042);
/* 1775 */     GL11.glEnable(3008);
/* 1776 */     GL11.glDepthMask(true);
/* 1777 */     GL11.glCullFace(1029);
/* 1778 */     GL11.glDisable(2848);
/* 1779 */     GL11.glHint(3154, 4352);
/* 1780 */     GL11.glHint(3155, 4352);
/*      */   }
/*      */   
/*      */   public static void draw2DBox(IEntity e, Color color, Render3DEvent event) {
/* 1784 */     ITimer timer = mc.getTimer();
/* 1785 */     IRenderManager renderManager = mc.getRenderManager();
/*      */     
/* 1787 */     double posX = e.getLastTickPosX() + (e.getPosX() - e.getLastTickPosX()) * event.getPartialTicks() - renderManager.getRenderPosX();
/* 1788 */     double posY = e.getLastTickPosY() + (e.getPosY() - e.getLastTickPosY()) * event.getPartialTicks() - renderManager.getRenderPosY();
/* 1789 */     double posZ = e.getLastTickPosZ() + (e.getPosZ() - e.getLastTickPosZ()) * event.getPartialTicks() - renderManager.getRenderPosZ();
/* 1790 */     IAxisAlignedBB box = classProvider.createAxisAlignedBB(posX - e.getWidth() / 2.0D, posY, posZ - e.getWidth() / 2.0D, posX + e.getWidth() / 2.0D, posY + e.getHeight() + 0.20000000298023224D, posZ + e.getWidth() / 2.0D);
/* 1791 */     GL11.glPushMatrix();
/* 1792 */     GL11.glColor4d(0.75D, 0.0D, 0.0D, 0.0D);
/* 1793 */     double size = classProvider.isEntityItem(e) ? 0.15D : 0.375D;
/*      */     
/* 1795 */     double boundindY = e.getEntityBoundingBox().getMaxY() - e.getEntityBoundingBox().getMinY() + 0.1D;
/* 1796 */     ESPUtils.drawBoundingBox(classProvider.createAxisAlignedBB(posX - size, posY, posZ - size, posX + size, posY + boundindY, posZ + size));
/* 1797 */     ESPUtils.renderOne();
/* 1798 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, 0.5F);
/* 1799 */     ESPUtils.drawBoundingBox(classProvider.createAxisAlignedBB(posX - size, posY, posZ - size, posX + size, posY + boundindY, posZ + size));
/* 1800 */     GL11.glStencilFunc(512, 0, 15);
/* 1801 */     GL11.glStencilOp(7681, 7681, 7681);
/* 1802 */     GL11.glPolygonMode(1032, 6914);
/* 1803 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, 0.5F);
/* 1804 */     ESPUtils.drawBoundingBox(classProvider.createAxisAlignedBB(posX - size, posY, posZ - size, posX + size, posY + boundindY, posZ + size));
/* 1805 */     GL11.glStencilFunc(514, 1, 15);
/* 1806 */     GL11.glStencilOp(7680, 7680, 7680);
/* 1807 */     GL11.glPolygonMode(1032, 6913);
/* 1808 */     ESPUtils.setColor(e);
/* 1809 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, 0.5F);
/* 1810 */     ESPUtils.drawBoundingBox(classProvider.createAxisAlignedBB(posX - size, posY, posZ - size, posX + size, posY + boundindY, posZ + size));
/* 1811 */     GL11.glPolygonOffset(1.0F, 2000000.0F);
/* 1812 */     GL11.glDisable(10754);
/* 1813 */     GL11.glEnable(2929);
/* 1814 */     GL11.glDepthMask(true);
/* 1815 */     GL11.glDisable(2960);
/* 1816 */     GL11.glDisable(2848);
/* 1817 */     GL11.glHint(3154, 4352);
/* 1818 */     GL11.glEnable(3042);
/* 1819 */     GL11.glEnable(2896);
/* 1820 */     GL11.glEnable(3553);
/* 1821 */     GL11.glEnable(3008);
/* 1822 */     GL11.glPopAttrib();
/* 1823 */     GL11.glColor4d(0.6D, 0.0D, 0.0D, 1.0D);
/* 1824 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawWolframEntityESP(IEntity entity, int rgb, double posX, double posY, double posZ) {
/* 1828 */     GL11.glPushMatrix();
/* 1829 */     GL11.glTranslated(posX, posY, posZ);
/* 1830 */     GL11.glRotatef(-entity.getRotationYaw(), 0.0F, 1.0F, 0.0F);
/* 1831 */     glColor(rgb);
/* 1832 */     enableGL3D(1.0F);
/* 1833 */     Cylinder c = new Cylinder();
/* 1834 */     GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 1835 */     c.setDrawStyle(100011);
/* 1836 */     c.draw(0.5F, 0.5F, entity.getHeight() + 0.1F, 18, 1);
/* 1837 */     disableGL3D();
/* 1838 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void drawRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius, int color) {
/* 1842 */     drawRoundedRect(paramXStart, paramYStart, paramXEnd, paramYEnd, radius, color, true);
/*      */   }
/*      */   public static void drawRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius, int color, boolean popPush) {
/* 1845 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 1846 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 1847 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 1848 */     float blue = (color & 0xFF) / 255.0F;
/*      */     
/* 1850 */     float z = 0.0F;
/* 1851 */     if (paramXStart > paramXEnd) {
/* 1852 */       z = paramXStart;
/* 1853 */       paramXStart = paramXEnd;
/* 1854 */       paramXEnd = z;
/*      */     } 
/*      */     
/* 1857 */     if (paramYStart > paramYEnd) {
/* 1858 */       z = paramYStart;
/* 1859 */       paramYStart = paramYEnd;
/* 1860 */       paramYEnd = z;
/*      */     } 
/*      */     
/* 1863 */     double x1 = (paramXStart + radius);
/* 1864 */     double y1 = (paramYStart + radius);
/* 1865 */     double x2 = (paramXEnd - radius);
/* 1866 */     double y2 = (paramYEnd - radius);
/*      */     
/* 1868 */     if (popPush) GL11.glPushMatrix(); 
/* 1869 */     GL11.glEnable(3042);
/* 1870 */     GL11.glDisable(3553);
/* 1871 */     GL11.glBlendFunc(770, 771);
/* 1872 */     GL11.glEnable(2848);
/* 1873 */     GL11.glLineWidth(1.0F);
/*      */     
/* 1875 */     GL11.glColor4f(red, green, blue, alpha);
/* 1876 */     GL11.glBegin(9);
/*      */     
/* 1878 */     double degree = 0.017453292519943295D; double i;
/* 1879 */     for (i = 0.0D; i <= 90.0D; i++)
/* 1880 */       GL11.glVertex2d(x2 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius); 
/* 1881 */     for (i = 90.0D; i <= 180.0D; i++)
/* 1882 */       GL11.glVertex2d(x2 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius); 
/* 1883 */     for (i = 180.0D; i <= 270.0D; i++)
/* 1884 */       GL11.glVertex2d(x1 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius); 
/* 1885 */     for (i = 270.0D; i <= 360.0D; i++)
/* 1886 */       GL11.glVertex2d(x1 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius); 
/* 1887 */     GL11.glEnd();
/*      */     
/* 1889 */     GL11.glEnable(3553);
/* 1890 */     GL11.glDisable(3042);
/* 1891 */     GL11.glDisable(2848);
/* 1892 */     if (popPush) GL11.glPopMatrix();
/*      */   
/*      */   }
/*      */   
/*      */   public static void customRounded(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float rTL, float rTR, float rBR, float rBL, int color) {
/* 1897 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 1898 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 1899 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 1900 */     float blue = (color & 0xFF) / 255.0F;
/*      */     
/* 1902 */     float z = 0.0F;
/* 1903 */     if (paramXStart > paramXEnd) {
/* 1904 */       z = paramXStart;
/* 1905 */       paramXStart = paramXEnd;
/* 1906 */       paramXEnd = z;
/*      */     } 
/*      */     
/* 1909 */     if (paramYStart > paramYEnd) {
/* 1910 */       z = paramYStart;
/* 1911 */       paramYStart = paramYEnd;
/* 1912 */       paramYEnd = z;
/*      */     } 
/*      */     
/* 1915 */     double xTL = (paramXStart + rTL);
/* 1916 */     double yTL = (paramYStart + rTL);
/*      */     
/* 1918 */     double xTR = (paramXEnd - rTR);
/* 1919 */     double yTR = (paramYStart + rTR);
/*      */     
/* 1921 */     double xBR = (paramXEnd - rBR);
/* 1922 */     double yBR = (paramYEnd - rBR);
/*      */     
/* 1924 */     double xBL = (paramXStart + rBL);
/* 1925 */     double yBL = (paramYEnd - rBL);
/*      */     
/* 1927 */     GL11.glPushMatrix();
/* 1928 */     GL11.glEnable(3042);
/* 1929 */     GL11.glDisable(3553);
/* 1930 */     GL11.glBlendFunc(770, 771);
/* 1931 */     GL11.glEnable(2848);
/* 1932 */     GL11.glLineWidth(1.0F);
/*      */     
/* 1934 */     GL11.glColor4f(red, green, blue, alpha);
/* 1935 */     GL11.glBegin(9);
/*      */     
/* 1937 */     double degree = 0.017453292519943295D;
/* 1938 */     if (rBR <= 0.0F)
/* 1939 */     { GL11.glVertex2d(xBR, yBR); }
/* 1940 */     else { double i; for (i = 0.0D; i <= 90.0D; i++)
/* 1941 */         GL11.glVertex2d(xBR + Math.sin(i * degree) * rBR, yBR + Math.cos(i * degree) * rBR);  }
/*      */     
/* 1943 */     if (rTR <= 0.0F)
/* 1944 */     { GL11.glVertex2d(xTR, yTR); }
/* 1945 */     else { double i; for (i = 90.0D; i <= 180.0D; i++)
/* 1946 */         GL11.glVertex2d(xTR + Math.sin(i * degree) * rTR, yTR + Math.cos(i * degree) * rTR);  }
/*      */     
/* 1948 */     if (rTL <= 0.0F)
/* 1949 */     { GL11.glVertex2d(xTL, yTL); }
/* 1950 */     else { double i; for (i = 180.0D; i <= 270.0D; i++)
/* 1951 */         GL11.glVertex2d(xTL + Math.sin(i * degree) * rTL, yTL + Math.cos(i * degree) * rTL);  }
/*      */     
/* 1953 */     if (rBL <= 0.0F)
/* 1954 */     { GL11.glVertex2d(xBL, yBL); }
/* 1955 */     else { double i; for (i = 270.0D; i <= 360.0D; i++)
/* 1956 */         GL11.glVertex2d(xBL + Math.sin(i * degree) * rBL, yBL + Math.cos(i * degree) * rBL);  }
/* 1957 */      GL11.glEnd();
/*      */     
/* 1959 */     GL11.glEnable(3553);
/* 1960 */     GL11.glDisable(3042);
/* 1961 */     GL11.glDisable(2848);
/* 1962 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static void resetColor() {
/* 1966 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void originalRoundedRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, float radius, int color) {
/* 1971 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 1972 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 1973 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 1974 */     float blue = (color & 0xFF) / 255.0F;
/*      */     
/* 1976 */     float z = 0.0F;
/* 1977 */     if (paramXStart > paramXEnd) {
/* 1978 */       z = paramXStart;
/* 1979 */       paramXStart = paramXEnd;
/* 1980 */       paramXEnd = z;
/*      */     } 
/*      */     
/* 1983 */     if (paramYStart > paramYEnd) {
/* 1984 */       z = paramYStart;
/* 1985 */       paramYStart = paramYEnd;
/* 1986 */       paramYEnd = z;
/*      */     } 
/*      */     
/* 1989 */     double x1 = (paramXStart + radius);
/* 1990 */     double y1 = (paramYStart + radius);
/* 1991 */     double x2 = (paramXEnd - radius);
/* 1992 */     double y2 = (paramYEnd - radius);
/*      */     
/* 1994 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 1995 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*      */     
/* 1997 */     GlStateManager.func_179147_l();
/* 1998 */     GlStateManager.func_179090_x();
/* 1999 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 2000 */     GlStateManager.func_179131_c(red, green, blue, alpha);
/* 2001 */     worldrenderer.begin(9, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*      */     
/* 2003 */     double degree = 0.017453292519943295D; double i;
/* 2004 */     for (i = 0.0D; i <= 90.0D; i++)
/* 2005 */       worldrenderer.pos(x2 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius, 0.0D).endVertex(); 
/* 2006 */     for (i = 90.0D; i <= 180.0D; i++)
/* 2007 */       worldrenderer.pos(x2 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius, 0.0D).endVertex(); 
/* 2008 */     for (i = 180.0D; i <= 270.0D; i++)
/* 2009 */       worldrenderer.pos(x1 + Math.sin(i * degree) * radius, y1 + Math.cos(i * degree) * radius, 0.0D).endVertex(); 
/* 2010 */     for (i = 270.0D; i <= 360.0D; i++) {
/* 2011 */       worldrenderer.pos(x1 + Math.sin(i * degree) * radius, y2 + Math.cos(i * degree) * radius, 0.0D).endVertex();
/*      */     }
/* 2013 */     tessellator.draw();
/* 2014 */     GlStateManager.func_179098_w();
/* 2015 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   
/*      */   public static void drawImage2(IResourceLocation image, float x, float y, int width, int height) {
/* 2019 */     GL11.glDisable(2929);
/* 2020 */     GL11.glEnable(3042);
/* 2021 */     GL11.glDepthMask(false);
/* 2022 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 2023 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2024 */     GL11.glTranslatef(x, y, x);
/* 2025 */     mc.getTextureManager().bindTexture(image);
/* 2026 */     Gui.func_146110_a(0, 0, 0.0F, 0.0F, width, height, width, height);
/* 2027 */     GL11.glTranslatef(-x, -y, -x);
/* 2028 */     GL11.glDepthMask(true);
/* 2029 */     GL11.glDisable(3042);
/* 2030 */     GL11.glEnable(2929);
/*      */   }
/*      */   public static void drawImage3(ResourceLocation image, float x, float y, int width, int height) {
/* 2033 */     GL11.glDisable(2929);
/* 2034 */     GL11.glEnable(3042);
/* 2035 */     GL11.glDepthMask(false);
/* 2036 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 2037 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2038 */     GL11.glTranslatef(x, y, x);
/* 2039 */     mc.getTextureManager().bindTexture((IResourceLocation)image);
/* 2040 */     Gui.func_146110_a(0, 0, 0.0F, 0.0F, width, height, width, height);
/* 2041 */     GL11.glTranslatef(-x, -y, -x);
/* 2042 */     GL11.glDepthMask(true);
/* 2043 */     GL11.glDisable(3042);
/* 2044 */     GL11.glEnable(2929);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void newDrawRect(float left, float top, float right, float bottom, int color) {
/* 2049 */     if (left < right) {
/*      */       
/* 2051 */       float i = left;
/* 2052 */       left = right;
/* 2053 */       right = i;
/*      */     } 
/*      */     
/* 2056 */     if (top < bottom) {
/*      */       
/* 2058 */       float j = top;
/* 2059 */       top = bottom;
/* 2060 */       bottom = j;
/*      */     } 
/*      */     
/* 2063 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 2064 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 2065 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 2066 */     float f2 = (color & 0xFF) / 255.0F;
/* 2067 */     ITessellator tessellator = classProvider.getTessellatorInstance();
/* 2068 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 2069 */     GlStateManager.func_179147_l();
/* 2070 */     GlStateManager.func_179090_x();
/* 2071 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 2072 */     GlStateManager.func_179131_c(f, f1, f2, f3);
/* 2073 */     worldrenderer.begin(7, classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 2074 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 2075 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/* 2076 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/* 2077 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/* 2078 */     tessellator.draw();
/* 2079 */     GlStateManager.func_179098_w();
/* 2080 */     GlStateManager.func_179084_k();
/*      */   }
/*      */   
/*      */   public static void drawLimitedCircle(float lx, float ly, float x2, float y2, int xx, int yy, float radius, Color color) {
/* 2084 */     int sections = 50;
/* 2085 */     double dAngle = 6.283185307179586D / sections;
/*      */ 
/*      */     
/* 2088 */     GL11.glPushAttrib(8192);
/*      */     
/* 2090 */     GL11.glEnable(3042);
/* 2091 */     GL11.glDisable(3553);
/* 2092 */     GL11.glBlendFunc(770, 771);
/* 2093 */     GL11.glEnable(2848);
/* 2094 */     GL11.glBegin(6);
/*      */     
/* 2096 */     glColor(color);
/* 2097 */     for (int i = 0; i < sections; i++) {
/* 2098 */       float x = (float)(radius * Math.sin(i * dAngle));
/* 2099 */       float y = (float)(radius * Math.cos(i * dAngle));
/* 2100 */       GL11.glVertex2f(Math.min(x2, Math.max(xx + x, lx)), Math.min(y2, Math.max(yy + y, ly)));
/*      */     } 
/*      */     
/* 2103 */     GlStateManager.func_179124_c(0.0F, 0.0F, 0.0F);
/*      */     
/* 2105 */     GL11.glEnd();
/*      */     
/* 2107 */     GL11.glPopAttrib();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\render\RenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */