package net.ccbluex.liquidbounce.api.minecraft.nbt;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\000\n\002\020\n\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\020\b\n\002\b\004\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\020\020\006\032\0020\0072\006\020\004\032\0020\005H&J\030\020\b\032\0020\t2\006\020\n\032\0020\0052\006\020\013\032\0020\fH&J\030\020\r\032\0020\t2\006\020\n\032\0020\0052\006\020\013\032\0020\005H&J\030\020\016\032\0020\t2\006\020\n\032\0020\0052\006\020\017\032\0020\001H&¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "getShort", "", "name", "", "hasKey", "", "setInteger", "", "key", "value", "", "setString", "setTag", "tag", "XSJClient"})
public interface INBTTagCompound extends INBTBase {
  boolean hasKey(@NotNull String paramString);
  
  short getShort(@NotNull String paramString);
  
  void setString(@NotNull String paramString1, @NotNull String paramString2);
  
  void setTag(@NotNull String paramString, @NotNull INBTBase paramINBTBase);
  
  void setInteger(@NotNull String paramString, int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\nbt\INBTTagCompound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */