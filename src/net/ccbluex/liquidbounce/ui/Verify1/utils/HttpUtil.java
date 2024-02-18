/*    */ package net.ccbluex.liquidbounce.ui.Verify1.utils;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class HttpUtil {
/*    */   public static String sendGet(String url, String param) {
/* 12 */     String result = "";
/* 13 */     BufferedReader in = null;
/*    */     
/* 15 */     try { String urlNameString = url + "?" + param;
/* 16 */       URL realUrl = new URL(urlNameString);
/* 17 */       URLConnection connection = realUrl.openConnection();
/* 18 */       connection.setDoOutput(true);
/* 19 */       connection.setReadTimeout(981);
/* 20 */       connection.setRequestProperty("accept", "*/*");
/* 21 */       connection.setRequestProperty("connection", "Keep-Alive");
/* 22 */       connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
/* 23 */       connection.connect();
/* 24 */       Map<String, List<String>> map = connection.getHeaderFields();
/* 25 */       for (String str : map.keySet());
/*    */       
/* 27 */       in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
/*    */       String line;
/* 29 */       while ((line = in.readLine()) != null) {
/* 30 */         result = result + line + "\n";
/*    */       } }
/* 32 */     catch (Exception exception)
/*    */     
/*    */     { 
/*    */       try {
/* 36 */         if (in != null) {
/* 37 */           in.close();
/*    */         }
/* 39 */       } catch (Exception exception1) {} } finally { try { if (in != null) in.close();  } catch (Exception exception) {} }
/*    */ 
/*    */     
/* 42 */     return result;
/*    */   }
/*    */   
/*    */   public static String webget(String url) throws IOException {
/* 46 */     HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
/* 47 */     con.setRequestMethod("GET");
/* 48 */     con.setRequestProperty("User-Agent", "Mozilla/5.0");
/* 49 */     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
/*    */     
/* 51 */     StringBuilder response = new StringBuilder(); String inputLine;
/* 52 */     while ((inputLine = in.readLine()) != null) {
/* 53 */       response.append(inputLine);
/* 54 */       response.append("\n");
/*    */     } 
/* 56 */     in.close();
/* 57 */     return response.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify\\utils\HttpUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */