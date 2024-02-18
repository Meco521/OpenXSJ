/*    */ package net.ccbluex.liquidbounce.ui.Verify1.utils;
/*    */ import java.awt.AWTException;
/*    */ import java.awt.Image;
/*    */ import java.awt.SystemTray;
/*    */ import java.awt.TrayIcon;
/*    */ 
/*    */ public class SystemUtils {
/*    */   public static boolean main(String Title, String Text, TrayIcon.MessageType type) throws AWTException {
/*  9 */     if (SystemTray.isSupported()) {
/* 10 */       new SystemUtils();
/* 11 */       displayTray(Title, Text, type);
/* 12 */       return false;
/*    */     } 
/* 14 */     System.err.println("LiquidBounce By CCBlueX");
/* 15 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void displayTray(String Title, String Text, TrayIcon.MessageType type) throws AWTException {
/* 20 */     SystemTray tray = SystemTray.getSystemTray();
/* 21 */     Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
/* 22 */     TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
/*    */     
/* 24 */     trayIcon.setImageAutoSize(true);
/* 25 */     trayIcon.setToolTip("System tray icon demo");
/* 26 */     tray.add(trayIcon);
/* 27 */     trayIcon.displayMessage(Title, Text, type);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify\\utils\SystemUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */