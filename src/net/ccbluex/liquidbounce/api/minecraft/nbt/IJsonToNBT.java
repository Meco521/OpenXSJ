package net.ccbluex.liquidbounce.api.minecraft.nbt;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/nbt/IJsonToNBT;", "", "getTagFromJson", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "s", "", "XSJClient"})
public interface IJsonToNBT {
  @NotNull
  INBTTagCompound getTagFromJson(@NotNull String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\nbt\IJsonToNBT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */