/*   */ package net.ccbluex.liquidbounce.utils.extensions;
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000 \n\000\n\002\020\b\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\007\n\002\b\003\n\002\020\013\n\000\032*\020\000\032\0020\001*\0020\0022\006\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\0062\006\020\b\032\0020\001\0322\020\000\032\0020\001*\0020\0022\006\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\0062\006\020\b\032\0020\0012\006\020\t\032\0020\n¨\006\013"}, d2 = {"drawCenteredString", "", "Lnet/minecraft/client/gui/FontRenderer;", "s", "", "x", "", "y", "color", "shadow", "", "XSJClient"})
/*   */ public final class RendererExtensionKt {
/*   */   public static final int drawCenteredString(@NotNull FontRenderer $this$drawCenteredString, @NotNull String s, float x, float y, int color, boolean shadow) {
/* 5 */     Intrinsics.checkParameterIsNotNull($this$drawCenteredString, "$this$drawCenteredString"); Intrinsics.checkParameterIsNotNull(s, "s"); return $this$drawCenteredString.func_175065_a(s, x - $this$drawCenteredString.func_78256_a(s) / 2.0F, y, color, shadow);
/*   */   }
/*   */   public static final int drawCenteredString(@NotNull FontRenderer $this$drawCenteredString, @NotNull String s, float x, float y, int color) {
/* 8 */     Intrinsics.checkParameterIsNotNull($this$drawCenteredString, "$this$drawCenteredString"); Intrinsics.checkParameterIsNotNull(s, "s"); return $this$drawCenteredString.func_175065_a(s, x - $this$drawCenteredString.func_78256_a(s) / 2.0F, y, color, false);
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\extensions\RendererExtensionKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */