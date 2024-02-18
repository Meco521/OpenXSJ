/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ import net.minecraft.item.ItemSword;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemSwordImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/ItemImpl;", "Lnet/minecraft/item/ItemSword;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemSword;", "wrapped", "(Lnet/minecraft/item/ItemSword;)V", "damageVsEntity", "", "getDamageVsEntity", "()F", "XSJClient"})
/*   */ public final class ItemSwordImpl extends ItemImpl<ItemSword> implements IItemSword {
/*   */   public ItemSwordImpl(@NotNull ItemSword wrapped) {
/* 7 */     super(wrapped);
/*   */   } public float getDamageVsEntity() {
/* 9 */     return getWrapped().func_150931_i();
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemSwordImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */