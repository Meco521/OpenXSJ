package net.ccbluex.liquidbounce.api.minecraft.scoreboard;

import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\036\n\002\030\002\n\002\b\002\bf\030\0002\0020\001J\022\020\002\032\004\030\0010\0032\006\020\004\032\0020\005H&J\024\020\006\032\004\030\0010\0072\b\020\b\032\004\030\0010\tH&J\026\020\n\032\b\022\004\022\0020\f0\0132\006\020\r\032\0020\003H&¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "", "getObjectiveInDisplaySlot", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreObjective;", "index", "", "getPlayersTeam", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "name", "", "getSortedScores", "", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScore;", "objective", "XSJClient"})
public interface IScoreboard {
  @Nullable
  ITeam getPlayersTeam(@Nullable String paramString);
  
  @Nullable
  IScoreObjective getObjectiveInDisplaySlot(int paramInt);
  
  @NotNull
  Collection<IScore> getSortedScores(@NotNull IScoreObjective paramIScoreObjective);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\scoreboard\IScoreboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */