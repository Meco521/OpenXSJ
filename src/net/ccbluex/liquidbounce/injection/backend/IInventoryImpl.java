/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/IInventoryImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IIInventory;", "wrapped", "Lnet/minecraft/inventory/IInventory;", "(Lnet/minecraft/inventory/IInventory;)V", "name", "", "getName", "()Ljava/lang/String;", "getWrapped", "()Lnet/minecraft/inventory/IInventory;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class IInventoryImpl implements IIInventory {
/*    */   @NotNull
/*  7 */   public final IInventory getWrapped() { return this.wrapped; } @NotNull private final IInventory wrapped; public IInventoryImpl(@NotNull IInventory wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public String getName() {
/*  9 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_70005_c_(), "wrapped.name"); return this.wrapped.func_70005_c_();
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 12 */     return (other instanceof IInventoryImpl && Intrinsics.areEqual(((IInventoryImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\IInventoryImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */