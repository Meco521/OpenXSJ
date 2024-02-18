/*    */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\000\030\0002\0020\001B5\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\003\022\006\020\007\032\0020\003\022\006\020\b\032\0020\003\022\006\020\t\032\0020\003¢\006\002\020\nJ\b\020\013\032\0020\fH\026¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/utils/GuiPasswordField;", "Lnet/minecraft/client/gui/GuiTextField;", "componentId", "", "fontrendererObj", "Lnet/minecraft/client/gui/FontRenderer;", "x", "y", "par5Width", "par6Height", "(ILnet/minecraft/client/gui/FontRenderer;IIII)V", "drawTextBox", "", "XSJClient"})
/*    */ public final class GuiPasswordField extends GuiTextField {
/*    */   public GuiPasswordField(int componentId, @NotNull FontRenderer fontrendererObj, int x, int y, int par5Width, int par6Height) {
/*  7 */     super(componentId, fontrendererObj, x, y, par5Width, par6Height);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146194_f() {
/* 13 */     String realText = func_146179_b();
/*    */     
/* 15 */     StringBuilder stringBuilder = new StringBuilder();
/* 16 */     byte b = 0; Intrinsics.checkExpressionValueIsNotNull(func_146179_b(), "text"); for (int i = ((CharSequence)func_146179_b()).length(); b < i; ) { stringBuilder.append('*'); b++; }
/* 17 */      func_146180_a(stringBuilder.toString());
/*    */     
/* 19 */     super.func_146194_f();
/* 20 */     func_146180_a(realText);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\GuiPasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */