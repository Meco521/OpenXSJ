/*    */ package net.ccbluex.liquidbounce.file;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FileConfig
/*    */ {
/*    */   private final File file;
/*    */   
/*    */   public FileConfig(File file) {
/* 16 */     this.file = file;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void loadConfig() throws IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract void saveConfig() throws IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void createConfig() throws IOException {
/* 40 */     this.file.createNewFile();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasConfig() {
/* 47 */     return this.file.exists();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public File getFile() {
/* 54 */     return this.file;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\FileConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */