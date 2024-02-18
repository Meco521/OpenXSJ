/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\006\n\002\020\016\n\000\n\002\020\007\n\002\b\003\n\002\020\013\n\002\b\006\n\002\020\000\n\000\n\002\030\002\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J(\020\013\032\0020\0062\006\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\006H\026J0\020\013\032\0020\0062\006\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\0062\006\020\022\032\0020\023H\026J(\020\024\032\0020\0062\006\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\006H\026J(\020\025\032\0020\0062\006\020\026\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\006H\026J0\020\025\032\0020\0062\006\020\026\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\0062\006\020\022\032\0020\023H\026J(\020\025\032\0020\0062\006\020\026\032\0020\r2\006\020\016\032\0020\0062\006\020\020\032\0020\0062\006\020\021\032\0020\006H\026J(\020\027\032\0020\0062\006\020\f\032\0020\r2\006\020\016\032\0020\0062\006\020\020\032\0020\0062\006\020\021\032\0020\006H\026J\023\020\030\032\0020\0232\b\020\031\032\004\030\0010\032H\002J\b\020\033\032\0020\034H\026J\020\020\035\032\0020\0062\006\020\026\032\0020\rH\026J\b\020\036\032\0020\023H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/FontRendererImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "wrapped", "Lnet/minecraft/client/gui/FontRenderer;", "(Lnet/minecraft/client/gui/FontRenderer;)V", "fontHeight", "", "getFontHeight", "()I", "getWrapped", "()Lnet/minecraft/client/gui/FontRenderer;", "drawCenteredString", "text", "", "x", "", "y", "color", "shadow", "", "drawCenteredStringWithShadow", "drawString", "str", "drawStringWithShadow", "equals", "other", "", "getGameFontRenderer", "Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "getStringWidth", "isGameFontRenderer", "XSJClient"})
/*    */ public final class FontRendererImpl implements IFontRenderer {
/*    */   @NotNull
/*  9 */   public final FontRenderer getWrapped() { return this.wrapped; } @NotNull private final FontRenderer wrapped; public FontRendererImpl(@NotNull FontRenderer wrapped) { this.wrapped = wrapped; } public int getCharWidth(char character) { return IFontRenderer.DefaultImpls.getCharWidth(this, character); }
/*    */    public int getFontHeight() {
/* 11 */     return this.wrapped.field_78288_b;
/*    */   } public int getStringWidth(@NotNull String str) {
/* 13 */     Intrinsics.checkParameterIsNotNull(str, "str"); return this.wrapped.func_78256_a(str);
/*    */   }
/* 15 */   public int drawString(@NotNull String str, int x, int y, int color) { Intrinsics.checkParameterIsNotNull(str, "str"); return this.wrapped.func_78276_b(str, x, y, color); } public int drawString(@NotNull String str, float x, float y, int color) {
/* 16 */     Intrinsics.checkParameterIsNotNull(str, "str"); return this.wrapped.func_78276_b(str, (int)x, (int)y, color);
/*    */   } public int drawString(@NotNull String str, float x, float y, int color, boolean shadow) {
/* 18 */     Intrinsics.checkParameterIsNotNull(str, "str"); return this.wrapped.func_175065_a(str, x, y, color, shadow);
/*    */   } public int drawCenteredString(@NotNull String text, float x, float y, int color) {
/* 20 */     Intrinsics.checkParameterIsNotNull(text, "text"); return drawString(text, x - getStringWidth(text) / 2.0F, y, color);
/*    */   }
/* 22 */   public int drawCenteredString(@NotNull String text, float x, float y, int color, boolean shadow) { Intrinsics.checkParameterIsNotNull(text, "text"); return drawString(text, x - getStringWidth(text) / 2.0F, y, color, shadow); } public int drawCenteredStringWithShadow(@NotNull String text, float x, float y, int color) {
/* 23 */     Intrinsics.checkParameterIsNotNull(text, "text"); return drawCenteredString(text, x, y, color, true);
/*    */   } public int drawStringWithShadow(@NotNull String text, int x, int y, int color) {
/* 25 */     Intrinsics.checkParameterIsNotNull(text, "text"); return this.wrapped.func_175063_a(text, x, y, color);
/*    */   }
/* 27 */   public boolean isGameFontRenderer() { return this.wrapped instanceof FontRendererWrapper; } @NotNull
/*    */   public GameFontRenderer getGameFontRenderer() {
/* 29 */     if (this.wrapped == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.FontRendererWrapper");  if (((FontRendererWrapper)this.wrapped).getWrapped() == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.ui.font.GameFontRenderer");  return (GameFontRenderer)((FontRendererWrapper)this.wrapped).getWrapped();
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 32 */     return (other instanceof FontRendererImpl && Intrinsics.areEqual(((FontRendererImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\FontRendererImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */