/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Reflection;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000v\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\036\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\005\b\026\030\000*\b\b\000\020\001*\0020\0022\0020\003B\r\022\006\020\004\032\0028\000¢\006\002\020\005J\020\020\024\032\0020\0072\006\020\025\032\0020\026H\026J\023\020\027\032\0020\0072\b\020\030\032\004\030\0010\031H\002J\020\020\032\032\0020\0332\006\020\034\032\0020\035H\026J\030\020\036\032\0020\0372\006\020 \032\0020!2\006\020\"\032\0020!H\026J\036\020#\032\b\022\004\022\0020\0260$2\006\020%\032\0020&2\006\020'\032\0020\026H\026J\026\020(\032\b\022\004\022\0020\0260$2\006\020'\032\0020\026H\026J6\020)\032\b\022\004\022\0020&0$2\b\020*\032\004\030\0010&2\006\020+\032\0020\0262\024\020,\032\020\022\006\022\004\030\0010&\022\004\022\0020\0070-H\026J \020.\032\b\022\004\022\0020&0$2\b\020%\032\004\030\0010&2\006\020'\032\0020\026H\026J\022\020/\032\004\030\0010&2\006\0200\032\0020!H\026J\032\0201\032\004\030\001022\006\0203\032\002042\006\0205\032\00204H\026J\"\0201\032\004\030\001022\006\0203\032\002042\006\0205\032\002042\006\0206\032\0020\007H\026J2\0201\032\004\030\001022\006\0203\032\002042\006\0205\032\002042\006\0206\032\0020\0072\006\0207\032\0020\0072\006\0208\032\0020\007H\026R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\006\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R\023\020\004\032\0028\000¢\006\n\n\002\020\023\032\004\b\021\020\022¨\0069"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/WorldImpl;", "T", "Lnet/minecraft/world/World;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "wrapped", "(Lnet/minecraft/world/World;)V", "isRemote", "", "()Z", "scoreboard", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "getScoreboard", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "worldBorder", "Lnet/ccbluex/liquidbounce/api/minecraft/world/border/IWorldBorder;", "getWorldBorder", "()Lnet/ccbluex/liquidbounce/api/minecraft/world/border/IWorldBorder;", "getWrapped", "()Lnet/minecraft/world/World;", "Lnet/minecraft/world/World;", "checkBlockCollision", "aabb", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "equals", "other", "", "getBlockState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getChunkFromChunkCoords", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IChunk;", "x", "", "z", "getCollidingBoundingBoxes", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "bb", "getCollisionBoxes", "getEntitiesInAABBexcluding", "entityIn", "boundingBox", "predicate", "Lkotlin/Function1;", "getEntitiesWithinAABBExcludingEntity", "getEntityByID", "id", "rayTraceBlocks", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "start", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "end", "stopOnLiquid", "ignoreBlockWithoutBoundingBox", "returnLastUncollidableBlock", "XSJClient"})
/*    */ public class WorldImpl<T extends World> implements IWorld {
/*    */   @NotNull
/* 20 */   public final T getWrapped() { return this.wrapped; } @NotNull private final T wrapped; public WorldImpl(@NotNull World wrapped) { this.wrapped = (T)wrapped; }
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
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\024\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\0020\001\"\b\b\000\020\002*\0020\0032\b\020\004\032\004\030\0010\005H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "T", "Lnet/minecraft/world/World;", "it", "Lnet/minecraft/entity/Entity;", "apply"})
/*    */   static final class WorldImpl$getEntitiesInAABBexcluding$1<T>
/*    */     implements Predicate<Entity>
/*    */   {
/*    */     public final boolean apply(@Nullable Entity it)
/*    */     {
/* 39 */       Entity entity = it; Function1 function1 = this.$predicate; int $i$f$wrap = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 75 */       EntityImpl<Entity> entityImpl = new EntityImpl<>(entity); return ((Boolean)this.$predicate.invoke((it != null) ? entityImpl : null)).booleanValue(); } WorldImpl$getEntitiesInAABBexcluding$1(Function1 param1Function1) {} } public boolean isRemote() { return ((World)this.wrapped).field_72995_K; } @NotNull public IScoreboard getScoreboard() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_96441_U(), "wrapped.scoreboard"); Scoreboard $this$wrap$iv = this.wrapped.func_96441_U(); int $i$f$wrap = 0; return new ScoreboardImpl($this$wrap$iv); } @NotNull public IWorldBorder getWorldBorder() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_175723_af(), "wrapped.worldBorder"); WorldBorder $this$wrap$iv = this.wrapped.func_175723_af(); int $i$f$wrap = 0;
/* 76 */     return new WorldBorderImpl($this$wrap$iv); } @Nullable public IEntity getEntityByID(int id) { Entity $this$wrap$iv = this.wrapped.func_73045_a(id); int $i$f$wrap = 0; this.wrapped.func_73045_a(id);
/* 77 */     return (this.wrapped.func_73045_a(id) != null) ? new EntityImpl<>($this$wrap$iv) : null; } @Nullable public IMovingObjectPosition rayTraceBlocks(@NotNull WVec3 start, @NotNull WVec3 end) { Intrinsics.checkParameterIsNotNull(start, "start"); Intrinsics.checkParameterIsNotNull(end, "end"); WVec3 wVec31 = start; T t = this.wrapped; int $i$f$unwrap = 0;
/* 78 */     Vec3d vec3d1 = new Vec3d(wVec31.getXCoord(), wVec31.getYCoord(), wVec31.getZCoord()); WVec3 $this$unwrap$iv = end; vec3d1 = vec3d1; t = t; $i$f$unwrap = 0;
/* 79 */     Vec3d vec3d2 = new Vec3d($this$unwrap$iv.getXCoord(), $this$unwrap$iv.getYCoord(), $this$unwrap$iv.getZCoord()); RayTraceResult $this$wrap$iv = t.func_72933_a(vec3d1, vec3d2); int $i$f$wrap = 0; t.func_72933_a(vec3d1, vec3d2); return (t.func_72933_a(vec3d1, vec3d2) != null) ? 
/* 80 */       new MovingObjectPositionImpl($this$wrap$iv) : null; } @Nullable public IMovingObjectPosition rayTraceBlocks(@NotNull WVec3 start, @NotNull WVec3 end, boolean stopOnLiquid) { Intrinsics.checkParameterIsNotNull(start, "start"); Intrinsics.checkParameterIsNotNull(end, "end"); WVec3 wVec31 = start; T t = this.wrapped; int $i$f$unwrap = 0;
/* 81 */     Vec3d vec3d1 = new Vec3d(wVec31.getXCoord(), wVec31.getYCoord(), wVec31.getZCoord()); WVec3 $this$unwrap$iv = end; vec3d1 = vec3d1; t = t; $i$f$unwrap = 0;
/* 82 */     Vec3d vec3d2 = new Vec3d($this$unwrap$iv.getXCoord(), $this$unwrap$iv.getYCoord(), $this$unwrap$iv.getZCoord()); RayTraceResult $this$wrap$iv = t.func_72901_a(vec3d1, vec3d2, stopOnLiquid); int $i$f$wrap = 0; t.func_72901_a(vec3d1, vec3d2, stopOnLiquid); return (t.func_72901_a(vec3d1, vec3d2, stopOnLiquid) != null) ? 
/* 83 */       new MovingObjectPositionImpl($this$wrap$iv) : null; } @Nullable public IMovingObjectPosition rayTraceBlocks(@NotNull WVec3 start, @NotNull WVec3 end, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock) { Intrinsics.checkParameterIsNotNull(start, "start"); Intrinsics.checkParameterIsNotNull(end, "end"); WVec3 wVec31 = start; T t = this.wrapped; int $i$f$unwrap = 0;
/* 84 */     Vec3d vec3d1 = new Vec3d(wVec31.getXCoord(), wVec31.getYCoord(), wVec31.getZCoord()); WVec3 $this$unwrap$iv = end; vec3d1 = vec3d1; t = t; $i$f$unwrap = 0;
/* 85 */     Vec3d vec3d2 = new Vec3d($this$unwrap$iv.getXCoord(), $this$unwrap$iv.getYCoord(), $this$unwrap$iv.getZCoord()); RayTraceResult $this$wrap$iv = t.func_147447_a(vec3d1, vec3d2, stopOnLiquid, ignoreBlockWithoutBoundingBox, returnLastUncollidableBlock); int $i$f$wrap = 0; t.func_147447_a(vec3d1, vec3d2, stopOnLiquid, ignoreBlockWithoutBoundingBox, returnLastUncollidableBlock); return (t.func_147447_a(vec3d1, vec3d2, stopOnLiquid, ignoreBlockWithoutBoundingBox, returnLastUncollidableBlock) != null) ? 
/* 86 */       new MovingObjectPositionImpl($this$wrap$iv) : null; } @NotNull public Collection<IEntity> getEntitiesInAABBexcluding(@Nullable IEntity entityIn, @NotNull IAxisAlignedBB boundingBox, @NotNull Function1 predicate) { Intrinsics.checkParameterIsNotNull(boundingBox, "boundingBox"); Intrinsics.checkParameterIsNotNull(predicate, "predicate"); IEntity iEntity = entityIn; T t = this.wrapped; int $i$f$unwrap = 0;
/* 87 */     if (iEntity == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityImpl<*>");  Entity entity = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); IAxisAlignedBB iAxisAlignedBB = boundingBox; entity = (Entity)((entityIn != null) ? entity : null); t = this.wrapped; $i$f$unwrap = 0;
/* 88 */     AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); WorldImpl$getEntitiesInAABBexcluding$3 worldImpl$getEntitiesInAABBexcluding$3 = WorldImpl$getEntitiesInAABBexcluding$3.INSTANCE; WorldImpl$getEntitiesInAABBexcluding$2 worldImpl$getEntitiesInAABBexcluding$2 = WorldImpl$getEntitiesInAABBexcluding$2.INSTANCE; List list = t.func_175674_a(entity, axisAlignedBB, new WorldImpl$getEntitiesInAABBexcluding$1(predicate)); return (Collection<IEntity>)new WrappedCollection(list, worldImpl$getEntitiesInAABBexcluding$2, worldImpl$getEntitiesInAABBexcluding$3); } @NotNull public IIBlockState getBlockState(@NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); WBlockPos wBlockPos = blockPos; T t = this.wrapped; int $i$f$unwrap = 0;
/* 89 */     BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); Intrinsics.checkExpressionValueIsNotNull(t.func_180495_p(blockPos1), "wrapped.getBlockState(blockPos.unwrap())"); IBlockState $this$wrap$iv = t.func_180495_p(blockPos1); int $i$f$wrap = 0;
/* 90 */     return new IBlockStateImpl($this$wrap$iv); } @NotNull public Collection<IEntity> getEntitiesWithinAABBExcludingEntity(@Nullable IEntity entity, @NotNull IAxisAlignedBB bb) { Intrinsics.checkParameterIsNotNull(bb, "bb"); IEntity iEntity = entity; T t = this.wrapped; int $i$f$unwrap = 0;
/* 91 */     if (iEntity == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityImpl<*>");  Entity entity1 = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); IAxisAlignedBB iAxisAlignedBB = bb; entity1 = (Entity)((entity != null) ? entity1 : null); t = this.wrapped; $i$f$unwrap = 0;
/* 92 */     AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); WorldImpl$getEntitiesWithinAABBExcludingEntity$2 worldImpl$getEntitiesWithinAABBExcludingEntity$2 = WorldImpl$getEntitiesWithinAABBExcludingEntity$2.INSTANCE; WorldImpl$getEntitiesWithinAABBExcludingEntity$1 worldImpl$getEntitiesWithinAABBExcludingEntity$1 = WorldImpl$getEntitiesWithinAABBExcludingEntity$1.INSTANCE; List list = t.func_72839_b(entity1, axisAlignedBB); return (Collection<IEntity>)new WrappedCollection(list, worldImpl$getEntitiesWithinAABBExcludingEntity$1, worldImpl$getEntitiesWithinAABBExcludingEntity$2); } @NotNull public Collection<IAxisAlignedBB> getCollidingBoundingBoxes(@NotNull IEntity entity, @NotNull IAxisAlignedBB bb) { Intrinsics.checkParameterIsNotNull(entity, "entity"); Intrinsics.checkParameterIsNotNull(bb, "bb"); IEntity iEntity = entity; T t = this.wrapped; int $i$f$unwrap = 0;
/* 93 */     Entity entity1 = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); IAxisAlignedBB iAxisAlignedBB = bb; entity1 = entity1; t = t; $i$f$unwrap = 0;
/* 94 */     AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); WorldImpl$getCollidingBoundingBoxes$2 worldImpl$getCollidingBoundingBoxes$2 = WorldImpl$getCollidingBoundingBoxes$2.INSTANCE; WorldImpl$getCollidingBoundingBoxes$1 worldImpl$getCollidingBoundingBoxes$1 = WorldImpl$getCollidingBoundingBoxes$1.INSTANCE; List list = t.func_184144_a(entity1, axisAlignedBB); return (Collection<IAxisAlignedBB>)new WrappedCollection(list, worldImpl$getCollidingBoundingBoxes$1, worldImpl$getCollidingBoundingBoxes$2); } public boolean checkBlockCollision(@NotNull IAxisAlignedBB aabb) { Intrinsics.checkParameterIsNotNull(aabb, "aabb"); IAxisAlignedBB iAxisAlignedBB = aabb; T t = this.wrapped; int $i$f$unwrap = 0;
/* 95 */     AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); return t.func_72829_c(axisAlignedBB); } @NotNull public Collection<IAxisAlignedBB> getCollisionBoxes(@NotNull IAxisAlignedBB bb) { Intrinsics.checkParameterIsNotNull(bb, "bb"); IAxisAlignedBB iAxisAlignedBB = bb; Entity entity = null; T t = this.wrapped; int $i$f$unwrap = 0;
/* 96 */     AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); WorldImpl$getCollisionBoxes$2 worldImpl$getCollisionBoxes$2 = WorldImpl$getCollisionBoxes$2.INSTANCE; WorldImpl$getCollisionBoxes$1 worldImpl$getCollisionBoxes$1 = WorldImpl$getCollisionBoxes$1.INSTANCE; List list = t.func_184144_a(entity, axisAlignedBB); return (Collection<IAxisAlignedBB>)new WrappedCollection(list, worldImpl$getCollisionBoxes$1, worldImpl$getCollisionBoxes$2); } @NotNull public IChunk getChunkFromChunkCoords(int x, int z) { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_72964_e(x, z), "wrapped.getChunkFromChunkCoords(x, z)"); Chunk $this$wrap$iv = this.wrapped.func_72964_e(x, z); int $i$f$wrap = 0;
/* 97 */     return new ChunkImpl($this$wrap$iv); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof WorldImpl && Intrinsics.areEqual(((WorldImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\WorldImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */