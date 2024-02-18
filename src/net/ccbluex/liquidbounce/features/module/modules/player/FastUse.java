/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "FastUse", description = "快速使用", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000R\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\002\b\003\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\030\032\0020\031H\026J\022\020\032\032\0020\0312\b\020\033\032\004\030\0010\034H\007J\020\020\035\032\0020\0312\006\020\033\032\0020\036H\007J\b\020\037\032\0020\031H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\021\020\017\032\0020\006¢\006\b\n\000\032\004\b\020\020\021R\026\020\022\032\004\030\0010\0238VX\004¢\006\006\032\004\b\024\020\025R\016\020\026\032\0020\027X\016¢\006\002\n\000¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/FastUse;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "customSpeedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "customTimer", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "delayValue", "durationValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "noMoveValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "speedValue", "getSpeedValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "usedTimer", "", "onDisable", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "send", "XSJClient"})
/*     */ public final class FastUse extends Module {
/*  23 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Instant", "NCP", "AAC", "Custom", "minemoratest", "delayedinstant", "Matrix", "GrimMin" }, "NCP");
/*     */   
/*  25 */   private final BoolValue noMoveValue = new BoolValue("NoMove", false);
/*     */   
/*  27 */   private final IntegerValue delayValue = new IntegerValue("CustomDelay", 0, 0, 300);
/*  28 */   private final IntegerValue customSpeedValue = new IntegerValue("CustomSpeed", 2, 1, 35);
/*  29 */   private final IntegerValue durationValue = new IntegerValue("InstantDelay", 14, 0, 35);
/*  30 */   private final FloatValue customTimer = new FloatValue("CustomTimer", 1.1F, 0.5F, 2.0F); @NotNull
/*  31 */   private final FloatValue speedValue = new FloatValue("GrimSpeed", 1.2F, 1.0F, 1.5F); @NotNull public final FloatValue getSpeedValue() { return this.speedValue; }
/*     */   
/*  33 */   private final MSTimer msTimer = new MSTimer();
/*     */   private boolean usedTimer;
/*     */   
/*     */   private final void send() {
/*  37 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayer(MinecraftInstance.mc.getThePlayer().getOnGround()));
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 23
/*     */     //   21: pop
/*     */     //   22: return
/*     */     //   23: astore_2
/*     */     //   24: aload_0
/*     */     //   25: getfield usedTimer : Z
/*     */     //   28: ifeq -> 50
/*     */     //   31: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   34: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   39: fconst_1
/*     */     //   40: invokeinterface setTimerSpeed : (F)V
/*     */     //   45: aload_0
/*     */     //   46: iconst_0
/*     */     //   47: putfield usedTimer : Z
/*     */     //   50: aload_2
/*     */     //   51: invokeinterface isUsingItem : ()Z
/*     */     //   56: ifne -> 67
/*     */     //   59: aload_0
/*     */     //   60: getfield msTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   63: invokevirtual reset : ()V
/*     */     //   66: return
/*     */     //   67: aload_2
/*     */     //   68: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   73: dup
/*     */     //   74: ifnonnull -> 80
/*     */     //   77: invokestatic throwNpe : ()V
/*     */     //   80: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   85: astore_3
/*     */     //   86: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   89: aload_3
/*     */     //   90: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   95: ifne -> 122
/*     */     //   98: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   101: aload_3
/*     */     //   102: invokeinterface isItemBucketMilk : (Ljava/lang/Object;)Z
/*     */     //   107: ifne -> 122
/*     */     //   110: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   113: aload_3
/*     */     //   114: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   119: ifeq -> 1051
/*     */     //   122: aload_0
/*     */     //   123: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   126: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   129: checkcast java/lang/String
/*     */     //   132: astore #4
/*     */     //   134: iconst_0
/*     */     //   135: istore #5
/*     */     //   137: aload #4
/*     */     //   139: dup
/*     */     //   140: ifnonnull -> 153
/*     */     //   143: new kotlin/TypeCastException
/*     */     //   146: dup
/*     */     //   147: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   149: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   152: athrow
/*     */     //   153: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   156: dup
/*     */     //   157: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   159: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   162: astore #4
/*     */     //   164: aload #4
/*     */     //   166: invokevirtual hashCode : ()I
/*     */     //   169: lookupswitch default -> 1051, -1349088399 -> 270, -1081239615 -> 309, -1043820362 -> 322, -62406081 -> 283, 96323 -> 244, 108891 -> 296, 287646883 -> 257, 1957570017 -> 335
/*     */     //   244: aload #4
/*     */     //   246: ldc 'aac'
/*     */     //   248: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   251: ifeq -> 1051
/*     */     //   254: goto -> 723
/*     */     //   257: aload #4
/*     */     //   259: ldc 'grimmin'
/*     */     //   261: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   264: ifeq -> 1051
/*     */     //   267: goto -> 746
/*     */     //   270: aload #4
/*     */     //   272: ldc 'custom'
/*     */     //   274: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   277: ifeq -> 1051
/*     */     //   280: goto -> 909
/*     */     //   283: aload #4
/*     */     //   285: ldc 'delayedinstant'
/*     */     //   287: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   290: ifeq -> 1051
/*     */     //   293: goto -> 430
/*     */     //   296: aload #4
/*     */     //   298: ldc 'ncp'
/*     */     //   300: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   303: ifeq -> 1051
/*     */     //   306: goto -> 600
/*     */     //   309: aload #4
/*     */     //   311: ldc 'matrix'
/*     */     //   313: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   316: ifeq -> 1051
/*     */     //   319: goto -> 696
/*     */     //   322: aload #4
/*     */     //   324: ldc 'minemoratest'
/*     */     //   326: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   329: ifeq -> 1051
/*     */     //   332: goto -> 780
/*     */     //   335: aload #4
/*     */     //   337: ldc 'instant'
/*     */     //   339: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   342: ifeq -> 1051
/*     */     //   345: bipush #35
/*     */     //   347: istore #5
/*     */     //   349: iconst_0
/*     */     //   350: istore #6
/*     */     //   352: iconst_0
/*     */     //   353: istore #7
/*     */     //   355: iconst_0
/*     */     //   356: istore #7
/*     */     //   358: iload #5
/*     */     //   360: istore #8
/*     */     //   362: iload #7
/*     */     //   364: iload #8
/*     */     //   366: if_icmpge -> 413
/*     */     //   369: iload #7
/*     */     //   371: istore #9
/*     */     //   373: iconst_0
/*     */     //   374: istore #10
/*     */     //   376: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   379: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   384: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   387: aload_2
/*     */     //   388: invokeinterface getOnGround : ()Z
/*     */     //   393: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   398: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   401: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   406: nop
/*     */     //   407: iinc #7, 1
/*     */     //   410: goto -> 362
/*     */     //   413: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   416: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   421: aload_2
/*     */     //   422: invokeinterface onStoppedUsingItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   427: goto -> 1051
/*     */     //   430: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   433: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   438: dup
/*     */     //   439: ifnonnull -> 445
/*     */     //   442: invokestatic throwNpe : ()V
/*     */     //   445: invokeinterface getItemInUseDuration : ()I
/*     */     //   450: aload_0
/*     */     //   451: getfield durationValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   454: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   457: checkcast java/lang/Number
/*     */     //   460: invokevirtual intValue : ()I
/*     */     //   463: if_icmple -> 1051
/*     */     //   466: bipush #36
/*     */     //   468: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   471: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   476: dup
/*     */     //   477: ifnonnull -> 483
/*     */     //   480: invokestatic throwNpe : ()V
/*     */     //   483: invokeinterface getItemInUseDuration : ()I
/*     */     //   488: isub
/*     */     //   489: istore #5
/*     */     //   491: iconst_0
/*     */     //   492: istore #6
/*     */     //   494: iconst_0
/*     */     //   495: istore #7
/*     */     //   497: iconst_0
/*     */     //   498: istore #7
/*     */     //   500: iload #5
/*     */     //   502: istore #8
/*     */     //   504: iload #7
/*     */     //   506: iload #8
/*     */     //   508: if_icmpge -> 569
/*     */     //   511: iload #7
/*     */     //   513: istore #9
/*     */     //   515: iconst_0
/*     */     //   516: istore #10
/*     */     //   518: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   521: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   526: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   529: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   532: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   537: dup
/*     */     //   538: ifnonnull -> 544
/*     */     //   541: invokestatic throwNpe : ()V
/*     */     //   544: invokeinterface getOnGround : ()Z
/*     */     //   549: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   554: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   557: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   562: nop
/*     */     //   563: iinc #7, 1
/*     */     //   566: goto -> 504
/*     */     //   569: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   572: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   577: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   580: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   585: dup
/*     */     //   586: ifnonnull -> 592
/*     */     //   589: invokestatic throwNpe : ()V
/*     */     //   592: invokeinterface onStoppedUsingItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   597: goto -> 1051
/*     */     //   600: aload_2
/*     */     //   601: invokeinterface getItemInUseDuration : ()I
/*     */     //   606: bipush #14
/*     */     //   608: if_icmple -> 1051
/*     */     //   611: bipush #20
/*     */     //   613: istore #5
/*     */     //   615: iconst_0
/*     */     //   616: istore #6
/*     */     //   618: iconst_0
/*     */     //   619: istore #7
/*     */     //   621: iconst_0
/*     */     //   622: istore #7
/*     */     //   624: iload #5
/*     */     //   626: istore #8
/*     */     //   628: iload #7
/*     */     //   630: iload #8
/*     */     //   632: if_icmpge -> 679
/*     */     //   635: iload #7
/*     */     //   637: istore #9
/*     */     //   639: iconst_0
/*     */     //   640: istore #10
/*     */     //   642: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   645: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   650: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   653: aload_2
/*     */     //   654: invokeinterface getOnGround : ()Z
/*     */     //   659: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   664: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   667: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   672: nop
/*     */     //   673: iinc #7, 1
/*     */     //   676: goto -> 628
/*     */     //   679: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   682: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   687: aload_2
/*     */     //   688: invokeinterface onStoppedUsingItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   693: goto -> 1051
/*     */     //   696: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   699: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   704: ldc 0.5
/*     */     //   706: invokeinterface setTimerSpeed : (F)V
/*     */     //   711: aload_0
/*     */     //   712: iconst_1
/*     */     //   713: putfield usedTimer : Z
/*     */     //   716: aload_0
/*     */     //   717: invokespecial send : ()V
/*     */     //   720: goto -> 1051
/*     */     //   723: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   726: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   731: ldc 1.22
/*     */     //   733: invokeinterface setTimerSpeed : (F)V
/*     */     //   738: aload_0
/*     */     //   739: iconst_1
/*     */     //   740: putfield usedTimer : Z
/*     */     //   743: goto -> 1051
/*     */     //   746: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   749: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   754: aload_0
/*     */     //   755: getfield speedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   758: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   761: checkcast java/lang/Number
/*     */     //   764: invokevirtual floatValue : ()F
/*     */     //   767: invokeinterface setTimerSpeed : (F)V
/*     */     //   772: aload_0
/*     */     //   773: iconst_1
/*     */     //   774: putfield usedTimer : Z
/*     */     //   777: goto -> 1051
/*     */     //   780: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   783: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   788: ldc 0.5
/*     */     //   790: invokeinterface setTimerSpeed : (F)V
/*     */     //   795: aload_0
/*     */     //   796: iconst_1
/*     */     //   797: putfield usedTimer : Z
/*     */     //   800: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   803: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   808: dup
/*     */     //   809: ifnonnull -> 815
/*     */     //   812: invokestatic throwNpe : ()V
/*     */     //   815: invokeinterface getTicksExisted : ()I
/*     */     //   820: iconst_2
/*     */     //   821: irem
/*     */     //   822: ifne -> 1051
/*     */     //   825: iconst_2
/*     */     //   826: istore #5
/*     */     //   828: iconst_0
/*     */     //   829: istore #6
/*     */     //   831: iconst_0
/*     */     //   832: istore #7
/*     */     //   834: iconst_0
/*     */     //   835: istore #7
/*     */     //   837: iload #5
/*     */     //   839: istore #8
/*     */     //   841: iload #7
/*     */     //   843: iload #8
/*     */     //   845: if_icmpge -> 906
/*     */     //   848: iload #7
/*     */     //   850: istore #9
/*     */     //   852: iconst_0
/*     */     //   853: istore #10
/*     */     //   855: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   858: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   863: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   866: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   869: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   874: dup
/*     */     //   875: ifnonnull -> 881
/*     */     //   878: invokestatic throwNpe : ()V
/*     */     //   881: invokeinterface getOnGround : ()Z
/*     */     //   886: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   891: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   894: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   899: nop
/*     */     //   900: iinc #7, 1
/*     */     //   903: goto -> 841
/*     */     //   906: goto -> 1051
/*     */     //   909: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   912: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   917: aload_0
/*     */     //   918: getfield customTimer : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   921: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   924: checkcast java/lang/Number
/*     */     //   927: invokevirtual floatValue : ()F
/*     */     //   930: invokeinterface setTimerSpeed : (F)V
/*     */     //   935: aload_0
/*     */     //   936: iconst_1
/*     */     //   937: putfield usedTimer : Z
/*     */     //   940: aload_0
/*     */     //   941: getfield msTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   944: aload_0
/*     */     //   945: getfield delayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   948: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   951: checkcast java/lang/Number
/*     */     //   954: invokevirtual intValue : ()I
/*     */     //   957: i2l
/*     */     //   958: invokevirtual hasTimePassed : (J)Z
/*     */     //   961: ifne -> 965
/*     */     //   964: return
/*     */     //   965: aload_0
/*     */     //   966: getfield customSpeedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   969: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   972: checkcast java/lang/Number
/*     */     //   975: invokevirtual intValue : ()I
/*     */     //   978: istore #5
/*     */     //   980: iconst_0
/*     */     //   981: istore #6
/*     */     //   983: iconst_0
/*     */     //   984: istore #7
/*     */     //   986: iconst_0
/*     */     //   987: istore #7
/*     */     //   989: iload #5
/*     */     //   991: istore #8
/*     */     //   993: iload #7
/*     */     //   995: iload #8
/*     */     //   997: if_icmpge -> 1044
/*     */     //   1000: iload #7
/*     */     //   1002: istore #9
/*     */     //   1004: iconst_0
/*     */     //   1005: istore #10
/*     */     //   1007: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1010: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1015: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1018: aload_2
/*     */     //   1019: invokeinterface getOnGround : ()Z
/*     */     //   1024: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1029: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1032: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1037: nop
/*     */     //   1038: iinc #7, 1
/*     */     //   1041: goto -> 993
/*     */     //   1044: aload_0
/*     */     //   1045: getfield msTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1048: invokevirtual reset : ()V
/*     */     //   1051: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #42	-> 6
/*     */     //   #42	-> 21
/*     */     //   #44	-> 24
/*     */     //   #45	-> 31
/*     */     //   #46	-> 45
/*     */     //   #49	-> 50
/*     */     //   #50	-> 59
/*     */     //   #51	-> 66
/*     */     //   #54	-> 67
/*     */     //   #56	-> 86
/*     */     //   #57	-> 122
/*     */     //   #84	-> 244
/*     */     //   #88	-> 257
/*     */     //   #101	-> 270
/*     */     //   #65	-> 283
/*     */     //   #72	-> 296
/*     */     //   #79	-> 309
/*     */     //   #92	-> 322
/*     */     //   #58	-> 335
/*     */     //   #59	-> 345
/*     */     //   #60	-> 376
/*     */     //   #61	-> 406
/*     */     //   #59	-> 407
/*     */     //   #63	-> 413
/*     */     //   #65	-> 430
/*     */     //   #66	-> 466
/*     */     //   #67	-> 518
/*     */     //   #68	-> 562
/*     */     //   #66	-> 563
/*     */     //   #70	-> 569
/*     */     //   #72	-> 600
/*     */     //   #73	-> 611
/*     */     //   #74	-> 642
/*     */     //   #75	-> 672
/*     */     //   #73	-> 673
/*     */     //   #77	-> 679
/*     */     //   #80	-> 696
/*     */     //   #81	-> 711
/*     */     //   #82	-> 716
/*     */     //   #85	-> 723
/*     */     //   #86	-> 738
/*     */     //   #89	-> 746
/*     */     //   #90	-> 772
/*     */     //   #93	-> 780
/*     */     //   #94	-> 795
/*     */     //   #95	-> 800
/*     */     //   #96	-> 825
/*     */     //   #97	-> 855
/*     */     //   #98	-> 899
/*     */     //   #96	-> 900
/*     */     //   #102	-> 909
/*     */     //   #103	-> 935
/*     */     //   #105	-> 940
/*     */     //   #106	-> 964
/*     */     //   #108	-> 965
/*     */     //   #109	-> 1007
/*     */     //   #110	-> 1037
/*     */     //   #108	-> 1038
/*     */     //   #112	-> 1044
/*     */     //   #114	-> 1051
/*     */     //   #116	-> 1051
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   373	33	9	it	I
/*     */     //   376	30	10	$i$a$-repeat-FastUse$onUpdate$1	I
/*     */     //   515	47	9	it	I
/*     */     //   518	44	10	$i$a$-repeat-FastUse$onUpdate$2	I
/*     */     //   639	33	9	it	I
/*     */     //   642	30	10	$i$a$-repeat-FastUse$onUpdate$3	I
/*     */     //   852	47	9	it	I
/*     */     //   855	44	10	$i$a$-repeat-FastUse$onUpdate$4	I
/*     */     //   1004	33	9	it	I
/*     */     //   1007	30	10	$i$a$-repeat-FastUse$onUpdate$5	I
/*     */     //   86	966	3	usingItem	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   24	1028	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1052	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/FastUse;
/*     */     //   0	1052	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onMove(@Nullable MoveEvent event) {
/* 120 */     IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 122 */     if (thePlayer == null || event == null)
/*     */       return; 
/* 124 */     if (!getState() || !thePlayer.isUsingItem() || !((Boolean)this.noMoveValue.get()).booleanValue()) {
/*     */       return;
/*     */     }
/* 127 */     if (thePlayer.getItemInUse() == null) Intrinsics.throwNpe();  IItem usingItem = thePlayer.getItemInUse().getItem();
/*     */     
/* 129 */     if (MinecraftInstance.classProvider.isItemFood(usingItem) || MinecraftInstance.classProvider.isItemBucketMilk(usingItem) || MinecraftInstance.classProvider.isItemPotion(usingItem))
/* 130 */       event.zero(); 
/*     */   }
/*     */   
/*     */   public void onDisable() {
/* 134 */     if (this.usedTimer) {
/* 135 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 136 */       this.usedTimer = false;
/*     */     } 
/*     */   }
/*     */   @Nullable
/*     */   public String getTag() {
/* 141 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\FastUse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */