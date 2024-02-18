/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\020\000\n\000\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ThreadDownloadImageDataImpl;", "T", "Lnet/minecraft/client/renderer/ThreadDownloadImageData;", "Lnet/ccbluex/liquidbounce/injection/backend/AbstractTextureImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IThreadDownloadImageData;", "wrapped", "(Lnet/minecraft/client/renderer/ThreadDownloadImageData;)V", "equals", "", "other", "", "XSJClient"})
/*   */ public final class ThreadDownloadImageDataImpl<T extends ThreadDownloadImageData> extends AbstractTextureImpl<T> implements IThreadDownloadImageData {
/*   */   public ThreadDownloadImageDataImpl(@NotNull ThreadDownloadImageData wrapped) {
/* 7 */     super((T)wrapped);
/*   */   } public boolean equals(@Nullable Object other) {
/* 9 */     return (other instanceof ThreadDownloadImageDataImpl && Intrinsics.areEqual(((ThreadDownloadImageDataImpl<ThreadDownloadImageData>)other).getWrapped(), (ThreadDownloadImageData)getWrapped()));
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ThreadDownloadImageDataImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */