/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\013\032\0020\fH\026J\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/TessellatorImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/ITessellator;", "wrapped", "Lnet/minecraft/client/renderer/Tessellator;", "(Lnet/minecraft/client/renderer/Tessellator;)V", "worldRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IWorldRenderer;", "getWorldRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IWorldRenderer;", "getWrapped", "()Lnet/minecraft/client/renderer/Tessellator;", "draw", "", "equals", "", "other", "", "XSJClient"})
/*    */ public final class TessellatorImpl implements ITessellator {
/*    */   @NotNull
/*  8 */   public final Tessellator getWrapped() { return this.wrapped; } @NotNull private final Tessellator wrapped; public TessellatorImpl(@NotNull Tessellator wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public IWorldRenderer getWorldRenderer() {
/* 10 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178180_c(), "wrapped.buffer"); return new WorldRendererImpl(this.wrapped.func_178180_c());
/*    */   } public void draw() {
/* 12 */     this.wrapped.func_78381_a();
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 15 */     return (other instanceof TessellatorImpl && Intrinsics.areEqual(((TessellatorImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\TessellatorImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */