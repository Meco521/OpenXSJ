package net.ccbluex.liquidbounce.api.minecraft.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\020\006\n\002\b\021\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\b\bf\030\0002\0020\001J \020\020\032\0020\0002\006\020\021\032\0020\0032\006\020\022\032\0020\0032\006\020\023\032\0020\003H&J\032\020\024\032\004\030\0010\0252\006\020\026\032\0020\0272\006\020\030\032\0020\027H&J \020\031\032\0020\0002\006\020\021\032\0020\0032\006\020\022\032\0020\0032\006\020\023\032\0020\003H&J\020\020\032\032\0020\0332\006\020\034\032\0020\000H&J\020\020\035\032\0020\0332\006\020\036\032\0020\027H&J \020\037\032\0020\0002\006\020 \032\0020\0032\006\020!\032\0020\0032\006\020\"\032\0020\003H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\003X¦\004¢\006\006\032\004\b\007\020\005R\022\020\b\032\0020\003X¦\004¢\006\006\032\004\b\t\020\005R\022\020\n\032\0020\003X¦\004¢\006\006\032\004\b\013\020\005R\022\020\f\032\0020\003X¦\004¢\006\006\032\004\b\r\020\005R\022\020\016\032\0020\003X¦\004¢\006\006\032\004\b\017\020\005¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "", "maxX", "", "getMaxX", "()D", "maxY", "getMaxY", "maxZ", "getMaxZ", "minX", "getMinX", "minY", "getMinY", "minZ", "getMinZ", "addCoord", "x", "y", "z", "calculateIntercept", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "from", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "to", "expand", "intersectsWith", "", "boundingBox", "isVecInside", "vec", "offset", "sx", "sy", "sz", "XSJClient"})
public interface IAxisAlignedBB {
  @NotNull
  IAxisAlignedBB addCoord(double paramDouble1, double paramDouble2, double paramDouble3);
  
  @NotNull
  IAxisAlignedBB expand(double paramDouble1, double paramDouble2, double paramDouble3);
  
  @Nullable
  IMovingObjectPosition calculateIntercept(@NotNull WVec3 paramWVec31, @NotNull WVec3 paramWVec32);
  
  boolean isVecInside(@NotNull WVec3 paramWVec3);
  
  @NotNull
  IAxisAlignedBB offset(double paramDouble1, double paramDouble2, double paramDouble3);
  
  boolean intersectsWith(@NotNull IAxisAlignedBB paramIAxisAlignedBB);
  
  double getMinX();
  
  double getMinY();
  
  double getMinZ();
  
  double getMaxX();
  
  double getMaxY();
  
  double getMaxZ();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\IAxisAlignedBB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */