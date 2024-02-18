/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.scoreboard.IScore;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.scoreboard.IScoreObjective;
/*    */ import net.minecraft.scoreboard.Score;
/*    */ import net.minecraft.scoreboard.Scoreboard;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\036\n\002\030\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002J\022\020\013\032\004\030\0010\f2\006\020\r\032\0020\016H\026J\024\020\017\032\004\030\0010\0202\b\020\021\032\004\030\0010\022H\026J\026\020\023\032\b\022\004\022\0020\0250\0242\006\020\026\032\0020\fH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ScoreboardImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "wrapped", "Lnet/minecraft/scoreboard/Scoreboard;", "(Lnet/minecraft/scoreboard/Scoreboard;)V", "getWrapped", "()Lnet/minecraft/scoreboard/Scoreboard;", "equals", "", "other", "", "getObjectiveInDisplaySlot", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreObjective;", "index", "", "getPlayersTeam", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "name", "", "getSortedScores", "", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScore;", "objective", "XSJClient"})
/*    */ public final class ScoreboardImpl implements IScoreboard {
/*    */   @NotNull
/* 12 */   public final Scoreboard getWrapped() { return this.wrapped; } @NotNull private final Scoreboard wrapped; public ScoreboardImpl(@NotNull Scoreboard wrapped) { this.wrapped = wrapped; } @Nullable
/* 13 */   public ITeam getPlayersTeam(@Nullable String name) { Team $this$wrap$iv = (Team)this.wrapped.func_96509_i(name); int $i$f$wrap = 0; this.wrapped.func_96509_i(name); return (this.wrapped.func_96509_i(name) != null) ? 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 26 */       new TeamImpl($this$wrap$iv) : null; } @Nullable public IScoreObjective getObjectiveInDisplaySlot(int index) { ScoreObjective $this$wrap$iv = this.wrapped.func_96539_a(index); int $i$f$wrap = 0; this.wrapped.func_96539_a(index);
/* 27 */     return (this.wrapped.func_96539_a(index) != null) ? new ScoreObjectiveImpl($this$wrap$iv) : null; } @NotNull public Collection<IScore> getSortedScores(@NotNull IScoreObjective objective) { Intrinsics.checkParameterIsNotNull(objective, "objective"); IScoreObjective iScoreObjective = objective; Scoreboard scoreboard = this.wrapped; int $i$f$unwrap = 0;
/* 28 */     ScoreObjective scoreObjective = ((ScoreObjectiveImpl)iScoreObjective).getWrapped(); ScoreboardImpl$getSortedScores$2 scoreboardImpl$getSortedScores$2 = ScoreboardImpl$getSortedScores$2.INSTANCE; ScoreboardImpl$getSortedScores$1 scoreboardImpl$getSortedScores$1 = ScoreboardImpl$getSortedScores$1.INSTANCE; Collection collection = scoreboard.func_96534_i(scoreObjective);
/*    */     return (Collection<IScore>)new WrappedCollection(collection, scoreboardImpl$getSortedScores$1, scoreboardImpl$getSortedScores$2); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof ScoreboardImpl && Intrinsics.areEqual(((ScoreboardImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ScoreboardImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */