/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.splash;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.ccbluex.liquidbounce.utils.render.AnimatedValue;
/*     */ import net.ccbluex.liquidbounce.utils.render.EaseUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraftforge.fml.client.SplashProgress;
/*     */ import net.minecraftforge.fml.common.ProgressManager;
/*     */ import org.lwjgl.opengl.Display;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin(targets = {"net.minecraftforge.fml.client.SplashProgress$2"}, remap = false)
/*     */ public abstract class MixinSplashProgressRunnable
/*     */ {
/*     */   @Shadow(remap = false)
/*     */   protected abstract void setGL();
/*     */   
/*     */   @Shadow(remap = false)
/*     */   protected abstract void clearGL();
/*     */   
/*     */   @Inject(method = {"run()V"}, at = {@At("HEAD")}, remap = false, cancellable = true)
/*     */   private void run(CallbackInfo callbackInfo) {
/*     */     int tex;
/*  38 */     callbackInfo.cancel();
/*     */     
/*  40 */     setGL();
/*  41 */     GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */     
/*  44 */     GL11.glEnable(3553);
/*     */     
/*     */     try {
/*  47 */       tex = RenderUtils.loadGlTexture(ImageIO.read(getClass().getResourceAsStream("/assets/minecraft/tomk/splash.png")));
/*  48 */     } catch (IOException e) {
/*  49 */       tex = 0;
/*     */     } 
/*  51 */     GL11.glDisable(3553);
/*     */     
/*  53 */     AnimatedValue animatedValue = new AnimatedValue();
/*  54 */     animatedValue.setType(EaseUtils.EnumEasingType.CIRC);
/*  55 */     animatedValue.setDuration(600L);
/*     */ 
/*     */     
/*  58 */     while (!SplashProgress.done) {
/*  59 */       GL11.glClear(16384);
/*  60 */       int width = Display.getWidth();
/*  61 */       int height = Display.getHeight();
/*  62 */       GL11.glViewport(0, 0, width, height);
/*  63 */       GL11.glMatrixMode(5889);
/*  64 */       GL11.glLoadIdentity();
/*  65 */       GL11.glOrtho(0.0D, width, height, 0.0D, -1.0D, 1.0D);
/*  66 */       GL11.glMatrixMode(5888);
/*  67 */       GL11.glLoadIdentity();
/*  68 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */ 
/*     */       
/*  71 */       GL11.glEnable(3553);
/*  72 */       GL11.glBindTexture(3553, tex);
/*  73 */       GL11.glBegin(7);
/*  74 */       GL11.glTexCoord2f(0.0F, 0.0F);
/*  75 */       GL11.glVertex2f(0.0F, 0.0F);
/*  76 */       GL11.glTexCoord2f(1.0F, 0.0F);
/*  77 */       GL11.glVertex2f(width, 0.0F);
/*  78 */       GL11.glTexCoord2f(1.0F, 1.0F);
/*  79 */       GL11.glVertex2f(width, height);
/*  80 */       GL11.glTexCoord2f(0.0F, 1.0F);
/*  81 */       GL11.glVertex2f(0.0F, height);
/*  82 */       GL11.glEnd();
/*  83 */       GL11.glDisable(3553);
/*     */ 
/*     */       
/*  86 */       float rectX = width * 0.2F;
/*  87 */       float rectX2 = width * 0.8F;
/*  88 */       float rectY = height * 0.85F;
/*  89 */       float rectY2 = height * 0.8F;
/*  90 */       float rectRadius = height * 0.025F;
/*  91 */       float progress = (float)animatedValue.sync(getProgress());
/*     */ 
/*     */       
/*  94 */       if (progress != 1.0F) {
/*  95 */         GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.3F);
/*  96 */         RenderUtils.drawRoundedCornerRect(rectX, rectY, rectX2, rectY2, rectRadius, (new Color(255, 255, 255, 40)).getRGB());
/*     */       } 
/*     */ 
/*     */       
/* 100 */       if (progress != 0.0F) {
/* 101 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 102 */         RenderUtils.drawRoundedCornerRect(rectX, rectY, rectX + width * 0.6F * progress, rectY2, rectRadius, (new Color(255, 255, 255, 170)).getRGB());
/*     */       } 
/*     */ 
/*     */       
/* 106 */       SplashProgress.mutex.acquireUninterruptibly();
/* 107 */       Display.update();
/* 108 */       SplashProgress.mutex.release();
/* 109 */       if (SplashProgress.pause) {
/* 110 */         clearGL();
/* 111 */         setGL();
/*     */       } 
/* 113 */       Display.sync(60);
/*     */     } 
/*     */     
/* 116 */     GL11.glDeleteTextures(tex);
/* 117 */     clearGL();
/*     */   }
/*     */   
/*     */   private static float getProgress() {
/* 121 */     float progress = 0.0F;
/* 122 */     Iterator<ProgressManager.ProgressBar> it = ProgressManager.barIterator();
/* 123 */     if (it.hasNext()) {
/* 124 */       ProgressManager.ProgressBar bar = it.next();
/* 125 */       progress = bar.getStep() / bar.getSteps();
/*     */     } 
/*     */     
/* 128 */     return progress;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\splash\MixinSplashProgressRunnable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */