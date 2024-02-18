package net.ccbluex.liquidbounce.api.minecraft.item;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "XSJClient"})
public interface IItemBlock extends IItem {
  @NotNull
  IBlock getBlock();
  
  @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
  public static final class DefaultImpls {
    @NotNull
    public static IItem getItemByID(IItemBlock $this, int id) {
      return IItem.DefaultImpls.getItemByID($this, id);
    }
  }
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\item\IItemBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */