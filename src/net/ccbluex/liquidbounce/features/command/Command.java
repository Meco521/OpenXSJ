/*    */ package net.ccbluex.liquidbounce.features.command;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\021\n\002\b\007\n\002\020\002\n\002\b\n\n\002\020 \n\002\b\002\b&\030\0002\0020\001B!\022\006\020\002\032\0020\003\022\022\020\004\032\n\022\006\b\001\022\0020\0030\005\"\0020\003¢\006\002\020\006J\020\020\f\032\0020\r2\006\020\016\032\0020\003H\004J\033\020\017\032\0020\r2\f\020\020\032\b\022\004\022\0020\0030\005H\004¢\006\002\020\021J\020\020\017\032\0020\r2\006\020\022\032\0020\003H\004J\b\020\023\032\0020\rH\004J\033\020\024\032\0020\r2\f\020\025\032\b\022\004\022\0020\0030\005H&¢\006\002\020\021J\b\020\026\032\0020\rH\004J!\020\027\032\b\022\004\022\0020\0030\0302\f\020\025\032\b\022\004\022\0020\0030\005H\026¢\006\002\020\031R\033\020\004\032\n\022\006\b\001\022\0020\0030\005¢\006\n\n\002\020\t\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\n\020\013¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/Command;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "command", "", "alias", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getAlias", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCommand", "()Ljava/lang/String;", "chat", "", "msg", "chatSyntax", "syntaxes", "([Ljava/lang/String;)V", "syntax", "chatSyntaxError", "execute", "args", "playEdit", "tabComplete", "", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*    */ public abstract class Command extends MinecraftInstance { @NotNull
/*    */   private final String command;
/*    */   
/*    */   @NotNull
/*  7 */   public final String getCommand() { return this.command; } @NotNull private final String[] alias; @NotNull public final String[] getAlias() { return this.alias; } public Command(@NotNull String command, @NotNull String... alias) { this.command = command; this.alias = alias; }
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
/*    */   @NotNull
/*    */   public List<String> tabComplete(@NotNull String[] args) {
/* 22 */     Intrinsics.checkParameterIsNotNull(args, "args"); return CollectionsKt.emptyList();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void chat(@NotNull String msg) {
/* 28 */     Intrinsics.checkParameterIsNotNull(msg, "msg"); ClientUtils.displayChatMessage("§8[§9§lXSJ Client§8] §3" + msg);
/*    */   }
/*    */ 
/*    */   
/*    */   protected final void chatSyntax(@NotNull String syntax) {
/* 33 */     Intrinsics.checkParameterIsNotNull(syntax, "syntax"); ClientUtils.displayChatMessage("§8[§9§lXSJ Client§8] §3Syntax: §7" + Retreat.INSTANCE.getCommandManager().getPrefix() + syntax);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void chatSyntax(@NotNull String[] syntaxes) {
/* 39 */     Intrinsics.checkParameterIsNotNull(syntaxes, "syntaxes"); ClientUtils.displayChatMessage("§8[§9§lXSJ Client§8] §3Syntax:");
/*    */     
/* 41 */     for (String syntax : syntaxes) {
/* 42 */       String str1 = syntax; StringBuilder stringBuilder = (new StringBuilder()).append("§8> §7").append(Retreat.INSTANCE.getCommandManager().getPrefix()).append(this.command).append(' '); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str2 = str1.toLowerCase(); ClientUtils.displayChatMessage(stringBuilder.append(str2).toString());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected final void chatSyntaxError() {
/* 48 */     ClientUtils.displayChatMessage("§8[§9§lXSJ Client§8] §3Syntax error");
/*    */   }
/*    */ 
/*    */   
/*    */   protected final void playEdit() {
/* 53 */     MinecraftInstance.mc.getSoundHandler().playSound("random.anvil_use", 1.0F);
/*    */   }
/*    */   
/*    */   public abstract void execute(@NotNull String[] paramArrayOfString); }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\Command.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */