/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import java.util.HashMap;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.PotionData;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Effects")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000j\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\013\n\002\030\002\n\002\b\n\n\002\020%\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\b\n\000\n\002\020\002\n\002\b\003\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\0201\032\00202H\026J\020\0203\032\002042\006\0205\032\00206H\002J\016\0207\032\002082\006\0209\032\0020\006J\016\020:\032\002082\006\0209\032\0020\006R\016\020\b\032\0020\tX\004¢\006\002\n\000R\032\020\n\032\0020\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\016\020\020\032\0020\013X\004¢\006\002\n\000R\032\020\021\032\0020\006X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025R\016\020\026\032\0020\027X\004¢\006\002\n\000R\032\020\030\032\0020\006X\016¢\006\016\n\000\032\004\b\031\020\023\"\004\b\032\020\025R\032\020\033\032\0020\006X\016¢\006\016\n\000\032\004\b\034\020\023\"\004\b\035\020\025R\032\020\036\032\0020\006X\016¢\006\016\n\000\032\004\b\037\020\023\"\004\b \020\025R\034\020!\032\020\022\004\022\0020#\022\006\022\004\030\0010$0\"X\004¢\006\002\n\000R\016\020%\032\0020\tX\004¢\006\002\n\000R\016\020&\032\0020'X\004¢\006\002\n\000R\016\020(\032\0020\tX\004¢\006\002\n\000R\021\020)\032\0020\013¢\006\b\n\000\032\004\b*\020\rR\032\020+\032\0020,X\016¢\006\016\n\000\032\004\b-\020.\"\004\b/\0200¨\006;"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Effects;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "Chinese", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getChinese", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "setChinese", "(Lnet/ccbluex/liquidbounce/value/BoolValue;)V", "bV", "backamin", "getBackamin", "()F", "setBackamin", "(F)V", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "easinghealth", "getEasinghealth", "setEasinghealth", "easingwith", "getEasingwith", "setEasingwith", "healthamin", "getHealthamin", "setHealthamin", "potionMap", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "Lnet/ccbluex/liquidbounce/utils/PotionData;", "radiusValue", "shadowColorMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "shadowValue", "shadowValueopen", "getShadowValueopen", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "setTimer", "(Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;)V", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "intToRomanByGreedy", "", "num", "", "updateAnimhealth", "", "easing", "updateAnimwith", "XSJClient"})
/*     */ public final class Effects extends Element {
/*     */   public Effects(double x, double y, float scale) {
/*  27 */     super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */     
/*  29 */     this.potionMap = new HashMap<>();
/*  30 */     this.bV = new BoolValue("Blur", true);
/*  31 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  32 */     this.shadowValueopen = new BoolValue("shadow", true);
/*  33 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*  34 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Custom" }, "Background");
/*  35 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  36 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/*  37 */     this.Chinese = new BoolValue("中文", true);
/*  38 */     this.timer = new MSTimer();
/*     */   }
/*     */   private final Map<IPotion, PotionData> potionMap; private final BoolValue bV; private final FloatValue BlurStrength; @NotNull
/*     */   private final BoolValue shadowValueopen; private final FloatValue shadowValue;
/*     */   private final ListValue shadowColorMode;
/*     */   private final IntegerValue bgValue;
/*     */   private final FloatValue radiusValue;
/*     */   @NotNull
/*     */   private BoolValue Chinese;
/*     */   @NotNull
/*     */   private MSTimer timer;
/*     */   private float easingwith;
/*     */   private float backamin;
/*     */   private float easinghealth;
/*     */   private float healthamin;
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Effects$drawElement$1 extends Lambda implements Function0<Unit> {
/*     */     Effects$drawElement$1() {
/*     */       super(0);
/*     */     }
/*     */     
/*  60 */     public final void invoke() { GL11.glPushMatrix();
/*  61 */       GL11.glTranslated(Effects.this.getRenderX(), Effects.this.getRenderY(), 0.0D);
/*  62 */       GL11.glScalef(Effects.this.getScale(), Effects.this.getScale(), Effects.this.getScale());
/*     */       
/*  64 */       RenderUtils.originalRoundedRect(
/*  65 */           12.2F, -7.32F, Effects.this.getEasingwith() + 12.2F, Effects.this.getEasinghealth() + -7.32F, ((Number)Effects.this.radiusValue.get()).floatValue(), 
/*  66 */           StringsKt.equals((String)Effects.this.shadowColorMode.get(), "background", true) ? (
/*  67 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/*  69 */           new Color(0, 0, 0)).getRGB());
/*     */       
/*  71 */       GL11.glPopMatrix(); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Effects$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/*  73 */       GL11.glPushMatrix();
/*  74 */       GL11.glTranslated(Effects.this.getRenderX(), Effects.this.getRenderY(), 0.0D);
/*  75 */       GL11.glScalef(Effects.this.getScale(), Effects.this.getScale(), Effects.this.getScale());
/*  76 */       GlStateManager.func_179147_l();
/*  77 */       GlStateManager.func_179090_x();
/*  78 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  79 */       RenderUtils.fastRoundedRect(12.2F, -7.32F, Effects.this.getEasingwith() + 12.2F, Effects.this.getEasinghealth() + -7.32F, ((Number)Effects.this.radiusValue.get()).floatValue());
/*  80 */       GlStateManager.func_179098_w();
/*  81 */       GlStateManager.func_179084_k();
/*  82 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Effects$drawElement$2() {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getShadowValueopen() {
/*     */     return this.shadowValueopen;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getChinese() {
/*     */     return this.Chinese;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setChinese(@NotNull BoolValue <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.Chinese = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final MSTimer getTimer() {
/*     */     return this.timer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setTimer(@NotNull MSTimer <set-?>) {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     this.timer = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getEasingwith() {
/*     */     return this.easingwith;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setEasingwith(float <set-?>) {
/*     */     this.easingwith = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getBackamin() {
/*     */     return this.backamin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setBackamin(float <set-?>) {
/*     */     this.backamin = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getEasinghealth() {
/*     */     return this.easinghealth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setEasinghealth(float <set-?>) {
/*     */     this.easinghealth = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getHealthamin() {
/*     */     return this.healthamin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setHealthamin(float <set-?>) {
/*     */     this.healthamin = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public Border drawElement() {
/*     */     // Byte code:
/*     */     //   0: ldc 12.2
/*     */     //   2: ldc -7.32
/*     */     //   4: aload_0
/*     */     //   5: getfield easingwith : F
/*     */     //   8: ldc 12.2
/*     */     //   10: fadd
/*     */     //   11: aload_0
/*     */     //   12: getfield easinghealth : F
/*     */     //   15: ldc -7.32
/*     */     //   17: fadd
/*     */     //   18: aload_0
/*     */     //   19: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   22: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   25: checkcast java/lang/Number
/*     */     //   28: invokevirtual floatValue : ()F
/*     */     //   31: new java/awt/Color
/*     */     //   34: dup
/*     */     //   35: iconst_0
/*     */     //   36: iconst_0
/*     */     //   37: iconst_0
/*     */     //   38: aload_0
/*     */     //   39: getfield bgValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   42: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   45: checkcast java/lang/Number
/*     */     //   48: invokevirtual intValue : ()I
/*     */     //   51: invokespecial <init> : (IIII)V
/*     */     //   54: invokevirtual getRGB : ()I
/*     */     //   57: invokestatic drawRoundedRect : (FFFFFI)V
/*     */     //   60: aload_0
/*     */     //   61: invokevirtual getRenderX : ()D
/*     */     //   64: dneg
/*     */     //   65: aload_0
/*     */     //   66: invokevirtual getRenderY : ()D
/*     */     //   69: dneg
/*     */     //   70: dconst_0
/*     */     //   71: invokestatic glTranslated : (DDD)V
/*     */     //   74: fconst_1
/*     */     //   75: fconst_1
/*     */     //   76: fconst_1
/*     */     //   77: invokestatic glScalef : (FFF)V
/*     */     //   80: invokestatic glPushMatrix : ()V
/*     */     //   83: aload_0
/*     */     //   84: getfield shadowValueopen : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   87: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   90: checkcast java/lang/Boolean
/*     */     //   93: invokevirtual booleanValue : ()Z
/*     */     //   96: ifeq -> 137
/*     */     //   99: aload_0
/*     */     //   100: getfield shadowValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   103: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   106: checkcast java/lang/Number
/*     */     //   109: invokevirtual floatValue : ()F
/*     */     //   112: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Effects$drawElement$1
/*     */     //   115: dup
/*     */     //   116: aload_0
/*     */     //   117: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Effects;)V
/*     */     //   120: checkcast kotlin/jvm/functions/Function0
/*     */     //   123: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Effects$drawElement$2
/*     */     //   126: dup
/*     */     //   127: aload_0
/*     */     //   128: invokespecial <init> : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Effects;)V
/*     */     //   131: checkcast kotlin/jvm/functions/Function0
/*     */     //   134: invokestatic shadow : (FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V
/*     */     //   137: invokestatic glPopMatrix : ()V
/*     */     //   140: aload_0
/*     */     //   141: invokevirtual getScale : ()F
/*     */     //   144: aload_0
/*     */     //   145: invokevirtual getScale : ()F
/*     */     //   148: aload_0
/*     */     //   149: invokevirtual getScale : ()F
/*     */     //   152: invokestatic glScalef : (FFF)V
/*     */     //   155: aload_0
/*     */     //   156: invokevirtual getRenderX : ()D
/*     */     //   159: aload_0
/*     */     //   160: invokevirtual getRenderY : ()D
/*     */     //   163: dconst_0
/*     */     //   164: invokestatic glTranslated : (DDD)V
/*     */     //   167: aload_0
/*     */     //   168: getfield bV : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   171: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   174: checkcast java/lang/Boolean
/*     */     //   177: invokevirtual booleanValue : ()Z
/*     */     //   180: ifeq -> 268
/*     */     //   183: aload_0
/*     */     //   184: invokevirtual getRenderX : ()D
/*     */     //   187: dneg
/*     */     //   188: aload_0
/*     */     //   189: invokevirtual getRenderY : ()D
/*     */     //   192: dneg
/*     */     //   193: dconst_0
/*     */     //   194: invokestatic glTranslated : (DDD)V
/*     */     //   197: invokestatic glPushMatrix : ()V
/*     */     //   200: aload_0
/*     */     //   201: invokevirtual getRenderX : ()D
/*     */     //   204: d2f
/*     */     //   205: ldc 12.2
/*     */     //   207: fadd
/*     */     //   208: aload_0
/*     */     //   209: invokevirtual getRenderY : ()D
/*     */     //   212: d2f
/*     */     //   213: ldc 7.32
/*     */     //   215: fsub
/*     */     //   216: aload_0
/*     */     //   217: getfield easingwith : F
/*     */     //   220: aload_0
/*     */     //   221: getfield easinghealth : F
/*     */     //   224: aload_0
/*     */     //   225: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   228: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   231: checkcast java/lang/Number
/*     */     //   234: invokevirtual floatValue : ()F
/*     */     //   237: aload_0
/*     */     //   238: getfield BlurStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   241: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   244: checkcast java/lang/Number
/*     */     //   247: invokevirtual floatValue : ()F
/*     */     //   250: invokestatic CustomBlurRoundArea : (FFFFFF)V
/*     */     //   253: invokestatic glPopMatrix : ()V
/*     */     //   256: aload_0
/*     */     //   257: invokevirtual getRenderX : ()D
/*     */     //   260: aload_0
/*     */     //   261: invokevirtual getRenderY : ()D
/*     */     //   264: dconst_0
/*     */     //   265: invokestatic glTranslated : (DDD)V
/*     */     //   268: invokestatic func_179094_E : ()V
/*     */     //   271: invokestatic func_179117_G : ()V
/*     */     //   274: fconst_0
/*     */     //   275: fstore_1
/*     */     //   276: fconst_0
/*     */     //   277: fstore_2
/*     */     //   278: fconst_0
/*     */     //   279: fstore_3
/*     */     //   280: iconst_0
/*     */     //   281: istore #4
/*     */     //   283: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   286: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   291: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   294: dup
/*     */     //   295: ifnonnull -> 301
/*     */     //   298: invokestatic throwNpe : ()V
/*     */     //   301: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP
/*     */     //   304: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   309: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   314: astore #6
/*     */     //   316: aload #6
/*     */     //   318: invokeinterface hasNext : ()Z
/*     */     //   323: ifeq -> 1922
/*     */     //   326: aload #6
/*     */     //   328: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   333: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   336: astore #5
/*     */     //   338: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   341: aload #5
/*     */     //   343: invokeinterface getPotionID : ()I
/*     */     //   348: invokeinterface getPotionById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   353: astore #7
/*     */     //   355: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   358: aload #7
/*     */     //   360: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   365: iconst_0
/*     */     //   366: anewarray java/lang/String
/*     */     //   369: invokeinterface formatI18n : (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
/*     */     //   374: astore #8
/*     */     //   376: aconst_null
/*     */     //   377: astore #9
/*     */     //   379: aload_0
/*     */     //   380: getfield potionMap : Ljava/util/Map;
/*     */     //   383: aload #7
/*     */     //   385: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   390: ifeq -> 446
/*     */     //   393: aload_0
/*     */     //   394: getfield potionMap : Ljava/util/Map;
/*     */     //   397: aload #7
/*     */     //   399: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   404: dup
/*     */     //   405: ifnonnull -> 411
/*     */     //   408: invokestatic throwNpe : ()V
/*     */     //   411: checkcast net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   414: getfield level : I
/*     */     //   417: aload #5
/*     */     //   419: invokeinterface getAmplifier : ()I
/*     */     //   424: if_icmpne -> 446
/*     */     //   427: aload_0
/*     */     //   428: getfield potionMap : Ljava/util/Map;
/*     */     //   431: aload #7
/*     */     //   433: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   438: checkcast net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   441: astore #9
/*     */     //   443: goto -> 526
/*     */     //   446: aload_0
/*     */     //   447: getfield potionMap : Ljava/util/Map;
/*     */     //   450: aload #7
/*     */     //   452: new net/ccbluex/liquidbounce/utils/PotionData
/*     */     //   455: dup
/*     */     //   456: aload #7
/*     */     //   458: new net/ccbluex/liquidbounce/utils/Translate
/*     */     //   461: dup
/*     */     //   462: fconst_0
/*     */     //   463: ldc_w -40.0
/*     */     //   466: iload #4
/*     */     //   468: i2f
/*     */     //   469: fadd
/*     */     //   470: invokespecial <init> : (FF)V
/*     */     //   473: aload #5
/*     */     //   475: invokeinterface getAmplifier : ()I
/*     */     //   480: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;Lnet/ccbluex/liquidbounce/utils/Translate;I)V
/*     */     //   483: astore #10
/*     */     //   485: astore #21
/*     */     //   487: astore #20
/*     */     //   489: iconst_0
/*     */     //   490: istore #11
/*     */     //   492: iconst_0
/*     */     //   493: istore #12
/*     */     //   495: aload #10
/*     */     //   497: astore #13
/*     */     //   499: iconst_0
/*     */     //   500: istore #14
/*     */     //   502: aload #13
/*     */     //   504: astore #9
/*     */     //   506: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
/*     */     //   509: pop
/*     */     //   510: aload #10
/*     */     //   512: astore #22
/*     */     //   514: aload #20
/*     */     //   516: aload #21
/*     */     //   518: aload #22
/*     */     //   520: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   525: pop
/*     */     //   526: iconst_1
/*     */     //   527: istore #10
/*     */     //   529: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   532: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   537: dup
/*     */     //   538: ifnonnull -> 544
/*     */     //   541: invokestatic throwNpe : ()V
/*     */     //   544: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   549: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   554: astore #12
/*     */     //   556: aload #12
/*     */     //   558: invokeinterface hasNext : ()Z
/*     */     //   563: ifeq -> 609
/*     */     //   566: aload #12
/*     */     //   568: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   573: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   576: astore #11
/*     */     //   578: aload #11
/*     */     //   580: invokeinterface getAmplifier : ()I
/*     */     //   585: aload #9
/*     */     //   587: dup
/*     */     //   588: ifnonnull -> 594
/*     */     //   591: invokestatic throwNpe : ()V
/*     */     //   594: getfield level : I
/*     */     //   597: if_icmpne -> 606
/*     */     //   600: iconst_0
/*     */     //   601: istore #10
/*     */     //   603: goto -> 609
/*     */     //   606: goto -> 556
/*     */     //   609: iload #10
/*     */     //   611: ifeq -> 626
/*     */     //   614: aload_0
/*     */     //   615: getfield potionMap : Ljava/util/Map;
/*     */     //   618: aload #7
/*     */     //   620: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   625: pop
/*     */     //   626: iconst_0
/*     */     //   627: istore #11
/*     */     //   629: iconst_0
/*     */     //   630: istore #12
/*     */     //   632: nop
/*     */     //   633: aload #5
/*     */     //   635: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   640: checkcast java/lang/CharSequence
/*     */     //   643: astore #13
/*     */     //   645: ldc_w ':'
/*     */     //   648: astore #14
/*     */     //   650: iconst_0
/*     */     //   651: istore #15
/*     */     //   653: new kotlin/text/Regex
/*     */     //   656: dup
/*     */     //   657: aload #14
/*     */     //   659: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   662: astore #14
/*     */     //   664: iconst_0
/*     */     //   665: istore #15
/*     */     //   667: iconst_0
/*     */     //   668: istore #16
/*     */     //   670: aload #14
/*     */     //   672: aload #13
/*     */     //   674: iload #15
/*     */     //   676: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   679: astore #13
/*     */     //   681: iconst_0
/*     */     //   682: istore #14
/*     */     //   684: aload #13
/*     */     //   686: invokeinterface isEmpty : ()Z
/*     */     //   691: ifne -> 786
/*     */     //   694: aload #13
/*     */     //   696: aload #13
/*     */     //   698: invokeinterface size : ()I
/*     */     //   703: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   708: astore #15
/*     */     //   710: aload #15
/*     */     //   712: invokeinterface hasPrevious : ()Z
/*     */     //   717: ifeq -> 786
/*     */     //   720: aload #15
/*     */     //   722: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   727: checkcast java/lang/String
/*     */     //   730: astore #16
/*     */     //   732: iconst_0
/*     */     //   733: istore #17
/*     */     //   735: aload #16
/*     */     //   737: checkcast java/lang/CharSequence
/*     */     //   740: astore #18
/*     */     //   742: iconst_0
/*     */     //   743: istore #19
/*     */     //   745: aload #18
/*     */     //   747: invokeinterface length : ()I
/*     */     //   752: ifne -> 759
/*     */     //   755: iconst_1
/*     */     //   756: goto -> 760
/*     */     //   759: iconst_0
/*     */     //   760: ifne -> 783
/*     */     //   763: aload #13
/*     */     //   765: checkcast java/lang/Iterable
/*     */     //   768: aload #15
/*     */     //   770: invokeinterface nextIndex : ()I
/*     */     //   775: iconst_1
/*     */     //   776: iadd
/*     */     //   777: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   780: goto -> 789
/*     */     //   783: goto -> 710
/*     */     //   786: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   789: checkcast java/util/Collection
/*     */     //   792: astore #13
/*     */     //   794: iconst_0
/*     */     //   795: istore #14
/*     */     //   797: aload #13
/*     */     //   799: astore #15
/*     */     //   801: aload #15
/*     */     //   803: iconst_0
/*     */     //   804: anewarray java/lang/String
/*     */     //   807: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   812: dup
/*     */     //   813: ifnonnull -> 827
/*     */     //   816: new kotlin/TypeCastException
/*     */     //   819: dup
/*     */     //   820: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   823: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   826: athrow
/*     */     //   827: checkcast [Ljava/lang/String;
/*     */     //   830: iconst_0
/*     */     //   831: aaload
/*     */     //   832: astore #13
/*     */     //   834: iconst_0
/*     */     //   835: istore #14
/*     */     //   837: aload #13
/*     */     //   839: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   842: istore #11
/*     */     //   844: aload #5
/*     */     //   846: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   851: checkcast java/lang/CharSequence
/*     */     //   854: astore #13
/*     */     //   856: ldc_w ':'
/*     */     //   859: astore #14
/*     */     //   861: iconst_0
/*     */     //   862: istore #15
/*     */     //   864: new kotlin/text/Regex
/*     */     //   867: dup
/*     */     //   868: aload #14
/*     */     //   870: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   873: astore #14
/*     */     //   875: iconst_0
/*     */     //   876: istore #15
/*     */     //   878: iconst_0
/*     */     //   879: istore #16
/*     */     //   881: aload #14
/*     */     //   883: aload #13
/*     */     //   885: iload #15
/*     */     //   887: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   890: astore #13
/*     */     //   892: iconst_0
/*     */     //   893: istore #14
/*     */     //   895: aload #13
/*     */     //   897: invokeinterface isEmpty : ()Z
/*     */     //   902: ifne -> 997
/*     */     //   905: aload #13
/*     */     //   907: aload #13
/*     */     //   909: invokeinterface size : ()I
/*     */     //   914: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   919: astore #15
/*     */     //   921: aload #15
/*     */     //   923: invokeinterface hasPrevious : ()Z
/*     */     //   928: ifeq -> 997
/*     */     //   931: aload #15
/*     */     //   933: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   938: checkcast java/lang/String
/*     */     //   941: astore #16
/*     */     //   943: iconst_0
/*     */     //   944: istore #17
/*     */     //   946: aload #16
/*     */     //   948: checkcast java/lang/CharSequence
/*     */     //   951: astore #18
/*     */     //   953: iconst_0
/*     */     //   954: istore #19
/*     */     //   956: aload #18
/*     */     //   958: invokeinterface length : ()I
/*     */     //   963: ifne -> 970
/*     */     //   966: iconst_1
/*     */     //   967: goto -> 971
/*     */     //   970: iconst_0
/*     */     //   971: ifne -> 994
/*     */     //   974: aload #13
/*     */     //   976: checkcast java/lang/Iterable
/*     */     //   979: aload #15
/*     */     //   981: invokeinterface nextIndex : ()I
/*     */     //   986: iconst_1
/*     */     //   987: iadd
/*     */     //   988: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   991: goto -> 1000
/*     */     //   994: goto -> 921
/*     */     //   997: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   1000: checkcast java/util/Collection
/*     */     //   1003: astore #13
/*     */     //   1005: iconst_0
/*     */     //   1006: istore #14
/*     */     //   1008: aload #13
/*     */     //   1010: astore #15
/*     */     //   1012: aload #15
/*     */     //   1014: iconst_0
/*     */     //   1015: anewarray java/lang/String
/*     */     //   1018: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   1023: dup
/*     */     //   1024: ifnonnull -> 1038
/*     */     //   1027: new kotlin/TypeCastException
/*     */     //   1030: dup
/*     */     //   1031: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   1034: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1037: athrow
/*     */     //   1038: checkcast [Ljava/lang/String;
/*     */     //   1041: iconst_1
/*     */     //   1042: aaload
/*     */     //   1043: astore #13
/*     */     //   1045: iconst_0
/*     */     //   1046: istore #14
/*     */     //   1048: aload #13
/*     */     //   1050: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   1053: istore #12
/*     */     //   1055: goto -> 1069
/*     */     //   1058: astore #13
/*     */     //   1060: bipush #100
/*     */     //   1062: istore #11
/*     */     //   1064: sipush #1000
/*     */     //   1067: istore #12
/*     */     //   1069: iload #11
/*     */     //   1071: bipush #60
/*     */     //   1073: imul
/*     */     //   1074: iload #12
/*     */     //   1076: iadd
/*     */     //   1077: istore #13
/*     */     //   1079: aload #9
/*     */     //   1081: dup
/*     */     //   1082: ifnonnull -> 1088
/*     */     //   1085: invokestatic throwNpe : ()V
/*     */     //   1088: invokevirtual getMaxTimer : ()I
/*     */     //   1091: ifeq -> 1107
/*     */     //   1094: iload #13
/*     */     //   1096: i2d
/*     */     //   1097: aload #9
/*     */     //   1099: invokevirtual getMaxTimer : ()I
/*     */     //   1102: i2d
/*     */     //   1103: dcmpl
/*     */     //   1104: ifle -> 1114
/*     */     //   1107: aload #9
/*     */     //   1109: iload #13
/*     */     //   1111: putfield maxTimer : I
/*     */     //   1114: fconst_0
/*     */     //   1115: fstore #14
/*     */     //   1117: iload #13
/*     */     //   1119: i2d
/*     */     //   1120: dconst_0
/*     */     //   1121: dcmpl
/*     */     //   1122: iflt -> 1143
/*     */     //   1125: iload #13
/*     */     //   1127: i2d
/*     */     //   1128: aload #9
/*     */     //   1130: invokevirtual getMaxTimer : ()I
/*     */     //   1133: i2f
/*     */     //   1134: f2d
/*     */     //   1135: ddiv
/*     */     //   1136: ldc2_w 100.0
/*     */     //   1139: dmul
/*     */     //   1140: d2f
/*     */     //   1141: fstore #14
/*     */     //   1143: aload #9
/*     */     //   1145: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1148: dup
/*     */     //   1149: ldc_w 'potionData.translate'
/*     */     //   1152: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1155: invokevirtual getY : ()F
/*     */     //   1158: ldc_w 1.4
/*     */     //   1161: fdiv
/*     */     //   1162: ldc_w 7.22
/*     */     //   1165: fsub
/*     */     //   1166: invokestatic round : (F)I
/*     */     //   1169: istore #15
/*     */     //   1171: fload #14
/*     */     //   1173: fconst_2
/*     */     //   1174: invokestatic max : (FF)F
/*     */     //   1177: fstore #14
/*     */     //   1179: aload #9
/*     */     //   1181: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1184: fconst_0
/*     */     //   1185: iload #4
/*     */     //   1187: i2f
/*     */     //   1188: ldc2_w 0.1
/*     */     //   1191: invokevirtual interpolate : (FFD)V
/*     */     //   1194: aload #9
/*     */     //   1196: aload #9
/*     */     //   1198: invokevirtual getAnimationX : ()F
/*     */     //   1201: f2d
/*     */     //   1202: ldc_w 1.2
/*     */     //   1205: fload #14
/*     */     //   1207: fmul
/*     */     //   1208: f2d
/*     */     //   1209: ldc_w 10.0
/*     */     //   1212: aload #9
/*     */     //   1214: getfield animationX : F
/*     */     //   1217: ldc_w 1.2
/*     */     //   1220: fload #14
/*     */     //   1222: fmul
/*     */     //   1223: fsub
/*     */     //   1224: invokestatic abs : (F)F
/*     */     //   1227: ldc_w 15.0
/*     */     //   1230: fmul
/*     */     //   1231: invokestatic max : (FF)F
/*     */     //   1234: ldc_w 0.3
/*     */     //   1237: fmul
/*     */     //   1238: f2d
/*     */     //   1239: invokestatic getAnimationState2 : (DDD)D
/*     */     //   1242: d2f
/*     */     //   1243: putfield animationX : F
/*     */     //   1246: aload_0
/*     */     //   1247: getfield Chinese : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1250: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1253: checkcast java/lang/Boolean
/*     */     //   1256: invokevirtual booleanValue : ()Z
/*     */     //   1259: ifeq -> 1502
/*     */     //   1262: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.F18 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1265: new java/lang/StringBuilder
/*     */     //   1268: dup
/*     */     //   1269: invokespecial <init> : ()V
/*     */     //   1272: aload #8
/*     */     //   1274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1277: ldc_w ' '
/*     */     //   1280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1283: aload_0
/*     */     //   1284: aload #5
/*     */     //   1286: invokeinterface getAmplifier : ()I
/*     */     //   1291: iconst_1
/*     */     //   1292: iadd
/*     */     //   1293: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1299: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1302: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   1305: i2f
/*     */     //   1306: fstore #16
/*     */     //   1308: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.F18 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1311: new java/lang/StringBuilder
/*     */     //   1314: dup
/*     */     //   1315: invokespecial <init> : ()V
/*     */     //   1318: aload #8
/*     */     //   1320: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1323: ldc_w ' '
/*     */     //   1326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1329: aload_0
/*     */     //   1330: aload #5
/*     */     //   1332: invokeinterface getAmplifier : ()I
/*     */     //   1337: iconst_1
/*     */     //   1338: iadd
/*     */     //   1339: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1345: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1348: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   1351: i2f
/*     */     //   1352: fstore_1
/*     */     //   1353: fload #16
/*     */     //   1355: fload_2
/*     */     //   1356: fcmpl
/*     */     //   1357: ifle -> 1363
/*     */     //   1360: fload #16
/*     */     //   1362: fstore_2
/*     */     //   1363: aload #9
/*     */     //   1365: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1368: dup
/*     */     //   1369: ldc_w 'potionData.translate'
/*     */     //   1372: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1375: invokevirtual getY : ()F
/*     */     //   1378: ldc_w 2.5
/*     */     //   1381: fdiv
/*     */     //   1382: fstore #17
/*     */     //   1384: aload #9
/*     */     //   1386: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1389: dup
/*     */     //   1390: ldc_w 'potionData.translate'
/*     */     //   1393: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1396: invokevirtual getY : ()F
/*     */     //   1399: ldc_w 2.5
/*     */     //   1402: fdiv
/*     */     //   1403: ldc_w 8.0
/*     */     //   1406: fsub
/*     */     //   1407: fstore_3
/*     */     //   1408: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.F18 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1411: new java/lang/StringBuilder
/*     */     //   1414: dup
/*     */     //   1415: invokespecial <init> : ()V
/*     */     //   1418: aload #8
/*     */     //   1420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1423: ldc_w ' '
/*     */     //   1426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1429: aload_0
/*     */     //   1430: aload #5
/*     */     //   1432: invokeinterface getAmplifier : ()I
/*     */     //   1437: iconst_1
/*     */     //   1438: iadd
/*     */     //   1439: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1445: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1448: ldc_w 29.0
/*     */     //   1451: fload #17
/*     */     //   1453: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1456: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1461: invokeinterface getFontHeight : ()I
/*     */     //   1466: i2f
/*     */     //   1467: fsub
/*     */     //   1468: fneg
/*     */     //   1469: iconst_m1
/*     */     //   1470: invokevirtual drawString : (Ljava/lang/String;FFI)V
/*     */     //   1473: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.F18 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1476: aload #5
/*     */     //   1478: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   1483: fload_1
/*     */     //   1484: bipush #32
/*     */     //   1486: i2f
/*     */     //   1487: fadd
/*     */     //   1488: fload #17
/*     */     //   1490: ldc_w 9.0
/*     */     //   1493: fsub
/*     */     //   1494: fneg
/*     */     //   1495: iconst_m1
/*     */     //   1496: invokevirtual drawString : (Ljava/lang/String;FFI)V
/*     */     //   1499: goto -> 1749
/*     */     //   1502: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.posterama30 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1505: new java/lang/StringBuilder
/*     */     //   1508: dup
/*     */     //   1509: invokespecial <init> : ()V
/*     */     //   1512: aload #8
/*     */     //   1514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1517: ldc_w ' '
/*     */     //   1520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1523: aload_0
/*     */     //   1524: aload #5
/*     */     //   1526: invokeinterface getAmplifier : ()I
/*     */     //   1531: iconst_1
/*     */     //   1532: iadd
/*     */     //   1533: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1536: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1539: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1542: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1547: i2f
/*     */     //   1548: fstore #16
/*     */     //   1550: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.posterama30 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1553: new java/lang/StringBuilder
/*     */     //   1556: dup
/*     */     //   1557: invokespecial <init> : ()V
/*     */     //   1560: aload #8
/*     */     //   1562: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1565: ldc_w ' '
/*     */     //   1568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1571: aload_0
/*     */     //   1572: aload #5
/*     */     //   1574: invokeinterface getAmplifier : ()I
/*     */     //   1579: iconst_1
/*     */     //   1580: iadd
/*     */     //   1581: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1587: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1590: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1595: i2f
/*     */     //   1596: fstore_1
/*     */     //   1597: fload #16
/*     */     //   1599: fload_2
/*     */     //   1600: fcmpl
/*     */     //   1601: ifle -> 1607
/*     */     //   1604: fload #16
/*     */     //   1606: fstore_2
/*     */     //   1607: aload #9
/*     */     //   1609: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1612: dup
/*     */     //   1613: ldc_w 'potionData.translate'
/*     */     //   1616: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1619: invokevirtual getY : ()F
/*     */     //   1622: ldc_w 2.5
/*     */     //   1625: fdiv
/*     */     //   1626: fstore #17
/*     */     //   1628: aload #9
/*     */     //   1630: getfield translate : Lnet/ccbluex/liquidbounce/utils/Translate;
/*     */     //   1633: dup
/*     */     //   1634: ldc_w 'potionData.translate'
/*     */     //   1637: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1640: invokevirtual getY : ()F
/*     */     //   1643: ldc_w 2.5
/*     */     //   1646: fdiv
/*     */     //   1647: ldc_w 8.0
/*     */     //   1650: fsub
/*     */     //   1651: fstore_3
/*     */     //   1652: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.posterama30 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1655: new java/lang/StringBuilder
/*     */     //   1658: dup
/*     */     //   1659: invokespecial <init> : ()V
/*     */     //   1662: aload #8
/*     */     //   1664: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1667: ldc_w ' '
/*     */     //   1670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1673: aload_0
/*     */     //   1674: aload #5
/*     */     //   1676: invokeinterface getAmplifier : ()I
/*     */     //   1681: iconst_1
/*     */     //   1682: iadd
/*     */     //   1683: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1686: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1689: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1692: ldc_w 29.0
/*     */     //   1695: fload #17
/*     */     //   1697: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1700: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1705: invokeinterface getFontHeight : ()I
/*     */     //   1710: i2f
/*     */     //   1711: fsub
/*     */     //   1712: fneg
/*     */     //   1713: iconst_m1
/*     */     //   1714: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   1719: pop
/*     */     //   1720: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.posterama30 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1723: aload #5
/*     */     //   1725: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   1730: fload_1
/*     */     //   1731: bipush #32
/*     */     //   1733: i2f
/*     */     //   1734: fadd
/*     */     //   1735: fload #17
/*     */     //   1737: ldc_w 9.76
/*     */     //   1740: fsub
/*     */     //   1741: fneg
/*     */     //   1742: iconst_m1
/*     */     //   1743: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   1748: pop
/*     */     //   1749: aload #7
/*     */     //   1751: invokeinterface getHasStatusIcon : ()Z
/*     */     //   1756: ifeq -> 1912
/*     */     //   1759: invokestatic func_179094_E : ()V
/*     */     //   1762: sipush #2929
/*     */     //   1765: invokestatic glDisable : (I)V
/*     */     //   1768: sipush #3042
/*     */     //   1771: invokestatic glEnable : (I)V
/*     */     //   1774: iconst_0
/*     */     //   1775: invokestatic glDepthMask : (Z)V
/*     */     //   1778: sipush #770
/*     */     //   1781: sipush #771
/*     */     //   1784: iconst_1
/*     */     //   1785: iconst_0
/*     */     //   1786: invokestatic func_148821_a : (IIII)V
/*     */     //   1789: fconst_1
/*     */     //   1790: fconst_1
/*     */     //   1791: fconst_1
/*     */     //   1792: fconst_1
/*     */     //   1793: invokestatic glColor4f : (FFFF)V
/*     */     //   1796: aload #7
/*     */     //   1798: invokeinterface getStatusIconIndex : ()I
/*     */     //   1803: istore #16
/*     */     //   1805: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1808: invokeinterface getTextureManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;
/*     */     //   1813: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1816: ldc_w 'textures/gui/container/inventory.png'
/*     */     //   1819: invokeinterface createResourceLocation : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   1824: invokeinterface bindTexture : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V
/*     */     //   1829: invokestatic glPushMatrix : ()V
/*     */     //   1832: ldc2_w 0.55
/*     */     //   1835: ldc2_w 0.55
/*     */     //   1838: dconst_1
/*     */     //   1839: invokestatic glScaled : (DDD)V
/*     */     //   1842: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1845: getfield field_71456_v : Lnet/minecraft/client/gui/GuiIngame;
/*     */     //   1848: ldc_w 30.0
/*     */     //   1851: iload #15
/*     */     //   1853: i2f
/*     */     //   1854: ldc_w 15.85
/*     */     //   1857: fadd
/*     */     //   1858: ldc_w 7.07
/*     */     //   1861: fadd
/*     */     //   1862: fneg
/*     */     //   1863: iload #16
/*     */     //   1865: bipush #8
/*     */     //   1867: irem
/*     */     //   1868: bipush #18
/*     */     //   1870: imul
/*     */     //   1871: sipush #198
/*     */     //   1874: iload #16
/*     */     //   1876: bipush #8
/*     */     //   1878: idiv
/*     */     //   1879: bipush #18
/*     */     //   1881: imul
/*     */     //   1882: iadd
/*     */     //   1883: bipush #18
/*     */     //   1885: bipush #18
/*     */     //   1887: invokevirtual func_175174_a : (FFIIII)V
/*     */     //   1890: invokestatic glPopMatrix : ()V
/*     */     //   1893: iconst_1
/*     */     //   1894: invokestatic glDepthMask : (Z)V
/*     */     //   1897: sipush #3042
/*     */     //   1900: invokestatic glDisable : (I)V
/*     */     //   1903: sipush #2929
/*     */     //   1906: invokestatic glEnable : (I)V
/*     */     //   1909: invokestatic func_179121_F : ()V
/*     */     //   1912: iload #4
/*     */     //   1914: bipush #35
/*     */     //   1916: isub
/*     */     //   1917: istore #4
/*     */     //   1919: goto -> 316
/*     */     //   1922: aload_0
/*     */     //   1923: fload_2
/*     */     //   1924: ldc_w 0.98
/*     */     //   1927: fmul
/*     */     //   1928: ldc_w 42.68
/*     */     //   1931: fadd
/*     */     //   1932: invokevirtual updateAnimwith : (F)V
/*     */     //   1935: aload_0
/*     */     //   1936: fload_3
/*     */     //   1937: fneg
/*     */     //   1938: ldc_w 1.1
/*     */     //   1941: fmul
/*     */     //   1942: ldc_w 14.63
/*     */     //   1945: fadd
/*     */     //   1946: invokevirtual updateAnimhealth : (F)V
/*     */     //   1949: invokestatic func_179121_F : ()V
/*     */     //   1952: aload_0
/*     */     //   1953: getfield Chinese : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1956: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1959: checkcast java/lang/Boolean
/*     */     //   1962: invokevirtual booleanValue : ()Z
/*     */     //   1965: ifeq -> 2000
/*     */     //   1968: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.F18 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1971: ldc_w '药水显示'
/*     */     //   1974: ldc2_w 17.07
/*     */     //   1977: ldc2_w -3.66
/*     */     //   1980: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   1983: dup
/*     */     //   1984: ldc_w 'Color.WHITE'
/*     */     //   1987: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1990: invokevirtual getRGB : ()I
/*     */     //   1993: invokevirtual drawStringWithShadow : (Ljava/lang/String;DDI)I
/*     */     //   1996: pop
/*     */     //   1997: goto -> 2017
/*     */     //   2000: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.posterama40 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2003: ldc_w 'Effects'
/*     */     //   2006: bipush #17
/*     */     //   2008: bipush #-3
/*     */     //   2010: iconst_m1
/*     */     //   2011: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   2016: pop
/*     */     //   2017: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   2020: dup
/*     */     //   2021: ldc_w 12.0
/*     */     //   2024: ldc_w -7.0
/*     */     //   2027: aload_0
/*     */     //   2028: getfield easingwith : F
/*     */     //   2031: aload_0
/*     */     //   2032: getfield easinghealth : F
/*     */     //   2035: invokespecial <init> : (FFFF)V
/*     */     //   2038: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #46	-> 0
/*     */     //   #47	-> 0
/*     */     //   #48	-> 2
/*     */     //   #49	-> 4
/*     */     //   #50	-> 11
/*     */     //   #51	-> 18
/*     */     //   #52	-> 31
/*     */     //   #46	-> 57
/*     */     //   #55	-> 60
/*     */     //   #56	-> 74
/*     */     //   #57	-> 80
/*     */     //   #58	-> 83
/*     */     //   #59	-> 99
/*     */     //   #72	-> 123
/*     */     //   #59	-> 134
/*     */     //   #86	-> 137
/*     */     //   #87	-> 140
/*     */     //   #88	-> 155
/*     */     //   #90	-> 167
/*     */     //   #91	-> 183
/*     */     //   #92	-> 197
/*     */     //   #93	-> 200
/*     */     //   #94	-> 200
/*     */     //   #95	-> 208
/*     */     //   #96	-> 216
/*     */     //   #97	-> 220
/*     */     //   #93	-> 250
/*     */     //   #99	-> 253
/*     */     //   #100	-> 256
/*     */     //   #105	-> 268
/*     */     //   #106	-> 271
/*     */     //   #107	-> 274
/*     */     //   #108	-> 276
/*     */     //   #109	-> 278
/*     */     //   #110	-> 280
/*     */     //   #111	-> 283
/*     */     //   #112	-> 338
/*     */     //   #113	-> 355
/*     */     //   #114	-> 376
/*     */     //   #115	-> 379
/*     */     //   #116	-> 427
/*     */     //   #117	-> 446
/*     */     //   #116	-> 446
/*     */     //   #117	-> 452
/*     */     //   #118	-> 502
/*     */     //   #119	-> 506
/*     */     //   #117	-> 509
/*     */     //   #116	-> 520
/*     */     //   #119	-> 526
/*     */     //   #120	-> 526
/*     */     //   #121	-> 529
/*     */     //   #122	-> 600
/*     */     //   #123	-> 603
/*     */     //   #121	-> 606
/*     */     //   #125	-> 609
/*     */     //   #126	-> 626
/*     */     //   #127	-> 629
/*     */     //   #128	-> 632
/*     */     //   #129	-> 633
/*     */     //   #130	-> 633
/*     */     //   #129	-> 633
/*     */     //   #130	-> 633
/*     */     //   #129	-> 633
/*     */     //   #129	-> 664
/*     */     //   #129	-> 681
/*     */     //   #278	-> 684
/*     */     //   #279	-> 694
/*     */     //   #280	-> 710
/*     */     //   #281	-> 720
/*     */     //   #129	-> 735
/*     */     //   #129	-> 760
/*     */     //   #282	-> 763
/*     */     //   #280	-> 783
/*     */     //   #286	-> 786
/*     */     //   #130	-> 794
/*     */     //   #287	-> 797
/*     */     //   #288	-> 801
/*     */     //   #130	-> 834
/*     */     //   #131	-> 844
/*     */     //   #132	-> 844
/*     */     //   #131	-> 844
/*     */     //   #132	-> 844
/*     */     //   #131	-> 844
/*     */     //   #131	-> 875
/*     */     //   #131	-> 892
/*     */     //   #289	-> 895
/*     */     //   #290	-> 905
/*     */     //   #291	-> 921
/*     */     //   #292	-> 931
/*     */     //   #131	-> 946
/*     */     //   #131	-> 971
/*     */     //   #293	-> 974
/*     */     //   #291	-> 994
/*     */     //   #297	-> 997
/*     */     //   #132	-> 1005
/*     */     //   #298	-> 1008
/*     */     //   #299	-> 1012
/*     */     //   #132	-> 1045
/*     */     //   #133	-> 1058
/*     */     //   #134	-> 1060
/*     */     //   #135	-> 1064
/*     */     //   #136	-> 1069
/*     */     //   #137	-> 1069
/*     */     //   #138	-> 1079
/*     */     //   #139	-> 1107
/*     */     //   #140	-> 1114
/*     */     //   #141	-> 1117
/*     */     //   #142	-> 1143
/*     */     //   #143	-> 1171
/*     */     //   #144	-> 1179
/*     */     //   #145	-> 1194
/*     */     //   #151	-> 1194
/*     */     //   #145	-> 1196
/*     */     //   #146	-> 1196
/*     */     //   #150	-> 1209
/*     */     //   #146	-> 1209
/*     */     //   #147	-> 1209
/*     */     //   #148	-> 1212
/*     */     //   #147	-> 1224
/*     */     //   #149	-> 1227
/*     */     //   #146	-> 1231
/*     */     //   #150	-> 1234
/*     */     //   #145	-> 1239
/*     */     //   #151	-> 1242
/*     */     //   #154	-> 1246
/*     */     //   #155	-> 1262
/*     */     //   #156	-> 1262
/*     */     //   #155	-> 1306
/*     */     //   #157	-> 1308
/*     */     //   #158	-> 1308
/*     */     //   #159	-> 1353
/*     */     //   #160	-> 1360
/*     */     //   #162	-> 1363
/*     */     //   #163	-> 1384
/*     */     //   #164	-> 1408
/*     */     //   #165	-> 1411
/*     */     //   #166	-> 1448
/*     */     //   #167	-> 1451
/*     */     //   #168	-> 1469
/*     */     //   #164	-> 1470
/*     */     //   #171	-> 1473
/*     */     //   #174	-> 1502
/*     */     //   #175	-> 1502
/*     */     //   #174	-> 1548
/*     */     //   #176	-> 1550
/*     */     //   #177	-> 1550
/*     */     //   #178	-> 1597
/*     */     //   #179	-> 1604
/*     */     //   #181	-> 1607
/*     */     //   #182	-> 1628
/*     */     //   #183	-> 1652
/*     */     //   #184	-> 1655
/*     */     //   #185	-> 1692
/*     */     //   #186	-> 1695
/*     */     //   #187	-> 1713
/*     */     //   #183	-> 1714
/*     */     //   #190	-> 1720
/*     */     //   #191	-> 1749
/*     */     //   #192	-> 1749
/*     */     //   #193	-> 1759
/*     */     //   #194	-> 1762
/*     */     //   #195	-> 1768
/*     */     //   #196	-> 1774
/*     */     //   #197	-> 1778
/*     */     //   #198	-> 1789
/*     */     //   #199	-> 1796
/*     */     //   #200	-> 1805
/*     */     //   #201	-> 1829
/*     */     //   #202	-> 1832
/*     */     //   #203	-> 1842
/*     */     //   #204	-> 1848
/*     */     //   #205	-> 1851
/*     */     //   #203	-> 1887
/*     */     //   #207	-> 1890
/*     */     //   #208	-> 1893
/*     */     //   #209	-> 1897
/*     */     //   #210	-> 1903
/*     */     //   #211	-> 1909
/*     */     //   #213	-> 1912
/*     */     //   #111	-> 1919
/*     */     //   #215	-> 1922
/*     */     //   #216	-> 1935
/*     */     //   #218	-> 1949
/*     */     //   #219	-> 1952
/*     */     //   #220	-> 1968
/*     */     //   #223	-> 2000
/*     */     //   #224	-> 2017
/*     */     //   #226	-> 2017
/*     */     //   #227	-> 2024
/*     */     //   #228	-> 2027
/*     */     //   #229	-> 2031
/*     */     //   #226	-> 2035
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   499	7	13	it	Lnet/ccbluex/liquidbounce/utils/PotionData;
/*     */     //   502	4	14	$i$a$-also-Effects$drawElement$3	I
/*     */     //   578	28	11	checkEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   732	28	16	it	Ljava/lang/String;
/*     */     //   735	25	17	$i$a$-dropLastWhile-Effects$drawElement$4	I
/*     */     //   710	76	15	iterator$iv	Ljava/util/ListIterator;
/*     */     //   681	108	13	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   684	105	14	$i$f$dropLastWhile	I
/*     */     //   801	26	15	thisCollection$iv	Ljava/util/Collection;
/*     */     //   794	33	13	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   797	30	14	$i$f$toTypedArray	I
/*     */     //   943	28	16	it	Ljava/lang/String;
/*     */     //   946	25	17	$i$a$-dropLastWhile-Effects$drawElement$5	I
/*     */     //   921	76	15	iterator$iv	Ljava/util/ListIterator;
/*     */     //   892	108	13	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   895	105	14	$i$f$dropLastWhile	I
/*     */     //   1012	26	15	thisCollection$iv	Ljava/util/Collection;
/*     */     //   1005	33	13	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   1008	30	14	$i$f$toTypedArray	I
/*     */     //   1060	9	13	ignored	Ljava/lang/Exception;
/*     */     //   1384	115	17	posY	F
/*     */     //   1308	191	16	namewith2	F
/*     */     //   1628	121	17	posY	F
/*     */     //   1550	199	16	namewith2	F
/*     */     //   1805	107	16	statusIconIndex	I
/*     */     //   1171	748	15	position	I
/*     */     //   1117	802	14	state	F
/*     */     //   1079	840	13	lifeTime	I
/*     */     //   632	1287	12	potionMaxTime	I
/*     */     //   629	1290	11	potionTime	I
/*     */     //   529	1390	10	flag	Z
/*     */     //   379	1540	9	potionData	Lnet/ccbluex/liquidbounce/utils/PotionData;
/*     */     //   376	1543	8	name	Ljava/lang/String;
/*     */     //   355	1564	7	potion	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   338	1581	5	potionEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   283	1756	4	y	I
/*     */     //   280	1759	3	namehight	F
/*     */     //   278	1761	2	namewith3	F
/*     */     //   276	1763	1	namewith	F
/*     */     //   0	2039	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Effects;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   632	1055	1058	java/lang/Exception
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void updateAnimwith(float easing) {
/* 232 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - this.easingwith, f3 = this.easingwith; Effects effects = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); effects.easingwith = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 234 */     if (!this.timer.hasTimePassed(2L)) {
/*     */       return;
/*     */     }
/*     */     
/* 238 */     this.backamin += true;
/*     */ 
/*     */ 
/*     */     
/* 242 */     this.timer.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateAnimhealth(float easing) {
/* 247 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - this.easinghealth, f3 = this.easinghealth; Effects effects = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); effects.easinghealth = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 249 */     if (!this.timer.hasTimePassed(2L)) {
/*     */       return;
/*     */     }
/*     */     
/* 253 */     this.healthamin += true;
/*     */ 
/*     */ 
/*     */     
/* 257 */     this.timer.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   private final String intToRomanByGreedy(int num) {
/* 262 */     int j = num;
/* 263 */     int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/* 264 */     String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/* 265 */     StringBuilder stringBuilder = new StringBuilder();
/* 266 */     int i = 0;
/* 267 */     while (i < values.length && j >= 0) {
/* 268 */       while (values[i] <= j) {
/* 269 */         j -= values[i];
/* 270 */         stringBuilder.append(symbols[i]);
/*     */       } 
/* 272 */       i++;
/*     */     } 
/* 274 */     Intrinsics.checkExpressionValueIsNotNull(stringBuilder.toString(), "stringBuilder.toString()"); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Effects() {
/*     */     this(0.0D, 0.0D, 0.0F, 7, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Effects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */