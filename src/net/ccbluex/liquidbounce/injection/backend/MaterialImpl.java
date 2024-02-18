/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\n\032\0020\0062\b\020\013\032\004\030\0010\fH\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\005\020\007R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\t¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/MaterialImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "wrapped", "Lnet/minecraft/block/material/Material;", "(Lnet/minecraft/block/material/Material;)V", "isReplaceable", "", "()Z", "getWrapped", "()Lnet/minecraft/block/material/Material;", "equals", "other", "", "XSJClient"})
/*    */ public final class MaterialImpl implements IMaterial {
/*    */   @NotNull
/*  7 */   public final Material getWrapped() { return this.wrapped; } @NotNull private final Material wrapped; public MaterialImpl(@NotNull Material wrapped) { this.wrapped = wrapped; }
/*    */    public boolean isReplaceable() {
/*  9 */     return this.wrapped.func_76222_j();
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 12 */     return (other instanceof MaterialImpl && Intrinsics.areEqual(((MaterialImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\MaterialImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */