package net.ccbluex.liquidbounce.api.minecraft.network.play.server;

import kotlin.Metadata;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\r\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\030\020\006\032\0020\003X¦\016¢\006\f\032\004\b\007\020\005\"\004\b\b\020\tR\030\020\n\032\0020\003X¦\016¢\006\f\032\004\b\013\020\005\"\004\b\f\020\tR\030\020\r\032\0020\003X¦\016¢\006\f\032\004\b\016\020\005\"\004\b\017\020\t¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;", "", "entityID", "", "getEntityID", "()I", "motionX", "getMotionX", "setMotionX", "(I)V", "motionY", "getMotionY", "setMotionY", "motionZ", "getMotionZ", "setMotionZ", "XSJClient"})
public interface ISPacketEntityVelocity {
  int getMotionX();
  
  void setMotionX(int paramInt);
  
  int getMotionY();
  
  void setMotionY(int paramInt);
  
  int getMotionZ();
  
  void setMotionZ(int paramInt);
  
  int getEntityID();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\server\ISPacketEntityVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */