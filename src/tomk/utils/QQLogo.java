/*    */ package tomk.utils;
/*    */ 
/*    */ import java.awt.AWTException;
/*    */ import java.io.IOException;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class QQLogo {
/*  8 */   public static String Name = "tomk";
/*  9 */   public static String version = "Build 2023";
/*    */   public static String username;
/*    */   
/*    */   public static void sendWindowsMessageLogin() throws AWTException, IOException {
/* 13 */     String AT = JOptionPane.showInputDialog("请输入QQ号");
/* 14 */     username = AT;
/*    */     
/* 16 */     isStarting = true;
/*    */ 
/*    */     
/* 19 */     if (username == null) {
/* 20 */       JOptionPane.showMessageDialog(null, "QQ号不能为空!", "Logoget", 0);
/* 21 */       System.exit(0);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isStarting;
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\QQLogo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */