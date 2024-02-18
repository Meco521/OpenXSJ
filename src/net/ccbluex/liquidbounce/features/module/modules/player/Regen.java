/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Regen", description = "Regenerates your health much faster.", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/Regen;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "foodValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "healthValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "noAirValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "potionEffectValue", "resetTimer", "", "speedValue", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Regen extends Module {
/* 17 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Vanilla", "Spartan" }, "Vanilla");
/* 18 */   private final IntegerValue healthValue = new IntegerValue("Health", 18, 0, 20);
/* 19 */   private final IntegerValue foodValue = new IntegerValue("Food", 18, 0, 20);
/* 20 */   private final IntegerValue speedValue = new IntegerValue("Speed", 100, 1, 100);
/* 21 */   private final BoolValue noAirValue = new BoolValue("NoAir", false);
/* 22 */   private final BoolValue potionEffectValue = new BoolValue("PotionEffect", false);
/*    */   private boolean resetTimer;
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getfield resetTimer : Z
/*    */     //   10: ifeq -> 27
/*    */     //   13: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   16: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*    */     //   21: fconst_1
/*    */     //   22: invokeinterface setTimerSpeed : (F)V
/*    */     //   27: aload_0
/*    */     //   28: iconst_0
/*    */     //   29: putfield resetTimer : Z
/*    */     //   32: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   35: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   40: dup
/*    */     //   41: ifnull -> 47
/*    */     //   44: goto -> 49
/*    */     //   47: pop
/*    */     //   48: return
/*    */     //   49: astore_2
/*    */     //   50: aload_0
/*    */     //   51: getfield noAirValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   54: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   57: checkcast java/lang/Boolean
/*    */     //   60: invokevirtual booleanValue : ()Z
/*    */     //   63: ifeq -> 75
/*    */     //   66: aload_2
/*    */     //   67: invokeinterface getOnGround : ()Z
/*    */     //   72: ifeq -> 463
/*    */     //   75: aload_2
/*    */     //   76: invokeinterface getCapabilities : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;
/*    */     //   81: invokeinterface isCreativeMode : ()Z
/*    */     //   86: ifne -> 463
/*    */     //   89: aload_2
/*    */     //   90: invokeinterface getFoodStats : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IFoodStats;
/*    */     //   95: invokeinterface getFoodLevel : ()I
/*    */     //   100: aload_0
/*    */     //   101: getfield foodValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   104: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   107: checkcast java/lang/Number
/*    */     //   110: invokevirtual intValue : ()I
/*    */     //   113: if_icmple -> 463
/*    */     //   116: aload_2
/*    */     //   117: invokeinterface isEntityAlive : ()Z
/*    */     //   122: ifeq -> 463
/*    */     //   125: aload_2
/*    */     //   126: invokeinterface getHealth : ()F
/*    */     //   131: aload_0
/*    */     //   132: getfield healthValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   135: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   138: checkcast java/lang/Number
/*    */     //   141: invokevirtual floatValue : ()F
/*    */     //   144: fcmpg
/*    */     //   145: ifge -> 463
/*    */     //   148: aload_0
/*    */     //   149: getfield potionEffectValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   152: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   155: checkcast java/lang/Boolean
/*    */     //   158: invokevirtual booleanValue : ()Z
/*    */     //   161: ifeq -> 185
/*    */     //   164: aload_2
/*    */     //   165: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   168: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.REGENERATION : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*    */     //   171: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*    */     //   176: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*    */     //   181: ifne -> 185
/*    */     //   184: return
/*    */     //   185: aload_0
/*    */     //   186: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   189: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   192: checkcast java/lang/String
/*    */     //   195: astore_3
/*    */     //   196: iconst_0
/*    */     //   197: istore #4
/*    */     //   199: aload_3
/*    */     //   200: dup
/*    */     //   201: ifnonnull -> 214
/*    */     //   204: new kotlin/TypeCastException
/*    */     //   207: dup
/*    */     //   208: ldc 'null cannot be cast to non-null type java.lang.String'
/*    */     //   210: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   213: athrow
/*    */     //   214: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   217: dup
/*    */     //   218: ldc '(this as java.lang.String).toLowerCase()'
/*    */     //   220: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   223: astore_3
/*    */     //   224: aload_3
/*    */     //   225: invokevirtual hashCode : ()I
/*    */     //   228: lookupswitch default -> 463, -2011701869 -> 256, 233102203 -> 268
/*    */     //   256: aload_3
/*    */     //   257: ldc 'spartan'
/*    */     //   259: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   262: ifeq -> 463
/*    */     //   265: goto -> 359
/*    */     //   268: aload_3
/*    */     //   269: ldc 'vanilla'
/*    */     //   271: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   274: ifeq -> 463
/*    */     //   277: aload_0
/*    */     //   278: getfield speedValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   281: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   284: checkcast java/lang/Number
/*    */     //   287: invokevirtual intValue : ()I
/*    */     //   290: istore #4
/*    */     //   292: iconst_0
/*    */     //   293: istore #5
/*    */     //   295: iconst_0
/*    */     //   296: istore #6
/*    */     //   298: iconst_0
/*    */     //   299: istore #6
/*    */     //   301: iload #4
/*    */     //   303: istore #7
/*    */     //   305: iload #6
/*    */     //   307: iload #7
/*    */     //   309: if_icmpge -> 356
/*    */     //   312: iload #6
/*    */     //   314: istore #8
/*    */     //   316: iconst_0
/*    */     //   317: istore #9
/*    */     //   319: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   322: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   327: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   330: aload_2
/*    */     //   331: invokeinterface getOnGround : ()Z
/*    */     //   336: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*    */     //   341: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   344: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   349: nop
/*    */     //   350: iinc #6, 1
/*    */     //   353: goto -> 305
/*    */     //   356: goto -> 463
/*    */     //   359: invokestatic isMoving : ()Z
/*    */     //   362: ifne -> 374
/*    */     //   365: aload_2
/*    */     //   366: invokeinterface getOnGround : ()Z
/*    */     //   371: ifne -> 375
/*    */     //   374: return
/*    */     //   375: bipush #9
/*    */     //   377: istore #4
/*    */     //   379: iconst_0
/*    */     //   380: istore #5
/*    */     //   382: iconst_0
/*    */     //   383: istore #6
/*    */     //   385: iconst_0
/*    */     //   386: istore #6
/*    */     //   388: iload #4
/*    */     //   390: istore #7
/*    */     //   392: iload #6
/*    */     //   394: iload #7
/*    */     //   396: if_icmpge -> 443
/*    */     //   399: iload #6
/*    */     //   401: istore #8
/*    */     //   403: iconst_0
/*    */     //   404: istore #9
/*    */     //   406: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   409: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   414: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   417: aload_2
/*    */     //   418: invokeinterface getOnGround : ()Z
/*    */     //   423: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*    */     //   428: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   431: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   436: nop
/*    */     //   437: iinc #6, 1
/*    */     //   440: goto -> 392
/*    */     //   443: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   446: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*    */     //   451: ldc 0.45
/*    */     //   453: invokeinterface setTimerSpeed : (F)V
/*    */     //   458: aload_0
/*    */     //   459: iconst_1
/*    */     //   460: putfield resetTimer : Z
/*    */     //   463: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #28	-> 6
/*    */     //   #29	-> 13
/*    */     //   #30	-> 27
/*    */     //   #32	-> 32
/*    */     //   #32	-> 47
/*    */     //   #34	-> 50
/*    */     //   #35	-> 50
/*    */     //   #34	-> 50
/*    */     //   #35	-> 100
/*    */     //   #36	-> 148
/*    */     //   #37	-> 184
/*    */     //   #39	-> 185
/*    */     //   #46	-> 256
/*    */     //   #40	-> 268
/*    */     //   #41	-> 277
/*    */     //   #42	-> 319
/*    */     //   #43	-> 349
/*    */     //   #41	-> 350
/*    */     //   #47	-> 359
/*    */     //   #48	-> 374
/*    */     //   #50	-> 375
/*    */     //   #51	-> 406
/*    */     //   #52	-> 436
/*    */     //   #50	-> 437
/*    */     //   #54	-> 443
/*    */     //   #55	-> 458
/*    */     //   #57	-> 463
/*    */     //   #59	-> 463
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   316	33	8	it	I
/*    */     //   319	30	9	$i$a$-repeat-Regen$onUpdate$1	I
/*    */     //   403	33	8	it	I
/*    */     //   406	30	9	$i$a$-repeat-Regen$onUpdate$2	I
/*    */     //   50	414	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	464	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/Regen;
/*    */     //   0	464	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\Regen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */