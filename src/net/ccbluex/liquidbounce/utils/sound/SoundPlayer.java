/*    */ package net.ccbluex.liquidbounce.utils.sound;
/*    */ import java.io.BufferedInputStream;
/*    */ import javax.sound.sampled.AudioInputStream;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.Clip;
/*    */ import javax.sound.sampled.FloatControl;
/*    */ 
/*    */ public class SoundPlayer {
/*    */   public void playSound(SoundType st, float volume) {
/* 10 */     (new Thread(() -> {
/*    */           try {
/*    */             AudioInputStream as = AudioSystem.getAudioInputStream(new BufferedInputStream(Objects.<InputStream>requireNonNull(getClass().getResourceAsStream("/assets/minecraft/soar/sounds/" + st.getName()))));
/*    */             
/*    */             Clip clip = AudioSystem.getClip();
/*    */             
/*    */             clip.open(as);
/*    */             clip.start();
/*    */             FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
/*    */             gainControl.setValue(volume);
/*    */             clip.start();
/* 21 */           } catch (UnsupportedAudioFileException|java.io.IOException|javax.sound.sampled.LineUnavailableException e) {
/*    */             e.printStackTrace();
/*    */           } 
/* 24 */         })).start();
/*    */   }
/*    */   
/*    */   public enum SoundType
/*    */   {
/* 29 */     WIN("mvp.wav");
/*    */     
/*    */     final String name;
/*    */ 
/*    */     
/*    */     SoundType(String fileName) {
/* 35 */       this.name = fileName;
/*    */     }
/*    */     String getName() {
/* 38 */       return this.name;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\sound\SoundPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */