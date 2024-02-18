package net.ccbluex.liquidbounce.api.minecraft.client.gui;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\005\n\002\020\016\n\002\b\007\n\002\020\002\n\002\b\002\n\002\020\f\n\002\b\b\bf\030\0002\0020\001J\b\020\025\032\0020\026H&J\030\020\027\032\0020\0032\006\020\030\032\0020\0312\006\020\032\032\0020\bH&J \020\033\032\0020\0262\006\020\034\032\0020\b2\006\020\035\032\0020\b2\006\020\036\032\0020\bH&J\030\020\037\032\0020\0032\006\020\030\032\0020\0312\006\020\032\032\0020\bH&J\b\020 \032\0020\026H&R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\002\020\004\"\004\b\005\020\006R\030\020\007\032\0020\bX¦\016¢\006\f\032\004\b\t\020\n\"\004\b\013\020\fR\030\020\r\032\0020\016X¦\016¢\006\f\032\004\b\017\020\020\"\004\b\021\020\022R\022\020\023\032\0020\bX¦\004¢\006\006\032\004\b\024\020\n¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiTextField;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGui;", "isFocused", "", "()Z", "setFocused", "(Z)V", "maxStringLength", "", "getMaxStringLength", "()I", "setMaxStringLength", "(I)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "xPosition", "getXPosition", "drawTextBox", "", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseX", "mouseY", "mouseButton", "textboxKeyTyped", "updateCursorCounter", "XSJClient"})
public interface IGuiTextField extends IGui {
  int getXPosition();
  
  @NotNull
  String getText();
  
  void setText(@NotNull String paramString);
  
  boolean isFocused();
  
  void setFocused(boolean paramBoolean);
  
  int getMaxStringLength();
  
  void setMaxStringLength(int paramInt);
  
  void updateCursorCounter();
  
  boolean textboxKeyTyped(char paramChar, int paramInt);
  
  void drawTextBox();
  
  void mouseClicked(int paramInt1, int paramInt2, int paramInt3);
  
  boolean keyTyped(char paramChar, int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\gui\IGuiTextField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */