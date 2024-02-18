/*    */ package net.ccbluex.liquidbounce.file.configs;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.file.FileConfig;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.Config;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HudConfig
/*    */   extends FileConfig
/*    */ {
/*    */   public HudConfig(File file) {
/* 26 */     super(file);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadConfig() throws IOException {
/* 36 */     Retreat.hud.clearElements();
/* 37 */     Retreat.hud = (new Config(FileUtils.readFileToString(getFile()))).toHUD();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void saveConfig() throws IOException {
/* 47 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/* 48 */     printWriter.println((new Config(Retreat.hud)).toJson());
/* 49 */     printWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\HudConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */