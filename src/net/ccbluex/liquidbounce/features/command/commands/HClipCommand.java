/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/HClipCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class HClipCommand extends Command {
/*    */   public HClipCommand() {
/*  6 */     super("hclip", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 11 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1) {
/*    */       try {
/* 13 */         String str = args[1]; boolean bool = false; MovementUtils.forward(Double.parseDouble(str));
/* 14 */         chat("You were teleported.");
/* 15 */       } catch (NumberFormatException exception) {
/* 16 */         chatSyntaxError();
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/* 21 */     chatSyntax("hclip <value>");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\HClipCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */