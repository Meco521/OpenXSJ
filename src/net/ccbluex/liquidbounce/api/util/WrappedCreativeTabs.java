/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\004\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\b&\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\026\020\r\032\0020\0162\f\020\017\032\b\022\004\022\0020\0210\020H\026J\b\020\022\032\0020\023H\026J\b\020\024\032\0020\003H\026J\b\020\025\032\0020\026H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\032\020\007\032\0020\bX.¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\f¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "representedType", "Lnet/ccbluex/liquidbounce/api/minecraft/creativetabs/ICreativeTabs;", "getRepresentedType", "()Lnet/ccbluex/liquidbounce/api/minecraft/creativetabs/ICreativeTabs;", "setRepresentedType", "(Lnet/ccbluex/liquidbounce/api/minecraft/creativetabs/ICreativeTabs;)V", "displayAllReleventItems", "", "items", "", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getTabIconItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getTranslatedTabLabel", "hasSearchBar", "", "XSJClient"})
/*    */ public abstract class WrappedCreativeTabs {
/*    */   @NotNull
/*    */   public ICreativeTabs representedType;
/*    */   @NotNull
/*    */   private final String name;
/*    */   
/*    */   @NotNull
/* 11 */   public final String getName() { return this.name; } public WrappedCreativeTabs(@NotNull String name) { this.name = name;
/*    */ 
/*    */ 
/*    */     
/* 15 */     Retreat.INSTANCE.getWrapper().getClassProvider().wrapCreativeTab(this.name, this); }
/*    */   @NotNull public final ICreativeTabs getRepresentedType() { if (this.representedType == null)
/*    */       Intrinsics.throwUninitializedPropertyAccessException("representedType"); 
/* 18 */     return this.representedType; } public void displayAllReleventItems(@NotNull List items) { Intrinsics.checkParameterIsNotNull(items, "items"); }
/* 19 */   public final void setRepresentedType(@NotNull ICreativeTabs <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.representedType = <set-?>; } @NotNull public String getTranslatedTabLabel() { return "asdf"; } @NotNull
/* 20 */   public IItem getTabIconItem() { return WrapperImpl.INSTANCE.getClassProvider().getItemEnum(ItemType.WRITABLE_BOOK); } public boolean hasSearchBar() {
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedCreativeTabs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */