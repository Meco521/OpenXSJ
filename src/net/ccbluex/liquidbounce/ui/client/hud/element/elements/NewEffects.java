/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import courage.utils.PotionData;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ElementInfo(name = "NewEffects")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\020\n\002\020%\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\b\n\000\n\002\020\002\n\002\b\004\b\007\030\000 *2\0020\001:\001*B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\n\020 \032\004\030\0010!H\026J\020\020\"\032\0020#2\006\020$\032\0020%H\002J\016\020&\032\0020'2\006\020(\032\0020\006J\016\020)\032\0020'2\006\020(\032\0020\006R\032\020\b\032\0020\006X\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\032\020\r\032\0020\006X\016¢\006\016\n\000\032\004\b\016\020\n\"\004\b\017\020\fR\032\020\020\032\0020\006X\016¢\006\016\n\000\032\004\b\021\020\n\"\004\b\022\020\fR\032\020\023\032\0020\006X\016¢\006\016\n\000\032\004\b\024\020\n\"\004\b\025\020\fR\034\020\026\032\020\022\004\022\0020\030\022\006\022\004\030\0010\0310\027X\004¢\006\002\n\000R\032\020\032\032\0020\033X\016¢\006\016\n\000\032\004\b\034\020\035\"\004\b\036\020\037¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "backamin", "getBackamin", "()F", "setBackamin", "(F)V", "easinghealth", "getEasinghealth", "setEasinghealth", "easingwith", "getEasingwith", "setEasingwith", "healthamin", "getHealthamin", "setHealthamin", "potionMap", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "Lcourage/utils/PotionData;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "setTimer", "(Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;)V", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "intToRomanByGreedy", "", "num", "", "updateAnimhealth", "", "easing", "updateAnimwith", "Companion", "XSJClient"})
/*     */ public final class NewEffects extends Element {
/*     */   private final Map<IPotion, PotionData> potionMap;
/*     */   @NotNull
/*     */   private MSTimer timer;
/*     */   private float easingwith;
/*     */   
/*  25 */   public NewEffects(double x, double y, float scale) { super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */     
/*  27 */     this.potionMap = new HashMap<>();
/*     */     
/*  29 */     this.timer = new MSTimer(); } private float backamin; private float easinghealth; private float healthamin; private static final BoolValue blur; @NotNull public final MSTimer getTimer() { return this.timer; } public final void setTimer(@NotNull MSTimer <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.timer = <set-?>; }
/*  30 */   public final float getEasingwith() { return this.easingwith; } public final void setEasingwith(float <set-?>) { this.easingwith = <set-?>; }
/*  31 */   public final float getBackamin() { return this.backamin; } public final void setBackamin(float <set-?>) { this.backamin = <set-?>; }
/*  32 */   public final float getEasinghealth() { return this.easinghealth; } public final void setEasinghealth(float <set-?>) { this.easinghealth = <set-?>; }
/*  33 */   public final float getHealthamin() { return this.healthamin; } public final void setHealthamin(float <set-?>) { this.healthamin = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     //   0: invokestatic func_179094_E : ()V
/*     */     //   3: fconst_0
/*     */     //   4: fstore_1
/*     */     //   5: fconst_0
/*     */     //   6: fstore_2
/*     */     //   7: fconst_0
/*     */     //   8: fstore_3
/*     */     //   9: iconst_0
/*     */     //   10: istore #4
/*     */     //   12: new java/awt/Color
/*     */     //   15: dup
/*     */     //   16: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   19: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   22: checkcast java/lang/Number
/*     */     //   25: invokevirtual intValue : ()I
/*     */     //   28: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   31: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   34: checkcast java/lang/Number
/*     */     //   37: invokevirtual intValue : ()I
/*     */     //   40: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   43: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   46: checkcast java/lang/Number
/*     */     //   49: invokevirtual intValue : ()I
/*     */     //   52: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.a : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   55: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   58: checkcast java/lang/Number
/*     */     //   61: invokevirtual intValue : ()I
/*     */     //   64: invokespecial <init> : (IIII)V
/*     */     //   67: astore #5
/*     */     //   69: new java/awt/Color
/*     */     //   72: dup
/*     */     //   73: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   76: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   79: checkcast java/lang/Number
/*     */     //   82: invokevirtual intValue : ()I
/*     */     //   85: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   88: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   91: checkcast java/lang/Number
/*     */     //   94: invokevirtual intValue : ()I
/*     */     //   97: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   100: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   103: checkcast java/lang/Number
/*     */     //   106: invokevirtual intValue : ()I
/*     */     //   109: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.a : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   112: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   115: checkcast java/lang/Number
/*     */     //   118: invokevirtual intValue : ()I
/*     */     //   121: invokespecial <init> : (IIII)V
/*     */     //   124: astore #6
/*     */     //   126: new java/awt/Color
/*     */     //   129: dup
/*     */     //   130: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   133: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   136: checkcast java/lang/Number
/*     */     //   139: invokevirtual intValue : ()I
/*     */     //   142: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   145: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   148: checkcast java/lang/Number
/*     */     //   151: invokevirtual intValue : ()I
/*     */     //   154: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   157: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   160: checkcast java/lang/Number
/*     */     //   163: invokevirtual intValue : ()I
/*     */     //   166: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.a2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   169: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   172: checkcast java/lang/Number
/*     */     //   175: invokevirtual intValue : ()I
/*     */     //   178: invokespecial <init> : (IIII)V
/*     */     //   181: astore #7
/*     */     //   183: new java/awt/Color
/*     */     //   186: dup
/*     */     //   187: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   190: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   193: checkcast java/lang/Number
/*     */     //   196: invokevirtual intValue : ()I
/*     */     //   199: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   202: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   205: checkcast java/lang/Number
/*     */     //   208: invokevirtual intValue : ()I
/*     */     //   211: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   214: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   217: checkcast java/lang/Number
/*     */     //   220: invokevirtual intValue : ()I
/*     */     //   223: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.a2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   226: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   229: checkcast java/lang/Number
/*     */     //   232: invokevirtual intValue : ()I
/*     */     //   235: invokespecial <init> : (IIII)V
/*     */     //   238: astore #8
/*     */     //   240: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   243: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   248: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   251: dup
/*     */     //   252: ifnonnull -> 258
/*     */     //   255: invokestatic throwNpe : ()V
/*     */     //   258: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP
/*     */     //   261: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   266: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   271: astore #10
/*     */     //   273: aload #10
/*     */     //   275: invokeinterface hasNext : ()Z
/*     */     //   280: ifeq -> 1655
/*     */     //   283: aload #10
/*     */     //   285: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   290: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   293: astore #9
/*     */     //   295: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   298: aload #9
/*     */     //   300: invokeinterface getPotionID : ()I
/*     */     //   305: invokeinterface getPotionById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   310: astore #11
/*     */     //   312: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   315: aload #11
/*     */     //   317: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   322: iconst_0
/*     */     //   323: anewarray java/lang/String
/*     */     //   326: invokeinterface formatI18n : (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
/*     */     //   331: astore #12
/*     */     //   333: aconst_null
/*     */     //   334: astore #13
/*     */     //   336: aload_0
/*     */     //   337: getfield potionMap : Ljava/util/Map;
/*     */     //   340: aload #11
/*     */     //   342: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   347: ifeq -> 403
/*     */     //   350: aload_0
/*     */     //   351: getfield potionMap : Ljava/util/Map;
/*     */     //   354: aload #11
/*     */     //   356: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   361: dup
/*     */     //   362: ifnonnull -> 368
/*     */     //   365: invokestatic throwNpe : ()V
/*     */     //   368: checkcast courage/utils/PotionData
/*     */     //   371: getfield level : I
/*     */     //   374: aload #9
/*     */     //   376: invokeinterface getAmplifier : ()I
/*     */     //   381: if_icmpne -> 403
/*     */     //   384: aload_0
/*     */     //   385: getfield potionMap : Ljava/util/Map;
/*     */     //   388: aload #11
/*     */     //   390: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   395: checkcast courage/utils/PotionData
/*     */     //   398: astore #13
/*     */     //   400: goto -> 482
/*     */     //   403: aload_0
/*     */     //   404: getfield potionMap : Ljava/util/Map;
/*     */     //   407: aload #11
/*     */     //   409: new courage/utils/PotionData
/*     */     //   412: dup
/*     */     //   413: aload #11
/*     */     //   415: new courage/utils/Translate
/*     */     //   418: dup
/*     */     //   419: fconst_0
/*     */     //   420: ldc -40.0
/*     */     //   422: iload #4
/*     */     //   424: i2f
/*     */     //   425: fadd
/*     */     //   426: invokespecial <init> : (FF)V
/*     */     //   429: aload #9
/*     */     //   431: invokeinterface getAmplifier : ()I
/*     */     //   436: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;Lcourage/utils/Translate;I)V
/*     */     //   439: astore #14
/*     */     //   441: astore #25
/*     */     //   443: astore #24
/*     */     //   445: iconst_0
/*     */     //   446: istore #15
/*     */     //   448: iconst_0
/*     */     //   449: istore #16
/*     */     //   451: aload #14
/*     */     //   453: astore #17
/*     */     //   455: iconst_0
/*     */     //   456: istore #18
/*     */     //   458: aload #17
/*     */     //   460: astore #13
/*     */     //   462: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
/*     */     //   465: pop
/*     */     //   466: aload #14
/*     */     //   468: astore #26
/*     */     //   470: aload #24
/*     */     //   472: aload #25
/*     */     //   474: aload #26
/*     */     //   476: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   481: pop
/*     */     //   482: iconst_1
/*     */     //   483: istore #14
/*     */     //   485: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   488: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   493: dup
/*     */     //   494: ifnonnull -> 500
/*     */     //   497: invokestatic throwNpe : ()V
/*     */     //   500: invokeinterface getActivePotionEffects : ()Ljava/util/Collection;
/*     */     //   505: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   510: astore #16
/*     */     //   512: aload #16
/*     */     //   514: invokeinterface hasNext : ()Z
/*     */     //   519: ifeq -> 565
/*     */     //   522: aload #16
/*     */     //   524: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   529: checkcast net/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect
/*     */     //   532: astore #15
/*     */     //   534: aload #15
/*     */     //   536: invokeinterface getAmplifier : ()I
/*     */     //   541: aload #13
/*     */     //   543: dup
/*     */     //   544: ifnonnull -> 550
/*     */     //   547: invokestatic throwNpe : ()V
/*     */     //   550: getfield level : I
/*     */     //   553: if_icmpne -> 562
/*     */     //   556: iconst_0
/*     */     //   557: istore #14
/*     */     //   559: goto -> 565
/*     */     //   562: goto -> 512
/*     */     //   565: iload #14
/*     */     //   567: ifeq -> 582
/*     */     //   570: aload_0
/*     */     //   571: getfield potionMap : Ljava/util/Map;
/*     */     //   574: aload #11
/*     */     //   576: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   581: pop
/*     */     //   582: iconst_0
/*     */     //   583: istore #15
/*     */     //   585: iconst_0
/*     */     //   586: istore #16
/*     */     //   588: nop
/*     */     //   589: aload #9
/*     */     //   591: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   596: checkcast java/lang/CharSequence
/*     */     //   599: astore #17
/*     */     //   601: ldc_w ':'
/*     */     //   604: astore #18
/*     */     //   606: iconst_0
/*     */     //   607: istore #19
/*     */     //   609: new kotlin/text/Regex
/*     */     //   612: dup
/*     */     //   613: aload #18
/*     */     //   615: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   618: astore #18
/*     */     //   620: iconst_0
/*     */     //   621: istore #19
/*     */     //   623: iconst_0
/*     */     //   624: istore #20
/*     */     //   626: aload #18
/*     */     //   628: aload #17
/*     */     //   630: iload #19
/*     */     //   632: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   635: astore #17
/*     */     //   637: iconst_0
/*     */     //   638: istore #18
/*     */     //   640: aload #17
/*     */     //   642: invokeinterface isEmpty : ()Z
/*     */     //   647: ifne -> 742
/*     */     //   650: aload #17
/*     */     //   652: aload #17
/*     */     //   654: invokeinterface size : ()I
/*     */     //   659: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   664: astore #19
/*     */     //   666: aload #19
/*     */     //   668: invokeinterface hasPrevious : ()Z
/*     */     //   673: ifeq -> 742
/*     */     //   676: aload #19
/*     */     //   678: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   683: checkcast java/lang/String
/*     */     //   686: astore #20
/*     */     //   688: iconst_0
/*     */     //   689: istore #21
/*     */     //   691: aload #20
/*     */     //   693: checkcast java/lang/CharSequence
/*     */     //   696: astore #22
/*     */     //   698: iconst_0
/*     */     //   699: istore #23
/*     */     //   701: aload #22
/*     */     //   703: invokeinterface length : ()I
/*     */     //   708: ifne -> 715
/*     */     //   711: iconst_1
/*     */     //   712: goto -> 716
/*     */     //   715: iconst_0
/*     */     //   716: ifne -> 739
/*     */     //   719: aload #17
/*     */     //   721: checkcast java/lang/Iterable
/*     */     //   724: aload #19
/*     */     //   726: invokeinterface nextIndex : ()I
/*     */     //   731: iconst_1
/*     */     //   732: iadd
/*     */     //   733: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   736: goto -> 745
/*     */     //   739: goto -> 666
/*     */     //   742: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   745: checkcast java/util/Collection
/*     */     //   748: astore #17
/*     */     //   750: iconst_0
/*     */     //   751: istore #18
/*     */     //   753: aload #17
/*     */     //   755: astore #19
/*     */     //   757: aload #19
/*     */     //   759: iconst_0
/*     */     //   760: anewarray java/lang/String
/*     */     //   763: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   768: dup
/*     */     //   769: ifnonnull -> 783
/*     */     //   772: new kotlin/TypeCastException
/*     */     //   775: dup
/*     */     //   776: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   779: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   782: athrow
/*     */     //   783: checkcast [Ljava/lang/String;
/*     */     //   786: iconst_0
/*     */     //   787: aaload
/*     */     //   788: astore #17
/*     */     //   790: iconst_0
/*     */     //   791: istore #18
/*     */     //   793: aload #17
/*     */     //   795: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   798: istore #15
/*     */     //   800: aload #9
/*     */     //   802: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   807: checkcast java/lang/CharSequence
/*     */     //   810: astore #17
/*     */     //   812: ldc_w ':'
/*     */     //   815: astore #18
/*     */     //   817: iconst_0
/*     */     //   818: istore #19
/*     */     //   820: new kotlin/text/Regex
/*     */     //   823: dup
/*     */     //   824: aload #18
/*     */     //   826: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   829: astore #18
/*     */     //   831: iconst_0
/*     */     //   832: istore #19
/*     */     //   834: iconst_0
/*     */     //   835: istore #20
/*     */     //   837: aload #18
/*     */     //   839: aload #17
/*     */     //   841: iload #19
/*     */     //   843: invokevirtual split : (Ljava/lang/CharSequence;I)Ljava/util/List;
/*     */     //   846: astore #17
/*     */     //   848: iconst_0
/*     */     //   849: istore #18
/*     */     //   851: aload #17
/*     */     //   853: invokeinterface isEmpty : ()Z
/*     */     //   858: ifne -> 953
/*     */     //   861: aload #17
/*     */     //   863: aload #17
/*     */     //   865: invokeinterface size : ()I
/*     */     //   870: invokeinterface listIterator : (I)Ljava/util/ListIterator;
/*     */     //   875: astore #19
/*     */     //   877: aload #19
/*     */     //   879: invokeinterface hasPrevious : ()Z
/*     */     //   884: ifeq -> 953
/*     */     //   887: aload #19
/*     */     //   889: invokeinterface previous : ()Ljava/lang/Object;
/*     */     //   894: checkcast java/lang/String
/*     */     //   897: astore #20
/*     */     //   899: iconst_0
/*     */     //   900: istore #21
/*     */     //   902: aload #20
/*     */     //   904: checkcast java/lang/CharSequence
/*     */     //   907: astore #22
/*     */     //   909: iconst_0
/*     */     //   910: istore #23
/*     */     //   912: aload #22
/*     */     //   914: invokeinterface length : ()I
/*     */     //   919: ifne -> 926
/*     */     //   922: iconst_1
/*     */     //   923: goto -> 927
/*     */     //   926: iconst_0
/*     */     //   927: ifne -> 950
/*     */     //   930: aload #17
/*     */     //   932: checkcast java/lang/Iterable
/*     */     //   935: aload #19
/*     */     //   937: invokeinterface nextIndex : ()I
/*     */     //   942: iconst_1
/*     */     //   943: iadd
/*     */     //   944: invokestatic take : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   947: goto -> 956
/*     */     //   950: goto -> 877
/*     */     //   953: invokestatic emptyList : ()Ljava/util/List;
/*     */     //   956: checkcast java/util/Collection
/*     */     //   959: astore #17
/*     */     //   961: iconst_0
/*     */     //   962: istore #18
/*     */     //   964: aload #17
/*     */     //   966: astore #19
/*     */     //   968: aload #19
/*     */     //   970: iconst_0
/*     */     //   971: anewarray java/lang/String
/*     */     //   974: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   979: dup
/*     */     //   980: ifnonnull -> 994
/*     */     //   983: new kotlin/TypeCastException
/*     */     //   986: dup
/*     */     //   987: ldc_w 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   990: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   993: athrow
/*     */     //   994: checkcast [Ljava/lang/String;
/*     */     //   997: iconst_1
/*     */     //   998: aaload
/*     */     //   999: astore #17
/*     */     //   1001: iconst_0
/*     */     //   1002: istore #18
/*     */     //   1004: aload #17
/*     */     //   1006: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   1009: istore #16
/*     */     //   1011: goto -> 1025
/*     */     //   1014: astore #17
/*     */     //   1016: bipush #100
/*     */     //   1018: istore #15
/*     */     //   1020: sipush #1000
/*     */     //   1023: istore #16
/*     */     //   1025: iload #15
/*     */     //   1027: bipush #60
/*     */     //   1029: imul
/*     */     //   1030: iload #16
/*     */     //   1032: iadd
/*     */     //   1033: istore #17
/*     */     //   1035: aload #13
/*     */     //   1037: dup
/*     */     //   1038: ifnonnull -> 1044
/*     */     //   1041: invokestatic throwNpe : ()V
/*     */     //   1044: invokevirtual getMaxTimer : ()I
/*     */     //   1047: ifeq -> 1063
/*     */     //   1050: iload #17
/*     */     //   1052: i2d
/*     */     //   1053: aload #13
/*     */     //   1055: invokevirtual getMaxTimer : ()I
/*     */     //   1058: i2d
/*     */     //   1059: dcmpl
/*     */     //   1060: ifle -> 1070
/*     */     //   1063: aload #13
/*     */     //   1065: iload #17
/*     */     //   1067: putfield maxTimer : I
/*     */     //   1070: fconst_0
/*     */     //   1071: fstore #18
/*     */     //   1073: iload #17
/*     */     //   1075: i2d
/*     */     //   1076: dconst_0
/*     */     //   1077: dcmpl
/*     */     //   1078: iflt -> 1099
/*     */     //   1081: iload #17
/*     */     //   1083: i2d
/*     */     //   1084: aload #13
/*     */     //   1086: invokevirtual getMaxTimer : ()I
/*     */     //   1089: i2f
/*     */     //   1090: f2d
/*     */     //   1091: ddiv
/*     */     //   1092: ldc2_w 100.0
/*     */     //   1095: dmul
/*     */     //   1096: d2f
/*     */     //   1097: fstore #18
/*     */     //   1099: aload #13
/*     */     //   1101: getfield translate : Lcourage/utils/Translate;
/*     */     //   1104: dup
/*     */     //   1105: ldc_w 'potionData.translate'
/*     */     //   1108: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1111: invokevirtual getY : ()F
/*     */     //   1114: ldc_w 1.4
/*     */     //   1117: fdiv
/*     */     //   1118: ldc_w 7.22
/*     */     //   1121: fsub
/*     */     //   1122: invokestatic round : (F)I
/*     */     //   1125: istore #19
/*     */     //   1127: fload #18
/*     */     //   1129: fconst_2
/*     */     //   1130: invokestatic max : (FF)F
/*     */     //   1133: fstore #18
/*     */     //   1135: aload #13
/*     */     //   1137: getfield translate : Lcourage/utils/Translate;
/*     */     //   1140: fconst_0
/*     */     //   1141: iload #4
/*     */     //   1143: i2f
/*     */     //   1144: ldc2_w 0.1
/*     */     //   1147: invokevirtual interpolate : (FFD)V
/*     */     //   1150: aload #13
/*     */     //   1152: aload #13
/*     */     //   1154: invokevirtual getAnimationX : ()F
/*     */     //   1157: f2d
/*     */     //   1158: ldc_w 1.2
/*     */     //   1161: fload #18
/*     */     //   1163: fmul
/*     */     //   1164: f2d
/*     */     //   1165: ldc_w 10.0
/*     */     //   1168: aload #13
/*     */     //   1170: getfield animationX : F
/*     */     //   1173: ldc_w 1.2
/*     */     //   1176: fload #18
/*     */     //   1178: fmul
/*     */     //   1179: fsub
/*     */     //   1180: invokestatic abs : (F)F
/*     */     //   1183: ldc_w 15.0
/*     */     //   1186: fmul
/*     */     //   1187: invokestatic max : (FF)F
/*     */     //   1190: ldc_w 0.3
/*     */     //   1193: fmul
/*     */     //   1194: f2d
/*     */     //   1195: invokestatic getAnimationState2 : (DDD)D
/*     */     //   1198: d2f
/*     */     //   1199: putfield animationX : F
/*     */     //   1202: ldc_w 12.2
/*     */     //   1205: ldc_w -7.32
/*     */     //   1208: aload_0
/*     */     //   1209: getfield easingwith : F
/*     */     //   1212: aload_0
/*     */     //   1213: getfield easinghealth : F
/*     */     //   1216: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.ra : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1219: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1222: checkcast java/lang/Number
/*     */     //   1225: invokevirtual floatValue : ()F
/*     */     //   1228: aload #8
/*     */     //   1230: ldc_w 0.85
/*     */     //   1233: invokestatic applyOpacity : (Ljava/awt/Color;F)Ljava/awt/Color;
/*     */     //   1236: aload #5
/*     */     //   1238: aload #7
/*     */     //   1240: aload #6
/*     */     //   1242: invokestatic drawGradientRound : (FFFFFLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;)V
/*     */     //   1245: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.S16 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1248: new java/lang/StringBuilder
/*     */     //   1251: dup
/*     */     //   1252: invokespecial <init> : ()V
/*     */     //   1255: aload #12
/*     */     //   1257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1260: ldc_w ' '
/*     */     //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1266: aload_0
/*     */     //   1267: aload #9
/*     */     //   1269: invokeinterface getAmplifier : ()I
/*     */     //   1274: iconst_1
/*     */     //   1275: iadd
/*     */     //   1276: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1282: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1285: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   1288: i2f
/*     */     //   1289: fstore #20
/*     */     //   1291: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.S16 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1294: new java/lang/StringBuilder
/*     */     //   1297: dup
/*     */     //   1298: invokespecial <init> : ()V
/*     */     //   1301: aload #12
/*     */     //   1303: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1306: ldc_w ' '
/*     */     //   1309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1312: aload_0
/*     */     //   1313: aload #9
/*     */     //   1315: invokeinterface getAmplifier : ()I
/*     */     //   1320: iconst_1
/*     */     //   1321: iadd
/*     */     //   1322: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1328: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1331: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   1334: i2f
/*     */     //   1335: fstore_1
/*     */     //   1336: fload #20
/*     */     //   1338: fload_2
/*     */     //   1339: fcmpl
/*     */     //   1340: ifle -> 1346
/*     */     //   1343: fload #20
/*     */     //   1345: fstore_2
/*     */     //   1346: aload #13
/*     */     //   1348: getfield translate : Lcourage/utils/Translate;
/*     */     //   1351: dup
/*     */     //   1352: ldc_w 'potionData.translate'
/*     */     //   1355: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1358: invokevirtual getY : ()F
/*     */     //   1361: ldc_w 2.5
/*     */     //   1364: fdiv
/*     */     //   1365: fstore #21
/*     */     //   1367: aload #13
/*     */     //   1369: getfield translate : Lcourage/utils/Translate;
/*     */     //   1372: dup
/*     */     //   1373: ldc_w 'potionData.translate'
/*     */     //   1376: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1379: invokevirtual getY : ()F
/*     */     //   1382: ldc_w 2.5
/*     */     //   1385: fdiv
/*     */     //   1386: ldc_w 8.0
/*     */     //   1389: fsub
/*     */     //   1390: fstore_3
/*     */     //   1391: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.S16 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1394: new java/lang/StringBuilder
/*     */     //   1397: dup
/*     */     //   1398: invokespecial <init> : ()V
/*     */     //   1401: aload #12
/*     */     //   1403: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1406: ldc_w ' '
/*     */     //   1409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1412: aload_0
/*     */     //   1413: aload #9
/*     */     //   1415: invokeinterface getAmplifier : ()I
/*     */     //   1420: iconst_1
/*     */     //   1421: iadd
/*     */     //   1422: invokespecial intToRomanByGreedy : (I)Ljava/lang/String;
/*     */     //   1425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1428: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1431: ldc_w 29.0
/*     */     //   1434: fload #21
/*     */     //   1436: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1439: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1444: invokeinterface getFontHeight : ()I
/*     */     //   1449: i2f
/*     */     //   1450: fsub
/*     */     //   1451: fneg
/*     */     //   1452: iconst_m1
/*     */     //   1453: invokevirtual drawString : (Ljava/lang/String;FFI)V
/*     */     //   1456: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.S16 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1459: aload #9
/*     */     //   1461: invokeinterface getDurationString : ()Ljava/lang/String;
/*     */     //   1466: fload_1
/*     */     //   1467: bipush #32
/*     */     //   1469: i2f
/*     */     //   1470: fadd
/*     */     //   1471: fload #21
/*     */     //   1473: ldc_w 9.76
/*     */     //   1476: fsub
/*     */     //   1477: fneg
/*     */     //   1478: iconst_m1
/*     */     //   1479: invokevirtual drawString : (Ljava/lang/String;FFI)V
/*     */     //   1482: aload #11
/*     */     //   1484: invokeinterface getHasStatusIcon : ()Z
/*     */     //   1489: ifeq -> 1645
/*     */     //   1492: invokestatic func_179094_E : ()V
/*     */     //   1495: sipush #2929
/*     */     //   1498: invokestatic glDisable : (I)V
/*     */     //   1501: sipush #3042
/*     */     //   1504: invokestatic glEnable : (I)V
/*     */     //   1507: iconst_0
/*     */     //   1508: invokestatic glDepthMask : (Z)V
/*     */     //   1511: sipush #770
/*     */     //   1514: sipush #771
/*     */     //   1517: iconst_1
/*     */     //   1518: iconst_0
/*     */     //   1519: invokestatic func_148821_a : (IIII)V
/*     */     //   1522: fconst_1
/*     */     //   1523: fconst_1
/*     */     //   1524: fconst_1
/*     */     //   1525: fconst_1
/*     */     //   1526: invokestatic glColor4f : (FFFF)V
/*     */     //   1529: aload #11
/*     */     //   1531: invokeinterface getStatusIconIndex : ()I
/*     */     //   1536: istore #22
/*     */     //   1538: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1541: invokeinterface getTextureManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;
/*     */     //   1546: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1549: ldc_w 'textures/gui/container/inventory.png'
/*     */     //   1552: invokeinterface createResourceLocation : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   1557: invokeinterface bindTexture : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V
/*     */     //   1562: invokestatic glPushMatrix : ()V
/*     */     //   1565: ldc2_w 0.55
/*     */     //   1568: ldc2_w 0.55
/*     */     //   1571: dconst_1
/*     */     //   1572: invokestatic glScaled : (DDD)V
/*     */     //   1575: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1578: getfield field_71456_v : Lnet/minecraft/client/gui/GuiIngame;
/*     */     //   1581: ldc_w 30.0
/*     */     //   1584: iload #19
/*     */     //   1586: i2f
/*     */     //   1587: ldc_w 15.85
/*     */     //   1590: fadd
/*     */     //   1591: ldc_w 7.07
/*     */     //   1594: fadd
/*     */     //   1595: fneg
/*     */     //   1596: iload #22
/*     */     //   1598: bipush #8
/*     */     //   1600: irem
/*     */     //   1601: bipush #18
/*     */     //   1603: imul
/*     */     //   1604: sipush #198
/*     */     //   1607: iload #22
/*     */     //   1609: bipush #8
/*     */     //   1611: idiv
/*     */     //   1612: bipush #18
/*     */     //   1614: imul
/*     */     //   1615: iadd
/*     */     //   1616: bipush #18
/*     */     //   1618: bipush #18
/*     */     //   1620: invokevirtual func_175174_a : (FFIIII)V
/*     */     //   1623: invokestatic glPopMatrix : ()V
/*     */     //   1626: iconst_1
/*     */     //   1627: invokestatic glDepthMask : (Z)V
/*     */     //   1630: sipush #3042
/*     */     //   1633: invokestatic glDisable : (I)V
/*     */     //   1636: sipush #2929
/*     */     //   1639: invokestatic glEnable : (I)V
/*     */     //   1642: invokestatic func_179121_F : ()V
/*     */     //   1645: iload #4
/*     */     //   1647: bipush #35
/*     */     //   1649: isub
/*     */     //   1650: istore #4
/*     */     //   1652: goto -> 273
/*     */     //   1655: aload_0
/*     */     //   1656: fload_2
/*     */     //   1657: ldc_w 0.98
/*     */     //   1660: fmul
/*     */     //   1661: ldc_w 42.68
/*     */     //   1664: fadd
/*     */     //   1665: invokevirtual updateAnimwith : (F)V
/*     */     //   1668: aload_0
/*     */     //   1669: fload_3
/*     */     //   1670: fneg
/*     */     //   1671: ldc_w 1.1
/*     */     //   1674: fmul
/*     */     //   1675: ldc_w 14.63
/*     */     //   1678: fadd
/*     */     //   1679: invokevirtual updateAnimhealth : (F)V
/*     */     //   1682: invokestatic func_179121_F : ()V
/*     */     //   1685: getstatic net/ccbluex/liquidbounce/ui/font/FontLoaders.S18 : Lnet/ccbluex/liquidbounce/ui/font/FontDrawer;
/*     */     //   1688: ldc_w '药水效果'
/*     */     //   1691: ldc2_w 17.07
/*     */     //   1694: ldc2_w -3.66
/*     */     //   1697: new java/awt/Color
/*     */     //   1700: dup
/*     */     //   1701: sipush #255
/*     */     //   1704: sipush #255
/*     */     //   1707: sipush #255
/*     */     //   1710: sipush #255
/*     */     //   1713: invokespecial <init> : (IIII)V
/*     */     //   1716: invokevirtual getRGB : ()I
/*     */     //   1719: invokevirtual drawStringWithShadow : (Ljava/lang/String;DDI)I
/*     */     //   1722: pop
/*     */     //   1723: new net/ccbluex/liquidbounce/ui/client/hud/element/Border
/*     */     //   1726: dup
/*     */     //   1727: fconst_0
/*     */     //   1728: fconst_0
/*     */     //   1729: ldc_w 120.0
/*     */     //   1732: ldc_w 30.0
/*     */     //   1735: invokespecial <init> : (FFFF)V
/*     */     //   1738: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #38	-> 0
/*     */     //   #39	-> 3
/*     */     //   #40	-> 5
/*     */     //   #41	-> 7
/*     */     //   #42	-> 9
/*     */     //   #43	-> 12
/*     */     //   #44	-> 69
/*     */     //   #45	-> 126
/*     */     //   #46	-> 183
/*     */     //   #47	-> 240
/*     */     //   #48	-> 295
/*     */     //   #49	-> 312
/*     */     //   #50	-> 333
/*     */     //   #51	-> 336
/*     */     //   #52	-> 384
/*     */     //   #53	-> 403
/*     */     //   #52	-> 403
/*     */     //   #53	-> 409
/*     */     //   #54	-> 458
/*     */     //   #55	-> 462
/*     */     //   #53	-> 465
/*     */     //   #52	-> 476
/*     */     //   #55	-> 482
/*     */     //   #56	-> 482
/*     */     //   #57	-> 485
/*     */     //   #58	-> 556
/*     */     //   #59	-> 559
/*     */     //   #57	-> 562
/*     */     //   #61	-> 565
/*     */     //   #62	-> 582
/*     */     //   #63	-> 585
/*     */     //   #64	-> 588
/*     */     //   #65	-> 589
/*     */     //   #66	-> 589
/*     */     //   #65	-> 589
/*     */     //   #66	-> 589
/*     */     //   #65	-> 589
/*     */     //   #65	-> 620
/*     */     //   #65	-> 637
/*     */     //   #187	-> 640
/*     */     //   #188	-> 650
/*     */     //   #189	-> 666
/*     */     //   #190	-> 676
/*     */     //   #65	-> 691
/*     */     //   #65	-> 716
/*     */     //   #191	-> 719
/*     */     //   #189	-> 739
/*     */     //   #195	-> 742
/*     */     //   #66	-> 750
/*     */     //   #196	-> 753
/*     */     //   #197	-> 757
/*     */     //   #66	-> 790
/*     */     //   #67	-> 800
/*     */     //   #68	-> 800
/*     */     //   #67	-> 800
/*     */     //   #68	-> 800
/*     */     //   #67	-> 800
/*     */     //   #67	-> 831
/*     */     //   #67	-> 848
/*     */     //   #198	-> 851
/*     */     //   #199	-> 861
/*     */     //   #200	-> 877
/*     */     //   #201	-> 887
/*     */     //   #67	-> 902
/*     */     //   #67	-> 927
/*     */     //   #202	-> 930
/*     */     //   #200	-> 950
/*     */     //   #206	-> 953
/*     */     //   #68	-> 961
/*     */     //   #207	-> 964
/*     */     //   #208	-> 968
/*     */     //   #68	-> 1001
/*     */     //   #69	-> 1014
/*     */     //   #70	-> 1016
/*     */     //   #71	-> 1020
/*     */     //   #72	-> 1025
/*     */     //   #73	-> 1025
/*     */     //   #74	-> 1035
/*     */     //   #75	-> 1063
/*     */     //   #76	-> 1070
/*     */     //   #77	-> 1073
/*     */     //   #78	-> 1099
/*     */     //   #79	-> 1127
/*     */     //   #80	-> 1135
/*     */     //   #81	-> 1150
/*     */     //   #87	-> 1150
/*     */     //   #81	-> 1152
/*     */     //   #82	-> 1152
/*     */     //   #86	-> 1165
/*     */     //   #82	-> 1165
/*     */     //   #83	-> 1165
/*     */     //   #84	-> 1168
/*     */     //   #83	-> 1180
/*     */     //   #85	-> 1183
/*     */     //   #82	-> 1187
/*     */     //   #86	-> 1190
/*     */     //   #81	-> 1195
/*     */     //   #87	-> 1198
/*     */     //   #88	-> 1202
/*     */     //   #89	-> 1245
/*     */     //   #90	-> 1245
/*     */     //   #89	-> 1289
/*     */     //   #91	-> 1291
/*     */     //   #92	-> 1291
/*     */     //   #93	-> 1336
/*     */     //   #94	-> 1343
/*     */     //   #96	-> 1346
/*     */     //   #97	-> 1367
/*     */     //   #98	-> 1391
/*     */     //   #99	-> 1394
/*     */     //   #100	-> 1431
/*     */     //   #101	-> 1434
/*     */     //   #102	-> 1452
/*     */     //   #98	-> 1453
/*     */     //   #105	-> 1456
/*     */     //   #106	-> 1482
/*     */     //   #107	-> 1492
/*     */     //   #108	-> 1495
/*     */     //   #109	-> 1501
/*     */     //   #110	-> 1507
/*     */     //   #111	-> 1511
/*     */     //   #112	-> 1522
/*     */     //   #113	-> 1529
/*     */     //   #114	-> 1538
/*     */     //   #115	-> 1562
/*     */     //   #116	-> 1565
/*     */     //   #117	-> 1575
/*     */     //   #118	-> 1581
/*     */     //   #119	-> 1584
/*     */     //   #117	-> 1620
/*     */     //   #121	-> 1623
/*     */     //   #122	-> 1626
/*     */     //   #123	-> 1630
/*     */     //   #124	-> 1636
/*     */     //   #125	-> 1642
/*     */     //   #127	-> 1645
/*     */     //   #47	-> 1652
/*     */     //   #129	-> 1655
/*     */     //   #130	-> 1668
/*     */     //   #134	-> 1682
/*     */     //   #135	-> 1685
/*     */     //   #137	-> 1723
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   455	7	17	it	Lcourage/utils/PotionData;
/*     */     //   458	4	18	$i$a$-also-NewEffects$drawElement$1	I
/*     */     //   534	28	15	checkEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   688	28	20	it	Ljava/lang/String;
/*     */     //   691	25	21	$i$a$-dropLastWhile-NewEffects$drawElement$2	I
/*     */     //   666	76	19	iterator$iv	Ljava/util/ListIterator;
/*     */     //   637	108	17	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   640	105	18	$i$f$dropLastWhile	I
/*     */     //   757	26	19	thisCollection$iv	Ljava/util/Collection;
/*     */     //   750	33	17	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   753	30	18	$i$f$toTypedArray	I
/*     */     //   899	28	20	it	Ljava/lang/String;
/*     */     //   902	25	21	$i$a$-dropLastWhile-NewEffects$drawElement$3	I
/*     */     //   877	76	19	iterator$iv	Ljava/util/ListIterator;
/*     */     //   848	108	17	$this$dropLastWhile$iv	Ljava/util/List;
/*     */     //   851	105	18	$i$f$dropLastWhile	I
/*     */     //   968	26	19	thisCollection$iv	Ljava/util/Collection;
/*     */     //   961	33	17	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   964	30	18	$i$f$toTypedArray	I
/*     */     //   1016	9	17	ignored	Ljava/lang/Exception;
/*     */     //   1538	107	22	statusIconIndex	I
/*     */     //   1367	285	21	posY	F
/*     */     //   1291	361	20	namewith2	F
/*     */     //   1127	525	19	position	I
/*     */     //   1073	579	18	state	F
/*     */     //   1035	617	17	lifeTime	I
/*     */     //   588	1064	16	potionMaxTime	I
/*     */     //   585	1067	15	potionTime	I
/*     */     //   485	1167	14	flag	Z
/*     */     //   336	1316	13	potionData	Lcourage/utils/PotionData;
/*     */     //   333	1319	12	name	Ljava/lang/String;
/*     */     //   312	1340	11	potion	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   295	1357	9	potionEffect	Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*     */     //   240	1499	8	gradientColor4	Ljava/awt/Color;
/*     */     //   183	1556	7	gradientColor3	Ljava/awt/Color;
/*     */     //   126	1613	6	gradientColor2	Ljava/awt/Color;
/*     */     //   69	1670	5	gradientColor1	Ljava/awt/Color;
/*     */     //   12	1727	4	y	I
/*     */     //   9	1730	3	namehight	F
/*     */     //   7	1732	2	namewith3	F
/*     */     //   5	1734	1	namewith	F
/*     */     //   0	1739	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   588	1011	1014	java/lang/Exception
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
/*     */   public final void updateAnimwith(float easing) {
/* 140 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - this.easingwith, f3 = this.easingwith; NewEffects newEffects = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); newEffects.easingwith = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 142 */     if (!this.timer.hasTimePassed(2L)) {
/*     */       return;
/*     */     }
/*     */     
/* 146 */     this.backamin += true;
/*     */ 
/*     */ 
/*     */     
/* 150 */     this.timer.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateAnimhealth(float easing) {
/* 155 */     float f1 = 2.0F, f2 = 6.5F, f4 = easing - this.easinghealth, f3 = this.easinghealth; NewEffects newEffects = this; boolean bool = false; float f5 = (float)Math.pow(f1, f2); newEffects.easinghealth = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 157 */     if (!this.timer.hasTimePassed(2L)) {
/*     */       return;
/*     */     }
/*     */     
/* 161 */     this.healthamin += true;
/*     */     
/* 163 */     this.timer.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   private final String intToRomanByGreedy(int num) {
/* 168 */     int j = num;
/* 169 */     int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/* 170 */     String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/* 171 */     StringBuilder stringBuilder = new StringBuilder();
/* 172 */     int i = 0;
/* 173 */     while (i < values.length && j >= 0) {
/* 174 */       while (values[i] <= j) {
/* 175 */         j -= values[i];
/* 176 */         stringBuilder.append(symbols[i]);
/*     */       } 
/* 178 */       i++;
/*     */     } 
/* 180 */     Intrinsics.checkExpressionValueIsNotNull(stringBuilder.toString(), "stringBuilder.toString()"); return stringBuilder.toString();
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NewEffects$Companion;", "", "()V", "blur", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {} }
/* 184 */   public static final Companion Companion = new Companion(null); static { blur = new BoolValue("Blur", true); }
/*     */ 
/*     */   
/*     */   public NewEffects() {
/*     */     this(0.0D, 0.0D, 0.0F, 7, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\NewEffects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */