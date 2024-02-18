/*     */ package me.utils;
/*     */ 
/*     */ import kotlin.jvm.internal.Ref;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\006\n\002\020\007\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\017\b\026\022\006\020\002\032\0020\003¢\006\002\020\004BU\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\006\022\006\020\t\032\0020\006\022\006\020\n\032\0020\006\022\006\020\013\032\0020\006\022\006\020\f\032\0020\r\022\006\020\016\032\0020\r\022\006\020\017\032\0020\r\022\006\020\020\032\0020\r¢\006\002\020\021J\b\020\022\032\0020\023H\002J\020\020\024\032\004\030\0010\0252\006\020\026\032\0020\027J\032\020\030\032\004\030\0010\0252\006\020\031\032\0020\0322\006\020\033\032\0020\032H\002R\016\020\017\032\0020\rX\016¢\006\002\n\000R\016\020\020\032\0020\rX\004¢\006\002\n\000R\016\020\t\032\0020\006X\016¢\006\002\n\000R\016\020\n\032\0020\006X\016¢\006\002\n\000R\016\020\013\032\0020\006X\016¢\006\002\n\000R\016\020\016\032\0020\rX\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\006X\016¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\b\032\0020\006X\016¢\006\002\n\000¨\006\034"}, d2 = {"Lme/utils/FallingPlayer;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "x", "", "y", "z", "motionX", "motionY", "motionZ", "yaw", "", "strafe", "forward", "jumpMovementFactor", "(DDDDDDFFFF)V", "calculateForTick", "", "findCollision", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "ticks", "", "rayTrace", "start", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "end", "XSJClient"})
/*     */ public final class FallingPlayer extends MinecraftInstance {
/*     */   private double x;
/*     */   private double y;
/*     */   private double z;
/*     */   private double motionX;
/*     */   private double motionY;
/*     */   private double motionZ;
/*     */   private final float yaw;
/*     */   private float strafe;
/*     */   private float forward;
/*     */   private final float jumpMovementFactor;
/*     */   
/*  23 */   public FallingPlayer(double x, double y, double z, double motionX, double motionY, double motionZ, float yaw, float strafe, float forward, float jumpMovementFactor) { this.x = x; this.y = y; this.z = z; this.motionX = motionX; this.motionY = motionY; this.motionZ = motionZ; this.yaw = yaw; this.strafe = strafe; this.forward = forward; this.jumpMovementFactor = jumpMovementFactor; } public FallingPlayer(@NotNull EntityPlayer player) {
/*  24 */     this(
/*  25 */         player.field_70165_t, 
/*  26 */         player.field_70163_u, 
/*  27 */         player.field_70161_v, 
/*  28 */         player.field_70159_w, 
/*  29 */         player.field_70181_x, 
/*  30 */         player.field_70179_y, 
/*  31 */         player.field_70177_z, 
/*  32 */         player.field_70702_br, 
/*  33 */         player.field_191988_bg, 
/*  34 */         player.field_70747_aH);
/*     */   }
/*     */   
/*     */   private final void calculateForTick() {
/*  38 */     this.strafe *= 0.98F;
/*  39 */     this.forward *= 0.98F;
/*  40 */     float v = this.strafe * this.strafe + this.forward * this.forward;
/*  41 */     if (v >= 1.0E-4F) {
/*  42 */       v = MathHelper.func_76129_c(v);
/*  43 */       if (v < 1.0F) {
/*  44 */         v = 1.0F;
/*     */       }
/*  46 */       float fixedJumpFactor = this.jumpMovementFactor;
/*  47 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) {
/*  48 */         fixedJumpFactor = (float)(fixedJumpFactor * 1.3D);
/*     */       }
/*  50 */       v = fixedJumpFactor / v;
/*  51 */       this.strafe *= v;
/*  52 */       this.forward *= v;
/*  53 */       float f1 = MathHelper.func_76126_a(this.yaw * (float)Math.PI / 180.0F);
/*  54 */       float f2 = MathHelper.func_76134_b(this.yaw * (float)Math.PI / 180.0F);
/*  55 */       this.motionX += (this.strafe * f2 - this.forward * f1);
/*  56 */       this.motionZ += (this.forward * f2 + this.strafe * f1);
/*     */     } 
/*  58 */     this.motionY -= 0.08D;
/*  59 */     this.motionX *= 0.91D;
/*  60 */     this.motionY *= 0.9800000190734863D;
/*  61 */     this.motionZ *= 0.91D;
/*  62 */     this.x += this.motionX;
/*  63 */     this.y += this.motionY;
/*  64 */     this.z += this.motionZ; } @Nullable
/*     */   public final WBlockPos findCollision(int ticks) {
/*     */     byte b;
/*     */     int i;
/*  68 */     for (b = 0, i = ticks; b < i; b++) {
/*  69 */       WVec3 start = new WVec3(this.x, this.y, this.z);
/*  70 */       calculateForTick();
/*  71 */       WVec3 end = new WVec3(this.x, this.y, this.z);
/*  72 */       Ref.ObjectRef raytracedBlock = new Ref.ObjectRef();
/*  73 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float w = MinecraftInstance.mc.getThePlayer().getWidth() / 2.0F;
/*  74 */       WBlockPos wBlockPos9 = rayTrace(start, end); boolean bool9 = false, bool10 = false; WBlockPos wBlockPos17 = wBlockPos9; int $i$a$-also-FallingPlayer$findCollision$1 = 0; raytracedBlock.element = wBlockPos17; if (wBlockPos9 != null) return (WBlockPos)raytracedBlock.element; 
/*  75 */       WVec3 wVec38 = start; double d8 = w, d15 = 0.0D, d16 = w; FallingPlayer fallingPlayer = this; int $i$f$addVector = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  95 */       WVec3 wVec39 = new WVec3(wVec38.getXCoord() + d8, wVec38.getYCoord() + d15, wVec38.getZCoord() + d16); WBlockPos wBlockPos8 = fallingPlayer.rayTrace(wVec39, end); boolean bool8 = false; bool10 = false; WBlockPos wBlockPos16 = wBlockPos8; int $i$a$-also-FallingPlayer$findCollision$2 = 0; raytracedBlock.element = wBlockPos16; if (wBlockPos8 != null)
/*  96 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec37 = start; double d7 = -(w), d14 = 0.0D, z$iv = w; fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec37.getXCoord() + d7, wVec37.getYCoord() + d14, wVec37.getZCoord() + z$iv); WBlockPos wBlockPos7 = fallingPlayer.rayTrace(wVec39, end); boolean bool7 = false; bool10 = false; WBlockPos wBlockPos15 = wBlockPos7; int $i$a$-also-FallingPlayer$findCollision$3 = 0; raytracedBlock.element = wBlockPos15; if (wBlockPos7 != null)
/*  97 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec36 = start; double d6 = w, d13 = 0.0D; z$iv = -(w); fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec36.getXCoord() + d6, wVec36.getYCoord() + d13, wVec36.getZCoord() + z$iv); WBlockPos wBlockPos6 = fallingPlayer.rayTrace(wVec39, end); boolean bool6 = false; bool10 = false; WBlockPos wBlockPos14 = wBlockPos6; int $i$a$-also-FallingPlayer$findCollision$4 = 0; raytracedBlock.element = wBlockPos14; if (wBlockPos6 != null)
/*  98 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec35 = start; double d5 = -(w), d12 = 0.0D; z$iv = -(w); fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec35.getXCoord() + d5, wVec35.getYCoord() + d12, wVec35.getZCoord() + z$iv); WBlockPos wBlockPos5 = fallingPlayer.rayTrace(wVec39, end); boolean bool5 = false; bool10 = false; WBlockPos wBlockPos13 = wBlockPos5; int $i$a$-also-FallingPlayer$findCollision$5 = 0; raytracedBlock.element = wBlockPos13; if (wBlockPos5 != null)
/*  99 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec34 = start; double d4 = w, d11 = 0.0D; z$iv = (w / 2.0F); fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec34.getXCoord() + d4, wVec34.getYCoord() + d11, wVec34.getZCoord() + z$iv); WBlockPos wBlockPos4 = fallingPlayer.rayTrace(wVec39, end); boolean bool4 = false; bool10 = false; WBlockPos wBlockPos12 = wBlockPos4; int $i$a$-also-FallingPlayer$findCollision$6 = 0; raytracedBlock.element = wBlockPos12; if (wBlockPos4 != null)
/* 100 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec33 = start; double d3 = -(w), d10 = 0.0D; z$iv = (w / 2.0F); fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec33.getXCoord() + d3, wVec33.getYCoord() + d10, wVec33.getZCoord() + z$iv); WBlockPos wBlockPos3 = fallingPlayer.rayTrace(wVec39, end); boolean bool3 = false; bool10 = false; WBlockPos wBlockPos11 = wBlockPos3; int $i$a$-also-FallingPlayer$findCollision$7 = 0; raytracedBlock.element = wBlockPos11; if (wBlockPos3 != null)
/* 101 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec32 = start; double d2 = (w / 2.0F), d9 = 0.0D; z$iv = w; fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec32.getXCoord() + d2, wVec32.getYCoord() + d9, wVec32.getZCoord() + z$iv); WBlockPos wBlockPos2 = fallingPlayer.rayTrace(wVec39, end); boolean bool2 = false; bool10 = false; WBlockPos wBlockPos10 = wBlockPos2; int $i$a$-also-FallingPlayer$findCollision$8 = 0; raytracedBlock.element = wBlockPos10; if (wBlockPos2 != null)
/* 102 */         return (WBlockPos)raytracedBlock.element;  WVec3 wVec31 = start; double d1 = (w / 2.0F), y$iv = 0.0D; z$iv = -(w); fallingPlayer = this; $i$f$addVector = 0; wVec39 = new WVec3(wVec31.getXCoord() + d1, wVec31.getYCoord() + y$iv, wVec31.getZCoord() + z$iv); WBlockPos wBlockPos1 = fallingPlayer.rayTrace(wVec39, end);
/*     */       boolean bool1 = false;
/*     */       bool10 = false;
/*     */       WBlockPos it = wBlockPos1;
/*     */       int $i$a$-also-FallingPlayer$findCollision$9 = 0;
/*     */       raytracedBlock.element = it;
/*     */       if (wBlockPos1 != null)
/*     */         return (WBlockPos)raytracedBlock.element; 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private final WBlockPos rayTrace(WVec3 start, WVec3 end) {
/*     */     if (MinecraftInstance.mc.getTheWorld() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     IMovingObjectPosition result = MinecraftInstance.mc.getTheWorld().rayTraceBlocks(start, end, true);
/*     */     return (result != null && result.getTypeOfHit() == RangesKt.rangeTo((Comparable)IMovingObjectPosition.WMovingObjectType.MISS, (Comparable)IMovingObjectPosition.WMovingObjectType.BLOCK) && result.getSideHit() == EnumFacing.UP) ? result.getBlockPos() : null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\FallingPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */