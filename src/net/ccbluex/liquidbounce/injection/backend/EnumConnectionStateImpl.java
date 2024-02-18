/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\n\032\0020\0062\b\020\013\032\004\030\0010\fH\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\005\020\007R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\t¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EnumConnectionStateImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IEnumConnectionState;", "wrapped", "Lnet/minecraft/network/EnumConnectionState;", "(Lnet/minecraft/network/EnumConnectionState;)V", "isHandshake", "", "()Z", "getWrapped", "()Lnet/minecraft/network/EnumConnectionState;", "equals", "other", "", "XSJClient"})
/*    */ public final class EnumConnectionStateImpl implements IEnumConnectionState {
/*    */   @NotNull
/*  7 */   public final EnumConnectionState getWrapped() { return this.wrapped; } @NotNull private final EnumConnectionState wrapped; public EnumConnectionStateImpl(@NotNull EnumConnectionState wrapped) { this.wrapped = wrapped; }
/*    */    public boolean isHandshake() {
/*  9 */     return (this.wrapped == EnumConnectionState.HANDSHAKING);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 12 */     return (other instanceof EnumConnectionStateImpl && ((EnumConnectionStateImpl)other).wrapped == this.wrapped);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EnumConnectionStateImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */