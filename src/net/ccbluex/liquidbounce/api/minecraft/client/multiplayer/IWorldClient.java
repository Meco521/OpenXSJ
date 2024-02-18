package net.ccbluex.liquidbounce.api.minecraft.client.multiplayer;

import java.util.Collection;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
import net.minecraft.block.state.IBlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\002\b\002\bf\030\0002\0020\001J\030\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\004H&J\020\020\022\032\0020\0162\006\020\017\032\0020\020H&J \020\023\032\0020\0162\006\020\017\032\0020\0202\006\020\024\032\0020\0252\006\020\026\032\0020\020H&J\b\020\027\032\0020\016H&J$\020\030\032\0020\0312\b\020\024\032\004\030\0010\0252\b\020\032\032\004\030\0010\0332\006\020\034\032\0020\020H&R\030\020\002\032\b\022\004\022\0020\0040\003X¦\004¢\006\006\032\004\b\005\020\006R\030\020\007\032\b\022\004\022\0020\b0\003X¦\004¢\006\006\032\004\b\t\020\006R\030\020\n\032\b\022\004\022\0020\0130\003X¦\004¢\006\006\032\004\b\f\020\006¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "loadedEntityList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getLoadedEntityList", "()Ljava/util/Collection;", "loadedTileEntityList", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "getLoadedTileEntityList", "playerEntities", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "getPlayerEntities", "addEntityToWorld", "", "entityId", "", "fakePlayer", "removeEntityFromWorld", "sendBlockBreakProgress", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "damage", "sendQuittingDisconnectingPacket", "setBlockState", "", "blockstate", "Lnet/minecraft/block/state/IBlockState;", "size", "XSJClient"})
public interface IWorldClient extends IWorld {
  @NotNull
  Collection<IEntityPlayer> getPlayerEntities();
  
  @NotNull
  Collection<IEntity> getLoadedEntityList();
  
  @NotNull
  Collection<ITileEntity> getLoadedTileEntityList();
  
  void sendQuittingDisconnectingPacket();
  
  void sendBlockBreakProgress(int paramInt1, @NotNull WBlockPos paramWBlockPos, int paramInt2);
  
  void addEntityToWorld(int paramInt, @NotNull IEntity paramIEntity);
  
  void removeEntityFromWorld(int paramInt);
  
  boolean setBlockState(@Nullable WBlockPos paramWBlockPos, @Nullable IBlockState paramIBlockState, int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\multiplayer\IWorldClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */