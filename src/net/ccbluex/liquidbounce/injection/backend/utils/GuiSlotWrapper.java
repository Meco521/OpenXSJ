/*    */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiSlot;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\b\n\002\020\002\n\002\b\b\n\002\020\007\n\002\b\002\n\002\020\013\n\002\b\005\030\0002\0020\001B=\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\007\022\006\020\t\032\0020\007\022\006\020\n\032\0020\007\022\006\020\013\032\0020\007¢\006\002\020\fJ\b\020\017\032\0020\020H\024J@\020\021\032\0020\0202\006\020\022\032\0020\0072\006\020\023\032\0020\0072\006\020\024\032\0020\0072\006\020\025\032\0020\0072\006\020\026\032\0020\0072\006\020\027\032\0020\0072\006\020\030\032\0020\031H\024J(\020\032\032\0020\0202\006\020\022\032\0020\0072\006\020\033\032\0020\0342\006\020\035\032\0020\0072\006\020\036\032\0020\007H\026J\b\020\037\032\0020\007H\024J\020\020 \032\0020\0342\006\020\022\032\0020\007H\024R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/utils/GuiSlotWrapper;", "Lnet/minecraft/client/gui/GuiSlot;", "wrapped", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "mc", "Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "width", "", "height", "topIn", "bottomIn", "slotHeightIn", "(Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;IIIII)V", "getWrapped", "()Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "drawBackground", "", "drawSlot", "slotIndex", "xPos", "yPos", "heightIn", "mouseXIn", "mouseYIn", "partialTicks", "", "elementClicked", "isDoubleClick", "", "mouseX", "mouseY", "getSize", "isSelected", "XSJClient"})
/*    */ public final class GuiSlotWrapper extends GuiSlot {
/*    */   @NotNull
/*  9 */   public final WrappedGuiSlot getWrapped() { return this.wrapped; } @NotNull private final WrappedGuiSlot wrapped; public GuiSlotWrapper(@NotNull WrappedGuiSlot wrapped, @NotNull IMinecraft mc, int width, int height, int topIn, int bottomIn, int slotHeightIn) { super(
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
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 25 */         minecraft, width, height, topIn, bottomIn, slotHeightIn);
/*    */     this.wrapped = wrapped;
/*    */     this.wrapped.setRepresented((IGuiSlot)new GuiSlotImpl(this)); }
/*    */ 
/*    */   
/*    */   protected int func_148127_b() {
/*    */     return this.wrapped.getSize();
/*    */   }
/*    */   
/*    */   protected void func_192637_a(int slotIndex, int xPos, int yPos, int heightIn, int mouseXIn, int mouseYIn, float partialTicks) {
/*    */     this.wrapped.drawSlot(slotIndex, xPos, yPos, heightIn, mouseXIn, mouseYIn);
/*    */   }
/*    */   
/*    */   protected boolean func_148131_a(int slotIndex) {
/*    */     return this.wrapped.isSelected(slotIndex);
/*    */   }
/*    */   
/*    */   protected void func_148123_a() {
/*    */     this.wrapped.drawBackground();
/*    */   }
/*    */   
/*    */   public void func_148144_a(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
/*    */     this.wrapped.elementClicked(slotIndex, isDoubleClick, mouseX, mouseY);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\GuiSlotWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */