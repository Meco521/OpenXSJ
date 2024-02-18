/*     */ package net.ccbluex.liquidbounce.utils.misc;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FallingPlayer
/*     */   extends MinecraftInstance
/*     */ {
/*     */   private double x;
/*     */   private double y;
/*     */   private double z;
/*     */   private double motionX;
/*     */   private double motionY;
/*     */   private double motionZ;
/*     */   private final float yaw;
/*     */   private float strafe;
/*     */   private float forward;
/*     */   
/*     */   public FallingPlayer(double x, double y, double z, double motionX, double motionY, double motionZ, float yaw, float strafe, float forward) {
/*  25 */     this.x = x;
/*  26 */     this.y = y;
/*  27 */     this.z = z;
/*  28 */     this.motionX = motionX;
/*  29 */     this.motionY = motionY;
/*  30 */     this.motionZ = motionZ;
/*  31 */     this.yaw = yaw;
/*  32 */     this.strafe = strafe;
/*  33 */     this.forward = forward;
/*     */   }
/*     */   
/*     */   private void calculateForTick() {
/*  37 */     this.strafe *= 0.98F;
/*  38 */     this.forward *= 0.98F;
/*     */     
/*  40 */     float v = this.strafe * this.strafe + this.forward * this.forward;
/*     */     
/*  42 */     if (v >= 1.0E-4F) {
/*  43 */       v = (float)Math.sqrt(v);
/*     */       
/*  45 */       if (v < 1.0F) {
/*  46 */         v = 1.0F;
/*     */       }
/*     */       
/*  49 */       v = mc.getThePlayer().getJumpMovementFactor() / v;
/*  50 */       this.strafe *= v;
/*  51 */       this.forward *= v;
/*  52 */       float f1 = (float)Math.sin((this.yaw * 3.1415927F / 180.0F));
/*  53 */       float f2 = (float)Math.cos((this.yaw * 3.1415927F / 180.0F));
/*  54 */       this.motionX += (this.strafe * f2 - this.forward * f1);
/*  55 */       this.motionZ += (this.forward * f2 + this.strafe * f1);
/*     */     } 
/*     */ 
/*     */     
/*  59 */     this.motionY -= 0.08D;
/*     */     
/*  61 */     this.motionX *= 0.91D;
/*  62 */     this.motionY *= 0.9800000190734863D;
/*  63 */     this.motionY *= 0.91D;
/*  64 */     this.motionZ *= 0.91D;
/*     */     
/*  66 */     this.x += this.motionX;
/*  67 */     this.y += this.motionY;
/*  68 */     this.z += this.motionZ;
/*     */   }
/*     */   
/*     */   public CollisionResult findCollision(int ticks) {
/*  72 */     for (int i = 0; i < ticks; i++) {
/*  73 */       WVec3 start = new WVec3(this.x, this.y, this.z);
/*     */       
/*  75 */       calculateForTick();
/*     */       
/*  77 */       WVec3 end = new WVec3(this.x, this.y, this.z);
/*     */ 
/*     */ 
/*     */       
/*  81 */       float w = mc.getThePlayer().getWidth() / 2.0F;
/*     */       WBlockPos raytracedBlock;
/*  83 */       if ((raytracedBlock = rayTrace(start, end)) != null) return new CollisionResult(raytracedBlock, i);
/*     */       
/*  85 */       if ((raytracedBlock = rayTrace(start.addVector(w, 0.0D, w), end)) != null)
/*  86 */         return new CollisionResult(raytracedBlock, i); 
/*  87 */       if ((raytracedBlock = rayTrace(start.addVector(-w, 0.0D, w), end)) != null)
/*  88 */         return new CollisionResult(raytracedBlock, i); 
/*  89 */       if ((raytracedBlock = rayTrace(start.addVector(w, 0.0D, -w), end)) != null)
/*  90 */         return new CollisionResult(raytracedBlock, i); 
/*  91 */       if ((raytracedBlock = rayTrace(start.addVector(-w, 0.0D, -w), end)) != null) {
/*  92 */         return new CollisionResult(raytracedBlock, i);
/*     */       }
/*  94 */       if ((raytracedBlock = rayTrace(start.addVector(w, 0.0D, (w / 2.0F)), end)) != null)
/*  95 */         return new CollisionResult(raytracedBlock, i); 
/*  96 */       if ((raytracedBlock = rayTrace(start.addVector(-w, 0.0D, (w / 2.0F)), end)) != null)
/*  97 */         return new CollisionResult(raytracedBlock, i); 
/*  98 */       if ((raytracedBlock = rayTrace(start.addVector((w / 2.0F), 0.0D, w), end)) != null)
/*  99 */         return new CollisionResult(raytracedBlock, i); 
/* 100 */       if ((raytracedBlock = rayTrace(start.addVector((w / 2.0F), 0.0D, -w), end)) != null) {
/* 101 */         return new CollisionResult(raytracedBlock, i);
/*     */       }
/*     */     } 
/*     */     
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private WBlockPos rayTrace(WVec3 start, WVec3 end) {
/* 111 */     IMovingObjectPosition result = mc.getTheWorld().rayTraceBlocks(start, end, true);
/*     */     
/* 113 */     if (result != null && result.getTypeOfHit() == IMovingObjectPosition.WMovingObjectType.BLOCK && result.getSideHit().isUp()) {
/* 114 */       return result.getBlockPos();
/*     */     }
/*     */     
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   public static class CollisionResult {
/*     */     private final WBlockPos pos;
/*     */     private final int tick;
/*     */     
/*     */     public CollisionResult(WBlockPos pos, int tick) {
/* 125 */       this.pos = pos;
/* 126 */       this.tick = tick;
/*     */     }
/*     */     
/*     */     public WBlockPos getPos() {
/* 130 */       return this.pos;
/*     */     }
/*     */     
/*     */     public int getTick() {
/* 134 */       return this.tick;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\FallingPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */