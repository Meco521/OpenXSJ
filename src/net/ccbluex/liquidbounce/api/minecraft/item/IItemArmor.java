package net.ccbluex.liquidbounce.api.minecraft.item;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.minecraft.IArmorMaterial;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\004\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\n\032\0020\0072\006\020\013\032\0020\fH&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\t¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemArmor;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "armorMaterial", "Lnet/ccbluex/liquidbounce/api/minecraft/minecraft/IArmorMaterial;", "getArmorMaterial", "()Lnet/ccbluex/liquidbounce/api/minecraft/minecraft/IArmorMaterial;", "armorType", "", "getArmorType", "()I", "getColor", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "XSJClient"})
public interface IItemArmor extends IItem {
  @NotNull
  IArmorMaterial getArmorMaterial();
  
  int getArmorType();
  
  int getColor(@NotNull IItemStack paramIItemStack);
  
  @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
  public static final class DefaultImpls {
    @NotNull
    public static IItem getItemByID(IItemArmor $this, int id) {
      return IItem.DefaultImpls.getItemByID($this, id);
    }
  }
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\item\IItemArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */