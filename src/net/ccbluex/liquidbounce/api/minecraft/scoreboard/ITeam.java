package net.ccbluex.liquidbounce.api.minecraft.scoreboard;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.util.WEnumChatFormatting;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\002\n\002\020\013\n\002\b\002\bf\030\0002\0020\001J\020\020\006\032\0020\0072\006\020\b\032\0020\007H&J\020\020\t\032\0020\n2\006\020\013\032\0020\000H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "", "chatFormat", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "getChatFormat", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "formatString", "", "name", "isSameTeam", "", "team", "XSJClient"})
public interface ITeam {
  @NotNull
  WEnumChatFormatting getChatFormat();
  
  @NotNull
  String formatString(@NotNull String paramString);
  
  boolean isSameTeam(@NotNull ITeam paramITeam);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\scoreboard\ITeam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */