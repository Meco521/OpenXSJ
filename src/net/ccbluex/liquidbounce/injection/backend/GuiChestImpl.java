/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.minecraft.client.gui.inventory.GuiChest;
/*    */ import net.minecraft.inventory.Container;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR\026\020\013\032\004\030\0010\f8VX\004¢\006\006\032\004\b\r\020\016R\026\020\017\032\004\030\0010\0208VX\004¢\006\006\032\004\b\021\020\022¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiChestImpl;", "T", "Lnet/minecraft/client/gui/inventory/GuiChest;", "Lnet/ccbluex/liquidbounce/injection/backend/GuiContainerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;", "wrapped", "(Lnet/minecraft/client/gui/inventory/GuiChest;)V", "inventoryRows", "", "getInventoryRows", "()I", "inventorySlots", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "getInventorySlots", "()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "lowerChestInventory", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IIInventory;", "getLowerChestInventory", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IIInventory;", "XSJClient"})
/*    */ public final class GuiChestImpl<T extends GuiChest> extends GuiContainerImpl<T> implements IGuiChest {
/*    */   public GuiChestImpl(@NotNull GuiChest wrapped) {
/*  9 */     super((T)wrapped);
/*    */   }
/* 11 */   public int getInventoryRows() { return ((GuiChest)getWrapped()).field_147018_x; }
/*    */   @Nullable
/* 13 */   public IIInventory getLowerChestInventory() { IInventory $this$wrap$iv = ((GuiChest)getWrapped()).field_147015_w; int $i$f$wrap = 0; return (((GuiChest)getWrapped()).field_147015_w != null) ? 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 20 */       new IInventoryImpl($this$wrap$iv) : null; } @Nullable public IContainer getInventorySlots() { Container $this$wrap$iv = ((GuiChest)getWrapped()).field_147002_h; int $i$f$wrap = 0;
/* 21 */     return (((GuiChest)getWrapped()).field_147002_h != null) ? new ContainerImpl($this$wrap$iv) : null; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiChestImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */