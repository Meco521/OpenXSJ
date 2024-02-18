/*    */ package net.ccbluex.liquidbounce.script;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020!\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\013\030\0002\0020\001B\005¢\006\002\020\002J\016\020\016\032\0020\0172\006\020\020\032\0020\007J\006\020\021\032\0020\017J\006\020\022\032\0020\017J\016\020\023\032\0020\0172\006\020\024\032\0020\013J\016\020\025\032\0020\0172\006\020\026\032\0020\013J\006\020\027\032\0020\017J\006\020\030\032\0020\017J\006\020\031\032\0020\017R\016\020\003\032\0020\004XD¢\006\002\n\000R\027\020\005\032\b\022\004\022\0020\0070\006¢\006\b\n\000\032\004\b\b\020\tR\021\020\n\032\0020\013¢\006\b\n\000\032\004\b\f\020\r¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/script/ScriptManager;", "", "()V", "scriptFileExtension", "", "scripts", "", "Lnet/ccbluex/liquidbounce/script/Script;", "getScripts", "()Ljava/util/List;", "scriptsFolder", "Ljava/io/File;", "getScriptsFolder", "()Ljava/io/File;", "deleteScript", "", "script", "disableScripts", "enableScripts", "importScript", "file", "loadScript", "scriptFile", "loadScripts", "reloadScripts", "unloadScripts", "XSJClient"})
/*    */ public final class ScriptManager {
/*    */   @NotNull
/*    */   private final List<Script> scripts;
/*    */   @NotNull
/*    */   private final File scriptsFolder;
/*    */   private final String scriptFileExtension = ".js";
/*    */   
/* 10 */   public ScriptManager() { ScriptManager scriptManager = this; boolean bool = false; ArrayList<Script> arrayList = new ArrayList();
/*    */     
/* 12 */     this.scriptsFolder = new File((Retreat.INSTANCE.getFileManager()).dir, "scripts");
/* 13 */     this.scriptFileExtension = ".js"; } @NotNull
/*    */   public final List<Script> getScripts() { return this.scripts; }
/*    */   @NotNull
/*    */   public final File getScriptsFolder() {
/*    */     return this.scriptsFolder;
/*    */   }
/* 19 */   public final void loadScripts() { if (!this.scriptsFolder.exists()) {
/* 20 */       this.scriptsFolder.mkdir();
/*    */     }
/* 22 */     Intrinsics.checkExpressionValueIsNotNull(this.scriptsFolder.listFiles(new ScriptManager$loadScripts$1()), "scriptsFolder.listFiles(…h(scriptFileExtension) })"); File[] arrayOfFile1 = this.scriptsFolder.listFiles(new ScriptManager$loadScripts$1()); int $i$f$forEach = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     File[] arrayOfFile2;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     int i;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     byte b;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 94 */     for (arrayOfFile2 = arrayOfFile1, i = arrayOfFile2.length, b = 0; b < i; Intrinsics.checkExpressionValueIsNotNull(object1, "it"), loadScript((File)object1), b++) { Object element$iv = arrayOfFile2[b], object1 = element$iv; int $i$a$-forEach-ScriptManager$loadScripts$2 = 0; }  }
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\020\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Ljava/io/File;", "kotlin.jvm.PlatformType", "accept"}) static final class ScriptManager$loadScripts$1 implements FileFilter {
/* 96 */     public final boolean accept(File it) { Intrinsics.checkExpressionValueIsNotNull(it, "it"); Intrinsics.checkExpressionValueIsNotNull(it.getName(), "it.name"); return StringsKt.endsWith$default(it.getName(), ScriptManager.this.scriptFileExtension, false, 2, null); } } public final void enableScripts() { Iterable<Script> $this$forEach$iv = this.scripts; int $i$f$forEach = 0; Iterator<Script> iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); Script it = (Script)element$iv; int $i$a$-forEach-ScriptManager$enableScripts$1 = 0; it.onEnable(); }  }
/*    */   public final void unloadScripts() { this.scripts.clear(); }
/* 98 */   public final void loadScript(@NotNull File scriptFile) { Intrinsics.checkParameterIsNotNull(scriptFile, "scriptFile"); try { this.scripts.add(new Script(scriptFile)); ClientUtils.getLogger().info("[ScriptAPI] Successfully loaded script '" + scriptFile.getName() + "'."); } catch (Throwable t) { ClientUtils.getLogger().error("[ScriptAPI] Failed to load script '" + scriptFile.getName() + "'.", t); }  } public final void disableScripts() { Iterable<Script> $this$forEach$iv = this.scripts; int $i$f$forEach = 0; Iterator<Script> iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); Script it = (Script)element$iv; int $i$a$-forEach-ScriptManager$disableScripts$1 = 0;
/*    */       it.onDisable(); }
/*    */      }
/*    */ 
/*    */   
/*    */   public final void importScript(@NotNull File file) {
/*    */     Intrinsics.checkParameterIsNotNull(file, "file");
/*    */     File scriptFile = new File(this.scriptsFolder, file.getName());
/*    */     FilesKt.copyTo$default(file, scriptFile, false, 0, 6, null);
/*    */     loadScript(scriptFile);
/*    */     ClientUtils.getLogger().info("[ScriptAPI]  Successfully imported script '" + scriptFile.getName() + "'.");
/*    */   }
/*    */   
/*    */   public final void deleteScript(@NotNull Script script) {
/*    */     Intrinsics.checkParameterIsNotNull(script, "script");
/*    */     script.onDisable();
/*    */     this.scripts.remove(script);
/*    */     script.getScriptFile().delete();
/*    */     ClientUtils.getLogger().info("[ScriptAPI]  Successfully deleted script '" + script.getScriptFile().getName() + "'.");
/*    */   }
/*    */   
/*    */   public final void reloadScripts() {
/*    */     disableScripts();
/*    */     unloadScripts();
/*    */     loadScripts();
/*    */     enableScripts();
/*    */     ClientUtils.getLogger().info("[ScriptAPI]  Successfully reloaded scripts.");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\ScriptManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */