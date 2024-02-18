/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\005\n\002\020\016\n\002\b\n\n\002\020\002\n\002\b\002\n\002\020\000\n\002\b\002\n\002\020\f\n\002\b\b\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\033\032\0020\034H\026J\023\020\035\032\0020\0062\b\020\036\032\004\030\0010\037H\002J\030\020 \032\0020\0062\006\020!\032\0020\"2\006\020#\032\0020\013H\026J \020$\032\0020\0342\006\020%\032\0020\0132\006\020&\032\0020\0132\006\020'\032\0020\013H\026J\030\020(\032\0020\0062\006\020!\032\0020\"2\006\020#\032\0020\013H\026J\b\020)\032\0020\034H\026R$\020\007\032\0020\0062\006\020\005\032\0020\0068V@VX\016¢\006\f\032\004\b\007\020\b\"\004\b\t\020\nR$\020\f\032\0020\0132\006\020\005\032\0020\0138V@VX\016¢\006\f\032\004\b\r\020\016\"\004\b\017\020\020R$\020\022\032\0020\0212\006\020\005\032\0020\0218V@VX\016¢\006\f\032\004\b\023\020\024\"\004\b\025\020\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\027\020\030R\024\020\031\032\0020\0138VX\004¢\006\006\032\004\b\032\020\016¨\006*"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiTextFieldImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiTextField;", "wrapped", "Lnet/minecraft/client/gui/GuiTextField;", "(Lnet/minecraft/client/gui/GuiTextField;)V", "value", "", "isFocused", "()Z", "setFocused", "(Z)V", "", "maxStringLength", "getMaxStringLength", "()I", "setMaxStringLength", "(I)V", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getWrapped", "()Lnet/minecraft/client/gui/GuiTextField;", "xPosition", "getXPosition", "drawTextBox", "", "equals", "other", "", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseX", "mouseY", "mouseButton", "textboxKeyTyped", "updateCursorCounter", "XSJClient"})
/*    */ public final class GuiTextFieldImpl implements IGuiTextField {
/*    */   @NotNull
/*  7 */   public final GuiTextField getWrapped() { return this.wrapped; } @NotNull private final GuiTextField wrapped; public GuiTextFieldImpl(@NotNull GuiTextField wrapped) { this.wrapped = wrapped; }
/*    */   
/*  9 */   public int getXPosition() { return this.wrapped.field_146209_f; } @NotNull
/*    */   public String getText() {
/* 11 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_146179_b(), "wrapped.text"); return this.wrapped.func_146179_b();
/*    */   } public void setText(@NotNull String value) {
/* 13 */     Intrinsics.checkParameterIsNotNull(value, "value"); this.wrapped.func_146180_a(value);
/*    */   }
/*    */   public boolean isFocused() {
/* 16 */     return this.wrapped.func_146206_l();
/*    */   } public void setFocused(boolean value) {
/* 18 */     this.wrapped.func_146195_b(value);
/*    */   }
/*    */   public int getMaxStringLength() {
/* 21 */     return this.wrapped.func_146208_g();
/*    */   } public void setMaxStringLength(int value) {
/* 23 */     this.wrapped.func_146203_f(value);
/*    */   }
/*    */   public void updateCursorCounter() {
/* 26 */     this.wrapped.func_146178_a();
/*    */   } public boolean textboxKeyTyped(char typedChar, int keyCode) {
/* 28 */     return this.wrapped.func_146201_a(typedChar, keyCode);
/*    */   } public void drawTextBox() {
/* 30 */     this.wrapped.func_146194_f();
/*    */   }
/*    */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 33 */     this.wrapped.func_146192_a(mouseX, mouseY, mouseButton);
/*    */   }
/*    */   public boolean keyTyped(char typedChar, int keyCode) {
/* 36 */     return this.wrapped.func_146201_a(typedChar, keyCode);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 39 */     return (other instanceof GuiTextFieldImpl && Intrinsics.areEqual(((GuiTextFieldImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiTextFieldImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */