/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.item.ItemBucket;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\006\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemBucketImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/ItemImpl;", "Lnet/minecraft/item/ItemBucket;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;", "wrapped", "(Lnet/minecraft/item/ItemBucket;)V", "isFull", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "XSJClient"})
/*    */ public final class ItemBucketImpl extends ItemImpl<ItemBucket> implements IItemBucket {
/*  8 */   public ItemBucketImpl(@NotNull ItemBucket wrapped) { super(wrapped); } @NotNull
/*    */   public IBlock isFull() {
/* 10 */     Intrinsics.checkExpressionValueIsNotNull((getWrapped()).field_77876_a, "wrapped.containedBlock"); return new BlockImpl((getWrapped()).field_77876_a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemBucketImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */