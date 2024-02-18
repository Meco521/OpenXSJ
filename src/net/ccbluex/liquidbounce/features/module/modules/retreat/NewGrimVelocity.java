/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "NewGrimVelocity", description = "HYTGrimFullvelocity 2023/10/2 Skid by 凡哥", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000`\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\n\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\032\032\0020\033H\026J\b\020\034\032\0020\033H\026J\020\020\035\032\0020\0332\006\020\036\032\0020\037H\007J\020\020 \032\0020\0332\006\020\036\032\0020!H\007J\020\020\"\032\0020\0332\006\020\036\032\0020#H\007J\020\020$\032\0020\0332\006\020\036\032\0020%H\007J\020\020&\032\0020\0332\006\020\036\032\0020'H\007J\020\020(\032\0020\0332\006\020\036\032\0020)H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\006X\004¢\006\002\n\000R\016\020\f\032\0020\006X\004¢\006\002\n\000R\016\020\r\032\0020\bX\016¢\006\002\n\000R\016\020\016\032\0020\004X\016¢\006\002\n\000R\016\020\017\032\0020\006X\004¢\006\002\n\000R\016\020\020\032\0020\006X\004¢\006\002\n\000R\016\020\021\032\0020\006X\004¢\006\002\n\000R\016\020\022\032\0020\004X\016¢\006\002\n\000R\016\020\023\032\0020\004X\016¢\006\002\n\000R\026\020\024\032\004\030\0010\0258VX\004¢\006\006\032\004\b\026\020\027R\016\020\030\032\0020\031X\004¢\006\002\n\000¨\006*"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NewGrimVelocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "air", "", "airTest", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "airtick", "", "airticks", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "c03Toc05", "c0F", "diggingtime", "gotVelo", "jumpFix", "notimer", "packetTick", "pre", "stop", "tag", "", "getTag", "()Ljava/lang/String;", "timerSpeed", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onDisable", "", "onEnable", "onJUmp", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onTIck", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class NewGrimVelocity
/*     */   extends Module
/*     */ {
/*  28 */   private final IntegerValue airticks = new IntegerValue("AirTicks", 1, 0, 10);
/*  29 */   private final FloatValue timerSpeed = new FloatValue("TimerSpeed", 0.43F, 0.1F, 1.0F);
/*  30 */   private final BoolValue airTest = new BoolValue("AirTest", true);
/*  31 */   private final BoolValue jumpFix = new BoolValue("JumpFix", true);
/*  32 */   private final BoolValue packetTick = new BoolValue("PacketTick", true);
/*  33 */   private final BoolValue c03Toc05 = new BoolValue("C03ToC05", false);
/*  34 */   private final BoolValue c0F = new BoolValue("C0f", true);
/*  35 */   private final BoolValue notimer = new BoolValue("notimer", true);
/*     */   
/*     */   private boolean gotVelo;
/*     */   private int airtick;
/*     */   private int diggingtime;
/*     */   private boolean air;
/*     */   private boolean pre;
/*     */   private boolean stop;
/*     */   
/*     */   public void onEnable() {
/*  45 */     this.airtick = 0;
/*  46 */     this.air = false;
/*  47 */     this.air = false;
/*  48 */     this.pre = false;
/*  49 */     this.gotVelo = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDisable() {
/*  54 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   14: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   19: invokeinterface isKeyDown : ()Z
/*     */     //   24: ifeq -> 111
/*     */     //   27: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   30: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   35: dup
/*     */     //   36: ifnonnull -> 42
/*     */     //   39: invokestatic throwNpe : ()V
/*     */     //   42: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   45: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   50: dup
/*     */     //   51: ifnonnull -> 57
/*     */     //   54: invokestatic throwNpe : ()V
/*     */     //   57: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   62: dup
/*     */     //   63: ifnonnull -> 69
/*     */     //   66: invokestatic throwNpe : ()V
/*     */     //   69: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   74: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   79: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   82: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   85: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   90: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   93: iconst_1
/*     */     //   94: ixor
/*     */     //   95: ifeq -> 111
/*     */     //   98: aload_0
/*     */     //   99: dup
/*     */     //   100: getfield diggingtime : I
/*     */     //   103: iconst_5
/*     */     //   104: iadd
/*     */     //   105: putfield diggingtime : I
/*     */     //   108: goto -> 116
/*     */     //   111: aload_0
/*     */     //   112: iconst_0
/*     */     //   113: putfield diggingtime : I
/*     */     //   116: aload_0
/*     */     //   117: getfield diggingtime : I
/*     */     //   120: iconst_5
/*     */     //   121: if_icmplt -> 217
/*     */     //   124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   127: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   132: dup
/*     */     //   133: ifnonnull -> 139
/*     */     //   136: invokestatic throwNpe : ()V
/*     */     //   139: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   142: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   147: dup
/*     */     //   148: ifnonnull -> 154
/*     */     //   151: invokestatic throwNpe : ()V
/*     */     //   154: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   159: dup
/*     */     //   160: ifnonnull -> 166
/*     */     //   163: invokestatic throwNpe : ()V
/*     */     //   166: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   171: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   176: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   179: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   182: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   187: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   190: iconst_1
/*     */     //   191: ixor
/*     */     //   192: ifeq -> 217
/*     */     //   195: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   198: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   203: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   208: invokeinterface isKeyDown : ()Z
/*     */     //   213: ifeq -> 217
/*     */     //   216: return
/*     */     //   217: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   220: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   223: ldc net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*     */     //   225: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   228: dup
/*     */     //   229: ifnonnull -> 242
/*     */     //   232: new kotlin/TypeCastException
/*     */     //   235: dup
/*     */     //   236: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.Blink'
/*     */     //   238: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   241: athrow
/*     */     //   242: checkcast net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*     */     //   245: astore_2
/*     */     //   246: aload_1
/*     */     //   247: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   250: astore #4
/*     */     //   252: iconst_0
/*     */     //   253: istore #5
/*     */     //   255: aload #4
/*     */     //   257: dup
/*     */     //   258: ifnonnull -> 271
/*     */     //   261: new kotlin/TypeCastException
/*     */     //   264: dup
/*     */     //   265: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*     */     //   267: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   270: athrow
/*     */     //   271: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   274: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*     */     //   277: astore_3
/*     */     //   278: aload_3
/*     */     //   279: instanceof net/minecraft/network/play/server/SPacketPlayerPosLook
/*     */     //   282: ifeq -> 350
/*     */     //   285: aload_0
/*     */     //   286: iconst_0
/*     */     //   287: putfield airtick : I
/*     */     //   290: aload_0
/*     */     //   291: iconst_0
/*     */     //   292: putfield air : Z
/*     */     //   295: aload_0
/*     */     //   296: iconst_0
/*     */     //   297: putfield air : Z
/*     */     //   300: aload_0
/*     */     //   301: iconst_0
/*     */     //   302: putfield pre : Z
/*     */     //   305: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   308: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   313: invokeinterface getTimerSpeed : ()F
/*     */     //   318: fconst_1
/*     */     //   319: fcmpg
/*     */     //   320: ifeq -> 340
/*     */     //   323: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   326: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   331: fconst_1
/*     */     //   332: invokeinterface setTimerSpeed : (F)V
/*     */     //   337: goto -> 305
/*     */     //   340: aload_0
/*     */     //   341: iconst_0
/*     */     //   342: invokevirtual setState : (Z)V
/*     */     //   345: ldc 'Lag'
/*     */     //   347: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   350: aload_3
/*     */     //   351: instanceof net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   354: ifeq -> 455
/*     */     //   357: aload_0
/*     */     //   358: getfield airTest : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   361: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   364: checkcast java/lang/Boolean
/*     */     //   367: invokevirtual booleanValue : ()Z
/*     */     //   370: ifeq -> 455
/*     */     //   373: aload_1
/*     */     //   374: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   377: invokeinterface asSPacketEntityVelocity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   382: astore #4
/*     */     //   384: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   387: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   392: dup
/*     */     //   393: ifnull -> 415
/*     */     //   396: aload #4
/*     */     //   398: invokeinterface getEntityID : ()I
/*     */     //   403: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   408: dup
/*     */     //   409: ifnull -> 415
/*     */     //   412: goto -> 417
/*     */     //   415: pop
/*     */     //   416: return
/*     */     //   417: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   420: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   425: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   428: iconst_1
/*     */     //   429: ixor
/*     */     //   430: ifeq -> 434
/*     */     //   433: return
/*     */     //   434: aload_1
/*     */     //   435: invokevirtual cancelEvent : ()V
/*     */     //   438: aload_0
/*     */     //   439: aload_0
/*     */     //   440: getfield airticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   443: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   446: checkcast java/lang/Number
/*     */     //   449: invokevirtual intValue : ()I
/*     */     //   452: putfield airtick : I
/*     */     //   455: aload_0
/*     */     //   456: getfield airtick : I
/*     */     //   459: ifle -> 879
/*     */     //   462: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   465: aload_1
/*     */     //   466: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   469: invokeinterface isCPacketPlayerPosition : (Ljava/lang/Object;)Z
/*     */     //   474: ifne -> 492
/*     */     //   477: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   480: aload_1
/*     */     //   481: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   484: invokeinterface isCPacketPlayerPosLook : (Ljava/lang/Object;)Z
/*     */     //   489: ifeq -> 879
/*     */     //   492: aload_0
/*     */     //   493: getfield packetTick : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   496: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   499: dup
/*     */     //   500: ifnonnull -> 514
/*     */     //   503: new kotlin/TypeCastException
/*     */     //   506: dup
/*     */     //   507: ldc_w 'null cannot be cast to non-null type kotlin.Boolean'
/*     */     //   510: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   513: athrow
/*     */     //   514: checkcast java/lang/Boolean
/*     */     //   517: invokevirtual booleanValue : ()Z
/*     */     //   520: ifeq -> 537
/*     */     //   523: aload_0
/*     */     //   524: getfield airtick : I
/*     */     //   527: istore #4
/*     */     //   529: aload_0
/*     */     //   530: iload #4
/*     */     //   532: iconst_m1
/*     */     //   533: iadd
/*     */     //   534: putfield airtick : I
/*     */     //   537: aload_0
/*     */     //   538: getfield c0F : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   541: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   544: dup
/*     */     //   545: ifnonnull -> 559
/*     */     //   548: new kotlin/TypeCastException
/*     */     //   551: dup
/*     */     //   552: ldc_w 'null cannot be cast to non-null type kotlin.Boolean'
/*     */     //   555: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   558: athrow
/*     */     //   559: checkcast java/lang/Boolean
/*     */     //   562: invokevirtual booleanValue : ()Z
/*     */     //   565: ifeq -> 601
/*     */     //   568: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   571: dup
/*     */     //   572: ldc_w 'mc2'
/*     */     //   575: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   578: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   581: dup
/*     */     //   582: ifnonnull -> 588
/*     */     //   585: invokestatic throwNpe : ()V
/*     */     //   588: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   591: dup
/*     */     //   592: invokespecial <init> : ()V
/*     */     //   595: checkcast net/minecraft/network/Packet
/*     */     //   598: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   601: aload_0
/*     */     //   602: getfield c03Toc05 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   605: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   608: dup
/*     */     //   609: ifnonnull -> 623
/*     */     //   612: new kotlin/TypeCastException
/*     */     //   615: dup
/*     */     //   616: ldc_w 'null cannot be cast to non-null type kotlin.Boolean'
/*     */     //   619: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   622: athrow
/*     */     //   623: checkcast java/lang/Boolean
/*     */     //   626: dup
/*     */     //   627: ifnonnull -> 633
/*     */     //   630: invokestatic throwNpe : ()V
/*     */     //   633: invokevirtual booleanValue : ()Z
/*     */     //   636: ifne -> 691
/*     */     //   639: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   642: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   647: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   650: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   653: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   658: dup
/*     */     //   659: ifnonnull -> 665
/*     */     //   662: invokestatic throwNpe : ()V
/*     */     //   665: invokeinterface getOnGround : ()Z
/*     */     //   670: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   675: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   678: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   683: aload_0
/*     */     //   684: iconst_1
/*     */     //   685: putfield gotVelo : Z
/*     */     //   688: goto -> 775
/*     */     //   691: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   694: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   699: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   702: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   705: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   710: dup
/*     */     //   711: ifnonnull -> 717
/*     */     //   714: invokestatic throwNpe : ()V
/*     */     //   717: invokeinterface getRotationYaw : ()F
/*     */     //   722: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   725: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   730: dup
/*     */     //   731: ifnonnull -> 737
/*     */     //   734: invokestatic throwNpe : ()V
/*     */     //   737: invokeinterface getRotationPitch : ()F
/*     */     //   742: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   745: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   750: dup
/*     */     //   751: ifnonnull -> 757
/*     */     //   754: invokestatic throwNpe : ()V
/*     */     //   757: invokeinterface getOnGround : ()Z
/*     */     //   762: invokeinterface createCPacketPlayerLook : (FFZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   767: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   770: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   775: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   778: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   783: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   786: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.STOP_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   789: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   792: dup
/*     */     //   793: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   796: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   801: dup
/*     */     //   802: ifnonnull -> 808
/*     */     //   805: invokestatic throwNpe : ()V
/*     */     //   808: invokeinterface getPosX : ()D
/*     */     //   813: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   816: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   821: dup
/*     */     //   822: ifnonnull -> 828
/*     */     //   825: invokestatic throwNpe : ()V
/*     */     //   828: invokeinterface getPosY : ()D
/*     */     //   833: dconst_1
/*     */     //   834: dadd
/*     */     //   835: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   838: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   843: dup
/*     */     //   844: ifnonnull -> 850
/*     */     //   847: invokestatic throwNpe : ()V
/*     */     //   850: invokeinterface getPosZ : ()D
/*     */     //   855: invokespecial <init> : (DDD)V
/*     */     //   858: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   861: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.NORTH : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   864: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   869: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   874: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   879: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #59	-> 6
/*     */     //   #60	-> 82
/*     */     //   #59	-> 85
/*     */     //   #61	-> 98
/*     */     //   #63	-> 111
/*     */     //   #64	-> 116
/*     */     //   #65	-> 116
/*     */     //   #66	-> 116
/*     */     //   #65	-> 124
/*     */     //   #66	-> 179
/*     */     //   #65	-> 182
/*     */     //   #66	-> 216
/*     */     //   #68	-> 217
/*     */     //   #69	-> 246
/*     */     //   #197	-> 255
/*     */     //   #69	-> 277
/*     */     //   #70	-> 278
/*     */     //   #71	-> 285
/*     */     //   #72	-> 290
/*     */     //   #73	-> 295
/*     */     //   #74	-> 300
/*     */     //   #75	-> 305
/*     */     //   #76	-> 323
/*     */     //   #75	-> 337
/*     */     //   #78	-> 340
/*     */     //   #79	-> 345
/*     */     //   #81	-> 350
/*     */     //   #82	-> 373
/*     */     //   #83	-> 384
/*     */     //   #83	-> 415
/*     */     //   #84	-> 433
/*     */     //   #85	-> 434
/*     */     //   #86	-> 438
/*     */     //   #88	-> 455
/*     */     //   #89	-> 492
/*     */     //   #90	-> 523
/*     */     //   #91	-> 529
/*     */     //   #93	-> 537
/*     */     //   #94	-> 568
/*     */     //   #96	-> 601
/*     */     //   #97	-> 639
/*     */     //   #98	-> 683
/*     */     //   #100	-> 691
/*     */     //   #101	-> 699
/*     */     //   #102	-> 702
/*     */     //   #103	-> 722
/*     */     //   #104	-> 742
/*     */     //   #101	-> 762
/*     */     //   #100	-> 770
/*     */     //   #107	-> 775
/*     */     //   #108	-> 775
/*     */     //   #109	-> 783
/*     */     //   #110	-> 786
/*     */     //   #111	-> 789
/*     */     //   #112	-> 858
/*     */     //   #109	-> 869
/*     */     //   #108	-> 874
/*     */     //   #116	-> 879
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   252	25	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   255	22	5	$i$f$unwrap	I
/*     */     //   384	71	4	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   529	8	4	n	I
/*     */     //   278	602	3	packet	Lnet/minecraft/network/Packet;
/*     */     //   246	634	2	blink	Lnet/ccbluex/liquidbounce/features/module/modules/player/Blink;
/*     */     //   0	880	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NewGrimVelocity;
/*     */     //   0	880	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 120 */     Intrinsics.checkParameterIsNotNull(event, "event");
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
/*     */   @EventTarget
/*     */   public final void onTIck(@NotNull TickEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   14: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   19: invokeinterface isKeyDown : ()Z
/*     */     //   24: ifeq -> 111
/*     */     //   27: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   30: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   35: dup
/*     */     //   36: ifnonnull -> 42
/*     */     //   39: invokestatic throwNpe : ()V
/*     */     //   42: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   45: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   50: dup
/*     */     //   51: ifnonnull -> 57
/*     */     //   54: invokestatic throwNpe : ()V
/*     */     //   57: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   62: dup
/*     */     //   63: ifnonnull -> 69
/*     */     //   66: invokestatic throwNpe : ()V
/*     */     //   69: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   74: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   79: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   82: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   85: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   90: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   93: iconst_1
/*     */     //   94: ixor
/*     */     //   95: ifeq -> 111
/*     */     //   98: aload_0
/*     */     //   99: dup
/*     */     //   100: getfield diggingtime : I
/*     */     //   103: iconst_5
/*     */     //   104: iadd
/*     */     //   105: putfield diggingtime : I
/*     */     //   108: goto -> 116
/*     */     //   111: aload_0
/*     */     //   112: iconst_0
/*     */     //   113: putfield diggingtime : I
/*     */     //   116: aload_0
/*     */     //   117: getfield diggingtime : I
/*     */     //   120: iconst_5
/*     */     //   121: if_icmplt -> 217
/*     */     //   124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   127: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   132: dup
/*     */     //   133: ifnonnull -> 139
/*     */     //   136: invokestatic throwNpe : ()V
/*     */     //   139: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   142: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   147: dup
/*     */     //   148: ifnonnull -> 154
/*     */     //   151: invokestatic throwNpe : ()V
/*     */     //   154: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   159: dup
/*     */     //   160: ifnonnull -> 166
/*     */     //   163: invokestatic throwNpe : ()V
/*     */     //   166: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   171: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   176: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   179: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   182: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   187: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   190: iconst_1
/*     */     //   191: ixor
/*     */     //   192: ifeq -> 217
/*     */     //   195: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   198: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   203: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   208: invokeinterface isKeyDown : ()Z
/*     */     //   213: ifeq -> 217
/*     */     //   216: return
/*     */     //   217: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   220: dup
/*     */     //   221: ifnonnull -> 235
/*     */     //   224: new kotlin/TypeCastException
/*     */     //   227: dup
/*     */     //   228: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl'
/*     */     //   231: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   234: athrow
/*     */     //   235: checkcast net/ccbluex/liquidbounce/injection/backend/MinecraftImpl
/*     */     //   238: invokevirtual getWrapped : ()Lnet/minecraft/client/Minecraft;
/*     */     //   241: getfield field_71428_T : Lnet/minecraft/util/Timer;
/*     */     //   244: dup
/*     */     //   245: ifnull -> 251
/*     */     //   248: goto -> 253
/*     */     //   251: pop
/*     */     //   252: return
/*     */     //   253: astore_2
/*     */     //   254: aload_0
/*     */     //   255: getfield gotVelo : Z
/*     */     //   258: ifeq -> 357
/*     */     //   261: aload_0
/*     */     //   262: getfield notimer : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   265: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   268: checkcast java/lang/Boolean
/*     */     //   271: invokevirtual booleanValue : ()Z
/*     */     //   274: ifeq -> 357
/*     */     //   277: aload_0
/*     */     //   278: iconst_0
/*     */     //   279: putfield gotVelo : Z
/*     */     //   282: nop
/*     */     //   283: aload_2
/*     */     //   284: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   287: ldc_w 'field_74277_g'
/*     */     //   290: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
/*     */     //   293: astore_3
/*     */     //   294: aload_3
/*     */     //   295: iconst_1
/*     */     //   296: invokevirtual setAccessible : (Z)V
/*     */     //   299: aload_3
/*     */     //   300: aload_2
/*     */     //   301: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   304: dup
/*     */     //   305: ifnonnull -> 319
/*     */     //   308: new kotlin/TypeCastException
/*     */     //   311: dup
/*     */     //   312: ldc_w 'null cannot be cast to non-null type kotlin.Long'
/*     */     //   315: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   318: athrow
/*     */     //   319: checkcast java/lang/Long
/*     */     //   322: invokevirtual longValue : ()J
/*     */     //   325: lstore #4
/*     */     //   327: aload_3
/*     */     //   328: aload_2
/*     */     //   329: lload #4
/*     */     //   331: ldc2_w 50
/*     */     //   334: ladd
/*     */     //   335: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   338: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
/*     */     //   341: goto -> 357
/*     */     //   344: astore_3
/*     */     //   345: aload_3
/*     */     //   346: invokevirtual printStackTrace : ()V
/*     */     //   349: goto -> 357
/*     */     //   352: astore_3
/*     */     //   353: aload_3
/*     */     //   354: invokevirtual printStackTrace : ()V
/*     */     //   357: aload_0
/*     */     //   358: getfield airtick : I
/*     */     //   361: ifle -> 549
/*     */     //   364: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   367: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   372: aload_0
/*     */     //   373: getfield timerSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   376: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   379: checkcast java/lang/Number
/*     */     //   382: invokevirtual floatValue : ()F
/*     */     //   385: invokeinterface setTimerSpeed : (F)V
/*     */     //   390: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   393: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   398: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   401: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.STOP_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   404: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   407: dup
/*     */     //   408: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   411: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   416: dup
/*     */     //   417: ifnonnull -> 423
/*     */     //   420: invokestatic throwNpe : ()V
/*     */     //   423: invokeinterface getPosX : ()D
/*     */     //   428: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   431: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   436: dup
/*     */     //   437: ifnonnull -> 443
/*     */     //   440: invokestatic throwNpe : ()V
/*     */     //   443: invokeinterface getPosY : ()D
/*     */     //   448: dconst_1
/*     */     //   449: dadd
/*     */     //   450: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   453: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   458: dup
/*     */     //   459: ifnonnull -> 465
/*     */     //   462: invokestatic throwNpe : ()V
/*     */     //   465: invokeinterface getPosZ : ()D
/*     */     //   470: invokespecial <init> : (DDD)V
/*     */     //   473: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   476: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.NORTH : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   479: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   484: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   489: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   494: aload_0
/*     */     //   495: iconst_1
/*     */     //   496: putfield air : Z
/*     */     //   499: aload_0
/*     */     //   500: getfield packetTick : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   503: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   506: dup
/*     */     //   507: ifnonnull -> 521
/*     */     //   510: new kotlin/TypeCastException
/*     */     //   513: dup
/*     */     //   514: ldc_w 'null cannot be cast to non-null type kotlin.Boolean'
/*     */     //   517: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   520: athrow
/*     */     //   521: checkcast java/lang/Boolean
/*     */     //   524: dup
/*     */     //   525: ifnonnull -> 531
/*     */     //   528: invokestatic throwNpe : ()V
/*     */     //   531: invokevirtual booleanValue : ()Z
/*     */     //   534: ifne -> 549
/*     */     //   537: aload_0
/*     */     //   538: getfield airtick : I
/*     */     //   541: istore_3
/*     */     //   542: aload_0
/*     */     //   543: iload_3
/*     */     //   544: iconst_m1
/*     */     //   545: iadd
/*     */     //   546: putfield airtick : I
/*     */     //   549: aload_0
/*     */     //   550: getfield air : Z
/*     */     //   553: ifeq -> 583
/*     */     //   556: aload_0
/*     */     //   557: getfield airtick : I
/*     */     //   560: iconst_1
/*     */     //   561: if_icmpge -> 583
/*     */     //   564: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   567: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   572: fconst_1
/*     */     //   573: invokeinterface setTimerSpeed : (F)V
/*     */     //   578: aload_0
/*     */     //   579: iconst_0
/*     */     //   580: putfield air : Z
/*     */     //   583: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #124	-> 6
/*     */     //   #125	-> 82
/*     */     //   #124	-> 85
/*     */     //   #126	-> 98
/*     */     //   #128	-> 111
/*     */     //   #129	-> 116
/*     */     //   #130	-> 116
/*     */     //   #131	-> 116
/*     */     //   #130	-> 124
/*     */     //   #131	-> 179
/*     */     //   #130	-> 182
/*     */     //   #131	-> 216
/*     */     //   #133	-> 217
/*     */     //   #133	-> 251
/*     */     //   #134	-> 254
/*     */     //   #135	-> 277
/*     */     //   #136	-> 282
/*     */     //   #137	-> 283
/*     */     //   #138	-> 294
/*     */     //   #139	-> 299
/*     */     //   #140	-> 327
/*     */     //   #141	-> 344
/*     */     //   #142	-> 345
/*     */     //   #143	-> 352
/*     */     //   #144	-> 353
/*     */     //   #145	-> 357
/*     */     //   #147	-> 357
/*     */     //   #148	-> 364
/*     */     //   #149	-> 390
/*     */     //   #150	-> 398
/*     */     //   #151	-> 401
/*     */     //   #152	-> 404
/*     */     //   #153	-> 473
/*     */     //   #150	-> 484
/*     */     //   #149	-> 489
/*     */     //   #156	-> 494
/*     */     //   #157	-> 499
/*     */     //   #158	-> 537
/*     */     //   #159	-> 542
/*     */     //   #162	-> 549
/*     */     //   #163	-> 564
/*     */     //   #164	-> 578
/*     */     //   #166	-> 583
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   327	14	4	t	J
/*     */     //   294	47	3	f	Ljava/lang/reflect/Field;
/*     */     //   345	4	3	e	Ljava/lang/NoSuchFieldException;
/*     */     //   353	4	3	e	Ljava/lang/IllegalAccessException;
/*     */     //   542	7	3	n	I
/*     */     //   254	330	2	timer	Lnet/minecraft/util/Timer;
/*     */     //   0	584	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NewGrimVelocity;
/*     */     //   0	584	1	event	Lnet/ccbluex/liquidbounce/event/TickEvent;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   282	341	344	java/lang/NoSuchFieldException
/*     */     //   282	341	352	java/lang/IllegalAccessException
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
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event) {
/* 171 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */   }
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/* 175 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.pre = !StringsKt.equals(event.getEventState().getStateName(), "Post", true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onJUmp(@NotNull JumpEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   14: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   19: invokeinterface isKeyDown : ()Z
/*     */     //   24: ifeq -> 111
/*     */     //   27: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   30: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   35: dup
/*     */     //   36: ifnonnull -> 42
/*     */     //   39: invokestatic throwNpe : ()V
/*     */     //   42: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   45: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   50: dup
/*     */     //   51: ifnonnull -> 57
/*     */     //   54: invokestatic throwNpe : ()V
/*     */     //   57: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   62: dup
/*     */     //   63: ifnonnull -> 69
/*     */     //   66: invokestatic throwNpe : ()V
/*     */     //   69: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   74: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   79: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   82: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   85: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   90: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   93: iconst_1
/*     */     //   94: ixor
/*     */     //   95: ifeq -> 111
/*     */     //   98: aload_0
/*     */     //   99: dup
/*     */     //   100: getfield diggingtime : I
/*     */     //   103: iconst_5
/*     */     //   104: iadd
/*     */     //   105: putfield diggingtime : I
/*     */     //   108: goto -> 116
/*     */     //   111: aload_0
/*     */     //   112: iconst_0
/*     */     //   113: putfield diggingtime : I
/*     */     //   116: aload_0
/*     */     //   117: getfield diggingtime : I
/*     */     //   120: iconst_5
/*     */     //   121: if_icmplt -> 217
/*     */     //   124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   127: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   132: dup
/*     */     //   133: ifnonnull -> 139
/*     */     //   136: invokestatic throwNpe : ()V
/*     */     //   139: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   142: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   147: dup
/*     */     //   148: ifnonnull -> 154
/*     */     //   151: invokestatic throwNpe : ()V
/*     */     //   154: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   159: dup
/*     */     //   160: ifnonnull -> 166
/*     */     //   163: invokestatic throwNpe : ()V
/*     */     //   166: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   171: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   176: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   179: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   182: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   187: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   190: iconst_1
/*     */     //   191: ixor
/*     */     //   192: ifeq -> 217
/*     */     //   195: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   198: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   203: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   208: invokeinterface isKeyDown : ()Z
/*     */     //   213: ifeq -> 217
/*     */     //   216: return
/*     */     //   217: aload_0
/*     */     //   218: getfield airtick : I
/*     */     //   221: ifle -> 244
/*     */     //   224: aload_0
/*     */     //   225: getfield jumpFix : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   228: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   231: checkcast java/lang/Boolean
/*     */     //   234: invokevirtual booleanValue : ()Z
/*     */     //   237: ifeq -> 244
/*     */     //   240: aload_1
/*     */     //   241: invokevirtual cancelEvent : ()V
/*     */     //   244: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #180	-> 6
/*     */     //   #181	-> 82
/*     */     //   #180	-> 85
/*     */     //   #182	-> 98
/*     */     //   #184	-> 111
/*     */     //   #185	-> 116
/*     */     //   #186	-> 116
/*     */     //   #187	-> 116
/*     */     //   #186	-> 124
/*     */     //   #187	-> 179
/*     */     //   #186	-> 182
/*     */     //   #187	-> 216
/*     */     //   #189	-> 217
/*     */     //   #190	-> 224
/*     */     //   #191	-> 240
/*     */     //   #193	-> 244
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	245	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NewGrimVelocity;
/*     */     //   0	245	1	event	Lnet/ccbluex/liquidbounce/event/JumpEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public String getTag() {
/* 195 */     return "LatestGrimac";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\NewGrimVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */