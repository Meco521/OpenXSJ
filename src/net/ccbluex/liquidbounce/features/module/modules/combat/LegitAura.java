/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "LegitAura", description = "安全杀戮", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\003\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\023\032\0020\0242\006\020\025\032\0020\026H\007J\020\020\027\032\0020\0242\006\020\025\032\0020\030H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\013X\016¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\017X\004¢\006\002\n\000R\016\020\021\032\0020\bX\004¢\006\002\n\000R\016\020\022\032\0020\bX\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/LegitAura;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "centerValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "clickTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "fovValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "jitterValue", "leftDelay", "", "leftLastSwing", "lockValue", "maxCPSValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "minCPSValue", "rangeValue", "turnSpeedValue", "onRender", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "XSJClient"})
/*    */ public final class LegitAura
/*    */   extends Module
/*    */ {
/* 29 */   private final IntegerValue maxCPSValue = new LegitAura$maxCPSValue$1("MaxCPS", 8, 1, 20); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/LegitAura$maxCPSValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class LegitAura$maxCPSValue$1 extends IntegerValue { LegitAura$maxCPSValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */     
/*    */     protected void onChanged(int oldValue, int newValue) {
/* 32 */       int minCPS = ((Number)LegitAura.this.minCPSValue.get()).intValue();
/* 33 */       if (minCPS > newValue) {
/* 34 */         set(Integer.valueOf(minCPS));
/*    */       }
/*    */     } }
/*    */ 
/*    */   
/* 39 */   private final IntegerValue minCPSValue = new LegitAura$minCPSValue$1("MinCPS", 5, 1, 20); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/LegitAura$minCPSValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class LegitAura$minCPSValue$1 extends IntegerValue { LegitAura$minCPSValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */     
/*    */     protected void onChanged(int oldValue, int newValue) {
/* 42 */       int maxCPS = ((Number)LegitAura.this.maxCPSValue.get()).intValue();
/* 43 */       if (maxCPS < newValue) {
/* 44 */         set(Integer.valueOf(maxCPS));
/*    */       }
/*    */     } }
/*    */ 
/*    */   
/* 49 */   private final FloatValue rangeValue = new FloatValue("Range", 4.4F, 1.0F, 8.0F);
/* 50 */   private final FloatValue turnSpeedValue = new FloatValue("TurnSpeed", 2.0F, 1.0F, 180.0F);
/* 51 */   private final FloatValue fovValue = new FloatValue("FOV", 180.0F, 1.0F, 180.0F);
/* 52 */   private final BoolValue centerValue = new BoolValue("Center", false);
/* 53 */   private final BoolValue lockValue = new BoolValue("Lock", true);
/* 54 */   private final BoolValue jitterValue = new BoolValue("Jitter", false);
/*    */   
/* 56 */   private final MSTimer clickTimer = new MSTimer();
/* 57 */   private long leftDelay = TimeUtils.randomClickDelay(((Number)this.minCPSValue.get()).intValue(), ((Number)this.maxCPSValue.get()).intValue());
/*    */   
/*    */   private long leftLastSwing;
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender(@NotNull Render3DEvent event) {
/* 63 */     Intrinsics.checkParameterIsNotNull(event, "event");
/* 64 */     if (MinecraftInstance.mc.getGameSettings().getKeyBindAttack().isKeyDown() && System.currentTimeMillis() - this.leftLastSwing >= this.leftDelay && MinecraftInstance.mc.getPlayerController().getCurBlockDamageMP() == 0.0F) {
/* 65 */       MinecraftInstance.mc.getGameSettings().getKeyBindAttack().onTick(MinecraftInstance.mc.getGameSettings().getKeyBindAttack().getKeyCode());
/*    */       
/* 67 */       this.leftLastSwing = System.currentTimeMillis();
/* 68 */       this.leftDelay = TimeUtils.randomClickDelay(((Number)this.minCPSValue.get()).intValue(), ((Number)this.maxCPSValue.get()).intValue());
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onStrafe(@NotNull StrafeEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   9: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   14: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   19: invokeinterface isKeyDown : ()Z
/*    */     //   24: ifeq -> 34
/*    */     //   27: aload_0
/*    */     //   28: getfield clickTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   31: invokevirtual reset : ()V
/*    */     //   34: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   37: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   42: dup
/*    */     //   43: ifnull -> 49
/*    */     //   46: goto -> 51
/*    */     //   49: pop
/*    */     //   50: return
/*    */     //   51: astore_2
/*    */     //   52: aload_0
/*    */     //   53: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   56: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   59: checkcast java/lang/Number
/*    */     //   62: invokevirtual floatValue : ()F
/*    */     //   65: fstore_3
/*    */     //   66: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   69: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   74: dup
/*    */     //   75: ifnonnull -> 81
/*    */     //   78: invokestatic throwNpe : ()V
/*    */     //   81: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*    */     //   86: checkcast java/lang/Iterable
/*    */     //   89: astore #5
/*    */     //   91: iconst_0
/*    */     //   92: istore #6
/*    */     //   94: aload #5
/*    */     //   96: astore #7
/*    */     //   98: new java/util/ArrayList
/*    */     //   101: dup
/*    */     //   102: invokespecial <init> : ()V
/*    */     //   105: checkcast java/util/Collection
/*    */     //   108: astore #8
/*    */     //   110: iconst_0
/*    */     //   111: istore #9
/*    */     //   113: aload #7
/*    */     //   115: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   120: astore #11
/*    */     //   122: aload #11
/*    */     //   124: invokeinterface hasNext : ()Z
/*    */     //   129: ifeq -> 229
/*    */     //   132: aload #11
/*    */     //   134: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   139: astore #12
/*    */     //   141: aload #12
/*    */     //   143: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   146: astore #14
/*    */     //   148: iconst_0
/*    */     //   149: istore #15
/*    */     //   151: aload #14
/*    */     //   153: iconst_1
/*    */     //   154: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*    */     //   157: ifeq -> 212
/*    */     //   160: aload_2
/*    */     //   161: aload #14
/*    */     //   163: invokeinterface canEntityBeSeen : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*    */     //   168: ifeq -> 212
/*    */     //   171: aload_2
/*    */     //   172: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   175: aload #14
/*    */     //   177: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   180: fload_3
/*    */     //   181: f2d
/*    */     //   182: dcmpg
/*    */     //   183: ifgt -> 212
/*    */     //   186: aload #14
/*    */     //   188: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   191: aload_0
/*    */     //   192: getfield fovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   195: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   198: checkcast java/lang/Number
/*    */     //   201: invokevirtual doubleValue : ()D
/*    */     //   204: dcmpg
/*    */     //   205: ifgt -> 212
/*    */     //   208: iconst_1
/*    */     //   209: goto -> 213
/*    */     //   212: iconst_0
/*    */     //   213: ifeq -> 122
/*    */     //   216: aload #8
/*    */     //   218: aload #12
/*    */     //   220: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   225: pop
/*    */     //   226: goto -> 122
/*    */     //   229: aload #8
/*    */     //   231: checkcast java/util/List
/*    */     //   234: checkcast java/lang/Iterable
/*    */     //   237: astore #5
/*    */     //   239: iconst_0
/*    */     //   240: istore #6
/*    */     //   242: aload #5
/*    */     //   244: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   249: astore #7
/*    */     //   251: aload #7
/*    */     //   253: invokeinterface hasNext : ()Z
/*    */     //   258: ifne -> 265
/*    */     //   261: aconst_null
/*    */     //   262: goto -> 362
/*    */     //   265: aload #7
/*    */     //   267: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   272: astore #8
/*    */     //   274: aload #7
/*    */     //   276: invokeinterface hasNext : ()Z
/*    */     //   281: ifne -> 289
/*    */     //   284: aload #8
/*    */     //   286: goto -> 362
/*    */     //   289: aload #8
/*    */     //   291: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   294: astore #9
/*    */     //   296: iconst_0
/*    */     //   297: istore #11
/*    */     //   299: aload #9
/*    */     //   301: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   304: dstore #9
/*    */     //   306: aload #7
/*    */     //   308: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   313: astore #11
/*    */     //   315: aload #11
/*    */     //   317: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   320: astore #12
/*    */     //   322: iconst_0
/*    */     //   323: istore #14
/*    */     //   325: aload #12
/*    */     //   327: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   330: dstore #12
/*    */     //   332: dload #9
/*    */     //   334: dload #12
/*    */     //   336: invokestatic compare : (DD)I
/*    */     //   339: ifle -> 350
/*    */     //   342: aload #11
/*    */     //   344: astore #8
/*    */     //   346: dload #12
/*    */     //   348: dstore #9
/*    */     //   350: aload #7
/*    */     //   352: invokeinterface hasNext : ()Z
/*    */     //   357: ifne -> 306
/*    */     //   360: aload #8
/*    */     //   362: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   365: dup
/*    */     //   366: ifnull -> 372
/*    */     //   369: goto -> 374
/*    */     //   372: pop
/*    */     //   373: return
/*    */     //   374: astore #4
/*    */     //   376: aload_0
/*    */     //   377: getfield lockValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   380: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   383: checkcast java/lang/Boolean
/*    */     //   386: invokevirtual booleanValue : ()Z
/*    */     //   389: ifne -> 403
/*    */     //   392: aload #4
/*    */     //   394: fload_3
/*    */     //   395: f2d
/*    */     //   396: invokestatic isFaced : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;D)Z
/*    */     //   399: ifeq -> 403
/*    */     //   402: return
/*    */     //   403: new net/ccbluex/liquidbounce/utils/Rotation
/*    */     //   406: dup
/*    */     //   407: aload_2
/*    */     //   408: invokeinterface getRotationYaw : ()F
/*    */     //   413: aload_2
/*    */     //   414: invokeinterface getRotationPitch : ()F
/*    */     //   419: invokespecial <init> : (FF)V
/*    */     //   422: aload_0
/*    */     //   423: getfield centerValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   426: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   429: checkcast java/lang/Boolean
/*    */     //   432: invokevirtual booleanValue : ()Z
/*    */     //   435: ifeq -> 455
/*    */     //   438: aload #4
/*    */     //   440: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*    */     //   445: invokestatic getCenter : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*    */     //   448: iconst_1
/*    */     //   449: invokestatic toRotation : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Z)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   452: goto -> 473
/*    */     //   455: aload #4
/*    */     //   457: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*    */     //   462: iconst_0
/*    */     //   463: iconst_0
/*    */     //   464: iconst_1
/*    */     //   465: iconst_0
/*    */     //   466: fload_3
/*    */     //   467: invokestatic searchCenter : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;ZZZZF)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*    */     //   470: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   473: aload_0
/*    */     //   474: getfield turnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   477: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   480: checkcast java/lang/Number
/*    */     //   483: invokevirtual doubleValue : ()D
/*    */     //   486: invokestatic random : ()D
/*    */     //   489: dadd
/*    */     //   490: d2f
/*    */     //   491: invokestatic limitAngleChange : (Lnet/ccbluex/liquidbounce/utils/Rotation;Lnet/ccbluex/liquidbounce/utils/Rotation;F)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   494: dup
/*    */     //   495: ldc_w 'RotationUtils.limitAngle…om()).toFloat()\\n        )'
/*    */     //   498: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   501: astore #5
/*    */     //   503: aload #5
/*    */     //   505: aload_2
/*    */     //   506: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer
/*    */     //   509: invokevirtual toPlayer : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;)V
/*    */     //   512: aload_0
/*    */     //   513: getfield jitterValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   516: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   519: checkcast java/lang/Boolean
/*    */     //   522: invokevirtual booleanValue : ()Z
/*    */     //   525: ifeq -> 693
/*    */     //   528: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   531: invokevirtual nextBoolean : ()Z
/*    */     //   534: istore #6
/*    */     //   536: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   539: invokevirtual nextBoolean : ()Z
/*    */     //   542: istore #7
/*    */     //   544: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   547: invokevirtual nextBoolean : ()Z
/*    */     //   550: istore #8
/*    */     //   552: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   555: invokevirtual nextBoolean : ()Z
/*    */     //   558: istore #9
/*    */     //   560: iload #6
/*    */     //   562: ifeq -> 603
/*    */     //   565: aload_2
/*    */     //   566: dup
/*    */     //   567: invokeinterface getRotationYaw : ()F
/*    */     //   572: iload #8
/*    */     //   574: ifeq -> 589
/*    */     //   577: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   580: fconst_0
/*    */     //   581: fconst_1
/*    */     //   582: invokevirtual nextFloat : (FF)F
/*    */     //   585: fneg
/*    */     //   586: goto -> 597
/*    */     //   589: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   592: fconst_0
/*    */     //   593: fconst_1
/*    */     //   594: invokevirtual nextFloat : (FF)F
/*    */     //   597: fadd
/*    */     //   598: invokeinterface setRotationYaw : (F)V
/*    */     //   603: iload #7
/*    */     //   605: ifeq -> 693
/*    */     //   608: aload_2
/*    */     //   609: dup
/*    */     //   610: invokeinterface getRotationPitch : ()F
/*    */     //   615: iload #9
/*    */     //   617: ifeq -> 632
/*    */     //   620: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   623: fconst_0
/*    */     //   624: fconst_1
/*    */     //   625: invokevirtual nextFloat : (FF)F
/*    */     //   628: fneg
/*    */     //   629: goto -> 640
/*    */     //   632: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   635: fconst_0
/*    */     //   636: fconst_1
/*    */     //   637: invokevirtual nextFloat : (FF)F
/*    */     //   640: fadd
/*    */     //   641: invokeinterface setRotationPitch : (F)V
/*    */     //   646: aload_2
/*    */     //   647: invokeinterface getRotationPitch : ()F
/*    */     //   652: bipush #90
/*    */     //   654: i2f
/*    */     //   655: fcmpl
/*    */     //   656: ifle -> 671
/*    */     //   659: aload_2
/*    */     //   660: ldc_w 90.0
/*    */     //   663: invokeinterface setRotationPitch : (F)V
/*    */     //   668: goto -> 693
/*    */     //   671: aload_2
/*    */     //   672: invokeinterface getRotationPitch : ()F
/*    */     //   677: bipush #-90
/*    */     //   679: i2f
/*    */     //   680: fcmpg
/*    */     //   681: ifge -> 693
/*    */     //   684: aload_2
/*    */     //   685: ldc_w -90.0
/*    */     //   688: invokeinterface setRotationPitch : (F)V
/*    */     //   693: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #75	-> 6
/*    */     //   #76	-> 27
/*    */     //   #79	-> 34
/*    */     //   #79	-> 49
/*    */     //   #81	-> 52
/*    */     //   #82	-> 66
/*    */     //   #87	-> 66
/*    */     //   #82	-> 66
/*    */     //   #83	-> 66
/*    */     //   #82	-> 66
/*    */     //   #83	-> 91
/*    */     //   #123	-> 94
/*    */     //   #124	-> 113
/*    */     //   #84	-> 151
/*    */     //   #85	-> 151
/*    */     //   #84	-> 151
/*    */     //   #85	-> 171
/*    */     //   #125	-> 229
/*    */     //   #87	-> 239
/*    */     //   #126	-> 242
/*    */     //   #127	-> 251
/*    */     //   #128	-> 265
/*    */     //   #129	-> 274
/*    */     //   #130	-> 289
/*    */     //   #87	-> 299
/*    */     //   #131	-> 306
/*    */     //   #132	-> 306
/*    */     //   #133	-> 315
/*    */     //   #87	-> 325
/*    */     //   #134	-> 332
/*    */     //   #135	-> 342
/*    */     //   #136	-> 346
/*    */     //   #138	-> 350
/*    */     //   #139	-> 360
/*    */     //   #87	-> 373
/*    */     //   #82	-> 374
/*    */     //   #89	-> 376
/*    */     //   #90	-> 402
/*    */     //   #92	-> 403
/*    */     //   #93	-> 403
/*    */     //   #94	-> 422
/*    */     //   #95	-> 438
/*    */     //   #97	-> 455
/*    */     //   #98	-> 455
/*    */     //   #97	-> 455
/*    */     //   #98	-> 465
/*    */     //   #97	-> 467
/*    */     //   #94	-> 473
/*    */     //   #99	-> 473
/*    */     //   #92	-> 491
/*    */     //   #102	-> 503
/*    */     //   #104	-> 512
/*    */     //   #105	-> 528
/*    */     //   #106	-> 536
/*    */     //   #107	-> 544
/*    */     //   #108	-> 552
/*    */     //   #110	-> 560
/*    */     //   #111	-> 565
/*    */     //   #113	-> 603
/*    */     //   #114	-> 608
/*    */     //   #115	-> 646
/*    */     //   #116	-> 659
/*    */     //   #117	-> 671
/*    */     //   #118	-> 684
/*    */     //   #121	-> 693
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   148	65	14	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   151	62	15	$i$a$-filter-LegitAura$onStrafe$entity$1	I
/*    */     //   141	85	12	element$iv$iv	Ljava/lang/Object;
/*    */     //   110	121	7	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*    */     //   110	121	8	destination$iv$iv	Ljava/util/Collection;
/*    */     //   113	118	9	$i$f$filterTo	I
/*    */     //   91	143	5	$this$filter$iv	Ljava/lang/Iterable;
/*    */     //   94	140	6	$i$f$filter	I
/*    */     //   296	8	9	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   299	5	11	$i$a$-minBy-LegitAura$onStrafe$entity$2	I
/*    */     //   322	8	12	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   325	5	14	$i$a$-minBy-LegitAura$onStrafe$entity$2	I
/*    */     //   332	28	12	v$iv	D
/*    */     //   315	45	11	e$iv	Ljava/lang/Object;
/*    */     //   306	56	9	minValue$iv	D
/*    */     //   274	88	8	minElem$iv	Ljava/lang/Object;
/*    */     //   251	111	7	iterator$iv	Ljava/util/Iterator;
/*    */     //   239	123	5	$this$minBy$iv	Ljava/lang/Iterable;
/*    */     //   242	120	6	$i$f$minBy	I
/*    */     //   560	133	9	pitchNegative	Z
/*    */     //   552	141	8	yawNegative	Z
/*    */     //   544	149	7	pitch	Z
/*    */     //   536	157	6	yaw	Z
/*    */     //   503	191	5	rotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   376	318	4	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   66	628	3	range	F
/*    */     //   52	642	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	694	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/LegitAura;
/*    */     //   0	694	1	event	Lnet/ccbluex/liquidbounce/event/StrafeEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\LegitAura.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */