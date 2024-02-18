/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.inventory.Slot;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\023\032\0020\0062\b\020\024\032\004\030\0010\025H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\026\020\r\032\004\030\0010\0168VX\004¢\006\006\032\004\b\017\020\020R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\021\020\022¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SlotImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "wrapped", "Lnet/minecraft/inventory/Slot;", "(Lnet/minecraft/inventory/Slot;)V", "hasStack", "", "getHasStack", "()Z", "slotNumber", "", "getSlotNumber", "()I", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getStack", "()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getWrapped", "()Lnet/minecraft/inventory/Slot;", "equals", "other", "", "XSJClient"})
/*    */ public final class SlotImpl implements ISlot {
/*    */   @NotNull
/*  8 */   public final Slot getWrapped() { return this.wrapped; } @NotNull private final Slot wrapped; public SlotImpl(@NotNull Slot wrapped) { this.wrapped = wrapped; }
/*    */   
/* 10 */   public int getSlotNumber() { return this.wrapped.field_75222_d; } @Nullable
/*    */   public IItemStack getStack() {
/* 12 */     ItemStack $this$wrap$iv = this.wrapped.func_75211_c(); int $i$f$wrap = 0; this.wrapped.func_75211_c(); return (this.wrapped.func_75211_c() != null) ? 
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
/*    */       
/* 24 */       new ItemStackImpl($this$wrap$iv) : null;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof SlotImpl && Intrinsics.areEqual(((SlotImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */   
/*    */   public boolean getHasStack() {
/*    */     return this.wrapped.func_75216_d();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SlotImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */