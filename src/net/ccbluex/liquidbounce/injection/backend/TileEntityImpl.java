/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/TileEntityImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "wrapped", "Lnet/minecraft/tileentity/TileEntity;", "(Lnet/minecraft/tileentity/TileEntity;)V", "pos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getPos", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getWrapped", "()Lnet/minecraft/tileentity/TileEntity;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class TileEntityImpl implements ITileEntity {
/*    */   @NotNull
/*  9 */   public final TileEntity getWrapped() { return this.wrapped; } @NotNull private final TileEntity wrapped; public TileEntityImpl(@NotNull TileEntity wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public WBlockPos getPos() {
/* 11 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_174877_v(), "wrapped.pos"); BlockPos $this$wrap$iv = this.wrapped.func_174877_v(); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 20 */       new WBlockPos($this$wrap$iv.func_177958_n(), $this$wrap$iv.func_177956_o(), $this$wrap$iv.func_177952_p());
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof TileEntityImpl && Intrinsics.areEqual(((TileEntityImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\TileEntityImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */