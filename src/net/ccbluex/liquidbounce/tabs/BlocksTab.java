/*    */ package net.ccbluex.liquidbounce.tabs;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*    */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedCreativeTabs;
/*    */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\013\n\000\030\0002\0020\001B\005¢\006\002\020\002J\026\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026J\b\020\b\032\0020\tH\026J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\rH\026¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/tabs/BlocksTab;", "Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "()V", "displayAllReleventItems", "", "itemList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getTabIconItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getTranslatedTabLabel", "", "hasSearchBar", "", "XSJClient"})
/*    */ public final class BlocksTab extends WrappedCreativeTabs {
/*    */   public BlocksTab() {
/* 16 */     super("Special blocks");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 22 */     getRepresentedType().setBackgroundImageName("item_search.png");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void displayAllReleventItems(@NotNull List<IItemStack> itemList) {
/* 31 */     Intrinsics.checkParameterIsNotNull(itemList, "itemList"); itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.COMMAND_BLOCK)));
/* 32 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getItemEnum(ItemType.COMMAND_BLOCK_MINECART)));
/* 33 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.BARRIER)));
/* 34 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.DRAGON_EGG)));
/* 35 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.BROWN_MUSHROOM_BLOCK)));
/* 36 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.RED_MUSHROOM_BLOCK)));
/* 37 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.FARMLAND)));
/* 38 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.MOB_SPAWNER)));
/* 39 */     itemList.add(WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.LIT_FURNACE)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public IItem getTabIconItem() {
/* 47 */     if (WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.COMMAND_BLOCK)).getItem() == null) Intrinsics.throwNpe();  return WrapperImpl.INSTANCE.getClassProvider().createItemStack(WrapperImpl.INSTANCE.getClassProvider().getBlockEnum(BlockType.COMMAND_BLOCK)).getItem();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getTranslatedTabLabel() {
/* 54 */     return "Special blocks";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasSearchBar() {
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\tabs\BlocksTab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */