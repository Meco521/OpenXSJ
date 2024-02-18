/*     */ package net.ccbluex.liquidbounce.utils.render.shader;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FramebufferShader
/*     */   extends Shader
/*     */ {
/*     */   private static Framebuffer framebuffer;
/*     */   protected float red;
/*     */   protected float green;
/*     */   protected float blue;
/*  19 */   protected float alpha = 1.0F;
/*  20 */   protected float radius = 2.0F;
/*  21 */   protected float quality = 1.0F;
/*     */   
/*     */   private boolean entityShadows;
/*     */   
/*     */   public FramebufferShader(String fragmentShader) {
/*  26 */     super(fragmentShader);
/*     */   }
/*     */   
/*     */   public void startDraw(float partialTicks) {
/*  30 */     classProvider.getGlStateManager().enableAlpha();
/*     */     
/*  32 */     classProvider.getGlStateManager().pushMatrix();
/*  33 */     classProvider.getGlStateManager().pushAttrib();
/*     */     
/*  35 */     framebuffer = setupFrameBuffer(framebuffer);
/*  36 */     framebuffer.func_147614_f();
/*  37 */     framebuffer.func_147610_a(true);
/*  38 */     this.entityShadows = mc.getGameSettings().getEntityShadows();
/*  39 */     mc.getGameSettings().setEntityShadows(false);
/*  40 */     mc.getEntityRenderer().setupCameraTransform(partialTicks, 0);
/*     */   }
/*     */   
/*     */   public void stopDraw(Color color, float radius, float quality) {
/*  44 */     mc.getGameSettings().setEntityShadows(this.entityShadows);
/*  45 */     GL11.glEnable(3042);
/*  46 */     GL11.glBlendFunc(770, 771);
/*  47 */     mc.getFramebuffer().bindFramebuffer(true);
/*     */     
/*  49 */     this.red = color.getRed() / 255.0F;
/*  50 */     this.green = color.getGreen() / 255.0F;
/*  51 */     this.blue = color.getBlue() / 255.0F;
/*  52 */     this.alpha = color.getAlpha() / 255.0F;
/*  53 */     this.radius = radius;
/*  54 */     this.quality = quality;
/*     */     
/*  56 */     mc.getEntityRenderer().disableLightmap();
/*  57 */     RenderHelper.func_74518_a();
/*     */     
/*  59 */     startShader();
/*  60 */     mc.getEntityRenderer().setupOverlayRendering();
/*  61 */     drawFramebuffer(framebuffer);
/*  62 */     stopShader();
/*     */     
/*  64 */     mc.getEntityRenderer().disableLightmap();
/*     */     
/*  66 */     classProvider.getGlStateManager().popMatrix();
/*  67 */     classProvider.getGlStateManager().popAttrib();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Framebuffer setupFrameBuffer(Framebuffer frameBuffer) {
/*  76 */     if (frameBuffer != null) {
/*  77 */       frameBuffer.func_147608_a();
/*     */     }
/*  79 */     frameBuffer = new Framebuffer(mc.getDisplayWidth(), mc.getDisplayHeight(), true);
/*     */     
/*  81 */     return frameBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawFramebuffer(Framebuffer framebuffer) {
/*  88 */     IScaledResolution scaledResolution = classProvider.createScaledResolution(mc);
/*     */     
/*  90 */     GL11.glBindTexture(3553, framebuffer.field_147617_g);
/*  91 */     GL11.glBegin(7);
/*  92 */     GL11.glTexCoord2d(0.0D, 1.0D);
/*  93 */     GL11.glVertex2d(0.0D, 0.0D);
/*  94 */     GL11.glTexCoord2d(0.0D, 0.0D);
/*  95 */     GL11.glVertex2d(0.0D, scaledResolution.getScaledHeight());
/*  96 */     GL11.glTexCoord2d(1.0D, 0.0D);
/*  97 */     GL11.glVertex2d(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
/*  98 */     GL11.glTexCoord2d(1.0D, 1.0D);
/*  99 */     GL11.glVertex2d(scaledResolution.getScaledWidth(), 0.0D);
/* 100 */     GL11.glEnd();
/* 101 */     GL20.glUseProgram(0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\shader\FramebufferShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */