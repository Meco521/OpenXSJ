/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\020\020\013\032\0020\b2\006\020\t\032\0020\fH\026J\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002J\030\020\021\032\0020\0162\006\020\022\032\0020\n2\006\020\023\032\0020\024H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/TextureManagerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;", "wrapped", "Lnet/minecraft/client/renderer/texture/TextureManager;", "(Lnet/minecraft/client/renderer/texture/TextureManager;)V", "getWrapped", "()Lnet/minecraft/client/renderer/texture/TextureManager;", "bindTexture", "", "image", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "bindTexture2", "Lnet/minecraft/util/ResourceLocation;", "equals", "", "other", "", "loadTexture", "textureLocation", "textureObj", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/IAbstractTexture;", "XSJClient"})
/*    */ public final class TextureManagerImpl implements ITextureManager {
/*    */   @NotNull
/* 10 */   public final TextureManager getWrapped() { return this.wrapped; } @NotNull private final TextureManager wrapped; public TextureManagerImpl(@NotNull TextureManager wrapped) { this.wrapped = wrapped; }
/* 11 */   public boolean loadTexture(@NotNull IResourceLocation textureLocation, @NotNull IAbstractTexture textureObj) { Intrinsics.checkParameterIsNotNull(textureLocation, "textureLocation"); Intrinsics.checkParameterIsNotNull(textureObj, "textureObj"); IResourceLocation iResourceLocation = textureLocation; TextureManager textureManager = this.wrapped; int $i$f$unwrap = 0;
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
/* 22 */     ResourceLocation resourceLocation = ((ResourceLocationImpl)iResourceLocation).getWrapped(); IAbstractTexture iAbstractTexture = textureObj; resourceLocation = resourceLocation; textureManager = textureManager; $i$f$unwrap = 0;
/* 23 */     ITextureObject iTextureObject = (ITextureObject)((AbstractTextureImpl<Object>)iAbstractTexture).getWrapped(); return textureManager.func_110579_a(resourceLocation, iTextureObject); } public void bindTexture(@NotNull IResourceLocation image) { Intrinsics.checkParameterIsNotNull(image, "image"); IResourceLocation iResourceLocation = image; TextureManager textureManager = this.wrapped; int $i$f$unwrap = 0;
/* 24 */     ResourceLocation resourceLocation = ((ResourceLocationImpl)iResourceLocation).getWrapped(); textureManager.func_110577_a(resourceLocation); } public void bindTexture2(@NotNull ResourceLocation image) { Intrinsics.checkParameterIsNotNull(image, "image"); ResourceLocation resourceLocation1 = image; TextureManager textureManager = this.wrapped; boolean bool1 = false, bool2 = false; ResourceLocation it = resourceLocation1; int $i$a$-also-TextureManagerImpl$bindTexture2$1 = 0; ITextureManager $this$unwrap$iv = this; int $i$f$unwrap = 0;
/* 25 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.TextureManagerImpl");  ((TextureManagerImpl)$this$unwrap$iv).getWrapped();
/*    */     ResourceLocation resourceLocation2 = resourceLocation1;
/*    */     textureManager.func_110577_a(resourceLocation2); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof TextureManagerImpl && Intrinsics.areEqual(((TextureManagerImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\TextureManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */