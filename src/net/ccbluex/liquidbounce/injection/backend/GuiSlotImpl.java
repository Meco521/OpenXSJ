/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiSlot;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\007\n\002\020\002\n\002\b\003\n\002\020\007\n\002\b\003\n\002\020\013\n\002\b\f\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J \020\r\032\0020\0162\006\020\017\032\0020\0062\006\020\020\032\0020\0062\006\020\021\032\0020\022H\026J(\020\023\032\0020\0162\006\020\024\032\0020\0062\006\020\025\032\0020\0262\006\020\027\032\0020\0062\006\020\030\032\0020\006H\026J\b\020\031\032\0020\016H\026J\030\020\032\032\0020\0162\006\020\033\032\0020\0062\006\020\034\032\0020\006H\026J\020\020\035\032\0020\0162\006\020\036\032\0020\006H\026J\020\020\037\032\0020\0162\006\020 \032\0020\026H\026J\020\020!\032\0020\0162\006\020\t\032\0020\006H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\0068VX\004¢\006\006\032\004\b\n\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\013\020\f¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiSlotImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiSlot;", "wrapped", "Lnet/minecraft/client/gui/GuiSlot;", "(Lnet/minecraft/client/gui/GuiSlot;)V", "slotHeight", "", "getSlotHeight", "()I", "width", "getWidth", "getWrapped", "()Lnet/minecraft/client/gui/GuiSlot;", "drawScreen", "", "mouseX", "mouseY", "partialTicks", "", "elementClicked", "index", "doubleClick", "", "var3", "var4", "handleMouseInput", "registerScrollButtons", "down", "up", "scrollBy", "value", "setEnableScissor", "flag", "setListWidth", "XSJClient"})
/*    */ public final class GuiSlotImpl implements IGuiSlot {
/*    */   @NotNull
/*  9 */   public final GuiSlot getWrapped() { return this.wrapped; } @NotNull private final GuiSlot wrapped; public GuiSlotImpl(@NotNull GuiSlot wrapped) { this.wrapped = wrapped; }
/*    */    public int getWidth() {
/* 11 */     return this.wrapped.field_148155_a;
/*    */   } public int getSlotHeight() {
/* 13 */     return this.wrapped.field_148149_f;
/*    */   } public void scrollBy(int value) {
/* 15 */     this.wrapped.func_148145_f(value);
/*    */   } public void registerScrollButtons(int down, int up) {
/* 17 */     this.wrapped.func_148134_d(down, up);
/*    */   } public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 19 */     this.wrapped.func_148128_a(mouseX, mouseY, partialTicks);
/*    */   } public void elementClicked(int index, boolean doubleClick, int var3, int var4) {
/* 21 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.GuiSlotWrapper");  ((GuiSlotWrapper)this.wrapped).func_148144_a(index, doubleClick, var3, var4);
/*    */   }
/* 23 */   public void handleMouseInput() { this.wrapped.func_178039_p(); } public void setListWidth(int width) {
/* 24 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.implementations.IMixinGuiSlot");  ((IMixinGuiSlot)this.wrapped).setListWidth(width);
/*    */   } public void setEnableScissor(boolean flag) {
/* 26 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.implementations.IMixinGuiSlot");  ((IMixinGuiSlot)this.wrapped).setEnableScissor(flag);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiSlotImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */