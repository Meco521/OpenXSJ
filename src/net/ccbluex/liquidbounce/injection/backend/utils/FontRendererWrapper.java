/*    */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.util.IWrappedFontRenderer;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\b\n\000\n\002\020\016\n\000\n\002\020\007\n\002\b\003\n\002\020\013\n\002\b\003\n\002\020\f\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J2\020\007\032\0020\b2\b\020\t\032\004\030\0010\n2\006\020\013\032\0020\f2\006\020\r\032\0020\f2\006\020\016\032\0020\b2\006\020\017\032\0020\020H\026J*\020\007\032\0020\b2\b\020\t\032\004\030\0010\n2\006\020\013\032\0020\b2\006\020\r\032\0020\b2\006\020\016\032\0020\bH\026J*\020\021\032\0020\b2\b\020\t\032\004\030\0010\n2\006\020\013\032\0020\f2\006\020\r\032\0020\f2\006\020\016\032\0020\bH\026J\020\020\022\032\0020\b2\006\020\023\032\0020\024H\026J\020\020\025\032\0020\b2\006\020\023\032\0020\024H\026J\022\020\026\032\0020\b2\b\020\t\032\004\030\0010\nH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/utils/FontRendererWrapper;", "Lnet/minecraft/client/gui/FontRenderer;", "wrapped", "Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;", "(Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;)V", "getWrapped", "()Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;", "drawString", "", "text", "", "x", "", "y", "color", "dropShadow", "", "drawStringWithShadow", "getCharWidth", "character", "", "getColorCode", "getStringWidth", "XSJClient"})
/*    */ public final class FontRendererWrapper extends FontRenderer {
/*    */   @NotNull
/*  9 */   public final IWrappedFontRenderer getWrapped() { return this.wrapped; } @NotNull private final IWrappedFontRenderer wrapped; public FontRendererWrapper(@NotNull IWrappedFontRenderer wrapped) { super((Minecraft.func_71410_x()).field_71474_y, 
/* 10 */         new ResourceLocation("textures/font/ascii.png"), 
/*    */ 
/*    */         
/* 13 */         Minecraft.func_71410_x().func_110434_K(), 
/* 14 */         false);
/*    */     this.wrapped = wrapped; } public int func_78276_b(@Nullable String text, int x, int y, int color) {
/* 16 */     return this.wrapped.drawString(text, x, y, color);
/*    */   } public int func_175065_a(@Nullable String text, float x, float y, int color, boolean dropShadow) {
/* 18 */     return this.wrapped.drawString(text, x, y, color, dropShadow);
/*    */   } public int func_175063_a(@Nullable String text, float x, float y, int color) {
/* 20 */     return this.wrapped.drawStringWithShadow(text, x, y, color);
/*    */   } public int func_175064_b(char character) {
/* 22 */     return this.wrapped.getColorCode(character);
/*    */   } public int func_78256_a(@Nullable String text) {
/* 24 */     return this.wrapped.getStringWidth(text);
/*    */   } public int func_78263_a(char character) {
/* 26 */     return this.wrapped.getCharWidth(character);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\FontRendererWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */