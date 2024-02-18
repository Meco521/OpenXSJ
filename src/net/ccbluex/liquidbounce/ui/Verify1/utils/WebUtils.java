/*    */ package net.ccbluex.liquidbounce.ui.Verify1.utils;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class WebUtils
/*    */ {
/*    */   public static String get(String url) throws IOException {
/* 15 */     HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
/*    */     
/* 17 */     con.setRequestMethod("GET");
/* 18 */     con.setRequestProperty("User-Agent", "Mozilla/5.0");
/*    */     
/* 20 */     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
/*    */     
/* 22 */     StringBuilder response = new StringBuilder();
/*    */     String inputLine;
/* 24 */     while ((inputLine = in.readLine()) != null) {
/* 25 */       response.append(inputLine);
/* 26 */       response.append("\n");
/*    */     } 
/*    */     
/* 29 */     in.close();
/*    */     
/* 31 */     return response.toString();
/*    */   }
/*    */   
/*    */   public static String readContent(String stringURL) throws IOException {
/* 35 */     HttpURLConnection httpConnection = stringURL.toLowerCase().startsWith("https://") ? (HttpURLConnection)(new URL(stringURL)).openConnection() : (HttpURLConnection)(new URL(stringURL)).openConnection();
/* 36 */     httpConnection.setConnectTimeout(10000);
/* 37 */     httpConnection.setReadTimeout(10000);
/* 38 */     httpConnection.setRequestMethod("GET");
/* 39 */     httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
/* 40 */     HttpURLConnection.setFollowRedirects(true);
/* 41 */     httpConnection.setDoOutput(true);
/* 42 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
/* 43 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     String line;
/* 45 */     while ((line = bufferedReader.readLine()) != null) {
/* 46 */       stringBuilder.append(line).append("\n");
/*    */     }
/* 48 */     bufferedReader.close();
/* 49 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static interface User32 extends StdCallLibrary {
/* 53 */     public static final User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class);
/*    */     
/*    */     boolean EnumWindows(WNDENUMPROC param1WNDENUMPROC, Pointer param1Pointer);
/*    */     
/*    */     int GetWindowTextA(Pointer param1Pointer, byte[] param1ArrayOfbyte, int param1Int);
/*    */     
/*    */     public static interface WNDENUMPROC extends StdCallLibrary.StdCallCallback {
/*    */       boolean callback(Pointer param2Pointer1, Pointer param2Pointer2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify\\utils\WebUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */