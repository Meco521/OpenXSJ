package net.ccbluex.liquidbounce.api.minecraft.network.play.client;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "slotId", "", "getSlotId", "()I", "XSJClient"})
public interface ICPacketHeldItemChange extends IPacket {
  int getSlotId();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\client\ICPacketHeldItemChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */