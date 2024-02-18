/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\000\n\000\b\026\030\000*\b\b\000\020\001*\0020\0022\0020\003B\r\022\006\020\004\032\0028\000¢\006\002\020\005J\b\020\r\032\0020\016H\026J\b\020\017\032\0020\020H\026J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\024H\026J\b\020\025\032\0020\026H\026J\023\020\027\032\0020\0302\b\020\031\032\004\030\0010\032H\002R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\tR\023\020\004\032\0028\000¢\006\n\n\002\020\f\032\004\b\n\020\013¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemImpl;", "T", "Lnet/minecraft/item/Item;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "wrapped", "(Lnet/minecraft/item/Item;)V", "unlocalizedName", "", "getUnlocalizedName", "()Ljava/lang/String;", "getWrapped", "()Lnet/minecraft/item/Item;", "Lnet/minecraft/item/Item;", "asItemArmor", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemArmor;", "asItemBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;", "asItemBucket", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;", "asItemPotion", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemPotion;", "asItemSword", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemSword;", "equals", "", "other", "", "XSJClient"})
/*    */ public class ItemImpl<T extends Item> implements IItem {
/*    */   @NotNull
/*  7 */   public final T getWrapped() { return this.wrapped; } @NotNull private final T wrapped; public ItemImpl(@NotNull Item wrapped) { this.wrapped = (T)wrapped; } @NotNull public IItem getItemByID(int id) { return IItem.DefaultImpls.getItemByID(this, id); }
/*    */   @NotNull
/*  9 */   public String getUnlocalizedName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_77658_a(), "wrapped.unlocalizedName"); return this.wrapped.func_77658_a(); }
/*    */   @NotNull
/* 11 */   public IItemArmor asItemArmor() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemArmor");  return new ItemArmorImpl((ItemArmor)this.wrapped); } @NotNull
/* 12 */   public IItemPotion asItemPotion() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemPotion");  return new ItemPotionImpl((ItemPotion)this.wrapped); } @NotNull
/* 13 */   public IItemBlock asItemBlock() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");  return new ItemBlockImpl((ItemBlock)this.wrapped); } @NotNull
/* 14 */   public IItemSword asItemSword() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemSword");  return new ItemSwordImpl((ItemSword)this.wrapped); } @NotNull
/* 15 */   public IItemBucket asItemBucket() { if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBucket");  return new ItemBucketImpl((ItemBucket)this.wrapped); }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 18 */     return (other instanceof ItemImpl && Intrinsics.areEqual(((ItemImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */