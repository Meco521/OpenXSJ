/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "Aimbot", description = "Automatically faces selected entities around you.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000R\016\020\f\032\0020\bX\004¢\006\002\n\000R\016\020\r\032\0020\bX\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Aimbot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "centerValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "clickTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "fovValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "jitterValue", "lockValue", "onClickValue", "rangeValue", "turnSpeedValue", "onStrafe", "", "event", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "XSJClient"})
/*    */ public final class Aimbot
/*    */   extends Module
/*    */ {
/* 22 */   private final FloatValue rangeValue = new FloatValue("Range", 4.4F, 1.0F, 8.0F);
/* 23 */   private final FloatValue turnSpeedValue = new FloatValue("TurnSpeed", 2.0F, 1.0F, 180.0F);
/* 24 */   private final FloatValue fovValue = new FloatValue("FOV", 180.0F, 1.0F, 180.0F);
/* 25 */   private final BoolValue centerValue = new BoolValue("Center", false);
/* 26 */   private final BoolValue lockValue = new BoolValue("Lock", true);
/* 27 */   private final BoolValue onClickValue = new BoolValue("OnClick", false);
/* 28 */   private final BoolValue jitterValue = new BoolValue("Jitter", false);
/*    */   
/* 30 */   private final MSTimer clickTimer = new MSTimer();
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
/*    */     //   34: aload_0
/*    */     //   35: getfield onClickValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   38: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   41: checkcast java/lang/Boolean
/*    */     //   44: invokevirtual booleanValue : ()Z
/*    */     //   47: ifeq -> 64
/*    */     //   50: aload_0
/*    */     //   51: getfield clickTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   54: ldc2_w 500
/*    */     //   57: invokevirtual hasTimePassed : (J)Z
/*    */     //   60: ifeq -> 64
/*    */     //   63: return
/*    */     //   64: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   67: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   72: dup
/*    */     //   73: ifnull -> 79
/*    */     //   76: goto -> 81
/*    */     //   79: pop
/*    */     //   80: return
/*    */     //   81: astore_2
/*    */     //   82: aload_0
/*    */     //   83: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   86: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   89: checkcast java/lang/Number
/*    */     //   92: invokevirtual floatValue : ()F
/*    */     //   95: fstore_3
/*    */     //   96: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   99: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   104: dup
/*    */     //   105: ifnonnull -> 111
/*    */     //   108: invokestatic throwNpe : ()V
/*    */     //   111: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*    */     //   116: checkcast java/lang/Iterable
/*    */     //   119: astore #5
/*    */     //   121: iconst_0
/*    */     //   122: istore #6
/*    */     //   124: aload #5
/*    */     //   126: astore #7
/*    */     //   128: new java/util/ArrayList
/*    */     //   131: dup
/*    */     //   132: invokespecial <init> : ()V
/*    */     //   135: checkcast java/util/Collection
/*    */     //   138: astore #8
/*    */     //   140: iconst_0
/*    */     //   141: istore #9
/*    */     //   143: aload #7
/*    */     //   145: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   150: astore #11
/*    */     //   152: aload #11
/*    */     //   154: invokeinterface hasNext : ()Z
/*    */     //   159: ifeq -> 259
/*    */     //   162: aload #11
/*    */     //   164: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   169: astore #12
/*    */     //   171: aload #12
/*    */     //   173: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   176: astore #14
/*    */     //   178: iconst_0
/*    */     //   179: istore #15
/*    */     //   181: aload #14
/*    */     //   183: iconst_1
/*    */     //   184: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*    */     //   187: ifeq -> 242
/*    */     //   190: aload_2
/*    */     //   191: aload #14
/*    */     //   193: invokeinterface canEntityBeSeen : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*    */     //   198: ifeq -> 242
/*    */     //   201: aload_2
/*    */     //   202: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   205: aload #14
/*    */     //   207: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   210: fload_3
/*    */     //   211: f2d
/*    */     //   212: dcmpg
/*    */     //   213: ifgt -> 242
/*    */     //   216: aload #14
/*    */     //   218: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   221: aload_0
/*    */     //   222: getfield fovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   225: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   228: checkcast java/lang/Number
/*    */     //   231: invokevirtual doubleValue : ()D
/*    */     //   234: dcmpg
/*    */     //   235: ifgt -> 242
/*    */     //   238: iconst_1
/*    */     //   239: goto -> 243
/*    */     //   242: iconst_0
/*    */     //   243: ifeq -> 152
/*    */     //   246: aload #8
/*    */     //   248: aload #12
/*    */     //   250: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   255: pop
/*    */     //   256: goto -> 152
/*    */     //   259: aload #8
/*    */     //   261: checkcast java/util/List
/*    */     //   264: checkcast java/lang/Iterable
/*    */     //   267: astore #5
/*    */     //   269: iconst_0
/*    */     //   270: istore #6
/*    */     //   272: aload #5
/*    */     //   274: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   279: astore #7
/*    */     //   281: aload #7
/*    */     //   283: invokeinterface hasNext : ()Z
/*    */     //   288: ifne -> 295
/*    */     //   291: aconst_null
/*    */     //   292: goto -> 392
/*    */     //   295: aload #7
/*    */     //   297: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   302: astore #8
/*    */     //   304: aload #7
/*    */     //   306: invokeinterface hasNext : ()Z
/*    */     //   311: ifne -> 319
/*    */     //   314: aload #8
/*    */     //   316: goto -> 392
/*    */     //   319: aload #8
/*    */     //   321: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   324: astore #9
/*    */     //   326: iconst_0
/*    */     //   327: istore #11
/*    */     //   329: aload #9
/*    */     //   331: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   334: dstore #9
/*    */     //   336: aload #7
/*    */     //   338: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   343: astore #11
/*    */     //   345: aload #11
/*    */     //   347: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   350: astore #12
/*    */     //   352: iconst_0
/*    */     //   353: istore #14
/*    */     //   355: aload #12
/*    */     //   357: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   360: dstore #12
/*    */     //   362: dload #9
/*    */     //   364: dload #12
/*    */     //   366: invokestatic compare : (DD)I
/*    */     //   369: ifle -> 380
/*    */     //   372: aload #11
/*    */     //   374: astore #8
/*    */     //   376: dload #12
/*    */     //   378: dstore #9
/*    */     //   380: aload #7
/*    */     //   382: invokeinterface hasNext : ()Z
/*    */     //   387: ifne -> 336
/*    */     //   390: aload #8
/*    */     //   392: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   395: dup
/*    */     //   396: ifnull -> 402
/*    */     //   399: goto -> 404
/*    */     //   402: pop
/*    */     //   403: return
/*    */     //   404: astore #4
/*    */     //   406: aload_0
/*    */     //   407: getfield lockValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   410: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   413: checkcast java/lang/Boolean
/*    */     //   416: invokevirtual booleanValue : ()Z
/*    */     //   419: ifne -> 433
/*    */     //   422: aload #4
/*    */     //   424: fload_3
/*    */     //   425: f2d
/*    */     //   426: invokestatic isFaced : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;D)Z
/*    */     //   429: ifeq -> 433
/*    */     //   432: return
/*    */     //   433: new net/ccbluex/liquidbounce/utils/Rotation
/*    */     //   436: dup
/*    */     //   437: aload_2
/*    */     //   438: invokeinterface getRotationYaw : ()F
/*    */     //   443: aload_2
/*    */     //   444: invokeinterface getRotationPitch : ()F
/*    */     //   449: invokespecial <init> : (FF)V
/*    */     //   452: aload_0
/*    */     //   453: getfield centerValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   456: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   459: checkcast java/lang/Boolean
/*    */     //   462: invokevirtual booleanValue : ()Z
/*    */     //   465: ifeq -> 485
/*    */     //   468: aload #4
/*    */     //   470: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*    */     //   475: invokestatic getCenter : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*    */     //   478: iconst_1
/*    */     //   479: invokestatic toRotation : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Z)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   482: goto -> 503
/*    */     //   485: aload #4
/*    */     //   487: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*    */     //   492: iconst_0
/*    */     //   493: iconst_0
/*    */     //   494: iconst_1
/*    */     //   495: iconst_0
/*    */     //   496: fload_3
/*    */     //   497: invokestatic searchCenter : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;ZZZZF)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*    */     //   500: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   503: aload_0
/*    */     //   504: getfield turnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   507: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   510: checkcast java/lang/Number
/*    */     //   513: invokevirtual doubleValue : ()D
/*    */     //   516: invokestatic random : ()D
/*    */     //   519: dadd
/*    */     //   520: d2f
/*    */     //   521: invokestatic limitAngleChange : (Lnet/ccbluex/liquidbounce/utils/Rotation;Lnet/ccbluex/liquidbounce/utils/Rotation;F)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   524: dup
/*    */     //   525: ldc 'RotationUtils.limitAngle…om()).toFloat()\\n        )'
/*    */     //   527: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   530: astore #5
/*    */     //   532: aload #5
/*    */     //   534: aload_2
/*    */     //   535: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer
/*    */     //   538: invokevirtual toPlayer : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;)V
/*    */     //   541: aload_0
/*    */     //   542: getfield jitterValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   545: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   548: checkcast java/lang/Boolean
/*    */     //   551: invokevirtual booleanValue : ()Z
/*    */     //   554: ifeq -> 722
/*    */     //   557: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   560: invokevirtual nextBoolean : ()Z
/*    */     //   563: istore #6
/*    */     //   565: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   568: invokevirtual nextBoolean : ()Z
/*    */     //   571: istore #7
/*    */     //   573: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   576: invokevirtual nextBoolean : ()Z
/*    */     //   579: istore #8
/*    */     //   581: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*    */     //   584: invokevirtual nextBoolean : ()Z
/*    */     //   587: istore #9
/*    */     //   589: iload #6
/*    */     //   591: ifeq -> 632
/*    */     //   594: aload_2
/*    */     //   595: dup
/*    */     //   596: invokeinterface getRotationYaw : ()F
/*    */     //   601: iload #8
/*    */     //   603: ifeq -> 618
/*    */     //   606: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   609: fconst_0
/*    */     //   610: fconst_1
/*    */     //   611: invokevirtual nextFloat : (FF)F
/*    */     //   614: fneg
/*    */     //   615: goto -> 626
/*    */     //   618: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   621: fconst_0
/*    */     //   622: fconst_1
/*    */     //   623: invokevirtual nextFloat : (FF)F
/*    */     //   626: fadd
/*    */     //   627: invokeinterface setRotationYaw : (F)V
/*    */     //   632: iload #7
/*    */     //   634: ifeq -> 722
/*    */     //   637: aload_2
/*    */     //   638: dup
/*    */     //   639: invokeinterface getRotationPitch : ()F
/*    */     //   644: iload #9
/*    */     //   646: ifeq -> 661
/*    */     //   649: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   652: fconst_0
/*    */     //   653: fconst_1
/*    */     //   654: invokevirtual nextFloat : (FF)F
/*    */     //   657: fneg
/*    */     //   658: goto -> 669
/*    */     //   661: getstatic net/ccbluex/liquidbounce/utils/misc/RandomUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/misc/RandomUtils;
/*    */     //   664: fconst_0
/*    */     //   665: fconst_1
/*    */     //   666: invokevirtual nextFloat : (FF)F
/*    */     //   669: fadd
/*    */     //   670: invokeinterface setRotationPitch : (F)V
/*    */     //   675: aload_2
/*    */     //   676: invokeinterface getRotationPitch : ()F
/*    */     //   681: bipush #90
/*    */     //   683: i2f
/*    */     //   684: fcmpl
/*    */     //   685: ifle -> 700
/*    */     //   688: aload_2
/*    */     //   689: ldc_w 90.0
/*    */     //   692: invokeinterface setRotationPitch : (F)V
/*    */     //   697: goto -> 722
/*    */     //   700: aload_2
/*    */     //   701: invokeinterface getRotationPitch : ()F
/*    */     //   706: bipush #-90
/*    */     //   708: i2f
/*    */     //   709: fcmpg
/*    */     //   710: ifge -> 722
/*    */     //   713: aload_2
/*    */     //   714: ldc_w -90.0
/*    */     //   717: invokeinterface setRotationPitch : (F)V
/*    */     //   722: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #34	-> 6
/*    */     //   #35	-> 27
/*    */     //   #37	-> 34
/*    */     //   #38	-> 63
/*    */     //   #40	-> 64
/*    */     //   #40	-> 79
/*    */     //   #42	-> 82
/*    */     //   #43	-> 96
/*    */     //   #48	-> 96
/*    */     //   #43	-> 96
/*    */     //   #44	-> 96
/*    */     //   #43	-> 96
/*    */     //   #44	-> 121
/*    */     //   #84	-> 124
/*    */     //   #85	-> 143
/*    */     //   #45	-> 181
/*    */     //   #46	-> 181
/*    */     //   #45	-> 181
/*    */     //   #46	-> 201
/*    */     //   #86	-> 259
/*    */     //   #48	-> 269
/*    */     //   #87	-> 272
/*    */     //   #88	-> 281
/*    */     //   #89	-> 295
/*    */     //   #90	-> 304
/*    */     //   #91	-> 319
/*    */     //   #48	-> 329
/*    */     //   #92	-> 336
/*    */     //   #93	-> 336
/*    */     //   #94	-> 345
/*    */     //   #48	-> 355
/*    */     //   #95	-> 362
/*    */     //   #96	-> 372
/*    */     //   #97	-> 376
/*    */     //   #99	-> 380
/*    */     //   #100	-> 390
/*    */     //   #48	-> 403
/*    */     //   #43	-> 404
/*    */     //   #50	-> 406
/*    */     //   #51	-> 432
/*    */     //   #53	-> 433
/*    */     //   #54	-> 433
/*    */     //   #55	-> 452
/*    */     //   #56	-> 468
/*    */     //   #58	-> 485
/*    */     //   #59	-> 485
/*    */     //   #58	-> 485
/*    */     //   #59	-> 495
/*    */     //   #58	-> 497
/*    */     //   #55	-> 503
/*    */     //   #60	-> 503
/*    */     //   #53	-> 521
/*    */     //   #63	-> 532
/*    */     //   #65	-> 541
/*    */     //   #66	-> 557
/*    */     //   #67	-> 565
/*    */     //   #68	-> 573
/*    */     //   #69	-> 581
/*    */     //   #71	-> 589
/*    */     //   #72	-> 594
/*    */     //   #74	-> 632
/*    */     //   #75	-> 637
/*    */     //   #76	-> 675
/*    */     //   #77	-> 688
/*    */     //   #78	-> 700
/*    */     //   #79	-> 713
/*    */     //   #82	-> 722
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   178	65	14	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   181	62	15	$i$a$-filter-Aimbot$onStrafe$entity$1	I
/*    */     //   171	85	12	element$iv$iv	Ljava/lang/Object;
/*    */     //   140	121	7	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*    */     //   140	121	8	destination$iv$iv	Ljava/util/Collection;
/*    */     //   143	118	9	$i$f$filterTo	I
/*    */     //   121	143	5	$this$filter$iv	Ljava/lang/Iterable;
/*    */     //   124	140	6	$i$f$filter	I
/*    */     //   326	8	9	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   329	5	11	$i$a$-minBy-Aimbot$onStrafe$entity$2	I
/*    */     //   352	8	12	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   355	5	14	$i$a$-minBy-Aimbot$onStrafe$entity$2	I
/*    */     //   362	28	12	v$iv	D
/*    */     //   345	45	11	e$iv	Ljava/lang/Object;
/*    */     //   336	56	9	minValue$iv	D
/*    */     //   304	88	8	minElem$iv	Ljava/lang/Object;
/*    */     //   281	111	7	iterator$iv	Ljava/util/Iterator;
/*    */     //   269	123	5	$this$minBy$iv	Ljava/lang/Iterable;
/*    */     //   272	120	6	$i$f$minBy	I
/*    */     //   589	133	9	pitchNegative	Z
/*    */     //   581	141	8	yawNegative	Z
/*    */     //   573	149	7	pitch	Z
/*    */     //   565	157	6	yaw	Z
/*    */     //   532	191	5	rotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   406	317	4	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   96	627	3	range	F
/*    */     //   82	641	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	723	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Aimbot;
/*    */     //   0	723	1	event	Lnet/ccbluex/liquidbounce/event/StrafeEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Aimbot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */