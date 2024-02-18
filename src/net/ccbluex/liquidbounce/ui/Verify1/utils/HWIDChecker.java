/*     */ package net.ccbluex.liquidbounce.ui.Verify1.utils;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.math.BigInteger;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.Scanner;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HWIDChecker
/*     */ {
/*     */   public static String getCpuId() throws IOException {
/*  18 */     Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
/*     */     
/*  20 */     process.getOutputStream().close();
/*  21 */     Scanner sc = new Scanner(process.getInputStream());
/*  22 */     String property = md5(convertMD5(md5(sc.next())));
/*  23 */     String serial = md5(sc.next());
/*     */     
/*  25 */     System.out.println(property + ": " + serial);
/*     */     
/*  27 */     return serial;
/*     */   }
/*     */   
/*     */   public static String get(String url) throws IOException {
/*  31 */     HttpURLConnection con = (HttpURLConnection)(new URL(url)).openConnection();
/*     */     
/*  33 */     con.setRequestMethod("GET");
/*  34 */     con.setRequestProperty("User-Agent", "Mozilla/5.0");
/*  35 */     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
/*  36 */     StringBuilder response = new StringBuilder();
/*     */     
/*     */     String inputLine;
/*     */     
/*  40 */     while ((inputLine = in.readLine()) != null) {
/*  41 */       response.append(inputLine);
/*  42 */       response.append("\n");
/*     */     } 
/*     */     
/*  45 */     in.close();
/*  46 */     return response.toString();
/*     */   }
/*     */   public static String md5(String text) {
/*     */     byte[] abyte;
/*  50 */     Object secretBytes = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  55 */       abyte = MessageDigest.getInstance("md5").digest(text.getBytes());
/*  56 */     } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
/*  57 */       throw new IllegalStateException("md5 errror");
/*     */     } 
/*     */     
/*  60 */     String md5code = (new BigInteger(1, abyte)).toString(16);
/*     */     
/*  62 */     for (int i = 0; i < 32 - md5code.length(); i++) {
/*  63 */       md5code = "0" + md5code;
/*     */     }
/*     */     
/*  66 */     return md5code;
/*     */   }
/*     */   
/*     */   public static String convertMD5(String inStr) {
/*  70 */     char[] a = inStr.toCharArray();
/*     */     
/*  72 */     for (int i = 0; i < a.length; i++) {
/*  73 */       a[i] = (char)(a[i] ^ 0x74);
/*     */     }
/*     */     
/*  76 */     String s = new String(a);
/*     */     
/*  78 */     return s;
/*     */   }
/*     */   public static String getSubString(String text, String left, String right) {
/*     */     int zLen;
/*  82 */     String result = "";
/*     */ 
/*     */     
/*  85 */     if (left != null && !left.isEmpty()) {
/*  86 */       zLen = text.indexOf(left);
/*  87 */       if (zLen > -1) {
/*  88 */         zLen += left.length();
/*     */       } else {
/*  90 */         zLen = 0;
/*     */       } 
/*     */     } else {
/*  93 */       zLen = 0;
/*     */     } 
/*     */     
/*  96 */     int yLen = text.indexOf(right, zLen);
/*     */     
/*  98 */     if (yLen < 0 || right == null || right.isEmpty()) {
/*  99 */       yLen = text.length();
/*     */     }
/*     */     
/* 102 */     result = text.substring(zLen, yLen);
/* 103 */     return result;
/*     */   }
/*     */   
/*     */   public static String getTime() {
/* 107 */     String times = null;
/*     */     
/*     */     try {
/* 110 */       times = getSubString(get("http://vv6.video.qq.com/checktime"), "<root><s>o</s><t>", "</t><ip>");
/* 111 */     } catch (IOException ioexception) {
/* 112 */       ioexception.printStackTrace();
/*     */     } 
/*     */     
/* 115 */     return times;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify\\utils\HWIDChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */