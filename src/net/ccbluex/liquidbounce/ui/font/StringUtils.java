/*    */ package net.ccbluex.liquidbounce.ui.font;
/*    */ 
/*    */ import java.util.concurrent.ThreadLocalRandom;
/*    */ 
/*    */ public class StringUtils {
/*    */   public static String randomStringDefault(int length) {
/*  7 */     return randomString("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_", length);
/*    */   }
/*    */   
/*    */   public static String randomString(String pool, int length) {
/* 11 */     StringBuilder builder = new StringBuilder();
/*    */     
/* 13 */     for (int i = 0; i < length; i++) {
/* 14 */       builder.append(pool.charAt(ThreadLocalRandom.current().nextInt(0, pool.length() - 1)));
/*    */     }
/*    */     
/* 17 */     return builder.toString();
/*    */   }
/*    */   
/*    */   public static boolean isBlank(String s) {
/* 21 */     if (s == null) {
/* 22 */       return true;
/*    */     }
/* 24 */     for (int i = 0; i < s.length(); i++) {
/* 25 */       if (!Character.isWhitespace(s.charAt(i))) {
/* 26 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean isEmojiCharacter(char codePoint) {
/* 35 */     return (codePoint == '\000' || codePoint == '\t' || codePoint == '\n' || codePoint == '\r' || (codePoint >= ' ' && codePoint <= '퟿') || (codePoint >= '' && codePoint <= '�') || (codePoint >= 65536 && codePoint <= 1114111));
/*    */   }
/*    */   
/*    */   public static String filterEmoji(String source) {
/* 39 */     if (isBlank(source)) {
/* 40 */       return source;
/*    */     }
/* 42 */     StringBuilder buf = null;
/* 43 */     int len = source.length();
/*    */     
/* 45 */     for (int i = 0; i < len; i++) {
/* 46 */       char codePoint = source.charAt(i);
/* 47 */       if (isEmojiCharacter(codePoint)) {
/* 48 */         if (buf == null) {
/* 49 */           buf = new StringBuilder(source.length());
/*    */         }
/*    */         
/* 52 */         buf.append(codePoint);
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     if (buf == null)
/* 57 */       return source; 
/* 58 */     if (buf.length() == len) {
/* 59 */       return source;
/*    */     }
/* 61 */     return buf.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\StringUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */