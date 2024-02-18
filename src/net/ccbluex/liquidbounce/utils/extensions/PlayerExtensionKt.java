/*    */ package net.ccbluex.liquidbounce.utils.extensions;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.Rotation;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000F\n\000\n\002\020\007\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\006\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\032\026\020\007\032\0020\b2\006\020\t\032\0020\b2\006\020\n\032\0020\013\032\022\020\f\032\0020\r*\0020\0162\006\020\017\032\0020\016\032\n\020\020\032\0020\021*\0020\016\032\n\020\022\032\0020\021*\0020\023\032\n\020\024\032\0020\021*\0020\016\032$\020\025\032\004\030\0010\026*\0020\0162\006\020\027\032\0020\r2\006\020\030\032\0020\0012\006\020\031\032\0020\001\032\034\020\025\032\004\030\0010\026*\0020\0162\006\020\027\032\0020\r2\006\020\032\032\0020\033\032\024\020\034\032\004\030\0010\026*\0020\0162\006\020\027\032\0020\r\"\025\020\000\032\0020\001*\0020\0028F¢\006\006\032\004\b\003\020\004\"\025\020\005\032\0020\001*\0020\0028F¢\006\006\032\004\b\006\020\004¨\006\035"}, d2 = {"hurtPercent", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getHurtPercent", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)F", "renderHurtTime", "getRenderHurtTime", "getNearestPointBB", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "eye", "box", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "getDistanceToEntityBox", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "entity", "isAnimal", "", "isClientFriend", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "isMob", "rayTraceWithCustomRotation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "blockReachDistance", "yaw", "pitch", "rotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "rayTraceWithServerSideRotation", "XSJClient"})
/*    */ public final class PlayerExtensionKt
/*    */ {
/*    */   public static final boolean isAnimal(@NotNull IEntity $this$isAnimal) {
/* 29 */     Intrinsics.checkParameterIsNotNull($this$isAnimal, "$this$isAnimal"); return (MinecraftInstance.classProvider.isEntityAnimal($this$isAnimal) || 
/* 30 */       MinecraftInstance.classProvider.isEntitySquid($this$isAnimal) || 
/* 31 */       MinecraftInstance.classProvider.isEntityGolem($this$isAnimal) || 
/* 32 */       MinecraftInstance.classProvider.isEntityBat($this$isAnimal));
/*    */   }
/*    */   
/*    */   public static final boolean isMob(@NotNull IEntity $this$isMob) {
/* 36 */     Intrinsics.checkParameterIsNotNull($this$isMob, "$this$isMob"); return (MinecraftInstance.classProvider.isEntityMob($this$isMob) || 
/* 37 */       MinecraftInstance.classProvider.isEntityVillager($this$isMob) || 
/* 38 */       MinecraftInstance.classProvider.isEntitySlime($this$isMob) || 
/* 39 */       MinecraftInstance.classProvider.isEntityGhast($this$isMob) || 
/* 40 */       MinecraftInstance.classProvider.isEntityDragon($this$isMob) || 
/* 41 */       MinecraftInstance.classProvider.isEntityShulker($this$isMob));
/*    */   }
/*    */   
/*    */   public static final boolean isClientFriend(@NotNull IEntityPlayer $this$isClientFriend) {
/* 45 */     Intrinsics.checkParameterIsNotNull($this$isClientFriend, "$this$isClientFriend"); if ($this$isClientFriend.getName() != null) { String entityName = $this$isClientFriend.getName();
/*    */       
/* 47 */       return (Retreat.INSTANCE.getFileManager()).friendsConfig.isFriend(ColorUtils.stripColor(entityName)); }
/*    */     
/*    */     $this$isClientFriend.getName();
/*    */     return false; } @Nullable
/* 51 */   public static final IMovingObjectPosition rayTraceWithCustomRotation(@NotNull IEntity $this$rayTraceWithCustomRotation, double blockReachDistance, @NotNull Rotation rotation) { Intrinsics.checkParameterIsNotNull($this$rayTraceWithCustomRotation, "$this$rayTraceWithCustomRotation"); Intrinsics.checkParameterIsNotNull(rotation, "rotation"); return rayTraceWithCustomRotation($this$rayTraceWithCustomRotation, blockReachDistance, rotation.getYaw(), rotation.getPitch()); }
/*    */    @Nullable
/*    */   public static final IMovingObjectPosition rayTraceWithCustomRotation(@NotNull IEntity $this$rayTraceWithCustomRotation, double blockReachDistance, float yaw, float pitch) {
/* 54 */     Intrinsics.checkParameterIsNotNull($this$rayTraceWithCustomRotation, "$this$rayTraceWithCustomRotation"); WVec3 vec3 = $this$rayTraceWithCustomRotation.getPositionEyes(1.0F);
/* 55 */     WVec3 vec31 = ClientUtils.getVectorForRotation(pitch, yaw);
/* 56 */     WVec3 wVec31 = vec3; double d1 = vec31.getXCoord() * blockReachDistance, d2 = vec31.getYCoord() * blockReachDistance, z$iv = vec31.getZCoord() * blockReachDistance; int $i$f$addVector = 0; WVec3 vec32 = 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 85 */       new WVec3(wVec31.getXCoord() + d1, wVec31.getYCoord() + d2, wVec31.getZCoord() + z$iv);
/*    */     if (MinecraftInstance.mc.getTheWorld() == null)
/*    */       Intrinsics.throwNpe(); 
/*    */     return MinecraftInstance.mc.getTheWorld().rayTraceBlocks(vec3, vec32, false, false, true);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static final IMovingObjectPosition rayTraceWithServerSideRotation(@NotNull IEntity $this$rayTraceWithServerSideRotation, double blockReachDistance) {
/*    */     Intrinsics.checkParameterIsNotNull($this$rayTraceWithServerSideRotation, "$this$rayTraceWithServerSideRotation");
/*    */     Intrinsics.checkExpressionValueIsNotNull(RotationUtils.serverRotation, "RotationUtils.serverRotation");
/*    */     return rayTraceWithCustomRotation($this$rayTraceWithServerSideRotation, blockReachDistance, RotationUtils.serverRotation);
/*    */   }
/*    */   
/*    */   public static final double getDistanceToEntityBox(@NotNull IEntity $this$getDistanceToEntityBox, @NotNull IEntity entity) {
/*    */     Intrinsics.checkParameterIsNotNull($this$getDistanceToEntityBox, "$this$getDistanceToEntityBox");
/*    */     Intrinsics.checkParameterIsNotNull(entity, "entity");
/*    */     WVec3 eyes = $this$getDistanceToEntityBox.getPositionEyes(1.0F);
/*    */     WVec3 pos = getNearestPointBB(eyes, entity.getEntityBoundingBox());
/*    */     double d1 = pos.getXCoord() - eyes.getXCoord();
/*    */     boolean bool1 = false;
/*    */     double xDist = Math.abs(d1);
/*    */     double d2 = pos.getYCoord() - eyes.getYCoord();
/*    */     boolean bool2 = false;
/*    */     double yDist = Math.abs(d2);
/*    */     double d3 = pos.getZCoord() - eyes.getZCoord();
/*    */     byte b = 0;
/*    */     double zDist = Math.abs(d3);
/*    */     d3 = xDist;
/*    */     b = 2;
/*    */     boolean bool3 = false;
/*    */     d3 = yDist;
/*    */     b = 2;
/*    */     double d4 = Math.pow(d3, b);
/*    */     bool3 = false;
/*    */     double d5 = Math.pow(d3, b);
/*    */     d3 = zDist;
/*    */     b = 2;
/*    */     d4 += d5;
/*    */     bool3 = false;
/*    */     d5 = Math.pow(d3, b);
/*    */     d3 = d4 + d5;
/*    */     b = 0;
/*    */     return Math.sqrt(d3);
/*    */   }
/*    */   
/*    */   public static final float getRenderHurtTime(@NotNull IEntityLivingBase $this$renderHurtTime) {
/*    */     Intrinsics.checkParameterIsNotNull($this$renderHurtTime, "$this$renderHurtTime");
/*    */     return $this$renderHurtTime.getHurtTime() - (($this$renderHurtTime.getHurtTime() != 0) ? (Minecraft.func_71410_x()).field_71428_T.field_194147_b : 0.0F);
/*    */   }
/*    */   
/*    */   public static final float getHurtPercent(@NotNull IEntityLivingBase $this$hurtPercent) {
/*    */     Intrinsics.checkParameterIsNotNull($this$hurtPercent, "$this$hurtPercent");
/*    */     return getRenderHurtTime($this$hurtPercent) / 10;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public static final WVec3 getNearestPointBB(@NotNull WVec3 eye, @NotNull IAxisAlignedBB box) {
/*    */     Intrinsics.checkParameterIsNotNull(eye, "eye");
/*    */     Intrinsics.checkParameterIsNotNull(box, "box");
/*    */     double[] origin = { eye.getXCoord(), eye.getYCoord(), eye.getZCoord() };
/*    */     double[] destMins = { box.getMinX(), box.getMinY(), box.getMinZ() };
/*    */     double[] destMaxs = { box.getMaxX(), box.getMaxY(), box.getMaxZ() };
/*    */     for (byte b1 = 0, b2 = 2; b1 <= b2; b1++) {
/*    */       if (origin[b1] > destMaxs[b1]) {
/*    */         origin[b1] = destMaxs[b1];
/*    */       } else if (origin[b1] < destMins[b1]) {
/*    */         origin[b1] = destMins[b1];
/*    */       } 
/*    */     } 
/*    */     return new WVec3(origin[0], origin[1], origin[2]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\extensions\PlayerExtensionKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */