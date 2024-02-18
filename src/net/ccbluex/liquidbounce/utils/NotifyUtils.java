/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class NotifyUtils {
/*    */   public static void notice(String title, String message) {
/*  7 */     JOptionPane.getRootFrame().setAlwaysOnTop(true);
/*  8 */     JOptionPane.showMessageDialog(null, message, title, 2);
/*    */   }
/*    */   
/*    */   public static String showInputDialog(String message) {
/* 12 */     JOptionPane.getRootFrame().setAlwaysOnTop(true);
/* 13 */     return JOptionPane.showInputDialog(message);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\NotifyUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */