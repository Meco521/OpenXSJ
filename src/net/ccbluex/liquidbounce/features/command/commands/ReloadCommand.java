/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/ReloadCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class ReloadCommand extends Command {
/*    */   public ReloadCommand() {
/*  9 */     super("reload", new String[] { "configreload" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 14 */     Intrinsics.checkParameterIsNotNull(args, "args"); chat("Reloading...");
/* 15 */     chat("§c§lReloading commands...");
/* 16 */     Retreat.INSTANCE.setCommandManager(new CommandManager());
/* 17 */     Retreat.INSTANCE.getCommandManager().registerCommands();
/* 18 */     Retreat.INSTANCE.setStarting(true);
/* 19 */     Retreat.INSTANCE.getScriptManager().disableScripts();
/* 20 */     Retreat.INSTANCE.getScriptManager().unloadScripts();
/* 21 */     for (Module module : Retreat.INSTANCE.getModuleManager().getModules()) {
/* 22 */       Intrinsics.checkExpressionValueIsNotNull(module, "module"); Retreat.INSTANCE.getModuleManager().generateCommand$XSJClient(module);
/* 23 */     }  chat("§c§lReloading scripts...");
/* 24 */     Retreat.INSTANCE.getScriptManager().loadScripts();
/* 25 */     Retreat.INSTANCE.getScriptManager().enableScripts();
/* 26 */     chat("§c§lReloading fonts...");
/* 27 */     Fonts.loadFonts();
/* 28 */     Retreat.INSTANCE.setStarting(false);
/* 29 */     chat("§c§lReloading values...");
/* 30 */     Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).valuesConfig);
/* 31 */     chat("§c§lReloading accounts...");
/* 32 */     Retreat.INSTANCE.getFileManager().loadConfig((FileConfig)(Retreat.INSTANCE.getFileManager()).accountsConfig);
/* 33 */     chat("§c§lReloading friends...");
/* 34 */     Retreat.INSTANCE.getFileManager().loadConfig((FileConfig)(Retreat.INSTANCE.getFileManager()).friendsConfig);
/* 35 */     chat("§c§lReloading xray...");
/* 36 */     Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).xrayConfig);
/* 37 */     chat("§c§lReloading HUD...");
/* 38 */     Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).hudConfig);
/* 39 */     chat("§c§lReloading ClickGUI...");
/* 40 */     Retreat.INSTANCE.setClickGui(new ClickGui());
/* 41 */     Retreat.INSTANCE.getFileManager().loadConfig((Retreat.INSTANCE.getFileManager()).clickGuiConfig);
/* 42 */     chat("Reloaded.");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\ReloadCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */