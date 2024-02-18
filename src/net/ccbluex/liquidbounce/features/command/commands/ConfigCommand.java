/*     */ package net.ccbluex.liquidbounce.features.command.commands;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.File;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.function.Consumer;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.special.AntiForge;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/ConfigCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*     */ public final class ConfigCommand extends Command {
/*     */   public ConfigCommand() {
/*  24 */     super("config", new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "module", "Lnet/ccbluex/liquidbounce/features/module/Module;", "accept"})
/*     */   static final class ConfigCommand$execute$1<T>
/*     */     implements Consumer<Module>
/*     */   {
/*     */     ConfigCommand$execute$1(JsonObject param1JsonObject) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void accept(@NotNull Module module) {
/* 164 */       Intrinsics.checkParameterIsNotNull(module, "module"); JsonObject jsonModule = new JsonObject();
/* 165 */       jsonModule.addProperty("State", Boolean.valueOf(module.getState()));
/* 166 */       jsonModule.addProperty("KeyBind", Integer.valueOf(module.getKeyBind()));
/* 167 */       jsonModule.addProperty("Array", Boolean.valueOf(module.getArray()));
/* 168 */       module.getValues().forEach(new Consumer<Value<?>>(jsonModule) { public final void accept(@NotNull Value value) {
/* 169 */               Intrinsics.checkParameterIsNotNull(value, "value"); this.$jsonModule.add(
/* 170 */                   value.getName(), 
/* 171 */                   value.toJson());
/*     */             } }
/*     */         );
/* 174 */       this.$jsonObject.add(module.getName(), (JsonElement)jsonModule); } } public void execute(@NotNull String[] args) { Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length >= 2) { String command = args[1]; if ((Retreat.INSTANCE.getFileManager()).configsDir == null) Intrinsics.throwNpe();  File dir = (Retreat.INSTANCE.getFileManager()).configsDir; String str1 = command; switch (str1.hashCode()) { case 3327206: if (str1.equals("load")) { if (args.length == 3) { try { JsonElement jsonElement = (new JsonParser()).parse(new BufferedReader(new FileReader(new File((Retreat.INSTANCE.getFileManager()).configsDir, args[2])))); if (jsonElement instanceof com.google.gson.JsonNull) { chatSyntax("Config " + args[2] + " not found."); return; }  if (jsonElement == null) throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");  JsonObject jsonObject = (JsonObject)jsonElement; for (Map.Entry set : jsonObject.entrySet()) { String key = (String)set.getKey(); JsonElement value = (JsonElement)set.getValue(); if (StringsKt.equals(key, "CommandPrefix", true)) { Intrinsics.checkExpressionValueIsNotNull(value, "value"); Retreat.INSTANCE.getCommandManager().setPrefix(value.getAsCharacter()); continue; }  if (StringsKt.equals(key, "targets", true)) { if (value == null) throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");  JsonObject jsonValue = (JsonObject)value; if (jsonValue.has("TargetPlayer")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("TargetPlayer"), "jsonValue[\"TargetPlayer\"]"); EntityUtils.targetPlayer = jsonValue.get("TargetPlayer").getAsBoolean(); }  if (jsonValue.has("TargetMobs")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("TargetMobs"), "jsonValue[\"TargetMobs\"]"); EntityUtils.targetMobs = jsonValue.get("TargetMobs").getAsBoolean(); }  if (jsonValue.has("TargetAnimals")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("TargetAnimals"), "jsonValue[\"TargetAnimals\"]"); EntityUtils.targetAnimals = jsonValue.get("TargetAnimals").getAsBoolean(); }  if (jsonValue.has("TargetInvisible")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("TargetInvisible"), "jsonValue[\"TargetInvisible\"]"); EntityUtils.targetInvisible = jsonValue.get("TargetInvisible").getAsBoolean(); }  if (jsonValue.has("TargetDead")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("TargetDead"), "jsonValue[\"TargetDead\"]"); EntityUtils.targetDead = jsonValue.get("TargetDead").getAsBoolean(); }  continue; }  if (StringsKt.equals(key, "features", true)) { if (value == null) throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");  JsonObject jsonValue = (JsonObject)value; if (jsonValue.has("AntiForge")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("AntiForge"), "jsonValue[\"AntiForge\"]"); AntiForge.enabled = jsonValue.get("AntiForge").getAsBoolean(); }  if (jsonValue.has("AntiForgeFML")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("AntiForgeFML"), "jsonValue[\"AntiForgeFML\"]"); AntiForge.blockFML = jsonValue.get("AntiForgeFML").getAsBoolean(); }  if (jsonValue.has("AntiForgeProxy")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("AntiForgeProxy"), "jsonValue[\"AntiForgeProxy\"]"); AntiForge.blockProxyPacket = jsonValue.get("AntiForgeProxy").getAsBoolean(); }  if (jsonValue.has("AntiForgePayloads")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("AntiForgePayloads"), "jsonValue[\"AntiForgePayloads\"]"); AntiForge.blockPayloadPackets = jsonValue.get("AntiForgePayloads").getAsBoolean(); }  if (jsonValue.has("BungeeSpoof")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("BungeeSpoof"), "jsonValue[\"BungeeSpoof\"]"); BungeeCordSpoof.enabled = jsonValue.get("BungeeSpoof").getAsBoolean(); }  if (jsonValue.has("AutoReconnectDelay")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("AutoReconnectDelay"), "jsonValue[\"AutoReconnectDelay\"]"); AutoReconnect.INSTANCE.setDelay(jsonValue.get("AutoReconnectDelay").getAsInt()); }  continue; }  if (StringsKt.equals(key, "thealtening", true)) { if (value == null)
/*     */                       throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");  JsonObject jsonValue = (JsonObject)value; if (jsonValue.has("API-Key")) { Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("API-Key"), "jsonValue[\"API-Key\"]"); Intrinsics.checkExpressionValueIsNotNull(jsonValue.get("API-Key").getAsString(), "jsonValue[\"API-Key\"].asString"); GuiTheAltening.Companion.setApiKey(jsonValue.get("API-Key").getAsString()); }  continue; }  Module module = Retreat.INSTANCE.getModuleManager().getModule(key); if (module != null) { if (value == null)
/*     */                       throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");  JsonObject jsonModule = (JsonObject)value; Intrinsics.checkExpressionValueIsNotNull(jsonModule.get("State"), "jsonModule[\"State\"]"); module.setState(jsonModule.get("State").getAsBoolean()); Intrinsics.checkExpressionValueIsNotNull(jsonModule.get("KeyBind"), "jsonModule[\"KeyBind\"]"); module.setKeyBind(jsonModule.get("KeyBind").getAsInt()); if (jsonModule.has("Array")) { Intrinsics.checkExpressionValueIsNotNull(jsonModule.get("Array"), "jsonModule[\"Array\"]"); module.setArray(jsonModule.get("Array").getAsBoolean()); }  for (Value moduleValue : module.getValues()) { JsonElement element = jsonModule.get(moduleValue.getName()); if (element != null)
/* 177 */                         moduleValue.fromJson(element);  }  }  }  chat("Loaded config: " + args[2]); } catch (Throwable throwable) { Exception e; chat("Failed to load config: " + args[2]); }  break; }  chatSyntax(".config < list / save <name> / load <name> / delete <name> >"); }  break;case 3522941: if (str1.equals("save")) { if (args.length == 3) { JsonObject jsonObject = new JsonObject(); jsonObject.addProperty("CommandPrefix", Character.valueOf(Retreat.INSTANCE.getCommandManager().getPrefix())); JsonObject jsonTargets = new JsonObject(); jsonTargets.addProperty("TargetPlayer", Boolean.valueOf(EntityUtils.targetPlayer)); jsonTargets.addProperty("TargetMobs", Boolean.valueOf(EntityUtils.targetMobs)); jsonTargets.addProperty("TargetAnimals", Boolean.valueOf(EntityUtils.targetAnimals)); jsonTargets.addProperty("TargetInvisible", Boolean.valueOf(EntityUtils.targetInvisible)); jsonTargets.addProperty("TargetDead", Boolean.valueOf(EntityUtils.targetDead)); jsonObject.add("targets", (JsonElement)jsonTargets); JsonObject jsonFeatures = new JsonObject(); jsonFeatures.addProperty("AntiForge", Boolean.valueOf(AntiForge.enabled)); jsonFeatures.addProperty("AntiForgeFML", Boolean.valueOf(AntiForge.blockFML)); jsonFeatures.addProperty("AntiForgeProxy", Boolean.valueOf(AntiForge.blockProxyPacket)); jsonFeatures.addProperty("AntiForgePayloads", Boolean.valueOf(AntiForge.blockPayloadPackets)); jsonFeatures.addProperty("BungeeSpoof", Boolean.valueOf(BungeeCordSpoof.enabled)); jsonFeatures.addProperty("AutoReconnectDelay", Integer.valueOf(AutoReconnect.INSTANCE.getDelay())); jsonObject.add("features", (JsonElement)jsonFeatures); JsonObject theAlteningObject = new JsonObject(); theAlteningObject.addProperty("API-Key", GuiTheAltening.Companion.getApiKey()); jsonObject.add("thealtening", (JsonElement)theAlteningObject); Retreat.INSTANCE.getModuleManager().getModules().stream().forEach(new ConfigCommand$execute$1(jsonObject)); PrintWriter printWriter = new PrintWriter(new FileWriter(new File((Retreat.INSTANCE.getFileManager()).configsDir, args[2])));
/* 178 */               printWriter.println(FileManager.PRETTY_GSON.toJson((JsonElement)jsonObject));
/* 179 */               printWriter.close();
/* 180 */               chat("Saved config " + args[2]); break; }
/*     */             
/* 182 */             chatSyntax(".config < list / save <name> / load <name> / delete <name> >"); }  break;
/*     */         case 3322014:
/*     */           if (str1.equals("list")) { chat("Configs :"); for (File listFile : dir.listFiles()) { Intrinsics.checkExpressionValueIsNotNull(listFile, "listFile"); Intrinsics.checkExpressionValueIsNotNull(listFile.getName(), "listFile.name"); chat(listFile.getName()); }  }  break;
/*     */         case -1335458389:
/*     */           if (str1.equals("delete")) { if (args.length == 3) { if ((new File((Retreat.INSTANCE.getFileManager()).configsDir, args[2])).exists()) { try { FileUtils.forceDelete(new File((Retreat.INSTANCE.getFileManager()).configsDir, args[2])); chat("Deleted config: " + args[2]); } catch (Exception exception) { chat("Failed to delete config: " + args[2]); }  break; }  chat("Config " + args[2] + " not found."); break; }  chatSyntax(".config < list / save <name> / load <name> / delete <name> >"); }  break; }  }
/* 187 */     else { chatSyntax(".config < list / save <name> / load <name> / delete <name> >"); }
/*     */      }
/*     */    @NotNull
/*     */   public List<String> tabComplete(@NotNull String[] args) {
/*     */     ArrayList<String> array;
/* 192 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*     */     
/* 194 */     switch (args.length) { case 1:
/*     */       
/*     */       case 2:
/* 197 */         array = new ArrayList();
/* 198 */         if ((Retreat.INSTANCE.getFileManager()).configsDir == null) Intrinsics.throwNpe();  for (File listFile : (Retreat.INSTANCE.getFileManager()).configsDir.listFiles()) {
/* 199 */           Intrinsics.checkExpressionValueIsNotNull(listFile, "listFile"); array.add(listFile.getName());
/*     */         }  }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     return CollectionsKt.emptyList();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\ConfigCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */