package net.ccbluex.liquidbounce.api.minecraft.inventory;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\002\bf\030\0002\0020\001J\020\020\006\032\0020\0072\006\020\b\032\0020\003H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "", "windowId", "", "getWindowId", "()I", "getSlot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "id", "XSJClient"})
public interface IContainer {
  int getWindowId();
  
  @NotNull
  ISlot getSlot(int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\inventory\IContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */