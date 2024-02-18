/*     */ package net.ccbluex.liquidbounce.file.configs;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Pair;
/*     */ import kotlin.io.FilesKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.command.Command;
/*     */ import net.ccbluex.liquidbounce.features.command.shortcuts.Shortcut;
/*     */ import net.ccbluex.liquidbounce.file.FileManager;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\024¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/file/configs/ShortcutsConfig;", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "loadConfig", "", "saveConfig", "XSJClient"})
/*     */ public final class ShortcutsConfig extends FileConfig {
/*     */   public ShortcutsConfig(@NotNull File file) {
/*  19 */     super(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfig() {
/*  27 */     Intrinsics.checkExpressionValueIsNotNull(getFile(), "file"); JsonElement jsonElement = (new JsonParser()).parse(FilesKt.readText$default(getFile(), null, 1, null));
/*     */     
/*  29 */     if (!(jsonElement instanceof JsonArray)) {
/*     */       return;
/*     */     }
/*  32 */     for (JsonElement shortcutJson : jsonElement) {
/*  33 */       if (!(shortcutJson instanceof JsonObject)) {
/*     */         continue;
/*     */       }
/*  36 */       if (((JsonObject)shortcutJson).get("name") != null && ((JsonObject)shortcutJson).get("name").getAsString() != null) { String name = ((JsonObject)shortcutJson).get("name").getAsString();
/*  37 */         if (((JsonObject)shortcutJson).get("script") != null && ((JsonObject)shortcutJson).get("script").getAsJsonArray() != null) { JsonArray scriptJson = ((JsonObject)shortcutJson).get("script").getAsJsonArray();
/*     */           
/*  39 */           boolean bool = false; List<Pair> script = new ArrayList();
/*     */           
/*  41 */           for (JsonElement scriptCommand : scriptJson) {
/*  42 */             if (!(scriptCommand instanceof JsonObject)) {
/*     */               continue;
/*     */             }
/*  45 */             if (((JsonObject)scriptCommand).get("name") != null && ((JsonObject)scriptCommand).get("name").getAsString() != null) { String commandName = ((JsonObject)scriptCommand).get("name").getAsString();
/*  46 */               if (((JsonObject)scriptCommand).get("arguments") != null && ((JsonObject)scriptCommand).get("arguments").getAsJsonArray() != null) { JsonArray arguments = ((JsonObject)scriptCommand).get("arguments").getAsJsonArray();
/*     */                 
/*  48 */                 if (Retreat.INSTANCE.getCommandManager().getCommand(commandName) != null) { Command command = Retreat.INSTANCE.getCommandManager().getCommand(commandName);
/*     */                   
/*  50 */                   Iterable iterable1 = (Iterable)arguments; Command command1 = command; List<Pair> list = script; int $i$f$map = 0;
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
/*  98 */                   Iterable iterable3 = iterable1; Collection<String> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1, 10)); int $i$f$mapTo = 0;
/*  99 */                   for (Object item$iv$iv : iterable3) {
/* 100 */                     JsonElement jsonElement1 = (JsonElement)item$iv$iv; Collection<String> collection = destination$iv$iv; int $i$a$-map-ShortcutsConfig$loadConfig$1 = 0; Intrinsics.checkExpressionValueIsNotNull(jsonElement1, "it"); String str = jsonElement1.getAsString(); collection.add(str);
/* 101 */                   }  List list1 = (List)destination$iv$iv; Iterable $this$map$iv = list1; command1 = command1; list = list; int $i$f$toTypedArray = 0;
/* 102 */                   Iterable iterable2 = $this$map$iv;
/* 103 */                   if (iterable2.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  Object[] arrayOfObject1 = iterable2.toArray((Object[])new String[0]); Object[] arrayOfObject2 = arrayOfObject1; Command command2 = command1; list.add(new Pair(command2, arrayOfObject2));
/*     */                   continue; }
/*     */                 
/*     */                 Retreat.INSTANCE.getCommandManager().getCommand(commandName);
/*     */                 continue; }
/*     */               
/*     */               ((JsonObject)scriptCommand).get("arguments").getAsJsonArray();
/*     */               continue; }
/*     */             
/*     */             ((JsonObject)scriptCommand).get("name").getAsString();
/*     */           } 
/*     */           Retreat.INSTANCE.getCommandManager().registerCommand((Command)new Shortcut(name, script));
/*     */           continue; }
/*     */         
/*     */         ((JsonObject)shortcutJson).get("script").getAsJsonArray();
/*     */         continue; }
/*     */       
/*     */       ((JsonObject)shortcutJson).get("name").getAsString();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void saveConfig() {
/*     */     JsonArray jsonArray = new JsonArray();
/*     */     for (Command command : Retreat.INSTANCE.getCommandManager().getCommands()) {
/*     */       if (!(command instanceof Shortcut))
/*     */         continue; 
/*     */       JsonObject jsonCommand = new JsonObject();
/*     */       jsonCommand.addProperty("name", command.getCommand());
/*     */       JsonArray scriptArray = new JsonArray();
/*     */       for (Pair pair : ((Shortcut)command).getScript()) {
/*     */         JsonObject pairObject = new JsonObject();
/*     */         pairObject.addProperty("name", ((Command)pair.getFirst()).getCommand());
/*     */         JsonArray argumentsObject = new JsonArray();
/*     */         for (String argument : (String[])pair.getSecond())
/*     */           argumentsObject.add(argument); 
/*     */         pairObject.add("arguments", (JsonElement)argumentsObject);
/*     */         scriptArray.add((JsonElement)pairObject);
/*     */       } 
/*     */       jsonCommand.add("script", (JsonElement)scriptArray);
/*     */       jsonArray.add((JsonElement)jsonCommand);
/*     */     } 
/*     */     Intrinsics.checkExpressionValueIsNotNull(getFile(), "file");
/*     */     Intrinsics.checkExpressionValueIsNotNull(FileManager.PRETTY_GSON.toJson((JsonElement)jsonArray), "FileManager.PRETTY_GSON.toJson(jsonArray)");
/*     */     FilesKt.writeText$default(getFile(), FileManager.PRETTY_GSON.toJson((JsonElement)jsonArray), null, 2, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\file\configs\ShortcutsConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */