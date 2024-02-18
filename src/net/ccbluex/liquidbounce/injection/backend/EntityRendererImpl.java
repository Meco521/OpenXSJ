/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\007\n\000\n\002\020\b\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\013\032\0020\fH\026J\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002J\b\020\021\032\0020\016H\026J\020\020\022\032\0020\f2\006\020\023\032\0020\024H\026J\020\020\025\032\0020\f2\006\020\023\032\0020\026H\026J\030\020\027\032\0020\f2\006\020\030\032\0020\0312\006\020\032\032\0020\033H\026J\b\020\034\032\0020\fH\026J\b\020\035\032\0020\fH\026R\026\020\005\032\004\030\0010\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EntityRendererImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IEntityRenderer;", "wrapped", "Lnet/minecraft/client/renderer/EntityRenderer;", "(Lnet/minecraft/client/renderer/EntityRenderer;)V", "shaderGroup", "Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IShaderGroup;", "getShaderGroup", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IShaderGroup;", "getWrapped", "()Lnet/minecraft/client/renderer/EntityRenderer;", "disableLightmap", "", "equals", "", "other", "", "isShaderActive", "loadShader", "resourceLocation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "loadShader2", "Lnet/minecraft/util/ResourceLocation;", "setupCameraTransform", "partialTicks", "", "pass", "", "setupOverlayRendering", "stopUseShader", "XSJClient"})
/*    */ public final class EntityRendererImpl implements IEntityRenderer {
/*    */   @NotNull
/*    */   private final EntityRenderer wrapped;
/*    */   
/*    */   @NotNull
/* 10 */   public final EntityRenderer getWrapped() { return this.wrapped; } public EntityRendererImpl(@NotNull EntityRenderer wrapped) { this.wrapped = wrapped; }
/*    */   public void disableLightmap() { this.wrapped.func_175072_h(); } @Nullable
/* 12 */   public IShaderGroup getShaderGroup() { ShaderGroup $this$wrap$iv = this.wrapped.func_147706_e(); int $i$f$wrap = 0; this.wrapped.func_147706_e(); return (this.wrapped.func_147706_e() != null) ? 
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
/* 33 */       new ShaderGroupImpl($this$wrap$iv) : null; } public void loadShader2(@NotNull ResourceLocation resourceLocation) { Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation"); ResourceLocation resourceLocation1 = resourceLocation; EntityRenderer entityRenderer = this.wrapped; boolean bool1 = false, bool2 = false; ResourceLocation it = resourceLocation1; int $i$a$-also-EntityRendererImpl$loadShader2$1 = 0; IEntityRenderer $this$unwrap$iv = this; int $i$f$unwrap = 0;
/* 34 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityRendererImpl");  ((EntityRendererImpl)$this$unwrap$iv).getWrapped(); ResourceLocation resourceLocation2 = resourceLocation1; entityRenderer.func_175069_a(resourceLocation2); } public boolean isShaderActive() { return this.wrapped.func_147702_a(); }
/* 35 */   public void loadShader(@NotNull IResourceLocation resourceLocation) { Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation"); IResourceLocation iResourceLocation = resourceLocation; EntityRenderer entityRenderer = this.wrapped; int $i$f$unwrap = 0; ResourceLocation resourceLocation1 = ((ResourceLocationImpl)iResourceLocation).getWrapped(); entityRenderer.func_175069_a(resourceLocation1); }
/*    */ 
/*    */   
/*    */   public void stopUseShader() {
/*    */     this.wrapped.func_181022_b();
/*    */   }
/*    */   
/*    */   public void setupCameraTransform(float partialTicks, int pass) {
/*    */     this.wrapped.func_78479_a(partialTicks, pass);
/*    */   }
/*    */   
/*    */   public void setupOverlayRendering() {
/*    */     this.wrapped.func_78478_c();
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof EntityRendererImpl && Intrinsics.areEqual(((EntityRendererImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EntityRendererImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */