/*     */ package net.ccbluex.liquidbounce.utils.render.particle;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.utils.render.particle.util.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ class Particle
/*     */ {
/*     */   public float x;
/*     */   public float y;
/*     */   public final float size;
/*  25 */   private final float ySpeed = (new Random()).nextInt(5);
/*  26 */   private final float xSpeed = (new Random()).nextInt(5);
/*     */   private int height;
/*     */   private int width;
/*     */   
/*     */   Particle(int x, int y) {
/*  31 */     this.x = x;
/*  32 */     this.y = y;
/*  33 */     this.size = genRandom();
/*     */   }
/*     */   
/*     */   private float lint1(float f) {
/*  37 */     return 1.02F * (1.0F - f) + 1.0F * f;
/*     */   }
/*     */   
/*     */   private float lint2(float f) {
/*  41 */     return 1.02F + f * -0.01999998F;
/*     */   }
/*     */   
/*     */   void connect(float x, float y) {
/*  45 */     RenderUtils.connectPoints(getX(), getY(), x, y);
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*  49 */     return this.height;
/*     */   }
/*     */   
/*     */   public void setHeight(int height) {
/*  53 */     this.height = height;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*  57 */     return this.width;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/*  61 */     this.width = width;
/*     */   }
/*     */   
/*     */   public float getX() {
/*  65 */     return this.x;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/*  69 */     this.x = x;
/*     */   }
/*     */   
/*     */   public float getY() {
/*  73 */     return this.y;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/*  77 */     this.y = y;
/*     */   }
/*     */   
/*     */   void interpolation() {
/*  81 */     for (int n = 0; n <= 64; n++) {
/*  82 */       float f = n / 64.0F;
/*  83 */       float p1 = lint1(f);
/*  84 */       float p2 = lint2(f);
/*     */       
/*  86 */       if (p1 != p2) {
/*  87 */         this.y -= f;
/*  88 */         this.x -= f;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void fall() {
/*  94 */     Minecraft mc = Minecraft.func_71410_x();
/*  95 */     ScaledResolution scaledResolution = new ScaledResolution(mc);
/*  96 */     this.y += this.ySpeed;
/*  97 */     this.x += this.xSpeed;
/*     */     
/*  99 */     if (this.y > mc.field_71440_d) {
/* 100 */       this.y = 1.0F;
/*     */     }
/* 102 */     if (this.x > mc.field_71443_c) {
/* 103 */       this.x = 1.0F;
/*     */     }
/* 105 */     if (this.x < 1.0F) {
/* 106 */       this.x = scaledResolution.func_78326_a();
/*     */     }
/* 108 */     if (this.y < 1.0F)
/* 109 */       this.y = scaledResolution.func_78328_b(); 
/*     */   }
/*     */   
/*     */   private float genRandom() {
/* 113 */     return (float)(0.30000001192092896D + Math.random() * 1.2999999523162842D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\particle\Particle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */