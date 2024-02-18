/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "AutoSkyWars", category = ModuleCategory.RETREAT, description = "space.bilibili.com/500398541")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\005\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\031\032\0020\032H\026J\b\020\033\032\0020\034H\026J\020\020\035\032\0020\0342\006\020\036\032\0020\037H\007J\020\020 \032\0020\0342\006\020\036\032\0020!H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\bX\004¢\006\002\n\000R\016\020\n\032\0020\bX\004¢\006\002\n\000R\016\020\013\032\0020\bX\004¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000R\016\020\r\032\0020\bX\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\024\020\023\032\0020\0248VX\004¢\006\006\032\004\b\025\020\026R\016\020\027\032\0020\022X\004¢\006\002\n\000R\016\020\030\032\0020\022X\004¢\006\002\n\000¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "SilentNoChat", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "TPtimes", "", "Times", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "X", "Y", "Z", "centerValue", "height", "lockValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "rangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "turnSpeedValue", "vanillaSpeedValue", "handleEvents", "", "onDisable", "", "onStrafe", "event", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class AutoSkyWars
/*     */   extends Module
/*     */ {
/*  24 */   private final ListValue modeValue = new ListValue("mode", new String[] {
/*  25 */         "firework", 
/*  26 */         "fly", 
/*  27 */         "flyaim", 
/*  28 */         "teleport"
/*  29 */       }, "flyaim");
/*  30 */   private final IntegerValue X = new IntegerValue("posX", 0, -100, 100);
/*  31 */   private final IntegerValue Y = new IntegerValue("posY", 10, 0, 50);
/*  32 */   private final IntegerValue Z = new IntegerValue("posZ", 0, -100, 100);
/*  33 */   private BoolValue SilentNoChat = new BoolValue("SilentNoChat", false);
/*     */ 
/*     */ 
/*     */   
/*  37 */   private final FloatValue vanillaSpeedValue = new FloatValue("FlySpeed", 4.0F, 0.0F, 10.0F);
/*  38 */   private final IntegerValue Times = new IntegerValue("TpTicks", 10, 0, 100);
/*  39 */   private int TPtimes = ((Number)this.Times.get()).intValue();
/*  40 */   private final FloatValue rangeValue = new FloatValue("AimRange", 114514.0F, 1.0F, 114514.0F);
/*  41 */   private final BoolValue centerValue = new BoolValue("Center", false);
/*  42 */   private final BoolValue lockValue = new BoolValue("Lock", true);
/*  43 */   private final FloatValue turnSpeedValue = new FloatValue("TurnSpeed", 360.0F, 360.0F, 114514.0F);
/*  44 */   private final IntegerValue height = new IntegerValue("Teleportheight", 190, 0, 256);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   9: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   12: ldc net/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars
/*     */     //   14: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   17: dup
/*     */     //   18: ifnonnull -> 31
/*     */     //   21: new kotlin/TypeCastException
/*     */     //   24: dup
/*     */     //   25: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.retreat.AutoSkyWars'
/*     */     //   27: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   30: athrow
/*     */     //   31: checkcast net/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars
/*     */     //   34: astore_2
/*     */     //   35: aload_2
/*     */     //   36: invokevirtual getState : ()Z
/*     */     //   39: ifeq -> 1664
/*     */     //   42: aload_0
/*     */     //   43: getfield vanillaSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   46: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   49: checkcast java/lang/Number
/*     */     //   52: invokevirtual floatValue : ()F
/*     */     //   55: fstore_3
/*     */     //   56: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   59: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   64: dup
/*     */     //   65: ifnonnull -> 71
/*     */     //   68: invokestatic throwNpe : ()V
/*     */     //   71: astore #4
/*     */     //   73: aload #4
/*     */     //   75: invokeinterface getCapabilities : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;
/*     */     //   80: invokeinterface isFlying : ()Z
/*     */     //   85: ifeq -> 1588
/*     */     //   88: aload_0
/*     */     //   89: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   92: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   95: checkcast java/lang/String
/*     */     //   98: astore #5
/*     */     //   100: iconst_0
/*     */     //   101: istore #6
/*     */     //   103: aload #5
/*     */     //   105: dup
/*     */     //   106: ifnonnull -> 119
/*     */     //   109: new kotlin/TypeCastException
/*     */     //   112: dup
/*     */     //   113: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   115: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   118: athrow
/*     */     //   119: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   122: dup
/*     */     //   123: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   125: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   128: astore #5
/*     */     //   130: aload #5
/*     */     //   132: invokevirtual hashCode : ()I
/*     */     //   135: lookupswitch default -> 1585, -1360201941 -> 202, -1271352334 -> 215, -562711993 -> 189, 101491 -> 176
/*     */     //   176: aload #5
/*     */     //   178: ldc 'fly'
/*     */     //   180: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   183: ifeq -> 1665
/*     */     //   186: goto -> 225
/*     */     //   189: aload #5
/*     */     //   191: ldc 'firework'
/*     */     //   193: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   196: ifeq -> 1665
/*     */     //   199: goto -> 225
/*     */     //   202: aload #5
/*     */     //   204: ldc 'teleport'
/*     */     //   206: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   209: ifeq -> 1665
/*     */     //   212: goto -> 804
/*     */     //   215: aload #5
/*     */     //   217: ldc 'flyaim'
/*     */     //   219: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   222: ifeq -> 1665
/*     */     //   225: aload_0
/*     */     //   226: getfield TPtimes : I
/*     */     //   229: ifeq -> 506
/*     */     //   232: aload_0
/*     */     //   233: getfield SilentNoChat : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   236: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   239: checkcast java/lang/Boolean
/*     */     //   242: invokevirtual booleanValue : ()Z
/*     */     //   245: ifne -> 253
/*     */     //   248: ldc '[修改空岛出生点]芜湖!起飞！！'
/*     */     //   250: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   253: aload #4
/*     */     //   255: aload #4
/*     */     //   257: invokeinterface getPosX : ()D
/*     */     //   262: aload_0
/*     */     //   263: getfield X : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   266: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   269: checkcast java/lang/Number
/*     */     //   272: invokevirtual doubleValue : ()D
/*     */     //   275: dadd
/*     */     //   276: aload #4
/*     */     //   278: invokeinterface getPosY : ()D
/*     */     //   283: aload_0
/*     */     //   284: getfield Y : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   287: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   290: checkcast java/lang/Number
/*     */     //   293: invokevirtual doubleValue : ()D
/*     */     //   296: dadd
/*     */     //   297: aload #4
/*     */     //   299: invokeinterface getPosZ : ()D
/*     */     //   304: aload_0
/*     */     //   305: getfield Z : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   308: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   311: checkcast java/lang/Number
/*     */     //   314: invokevirtual doubleValue : ()D
/*     */     //   317: dadd
/*     */     //   318: aload #4
/*     */     //   320: invokeinterface getRotationYaw : ()F
/*     */     //   325: aload #4
/*     */     //   327: invokeinterface getRotationPitch : ()F
/*     */     //   332: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   337: aload_0
/*     */     //   338: dup
/*     */     //   339: getfield TPtimes : I
/*     */     //   342: iconst_1
/*     */     //   343: isub
/*     */     //   344: putfield TPtimes : I
/*     */     //   347: aload_0
/*     */     //   348: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   351: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   354: checkcast java/lang/String
/*     */     //   357: astore #6
/*     */     //   359: iconst_0
/*     */     //   360: istore #7
/*     */     //   362: aload #6
/*     */     //   364: dup
/*     */     //   365: ifnonnull -> 378
/*     */     //   368: new kotlin/TypeCastException
/*     */     //   371: dup
/*     */     //   372: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   374: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   377: athrow
/*     */     //   378: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   381: dup
/*     */     //   382: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   384: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   387: astore #6
/*     */     //   389: aload #6
/*     */     //   391: invokevirtual hashCode : ()I
/*     */     //   394: tableswitch default -> 506, -562711993 -> 412
/*     */     //   412: aload #6
/*     */     //   414: ldc 'firework'
/*     */     //   416: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   419: ifeq -> 506
/*     */     //   422: aload #4
/*     */     //   424: aload #4
/*     */     //   426: invokeinterface getPosX : ()D
/*     */     //   431: aload_0
/*     */     //   432: getfield X : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   435: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   438: checkcast java/lang/Number
/*     */     //   441: invokevirtual doubleValue : ()D
/*     */     //   444: dadd
/*     */     //   445: aload #4
/*     */     //   447: invokeinterface getPosY : ()D
/*     */     //   452: aload_0
/*     */     //   453: getfield Y : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   456: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   459: checkcast java/lang/Number
/*     */     //   462: invokevirtual doubleValue : ()D
/*     */     //   465: dadd
/*     */     //   466: aload #4
/*     */     //   468: invokeinterface getPosZ : ()D
/*     */     //   473: aload_0
/*     */     //   474: getfield Z : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   477: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   480: checkcast java/lang/Number
/*     */     //   483: invokevirtual doubleValue : ()D
/*     */     //   486: dadd
/*     */     //   487: aload #4
/*     */     //   489: invokeinterface getRotationYaw : ()F
/*     */     //   494: aload #4
/*     */     //   496: invokeinterface getRotationPitch : ()F
/*     */     //   501: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   506: aload_0
/*     */     //   507: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   510: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   513: checkcast java/lang/String
/*     */     //   516: astore #6
/*     */     //   518: iconst_0
/*     */     //   519: istore #7
/*     */     //   521: aload #6
/*     */     //   523: dup
/*     */     //   524: ifnonnull -> 537
/*     */     //   527: new kotlin/TypeCastException
/*     */     //   530: dup
/*     */     //   531: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   533: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   536: athrow
/*     */     //   537: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   540: dup
/*     */     //   541: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   543: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   546: astore #6
/*     */     //   548: aload #6
/*     */     //   550: invokevirtual hashCode : ()I
/*     */     //   553: lookupswitch default -> 801, -1271352334 -> 593, 101491 -> 580
/*     */     //   580: aload #6
/*     */     //   582: ldc 'fly'
/*     */     //   584: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   587: ifeq -> 1665
/*     */     //   590: goto -> 603
/*     */     //   593: aload #6
/*     */     //   595: ldc 'flyaim'
/*     */     //   597: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   600: ifeq -> 1665
/*     */     //   603: aload #4
/*     */     //   605: dconst_0
/*     */     //   606: invokeinterface setMotionY : (D)V
/*     */     //   611: aload #4
/*     */     //   613: dconst_0
/*     */     //   614: invokeinterface setMotionX : (D)V
/*     */     //   619: aload #4
/*     */     //   621: dconst_0
/*     */     //   622: invokeinterface setMotionZ : (D)V
/*     */     //   627: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   630: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   635: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   640: invokeinterface isKeyDown : ()Z
/*     */     //   645: ifeq -> 664
/*     */     //   648: aload #4
/*     */     //   650: dup
/*     */     //   651: invokeinterface getMotionY : ()D
/*     */     //   656: fload_3
/*     */     //   657: f2d
/*     */     //   658: dadd
/*     */     //   659: invokeinterface setMotionY : (D)V
/*     */     //   664: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   667: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   672: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   677: invokeinterface isKeyDown : ()Z
/*     */     //   682: ifeq -> 701
/*     */     //   685: aload #4
/*     */     //   687: dup
/*     */     //   688: invokeinterface getMotionY : ()D
/*     */     //   693: fload_3
/*     */     //   694: f2d
/*     */     //   695: dsub
/*     */     //   696: invokeinterface setMotionY : (D)V
/*     */     //   701: fload_3
/*     */     //   702: invokestatic strafe : (F)V
/*     */     //   705: aload_0
/*     */     //   706: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   709: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   712: checkcast java/lang/String
/*     */     //   715: astore #7
/*     */     //   717: iconst_0
/*     */     //   718: istore #8
/*     */     //   720: aload #7
/*     */     //   722: dup
/*     */     //   723: ifnonnull -> 736
/*     */     //   726: new kotlin/TypeCastException
/*     */     //   729: dup
/*     */     //   730: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   732: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   735: athrow
/*     */     //   736: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   739: dup
/*     */     //   740: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   742: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   745: astore #7
/*     */     //   747: aload #7
/*     */     //   749: invokevirtual hashCode : ()I
/*     */     //   752: tableswitch default -> 801, -1271352334 -> 772
/*     */     //   772: aload #7
/*     */     //   774: ldc 'flyaim'
/*     */     //   776: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   779: ifeq -> 1665
/*     */     //   782: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   785: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   790: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   795: iconst_1
/*     */     //   796: invokeinterface setPressed : (Z)V
/*     */     //   801: goto -> 1665
/*     */     //   804: aload_0
/*     */     //   805: getfield TPtimes : I
/*     */     //   808: ifeq -> 908
/*     */     //   811: aload #4
/*     */     //   813: aload #4
/*     */     //   815: invokeinterface getPosX : ()D
/*     */     //   820: aload_0
/*     */     //   821: getfield X : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   824: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   827: checkcast java/lang/Number
/*     */     //   830: invokevirtual doubleValue : ()D
/*     */     //   833: dadd
/*     */     //   834: aload #4
/*     */     //   836: invokeinterface getPosY : ()D
/*     */     //   841: aload_0
/*     */     //   842: getfield Y : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   845: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   848: checkcast java/lang/Number
/*     */     //   851: invokevirtual doubleValue : ()D
/*     */     //   854: dadd
/*     */     //   855: aload #4
/*     */     //   857: invokeinterface getPosZ : ()D
/*     */     //   862: aload_0
/*     */     //   863: getfield Z : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   866: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   869: checkcast java/lang/Number
/*     */     //   872: invokevirtual doubleValue : ()D
/*     */     //   875: dadd
/*     */     //   876: aload #4
/*     */     //   878: invokeinterface getRotationYaw : ()F
/*     */     //   883: aload #4
/*     */     //   885: invokeinterface getRotationPitch : ()F
/*     */     //   890: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   895: aload_0
/*     */     //   896: dup
/*     */     //   897: getfield TPtimes : I
/*     */     //   900: iconst_1
/*     */     //   901: isub
/*     */     //   902: putfield TPtimes : I
/*     */     //   905: goto -> 1665
/*     */     //   908: aload #4
/*     */     //   910: invokeinterface getPosX : ()D
/*     */     //   915: dstore #6
/*     */     //   917: aload #4
/*     */     //   919: invokeinterface getPosZ : ()D
/*     */     //   924: dstore #8
/*     */     //   926: dload #6
/*     */     //   928: iconst_5
/*     */     //   929: i2d
/*     */     //   930: ddiv
/*     */     //   931: dstore #10
/*     */     //   933: dload #8
/*     */     //   935: iconst_5
/*     */     //   936: i2d
/*     */     //   937: ddiv
/*     */     //   938: dstore #12
/*     */     //   940: dload #12
/*     */     //   942: bipush #20
/*     */     //   944: i2d
/*     */     //   945: ddiv
/*     */     //   946: dstore #14
/*     */     //   948: dload #10
/*     */     //   950: bipush #20
/*     */     //   952: i2d
/*     */     //   953: ddiv
/*     */     //   954: dstore #16
/*     */     //   956: aload #4
/*     */     //   958: invokeinterface getPosY : ()D
/*     */     //   963: bipush #20
/*     */     //   965: i2d
/*     */     //   966: ddiv
/*     */     //   967: dstore #18
/*     */     //   969: ldc_w '>>>>>>>>>>>>>>>>>>SkyWars Helper<<<<<<<<<<<<<<<<<<'
/*     */     //   972: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   975: ldc_w 'Code by 菜级玩家(bilibili.com)'
/*     */     //   978: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   981: ldc_w 'Only working in HuaYuTing,Thank you for using,XSJ Client'
/*     */     //   984: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   987: new java/lang/StringBuilder
/*     */     //   990: dup
/*     */     //   991: invokespecial <init> : ()V
/*     */     //   994: ldc_w '>>>PosX-> '
/*     */     //   997: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1000: dload #6
/*     */     //   1002: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   1005: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1008: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1011: new java/lang/StringBuilder
/*     */     //   1014: dup
/*     */     //   1015: invokespecial <init> : ()V
/*     */     //   1018: ldc_w '>>>PosZ-> '
/*     */     //   1021: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1024: dload #8
/*     */     //   1026: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   1029: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1032: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1035: dload #10
/*     */     //   1037: d2i
/*     */     //   1038: ifne -> 1050
/*     */     //   1041: ldc_w '>>>X teleport Time remaining -> SUCCESSFUL'
/*     */     //   1044: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1047: goto -> 1080
/*     */     //   1050: new java/lang/StringBuilder
/*     */     //   1053: dup
/*     */     //   1054: invokespecial <init> : ()V
/*     */     //   1057: ldc_w '>>>PX teleport Time remaining -> '
/*     */     //   1060: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1063: dload #16
/*     */     //   1065: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   1068: ldc_w ' seconds'
/*     */     //   1071: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1074: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1077: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1080: dload #12
/*     */     //   1082: d2i
/*     */     //   1083: ifne -> 1095
/*     */     //   1086: ldc_w '>>>Z teleport Time remaining -> SUCCESSFUL'
/*     */     //   1089: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1092: goto -> 1125
/*     */     //   1095: new java/lang/StringBuilder
/*     */     //   1098: dup
/*     */     //   1099: invokespecial <init> : ()V
/*     */     //   1102: ldc_w '>>>Z teleport Time remaining -> '
/*     */     //   1105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1108: dload #14
/*     */     //   1110: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   1113: ldc_w ' seconds'
/*     */     //   1116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1119: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1122: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1125: aload #4
/*     */     //   1127: invokeinterface getPosY : ()D
/*     */     //   1132: d2i
/*     */     //   1133: aload_0
/*     */     //   1134: getfield height : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1137: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1140: checkcast java/lang/Number
/*     */     //   1143: invokevirtual intValue : ()I
/*     */     //   1146: if_icmple -> 1158
/*     */     //   1149: ldc_w '>>>Y teleport Time remaining -> SUCCESSFUL'
/*     */     //   1152: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1155: goto -> 1188
/*     */     //   1158: new java/lang/StringBuilder
/*     */     //   1161: dup
/*     */     //   1162: invokespecial <init> : ()V
/*     */     //   1165: ldc_w '>>>Y teleport Time remaining -> '
/*     */     //   1168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1171: dload #18
/*     */     //   1173: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   1176: ldc_w ' seconds'
/*     */     //   1179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1182: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1185: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1188: aload #4
/*     */     //   1190: invokeinterface getPosY : ()D
/*     */     //   1195: d2i
/*     */     //   1196: aload_0
/*     */     //   1197: getfield height : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1200: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1203: checkcast java/lang/Number
/*     */     //   1206: invokevirtual intValue : ()I
/*     */     //   1209: if_icmpge -> 1257
/*     */     //   1212: aload #4
/*     */     //   1214: aload #4
/*     */     //   1216: invokeinterface getPosX : ()D
/*     */     //   1221: aload #4
/*     */     //   1223: invokeinterface getPosY : ()D
/*     */     //   1228: iconst_4
/*     */     //   1229: i2d
/*     */     //   1230: dadd
/*     */     //   1231: aload #4
/*     */     //   1233: invokeinterface getPosZ : ()D
/*     */     //   1238: aload #4
/*     */     //   1240: invokeinterface getRotationYaw : ()F
/*     */     //   1245: aload #4
/*     */     //   1247: invokeinterface getRotationPitch : ()F
/*     */     //   1252: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   1257: dload #10
/*     */     //   1259: d2i
/*     */     //   1260: ifeq -> 1421
/*     */     //   1263: dload #10
/*     */     //   1265: iconst_0
/*     */     //   1266: i2d
/*     */     //   1267: dcmpg
/*     */     //   1268: ifge -> 1347
/*     */     //   1271: iconst_5
/*     */     //   1272: istore #20
/*     */     //   1274: new java/lang/StringBuilder
/*     */     //   1277: dup
/*     */     //   1278: invokespecial <init> : ()V
/*     */     //   1281: ldc_w 'X-> '
/*     */     //   1284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1287: iload #20
/*     */     //   1289: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1292: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1295: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1298: aload #4
/*     */     //   1300: aload #4
/*     */     //   1302: invokeinterface getPosX : ()D
/*     */     //   1307: iload #20
/*     */     //   1309: i2d
/*     */     //   1310: dadd
/*     */     //   1311: aload #4
/*     */     //   1313: invokeinterface getPosY : ()D
/*     */     //   1318: aload #4
/*     */     //   1320: invokeinterface getPosZ : ()D
/*     */     //   1325: aload #4
/*     */     //   1327: invokeinterface getRotationYaw : ()F
/*     */     //   1332: aload #4
/*     */     //   1334: invokeinterface getRotationPitch : ()F
/*     */     //   1339: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   1344: goto -> 1421
/*     */     //   1347: bipush #-5
/*     */     //   1349: istore #20
/*     */     //   1351: new java/lang/StringBuilder
/*     */     //   1354: dup
/*     */     //   1355: invokespecial <init> : ()V
/*     */     //   1358: ldc_w 'X-> '
/*     */     //   1361: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1364: iload #20
/*     */     //   1366: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1369: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1372: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1375: aload #4
/*     */     //   1377: aload #4
/*     */     //   1379: invokeinterface getPosX : ()D
/*     */     //   1384: iload #20
/*     */     //   1386: i2d
/*     */     //   1387: dadd
/*     */     //   1388: aload #4
/*     */     //   1390: invokeinterface getPosY : ()D
/*     */     //   1395: aload #4
/*     */     //   1397: invokeinterface getPosZ : ()D
/*     */     //   1402: aload #4
/*     */     //   1404: invokeinterface getRotationYaw : ()F
/*     */     //   1409: aload #4
/*     */     //   1411: invokeinterface getRotationPitch : ()F
/*     */     //   1416: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   1421: dload #12
/*     */     //   1423: d2i
/*     */     //   1424: ifeq -> 1585
/*     */     //   1427: dload #12
/*     */     //   1429: iconst_0
/*     */     //   1430: i2d
/*     */     //   1431: dcmpg
/*     */     //   1432: ifge -> 1511
/*     */     //   1435: iconst_5
/*     */     //   1436: istore #20
/*     */     //   1438: new java/lang/StringBuilder
/*     */     //   1441: dup
/*     */     //   1442: invokespecial <init> : ()V
/*     */     //   1445: ldc_w 'Z-> '
/*     */     //   1448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1451: iload #20
/*     */     //   1453: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1456: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1459: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1462: aload #4
/*     */     //   1464: aload #4
/*     */     //   1466: invokeinterface getPosX : ()D
/*     */     //   1471: aload #4
/*     */     //   1473: invokeinterface getPosY : ()D
/*     */     //   1478: aload #4
/*     */     //   1480: invokeinterface getPosZ : ()D
/*     */     //   1485: iload #20
/*     */     //   1487: i2d
/*     */     //   1488: dadd
/*     */     //   1489: aload #4
/*     */     //   1491: invokeinterface getRotationYaw : ()F
/*     */     //   1496: aload #4
/*     */     //   1498: invokeinterface getRotationPitch : ()F
/*     */     //   1503: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   1508: goto -> 1585
/*     */     //   1511: bipush #-5
/*     */     //   1513: istore #20
/*     */     //   1515: new java/lang/StringBuilder
/*     */     //   1518: dup
/*     */     //   1519: invokespecial <init> : ()V
/*     */     //   1522: ldc_w 'Z-> '
/*     */     //   1525: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1528: iload #20
/*     */     //   1530: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   1533: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1536: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   1539: aload #4
/*     */     //   1541: aload #4
/*     */     //   1543: invokeinterface getPosX : ()D
/*     */     //   1548: aload #4
/*     */     //   1550: invokeinterface getPosY : ()D
/*     */     //   1555: aload #4
/*     */     //   1557: invokeinterface getPosZ : ()D
/*     */     //   1562: iload #20
/*     */     //   1564: i2d
/*     */     //   1565: dadd
/*     */     //   1566: aload #4
/*     */     //   1568: invokeinterface getRotationYaw : ()F
/*     */     //   1573: aload #4
/*     */     //   1575: invokeinterface getRotationPitch : ()F
/*     */     //   1580: invokeinterface setPositionAndRotation : (DDDFF)V
/*     */     //   1585: goto -> 1665
/*     */     //   1588: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1591: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1596: dup
/*     */     //   1597: ifnull -> 1603
/*     */     //   1600: goto -> 1605
/*     */     //   1603: pop
/*     */     //   1604: return
/*     */     //   1605: astore #5
/*     */     //   1607: aload #5
/*     */     //   1609: invokeinterface getCapabilities : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;
/*     */     //   1614: iconst_0
/*     */     //   1615: invokeinterface setFlying : (Z)V
/*     */     //   1620: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1623: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1628: fconst_1
/*     */     //   1629: invokeinterface setTimerSpeed : (F)V
/*     */     //   1634: aload #5
/*     */     //   1636: ldc_w 0.02
/*     */     //   1639: invokeinterface setSpeedInAir : (F)V
/*     */     //   1644: aload_0
/*     */     //   1645: aload_0
/*     */     //   1646: getfield Times : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1649: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1652: checkcast java/lang/Number
/*     */     //   1655: invokevirtual intValue : ()I
/*     */     //   1658: putfield TPtimes : I
/*     */     //   1661: goto -> 1665
/*     */     //   1664: return
/*     */     //   1665: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #86	-> 6
/*     */     //   #87	-> 35
/*     */     //   #88	-> 42
/*     */     //   #89	-> 56
/*     */     //   #90	-> 73
/*     */     //   #91	-> 88
/*     */     //   #92	-> 176
/*     */     //   #135	-> 202
/*     */     //   #92	-> 215
/*     */     //   #94	-> 225
/*     */     //   #95	-> 232
/*     */     //   #96	-> 248
/*     */     //   #98	-> 253
/*     */     //   #99	-> 255
/*     */     //   #100	-> 276
/*     */     //   #101	-> 297
/*     */     //   #102	-> 318
/*     */     //   #103	-> 325
/*     */     //   #98	-> 332
/*     */     //   #105	-> 337
/*     */     //   #106	-> 347
/*     */     //   #107	-> 412
/*     */     //   #108	-> 422
/*     */     //   #109	-> 424
/*     */     //   #110	-> 445
/*     */     //   #111	-> 466
/*     */     //   #112	-> 487
/*     */     //   #113	-> 494
/*     */     //   #108	-> 501
/*     */     //   #116	-> 506
/*     */     //   #118	-> 506
/*     */     //   #119	-> 580
/*     */     //   #121	-> 603
/*     */     //   #122	-> 611
/*     */     //   #123	-> 619
/*     */     //   #124	-> 627
/*     */     //   #125	-> 664
/*     */     //   #126	-> 701
/*     */     //   #127	-> 705
/*     */     //   #128	-> 772
/*     */     //   #129	-> 782
/*     */     //   #131	-> 801
/*     */     //   #133	-> 801
/*     */     //   #136	-> 804
/*     */     //   #137	-> 811
/*     */     //   #138	-> 813
/*     */     //   #139	-> 834
/*     */     //   #140	-> 855
/*     */     //   #141	-> 876
/*     */     //   #142	-> 883
/*     */     //   #137	-> 890
/*     */     //   #144	-> 895
/*     */     //   #146	-> 908
/*     */     //   #147	-> 917
/*     */     //   #148	-> 926
/*     */     //   #149	-> 933
/*     */     //   #150	-> 940
/*     */     //   #151	-> 948
/*     */     //   #152	-> 956
/*     */     //   #153	-> 969
/*     */     //   #154	-> 975
/*     */     //   #155	-> 981
/*     */     //   #156	-> 987
/*     */     //   #157	-> 1011
/*     */     //   #158	-> 1035
/*     */     //   #159	-> 1041
/*     */     //   #161	-> 1050
/*     */     //   #162	-> 1080
/*     */     //   #163	-> 1080
/*     */     //   #164	-> 1086
/*     */     //   #166	-> 1095
/*     */     //   #167	-> 1125
/*     */     //   #168	-> 1125
/*     */     //   #169	-> 1149
/*     */     //   #171	-> 1158
/*     */     //   #172	-> 1188
/*     */     //   #173	-> 1188
/*     */     //   #174	-> 1212
/*     */     //   #175	-> 1214
/*     */     //   #176	-> 1221
/*     */     //   #177	-> 1231
/*     */     //   #178	-> 1238
/*     */     //   #179	-> 1245
/*     */     //   #174	-> 1252
/*     */     //   #182	-> 1257
/*     */     //   #183	-> 1263
/*     */     //   #184	-> 1271
/*     */     //   #185	-> 1274
/*     */     //   #186	-> 1298
/*     */     //   #187	-> 1300
/*     */     //   #188	-> 1311
/*     */     //   #189	-> 1318
/*     */     //   #190	-> 1325
/*     */     //   #191	-> 1332
/*     */     //   #186	-> 1339
/*     */     //   #194	-> 1347
/*     */     //   #195	-> 1351
/*     */     //   #196	-> 1375
/*     */     //   #197	-> 1377
/*     */     //   #198	-> 1388
/*     */     //   #199	-> 1395
/*     */     //   #200	-> 1402
/*     */     //   #201	-> 1409
/*     */     //   #196	-> 1416
/*     */     //   #203	-> 1421
/*     */     //   #205	-> 1421
/*     */     //   #206	-> 1427
/*     */     //   #207	-> 1435
/*     */     //   #208	-> 1438
/*     */     //   #209	-> 1462
/*     */     //   #210	-> 1464
/*     */     //   #211	-> 1471
/*     */     //   #212	-> 1478
/*     */     //   #213	-> 1489
/*     */     //   #214	-> 1496
/*     */     //   #209	-> 1503
/*     */     //   #217	-> 1511
/*     */     //   #218	-> 1515
/*     */     //   #219	-> 1539
/*     */     //   #220	-> 1541
/*     */     //   #221	-> 1548
/*     */     //   #222	-> 1555
/*     */     //   #223	-> 1566
/*     */     //   #224	-> 1573
/*     */     //   #219	-> 1580
/*     */     //   #226	-> 1585
/*     */     //   #228	-> 1585
/*     */     //   #230	-> 1585
/*     */     //   #232	-> 1588
/*     */     //   #232	-> 1603
/*     */     //   #233	-> 1607
/*     */     //   #234	-> 1620
/*     */     //   #235	-> 1634
/*     */     //   #236	-> 1644
/*     */     //   #237	-> 1661
/*     */     //   #239	-> 1664
/*     */     //   #240	-> 1665
/*     */     //   #241	-> 1665
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   1274	70	20	isNegativeX	I
/*     */     //   1351	70	20	isNegativeX	I
/*     */     //   1438	70	20	isNegativeZ	I
/*     */     //   1515	70	20	isNegativeZ	I
/*     */     //   969	616	18	remainY	D
/*     */     //   956	629	16	remainX	D
/*     */     //   948	637	14	remainZ	D
/*     */     //   940	645	12	tpztimes	D
/*     */     //   933	652	10	tpxtimes	D
/*     */     //   926	659	8	PlayerZ	D
/*     */     //   917	668	6	PlayerX	D
/*     */     //   1607	54	5	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   73	1588	4	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   56	1605	3	vanillaSpeed	F
/*     */     //   35	1631	2	autoSkyWars	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars;
/*     */     //   0	1666	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars;
/*     */     //   0	1666	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   9: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   12: ldc net/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars
/*     */     //   14: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   17: dup
/*     */     //   18: ifnonnull -> 31
/*     */     //   21: new kotlin/TypeCastException
/*     */     //   24: dup
/*     */     //   25: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.retreat.AutoSkyWars'
/*     */     //   27: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   30: athrow
/*     */     //   31: checkcast net/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars
/*     */     //   34: astore_2
/*     */     //   35: aload_2
/*     */     //   36: invokevirtual getState : ()Z
/*     */     //   39: ifeq -> 625
/*     */     //   42: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   45: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   50: dup
/*     */     //   51: ifnonnull -> 57
/*     */     //   54: invokestatic throwNpe : ()V
/*     */     //   57: astore_3
/*     */     //   58: aload_3
/*     */     //   59: invokeinterface getCapabilities : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;
/*     */     //   64: invokeinterface isFlying : ()Z
/*     */     //   69: ifeq -> 625
/*     */     //   72: aload_0
/*     */     //   73: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   76: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   79: checkcast java/lang/String
/*     */     //   82: astore #4
/*     */     //   84: iconst_0
/*     */     //   85: istore #5
/*     */     //   87: aload #4
/*     */     //   89: dup
/*     */     //   90: ifnonnull -> 103
/*     */     //   93: new kotlin/TypeCastException
/*     */     //   96: dup
/*     */     //   97: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   99: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   102: athrow
/*     */     //   103: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   106: dup
/*     */     //   107: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   109: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   112: astore #4
/*     */     //   114: aload #4
/*     */     //   116: invokevirtual hashCode : ()I
/*     */     //   119: tableswitch default -> 625, -1271352334 -> 136
/*     */     //   136: aload #4
/*     */     //   138: ldc 'flyaim'
/*     */     //   140: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   143: ifeq -> 625
/*     */     //   146: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   149: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   154: dup
/*     */     //   155: ifnull -> 161
/*     */     //   158: goto -> 163
/*     */     //   161: pop
/*     */     //   162: return
/*     */     //   163: astore #5
/*     */     //   165: aload_0
/*     */     //   166: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   169: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   172: checkcast java/lang/Number
/*     */     //   175: invokevirtual floatValue : ()F
/*     */     //   178: fstore #6
/*     */     //   180: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   183: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   188: dup
/*     */     //   189: ifnonnull -> 195
/*     */     //   192: invokestatic throwNpe : ()V
/*     */     //   195: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   200: checkcast java/lang/Iterable
/*     */     //   203: astore #8
/*     */     //   205: iconst_0
/*     */     //   206: istore #9
/*     */     //   208: aload #8
/*     */     //   210: astore #10
/*     */     //   212: new java/util/ArrayList
/*     */     //   215: dup
/*     */     //   216: invokespecial <init> : ()V
/*     */     //   219: checkcast java/util/Collection
/*     */     //   222: astore #11
/*     */     //   224: iconst_0
/*     */     //   225: istore #12
/*     */     //   227: aload #10
/*     */     //   229: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   234: astore #14
/*     */     //   236: aload #14
/*     */     //   238: invokeinterface hasNext : ()Z
/*     */     //   243: ifeq -> 337
/*     */     //   246: aload #14
/*     */     //   248: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   253: astore #15
/*     */     //   255: aload #15
/*     */     //   257: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   260: astore #17
/*     */     //   262: iconst_0
/*     */     //   263: istore #18
/*     */     //   265: aload #17
/*     */     //   267: iconst_1
/*     */     //   268: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   271: ifeq -> 320
/*     */     //   274: aload #5
/*     */     //   276: aload #17
/*     */     //   278: invokeinterface canEntityBeSeen : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*     */     //   283: ifeq -> 320
/*     */     //   286: aload #5
/*     */     //   288: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   291: aload #17
/*     */     //   293: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   296: fload #6
/*     */     //   298: f2d
/*     */     //   299: dcmpg
/*     */     //   300: ifgt -> 320
/*     */     //   303: aload #17
/*     */     //   305: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   308: sipush #360
/*     */     //   311: i2d
/*     */     //   312: dcmpg
/*     */     //   313: ifgt -> 320
/*     */     //   316: iconst_1
/*     */     //   317: goto -> 321
/*     */     //   320: iconst_0
/*     */     //   321: ifeq -> 236
/*     */     //   324: aload #11
/*     */     //   326: aload #15
/*     */     //   328: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   333: pop
/*     */     //   334: goto -> 236
/*     */     //   337: aload #11
/*     */     //   339: checkcast java/util/List
/*     */     //   342: checkcast java/lang/Iterable
/*     */     //   345: astore #8
/*     */     //   347: iconst_0
/*     */     //   348: istore #9
/*     */     //   350: aload #8
/*     */     //   352: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   357: astore #10
/*     */     //   359: aload #10
/*     */     //   361: invokeinterface hasNext : ()Z
/*     */     //   366: ifne -> 373
/*     */     //   369: aconst_null
/*     */     //   370: goto -> 470
/*     */     //   373: aload #10
/*     */     //   375: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   380: astore #11
/*     */     //   382: aload #10
/*     */     //   384: invokeinterface hasNext : ()Z
/*     */     //   389: ifne -> 397
/*     */     //   392: aload #11
/*     */     //   394: goto -> 470
/*     */     //   397: aload #11
/*     */     //   399: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   402: astore #12
/*     */     //   404: iconst_0
/*     */     //   405: istore #14
/*     */     //   407: aload #12
/*     */     //   409: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   412: dstore #12
/*     */     //   414: aload #10
/*     */     //   416: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   421: astore #14
/*     */     //   423: aload #14
/*     */     //   425: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   428: astore #15
/*     */     //   430: iconst_0
/*     */     //   431: istore #17
/*     */     //   433: aload #15
/*     */     //   435: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   438: dstore #15
/*     */     //   440: dload #12
/*     */     //   442: dload #15
/*     */     //   444: invokestatic compare : (DD)I
/*     */     //   447: ifle -> 458
/*     */     //   450: aload #14
/*     */     //   452: astore #11
/*     */     //   454: dload #15
/*     */     //   456: dstore #12
/*     */     //   458: aload #10
/*     */     //   460: invokeinterface hasNext : ()Z
/*     */     //   465: ifne -> 414
/*     */     //   468: aload #11
/*     */     //   470: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   473: dup
/*     */     //   474: ifnull -> 480
/*     */     //   477: goto -> 482
/*     */     //   480: pop
/*     */     //   481: return
/*     */     //   482: astore #7
/*     */     //   484: aload_0
/*     */     //   485: getfield lockValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   488: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   491: checkcast java/lang/Boolean
/*     */     //   494: invokevirtual booleanValue : ()Z
/*     */     //   497: ifne -> 512
/*     */     //   500: aload #7
/*     */     //   502: fload #6
/*     */     //   504: f2d
/*     */     //   505: invokestatic isFaced : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;D)Z
/*     */     //   508: ifeq -> 512
/*     */     //   511: return
/*     */     //   512: new net/ccbluex/liquidbounce/utils/Rotation
/*     */     //   515: dup
/*     */     //   516: aload #5
/*     */     //   518: invokeinterface getRotationYaw : ()F
/*     */     //   523: aload #5
/*     */     //   525: invokeinterface getRotationPitch : ()F
/*     */     //   530: invokespecial <init> : (FF)V
/*     */     //   533: aload_0
/*     */     //   534: getfield centerValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   537: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   540: checkcast java/lang/Boolean
/*     */     //   543: invokevirtual booleanValue : ()Z
/*     */     //   546: ifeq -> 566
/*     */     //   549: aload #7
/*     */     //   551: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   556: invokestatic getCenter : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   559: iconst_1
/*     */     //   560: invokestatic toRotation : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Z)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   563: goto -> 585
/*     */     //   566: aload #7
/*     */     //   568: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   573: iconst_0
/*     */     //   574: iconst_0
/*     */     //   575: iconst_1
/*     */     //   576: iconst_0
/*     */     //   577: fload #6
/*     */     //   579: invokestatic searchCenter : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;ZZZZF)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   582: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   585: aload_0
/*     */     //   586: getfield turnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   589: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   592: checkcast java/lang/Number
/*     */     //   595: invokevirtual doubleValue : ()D
/*     */     //   598: invokestatic random : ()D
/*     */     //   601: dadd
/*     */     //   602: d2f
/*     */     //   603: invokestatic limitAngleChange : (Lnet/ccbluex/liquidbounce/utils/Rotation;Lnet/ccbluex/liquidbounce/utils/Rotation;F)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   606: dup
/*     */     //   607: ldc_w 'RotationUtils.limitAngle…                        )'
/*     */     //   610: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   613: astore #8
/*     */     //   615: aload #8
/*     */     //   617: aload #5
/*     */     //   619: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer
/*     */     //   622: invokevirtual toPlayer : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;)V
/*     */     //   625: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #244	-> 6
/*     */     //   #245	-> 35
/*     */     //   #246	-> 42
/*     */     //   #247	-> 58
/*     */     //   #248	-> 72
/*     */     //   #249	-> 136
/*     */     //   #252	-> 146
/*     */     //   #252	-> 161
/*     */     //   #254	-> 165
/*     */     //   #255	-> 180
/*     */     //   #261	-> 180
/*     */     //   #255	-> 180
/*     */     //   #256	-> 180
/*     */     //   #255	-> 180
/*     */     //   #256	-> 205
/*     */     //   #301	-> 208
/*     */     //   #302	-> 227
/*     */     //   #257	-> 265
/*     */     //   #258	-> 265
/*     */     //   #259	-> 265
/*     */     //   #257	-> 265
/*     */     //   #258	-> 286
/*     */     //   #259	-> 303
/*     */     //   #258	-> 305
/*     */     //   #259	-> 321
/*     */     //   #303	-> 337
/*     */     //   #261	-> 347
/*     */     //   #304	-> 350
/*     */     //   #305	-> 359
/*     */     //   #306	-> 373
/*     */     //   #307	-> 382
/*     */     //   #308	-> 397
/*     */     //   #261	-> 407
/*     */     //   #309	-> 414
/*     */     //   #310	-> 414
/*     */     //   #311	-> 423
/*     */     //   #261	-> 433
/*     */     //   #312	-> 440
/*     */     //   #313	-> 450
/*     */     //   #314	-> 454
/*     */     //   #316	-> 458
/*     */     //   #317	-> 468
/*     */     //   #261	-> 481
/*     */     //   #255	-> 482
/*     */     //   #263	-> 484
/*     */     //   #264	-> 511
/*     */     //   #266	-> 512
/*     */     //   #267	-> 512
/*     */     //   #268	-> 533
/*     */     //   #269	-> 549
/*     */     //   #271	-> 566
/*     */     //   #272	-> 566
/*     */     //   #271	-> 566
/*     */     //   #272	-> 576
/*     */     //   #271	-> 579
/*     */     //   #268	-> 585
/*     */     //   #273	-> 585
/*     */     //   #266	-> 603
/*     */     //   #275	-> 615
/*     */     //   #279	-> 625
/*     */     //   #282	-> 625
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   262	59	17	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   265	56	18	$i$a$-filter-AutoSkyWars$onStrafe$entity$1	I
/*     */     //   255	79	15	element$iv$iv	Ljava/lang/Object;
/*     */     //   224	115	10	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   224	115	11	destination$iv$iv	Ljava/util/Collection;
/*     */     //   227	112	12	$i$f$filterTo	I
/*     */     //   205	137	8	$this$filter$iv	Ljava/lang/Iterable;
/*     */     //   208	134	9	$i$f$filter	I
/*     */     //   404	8	12	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   407	5	14	$i$a$-minBy-AutoSkyWars$onStrafe$entity$2	I
/*     */     //   430	8	15	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   433	5	17	$i$a$-minBy-AutoSkyWars$onStrafe$entity$2	I
/*     */     //   440	28	15	v$iv	D
/*     */     //   423	45	14	e$iv	Ljava/lang/Object;
/*     */     //   414	56	12	minValue$iv	D
/*     */     //   382	88	11	minElem$iv	Ljava/lang/Object;
/*     */     //   359	111	10	iterator$iv	Ljava/util/Iterator;
/*     */     //   347	123	8	$this$minBy$iv	Ljava/lang/Iterable;
/*     */     //   350	120	9	$i$f$minBy	I
/*     */     //   615	10	8	rotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   484	141	7	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   180	445	6	range	F
/*     */     //   165	460	5	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   58	567	3	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   35	591	2	autoSkyWars	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars;
/*     */     //   0	626	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AutoSkyWars;
/*     */     //   0	626	1	event	Lnet/ccbluex/liquidbounce/event/StrafeEvent;
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
/*     */   public boolean handleEvents() {
/* 283 */     return true; } @NotNull
/*     */   public String getTag() {
/* 285 */     return (String)this.modeValue.get();
/*     */   } public void onDisable() {
/* 287 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 288 */     thePlayer.getCapabilities().setFlying(false);
/* 289 */     if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindForward()))
/* 290 */       MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(false); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\AutoSkyWars.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */