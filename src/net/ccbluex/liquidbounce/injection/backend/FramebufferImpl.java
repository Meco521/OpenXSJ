/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\020\013\n\002\b\002\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\023\020\013\032\0020\n2\b\020\f\032\004\030\0010\rH\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/FramebufferImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IFramebuffer;", "wrapped", "Lnet/minecraft/client/shader/Framebuffer;", "(Lnet/minecraft/client/shader/Framebuffer;)V", "getWrapped", "()Lnet/minecraft/client/shader/Framebuffer;", "bindFramebuffer", "", "b", "", "equals", "other", "", "XSJClient"})
/*    */ public final class FramebufferImpl implements IFramebuffer {
/*    */   @NotNull
/*  7 */   public final Framebuffer getWrapped() { return this.wrapped; } @NotNull private final Framebuffer wrapped; public FramebufferImpl(@NotNull Framebuffer wrapped) { this.wrapped = wrapped; } public void bindFramebuffer(boolean b) {
/*  8 */     this.wrapped.func_147610_a(b);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 11 */     return (other instanceof FramebufferImpl && Intrinsics.areEqual(((FramebufferImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\FramebufferImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */