package net.ccbluex.liquidbounce.injection.implementations;

import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;

public interface IMixinGuiContainer {
  void publicHandleMouseClick(Slot paramSlot, int paramInt1, int paramInt2, ClickType paramClickType);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\implementations\IMixinGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */