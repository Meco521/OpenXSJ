/*    */ package net.ccbluex.liquidbounce.utils.misc;
/*    */ 
/*    */ import java.awt.Desktop;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.net.URI;
/*    */ import javax.swing.JFileChooser;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JOptionPane;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ public final class MiscUtils
/*    */   extends MinecraftInstance {
/*    */   public static void showErrorPopup(String title, String message) {
/* 15 */     JOptionPane.showMessageDialog(null, message, title, 0);
/*    */   }
/*    */   
/*    */   public static void showURL(String url) {
/*    */     try {
/* 20 */       Desktop.getDesktop().browse(new URI(url));
/* 21 */     } catch (IOException|java.net.URISyntaxException e) {
/* 22 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static File openFileChooser() {
/* 27 */     if (mc.isFullScreen()) {
/* 28 */       mc.toggleFullscreen();
/*    */     }
/* 30 */     JFileChooser fileChooser = new JFileChooser();
/* 31 */     JFrame frame = new JFrame();
/*    */     
/* 33 */     fileChooser.setFileSelectionMode(0);
/*    */     
/* 35 */     frame.setVisible(true);
/* 36 */     frame.toFront();
/* 37 */     frame.setVisible(false);
/*    */     
/* 39 */     int action = fileChooser.showOpenDialog(frame);
/* 40 */     frame.dispose();
/*    */     
/* 42 */     return (action == 0) ? fileChooser.getSelectedFile() : null;
/*    */   }
/*    */   
/*    */   public static File saveFileChooser() {
/* 46 */     if (mc.isFullScreen()) {
/* 47 */       mc.toggleFullscreen();
/*    */     }
/* 49 */     JFileChooser fileChooser = new JFileChooser();
/* 50 */     JFrame frame = new JFrame();
/*    */     
/* 52 */     fileChooser.setFileSelectionMode(0);
/*    */     
/* 54 */     frame.setVisible(true);
/* 55 */     frame.toFront();
/* 56 */     frame.setVisible(false);
/*    */     
/* 58 */     int action = fileChooser.showSaveDialog(frame);
/* 59 */     frame.dispose();
/*    */     
/* 61 */     return (action == 0) ? fileChooser.getSelectedFile() : null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\MiscUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */