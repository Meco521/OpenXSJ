package net.ccbluex.liquidbounce.api.minecraft.client.gui.inventory;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
import net.ccbluex.liquidbounce.api.minecraft.inventory.IContainer;
import net.ccbluex.liquidbounce.api.minecraft.inventory.ISlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\bf\030\0002\0020\001J(\020\006\032\0020\0072\006\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\0132\006\020\r\032\0020\013H&R\024\020\002\032\004\030\0010\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiContainer;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "inventorySlots", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "getInventorySlots", "()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "handleMouseClick", "", "slot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "slotNumber", "", "clickedButton", "clickType", "XSJClient"})
public interface IGuiContainer extends IGuiScreen {
  void handleMouseClick(@NotNull ISlot paramISlot, int paramInt1, int paramInt2, int paramInt3);
  
  @Nullable
  IContainer getInventorySlots();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\gui\inventory\IGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */