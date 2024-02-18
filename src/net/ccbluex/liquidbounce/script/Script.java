/*     */ package net.ccbluex.liquidbounce.script;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import jdk.nashorn.api.scripting.JSObject;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000R\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\002\030\002\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\021\n\002\b\006\n\002\030\002\n\002\b\f\n\002\020\013\n\000\n\002\020\002\n\002\b\022\030\0002\0020\001:\0017B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020%\032\0020&2\006\020'\032\0020\007H\002J\022\020(\032\004\030\0010\0072\006\020)\032\0020\007H\002J\016\020*\032\0020&2\006\020\002\032\0020\007J\026\020+\032\0020&2\006\020'\032\0020\0072\006\020,\032\0020\bJ\006\020-\032\0020&J\006\020.\032\0020&J\026\020/\032\0020&2\006\0200\032\0020\b2\006\0201\032\0020\bJ\026\0202\032\0020&2\006\0203\032\0020\b2\006\0201\032\0020\bJ\016\0204\032\0020&2\006\0205\032\0020\bJ\b\0206\032\0020&H\002R*\020\005\032\036\022\004\022\0020\007\022\004\022\0020\b0\006j\016\022\004\022\0020\007\022\004\022\0020\b`\tX\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\f0\013X\004¢\006\002\n\000R\024\020\r\032\b\022\004\022\0020\0160\013X\004¢\006\002\n\000R\"\020\017\032\b\022\004\022\0020\0070\020X.¢\006\020\n\002\020\025\032\004\b\021\020\022\"\004\b\023\020\024R\016\020\026\032\0020\027X\004¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\030\020\031R\032\020\032\032\0020\007X.¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036R\016\020\037\032\0020\007X\004¢\006\002\n\000R\032\020 \032\0020\007X.¢\006\016\n\000\032\004\b!\020\034\"\004\b\"\020\036R\016\020#\032\0020$X\016¢\006\002\n\000¨\0068"}, d2 = {"Lnet/ccbluex/liquidbounce/script/Script;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "scriptFile", "Ljava/io/File;", "(Ljava/io/File;)V", "events", "Ljava/util/HashMap;", "", "Ljdk/nashorn/api/scripting/JSObject;", "Lkotlin/collections/HashMap;", "registeredCommands", "", "Lnet/ccbluex/liquidbounce/features/command/Command;", "registeredModules", "Lnet/ccbluex/liquidbounce/features/module/Module;", "scriptAuthors", "", "getScriptAuthors", "()[Ljava/lang/String;", "setScriptAuthors", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "scriptEngine", "Ljavax/script/ScriptEngine;", "getScriptFile", "()Ljava/io/File;", "scriptName", "getScriptName", "()Ljava/lang/String;", "setScriptName", "(Ljava/lang/String;)V", "scriptText", "scriptVersion", "getScriptVersion", "setScriptVersion", "state", "", "callEvent", "", "eventName", "getMagicComment", "name", "import", "on", "handler", "onDisable", "onEnable", "registerCommand", "commandObject", "callback", "registerModule", "moduleObject", "registerTab", "tabObject", "supportLegacyScripts", "RegisterScript", "XSJClient"})
/*     */ public final class Script extends MinecraftInstance {
/*     */   private final ScriptEngine scriptEngine;
/*     */   private final String scriptText;
/*     */   @NotNull
/*     */   public String scriptName;
/*     */   @NotNull
/*     */   public String scriptVersion;
/*     */   @NotNull
/*     */   public String[] scriptAuthors;
/*     */   
/*     */   @NotNull
/*  22 */   public final File getScriptFile() { return this.scriptFile; } private boolean state; private final HashMap<String, JSObject> events; private final List<Module> registeredModules; private final List<Command> registeredCommands; @NotNull private final File scriptFile; public Script(@NotNull File scriptFile) { this.scriptFile = scriptFile;
/*     */ 
/*     */     
/*  25 */     this.scriptText = FilesKt.readText$default(this.scriptFile, null, 1, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.events = new HashMap<>();
/*  34 */     Script script = this; boolean bool = false; ArrayList<Module> arrayList = new ArrayList();
/*  35 */     script = this; bool = false; script.registeredCommands = (List)(arrayList = new ArrayList<>());
/*     */ 
/*     */     
/*  38 */     if (getMagicComment("engine_flags") != null && StringsKt.split$default(getMagicComment("engine_flags"), new String[] { "," }, false, 0, 6, null) != null) { Collection $this$toTypedArray$iv = StringsKt.split$default(getMagicComment("engine_flags"), new String[] { "," }, false, 0, 6, null); int $i$f$toTypedArray = 0;
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
/* 206 */       Collection thisCollection$iv = $this$toTypedArray$iv;
/* 207 */       if (thisCollection$iv.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  if ((String[])thisCollection$iv.toArray((Object[])new String[0]) != null) { String[] engineFlags = (String[])thisCollection$iv.toArray((Object[])new String[0]); Intrinsics.checkExpressionValueIsNotNull((new NashornScriptEngineFactory()).getScriptEngine(Arrays.copyOf(engineFlags, engineFlags.length)), "NashornScriptEngineFacto…criptEngine(*engineFlags)"); this.scriptEngine = (new NashornScriptEngineFactory()).getScriptEngine(Arrays.copyOf(engineFlags, engineFlags.length)); this.scriptEngine.put("Chat", StaticClass.forClass(Chat.class)); this.scriptEngine.put("Setting", StaticClass.forClass(Setting.class)); this.scriptEngine.put("Item", StaticClass.forClass(Item.class)); this.scriptEngine.put("mc", MinecraftInstance.mc); this.scriptEngine.put("moduleManager", Retreat.INSTANCE.getModuleManager()); this.scriptEngine.put("commandManager", Retreat.INSTANCE.getCommandManager()); this.scriptEngine.put("scriptManager", Retreat.INSTANCE.getScriptManager()); this.scriptEngine.put("registerScript", new RegisterScript()); supportLegacyScripts(); this.scriptEngine.eval(this.scriptText); callEvent("load"); return; }  }  (String[])thisCollection$iv.toArray((Object[])new String[0]);
/*     */     String[] arrayOfString = new String[0];
/*     */     Intrinsics.checkExpressionValueIsNotNull((new NashornScriptEngineFactory()).getScriptEngine(Arrays.copyOf(arrayOfString, arrayOfString.length)), "NashornScriptEngineFacto…criptEngine(*engineFlags)");
/*     */     this.scriptEngine = (new NashornScriptEngineFactory()).getScriptEngine(Arrays.copyOf(arrayOfString, arrayOfString.length));
/*     */     this.scriptEngine.put("Chat", StaticClass.forClass(Chat.class));
/*     */     this.scriptEngine.put("Setting", StaticClass.forClass(Setting.class));
/*     */     this.scriptEngine.put("Item", StaticClass.forClass(Item.class));
/*     */     this.scriptEngine.put("mc", MinecraftInstance.mc);
/*     */     this.scriptEngine.put("moduleManager", Retreat.INSTANCE.getModuleManager());
/*     */     this.scriptEngine.put("commandManager", Retreat.INSTANCE.getCommandManager());
/*     */     this.scriptEngine.put("scriptManager", Retreat.INSTANCE.getScriptManager());
/*     */     this.scriptEngine.put("registerScript", new RegisterScript());
/*     */     supportLegacyScripts();
/*     */     this.scriptEngine.eval(this.scriptText);
/*     */     callEvent("load"); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final String getScriptName() {
/*     */     if (this.scriptName == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("scriptName"); 
/*     */     return this.scriptName;
/*     */   }
/*     */   
/*     */   public final void setScriptName(@NotNull String <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.scriptName = <set-?>;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String getScriptVersion() {
/*     */     if (this.scriptVersion == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("scriptVersion"); 
/*     */     return this.scriptVersion;
/*     */   }
/*     */   
/*     */   public final void setScriptVersion(@NotNull String <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.scriptVersion = <set-?>;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String[] getScriptAuthors() {
/*     */     if (this.scriptAuthors == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("scriptAuthors"); 
/*     */     return this.scriptAuthors;
/*     */   }
/*     */   
/*     */   public final void setScriptAuthors(@NotNull String[] <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.scriptAuthors = <set-?>;
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\004\b\004\030\0002\016\022\004\022\0020\002\022\004\022\0020\0030\001B\005¢\006\002\020\004J\020\020\005\032\0020\0032\006\020\006\032\0020\002H\026¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/script/Script$RegisterScript;", "Ljava/util/function/Function;", "Ljdk/nashorn/api/scripting/JSObject;", "Lnet/ccbluex/liquidbounce/script/Script;", "(Lnet/ccbluex/liquidbounce/script/Script;)V", "apply", "scriptObject", "XSJClient"})
/*     */   public final class RegisterScript implements Function<JSObject, Script> {
/*     */     @NotNull
/*     */     public Script apply(@NotNull JSObject scriptObject) {
/*     */       Intrinsics.checkParameterIsNotNull(scriptObject, "scriptObject");
/*     */       if (scriptObject.getMember("name") == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type kotlin.String"); 
/*     */       Script.this.setScriptName((String)scriptObject.getMember("name"));
/*     */       if (scriptObject.getMember("version") == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type kotlin.String"); 
/*     */       Script.this.setScriptVersion((String)scriptObject.getMember("version"));
/*     */       if (ScriptUtils.convert(scriptObject.getMember("authors"), String[].class) == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>"); 
/*     */       Script.this.setScriptAuthors((String[])ScriptUtils.convert(scriptObject.getMember("authors"), String[].class));
/*     */       return Script.this;
/*     */     }
/*     */   }
/*     */   
/*     */   public final void registerModule(@NotNull JSObject moduleObject, @NotNull JSObject callback) {
/*     */     Intrinsics.checkParameterIsNotNull(moduleObject, "moduleObject");
/*     */     Intrinsics.checkParameterIsNotNull(callback, "callback");
/*     */     ScriptModule module = new ScriptModule(moduleObject);
/*     */     Retreat.INSTANCE.getModuleManager().registerModule((Module)module);
/*     */     List<Module> list = this.registeredModules;
/*     */     boolean bool = false;
/*     */     list.add(module);
/*     */     callback.call(moduleObject, new Object[] { module });
/*     */   }
/*     */   
/*     */   public final void registerCommand(@NotNull JSObject commandObject, @NotNull JSObject callback) {
/*     */     Intrinsics.checkParameterIsNotNull(commandObject, "commandObject");
/*     */     Intrinsics.checkParameterIsNotNull(callback, "callback");
/*     */     ScriptCommand command = new ScriptCommand(commandObject);
/*     */     Retreat.INSTANCE.getCommandManager().registerCommand((Command)command);
/*     */     List<Command> list = this.registeredCommands;
/*     */     boolean bool = false;
/*     */     list.add(command);
/*     */     callback.call(commandObject, new Object[] { command });
/*     */   }
/*     */   
/*     */   public final void registerTab(@NotNull JSObject tabObject) {
/*     */     Intrinsics.checkParameterIsNotNull(tabObject, "tabObject");
/*     */     new ScriptTab(tabObject);
/*     */   }
/*     */   
/*     */   private final String getMagicComment(String name) {
/*     */     String magicPrefix = "///";
/*     */     Iterable $this$forEach$iv = StringsKt.lines(this.scriptText);
/*     */     int $i$f$forEach = 0;
/*     */     Iterator iterator = $this$forEach$iv.iterator();
/*     */     if (iterator.hasNext()) {
/*     */       Object element$iv = iterator.next();
/*     */       String it = (String)element$iv;
/*     */       int $i$a$-forEach-Script$getMagicComment$1 = 0;
/*     */       if (!StringsKt.startsWith$default(it, magicPrefix, false, 2, null))
/*     */         return null; 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private final void supportLegacyScripts() {
/*     */     if ((Intrinsics.areEqual(getMagicComment("api_version"), "2") ^ true) != 0) {
/*     */       ClientUtils.getLogger().info("[ScriptAPI] Running script '" + this.scriptFile.getName() + "' with legacy support.");
/*     */       Intrinsics.checkExpressionValueIsNotNull(Retreat.class.getResource("/assets/minecraft/tomk/scriptapi/legacy.js"), "Retreat::class.java.getR…omk/scriptapi/legacy.js\")");
/*     */       URL uRL = Retreat.class.getResource("/assets/minecraft/tomk/scriptapi/legacy.js");
/*     */       Charset charset = Charsets.UTF_8;
/*     */       boolean bool1 = false;
/*     */       byte[] arrayOfByte = TextStreamsKt.readBytes(uRL);
/*     */       boolean bool2 = false, bool3 = false;
/*     */       String legacyScript = new String(arrayOfByte, charset);
/*     */       this.scriptEngine.eval(legacyScript);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void on(@NotNull String eventName, @NotNull JSObject handler) {
/*     */     Intrinsics.checkParameterIsNotNull(eventName, "eventName");
/*     */     Intrinsics.checkParameterIsNotNull(handler, "handler");
/*     */     this.events.put(eventName, handler);
/*     */   }
/*     */   
/*     */   public final void onEnable() {
/*     */     if (this.state)
/*     */       return; 
/*     */     callEvent("enable");
/*     */     this.state = true;
/*     */   }
/*     */   
/*     */   public final void onDisable() {
/*     */     if (!this.state)
/*     */       return; 
/*     */     Iterable<Module> iterable = this.registeredModules;
/*     */     int $i$f$forEach = 0;
/*     */     Iterator<Module> iterator = iterable.iterator();
/*     */     if (iterator.hasNext()) {
/*     */       Object element$iv = iterator.next();
/*     */       Module it = (Module)element$iv;
/*     */       int $i$a$-forEach-Script$onDisable$1 = 0;
/*     */       Retreat.INSTANCE.getModuleManager().unregisterModule(it);
/*     */     } 
/*     */     Iterable<Command> $this$forEach$iv = this.registeredCommands;
/*     */     $i$f$forEach = 0;
/*     */     iterator = (Iterator)$this$forEach$iv.iterator();
/*     */     if (iterator.hasNext()) {
/*     */       Object element$iv = iterator.next();
/*     */       Command it = (Command)element$iv;
/*     */       int $i$a$-forEach-Script$onDisable$2 = 0;
/*     */       Retreat.INSTANCE.getCommandManager().unregisterCommand(it);
/*     */     } 
/*     */     callEvent("disable");
/*     */     this.state = false;
/*     */   }
/*     */   
/*     */   public final void import(@NotNull String scriptFile) {
/*     */     Intrinsics.checkParameterIsNotNull(scriptFile, "scriptFile");
/*     */     this.scriptEngine.eval(FilesKt.readText$default(new File(Retreat.INSTANCE.getScriptManager().getScriptsFolder(), scriptFile), null, 1, null));
/*     */   }
/*     */   
/*     */   private final void callEvent(String eventName) {
/*     */     try {
/*     */       if ((JSObject)this.events.get(eventName) != null) {
/*     */         ((JSObject)this.events.get(eventName)).call(null, new Object[0]);
/*     */       } else {
/*     */         (JSObject)this.events.get(eventName);
/*     */       } 
/*     */     } catch (Throwable throwable) {
/*     */       if (this.scriptName == null)
/*     */         Intrinsics.throwUninitializedPropertyAccessException("scriptName"); 
/*     */       ClientUtils.getLogger().error("[ScriptAPI] Exception in script '" + this.scriptName + "'!", throwable);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\Script.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */