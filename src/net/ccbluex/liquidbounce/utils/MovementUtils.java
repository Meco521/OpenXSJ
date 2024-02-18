/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000H\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\b\n\002\020\013\n\002\b\006\n\002\020\007\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\013\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J0\020\031\032\0020\0322\006\020\033\032\0020\0342\006\020\035\032\0020\0242\006\020\036\032\0020\0242\006\020\037\032\0020 2\b\b\002\020!\032\0020\"J\020\020#\032\0020\0322\006\020$\032\0020\004H\007J\016\020%\032\0020\0042\006\020&\032\0020'J\030\020(\032\0020\0242\006\020)\032\0020\0242\006\020*\032\0020\024H\007J\006\020+\032\0020\rJ\016\020,\032\0020\r2\006\020-\032\0020\004J\016\020.\032\0020\0322\006\020/\032\0020\rJ\016\0200\032\0020\0322\006\020\027\032\0020\004J\022\020*\032\0020\0322\b\b\002\020\027\032\0020\024H\007J\006\0201\032\0020\032R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\0048FX\004¢\006\f\022\004\b\n\020\002\032\004\b\013\020\006R\032\020\f\032\0020\r8FX\004¢\006\f\022\004\b\016\020\002\032\004\b\f\020\017R\016\020\020\032\0020\004X\016¢\006\002\n\000R\016\020\021\032\0020\004X\016¢\006\002\n\000R\016\020\022\032\0020\004X\016¢\006\002\n\000R\021\020\023\032\0020\0248F¢\006\006\032\004\b\025\020\026R\021\020\027\032\0020\0248F¢\006\006\032\004\b\030\020\026¨\0062"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/MovementUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "bps", "", "getBps", "()D", "setBps", "(D)V", "direction", "direction$annotations", "getDirection", "isMoving", "", "isMoving$annotations", "()Z", "lastX", "lastY", "lastZ", "movingYaw", "", "getMovingYaw", "()F", "speed", "getSpeed", "doTargetStrafe", "", "curTarget", "Lnet/minecraft/entity/EntityLivingBase;", "direction_", "radius", "moveEvent", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "mathRadius", "", "forward", "length", "getBlockSpeed", "entityIn", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getScaffoldRotation", "yaw", "strafe", "hasMotion", "isOnGround", "height", "resetMotion", "y", "setMotion", "updateBlocksPerSecond", "XSJClient"})
/*     */ public final class MovementUtils extends MinecraftInstance {
/*     */   private static double bps;
/*     */   private static double lastX;
/*     */   
/*  12 */   static { MovementUtils movementUtils = new MovementUtils(); } private static double lastY; private static double lastZ; public static final MovementUtils INSTANCE; public final double getBps() {
/*  13 */     return bps; } public final void setBps(double <set-?>) { bps = <set-?>; }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getSpeed() {
/*  18 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d = MinecraftInstance.mc.getThePlayer().getMotionX() * MinecraftInstance.mc.getThePlayer().getMotionX() + MinecraftInstance.mc.getThePlayer().getMotionZ() * MinecraftInstance.mc.getThePlayer().getMotionZ(); boolean bool = false; return (float)Math.sqrt(d);
/*     */   } public final void setMotion(double speed) {
/*  20 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double forward = MinecraftInstance.mc.getThePlayer().getMovementInput().getMoveForward();
/*  21 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double strafe = MinecraftInstance.mc.getThePlayer().getMovementInput().getMoveStrafe();
/*  22 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float yaw = MinecraftInstance.mc.getThePlayer().getRotationYaw();
/*  23 */     if (forward == 0.0D && strafe == 0.0D) {
/*  24 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(0.0D);
/*  25 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(0.0D);
/*     */     } else {
/*  27 */       if (forward != 0.0D) {
/*  28 */         if (strafe > 0.0D) {
/*  29 */           yaw += ((forward > 0.0D) ? -45 : 45);
/*  30 */         } else if (strafe < 0.0D) {
/*  31 */           yaw += ((forward > 0.0D) ? 45 : -45);
/*     */         } 
/*  33 */         strafe = 0.0D;
/*  34 */         if (forward > 0.0D) {
/*  35 */           forward = 1.0D;
/*  36 */         } else if (forward < 0.0D) {
/*  37 */           forward = -1.0D;
/*     */         } 
/*     */       } 
/*  40 */       double cos = Math.cos(Math.toRadians(yaw + 90.0F));
/*  41 */       double sin = Math.sin(Math.toRadians(yaw + 90.0F));
/*  42 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer()
/*  43 */         .setMotionX(forward * speed * cos + strafe * speed * sin);
/*  44 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer()
/*  45 */         .setMotionZ(forward * speed * sin - strafe * speed * cos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void updateBlocksPerSecond() {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: ifnull -> 35
/*     */     //   11: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   14: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   19: dup
/*     */     //   20: ifnonnull -> 26
/*     */     //   23: invokestatic throwNpe : ()V
/*     */     //   26: invokeinterface getTicksExisted : ()I
/*     */     //   31: iconst_1
/*     */     //   32: if_icmpge -> 39
/*     */     //   35: dconst_0
/*     */     //   36: putstatic net/ccbluex/liquidbounce/utils/MovementUtils.bps : D
/*     */     //   39: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   42: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   47: dup
/*     */     //   48: ifnonnull -> 54
/*     */     //   51: invokestatic throwNpe : ()V
/*     */     //   54: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.lastX : D
/*     */     //   57: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.lastY : D
/*     */     //   60: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.lastZ : D
/*     */     //   63: invokeinterface getDistance : (DDD)D
/*     */     //   68: dstore_1
/*     */     //   69: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   72: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   77: dup
/*     */     //   78: ifnonnull -> 84
/*     */     //   81: invokestatic throwNpe : ()V
/*     */     //   84: invokeinterface getPosX : ()D
/*     */     //   89: putstatic net/ccbluex/liquidbounce/utils/MovementUtils.lastX : D
/*     */     //   92: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   95: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   100: dup
/*     */     //   101: ifnonnull -> 107
/*     */     //   104: invokestatic throwNpe : ()V
/*     */     //   107: invokeinterface getPosY : ()D
/*     */     //   112: putstatic net/ccbluex/liquidbounce/utils/MovementUtils.lastY : D
/*     */     //   115: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   118: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   123: dup
/*     */     //   124: ifnonnull -> 130
/*     */     //   127: invokestatic throwNpe : ()V
/*     */     //   130: invokeinterface getPosZ : ()D
/*     */     //   135: putstatic net/ccbluex/liquidbounce/utils/MovementUtils.lastZ : D
/*     */     //   138: dload_1
/*     */     //   139: bipush #20
/*     */     //   141: i2f
/*     */     //   142: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   145: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   150: invokeinterface getTimerSpeed : ()F
/*     */     //   155: fmul
/*     */     //   156: f2d
/*     */     //   157: dmul
/*     */     //   158: putstatic net/ccbluex/liquidbounce/utils/MovementUtils.bps : D
/*     */     //   161: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #49	-> 0
/*     */     //   #50	-> 35
/*     */     //   #52	-> 39
/*     */     //   #53	-> 69
/*     */     //   #54	-> 92
/*     */     //   #55	-> 115
/*     */     //   #56	-> 138
/*     */     //   #57	-> 161
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   69	93	1	distance	D
/*     */     //   0	162	0	this	Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void resetMotion(boolean y) {
/*  59 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(0.0D);
/*  60 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(0.0D);
/*  61 */     if (y) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.0D); }
/*     */   
/*     */   }
/*     */   public static final boolean isMoving() {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: ifnull -> 75
/*     */     //   11: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   14: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   19: dup
/*     */     //   20: ifnonnull -> 26
/*     */     //   23: invokestatic throwNpe : ()V
/*     */     //   26: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   31: invokeinterface getMoveForward : ()F
/*     */     //   36: fconst_0
/*     */     //   37: fcmpg
/*     */     //   38: ifne -> 71
/*     */     //   41: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   44: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   49: dup
/*     */     //   50: ifnonnull -> 56
/*     */     //   53: invokestatic throwNpe : ()V
/*     */     //   56: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   61: invokeinterface getMoveStrafe : ()F
/*     */     //   66: fconst_0
/*     */     //   67: fcmpg
/*     */     //   68: ifeq -> 75
/*     */     //   71: iconst_1
/*     */     //   72: goto -> 76
/*     */     //   75: iconst_0
/*     */     //   76: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #66	-> 0
/*     */   }
/*     */   @JvmStatic
/*     */   public static final float getScaffoldRotation(float yaw, float strafe) {
/*  69 */     float rotationYaw = yaw;
/*  70 */     rotationYaw += 180.0F;
/*  71 */     float forward = -0.5F;
/*  72 */     if (strafe < 0.0F) rotationYaw -= 90.0F * forward; 
/*  73 */     if (strafe > 0.0F) rotationYaw += 90.0F * forward; 
/*  74 */     return rotationYaw;
/*     */   }
/*     */   public final void doTargetStrafe(@NotNull EntityLivingBase curTarget, float direction_, float radius, @NotNull MoveEvent moveEvent, int mathRadius) {
/*  77 */     Intrinsics.checkParameterIsNotNull(curTarget, "curTarget"); Intrinsics.checkParameterIsNotNull(moveEvent, "moveEvent"); if (!isMoving())
/*     */       return; 
/*  79 */     double forward_ = 0.0D;
/*  80 */     double strafe_ = 0.0D;
/*  81 */     double d1 = moveEvent.getX() * moveEvent.getX() + moveEvent.getZ() * moveEvent.getZ(); boolean bool1 = false; double speed_ = Math.sqrt(d1);
/*     */     
/*  83 */     if (speed_ <= 1.0E-4D) {
/*     */       return;
/*     */     }
/*  86 */     double _direction = 0.0D;
/*  87 */     if (direction_ > 0.001D) {
/*  88 */       _direction = 1.0D;
/*  89 */     } else if (direction_ < -0.001D) {
/*  90 */       _direction = -1.0D;
/*     */     } 
/*  92 */     float curDistance = (float)0.01D;
/*  93 */     if (mathRadius == 1) {
/*  94 */       curDistance = MinecraftInstance.mc2.field_71439_g.func_70032_d((Entity)curTarget);
/*  95 */     } else if (mathRadius == 0) {
/*  96 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d = (MinecraftInstance.mc.getThePlayer().getPosX() - curTarget.field_70165_t) * (MinecraftInstance.mc.getThePlayer().getPosX() - curTarget.field_70165_t) + (MinecraftInstance.mc.getThePlayer().getPosZ() - curTarget.field_70161_v) * (MinecraftInstance.mc.getThePlayer().getPosZ() - curTarget.field_70161_v); boolean bool = false; curDistance = (float)Math.sqrt(d);
/*     */     } 
/*  98 */     if (curDistance < radius - speed_) {
/*  99 */       forward_ = -1.0D;
/* 100 */     } else if (curDistance > radius + speed_) {
/* 101 */       forward_ = 1.0D;
/*     */     } else {
/* 103 */       forward_ = (curDistance - radius) / speed_;
/*     */     } 
/* 105 */     if (curDistance < radius + speed_ * 2 && curDistance > radius - speed_ * 2) {
/* 106 */       strafe_ = 1.0D;
/*     */     }
/* 108 */     strafe_ *= _direction;
/*     */     
/* 110 */     double d2 = forward_ * forward_ + strafe_ * strafe_; boolean bool2 = false; double covert_ = Math.sqrt(d2);
/* 111 */     forward_ /= covert_;
/* 112 */     strafe_ /= covert_;
/* 113 */     bool2 = false; double turnAngle = Math.toDegrees(Math.asin(strafe_));
/* 114 */     if (turnAngle > false) {
/* 115 */       if (forward_ < false) {
/* 116 */         turnAngle = 180.0F - turnAngle;
/*     */       }
/* 118 */     } else if (forward_ < false) {
/* 119 */       turnAngle = -180.0F - turnAngle;
/*     */     } 
/* 121 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(moveEvent.getX());
/* 122 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(moveEvent.getZ());
/*     */   }
/*     */   public final boolean hasMotion() {
/* 125 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionX() != 0.0D) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionZ() != 0.0D) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionY() != 0.0D); }  }  return false;
/*     */   }
/*     */   public final float getMovingYaw() {
/* 128 */     return (float)(getDirection() * 180.0F / Math.PI);
/*     */   } public final double getBlockSpeed(@NotNull IEntityLivingBase entityIn) {
/* 130 */     Intrinsics.checkParameterIsNotNull(entityIn, "entityIn");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     return BigDecimal.valueOf(Math.sqrt(Math.pow(entityIn.getPosX() - entityIn.getPrevPosX(), 2.0D) + Math.pow(entityIn.getPosZ() - entityIn.getPrevPosZ(), 2.0D)) * 20).setScale(1, 4).doubleValue();
/*     */   }
/*     */   public final boolean isOnGround(double height) {
/* 140 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return !MinecraftInstance.mc.getTheWorld().getCollidingBoundingBoxes((IEntity)MinecraftInstance.mc.getThePlayer(), MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().offset(0.0D, -height, 0.0D)).isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   @JvmOverloads
/*     */   public static final void strafe(float speed) {
/* 149 */     if (!isMoving())
/* 150 */       return;  double yaw = getDirection();
/* 151 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 152 */     IEntityPlayerSP iEntityPlayerSP1 = thePlayer; boolean bool = false; double d1 = Math.sin(yaw); iEntityPlayerSP1.setMotionX(-d1 * speed);
/* 153 */     iEntityPlayerSP1 = thePlayer; bool = false; d1 = Math.cos(yaw); iEntityPlayerSP1.setMotionZ(d1 * speed);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final void forward(double length) {
/* 158 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 159 */     double yaw = Math.toRadians(thePlayer.getRotationYaw());
/* 160 */     double d1 = thePlayer.getPosX(); IEntityPlayerSP iEntityPlayerSP1 = thePlayer; boolean bool = false; double d2 = Math.sin(yaw), d3 = thePlayer.getPosZ(); d2 = thePlayer.getPosY(); d1 += -d2 * length; iEntityPlayerSP1 = iEntityPlayerSP1; bool = false; double d4 = Math.cos(yaw); iEntityPlayerSP1.setPosition(d1, d2, d3 + d4 * length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final double getDirection() {
/* 166 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 167 */     float rotationYaw = thePlayer.getRotationYaw();
/* 168 */     if (thePlayer.getMoveForward() < 0.0F) rotationYaw += 180.0F; 
/* 169 */     float forward = 1.0F;
/* 170 */     if (thePlayer.getMoveForward() < 0.0F) { forward = -0.5F; } else if (thePlayer.getMoveForward() > 0.0F) { forward = 0.5F; }
/* 171 */      if (thePlayer.getMoveStrafing() > 0.0F) rotationYaw -= 90.0F * forward; 
/* 172 */     if (thePlayer.getMoveStrafing() < 0.0F) rotationYaw += 90.0F * forward; 
/* 173 */     return Math.toRadians(rotationYaw);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @JvmOverloads
/*     */   public static final void strafe() {
/*     */     strafe$default(0.0F, 1, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\MovementUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */