/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Reflection;
/*     */ import kotlin.reflect.KDeclarationContainer;
/*     */ import net.ccbluex.liquidbounce.api.IClassProvider;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "LiquidWalk", description = "Allows you to walk on water.", category = ModuleCategory.MOVEMENT, keyBind = 36)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000R\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\021\032\0020\0222\006\020\023\032\0020\024H\007J\020\020\025\032\0020\0222\006\020\023\032\0020\026H\007J\020\020\027\032\0020\0222\006\020\023\032\0020\030H\007J\020\020\031\032\0020\0222\006\020\023\032\0020\032H\007J\022\020\033\032\0020\0222\b\020\023\032\004\030\0010\034H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\007\020\bR\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/LiquidWalk;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aacFlyValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "nextTick", "", "noJumpValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "onBlockBB", "", "event", "Lnet/ccbluex/liquidbounce/event/BlockBBEvent;", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class LiquidWalk extends Module {
/*     */   @NotNull
/*  19 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Vanilla", "NCP", "AAC", "AAC3.3.11", "AACFly", "Spartan", "Dolphin" }, "NCP"); @NotNull public final ListValue getModeValue() { return this.modeValue; }
/*  20 */    private final BoolValue noJumpValue = new BoolValue("NoJump", false);
/*  21 */   private final FloatValue aacFlyValue = new FloatValue("AACFlyMotion", 0.5F, 0.1F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean nextTick;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: astore_2
/*     */     //   9: aload_2
/*     */     //   10: ifnull -> 22
/*     */     //   13: aload_2
/*     */     //   14: invokeinterface isSneaking : ()Z
/*     */     //   19: ifeq -> 23
/*     */     //   22: return
/*     */     //   23: aload_0
/*     */     //   24: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   27: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   30: checkcast java/lang/String
/*     */     //   33: astore_3
/*     */     //   34: iconst_0
/*     */     //   35: istore #4
/*     */     //   37: aload_3
/*     */     //   38: dup
/*     */     //   39: ifnonnull -> 52
/*     */     //   42: new kotlin/TypeCastException
/*     */     //   45: dup
/*     */     //   46: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   48: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   51: athrow
/*     */     //   52: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   55: dup
/*     */     //   56: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   58: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   61: astore_3
/*     */     //   62: aload_3
/*     */     //   63: invokevirtual hashCode : ()I
/*     */     //   66: lookupswitch default -> 919, -2011701869 -> 148, 96323 -> 136, 108891 -> 172, 233102203 -> 184, 1492139161 -> 160, 1837070814 -> 124
/*     */     //   124: aload_3
/*     */     //   125: ldc 'dolphin'
/*     */     //   127: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   130: ifeq -> 919
/*     */     //   133: goto -> 894
/*     */     //   136: aload_3
/*     */     //   137: ldc 'aac'
/*     */     //   139: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   142: ifeq -> 919
/*     */     //   145: goto -> 259
/*     */     //   148: aload_3
/*     */     //   149: ldc 'spartan'
/*     */     //   151: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   154: ifeq -> 919
/*     */     //   157: goto -> 553
/*     */     //   160: aload_3
/*     */     //   161: ldc 'aac3.3.11'
/*     */     //   163: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   166: ifeq -> 919
/*     */     //   169: goto -> 742
/*     */     //   172: aload_3
/*     */     //   173: ldc 'ncp'
/*     */     //   175: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   178: ifeq -> 919
/*     */     //   181: goto -> 193
/*     */     //   184: aload_3
/*     */     //   185: ldc 'vanilla'
/*     */     //   187: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   190: ifeq -> 919
/*     */     //   193: aload_2
/*     */     //   194: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   199: new net/ccbluex/liquidbounce/features/module/modules/movement/LiquidWalk$onUpdate$1
/*     */     //   202: dup
/*     */     //   203: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   206: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/IClassProvider;)V
/*     */     //   209: checkcast kotlin/jvm/functions/Function1
/*     */     //   212: invokestatic collideBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;Lkotlin/jvm/functions/Function1;)Z
/*     */     //   215: ifeq -> 919
/*     */     //   218: aload_2
/*     */     //   219: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   222: getstatic net/ccbluex/liquidbounce/api/enums/MaterialType.AIR : Lnet/ccbluex/liquidbounce/api/enums/MaterialType;
/*     */     //   225: invokeinterface getMaterialEnum : (Lnet/ccbluex/liquidbounce/api/enums/MaterialType;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   230: invokeinterface isInsideOfMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;)Z
/*     */     //   235: ifeq -> 919
/*     */     //   238: aload_2
/*     */     //   239: invokeinterface isSneaking : ()Z
/*     */     //   244: ifne -> 919
/*     */     //   247: aload_2
/*     */     //   248: ldc2_w 0.08
/*     */     //   251: invokeinterface setMotionY : (D)V
/*     */     //   256: goto -> 919
/*     */     //   259: aload_2
/*     */     //   260: invokeinterface getPosition : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   265: invokevirtual down : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   268: astore #4
/*     */     //   270: aload_2
/*     */     //   271: invokeinterface getOnGround : ()Z
/*     */     //   276: ifne -> 301
/*     */     //   279: aload #4
/*     */     //   281: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   284: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   287: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.WATER : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   290: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   295: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   298: ifne -> 310
/*     */     //   301: aload_2
/*     */     //   302: invokeinterface isInWater : ()Z
/*     */     //   307: ifeq -> 534
/*     */     //   310: aload_2
/*     */     //   311: invokeinterface getSprinting : ()Z
/*     */     //   316: ifne -> 407
/*     */     //   319: aload_2
/*     */     //   320: dup
/*     */     //   321: invokeinterface getMotionX : ()D
/*     */     //   326: ldc2_w 0.99999
/*     */     //   329: dmul
/*     */     //   330: invokeinterface setMotionX : (D)V
/*     */     //   335: aload_2
/*     */     //   336: dup
/*     */     //   337: invokeinterface getMotionY : ()D
/*     */     //   342: dconst_0
/*     */     //   343: dmul
/*     */     //   344: invokeinterface setMotionY : (D)V
/*     */     //   349: aload_2
/*     */     //   350: dup
/*     */     //   351: invokeinterface getMotionZ : ()D
/*     */     //   356: ldc2_w 0.99999
/*     */     //   359: dmul
/*     */     //   360: invokeinterface setMotionZ : (D)V
/*     */     //   365: aload_2
/*     */     //   366: invokeinterface isCollidedHorizontally : ()Z
/*     */     //   371: ifeq -> 492
/*     */     //   374: aload_2
/*     */     //   375: aload_2
/*     */     //   376: invokeinterface getPosY : ()D
/*     */     //   381: aload_2
/*     */     //   382: invokeinterface getPosY : ()D
/*     */     //   387: iconst_1
/*     */     //   388: i2d
/*     */     //   389: dsub
/*     */     //   390: d2i
/*     */     //   391: i2d
/*     */     //   392: dsub
/*     */     //   393: d2i
/*     */     //   394: i2f
/*     */     //   395: ldc 8.0
/*     */     //   397: fdiv
/*     */     //   398: f2d
/*     */     //   399: invokeinterface setMotionY : (D)V
/*     */     //   404: goto -> 492
/*     */     //   407: aload_2
/*     */     //   408: dup
/*     */     //   409: invokeinterface getMotionX : ()D
/*     */     //   414: ldc2_w 0.99999
/*     */     //   417: dmul
/*     */     //   418: invokeinterface setMotionX : (D)V
/*     */     //   423: aload_2
/*     */     //   424: dup
/*     */     //   425: invokeinterface getMotionY : ()D
/*     */     //   430: dconst_0
/*     */     //   431: dmul
/*     */     //   432: invokeinterface setMotionY : (D)V
/*     */     //   437: aload_2
/*     */     //   438: dup
/*     */     //   439: invokeinterface getMotionZ : ()D
/*     */     //   444: ldc2_w 0.99999
/*     */     //   447: dmul
/*     */     //   448: invokeinterface setMotionZ : (D)V
/*     */     //   453: aload_2
/*     */     //   454: invokeinterface isCollidedHorizontally : ()Z
/*     */     //   459: ifeq -> 492
/*     */     //   462: aload_2
/*     */     //   463: aload_2
/*     */     //   464: invokeinterface getPosY : ()D
/*     */     //   469: aload_2
/*     */     //   470: invokeinterface getPosY : ()D
/*     */     //   475: iconst_1
/*     */     //   476: i2d
/*     */     //   477: dsub
/*     */     //   478: d2i
/*     */     //   479: i2d
/*     */     //   480: dsub
/*     */     //   481: d2i
/*     */     //   482: i2f
/*     */     //   483: ldc 8.0
/*     */     //   485: fdiv
/*     */     //   486: f2d
/*     */     //   487: invokeinterface setMotionY : (D)V
/*     */     //   492: aload_2
/*     */     //   493: invokeinterface getFallDistance : ()F
/*     */     //   498: iconst_4
/*     */     //   499: i2f
/*     */     //   500: fcmpl
/*     */     //   501: iflt -> 516
/*     */     //   504: aload_2
/*     */     //   505: ldc2_w -0.004
/*     */     //   508: invokeinterface setMotionY : (D)V
/*     */     //   513: goto -> 534
/*     */     //   516: aload_2
/*     */     //   517: invokeinterface isInWater : ()Z
/*     */     //   522: ifeq -> 534
/*     */     //   525: aload_2
/*     */     //   526: ldc2_w 0.09
/*     */     //   529: invokeinterface setMotionY : (D)V
/*     */     //   534: aload_2
/*     */     //   535: invokeinterface getHurtTime : ()I
/*     */     //   540: ifeq -> 919
/*     */     //   543: aload_2
/*     */     //   544: iconst_0
/*     */     //   545: invokeinterface setOnGround : (Z)V
/*     */     //   550: goto -> 919
/*     */     //   553: aload_2
/*     */     //   554: invokeinterface isInWater : ()Z
/*     */     //   559: ifeq -> 919
/*     */     //   562: aload_2
/*     */     //   563: invokeinterface isCollidedHorizontally : ()Z
/*     */     //   568: ifeq -> 588
/*     */     //   571: aload_2
/*     */     //   572: dup
/*     */     //   573: invokeinterface getMotionY : ()D
/*     */     //   578: ldc2_w 0.15
/*     */     //   581: dadd
/*     */     //   582: invokeinterface setMotionY : (D)V
/*     */     //   587: return
/*     */     //   588: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   591: dup
/*     */     //   592: aload_2
/*     */     //   593: invokeinterface getPosX : ()D
/*     */     //   598: aload_2
/*     */     //   599: invokeinterface getPosY : ()D
/*     */     //   604: iconst_1
/*     */     //   605: i2d
/*     */     //   606: dadd
/*     */     //   607: aload_2
/*     */     //   608: invokeinterface getPosZ : ()D
/*     */     //   613: invokespecial <init> : (DDD)V
/*     */     //   616: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   619: astore #4
/*     */     //   621: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   624: dup
/*     */     //   625: aload_2
/*     */     //   626: invokeinterface getPosX : ()D
/*     */     //   631: aload_2
/*     */     //   632: invokeinterface getPosY : ()D
/*     */     //   637: ldc2_w 1.1
/*     */     //   640: dadd
/*     */     //   641: aload_2
/*     */     //   642: invokeinterface getPosZ : ()D
/*     */     //   647: invokespecial <init> : (DDD)V
/*     */     //   650: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   653: astore #5
/*     */     //   655: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   658: aload #5
/*     */     //   660: invokeinterface isBlockLiquid : (Ljava/lang/Object;)Z
/*     */     //   665: ifeq -> 680
/*     */     //   668: aload_2
/*     */     //   669: ldc2_w 0.1
/*     */     //   672: invokeinterface setMotionY : (D)V
/*     */     //   677: goto -> 700
/*     */     //   680: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   683: aload #4
/*     */     //   685: invokeinterface isBlockLiquid : (Ljava/lang/Object;)Z
/*     */     //   690: ifeq -> 700
/*     */     //   693: aload_2
/*     */     //   694: dconst_0
/*     */     //   695: invokeinterface setMotionY : (D)V
/*     */     //   700: aload_2
/*     */     //   701: iconst_1
/*     */     //   702: invokeinterface setOnGround : (Z)V
/*     */     //   707: aload_2
/*     */     //   708: dup
/*     */     //   709: invokeinterface getMotionX : ()D
/*     */     //   714: ldc2_w 1.085
/*     */     //   717: dmul
/*     */     //   718: invokeinterface setMotionX : (D)V
/*     */     //   723: aload_2
/*     */     //   724: dup
/*     */     //   725: invokeinterface getMotionZ : ()D
/*     */     //   730: ldc2_w 1.085
/*     */     //   733: dmul
/*     */     //   734: invokeinterface setMotionZ : (D)V
/*     */     //   739: goto -> 919
/*     */     //   742: aload_2
/*     */     //   743: invokeinterface isInWater : ()Z
/*     */     //   748: ifeq -> 919
/*     */     //   751: aload_2
/*     */     //   752: dup
/*     */     //   753: invokeinterface getMotionX : ()D
/*     */     //   758: ldc2_w 1.17
/*     */     //   761: dmul
/*     */     //   762: invokeinterface setMotionX : (D)V
/*     */     //   767: aload_2
/*     */     //   768: dup
/*     */     //   769: invokeinterface getMotionZ : ()D
/*     */     //   774: ldc2_w 1.17
/*     */     //   777: dmul
/*     */     //   778: invokeinterface setMotionZ : (D)V
/*     */     //   783: aload_2
/*     */     //   784: invokeinterface isCollidedHorizontally : ()Z
/*     */     //   789: ifeq -> 804
/*     */     //   792: aload_2
/*     */     //   793: ldc2_w 0.24
/*     */     //   796: invokeinterface setMotionY : (D)V
/*     */     //   801: goto -> 919
/*     */     //   804: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   807: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   812: dup
/*     */     //   813: ifnonnull -> 819
/*     */     //   816: invokestatic throwNpe : ()V
/*     */     //   819: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   822: dup
/*     */     //   823: aload_2
/*     */     //   824: invokeinterface getPosX : ()D
/*     */     //   829: aload_2
/*     */     //   830: invokeinterface getPosY : ()D
/*     */     //   835: dconst_1
/*     */     //   836: dadd
/*     */     //   837: aload_2
/*     */     //   838: invokeinterface getPosZ : ()D
/*     */     //   843: invokespecial <init> : (DDD)V
/*     */     //   846: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   851: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   856: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   859: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   862: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   867: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   870: iconst_1
/*     */     //   871: ixor
/*     */     //   872: ifeq -> 919
/*     */     //   875: aload_2
/*     */     //   876: dup
/*     */     //   877: invokeinterface getMotionY : ()D
/*     */     //   882: ldc2_w 0.04
/*     */     //   885: dadd
/*     */     //   886: invokeinterface setMotionY : (D)V
/*     */     //   891: goto -> 919
/*     */     //   894: aload_2
/*     */     //   895: invokeinterface isInWater : ()Z
/*     */     //   900: ifeq -> 919
/*     */     //   903: aload_2
/*     */     //   904: dup
/*     */     //   905: invokeinterface getMotionY : ()D
/*     */     //   910: ldc2_w 0.03999999910593033
/*     */     //   913: dadd
/*     */     //   914: invokeinterface setMotionY : (D)V
/*     */     //   919: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #27	-> 0
/*     */     //   #29	-> 9
/*     */     //   #31	-> 23
/*     */     //   #74	-> 124
/*     */     //   #33	-> 136
/*     */     //   #51	-> 148
/*     */     //   #69	-> 160
/*     */     //   #32	-> 172
/*     */     //   #34	-> 259
/*     */     //   #35	-> 270
/*     */     //   #36	-> 310
/*     */     //   #37	-> 319
/*     */     //   #38	-> 335
/*     */     //   #39	-> 349
/*     */     //   #40	-> 365
/*     */     //   #42	-> 407
/*     */     //   #43	-> 423
/*     */     //   #44	-> 437
/*     */     //   #45	-> 453
/*     */     //   #46	-> 492
/*     */     //   #47	-> 492
/*     */     //   #49	-> 534
/*     */     //   #51	-> 553
/*     */     //   #52	-> 562
/*     */     //   #53	-> 571
/*     */     //   #54	-> 587
/*     */     //   #56	-> 588
/*     */     //   #57	-> 621
/*     */     //   #59	-> 655
/*     */     //   #60	-> 668
/*     */     //   #61	-> 680
/*     */     //   #62	-> 693
/*     */     //   #63	-> 700
/*     */     //   #65	-> 700
/*     */     //   #66	-> 707
/*     */     //   #67	-> 723
/*     */     //   #69	-> 742
/*     */     //   #70	-> 751
/*     */     //   #71	-> 767
/*     */     //   #72	-> 783
/*     */     //   #74	-> 894
/*     */     //   #75	-> 919
/*     */     //   #76	-> 919
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   270	280	4	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   655	84	5	blockUp	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   621	118	4	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   9	911	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	920	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/LiquidWalk;
/*     */     //   0	920	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onMove(@NotNull MoveEvent event) {
/*  80 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str1 = (String)this.modeValue.get(), str2 = "aacfly"; boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str1.toLowerCase(); if (Intrinsics.areEqual(str2, str3)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isInWater()) {
/*  81 */         event.setY(((Number)this.aacFlyValue.get()).floatValue());
/*  82 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(((Number)this.aacFlyValue.get()).floatValue());
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onBlockBB(@NotNull BlockBBEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'event'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   10: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   15: ifnonnull -> 19
/*     */     //   18: return
/*     */     //   19: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   22: aload_1
/*     */     //   23: invokevirtual getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   26: invokeinterface isBlockLiquid : (Ljava/lang/Object;)Z
/*     */     //   31: ifeq -> 236
/*     */     //   34: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   37: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   42: dup
/*     */     //   43: ifnonnull -> 49
/*     */     //   46: invokestatic throwNpe : ()V
/*     */     //   49: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   54: new net/ccbluex/liquidbounce/features/module/modules/movement/LiquidWalk$onBlockBB$1
/*     */     //   57: dup
/*     */     //   58: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   61: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/IClassProvider;)V
/*     */     //   64: checkcast kotlin/jvm/functions/Function1
/*     */     //   67: invokestatic collideBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;Lkotlin/jvm/functions/Function1;)Z
/*     */     //   70: ifne -> 236
/*     */     //   73: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   76: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   81: dup
/*     */     //   82: ifnonnull -> 88
/*     */     //   85: invokestatic throwNpe : ()V
/*     */     //   88: invokeinterface isSneaking : ()Z
/*     */     //   93: ifne -> 236
/*     */     //   96: aload_0
/*     */     //   97: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   100: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   103: checkcast java/lang/String
/*     */     //   106: astore_2
/*     */     //   107: iconst_0
/*     */     //   108: istore_3
/*     */     //   109: aload_2
/*     */     //   110: dup
/*     */     //   111: ifnonnull -> 124
/*     */     //   114: new kotlin/TypeCastException
/*     */     //   117: dup
/*     */     //   118: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   120: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   123: athrow
/*     */     //   124: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   127: dup
/*     */     //   128: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   130: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   133: astore_2
/*     */     //   134: aload_2
/*     */     //   135: invokevirtual hashCode : ()I
/*     */     //   138: lookupswitch default -> 236, 108891 -> 164, 233102203 -> 176
/*     */     //   164: aload_2
/*     */     //   165: ldc 'ncp'
/*     */     //   167: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   170: ifeq -> 236
/*     */     //   173: goto -> 185
/*     */     //   176: aload_2
/*     */     //   177: ldc 'vanilla'
/*     */     //   179: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   182: ifeq -> 236
/*     */     //   185: aload_1
/*     */     //   186: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   189: aload_1
/*     */     //   190: invokevirtual getX : ()I
/*     */     //   193: i2d
/*     */     //   194: aload_1
/*     */     //   195: invokevirtual getY : ()I
/*     */     //   198: i2d
/*     */     //   199: aload_1
/*     */     //   200: invokevirtual getZ : ()I
/*     */     //   203: i2d
/*     */     //   204: aload_1
/*     */     //   205: invokevirtual getX : ()I
/*     */     //   208: i2d
/*     */     //   209: iconst_1
/*     */     //   210: i2d
/*     */     //   211: dadd
/*     */     //   212: aload_1
/*     */     //   213: invokevirtual getY : ()I
/*     */     //   216: i2d
/*     */     //   217: iconst_1
/*     */     //   218: i2d
/*     */     //   219: dadd
/*     */     //   220: aload_1
/*     */     //   221: invokevirtual getZ : ()I
/*     */     //   224: i2d
/*     */     //   225: iconst_1
/*     */     //   226: i2d
/*     */     //   227: dadd
/*     */     //   228: invokeinterface createAxisAlignedBB : (DDDDDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   233: invokevirtual setBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*     */     //   236: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #88	-> 7
/*     */     //   #89	-> 18
/*     */     //   #91	-> 19
/*     */     //   #92	-> 96
/*     */     //   #93	-> 164
/*     */     //   #94	-> 236
/*     */     //   #96	-> 236
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	237	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/LiquidWalk;
/*     */     //   0	237	1	event	Lnet/ccbluex/liquidbounce/event/BlockBBEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 100 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 102 */     if (thePlayer == null || !StringsKt.equals((String)this.modeValue.get(), "NCP", true)) {
/*     */       return;
/*     */     }
/*     */     
/* 106 */     ICPacketPlayer packetPlayer = event.getPacket().asCPacketPlayer();
/*     */     
/* 108 */     if (MinecraftInstance.classProvider.isCPacketPlayer(event.getPacket()) && BlockUtils.collideBlock(MinecraftInstance.classProvider.createAxisAlignedBB(thePlayer.getEntityBoundingBox().getMaxX(), thePlayer.getEntityBoundingBox().getMaxY(), thePlayer.getEntityBoundingBox().getMaxZ(), thePlayer.getEntityBoundingBox().getMinX(), thePlayer.getEntityBoundingBox().getMinY() - 0.01D, thePlayer.getEntityBoundingBox().getMinZ()), new LiquidWalk$onPacket$1(MinecraftInstance.classProvider))) {
/* 109 */       this.nextTick = !this.nextTick;
/* 110 */       if (this.nextTick) packetPlayer.setY(packetPlayer.getY() - 0.001D);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 117 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 119 */       IBlock block = BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() - 0.01D, thePlayer.getPosZ()));
/*     */       
/* 121 */       if (((Boolean)this.noJumpValue.get()).booleanValue() && MinecraftInstance.classProvider.isBlockLiquid(block))
/* 122 */         event.cancelEvent(); 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @NotNull
/* 126 */   public String getTag() { return (String)this.modeValue.get(); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\LiquidWalk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */