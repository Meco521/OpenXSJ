package net.ccbluex.liquidbounce.api.minecraft.client.gui;

import kotlin.Metadata;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\020\002\n\002\b\003\n\002\020\007\n\002\b\003\n\002\020\013\n\002\b\f\bf\030\0002\0020\001J \020\b\032\0020\t2\006\020\n\032\0020\0032\006\020\013\032\0020\0032\006\020\f\032\0020\rH&J(\020\016\032\0020\t2\006\020\017\032\0020\0032\006\020\020\032\0020\0212\006\020\022\032\0020\0032\006\020\023\032\0020\003H&J\b\020\024\032\0020\tH&J\030\020\025\032\0020\t2\006\020\026\032\0020\0032\006\020\027\032\0020\003H&J\020\020\030\032\0020\t2\006\020\031\032\0020\003H&J\020\020\032\032\0020\t2\006\020\033\032\0020\021H&J\020\020\034\032\0020\t2\006\020\006\032\0020\003H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\003X¦\004¢\006\006\032\004\b\007\020\005¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiSlot;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGui;", "slotHeight", "", "getSlotHeight", "()I", "width", "getWidth", "drawScreen", "", "mouseX", "mouseY", "partialTicks", "", "elementClicked", "index", "doubleClick", "", "var3", "var4", "handleMouseInput", "registerScrollButtons", "down", "up", "scrollBy", "value", "setEnableScissor", "flag", "setListWidth", "XSJClient"})
public interface IGuiSlot extends IGui {
  int getWidth();
  
  int getSlotHeight();
  
  void scrollBy(int paramInt);
  
  void registerScrollButtons(int paramInt1, int paramInt2);
  
  void drawScreen(int paramInt1, int paramInt2, float paramFloat);
  
  void elementClicked(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
  
  void handleMouseInput();
  
  void setListWidth(int paramInt);
  
  void setEnableScissor(boolean paramBoolean);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\gui\IGuiSlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */