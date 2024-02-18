/*    */ package me.sound;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ public class Sound
/*    */ {
/*    */   public static Sound INSTANCE;
/*  9 */   public static final Minecraft mc = Minecraft.func_71410_x();
/*    */   
/*    */   private static boolean notificationsAllowed = false;
/*    */   
/*    */   public static void notificationsAllowed(boolean value) {
/* 14 */     notificationsAllowed = value;
/*    */   }
/*    */   
/*    */   public Sound() {
/* 18 */     (new SoundPlayer()).playSound(SoundPlayer.SoundType.SPECIAL, 10.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void Volll() {
/* 23 */     (new SoundPlayer()).playSound(SoundPlayer.SoundType.VICTORY, 10.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\me\sound\Sound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */