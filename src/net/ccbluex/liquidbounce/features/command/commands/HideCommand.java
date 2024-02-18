/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import java.util.Collection;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/HideCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public final class HideCommand extends Command {
/*    */   public HideCommand() {
/*  8 */     super("hide", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/*    */     Iterator iterator;
/* 14 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1)
/*    */     
/* 16 */     { if (StringsKt.equals(args[1], "list", true))
/* 17 */       { chat("§c§lHidden");
/* 18 */         Iterable $this$filter$iv = Retreat.INSTANCE.getModuleManager().getModules(); int $i$f$filter = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 78 */         Iterable iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 79 */         for (Object element$iv$iv : iterable1) { Module it = (Module)element$iv$iv; int $i$a$-filter-HideCommand$execute$1 = 0; if (!it.getArray())
/* 80 */             destination$iv$iv.add(element$iv$iv);  }  Iterable $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 81 */         iterator = $this$forEach$iv.iterator(); } else { if (StringsKt.equals(args[1], "clear", true)) { for (Module module1 : Retreat.INSTANCE.getModuleManager().getModules()) module1.setArray(true);  chat("Cleared hidden modules."); return; }  if (StringsKt.equals(args[1], "reset", true)) { for (Module module1 : Retreat.INSTANCE.getModuleManager().getModules()) module1.setArray(((ModuleInfo)module1.getClass().<ModuleInfo>getAnnotation(ModuleInfo.class)).array());  chat("Reset hidden modules."); return; }  Module module = Retreat.INSTANCE.getModuleManager().getModule(args[1]); if (module == null) { chat("Module §a§l" + args[1] + "§3 not found."); return; }  module.setArray(!module.getArray()); chat("Module §a§l" + module.getName() + "§3 is now §a§l" + (module.getArray() ? "visible" : "invisible") + "§3 on the array list."); playEdit(); return; }  } else { chatSyntax("hide <module/list/clear/reset>"); return; }  if (iterator.hasNext()) { Object element$iv = iterator.next(); Module it = (Module)element$iv; int $i$a$-forEach-HideCommand$execute$2 = 0; ClientUtils.displayChatMessage("§6> §c" + it.getName()); }  } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable $this$map$iv, $this$filter$iv; int $i$f$map, $i$f$filter; Iterable iterable1, $this$mapTo$iv$iv; Collection<String> collection; Collection<Object> destination$iv$iv; int $i$f$mapTo, $i$f$filterTo; Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0))
/*    */       return CollectionsKt.emptyList();  String moduleName = args[0]; switch (args.length) { case 1:
/* 83 */         $this$map$iv = Retreat.INSTANCE.getModuleManager().getModules(); $i$f$map = 0; iterable1 = $this$map$iv; collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); $i$f$mapTo = 0;
/* 84 */         for (Object item$iv$iv : iterable1) {
/* 85 */           Module module = (Module)item$iv$iv; Collection<String> collection1 = collection; int $i$a$-map-HideCommand$tabComplete$1 = 0; String str = module.getName(); collection1.add(str);
/* 86 */         }  $this$filter$iv = collection; $i$f$filter = 0;
/* 87 */         $this$mapTo$iv$iv = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 88 */         for (Object element$iv$iv : $this$mapTo$iv$iv) { String it = (String)element$iv$iv; int $i$a$-filter-HideCommand$tabComplete$2 = 0;
/*    */           if (StringsKt.startsWith(it, moduleName, true))
/*    */             destination$iv$iv.add(element$iv$iv);  }
/*    */        }
/*    */     
/*    */     return CollectionsKt.emptyList(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\HideCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */