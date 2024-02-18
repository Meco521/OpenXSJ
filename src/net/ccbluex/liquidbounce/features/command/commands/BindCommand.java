/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import java.util.Collection;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/BindCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public final class BindCommand extends Command {
/*    */   public BindCommand() {
/*  9 */     super("bind", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 14 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 2) {
/*    */       
/* 16 */       Module module = Retreat.INSTANCE.getModuleManager().getModule(args[1]);
/*    */       
/* 18 */       if (module == null) {
/* 19 */         chat("Module §a§l" + args[1] + "§3 not found.");
/*    */         
/*    */         return;
/*    */       } 
/* 23 */       String str = args[2]; boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toUpperCase(), "(this as java.lang.String).toUpperCase()"); int key = Keyboard.getKeyIndex(str.toUpperCase());
/* 24 */       module.setKeyBind(key);
/*    */ 
/*    */       
/* 27 */       chat("Bound module §a§l" + module.getName() + "§3 to key §a§l" + Keyboard.getKeyName(key) + "§3.");
/* 28 */       Retreat.INSTANCE.getHud().addNotification(new Notification("Bind", "Bound " + module.getName() + " to " + Keyboard.getKeyName(key), NotifyType.INFO, 1500, 500));
/* 29 */       playEdit();
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     chatSyntax(new String[] { "<module> <key>", "<module> none" }); } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable $this$map$iv, $this$filter$iv; int $i$f$map, $i$f$filter; Iterable iterable1, $this$mapTo$iv$iv;
/*    */     Collection<String> collection;
/*    */     Collection<Object> destination$iv$iv;
/*    */     int $i$f$mapTo, $i$f$filterTo;
/* 37 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*    */     
/* 39 */     String moduleName = args[0];
/*    */     
/* 41 */     switch (args.length) { case 1:
/* 42 */         $this$map$iv = Retreat.INSTANCE.getModuleManager().getModules();
/* 43 */         $i$f$map = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 50 */         iterable1 = $this$map$iv; collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); $i$f$mapTo = 0;
/* 51 */         for (Object item$iv$iv : iterable1) {
/* 52 */           Module module = (Module)item$iv$iv; Collection<String> collection1 = collection; int $i$a$-map-BindCommand$tabComplete$1 = 0; String str = module.getName(); collection1.add(str);
/* 53 */         }  $this$filter$iv = collection; $i$f$filter = 0;
/* 54 */         $this$mapTo$iv$iv = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 55 */         for (Object element$iv$iv : $this$mapTo$iv$iv) { String it = (String)element$iv$iv; int $i$a$-filter-BindCommand$tabComplete$2 = 0;
/*    */           if (StringsKt.startsWith(it, moduleName, true))
/*    */             destination$iv$iv.add(element$iv$iv);  }
/*    */        }
/*    */     
/*    */     return CollectionsKt.emptyList(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\BindCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */