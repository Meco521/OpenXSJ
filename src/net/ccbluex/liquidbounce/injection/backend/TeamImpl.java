/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\016\n\002\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002J\020\020\017\032\0020\0202\006\020\021\032\0020\020H\026J\020\020\022\032\0020\f2\006\020\023\032\0020\001H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/TeamImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "wrapped", "Lnet/minecraft/scoreboard/Team;", "(Lnet/minecraft/scoreboard/Team;)V", "chatFormat", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "getChatFormat", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "getWrapped", "()Lnet/minecraft/scoreboard/Team;", "equals", "", "other", "", "formatString", "", "name", "isSameTeam", "team", "XSJClient"})
/*    */ public final class TeamImpl implements ITeam {
/*    */   @NotNull
/*    */   private final Team wrapped;
/*    */   
/*    */   @NotNull
/* 10 */   public final Team getWrapped() { return this.wrapped; } public TeamImpl(@NotNull Team wrapped) { this.wrapped = wrapped; }
/*    */   @NotNull
/* 12 */   public WEnumChatFormatting getChatFormat() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.scoreboard.ScorePlayerTeam");  Intrinsics.checkExpressionValueIsNotNull(((ScorePlayerTeam)this.wrapped).func_178775_l(), "(wrapped as ScorePlayerTeam).color"); TextFormatting $this$wrap$iv = ((ScorePlayerTeam)this.wrapped).func_178775_l(); int $i$f$wrap = 0;
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
/* 25 */     switch (BackendExtentionsKt.WhenMappings.$EnumSwitchMapping$3[$this$wrap$iv.ordinal()]) { case 1: 
/*    */       case 2: 
/*    */       case 3: 
/*    */       case 4: 
/*    */       case 5: 
/*    */       case 6: 
/*    */       case 7: 
/*    */       case 8: 
/*    */       case 9: 
/*    */       case 10: 
/*    */       case 11: 
/*    */       case 12: 
/*    */       case 13: 
/*    */       case 14: 
/*    */       case 15: 
/*    */       case 16: 
/*    */       case 17: 
/*    */       case 18: 
/*    */       case 19: 
/*    */       case 20: 
/*    */       case 21: 
/*    */       case 22:
/* 47 */        }  throw new NoWhenBranchMatchedException(); }
/* 48 */   @NotNull public String formatString(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_142053_d(name), "wrapped.formatString(name)"); return this.wrapped.func_142053_d(name); } public boolean isSameTeam(@NotNull ITeam team) { Intrinsics.checkParameterIsNotNull(team, "team"); ITeam iTeam = team; Team team1 = this.wrapped; int $i$f$unwrap = 0; Team team2 = ((TeamImpl)iTeam).getWrapped(); return team1.func_142054_a(team2); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof TeamImpl && Intrinsics.areEqual(((TeamImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\TeamImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */