/*    */ package net.ccbluex.liquidbounce.ui.Verify1.utils;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class HWIDUtils {
/*    */   public static String getHWID() throws NoSuchAlgorithmException, UnsupportedEncodingException {
/*  8 */     StringBuilder s = new StringBuilder();
/*  9 */     String main = System.getenv("PROCESS_IDENTIFIER") + System.getenv("COMPUTERNAME");
/* 10 */     byte[] bytes = main.getBytes("UTF-8");
/* 11 */     MessageDigest messageDigest = MessageDigest.getInstance("MD5");
/* 12 */     byte[] md5 = messageDigest.digest(bytes);
/* 13 */     int i = 0;
/* 14 */     for (byte b : md5) {
/* 15 */       s.append(Integer.toHexString(b & 0xFF | 0x300), 0, 3);
/* 16 */       if (i != md5.length - 1) {
/* 17 */         s.append("-");
/*    */       }
/* 19 */       i++;
/*    */     } 
/* 21 */     return s.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify\\utils\HWIDUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */