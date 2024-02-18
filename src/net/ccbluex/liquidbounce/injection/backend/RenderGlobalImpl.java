/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002J\b\020\013\032\0020\fH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/RenderGlobalImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IRenderGlobal;", "wrapped", "Lnet/minecraft/client/renderer/RenderGlobal;", "(Lnet/minecraft/client/renderer/RenderGlobal;)V", "getWrapped", "()Lnet/minecraft/client/renderer/RenderGlobal;", "equals", "", "other", "", "loadRenderers", "", "XSJClient"})
/*    */ public final class RenderGlobalImpl implements IRenderGlobal {
/*    */   @NotNull
/*  7 */   public final RenderGlobal getWrapped() { return this.wrapped; } @NotNull private final RenderGlobal wrapped; public RenderGlobalImpl(@NotNull RenderGlobal wrapped) { this.wrapped = wrapped; } public void loadRenderers() {
/*  8 */     this.wrapped.func_72712_a();
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 11 */     return (other instanceof RenderGlobalImpl && Intrinsics.areEqual(((RenderGlobalImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\RenderGlobalImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */