/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\003\n\002\020\016\n\002\b\004\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005J\020\020\022\032\0020\0132\006\020\023\032\0020\024H\026R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\024\020\016\032\0020\0178VX\004¢\006\006\032\004\b\020\020\021¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemArmorImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/ItemImpl;", "Lnet/minecraft/item/ItemArmor;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemArmor;", "wrapped", "(Lnet/minecraft/item/ItemArmor;)V", "armorMaterial", "Lnet/ccbluex/liquidbounce/api/minecraft/minecraft/IArmorMaterial;", "getArmorMaterial", "()Lnet/ccbluex/liquidbounce/api/minecraft/minecraft/IArmorMaterial;", "armorType", "", "getArmorType", "()I", "unlocalizedName", "", "getUnlocalizedName", "()Ljava/lang/String;", "getColor", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "XSJClient"})
/*    */ public final class ItemArmorImpl extends ItemImpl<ItemArmor> implements IItemArmor {
/*  9 */   public ItemArmorImpl(@NotNull ItemArmor wrapped) { super(wrapped); }
/*    */   @NotNull
/* 11 */   public IArmorMaterial getArmorMaterial() { Intrinsics.checkExpressionValueIsNotNull(getWrapped().func_82812_d(), "wrapped.armorMaterial"); ItemArmor.ArmorMaterial $this$wrap$iv = getWrapped().func_82812_d(); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 22 */       new ArmorMaterialImpl($this$wrap$iv); } public int getColor(@NotNull IItemStack stack) { Intrinsics.checkParameterIsNotNull(stack, "stack"); IItemStack iItemStack = stack; ItemArmor itemArmor = getWrapped(); int $i$f$unwrap = 0;
/* 23 */     ItemStack itemStack = ((ItemStackImpl)iItemStack).getWrapped(); return itemArmor.func_82814_b(itemStack); }
/*    */ 
/*    */   
/*    */   public int getArmorType() {
/*    */     Intrinsics.checkExpressionValueIsNotNull((getWrapped()).field_77881_a, "wrapped.armorType");
/*    */     return (getWrapped()).field_77881_a.func_188454_b();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getUnlocalizedName() {
/*    */     Intrinsics.checkExpressionValueIsNotNull(getWrapped().func_77658_a(), "wrapped.unlocalizedName");
/*    */     return getWrapped().func_77658_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemArmorImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */