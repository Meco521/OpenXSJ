/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/ToggleCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public final class ToggleCommand extends Command {
/*    */   public ToggleCommand() {
/*  6 */     super("toggle", new String[] { "t" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 11 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1) {
/* 12 */       Module module = Retreat.INSTANCE.getModuleManager().getModule(args[1]);
/*    */       
/* 14 */       if (module == null) {
/* 15 */         chat("Module '" + args[1] + "' not found.");
/*    */         
/*    */         return;
/*    */       } 
/* 19 */       if (args.length > 2) {
/* 20 */         String str1 = args[2]; boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String newState = str1.toLowerCase();
/*    */         
/* 22 */         if (Intrinsics.areEqual(newState, "on") || Intrinsics.areEqual(newState, "off")) {
/* 23 */           module.setState(Intrinsics.areEqual(newState, "on"));
/*    */         } else {
/* 25 */           chatSyntax("toggle <module> [on/off]");
/*    */           return;
/*    */         } 
/*    */       } else {
/* 29 */         module.toggle();
/*    */       } 
/*    */       
/* 32 */       chat((module.getState() ? "Enabled" : "Disabled") + " module §8" + module.getName() + "§3.");
/*    */       
/*    */       return;
/*    */     } 
/* 36 */     chatSyntax("toggle <module> [on/off]"); } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable $this$map$iv, $this$filter$iv; int $i$f$map, $i$f$filter; Iterable iterable1, $this$mapTo$iv$iv;
/*    */     Collection<String> collection;
/*    */     Collection<Object> destination$iv$iv;
/*    */     int $i$f$mapTo, $i$f$filterTo;
/* 40 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*    */     
/* 42 */     String moduleName = args[0];
/*    */     
/* 44 */     switch (args.length) { case 1:
/* 45 */         $this$map$iv = Retreat.INSTANCE.getModuleManager().getModules();
/* 46 */         $i$f$map = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 55 */         iterable1 = $this$map$iv; collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); $i$f$mapTo = 0;
/* 56 */         for (Object item$iv$iv : iterable1) {
/* 57 */           Module module = (Module)item$iv$iv; Collection<String> collection1 = collection; int $i$a$-map-ToggleCommand$tabComplete$1 = 0; String str = module.getName(); collection1.add(str);
/* 58 */         }  $this$filter$iv = collection; $i$f$filter = 0;
/* 59 */         $this$mapTo$iv$iv = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 60 */         for (Object element$iv$iv : $this$mapTo$iv$iv) { String it = (String)element$iv$iv; int $i$a$-filter-ToggleCommand$tabComplete$2 = 0;
/*    */           if (StringsKt.startsWith(it, moduleName, true))
/*    */             destination$iv$iv.add(element$iv$iv);  }
/*    */        }
/*    */     
/*    */     return CollectionsKt.emptyList(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\ToggleCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */