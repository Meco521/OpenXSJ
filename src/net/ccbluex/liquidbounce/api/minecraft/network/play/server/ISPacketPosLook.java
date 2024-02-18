package net.ccbluex.liquidbounce.api.minecraft.network.play.server;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\b\bf\030\0002\0020\001R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\030\020\b\032\0020\003X¦\016¢\006\f\032\004\b\t\020\005\"\004\b\n\020\007¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketPosLook;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "pitch", "", "getPitch", "()F", "setPitch", "(F)V", "yaw", "getYaw", "setYaw", "XSJClient"})
public interface ISPacketPosLook extends IPacket {
  float getYaw();
  
  void setYaw(float paramFloat);
  
  float getPitch();
  
  void setPitch(float paramFloat);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\server\ISPacketPosLook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */