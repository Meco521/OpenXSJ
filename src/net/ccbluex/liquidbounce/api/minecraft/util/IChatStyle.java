package net.ccbluex.liquidbounce.api.minecraft.util;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.event.IClickEvent;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\bf\030\0002\0020\001R\032\020\002\032\004\030\0010\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\032\020\b\032\004\030\0010\tX¦\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR\030\020\016\032\0020\017X¦\016¢\006\f\032\004\b\020\020\021\"\004\b\022\020\023¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/IChatStyle;", "", "chatClickEvent", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;", "getChatClickEvent", "()Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;", "setChatClickEvent", "(Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;)V", "color", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "getColor", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "setColor", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;)V", "underlined", "", "getUnderlined", "()Z", "setUnderlined", "(Z)V", "XSJClient"})
public interface IChatStyle {
  @Nullable
  IClickEvent getChatClickEvent();
  
  void setChatClickEvent(@Nullable IClickEvent paramIClickEvent);
  
  boolean getUnderlined();
  
  void setUnderlined(boolean paramBoolean);
  
  @Nullable
  WEnumChatFormatting getColor();
  
  void setColor(@Nullable WEnumChatFormatting paramWEnumChatFormatting);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\IChatStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */