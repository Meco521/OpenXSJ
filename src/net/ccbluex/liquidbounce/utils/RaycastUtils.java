/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\006\n\000\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001:\001\fB\007\b\002¢\006\002\020\002J(\020\003\032\004\030\0010\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\b2\006\020\n\032\0020\013J\032\020\003\032\004\030\0010\0042\006\020\005\032\0020\0062\006\020\n\032\0020\013H\007¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/RaycastUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "raycastEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "range", "", "yaw", "", "pitch", "entityFilter", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "EntityFilter", "XSJClient"})
/*    */ public final class RaycastUtils extends MinecraftInstance {
/*    */   static {
/*  9 */     RaycastUtils raycastUtils = new RaycastUtils();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final RaycastUtils INSTANCE;
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H&¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*    */   public static interface EntityFilter
/*    */   {
/*    */     boolean canRaycast(@Nullable IEntity param1IEntity);
/*    */   }
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "invoke"})
/*    */   static final class RaycastUtils$raycastEntity$entityList$1
/*    */     extends Lambda
/*    */     implements Function1<IEntity, Boolean>
/*    */   {
/*    */     public static final RaycastUtils$raycastEntity$entityList$1 INSTANCE = new RaycastUtils$raycastEntity$entityList$1();
/*    */     
/*    */     public final boolean invoke(@Nullable IEntity it) {
/* 31 */       return (it != null && (!MinecraftInstance.classProvider.isEntityPlayer(it) || !it.asEntityPlayer().isSpectator()) && it.canBeCollidedWith());
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     RaycastUtils$raycastEntity$entityList$1() {
/*    */       super(1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   @Nullable
/*    */   public static final IEntity raycastEntity(double range, @NotNull EntityFilter entityFilter) {
/*    */     Intrinsics.checkParameterIsNotNull(entityFilter, "entityFilter");
/*    */     return INSTANCE.raycastEntity(range, RotationUtils.serverRotation.getYaw(), RotationUtils.serverRotation.getPitch(), entityFilter);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public final IEntity raycastEntity(double range, float yaw, float pitch, @NotNull EntityFilter entityFilter) {
/*    */     Intrinsics.checkParameterIsNotNull(entityFilter, "entityFilter");
/*    */     IEntity renderViewEntity = MinecraftInstance.mc.getRenderViewEntity();
/*    */     if (renderViewEntity != null && MinecraftInstance.mc.getTheWorld() != null) {
/*    */       double blockReachDistance = range;
/*    */       WVec3 eyePosition = renderViewEntity.getPositionEyes(1.0F);
/*    */       float f1 = -yaw * 0.017453292F - (float)Math.PI;
/*    */       boolean bool1 = false;
/*    */       float yawCos = (float)Math.cos(f1);
/*    */       float f2 = -yaw * 0.017453292F - (float)Math.PI;
/*    */       boolean bool2 = false;
/*    */       float yawSin = (float)Math.sin(f2);
/*    */       double d1 = -pitch * 0.017453292F;
/*    */       boolean bool3 = false;
/*    */       float pitchCos = (float)-Math.cos(d1);
/*    */       double d2 = -pitch * 0.017453292F;
/*    */       boolean bool4 = false;
/*    */       float pitchSin = (float)Math.sin(d2);
/*    */       WVec3 entityLook = new WVec3((yawSin * pitchCos), pitchSin, (yawCos * pitchCos));
/*    */       WVec3 wVec31 = eyePosition;
/*    */       double d3 = entityLook.getXCoord() * blockReachDistance, d4 = entityLook.getYCoord() * blockReachDistance, z$iv = entityLook.getZCoord() * blockReachDistance;
/*    */       int $i$f$addVector = 0;
/* 76 */       WVec3 vector = new WVec3(wVec31.getXCoord() + d3, wVec31.getYCoord() + d4, wVec31.getZCoord() + z$iv);
/*    */       if (MinecraftInstance.mc.getTheWorld() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       Collection entityList = MinecraftInstance.mc.getTheWorld().getEntitiesInAABBexcluding(renderViewEntity, renderViewEntity.getEntityBoundingBox().addCoord(entityLook.getXCoord() * blockReachDistance, entityLook.getYCoord() * blockReachDistance, entityLook.getZCoord() * blockReachDistance).expand(1.0D, 1.0D, 1.0D), RaycastUtils$raycastEntity$entityList$1.INSTANCE);
/*    */       IEntity pointedEntity = (IEntity)null;
/*    */       for (IEntity entity : entityList) {
/*    */         if (!entityFilter.canRaycast(entity))
/*    */           continue; 
/*    */         double collisionBorderSize = entity.getCollisionBorderSize();
/*    */         IAxisAlignedBB axisAlignedBB = entity.getEntityBoundingBox().expand(collisionBorderSize, collisionBorderSize, collisionBorderSize);
/*    */         IMovingObjectPosition movingObjectPosition = axisAlignedBB.calculateIntercept(eyePosition, vector);
/*    */         if (axisAlignedBB.isVecInside(eyePosition)) {
/*    */           if (blockReachDistance >= 0.0D) {
/*    */             IEntity iEntity = entity;
/*    */             blockReachDistance = 0.0D;
/*    */           } 
/*    */           continue;
/*    */         } 
/*    */         if (movingObjectPosition != null) {
/*    */           double eyeDistance = eyePosition.distanceTo(movingObjectPosition.getHitVec());
/*    */           if (eyeDistance < blockReachDistance || blockReachDistance == 0.0D) {
/*    */             if (Intrinsics.areEqual(entity, renderViewEntity.getRidingEntity()) && !renderViewEntity.canRiderInteract()) {
/*    */               if (blockReachDistance == 0.0D)
/*    */                 pointedEntity = entity; 
/*    */               continue;
/*    */             } 
/*    */             pointedEntity = entity;
/*    */             blockReachDistance = eyeDistance;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       return pointedEntity;
/*    */     } 
/*    */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\RaycastUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */