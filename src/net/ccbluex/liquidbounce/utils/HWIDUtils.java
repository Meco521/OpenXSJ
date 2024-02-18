/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HWIDUtils
/*    */ {
/*    */   public static String getHWID() {
/*    */     try {
/* 14 */       StringBuilder s = new StringBuilder();
/* 15 */       String main = System.getenv("PROCESS_IDENTIFIER") + System.getenv("COMPUTERNAME");
/* 16 */       byte[] bytes = main.getBytes(StandardCharsets.UTF_8);
/* 17 */       MessageDigest messageDigest = MessageDigest.getInstance("SHA");
/* 18 */       byte[] sha = messageDigest.digest(bytes);
/* 19 */       int i = 0;
/* 20 */       for (byte b : sha) {
/* 21 */         s.append(Integer.toHexString(b & 0xFF | 0x300), 0, 3);
/* 22 */         if (i != sha.length - 1) {
/* 23 */           s.append("-");
/*    */         }
/* 25 */         i++;
/*    */       } 
/* 27 */       return s.toString();
/* 28 */     } catch (NoSuchAlgorithmException e) {
/* 29 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\HWIDUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */