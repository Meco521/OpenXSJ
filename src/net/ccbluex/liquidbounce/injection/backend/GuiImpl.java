/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ 
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\006\b\026\030\000*\b\b\000\020\001*\0020\0022\0020\003B\r\022\006\020\004\032\0028\000¢\006\002\020\005R\023\020\004\032\0028\000¢\006\n\n\002\020\b\032\004\b\006\020\007¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiImpl;", "T", "Lnet/minecraft/client/gui/Gui;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGui;", "wrapped", "(Lnet/minecraft/client/gui/Gui;)V", "getWrapped", "()Lnet/minecraft/client/gui/Gui;", "Lnet/minecraft/client/gui/Gui;", "XSJClient"})
/*   */ public class GuiImpl<T extends Gui> implements IGui {
/*   */   @NotNull
/* 7 */   public final T getWrapped() { return this.wrapped; } @NotNull private final T wrapped; public GuiImpl(@NotNull Gui wrapped) { this.wrapped = (T)wrapped; }
/*   */ 
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */