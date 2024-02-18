/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\005\n\002\020\013\n\002\b\006\n\002\020\b\n\002\b\005\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R$\020\007\032\0020\0062\006\020\005\032\0020\0068V@VX\016¢\006\f\032\004\b\b\020\t\"\004\b\n\020\013R$\020\r\032\0020\f2\006\020\005\032\0020\f8V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021R\024\020\022\032\0020\0238VX\004¢\006\006\032\004\b\024\020\025R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\026\020\027¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiButtonImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "wrapped", "Lnet/minecraft/client/gui/GuiButton;", "(Lnet/minecraft/client/gui/GuiButton;)V", "value", "", "displayString", "getDisplayString", "()Ljava/lang/String;", "setDisplayString", "(Ljava/lang/String;)V", "", "enabled", "getEnabled", "()Z", "setEnabled", "(Z)V", "id", "", "getId", "()I", "getWrapped", "()Lnet/minecraft/client/gui/GuiButton;", "XSJClient"})
/*    */ public final class GuiButtonImpl implements IGuiButton {
/*    */   @NotNull
/*  7 */   public final GuiButton getWrapped() { return this.wrapped; } @NotNull private final GuiButton wrapped; public GuiButtonImpl(@NotNull GuiButton wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public String getDisplayString() {
/*  9 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_146126_j, "wrapped.displayString"); return this.wrapped.field_146126_j;
/*    */   } public void setDisplayString(@NotNull String value) {
/* 11 */     Intrinsics.checkParameterIsNotNull(value, "value"); this.wrapped.field_146126_j = value;
/*    */   }
/*    */   public int getId() {
/* 14 */     return this.wrapped.field_146127_k;
/*    */   } public boolean getEnabled() {
/* 16 */     return this.wrapped.field_146124_l;
/*    */   } public void setEnabled(boolean value) {
/* 18 */     this.wrapped.field_146124_l = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiButtonImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */