package net.ccbluex.liquidbounce.api.minecraft.world.border;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/world/border/IWorldBorder;", "", "contains", "", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"})
public interface IWorldBorder {
  boolean contains(@NotNull WBlockPos paramWBlockPos);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\world\border\IWorldBorder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */