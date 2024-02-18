package net.ccbluex.liquidbounce.api.minecraft.network.handshake.client;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.network.IEnumConnectionState;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\005\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\003\bf\030\0002\0020\001R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\022\020\b\032\0020\tX¦\004¢\006\006\032\004\b\n\020\013R\022\020\f\032\0020\rX¦\004¢\006\006\032\004\b\016\020\017¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/handshake/client/ICPacketHandshake;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "ip", "", "getIp", "()Ljava/lang/String;", "setIp", "(Ljava/lang/String;)V", "port", "", "getPort", "()I", "requestedState", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IEnumConnectionState;", "getRequestedState", "()Lnet/ccbluex/liquidbounce/api/minecraft/network/IEnumConnectionState;", "XSJClient"})
public interface ICPacketHandshake extends IPacket {
  int getPort();
  
  @NotNull
  String getIp();
  
  void setIp(@NotNull String paramString);
  
  @NotNull
  IEnumConnectionState getRequestedState();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\handshake\client\ICPacketHandshake.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */