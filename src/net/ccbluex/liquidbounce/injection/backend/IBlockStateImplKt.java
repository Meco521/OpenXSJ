/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/block/state/IBlockState;", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "wrap", "XSJClient"})
/*    */ public final class IBlockStateImplKt
/*    */ {
/*    */   @NotNull
/*    */   public static final IBlockState unwrap(@NotNull IIBlockState $this$unwrap) {
/* 18 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((IBlockStateImpl)$this$unwrap).getWrapped(); } @NotNull
/* 19 */   public static final IIBlockState wrap(@NotNull IBlockState $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new IBlockStateImpl($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\IBlockStateImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */