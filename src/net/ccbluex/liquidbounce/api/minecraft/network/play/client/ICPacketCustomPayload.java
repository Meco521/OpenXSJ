package net.ccbluex.liquidbounce.api.minecraft.network.play.client;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
import net.ccbluex.liquidbounce.api.network.IPacketBuffer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\005\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\030\020\006\032\0020\007X¦\016¢\006\f\032\004\b\b\020\t\"\004\b\n\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCustomPayload;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "channelName", "", "getChannelName", "()Ljava/lang/String;", "data", "Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "getData", "()Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "setData", "(Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;)V", "XSJClient"})
public interface ICPacketCustomPayload extends IPacket {
  @NotNull
  IPacketBuffer getData();
  
  void setData(@NotNull IPacketBuffer paramIPacketBuffer);
  
  @NotNull
  String getChannelName();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\client\ICPacketCustomPayload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */