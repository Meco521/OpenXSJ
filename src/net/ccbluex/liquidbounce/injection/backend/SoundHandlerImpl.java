/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.minecraft.client.audio.SoundHandler;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\002\n\000\n\002\020\016\n\000\n\002\020\007\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002J\030\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\020H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SoundHandlerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;", "wrapped", "Lnet/minecraft/client/audio/SoundHandler;", "(Lnet/minecraft/client/audio/SoundHandler;)V", "getWrapped", "()Lnet/minecraft/client/audio/SoundHandler;", "equals", "", "other", "", "playSound", "", "name", "", "pitch", "", "XSJClient"})
/*    */ public final class SoundHandlerImpl implements ISoundHandler {
/*    */   @NotNull
/* 10 */   public final SoundHandler getWrapped() { return this.wrapped; } @NotNull private final SoundHandler wrapped; public SoundHandlerImpl(@NotNull SoundHandler wrapped) { this.wrapped = wrapped; } public void playSound(@NotNull String name, float pitch) {
/* 11 */     Intrinsics.checkParameterIsNotNull(name, "name"); this.wrapped.func_147682_a((ISound)PositionedSoundRecord.func_194007_a(new SoundEvent(new ResourceLocation(name)), pitch, 1.0F));
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 15 */     return (other instanceof SoundHandlerImpl && Intrinsics.areEqual(((SoundHandlerImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SoundHandlerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */