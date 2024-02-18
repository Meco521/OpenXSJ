/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.inventory.Container;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002J\020\020\017\032\0020\0202\006\020\021\032\0020\006H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ContainerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "wrapped", "Lnet/minecraft/inventory/Container;", "(Lnet/minecraft/inventory/Container;)V", "windowId", "", "getWindowId", "()I", "getWrapped", "()Lnet/minecraft/inventory/Container;", "equals", "", "other", "", "getSlot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "id", "XSJClient"})
/*    */ public final class ContainerImpl implements IContainer {
/*    */   @NotNull
/*  9 */   public final Container getWrapped() { return this.wrapped; } @NotNull private final Container wrapped; public ContainerImpl(@NotNull Container wrapped) { this.wrapped = wrapped; }
/*    */   
/* 11 */   public int getWindowId() { return this.wrapped.field_75152_c; } @NotNull
/*    */   public ISlot getSlot(int id) {
/* 13 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_75139_a(id), "wrapped.getSlot(id)"); Slot $this$wrap$iv = this.wrapped.func_75139_a(id); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 22 */       new SlotImpl($this$wrap$iv);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof ContainerImpl && Intrinsics.areEqual(((ContainerImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ContainerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */