/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\006\n\002\b\002\n\002\020\021\n\002\b\004\n\002\020\007\n\002\b\003\n\002\020\b\n\002\b%\n\002\020!\n\002\b\002\n\002\020\013\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J/\020\006\032\b\022\004\022\0020\0040\0072\022\020\b\032\016\022\n\022\b\022\004\022\0020\0040\0070\0072\006\020\t\032\0020\004H\007¢\006\002\020\nJ\026\020\013\032\0020\f2\006\020\r\032\0020\f2\006\020\016\032\0020\fJ\036\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\022\032\0020\0202\006\020\023\032\0020\020J'\020\024\032\0020\0042\f\020\025\032\b\022\004\022\0020\0040\0072\f\020\026\032\b\022\004\022\0020\0040\007¢\006\002\020\027J5\020\030\032\0020\0042\f\020\031\032\b\022\004\022\0020\0040\0072\f\020\032\032\b\022\004\022\0020\0040\0072\f\020\033\032\b\022\004\022\0020\0040\007¢\006\002\020\034J\026\020\035\032\0020\f2\006\020\r\032\0020\0202\006\020\016\032\0020\fJ&\020\036\032\0020\0042\006\020\037\032\0020\0042\006\020 \032\0020\0042\006\020!\032\0020\0042\006\020\"\032\0020\004J5\020#\032\016\022\n\022\b\022\004\022\0020\0040\0070\0072\022\020\b\032\016\022\n\022\b\022\004\022\0020\0040\0070\0072\006\020$\032\0020\020H\007¢\006\002\020%J5\020&\032\b\022\004\022\0020\0040\0072\f\020\025\032\b\022\004\022\0020\0040\0072\f\020\026\032\b\022\004\022\0020\0040\0072\006\020\t\032\0020\004¢\006\002\020'J\016\020(\032\0020\0042\006\020)\032\0020\004J\030\020*\032\0020\0042\006\020+\032\0020\0042\006\020,\032\0020\004H\007J\020\020-\032\0020\0042\006\020.\032\0020\004H\007J\030\020/\032\0020\0042\006\020+\032\0020\0042\006\0200\032\0020\020H\007J_\0201\032\016\022\n\022\b\022\004\022\0020\0040\0070\0072\022\020\b\032\016\022\n\022\b\022\004\022\0020\0040\0070\0072\006\0202\032\0020\0042\b\b\002\0203\032\0020\0202\b\b\002\0204\032\0020\0202\024\b\002\0205\032\016\022\n\022\b\022\004\022\0020\0040\00706H\007¢\006\002\0207J\032\0208\032\00209*\0020\0042\006\020:\032\0020\0042\006\020;\032\0020\004J\032\0208\032\00209*\0020\f2\006\020:\032\0020\f2\006\020;\032\0020\fJ\032\0208\032\00209*\0020\0202\006\020:\032\0020\0202\006\020;\032\0020\020J\n\020<\032\0020\004*\0020\004J\n\020=\032\0020\004*\0020\004R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000¨\006>"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/MathUtils;", "", "()V", "DEGREES_TO_RADIANS", "", "RADIANS_TO_DEGREES", "calcCurvePoint", "", "points", "t", "([[Ljava/lang/Double;D)[Ljava/lang/Double;", "calculateGaussianValue", "", "x", "sigma", "clamp_int", "", "p_clamp_int_0_", "p_clamp_int_1_", "p_clamp_int_2_", "distanceSq", "a", "b", "([Ljava/lang/Double;[Ljava/lang/Double;)D", "distanceToSegmentSq", "p", "v", "w", "([Ljava/lang/Double;[Ljava/lang/Double;[Ljava/lang/Double;)D", "gaussian", "getDistance", "x1", "y1", "x2", "y2", "getPointsOnCurve", "num", "([[Ljava/lang/Double;I)[[Ljava/lang/Double;", "lerp", "([Ljava/lang/Double;[Ljava/lang/Double;D)[Ljava/lang/Double;", "radians", "degrees", "round", "value", "inc", "roundToHalf", "d", "roundToPlace", "places", "simplifyPoints", "epsilon", "start", "end", "outPoints", "", "([[Ljava/lang/Double;DIILjava/util/List;)[[Ljava/lang/Double;", "inRange", "", "base", "range", "toDegrees", "toRadians", "XSJClient"})
/*     */ public final class MathUtils {
/*     */   public static final double DEGREES_TO_RADIANS = 0.017453292519943295D;
/*     */   public static final double RADIANS_TO_DEGREES = 57.29577951308232D;
/*     */   public static final MathUtils INSTANCE;
/*     */   
/*     */   static {
/*  10 */     MathUtils mathUtils = new MathUtils();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final double radians(double degrees) {
/*  16 */     return degrees * Math.PI / '´';
/*     */   }
/*     */   
/*     */   public final double getDistance(double x1, double y1, double x2, double y2) {
/*  20 */     double d1 = x1 - x2, d2 = 2; boolean bool2 = false; d1 = y1 - y2; d2 = 2; double d3 = Math.pow(d1, d2); bool2 = false; double d4 = Math.pow(d1, d2); d1 = d3 + d4; boolean bool1 = false; return Math.sqrt(d1);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Double[] lerp(@NotNull Double[] a, @NotNull Double[] b, double t) {
/*  25 */     Intrinsics.checkParameterIsNotNull(a, "a"); Intrinsics.checkParameterIsNotNull(b, "b"); return new Double[] { Double.valueOf(a[0].doubleValue() + (b[0].doubleValue() - a[0].doubleValue()) * t), Double.valueOf(a[1].doubleValue() + (b[1].doubleValue() - a[1].doubleValue()) * t) };
/*     */   } public final double distanceSq(@NotNull Double[] a, @NotNull Double[] b) {
/*  27 */     Intrinsics.checkParameterIsNotNull(a, "a"); Intrinsics.checkParameterIsNotNull(b, "b"); double d1 = a[0].doubleValue() - b[0].doubleValue(); byte b1 = 2; boolean bool = false; d1 = a[1].doubleValue() - b[1].doubleValue(); b1 = 2; double d2 = Math.pow(d1, b1); bool = false; double d3 = Math.pow(d1, b1); return d2 + d3;
/*     */   }
/*     */   public final double distanceToSegmentSq(@NotNull Double[] p, @NotNull Double[] v, @NotNull Double[] w) {
/*  30 */     Intrinsics.checkParameterIsNotNull(p, "p"); Intrinsics.checkParameterIsNotNull(v, "v"); Intrinsics.checkParameterIsNotNull(w, "w"); double l2 = distanceSq(v, w);
/*  31 */     if (l2 == 0.0D) {
/*  32 */       return distanceSq(p, v);
/*     */     }
/*  34 */     return distanceSq(p, lerp(v, w, RangesKt.coerceAtLeast(RangesKt.coerceAtMost(((p[0].doubleValue() - v[0].doubleValue()) * (w[0].doubleValue() - v[0].doubleValue()) + (p[1].doubleValue() - v[1].doubleValue()) * (w[1].doubleValue() - v[1].doubleValue())) / l2, 1.0D), 0.0D)));
/*     */   }
/*     */   @JvmStatic
/*     */   public static final double roundToHalf(double d) {
/*  38 */     return Math.round(d * 2) / 2.0D;
/*     */   }
/*     */   @JvmStatic
/*     */   public static final double roundToPlace(double value, int places) {
/*  42 */     boolean bool1 = (places >= 0) ? true : false, bool2 = false, bool3 = false; bool3 = false; boolean bool4 = false; if (!bool1) { boolean bool = false; String str = "Failed requirement."; throw (Throwable)new IllegalArgumentException(str.toString()); }
/*  43 */      BigDecimal bd = new BigDecimal(value);
/*  44 */     Intrinsics.checkExpressionValueIsNotNull(bd.setScale(places, RoundingMode.HALF_UP), "bd.setScale(places, RoundingMode.HALF_UP)"); bd = bd.setScale(places, RoundingMode.HALF_UP);
/*  45 */     return bd.doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final double round(double value, double inc) {
/*  51 */     double halfOfInc = inc / 2.0D;
/*  52 */     double floored = Math.floor(value / inc) * inc;
/*  53 */     return (inc == 0.0D) ? value : ((inc == 1.0D) ? Math.round(value) : ((value >= floored + halfOfInc) ? (new BigDecimal(Math.ceil(value / inc) * inc))
/*  54 */       .doubleValue() : (new BigDecimal(floored))
/*  55 */       .doubleValue()));
/*     */   }
/*     */   
/*     */   public final boolean inRange(float $this$inRange, float base, float range) {
/*  59 */     float f2 = base - range, f3 = base + range, f1 = $this$inRange; return (f1 >= f2 && f1 <= f3);
/*     */   }
/*     */   
/*     */   public final boolean inRange(int $this$inRange, int base, int range) {
/*  63 */     int i = $this$inRange; if (base - range > i) { base + range; } else if (base + range >= i) {  }  return false;
/*     */   }
/*     */   
/*     */   public final boolean inRange(double $this$inRange, double base, double range) {
/*  67 */     double d2 = base - range, d3 = base + range, d1 = $this$inRange; return (d1 >= d2 && d1 <= d3);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*  72 */   public static final Double[] calcCurvePoint(@NotNull Double[][] points, double t) { Intrinsics.checkParameterIsNotNull(points, "points"); byte b = 0; List<Double[]> cpoints = new ArrayList(); int i;
/*  73 */     for (b = 0, i = ((Object[])points).length - 1; b < i; b++) {
/*  74 */       cpoints.add(INSTANCE.lerp(points[b], points[b + 1], t));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  79 */     Collection<Double[]> $this$toTypedArray$iv = (Collection<Double[]>)cpoints; int $i$f$toTypedArray = 0;
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
/* 158 */     Collection<Double[]> thisCollection$iv = $this$toTypedArray$iv;
/* 159 */     if (thisCollection$iv.toArray(new Double[0][]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  return (cpoints.size() == 1) ? cpoints.get(0) : calcCurvePoint(thisCollection$iv.toArray(new Double[0][]), t); } @JvmStatic @NotNull public static final Double[][] getPointsOnCurve(@NotNull Double[][] points, int num) { Intrinsics.checkParameterIsNotNull(points, "points"); byte b = 0; List<Double[]> cpoints = new ArrayList(); int i; for (b = 0, i = num; b < i; b++) { double t = b / (num - 1.0D); cpoints.add(calcCurvePoint(points, t)); }
/* 160 */      Collection<Double[]> $this$toTypedArray$iv = (Collection<Double[]>)cpoints; int $i$f$toTypedArray = 0; Collection<Double[]> thisCollection$iv = $this$toTypedArray$iv;
/* 161 */     if (thisCollection$iv.toArray(new Double[0][]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  return thisCollection$iv.toArray(new Double[0][]); } @JvmStatic @JvmOverloads @NotNull public static final Double[][] simplifyPoints(@NotNull Double[][] points, double epsilon, int start, int end, @NotNull List<Double[]> outPoints) { Intrinsics.checkParameterIsNotNull(points, "points"); Intrinsics.checkParameterIsNotNull(outPoints, "outPoints"); Double[] s = points[start]; Double[] e = points[end - 1]; double maxDistSq = 0.0D; int maxNdx = 1; for (int i = start + 1, j = end - 1; i < j; i++) { double distSq = INSTANCE.distanceToSegmentSq(points[i], s, e); if (distSq > maxDistSq) { maxDistSq = distSq; maxNdx = i; }  }  if (Math.sqrt(maxDistSq) > epsilon) { simplifyPoints(points, epsilon, start, maxNdx + 1, outPoints); simplifyPoints(points, epsilon, maxNdx, end, outPoints); } else { outPoints.add(s); outPoints.add(e); }
/* 162 */      Collection<Double[]> $this$toTypedArray$iv = (Collection<Double[]>)outPoints; int $i$f$toTypedArray = 0; Collection<Double[]> thisCollection$iv = $this$toTypedArray$iv;
/* 163 */     if (thisCollection$iv.toArray(new Double[0][]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  return thisCollection$iv.toArray(new Double[0][]); }
/*     */ 
/*     */   
/*     */   public final float calculateGaussianValue(float x, float sigma) {
/*     */     double PI = 3.141592653D;
/*     */     double output = 1.0D / Math.sqrt(2.0D * PI * (sigma * sigma));
/*     */     return (float)(output * Math.exp(-(x * x) / 2.0D * (sigma * sigma)));
/*     */   }
/*     */   
/*     */   public final int clamp_int(int p_clamp_int_0_, int p_clamp_int_1_, int p_clamp_int_2_) {
/*     */     return (p_clamp_int_0_ < p_clamp_int_1_) ? p_clamp_int_1_ : ((p_clamp_int_0_ > p_clamp_int_2_) ? p_clamp_int_2_ : p_clamp_int_0_);
/*     */   }
/*     */   
/*     */   public final double toRadians(double $this$toRadians) {
/*     */     return $this$toRadians * 0.017453292519943295D;
/*     */   }
/*     */   
/*     */   public final double toDegrees(double $this$toDegrees) {
/*     */     return $this$toDegrees * 57.29577951308232D;
/*     */   }
/*     */   
/*     */   public final float gaussian(int x, float sigma) {
/*     */     float s = sigma * sigma * 2;
/*     */     float f1 = (float)Math.PI * s, f2 = 1.0F;
/*     */     boolean bool = false;
/*     */     float f3 = (float)Math.sqrt(f1);
/*     */     f1 = -(x * x) / s;
/*     */     f2 /= f3;
/*     */     bool = false;
/*     */     f3 = (float)Math.exp(f1);
/*     */     return f2 * f3;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @JvmOverloads
/*     */   @NotNull
/*     */   public static final Double[][] simplifyPoints(@NotNull Double[][] points, double epsilon, int start, int end) {
/*     */     return simplifyPoints$default(points, epsilon, start, end, null, 16, null);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @JvmOverloads
/*     */   @NotNull
/*     */   public static final Double[][] simplifyPoints(@NotNull Double[][] points, double epsilon, int start) {
/*     */     return simplifyPoints$default(points, epsilon, start, 0, null, 24, null);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @JvmOverloads
/*     */   @NotNull
/*     */   public static final Double[][] simplifyPoints(@NotNull Double[][] points, double epsilon) {
/*     */     return simplifyPoints$default(points, epsilon, 0, 0, null, 28, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\MathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */