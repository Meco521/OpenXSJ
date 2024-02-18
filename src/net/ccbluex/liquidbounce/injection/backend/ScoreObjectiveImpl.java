/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\022H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ScoreObjectiveImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreObjective;", "wrapped", "Lnet/minecraft/scoreboard/ScoreObjective;", "(Lnet/minecraft/scoreboard/ScoreObjective;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "scoreboard", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "getScoreboard", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScoreboard;", "getWrapped", "()Lnet/minecraft/scoreboard/ScoreObjective;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class ScoreObjectiveImpl implements IScoreObjective {
/*    */   @NotNull
/*  8 */   public final ScoreObjective getWrapped() { return this.wrapped; } @NotNull private final ScoreObjective wrapped; public ScoreObjectiveImpl(@NotNull ScoreObjective wrapped) { this.wrapped = wrapped; }
/*    */   @NotNull
/* 10 */   public String getDisplayName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_96678_d(), "wrapped.displayName"); return this.wrapped.func_96678_d(); } @NotNull
/*    */   public IScoreboard getScoreboard() {
/* 12 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_96682_a(), "wrapped.scoreboard"); Scoreboard $this$wrap$iv = this.wrapped.func_96682_a(); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 22 */       new ScoreboardImpl($this$wrap$iv);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof ScoreObjectiveImpl && Intrinsics.areEqual(((ScoreObjectiveImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ScoreObjectiveImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */