package net.ccbluex.liquidbounce.api.minecraft.client.settings;

import kotlin.Metadata;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\007\n\002\020\002\n\000\bf\030\0002\0020\001J\020\020\r\032\0020\0162\006\020\005\032\0020\006H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\002\020\004R\022\020\005\032\0020\006X¦\004¢\006\006\032\004\b\007\020\bR\030\020\t\032\0020\003X¦\016¢\006\f\032\004\b\n\020\004\"\004\b\013\020\f¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "", "isKeyDown", "", "()Z", "keyCode", "", "getKeyCode", "()I", "pressed", "getPressed", "setPressed", "(Z)V", "onTick", "", "XSJClient"})
public interface IKeyBinding {
  int getKeyCode();
  
  boolean getPressed();
  
  void setPressed(boolean paramBoolean);
  
  boolean isKeyDown();
  
  void onTick(int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\settings\IKeyBinding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */