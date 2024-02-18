/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\022H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ScoreImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScore;", "wrapped", "Lnet/minecraft/scoreboard/Score;", "(Lnet/minecraft/scoreboard/Score;)V", "playerName", "", "getPlayerName", "()Ljava/lang/String;", "scorePoints", "", "getScorePoints", "()I", "getWrapped", "()Lnet/minecraft/scoreboard/Score;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class ScoreImpl implements IScore {
/*    */   @NotNull
/*  7 */   public final Score getWrapped() { return this.wrapped; } @NotNull private final Score wrapped; public ScoreImpl(@NotNull Score wrapped) { this.wrapped = wrapped; }
/*    */   
/*  9 */   public int getScorePoints() { return this.wrapped.func_96652_c(); } @NotNull
/*    */   public String getPlayerName() {
/* 11 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_96653_e(), "wrapped.playerName"); return this.wrapped.func_96653_e();
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 15 */     return (other instanceof ScoreImpl && Intrinsics.areEqual(((ScoreImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ScoreImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */