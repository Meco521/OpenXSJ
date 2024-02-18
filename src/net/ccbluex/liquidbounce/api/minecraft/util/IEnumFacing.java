package net.ccbluex.liquidbounce.api.minecraft.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\006\bf\030\0002\0020\001J\b\020\r\032\0020\016H&J\b\020\017\032\0020\016H&J\b\020\020\032\0020\016H&J\b\020\021\032\0020\016H&J\b\020\022\032\0020\016H&J\b\020\023\032\0020\016H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\000X¦\004¢\006\006\032\004\b\013\020\f¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "", "axisOrdinal", "", "getAxisOrdinal", "()I", "directionVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "getDirectionVec", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "opposite", "getOpposite", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "isDown", "", "isEast", "isNorth", "isSouth", "isUp", "isWest", "XSJClient"})
public interface IEnumFacing {
  boolean isNorth();
  
  boolean isSouth();
  
  boolean isEast();
  
  boolean isWest();
  
  boolean isUp();
  
  boolean isDown();
  
  @NotNull
  IEnumFacing getOpposite();
  
  @NotNull
  WVec3i getDirectionVec();
  
  int getAxisOrdinal();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\IEnumFacing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */