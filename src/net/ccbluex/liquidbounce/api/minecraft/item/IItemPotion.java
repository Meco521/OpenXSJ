package net.ccbluex.liquidbounce.api.minecraft.item;

import java.util.Collection;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.potion.IPotionEffect;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\026\020\002\032\b\022\004\022\0020\0040\0032\006\020\005\032\0020\006H&¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemPotion;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getEffects", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "XSJClient"})
public interface IItemPotion extends IItem {
  @NotNull
  Collection<IPotionEffect> getEffects(@NotNull IItemStack paramIItemStack);
  
  @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
  public static final class DefaultImpls {
    @NotNull
    public static IItem getItemByID(IItemPotion $this, int id) {
      return IItem.DefaultImpls.getItemByID($this, id);
    }
  }
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\item\IItemPotion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */