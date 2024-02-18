/*    */ package net.ccbluex.liquidbounce.file.configs;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.file.FileConfig;
/*    */ import net.ccbluex.liquidbounce.file.FileManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModulesConfig
/*    */   extends FileConfig
/*    */ {
/*    */   public ModulesConfig(File file) {
/* 29 */     super(file);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadConfig() throws IOException {
/* 39 */     JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(getFile())));
/*    */     
/* 41 */     if (jsonElement instanceof com.google.gson.JsonNull) {
/*    */       return;
/*    */     }
/* 44 */     Iterator<Map.Entry<String, JsonElement>> entryIterator = jsonElement.getAsJsonObject().entrySet().iterator();
/* 45 */     while (entryIterator.hasNext()) {
/* 46 */       Map.Entry<String, JsonElement> entry = entryIterator.next();
/* 47 */       Module module = Retreat.moduleManager.getModule(entry.getKey());
/*    */       
/* 49 */       if (module != null) {
/* 50 */         JsonObject jsonModule = (JsonObject)entry.getValue();
/*    */         
/* 52 */         module.setState(jsonModule.get("State").getAsBoolean());
/* 53 */         module.setKeyBind(jsonModule.get("KeyBind").getAsInt());
/*    */         
/* 55 */         if (jsonModule.has("Array")) {
/* 56 */           module.setArray(jsonModule.get("Array").getAsBoolean());
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void saveConfig() throws IOException {
/* 68 */     JsonObject jsonObject = new JsonObject();
/*    */     
/* 70 */     for (Module module : Retreat.moduleManager.getModules()) {
/* 71 */       JsonObject jsonMod = new JsonObject();
/* 72 */       jsonMod.addProperty("State", Boolean.valueOf(module.getState()));
/* 73 */       jsonMod.addProperty("KeyBind", Integer.valueOf(module.getKeyBind()));
/* 74 */       jsonMod.addProperty("Array", Boolean.valueOf(module.getArray()));
/* 75 */       jsonObject.add(module.getName(), (JsonElement)jsonMod);
/*    */     } 
/*    */     
/* 78 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/* 79 */     printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonObject));
/* 80 */     printWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\ModulesConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */