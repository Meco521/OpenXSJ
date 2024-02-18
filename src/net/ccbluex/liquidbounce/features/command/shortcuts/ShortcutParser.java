/*    */ package net.ccbluex.liquidbounce.features.command.shortcuts;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\000\n\002\020\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\002\b\003\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\"\020\005\032\0020\0062\f\020\007\032\b\022\004\022\0020\t0\b2\n\020\n\032\0060\013j\002`\fH\002J\032\020\r\032\016\022\n\022\b\022\004\022\0020\0170\0160\0162\006\020\020\032\0020\017J\026\020\021\032\b\022\004\022\0020\t0\0162\006\020\020\032\0020\017H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/shortcuts/ShortcutParser;", "", "()V", "SEPARATOR", "", "finishLiteral", "", "tokens", "", "Lnet/ccbluex/liquidbounce/features/command/shortcuts/Token;", "tokenBuf", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "parse", "", "", "script", "tokenize", "XSJClient"})
/*    */ public final class ShortcutParser {
/*    */   private static final int SEPARATOR;
/*    */   
/*    */   static {
/*  8 */     ShortcutParser shortcutParser = new ShortcutParser();
/*  9 */     String str = ";"; boolean bool1 = false, bool2 = false; SEPARATOR = str.codePointAt(bool1);
/*    */   } public static final ShortcutParser INSTANCE; @NotNull
/*    */   public final List<List<String>> parse(@NotNull String script) {
/* 12 */     Intrinsics.checkParameterIsNotNull(script, "script"); List<Token> tokens = tokenize(script);
/*    */     
/* 14 */     boolean bool1 = false; List<List> parsed = new ArrayList();
/* 15 */     boolean bool2 = false; List<String> tmpStatement = new ArrayList();
/*    */     
/* 17 */     for (Token token : tokens) {
/* 18 */       Token token1 = token;
/* 19 */       if (token1 instanceof Literal) { List<String> list = tmpStatement; String str = ((Literal)token).getLiteral(); boolean bool = false; list.add(str); continue; }
/* 20 */        if (token1 instanceof StatementEnd) {
/* 21 */         List<List> list = parsed; List list2 = CollectionsKt.toList(tmpStatement); boolean bool = false; list.add(list2);
/*    */         
/* 23 */         tmpStatement.clear();
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 28 */     List<String> list1 = tmpStatement; boolean bool3 = false; if (!list1.isEmpty()) {
/* 29 */       throw (Throwable)new IllegalArgumentException("Unexpected end of statement!");
/*    */     }
/* 31 */     return (List)parsed;
/*    */   }
/*    */   
/*    */   private final List<Token> tokenize(String script) {
/* 35 */     boolean bool1 = false; List<Token> tokens = new ArrayList();
/* 36 */     StringBuilder tokenBuf = new StringBuilder();
/*    */     
/* 38 */     for (PrimitiveIterator.OfInt ofInt = script.codePoints().iterator(); ofInt.hasNext(); ) { Integer code = ofInt.next();
/*    */       
/* 40 */       Intrinsics.checkExpressionValueIsNotNull(code, "code"); if (Character.isWhitespace(code.intValue())) { finishLiteral(tokens, tokenBuf); continue; }
/* 41 */        int i = SEPARATOR; if (code.intValue() == i) {
/* 42 */         finishLiteral(tokens, tokenBuf);
/*    */         
/* 44 */         List<Token> list = tokens; StatementEnd statementEnd = new StatementEnd(); boolean bool = false; list.add(statementEnd); continue;
/*    */       } 
/* 46 */       tokenBuf.appendCodePoint(code.intValue()); }
/*    */ 
/*    */ 
/*    */     
/* 50 */     StringBuilder stringBuilder1 = tokenBuf; boolean bool2 = false; if ((stringBuilder1.length() > 0)) {
/* 51 */       throw (Throwable)new IllegalArgumentException("Unexpected end of literal!");
/*    */     }
/* 53 */     return tokens;
/*    */   }
/*    */   
/*    */   private final void finishLiteral(List<Literal> tokens, StringBuilder tokenBuf) {
/* 57 */     StringBuilder stringBuilder = tokenBuf; boolean bool = false; if ((stringBuilder.length() > 0)) {
/* 58 */       List<Literal> list = tokens; Intrinsics.checkExpressionValueIsNotNull(tokenBuf.toString(), "tokenBuf.toString()"); Literal literal = new Literal(tokenBuf.toString()); boolean bool1 = false; list.add(literal);
/*    */       
/* 60 */       StringsKt.clear(tokenBuf);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\shortcuts\ShortcutParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */