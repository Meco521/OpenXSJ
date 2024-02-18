/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\t\n\002\b\013\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\033\032\0020\0342\b\020\035\032\004\030\0010\036H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0068VX\004¢\006\006\032\004\b\016\020\bR\024\020\017\032\0020\0068VX\004¢\006\006\032\004\b\020\020\bR\024\020\021\032\0020\0068VX\004¢\006\006\032\004\b\022\020\bR\024\020\023\032\0020\0068VX\004¢\006\006\032\004\b\024\020\bR\024\020\025\032\0020\0268VX\004¢\006\006\032\004\b\027\020\030R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\031\020\032¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ServerDataImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "wrapped", "Lnet/minecraft/client/multiplayer/ServerData;", "(Lnet/minecraft/client/multiplayer/ServerData;)V", "gameVersion", "", "getGameVersion", "()Ljava/lang/String;", "pingToServer", "", "getPingToServer", "()J", "populationInfo", "getPopulationInfo", "serverIP", "getServerIP", "serverMOTD", "getServerMOTD", "serverName", "getServerName", "version", "", "getVersion", "()I", "getWrapped", "()Lnet/minecraft/client/multiplayer/ServerData;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class ServerDataImpl implements IServerData {
/*    */   @NotNull
/*  7 */   public final ServerData getWrapped() { return this.wrapped; } @NotNull private final ServerData wrapped; public ServerDataImpl(@NotNull ServerData wrapped) { this.wrapped = wrapped; }
/*    */    public long getPingToServer() {
/*  9 */     return this.wrapped.field_78844_e;
/*    */   }
/* 11 */   public int getVersion() { return this.wrapped.field_82821_f; }
/*    */   @NotNull
/* 13 */   public String getGameVersion() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_82822_g, "wrapped.gameVersion"); return this.wrapped.field_82822_g; }
/*    */   @NotNull
/* 15 */   public String getServerMOTD() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_78843_d, "wrapped.serverMOTD"); return this.wrapped.field_78843_d; }
/*    */   @NotNull
/* 17 */   public String getPopulationInfo() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_78846_c, "wrapped.populationInfo"); return this.wrapped.field_78846_c; }
/*    */   @NotNull
/* 19 */   public String getServerName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_78847_a, "wrapped.serverName"); return this.wrapped.field_78847_a; } @NotNull
/*    */   public String getServerIP() {
/* 21 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_78845_b, "wrapped.serverIP"); return this.wrapped.field_78845_b;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 25 */     return (other instanceof ServerDataImpl && Intrinsics.areEqual(((ServerDataImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ServerDataImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */