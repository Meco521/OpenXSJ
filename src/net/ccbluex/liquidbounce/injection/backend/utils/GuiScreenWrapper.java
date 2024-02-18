/*    */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\004\n\002\020\f\n\002\b\r\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\022\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\024J\b\020\013\032\0020\fH\026J \020\r\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\022H\026J\b\020\023\032\0020\bH\026J\b\020\024\032\0020\bH\026J\030\020\025\032\0020\b2\006\020\026\032\0020\0272\006\020\030\032\0020\017H\024J \020\031\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\032\032\0020\017H\024J \020\033\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\034\032\0020\017H\024J\b\020\035\032\0020\bH\026J\036\020\036\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\022J\006\020\037\032\0020\bJ\026\020 \032\0020\b2\006\020\026\032\0020\0272\006\020\030\032\0020\017J\036\020!\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\032\032\0020\017J\036\020\"\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\034\032\0020\017J\b\020#\032\0020\bH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006$"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/utils/GuiScreenWrapper;", "Lnet/minecraft/client/gui/GuiScreen;", "wrapped", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "(Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;)V", "getWrapped", "()Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "actionPerformed", "", "button", "Lnet/minecraft/client/gui/GuiButton;", "doesGuiPauseGame", "", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "handleMouseInput", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseButton", "mouseReleased", "state", "onGuiClosed", "superDrawScreen", "superHandleMouseInput", "superKeyTyped", "superMouseClicked", "superMouseReleased", "updateScreen", "XSJClient"})
/*    */ public final class GuiScreenWrapper extends GuiScreen {
/*    */   @NotNull
/*  9 */   public final WrappedGuiScreen getWrapped() { return this.wrapped; } @NotNull private final WrappedGuiScreen wrapped; public GuiScreenWrapper(@NotNull WrappedGuiScreen wrapped) { this.wrapped = wrapped; }
/* 10 */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) { this.wrapped.drawScreen(mouseX, mouseY, partialTicks); }
/* 11 */   public void func_73866_w_() { this.wrapped.initGui(); }
/* 12 */   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) { this.wrapped.mouseClicked(mouseX, mouseY, mouseButton); } public void func_73876_c() {
/* 13 */     this.wrapped.updateScreen();
/*    */   } public void func_146274_d() {
/* 15 */     this.wrapped.handleMouseInput();
/*    */   } protected void func_73869_a(char typedChar, int keyCode) {
/* 17 */     this.wrapped.keyTyped(typedChar, keyCode);
/*    */   }
/*    */   protected void func_146284_a(@Nullable GuiButton button) {
/* 20 */     if (button != null) { GuiButton guiButton1 = button; boolean bool1 = false, bool2 = false; GuiButton it = guiButton1; int $i$a$-let-GuiScreenWrapper$actionPerformed$1 = 0; GuiButton guiButton2 = button; WrappedGuiScreen wrappedGuiScreen = this.wrapped; int $i$f$wrap = 0;
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
/* 35 */       IGuiButton iGuiButton = (IGuiButton)new GuiButtonImpl(guiButton2); wrappedGuiScreen.actionPerformed(iGuiButton); }
/*    */     else
/*    */     {  }
/*    */   
/*    */   }
/*    */   
/*    */   public void func_146281_b() {
/*    */     this.wrapped.onGuiClosed();
/*    */   }
/*    */   
/*    */   protected void func_146286_b(int mouseX, int mouseY, int state) {
/*    */     this.wrapped.mouseReleased(mouseX, mouseY, state);
/*    */   }
/*    */   
/*    */   public boolean func_73868_f() {
/*    */     return this.wrapped.doesGuiPauseGame();
/*    */   }
/*    */   
/*    */   public final void superMouseReleased(int mouseX, int mouseY, int state) {
/*    */     super.func_146286_b(mouseX, mouseY, state);
/*    */   }
/*    */   
/*    */   public final void superKeyTyped(char typedChar, int keyCode) {
/*    */     super.func_73869_a(typedChar, keyCode);
/*    */   }
/*    */   
/*    */   public final void superHandleMouseInput() {
/*    */     super.func_146274_d();
/*    */   }
/*    */   
/*    */   public final void superMouseClicked(int mouseX, int mouseY, int mouseButton) {
/*    */     super.func_73864_a(mouseX, mouseY, mouseButton);
/*    */   }
/*    */   
/*    */   public final void superDrawScreen(int mouseX, int mouseY, float partialTicks) {
/*    */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\GuiScreenWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */