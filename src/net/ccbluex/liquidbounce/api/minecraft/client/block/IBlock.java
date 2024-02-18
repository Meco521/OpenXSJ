package net.ccbluex.liquidbounce.api.minecraft.client.block;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.block.material.IMaterial;
import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\005\n\002\020\007\n\002\b\005\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\bf\030\0002\0020\001J\032\020\022\032\0020\0232\b\020\024\032\004\030\0010\0032\006\020\025\032\0020\023H&J\"\020\026\032\004\030\0010\0272\006\020\030\032\0020\0312\006\020\032\032\0020\0332\006\020\024\032\0020\003H&J\020\020\034\032\0020\0352\006\020\036\032\0020\000H&J \020\037\032\0020\0352\006\020 \032\0020\0032\006\020!\032\0020\"2\006\020#\032\0020\033H&J\022\020$\032\004\030\0010%2\006\020\024\032\0020\003H&J \020&\032\0020\r2\006\020'\032\0020(2\006\020!\032\0020\0312\006\020)\032\0020\033H&J \020*\032\0020\0272\006\020\030\032\0020\0312\006\020 \032\0020\0032\006\020)\032\0020\033H&J\020\020+\032\0020\0232\006\020\024\032\0020\003H&J\020\020,\032\0020\0232\006\020 \032\0020\003H&J\030\020-\032\0020.2\006\020\030\032\0020\0312\006\020)\032\0020\033H&R\024\020\002\032\004\030\0010\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\007X¦\004¢\006\006\032\004\b\013\020\tR\030\020\f\032\0020\rX¦\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021¨\006/"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "", "defaultState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "getDefaultState", "()Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "localizedName", "", "getLocalizedName", "()Ljava/lang/String;", "registryName", "getRegistryName", "slipperiness", "", "getSlipperiness", "()F", "setSlipperiness", "(F)V", "canCollideCheck", "", "state", "hitIfLiquid", "getCollisionBoundingBox", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "world", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "pos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getIdFromBlock", "", "block", "getMapColor", "blockState", "theWorld", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "bp", "getMaterial", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "getPlayerRelativeBlockHardness", "thePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "blockPos", "getSelectedBoundingBox", "isFullCube", "isTranslucent", "setBlockBoundsBasedOnState", "", "XSJClient"})
public interface IBlock {
  @NotNull
  String getRegistryName();
  
  float getSlipperiness();
  
  void setSlipperiness(float paramFloat);
  
  @Nullable
  IIBlockState getDefaultState();
  
  @NotNull
  String getLocalizedName();
  
  @NotNull
  IAxisAlignedBB getSelectedBoundingBox(@NotNull IWorld paramIWorld, @NotNull IIBlockState paramIIBlockState, @NotNull WBlockPos paramWBlockPos);
  
  @Nullable
  IAxisAlignedBB getCollisionBoundingBox(@NotNull IWorld paramIWorld, @NotNull WBlockPos paramWBlockPos, @NotNull IIBlockState paramIIBlockState);
  
  boolean canCollideCheck(@Nullable IIBlockState paramIIBlockState, boolean paramBoolean);
  
  void setBlockBoundsBasedOnState(@NotNull IWorld paramIWorld, @NotNull WBlockPos paramWBlockPos);
  
  float getPlayerRelativeBlockHardness(@NotNull IEntityPlayerSP paramIEntityPlayerSP, @NotNull IWorld paramIWorld, @NotNull WBlockPos paramWBlockPos);
  
  int getIdFromBlock(@NotNull IBlock paramIBlock);
  
  boolean isTranslucent(@NotNull IIBlockState paramIIBlockState);
  
  int getMapColor(@NotNull IIBlockState paramIIBlockState, @NotNull IWorldClient paramIWorldClient, @NotNull WBlockPos paramWBlockPos);
  
  @Nullable
  IMaterial getMaterial(@NotNull IIBlockState paramIIBlockState);
  
  boolean isFullCube(@NotNull IIBlockState paramIIBlockState);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\block\IBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */