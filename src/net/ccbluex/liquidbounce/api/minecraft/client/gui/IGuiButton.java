package net.ccbluex.liquidbounce.api.minecraft.client.gui;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\005\n\002\020\013\n\002\b\005\n\002\020\b\n\002\b\003\bf\030\0002\0020\001R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\030\020\b\032\0020\tX¦\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR\022\020\016\032\0020\017X¦\004¢\006\006\032\004\b\020\020\021¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGui;", "displayString", "", "getDisplayString", "()Ljava/lang/String;", "setDisplayString", "(Ljava/lang/String;)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "id", "", "getId", "()I", "XSJClient"})
public interface IGuiButton extends IGui {
  @NotNull
  String getDisplayString();
  
  void setDisplayString(@NotNull String paramString);
  
  int getId();
  
  boolean getEnabled();
  
  void setEnabled(boolean paramBoolean);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\gui\IGuiButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */