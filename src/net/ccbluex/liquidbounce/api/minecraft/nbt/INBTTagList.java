package net.ccbluex.liquidbounce.api.minecraft.nbt;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\002\b\002\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\001H&J\020\020\005\032\0020\0062\006\020\007\032\0020\bH&J\b\020\t\032\0020\nH&J\b\020\013\032\0020\bH&¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "appendTag", "", "createNBTTagString", "getCompoundTagAt", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "index", "", "hasNoTags", "", "tagCount", "XSJClient"})
public interface INBTTagList extends INBTBase {
  boolean hasNoTags();
  
  int tagCount();
  
  @NotNull
  INBTTagCompound getCompoundTagAt(int paramInt);
  
  void appendTag(@NotNull INBTBase paramINBTBase);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\nbt\INBTTagList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */