/*    */ package net.ccbluex.liquidbounce.features.command.shortcuts;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.command.Command;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\020\021\n\002\b\006\n\002\020\002\n\002\b\003\030\0002\0020\001B-\022\006\020\002\032\0020\003\022\036\020\004\032\032\022\026\022\024\022\004\022\0020\001\022\n\022\b\022\004\022\0020\0030\0070\0060\005¢\006\002\020\bJ\033\020\r\032\0020\0162\f\020\017\032\b\022\004\022\0020\0030\007H\026¢\006\002\020\020R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR)\020\004\032\032\022\026\022\024\022\004\022\0020\001\022\n\022\b\022\004\022\0020\0030\0070\0060\005¢\006\b\n\000\032\004\b\013\020\f¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/shortcuts/Shortcut;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "name", "", "script", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getScript", "()Ljava/util/List;", "execute", "", "args", "([Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class Shortcut extends Command {
/*    */   @NotNull
/*    */   private final String name;
/*    */   
/* 10 */   public Shortcut(@NotNull String name, @NotNull List<Pair<Command, String[]>> script) { super(name, new String[0]); this.name = name; this.script = script; } @NotNull private final List<Pair<Command, String[]>> script; @NotNull public final List<Pair<Command, String[]>> getScript() { return this.script; } @NotNull public final String getName() { return this.name; }
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 15 */     Intrinsics.checkParameterIsNotNull(args, "args"); Iterable<Pair<Command, String[]>> $this$forEach$iv = this.script; int $i$f$forEach = 0;
/*    */ 
/*    */ 
/*    */     
/* 19 */     Iterator<Pair<Command, String[]>> iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object<Command, String[]> element$iv = (Object<Command, String[]>)iterator.next(); Pair it = (Pair)element$iv; int $i$a$-forEach-Shortcut$execute$1 = 0;
/*    */       ((Command)it.getFirst()).execute((String[])it.getSecond()); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\shortcuts\Shortcut.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */