/*    */ package me.sound;
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
/*    */             AudioInputStream as = AudioSystem.getAudioInputStream(new BufferedInputStream(Objects.<InputStream>requireNonNull(getClass().getResourceAsStream("/assets/minecraft/tomk/sound/" + st.getName()))));
/*    */             
/*    */             Clip clip = AudioSystem.getClip();
/*    */             
/*    */             clip.open(as);
/*    */             
/*    */             clip.start();
/*    */             FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
/*    */             gainControl.setValue(volume);
/*    */             clip.start();
/* 22 */           } catch (UnsupportedAudioFileException|java.io.IOException|javax.sound.sampled.LineUnavailableException e) {
/*    */             e.printStackTrace();
/*    */           } 
/* 25 */         })).start();
/*    */   }
/*    */   
/*    */   public enum SoundType
/*    */   {
/* 30 */     Enter("enter.wav"),
/* 31 */     Notification("notification.wav"),
/* 32 */     Startup("startup.wav"),
/* 33 */     ClickGuiOpen("clickguiopen.wav"),
/* 34 */     Ding("dingsound.wav"),
/* 35 */     Crack("cracksound.wav"),
/* 36 */     EDITION("ingame.wav"),
/* 37 */     MIDDLEOFNIGHT("middleofnight.wav"),
/* 38 */     ONMYOWN("onmyown.wav"),
/* 39 */     GUANGTOUQIANG("guangtouqang.wav"),
/* 40 */     VICTORY("victory.wav"),
/* 41 */     BACKDOOL("back.wav"),
/* 42 */     KELALAWIN("Kelalawin.wav"),
/*    */     
/* 44 */     KEQINGSTART("Keqingstart.wav"),
/* 45 */     KELIWIN("Keliwin.wav"),
/* 46 */     JINYUANWIN("Jinyuanwin.wav"),
/* 47 */     HUKEWIN("Hukewin.wav"),
/* 48 */     HEITAWIN("Heitawin.wav"),
/* 49 */     PAIMENWIN("Paimenwin.wav"),
/* 50 */     TINYUNWIN("Tinyunwin.wav"),
/* 51 */     WATWIN("Waertewin.wav"),
/* 52 */     FENGYUANWIN("Fengyuanwangyewin.wav"),
/* 53 */     AISHIDAWIN("Aishidanwin.wav"),
/* 54 */     LENGWIN("Lengwin.wav"),
/* 55 */     LENGKILL("LengKill.wav"),
/* 56 */     LENGDIED("Lengdied.wav"),
/* 57 */     YINLANKILL("Yinnankill.wav"),
/* 58 */     PEILABEGIN("Peilabegin.wav"),
/* 59 */     YINLANDIED("Yinnandied.wav"),
/* 60 */     GANYUDIED("Ganyudied.wav"),
/* 61 */     LUOCHASIHAO("Luochasihao.wav"),
/* 62 */     SKEET("skeet.wav"),
/* 63 */     NEKO("neko.wav"),
/* 64 */     SPECIAL("spec.wav");
/*    */     
/*    */     final String name;
/*    */ 
/*    */     
/*    */     SoundType(String fileName) {
/* 70 */       this.name = fileName;
/*    */     }
/*    */     String getName() {
/* 73 */       return this.name;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\me\sound\SoundPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */