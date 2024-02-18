package net.ccbluex.liquidbounce.api.minecraft.inventory;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\003\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\003\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\004\030\0010\013X¦\004¢\006\006\032\004\b\f\020\r¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "", "hasStack", "", "getHasStack", "()Z", "slotNumber", "", "getSlotNumber", "()I", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getStack", "()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "XSJClient"})
public interface ISlot {
  int getSlotNumber();
  
  @Nullable
  IItemStack getStack();
  
  boolean getHasStack();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\inventory\ISlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */