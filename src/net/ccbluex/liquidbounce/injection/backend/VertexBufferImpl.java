/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\007\032\0020\bH\026J\020\020\t\032\0020\b2\006\020\n\032\0020\013H\026J\b\020\f\032\0020\bH\026J\020\020\r\032\0020\b2\006\020\016\032\0020\017H\026J\023\020\020\032\0020\0212\b\020\022\032\004\030\0010\023H\002J\b\020\024\032\0020\bH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/VertexBufferImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/vertex/IVertexBuffer;", "wrapped", "Lnet/minecraft/client/renderer/vertex/VertexBuffer;", "(Lnet/minecraft/client/renderer/vertex/VertexBuffer;)V", "getWrapped", "()Lnet/minecraft/client/renderer/vertex/VertexBuffer;", "bindBuffer", "", "bufferData", "buffer", "Ljava/nio/ByteBuffer;", "deleteGlBuffers", "drawArrays", "mode", "", "equals", "", "other", "", "unbindBuffer", "XSJClient"})
/*    */ public final class VertexBufferImpl implements IVertexBuffer {
/*    */   @NotNull
/*  8 */   public final VertexBuffer getWrapped() { return this.wrapped; } @NotNull private final VertexBuffer wrapped; public VertexBufferImpl(@NotNull VertexBuffer wrapped) { this.wrapped = wrapped; } public void deleteGlBuffers() {
/*  9 */     this.wrapped.func_177362_c();
/*    */   } public void bindBuffer() {
/* 11 */     this.wrapped.func_177359_a();
/*    */   } public void drawArrays(int mode) {
/* 13 */     this.wrapped.func_177358_a(mode);
/*    */   } public void unbindBuffer() {
/* 15 */     this.wrapped.func_177361_b();
/*    */   } public void bufferData(@NotNull ByteBuffer buffer) {
/* 17 */     Intrinsics.checkParameterIsNotNull(buffer, "buffer"); this.wrapped.func_181722_a(buffer);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 20 */     return (other instanceof VertexBufferImpl && Intrinsics.areEqual(((VertexBufferImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\VertexBufferImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */