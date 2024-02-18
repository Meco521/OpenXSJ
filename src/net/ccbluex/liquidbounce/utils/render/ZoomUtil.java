/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ 
/*     */ public class ZoomUtil
/*     */ {
/*   9 */   protected static final Minecraft mc = Minecraft.func_71410_x();
/*     */   
/*     */   private final float originalX;
/*     */   private final float originalY;
/*     */   private final float originalWidth;
/*     */   private final float originalHeight;
/*     */   private final float speed;
/*     */   private final float zoomFactor;
/*     */   private final long nextUpdateTime;
/*  18 */   private final TimeUtils timer = new TimeUtils(); private float x;
/*     */   private float y;
/*     */   
/*     */   public ZoomUtil(float x, float y, float width, float height, long nextUpdateTime, float speed, float zoomFactor) {
/*  22 */     this.originalX = x;
/*  23 */     this.originalY = y;
/*  24 */     this.originalWidth = width;
/*  25 */     this.originalHeight = height;
/*  26 */     this.x = x;
/*  27 */     this.y = y;
/*  28 */     this.width = width;
/*  29 */     this.height = height;
/*  30 */     this.speed = speed;
/*  31 */     this.zoomFactor = zoomFactor;
/*  32 */     this.nextUpdateTime = nextUpdateTime;
/*     */   }
/*     */   private float width; private float height;
/*     */   public void update(int mouseX, int mouseY) {
/*  36 */     if (RenderUtils.isHovered(this.x, this.y, this.width, this.height, mouseX, mouseY)) {
/*  37 */       if (this.timer.hasElapsed(this.nextUpdateTime)) {
/*  38 */         this.x = RenderUtils.animate(this.originalX - this.zoomFactor / 2.0F, this.x, this.speed) - 0.1F;
/*  39 */         this.y = RenderUtils.animate(this.originalY - this.zoomFactor / 2.0F, this.y, this.speed) - 0.1F;
/*  40 */         this.width = RenderUtils.animate(this.originalWidth + this.zoomFactor, this.width, this.speed) - 0.1F;
/*  41 */         this.height = RenderUtils.animate(this.originalHeight + this.zoomFactor, this.height, this.speed) - 0.1F;
/*  42 */         this.timer.reset();
/*     */       } 
/*  44 */     } else if (this.timer.hasElapsed(this.nextUpdateTime)) {
/*  45 */       this.x = RenderUtils.animate(this.originalX, this.x, this.speed) - 0.1F;
/*  46 */       this.y = RenderUtils.animate(this.originalY, this.y, this.speed) - 0.1F;
/*  47 */       this.width = RenderUtils.animate(this.originalWidth, this.width, this.speed) - 0.1F;
/*  48 */       this.height = RenderUtils.animate(this.originalHeight, this.height, this.speed) - 0.1F;
/*  49 */       this.timer.reset();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPosition(float x, float y, float width, float height) {
/*  54 */     this.x = x;
/*  55 */     this.y = y;
/*  56 */     this.width = width;
/*  57 */     this.height = height;
/*     */   }
/*     */   
/*     */   public float getOriginalX() {
/*  61 */     return this.originalX;
/*     */   }
/*     */   
/*     */   public float getOriginalY() {
/*  65 */     return this.originalY;
/*     */   }
/*     */   
/*     */   public float getOriginalWidth() {
/*  69 */     return this.originalWidth;
/*     */   }
/*     */   
/*     */   public float getOriginalHeight() {
/*  73 */     return this.originalHeight;
/*     */   }
/*     */   
/*     */   public float getX() {
/*  77 */     return this.x;
/*     */   }
/*     */   
/*     */   public float getY() {
/*  81 */     return this.y;
/*     */   }
/*     */   
/*     */   public float getWidth() {
/*  85 */     return this.width;
/*     */   }
/*     */   
/*     */   public float getHeight() {
/*  89 */     return this.height;
/*     */   }
/*     */   
/*     */   public float getSpeed() {
/*  93 */     return this.speed;
/*     */   }
/*     */   
/*     */   public float getZoomFactor() {
/*  97 */     return this.zoomFactor;
/*     */   }
/*     */   
/*     */   public long getNextUpdateTime() {
/* 101 */     return this.nextUpdateTime;
/*     */   }
/*     */   
/*     */   public TimeUtils getTimer() {
/* 105 */     return this.timer;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\ZoomUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */