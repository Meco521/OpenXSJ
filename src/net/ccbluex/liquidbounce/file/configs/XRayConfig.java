/*    */ package net.ccbluex.liquidbounce.file.configs;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
/*    */ import net.ccbluex.liquidbounce.file.FileConfig;
/*    */ import net.ccbluex.liquidbounce.file.FileManager;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ 
/*    */ public class XRayConfig
/*    */   extends FileConfig
/*    */ {
/*    */   public XRayConfig(File file) {
/* 23 */     super(file);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void loadConfig() throws IOException {
/* 33 */     XRay xRay = (XRay)Retreat.moduleManager.getModule(XRay.class);
/*    */     
/* 35 */     if (xRay == null) {
/* 36 */       ClientUtils.getLogger().error("[FileManager] Failed to find xray module.");
/*    */       
/*    */       return;
/*    */     } 
/* 40 */     JsonArray jsonArray = (new JsonParser()).parse(new BufferedReader(new FileReader(getFile()))).getAsJsonArray();
/*    */     
/* 42 */     xRay.getXrayBlocks().clear();
/*    */     
/* 44 */     for (JsonElement jsonElement : jsonArray) {
/*    */       try {
/* 46 */         IBlock block = Retreat.wrapper.getFunctions().getBlockFromName(jsonElement.getAsString());
/*    */         
/* 48 */         if (xRay.getXrayBlocks().contains(block)) {
/* 49 */           ClientUtils.getLogger().error("[FileManager] Skipped xray block '" + block.getRegistryName() + "' because the block is already added.");
/*    */           
/*    */           continue;
/*    */         } 
/* 53 */         xRay.getXrayBlocks().add(block);
/* 54 */       } catch (Throwable throwable) {
/* 55 */         ClientUtils.getLogger().error("[FileManager] Failed to add block to xray.", throwable);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void saveConfig() throws IOException {
/* 67 */     XRay xRay = (XRay)Retreat.moduleManager.getModule(XRay.class);
/*    */     
/* 69 */     if (xRay == null) {
/* 70 */       ClientUtils.getLogger().error("[FileManager] Failed to find xray module.");
/*    */       
/*    */       return;
/*    */     } 
/* 74 */     JsonArray jsonArray = new JsonArray();
/*    */     
/* 76 */     for (IBlock block : xRay.getXrayBlocks()) {
/* 77 */       jsonArray.add(FileManager.PRETTY_GSON.toJsonTree(Integer.valueOf(Retreat.wrapper.getFunctions().getIdFromBlock(block))));
/*    */     }
/* 79 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/* 80 */     printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonArray));
/* 81 */     printWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\XRayConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */