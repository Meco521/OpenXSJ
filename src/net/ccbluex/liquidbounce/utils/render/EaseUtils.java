/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\006\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\036\n\002\030\002\n\000\n\002\020\016\n\002\b\004\bÆ\002\030\0002\0020\001:\002+,B\007\b\002¢\006\002\020\002J\036\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\004J\016\020\n\032\0020\0042\006\020\013\032\0020\004J\016\020\f\032\0020\0042\006\020\013\032\0020\004J\016\020\r\032\0020\0042\006\020\013\032\0020\004J\016\020\016\032\0020\0042\006\020\013\032\0020\004J\016\020\017\032\0020\0042\006\020\013\032\0020\004J\016\020\020\032\0020\0042\006\020\013\032\0020\004J\016\020\021\032\0020\0042\006\020\013\032\0020\004J\016\020\022\032\0020\0042\006\020\013\032\0020\004J\016\020\023\032\0020\0042\006\020\013\032\0020\004J\016\020\024\032\0020\0042\006\020\013\032\0020\004J\016\020\025\032\0020\0042\006\020\013\032\0020\004J\016\020\026\032\0020\0042\006\020\013\032\0020\004J\016\020\027\032\0020\0042\006\020\013\032\0020\004J\016\020\030\032\0020\0042\006\020\013\032\0020\004J\016\020\031\032\0020\0042\006\020\013\032\0020\004J\016\020\032\032\0020\0042\006\020\013\032\0020\004J\016\020\033\032\0020\0042\006\020\013\032\0020\004J\016\020\034\032\0020\0042\006\020\013\032\0020\004J\016\020\035\032\0020\0042\006\020\013\032\0020\004J\016\020\036\032\0020\0042\006\020\013\032\0020\004J\016\020\037\032\0020\0042\006\020\013\032\0020\004J\016\020 \032\0020\0042\006\020\013\032\0020\004J\016\020!\032\0020\0042\006\020\013\032\0020\004J\016\020\"\032\0020\0042\006\020\013\032\0020\004J\020\020#\032\0020\0042\006\020\013\032\0020\004H\007J\016\020$\032\0020\0042\006\020\013\032\0020\004J\016\020%\032\0020\0042\006\020\013\032\0020\004J\016\020&\032\0020'2\006\020(\032\0020)J\016\020*\032\0020'2\006\020(\032\0020)¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;", "", "()V", "apply", "", "type", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "order", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "value", "easeInBack", "x", "easeInCirc", "easeInCubic", "easeInElastic", "easeInExpo", "easeInOutBack", "easeInOutCirc", "easeInOutCubic", "easeInOutElastic", "easeInOutExpo", "easeInOutQuad", "easeInOutQuart", "easeInOutQuint", "easeInOutSine", "easeInQuad", "easeInQuart", "easeInQuint", "easeInSine", "easeOutBack", "easeOutCirc", "easeOutCubic", "easeOutElastic", "easeOutExpo", "easeOutQuad", "easeOutQuart", "easeOutQuint", "easeOutSine", "getEnumEasingList", "Lnet/ccbluex/liquidbounce/value/ListValue;", "name", "", "getEnumEasingOrderList", "EnumEasingOrder", "EnumEasingType", "XSJClient"})
/*     */ public final class EaseUtils {
/*     */   public static final EaseUtils INSTANCE;
/*     */   
/*     */   static {
/*  11 */     EaseUtils easeUtils = new EaseUtils();
/*     */   } public final double easeInSine(double x) {
/*  13 */     double d1 = x * Math.PI / 2, d2 = true; boolean bool = false; double d3 = Math.cos(d1); return d2 - d3;
/*     */   }
/*     */   
/*     */   public final double easeOutSine(double x) {
/*  17 */     double d = x * Math.PI / 2; boolean bool = false; return Math.sin(d);
/*     */   }
/*     */   
/*     */   public final double easeInOutSine(double x) {
/*  21 */     double d = Math.PI * x; boolean bool = false; return -(Math.cos(d) - true) / 2;
/*     */   }
/*     */   
/*     */   public final double easeInQuad(double x) {
/*  25 */     return x * x;
/*     */   }
/*     */   
/*     */   public final double easeOutQuad(double x) {
/*  29 */     return true - (true - x) * (true - x);
/*     */   }
/*     */   
/*     */   public final double easeInOutQuad(double x) {
/*  33 */     double d1 = -2 * x + 2; byte b = 2; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (2 * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */   
/*     */   public final double easeInCubic(double x) {
/*  37 */     return x * x * x;
/*     */   }
/*     */   
/*     */   public final double easeOutCubic(double x) {
/*  41 */     double d1 = true - x; byte b = 3; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return d2 - d3;
/*     */   }
/*     */   
/*     */   public final double easeInOutCubic(double x) {
/*  45 */     double d1 = -2 * x + 2; byte b = 3; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (4 * x * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */   
/*     */   public final double easeInQuart(double x) {
/*  49 */     return x * x * x * x;
/*     */   }
/*     */   @JvmStatic
/*     */   public static final double easeOutQuart(double x) {
/*  53 */     double d1 = true - x; byte b = 4; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return d2 - d3;
/*     */   }
/*     */   
/*     */   public final double easeInOutQuart(double x) {
/*  57 */     double d1 = -2 * x + 2; byte b = 4; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (8 * x * x * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */   
/*     */   public final double easeInQuint(double x) {
/*  61 */     return x * x * x * x * x;
/*     */   }
/*     */   
/*     */   public final double easeOutQuint(double x) {
/*  65 */     double d1 = true - x; byte b = 5; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return d2 - d3;
/*     */   }
/*     */   
/*     */   public final double easeInOutQuint(double x) {
/*  69 */     double d1 = -2 * x + 2; byte b = 5; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (16 * x * x * x * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */   
/*     */   public final double easeInExpo(double x) {
/*  73 */     double d1 = 2.0D, d2 = 10 * x - 10; boolean bool = false; return (x == 0.0D) ? 0.0D : Math.pow(d1, d2);
/*     */   }
/*     */   
/*     */   public final double easeOutExpo(double x) {
/*  77 */     double d1 = 2.0D, d2 = -10 * x, d3 = true; boolean bool = false; double d4 = Math.pow(d1, d2); return (x == 1.0D) ? 1.0D : (d3 - d4);
/*     */   }
/*     */   
/*     */   public final double easeInOutExpo(double x) {
/*  81 */     double d1 = 2.0D, d2 = 20 * x - 10; boolean bool = false; d1 = 2.0D; d2 = -20 * x + 10; double d3 = 2; bool = false; double d4 = Math.pow(d1, d2); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : ((x < 0.5D) ? (Math.pow(d1, d2) / 2) : ((d3 - d4) / 2)));
/*     */   }
/*     */   
/*     */   public final double easeInCirc(double x) {
/*  85 */     double d1 = x; byte b = 2; double d3 = true, d2 = true; boolean bool = false; double d4 = Math.pow(d1, b); d1 = d3 - d4; d2 = d2; b = 0; d3 = Math.sqrt(d1); return d2 - d3;
/*     */   }
/*     */   
/*     */   public final double easeOutCirc(double x) {
/*  89 */     double d1 = x - true; byte b = 2; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); d1 = d2 - d3; b = 0; return Math.sqrt(d1);
/*     */   }
/*     */   
/*     */   public final double easeInOutCirc(double x) {
/*  93 */     double d1 = 2 * x; byte b = 2; double d3 = true, d2 = true; boolean bool = false; double d4 = Math.pow(d1, b); d1 = d3 - d4; d2 = d2; b = 0; d3 = Math.sqrt(d1); d1 = -2 * x + 2; b = 2; d2 = true; bool = false; d3 = Math.pow(d1, b); d1 = d2 - d3; b = 0; return (x < 0.5D) ? ((d2 - d3) / 2) : ((Math.sqrt(d1) + true) / 2);
/*     */   }
/*     */   
/*     */   public final double easeInBack(double x) {
/*  97 */     double c1 = 1.70158D;
/*  98 */     double c3 = c1 + true;
/*     */     
/* 100 */     return c3 * x * x * x - c1 * x * x;
/*     */   }
/*     */   
/*     */   public final double easeOutBack(double x) {
/* 104 */     double c1 = 1.70158D;
/* 105 */     double c3 = c1 + true;
/*     */     
/* 107 */     double d1 = x - true; byte b = 3; double d3 = c3, d2 = true; boolean bool = false; double d4 = Math.pow(d1, b); d1 = x - true; b = 2; d3 = c1; d2 += d3 * d4; bool = false; d4 = Math.pow(d1, b); return d2 + d3 * d4;
/*     */   }
/*     */   
/*     */   public final double easeInOutBack(double x) {
/* 111 */     double c1 = 1.70158D;
/* 112 */     double c2 = c1 * 1.525D;
/*     */     
/* 114 */     double d1 = 2 * x; byte b = 2; boolean bool = false; d1 = 2 * x - 2; b = 2; bool = false; return (x < 0.5D) ? (Math.pow(d1, b) * ((c2 + true) * 2 * x - c2) / 2) : ((Math.pow(d1, b) * ((c2 + true) * (x * 2 - 2) + c2) + 2) / 2);
/*     */   }
/*     */   
/*     */   public final double easeInElastic(double x) {
/* 118 */     double c4 = 2.0943951023931953D;
/*     */     
/* 120 */     double d1 = -2.0D, d2 = 10 * x - 10; boolean bool2 = false; d1 = (x * 10 - 10.75D) * c4; double d3 = Math.pow(d1, d2); boolean bool1 = false; double d4 = Math.sin(d1); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : (d3 * d4));
/*     */   }
/*     */   
/*     */   public final double easeOutElastic(double x) {
/* 124 */     double c4 = 2.0943951023931953D;
/*     */     
/* 126 */     double d1 = 2.0D, d2 = -10 * x; boolean bool2 = false; d1 = (x * 10 - 0.75D) * c4; double d3 = Math.pow(d1, d2); boolean bool1 = false; double d4 = Math.sin(d1); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : (d3 * d4 + true));
/*     */   }
/*     */   
/*     */   public final double easeInOutElastic(double x) {
/* 130 */     double c5 = 1.3962634015954636D;
/*     */     
/* 132 */     double d1 = 2.0D, d3 = 20 * x - 10; boolean bool3 = false; d1 = (20 * x - 11.125D) * c5; double d4 = Math.pow(d1, d3); boolean bool2 = false; double d5 = Math.sin(d1); d1 = 2.0D; double d2 = -20 * x + 10; bool3 = false; d1 = (20 * x - 11.125D) * c5; d4 = Math.pow(d1, d2); boolean bool1 = false; d5 = Math.sin(d1); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : ((x < 0.5D) ? (-(d4 * d5) / 2) : (d4 * d5 / 2 + true)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\020\n\002\b\002\n\002\020\016\n\002\b\r\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\fj\002\b\rj\002\b\016j\002\b\017j\002\b\020¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "", "(Ljava/lang/String;I)V", "friendlyName", "", "getFriendlyName", "()Ljava/lang/String;", "NONE", "SINE", "QUAD", "CUBIC", "QUART", "QUINT", "EXPO", "CIRC", "BACK", "ELASTIC", "XSJClient"})
/*     */   public enum EnumEasingType
/*     */   {
/*     */     NONE, SINE, QUAD, CUBIC, QUART, QUINT, EXPO, CIRC, BACK, ELASTIC;
/*     */     
/*     */     @NotNull
/*     */     private final String friendlyName;
/*     */ 
/*     */     
/*     */     EnumEasingType() {
/* 147 */       String str1 = name(); boolean bool1 = false; int i = 1; StringBuilder stringBuilder = new StringBuilder(); EnumEasingType enumEasingType = this; boolean bool2 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.substring(bool1, i), "(this as java.lang.Strin…ing(startIndex, endIndex)"); String str2 = str1.substring(bool1, i); stringBuilder = stringBuilder; enumEasingType = enumEasingType; bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toUpperCase(), "(this as java.lang.String).toUpperCase()"); str2 = str1.toUpperCase(); str1 = name(); bool1 = true; i = name().length(); stringBuilder = stringBuilder.append(str2); enumEasingType = enumEasingType; bool2 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.substring(bool1, i), "(this as java.lang.Strin…ing(startIndex, endIndex)"); str1 = str2 = str1.substring(bool1, i); stringBuilder = stringBuilder; enumEasingType = enumEasingType; bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str2 = str1.toLowerCase(); enumEasingType.friendlyName = stringBuilder.append(str2).toString(); } @NotNull public final String getFriendlyName() { return this.friendlyName; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\007\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "", "methodName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethodName", "()Ljava/lang/String;", "FAST_AT_START", "FAST_AT_END", "FAST_AT_START_AND_END", "XSJClient"})
/*     */   public enum EnumEasingOrder {
/*     */     FAST_AT_START, FAST_AT_END, FAST_AT_START_AND_END; @NotNull
/* 150 */     public final String getMethodName() { return this.methodName; } EnumEasingOrder(String methodName) { this.methodName = methodName; }
/*     */     
/*     */     @NotNull
/*     */     private final String methodName;
/*     */   }
/*     */   @NotNull
/* 156 */   public final ListValue getEnumEasingList(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); EnumEasingType[] arrayOfEnumEasingType1 = EnumEasingType.values(); String str1 = name; int $i$f$map = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     EnumEasingType[] arrayOfEnumEasingType2 = arrayOfEnumEasingType1; Collection<String> destination$iv$iv = new ArrayList(arrayOfEnumEasingType1.length); int $i$f$mapTo = 0;
/* 178 */     for (EnumEasingType item$iv$iv : arrayOfEnumEasingType2) {
/* 179 */       Object object = item$iv$iv; Collection<String> collection = destination$iv$iv; int $i$a$-map-EaseUtils$getEnumEasingList$1 = 0; String str = object.toString(); collection.add(str);
/* 180 */     }  List list2 = (List)destination$iv$iv, list1 = list2; str1 = str1; int $i$f$toTypedArray = 0;
/* 181 */     Collection thisCollection$iv = list1;
/* 182 */     if (thisCollection$iv.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  Object[] arrayOfObject = thisCollection$iv.toArray((Object[])new String[0]); String str2 = EnumEasingType.SINE.toString(), arrayOfString[] = (String[])arrayOfObject, str3 = str1; return new ListValue(str3, arrayOfString, str2); } @NotNull public final ListValue getEnumEasingOrderList(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); EnumEasingOrder[] arrayOfEnumEasingOrder1 = EnumEasingOrder.values(); String str1 = name; int $i$f$map = 0;
/* 183 */     EnumEasingOrder[] arrayOfEnumEasingOrder2 = arrayOfEnumEasingOrder1; Collection<String> destination$iv$iv = new ArrayList(arrayOfEnumEasingOrder1.length); int $i$f$mapTo = 0;
/* 184 */     for (EnumEasingOrder item$iv$iv : arrayOfEnumEasingOrder2) {
/* 185 */       Object object = item$iv$iv; Collection<String> collection = destination$iv$iv; int $i$a$-map-EaseUtils$getEnumEasingOrderList$1 = 0; String str = object.toString(); collection.add(str);
/* 186 */     }  List list2 = (List)destination$iv$iv, list1 = list2; str1 = str1; int $i$f$toTypedArray = 0;
/* 187 */     Collection thisCollection$iv = list1;
/* 188 */     if (thisCollection$iv.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  Object[] arrayOfObject = thisCollection$iv.toArray((Object[])new String[0]); String str2 = EnumEasingOrder.FAST_AT_START.toString(), arrayOfString[] = (String[])arrayOfObject, str3 = str1;
/*     */     return new ListValue(str3, arrayOfString, str2); }
/*     */ 
/*     */   
/*     */   public final double apply(@NotNull EnumEasingType type, @NotNull EnumEasingOrder order, double value) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'type'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_2
/*     */     //   7: ldc 'order'
/*     */     //   9: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   12: aload_1
/*     */     //   13: getstatic net/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType.NONE : Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;
/*     */     //   16: if_acmpne -> 21
/*     */     //   19: dload_3
/*     */     //   20: dreturn
/*     */     //   21: new java/lang/StringBuilder
/*     */     //   24: dup
/*     */     //   25: invokespecial <init> : ()V
/*     */     //   28: ldc 'ease'
/*     */     //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   33: aload_2
/*     */     //   34: invokevirtual getMethodName : ()Ljava/lang/String;
/*     */     //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   40: aload_1
/*     */     //   41: invokevirtual getFriendlyName : ()Ljava/lang/String;
/*     */     //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   47: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   50: astore #5
/*     */     //   52: aload_0
/*     */     //   53: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   56: invokevirtual getDeclaredMethods : ()[Ljava/lang/reflect/Method;
/*     */     //   59: dup
/*     */     //   60: ldc 'this.javaClass.declaredMethods'
/*     */     //   62: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   65: astore #6
/*     */     //   67: iconst_0
/*     */     //   68: istore #7
/*     */     //   70: aload #6
/*     */     //   72: astore #8
/*     */     //   74: iconst_0
/*     */     //   75: istore #9
/*     */     //   77: aload #8
/*     */     //   79: astore #10
/*     */     //   81: aload #10
/*     */     //   83: arraylength
/*     */     //   84: istore #11
/*     */     //   86: iconst_0
/*     */     //   87: istore #12
/*     */     //   89: iload #12
/*     */     //   91: iload #11
/*     */     //   93: if_icmpge -> 140
/*     */     //   96: aload #10
/*     */     //   98: iload #12
/*     */     //   100: aaload
/*     */     //   101: astore #13
/*     */     //   103: aload #13
/*     */     //   105: astore #14
/*     */     //   107: iconst_0
/*     */     //   108: istore #15
/*     */     //   110: aload #14
/*     */     //   112: dup
/*     */     //   113: ldc 'it'
/*     */     //   115: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   118: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   121: aload #5
/*     */     //   123: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   126: ifeq -> 134
/*     */     //   129: aload #13
/*     */     //   131: goto -> 141
/*     */     //   134: iinc #12, 1
/*     */     //   137: goto -> 89
/*     */     //   140: aconst_null
/*     */     //   141: astore #6
/*     */     //   143: iconst_0
/*     */     //   144: istore #7
/*     */     //   146: iconst_0
/*     */     //   147: istore #8
/*     */     //   149: aload #6
/*     */     //   151: astore #9
/*     */     //   153: iconst_0
/*     */     //   154: istore #10
/*     */     //   156: aload #9
/*     */     //   158: ifnull -> 204
/*     */     //   161: aload #9
/*     */     //   163: getstatic net/ccbluex/liquidbounce/utils/render/EaseUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;
/*     */     //   166: iconst_1
/*     */     //   167: anewarray java/lang/Object
/*     */     //   170: dup
/*     */     //   171: iconst_0
/*     */     //   172: dload_3
/*     */     //   173: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   176: aastore
/*     */     //   177: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   180: dup
/*     */     //   181: ifnonnull -> 195
/*     */     //   184: new kotlin/TypeCastException
/*     */     //   187: dup
/*     */     //   188: ldc_w 'null cannot be cast to non-null type kotlin.Double'
/*     */     //   191: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   194: athrow
/*     */     //   195: checkcast java/lang/Double
/*     */     //   198: invokevirtual doubleValue : ()D
/*     */     //   201: goto -> 237
/*     */     //   204: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   207: getstatic org/apache/logging/log4j/Level.ERROR : Lorg/apache/logging/log4j/Level;
/*     */     //   210: new java/lang/StringBuilder
/*     */     //   213: dup
/*     */     //   214: invokespecial <init> : ()V
/*     */     //   217: ldc_w 'Cannot found easing method: '
/*     */     //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   223: aload #5
/*     */     //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   228: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   231: invokeinterface log : (Lorg/apache/logging/log4j/Level;Ljava/lang/String;)V
/*     */     //   236: dload_3
/*     */     //   237: dreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #161	-> 12
/*     */     //   #162	-> 19
/*     */     //   #165	-> 21
/*     */     //   #167	-> 52
/*     */     //   #167	-> 110
/*     */     //   #167	-> 126
/*     */     //   #167	-> 143
/*     */     //   #168	-> 156
/*     */     //   #169	-> 161
/*     */     //   #171	-> 204
/*     */     //   #172	-> 236
/*     */     //   #168	-> 237
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   107	19	14	it	Ljava/lang/reflect/Method;
/*     */     //   110	16	15	$i$a$-find-EaseUtils$apply$1	I
/*     */     //   153	85	9	it	Ljava/lang/reflect/Method;
/*     */     //   156	82	10	$i$a$-also-EaseUtils$apply$2	I
/*     */     //   52	186	5	methodName	Ljava/lang/String;
/*     */     //   0	238	0	this	Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;
/*     */     //   0	238	1	type	Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;
/*     */     //   0	238	2	order	Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;
/*     */     //   0	238	3	value	D
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\EaseUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */