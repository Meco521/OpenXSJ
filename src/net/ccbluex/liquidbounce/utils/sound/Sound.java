/*    */ package net.ccbluex.liquidbounce.utils.sound;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*    */ import net.minecraft.client.renderer.EntityRenderer;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Sound
/*    */ {
/*    */   public static Sound INSTANCE;
/* 15 */   public static final Minecraft mc = Minecraft.func_71410_x();
/*    */   public static boolean canSendMotionPacket = true;
/*    */   private static boolean notificationsAllowed = false;
/*    */   public static boolean hasOptifine = false;
/*    */   
/*    */   public static EntityRenderer getEntityRenderer() {
/* 21 */     return (getMinecraft()).field_71460_t;
/*    */   }
/*    */   
/*    */   public static Minecraft getMinecraft() {
/* 25 */     return Minecraft.func_71410_x();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static PlayerControllerMP getPlayerController() {
/* 31 */     return (getMinecraft()).field_71442_b;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static GameSettings getGameSettings() {
/* 37 */     return (getMinecraft()).field_71474_y;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean notificationsAllowed() {
/* 47 */     return notificationsAllowed;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Color getClientColor() {
/* 52 */     return new Color(236, 133, 209);
/*    */   }
/*    */   
/*    */   public static Color getAlternateClientColor() {
/* 56 */     return new Color(28, 167, 222);
/*    */   }
/*    */   
/*    */   public static void notificationsAllowed(boolean value) {
/* 60 */     notificationsAllowed = value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void SOUND() {
/* 67 */     (new SoundPlayer()).playSound(SoundPlayer.SoundType.WIN, Retreat.moduleManager.getToggleVolume());
/*    */   }
/*    */   public boolean fastRenderDisabled(GameSettings gameSettingsIn) {
/*    */     try {
/* 71 */       return !fastRenderDisabled(gameSettingsIn);
/* 72 */     } catch (Exception exception) {
/*    */       
/* 74 */       return true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\sound\Sound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */