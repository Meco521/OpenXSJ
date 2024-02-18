/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.command.Command;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/HelpCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class HelpCommand extends Command {
/*    */   public HelpCommand() {
/*  8 */     super("help", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 13 */     Intrinsics.checkParameterIsNotNull(args, "args"); int page = 1;
/*    */ 
/*    */     
/* 16 */     if (args.length > 1) {
/*    */       try {
/* 18 */         String str = args[1]; boolean bool1 = false; page = Integer.parseInt(str);
/* 19 */       } catch (NumberFormatException e) {
/* 20 */         chatSyntaxError();
/*    */       } 
/*    */     }
/*    */     
/* 24 */     if (page <= 0) {
/* 25 */       chat("The number you have entered is too low, it must be over 0");
/*    */       
/*    */       return;
/*    */     } 
/* 29 */     double maxPageDouble = Retreat.INSTANCE.getCommandManager().getCommands().size() / 8.0D;
/* 30 */     int maxPage = (maxPageDouble > (int)maxPageDouble) ? (
/* 31 */       (int)maxPageDouble + 1) : 
/*    */       
/* 33 */       (int)maxPageDouble;
/*    */     
/* 35 */     if (page > maxPage) {
/* 36 */       chat("The number you have entered is too big, it must be under " + maxPage + '.');
/*    */       
/*    */       return;
/*    */     } 
/* 40 */     chat("§c§lHelp");
/* 41 */     ClientUtils.displayChatMessage("§7> Page: §8" + page + " / " + maxPage);
/*    */     
/* 43 */     Iterable $this$sortedBy$iv = Retreat.INSTANCE.getCommandManager().getCommands(); int $i$f$sortedBy = 0;
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
/* 56 */     Iterable iterable1 = $this$sortedBy$iv; boolean bool = false; HelpCommand$execute$$inlined$sortedBy$1 helpCommand$execute$$inlined$sortedBy$1 = new HelpCommand$execute$$inlined$sortedBy$1(); List<Command> commands = CollectionsKt.sortedWith(iterable1, helpCommand$execute$$inlined$sortedBy$1);
/*    */     int i = 8 * (page - 1);
/*    */     while (i < 8 * page && i < commands.size()) {
/*    */       Command command = commands.get(i);
/*    */       String[] arrayOfString = command.getAlias();
/*    */       StringBuilder stringBuilder = (new StringBuilder()).append("§6> §7").append(Retreat.INSTANCE.getCommandManager().getPrefix()).append(command.getCommand());
/*    */       bool = false;
/*    */       boolean bool1 = (arrayOfString.length == 0) ? true : false;
/*    */       ClientUtils.displayChatMessage(stringBuilder.append(bool1 ? "" : (" §7(§8" + Strings.join(command.getAlias(), "§7, §8") + "§7)")).toString());
/*    */       i++;
/*    */     } 
/*    */     ClientUtils.displayChatMessage("§a------------\n§7> §c" + Retreat.INSTANCE.getCommandManager().getPrefix() + "help §8<§7§lpage§8>");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\HelpCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */