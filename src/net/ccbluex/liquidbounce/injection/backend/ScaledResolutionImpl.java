/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\022H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\0068VX\004¢\006\006\032\004\b\n\020\bR\024\020\013\032\0020\0068VX\004¢\006\006\032\004\b\f\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ScaledResolutionImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;", "wrapped", "Lnet/minecraft/client/gui/ScaledResolution;", "(Lnet/minecraft/client/gui/ScaledResolution;)V", "scaleFactor", "", "getScaleFactor", "()I", "scaledHeight", "getScaledHeight", "scaledWidth", "getScaledWidth", "getWrapped", "()Lnet/minecraft/client/gui/ScaledResolution;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class ScaledResolutionImpl implements IScaledResolution {
/*    */   @NotNull
/*  7 */   public final ScaledResolution getWrapped() { return this.wrapped; } @NotNull private final ScaledResolution wrapped; public ScaledResolutionImpl(@NotNull ScaledResolution wrapped) { this.wrapped = wrapped; }
/*    */    public int getScaledWidth() {
/*  9 */     return this.wrapped.func_78326_a();
/*    */   } public int getScaledHeight() {
/* 11 */     return this.wrapped.func_78328_b();
/*    */   } public int getScaleFactor() {
/* 13 */     return this.wrapped.func_78325_e();
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 17 */     return (other instanceof ScaledResolutionImpl && Intrinsics.areEqual(((ScaledResolutionImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ScaledResolutionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */