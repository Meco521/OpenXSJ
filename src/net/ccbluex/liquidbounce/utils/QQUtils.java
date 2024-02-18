/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QQUtils
/*    */ {
/*    */   public static String QQNumber;
/*    */   private static final String QQ_WINDOW_TEXT_PRE = "qqexchangewnd_shortcut_prefix_";
/* 17 */   private static final User32 user32 = User32.INSTANCE;
/*    */   
/*    */   public static interface User32 extends StdCallLibrary {
/* 20 */     public static final User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class);
/*    */ 
/*    */     
/*    */     boolean EnumWindows(WNDENUMPROC param1WNDENUMPROC, Pointer param1Pointer);
/*    */ 
/*    */     
/*    */     int GetWindowTextA(Pointer param1Pointer, byte[] param1ArrayOfbyte, int param1Int);
/*    */ 
/*    */     
/*    */     public static interface WNDENUMPROC
/*    */       extends StdCallLibrary.StdCallCallback
/*    */     {
/*    */       boolean callback(Pointer param2Pointer1, Pointer param2Pointer2);
/*    */     }
/*    */   }
/*    */   
/*    */   public static String getSubString(String text, String left, String right) {
/*    */     int zLen;
/* 38 */     String result = "";
/*    */     
/* 40 */     if (left == null || left.isEmpty()) {
/* 41 */       zLen = 0;
/*    */     } else {
/* 43 */       zLen = text.indexOf(left);
/* 44 */       if (zLen > -1) {
/* 45 */         zLen += left.length();
/*    */       } else {
/* 47 */         zLen = 0;
/*    */       } 
/*    */     } 
/* 50 */     int yLen = text.indexOf(right, zLen);
/* 51 */     if (yLen < 0 || right == null || right.isEmpty()) {
/* 52 */       yLen = text.length();
/*    */     }
/* 54 */     result = text.substring(zLen, yLen);
/* 55 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Map<String, String> getLoginQQList() {
/* 64 */     final Map<String, String> map = new HashMap<>(5);
/*    */     
/* 66 */     user32.EnumWindows(new User32.WNDENUMPROC() {
/*    */           public boolean callback(Pointer hWnd, Pointer userData) {
/* 68 */             byte[] windowText = new byte[512];
/* 69 */             QQUtils.user32.GetWindowTextA(hWnd, windowText, 512);
/* 70 */             String wText = Native.toString(windowText);
/* 71 */             if (QQUtils._filterQQInfo(wText)) {
/* 72 */               map.put(hWnd.toString(), wText.substring(wText.indexOf("qqexchangewnd_shortcut_prefix_") + "qqexchangewnd_shortcut_prefix_".length()));
/*    */             }
/* 74 */             QQUtils.QQNumber = QQUtils.getSubString(String.valueOf(map), "=", "}");
/* 75 */             return true;
/*    */           }
/*    */         }null);
/* 78 */     return map;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean _filterQQInfo(String windowText) {
/* 89 */     if (windowText.startsWith("qqexchangewnd_shortcut_prefix_"))
/* 90 */       return true; 
/* 91 */     return false;
/*    */   }
/*    */   
/*    */   public static void getQQ() {
/* 95 */     getLoginQQList();
/*    */   }
/*    */   
/*    */   public static interface WNDENUMPROC extends StdCallLibrary.StdCallCallback {
/*    */     boolean callback(Pointer param1Pointer1, Pointer param1Pointer2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\QQUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */