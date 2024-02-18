package net.ccbluex.liquidbounce.api.minecraft.network.play.client;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\005\n\002\020\007\n\002\b\b\n\002\020\006\n\002\b\016\bf\030\0002\0020\001R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\030\020\b\032\0020\tX¦\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR\032\020\016\032\0020\0038gX¦\016¢\006\f\032\004\b\017\020\005\"\004\b\020\020\007R\030\020\021\032\0020\022X¦\016¢\006\f\032\004\b\023\020\024\"\004\b\025\020\026R\030\020\027\032\0020\022X¦\016¢\006\f\032\004\b\030\020\024\"\004\b\031\020\026R\030\020\032\032\0020\tX¦\016¢\006\f\032\004\b\033\020\013\"\004\b\034\020\rR\030\020\035\032\0020\022X¦\016¢\006\f\032\004\b\036\020\024\"\004\b\037\020\026¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "onGround", "", "getOnGround", "()Z", "setOnGround", "(Z)V", "pitch", "", "getPitch", "()F", "setPitch", "(F)V", "rotating", "isRotating", "setRotating", "x", "", "getX", "()D", "setX", "(D)V", "y", "getY", "setY", "yaw", "getYaw", "setYaw", "z", "getZ", "setZ", "XSJClient"})
public interface ICPacketPlayer extends IPacket {
  double getX();
  
  void setX(double paramDouble);
  
  double getY();
  
  void setY(double paramDouble);
  
  double getZ();
  
  void setZ(double paramDouble);
  
  float getYaw();
  
  void setYaw(float paramFloat);
  
  float getPitch();
  
  void setPitch(float paramFloat);
  
  boolean getOnGround();
  
  void setOnGround(boolean paramBoolean);
  
  @JvmName(name = "isRotating")
  boolean isRotating();
  
  void setRotating(boolean paramBoolean);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\client\ICPacketPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */