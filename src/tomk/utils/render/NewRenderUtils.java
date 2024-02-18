/*     */ package tomk.utils.render;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\025\n\002\b\002\n\002\020\b\n\002\b\006\n\002\020%\n\002\020\013\n\002\b\002\n\002\020\002\n\000\n\002\020\007\n\002\b\013\n\002\020\016\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002JH\020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\0242\006\020\027\032\0020\0242\006\020\030\032\0020\0242\006\020\031\032\0020\0242\006\020\032\032\0020\0242\006\020\033\032\0020\024H\007J0\020\034\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\030\032\0020\0242\006\020\031\032\0020\0242\006\020\035\032\0020\024H\007J0\020\036\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\030\032\0020\0242\006\020\031\032\0020\0242\006\020\037\032\0020 H\007J8\020!\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\030\032\0020\0242\006\020\031\032\0020\0242\006\020\037\032\0020 2\006\020\035\032\0020\024H\007R\026\020\003\032\0020\0048\002X\004¢\006\b\n\000\022\004\b\005\020\002R$\020\006\032\0020\0078\006@\006X\016¢\006\024\n\000\022\004\b\b\020\002\032\004\b\t\020\n\"\004\b\013\020\fR\"\020\r\032\016\022\004\022\0020\007\022\004\022\0020\0170\0168\002X\004¢\006\b\n\000\022\004\b\020\020\002¨\006\""}, d2 = {"Ltomk/utils/render/NewRenderUtils;", "", "()V", "DISPLAY_LISTS_2D", "", "DISPLAY_LISTS_2D$annotations", "deltaTime", "", "deltaTime$annotations", "getDeltaTime", "()I", "setDeltaTime", "(I)V", "glCapMap", "", "", "glCapMap$annotations", "drawModalRectWithCustomSizedTexture", "", "x", "", "y", "u", "v", "width", "height", "textureWidth", "textureHeight", "drawShadowWithCustomAlpha", "alpha", "drawTexturedRect", "image", "", "drawTexturedRectWithCustomAlpha", "XSJClient"})
/*     */ public final class NewRenderUtils {
/*     */   static {
/*  14 */     NewRenderUtils newRenderUtils = new NewRenderUtils();
/*     */   }
/*  16 */   private static final Map<Integer, Boolean> glCapMap = new HashMap<>();
/*     */   private static int deltaTime;
/*  18 */   public static final int getDeltaTime() { return deltaTime; } public static final void setDeltaTime(int <set-?>) { deltaTime = <set-?>; }
/*     */   
/*  20 */   private static final int[] DISPLAY_LISTS_2D = new int[4]; public static final NewRenderUtils INSTANCE;
/*     */   @JvmStatic
/*     */   public static final void drawShadowWithCustomAlpha(float x, float y, float width, float height, float alpha) {
/*  23 */     drawTexturedRectWithCustomAlpha(x - 9, y - 9, 9.0F, 9.0F, "paneltopleft", alpha);
/*  24 */     drawTexturedRectWithCustomAlpha(x - 9, y + height, 9.0F, 9.0F, "panelbottomleft", alpha);
/*  25 */     drawTexturedRectWithCustomAlpha(x + width, y + height, 9.0F, 9.0F, "panelbottomright", alpha);
/*  26 */     drawTexturedRectWithCustomAlpha(x + width, y - 9, 9.0F, 9.0F, "paneltopright", alpha);
/*  27 */     drawTexturedRectWithCustomAlpha(x - 9, y, 9.0F, height, "panelleft", alpha);
/*  28 */     drawTexturedRectWithCustomAlpha(x + width, y, 9.0F, height, "panelright", alpha);
/*  29 */     drawTexturedRectWithCustomAlpha(x, y - 9, width, 9.0F, "paneltop", alpha);
/*  30 */     drawTexturedRectWithCustomAlpha(x, y + height, width, 9.0F, "panelbottom", alpha);
/*     */   }
/*     */   @JvmStatic
/*     */   public static final void drawTexturedRectWithCustomAlpha(float x, float y, float width, float height, @NotNull String image, float alpha) {
/*  34 */     Intrinsics.checkParameterIsNotNull(image, "image"); GL11.glPushMatrix();
/*  35 */     boolean enableBlend = GL11.glIsEnabled(3042);
/*  36 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/*  37 */     if (!enableBlend) GL11.glEnable(3042); 
/*  38 */     if (!disableAlpha) GL11.glDisable(3008); 
/*  39 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, alpha);
/*  40 */     Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("tomk/shadow/" + image + ".png"));
/*  41 */     drawModalRectWithCustomSizedTexture(
/*  42 */         x, 
/*  43 */         y, 
/*  44 */         0.0F, 
/*  45 */         0.0F, 
/*  46 */         width, 
/*  47 */         height, 
/*  48 */         width, 
/*  49 */         height);
/*     */     
/*  51 */     if (!enableBlend) GL11.glDisable(3042); 
/*  52 */     if (!disableAlpha) GL11.glEnable(3008); 
/*  53 */     GlStateManager.func_179117_G();
/*  54 */     GL11.glPopMatrix();
/*     */   }
/*     */   @JvmStatic
/*     */   public static final void drawTexturedRect(float x, float y, float width, float height, @NotNull String image) {
/*  58 */     Intrinsics.checkParameterIsNotNull(image, "image"); GL11.glPushMatrix();
/*  59 */     boolean enableBlend = GL11.glIsEnabled(3042);
/*  60 */     boolean disableAlpha = !GL11.glIsEnabled(3008);
/*  61 */     if (!enableBlend) GL11.glEnable(3042); 
/*  62 */     if (!disableAlpha) GL11.glDisable(3008); 
/*  63 */     Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("destiny/shadow/" + image + ".png"));
/*  64 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  65 */     drawModalRectWithCustomSizedTexture(
/*  66 */         x, 
/*  67 */         y, 
/*  68 */         0.0F, 
/*  69 */         0.0F, 
/*  70 */         width, 
/*  71 */         height, 
/*  72 */         width, 
/*  73 */         height);
/*     */     
/*  75 */     if (!enableBlend) GL11.glDisable(3042); 
/*  76 */     if (!disableAlpha) GL11.glEnable(3008); 
/*  77 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final void drawModalRectWithCustomSizedTexture(float x, float y, float u, float v, float width, float height, float textureWidth, float textureHeight) {
/*  90 */     float f = 1.0F / textureWidth;
/*  91 */     float f1 = 1.0F / textureHeight;
/*  92 */     ITessellator tessellator = MinecraftInstance.classProvider.getTessellatorInstance();
/*  93 */     IWorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  94 */     worldrenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION_TEX));
/*  95 */     worldrenderer.pos(x, (y + height), 0.0D)
/*  96 */       .tex((u * f), ((v + height) * f1)).endVertex();
/*  97 */     worldrenderer.pos((x + width), (y + height), 0.0D)
/*  98 */       .tex(((u + width) * f), ((v + height) * f1)).endVertex();
/*  99 */     worldrenderer.pos((x + width), y, 0.0D)
/* 100 */       .tex(((u + width) * f), (v * f1)).endVertex();
/* 101 */     worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
/* 102 */     tessellator.draw();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\render\NewRenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */