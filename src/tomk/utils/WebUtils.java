/*    */ package tomk.utils;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class WebUtils {
/*    */   public static String get(String url) throws IOException {
/* 12 */     HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
/*    */     
/* 14 */     con.setRequestMethod("GET");
/* 15 */     con.setRequestProperty("User-Agent", "Mozilla/5.0");
/*    */     
/* 17 */     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
/*    */     
/* 19 */     StringBuilder response = new StringBuilder();
/*    */     String inputLine;
/* 21 */     while ((inputLine = in.readLine()) != null) {
/* 22 */       response.append(inputLine);
/* 23 */       response.append("\n");
/*    */     } 
/*    */     
/* 26 */     in.close();
/*    */     
/* 28 */     return response.toString();
/*    */   }
/*    */   
/*    */   public static String readContent(String stringURL) throws IOException {
/* 32 */     HttpURLConnection httpConnection = stringURL.toLowerCase().startsWith("https://") ? (HttpURLConnection)(new URL(stringURL)).openConnection() : (HttpURLConnection)(new URL(stringURL)).openConnection();
/* 33 */     httpConnection.setConnectTimeout(10000);
/* 34 */     httpConnection.setReadTimeout(10000);
/* 35 */     httpConnection.setRequestMethod("GET");
/* 36 */     httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
/* 37 */     HttpURLConnection.setFollowRedirects(true);
/* 38 */     httpConnection.setDoOutput(true);
/* 39 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
/* 40 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     String line;
/* 42 */     while ((line = bufferedReader.readLine()) != null) {
/* 43 */       stringBuilder.append(line).append("\n");
/*    */     }
/* 45 */     bufferedReader.close();
/* 46 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static interface User32 extends StdCallLibrary {
/* 50 */     public static final User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class);
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\WebUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */