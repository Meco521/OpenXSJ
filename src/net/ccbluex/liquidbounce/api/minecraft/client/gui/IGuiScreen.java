package net.ccbluex.liquidbounce.api.minecraft.client.gui;

import java.util.List;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.inventory.IGuiChest;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.inventory.IGuiContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000P\n\002\030\002\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\006\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\006\bf\030\0002\0020\001J\b\020\021\032\0020\022H&J\b\020\023\032\0020\024H&J\b\020\025\032\0020\026H&J\020\020\027\032\0020\0302\006\020\031\032\0020\fH&J\b\020\032\032\0020\030H&J \020\033\032\0020\0302\006\020\034\032\0020\f2\006\020\035\032\0020\f2\006\020\036\032\0020\037H&J\b\020 \032\0020\030H&J\030\020!\032\0020\0302\006\020\"\032\0020#2\006\020$\032\0020\fH&J \020%\032\0020\0302\006\020\034\032\0020\f2\006\020\035\032\0020\f2\006\020&\032\0020\fH&J \020'\032\0020\0302\006\020\034\032\0020\f2\006\020\035\032\0020\f2\006\020(\032\0020\fH&R\030\020\002\032\b\022\004\022\0020\0040\003X¦\004¢\006\006\032\004\b\005\020\006R\022\020\007\032\0020\bX¦\004¢\006\006\032\004\b\t\020\nR\022\020\013\032\0020\fX¦\004¢\006\006\032\004\b\r\020\016R\022\020\017\032\0020\fX¦\004¢\006\006\032\004\b\020\020\016¨\006)"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGui;", "buttonList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "getButtonList", "()Ljava/util/List;", "fontRendererObj", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "getFontRendererObj", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "height", "", "getHeight", "()I", "width", "getWidth", "asGuiChest", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;", "asGuiContainer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiContainer;", "asGuiGameOver", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiGameOver;", "drawBackground", "", "i", "drawDefaultBackground", "superDrawScreen", "mouseX", "mouseY", "partialTicks", "", "superHandleMouseInput", "superKeyTyped", "typedChar", "", "keyCode", "superMouseClicked", "mouseButton", "superMouseReleased", "state", "XSJClient"})
public interface IGuiScreen extends IGui {
  int getWidth();
  
  int getHeight();
  
  @NotNull
  IFontRenderer getFontRendererObj();
  
  @NotNull
  List<IGuiButton> getButtonList();
  
  @NotNull
  IGuiContainer asGuiContainer();
  
  @NotNull
  IGuiGameOver asGuiGameOver();
  
  @NotNull
  IGuiChest asGuiChest();
  
  void superMouseReleased(int paramInt1, int paramInt2, int paramInt3);
  
  void drawBackground(int paramInt);
  
  void drawDefaultBackground();
  
  void superKeyTyped(char paramChar, int paramInt);
  
  void superHandleMouseInput();
  
  void superMouseClicked(int paramInt1, int paramInt2, int paramInt3);
  
  void superDrawScreen(int paramInt1, int paramInt2, float paramFloat);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\gui\IGuiScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */