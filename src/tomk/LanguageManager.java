/*    */ package tomk;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\020\016\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\004\n\002\020\021\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\026\032\0020\0052\006\020\n\032\0020\005J+\020\027\032\0020\0052\006\020\n\032\0020\0052\026\020\030\032\f\022\b\b\001\022\004\030\0010\0010\031\"\004\030\0010\001¢\006\002\020\032J\016\020\033\032\0020\0052\006\020\034\032\0020\005R*\020\003\032\036\022\004\022\0020\005\022\004\022\0020\0050\004j\016\022\004\022\0020\005\022\004\022\0020\005`\006X\004¢\006\002\n\000R\024\020\007\032\0020\005XD¢\006\b\n\000\032\004\b\b\020\tR\024\020\n\032\0020\005XD¢\006\b\n\000\032\004\b\013\020\tR$\020\016\032\0020\r2\006\020\f\032\0020\r@BX\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\026\020\023\032\n \025*\004\030\0010\0240\024X\004¢\006\002\n\000¨\006\035"}, d2 = {"Ltomk/LanguageManager;", "", "()V", "cachedStrings", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "defaultLocale", "getDefaultLocale", "()Ljava/lang/String;", "key", "getKey", "value", "Ltomk/Language;", "language", "getLanguage", "()Ltomk/Language;", "setLanguage", "(Ltomk/Language;)V", "pattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "get", "getAndFormat", "argsIn", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "replace", "text", "XSJClient"})
/*    */ public final class LanguageManager {
/*  6 */   static { LanguageManager languageManager = new LanguageManager(); } @NotNull
/*  7 */   private static final String key = "%"; @NotNull public final String getKey() { return key; } @NotNull
/*  8 */   private static final String defaultLocale = "en_us"; @NotNull public final String getDefaultLocale() { return defaultLocale; }
/*    */    @NotNull
/* 10 */   private static Language language = new Language(defaultLocale); @NotNull public final Language getLanguage() { return language; }
/*    */    private final void setLanguage(Language value) {
/* 12 */     cachedStrings.clear();
/* 13 */     language = value;
/*    */   }
/*    */ 
/*    */   
/* 17 */   private static final HashMap<String, String> cachedStrings = new HashMap<>();
/* 18 */   private static final Pattern pattern = Pattern.compile(key + "[A-Za-z0-9.]*" + key); public static final LanguageManager INSTANCE;
/*    */   @NotNull
/*    */   public final String replace(@NotNull String text) {
/* 21 */     Intrinsics.checkParameterIsNotNull(text, "text"); if (!StringsKt.contains$default(text, key, false, 2, null)) {
/* 22 */       return text;
/*    */     }
/*    */     
/* 25 */     if (cachedStrings.containsKey(text)) {
/* 26 */       if (cachedStrings.get(text) == null) Intrinsics.throwNpe();  return cachedStrings.get(text);
/*    */     } 
/*    */     
/* 29 */     Matcher matcher = pattern.matcher(text);
/* 30 */     Object result = text;
/* 31 */     Intrinsics.checkExpressionValueIsNotNull(matcher, "matcher"); String[] arrayOfString1 = RegexUtils.INSTANCE.match(matcher); int $i$f$forEach = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 60 */     String[] arrayOfString2 = arrayOfString1; int i = arrayOfString2.length; byte b = 0; if (b < i) { Object element$iv = arrayOfString2[b], object1 = element$iv; int $i$a$-forEach-LanguageManager$replace$1 = 0;
/*    */       Object object2 = object1;
/*    */       boolean bool1 = true;
/*    */       int j = object1.length() - 1;
/*    */       boolean bool2 = false; }
/*    */     
/*    */     cachedStrings.put(text, result);
/*    */     return (String)result;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String get(@NotNull String key) {
/*    */     Intrinsics.checkParameterIsNotNull(key, "key");
/*    */     return language.get(key);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String getAndFormat(@NotNull String key, @NotNull Object... argsIn) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'key'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_2
/*    */     //   7: ldc 'argsIn'
/*    */     //   9: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   12: aload_2
/*    */     //   13: invokestatic toList : ([Ljava/lang/Object;)Ljava/util/List;
/*    */     //   16: checkcast java/util/Collection
/*    */     //   19: invokestatic toMutableList : (Ljava/util/Collection;)Ljava/util/List;
/*    */     //   22: astore_3
/*    */     //   23: aload_3
/*    */     //   24: checkcast java/lang/Iterable
/*    */     //   27: astore #4
/*    */     //   29: iconst_0
/*    */     //   30: istore #5
/*    */     //   32: iconst_0
/*    */     //   33: istore #6
/*    */     //   35: aload #4
/*    */     //   37: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   42: astore #7
/*    */     //   44: aload #7
/*    */     //   46: invokeinterface hasNext : ()Z
/*    */     //   51: ifeq -> 128
/*    */     //   54: aload #7
/*    */     //   56: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   61: astore #8
/*    */     //   63: iload #6
/*    */     //   65: iinc #6, 1
/*    */     //   68: istore #9
/*    */     //   70: iconst_0
/*    */     //   71: istore #10
/*    */     //   73: iload #9
/*    */     //   75: ifge -> 81
/*    */     //   78: invokestatic throwIndexOverflow : ()V
/*    */     //   81: iload #9
/*    */     //   83: istore #11
/*    */     //   85: iload #11
/*    */     //   87: aload #8
/*    */     //   89: astore #12
/*    */     //   91: istore #13
/*    */     //   93: iconst_0
/*    */     //   94: istore #14
/*    */     //   96: aload #12
/*    */     //   98: instanceof java/lang/String
/*    */     //   101: ifeq -> 124
/*    */     //   104: aload_3
/*    */     //   105: iload #13
/*    */     //   107: getstatic tomk/LanguageManager.INSTANCE : Ltomk/LanguageManager;
/*    */     //   110: aload #12
/*    */     //   112: checkcast java/lang/String
/*    */     //   115: invokevirtual replace : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   118: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
/*    */     //   123: pop
/*    */     //   124: nop
/*    */     //   125: goto -> 44
/*    */     //   128: nop
/*    */     //   129: getstatic kotlin/jvm/internal/StringCompanionObject.INSTANCE : Lkotlin/jvm/internal/StringCompanionObject;
/*    */     //   132: astore #4
/*    */     //   134: aload_0
/*    */     //   135: aload_1
/*    */     //   136: invokevirtual get : (Ljava/lang/String;)Ljava/lang/String;
/*    */     //   139: astore #5
/*    */     //   141: aload_3
/*    */     //   142: checkcast java/util/Collection
/*    */     //   145: astore #6
/*    */     //   147: iconst_0
/*    */     //   148: istore #7
/*    */     //   150: aload #6
/*    */     //   152: astore #8
/*    */     //   154: aload #8
/*    */     //   156: iconst_0
/*    */     //   157: anewarray java/lang/Object
/*    */     //   160: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*    */     //   165: dup
/*    */     //   166: ifnonnull -> 179
/*    */     //   169: new kotlin/TypeCastException
/*    */     //   172: dup
/*    */     //   173: ldc 'null cannot be cast to non-null type kotlin.Array<T>'
/*    */     //   175: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   178: athrow
/*    */     //   179: dup
/*    */     //   180: arraylength
/*    */     //   181: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*    */     //   184: astore #6
/*    */     //   186: iconst_0
/*    */     //   187: istore #7
/*    */     //   189: aload #5
/*    */     //   191: aload #6
/*    */     //   193: dup
/*    */     //   194: arraylength
/*    */     //   195: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*    */     //   198: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   201: dup
/*    */     //   202: ldc 'java.lang.String.format(format, *args)'
/*    */     //   204: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   207: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #49	-> 12
/*    */     //   #50	-> 23
/*    */     //   #62	-> 32
/*    */     //   #63	-> 35
/*    */     //   #63	-> 87
/*    */     //   #51	-> 96
/*    */     //   #52	-> 104
/*    */     //   #54	-> 124
/*    */     //   #64	-> 128
/*    */     //   #55	-> 129
/*    */     //   #65	-> 150
/*    */     //   #66	-> 154
/*    */     //   #55	-> 186
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   93	31	13	index	I
/*    */     //   93	31	12	arg	Ljava/lang/Object;
/*    */     //   96	28	14	$i$a$-forEachIndexed-LanguageManager$getAndFormat$1	I
/*    */     //   63	62	8	item$iv	Ljava/lang/Object;
/*    */     //   35	94	6	index$iv	I
/*    */     //   29	100	4	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*    */     //   32	97	5	$i$f$forEachIndexed	I
/*    */     //   154	25	8	thisCollection$iv	Ljava/util/Collection;
/*    */     //   147	32	6	$this$toTypedArray$iv	Ljava/util/Collection;
/*    */     //   150	29	7	$i$f$toTypedArray	I
/*    */     //   23	185	3	args	Ljava/util/List;
/*    */     //   0	208	0	this	Ltomk/LanguageManager;
/*    */     //   0	208	1	key	Ljava/lang/String;
/*    */     //   0	208	2	argsIn	[Ljava/lang/Object;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\LanguageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */