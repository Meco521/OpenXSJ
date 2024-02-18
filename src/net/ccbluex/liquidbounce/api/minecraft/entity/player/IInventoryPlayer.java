package net.ccbluex.liquidbounce.api.minecraft.entity.player;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import net.ccbluex.liquidbounce.api.util.IWrappedArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\r\bf\030\0002\0020\001J\022\020\021\032\004\030\0010\0042\006\020\022\032\0020\bH&J\n\020\023\032\004\030\0010\004H&J\022\020\024\032\004\030\0010\0042\006\020\022\032\0020\bH&R\032\020\002\032\n\022\006\022\004\030\0010\0040\003X¦\004¢\006\006\032\004\b\005\020\006R\030\020\007\032\0020\bX¦\016¢\006\f\032\004\b\t\020\n\"\004\b\013\020\fR\032\020\r\032\n\022\006\022\004\030\0010\0040\003X¦\004¢\006\006\032\004\b\016\020\006R\032\020\017\032\n\022\006\022\004\030\0010\0040\003X¦\004¢\006\006\032\004\b\020\020\006¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;", "", "armorInventory", "Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getArmorInventory", "()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;", "currentItem", "", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "mainInventory", "getMainInventory", "offHandInventory", "getOffHandInventory", "armorItemInSlot", "slot", "getCurrentItemInHand", "getStackInSlot", "XSJClient"})
public interface IInventoryPlayer {
  @NotNull
  IWrappedArray<IItemStack> getMainInventory();
  
  @NotNull
  IWrappedArray<IItemStack> getArmorInventory();
  
  int getCurrentItem();
  
  void setCurrentItem(int paramInt);
  
  @NotNull
  IWrappedArray<IItemStack> getOffHandInventory();
  
  @Nullable
  IItemStack getStackInSlot(int paramInt);
  
  @Nullable
  IItemStack armorItemInSlot(int paramInt);
  
  @Nullable
  IItemStack getCurrentItemInHand();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\entity\player\IInventoryPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */