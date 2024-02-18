package net.ccbluex.liquidbounce.api.network;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\020\022\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\016\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\020\020\006\032\0020\0032\006\020\007\032\0020\bH&J\020\020\t\032\0020\0002\006\020\n\032\0020\013H&¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "", "writeBytes", "", "payload", "", "writeItemStackToBuffer", "itemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "writeString", "vanilla", "", "XSJClient"})
public interface IPacketBuffer {
  void writeBytes(@NotNull byte[] paramArrayOfbyte);
  
  void writeItemStackToBuffer(@NotNull IItemStack paramIItemStack);
  
  @NotNull
  IPacketBuffer writeString(@NotNull String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\network\IPacketBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */