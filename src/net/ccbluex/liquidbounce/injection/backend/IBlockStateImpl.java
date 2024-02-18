/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/IBlockStateImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "wrapped", "Lnet/minecraft/block/state/IBlockState;", "(Lnet/minecraft/block/state/IBlockState;)V", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getWrapped", "()Lnet/minecraft/block/state/IBlockState;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class IBlockStateImpl implements IIBlockState {
/*    */   @NotNull
/*  8 */   public final IBlockState getWrapped() { return this.wrapped; } @NotNull private final IBlockState wrapped; public IBlockStateImpl(@NotNull IBlockState wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public IBlock getBlock() {
/* 10 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_177230_c(), "wrapped.block"); return new BlockImpl(this.wrapped.func_177230_c());
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 14 */     return (other instanceof IBlockStateImpl && Intrinsics.areEqual(((IBlockStateImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\IBlockStateImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */