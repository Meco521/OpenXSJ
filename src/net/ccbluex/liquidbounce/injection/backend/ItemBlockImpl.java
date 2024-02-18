/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\r¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemBlockImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/ItemImpl;", "Lnet/minecraft/item/ItemBlock;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;", "wrapped", "(Lnet/minecraft/item/ItemBlock;)V", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "unlocalizedName", "", "getUnlocalizedName", "()Ljava/lang/String;", "XSJClient"})
/*    */ public final class ItemBlockImpl extends ItemImpl<ItemBlock> implements IItemBlock {
/*  8 */   public ItemBlockImpl(@NotNull ItemBlock wrapped) { super(wrapped); }
/*    */   @NotNull
/* 10 */   public IBlock getBlock() { Intrinsics.checkExpressionValueIsNotNull(getWrapped().func_179223_d(), "wrapped.block"); return new BlockImpl(getWrapped().func_179223_d()); } @NotNull
/*    */   public String getUnlocalizedName() {
/* 12 */     Intrinsics.checkExpressionValueIsNotNull(getWrapped().func_77658_a(), "wrapped.unlocalizedName"); return getWrapped().func_77658_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemBlockImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */