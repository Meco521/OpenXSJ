/*    */ package net.ccbluex.liquidbounce.utils.misc;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import java.nio.charset.Charset;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.io.TextStreamsKt;
/*    */ import kotlin.jvm.JvmStatic;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.Charsets;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\030\020\005\032\0020\0062\006\020\007\032\0020\0042\006\020\b\032\0020\tH\007J\020\020\n\032\0020\0042\006\020\007\032\0020\004H\007J\"\020\013\032\0020\f2\006\020\007\032\0020\0042\006\020\r\032\0020\0042\b\b\002\020\016\032\0020\004H\002J \020\017\032\0020\0042\006\020\007\032\0020\0042\006\020\r\032\0020\0042\b\b\002\020\016\032\0020\004J\"\020\020\032\004\030\0010\0212\006\020\007\032\0020\0042\006\020\r\032\0020\0042\b\b\002\020\016\032\0020\004R\016\020\003\032\0020\004XT¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/misc/HttpUtils;", "", "()V", "DEFAULT_AGENT", "", "download", "", "url", "file", "Ljava/io/File;", "get", "make", "Ljava/net/HttpURLConnection;", "method", "agent", "request", "requestStream", "Ljava/io/InputStream;", "XSJClient"})
/*    */ public final class HttpUtils {
/*    */   private static final String DEFAULT_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";
/*    */   
/*    */   static {
/* 24 */     HttpUtils httpUtils = new HttpUtils();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     HttpURLConnection.setFollowRedirects(true);
/*    */   }
/*    */   public static final HttpUtils INSTANCE;
/*    */   
/*    */   private final HttpURLConnection make(String url, String method, String agent) {
/* 34 */     if ((new URL(url)).openConnection() == null) throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");  HttpURLConnection httpConnection = (HttpURLConnection)(new URL(url)).openConnection();
/*    */     
/* 36 */     httpConnection.setRequestMethod(method);
/* 37 */     httpConnection.setConnectTimeout(2000);
/* 38 */     httpConnection.setReadTimeout(10000);
/*    */     
/* 40 */     httpConnection.setRequestProperty("User-Agent", agent);
/*    */     
/* 42 */     httpConnection.setInstanceFollowRedirects(true);
/* 43 */     httpConnection.setDoOutput(true);
/*    */     
/* 45 */     return httpConnection;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final String request(@NotNull String url, @NotNull String method, @NotNull String agent) throws IOException {
/* 51 */     Intrinsics.checkParameterIsNotNull(url, "url"); Intrinsics.checkParameterIsNotNull(method, "method"); Intrinsics.checkParameterIsNotNull(agent, "agent"); HttpURLConnection connection = make(url, method, agent);
/*    */     
/* 53 */     Intrinsics.checkExpressionValueIsNotNull(connection.getInputStream(), "connection.inputStream"); InputStream inputStream = connection.getInputStream(); Charset charset = Charsets.UTF_8; boolean bool = false; return TextStreamsKt.readText(new InputStreamReader(inputStream, charset));
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public final InputStream requestStream(@NotNull String url, @NotNull String method, @NotNull String agent) throws IOException {
/* 59 */     Intrinsics.checkParameterIsNotNull(url, "url"); Intrinsics.checkParameterIsNotNull(method, "method"); Intrinsics.checkParameterIsNotNull(agent, "agent"); HttpURLConnection connection = make(url, method, agent);
/*    */     
/* 61 */     return connection.getInputStream();
/*    */   }
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final String get(@NotNull String url) throws IOException {
/* 66 */     Intrinsics.checkParameterIsNotNull(url, "url"); return request$default(INSTANCE, url, "GET", null, 4, null);
/*    */   }
/*    */   @JvmStatic
/*    */   public static final long download(@NotNull String url, @NotNull File file) throws IOException {
/* 70 */     Intrinsics.checkParameterIsNotNull(url, "url"); Intrinsics.checkParameterIsNotNull(file, "file"); FileOutputStream fileOutputStream = new FileOutputStream(file); boolean bool = false; Throwable throwable = (Throwable)null; try { FileOutputStream it = fileOutputStream; int $i$a$-use-HttpUtils$download$1 = 0; long l = ByteStreams.copy(make$default(INSTANCE, url, "GET", null, 4, null).getInputStream(), it); } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; } finally { CloseableKt.closeFinally(fileOutputStream, throwable); }  return l;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\misc\HttpUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */