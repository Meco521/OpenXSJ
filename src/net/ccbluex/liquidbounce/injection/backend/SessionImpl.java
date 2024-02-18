/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\013\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\025\032\0020\0262\b\020\027\032\004\030\0010\030H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0068VX\004¢\006\006\032\004\b\016\020\bR\024\020\017\032\0020\0068VX\004¢\006\006\032\004\b\020\020\bR\024\020\021\032\0020\0068VX\004¢\006\006\032\004\b\022\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\023\020\024¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SessionImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "wrapped", "Lnet/minecraft/util/Session;", "(Lnet/minecraft/util/Session;)V", "playerId", "", "getPlayerId", "()Ljava/lang/String;", "profile", "Lcom/mojang/authlib/GameProfile;", "getProfile", "()Lcom/mojang/authlib/GameProfile;", "sessionType", "getSessionType", "token", "getToken", "username", "getUsername", "getWrapped", "()Lnet/minecraft/util/Session;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class SessionImpl implements ISession {
/*    */   @NotNull
/*  8 */   public final Session getWrapped() { return this.wrapped; } @NotNull private final Session wrapped; public SessionImpl(@NotNull Session wrapped) { this.wrapped = wrapped; }
/*    */   @NotNull
/* 10 */   public GameProfile getProfile() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_148256_e(), "wrapped.profile"); return this.wrapped.func_148256_e(); }
/*    */   @NotNull
/* 12 */   public String getUsername() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_111285_a(), "wrapped.username"); return this.wrapped.func_111285_a(); }
/*    */   @NotNull
/* 14 */   public String getPlayerId() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_148255_b(), "wrapped.playerID"); return this.wrapped.func_148255_b(); }
/*    */   @NotNull
/* 16 */   public String getSessionType() { return this.wrapped.field_152429_d.name(); } @NotNull
/*    */   public String getToken() {
/* 18 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_148254_d(), "wrapped.token"); return this.wrapped.func_148254_d();
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 22 */     return (other instanceof SessionImpl && Intrinsics.areEqual(((SessionImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SessionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */