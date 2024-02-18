/*     */ package net.ccbluex.liquidbounce.file.configs;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.file.FileConfig;
/*     */ import net.ccbluex.liquidbounce.file.FileManager;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.Element;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ 
/*     */ 
/*     */ public class ClickGuiConfig
/*     */   extends FileConfig
/*     */ {
/*     */   public ClickGuiConfig(File file) {
/*  25 */     super(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfig() throws IOException {
/*  35 */     JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(getFile())));
/*     */     
/*  37 */     if (jsonElement instanceof com.google.gson.JsonNull) {
/*     */       return;
/*     */     }
/*  40 */     JsonObject jsonObject = (JsonObject)jsonElement;
/*     */     
/*  42 */     for (Panel panel : Retreat.clickGui.panels) {
/*  43 */       if (!jsonObject.has(panel.getName())) {
/*     */         continue;
/*     */       }
/*     */       try {
/*  47 */         JsonObject panelObject = jsonObject.getAsJsonObject(panel.getName());
/*     */         
/*  49 */         panel.setOpen(panelObject.get("open").getAsBoolean());
/*  50 */         panel.setVisible(panelObject.get("visible").getAsBoolean());
/*  51 */         panel.setX(panelObject.get("posX").getAsInt());
/*  52 */         panel.setY(panelObject.get("posY").getAsInt());
/*     */         
/*  54 */         for (Element element : panel.getElements()) {
/*  55 */           if (!(element instanceof ModuleElement)) {
/*     */             continue;
/*     */           }
/*  58 */           ModuleElement moduleElement = (ModuleElement)element;
/*     */           
/*  60 */           if (!panelObject.has(moduleElement.getModule().getName())) {
/*     */             continue;
/*     */           }
/*     */           try {
/*  64 */             JsonObject elementObject = panelObject.getAsJsonObject(moduleElement.getModule().getName());
/*     */             
/*  66 */             moduleElement.setShowSettings(elementObject.get("Settings").getAsBoolean());
/*  67 */           } catch (Exception e) {
/*  68 */             ClientUtils.getLogger().error("Error while loading clickgui module element with the name '" + moduleElement.getModule().getName() + "' (Panel Name: " + panel.getName() + ").", e);
/*     */           } 
/*     */         } 
/*  71 */       } catch (Exception e) {
/*  72 */         ClientUtils.getLogger().error("Error while loading clickgui panel with the name '" + panel.getName() + "'.", e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConfig() throws IOException {
/*  84 */     JsonObject jsonObject = new JsonObject();
/*     */     
/*  86 */     for (Panel panel : Retreat.clickGui.panels) {
/*  87 */       JsonObject panelObject = new JsonObject();
/*     */       
/*  89 */       panelObject.addProperty("open", Boolean.valueOf(panel.getOpen()));
/*  90 */       panelObject.addProperty("visible", Boolean.valueOf(panel.isVisible()));
/*  91 */       panelObject.addProperty("posX", Integer.valueOf(panel.getX()));
/*  92 */       panelObject.addProperty("posY", Integer.valueOf(panel.getY()));
/*     */       
/*  94 */       for (Element element : panel.getElements()) {
/*  95 */         if (!(element instanceof ModuleElement)) {
/*     */           continue;
/*     */         }
/*  98 */         ModuleElement moduleElement = (ModuleElement)element;
/*     */         
/* 100 */         JsonObject elementObject = new JsonObject();
/*     */         
/* 102 */         elementObject.addProperty("Settings", Boolean.valueOf(moduleElement.isShowSettings()));
/*     */         
/* 104 */         panelObject.add(moduleElement.getModule().getName(), (JsonElement)elementObject);
/*     */       } 
/*     */       
/* 107 */       jsonObject.add(panel.getName(), (JsonElement)panelObject);
/*     */     } 
/*     */     
/* 110 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/* 111 */     printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonObject));
/* 112 */     printWriter.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\ClickGuiConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */