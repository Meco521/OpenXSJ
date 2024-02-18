/*    */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedCreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\000\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\026\020\t\032\0020\n2\f\020\013\032\b\022\004\022\0020\r0\fH\026J\b\020\016\032\0020\rH\026J\b\020\017\032\0020\005H\026J\b\020\020\032\0020\021H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\b¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/utils/CreativeTabsWrapper;", "Lnet/minecraft/creativetab/CreativeTabs;", "wrapped", "Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "name", "", "(Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;Ljava/lang/String;)V", "getWrapped", "()Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "displayAllRelevantItems", "", "items", "Lnet/minecraft/util/NonNullList;", "Lnet/minecraft/item/ItemStack;", "getTabIconItem", "getTranslatedTabLabel", "hasSearchBar", "", "XSJClient"})
/*    */ public final class CreativeTabsWrapper extends CreativeTabs {
/*    */   @NotNull
/* 12 */   public final WrappedCreativeTabs getWrapped() { return this.wrapped; } @NotNull private final WrappedCreativeTabs wrapped; public CreativeTabsWrapper(@NotNull WrappedCreativeTabs wrapped, @NotNull String name) { super(name); this.wrapped = wrapped; } @NotNull
/* 13 */   public ItemStack func_78016_d() { IItem $this$unwrap$iv = this.wrapped.getTabIconItem(); int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 18 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ItemImpl<*>");  Item item1 = ((ItemImpl)$this$unwrap$iv).getWrapped(); Item item2 = item1;
/*    */     return new ItemStack(item2); }
/*    */ 
/*    */   
/*    */   public void func_78018_a(@NotNull NonNullList items) {
/*    */     Intrinsics.checkParameterIsNotNull(items, "items");
/*    */     this.wrapped.displayAllReleventItems((List)new WrappedMutableList((List)items, CreativeTabsWrapper$displayAllRelevantItems$1.INSTANCE, CreativeTabsWrapper$displayAllRelevantItems$2.INSTANCE));
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String func_78024_c() {
/*    */     return this.wrapped.getTranslatedTabLabel();
/*    */   }
/*    */   
/*    */   public boolean hasSearchBar() {
/*    */     return this.wrapped.hasSearchBar();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\CreativeTabsWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */