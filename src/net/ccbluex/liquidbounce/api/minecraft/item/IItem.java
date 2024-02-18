/*    */ package net.ccbluex.liquidbounce.api.minecraft.item;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\bf\030\0002\0020\001J\b\020\006\032\0020\007H&J\b\020\b\032\0020\tH&J\b\020\n\032\0020\013H&J\b\020\f\032\0020\rH&J\b\020\016\032\0020\017H&J\020\020\020\032\0020\0002\006\020\021\032\0020\022H\026R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "", "unlocalizedName", "", "getUnlocalizedName", "()Ljava/lang/String;", "asItemArmor", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemArmor;", "asItemBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;", "asItemBucket", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;", "asItemPotion", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemPotion;", "asItemSword", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemSword;", "getItemByID", "id", "", "XSJClient"})
/*    */ public interface IItem { @NotNull
/*    */   String getUnlocalizedName(); @NotNull
/*    */   IItemArmor asItemArmor(); @NotNull
/*    */   IItemPotion asItemPotion(); @NotNull
/*    */   IItemBlock asItemBlock(); @NotNull
/*    */   IItemSword asItemSword();
/*    */   @NotNull
/*    */   IItemBucket asItemBucket();
/*    */   @NotNull
/*    */   IItem getItemByID(int paramInt);
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
/*    */   public static final class DefaultImpls { @NotNull
/*    */     public static IItem getItemByID(IItem $this, int id) {
/* 15 */       if (Item.func_150899_d(id) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItem");  return (IItem)Item.func_150899_d(id);
/*    */     } }
/*    */    }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\item\IItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */