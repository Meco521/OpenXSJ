/*    */ package net.ccbluex.liquidbounce.features.command.shortcuts;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/shortcuts/Literal;", "Lnet/ccbluex/liquidbounce/features/command/shortcuts/Token;", "literal", "", "(Ljava/lang/String;)V", "getLiteral", "()Ljava/lang/String;", "XSJClient"})
/*    */ public final class Literal extends Token {
/*    */   @NotNull
/*    */   private final String literal;
/*    */   
/*    */   @NotNull
/* 10 */   public final String getLiteral() { return this.literal; } public Literal(@NotNull String literal) { this.literal = literal; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\shortcuts\Literal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */