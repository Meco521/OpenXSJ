/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\t\n\002\020\002\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005J\016\020\f\032\0020\r2\006\020\016\032\0020\017J\006\020\020\032\0020\000J\t\020\021\032\0020\003HÆ\003J\t\020\022\032\0020\003HÆ\003J\035\020\023\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\003HÆ\001J\023\020\024\032\0020\0252\b\020\026\032\004\030\0010\027HÖ\003J\016\020\030\032\0020\r2\006\020\031\032\0020\003J\t\020\032\032\0020\033HÖ\001J\016\020\034\032\0020\r2\006\020\035\032\0020\036J\t\020\037\032\0020 HÖ\001R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\n\020\007\"\004\b\013\020\t¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/Rotation;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "yaw", "", "pitch", "(FF)V", "getPitch", "()F", "setPitch", "(F)V", "getYaw", "setYaw", "applyStrafeToPlayer", "", "event", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "cloneSelf", "component1", "component2", "copy", "equals", "", "other", "", "fixedSensitivity", "sensitivity", "hashCode", "", "toPlayer", "player", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "toString", "", "XSJClient"})
/*     */ public final class Rotation extends MinecraftInstance {
/*     */   private float yaw;
/*     */   private float pitch;
/*     */   
/*  15 */   public final float getYaw() { return this.yaw; } public final void setYaw(float <set-?>) { this.yaw = <set-?>; } public final float getPitch() { return this.pitch; } public final void setPitch(float <set-?>) { this.pitch = <set-?>; } public Rotation(float yaw, float pitch) { this.yaw = yaw; this.pitch = pitch; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void toPlayer(@NotNull IEntityPlayer player) {
/*  21 */     Intrinsics.checkParameterIsNotNull(player, "player"); float f = this.yaw; boolean bool = false; if (!Float.isNaN(f)) { f = this.pitch; bool = false; if (!Float.isNaN(f)) {
/*     */ 
/*     */         
/*  24 */         fixedSensitivity(MinecraftInstance.mc.getGameSettings().getMouseSensitivity());
/*     */         
/*  26 */         player.setRotationYaw(this.yaw);
/*  27 */         player.setRotationPitch(this.pitch);
/*     */         return;
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fixedSensitivity(float sensitivity) {
/*  36 */     float f = sensitivity * 0.6F + 0.2F;
/*  37 */     float gcd = f * f * f * 1.2F;
/*     */ 
/*     */     
/*  40 */     Rotation rotation = RotationUtils.serverRotation;
/*     */ 
/*     */     
/*  43 */     float deltaYaw = this.yaw - rotation.yaw;
/*  44 */     deltaYaw -= deltaYaw % gcd;
/*  45 */     rotation.yaw += deltaYaw;
/*     */ 
/*     */     
/*  48 */     float deltaPitch = this.pitch - rotation.pitch;
/*  49 */     deltaPitch -= deltaPitch % gcd;
/*  50 */     rotation.pitch += deltaPitch;
/*     */   } @NotNull
/*     */   public final Rotation cloneSelf() {
/*  53 */     return new Rotation(this.yaw, this.pitch);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyStrafeToPlayer(@NotNull StrafeEvent event) {
/*  62 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*     */     
/*  64 */     int dif = 
/*     */       
/*  66 */       (int)((WMathHelper.wrapAngleTo180_float(player.getRotationYaw() - this.yaw - 23.5F - '') + '´') / 45);
/*     */     
/*  68 */     float yaw = this.yaw;
/*     */     
/*  70 */     float strafe = event.getStrafe();
/*  71 */     float forward = event.getForward();
/*  72 */     float friction = event.getFriction();
/*     */     
/*  74 */     float calcForward = 0.0F;
/*  75 */     float calcStrafe = 0.0F;
/*     */     
/*  77 */     switch (dif) {
/*     */       case 0:
/*  79 */         calcForward = forward;
/*  80 */         calcStrafe = strafe;
/*     */         break;
/*     */       case 1:
/*  83 */         calcForward += forward;
/*  84 */         calcStrafe -= forward;
/*  85 */         calcForward += strafe;
/*  86 */         calcStrafe += strafe;
/*     */         break;
/*     */       case 2:
/*  89 */         calcForward = strafe;
/*  90 */         calcStrafe = -forward;
/*     */         break;
/*     */       case 3:
/*  93 */         calcForward -= forward;
/*  94 */         calcStrafe -= forward;
/*  95 */         calcForward += strafe;
/*  96 */         calcStrafe -= strafe;
/*     */         break;
/*     */       case 4:
/*  99 */         calcForward = -forward;
/* 100 */         calcStrafe = -strafe;
/*     */         break;
/*     */       case 5:
/* 103 */         calcForward -= forward;
/* 104 */         calcStrafe += forward;
/* 105 */         calcForward -= strafe;
/* 106 */         calcStrafe -= strafe;
/*     */         break;
/*     */       case 6:
/* 109 */         calcForward = -strafe;
/* 110 */         calcStrafe = forward;
/*     */         break;
/*     */       case 7:
/* 113 */         calcForward += forward;
/* 114 */         calcStrafe += forward;
/* 115 */         calcForward -= strafe;
/* 116 */         calcStrafe += strafe;
/*     */         break;
/*     */     } 
/*     */     
/* 120 */     if (calcForward > 1.0F || (calcForward < 0.9F && calcForward > 0.3F) || calcForward < -1.0F || (calcForward > -0.9F && calcForward < -0.3F)) {
/* 121 */       calcForward *= 0.5F;
/*     */     }
/*     */     
/* 124 */     if (calcStrafe > 1.0F || (calcStrafe < 0.9F && calcStrafe > 0.3F) || calcStrafe < -1.0F || (calcStrafe > -0.9F && calcStrafe < -0.3F)) {
/* 125 */       calcStrafe *= 0.5F;
/*     */     }
/*     */     
/* 128 */     float d = calcStrafe * calcStrafe + calcForward * calcForward;
/*     */     
/* 130 */     if (d >= 1.0E-4F) {
/* 131 */       boolean bool1 = false; d = (float)Math.sqrt(d);
/* 132 */       if (d < 1.0F) d = 1.0F; 
/* 133 */       d = friction / d;
/* 134 */       calcStrafe *= d;
/* 135 */       calcForward *= d;
/* 136 */       float f1 = (float)(yaw * Math.PI / 180.0F); boolean bool2 = false; float yawSin = (float)Math.sin(f1);
/* 137 */       float f2 = (float)(yaw * Math.PI / 180.0F); boolean bool3 = false; float yawCos = (float)Math.cos(f2);
/* 138 */       player.setMotionX(player.getMotionX() + (calcStrafe * yawCos) - calcForward * yawSin);
/* 139 */       player.setMotionZ(player.getMotionZ() + (calcForward * yawCos) + calcStrafe * yawSin);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final float component1() {
/*     */     return this.yaw;
/*     */   }
/*     */   
/*     */   public final float component2() {
/*     */     return this.pitch;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Rotation copy(float yaw, float pitch) {
/*     */     return new Rotation(yaw, pitch);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String toString() {
/*     */     return "Rotation(yaw=" + this.yaw + ", pitch=" + this.pitch + ")";
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*     */     return Float.hashCode(this.yaw) * 31 + Float.hashCode(this.pitch);
/*     */   }
/*     */   
/*     */   public boolean equals(@Nullable Object paramObject) {
/*     */     if (this != paramObject) {
/*     */       if (paramObject instanceof Rotation) {
/*     */         Rotation rotation = (Rotation)paramObject;
/*     */         if (Float.compare(this.yaw, rotation.yaw) == 0 && Float.compare(this.pitch, rotation.pitch) == 0)
/*     */           return true; 
/*     */       } 
/*     */     } else {
/*     */       return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\Rotation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */