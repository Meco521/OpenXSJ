/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\013\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\020\032\0020\0062\b\020\021\032\004\030\0010\022H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\0068VX\004¢\006\006\032\004\b\t\020\bR$\020\013\032\0020\0062\006\020\n\032\0020\0068V@VX\016¢\006\f\032\004\b\013\020\b\"\004\b\f\020\rR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\016\020\017¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/PlayerCapabilitiesImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;", "wrapped", "Lnet/minecraft/entity/player/PlayerCapabilities;", "(Lnet/minecraft/entity/player/PlayerCapabilities;)V", "allowFlying", "", "getAllowFlying", "()Z", "isCreativeMode", "value", "isFlying", "setFlying", "(Z)V", "getWrapped", "()Lnet/minecraft/entity/player/PlayerCapabilities;", "equals", "other", "", "XSJClient"})
/*    */ public final class PlayerCapabilitiesImpl implements IPlayerCapabilities {
/*    */   @NotNull
/*  7 */   public final PlayerCapabilities getWrapped() { return this.wrapped; } @NotNull private final PlayerCapabilities wrapped; public PlayerCapabilitiesImpl(@NotNull PlayerCapabilities wrapped) { this.wrapped = wrapped; }
/*    */    public boolean getAllowFlying() {
/*  9 */     return this.wrapped.field_75101_c;
/*    */   } public boolean isFlying() {
/* 11 */     return this.wrapped.field_75100_b;
/*    */   } public void setFlying(boolean value) {
/* 13 */     this.wrapped.field_75100_b = value;
/*    */   }
/*    */   public boolean isCreativeMode() {
/* 16 */     return this.wrapped.field_75098_d;
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 19 */     return (other instanceof PlayerCapabilitiesImpl && Intrinsics.areEqual(((PlayerCapabilitiesImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\PlayerCapabilitiesImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */