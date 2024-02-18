/*    */ package lynn.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.sound.sampled.AudioInputStream;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.Clip;
/*    */ 
/*    */ public class TipSoundPlayer
/*    */ {
/*    */   public TipSoundPlayer(File file) {
/* 11 */     this.file = file;
/*    */   }
/*    */   private final File file;
/*    */   public void asyncPlay() {
/* 15 */     (new Thread(this::playSound)).start();
/*    */   }
/*    */   
/*    */   public void playSound() {
/*    */     try {
/* 20 */       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.file);
/* 21 */       Clip clip = AudioSystem.getClip();
/* 22 */       clip.open(audioInputStream);
/* 23 */       clip.start();
/* 24 */     } catch (Exception ex) {
/* 25 */       System.out.println("Error with playing sound.");
/* 26 */       ex.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\TipSoundPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */