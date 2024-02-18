/*    */ package tomk;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\t\032\0020\nH\002J\016\020\013\032\0020\0032\006\020\f\032\0020\003J\020\020\r\032\0020\0162\006\020\002\032\0020\003H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\032\020\007\032\016\022\004\022\0020\003\022\004\022\0020\0030\bX\004¢\006\002\n\000¨\006\017"}, d2 = {"Ltomk/Language;", "", "locale", "", "(Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "translateMap", "Ljava/util/HashMap;", "find", "Ljava/io/InputStream;", "get", "key", "read", "", "XSJClient"})
/*    */ public final class Language {
/*    */   private final HashMap<String, String> translateMap;
/*    */   
/*    */   @NotNull
/*  7 */   public final String getLocale() { return this.locale; } @NotNull private final String locale; public Language(@NotNull String locale) { this.locale = locale;
/*    */     
/*  9 */     this.translateMap = new HashMap<>();
/*    */ 
/*    */     
/* 12 */     read(this.locale); }
/*    */ 
/*    */   
/*    */   private final InputStream find() {
/* 16 */     List<String> split = StringsKt.split$default(StringsKt.replace$default(this.locale, "-", "_", false, 4, null), new String[] { "_" }, false, 0, 6, null);
/*    */     
/* 18 */     if (split.size() > 1) {
/* 19 */       String str3 = split.get(0); StringBuilder stringBuilder = new StringBuilder(); boolean bool1 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str4 = str3.toLowerCase(); str3 = split.get(1); stringBuilder = stringBuilder.append(str4).append("-"); bool1 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toUpperCase(), "(this as java.lang.String).toUpperCase()"); str4 = str3.toUpperCase(); String str2 = stringBuilder.append(str4).toString();
/* 20 */       if (LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/" + str2 + "/source.properties") != null) { InputStream inputStream1 = LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/" + str2 + "/source.properties"); bool1 = false; boolean bool2 = false; InputStream it = inputStream1; int $i$a$-let-Language$find$1 = 0;
/* 21 */         return it; }
/*    */       
/*    */       LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/" + str2 + "/source.properties");
/*    */     } 
/* 25 */     String str1 = split.get(0); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str = str1.toLowerCase();
/* 26 */     if (LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/" + str + "/source.properties") != null) { InputStream inputStream1 = LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/" + str + "/source.properties"); bool = false; boolean bool1 = false; InputStream it = inputStream1; int $i$a$-let-Language$find$2 = 0;
/* 27 */       return it; }
/*    */     
/*    */     LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/" + str + "/source.properties");
/* 30 */     if (LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/source.properties") != null) { InputStream inputStream1 = LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/source.properties"); bool = false; boolean bool1 = false; InputStream it = inputStream1; int $i$a$-let-Language$find$3 = 0;
/* 31 */       return it; }
/*    */     
/*    */     LanguageManager.class.getClassLoader().getResourceAsStream("assets/minecraft/liquidbounce/translations/source.properties");
/* 34 */     throw (Throwable)new IllegalStateException("Can't find language file! Try sync gitsubmodule if this is a custom build!");
/*    */   }
/*    */   
/*    */   private final void read(String locale) {
/* 38 */     Properties prop = new Properties();
/*    */     
/* 40 */     prop.load(new InputStreamReader(find(), Charsets.UTF_8));
/*    */     
/* 42 */     for (Iterator<Map.Entry<Object, Object>> iterator = prop.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry entry1 = iterator.next(), entry2 = entry1; boolean bool = false; Object object1 = entry2.getKey(); entry2 = entry1; bool = false; Object value = entry2.getValue();
/* 43 */       if (object1 instanceof String && value instanceof String)
/* 44 */         this.translateMap.put(object1, value);  }
/*    */   
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String get(@NotNull String key) {
/* 50 */     Intrinsics.checkParameterIsNotNull(key, "key"); if ((String)this.translateMap.get(key) == null) (String)this.translateMap.get(key);  return key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\Language.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */