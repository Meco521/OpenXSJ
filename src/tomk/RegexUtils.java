/*    */ package tomk;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\021\n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\006\n\002\b\002\n\002\020\b\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\031\020\003\032\b\022\004\022\0020\0050\0042\006\020\006\032\0020\007¢\006\002\020\bJ!\020\003\032\b\022\004\022\0020\0050\0042\006\020\t\032\0020\0052\006\020\n\032\0020\013¢\006\002\020\fJ!\020\003\032\b\022\004\022\0020\0050\0042\006\020\t\032\0020\0052\006\020\n\032\0020\005¢\006\002\020\rJ\026\020\016\032\0020\0172\006\020\020\032\0020\0172\006\020\021\032\0020\022¨\006\023"}, d2 = {"Ltomk/RegexUtils;", "", "()V", "match", "", "", "matcher", "Ljava/util/regex/Matcher;", "(Ljava/util/regex/Matcher;)[Ljava/lang/String;", "text", "pattern", "Ljava/util/regex/Pattern;", "(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "round", "", "value", "places", "", "XSJClient"})
/*    */ public final class RegexUtils {
/*  8 */   static { RegexUtils regexUtils = new RegexUtils(); } public static final RegexUtils INSTANCE; @NotNull
/*    */   public final String[] match(@NotNull Matcher matcher) {
/* 10 */     Intrinsics.checkParameterIsNotNull(matcher, "matcher"); boolean bool = false; List<String> result = new ArrayList();
/*    */     
/* 12 */     while (matcher.find()) {
/* 13 */       Intrinsics.checkExpressionValueIsNotNull(matcher.group(), "matcher.group()"); result.add(matcher.group());
/*    */     } 
/*    */     
/* 16 */     Collection<String> $this$toTypedArray$iv = result; int $i$f$toTypedArray = 0;
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
/* 39 */     Collection<String> thisCollection$iv = $this$toTypedArray$iv;
/* 40 */     if (thisCollection$iv.toArray(new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  return thisCollection$iv.toArray(new String[0]);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String[] match(@NotNull String text, @NotNull Pattern pattern) {
/*    */     Intrinsics.checkParameterIsNotNull(text, "text");
/*    */     Intrinsics.checkParameterIsNotNull(pattern, "pattern");
/*    */     Intrinsics.checkExpressionValueIsNotNull(pattern.matcher(text), "pattern.matcher(text)");
/*    */     return match(pattern.matcher(text));
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String[] match(@NotNull String text, @NotNull String pattern) {
/*    */     Intrinsics.checkParameterIsNotNull(text, "text");
/*    */     Intrinsics.checkParameterIsNotNull(pattern, "pattern");
/*    */     Intrinsics.checkExpressionValueIsNotNull(Pattern.compile(pattern), "Pattern.compile(pattern)");
/*    */     return match(text, Pattern.compile(pattern));
/*    */   }
/*    */   
/*    */   public final double round(double value, int places) {
/*    */     boolean bool1 = (places >= 0) ? true : false, bool2 = false, bool3 = false;
/*    */     bool3 = false;
/*    */     boolean bool4 = false;
/*    */     if (!bool1) {
/*    */       boolean bool = false;
/*    */       String str = "Failed requirement.";
/*    */       throw (Throwable)new IllegalArgumentException(str.toString());
/*    */     } 
/*    */     return BigDecimal.valueOf(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\RegexUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */