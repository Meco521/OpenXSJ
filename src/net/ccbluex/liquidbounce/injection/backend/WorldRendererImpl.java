/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\020\006\n\002\b\007\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\030\020\017\032\0020\0202\006\020\021\032\0020\0222\006\020\t\032\0020\nH\026J(\020\023\032\0020\0012\006\020\024\032\0020\0252\006\020\026\032\0020\0252\006\020\027\032\0020\0252\006\020\030\032\0020\025H\026J\b\020\031\032\0020\020H\026J\023\020\032\032\0020\0332\b\020\034\032\004\030\0010\035H\002J\b\020\036\032\0020\020H\026J \020\037\032\0020\0012\006\020 \032\0020!2\006\020\"\032\0020!2\006\020#\032\0020!H\026J\b\020$\032\0020\020H\026J\030\020%\032\0020\0012\006\020&\032\0020!2\006\020'\032\0020!H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006("}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/WorldRendererImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IWorldRenderer;", "wrapped", "Lnet/minecraft/client/renderer/BufferBuilder;", "(Lnet/minecraft/client/renderer/BufferBuilder;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "vertexFormat", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "getVertexFormat", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "getWrapped", "()Lnet/minecraft/client/renderer/BufferBuilder;", "begin", "", "mode", "", "color", "red", "", "green", "blue", "alpha", "endVertex", "equals", "", "other", "", "finishDrawing", "pos", "x", "", "y", "z", "reset", "tex", "u", "v", "XSJClient"})
/*    */ public final class WorldRendererImpl implements IWorldRenderer {
/*    */   @NotNull
/*  9 */   public final BufferBuilder getWrapped() { return this.wrapped; } @NotNull private final BufferBuilder wrapped; public WorldRendererImpl(@NotNull BufferBuilder wrapped) { this.wrapped = wrapped; }
/*    */   @NotNull
/* 11 */   public ByteBuffer getByteBuffer() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178966_f(), "wrapped.byteBuffer"); return this.wrapped.func_178966_f(); } @NotNull
/*    */   public IVertexFormat getVertexFormat() {
/* 13 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178973_g(), "wrapped.vertexFormat"); VertexFormat $this$wrap$iv = this.wrapped.func_178973_g(); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 45 */       new VertexFormatImpl($this$wrap$iv);
/*    */   }
/*    */   
/*    */   public void begin(int mode, @NotNull IVertexFormat vertexFormat) {
/*    */     Intrinsics.checkParameterIsNotNull(vertexFormat, "vertexFormat");
/*    */     this.wrapped.func_181668_a(mode, ((VertexFormatImpl)vertexFormat).getWrapped());
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IWorldRenderer pos(double x, double y, double z) {
/*    */     this.wrapped.func_181662_b(x, y, z);
/*    */     return this;
/*    */   }
/*    */   
/*    */   public void endVertex() {
/*    */     this.wrapped.func_181675_d();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IWorldRenderer tex(double u, double v) {
/*    */     this.wrapped.func_187315_a(u, v);
/*    */     return this;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IWorldRenderer color(float red, float green, float blue, float alpha) {
/*    */     this.wrapped.func_181666_a(red, green, blue, alpha);
/*    */     return this;
/*    */   }
/*    */   
/*    */   public void finishDrawing() {
/*    */     this.wrapped.func_178977_d();
/*    */   }
/*    */   
/*    */   public void reset() {
/*    */     this.wrapped.func_178965_a();
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof WorldRendererImpl && Intrinsics.areEqual(((WorldRendererImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\WorldRendererImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */