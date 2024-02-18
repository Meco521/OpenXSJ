/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\006\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\036\n\002\030\002\n\000\n\002\020\016\n\002\b\004\bÆ\002\030\0002\0020\001:\002+,B\007\b\002¢\006\002\020\002J \020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\004H\007J\020\020\n\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\f\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\r\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\016\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\017\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\020\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\021\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\022\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\023\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\024\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\025\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\026\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\027\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\030\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\031\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\032\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\033\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\034\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\035\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\036\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\037\032\0020\0042\006\020\013\032\0020\004H\007J\020\020 \032\0020\0042\006\020\013\032\0020\004H\007J\020\020!\032\0020\0042\006\020\013\032\0020\004H\007J\020\020\"\032\0020\0042\006\020\013\032\0020\004H\007J\020\020#\032\0020\0042\006\020\013\032\0020\004H\007J\020\020$\032\0020\0042\006\020\013\032\0020\004H\007J\020\020%\032\0020\0042\006\020\013\032\0020\004H\007J\020\020&\032\0020'2\006\020(\032\0020)H\007J\020\020*\032\0020'2\006\020(\032\0020)H\007¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/EaseUtils;", "", "()V", "apply", "", "type", "Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingType;", "order", "Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingOrder;", "value", "easeInBack", "x", "easeInCirc", "easeInCubic", "easeInElastic", "easeInExpo", "easeInOutBack", "easeInOutCirc", "easeInOutCubic", "easeInOutElastic", "easeInOutExpo", "easeInOutQuad", "easeInOutQuart", "easeInOutQuint", "easeInOutSine", "easeInQuad", "easeInQuart", "easeInQuint", "easeInSine", "easeOutBack", "easeOutCirc", "easeOutCubic", "easeOutElastic", "easeOutExpo", "easeOutQuad", "easeOutQuart", "easeOutQuint", "easeOutSine", "getEnumEasingList", "Lnet/ccbluex/liquidbounce/value/ListValue;", "name", "", "getEnumEasingOrderList", "EnumEasingOrder", "EnumEasingType", "XSJClient"})
/*     */ public final class EaseUtils {
/*     */   public static final EaseUtils INSTANCE;
/*     */   
/*     */   static {
/*  14 */     EaseUtils easeUtils = new EaseUtils();
/*     */   } @JvmStatic
/*     */   public static final double easeInSine(double x) {
/*  17 */     double d1 = x * Math.PI / 2, d2 = true; boolean bool = false; double d3 = Math.cos(d1); return d2 - d3;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutSine(double x) {
/*  22 */     double d = x * Math.PI / 2; boolean bool = false; return Math.sin(d);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutSine(double x) {
/*  27 */     double d = Math.PI * x; boolean bool = false; return -(Math.cos(d) - true) / 2;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInQuad(double x) {
/*  32 */     return x * x;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutQuad(double x) {
/*  37 */     return true - (true - x) * (true - x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutQuad(double x) {
/*  45 */     double d1 = -2 * x + 2; byte b = 2; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (2 * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInCubic(double x) {
/*  51 */     return x * x * x;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutCubic(double x) {
/*  56 */     double d1 = true - x; byte b = 3; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return d2 - d3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutCubic(double x) {
/*  64 */     double d1 = -2 * x + 2; byte b = 3; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (4 * x * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInQuart(double x) {
/*  70 */     return x * x * x * x;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutQuart(double x) {
/*  75 */     double d1 = true - x; byte b = 4; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return d2 - d3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutQuart(double x) {
/*  83 */     double d1 = -2 * x + 2; byte b = 4; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (8 * x * x * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInQuint(double x) {
/*  89 */     return x * x * x * x * x;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutQuint(double x) {
/*  94 */     double d1 = true - x; byte b = 5; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return d2 - d3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutQuint(double x) {
/* 102 */     double d1 = -2 * x + 2; byte b = 5; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); return (x < 0.5D) ? (16 * x * x * x * x * x) : (d2 - d3 / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInExpo(double x) {
/* 111 */     double d1 = 2.0D, d2 = 10 * x - 10; boolean bool = false; return (x == 0.0D) ? 0.0D : Math.pow(d1, d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutExpo(double x) {
/* 120 */     double d1 = 2.0D, d2 = -10 * x, d3 = true; boolean bool = false; double d4 = Math.pow(d1, d2); return (x == 1.0D) ? 1.0D : (d3 - d4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutExpo(double x) {
/* 133 */     double d1 = 2.0D, d2 = 20 * x - 10; boolean bool = false;
/*     */     
/* 135 */     d1 = 2.0D; d2 = -20 * x + 10; double d3 = 2; bool = false; double d4 = Math.pow(d1, d2); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : ((x < 0.5D) ? (Math.pow(d1, d2) / 2) : ((d3 - d4) / 2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInCirc(double x) {
/* 143 */     double d1 = x; byte b = 2; double d3 = true, d2 = true; boolean bool = false; double d4 = Math.pow(d1, b); d1 = d3 - d4; d2 = d2; b = 0; d3 = Math.sqrt(d1); return d2 - d3;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutCirc(double x) {
/* 148 */     double d1 = x - true; byte b = 2; double d2 = true; boolean bool = false; double d3 = Math.pow(d1, b); d1 = d2 - d3; b = 0; return Math.sqrt(d1);
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutCirc(double x) {
/* 154 */     double d1 = 2 * x; byte b = 2; double d3 = true, d2 = true; boolean bool = false; double d4 = Math.pow(d1, b); d1 = d3 - d4; d2 = d2; b = 0; d3 = Math.sqrt(d1);
/*     */     
/* 156 */     d1 = -2 * x + 2; b = 2; d2 = true; bool = false; d3 = Math.pow(d1, b); d1 = d2 - d3; b = 0; return (x < 0.5D) ? ((d2 - d3) / 2) : ((Math.sqrt(d1) + true) / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInBack(double x) {
/* 162 */     double c1 = 1.70158D;
/* 163 */     double c3 = c1 + true;
/*     */     
/* 165 */     return c3 * x * x * x - c1 * x * x;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutBack(double x) {
/* 170 */     double c1 = 1.70158D;
/* 171 */     double c3 = c1 + true;
/*     */     
/* 173 */     double d1 = x - true; byte b = 3; double d3 = c3, d2 = true; boolean bool = false; double d4 = Math.pow(d1, b); d1 = x - true; b = 2; d3 = c1; d2 += d3 * d4; bool = false; d4 = Math.pow(d1, b); return d2 + d3 * d4;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutBack(double x) {
/* 178 */     double c1 = 1.70158D;
/* 179 */     double c2 = c1 * 1.525D;
/*     */ 
/*     */     
/* 182 */     double d1 = 2 * x; byte b = 2; boolean bool = false;
/*     */     
/* 184 */     d1 = 2 * x - 2; b = 2; bool = false; return (x < 0.5D) ? (Math.pow(d1, b) * ((c2 + true) * 2 * x - c2) / 2) : ((Math.pow(d1, b) * ((c2 + true) * (x * 2 - 2) + c2) + 2) / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInElastic(double x) {
/* 190 */     double c4 = 2.0943951023931953D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     double d1 = -2.0D, d2 = 10 * x - 10; boolean bool2 = false; d1 = (x * 10 - 10.75D) * c4; double d3 = Math.pow(d1, d2); boolean bool1 = false; double d4 = Math.sin(d1); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : (d3 * d4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeOutElastic(double x) {
/* 205 */     double c4 = 2.0943951023931953D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     double d1 = 2.0D, d2 = -10 * x; boolean bool2 = false; d1 = (x * 10 - 0.75D) * c4; double d3 = Math.pow(d1, d2); boolean bool1 = false; double d4 = Math.sin(d1); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : (d3 * d4 + true));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double easeInOutElastic(double x) {
/* 220 */     double c5 = 1.3962634015954636D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     double d1 = 2.0D, d3 = 20 * x - 10; boolean bool3 = false; d1 = (20 * x - 11.125D) * c5; double d4 = Math.pow(d1, d3); boolean bool2 = false; double d5 = Math.sin(d1);
/*     */     
/* 231 */     d1 = 2.0D; double d2 = -20 * x + 10; bool3 = false; d1 = (20 * x - 11.125D) * c5; d4 = Math.pow(d1, d2); boolean bool1 = false; d5 = Math.sin(d1); return (x == 0.0D) ? 0.0D : ((x == 1.0D) ? 1.0D : ((x < 0.5D) ? (-(d4 * d5) / 2) : (d4 * d5 / 2 + true)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\020\n\002\b\002\n\002\020\016\n\002\b\r\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\fj\002\b\rj\002\b\016j\002\b\017j\002\b\020¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingType;", "", "(Ljava/lang/String;I)V", "friendlyName", "", "getFriendlyName", "()Ljava/lang/String;", "NONE", "SINE", "QUAD", "CUBIC", "QUART", "QUINT", "EXPO", "CIRC", "BACK", "ELASTIC", "XSJClient"})
/*     */   public enum EnumEasingType
/*     */   {
/*     */     NONE, SINE, QUAD, CUBIC, QUART, QUINT, EXPO, CIRC, BACK, ELASTIC;
/*     */ 
/*     */     
/*     */     @NotNull
/*     */     private final String friendlyName;
/*     */ 
/*     */ 
/*     */     
/*     */     EnumEasingType() {
/* 249 */       String str1 = name(); boolean bool1 = false; int i = 1; StringBuilder stringBuilder = new StringBuilder(); EnumEasingType enumEasingType = this; boolean bool2 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.substring(bool1, i), "(this as java.lang.Strin…ing(startIndex, endIndex)"); String str2 = str1.substring(bool1, i); stringBuilder = stringBuilder; enumEasingType = enumEasingType; bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toUpperCase(), "(this as java.lang.String).toUpperCase()"); str2 = str1.toUpperCase(); str1 = name(); bool1 = true; i = name().length(); stringBuilder = stringBuilder.append(str2); enumEasingType = enumEasingType; bool2 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.substring(bool1, i), "(this as java.lang.Strin…ing(startIndex, endIndex)"); str1 = str2 = str1.substring(bool1, i); stringBuilder = stringBuilder; enumEasingType = enumEasingType; bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str2 = str1.toLowerCase(); enumEasingType.friendlyName = stringBuilder.append(str2).toString(); } @NotNull public final String getFriendlyName() { return this.friendlyName; } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\007\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingOrder;", "", "methodName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethodName", "()Ljava/lang/String;", "FAST_AT_START", "FAST_AT_END", "FAST_AT_START_AND_END", "XSJClient"})
/*     */   public enum EnumEasingOrder {
/*     */     FAST_AT_START, FAST_AT_END, FAST_AT_START_AND_END; @NotNull
/* 252 */     public final String getMethodName() { return this.methodName; } EnumEasingOrder(String methodName) { this.methodName = methodName; }
/*     */     
/*     */     @NotNull
/*     */     private final String methodName;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/* 260 */   public static final ListValue getEnumEasingList(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); EnumEasingType[] arrayOfEnumEasingType1 = EnumEasingType.values(); String str1 = name; int $i$f$map = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 287 */     EnumEasingType[] arrayOfEnumEasingType2 = arrayOfEnumEasingType1; Collection<String> destination$iv$iv = new ArrayList(arrayOfEnumEasingType1.length); int $i$f$mapTo = 0;
/* 288 */     for (EnumEasingType item$iv$iv : arrayOfEnumEasingType2) {
/* 289 */       Object object = item$iv$iv; Collection<String> collection = destination$iv$iv; int $i$a$-map-EaseUtils$getEnumEasingList$1 = 0; String str = object.toString(); collection.add(str);
/* 290 */     }  List list2 = (List)destination$iv$iv, list1 = list2; str1 = str1; int $i$f$toTypedArray = 0;
/* 291 */     Collection thisCollection$iv = list1;
/* 292 */     if (thisCollection$iv.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  Object[] arrayOfObject = thisCollection$iv.toArray((Object[])new String[0]); String str2 = EnumEasingType.SINE.toString(), arrayOfString[] = (String[])arrayOfObject, str3 = str1; return new ListValue(str3, arrayOfString, str2); } @JvmStatic @NotNull public static final ListValue getEnumEasingOrderList(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); EnumEasingOrder[] arrayOfEnumEasingOrder1 = EnumEasingOrder.values(); String str1 = name; int $i$f$map = 0;
/* 293 */     EnumEasingOrder[] arrayOfEnumEasingOrder2 = arrayOfEnumEasingOrder1; Collection<String> destination$iv$iv = new ArrayList(arrayOfEnumEasingOrder1.length); int $i$f$mapTo = 0;
/* 294 */     for (EnumEasingOrder item$iv$iv : arrayOfEnumEasingOrder2) {
/* 295 */       Object object = item$iv$iv; Collection<String> collection = destination$iv$iv; int $i$a$-map-EaseUtils$getEnumEasingOrderList$1 = 0; String str = object.toString(); collection.add(str);
/* 296 */     }  List list2 = (List)destination$iv$iv, list1 = list2; str1 = str1; int $i$f$toTypedArray = 0;
/* 297 */     Collection thisCollection$iv = list1;
/* 298 */     if (thisCollection$iv.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  Object[] arrayOfObject = thisCollection$iv.toArray((Object[])new String[0]); String str2 = EnumEasingOrder.FAST_AT_START.toString(), arrayOfString[] = (String[])arrayOfObject, str3 = str1;
/*     */     return new ListValue(str3, arrayOfString, str2); }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double apply(@NotNull EnumEasingType type, @NotNull EnumEasingOrder order, double value) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ldc 'type'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: ldc 'order'
/*     */     //   9: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   12: aload_0
/*     */     //   13: getstatic net/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingType.NONE : Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingType;
/*     */     //   16: if_acmpne -> 21
/*     */     //   19: dload_2
/*     */     //   20: dreturn
/*     */     //   21: new java/lang/StringBuilder
/*     */     //   24: dup
/*     */     //   25: invokespecial <init> : ()V
/*     */     //   28: ldc 'ease'
/*     */     //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   33: aload_1
/*     */     //   34: invokevirtual getMethodName : ()Ljava/lang/String;
/*     */     //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   40: aload_0
/*     */     //   41: invokevirtual getFriendlyName : ()Ljava/lang/String;
/*     */     //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   47: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   50: astore #4
/*     */     //   52: getstatic net/ccbluex/liquidbounce/utils/EaseUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/EaseUtils;
/*     */     //   55: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   58: invokevirtual getDeclaredMethods : ()[Ljava/lang/reflect/Method;
/*     */     //   61: dup
/*     */     //   62: ldc 'this.javaClass.declaredMethods'
/*     */     //   64: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   67: astore #5
/*     */     //   69: iconst_0
/*     */     //   70: istore #6
/*     */     //   72: aload #5
/*     */     //   74: astore #7
/*     */     //   76: iconst_0
/*     */     //   77: istore #8
/*     */     //   79: aload #7
/*     */     //   81: astore #9
/*     */     //   83: aload #9
/*     */     //   85: arraylength
/*     */     //   86: istore #10
/*     */     //   88: iconst_0
/*     */     //   89: istore #11
/*     */     //   91: iload #11
/*     */     //   93: iload #10
/*     */     //   95: if_icmpge -> 142
/*     */     //   98: aload #9
/*     */     //   100: iload #11
/*     */     //   102: aaload
/*     */     //   103: astore #12
/*     */     //   105: aload #12
/*     */     //   107: astore #13
/*     */     //   109: iconst_0
/*     */     //   110: istore #14
/*     */     //   112: aload #13
/*     */     //   114: dup
/*     */     //   115: ldc 'it'
/*     */     //   117: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   120: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   123: aload #4
/*     */     //   125: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   128: ifeq -> 136
/*     */     //   131: aload #12
/*     */     //   133: goto -> 143
/*     */     //   136: iinc #11, 1
/*     */     //   139: goto -> 91
/*     */     //   142: aconst_null
/*     */     //   143: astore #5
/*     */     //   145: iconst_0
/*     */     //   146: istore #6
/*     */     //   148: iconst_0
/*     */     //   149: istore #7
/*     */     //   151: aload #5
/*     */     //   153: astore #8
/*     */     //   155: iconst_0
/*     */     //   156: istore #9
/*     */     //   158: aload #8
/*     */     //   160: ifnull -> 206
/*     */     //   163: aload #8
/*     */     //   165: getstatic net/ccbluex/liquidbounce/utils/EaseUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/EaseUtils;
/*     */     //   168: iconst_1
/*     */     //   169: anewarray java/lang/Object
/*     */     //   172: dup
/*     */     //   173: iconst_0
/*     */     //   174: dload_2
/*     */     //   175: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   178: aastore
/*     */     //   179: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   182: dup
/*     */     //   183: ifnonnull -> 197
/*     */     //   186: new kotlin/TypeCastException
/*     */     //   189: dup
/*     */     //   190: ldc_w 'null cannot be cast to non-null type kotlin.Double'
/*     */     //   193: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   196: athrow
/*     */     //   197: checkcast java/lang/Double
/*     */     //   200: invokevirtual doubleValue : ()D
/*     */     //   203: goto -> 207
/*     */     //   206: dload_2
/*     */     //   207: dreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #271	-> 12
/*     */     //   #272	-> 19
/*     */     //   #275	-> 21
/*     */     //   #277	-> 52
/*     */     //   #277	-> 112
/*     */     //   #277	-> 128
/*     */     //   #277	-> 145
/*     */     //   #278	-> 158
/*     */     //   #279	-> 163
/*     */     //   #282	-> 206
/*     */     //   #278	-> 207
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   109	19	13	it	Ljava/lang/reflect/Method;
/*     */     //   112	16	14	$i$a$-find-EaseUtils$apply$1	I
/*     */     //   155	53	8	it	Ljava/lang/reflect/Method;
/*     */     //   158	50	9	$i$a$-also-EaseUtils$apply$2	I
/*     */     //   52	156	4	methodName	Ljava/lang/String;
/*     */     //   0	208	0	type	Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingType;
/*     */     //   0	208	1	order	Lnet/ccbluex/liquidbounce/utils/EaseUtils$EnumEasingOrder;
/*     */     //   0	208	2	value	D
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\EaseUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */