/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ 
/*    */ 
/*    */ public class FileUtils
/*    */ {
/*    */   public static void unpackFile(File file, String name) throws IOException {
/* 12 */     FileOutputStream fos = new FileOutputStream(file);
/* 13 */     IOUtils.copy(FileUtils.class.getClassLoader().getResourceAsStream(name), fos);
/* 14 */     fos.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\FileUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */