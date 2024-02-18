package net.ccbluex.liquidbounce.api.minecraft.world;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.scoreboard.IScoreboard;
import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
import net.ccbluex.liquidbounce.api.minecraft.world.border.IWorldBorder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000f\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\036\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\005\bf\030\0002\0020\001J\020\020\r\032\0020\0032\006\020\016\032\0020\017H&J\020\020\020\032\0020\0212\006\020\022\032\0020\023H&J\030\020\024\032\0020\0252\006\020\026\032\0020\0272\006\020\030\032\0020\027H&J\036\020\031\032\b\022\004\022\0020\0170\0322\006\020\033\032\0020\0342\006\020\035\032\0020\017H&J\026\020\036\032\b\022\004\022\0020\0170\0322\006\020\035\032\0020\017H&J6\020\037\032\b\022\004\022\0020\0340\0322\b\020 \032\004\030\0010\0342\006\020!\032\0020\0172\024\020\"\032\020\022\006\022\004\030\0010\034\022\004\022\0020\0030#H&J \020$\032\b\022\004\022\0020\0340\0322\b\020\033\032\004\030\0010\0342\006\020\035\032\0020\017H&J\022\020%\032\004\030\0010\0342\006\020&\032\0020\027H&J\032\020'\032\004\030\0010(2\006\020)\032\0020*2\006\020+\032\0020*H&J\"\020'\032\004\030\0010(2\006\020)\032\0020*2\006\020+\032\0020*2\006\020,\032\0020\003H&J2\020'\032\004\030\0010(2\006\020)\032\0020*2\006\020+\032\0020*2\006\020,\032\0020\0032\006\020-\032\0020\0032\006\020.\032\0020\003H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\002\020\004R\022\020\005\032\0020\006X¦\004¢\006\006\032\004\b\007\020\bR\022\020\t\032\0020\nX¦\004¢\006\006\032\004\b\013\020\f¨\006/"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "", "isRemote", "", "()Z", "scoreboard", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "getScoreboard", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "worldBorder", "Lnet/ccbluex/liquidbounce/api/minecraft/world/border/IWorldBorder;", "getWorldBorder", "()Lnet/ccbluex/liquidbounce/api/minecraft/world/border/IWorldBorder;", "checkBlockCollision", "aabb", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "getBlockState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getChunkFromChunkCoords", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IChunk;", "x", "", "z", "getCollidingBoundingBoxes", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "bb", "getCollisionBoxes", "getEntitiesInAABBexcluding", "entityIn", "boundingBox", "predicate", "Lkotlin/Function1;", "getEntitiesWithinAABBExcludingEntity", "getEntityByID", "id", "rayTraceBlocks", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "start", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "end", "stopOnLiquid", "ignoreBlockWithoutBoundingBox", "returnLastUncollidableBlock", "XSJClient"})
public interface IWorld {
  boolean isRemote();
  
  @NotNull
  IScoreboard getScoreboard();
  
  @NotNull
  IWorldBorder getWorldBorder();
  
  @Nullable
  IEntity getEntityByID(int paramInt);
  
  @Nullable
  IMovingObjectPosition rayTraceBlocks(@NotNull WVec3 paramWVec31, @NotNull WVec3 paramWVec32);
  
  @Nullable
  IMovingObjectPosition rayTraceBlocks(@NotNull WVec3 paramWVec31, @NotNull WVec3 paramWVec32, boolean paramBoolean);
  
  @Nullable
  IMovingObjectPosition rayTraceBlocks(@NotNull WVec3 paramWVec31, @NotNull WVec3 paramWVec32, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  @NotNull
  Collection<IEntity> getEntitiesInAABBexcluding(@Nullable IEntity paramIEntity, @NotNull IAxisAlignedBB paramIAxisAlignedBB, @NotNull Function1<? super IEntity, Boolean> paramFunction1);
  
  @NotNull
  IIBlockState getBlockState(@NotNull WBlockPos paramWBlockPos);
  
  @NotNull
  Collection<IEntity> getEntitiesWithinAABBExcludingEntity(@Nullable IEntity paramIEntity, @NotNull IAxisAlignedBB paramIAxisAlignedBB);
  
  @NotNull
  Collection<IAxisAlignedBB> getCollidingBoundingBoxes(@NotNull IEntity paramIEntity, @NotNull IAxisAlignedBB paramIAxisAlignedBB);
  
  boolean checkBlockCollision(@NotNull IAxisAlignedBB paramIAxisAlignedBB);
  
  @NotNull
  Collection<IAxisAlignedBB> getCollisionBoxes(@NotNull IAxisAlignedBB paramIAxisAlignedBB);
  
  @NotNull
  IChunk getChunkFromChunkCoords(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\world\IWorld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */