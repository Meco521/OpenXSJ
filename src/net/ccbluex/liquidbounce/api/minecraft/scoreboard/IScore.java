package net.ccbluex.liquidbounce.api.minecraft.scoreboard;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\003\n\002\020\b\n\002\b\003\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScore;", "", "playerName", "", "getPlayerName", "()Ljava/lang/String;", "scorePoints", "", "getScorePoints", "()I", "XSJClient"})
public interface IScore {
  int getScorePoints();
  
  @NotNull
  String getPlayerName();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\scoreboard\IScore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */