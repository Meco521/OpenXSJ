/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\b\n\002\b\005\n\002\020\016\n\002\b\b\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\027\032\0020\0062\b\020\030\032\004\030\0010\031H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\n8VX\004¢\006\006\032\004\b\016\020\fR\024\020\017\032\0020\0208VX\004¢\006\006\032\004\b\021\020\022R\024\020\023\032\0020\n8VX\004¢\006\006\032\004\b\024\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\025\020\026¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/PotionImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "wrapped", "Lnet/minecraft/potion/Potion;", "(Lnet/minecraft/potion/Potion;)V", "hasStatusIcon", "", "getHasStatusIcon", "()Z", "id", "", "getId", "()I", "liquidColor", "getLiquidColor", "name", "", "getName", "()Ljava/lang/String;", "statusIconIndex", "getStatusIconIndex", "getWrapped", "()Lnet/minecraft/potion/Potion;", "equals", "other", "", "XSJClient"})
/*    */ public final class PotionImpl implements IPotion {
/*    */   @NotNull
/*  7 */   public final Potion getWrapped() { return this.wrapped; } @NotNull private final Potion wrapped; public PotionImpl(@NotNull Potion wrapped) { this.wrapped = wrapped; }
/*    */    public int getLiquidColor() {
/*  9 */     return this.wrapped.func_76401_j();
/*    */   }
/* 11 */   public int getId() { return Potion.func_188409_a(this.wrapped); } @NotNull
/*    */   public String getName() {
/* 13 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_76393_a(), "wrapped.name"); return this.wrapped.func_76393_a();
/*    */   } public boolean getHasStatusIcon() {
/* 15 */     return this.wrapped.func_76400_d();
/*    */   } public int getStatusIconIndex() {
/* 17 */     return this.wrapped.func_76392_e();
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 20 */     return (other instanceof PotionImpl && Intrinsics.areEqual(((PotionImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\PotionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */