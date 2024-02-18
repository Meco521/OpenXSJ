/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ 
/*   */ import net.minecraft.client.renderer.vertex.VertexFormat;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/VertexFormatImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "wrapped", "Lnet/minecraft/client/renderer/vertex/VertexFormat;", "(Lnet/minecraft/client/renderer/vertex/VertexFormat;)V", "getWrapped", "()Lnet/minecraft/client/renderer/vertex/VertexFormat;", "equals", "", "other", "", "XSJClient"})
/*   */ public final class VertexFormatImpl implements IVertexFormat {
/* 7 */   public VertexFormatImpl(@NotNull VertexFormat wrapped) { this.wrapped = wrapped; } @NotNull private final VertexFormat wrapped; @NotNull public final VertexFormat getWrapped() { return this.wrapped; }
/*   */    public boolean equals(@Nullable Object other) {
/* 9 */     return (other instanceof VertexFormatImpl && Intrinsics.areEqual(((VertexFormatImpl)other).wrapped, this.wrapped));
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\VertexFormatImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */