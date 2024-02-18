/*    */ package net.ccbluex.liquidbounce.script.api;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\021\n\002\030\002\n\002\b\004\n\002\020\002\n\002\020!\n\000\n\002\030\002\n\000\n\002\020\016\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\026\020\013\032\0020\f2\f\020\005\032\b\022\004\022\0020\0070\rH\026J\b\020\016\032\0020\017H\026J\b\020\020\032\0020\021H\026R\031\020\005\032\b\022\004\022\0020\0070\006¢\006\n\n\002\020\n\032\004\b\b\020\tR\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/script/api/ScriptTab;", "Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "tabObject", "Ljdk/nashorn/api/scripting/JSObject;", "(Ljdk/nashorn/api/scripting/JSObject;)V", "items", "", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getItems", "()[Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "[Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "displayAllReleventItems", "", "", "getTabIconItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getTranslatedTabLabel", "", "XSJClient"})
/*    */ public final class ScriptTab extends WrappedCreativeTabs {
/*    */   @NotNull
/*    */   private final IItemStack[] items;
/*    */   
/* 10 */   public ScriptTab(@NotNull JSObject tabObject) { super((String)tabObject.getMember("name")); this.tabObject = tabObject;
/* 11 */     if (ScriptUtils.convert(this.tabObject.getMember("items"), IItemStack[].class) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<net.ccbluex.liquidbounce.api.minecraft.item.IItemStack>");  this.items = (IItemStack[])ScriptUtils.convert(this.tabObject.getMember("items"), IItemStack[].class); } private final JSObject tabObject; @NotNull public final IItemStack[] getItems() { return this.items; }
/*    */   @NotNull
/* 13 */   public IItem getTabIconItem() { if (this.tabObject.getMember("icon") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  if (WrapperImpl.INSTANCE.getFunctions().getItemByName((String)this.tabObject.getMember("icon")) == null) Intrinsics.throwNpe();  return WrapperImpl.INSTANCE.getFunctions().getItemByName((String)this.tabObject.getMember("icon")); } @NotNull
/*    */   public String getTranslatedTabLabel() {
/* 15 */     if (this.tabObject.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  return (String)this.tabObject.getMember("name");
/*    */   }
/*    */   public void displayAllReleventItems(@NotNull List<IItemStack> items) {
/* 18 */     Intrinsics.checkParameterIsNotNull(items, "items"); Iterable<IItemStack> $this$forEach$iv = items; int $i$f$forEach = 0;
/*    */ 
/*    */     
/* 21 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); IItemStack it = (IItemStack)element$iv; int $i$a$-forEach-ScriptTab$displayAllReleventItems$1 = 0;
/*    */       items.add(it); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\api\ScriptTab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */