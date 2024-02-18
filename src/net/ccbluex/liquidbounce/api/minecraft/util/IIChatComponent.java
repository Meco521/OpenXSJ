package net.ccbluex.liquidbounce.api.minecraft.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\005\n\002\020\002\n\002\b\004\bf\030\0002\0020\001J\020\020\f\032\0020\r2\006\020\016\032\0020\000H&J\020\020\017\032\0020\r2\006\020\020\032\0020\007H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\007X¦\004¢\006\006\032\004\b\013\020\t¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "", "chatStyle", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IChatStyle;", "getChatStyle", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IChatStyle;", "formattedText", "", "getFormattedText", "()Ljava/lang/String;", "unformattedText", "getUnformattedText", "appendSibling", "", "component", "appendText", "text", "XSJClient"})
public interface IIChatComponent {
  @NotNull
  String getUnformattedText();
  
  @NotNull
  IChatStyle getChatStyle();
  
  @NotNull
  String getFormattedText();
  
  void appendText(@NotNull String paramString);
  
  void appendSibling(@NotNull IIChatComponent paramIIChatComponent);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\IIChatComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */