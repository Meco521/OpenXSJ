/*     */ package net.ccbluex.liquidbounce.ui.client;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AutoDiYuQiShi
/*     */ {
/*  16 */   private static final Map<String, String> LOCATION_MAP = initializeLocationMap();
/*     */   
/*     */   private static String getPublicIPAddress() throws IOException {
/*  19 */     URL url = new URL("https://api64.ipify.org?format=json");
/*     */     
/*  21 */     HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/*  22 */     connection.setRequestMethod("GET");
/*     */     
/*  24 */     BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
/*  25 */     StringBuilder response = new StringBuilder();
/*     */     
/*     */     String line;
/*  28 */     while ((line = reader.readLine()) != null) {
/*  29 */       response.append(line);
/*     */     }
/*     */     
/*  32 */     reader.close();
/*     */     
/*  34 */     JSONObject jsonResponse = new JSONObject(response.toString());
/*  35 */     return jsonResponse.getString("ip");
/*     */   }
/*     */   
/*     */   private static String getLocationByIP(String ipAddress) throws IOException {
/*  39 */     String apiUrl = "http://ip-api.com/json/" + ipAddress;
/*     */     
/*  41 */     URL url = new URL(apiUrl);
/*  42 */     HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/*  43 */     connection.setRequestMethod("GET");
/*     */     
/*  45 */     BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
/*  46 */     StringBuilder response = new StringBuilder();
/*     */     
/*     */     String line;
/*  49 */     while ((line = reader.readLine()) != null) {
/*  50 */       response.append(line);
/*     */     }
/*     */     
/*  53 */     reader.close();
/*     */     
/*  55 */     JSONObject jsonResponse = new JSONObject(response.toString());
/*     */ 
/*     */     
/*  58 */     String region = jsonResponse.getString("regionName");
/*     */     
/*  60 */     return region;
/*     */   }
/*     */   
/*     */   private static Map<String, String> initializeLocationMap() {
/*  64 */     Map<String, String> locationMap = new HashMap<>();
/*     */ 
/*     */     
/*  67 */     locationMap.put("beijing", "北京");
/*  68 */     locationMap.put("tianjin", "天津");
/*  69 */     locationMap.put("shanghai", "上海");
/*  70 */     locationMap.put("chongqing", "重庆");
/*     */ 
/*     */     
/*  73 */     locationMap.put("anhui", "安徽");
/*  74 */     locationMap.put("fujian", "福建");
/*  75 */     locationMap.put("gansu", "甘肃");
/*  76 */     locationMap.put("guangdong", "广东");
/*  77 */     locationMap.put("guizhou", "贵州");
/*  78 */     locationMap.put("hainan", "海南");
/*  79 */     locationMap.put("hebei", "河北");
/*  80 */     locationMap.put("heilongjiang", "黑龙江");
/*  81 */     locationMap.put("henan", "河南");
/*  82 */     locationMap.put("hubei", "湖北");
/*  83 */     locationMap.put("hunan", "湖南");
/*  84 */     locationMap.put("jiangsu", "江苏");
/*  85 */     locationMap.put("jiangxi", "江西");
/*  86 */     locationMap.put("jilin", "吉林");
/*  87 */     locationMap.put("liaoning", "辽宁");
/*  88 */     locationMap.put("qinghai", "青海");
/*  89 */     locationMap.put("shaanxi", "陕西");
/*  90 */     locationMap.put("shandong", "山东");
/*  91 */     locationMap.put("shanxi", "山西");
/*  92 */     locationMap.put("sichuan", "四川");
/*  93 */     locationMap.put("yunnan", "云南");
/*  94 */     locationMap.put("zhejiang", "浙江");
/*     */ 
/*     */     
/*  97 */     locationMap.put("guangxi", "广西");
/*  98 */     locationMap.put("neimenggu", "内蒙古");
/*  99 */     locationMap.put("ningxia", "宁夏");
/* 100 */     locationMap.put("xizang", "西藏");
/* 101 */     locationMap.put("xinjiang", "新疆");
/*     */ 
/*     */     
/* 104 */     locationMap.put("hongkong", "香港");
/* 105 */     locationMap.put("macau", "澳门");
/* 106 */     locationMap.put("taiwan", "湾湾");
/* 107 */     return locationMap;
/*     */   }
/*     */   
/*     */   public static String getLocation() throws IOException {
/* 111 */     String location = getLocationByIP(getPublicIPAddress());
/*     */ 
/*     */     
/* 114 */     String province = LOCATION_MAP.get(location.toLowerCase());
/*     */     
/* 116 */     return (province != null) ? province : "外国";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\AutoDiYuQiShi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */