package net.ccbluex.liquidbounce.api.minecraft.client.network;

import java.util.Collection;
import java.util.UUID;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.INetworkManager;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\036\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\013\032\0020\f2\006\020\r\032\0020\016H&J\022\020\017\032\004\030\0010\b2\006\020\020\032\0020\021H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\030\020\006\032\b\022\004\022\0020\b0\007X¦\004¢\006\006\032\004\b\t\020\n¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "", "networkManager", "Lnet/ccbluex/liquidbounce/api/minecraft/INetworkManager;", "getNetworkManager", "()Lnet/ccbluex/liquidbounce/api/minecraft/INetworkManager;", "playerInfoMap", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;", "getPlayerInfoMap", "()Ljava/util/Collection;", "addToSendQueue", "", "classProviderCPacketHeldItemChange", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "getPlayerInfo", "uuid", "Ljava/util/UUID;", "XSJClient"})
public interface IINetHandlerPlayClient {
  @NotNull
  INetworkManager getNetworkManager();
  
  @NotNull
  Collection<INetworkPlayerInfo> getPlayerInfoMap();
  
  @Nullable
  INetworkPlayerInfo getPlayerInfo(@NotNull UUID paramUUID);
  
  void addToSendQueue(@NotNull IPacket paramIPacket);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\network\IINetHandlerPlayClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */