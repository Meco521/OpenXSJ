package net.ccbluex.liquidbounce.api.minecraft.item;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\002\020\004¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isFull", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "XSJClient"})
public interface IItemBucket extends IItem {
  @NotNull
  IBlock isFull();
  
  @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
  public static final class DefaultImpls {
    @NotNull
    public static IItem getItemByID(IItemBucket $this, int id) {
      return IItem.DefaultImpls.getItemByID($this, id);
    }
  }
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\item\IItemBucket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */