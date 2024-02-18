/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\033\032\0020\0342\b\020\035\032\004\030\0010\036H\002R\026\020\005\032\004\030\0010\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R\026\020\021\032\004\030\0010\0228VX\004¢\006\006\032\004\b\023\020\024R\024\020\025\032\0020\0268VX\004¢\006\006\032\004\b\027\020\030R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\031\020\032¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/NetworkPlayerInfoImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;", "wrapped", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "(Lnet/minecraft/client/network/NetworkPlayerInfo;)V", "displayName", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "getDisplayName", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "getGameProfile", "()Lcom/mojang/authlib/GameProfile;", "locationSkin", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "getLocationSkin", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "playerTeam", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "getPlayerTeam", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "responseTime", "", "getResponseTime", "()I", "getWrapped", "()Lnet/minecraft/client/network/NetworkPlayerInfo;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class NetworkPlayerInfoImpl implements INetworkPlayerInfo {
/*    */   @NotNull
/*    */   private final NetworkPlayerInfo wrapped;
/*    */   
/*    */   @NotNull
/* 11 */   public final NetworkPlayerInfo getWrapped() { return this.wrapped; } public NetworkPlayerInfoImpl(@NotNull NetworkPlayerInfo wrapped) { this.wrapped = wrapped; }
/*    */   public int getResponseTime() { return this.wrapped.func_178853_c(); } @NotNull
/* 13 */   public IResourceLocation getLocationSkin() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178837_g(), "wrapped.locationSkin"); ResourceLocation $this$wrap$iv = this.wrapped.func_178837_g(); int $i$f$wrap = 0; return 
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
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 30 */       new ResourceLocationImpl($this$wrap$iv); }
/* 31 */   @NotNull public GameProfile getGameProfile() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178845_a(), "wrapped.gameProfile"); return this.wrapped.func_178845_a(); } @Nullable public ITeam getPlayerTeam() { Team $this$wrap$iv = (Team)this.wrapped.func_178850_i(); int $i$f$wrap = 0; this.wrapped.func_178850_i(); return (this.wrapped.func_178850_i() != null) ? new TeamImpl($this$wrap$iv) : null; } @Nullable public IIChatComponent getDisplayName() { ITextComponent $this$wrap$iv = this.wrapped.func_178854_k(); int $i$f$wrap = 0; this.wrapped.func_178854_k();
/* 32 */     return (this.wrapped.func_178854_k() != null) ? new IChatComponentImpl($this$wrap$iv) : null; }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof NetworkPlayerInfoImpl && Intrinsics.areEqual(((NetworkPlayerInfoImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\NetworkPlayerInfoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */