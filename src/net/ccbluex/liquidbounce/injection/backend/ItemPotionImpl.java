/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotionEffect;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005J\026\020\006\032\b\022\004\022\0020\b0\0072\006\020\t\032\0020\nH\026¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemPotionImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/ItemImpl;", "Lnet/minecraft/item/ItemPotion;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemPotion;", "wrapped", "(Lnet/minecraft/item/ItemPotion;)V", "getEffects", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "XSJClient"})
/*    */ public final class ItemPotionImpl extends ItemImpl<ItemPotion> implements IItemPotion {
/* 12 */   public ItemPotionImpl(@NotNull ItemPotion wrapped) { super(wrapped); } @NotNull
/*    */   public Collection<IPotionEffect> getEffects(@NotNull IItemStack stack) {
/* 14 */     Intrinsics.checkParameterIsNotNull(stack, "stack");
/* 15 */     IItemStack $this$unwrap$iv = stack; int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 24 */     ItemStack itemStack = ((ItemStackImpl)$this$unwrap$iv).getWrapped(); ItemPotionImpl$getEffects$2 itemPotionImpl$getEffects$2 = ItemPotionImpl$getEffects$2.INSTANCE; ItemPotionImpl$getEffects$1 itemPotionImpl$getEffects$1 = ItemPotionImpl$getEffects$1.INSTANCE; List list = PotionUtils.func_185189_a(itemStack);
/*    */     return (Collection<IPotionEffect>)new WrappedCollection(list, itemPotionImpl$getEffects$1, itemPotionImpl$getEffects$2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemPotionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */