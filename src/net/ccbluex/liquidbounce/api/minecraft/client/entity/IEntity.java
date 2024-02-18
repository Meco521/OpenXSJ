package net.ccbluex.liquidbounce.api.minecraft.client.entity;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import net.ccbluex.liquidbounce.api.minecraft.block.material.IMaterial;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\003\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\f\n\002\030\002\n\002\b\005\n\002\020\b\n\002\b\n\n\002\030\002\n\002\b\023\n\002\020\006\n\002\b\007\n\002\030\002\n\002\b\r\n\002\020\016\n\002\b\020\n\002\030\002\n\002\b\036\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\016\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\bf\030\0002\0020\001J\n\020\001\032\0030\001H&J\n\020\001\032\0030\001H&J\n\020\001\032\0030\001H&J\t\020\001\032\0020\003H&J\t\020\001\032\0020\003H&J\024\020\001\032\0030\0012\b\020\001\032\0030\001H&J$\020\001\032\0020=2\007\020\001\032\0020=2\007\020\001\032\0020=2\007\020\001\032\0020=H&J\022\020\001\032\0020=2\007\020\001\032\0020dH&J\022\020\001\032\0020=2\007\020\001\032\0020\000H&J\022\020\001\032\0020\0072\007\020\001\032\0020\000H&J\022\020\001\032\0020E2\007\020\001\032\0020\007H&J\022\020\001\032\0020E2\007\020\001\032\0020\007H&J\023\020 \001\032\0020\0032\b\020¡\001\032\0030¢\001H&J%\020£\001\032\0030\0012\007\020\001\032\0020=2\007\020\001\032\0020=2\007\020\001\032\0020=H&J\036\020¤\001\032\005\030\0010¥\0012\007\020¦\001\032\0020=2\007\020\001\032\0020\007H&J%\020§\001\032\0030\0012\007\020\001\032\0020=2\007\020\001\032\0020=2\007\020\001\032\0020=H&J5\020¨\001\032\0030\0012\007\020©\001\032\0020=2\007\020ª\001\032\0020=2\007\020«\001\032\0020=2\006\020u\032\0020\0072\006\020r\032\0020\007H&J\"\020¬\001\032\0030\0012\006\020\\\032\0020=2\006\020^\032\0020=2\006\020a\032\0020=H&R\024\020\002\032\0020\0038gX¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\004\030\0010\013X¦\004¢\006\006\032\004\b\f\020\rR\030\020\016\032\0020\007X¦\016¢\006\f\032\004\b\017\020\t\"\004\b\020\020\021R\030\020\022\032\0020\007X¦\016¢\006\f\032\004\b\023\020\t\"\004\b\024\020\021R\024\020\025\032\0020\0038gX¦\004¢\006\006\032\004\b\026\020\005R\030\020\027\032\0020\030X¦\016¢\006\f\032\004\b\031\020\032\"\004\b\033\020\034R\022\020\035\032\0020\036X¦\004¢\006\006\032\004\b\037\020 R\022\020!\032\0020\007X¦\004¢\006\006\032\004\b\"\020\tR\030\020#\032\0020\007X¦\016¢\006\f\032\004\b$\020\t\"\004\b%\020\021R\022\020&\032\0020\007X¦\004¢\006\006\032\004\b'\020\tR\022\020(\032\0020)X¦\004¢\006\006\032\004\b*\020+R\022\020,\032\0020\036X¦\004¢\006\006\032\004\b-\020 R\024\020.\032\0020\0038gX¦\004¢\006\006\032\004\b/\020\005R\030\0200\032\0020\003X¦\016¢\006\f\032\004\b0\020\005\"\004\b1\0202R\022\0203\032\0020\003X¦\004¢\006\006\032\004\b3\020\005R\022\0204\032\0020\003X¦\004¢\006\006\032\004\b4\020\005R\030\0205\032\0020\003X¦\016¢\006\f\032\004\b5\020\005\"\004\b6\0202R\022\0207\032\0020\003X¦\004¢\006\006\032\004\b7\020\005R\022\0208\032\0020\003X¦\004¢\006\006\032\004\b8\020\005R\030\0209\032\0020\003X¦\016¢\006\f\032\004\b9\020\005\"\004\b:\0202R\024\020;\032\0020\0038gX¦\004¢\006\006\032\004\b;\020\005R\022\020<\032\0020=X¦\004¢\006\006\032\004\b>\020?R\022\020@\032\0020=X¦\004¢\006\006\032\004\bA\020?R\022\020B\032\0020=X¦\004¢\006\006\032\004\bC\020?R\024\020D\032\004\030\0010EX¦\004¢\006\006\032\004\bF\020GR\030\020H\032\0020=X¦\016¢\006\f\032\004\bI\020?\"\004\bJ\020KR\030\020L\032\0020=X¦\016¢\006\f\032\004\bM\020?\"\004\bN\020KR\030\020O\032\0020=X¦\016¢\006\f\032\004\bP\020?\"\004\bQ\020KR\024\020R\032\004\030\0010SX¦\004¢\006\006\032\004\bT\020UR\030\020V\032\0020\003X¦\016¢\006\f\032\004\bW\020\005\"\004\bX\0202R\030\020Y\032\0020\003X¦\016¢\006\f\032\004\bZ\020\005\"\004\b[\0202R\022\020\\\032\0020=X¦\004¢\006\006\032\004\b]\020?R\030\020^\032\0020=X¦\016¢\006\f\032\004\b_\020?\"\004\b`\020KR\022\020a\032\0020=X¦\004¢\006\006\032\004\bb\020?R\022\020c\032\0020dX¦\004¢\006\006\032\004\be\020fR\022\020g\032\0020EX¦\004¢\006\006\032\004\bh\020GR\022\020i\032\0020=X¦\004¢\006\006\032\004\bj\020?R\022\020k\032\0020=X¦\004¢\006\006\032\004\bl\020?R\022\020m\032\0020=X¦\004¢\006\006\032\004\bn\020?R\024\020o\032\004\030\0010\000X¦\004¢\006\006\032\004\bp\020qR\030\020r\032\0020\007X¦\016¢\006\f\032\004\bs\020\t\"\004\bt\020\021R\030\020u\032\0020\007X¦\016¢\006\f\032\004\bv\020\t\"\004\bw\020\021R\024\020x\032\0020\0038gX¦\004¢\006\006\032\004\by\020\005R\030\020z\032\0020\003X¦\016¢\006\f\032\004\b{\020\005\"\004\b|\0202R\030\020}\032\0020\007X¦\016¢\006\f\032\004\b~\020\t\"\004\b\020\021R\024\020\001\032\0020\036X¦\004¢\006\007\032\005\b\001\020 R\026\020\001\032\0030\001X¦\004¢\006\b\032\006\b\001\020\001R\024\020\001\032\0020\007X¦\004¢\006\007\032\005\b\001\020\t¨\006­\001"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "", "burning", "", "isBurning", "()Z", "collisionBorderSize", "", "getCollisionBorderSize", "()F", "displayName", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "getDisplayName", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "distanceWalkedModified", "getDistanceWalkedModified", "setDistanceWalkedModified", "(F)V", "distanceWalkedOnStepModified", "getDistanceWalkedOnStepModified", "setDistanceWalkedOnStepModified", "entityAlive", "isEntityAlive", "entityBoundingBox", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "getEntityBoundingBox", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "setEntityBoundingBox", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V", "entityId", "", "getEntityId", "()I", "eyeHeight", "getEyeHeight", "fallDistance", "getFallDistance", "setFallDistance", "height", "getHeight", "horizontalFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getHorizontalFacing", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "hurtResistantTime", "getHurtResistantTime", "invisible", "isInvisible", "isAirBorne", "setAirBorne", "(Z)V", "isCollidedHorizontally", "isCollidedVertically", "isDead", "setDead", "isInLava", "isInWater", "isInWeb", "setInWeb", "isRiding", "lastTickPosX", "", "getLastTickPosX", "()D", "lastTickPosY", "getLastTickPosY", "lastTickPosZ", "getLastTickPosZ", "lookVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "getLookVec", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "motionX", "getMotionX", "setMotionX", "(D)V", "motionY", "getMotionY", "setMotionY", "motionZ", "getMotionZ", "setMotionZ", "name", "", "getName", "()Ljava/lang/String;", "noClip", "getNoClip", "setNoClip", "onGround", "getOnGround", "setOnGround", "posX", "getPosX", "posY", "getPosY", "setPosY", "posZ", "getPosZ", "position", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getPosition", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "positionVector", "getPositionVector", "prevPosX", "getPrevPosX", "prevPosY", "getPrevPosY", "prevPosZ", "getPrevPosZ", "ridingEntity", "getRidingEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "rotationPitch", "getRotationPitch", "setRotationPitch", "rotationYaw", "getRotationYaw", "setRotationYaw", "sneaking", "isSneaking", "sprinting", "getSprinting", "setSprinting", "stepHeight", "getStepHeight", "setStepHeight", "ticksExisted", "getTicksExisted", "uniqueID", "Ljava/util/UUID;", "getUniqueID", "()Ljava/util/UUID;", "width", "getWidth", "asEntityLivingBase", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "asEntityPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "asEntityTNTPrimed", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityTNTPrimed;", "canBeCollidedWith", "canRiderInteract", "copyLocationAndAnglesFrom", "", "player", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "getDistance", "x", "y", "z", "getDistanceSq", "blockPos", "getDistanceSqToEntity", "it", "getDistanceToEntity", "getLook", "partialTicks", "getPositionEyes", "isInsideOfMaterial", "material", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "moveEntity", "rayTrace", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "range", "setPosition", "setPositionAndRotation", "oldX", "oldY", "oldZ", "setPositionAndUpdate", "XSJClient"})
public interface IEntity {
  float getDistanceWalkedOnStepModified();
  
  void setDistanceWalkedOnStepModified(float paramFloat);
  
  float getDistanceWalkedModified();
  
  void setDistanceWalkedModified(float paramFloat);
  
  @JvmName(name = "isSneaking")
  boolean isSneaking();
  
  float getStepHeight();
  
  void setStepHeight(float paramFloat);
  
  @NotNull
  IEnumFacing getHorizontalFacing();
  
  @Nullable
  WVec3 getLookVec();
  
  boolean isDead();
  
  void setDead(boolean paramBoolean);
  
  boolean isCollidedVertically();
  
  boolean isCollidedHorizontally();
  
  boolean isAirBorne();
  
  void setAirBorne(boolean paramBoolean);
  
  int getHurtResistantTime();
  
  boolean getNoClip();
  
  void setNoClip(boolean paramBoolean);
  
  boolean getSprinting();
  
  void setSprinting(boolean paramBoolean);
  
  @NotNull
  WVec3 getPositionVector();
  
  @JvmName(name = "isRiding")
  boolean isRiding();
  
  @NotNull
  WBlockPos getPosition();
  
  @JvmName(name = "isBurning")
  boolean isBurning();
  
  float getFallDistance();
  
  void setFallDistance(float paramFloat);
  
  boolean isInWater();
  
  boolean isInWeb();
  
  void setInWeb(boolean paramBoolean);
  
  boolean isInLava();
  
  float getWidth();
  
  float getHeight();
  
  boolean getOnGround();
  
  void setOnGround(boolean paramBoolean);
  
  @Nullable
  IEntity getRidingEntity();
  
  float getCollisionBorderSize();
  
  double getMotionX();
  
  void setMotionX(double paramDouble);
  
  double getMotionY();
  
  void setMotionY(double paramDouble);
  
  double getMotionZ();
  
  void setMotionZ(double paramDouble);
  
  float getEyeHeight();
  
  @NotNull
  IAxisAlignedBB getEntityBoundingBox();
  
  void setEntityBoundingBox(@NotNull IAxisAlignedBB paramIAxisAlignedBB);
  
  double getPosX();
  
  double getPosY();
  
  void setPosY(double paramDouble);
  
  double getPosZ();
  
  double getLastTickPosX();
  
  double getLastTickPosY();
  
  double getLastTickPosZ();
  
  double getPrevPosX();
  
  double getPrevPosY();
  
  double getPrevPosZ();
  
  float getRotationYaw();
  
  void setRotationYaw(float paramFloat);
  
  float getRotationPitch();
  
  void setRotationPitch(float paramFloat);
  
  int getEntityId();
  
  @Nullable
  IIChatComponent getDisplayName();
  
  @NotNull
  UUID getUniqueID();
  
  @Nullable
  String getName();
  
  int getTicksExisted();
  
  @JvmName(name = "isEntityAlive")
  boolean isEntityAlive();
  
  @JvmName(name = "isInvisible")
  boolean isInvisible();
  
  @NotNull
  WVec3 getPositionEyes(float paramFloat);
  
  boolean canBeCollidedWith();
  
  boolean canRiderInteract();
  
  void moveEntity(double paramDouble1, double paramDouble2, double paramDouble3);
  
  float getDistanceToEntity(@NotNull IEntity paramIEntity);
  
  double getDistanceSqToEntity(@NotNull IEntity paramIEntity);
  
  @NotNull
  IEntityPlayer asEntityPlayer();
  
  @NotNull
  IEntityLivingBase asEntityLivingBase();
  
  @NotNull
  IEntityTNTPrimed asEntityTNTPrimed();
  
  double getDistance(double paramDouble1, double paramDouble2, double paramDouble3);
  
  void setPosition(double paramDouble1, double paramDouble2, double paramDouble3);
  
  double getDistanceSq(@NotNull WBlockPos paramWBlockPos);
  
  void setPositionAndUpdate(double paramDouble1, double paramDouble2, double paramDouble3);
  
  @Nullable
  IMovingObjectPosition rayTrace(double paramDouble, float paramFloat);
  
  @NotNull
  WVec3 getLook(float paramFloat);
  
  boolean isInsideOfMaterial(@NotNull IMaterial paramIMaterial);
  
  void copyLocationAndAnglesFrom(@NotNull IEntityPlayerSP paramIEntityPlayerSP);
  
  void setPositionAndRotation(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\entity\IEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */