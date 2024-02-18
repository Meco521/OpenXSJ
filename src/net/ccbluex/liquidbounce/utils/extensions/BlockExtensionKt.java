/*    */ package net.ccbluex.liquidbounce.utils.extensions;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\022\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\032\f\020\000\032\004\030\0010\001*\0020\002\032\n\020\003\032\0020\004*\0020\002¨\006\005"}, d2 = {"getBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "XSJClient"})
/*    */ public final class BlockExtensionKt {
/*    */   @Nullable
/*    */   public static final IBlock getBlock(@NotNull WBlockPos $this$getBlock) {
/* 15 */     Intrinsics.checkParameterIsNotNull($this$getBlock, "$this$getBlock"); return BlockUtils.getBlock($this$getBlock);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public static final WVec3 getVec(@NotNull WBlockPos $this$getVec) {
/* 20 */     Intrinsics.checkParameterIsNotNull($this$getVec, "$this$getVec"); return new WVec3($this$getVec.getX() + 0.5D, $this$getVec.getY() + 0.5D, $this$getVec.getZ() + 0.5D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\extensions\BlockExtensionKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */