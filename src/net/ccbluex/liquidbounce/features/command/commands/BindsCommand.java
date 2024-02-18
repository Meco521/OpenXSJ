/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import java.util.Collection;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\033\020\003\032\0020\0042\f\020\005\032\b\022\004\022\0020\0070\006H\026¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/BindsCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "()V", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class BindsCommand extends Command {
/*    */   public BindsCommand() {
/*  8 */     super("binds", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 13 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (args.length > 1 && 
/* 14 */       StringsKt.equals(args[1], "clear", true)) {
/* 15 */       for (Module module : Retreat.INSTANCE.getModuleManager().getModules()) {
/* 16 */         module.setKeyBind(0);
/*    */       }
/* 18 */       chat("Removed all binds.");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 23 */     chat("§c§lBinds");
/* 24 */     Iterable $this$filter$iv = Retreat.INSTANCE.getModuleManager().getModules(); int $i$f$filter = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     Iterable iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 31 */     for (Object element$iv$iv : iterable1) { Module it = (Module)element$iv$iv; int $i$a$-filter-BindsCommand$execute$1 = 0; if ((it.getKeyBind() != 0))
/* 32 */         destination$iv$iv.add(element$iv$iv);  }  Iterable $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 33 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); Module it = (Module)element$iv; int $i$a$-forEach-BindsCommand$execute$2 = 0;
/*    */       ClientUtils.displayChatMessage("§6> §c" + it.getName() + ": §a§l" + Keyboard.getKeyName(it.getKeyBind())); }
/*    */     
/*    */     chatSyntax("binds clear");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\BindsCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */