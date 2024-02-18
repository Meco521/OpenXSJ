/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/client/gui/Gui;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGui;", "wrap", "XSJClient"})
/*    */ public final class GuiImplKt {
/*    */   @NotNull
/*  9 */   public static final Gui unwrap(@NotNull IGui $this$unwrap) { int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((GuiImpl<Gui>)$this$unwrap).getWrapped(); } @NotNull
/* 10 */   public static final IGui wrap(@NotNull Gui $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new GuiImpl<>($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */