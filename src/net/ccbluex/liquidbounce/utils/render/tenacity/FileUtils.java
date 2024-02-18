/*    */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ 
/*    */ public class FileUtils
/*    */ {
/*    */   public static String readFile(File file) {
/* 15 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/*    */     try {
/* 18 */       FileInputStream fileInputStream = new FileInputStream(file);
/* 19 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
/*    */       String line;
/* 21 */       while ((line = bufferedReader.readLine()) != null) {
/* 22 */         stringBuilder.append(line).append('\n');
/*    */       }
/* 24 */     } catch (Exception e) {
/* 25 */       e.printStackTrace();
/*    */     } 
/* 27 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static String readInputStream(InputStream inputStream) {
/* 31 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/*    */     try {
/* 34 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*    */       String line;
/* 36 */       while ((line = bufferedReader.readLine()) != null) {
/* 37 */         stringBuilder.append(line).append('\n');
/*    */       }
/* 39 */     } catch (Exception e) {
/* 40 */       e.printStackTrace();
/*    */     } 
/* 42 */     return stringBuilder.toString();
/*    */   }
/*    */   public static void unpackFile(File file, String name) throws IOException {
/* 45 */     FileOutputStream fos = new FileOutputStream(file);
/* 46 */     IOUtils.copy(FileUtils.class.getClassLoader().getResourceAsStream(name), fos);
/* 47 */     fos.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\FileUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */