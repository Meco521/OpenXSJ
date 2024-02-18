package net.ccbluex.liquidbounce.api.minecraft.world;

import java.util.List;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\020\001\n\002\b\002\bf\030\0002\0020\001J\020\020\b\032\0020\t2\006\020\n\032\0020\013H&J0\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\0020\0240\0232\b\020\025\032\004\030\0010\026H&J\030\020\027\032\0020\0032\006\020\002\032\0020\0032\006\020\006\032\0020\003H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\003X¦\004¢\006\006\032\004\b\007\020\005¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/world/IChunk;", "", "x", "", "getX", "()I", "z", "getZ", "getBlockState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getEntitiesWithinAABBForEntity", "", "thePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "arrowBox", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "collidedEntities", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "nothing", "", "getHeightValue", "XSJClient"})
public interface IChunk {
  int getX();
  
  int getZ();
  
  void getEntitiesWithinAABBForEntity(@NotNull IEntityPlayerSP paramIEntityPlayerSP, @NotNull IAxisAlignedBB paramIAxisAlignedBB, @NotNull List<IEntity> paramList, @Nullable Void paramVoid);
  
  int getHeightValue(int paramInt1, int paramInt2);
  
  @NotNull
  IIBlockState getBlockState(@NotNull WBlockPos paramWBlockPos);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\world\IChunk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */