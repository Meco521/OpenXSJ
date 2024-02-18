/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ @ElementInfo(name = "NewEffects2")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\020\n\002\020 \n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020%\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\007\n\002\020\016\n\000\n\002\020\b\n\000\n\002\020\002\n\002\b\006\b\007\030\000 W2\0020\001:\001WB#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\n\020E\032\004\030\0010FH\026J\006\020G\032\0020!J \020H\032\0020\0032\006\020I\032\0020\0032\006\020J\032\0020\0032\006\020K\032\0020\003H\002J\006\020L\032\0020!J\020\020M\032\0020N2\006\020O\032\0020PH\002J\b\020Q\032\0020RH\026J\016\020S\032\0020R2\006\020T\032\0020\006J\016\020U\032\0020R2\006\020T\032\0020\006J\b\020V\032\0020RH\026R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\n\020\013R\021\020\f\032\0020\t¢\006\b\n\000\032\004\b\r\020\013R\032\020\016\032\0020\006X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\032\020\023\032\0020\006X\016¢\006\016\n\000\032\004\b\024\020\020\"\004\b\025\020\022R\032\020\026\032\0020\006X\016¢\006\016\n\000\032\004\b\027\020\020\"\004\b\030\020\022R \020\031\032\b\022\004\022\0020\0330\032X\016¢\006\016\n\000\032\004\b\034\020\035\"\004\b\036\020\037R\026\020 \032\n \"*\004\030\0010!0!X\016¢\006\002\n\000R\020\020#\032\004\030\0010!X\016¢\006\002\n\000R\021\020$\032\0020\t¢\006\b\n\000\032\004\b%\020\013R\032\020&\032\0020\006X\016¢\006\016\n\000\032\004\b'\020\020\"\004\b(\020\022R\021\020)\032\0020*¢\006\b\n\000\032\004\b+\020,R\016\020-\032\0020.X\004¢\006\002\n\000R\034\020/\032\020\022\004\022\00201\022\006\022\004\030\0010200X\004¢\006\002\n\000R\036\0203\032\022\022\006\022\004\030\00104\022\006\022\004\030\0010500X\004¢\006\002\n\000R\021\0206\032\0020\t¢\006\b\n\000\032\004\b7\020\013R\016\0208\032\00209X\004¢\006\002\n\000R\020\020:\032\004\030\0010!X\016¢\006\002\n\000R\016\020;\032\0020\tX\004¢\006\002\n\000R\016\020<\032\0020\tX\004¢\006\002\n\000R\016\020=\032\0020\tX\004¢\006\002\n\000R\020\020>\032\004\030\0010!X\016¢\006\002\n\000R\032\020?\032\0020@X\016¢\006\016\n\000\032\004\bA\020B\"\004\bC\020D¨\006X"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "alpha", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getAlpha", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b", "getB", "backamin", "getBackamin", "()F", "setBackamin", "(F)V", "easinghealth", "getEasinghealth", "setEasinghealth", "easingwith", "getEasingwith", "setEasingwith", "effects", "", "Lnet/minecraft/potion/PotionEffect;", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "firstColor", "Ljava/awt/Color;", "kotlin.jvm.PlatformType", "fourthColor", "g", "getG", "healthamin", "getHealthamin", "setHealthamin", "hudMod", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHudMod", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "modes", "Lnet/ccbluex/liquidbounce/value/ListValue;", "potionMap", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "Lnet/ccbluex/liquidbounce/utils/PotionData;", "potionMap2", "Lnet/minecraft/potion/Potion;", "Lnet/ccbluex/liquidbounce/utils/render/PotionData;", "r", "getR", "ridius", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "secondColor", "textblueValue", "textgreenValue", "textredValue", "thirdColor", "timer", "Lnet/ccbluex/liquidbounce/utils/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/MSTimer;", "setTimer", "(Lnet/ccbluex/liquidbounce/utils/MSTimer;)V", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getAlternateClientColor", "getAnimationState", "animation", "finalState", "speed", "getClientColor", "intToRomanByGreedy", "", "num", "", "shader", "", "updateAnimhealth", "easing", "updateAnimwith", "updateElement", "Companion", "XSJClient"})
/*     */ public final class NewEffects2 extends Element { private final ListValue modes; @NotNull
/*     */   private final IntegerValue alpha; private final FloatValue ridius; @NotNull
/*     */   private final IntegerValue r; @NotNull
/*     */   private final IntegerValue g; @NotNull
/*     */   private final IntegerValue b; private final IntegerValue textredValue; private final IntegerValue textgreenValue; private final IntegerValue textblueValue; private final Map<IPotion, PotionData> potionMap; private final Map<Potion, PotionData> potionMap2; @NotNull
/*     */   private List<? extends PotionEffect> effects; @NotNull
/*     */   private final HUD hudMod; private Color firstColor; private Color secondColor; private Color thirdColor; private Color fourthColor; @NotNull
/*     */   private MSTimer timer; private float easingwith; private float backamin; private float easinghealth; private float healthamin; @JvmField
/*     */   @NotNull
/*     */   public static final BoolValue novoshadow;
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\b\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lnet/minecraft/potion/PotionEffect;", "applyAsInt"})
/*     */   static final class NewEffects2$updateElement$1<T> implements ToIntFunction<T> { public final int applyAsInt(@NotNull PotionEffect it) {
/*     */       Intrinsics.checkParameterIsNotNull(it, "it");
/*     */       if (Potion.func_188412_a(Potion.func_188409_a(it.func_188419_a())) == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       Intrinsics.checkExpressionValueIsNotNull(Potion.func_188412_a(Potion.func_188409_a(it.func_188419_a())), "Potion.getPotionById(Pot…dFromPotion(it.potion))!!");
/*     */       return -Fonts.font35.getStringWidth(I18n.func_135052_a(Potion.func_188412_a(Potion.func_188409_a(it.func_188419_a())).func_76393_a(), new Object[0]) + " " + NewEffects2.this.intToRomanByGreedy(it.func_76458_c() + 1));
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\f\n\000\n\002\030\002\n\002\030\002\n\000\020\000\032\b\022\004\022\0020\0020\001H\n¢\006\002\b\003"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lnet/minecraft/potion/PotionEffect;", "get"})
/*     */   static final class NewEffects2$updateElement$2<T> implements Supplier<C> { public static final NewEffects2$updateElement$2 INSTANCE = new NewEffects2$updateElement$2();
/*     */     
/*     */     @NotNull
/*     */     public final ArrayList<PotionEffect> get() {
/*     */       return new ArrayList<>();
/*     */     } }
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getAlpha() {
/*     */     return this.alpha;
/*     */   }
/*     */   
/*  37 */   public NewEffects2(double x, double y, float scale) { super(0.0D, 0.0D, 0.0F, null, 15, null);
/*  38 */     this.modes = new ListValue("Mode", new String[] { "New", "Outline", "NewNovoline" }, "New");
/*  39 */     this.alpha = new IntegerValue("BG-Alpha", 40, 0, 255);
/*  40 */     this.ridius = new FloatValue("Ridius", 5.0F, 0.0F, 15.0F);
/*  41 */     this.r = new IntegerValue("Red", 0, 0, 255);
/*  42 */     this.g = new IntegerValue("Green", 0, 0, 255);
/*  43 */     this.b = new IntegerValue("Blue", 0, 0, 255);
/*  44 */     this.textredValue = new IntegerValue("Text-R", 255, 0, 255);
/*  45 */     this.textgreenValue = new IntegerValue("Text-G", 244, 0, 255);
/*  46 */     this.textblueValue = new IntegerValue("Text-B", 255, 0, 255);
/*  47 */     this.potionMap = new HashMap<>();
/*  48 */     this.potionMap2 = new HashMap<>();
/*  49 */     this.effects = new ArrayList<>();
/*  50 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hudMod = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*  51 */     this.firstColor = Color.BLACK;
/*  52 */     this.secondColor = Color.BLACK;
/*  53 */     this.thirdColor = Color.BLACK;
/*  54 */     this.fourthColor = Color.BLACK;
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
/* 181 */     this.timer = new MSTimer(); } @NotNull public final IntegerValue getR() { return this.r; } @NotNull public final IntegerValue getG() { return this.g; } @NotNull public final IntegerValue getB() { return this.b; } @NotNull public final MSTimer getTimer() { return this.timer; } @NotNull public final List<PotionEffect> getEffects() { return (List)this.effects; } public final void setEffects(@NotNull List<? extends PotionEffect> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.effects = <set-?>; } @NotNull public final HUD getHudMod() { return this.hudMod; } @NotNull public final Color getClientColor() { return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255); } @NotNull public final Color getAlternateClientColor() { return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 255); } public void shader() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: bipush #15
/*     */     //   3: iconst_0
/*     */     //   4: aload_0
/*     */     //   5: invokevirtual getClientColor : ()Ljava/awt/Color;
/*     */     //   8: aload_0
/*     */     //   9: invokevirtual getAlternateClientColor : ()Ljava/awt/Color;
/*     */     //   12: aload_0
/*     */     //   13: getfield hudMod : Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;
/*     */     //   16: invokevirtual getHueInterpolation : ()Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   19: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   22: checkcast java/lang/Boolean
/*     */     //   25: invokevirtual booleanValue : ()Z
/*     */     //   28: invokestatic interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   31: putfield firstColor : Ljava/awt/Color;
/*     */     //   34: aload_0
/*     */     //   35: bipush #15
/*     */     //   37: bipush #90
/*     */     //   39: aload_0
/*     */     //   40: invokevirtual getClientColor : ()Ljava/awt/Color;
/*     */     //   43: aload_0
/*     */     //   44: invokevirtual getAlternateClientColor : ()Ljava/awt/Color;
/*     */     //   47: aload_0
/*     */     //   48: getfield hudMod : Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;
/*     */     //   51: invokevirtual getHueInterpolation : ()Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   54: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   57: checkcast java/lang/Boolean
/*     */     //   60: invokevirtual booleanValue : ()Z
/*     */     //   63: invokestatic interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   66: putfield secondColor : Ljava/awt/Color;
/*     */     //   69: aload_0
/*     */     //   70: bipush #15
/*     */     //   72: sipush #180
/*     */     //   75: aload_0
/*     */     //   76: invokevirtual getClientColor : ()Ljava/awt/Color;
/*     */     //   79: aload_0
/*     */     //   80: invokevirtual getAlternateClientColor : ()Ljava/awt/Color;
/*     */     //   83: aload_0
/*     */     //   84: getfield hudMod : Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;
/*     */     //   87: invokevirtual getHueInterpolation : ()Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   90: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   93: checkcast java/lang/Boolean
/*     */     //   96: invokevirtual booleanValue : ()Z
/*     */     //   99: invokestatic interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   102: putfield thirdColor : Ljava/awt/Color;
/*     */     //   105: aload_0
/*     */     //   106: bipush #15
/*     */     //   108: sipush #270
/*     */     //   111: aload_0
/*     */     //   112: invokevirtual getClientColor : ()Ljava/awt/Color;
/*     */     //   115: aload_0
/*     */     //   116: invokevirtual getAlternateClientColor : ()Ljava/awt/Color;
/*     */     //   119: aload_0
/*     */     //   120: getfield hudMod : Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;
/*     */     //   123: invokevirtual getHueInterpolation : ()Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   126: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   129: checkcast java/lang/Boolean
/*     */     //   132: invokevirtual booleanValue : ()Z
/*     */     //   135: invokestatic interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   138: putfield fourthColor : Ljava/awt/Color;
/*     */     //   141: aload_0
/*     */     //   142: getfield modes : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   145: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   148: checkcast java/lang/String
/*     */     //   151: astore_1
/*     */     //   152: iconst_0
/*     */     //   153: istore_2
/*     */     //   154: aload_1
/*     */     //   155: dup
/*     */     //   156: ifnonnull -> 169
/*     */     //   159: new kotlin/TypeCastException
/*     */     //   162: dup
/*     */     //   163: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   165: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   168: athrow
/*     */     //   169: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   172: dup
/*     */     //   173: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   175: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   178: astore_1
/*     */     //   179: aload_1
/*     */     //   180: invokevirtual hashCode : ()I
/*     */     //   183: lookupswitch default -> 1518, -1454523186 -> 240, -1106245566 -> 228, 108960 -> 216
/*     */     //   216: aload_1
/*     */     //   217: ldc 'new'
/*     */     //   219: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   222: ifeq -> 1518
/*     */     //   225: goto -> 252
/*     */     //   228: aload_1
/*     */     //   229: ldc 'outline'
/*     */     //   231: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   234: ifeq -> 1518
/*     */     //   237: goto -> 1407
/*     */     //   240: aload_1
/*     */     //   241: ldc 'newnovoline'
/*     */     //   243: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   246: ifeq -> 1518
/*     */     //   249: goto -> 338
/*     */     //   252: aload_0
/*     */     //   253: getfield easinghealth : F
/*     */     //   256: ldc 13.0
/*     */     //   258: fsub
/*     */     //   259: fstore_2
/*     */     //   260: ldc 8.0
/*     */     //   262: fstore_3
/*     */     //   263: fload_2
/*     */     //   264: ldc 3.0
/*     */     //   266: fcmpg
/*     */     //   267: ifgt -> 273
/*     */     //   270: ldc -10.0
/*     */     //   272: fstore_2
/*     */     //   273: fload_2
/*     */     //   274: ldc 3.0
/*     */     //   276: fcmpg
/*     */     //   277: ifgt -> 283
/*     */     //   280: ldc -1.0
/*     */     //   282: fstore_3
/*     */     //   283: ldc 12.0
/*     */     //   285: fload_3
/*     */     //   286: ldc 99.5
/*     */     //   288: fload_2
/*     */     //   289: ldc 5.0
/*     */     //   291: new java/awt/Color
/*     */     //   294: dup
/*     */     //   295: iconst_0
/*     */     //   296: iconst_0
/*     */     //   297: iconst_0
/*     */     //   298: invokespecial <init> : (III)V
/*     */     //   301: invokevirtual getRGB : ()I
/*     */     //   304: invokestatic drawRoundedRectfix : (FFFFFI)V
/*     */     //   307: ldc 12.0
/*     */     //   309: ldc_w -13.0
/*     */     //   312: ldc 99.5
/*     */     //   314: ldc_w 16.0
/*     */     //   317: ldc 5.0
/*     */     //   319: new java/awt/Color
/*     */     //   322: dup
/*     */     //   323: iconst_0
/*     */     //   324: iconst_0
/*     */     //   325: iconst_0
/*     */     //   326: invokespecial <init> : (III)V
/*     */     //   329: invokevirtual getRGB : ()I
/*     */     //   332: invokestatic drawRoundedRectfix : (FFFFFI)V
/*     */     //   335: goto -> 1518
/*     */     //   338: iconst_0
/*     */     //   339: istore_2
/*     */     //   340: aload_0
/*     */     //   341: getfield effects : Ljava/util/List;
/*     */     //   344: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   349: astore #4
/*     */     //   351: aload #4
/*     */     //   353: invokeinterface hasNext : ()Z
/*     */     //   358: ifeq -> 1518
/*     */     //   361: aload #4
/*     */     //   363: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   368: checkcast net/minecraft/potion/PotionEffect
/*     */     //   371: astore_3
/*     */     //   372: aload_3
/*     */     //   373: invokevirtual func_188419_a : ()Lnet/minecraft/potion/Potion;
/*     */     //   376: invokestatic func_188409_a : (Lnet/minecraft/potion/Potion;)I
/*     */     //   379: invokestatic func_188412_a : (I)Lnet/minecraft/potion/Potion;
/*     */     //   382: astore #5
/*     */     //   384: aload #5
/*     */     //   386: dup
/*     */     //   387: ifnonnull -> 393
/*     */     //   390: invokestatic throwNpe : ()V
/*     */     //   393: invokevirtual func_76393_a : ()Ljava/lang/String;
/*     */     //   396: iconst_0
/*     */     //   397: anewarray java/lang/Object
/*     */     //   400: invokestatic func_135052_a : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   403: astore #6
/*     */     //   405: aconst_null
/*     */     //   406: astore #7
/*     */     //   408: aload_0
/*     */     //   409: getfield potionMap2 : Ljava/util/Map;
/*     */     //   412: aload #5
/*     */     //   414: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   419: ifeq -> 472
/*     */     //   422: aload_0
/*     */     //   423: getfield potionMap2 : Ljava/util/Map;
/*     */     //   426: aload #5
/*     */     //   428: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   433: dup
/*     */     //   434: ifnonnull -> 440
/*     */     //   437: invokestatic throwNpe : ()V
/*     */     //   440: checkcast net/ccbluex/liquidbounce/utils/render/PotionData
/*     */     //   443: getfield level : I
/*     */     //   446: aload_3
/*     */     //   447: invokevirtual func_76458_c : ()I
/*     */     //   450: if_icmpne -> 472
/*     */     //   453: aload_0
/*     */     //   454: getfield potionMap2 : Ljava/util/Map;
/*     */     //   457: aload #5
/*     */     //   459: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   464: checkcast net/ccbluex/liquidbounce/utils/render/PotionData
/*     */     //   467: astore #7
/*     */     //   469: goto -> 544
/*     */     //   472: aload_0
/*     */     //   473: getfield potionMap2 : Ljava/util/Map;
/*     */     //   476: aload #5
/*     */     //   478: new net/ccbluex/liquidbounce/utils/render/PotionData
/*     */     //   481: dup
/*     */     //   482: aload #5
/*     */     //   484: new net/ccbluex/liquidbounce/utils/Translate
/*     */     //   487: dup
/*     */     //   488: fconst_0
/*     */     //   489: ldc_w -40.0
/*     */     //   492: iload_2
/*     */     //   493: i2f
/*     */     //   494: fadd
/*     */     //   495: invokespecial <init> : (FF)V
/*     */     //   498: aload_3
/*     */     //   499: invokevirtual func_76458_c : ()I
/*     */     //   502: invokespecial <init> : (Lnet/minecraft/potion/Potion;Lnet/ccbluex/liquidbounce/utils/Translate;I)V
/*     */     //   505: astore #8
/*     */     //   507: astore #19
/*     */     //   509: astore #18
/*     */     //   511: iconst_0
/*     */     //   512: istore #9
/*     */     //   514: iconst_0
/*     */     //   515: istore #10
/*     */     //   517: aload #8
/*     */     //   519: astore #11
/*     */     //   521: iconst_0
/*     */     //   522: istore #12
/*     */     //   524: aload #11
/*     */     //   526: astore #7
/*     */     //   528: aload #8
/*     */     //   530: astore #20
/*     */     //   532: aload #18
/*     */     //   534: aload #19
/*     */     //   536: aload #20
/*     */     //   538: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   543: pop
/*     */     //   544: iconst_1
/*     */     //   545: istore #8
/*     */     //   547: aload_0
/*     */     //   548: getfield effects : Ljava/util/List;
/*     */     //   551: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   556: astore #10
/*     */     //   558: aload #10
/*     */     //   560: invokeinterface hasNext : ()Z
/*     */     //   565: ifeq -> 609
/*     */     //   568: aload #10
/*     */     //   570: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   575: checkcast net/minecraft/potion/PotionEffect
/*     */     //   578: astore #9
/*     */     //   580: aload #9
/*     */     //   582: invokevirtual func_76458_c : ()I
/*     */     //   585: aload #7
/*     */     //   587: dup
/*     */     //   588: ifnonnull -> 594
/*     */     //   591: invokestatic throwNpe : ()V
/*     */     //   594: getfield level : I
/*     */     //   597: if_icmpne -> 606
/*     */     //   600: iconst_0
/*     */     //   601: istore #8
/*     */     //   603: goto -> 609
/*     */     //   606: goto -> 558
/*     */     //   609: iload #8
/*     */     //   611: ifeq -> 626
/*     */     //   614: aload_0
/*     */     //   615: getfield potionMap2 : Ljava/util/Map;
/*     */     //   618: aload #5
/*     */     //   620: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   625: pop
/*     */     //   626: iconst_0
/*     */     //   627: istore #9
/*     */     //   629: iconst_0
/*     */     //   630: istore #10
/*     */     //   632: nop
/*     */     //   633: aload_3
/*     */     //   634: fconst_1
/*     */     //   635: invokestatic func_188410_a : (Lnet/minecraft/potion/PotionEffect;F)Ljava/lang/String;
/*     */     //   638: dup
/*     */     //   639: ldc_w 'Potion.getPotionDurationString(potionEffect, 1.0f)'
/*     */     //   642: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   645: checkcast java/lang/CharSequence
/*     */     //   648: astore #11
/*     */     //   650: ldc_w ':'
/*     */     //   653: astore #12
/*     */     //   655: iconst_0
/*     */     //   656: istore #13
/*     */     //   658: new kotlin/text/Regex
/*     */     //   661: dup
/*     */     //   662: aload #12
/*     */     //   664: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   667: astore #12
/*     */     //   669: iconst_0
/*     */     //   670: istore #13
/*     */     //   672: iconst_0
/*     */     //   673: istore #14
/*     */     //   675: aload #12
/*     */     //   677: aload #11
/*     */     //   679: iload #13
/*     */     //   681: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   684: astore #11
/*     */     //   686: iconst_0
/*     */     //   687: istore #12
/*     */     //   689: aload #11
/*     */     //   691: invokeinterface isEmpty : ()Z
/*     */     //   696: ifne -> 791
/*     */     //   699: aload #11
/*     */     //   701: aload #11
/*     */     //   703: invokeinterface size : ()I
/*     */     //   708: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   713: astore #13
/*     */     //   715: aload #13
/*     */     //   717: invokeinterface hasPrevious : ()Z
/*     */     //   722: ifeq -> 791
/*     */     //   725: aload #13
/*     */     //   727: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   732: checkcast java/lang/String
/*     */     //   735: astore #14
/*     */     //   737: iconst_0
/*     */     //   738: istore #15
/*     */     //   740: aload #14
/*     */     //   742: checkcast java/lang/CharSequence
/*     */     //   745: astore #16
/*     */     //   747: iconst_0
/*     */     //   748: istore #17
/*     */     //   750: aload #16
/*     */     //   752: invokeinterface length : ()I
/*     */     //   757: ifne -> 764
/*     */     //   760: iconst_1
/*     */     //   761: goto -> 765
/*     */     //   764: iconst_0
/*     */     //   765: ifne -> 788
/*     */     //   768: aload #11
/*     */     //   770: checkcast java/lang/Iterable
/*     */     //   773: aload #13
/*     */     //   775: invokeinterface nextIndex : ()I
/*     */     //   780: iconst_1
/*     */     //   781: iadd
/*     */     //   782: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   785: goto -> 794
/*     */     //   788: goto -> 715
/*     */     //   791: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   794: checkcast java/util/Collection
/*     */     //   797: astore #11
/*     */     //   799: iconst_0
/*     */     //   800: istore #12
/*     */     //   802: aload #11
/*     */     //   804: astore #13
/*     */     //   806: aload #13
/*     */     //   808: iconst_0
/*     */     //   809: anewarray java/lang/String
/*     */     //   812: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   817: dup
/*     */     //   818: ifnonnull -> 832
/*     */     //   821: new kotlin/TypeCastException
/*     */     //   824: dup
/*     */     //   825: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   828: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   831: athrow
/*     */     //   832: checkcast [Ljava/lang/String;
/*     */     //   835: iconst_0
/*     */     //   836: aaload
/*     */     //   837: astore #11
/*     */     //   839: iconst_0
/*     */     //   840: istore #12
/*     */     //   842: aload #11
/*     */     //   844: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   847: istore #9
/*     */     //   849: aload_3
/*     */     //   850: fconst_1
/*     */     //   851: invokestatic func_188410_a : (Lnet/minecraft/potion/PotionEffect;F)Ljava/lang/String;
/*     */     //   854: dup
/*     */     //   855: ldc_w 'Potion.getPotionDurationString(potionEffect, 1.0f)'
/*     */     //   858: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   861: checkcast java/lang/CharSequence
/*     */     //   864: astore #11
/*     */     //   866: ldc_w ':'
/*     */     //   869: astore #12
/*     */     //   871: iconst_0
/*     */     //   872: istore #13
/*     */     //   874: new kotlin/text/Regex
/*     */     //   877: dup
/*     */     //   878: aload #12
/*     */     //   880: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   883: astore #12
/*     */     //   885: iconst_0
/*     */     //   886: istore #13
/*     */     //   888: iconst_0
/*     */     //   889: istore #14
/*     */     //   891: aload #12
/*     */     //   893: aload #11
/*     */     //   895: iload #13
/*     */     //   897: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   900: astore #11
/*     */     //   902: iconst_0
/*     */     //   903: istore #12
/*     */     //   905: aload #11
/*     */     //   907: invokeinterface isEmpty : ()Z
/*     */     //   912: ifne -> 1007
/*     */     //   915: aload #11
/*     */     //   917: aload #11
/*     */     //   919: invokeinterface size : ()I
/*     */     //   924: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   929: astore #13
/*     */     //   931: aload #13
/*     */     //   933: invokeinterface hasPrevious : ()Z
/*     */     //   938: ifeq -> 1007
/*     */     //   941: aload #13
/*     */     //   943: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   948: checkcast java/lang/String
/*     */     //   951: astore #14
/*     */     //   953: iconst_0
/*     */     //   954: istore #15
/*     */     //   956: aload #14
/*     */     //   958: checkcast java/lang/CharSequence
/*     */     //   961: astore #16
/*     */     //   963: iconst_0
/*     */     //   964: istore #17
/*     */     //   966: aload #16
/*     */     //   968: invokeinterface length : ()I
/*     */     //   973: ifne -> 980
/*     */     //   976: iconst_1
/*     */     //   977: goto -> 981
/*     */     //   980: iconst_0
/*     */     //   981: ifne -> 1004
/*     */     //   984: aload #11
/*     */     //   986: checkcast java/lang/Iterable
/*     */     //   989: aload #13
/*     */     //   991: invokeinterface nextIndex : ()I
/*     */     //   996: iconst_1
/*     */     //   997: iadd
/*     */     //   998: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   1001: goto -> 1010
/*     */     //   1004: goto -> 931
/*     */     //   1007: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   1010: checkcast java/util/Collection
/*     */     //   1013: astore #11
/*     */     //   1015: iconst_0
/*     */     //   1016: istore #12
/*     */     //   1018: aload #11
/*     */     //   1020: astore #13
/*     */     //   1022: aload #13
/*     */     //   1024: iconst_0
/*     */     //   1025: anewarray java/lang/String
/*     */     //   1028: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   1033: dup
/*     */     //   1034: ifnonnull -> 1048
/*     */     //   1037: new kotlin/TypeCastException
/*     */     //   1040: dup
/*     */     //   1041: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   1044: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1047: athrow
/*     */     //   1048: checkcast [Ljava/lang/String;
/*     */     //   1051: iconst_1
/*     */     //   1052: aaload
/*     */     //   1053: astore #11
/*     */     //   1055: iconst_0
/*     */     //   1056: istore #12
/*     */     //   1058: aload #11
/*     */     //   1060: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   1063: istore #10
/*     */     //   1065: goto -> 1079
/*     */     //   1068: astore #11
/*     */     //   1070: bipush #100
/*     */     //   1072: istore #9
/*     */     //   1074: sipush #1000
/*     */     //   1077: istore #10
/*     */     //   1079: iload #9
/*     */     //   1081: bipush #60
/*     */     //   1083: imul
/*     */     //   1084: iload #10
/*     */     //   1086: iadd
/*     */     //   1087: istore #11
/*     */     //   1089: aload #7
/*     */     //   1091: dup
/*     */     //   1092: ifnonnull -> 1098
/*     */     //   1095: invokestatic throwNpe : ()V
/*     */     //   1098: invokevirtual getMaxTimer : ()I
/*     */     //   1101: ifeq -> 1117
/*     */     //   1104: iload #11
/*     */     //   1106: i2d
/*     */     //   1107: aload #7
/*     */     //   1109: invokevirtual getMaxTimer : ()I
/*     */     //   1112: i2d
/*     */     //   1113: dcmpl
/*     */     //   1114: ifle -> 1124
/*     */     //   1117: aload #7
/*     */     //   1119: iload #11
/*     */     //   1121: putfield maxTimer : I
/*     */     //   1124: fconst_0
/*     */     //   1125: fstore #12
/*     */     //   1127: iload #11
/*     */     //   1129: i2d
/*     */     //   1130: dconst_0
/*     */     //   1131: dcmpl
/*     */     //   1132: iflt -> 1153
/*     */     //   1135: iload #11
/*     */     //   1137: i2d
/*     */     //   1138: aload #7
/*     */     //   1140: invokevirtual getMaxTimer : ()I
/*     */     //   1143: i2f
/*     */     //   1144: f2d
/*     */     //   1145: ddiv
/*     */     //   1146: ldc2_w 100.0
/*     */     //   1149: dmul
/*     */     //   1150: d2f
/*     */     //   1151: fstore #12
/*     */     //   1153: aload #7
/*     */     //   1155: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1158: dup
/*     */     //   1159: ldc_w 'potionData.translate'
/*     */     //   1162: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1165: invokevirtual getY : ()F
/*     */     //   1168: iconst_5
/*     */     //   1169: i2f
/*     */     //   1170: fadd
/*     */     //   1171: invokestatic round : (F)I
/*     */     //   1174: istore #13
/*     */     //   1176: fload #12
/*     */     //   1178: fconst_2
/*     */     //   1179: invokestatic coerceAtLeast : (FF)F
/*     */     //   1182: fstore #12
/*     */     //   1184: aload #7
/*     */     //   1186: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1189: fconst_0
/*     */     //   1190: iload_2
/*     */     //   1191: i2f
/*     */     //   1192: ldc2_w 0.1
/*     */     //   1195: invokevirtual interpolate : (FFD)V
/*     */     //   1198: aload #7
/*     */     //   1200: aload_0
/*     */     //   1201: aload #7
/*     */     //   1203: invokevirtual getAnimationX : ()F
/*     */     //   1206: f2d
/*     */     //   1207: ldc_w 1.2
/*     */     //   1210: fload #12
/*     */     //   1212: fmul
/*     */     //   1213: f2d
/*     */     //   1214: ldc_w 10.0
/*     */     //   1217: aload #7
/*     */     //   1219: getfield animationX : F
/*     */     //   1222: ldc_w 1.2
/*     */     //   1225: fload #12
/*     */     //   1227: fmul
/*     */     //   1228: fsub
/*     */     //   1229: invokestatic abs : (F)F
/*     */     //   1232: ldc_w 15.0
/*     */     //   1235: fmul
/*     */     //   1236: invokestatic max : (FF)F
/*     */     //   1239: ldc_w 0.3
/*     */     //   1242: fmul
/*     */     //   1243: f2d
/*     */     //   1244: invokespecial getAnimationState : (DDD)D
/*     */     //   1247: d2f
/*     */     //   1248: putfield animationX : F
/*     */     //   1251: fconst_0
/*     */     //   1252: aload #7
/*     */     //   1254: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1257: dup
/*     */     //   1258: ldc_w 'potionData.translate'
/*     */     //   1261: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1264: invokevirtual getY : ()F
/*     */     //   1267: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1270: new java/lang/StringBuilder
/*     */     //   1273: dup
/*     */     //   1274: invokespecial <init> : ()V
/*     */     //   1277: aload #6
/*     */     //   1279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1282: ldc_w ' '
/*     */     //   1285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1288: aload_0
/*     */     //   1289: aload_3
/*     */     //   1290: invokevirtual func_76458_c : ()I
/*     */     //   1293: iconst_1
/*     */     //   1294: iadd
/*     */     //   1295: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1301: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1304: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1309: bipush #25
/*     */     //   1311: iadd
/*     */     //   1312: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1315: new java/lang/StringBuilder
/*     */     //   1318: dup
/*     */     //   1319: invokespecial <init> : ()V
/*     */     //   1322: aload #6
/*     */     //   1324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1327: ldc_w ' '
/*     */     //   1330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1333: aload_0
/*     */     //   1334: aload_3
/*     */     //   1335: invokevirtual func_76458_c : ()I
/*     */     //   1338: iconst_1
/*     */     //   1339: iadd
/*     */     //   1340: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1346: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1349: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1354: bipush #25
/*     */     //   1356: iadd
/*     */     //   1357: bipush #10
/*     */     //   1359: iadd
/*     */     //   1360: invokestatic max : (II)I
/*     */     //   1363: i2f
/*     */     //   1364: ldc_w 30.0
/*     */     //   1367: aload_0
/*     */     //   1368: getfield ridius : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1371: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1374: checkcast java/lang/Number
/*     */     //   1377: invokevirtual floatValue : ()F
/*     */     //   1380: new java/awt/Color
/*     */     //   1383: dup
/*     */     //   1384: iconst_0
/*     */     //   1385: iconst_0
/*     */     //   1386: iconst_0
/*     */     //   1387: invokespecial <init> : (III)V
/*     */     //   1390: invokevirtual getRGB : ()I
/*     */     //   1393: invokestatic drawRoundedRect3 : (FFFFFI)V
/*     */     //   1396: invokestatic func_179084_k : ()V
/*     */     //   1399: iload_2
/*     */     //   1400: bipush #35
/*     */     //   1402: isub
/*     */     //   1403: istore_2
/*     */     //   1404: goto -> 351
/*     */     //   1407: aload_0
/*     */     //   1408: getfield easinghealth : F
/*     */     //   1411: ldc 13.0
/*     */     //   1413: fsub
/*     */     //   1414: fstore_2
/*     */     //   1415: ldc 8.0
/*     */     //   1417: fstore_3
/*     */     //   1418: fload_2
/*     */     //   1419: ldc 3.0
/*     */     //   1421: fcmpg
/*     */     //   1422: ifle -> 1518
/*     */     //   1425: getstatic net/ccbluex/liquidbounce/features/module/modules/render/BlurSettings.EffectsGlow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1428: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1431: checkcast java/lang/Boolean
/*     */     //   1434: invokevirtual booleanValue : ()Z
/*     */     //   1437: ifeq -> 1484
/*     */     //   1440: ldc_w 14.2
/*     */     //   1443: fload_3
/*     */     //   1444: ldc_w 1.8
/*     */     //   1447: fadd
/*     */     //   1448: ldc_w 98.4
/*     */     //   1451: fload_2
/*     */     //   1452: ldc_w 0.4
/*     */     //   1455: fsub
/*     */     //   1456: ldc 5.0
/*     */     //   1458: aload_0
/*     */     //   1459: getfield fourthColor : Ljava/awt/Color;
/*     */     //   1462: fconst_1
/*     */     //   1463: invokestatic applyOpacity : (Ljava/awt/Color;F)Ljava/awt/Color;
/*     */     //   1466: aload_0
/*     */     //   1467: getfield firstColor : Ljava/awt/Color;
/*     */     //   1470: aload_0
/*     */     //   1471: getfield secondColor : Ljava/awt/Color;
/*     */     //   1474: aload_0
/*     */     //   1475: getfield thirdColor : Ljava/awt/Color;
/*     */     //   1478: invokestatic drawGradientRound : (FFFFFLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;)V
/*     */     //   1481: goto -> 1515
/*     */     //   1484: ldc_w 14.2
/*     */     //   1487: fload_3
/*     */     //   1488: ldc_w 1.8
/*     */     //   1491: fadd
/*     */     //   1492: ldc_w 98.4
/*     */     //   1495: fload_2
/*     */     //   1496: ldc_w 0.4
/*     */     //   1499: fsub
/*     */     //   1500: ldc 5.0
/*     */     //   1502: new java/awt/Color
/*     */     //   1505: dup
/*     */     //   1506: iconst_0
/*     */     //   1507: iconst_0
/*     */     //   1508: iconst_0
/*     */     //   1509: invokespecial <init> : (III)V
/*     */     //   1512: invokestatic drawRound : (FFFFFLjava/awt/Color;)V
/*     */     //   1515: invokestatic func_179117_G : ()V
/*     */     //   1518: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #64	-> 0
/*     */     //   #65	-> 12
/*     */     //   #64	-> 28
/*     */     //   #66	-> 34
/*     */     //   #67	-> 47
/*     */     //   #66	-> 63
/*     */     //   #68	-> 69
/*     */     //   #69	-> 83
/*     */     //   #68	-> 99
/*     */     //   #70	-> 105
/*     */     //   #71	-> 119
/*     */     //   #70	-> 135
/*     */     //   #72	-> 141
/*     */     //   #73	-> 216
/*     */     //   #142	-> 228
/*     */     //   #86	-> 240
/*     */     //   #74	-> 252
/*     */     //   #75	-> 260
/*     */     //   #76	-> 263
/*     */     //   #77	-> 270
/*     */     //   #79	-> 273
/*     */     //   #80	-> 280
/*     */     //   #82	-> 283
/*     */     //   #83	-> 307
/*     */     //   #87	-> 338
/*     */     //   #88	-> 340
/*     */     //   #89	-> 372
/*     */     //   #90	-> 384
/*     */     //   #91	-> 405
/*     */     //   #92	-> 408
/*     */     //   #93	-> 453
/*     */     //   #94	-> 472
/*     */     //   #98	-> 472
/*     */     //   #93	-> 472
/*     */     //   #94	-> 478
/*     */     //   #95	-> 482
/*     */     //   #96	-> 484
/*     */     //   #97	-> 498
/*     */     //   #94	-> 502
/*     */     //   #98	-> 507
/*     */     //   #98	-> 524
/*     */     //   #98	-> 528
/*     */     //   #93	-> 538
/*     */     //   #98	-> 544
/*     */     //   #99	-> 544
/*     */     //   #100	-> 547
/*     */     //   #101	-> 600
/*     */     //   #102	-> 603
/*     */     //   #100	-> 606
/*     */     //   #104	-> 609
/*     */     //   #105	-> 626
/*     */     //   #106	-> 629
/*     */     //   #107	-> 632
/*     */     //   #108	-> 633
/*     */     //   #110	-> 633
/*     */     //   #108	-> 633
/*     */     //   #110	-> 633
/*     */     //   #108	-> 633
/*     */     //   #109	-> 633
/*     */     //   #108	-> 633
/*     */     //   #108	-> 669
/*     */     //   #109	-> 686
/*     */     //   #544	-> 689
/*     */     //   #545	-> 699
/*     */     //   #546	-> 715
/*     */     //   #547	-> 725
/*     */     //   #109	-> 740
/*     */     //   #109	-> 765
/*     */     //   #548	-> 768
/*     */     //   #546	-> 788
/*     */     //   #552	-> 791
/*     */     //   #110	-> 799
/*     */     //   #553	-> 802
/*     */     //   #554	-> 806
/*     */     //   #110	-> 839
/*     */     //   #111	-> 849
/*     */     //   #113	-> 849
/*     */     //   #111	-> 849
/*     */     //   #113	-> 849
/*     */     //   #111	-> 849
/*     */     //   #112	-> 849
/*     */     //   #111	-> 849
/*     */     //   #111	-> 885
/*     */     //   #112	-> 902
/*     */     //   #555	-> 905
/*     */     //   #556	-> 915
/*     */     //   #557	-> 931
/*     */     //   #558	-> 941
/*     */     //   #112	-> 956
/*     */     //   #112	-> 981
/*     */     //   #559	-> 984
/*     */     //   #557	-> 1004
/*     */     //   #563	-> 1007
/*     */     //   #113	-> 1015
/*     */     //   #564	-> 1018
/*     */     //   #565	-> 1022
/*     */     //   #113	-> 1055
/*     */     //   #114	-> 1068
/*     */     //   #115	-> 1070
/*     */     //   #116	-> 1074
/*     */     //   #117	-> 1079
/*     */     //   #118	-> 1079
/*     */     //   #119	-> 1089
/*     */     //   #120	-> 1117
/*     */     //   #121	-> 1124
/*     */     //   #122	-> 1127
/*     */     //   #123	-> 1153
/*     */     //   #124	-> 1176
/*     */     //   #125	-> 1184
/*     */     //   #126	-> 1198
/*     */     //   #132	-> 1198
/*     */     //   #126	-> 1200
/*     */     //   #127	-> 1201
/*     */     //   #131	-> 1214
/*     */     //   #127	-> 1214
/*     */     //   #128	-> 1214
/*     */     //   #129	-> 1217
/*     */     //   #128	-> 1229
/*     */     //   #130	-> 1232
/*     */     //   #127	-> 1236
/*     */     //   #131	-> 1239
/*     */     //   #126	-> 1244
/*     */     //   #132	-> 1247
/*     */     //   #133	-> 1251
/*     */     //   #134	-> 1267
/*     */     //   #135	-> 1267
/*     */     //   #134	-> 1267
/*     */     //   #135	-> 1312
/*     */     //   #134	-> 1360
/*     */     //   #135	-> 1363
/*     */     //   #136	-> 1367
/*     */     //   #133	-> 1393
/*     */     //   #138	-> 1396
/*     */     //   #139	-> 1399
/*     */     //   #88	-> 1404
/*     */     //   #143	-> 1407
/*     */     //   #144	-> 1415
/*     */     //   #145	-> 1418
/*     */     //   #148	-> 1425
/*     */     //   #149	-> 1440
/*     */     //   #150	-> 1440
/*     */     //   #151	-> 1458
/*     */     //   #149	-> 1478
/*     */     //   #154	-> 1484
/*     */     //   #155	-> 1502
/*     */     //   #154	-> 1512
/*     */     //   #156	-> 1515
/*     */     //   #158	-> 1515
/*     */     //   #162	-> 1518
/*     */     //   #163	-> 1518
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   263	72	3	Y	F
/*     */     //   260	75	2	H	F
/*     */     //   521	7	11	it	Lnet/ccbluex/liquidbounce/utils/render/PotionData;
/*     */     //   524	4	12	$i$a$-also-NewEffects2$shader$1	I
/*     */     //   580	26	9	checkEffect	Lnet/minecraft/potion/PotionEffect;
/*     */     //   737	28	14	it	Ljava/lang/String;
/*     */     //   740	25	15	$i$a$-dropLastWhile-NewEffects2$shader$2	I
/*     */     //   715	76	13	iterator$iv	Ljava/util/ListIterator;
/*     */     //   686	108	11	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   689	105	12	$i$f$dropLastWhile	I
/*     */     //   806	26	13	thisCollection$iv	Ljava/util/Collection;
/*     */     //   799	33	11	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   802	30	12	$i$f$toTypedArray	I
/*     */     //   953	28	14	it	Ljava/lang/String;
/*     */     //   956	25	15	$i$a$-dropLastWhile-NewEffects2$shader$3	I
/*     */     //   931	76	13	iterator$iv	Ljava/util/ListIterator;
/*     */     //   902	108	11	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   905	105	12	$i$f$dropLastWhile	I
/*     */     //   1022	26	13	thisCollection$iv	Ljava/util/Collection;
/*     */     //   1015	33	11	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   1018	30	12	$i$f$toTypedArray	I
/*     */     //   1070	9	11	ignored	Ljava/lang/Exception;
/*     */     //   1176	228	13	position	I
/*     */     //   1127	277	12	state	F
/*     */     //   1089	315	11	lifeTime	I
/*     */     //   632	772	10	potionMaxTime	I
/*     */     //   629	775	9	potionTime	I
/*     */     //   547	857	8	flag	Z
/*     */     //   408	996	7	potionData	Lnet/ccbluex/liquidbounce/utils/render/PotionData;
/*     */     //   405	999	6	name	Ljava/lang/String;
/*     */     //   384	1020	5	potion	Lnet/minecraft/potion/Potion;
/*     */     //   372	1032	3	potionEffect	Lnet/minecraft/potion/PotionEffect;
/*     */     //   340	1067	2	y	I
/*     */     //   1418	100	3	Y	F
/*     */     //   1415	103	2	H	F
/*     */     //   0	1519	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/* 181 */     //   632	1065	1068	java/lang/Exception } public void updateElement() { if ((String)this.modes.get() == "NewNovoline") { if (MinecraftInstance.mc2.field_71439_g == null) return;  Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_70651_bq().stream().sorted(Comparator.comparingInt(new NewEffects2$updateElement$1())).collect(Collectors.toCollection(NewEffects2$updateElement$2.INSTANCE)), "mc2.player.activePotionE…Effect>> { ArrayList() })"); this.effects = (List<? extends PotionEffect>)MinecraftInstance.mc2.field_71439_g.func_70651_bq().stream().sorted(Comparator.comparingInt(new NewEffects2$updateElement$1())).collect(Collectors.toCollection(NewEffects2$updateElement$2.INSTANCE)); }  } public final void setTimer(@NotNull MSTimer <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.timer = <set-?>; }
/* 182 */   public final float getEasingwith() { return this.easingwith; } public final void setEasingwith(float <set-?>) { this.easingwith = <set-?>; }
/* 183 */   public final float getBackamin() { return this.backamin; } public final void setBackamin(float <set-?>) { this.backamin = <set-?>; }
/* 184 */   public final float getEasinghealth() { return this.easinghealth; } public final void setEasinghealth(float <set-?>) { this.easinghealth = <set-?>; }
/* 185 */   public final float getHealthamin() { return this.healthamin; } public final void setHealthamin(float <set-?>) { this.healthamin = <set-?>; }
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
/*     */   @Nullable
/*     */   public Border drawElement() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield modes : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   7: checkcast java/lang/String
/*     */     //   10: astore_1
/*     */     //   11: iconst_0
/*     */     //   12: istore_2
/*     */     //   13: aload_1
/*     */     //   14: dup
/*     */     //   15: ifnonnull -> 28
/*     */     //   18: new kotlin/TypeCastException
/*     */     //   21: dup
/*     */     //   22: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   24: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   27: athrow
/*     */     //   28: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   31: dup
/*     */     //   32: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   34: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   37: astore_1
/*     */     //   38: aload_1
/*     */     //   39: invokevirtual hashCode : ()I
/*     */     //   42: lookupswitch default -> 431, -1106245566 -> 80, 108960 -> 68
/*     */     //   68: aload_1
/*     */     //   69: ldc 'new'
/*     */     //   71: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   74: ifeq -> 431
/*     */     //   77: goto -> 213
/*     */     //   80: aload_1
/*     */     //   81: ldc 'outline'
/*     */     //   83: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   86: ifeq -> 431
/*     */     //   89: aload_0
/*     */     //   90: getfield easinghealth : F
/*     */     //   93: ldc 13.0
/*     */     //   95: fsub
/*     */     //   96: fstore_2
/*     */     //   97: ldc 8.0
/*     */     //   99: fstore_3
/*     */     //   100: fload_2
/*     */     //   101: ldc 3.0
/*     */     //   103: fcmpg
/*     */     //   104: ifle -> 431
/*     */     //   107: ldc_w 14.2
/*     */     //   110: fload_3
/*     */     //   111: ldc_w 1.8
/*     */     //   114: fadd
/*     */     //   115: ldc_w 98.4
/*     */     //   118: fload_2
/*     */     //   119: ldc_w 0.4
/*     */     //   122: fsub
/*     */     //   123: ldc 5.0
/*     */     //   125: new java/awt/Color
/*     */     //   128: dup
/*     */     //   129: aload_0
/*     */     //   130: getfield r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   133: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   136: checkcast java/lang/Number
/*     */     //   139: invokevirtual intValue : ()I
/*     */     //   142: aload_0
/*     */     //   143: getfield g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   146: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   149: checkcast java/lang/Number
/*     */     //   152: invokevirtual intValue : ()I
/*     */     //   155: aload_0
/*     */     //   156: getfield b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   159: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   162: checkcast java/lang/Number
/*     */     //   165: invokevirtual intValue : ()I
/*     */     //   168: aload_0
/*     */     //   169: getfield alpha : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   172: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   175: checkcast java/lang/Number
/*     */     //   178: invokevirtual intValue : ()I
/*     */     //   181: invokespecial <init> : (IIII)V
/*     */     //   184: invokestatic drawRound : (FFFFFLjava/awt/Color;)V
/*     */     //   187: invokestatic func_179117_G : ()V
/*     */     //   190: ldc_w 19.0
/*     */     //   193: fload_3
/*     */     //   194: ldc_w 1.6
/*     */     //   197: fadd
/*     */     //   198: ldc_w 108.0
/*     */     //   201: fload_2
/*     */     //   202: ldc 5.0
/*     */     //   204: ldc_w 2.2
/*     */     //   207: invokestatic drawOutline : (FFFFFF)V
/*     */     //   210: goto -> 431
/*     */     //   213: aload_0
/*     */     //   214: getfield easinghealth : F
/*     */     //   217: ldc 13.0
/*     */     //   219: fsub
/*     */     //   220: fstore_2
/*     */     //   221: ldc 8.0
/*     */     //   223: fstore_3
/*     */     //   224: fload_2
/*     */     //   225: ldc 3.0
/*     */     //   227: fcmpg
/*     */     //   228: ifgt -> 234
/*     */     //   231: ldc -10.0
/*     */     //   233: fstore_2
/*     */     //   234: fload_2
/*     */     //   235: ldc 3.0
/*     */     //   237: fcmpg
/*     */     //   238: ifgt -> 244
/*     */     //   241: ldc -1.0
/*     */     //   243: fstore_3
/*     */     //   244: ldc 12.0
/*     */     //   246: fload_3
/*     */     //   247: ldc 99.5
/*     */     //   249: fload_2
/*     */     //   250: ldc 5.0
/*     */     //   252: new java/awt/Color
/*     */     //   255: dup
/*     */     //   256: aload_0
/*     */     //   257: getfield r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   260: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   263: checkcast java/lang/Number
/*     */     //   266: invokevirtual intValue : ()I
/*     */     //   269: aload_0
/*     */     //   270: getfield g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   273: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   276: checkcast java/lang/Number
/*     */     //   279: invokevirtual intValue : ()I
/*     */     //   282: aload_0
/*     */     //   283: getfield b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   286: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   289: checkcast java/lang/Number
/*     */     //   292: invokevirtual intValue : ()I
/*     */     //   295: aload_0
/*     */     //   296: getfield alpha : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   299: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   302: checkcast java/lang/Number
/*     */     //   305: invokevirtual intValue : ()I
/*     */     //   308: invokespecial <init> : (IIII)V
/*     */     //   311: invokevirtual getRGB : ()I
/*     */     //   314: invokestatic drawRoundedRectfix : (FFFFFI)V
/*     */     //   317: invokestatic func_179117_G : ()V
/*     */     //   320: ldc 12.0
/*     */     //   322: ldc_w -13.0
/*     */     //   325: ldc 99.5
/*     */     //   327: ldc_w 16.0
/*     */     //   330: ldc 5.0
/*     */     //   332: new java/awt/Color
/*     */     //   335: dup
/*     */     //   336: iconst_0
/*     */     //   337: bipush #20
/*     */     //   339: bipush #40
/*     */     //   341: sipush #225
/*     */     //   344: invokespecial <init> : (IIII)V
/*     */     //   347: invokevirtual getRGB : ()I
/*     */     //   350: invokestatic drawRoundedRectfix : (FFFFFI)V
/*     */     //   353: invokestatic func_179117_G : ()V
/*     */     //   356: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont17 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   359: ldc_w 'Effects'
/*     */     //   362: ldc_w 25.0
/*     */     //   365: ldc_w -7.5
/*     */     //   368: new java/awt/Color
/*     */     //   371: dup
/*     */     //   372: sipush #255
/*     */     //   375: sipush #255
/*     */     //   378: sipush #255
/*     */     //   381: invokespecial <init> : (III)V
/*     */     //   384: invokevirtual getRGB : ()I
/*     */     //   387: iconst_1
/*     */     //   388: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   393: pop
/*     */     //   394: getstatic net/ccbluex/liquidbounce/ui/font/UiFonts.Newuiicon820 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   397: ldc_w 'q'
/*     */     //   400: ldc_w 15.0
/*     */     //   403: ldc_w -7.5
/*     */     //   406: new java/awt/Color
/*     */     //   409: dup
/*     */     //   410: bipush #6
/*     */     //   412: sipush #180
/*     */     //   415: sipush #255
/*     */     //   418: invokespecial <init> : (III)V
/*     */     //   421: invokevirtual getRGB : ()I
/*     */     //   424: iconst_1
/*     */     //   425: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   430: pop
/*     */     //   431: invokestatic func_179094_E : ()V
/*     */     //   434: fconst_0
/*     */     //   435: fstore_1
/*     */     //   436: fconst_0
/*     */     //   437: fstore_2
/*     */     //   438: fconst_0
/*     */     //   439: fstore_3
/*     */     //   440: iconst_0
/*     */     //   441: istore #4
/*     */     //   443: aload_0
/*     */     //   444: getfield modes : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   447: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   450: checkcast java/lang/String
/*     */     //   453: astore #5
/*     */     //   455: iconst_0
/*     */     //   456: istore #6
/*     */     //   458: aload #5
/*     */     //   460: dup
/*     */     //   461: ifnonnull -> 474
/*     */     //   464: new kotlin/TypeCastException
/*     */     //   467: dup
/*     */     //   468: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   470: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   473: athrow
/*     */     //   474: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   477: dup
/*     */     //   478: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   480: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   483: astore #5
/*     */     //   485: aload #5
/*     */     //   487: invokevirtual hashCode : ()I
/*     */     //   490: lookupswitch default -> 4447, -1454523186 -> 550, -1106245566 -> 537, 108960 -> 524
/*     */     //   524: aload #5
/*     */     //   526: ldc 'new'
/*     */     //   528: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   531: ifeq -> 4447
/*     */     //   534: goto -> 1789
/*     */     //   537: aload #5
/*     */     //   539: ldc 'outline'
/*     */     //   541: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   544: ifeq -> 4447
/*     */     //   547: goto -> 563
/*     */     //   550: aload #5
/*     */     //   552: ldc 'newnovoline'
/*     */     //   554: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   557: ifeq -> 4447
/*     */     //   560: goto -> 3007
/*     */     //   563: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   566: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   571: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   574: dup
/*     */     //   575: ifnonnull -> 581
/*     */     //   578: invokestatic throwNpe : ()V
/*     */     //   581: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP
/*     */     //   584: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   589: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   594: astore #7
/*     */     //   596: aload #7
/*     */     //   598: invokeinterface hasNext : ()Z
/*     */     //   603: ifeq -> 4447
/*     */     //   606: aload #7
/*     */     //   608: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   613: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   616: astore #6
/*     */     //   618: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   621: aload #6
/*     */     //   623: invokeinterface getPotionID : ()I
/*     */     //   628: invokeinterface getPotionById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   633: astore #8
/*     */     //   635: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   638: aload #8
/*     */     //   640: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   645: iconst_0
/*     */     //   646: anewarray java/lang/String
/*     */     //   649: invokeinterface formatI18n : (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
/*     */     //   654: astore #9
/*     */     //   656: aconst_null
/*     */     //   657: astore #10
/*     */     //   659: aload_0
/*     */     //   660: getfield potionMap : Ljava/util/Map;
/*     */     //   663: aload #8
/*     */     //   665: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   670: ifeq -> 726
/*     */     //   673: aload_0
/*     */     //   674: getfield potionMap : Ljava/util/Map;
/*     */     //   677: aload #8
/*     */     //   679: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   684: dup
/*     */     //   685: ifnonnull -> 691
/*     */     //   688: invokestatic throwNpe : ()V
/*     */     //   691: checkcast net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   694: getfield level : I
/*     */     //   697: aload #6
/*     */     //   699: invokeinterface getAmplifier : ()I
/*     */     //   704: if_icmpne -> 726
/*     */     //   707: aload_0
/*     */     //   708: getfield potionMap : Ljava/util/Map;
/*     */     //   711: aload #8
/*     */     //   713: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   718: checkcast net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   721: astore #10
/*     */     //   723: goto -> 806
/*     */     //   726: aload_0
/*     */     //   727: getfield potionMap : Ljava/util/Map;
/*     */     //   730: aload #8
/*     */     //   732: new net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   735: dup
/*     */     //   736: aload #8
/*     */     //   738: new net/ccbluex/liquidbounce/utils/Translate
/*     */     //   741: dup
/*     */     //   742: fconst_0
/*     */     //   743: ldc_w -40.0
/*     */     //   746: iload #4
/*     */     //   748: i2f
/*     */     //   749: fadd
/*     */     //   750: invokespecial <init> : (FF)V
/*     */     //   753: aload #6
/*     */     //   755: invokeinterface getAmplifier : ()I
/*     */     //   760: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;Lnet/ccbluex/liquidbounce/utils/Translate;I)V
/*     */     //   763: astore #11
/*     */     //   765: astore #23
/*     */     //   767: astore #22
/*     */     //   769: iconst_0
/*     */     //   770: istore #12
/*     */     //   772: iconst_0
/*     */     //   773: istore #13
/*     */     //   775: aload #11
/*     */     //   777: astore #14
/*     */     //   779: iconst_0
/*     */     //   780: istore #15
/*     */     //   782: aload #14
/*     */     //   784: astore #10
/*     */     //   786: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
/*     */     //   789: pop
/*     */     //   790: aload #11
/*     */     //   792: astore #24
/*     */     //   794: aload #22
/*     */     //   796: aload #23
/*     */     //   798: aload #24
/*     */     //   800: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   805: pop
/*     */     //   806: iconst_1
/*     */     //   807: istore #11
/*     */     //   809: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   812: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   817: dup
/*     */     //   818: ifnonnull -> 824
/*     */     //   821: invokestatic throwNpe : ()V
/*     */     //   824: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   829: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   834: astore #13
/*     */     //   836: aload #13
/*     */     //   838: invokeinterface hasNext : ()Z
/*     */     //   843: ifeq -> 889
/*     */     //   846: aload #13
/*     */     //   848: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   853: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   856: astore #12
/*     */     //   858: aload #12
/*     */     //   860: invokeinterface getAmplifier : ()I
/*     */     //   865: aload #10
/*     */     //   867: dup
/*     */     //   868: ifnonnull -> 874
/*     */     //   871: invokestatic throwNpe : ()V
/*     */     //   874: getfield level : I
/*     */     //   877: if_icmpne -> 886
/*     */     //   880: iconst_0
/*     */     //   881: istore #11
/*     */     //   883: goto -> 889
/*     */     //   886: goto -> 836
/*     */     //   889: iload #11
/*     */     //   891: ifeq -> 906
/*     */     //   894: aload_0
/*     */     //   895: getfield potionMap : Ljava/util/Map;
/*     */     //   898: aload #8
/*     */     //   900: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   905: pop
/*     */     //   906: iconst_0
/*     */     //   907: istore #12
/*     */     //   909: iconst_0
/*     */     //   910: istore #13
/*     */     //   912: nop
/*     */     //   913: aload #6
/*     */     //   915: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   920: checkcast java/lang/CharSequence
/*     */     //   923: astore #14
/*     */     //   925: ldc_w ':'
/*     */     //   928: astore #15
/*     */     //   930: iconst_0
/*     */     //   931: istore #16
/*     */     //   933: new kotlin/text/Regex
/*     */     //   936: dup
/*     */     //   937: aload #15
/*     */     //   939: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   942: astore #15
/*     */     //   944: iconst_0
/*     */     //   945: istore #16
/*     */     //   947: iconst_0
/*     */     //   948: istore #17
/*     */     //   950: aload #15
/*     */     //   952: aload #14
/*     */     //   954: iload #16
/*     */     //   956: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   959: astore #14
/*     */     //   961: iconst_0
/*     */     //   962: istore #15
/*     */     //   964: aload #14
/*     */     //   966: invokeinterface isEmpty : ()Z
/*     */     //   971: ifne -> 1066
/*     */     //   974: aload #14
/*     */     //   976: aload #14
/*     */     //   978: invokeinterface size : ()I
/*     */     //   983: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   988: astore #16
/*     */     //   990: aload #16
/*     */     //   992: invokeinterface hasPrevious : ()Z
/*     */     //   997: ifeq -> 1066
/*     */     //   1000: aload #16
/*     */     //   1002: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   1007: checkcast java/lang/String
/*     */     //   1010: astore #17
/*     */     //   1012: iconst_0
/*     */     //   1013: istore #18
/*     */     //   1015: aload #17
/*     */     //   1017: checkcast java/lang/CharSequence
/*     */     //   1020: astore #19
/*     */     //   1022: iconst_0
/*     */     //   1023: istore #20
/*     */     //   1025: aload #19
/*     */     //   1027: invokeinterface length : ()I
/*     */     //   1032: ifne -> 1039
/*     */     //   1035: iconst_1
/*     */     //   1036: goto -> 1040
/*     */     //   1039: iconst_0
/*     */     //   1040: ifne -> 1063
/*     */     //   1043: aload #14
/*     */     //   1045: checkcast java/lang/Iterable
/*     */     //   1048: aload #16
/*     */     //   1050: invokeinterface nextIndex : ()I
/*     */     //   1055: iconst_1
/*     */     //   1056: iadd
/*     */     //   1057: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   1060: goto -> 1069
/*     */     //   1063: goto -> 990
/*     */     //   1066: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   1069: checkcast java/util/Collection
/*     */     //   1072: astore #14
/*     */     //   1074: iconst_0
/*     */     //   1075: istore #15
/*     */     //   1077: aload #14
/*     */     //   1079: astore #16
/*     */     //   1081: aload #16
/*     */     //   1083: iconst_0
/*     */     //   1084: anewarray java/lang/String
/*     */     //   1087: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   1092: dup
/*     */     //   1093: ifnonnull -> 1107
/*     */     //   1096: new kotlin/TypeCastException
/*     */     //   1099: dup
/*     */     //   1100: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   1103: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1106: athrow
/*     */     //   1107: checkcast [Ljava/lang/String;
/*     */     //   1110: iconst_0
/*     */     //   1111: aaload
/*     */     //   1112: astore #14
/*     */     //   1114: iconst_0
/*     */     //   1115: istore #15
/*     */     //   1117: aload #14
/*     */     //   1119: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   1122: istore #12
/*     */     //   1124: aload #6
/*     */     //   1126: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   1131: checkcast java/lang/CharSequence
/*     */     //   1134: astore #14
/*     */     //   1136: ldc_w ':'
/*     */     //   1139: astore #15
/*     */     //   1141: iconst_0
/*     */     //   1142: istore #16
/*     */     //   1144: new kotlin/text/Regex
/*     */     //   1147: dup
/*     */     //   1148: aload #15
/*     */     //   1150: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1153: astore #15
/*     */     //   1155: iconst_0
/*     */     //   1156: istore #16
/*     */     //   1158: iconst_0
/*     */     //   1159: istore #17
/*     */     //   1161: aload #15
/*     */     //   1163: aload #14
/*     */     //   1165: iload #16
/*     */     //   1167: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   1170: astore #14
/*     */     //   1172: iconst_0
/*     */     //   1173: istore #15
/*     */     //   1175: aload #14
/*     */     //   1177: invokeinterface isEmpty : ()Z
/*     */     //   1182: ifne -> 1277
/*     */     //   1185: aload #14
/*     */     //   1187: aload #14
/*     */     //   1189: invokeinterface size : ()I
/*     */     //   1194: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   1199: astore #16
/*     */     //   1201: aload #16
/*     */     //   1203: invokeinterface hasPrevious : ()Z
/*     */     //   1208: ifeq -> 1277
/*     */     //   1211: aload #16
/*     */     //   1213: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   1218: checkcast java/lang/String
/*     */     //   1221: astore #17
/*     */     //   1223: iconst_0
/*     */     //   1224: istore #18
/*     */     //   1226: aload #17
/*     */     //   1228: checkcast java/lang/CharSequence
/*     */     //   1231: astore #19
/*     */     //   1233: iconst_0
/*     */     //   1234: istore #20
/*     */     //   1236: aload #19
/*     */     //   1238: invokeinterface length : ()I
/*     */     //   1243: ifne -> 1250
/*     */     //   1246: iconst_1
/*     */     //   1247: goto -> 1251
/*     */     //   1250: iconst_0
/*     */     //   1251: ifne -> 1274
/*     */     //   1254: aload #14
/*     */     //   1256: checkcast java/lang/Iterable
/*     */     //   1259: aload #16
/*     */     //   1261: invokeinterface nextIndex : ()I
/*     */     //   1266: iconst_1
/*     */     //   1267: iadd
/*     */     //   1268: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   1271: goto -> 1280
/*     */     //   1274: goto -> 1201
/*     */     //   1277: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   1280: checkcast java/util/Collection
/*     */     //   1283: astore #14
/*     */     //   1285: iconst_0
/*     */     //   1286: istore #15
/*     */     //   1288: aload #14
/*     */     //   1290: astore #16
/*     */     //   1292: aload #16
/*     */     //   1294: iconst_0
/*     */     //   1295: anewarray java/lang/String
/*     */     //   1298: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   1303: dup
/*     */     //   1304: ifnonnull -> 1318
/*     */     //   1307: new kotlin/TypeCastException
/*     */     //   1310: dup
/*     */     //   1311: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   1314: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1317: athrow
/*     */     //   1318: checkcast [Ljava/lang/String;
/*     */     //   1321: iconst_1
/*     */     //   1322: aaload
/*     */     //   1323: astore #14
/*     */     //   1325: iconst_0
/*     */     //   1326: istore #15
/*     */     //   1328: aload #14
/*     */     //   1330: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   1333: istore #13
/*     */     //   1335: goto -> 1349
/*     */     //   1338: astore #14
/*     */     //   1340: bipush #100
/*     */     //   1342: istore #12
/*     */     //   1344: sipush #1000
/*     */     //   1347: istore #13
/*     */     //   1349: iload #12
/*     */     //   1351: bipush #60
/*     */     //   1353: imul
/*     */     //   1354: iload #13
/*     */     //   1356: iadd
/*     */     //   1357: istore #14
/*     */     //   1359: aload #10
/*     */     //   1361: dup
/*     */     //   1362: ifnonnull -> 1368
/*     */     //   1365: invokestatic throwNpe : ()V
/*     */     //   1368: invokevirtual getMaxTimer : ()I
/*     */     //   1371: ifeq -> 1387
/*     */     //   1374: iload #14
/*     */     //   1376: i2d
/*     */     //   1377: aload #10
/*     */     //   1379: invokevirtual getMaxTimer : ()I
/*     */     //   1382: i2d
/*     */     //   1383: dcmpl
/*     */     //   1384: ifle -> 1394
/*     */     //   1387: aload #10
/*     */     //   1389: iload #14
/*     */     //   1391: putfield maxTimer : I
/*     */     //   1394: fconst_0
/*     */     //   1395: fstore #15
/*     */     //   1397: iload #14
/*     */     //   1399: i2d
/*     */     //   1400: dconst_0
/*     */     //   1401: dcmpl
/*     */     //   1402: iflt -> 1423
/*     */     //   1405: iload #14
/*     */     //   1407: i2d
/*     */     //   1408: aload #10
/*     */     //   1410: invokevirtual getMaxTimer : ()I
/*     */     //   1413: i2f
/*     */     //   1414: f2d
/*     */     //   1415: ddiv
/*     */     //   1416: ldc2_w 100.0
/*     */     //   1419: dmul
/*     */     //   1420: d2f
/*     */     //   1421: fstore #15
/*     */     //   1423: aload #10
/*     */     //   1425: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1428: dup
/*     */     //   1429: ldc_w 'potionData.translate'
/*     */     //   1432: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1435: invokevirtual getY : ()F
/*     */     //   1438: ldc_w 1.4
/*     */     //   1441: fdiv
/*     */     //   1442: ldc_w 7.22
/*     */     //   1445: fsub
/*     */     //   1446: invokestatic round : (F)I
/*     */     //   1449: istore #16
/*     */     //   1451: fload #15
/*     */     //   1453: fconst_2
/*     */     //   1454: invokestatic max : (FF)F
/*     */     //   1457: fstore #15
/*     */     //   1459: aload #10
/*     */     //   1461: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1464: fconst_0
/*     */     //   1465: iload #4
/*     */     //   1467: i2f
/*     */     //   1468: ldc2_w 0.1
/*     */     //   1471: invokevirtual interpolate : (FFD)V
/*     */     //   1474: aload #10
/*     */     //   1476: aload #10
/*     */     //   1478: invokevirtual getAnimationX : ()F
/*     */     //   1481: f2d
/*     */     //   1482: ldc_w 1.2
/*     */     //   1485: fload #15
/*     */     //   1487: fmul
/*     */     //   1488: f2d
/*     */     //   1489: ldc_w 10.0
/*     */     //   1492: aload #10
/*     */     //   1494: getfield animationX : F
/*     */     //   1497: ldc_w 1.2
/*     */     //   1500: fload #15
/*     */     //   1502: fmul
/*     */     //   1503: fsub
/*     */     //   1504: invokestatic abs : (F)F
/*     */     //   1507: ldc_w 15.0
/*     */     //   1510: fmul
/*     */     //   1511: invokestatic max : (FF)F
/*     */     //   1514: ldc_w 0.3
/*     */     //   1517: fmul
/*     */     //   1518: f2d
/*     */     //   1519: invokestatic getAnimationState2 : (DDD)D
/*     */     //   1522: d2f
/*     */     //   1523: putfield animationX : F
/*     */     //   1526: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1529: new java/lang/StringBuilder
/*     */     //   1532: dup
/*     */     //   1533: invokespecial <init> : ()V
/*     */     //   1536: aload #9
/*     */     //   1538: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1541: ldc_w ' '
/*     */     //   1544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1547: aload_0
/*     */     //   1548: aload #6
/*     */     //   1550: invokeinterface getAmplifier : ()I
/*     */     //   1555: iconst_1
/*     */     //   1556: iadd
/*     */     //   1557: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1563: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1566: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1571: istore #17
/*     */     //   1573: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1576: new java/lang/StringBuilder
/*     */     //   1579: dup
/*     */     //   1580: invokespecial <init> : ()V
/*     */     //   1583: aload #9
/*     */     //   1585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1588: ldc_w ' '
/*     */     //   1591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1594: aload_0
/*     */     //   1595: aload #6
/*     */     //   1597: invokeinterface getAmplifier : ()I
/*     */     //   1602: iconst_1
/*     */     //   1603: iadd
/*     */     //   1604: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1610: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1613: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1618: i2f
/*     */     //   1619: fstore_1
/*     */     //   1620: iload #17
/*     */     //   1622: i2f
/*     */     //   1623: fload_2
/*     */     //   1624: fcmpl
/*     */     //   1625: ifle -> 1632
/*     */     //   1628: iload #17
/*     */     //   1630: i2f
/*     */     //   1631: fstore_2
/*     */     //   1632: aload #10
/*     */     //   1634: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1637: dup
/*     */     //   1638: ldc_w 'potionData.translate'
/*     */     //   1641: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1644: invokevirtual getY : ()F
/*     */     //   1647: ldc_w 2.5
/*     */     //   1650: fdiv
/*     */     //   1651: ldc 3.0
/*     */     //   1653: fsub
/*     */     //   1654: fstore #18
/*     */     //   1656: aload #10
/*     */     //   1658: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1661: dup
/*     */     //   1662: ldc_w 'potionData.translate'
/*     */     //   1665: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1668: invokevirtual getY : ()F
/*     */     //   1671: ldc_w 2.5
/*     */     //   1674: fdiv
/*     */     //   1675: ldc 8.0
/*     */     //   1677: fsub
/*     */     //   1678: fstore_3
/*     */     //   1679: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1682: new java/lang/StringBuilder
/*     */     //   1685: dup
/*     */     //   1686: invokespecial <init> : ()V
/*     */     //   1689: aload #9
/*     */     //   1691: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1694: ldc_w ' '
/*     */     //   1697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1700: aload_0
/*     */     //   1701: aload #6
/*     */     //   1703: invokeinterface getAmplifier : ()I
/*     */     //   1708: iconst_1
/*     */     //   1709: iadd
/*     */     //   1710: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1713: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1716: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1719: ldc_w 18.0
/*     */     //   1722: fload #18
/*     */     //   1724: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1727: invokeinterface getFontHeight : ()I
/*     */     //   1732: i2f
/*     */     //   1733: fsub
/*     */     //   1734: fneg
/*     */     //   1735: ldc_w 1.3
/*     */     //   1738: fadd
/*     */     //   1739: iconst_m1
/*     */     //   1740: iconst_1
/*     */     //   1741: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   1746: pop
/*     */     //   1747: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1750: aload #6
/*     */     //   1752: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   1757: ldc_w 93.0
/*     */     //   1760: fload #18
/*     */     //   1762: ldc_w 9.76
/*     */     //   1765: fsub
/*     */     //   1766: fneg
/*     */     //   1767: ldc_w 1.3
/*     */     //   1770: fadd
/*     */     //   1771: iconst_m1
/*     */     //   1772: iconst_1
/*     */     //   1773: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   1778: pop
/*     */     //   1779: iload #4
/*     */     //   1781: bipush #35
/*     */     //   1783: isub
/*     */     //   1784: istore #4
/*     */     //   1786: goto -> 596
/*     */     //   1789: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1792: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1797: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   1800: dup
/*     */     //   1801: ifnonnull -> 1807
/*     */     //   1804: invokestatic throwNpe : ()V
/*     */     //   1807: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP
/*     */     //   1810: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   1815: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1820: astore #7
/*     */     //   1822: aload #7
/*     */     //   1824: invokeinterface hasNext : ()Z
/*     */     //   1829: ifeq -> 4447
/*     */     //   1832: aload #7
/*     */     //   1834: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1839: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   1842: astore #6
/*     */     //   1844: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   1847: aload #6
/*     */     //   1849: invokeinterface getPotionID : ()I
/*     */     //   1854: invokeinterface getPotionById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   1859: astore #8
/*     */     //   1861: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   1864: aload #8
/*     */     //   1866: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1871: iconst_0
/*     */     //   1872: anewarray java/lang/String
/*     */     //   1875: invokeinterface formatI18n : (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
/*     */     //   1880: astore #9
/*     */     //   1882: aconst_null
/*     */     //   1883: astore #10
/*     */     //   1885: aload_0
/*     */     //   1886: getfield potionMap : Ljava/util/Map;
/*     */     //   1889: aload #8
/*     */     //   1891: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   1896: ifeq -> 1952
/*     */     //   1899: aload_0
/*     */     //   1900: getfield potionMap : Ljava/util/Map;
/*     */     //   1903: aload #8
/*     */     //   1905: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   1910: dup
/*     */     //   1911: ifnonnull -> 1917
/*     */     //   1914: invokestatic throwNpe : ()V
/*     */     //   1917: checkcast net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   1920: getfield level : I
/*     */     //   1923: aload #6
/*     */     //   1925: invokeinterface getAmplifier : ()I
/*     */     //   1930: if_icmpne -> 1952
/*     */     //   1933: aload_0
/*     */     //   1934: getfield potionMap : Ljava/util/Map;
/*     */     //   1937: aload #8
/*     */     //   1939: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   1944: checkcast net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   1947: astore #10
/*     */     //   1949: goto -> 2032
/*     */     //   1952: aload_0
/*     */     //   1953: getfield potionMap : Ljava/util/Map;
/*     */     //   1956: aload #8
/*     */     //   1958: new net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   1961: dup
/*     */     //   1962: aload #8
/*     */     //   1964: new net/ccbluex/liquidbounce/utils/Translate
/*     */     //   1967: dup
/*     */     //   1968: fconst_0
/*     */     //   1969: ldc_w -40.0
/*     */     //   1972: iload #4
/*     */     //   1974: i2f
/*     */     //   1975: fadd
/*     */     //   1976: invokespecial <init> : (FF)V
/*     */     //   1979: aload #6
/*     */     //   1981: invokeinterface getAmplifier : ()I
/*     */     //   1986: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;Lnet/ccbluex/liquidbounce/utils/Translate;I)V
/*     */     //   1989: astore #11
/*     */     //   1991: astore #23
/*     */     //   1993: astore #22
/*     */     //   1995: iconst_0
/*     */     //   1996: istore #12
/*     */     //   1998: iconst_0
/*     */     //   1999: istore #13
/*     */     //   2001: aload #11
/*     */     //   2003: astore #14
/*     */     //   2005: iconst_0
/*     */     //   2006: istore #15
/*     */     //   2008: aload #14
/*     */     //   2010: astore #10
/*     */     //   2012: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
/*     */     //   2015: pop
/*     */     //   2016: aload #11
/*     */     //   2018: astore #24
/*     */     //   2020: aload #22
/*     */     //   2022: aload #23
/*     */     //   2024: aload #24
/*     */     //   2026: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   2031: pop
/*     */     //   2032: iconst_1
/*     */     //   2033: istore #11
/*     */     //   2035: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2038: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2043: dup
/*     */     //   2044: ifnonnull -> 2050
/*     */     //   2047: invokestatic throwNpe : ()V
/*     */     //   2050: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   2055: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   2060: astore #13
/*     */     //   2062: aload #13
/*     */     //   2064: invokeinterface hasNext : ()Z
/*     */     //   2069: ifeq -> 2115
/*     */     //   2072: aload #13
/*     */     //   2074: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   2079: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   2082: astore #12
/*     */     //   2084: aload #12
/*     */     //   2086: invokeinterface getAmplifier : ()I
/*     */     //   2091: aload #10
/*     */     //   2093: dup
/*     */     //   2094: ifnonnull -> 2100
/*     */     //   2097: invokestatic throwNpe : ()V
/*     */     //   2100: getfield level : I
/*     */     //   2103: if_icmpne -> 2112
/*     */     //   2106: iconst_0
/*     */     //   2107: istore #11
/*     */     //   2109: goto -> 2115
/*     */     //   2112: goto -> 2062
/*     */     //   2115: iload #11
/*     */     //   2117: ifeq -> 2132
/*     */     //   2120: aload_0
/*     */     //   2121: getfield potionMap : Ljava/util/Map;
/*     */     //   2124: aload #8
/*     */     //   2126: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   2131: pop
/*     */     //   2132: iconst_0
/*     */     //   2133: istore #12
/*     */     //   2135: iconst_0
/*     */     //   2136: istore #13
/*     */     //   2138: nop
/*     */     //   2139: aload #6
/*     */     //   2141: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   2146: checkcast java/lang/CharSequence
/*     */     //   2149: astore #14
/*     */     //   2151: ldc_w ':'
/*     */     //   2154: astore #15
/*     */     //   2156: iconst_0
/*     */     //   2157: istore #16
/*     */     //   2159: new kotlin/text/Regex
/*     */     //   2162: dup
/*     */     //   2163: aload #15
/*     */     //   2165: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2168: astore #15
/*     */     //   2170: iconst_0
/*     */     //   2171: istore #16
/*     */     //   2173: iconst_0
/*     */     //   2174: istore #17
/*     */     //   2176: aload #15
/*     */     //   2178: aload #14
/*     */     //   2180: iload #16
/*     */     //   2182: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   2185: astore #14
/*     */     //   2187: iconst_0
/*     */     //   2188: istore #15
/*     */     //   2190: aload #14
/*     */     //   2192: invokeinterface isEmpty : ()Z
/*     */     //   2197: ifne -> 2292
/*     */     //   2200: aload #14
/*     */     //   2202: aload #14
/*     */     //   2204: invokeinterface size : ()I
/*     */     //   2209: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   2214: astore #16
/*     */     //   2216: aload #16
/*     */     //   2218: invokeinterface hasPrevious : ()Z
/*     */     //   2223: ifeq -> 2292
/*     */     //   2226: aload #16
/*     */     //   2228: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   2233: checkcast java/lang/String
/*     */     //   2236: astore #17
/*     */     //   2238: iconst_0
/*     */     //   2239: istore #18
/*     */     //   2241: aload #17
/*     */     //   2243: checkcast java/lang/CharSequence
/*     */     //   2246: astore #19
/*     */     //   2248: iconst_0
/*     */     //   2249: istore #20
/*     */     //   2251: aload #19
/*     */     //   2253: invokeinterface length : ()I
/*     */     //   2258: ifne -> 2265
/*     */     //   2261: iconst_1
/*     */     //   2262: goto -> 2266
/*     */     //   2265: iconst_0
/*     */     //   2266: ifne -> 2289
/*     */     //   2269: aload #14
/*     */     //   2271: checkcast java/lang/Iterable
/*     */     //   2274: aload #16
/*     */     //   2276: invokeinterface nextIndex : ()I
/*     */     //   2281: iconst_1
/*     */     //   2282: iadd
/*     */     //   2283: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   2286: goto -> 2295
/*     */     //   2289: goto -> 2216
/*     */     //   2292: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   2295: checkcast java/util/Collection
/*     */     //   2298: astore #14
/*     */     //   2300: iconst_0
/*     */     //   2301: istore #15
/*     */     //   2303: aload #14
/*     */     //   2305: astore #16
/*     */     //   2307: aload #16
/*     */     //   2309: iconst_0
/*     */     //   2310: anewarray java/lang/String
/*     */     //   2313: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   2318: dup
/*     */     //   2319: ifnonnull -> 2333
/*     */     //   2322: new kotlin/TypeCastException
/*     */     //   2325: dup
/*     */     //   2326: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   2329: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2332: athrow
/*     */     //   2333: checkcast [Ljava/lang/String;
/*     */     //   2336: iconst_0
/*     */     //   2337: aaload
/*     */     //   2338: astore #14
/*     */     //   2340: iconst_0
/*     */     //   2341: istore #15
/*     */     //   2343: aload #14
/*     */     //   2345: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   2348: istore #12
/*     */     //   2350: aload #6
/*     */     //   2352: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   2357: checkcast java/lang/CharSequence
/*     */     //   2360: astore #14
/*     */     //   2362: ldc_w ':'
/*     */     //   2365: astore #15
/*     */     //   2367: iconst_0
/*     */     //   2368: istore #16
/*     */     //   2370: new kotlin/text/Regex
/*     */     //   2373: dup
/*     */     //   2374: aload #15
/*     */     //   2376: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2379: astore #15
/*     */     //   2381: iconst_0
/*     */     //   2382: istore #16
/*     */     //   2384: iconst_0
/*     */     //   2385: istore #17
/*     */     //   2387: aload #15
/*     */     //   2389: aload #14
/*     */     //   2391: iload #16
/*     */     //   2393: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   2396: astore #14
/*     */     //   2398: iconst_0
/*     */     //   2399: istore #15
/*     */     //   2401: aload #14
/*     */     //   2403: invokeinterface isEmpty : ()Z
/*     */     //   2408: ifne -> 2503
/*     */     //   2411: aload #14
/*     */     //   2413: aload #14
/*     */     //   2415: invokeinterface size : ()I
/*     */     //   2420: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   2425: astore #16
/*     */     //   2427: aload #16
/*     */     //   2429: invokeinterface hasPrevious : ()Z
/*     */     //   2434: ifeq -> 2503
/*     */     //   2437: aload #16
/*     */     //   2439: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   2444: checkcast java/lang/String
/*     */     //   2447: astore #17
/*     */     //   2449: iconst_0
/*     */     //   2450: istore #18
/*     */     //   2452: aload #17
/*     */     //   2454: checkcast java/lang/CharSequence
/*     */     //   2457: astore #19
/*     */     //   2459: iconst_0
/*     */     //   2460: istore #20
/*     */     //   2462: aload #19
/*     */     //   2464: invokeinterface length : ()I
/*     */     //   2469: ifne -> 2476
/*     */     //   2472: iconst_1
/*     */     //   2473: goto -> 2477
/*     */     //   2476: iconst_0
/*     */     //   2477: ifne -> 2500
/*     */     //   2480: aload #14
/*     */     //   2482: checkcast java/lang/Iterable
/*     */     //   2485: aload #16
/*     */     //   2487: invokeinterface nextIndex : ()I
/*     */     //   2492: iconst_1
/*     */     //   2493: iadd
/*     */     //   2494: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   2497: goto -> 2506
/*     */     //   2500: goto -> 2427
/*     */     //   2503: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   2506: checkcast java/util/Collection
/*     */     //   2509: astore #14
/*     */     //   2511: iconst_0
/*     */     //   2512: istore #15
/*     */     //   2514: aload #14
/*     */     //   2516: astore #16
/*     */     //   2518: aload #16
/*     */     //   2520: iconst_0
/*     */     //   2521: anewarray java/lang/String
/*     */     //   2524: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   2529: dup
/*     */     //   2530: ifnonnull -> 2544
/*     */     //   2533: new kotlin/TypeCastException
/*     */     //   2536: dup
/*     */     //   2537: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   2540: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   2543: athrow
/*     */     //   2544: checkcast [Ljava/lang/String;
/*     */     //   2547: iconst_1
/*     */     //   2548: aaload
/*     */     //   2549: astore #14
/*     */     //   2551: iconst_0
/*     */     //   2552: istore #15
/*     */     //   2554: aload #14
/*     */     //   2556: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   2559: istore #13
/*     */     //   2561: goto -> 2575
/*     */     //   2564: astore #14
/*     */     //   2566: bipush #100
/*     */     //   2568: istore #12
/*     */     //   2570: sipush #1000
/*     */     //   2573: istore #13
/*     */     //   2575: iload #12
/*     */     //   2577: bipush #60
/*     */     //   2579: imul
/*     */     //   2580: iload #13
/*     */     //   2582: iadd
/*     */     //   2583: istore #14
/*     */     //   2585: aload #10
/*     */     //   2587: dup
/*     */     //   2588: ifnonnull -> 2594
/*     */     //   2591: invokestatic throwNpe : ()V
/*     */     //   2594: invokevirtual getMaxTimer : ()I
/*     */     //   2597: ifeq -> 2613
/*     */     //   2600: iload #14
/*     */     //   2602: i2d
/*     */     //   2603: aload #10
/*     */     //   2605: invokevirtual getMaxTimer : ()I
/*     */     //   2608: i2d
/*     */     //   2609: dcmpl
/*     */     //   2610: ifle -> 2620
/*     */     //   2613: aload #10
/*     */     //   2615: iload #14
/*     */     //   2617: putfield maxTimer : I
/*     */     //   2620: fconst_0
/*     */     //   2621: fstore #15
/*     */     //   2623: iload #14
/*     */     //   2625: i2d
/*     */     //   2626: dconst_0
/*     */     //   2627: dcmpl
/*     */     //   2628: iflt -> 2649
/*     */     //   2631: iload #14
/*     */     //   2633: i2d
/*     */     //   2634: aload #10
/*     */     //   2636: invokevirtual getMaxTimer : ()I
/*     */     //   2639: i2f
/*     */     //   2640: f2d
/*     */     //   2641: ddiv
/*     */     //   2642: ldc2_w 100.0
/*     */     //   2645: dmul
/*     */     //   2646: d2f
/*     */     //   2647: fstore #15
/*     */     //   2649: aload #10
/*     */     //   2651: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   2654: dup
/*     */     //   2655: ldc_w 'potionData.translate'
/*     */     //   2658: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2661: invokevirtual getY : ()F
/*     */     //   2664: ldc_w 1.4
/*     */     //   2667: fdiv
/*     */     //   2668: ldc_w 7.22
/*     */     //   2671: fsub
/*     */     //   2672: invokestatic round : (F)I
/*     */     //   2675: istore #16
/*     */     //   2677: fload #15
/*     */     //   2679: fconst_2
/*     */     //   2680: invokestatic max : (FF)F
/*     */     //   2683: fstore #15
/*     */     //   2685: aload #10
/*     */     //   2687: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   2690: fconst_0
/*     */     //   2691: iload #4
/*     */     //   2693: i2f
/*     */     //   2694: ldc2_w 0.1
/*     */     //   2697: invokevirtual interpolate : (FFD)V
/*     */     //   2700: aload #10
/*     */     //   2702: aload #10
/*     */     //   2704: invokevirtual getAnimationX : ()F
/*     */     //   2707: f2d
/*     */     //   2708: ldc_w 1.2
/*     */     //   2711: fload #15
/*     */     //   2713: fmul
/*     */     //   2714: f2d
/*     */     //   2715: ldc_w 10.0
/*     */     //   2718: aload #10
/*     */     //   2720: getfield animationX : F
/*     */     //   2723: ldc_w 1.2
/*     */     //   2726: fload #15
/*     */     //   2728: fmul
/*     */     //   2729: fsub
/*     */     //   2730: invokestatic abs : (F)F
/*     */     //   2733: ldc_w 15.0
/*     */     //   2736: fmul
/*     */     //   2737: invokestatic max : (FF)F
/*     */     //   2740: ldc_w 0.3
/*     */     //   2743: fmul
/*     */     //   2744: f2d
/*     */     //   2745: invokestatic getAnimationState2 : (DDD)D
/*     */     //   2748: d2f
/*     */     //   2749: putfield animationX : F
/*     */     //   2752: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2755: new java/lang/StringBuilder
/*     */     //   2758: dup
/*     */     //   2759: invokespecial <init> : ()V
/*     */     //   2762: aload #9
/*     */     //   2764: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2767: ldc_w ' '
/*     */     //   2770: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2773: aload_0
/*     */     //   2774: aload #6
/*     */     //   2776: invokeinterface getAmplifier : ()I
/*     */     //   2781: iconst_1
/*     */     //   2782: iadd
/*     */     //   2783: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   2786: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2789: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2792: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   2797: istore #17
/*     */     //   2799: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2802: new java/lang/StringBuilder
/*     */     //   2805: dup
/*     */     //   2806: invokespecial <init> : ()V
/*     */     //   2809: aload #9
/*     */     //   2811: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2814: ldc_w ' '
/*     */     //   2817: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2820: aload_0
/*     */     //   2821: aload #6
/*     */     //   2823: invokeinterface getAmplifier : ()I
/*     */     //   2828: iconst_1
/*     */     //   2829: iadd
/*     */     //   2830: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   2833: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2836: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2839: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   2844: i2f
/*     */     //   2845: fstore_1
/*     */     //   2846: iload #17
/*     */     //   2848: i2f
/*     */     //   2849: fload_2
/*     */     //   2850: fcmpl
/*     */     //   2851: ifle -> 2858
/*     */     //   2854: iload #17
/*     */     //   2856: i2f
/*     */     //   2857: fstore_2
/*     */     //   2858: aload #10
/*     */     //   2860: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   2863: dup
/*     */     //   2864: ldc_w 'potionData.translate'
/*     */     //   2867: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2870: invokevirtual getY : ()F
/*     */     //   2873: ldc_w 2.5
/*     */     //   2876: fdiv
/*     */     //   2877: ldc 3.0
/*     */     //   2879: fsub
/*     */     //   2880: fstore #18
/*     */     //   2882: aload #10
/*     */     //   2884: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   2887: dup
/*     */     //   2888: ldc_w 'potionData.translate'
/*     */     //   2891: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2894: invokevirtual getY : ()F
/*     */     //   2897: ldc_w 2.5
/*     */     //   2900: fdiv
/*     */     //   2901: ldc 8.0
/*     */     //   2903: fsub
/*     */     //   2904: fstore_3
/*     */     //   2905: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2908: new java/lang/StringBuilder
/*     */     //   2911: dup
/*     */     //   2912: invokespecial <init> : ()V
/*     */     //   2915: aload #9
/*     */     //   2917: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2920: ldc_w ' '
/*     */     //   2923: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2926: aload_0
/*     */     //   2927: aload #6
/*     */     //   2929: invokeinterface getAmplifier : ()I
/*     */     //   2934: iconst_1
/*     */     //   2935: iadd
/*     */     //   2936: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   2939: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2942: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2945: ldc_w 15.0
/*     */     //   2948: fload #18
/*     */     //   2950: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2953: invokeinterface getFontHeight : ()I
/*     */     //   2958: i2f
/*     */     //   2959: fsub
/*     */     //   2960: fneg
/*     */     //   2961: iconst_m1
/*     */     //   2962: iconst_1
/*     */     //   2963: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   2968: pop
/*     */     //   2969: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.Newuifont15 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2972: aload #6
/*     */     //   2974: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   2979: ldc_w 93.0
/*     */     //   2982: fload #18
/*     */     //   2984: ldc_w 9.76
/*     */     //   2987: fsub
/*     */     //   2988: fneg
/*     */     //   2989: iconst_m1
/*     */     //   2990: iconst_1
/*     */     //   2991: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   2996: pop
/*     */     //   2997: iload #4
/*     */     //   2999: bipush #35
/*     */     //   3001: isub
/*     */     //   3002: istore #4
/*     */     //   3004: goto -> 1822
/*     */     //   3007: iconst_0
/*     */     //   3008: istore #6
/*     */     //   3010: aload_0
/*     */     //   3011: getfield effects : Ljava/util/List;
/*     */     //   3014: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   3019: astore #8
/*     */     //   3021: aload #8
/*     */     //   3023: invokeinterface hasNext : ()Z
/*     */     //   3028: ifeq -> 4447
/*     */     //   3031: aload #8
/*     */     //   3033: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   3038: checkcast net/minecraft/potion/PotionEffect
/*     */     //   3041: astore #7
/*     */     //   3043: aload #7
/*     */     //   3045: invokevirtual func_188419_a : ()Lnet/minecraft/potion/Potion;
/*     */     //   3048: invokestatic func_188409_a : (Lnet/minecraft/potion/Potion;)I
/*     */     //   3051: invokestatic func_188412_a : (I)Lnet/minecraft/potion/Potion;
/*     */     //   3054: astore #9
/*     */     //   3056: aload #9
/*     */     //   3058: dup
/*     */     //   3059: ifnonnull -> 3065
/*     */     //   3062: invokestatic throwNpe : ()V
/*     */     //   3065: invokevirtual func_76393_a : ()Ljava/lang/String;
/*     */     //   3068: iconst_0
/*     */     //   3069: anewarray java/lang/Object
/*     */     //   3072: invokestatic func_135052_a : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   3075: astore #10
/*     */     //   3077: aconst_null
/*     */     //   3078: astore #11
/*     */     //   3080: aload_0
/*     */     //   3081: getfield potionMap2 : Ljava/util/Map;
/*     */     //   3084: aload #9
/*     */     //   3086: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   3091: ifeq -> 3145
/*     */     //   3094: aload_0
/*     */     //   3095: getfield potionMap2 : Ljava/util/Map;
/*     */     //   3098: aload #9
/*     */     //   3100: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   3105: dup
/*     */     //   3106: ifnonnull -> 3112
/*     */     //   3109: invokestatic throwNpe : ()V
/*     */     //   3112: checkcast net/ccbluex/liquidbounce/utils/render/PotionData
/*     */     //   3115: getfield level : I
/*     */     //   3118: aload #7
/*     */     //   3120: invokevirtual func_76458_c : ()I
/*     */     //   3123: if_icmpne -> 3145
/*     */     //   3126: aload_0
/*     */     //   3127: getfield potionMap2 : Ljava/util/Map;
/*     */     //   3130: aload #9
/*     */     //   3132: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   3137: checkcast net/ccbluex/liquidbounce/utils/render/PotionData
/*     */     //   3140: astore #11
/*     */     //   3142: goto -> 3223
/*     */     //   3145: aload_0
/*     */     //   3146: getfield potionMap2 : Ljava/util/Map;
/*     */     //   3149: aload #9
/*     */     //   3151: new net/ccbluex/liquidbounce/utils/render/PotionData
/*     */     //   3154: dup
/*     */     //   3155: aload #9
/*     */     //   3157: new net/ccbluex/liquidbounce/utils/Translate
/*     */     //   3160: dup
/*     */     //   3161: fconst_0
/*     */     //   3162: ldc_w -40.0
/*     */     //   3165: iload #6
/*     */     //   3167: i2f
/*     */     //   3168: fadd
/*     */     //   3169: invokespecial <init> : (FF)V
/*     */     //   3172: aload #7
/*     */     //   3174: invokevirtual func_76458_c : ()I
/*     */     //   3177: invokespecial <init> : (Lnet/minecraft/potion/Potion;Lnet/ccbluex/liquidbounce/utils/Translate;I)V
/*     */     //   3180: astore #12
/*     */     //   3182: astore #23
/*     */     //   3184: astore #22
/*     */     //   3186: iconst_0
/*     */     //   3187: istore #13
/*     */     //   3189: iconst_0
/*     */     //   3190: istore #14
/*     */     //   3192: aload #12
/*     */     //   3194: astore #15
/*     */     //   3196: iconst_0
/*     */     //   3197: istore #16
/*     */     //   3199: aload #15
/*     */     //   3201: astore #11
/*     */     //   3203: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
/*     */     //   3206: pop
/*     */     //   3207: aload #12
/*     */     //   3209: astore #24
/*     */     //   3211: aload #22
/*     */     //   3213: aload #23
/*     */     //   3215: aload #24
/*     */     //   3217: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   3222: pop
/*     */     //   3223: iconst_1
/*     */     //   3224: istore #12
/*     */     //   3226: aload_0
/*     */     //   3227: getfield effects : Ljava/util/List;
/*     */     //   3230: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   3235: astore #14
/*     */     //   3237: aload #14
/*     */     //   3239: invokeinterface hasNext : ()Z
/*     */     //   3244: ifeq -> 3288
/*     */     //   3247: aload #14
/*     */     //   3249: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   3254: checkcast net/minecraft/potion/PotionEffect
/*     */     //   3257: astore #13
/*     */     //   3259: aload #13
/*     */     //   3261: invokevirtual func_76458_c : ()I
/*     */     //   3264: aload #11
/*     */     //   3266: dup
/*     */     //   3267: ifnonnull -> 3273
/*     */     //   3270: invokestatic throwNpe : ()V
/*     */     //   3273: getfield level : I
/*     */     //   3276: if_icmpne -> 3285
/*     */     //   3279: iconst_0
/*     */     //   3280: istore #12
/*     */     //   3282: goto -> 3288
/*     */     //   3285: goto -> 3237
/*     */     //   3288: iload #12
/*     */     //   3290: ifeq -> 3305
/*     */     //   3293: aload_0
/*     */     //   3294: getfield potionMap2 : Ljava/util/Map;
/*     */     //   3297: aload #9
/*     */     //   3299: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   3304: pop
/*     */     //   3305: iconst_0
/*     */     //   3306: istore #13
/*     */     //   3308: iconst_0
/*     */     //   3309: istore #14
/*     */     //   3311: nop
/*     */     //   3312: aload #7
/*     */     //   3314: fconst_1
/*     */     //   3315: invokestatic func_188410_a : (Lnet/minecraft/potion/PotionEffect;F)Ljava/lang/String;
/*     */     //   3318: dup
/*     */     //   3319: ldc_w 'Potion.getPotionDurationString(potionEffect, 1.0f)'
/*     */     //   3322: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3325: checkcast java/lang/CharSequence
/*     */     //   3328: astore #15
/*     */     //   3330: ldc_w ':'
/*     */     //   3333: astore #16
/*     */     //   3335: iconst_0
/*     */     //   3336: istore #17
/*     */     //   3338: new kotlin/text/Regex
/*     */     //   3341: dup
/*     */     //   3342: aload #16
/*     */     //   3344: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3347: astore #16
/*     */     //   3349: iconst_0
/*     */     //   3350: istore #17
/*     */     //   3352: iconst_0
/*     */     //   3353: istore #18
/*     */     //   3355: aload #16
/*     */     //   3357: aload #15
/*     */     //   3359: iload #17
/*     */     //   3361: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   3364: astore #15
/*     */     //   3366: iconst_0
/*     */     //   3367: istore #16
/*     */     //   3369: aload #15
/*     */     //   3371: invokeinterface isEmpty : ()Z
/*     */     //   3376: ifne -> 3471
/*     */     //   3379: aload #15
/*     */     //   3381: aload #15
/*     */     //   3383: invokeinterface size : ()I
/*     */     //   3388: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   3393: astore #17
/*     */     //   3395: aload #17
/*     */     //   3397: invokeinterface hasPrevious : ()Z
/*     */     //   3402: ifeq -> 3471
/*     */     //   3405: aload #17
/*     */     //   3407: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   3412: checkcast java/lang/String
/*     */     //   3415: astore #18
/*     */     //   3417: iconst_0
/*     */     //   3418: istore #19
/*     */     //   3420: aload #18
/*     */     //   3422: checkcast java/lang/CharSequence
/*     */     //   3425: astore #20
/*     */     //   3427: iconst_0
/*     */     //   3428: istore #21
/*     */     //   3430: aload #20
/*     */     //   3432: invokeinterface length : ()I
/*     */     //   3437: ifne -> 3444
/*     */     //   3440: iconst_1
/*     */     //   3441: goto -> 3445
/*     */     //   3444: iconst_0
/*     */     //   3445: ifne -> 3468
/*     */     //   3448: aload #15
/*     */     //   3450: checkcast java/lang/Iterable
/*     */     //   3453: aload #17
/*     */     //   3455: invokeinterface nextIndex : ()I
/*     */     //   3460: iconst_1
/*     */     //   3461: iadd
/*     */     //   3462: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   3465: goto -> 3474
/*     */     //   3468: goto -> 3395
/*     */     //   3471: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   3474: checkcast java/util/Collection
/*     */     //   3477: astore #15
/*     */     //   3479: iconst_0
/*     */     //   3480: istore #16
/*     */     //   3482: aload #15
/*     */     //   3484: astore #17
/*     */     //   3486: aload #17
/*     */     //   3488: iconst_0
/*     */     //   3489: anewarray java/lang/String
/*     */     //   3492: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   3497: dup
/*     */     //   3498: ifnonnull -> 3512
/*     */     //   3501: new kotlin/TypeCastException
/*     */     //   3504: dup
/*     */     //   3505: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   3508: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3511: athrow
/*     */     //   3512: checkcast [Ljava/lang/String;
/*     */     //   3515: iconst_0
/*     */     //   3516: aaload
/*     */     //   3517: astore #15
/*     */     //   3519: iconst_0
/*     */     //   3520: istore #16
/*     */     //   3522: aload #15
/*     */     //   3524: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   3527: istore #13
/*     */     //   3529: aload #7
/*     */     //   3531: fconst_1
/*     */     //   3532: invokestatic func_188410_a : (Lnet/minecraft/potion/PotionEffect;F)Ljava/lang/String;
/*     */     //   3535: dup
/*     */     //   3536: ldc_w 'Potion.getPotionDurationString(potionEffect, 1.0f)'
/*     */     //   3539: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3542: checkcast java/lang/CharSequence
/*     */     //   3545: astore #15
/*     */     //   3547: ldc_w ':'
/*     */     //   3550: astore #16
/*     */     //   3552: iconst_0
/*     */     //   3553: istore #17
/*     */     //   3555: new kotlin/text/Regex
/*     */     //   3558: dup
/*     */     //   3559: aload #16
/*     */     //   3561: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3564: astore #16
/*     */     //   3566: iconst_0
/*     */     //   3567: istore #17
/*     */     //   3569: iconst_0
/*     */     //   3570: istore #18
/*     */     //   3572: aload #16
/*     */     //   3574: aload #15
/*     */     //   3576: iload #17
/*     */     //   3578: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   3581: astore #15
/*     */     //   3583: iconst_0
/*     */     //   3584: istore #16
/*     */     //   3586: aload #15
/*     */     //   3588: invokeinterface isEmpty : ()Z
/*     */     //   3593: ifne -> 3688
/*     */     //   3596: aload #15
/*     */     //   3598: aload #15
/*     */     //   3600: invokeinterface size : ()I
/*     */     //   3605: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   3610: astore #17
/*     */     //   3612: aload #17
/*     */     //   3614: invokeinterface hasPrevious : ()Z
/*     */     //   3619: ifeq -> 3688
/*     */     //   3622: aload #17
/*     */     //   3624: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   3629: checkcast java/lang/String
/*     */     //   3632: astore #18
/*     */     //   3634: iconst_0
/*     */     //   3635: istore #19
/*     */     //   3637: aload #18
/*     */     //   3639: checkcast java/lang/CharSequence
/*     */     //   3642: astore #20
/*     */     //   3644: iconst_0
/*     */     //   3645: istore #21
/*     */     //   3647: aload #20
/*     */     //   3649: invokeinterface length : ()I
/*     */     //   3654: ifne -> 3661
/*     */     //   3657: iconst_1
/*     */     //   3658: goto -> 3662
/*     */     //   3661: iconst_0
/*     */     //   3662: ifne -> 3685
/*     */     //   3665: aload #15
/*     */     //   3667: checkcast java/lang/Iterable
/*     */     //   3670: aload #17
/*     */     //   3672: invokeinterface nextIndex : ()I
/*     */     //   3677: iconst_1
/*     */     //   3678: iadd
/*     */     //   3679: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   3682: goto -> 3691
/*     */     //   3685: goto -> 3612
/*     */     //   3688: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   3691: checkcast java/util/Collection
/*     */     //   3694: astore #15
/*     */     //   3696: iconst_0
/*     */     //   3697: istore #16
/*     */     //   3699: aload #15
/*     */     //   3701: astore #17
/*     */     //   3703: aload #17
/*     */     //   3705: iconst_0
/*     */     //   3706: anewarray java/lang/String
/*     */     //   3709: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   3714: dup
/*     */     //   3715: ifnonnull -> 3729
/*     */     //   3718: new kotlin/TypeCastException
/*     */     //   3721: dup
/*     */     //   3722: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   3725: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   3728: athrow
/*     */     //   3729: checkcast [Ljava/lang/String;
/*     */     //   3732: iconst_1
/*     */     //   3733: aaload
/*     */     //   3734: astore #15
/*     */     //   3736: iconst_0
/*     */     //   3737: istore #16
/*     */     //   3739: aload #15
/*     */     //   3741: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   3744: istore #14
/*     */     //   3746: goto -> 3760
/*     */     //   3749: astore #15
/*     */     //   3751: bipush #100
/*     */     //   3753: istore #13
/*     */     //   3755: sipush #1000
/*     */     //   3758: istore #14
/*     */     //   3760: iload #13
/*     */     //   3762: bipush #60
/*     */     //   3764: imul
/*     */     //   3765: iload #14
/*     */     //   3767: iadd
/*     */     //   3768: istore #15
/*     */     //   3770: aload #11
/*     */     //   3772: dup
/*     */     //   3773: ifnonnull -> 3779
/*     */     //   3776: invokestatic throwNpe : ()V
/*     */     //   3779: invokevirtual getMaxTimer : ()I
/*     */     //   3782: ifeq -> 3798
/*     */     //   3785: iload #15
/*     */     //   3787: i2d
/*     */     //   3788: aload #11
/*     */     //   3790: invokevirtual getMaxTimer : ()I
/*     */     //   3793: i2d
/*     */     //   3794: dcmpl
/*     */     //   3795: ifle -> 3805
/*     */     //   3798: aload #11
/*     */     //   3800: iload #15
/*     */     //   3802: putfield maxTimer : I
/*     */     //   3805: fconst_0
/*     */     //   3806: fstore #16
/*     */     //   3808: iload #15
/*     */     //   3810: i2d
/*     */     //   3811: dconst_0
/*     */     //   3812: dcmpl
/*     */     //   3813: iflt -> 3834
/*     */     //   3816: iload #15
/*     */     //   3818: i2d
/*     */     //   3819: aload #11
/*     */     //   3821: invokevirtual getMaxTimer : ()I
/*     */     //   3824: i2f
/*     */     //   3825: f2d
/*     */     //   3826: ddiv
/*     */     //   3827: ldc2_w 100.0
/*     */     //   3830: dmul
/*     */     //   3831: d2f
/*     */     //   3832: fstore #16
/*     */     //   3834: aload #11
/*     */     //   3836: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   3839: dup
/*     */     //   3840: ldc_w 'potionData.translate'
/*     */     //   3843: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3846: invokevirtual getY : ()F
/*     */     //   3849: iconst_5
/*     */     //   3850: i2f
/*     */     //   3851: fadd
/*     */     //   3852: invokestatic round : (F)I
/*     */     //   3855: istore #17
/*     */     //   3857: fload #16
/*     */     //   3859: fconst_2
/*     */     //   3860: invokestatic coerceAtLeast : (FF)F
/*     */     //   3863: fstore #16
/*     */     //   3865: aload #11
/*     */     //   3867: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   3870: fconst_0
/*     */     //   3871: iload #6
/*     */     //   3873: i2f
/*     */     //   3874: ldc2_w 0.1
/*     */     //   3877: invokevirtual interpolate : (FFD)V
/*     */     //   3880: aload #11
/*     */     //   3882: aload_0
/*     */     //   3883: aload #11
/*     */     //   3885: invokevirtual getAnimationX : ()F
/*     */     //   3888: f2d
/*     */     //   3889: ldc_w 1.2
/*     */     //   3892: fload #16
/*     */     //   3894: fmul
/*     */     //   3895: f2d
/*     */     //   3896: ldc_w 10.0
/*     */     //   3899: aload #11
/*     */     //   3901: getfield animationX : F
/*     */     //   3904: ldc_w 1.2
/*     */     //   3907: fload #16
/*     */     //   3909: fmul
/*     */     //   3910: fsub
/*     */     //   3911: invokestatic abs : (F)F
/*     */     //   3914: ldc_w 15.0
/*     */     //   3917: fmul
/*     */     //   3918: invokestatic max : (FF)F
/*     */     //   3921: ldc_w 0.3
/*     */     //   3924: fmul
/*     */     //   3925: f2d
/*     */     //   3926: invokespecial getAnimationState : (DDD)D
/*     */     //   3929: d2f
/*     */     //   3930: putfield animationX : F
/*     */     //   3933: fconst_0
/*     */     //   3934: aload #11
/*     */     //   3936: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   3939: dup
/*     */     //   3940: ldc_w 'potionData.translate'
/*     */     //   3943: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3946: invokevirtual getY : ()F
/*     */     //   3949: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3952: new java/lang/StringBuilder
/*     */     //   3955: dup
/*     */     //   3956: invokespecial <init> : ()V
/*     */     //   3959: aload #10
/*     */     //   3961: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3964: ldc_w ' '
/*     */     //   3967: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3970: aload_0
/*     */     //   3971: aload #7
/*     */     //   3973: invokevirtual func_76458_c : ()I
/*     */     //   3976: iconst_1
/*     */     //   3977: iadd
/*     */     //   3978: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   3981: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3984: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3987: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   3992: bipush #25
/*     */     //   3994: iadd
/*     */     //   3995: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3998: new java/lang/StringBuilder
/*     */     //   4001: dup
/*     */     //   4002: invokespecial <init> : ()V
/*     */     //   4005: aload #10
/*     */     //   4007: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4010: ldc_w ' '
/*     */     //   4013: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4016: aload_0
/*     */     //   4017: aload #7
/*     */     //   4019: invokevirtual func_76458_c : ()I
/*     */     //   4022: iconst_1
/*     */     //   4023: iadd
/*     */     //   4024: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   4027: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4030: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4033: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   4038: bipush #25
/*     */     //   4040: iadd
/*     */     //   4041: bipush #10
/*     */     //   4043: iadd
/*     */     //   4044: invokestatic max : (II)I
/*     */     //   4047: i2f
/*     */     //   4048: ldc_w 30.0
/*     */     //   4051: aload_0
/*     */     //   4052: getfield ridius : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   4055: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4058: checkcast java/lang/Number
/*     */     //   4061: invokevirtual floatValue : ()F
/*     */     //   4064: new java/awt/Color
/*     */     //   4067: dup
/*     */     //   4068: iconst_0
/*     */     //   4069: iconst_0
/*     */     //   4070: iconst_0
/*     */     //   4071: aload_0
/*     */     //   4072: getfield alpha : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   4075: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4078: checkcast java/lang/Number
/*     */     //   4081: invokevirtual intValue : ()I
/*     */     //   4084: invokespecial <init> : (IIII)V
/*     */     //   4087: invokevirtual getRGB : ()I
/*     */     //   4090: invokestatic drawRoundedRect3 : (FFFFFI)V
/*     */     //   4093: invokestatic func_179117_G : ()V
/*     */     //   4096: aload #11
/*     */     //   4098: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   4101: dup
/*     */     //   4102: ldc_w 'potionData.translate'
/*     */     //   4105: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   4108: invokevirtual getY : ()F
/*     */     //   4111: ldc 13.0
/*     */     //   4113: fadd
/*     */     //   4114: fstore #18
/*     */     //   4116: invokestatic func_179084_k : ()V
/*     */     //   4119: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   4122: new java/lang/StringBuilder
/*     */     //   4125: dup
/*     */     //   4126: invokespecial <init> : ()V
/*     */     //   4129: aload #10
/*     */     //   4131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4134: ldc_w ' '
/*     */     //   4137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4140: aload_0
/*     */     //   4141: aload #7
/*     */     //   4143: invokevirtual func_76458_c : ()I
/*     */     //   4146: iconst_1
/*     */     //   4147: iadd
/*     */     //   4148: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   4151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4154: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4157: ldc_w 27.0
/*     */     //   4160: fload #18
/*     */     //   4162: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4165: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   4170: invokeinterface getFontHeight : ()I
/*     */     //   4175: i2f
/*     */     //   4176: fsub
/*     */     //   4177: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2$Companion;
/*     */     //   4180: new java/awt/Color
/*     */     //   4183: dup
/*     */     //   4184: aload_0
/*     */     //   4185: getfield textredValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   4188: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4191: checkcast java/lang/Number
/*     */     //   4194: invokevirtual intValue : ()I
/*     */     //   4197: aload_0
/*     */     //   4198: getfield textgreenValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   4201: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4204: checkcast java/lang/Number
/*     */     //   4207: invokevirtual intValue : ()I
/*     */     //   4210: aload_0
/*     */     //   4211: getfield textblueValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   4214: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4217: checkcast java/lang/Number
/*     */     //   4220: invokevirtual intValue : ()I
/*     */     //   4223: invokespecial <init> : (III)V
/*     */     //   4226: invokevirtual getRGB : ()I
/*     */     //   4229: ldc_w 0.8
/*     */     //   4232: invokevirtual reAlpha : (IF)I
/*     */     //   4235: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   4240: pop
/*     */     //   4241: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   4244: aload #7
/*     */     //   4246: fconst_1
/*     */     //   4247: invokestatic func_188410_a : (Lnet/minecraft/potion/PotionEffect;F)Ljava/lang/String;
/*     */     //   4250: dup
/*     */     //   4251: ldc_w 'Potion.getPotionDurationString(potionEffect, 1.0f)'
/*     */     //   4254: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   4257: ldc_w 27.0
/*     */     //   4260: fload #18
/*     */     //   4262: ldc_w 4.0
/*     */     //   4265: fadd
/*     */     //   4266: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2$Companion;
/*     */     //   4269: new java/awt/Color
/*     */     //   4272: dup
/*     */     //   4273: sipush #200
/*     */     //   4276: sipush #200
/*     */     //   4279: sipush #200
/*     */     //   4282: invokespecial <init> : (III)V
/*     */     //   4285: invokevirtual getRGB : ()I
/*     */     //   4288: ldc_w 0.5
/*     */     //   4291: invokevirtual reAlpha : (IF)I
/*     */     //   4294: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   4299: pop
/*     */     //   4300: aload #9
/*     */     //   4302: invokevirtual func_76400_d : ()Z
/*     */     //   4305: ifeq -> 4437
/*     */     //   4308: invokestatic func_179094_E : ()V
/*     */     //   4311: sipush #2929
/*     */     //   4314: invokestatic glDisable : (I)V
/*     */     //   4317: sipush #3042
/*     */     //   4320: invokestatic glEnable : (I)V
/*     */     //   4323: iconst_0
/*     */     //   4324: invokestatic glDepthMask : (Z)V
/*     */     //   4327: sipush #770
/*     */     //   4330: sipush #771
/*     */     //   4333: iconst_1
/*     */     //   4334: iconst_0
/*     */     //   4335: invokestatic func_148821_a : (IIII)V
/*     */     //   4338: fconst_1
/*     */     //   4339: fconst_1
/*     */     //   4340: fconst_1
/*     */     //   4341: fconst_1
/*     */     //   4342: invokestatic glColor4f : (FFFF)V
/*     */     //   4345: aload #9
/*     */     //   4347: invokevirtual func_76392_e : ()I
/*     */     //   4350: istore #19
/*     */     //   4352: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   4355: dup
/*     */     //   4356: ldc_w 'mc2'
/*     */     //   4359: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   4362: invokevirtual func_110434_K : ()Lnet/minecraft/client/renderer/texture/TextureManager;
/*     */     //   4365: new net/minecraft/util/ResourceLocation
/*     */     //   4368: dup
/*     */     //   4369: ldc_w 'textures/gui/container/inventory.png'
/*     */     //   4372: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   4375: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
/*     */     //   4378: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   4381: getfield field_71456_v : Lnet/minecraft/client/gui/GuiIngame;
/*     */     //   4384: ldc 5.0
/*     */     //   4386: iload #17
/*     */     //   4388: iconst_2
/*     */     //   4389: iadd
/*     */     //   4390: i2f
/*     */     //   4391: iload #19
/*     */     //   4393: bipush #8
/*     */     //   4395: irem
/*     */     //   4396: bipush #18
/*     */     //   4398: imul
/*     */     //   4399: sipush #198
/*     */     //   4402: iload #19
/*     */     //   4404: bipush #8
/*     */     //   4406: idiv
/*     */     //   4407: bipush #18
/*     */     //   4409: imul
/*     */     //   4410: iadd
/*     */     //   4411: bipush #16
/*     */     //   4413: bipush #16
/*     */     //   4415: invokevirtual func_175174_a : (FFIIII)V
/*     */     //   4418: iconst_1
/*     */     //   4419: invokestatic glDepthMask : (Z)V
/*     */     //   4422: sipush #3042
/*     */     //   4425: invokestatic glDisable : (I)V
/*     */     //   4428: sipush #2929
/*     */     //   4431: invokestatic glEnable : (I)V
/*     */     //   4434: invokestatic func_179121_F : ()V
/*     */     //   4437: iload #6
/*     */     //   4439: bipush #35
/*     */     //   4441: isub
/*     */     //   4442: istore #6
/*     */     //   4444: goto -> 3021
/*     */     //   4447: aload_0
/*     */     //   4448: getfield modes : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4451: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4454: checkcast java/lang/String
/*     */     //   4457: ldc 'newnovoline'
/*     */     //   4459: if_acmpeq -> 4489
/*     */     //   4462: aload_0
/*     */     //   4463: fload_2
/*     */     //   4464: ldc_w 0.98
/*     */     //   4467: fmul
/*     */     //   4468: ldc_w 42.68
/*     */     //   4471: fadd
/*     */     //   4472: invokevirtual updateAnimwith : (F)V
/*     */     //   4475: aload_0
/*     */     //   4476: fload_3
/*     */     //   4477: fneg
/*     */     //   4478: ldc_w 1.1
/*     */     //   4481: fmul
/*     */     //   4482: ldc_w 14.63
/*     */     //   4485: fadd
/*     */     //   4486: invokevirtual updateAnimhealth : (F)V
/*     */     //   4489: invokestatic func_179121_F : ()V
/*     */     //   4492: aload_0
/*     */     //   4493: getfield modes : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   4496: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4499: checkcast java/lang/String
/*     */     //   4502: astore #5
/*     */     //   4504: iconst_0
/*     */     //   4505: istore #6
/*     */     //   4507: aload #5
/*     */     //   4509: dup
/*     */     //   4510: ifnonnull -> 4523
/*     */     //   4513: new kotlin/TypeCastException
/*     */     //   4516: dup
/*     */     //   4517: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   4519: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   4522: athrow
/*     */     //   4523: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   4526: dup
/*     */     //   4527: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   4529: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   4532: astore #5
/*     */     //   4534: aload #5
/*     */     //   4536: invokevirtual hashCode : ()I
/*     */     //   4539: lookupswitch default -> 4636, -1106245566 -> 4577, 108960 -> 4564
/*     */     //   4564: aload #5
/*     */     //   4566: ldc 'new'
/*     */     //   4568: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   4571: ifeq -> 4636
/*     */     //   4574: goto -> 4590
/*     */     //   4577: aload #5
/*     */     //   4579: ldc 'outline'
/*     */     //   4581: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   4584: ifeq -> 4636
/*     */     //   4587: goto -> 4613
/*     */     //   4590: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   4593: dup
/*     */     //   4594: ldc_w 12.8
/*     */     //   4597: ldc_w -15.32
/*     */     //   4600: ldc_w 119.0
/*     */     //   4603: aload_0
/*     */     //   4604: getfield easinghealth : F
/*     */     //   4607: invokespecial <init> : (FFFF)V
/*     */     //   4610: goto -> 4651
/*     */     //   4613: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   4616: dup
/*     */     //   4617: ldc_w 12.8
/*     */     //   4620: ldc_w -15.32
/*     */     //   4623: ldc_w 119.0
/*     */     //   4626: aload_0
/*     */     //   4627: getfield easinghealth : F
/*     */     //   4630: invokespecial <init> : (FFFF)V
/*     */     //   4633: goto -> 4651
/*     */     //   4636: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   4639: dup
/*     */     //   4640: fconst_0
/*     */     //   4641: fconst_0
/*     */     //   4642: ldc_w 120.0
/*     */     //   4645: ldc_w 30.0
/*     */     //   4648: invokespecial <init> : (FFFF)V
/*     */     //   4651: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #190	-> 0
/*     */     //   #203	-> 68
/*     */     //   #191	-> 80
/*     */     //   #192	-> 89
/*     */     //   #193	-> 97
/*     */     //   #194	-> 100
/*     */     //   #197	-> 107
/*     */     //   #198	-> 187
/*     */     //   #199	-> 190
/*     */     //   #204	-> 213
/*     */     //   #205	-> 221
/*     */     //   #206	-> 224
/*     */     //   #207	-> 231
/*     */     //   #209	-> 234
/*     */     //   #210	-> 241
/*     */     //   #212	-> 244
/*     */     //   #213	-> 317
/*     */     //   #214	-> 320
/*     */     //   #215	-> 353
/*     */     //   #216	-> 356
/*     */     //   #217	-> 394
/*     */     //   #219	-> 431
/*     */     //   #220	-> 431
/*     */     //   #221	-> 434
/*     */     //   #222	-> 436
/*     */     //   #223	-> 438
/*     */     //   #224	-> 440
/*     */     //   #225	-> 443
/*     */     //   #293	-> 524
/*     */     //   #226	-> 537
/*     */     //   #359	-> 550
/*     */     //   #227	-> 563
/*     */     //   #228	-> 618
/*     */     //   #229	-> 635
/*     */     //   #230	-> 656
/*     */     //   #231	-> 659
/*     */     //   #232	-> 707
/*     */     //   #233	-> 726
/*     */     //   #232	-> 726
/*     */     //   #233	-> 732
/*     */     //   #234	-> 782
/*     */     //   #235	-> 786
/*     */     //   #233	-> 789
/*     */     //   #232	-> 800
/*     */     //   #235	-> 806
/*     */     //   #236	-> 806
/*     */     //   #237	-> 809
/*     */     //   #238	-> 880
/*     */     //   #239	-> 883
/*     */     //   #237	-> 886
/*     */     //   #241	-> 889
/*     */     //   #242	-> 906
/*     */     //   #243	-> 909
/*     */     //   #244	-> 912
/*     */     //   #245	-> 913
/*     */     //   #246	-> 913
/*     */     //   #247	-> 913
/*     */     //   #246	-> 913
/*     */     //   #247	-> 913
/*     */     //   #246	-> 913
/*     */     //   #246	-> 944
/*     */     //   #246	-> 961
/*     */     //   #566	-> 964
/*     */     //   #567	-> 974
/*     */     //   #568	-> 990
/*     */     //   #569	-> 1000
/*     */     //   #246	-> 1015
/*     */     //   #246	-> 1040
/*     */     //   #570	-> 1043
/*     */     //   #568	-> 1063
/*     */     //   #574	-> 1066
/*     */     //   #247	-> 1074
/*     */     //   #575	-> 1077
/*     */     //   #576	-> 1081
/*     */     //   #247	-> 1114
/*     */     //   #248	-> 1124
/*     */     //   #249	-> 1124
/*     */     //   #250	-> 1124
/*     */     //   #249	-> 1124
/*     */     //   #250	-> 1124
/*     */     //   #249	-> 1124
/*     */     //   #249	-> 1155
/*     */     //   #249	-> 1172
/*     */     //   #577	-> 1175
/*     */     //   #578	-> 1185
/*     */     //   #579	-> 1201
/*     */     //   #580	-> 1211
/*     */     //   #249	-> 1226
/*     */     //   #249	-> 1251
/*     */     //   #581	-> 1254
/*     */     //   #579	-> 1274
/*     */     //   #585	-> 1277
/*     */     //   #250	-> 1285
/*     */     //   #586	-> 1288
/*     */     //   #587	-> 1292
/*     */     //   #250	-> 1325
/*     */     //   #251	-> 1338
/*     */     //   #252	-> 1340
/*     */     //   #253	-> 1344
/*     */     //   #254	-> 1349
/*     */     //   #255	-> 1349
/*     */     //   #256	-> 1359
/*     */     //   #257	-> 1359
/*     */     //   #256	-> 1359
/*     */     //   #257	-> 1382
/*     */     //   #258	-> 1387
/*     */     //   #259	-> 1387
/*     */     //   #260	-> 1394
/*     */     //   #261	-> 1397
/*     */     //   #262	-> 1405
/*     */     //   #263	-> 1423
/*     */     //   #264	-> 1451
/*     */     //   #265	-> 1459
/*     */     //   #266	-> 1474
/*     */     //   #272	-> 1474
/*     */     //   #266	-> 1476
/*     */     //   #267	-> 1476
/*     */     //   #271	-> 1489
/*     */     //   #267	-> 1489
/*     */     //   #268	-> 1489
/*     */     //   #269	-> 1492
/*     */     //   #268	-> 1504
/*     */     //   #270	-> 1507
/*     */     //   #267	-> 1511
/*     */     //   #271	-> 1514
/*     */     //   #266	-> 1519
/*     */     //   #272	-> 1522
/*     */     //   #275	-> 1526
/*     */     //   #276	-> 1526
/*     */     //   #275	-> 1571
/*     */     //   #277	-> 1573
/*     */     //   #278	-> 1573
/*     */     //   #279	-> 1573
/*     */     //   #278	-> 1573
/*     */     //   #279	-> 1618
/*     */     //   #280	-> 1620
/*     */     //   #281	-> 1628
/*     */     //   #283	-> 1632
/*     */     //   #284	-> 1656
/*     */     //   #285	-> 1679
/*     */     //   #287	-> 1747
/*     */     //   #288	-> 1779
/*     */     //   #227	-> 1786
/*     */     //   #294	-> 1789
/*     */     //   #295	-> 1844
/*     */     //   #296	-> 1861
/*     */     //   #297	-> 1882
/*     */     //   #298	-> 1885
/*     */     //   #299	-> 1933
/*     */     //   #300	-> 1952
/*     */     //   #299	-> 1952
/*     */     //   #300	-> 1958
/*     */     //   #301	-> 2008
/*     */     //   #302	-> 2012
/*     */     //   #300	-> 2015
/*     */     //   #299	-> 2026
/*     */     //   #302	-> 2032
/*     */     //   #303	-> 2032
/*     */     //   #304	-> 2035
/*     */     //   #305	-> 2106
/*     */     //   #306	-> 2109
/*     */     //   #304	-> 2112
/*     */     //   #308	-> 2115
/*     */     //   #309	-> 2132
/*     */     //   #310	-> 2135
/*     */     //   #311	-> 2138
/*     */     //   #312	-> 2139
/*     */     //   #313	-> 2139
/*     */     //   #314	-> 2139
/*     */     //   #313	-> 2139
/*     */     //   #314	-> 2139
/*     */     //   #313	-> 2139
/*     */     //   #313	-> 2170
/*     */     //   #313	-> 2187
/*     */     //   #588	-> 2190
/*     */     //   #589	-> 2200
/*     */     //   #590	-> 2216
/*     */     //   #591	-> 2226
/*     */     //   #313	-> 2241
/*     */     //   #313	-> 2266
/*     */     //   #592	-> 2269
/*     */     //   #590	-> 2289
/*     */     //   #596	-> 2292
/*     */     //   #314	-> 2300
/*     */     //   #597	-> 2303
/*     */     //   #598	-> 2307
/*     */     //   #314	-> 2340
/*     */     //   #315	-> 2350
/*     */     //   #316	-> 2350
/*     */     //   #317	-> 2350
/*     */     //   #316	-> 2350
/*     */     //   #317	-> 2350
/*     */     //   #316	-> 2350
/*     */     //   #316	-> 2381
/*     */     //   #316	-> 2398
/*     */     //   #599	-> 2401
/*     */     //   #600	-> 2411
/*     */     //   #601	-> 2427
/*     */     //   #602	-> 2437
/*     */     //   #316	-> 2452
/*     */     //   #316	-> 2477
/*     */     //   #603	-> 2480
/*     */     //   #601	-> 2500
/*     */     //   #607	-> 2503
/*     */     //   #317	-> 2511
/*     */     //   #608	-> 2514
/*     */     //   #609	-> 2518
/*     */     //   #317	-> 2551
/*     */     //   #318	-> 2564
/*     */     //   #319	-> 2566
/*     */     //   #320	-> 2570
/*     */     //   #321	-> 2575
/*     */     //   #322	-> 2575
/*     */     //   #323	-> 2585
/*     */     //   #324	-> 2585
/*     */     //   #323	-> 2585
/*     */     //   #324	-> 2608
/*     */     //   #325	-> 2613
/*     */     //   #326	-> 2613
/*     */     //   #327	-> 2620
/*     */     //   #328	-> 2623
/*     */     //   #329	-> 2631
/*     */     //   #330	-> 2649
/*     */     //   #331	-> 2677
/*     */     //   #332	-> 2685
/*     */     //   #333	-> 2700
/*     */     //   #339	-> 2700
/*     */     //   #333	-> 2702
/*     */     //   #334	-> 2702
/*     */     //   #338	-> 2715
/*     */     //   #334	-> 2715
/*     */     //   #335	-> 2715
/*     */     //   #336	-> 2718
/*     */     //   #335	-> 2730
/*     */     //   #337	-> 2733
/*     */     //   #334	-> 2737
/*     */     //   #338	-> 2740
/*     */     //   #333	-> 2745
/*     */     //   #339	-> 2748
/*     */     //   #342	-> 2752
/*     */     //   #343	-> 2752
/*     */     //   #342	-> 2797
/*     */     //   #344	-> 2799
/*     */     //   #345	-> 2799
/*     */     //   #346	-> 2799
/*     */     //   #345	-> 2799
/*     */     //   #346	-> 2844
/*     */     //   #347	-> 2846
/*     */     //   #348	-> 2854
/*     */     //   #350	-> 2858
/*     */     //   #351	-> 2882
/*     */     //   #352	-> 2905
/*     */     //   #353	-> 2969
/*     */     //   #354	-> 2997
/*     */     //   #294	-> 3004
/*     */     //   #360	-> 3007
/*     */     //   #361	-> 3010
/*     */     //   #362	-> 3043
/*     */     //   #363	-> 3056
/*     */     //   #364	-> 3077
/*     */     //   #365	-> 3080
/*     */     //   #366	-> 3126
/*     */     //   #367	-> 3145
/*     */     //   #371	-> 3145
/*     */     //   #366	-> 3145
/*     */     //   #367	-> 3151
/*     */     //   #368	-> 3155
/*     */     //   #369	-> 3157
/*     */     //   #370	-> 3172
/*     */     //   #367	-> 3177
/*     */     //   #371	-> 3182
/*     */     //   #371	-> 3199
/*     */     //   #371	-> 3206
/*     */     //   #366	-> 3217
/*     */     //   #371	-> 3223
/*     */     //   #372	-> 3223
/*     */     //   #373	-> 3226
/*     */     //   #374	-> 3279
/*     */     //   #375	-> 3282
/*     */     //   #373	-> 3285
/*     */     //   #377	-> 3288
/*     */     //   #378	-> 3305
/*     */     //   #379	-> 3308
/*     */     //   #380	-> 3311
/*     */     //   #381	-> 3312
/*     */     //   #383	-> 3312
/*     */     //   #381	-> 3312
/*     */     //   #383	-> 3312
/*     */     //   #381	-> 3312
/*     */     //   #382	-> 3312
/*     */     //   #381	-> 3312
/*     */     //   #381	-> 3349
/*     */     //   #382	-> 3366
/*     */     //   #610	-> 3369
/*     */     //   #611	-> 3379
/*     */     //   #612	-> 3395
/*     */     //   #613	-> 3405
/*     */     //   #382	-> 3420
/*     */     //   #382	-> 3445
/*     */     //   #614	-> 3448
/*     */     //   #612	-> 3468
/*     */     //   #618	-> 3471
/*     */     //   #383	-> 3479
/*     */     //   #619	-> 3482
/*     */     //   #620	-> 3486
/*     */     //   #383	-> 3519
/*     */     //   #384	-> 3529
/*     */     //   #386	-> 3529
/*     */     //   #384	-> 3529
/*     */     //   #386	-> 3529
/*     */     //   #384	-> 3529
/*     */     //   #385	-> 3529
/*     */     //   #384	-> 3529
/*     */     //   #384	-> 3566
/*     */     //   #385	-> 3583
/*     */     //   #621	-> 3586
/*     */     //   #622	-> 3596
/*     */     //   #623	-> 3612
/*     */     //   #624	-> 3622
/*     */     //   #385	-> 3637
/*     */     //   #385	-> 3662
/*     */     //   #625	-> 3665
/*     */     //   #623	-> 3685
/*     */     //   #629	-> 3688
/*     */     //   #386	-> 3696
/*     */     //   #630	-> 3699
/*     */     //   #631	-> 3703
/*     */     //   #386	-> 3736
/*     */     //   #387	-> 3749
/*     */     //   #388	-> 3751
/*     */     //   #389	-> 3755
/*     */     //   #390	-> 3760
/*     */     //   #391	-> 3760
/*     */     //   #392	-> 3770
/*     */     //   #393	-> 3770
/*     */     //   #392	-> 3770
/*     */     //   #393	-> 3793
/*     */     //   #394	-> 3798
/*     */     //   #395	-> 3798
/*     */     //   #396	-> 3805
/*     */     //   #397	-> 3808
/*     */     //   #398	-> 3816
/*     */     //   #399	-> 3834
/*     */     //   #400	-> 3857
/*     */     //   #401	-> 3865
/*     */     //   #402	-> 3880
/*     */     //   #406	-> 3880
/*     */     //   #402	-> 3882
/*     */     //   #403	-> 3883
/*     */     //   #404	-> 3889
/*     */     //   #405	-> 3896
/*     */     //   #402	-> 3926
/*     */     //   #406	-> 3929
/*     */     //   #409	-> 3933
/*     */     //   #410	-> 3933
/*     */     //   #411	-> 3949
/*     */     //   #414	-> 3949
/*     */     //   #411	-> 3949
/*     */     //   #412	-> 3949
/*     */     //   #413	-> 3995
/*     */     //   #411	-> 4044
/*     */     //   #414	-> 4047
/*     */     //   #415	-> 4051
/*     */     //   #416	-> 4064
/*     */     //   #409	-> 4090
/*     */     //   #418	-> 4093
/*     */     //   #419	-> 4096
/*     */     //   #420	-> 4116
/*     */     //   #421	-> 4119
/*     */     //   #422	-> 4122
/*     */     //   #423	-> 4157
/*     */     //   #424	-> 4160
/*     */     //   #425	-> 4177
/*     */     //   #426	-> 4180
/*     */     //   #425	-> 4232
/*     */     //   #421	-> 4235
/*     */     //   #429	-> 4241
/*     */     //   #430	-> 4244
/*     */     //   #431	-> 4269
/*     */     //   #430	-> 4291
/*     */     //   #429	-> 4294
/*     */     //   #434	-> 4300
/*     */     //   #435	-> 4308
/*     */     //   #436	-> 4311
/*     */     //   #437	-> 4317
/*     */     //   #438	-> 4323
/*     */     //   #439	-> 4327
/*     */     //   #440	-> 4338
/*     */     //   #441	-> 4345
/*     */     //   #442	-> 4352
/*     */     //   #443	-> 4378
/*     */     //   #444	-> 4384
/*     */     //   #445	-> 4386
/*     */     //   #446	-> 4391
/*     */     //   #447	-> 4399
/*     */     //   #448	-> 4411
/*     */     //   #449	-> 4413
/*     */     //   #443	-> 4415
/*     */     //   #451	-> 4418
/*     */     //   #452	-> 4422
/*     */     //   #453	-> 4428
/*     */     //   #454	-> 4434
/*     */     //   #456	-> 4437
/*     */     //   #361	-> 4444
/*     */     //   #459	-> 4447
/*     */     //   #460	-> 4447
/*     */     //   #463	-> 4462
/*     */     //   #464	-> 4475
/*     */     //   #467	-> 4489
/*     */     //   #468	-> 4492
/*     */     //   #469	-> 4564
/*     */     //   #470	-> 4577
/*     */     //   #469	-> 4590
/*     */     //   #470	-> 4613
/*     */     //   #471	-> 4636
/*     */     //   #468	-> 4651
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   100	110	3	Y	F
/*     */     //   97	113	2	H	F
/*     */     //   224	207	3	Y	F
/*     */     //   221	210	2	H	F
/*     */     //   779	7	14	it	Lnet/ccbluex/liquidbounce/utils/PotionData;
/*     */     //   782	4	15	$i$a$-also-NewEffects2$drawElement$1	I
/*     */     //   858	28	12	checkEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   1012	28	17	it	Ljava/lang/String;
/*     */     //   1015	25	18	$i$a$-dropLastWhile-NewEffects2$drawElement$2	I
/*     */     //   990	76	16	iterator$iv	Ljava/util/ListIterator;
/*     */     //   961	108	14	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   964	105	15	$i$f$dropLastWhile	I
/*     */     //   1081	26	16	thisCollection$iv	Ljava/util/Collection;
/*     */     //   1074	33	14	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   1077	30	15	$i$f$toTypedArray	I
/*     */     //   1223	28	17	it	Ljava/lang/String;
/*     */     //   1226	25	18	$i$a$-dropLastWhile-NewEffects2$drawElement$3	I
/*     */     //   1201	76	16	iterator$iv	Ljava/util/ListIterator;
/*     */     //   1172	108	14	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   1175	105	15	$i$f$dropLastWhile	I
/*     */     //   1292	26	16	thisCollection$iv	Ljava/util/Collection;
/*     */     //   1285	33	14	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   1288	30	15	$i$f$toTypedArray	I
/*     */     //   1340	9	14	ignored	Ljava/lang/Exception;
/*     */     //   1656	130	18	posY	F
/*     */     //   1573	213	17	namewith2	I
/*     */     //   1451	335	16	position	I
/*     */     //   1397	389	15	state	F
/*     */     //   1359	427	14	lifeTime	I
/*     */     //   912	874	13	potionMaxTime	I
/*     */     //   909	877	12	potionTime	I
/*     */     //   809	977	11	flag	Z
/*     */     //   659	1127	10	potionData	Lnet/ccbluex/liquidbounce/utils/PotionData;
/*     */     //   656	1130	9	name	Ljava/lang/String;
/*     */     //   635	1151	8	potion	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   618	1168	6	potionEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   2005	7	14	it	Lnet/ccbluex/liquidbounce/utils/PotionData;
/*     */     //   2008	4	15	$i$a$-also-NewEffects2$drawElement$4	I
/*     */     //   2084	28	12	checkEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   2238	28	17	it	Ljava/lang/String;
/*     */     //   2241	25	18	$i$a$-dropLastWhile-NewEffects2$drawElement$5	I
/*     */     //   2216	76	16	iterator$iv	Ljava/util/ListIterator;
/*     */     //   2187	108	14	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   2190	105	15	$i$f$dropLastWhile	I
/*     */     //   2307	26	16	thisCollection$iv	Ljava/util/Collection;
/*     */     //   2300	33	14	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   2303	30	15	$i$f$toTypedArray	I
/*     */     //   2449	28	17	it	Ljava/lang/String;
/*     */     //   2452	25	18	$i$a$-dropLastWhile-NewEffects2$drawElement$6	I
/*     */     //   2427	76	16	iterator$iv	Ljava/util/ListIterator;
/*     */     //   2398	108	14	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   2401	105	15	$i$f$dropLastWhile	I
/*     */     //   2518	26	16	thisCollection$iv	Ljava/util/Collection;
/*     */     //   2511	33	14	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   2514	30	15	$i$f$toTypedArray	I
/*     */     //   2566	9	14	ignored	Ljava/lang/Exception;
/*     */     //   2882	122	18	posY	F
/*     */     //   2799	205	17	namewith2	I
/*     */     //   2677	327	16	position	I
/*     */     //   2623	381	15	state	F
/*     */     //   2585	419	14	lifeTime	I
/*     */     //   2138	866	13	potionMaxTime	I
/*     */     //   2135	869	12	potionTime	I
/*     */     //   2035	969	11	flag	Z
/*     */     //   1885	1119	10	potionData	Lnet/ccbluex/liquidbounce/utils/PotionData;
/*     */     //   1882	1122	9	name	Ljava/lang/String;
/*     */     //   1861	1143	8	potion	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   1844	1160	6	potionEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   3196	7	15	it	Lnet/ccbluex/liquidbounce/utils/render/PotionData;
/*     */     //   3199	4	16	$i$a$-also-NewEffects2$drawElement$7	I
/*     */     //   3259	26	13	checkEffect	Lnet/minecraft/potion/PotionEffect;
/*     */     //   3417	28	18	it	Ljava/lang/String;
/*     */     //   3420	25	19	$i$a$-dropLastWhile-NewEffects2$drawElement$8	I
/*     */     //   3395	76	17	iterator$iv	Ljava/util/ListIterator;
/*     */     //   3366	108	15	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   3369	105	16	$i$f$dropLastWhile	I
/*     */     //   3486	26	17	thisCollection$iv	Ljava/util/Collection;
/*     */     //   3479	33	15	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   3482	30	16	$i$f$toTypedArray	I
/*     */     //   3634	28	18	it	Ljava/lang/String;
/*     */     //   3637	25	19	$i$a$-dropLastWhile-NewEffects2$drawElement$9	I
/*     */     //   3612	76	17	iterator$iv	Ljava/util/ListIterator;
/*     */     //   3583	108	15	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   3586	105	16	$i$f$dropLastWhile	I
/*     */     //   3703	26	17	thisCollection$iv	Ljava/util/Collection;
/*     */     //   3696	33	15	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   3699	30	16	$i$f$toTypedArray	I
/*     */     //   3751	9	15	ignored	Ljava/lang/Exception;
/*     */     //   4352	85	19	statusIconIndex	I
/*     */     //   4116	328	18	posY	F
/*     */     //   3857	587	17	position	I
/*     */     //   3808	636	16	state	F
/*     */     //   3770	674	15	lifeTime	I
/*     */     //   3311	1133	14	potionMaxTime	I
/*     */     //   3308	1136	13	potionTime	I
/*     */     //   3226	1218	12	flag	Z
/*     */     //   3080	1364	11	potionData	Lnet/ccbluex/liquidbounce/utils/render/PotionData;
/*     */     //   3077	1367	10	name	Ljava/lang/String;
/*     */     //   3056	1388	9	potion	Lnet/minecraft/potion/Potion;
/*     */     //   3043	1401	7	potionEffect	Lnet/minecraft/potion/PotionEffect;
/*     */     //   3010	1437	6	y	I
/*     */     //   443	4209	4	y	I
/*     */     //   440	4212	3	namehight	F
/*     */     //   438	4214	2	namewith3	F
/*     */     //   436	4216	1	namewith	F
/*     */     //   0	4652	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   912	1335	1338	java/lang/Exception
/*     */     //   2138	2561	2564	java/lang/Exception
/*     */     //   3311	3746	3749	java/lang/Exception
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
/*     */   public final void updateAnimwith(float easing) {
/* 476 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - this.easingwith, f3 = this.easingwith; NewEffects2 newEffects2 = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); newEffects2.easingwith = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 478 */     if (!this.timer.hasTimePassed(2L)) {
/*     */       return;
/*     */     }
/*     */     
/* 482 */     this.backamin += true;
/*     */ 
/*     */ 
/*     */     
/* 486 */     this.timer.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateAnimhealth(float easing) {
/* 491 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - this.easinghealth, f3 = this.easinghealth; NewEffects2 newEffects2 = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); newEffects2.easinghealth = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 493 */     if (!this.timer.hasTimePassed(2L)) {
/*     */       return;
/*     */     }
/* 496 */     this.healthamin += true;
/*     */     
/* 498 */     this.timer.reset();
/*     */   }
/*     */   
/*     */   private final String intToRomanByGreedy(int num) {
/* 502 */     int j = num;
/* 503 */     int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/* 504 */     String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/* 505 */     StringBuilder stringBuilder = new StringBuilder();
/* 506 */     int i = 0;
/* 507 */     while (i < values.length && j >= 0) {
/* 508 */       while (values[i] <= j) {
/* 509 */         j -= values[i];
/* 510 */         stringBuilder.append(symbols[i]);
/*     */       } 
/* 512 */       i++;
/*     */     } 
/* 514 */     Intrinsics.checkExpressionValueIsNotNull(stringBuilder.toString(), "stringBuilder.toString()"); return stringBuilder.toString();
/*     */   }
/*     */   private final double getAnimationState(double animation, double finalState, double speed) {
/* 517 */     double d = animation;
/* 518 */     float add = (float)(0.01D * speed);
/* 519 */     if (d < finalState)
/* 520 */     { if (d + add < finalState) { d += add; } else { d = finalState; }
/*     */        }
/* 522 */     else if (d - add > finalState) { d -= add; } else { d = finalState; }
/*     */     
/* 524 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 529 */   public static final Companion Companion = new Companion(null); static { novoshadow = new BoolValue("Shadow", false); } public NewEffects2() { this(0.0D, 0.0D, 0.0F, 7, null); } @JvmStatic public static final int reAlpha(int n, float n2) { return Companion.reAlpha(n, n2); }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\007\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\005\032\0020\0062\006\020\007\032\0020\006J\030\020\b\032\0020\0062\006\020\007\032\0020\0062\006\020\t\032\0020\nH\007R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects2$Companion;", "", "()V", "novoshadow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "rainbow", "", "n", "reAlpha", "n2", "", "XSJClient"}) public static final class Companion { private Companion() {}
/* 531 */     public final int rainbow(int n) { Intrinsics.checkExpressionValueIsNotNull(Color.getHSBColor(
/* 532 */             (float)(Math.ceil((System.currentTimeMillis() + n) / 10.0D) % 360.0D / 360.0D), 
/* 533 */             0.5F, 
/* 534 */             1.0F), "Color.getHSBColor(\n     …       1.0f\n            )"); return Color.getHSBColor((float)(Math.ceil((System.currentTimeMillis() + n) / 10.0D) % 360.0D / 360.0D), 0.5F, 1.0F).getRGB(); }
/*     */ 
/*     */     
/*     */     @JvmStatic
/*     */     public final int reAlpha(int n, float n2) {
/* 539 */       Color color = new Color(n);
/* 540 */       return (new Color(0.003921569F * color.getRed(), 0.003921569F * color.getGreen(), 0.003921569F * color.getBlue(), n2)).getRGB();
/*     */     } }
/*     */    }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\NewEffects2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */