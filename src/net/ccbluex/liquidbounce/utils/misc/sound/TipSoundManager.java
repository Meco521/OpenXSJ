/*    */ package net.ccbluex.liquidbounce.utils.misc.sound;
/*    */ 
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.utils.FileUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\b\030\0002\0020\001B\005¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\b¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundManager;", "", "()V", "disableSound", "Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundPlayer;", "getDisableSound", "()Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundPlayer;", "setDisableSound", "(Lnet/ccbluex/liquidbounce/utils/misc/sound/TipSoundPlayer;)V", "enableSound", "getEnableSound", "setEnableSound", "XSJClient"})
/*    */ public final class TipSoundManager {
/*    */   public TipSoundManager() {
/* 13 */     File enableSoundFile = new File((Retreat.INSTANCE.getFileManager()).soundsDir, "enable.wav");
/* 14 */     File disableSoundFile = new File((Retreat.INSTANCE.getFileManager()).soundsDir, "disable.wav");
/*    */     
/* 16 */     if (!enableSoundFile.exists())
/* 17 */       FileUtils.unpackFile(enableSoundFile, "assets/minecraft/tomk/sound/enable.wav"); 
/* 18 */     if (!disableSoundFile.exists()) {
/* 19 */       FileUtils.unpackFile(disableSoundFile, "assets/minecraft/tomk/sound/disable.wav");
/*    */     }
/* 21 */     this.enableSound = new TipSoundPlayer(enableSoundFile);
/* 22 */     this.disableSound = new TipSoundPlayer(disableSoundFile);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   private TipSoundPlayer enableSound;
/*    */   @NotNull
/*    */   private TipSoundPlayer disableSound;
/*    */   
/*    */   @NotNull
/*    */   public final TipSoundPlayer getEnableSound() {
/*    */     return this.enableSound;
/*    */   }
/*    */   
/*    */   public final void setEnableSound(@NotNull TipSoundPlayer <set-?>) {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     this.enableSound = <set-?>;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final TipSoundPlayer getDisableSound() {
/*    */     return this.disableSound;
/*    */   }
/*    */   
/*    */   public final void setDisableSound(@NotNull TipSoundPlayer <set-?>) {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     this.disableSound = <set-?>;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\sound\TipSoundManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */