/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020 \n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\bJ!\020\t\032\b\022\004\022\0020\0070\n2\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/TargetCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public final class TargetCommand extends Command {
/*    */   public TargetCommand() {
/*  6 */     super("target", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 11 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1) {
/*    */       
/* 13 */       if (StringsKt.equals(args[1], "players", true)) {
/* 14 */         EntityUtils.targetPlayer = !EntityUtils.targetPlayer;
/* 15 */         chat("§7Target player toggled " + (EntityUtils.targetPlayer ? "on" : "off") + '.');
/* 16 */         playEdit();
/*    */         
/*    */         return;
/*    */       } 
/* 20 */       if (StringsKt.equals(args[1], "mobs", true)) {
/* 21 */         EntityUtils.targetMobs = !EntityUtils.targetMobs;
/* 22 */         chat("§7Target mobs toggled " + (EntityUtils.targetMobs ? "on" : "off") + '.');
/* 23 */         playEdit();
/*    */         
/*    */         return;
/*    */       } 
/* 27 */       if (StringsKt.equals(args[1], "animals", true)) {
/* 28 */         EntityUtils.targetAnimals = !EntityUtils.targetAnimals;
/* 29 */         chat("§7Target animals toggled " + (EntityUtils.targetAnimals ? "on" : "off") + '.');
/* 30 */         playEdit();
/*    */         
/*    */         return;
/*    */       } 
/* 34 */       if (StringsKt.equals(args[1], "invisible", true)) {
/* 35 */         EntityUtils.targetInvisible = !EntityUtils.targetInvisible;
/* 36 */         chat("§7Target Invisible toggled " + (EntityUtils.targetInvisible ? "on" : "off") + '.');
/* 37 */         playEdit();
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/*    */     
/* 43 */     chatSyntax("target <players/mobs/animals/invisible>"); } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable $this$filter$iv; int $i$f$filter;
/*    */     Iterable iterable1;
/*    */     Collection<Object> destination$iv$iv;
/*    */     int $i$f$filterTo;
/* 47 */     Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0)) return CollectionsKt.emptyList();
/*    */     
/* 49 */     switch (args.length) { case 1:
/* 50 */         $this$filter$iv = CollectionsKt.listOf((Object[])new String[] { "players", "mobs", "animals", "invisible" });
/* 51 */         $i$f$filter = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 56 */         iterable1 = $this$filter$iv; destination$iv$iv = new ArrayList(); $i$f$filterTo = 0;
/* 57 */         for (Object element$iv$iv : iterable1) { String it = (String)element$iv$iv; int $i$a$-filter-TargetCommand$tabComplete$1 = 0;
/*    */           if (StringsKt.startsWith(it, args[0], true))
/*    */             destination$iv$iv.add(element$iv$iv);  }
/*    */        }
/*    */     
/*    */     return CollectionsKt.emptyList(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\TargetCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */