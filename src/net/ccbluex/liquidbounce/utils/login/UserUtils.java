/*    */ package net.ccbluex.liquidbounce.utils.login;
/*    */ import java.net.URL;
/*    */ import javax.net.ssl.HttpsURLConnection;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.apache.http.client.methods.CloseableHttpResponse;
/*    */ import org.apache.http.client.methods.HttpGet;
/*    */ import org.apache.http.client.methods.HttpPost;
/*    */ import org.apache.http.impl.client.CloseableHttpClient;
/*    */ import org.apache.http.impl.client.HttpClients;
/*    */ import org.apache.http.message.BasicHeader;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.json.JSONArray;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\004\n\002\020\013\n\002\b\003\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\004J\020\020\006\032\004\030\0010\0042\006\020\007\032\0020\004J\016\020\b\032\0020\t2\006\020\n\032\0020\004J\016\020\013\032\0020\t2\006\020\n\032\0020\004¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/login/UserUtils;", "", "()V", "getUUID", "", "username", "getUsername", "uuid", "isValidToken", "", "token", "isValidTokenOffline", "XSJClient"})
/*    */ public final class UserUtils {
/*    */   static {
/* 18 */     UserUtils userUtils = new UserUtils();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static final UserUtils INSTANCE;
/*    */ 
/*    */   
/*    */   public final boolean isValidTokenOffline(@NotNull String token) {
/* 27 */     Intrinsics.checkParameterIsNotNull(token, "token"); return (token.length() >= 32);
/*    */   }
/*    */   public final boolean isValidToken(@NotNull String token) {
/* 30 */     Intrinsics.checkParameterIsNotNull(token, "token"); CloseableHttpClient client = HttpClients.createDefault();
/* 31 */     BasicHeader[] headers = {
/* 32 */         new BasicHeader("Content-Type", "application/json")
/*    */       };
/*    */     
/* 35 */     HttpPost request = new HttpPost("https://authserver.mojang.com/validate");
/* 36 */     request.setHeaders((Header[])headers);
/*    */     
/* 38 */     JSONObject body = new JSONObject();
/* 39 */     body.put("accessToken", token);
/* 40 */     request.setEntity((HttpEntity)new StringEntity(body.toString()));
/*    */     
/* 42 */     CloseableHttpResponse response = client.execute((HttpUriRequest)request);
/* 43 */     Intrinsics.checkExpressionValueIsNotNull(response, "response"); Intrinsics.checkExpressionValueIsNotNull(response.getStatusLine(), "response.statusLine"); boolean valid = (response.getStatusLine().getStatusCode() == 204);
/*    */     
/* 45 */     return valid;
/*    */   } @Nullable
/*    */   public final String getUsername(@NotNull String uuid) {
/*    */     String str1;
/* 49 */     Intrinsics.checkParameterIsNotNull(uuid, "uuid"); CloseableHttpClient client = HttpClients.createDefault();
/* 50 */     HttpGet request = new HttpGet("https://api.mojang.com/user/profiles/" + uuid + "/names");
/* 51 */     CloseableHttpResponse response = client.execute((HttpUriRequest)request);
/*    */     
/* 53 */     Intrinsics.checkExpressionValueIsNotNull(response, "response"); Intrinsics.checkExpressionValueIsNotNull(response.getStatusLine(), "response.statusLine"); if (response.getStatusLine().getStatusCode() != 200) {
/* 54 */       return null;
/*    */     }
/*    */     
/*    */     try {
/* 58 */       JSONArray names = new JSONArray(EntityUtils.toString(response.getEntity()));
/*    */       
/* 60 */       str1 = (new JSONObject(names.get(names.length() - 1).toString())).getString("name");
/* 61 */     } catch (Exception e) {
/* 62 */       e.printStackTrace();
/* 63 */       return null;
/*    */     } 
/*    */     String username = str1;
/* 66 */     return username;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final String getUUID(@NotNull String username) {
/* 73 */     Intrinsics.checkParameterIsNotNull(username, "username");
/*    */     try {
/* 75 */       if ((new URL("https://api.mojang.com/users/profiles/minecraft/" + username)).openConnection() == null) throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");  HttpsURLConnection httpConnection = (HttpsURLConnection)(new URL("https://api.mojang.com/users/profiles/minecraft/" + username)).openConnection();
/* 76 */       httpConnection.setConnectTimeout(2000);
/* 77 */       httpConnection.setReadTimeout(2000);
/* 78 */       httpConnection.setRequestMethod("GET");
/* 79 */       httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
/* 80 */       HttpURLConnection.setFollowRedirects(true);
/* 81 */       httpConnection.setDoOutput(true);
/*    */       
/* 83 */       if (httpConnection.getResponseCode() != 200) {
/* 84 */         return "";
/*    */       }
/*    */       
/* 87 */       InputStreamReader inputStreamReader = new InputStreamReader(httpConnection.getInputStream()); boolean bool = false; Throwable throwable = (Throwable)null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }
/* 94 */     catch (Throwable throwable) {}
/*    */ 
/*    */     
/* 97 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\login\UserUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */