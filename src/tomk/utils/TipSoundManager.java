/*    */ package tomk.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.utils.render.tenacity.FileUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\013\030\0002\0020\001B\005¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\004X\016¢\006\016\n\000\032\004\b\r\020\006\"\004\b\016\020\b¨\006\017"}, d2 = {"Ltomk/utils/TipSoundManager;", "", "()V", "disableSound", "Ltomk/utils/TipSoundPlayer;", "getDisableSound", "()Ltomk/utils/TipSoundPlayer;", "setDisableSound", "(Ltomk/utils/TipSoundPlayer;)V", "enableSound", "getEnableSound", "setEnableSound", "mew", "getMew", "setMew", "XSJClient"})
/*    */ public final class TipSoundManager {
/*    */   public TipSoundManager() {
/* 13 */     File enableSoundFile = new File((Retreat.INSTANCE.getFileManager()).soundsDir, "enable.wav");
/* 14 */     File disableSoundFile = new File((Retreat.INSTANCE.getFileManager()).soundsDir, "disable.wav");
/* 15 */     File mewFile = new File((Retreat.INSTANCE.getFileManager()).soundsDir, "enable.wav");
/* 16 */     if (!enableSoundFile.exists())
/* 17 */       FileUtils.unpackFile(enableSoundFile, "assets/minecraft/onlooker/sounds/enable.wav"); 
/* 18 */     if (!mewFile.exists())
/* 19 */       FileUtils.unpackFile(mewFile, "assets/minecraft/onlooker/sounds/enable.wav"); 
/* 20 */     if (!disableSoundFile.exists())
/* 21 */       FileUtils.unpackFile(disableSoundFile, "assets/minecraft/onlooker/sounds/disable.wav"); 
/* 22 */     this.mew = new TipSoundPlayer(mewFile);
/* 23 */     this.enableSound = new TipSoundPlayer(enableSoundFile);
/* 24 */     this.disableSound = new TipSoundPlayer(disableSoundFile);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   private TipSoundPlayer enableSound;
/*    */   @NotNull
/*    */   private TipSoundPlayer disableSound;
/*    */   @NotNull
/*    */   private TipSoundPlayer mew;
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
/*    */   
/*    */   @NotNull
/*    */   public final TipSoundPlayer getMew() {
/*    */     return this.mew;
/*    */   }
/*    */   
/*    */   public final void setMew(@NotNull TipSoundPlayer <set-?>) {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     this.mew = <set-?>;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\TipSoundManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */