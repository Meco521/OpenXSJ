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
/*     */ import java.util.Map;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.special.AntiForge;
/*     */ import net.ccbluex.liquidbounce.features.special.AutoReconnect;
/*     */ import net.ccbluex.liquidbounce.features.special.BungeeCordSpoof;
/*     */ import net.ccbluex.liquidbounce.file.FileConfig;
/*     */ import net.ccbluex.liquidbounce.file.FileManager;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.sub.altgenerator.GuiTheAltening;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ 
/*     */ 
/*     */ public class ValuesConfig
/*     */   extends FileConfig
/*     */ {
/*     */   public ValuesConfig(File file) {
/*  29 */     super(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfig() throws IOException {
/*  37 */     JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(getFile())));
/*     */     
/*  39 */     if (jsonElement instanceof com.google.gson.JsonNull) {
/*     */       return;
/*     */     }
/*  42 */     JsonObject jsonObject = (JsonObject)jsonElement;
/*     */     
/*  44 */     for (Map.Entry<String, JsonElement> entry : (Iterable<Map.Entry<String, JsonElement>>)jsonObject.entrySet()) {
/*  45 */       if (((String)entry.getKey()).equalsIgnoreCase("CommandPrefix")) {
/*  46 */         Retreat.commandManager.setPrefix(((JsonElement)entry.getValue()).getAsCharacter()); continue;
/*  47 */       }  if (((String)entry.getKey()).equalsIgnoreCase("targets")) {
/*  48 */         JsonObject jsonValue = (JsonObject)entry.getValue();
/*     */         
/*  50 */         if (jsonValue.has("TargetPlayer"))
/*  51 */           EntityUtils.targetPlayer = jsonValue.get("TargetPlayer").getAsBoolean(); 
/*  52 */         if (jsonValue.has("TargetMobs"))
/*  53 */           EntityUtils.targetMobs = jsonValue.get("TargetMobs").getAsBoolean(); 
/*  54 */         if (jsonValue.has("TargetAnimals"))
/*  55 */           EntityUtils.targetAnimals = jsonValue.get("TargetAnimals").getAsBoolean(); 
/*  56 */         if (jsonValue.has("TargetInvisible"))
/*  57 */           EntityUtils.targetInvisible = jsonValue.get("TargetInvisible").getAsBoolean(); 
/*  58 */         if (jsonValue.has("TargetDead"))
/*  59 */           EntityUtils.targetDead = jsonValue.get("TargetDead").getAsBoolean();  continue;
/*  60 */       }  if (((String)entry.getKey()).equalsIgnoreCase("features")) {
/*  61 */         JsonObject jsonValue = (JsonObject)entry.getValue();
/*     */         
/*  63 */         if (jsonValue.has("AntiForge"))
/*  64 */           AntiForge.enabled = jsonValue.get("AntiForge").getAsBoolean(); 
/*  65 */         if (jsonValue.has("AntiForgeFML"))
/*  66 */           AntiForge.blockFML = jsonValue.get("AntiForgeFML").getAsBoolean(); 
/*  67 */         if (jsonValue.has("AntiForgeProxy"))
/*  68 */           AntiForge.blockProxyPacket = jsonValue.get("AntiForgeProxy").getAsBoolean(); 
/*  69 */         if (jsonValue.has("AntiForgePayloads"))
/*  70 */           AntiForge.blockPayloadPackets = jsonValue.get("AntiForgePayloads").getAsBoolean(); 
/*  71 */         if (jsonValue.has("BungeeSpoof"))
/*  72 */           BungeeCordSpoof.enabled = jsonValue.get("BungeeSpoof").getAsBoolean(); 
/*  73 */         if (jsonValue.has("AutoReconnectDelay"))
/*  74 */           AutoReconnect.INSTANCE.setDelay(jsonValue.get("AutoReconnectDelay").getAsInt());  continue;
/*  75 */       }  if (((String)entry.getKey()).equalsIgnoreCase("thealtening")) {
/*  76 */         JsonObject jsonValue = (JsonObject)entry.getValue();
/*     */         
/*  78 */         if (jsonValue.has("API-Key"))
/*  79 */           GuiTheAltening.Companion.setApiKey(jsonValue.get("API-Key").getAsString());  continue;
/*     */       } 
/*  81 */       Module module = Retreat.moduleManager.getModule(entry.getKey());
/*     */       
/*  83 */       if (module != null) {
/*  84 */         JsonObject jsonModule = (JsonObject)entry.getValue();
/*     */         
/*  86 */         module.setState(jsonModule.get("State").getAsBoolean());
/*  87 */         module.setKeyBind(jsonModule.get("KeyBind").getAsInt());
/*     */         
/*  89 */         if (jsonModule.has("Array")) {
/*  90 */           module.setArray(jsonModule.get("Array").getAsBoolean());
/*     */         }
/*  92 */         for (Value moduleValue : module.getValues()) {
/*  93 */           JsonElement element = jsonModule.get(moduleValue.getName());
/*     */           
/*  95 */           if (element != null) moduleValue.fromJson(element);
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveConfig() throws IOException {
/* 107 */     JsonObject jsonObject = new JsonObject();
/*     */     
/* 109 */     jsonObject.addProperty("CommandPrefix", Character.valueOf(Retreat.commandManager.getPrefix()));
/*     */     
/* 111 */     JsonObject jsonTargets = new JsonObject();
/* 112 */     jsonTargets.addProperty("TargetPlayer", Boolean.valueOf(EntityUtils.targetPlayer));
/* 113 */     jsonTargets.addProperty("TargetMobs", Boolean.valueOf(EntityUtils.targetMobs));
/* 114 */     jsonTargets.addProperty("TargetAnimals", Boolean.valueOf(EntityUtils.targetAnimals));
/* 115 */     jsonTargets.addProperty("TargetInvisible", Boolean.valueOf(EntityUtils.targetInvisible));
/* 116 */     jsonTargets.addProperty("TargetDead", Boolean.valueOf(EntityUtils.targetDead));
/* 117 */     jsonObject.add("targets", (JsonElement)jsonTargets);
/*     */     
/* 119 */     JsonObject jsonFeatures = new JsonObject();
/* 120 */     jsonFeatures.addProperty("AntiForge", Boolean.valueOf(AntiForge.enabled));
/* 121 */     jsonFeatures.addProperty("AntiForgeFML", Boolean.valueOf(AntiForge.blockFML));
/* 122 */     jsonFeatures.addProperty("AntiForgeProxy", Boolean.valueOf(AntiForge.blockProxyPacket));
/* 123 */     jsonFeatures.addProperty("AntiForgePayloads", Boolean.valueOf(AntiForge.blockPayloadPackets));
/* 124 */     jsonFeatures.addProperty("BungeeSpoof", Boolean.valueOf(BungeeCordSpoof.enabled));
/* 125 */     jsonFeatures.addProperty("AutoReconnectDelay", Integer.valueOf(AutoReconnect.INSTANCE.getDelay()));
/* 126 */     jsonObject.add("features", (JsonElement)jsonFeatures);
/*     */     
/* 128 */     JsonObject theAlteningObject = new JsonObject();
/* 129 */     theAlteningObject.addProperty("API-Key", GuiTheAltening.Companion.getApiKey());
/* 130 */     jsonObject.add("thealtening", (JsonElement)theAlteningObject);
/*     */     
/* 132 */     Retreat.moduleManager.getModules().forEach(module -> {
/*     */           JsonObject jsonModule = new JsonObject();
/*     */           
/*     */           jsonModule.addProperty("State", Boolean.valueOf(module.getState()));
/*     */           jsonModule.addProperty("KeyBind", Integer.valueOf(module.getKeyBind()));
/*     */           jsonModule.addProperty("Array", Boolean.valueOf(module.getArray()));
/*     */           module.getValues().forEach(());
/*     */           jsonObject.add(module.getName(), (JsonElement)jsonModule);
/*     */         });
/* 141 */     PrintWriter printWriter = new PrintWriter(new FileWriter(getFile()));
/* 142 */     printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonObject));
/* 143 */     printWriter.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\ValuesConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */