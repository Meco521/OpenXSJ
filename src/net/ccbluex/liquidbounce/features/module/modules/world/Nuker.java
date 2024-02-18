/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "Nuker", description = "Breaks all blocks around you.", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000f\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\b\007\030\000 #2\0020\001:\001#B\005¢\006\002\020\002J\020\020\031\032\0020\0322\006\020\033\032\0020\034H\007J\020\020\035\032\0020\0322\006\020\033\032\0020\036H\007J\020\020\037\032\0020 2\006\020!\032\0020\"H\002R\036\020\003\032\022\022\004\022\0020\0050\004j\b\022\004\022\0020\005`\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\020\020\t\032\004\030\0010\005X\016¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\bX\016¢\006\002\n\000R\016\020\017\032\0020\013X\004¢\006\002\n\000R\016\020\020\032\0020\021X\016¢\006\002\n\000R\016\020\022\032\0020\013X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\rX\004¢\006\002\n\000R\016\020\030\032\0020\rX\004¢\006\002\n\000¨\006$"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Nuker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "attackedBlocks", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "Lkotlin/collections/ArrayList;", "blockHitDelay", "", "currentBlock", "hitDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "layerValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "nuke", "nukeDelay", "nukeTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "nukeValue", "priorityValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "radiusValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "rotationsValue", "throughWallsValue", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "validBlock", "", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "Companion", "XSJClient"})
/*     */ public final class Nuker
/*     */   extends Module
/*     */ {
/*  36 */   private final FloatValue radiusValue = new FloatValue("Radius", 5.2F, 1.0F, 6.0F);
/*  37 */   private final BoolValue throughWallsValue = new BoolValue("ThroughWalls", false);
/*  38 */   private final ListValue priorityValue = new ListValue("Priority", new String[] { "Distance", "Hardness" }, "Distance");
/*  39 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/*  40 */   private final BoolValue layerValue = new BoolValue("Layer", false);
/*  41 */   private final IntegerValue hitDelayValue = new IntegerValue("HitDelay", 4, 0, 20);
/*  42 */   private final IntegerValue nukeValue = new IntegerValue("Nuke", 1, 1, 20);
/*  43 */   private final IntegerValue nukeDelay = new IntegerValue("NukeDelay", 1, 1, 20); private final ArrayList<WBlockPos> attackedBlocks; private WBlockPos currentBlock; private int blockHitDelay; private TickTimer nukeTimer;
/*     */   private int nuke;
/*     */   private static float currentDamage;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   public Nuker() {
/*  49 */     Nuker nuker = this; boolean bool = false; ArrayList<WBlockPos> arrayList = new ArrayList();
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.nukeTimer = new TickTimer();
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield blockHitDelay : I
/*     */     //   10: ifle -> 50
/*     */     //   13: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   16: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   19: ldc net/ccbluex/liquidbounce/features/module/modules/world/FastBreak
/*     */     //   21: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   24: dup
/*     */     //   25: ifnonnull -> 31
/*     */     //   28: invokestatic throwNpe : ()V
/*     */     //   31: invokevirtual getState : ()Z
/*     */     //   34: ifne -> 50
/*     */     //   37: aload_0
/*     */     //   38: dup
/*     */     //   39: getfield blockHitDelay : I
/*     */     //   42: dup
/*     */     //   43: istore_2
/*     */     //   44: iconst_m1
/*     */     //   45: iadd
/*     */     //   46: putfield blockHitDelay : I
/*     */     //   49: return
/*     */     //   50: aload_0
/*     */     //   51: getfield nukeTimer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   54: invokevirtual update : ()V
/*     */     //   57: aload_0
/*     */     //   58: getfield nukeTimer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   61: aload_0
/*     */     //   62: getfield nukeDelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   65: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   68: checkcast java/lang/Number
/*     */     //   71: invokevirtual intValue : ()I
/*     */     //   74: invokevirtual hasTimePassed : (I)Z
/*     */     //   77: ifeq -> 92
/*     */     //   80: aload_0
/*     */     //   81: iconst_0
/*     */     //   82: putfield nuke : I
/*     */     //   85: aload_0
/*     */     //   86: getfield nukeTimer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   89: invokevirtual reset : ()V
/*     */     //   92: aload_0
/*     */     //   93: getfield attackedBlocks : Ljava/util/ArrayList;
/*     */     //   96: invokevirtual clear : ()V
/*     */     //   99: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   102: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   107: dup
/*     */     //   108: ifnonnull -> 114
/*     */     //   111: invokestatic throwNpe : ()V
/*     */     //   114: astore_2
/*     */     //   115: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   118: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   123: invokeinterface isInCreativeMode : ()Z
/*     */     //   128: ifne -> 1962
/*     */     //   131: aload_0
/*     */     //   132: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   135: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   138: checkcast java/lang/Number
/*     */     //   141: invokevirtual floatValue : ()F
/*     */     //   144: invokestatic roundToInt : (F)I
/*     */     //   147: iconst_1
/*     */     //   148: iadd
/*     */     //   149: invokestatic searchBlocks : (I)Ljava/util/Map;
/*     */     //   152: astore #4
/*     */     //   154: iconst_0
/*     */     //   155: istore #5
/*     */     //   157: aload #4
/*     */     //   159: astore #6
/*     */     //   161: new java/util/LinkedHashMap
/*     */     //   164: dup
/*     */     //   165: invokespecial <init> : ()V
/*     */     //   168: checkcast java/util/Map
/*     */     //   171: astore #7
/*     */     //   173: iconst_0
/*     */     //   174: istore #8
/*     */     //   176: aload #6
/*     */     //   178: astore #9
/*     */     //   180: iconst_0
/*     */     //   181: istore #10
/*     */     //   183: aload #9
/*     */     //   185: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   190: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   195: astore #11
/*     */     //   197: aload #11
/*     */     //   199: invokeinterface hasNext : ()Z
/*     */     //   204: ifeq -> 516
/*     */     //   207: aload #11
/*     */     //   209: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   214: checkcast java/util/Map$Entry
/*     */     //   217: astore #12
/*     */     //   219: aload #12
/*     */     //   221: astore #13
/*     */     //   223: iconst_0
/*     */     //   224: istore #14
/*     */     //   226: aload #13
/*     */     //   228: astore #16
/*     */     //   230: iconst_0
/*     */     //   231: istore #17
/*     */     //   233: aload #16
/*     */     //   235: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   240: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   243: astore #19
/*     */     //   245: aload #13
/*     */     //   247: astore #16
/*     */     //   249: iconst_0
/*     */     //   250: istore #17
/*     */     //   252: aload #16
/*     */     //   254: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   259: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   262: astore #20
/*     */     //   264: aload #19
/*     */     //   266: invokestatic getCenterDistance : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)D
/*     */     //   269: aload_0
/*     */     //   270: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   273: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   276: checkcast java/lang/Number
/*     */     //   279: invokevirtual doubleValue : ()D
/*     */     //   282: dcmpg
/*     */     //   283: ifgt -> 487
/*     */     //   286: aload_0
/*     */     //   287: aload #20
/*     */     //   289: invokespecial validBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)Z
/*     */     //   292: ifeq -> 487
/*     */     //   295: aload_0
/*     */     //   296: getfield layerValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   299: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   302: checkcast java/lang/Boolean
/*     */     //   305: invokevirtual booleanValue : ()Z
/*     */     //   308: ifeq -> 331
/*     */     //   311: aload #19
/*     */     //   313: invokevirtual getY : ()I
/*     */     //   316: i2d
/*     */     //   317: aload_2
/*     */     //   318: invokeinterface getPosY : ()D
/*     */     //   323: dcmpg
/*     */     //   324: ifge -> 331
/*     */     //   327: iconst_0
/*     */     //   328: goto -> 488
/*     */     //   331: aload_0
/*     */     //   332: getfield throughWallsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   335: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   338: checkcast java/lang/Boolean
/*     */     //   341: invokevirtual booleanValue : ()Z
/*     */     //   344: ifne -> 483
/*     */     //   347: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   350: dup
/*     */     //   351: aload_2
/*     */     //   352: invokeinterface getPosX : ()D
/*     */     //   357: aload_2
/*     */     //   358: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   363: invokeinterface getMinY : ()D
/*     */     //   368: aload_2
/*     */     //   369: invokeinterface getEyeHeight : ()F
/*     */     //   374: f2d
/*     */     //   375: dadd
/*     */     //   376: aload_2
/*     */     //   377: invokeinterface getPosZ : ()D
/*     */     //   382: invokespecial <init> : (DDD)V
/*     */     //   385: astore #16
/*     */     //   387: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   390: dup
/*     */     //   391: aload #19
/*     */     //   393: invokevirtual getX : ()I
/*     */     //   396: i2d
/*     */     //   397: ldc2_w 0.5
/*     */     //   400: dadd
/*     */     //   401: aload #19
/*     */     //   403: invokevirtual getY : ()I
/*     */     //   406: i2d
/*     */     //   407: ldc2_w 0.5
/*     */     //   410: dadd
/*     */     //   411: aload #19
/*     */     //   413: invokevirtual getZ : ()I
/*     */     //   416: i2d
/*     */     //   417: ldc2_w 0.5
/*     */     //   420: dadd
/*     */     //   421: invokespecial <init> : (DDD)V
/*     */     //   424: astore #17
/*     */     //   426: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   429: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   434: dup
/*     */     //   435: ifnonnull -> 441
/*     */     //   438: invokestatic throwNpe : ()V
/*     */     //   441: aload #16
/*     */     //   443: aload #17
/*     */     //   445: iconst_0
/*     */     //   446: iconst_1
/*     */     //   447: iconst_0
/*     */     //   448: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   453: astore #21
/*     */     //   455: aload #21
/*     */     //   457: ifnull -> 479
/*     */     //   460: aload #21
/*     */     //   462: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   467: aload #19
/*     */     //   469: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   472: ifeq -> 479
/*     */     //   475: iconst_1
/*     */     //   476: goto -> 488
/*     */     //   479: iconst_0
/*     */     //   480: goto -> 488
/*     */     //   483: iconst_1
/*     */     //   484: goto -> 488
/*     */     //   487: iconst_0
/*     */     //   488: ifeq -> 513
/*     */     //   491: aload #7
/*     */     //   493: aload #12
/*     */     //   495: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   500: aload #12
/*     */     //   502: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   507: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   512: pop
/*     */     //   513: goto -> 197
/*     */     //   516: aload #7
/*     */     //   518: nop
/*     */     //   519: invokestatic toMutableMap : (Ljava/util/Map;)Ljava/util/Map;
/*     */     //   522: astore_3
/*     */     //   523: aload_0
/*     */     //   524: getfield priorityValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   527: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   530: checkcast java/lang/String
/*     */     //   533: astore #7
/*     */     //   535: aload #7
/*     */     //   537: invokevirtual hashCode : ()I
/*     */     //   540: lookupswitch default -> 1431, 181289442 -> 568, 353103893 -> 582
/*     */     //   568: aload #7
/*     */     //   570: ldc_w 'Hardness'
/*     */     //   573: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   576: ifeq -> 1431
/*     */     //   579: goto -> 988
/*     */     //   582: aload #7
/*     */     //   584: ldc_w 'Distance'
/*     */     //   587: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   590: ifeq -> 1431
/*     */     //   593: aload_3
/*     */     //   594: astore #8
/*     */     //   596: iconst_0
/*     */     //   597: istore #9
/*     */     //   599: aload #8
/*     */     //   601: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   606: checkcast java/lang/Iterable
/*     */     //   609: astore #10
/*     */     //   611: iconst_0
/*     */     //   612: istore #11
/*     */     //   614: aload #10
/*     */     //   616: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   621: astore #12
/*     */     //   623: aload #12
/*     */     //   625: invokeinterface hasNext : ()Z
/*     */     //   630: ifne -> 637
/*     */     //   633: aconst_null
/*     */     //   634: goto -> 982
/*     */     //   637: aload #12
/*     */     //   639: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   644: astore #13
/*     */     //   646: aload #12
/*     */     //   648: invokeinterface hasNext : ()Z
/*     */     //   653: ifne -> 661
/*     */     //   656: aload #13
/*     */     //   658: goto -> 982
/*     */     //   661: aload #13
/*     */     //   663: checkcast java/util/Map$Entry
/*     */     //   666: astore #14
/*     */     //   668: iconst_0
/*     */     //   669: istore #16
/*     */     //   671: aload #14
/*     */     //   673: astore #17
/*     */     //   675: iconst_0
/*     */     //   676: istore #19
/*     */     //   678: aload #17
/*     */     //   680: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   685: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   688: astore #20
/*     */     //   690: aload #14
/*     */     //   692: astore #17
/*     */     //   694: iconst_0
/*     */     //   695: istore #19
/*     */     //   697: aload #17
/*     */     //   699: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   704: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   707: astore #21
/*     */     //   709: aload #20
/*     */     //   711: invokestatic getCenterDistance : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)D
/*     */     //   714: dstore #22
/*     */     //   716: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   719: dup
/*     */     //   720: aload_2
/*     */     //   721: invokeinterface getPosX : ()D
/*     */     //   726: aload_2
/*     */     //   727: invokeinterface getPosY : ()D
/*     */     //   732: iconst_1
/*     */     //   733: i2d
/*     */     //   734: dsub
/*     */     //   735: aload_2
/*     */     //   736: invokeinterface getPosZ : ()D
/*     */     //   741: invokespecial <init> : (DDD)V
/*     */     //   744: astore #24
/*     */     //   746: aload #20
/*     */     //   748: invokevirtual getX : ()I
/*     */     //   751: aload #24
/*     */     //   753: invokevirtual getX : ()I
/*     */     //   756: if_icmpne -> 797
/*     */     //   759: aload #24
/*     */     //   761: invokevirtual getY : ()I
/*     */     //   764: aload #20
/*     */     //   766: invokevirtual getY : ()I
/*     */     //   769: if_icmpgt -> 797
/*     */     //   772: aload #20
/*     */     //   774: invokevirtual getZ : ()I
/*     */     //   777: aload #24
/*     */     //   779: invokevirtual getZ : ()I
/*     */     //   782: if_icmpne -> 797
/*     */     //   785: getstatic kotlin/jvm/internal/DoubleCompanionObject.INSTANCE : Lkotlin/jvm/internal/DoubleCompanionObject;
/*     */     //   788: invokevirtual getMAX_VALUE : ()D
/*     */     //   791: dload #22
/*     */     //   793: dsub
/*     */     //   794: goto -> 799
/*     */     //   797: dload #22
/*     */     //   799: nop
/*     */     //   800: dstore #14
/*     */     //   802: aload #12
/*     */     //   804: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   809: astore #16
/*     */     //   811: aload #16
/*     */     //   813: checkcast java/util/Map$Entry
/*     */     //   816: astore #17
/*     */     //   818: iconst_0
/*     */     //   819: istore #19
/*     */     //   821: aload #17
/*     */     //   823: astore #20
/*     */     //   825: iconst_0
/*     */     //   826: istore #21
/*     */     //   828: aload #20
/*     */     //   830: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   835: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   838: astore #25
/*     */     //   840: aload #17
/*     */     //   842: astore #20
/*     */     //   844: iconst_0
/*     */     //   845: istore #21
/*     */     //   847: aload #20
/*     */     //   849: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   854: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   857: astore #26
/*     */     //   859: aload #25
/*     */     //   861: invokestatic getCenterDistance : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)D
/*     */     //   864: dstore #27
/*     */     //   866: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   869: dup
/*     */     //   870: aload_2
/*     */     //   871: invokeinterface getPosX : ()D
/*     */     //   876: aload_2
/*     */     //   877: invokeinterface getPosY : ()D
/*     */     //   882: iconst_1
/*     */     //   883: i2d
/*     */     //   884: dsub
/*     */     //   885: aload_2
/*     */     //   886: invokeinterface getPosZ : ()D
/*     */     //   891: invokespecial <init> : (DDD)V
/*     */     //   894: astore #29
/*     */     //   896: aload #25
/*     */     //   898: invokevirtual getX : ()I
/*     */     //   901: aload #29
/*     */     //   903: invokevirtual getX : ()I
/*     */     //   906: if_icmpne -> 947
/*     */     //   909: aload #29
/*     */     //   911: invokevirtual getY : ()I
/*     */     //   914: aload #25
/*     */     //   916: invokevirtual getY : ()I
/*     */     //   919: if_icmpgt -> 947
/*     */     //   922: aload #25
/*     */     //   924: invokevirtual getZ : ()I
/*     */     //   927: aload #29
/*     */     //   929: invokevirtual getZ : ()I
/*     */     //   932: if_icmpne -> 947
/*     */     //   935: getstatic kotlin/jvm/internal/DoubleCompanionObject.INSTANCE : Lkotlin/jvm/internal/DoubleCompanionObject;
/*     */     //   938: invokevirtual getMAX_VALUE : ()D
/*     */     //   941: dload #27
/*     */     //   943: dsub
/*     */     //   944: goto -> 949
/*     */     //   947: dload #27
/*     */     //   949: nop
/*     */     //   950: dstore #17
/*     */     //   952: dload #14
/*     */     //   954: dload #17
/*     */     //   956: invokestatic compare : (DD)I
/*     */     //   959: ifle -> 970
/*     */     //   962: aload #16
/*     */     //   964: astore #13
/*     */     //   966: dload #17
/*     */     //   968: dstore #14
/*     */     //   970: aload #12
/*     */     //   972: invokeinterface hasNext : ()Z
/*     */     //   977: ifne -> 802
/*     */     //   980: aload #13
/*     */     //   982: checkcast java/util/Map$Entry
/*     */     //   985: goto -> 1432
/*     */     //   988: aload_3
/*     */     //   989: astore #8
/*     */     //   991: iconst_0
/*     */     //   992: istore #9
/*     */     //   994: aload #8
/*     */     //   996: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   1001: checkcast java/lang/Iterable
/*     */     //   1004: astore #10
/*     */     //   1006: iconst_0
/*     */     //   1007: istore #11
/*     */     //   1009: aload #10
/*     */     //   1011: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1016: astore #12
/*     */     //   1018: aload #12
/*     */     //   1020: invokeinterface hasNext : ()Z
/*     */     //   1025: ifne -> 1032
/*     */     //   1028: aconst_null
/*     */     //   1029: goto -> 1425
/*     */     //   1032: aload #12
/*     */     //   1034: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1039: astore #13
/*     */     //   1041: aload #12
/*     */     //   1043: invokeinterface hasNext : ()Z
/*     */     //   1048: ifne -> 1056
/*     */     //   1051: aload #13
/*     */     //   1053: goto -> 1425
/*     */     //   1056: aload #13
/*     */     //   1058: checkcast java/util/Map$Entry
/*     */     //   1061: astore #14
/*     */     //   1063: iconst_0
/*     */     //   1064: istore #16
/*     */     //   1066: aload #14
/*     */     //   1068: astore #17
/*     */     //   1070: iconst_0
/*     */     //   1071: istore #19
/*     */     //   1073: aload #17
/*     */     //   1075: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   1080: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1083: astore #20
/*     */     //   1085: aload #14
/*     */     //   1087: astore #17
/*     */     //   1089: iconst_0
/*     */     //   1090: istore #19
/*     */     //   1092: aload #17
/*     */     //   1094: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1099: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   1102: astore #21
/*     */     //   1104: aload #21
/*     */     //   1106: aload_2
/*     */     //   1107: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1110: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1115: dup
/*     */     //   1116: ifnonnull -> 1122
/*     */     //   1119: invokestatic throwNpe : ()V
/*     */     //   1122: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   1125: aload #20
/*     */     //   1127: invokeinterface getPlayerRelativeBlockHardness : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)F
/*     */     //   1132: f2d
/*     */     //   1133: dstore #22
/*     */     //   1135: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1138: dup
/*     */     //   1139: aload_2
/*     */     //   1140: invokeinterface getPosX : ()D
/*     */     //   1145: aload_2
/*     */     //   1146: invokeinterface getPosY : ()D
/*     */     //   1151: iconst_1
/*     */     //   1152: i2d
/*     */     //   1153: dsub
/*     */     //   1154: aload_2
/*     */     //   1155: invokeinterface getPosZ : ()D
/*     */     //   1160: invokespecial <init> : (DDD)V
/*     */     //   1163: astore #24
/*     */     //   1165: aload #20
/*     */     //   1167: invokevirtual getX : ()I
/*     */     //   1170: aload #24
/*     */     //   1172: invokevirtual getX : ()I
/*     */     //   1175: if_icmpne -> 1216
/*     */     //   1178: aload #24
/*     */     //   1180: invokevirtual getY : ()I
/*     */     //   1183: aload #20
/*     */     //   1185: invokevirtual getY : ()I
/*     */     //   1188: if_icmpgt -> 1216
/*     */     //   1191: aload #20
/*     */     //   1193: invokevirtual getZ : ()I
/*     */     //   1196: aload #24
/*     */     //   1198: invokevirtual getZ : ()I
/*     */     //   1201: if_icmpne -> 1216
/*     */     //   1204: getstatic kotlin/jvm/internal/DoubleCompanionObject.INSTANCE : Lkotlin/jvm/internal/DoubleCompanionObject;
/*     */     //   1207: invokevirtual getMIN_VALUE : ()D
/*     */     //   1210: dload #22
/*     */     //   1212: dadd
/*     */     //   1213: goto -> 1218
/*     */     //   1216: dload #22
/*     */     //   1218: nop
/*     */     //   1219: dstore #14
/*     */     //   1221: aload #12
/*     */     //   1223: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1228: astore #16
/*     */     //   1230: aload #16
/*     */     //   1232: checkcast java/util/Map$Entry
/*     */     //   1235: astore #17
/*     */     //   1237: iconst_0
/*     */     //   1238: istore #19
/*     */     //   1240: aload #17
/*     */     //   1242: astore #20
/*     */     //   1244: iconst_0
/*     */     //   1245: istore #21
/*     */     //   1247: aload #20
/*     */     //   1249: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   1254: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1257: astore #25
/*     */     //   1259: aload #17
/*     */     //   1261: astore #20
/*     */     //   1263: iconst_0
/*     */     //   1264: istore #21
/*     */     //   1266: aload #20
/*     */     //   1268: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1273: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   1276: astore #26
/*     */     //   1278: aload #26
/*     */     //   1280: aload_2
/*     */     //   1281: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1284: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1289: dup
/*     */     //   1290: ifnonnull -> 1296
/*     */     //   1293: invokestatic throwNpe : ()V
/*     */     //   1296: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   1299: aload #25
/*     */     //   1301: invokeinterface getPlayerRelativeBlockHardness : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)F
/*     */     //   1306: f2d
/*     */     //   1307: dstore #27
/*     */     //   1309: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1312: dup
/*     */     //   1313: aload_2
/*     */     //   1314: invokeinterface getPosX : ()D
/*     */     //   1319: aload_2
/*     */     //   1320: invokeinterface getPosY : ()D
/*     */     //   1325: iconst_1
/*     */     //   1326: i2d
/*     */     //   1327: dsub
/*     */     //   1328: aload_2
/*     */     //   1329: invokeinterface getPosZ : ()D
/*     */     //   1334: invokespecial <init> : (DDD)V
/*     */     //   1337: astore #29
/*     */     //   1339: aload #25
/*     */     //   1341: invokevirtual getX : ()I
/*     */     //   1344: aload #29
/*     */     //   1346: invokevirtual getX : ()I
/*     */     //   1349: if_icmpne -> 1390
/*     */     //   1352: aload #29
/*     */     //   1354: invokevirtual getY : ()I
/*     */     //   1357: aload #25
/*     */     //   1359: invokevirtual getY : ()I
/*     */     //   1362: if_icmpgt -> 1390
/*     */     //   1365: aload #25
/*     */     //   1367: invokevirtual getZ : ()I
/*     */     //   1370: aload #29
/*     */     //   1372: invokevirtual getZ : ()I
/*     */     //   1375: if_icmpne -> 1390
/*     */     //   1378: getstatic kotlin/jvm/internal/DoubleCompanionObject.INSTANCE : Lkotlin/jvm/internal/DoubleCompanionObject;
/*     */     //   1381: invokevirtual getMIN_VALUE : ()D
/*     */     //   1384: dload #27
/*     */     //   1386: dadd
/*     */     //   1387: goto -> 1392
/*     */     //   1390: dload #27
/*     */     //   1392: nop
/*     */     //   1393: dstore #17
/*     */     //   1395: dload #14
/*     */     //   1397: dload #17
/*     */     //   1399: invokestatic compare : (DD)I
/*     */     //   1402: ifge -> 1413
/*     */     //   1405: aload #16
/*     */     //   1407: astore #13
/*     */     //   1409: dload #17
/*     */     //   1411: dstore #14
/*     */     //   1413: aload #12
/*     */     //   1415: invokeinterface hasNext : ()Z
/*     */     //   1420: ifne -> 1221
/*     */     //   1423: aload #13
/*     */     //   1425: checkcast java/util/Map$Entry
/*     */     //   1428: goto -> 1432
/*     */     //   1431: return
/*     */     //   1432: dup
/*     */     //   1433: ifnull -> 1439
/*     */     //   1436: goto -> 1441
/*     */     //   1439: pop
/*     */     //   1440: return
/*     */     //   1441: astore #6
/*     */     //   1443: aload #6
/*     */     //   1445: astore #7
/*     */     //   1447: iconst_0
/*     */     //   1448: istore #8
/*     */     //   1450: aload #7
/*     */     //   1452: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   1457: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1460: astore #4
/*     */     //   1462: aload #6
/*     */     //   1464: astore #7
/*     */     //   1466: iconst_0
/*     */     //   1467: istore #8
/*     */     //   1469: aload #7
/*     */     //   1471: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1476: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   1479: astore #5
/*     */     //   1481: aload #4
/*     */     //   1483: aload_0
/*     */     //   1484: getfield currentBlock : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1487: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1490: iconst_1
/*     */     //   1491: ixor
/*     */     //   1492: ifeq -> 1499
/*     */     //   1495: fconst_0
/*     */     //   1496: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1499: aload_0
/*     */     //   1500: getfield rotationsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1503: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1506: checkcast java/lang/Boolean
/*     */     //   1509: invokevirtual booleanValue : ()Z
/*     */     //   1512: ifeq -> 1539
/*     */     //   1515: aload #4
/*     */     //   1517: invokestatic faceBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   1520: dup
/*     */     //   1521: ifnull -> 1527
/*     */     //   1524: goto -> 1529
/*     */     //   1527: pop
/*     */     //   1528: return
/*     */     //   1529: astore #6
/*     */     //   1531: aload #6
/*     */     //   1533: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   1536: invokestatic setTargetRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)V
/*     */     //   1539: aload_0
/*     */     //   1540: aload #4
/*     */     //   1542: putfield currentBlock : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1545: aload_0
/*     */     //   1546: getfield attackedBlocks : Ljava/util/ArrayList;
/*     */     //   1549: aload #4
/*     */     //   1551: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   1554: pop
/*     */     //   1555: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1558: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   1561: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/AutoTool
/*     */     //   1564: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   1567: dup
/*     */     //   1568: ifnonnull -> 1582
/*     */     //   1571: new kotlin/TypeCastException
/*     */     //   1574: dup
/*     */     //   1575: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoTool'
/*     */     //   1578: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1581: athrow
/*     */     //   1582: checkcast net/ccbluex/liquidbounce/features/module/modules/player/AutoTool
/*     */     //   1585: astore #6
/*     */     //   1587: aload #6
/*     */     //   1589: invokevirtual getState : ()Z
/*     */     //   1592: ifeq -> 1602
/*     */     //   1595: aload #6
/*     */     //   1597: aload #4
/*     */     //   1599: invokevirtual switchSlot : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)V
/*     */     //   1602: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1605: fconst_0
/*     */     //   1606: fcmpg
/*     */     //   1607: ifne -> 1766
/*     */     //   1610: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1613: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1618: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1621: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.START_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   1624: aload #4
/*     */     //   1626: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1629: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1632: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1637: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   1642: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1647: aload #5
/*     */     //   1649: aload_2
/*     */     //   1650: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1653: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1658: dup
/*     */     //   1659: ifnonnull -> 1665
/*     */     //   1662: invokestatic throwNpe : ()V
/*     */     //   1665: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   1668: aload #4
/*     */     //   1670: invokeinterface getPlayerRelativeBlockHardness : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)F
/*     */     //   1675: fconst_1
/*     */     //   1676: fcmpl
/*     */     //   1677: iflt -> 1766
/*     */     //   1680: fconst_0
/*     */     //   1681: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1684: aload_2
/*     */     //   1685: invokeinterface swingItem : ()V
/*     */     //   1690: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1693: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   1698: aload #4
/*     */     //   1700: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1703: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1706: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1711: invokeinterface onPlayerDestroyBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Z
/*     */     //   1716: pop
/*     */     //   1717: aload_0
/*     */     //   1718: aload_0
/*     */     //   1719: getfield hitDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1722: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1725: checkcast java/lang/Number
/*     */     //   1728: invokevirtual intValue : ()I
/*     */     //   1731: putfield blockHitDelay : I
/*     */     //   1734: aload_3
/*     */     //   1735: astore #7
/*     */     //   1737: iconst_0
/*     */     //   1738: istore #8
/*     */     //   1740: aload #7
/*     */     //   1742: aload #4
/*     */     //   1744: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   1749: pop
/*     */     //   1750: aload_0
/*     */     //   1751: dup
/*     */     //   1752: getfield nuke : I
/*     */     //   1755: dup
/*     */     //   1756: istore #7
/*     */     //   1758: iconst_1
/*     */     //   1759: iadd
/*     */     //   1760: putfield nuke : I
/*     */     //   1763: goto -> 1939
/*     */     //   1766: aload_2
/*     */     //   1767: invokeinterface swingItem : ()V
/*     */     //   1772: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1775: aload #5
/*     */     //   1777: aload_2
/*     */     //   1778: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1781: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1786: dup
/*     */     //   1787: ifnonnull -> 1793
/*     */     //   1790: invokestatic throwNpe : ()V
/*     */     //   1793: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   1796: aload #4
/*     */     //   1798: invokeinterface getPlayerRelativeBlockHardness : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)F
/*     */     //   1803: fadd
/*     */     //   1804: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1807: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1810: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1815: dup
/*     */     //   1816: ifnonnull -> 1822
/*     */     //   1819: invokestatic throwNpe : ()V
/*     */     //   1822: aload_2
/*     */     //   1823: invokeinterface getEntityId : ()I
/*     */     //   1828: aload #4
/*     */     //   1830: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1833: ldc_w 10.0
/*     */     //   1836: fmul
/*     */     //   1837: f2i
/*     */     //   1838: iconst_1
/*     */     //   1839: isub
/*     */     //   1840: invokeinterface sendBlockBreakProgress : (ILnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;I)V
/*     */     //   1845: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1848: fconst_1
/*     */     //   1849: fcmpl
/*     */     //   1850: iflt -> 1938
/*     */     //   1853: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1856: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1861: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1864: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.STOP_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   1867: aload #4
/*     */     //   1869: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1872: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1875: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1880: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   1885: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1890: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1893: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   1898: aload #4
/*     */     //   1900: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1903: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1906: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1911: invokeinterface onPlayerDestroyBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Z
/*     */     //   1916: pop
/*     */     //   1917: aload_0
/*     */     //   1918: aload_0
/*     */     //   1919: getfield hitDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1922: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1925: checkcast java/lang/Number
/*     */     //   1928: invokevirtual intValue : ()I
/*     */     //   1931: putfield blockHitDelay : I
/*     */     //   1934: fconst_0
/*     */     //   1935: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Nuker.currentDamage : F
/*     */     //   1938: return
/*     */     //   1939: aload_0
/*     */     //   1940: getfield nuke : I
/*     */     //   1943: aload_0
/*     */     //   1944: getfield nukeValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1947: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1950: checkcast java/lang/Number
/*     */     //   1953: invokevirtual intValue : ()I
/*     */     //   1956: if_icmplt -> 523
/*     */     //   1959: goto -> 2547
/*     */     //   1962: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1965: aload_2
/*     */     //   1966: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1971: dup
/*     */     //   1972: ifnull -> 1983
/*     */     //   1975: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1980: goto -> 1985
/*     */     //   1983: pop
/*     */     //   1984: aconst_null
/*     */     //   1985: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   1990: ifeq -> 1994
/*     */     //   1993: return
/*     */     //   1994: aload_0
/*     */     //   1995: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1998: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2001: checkcast java/lang/Number
/*     */     //   2004: invokevirtual floatValue : ()F
/*     */     //   2007: invokestatic roundToInt : (F)I
/*     */     //   2010: iconst_1
/*     */     //   2011: iadd
/*     */     //   2012: invokestatic searchBlocks : (I)Ljava/util/Map;
/*     */     //   2015: astore_3
/*     */     //   2016: iconst_0
/*     */     //   2017: istore #4
/*     */     //   2019: aload_3
/*     */     //   2020: astore #5
/*     */     //   2022: new java/util/LinkedHashMap
/*     */     //   2025: dup
/*     */     //   2026: invokespecial <init> : ()V
/*     */     //   2029: checkcast java/util/Map
/*     */     //   2032: astore #6
/*     */     //   2034: iconst_0
/*     */     //   2035: istore #7
/*     */     //   2037: aload #5
/*     */     //   2039: astore #8
/*     */     //   2041: iconst_0
/*     */     //   2042: istore #9
/*     */     //   2044: aload #8
/*     */     //   2046: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   2051: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   2056: astore #10
/*     */     //   2058: aload #10
/*     */     //   2060: invokeinterface hasNext : ()Z
/*     */     //   2065: ifeq -> 2377
/*     */     //   2068: aload #10
/*     */     //   2070: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   2075: checkcast java/util/Map$Entry
/*     */     //   2078: astore #11
/*     */     //   2080: aload #11
/*     */     //   2082: astore #12
/*     */     //   2084: iconst_0
/*     */     //   2085: istore #13
/*     */     //   2087: aload #12
/*     */     //   2089: astore #14
/*     */     //   2091: iconst_0
/*     */     //   2092: istore #16
/*     */     //   2094: aload #14
/*     */     //   2096: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   2101: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   2104: astore #17
/*     */     //   2106: aload #12
/*     */     //   2108: astore #14
/*     */     //   2110: iconst_0
/*     */     //   2111: istore #16
/*     */     //   2113: aload #14
/*     */     //   2115: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   2120: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */     //   2123: astore #19
/*     */     //   2125: aload #17
/*     */     //   2127: invokestatic getCenterDistance : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)D
/*     */     //   2130: aload_0
/*     */     //   2131: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2134: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2137: checkcast java/lang/Number
/*     */     //   2140: invokevirtual doubleValue : ()D
/*     */     //   2143: dcmpg
/*     */     //   2144: ifgt -> 2348
/*     */     //   2147: aload_0
/*     */     //   2148: aload #19
/*     */     //   2150: invokespecial validBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)Z
/*     */     //   2153: ifeq -> 2348
/*     */     //   2156: aload_0
/*     */     //   2157: getfield layerValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2160: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2163: checkcast java/lang/Boolean
/*     */     //   2166: invokevirtual booleanValue : ()Z
/*     */     //   2169: ifeq -> 2192
/*     */     //   2172: aload #17
/*     */     //   2174: invokevirtual getY : ()I
/*     */     //   2177: i2d
/*     */     //   2178: aload_2
/*     */     //   2179: invokeinterface getPosY : ()D
/*     */     //   2184: dcmpg
/*     */     //   2185: ifge -> 2192
/*     */     //   2188: iconst_0
/*     */     //   2189: goto -> 2349
/*     */     //   2192: aload_0
/*     */     //   2193: getfield throughWallsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2196: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2199: checkcast java/lang/Boolean
/*     */     //   2202: invokevirtual booleanValue : ()Z
/*     */     //   2205: ifne -> 2344
/*     */     //   2208: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   2211: dup
/*     */     //   2212: aload_2
/*     */     //   2213: invokeinterface getPosX : ()D
/*     */     //   2218: aload_2
/*     */     //   2219: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   2224: invokeinterface getMinY : ()D
/*     */     //   2229: aload_2
/*     */     //   2230: invokeinterface getEyeHeight : ()F
/*     */     //   2235: f2d
/*     */     //   2236: dadd
/*     */     //   2237: aload_2
/*     */     //   2238: invokeinterface getPosZ : ()D
/*     */     //   2243: invokespecial <init> : (DDD)V
/*     */     //   2246: astore #14
/*     */     //   2248: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   2251: dup
/*     */     //   2252: aload #17
/*     */     //   2254: invokevirtual getX : ()I
/*     */     //   2257: i2d
/*     */     //   2258: ldc2_w 0.5
/*     */     //   2261: dadd
/*     */     //   2262: aload #17
/*     */     //   2264: invokevirtual getY : ()I
/*     */     //   2267: i2d
/*     */     //   2268: ldc2_w 0.5
/*     */     //   2271: dadd
/*     */     //   2272: aload #17
/*     */     //   2274: invokevirtual getZ : ()I
/*     */     //   2277: i2d
/*     */     //   2278: ldc2_w 0.5
/*     */     //   2281: dadd
/*     */     //   2282: invokespecial <init> : (DDD)V
/*     */     //   2285: astore #16
/*     */     //   2287: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2290: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   2295: dup
/*     */     //   2296: ifnonnull -> 2302
/*     */     //   2299: invokestatic throwNpe : ()V
/*     */     //   2302: aload #14
/*     */     //   2304: aload #16
/*     */     //   2306: iconst_0
/*     */     //   2307: iconst_1
/*     */     //   2308: iconst_0
/*     */     //   2309: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   2314: astore #20
/*     */     //   2316: aload #20
/*     */     //   2318: ifnull -> 2340
/*     */     //   2321: aload #20
/*     */     //   2323: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   2328: aload #17
/*     */     //   2330: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2333: ifeq -> 2340
/*     */     //   2336: iconst_1
/*     */     //   2337: goto -> 2349
/*     */     //   2340: iconst_0
/*     */     //   2341: goto -> 2349
/*     */     //   2344: iconst_1
/*     */     //   2345: goto -> 2349
/*     */     //   2348: iconst_0
/*     */     //   2349: ifeq -> 2374
/*     */     //   2352: aload #6
/*     */     //   2354: aload #11
/*     */     //   2356: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   2361: aload #11
/*     */     //   2363: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   2368: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   2373: pop
/*     */     //   2374: goto -> 2058
/*     */     //   2377: aload #6
/*     */     //   2379: nop
/*     */     //   2380: astore_3
/*     */     //   2381: iconst_0
/*     */     //   2382: istore #4
/*     */     //   2384: aload_3
/*     */     //   2385: astore #5
/*     */     //   2387: iconst_0
/*     */     //   2388: istore #6
/*     */     //   2390: aload #5
/*     */     //   2392: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   2397: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   2402: astore #7
/*     */     //   2404: aload #7
/*     */     //   2406: invokeinterface hasNext : ()Z
/*     */     //   2411: ifeq -> 2546
/*     */     //   2414: aload #7
/*     */     //   2416: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   2421: checkcast java/util/Map$Entry
/*     */     //   2424: astore #8
/*     */     //   2426: aload #8
/*     */     //   2428: astore #9
/*     */     //   2430: iconst_0
/*     */     //   2431: istore #10
/*     */     //   2433: aload #9
/*     */     //   2435: astore #11
/*     */     //   2437: iconst_0
/*     */     //   2438: istore #12
/*     */     //   2440: aload #11
/*     */     //   2442: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   2447: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   2450: astore #13
/*     */     //   2452: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2455: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2460: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2463: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.START_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   2466: aload #13
/*     */     //   2468: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2471: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   2474: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   2479: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   2484: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2489: aload_2
/*     */     //   2490: invokeinterface swingItem : ()V
/*     */     //   2495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2498: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2503: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2506: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.STOP_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   2509: aload #13
/*     */     //   2511: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2514: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   2517: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   2522: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   2527: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2532: aload_0
/*     */     //   2533: getfield attackedBlocks : Ljava/util/ArrayList;
/*     */     //   2536: aload #13
/*     */     //   2538: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   2541: pop
/*     */     //   2542: nop
/*     */     //   2543: goto -> 2404
/*     */     //   2546: nop
/*     */     //   2547: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #59	-> 6
/*     */     //   #60	-> 37
/*     */     //   #61	-> 49
/*     */     //   #65	-> 50
/*     */     //   #66	-> 57
/*     */     //   #67	-> 80
/*     */     //   #68	-> 85
/*     */     //   #72	-> 92
/*     */     //   #74	-> 99
/*     */     //   #76	-> 115
/*     */     //   #79	-> 131
/*     */     //   #98	-> 131
/*     */     //   #79	-> 131
/*     */     //   #80	-> 131
/*     */     //   #79	-> 131
/*     */     //   #80	-> 154
/*     */     //   #237	-> 157
/*     */     //   #238	-> 176
/*     */     //   #239	-> 219
/*     */     //   #81	-> 264
/*     */     //   #82	-> 295
/*     */     //   #83	-> 327
/*     */     //   #86	-> 331
/*     */     //   #88	-> 347
/*     */     //   #89	-> 368
/*     */     //   #88	-> 375
/*     */     //   #89	-> 376
/*     */     //   #88	-> 382
/*     */     //   #90	-> 387
/*     */     //   #91	-> 426
/*     */     //   #92	-> 445
/*     */     //   #91	-> 448
/*     */     //   #95	-> 455
/*     */     //   #96	-> 483
/*     */     //   #86	-> 484
/*     */     //   #97	-> 487
/*     */     //   #81	-> 488
/*     */     //   #97	-> 488
/*     */     //   #240	-> 491
/*     */     //   #238	-> 513
/*     */     //   #243	-> 516
/*     */     //   #98	-> 519
/*     */     //   #79	-> 522
/*     */     //   #100	-> 523
/*     */     //   #101	-> 523
/*     */     //   #111	-> 568
/*     */     //   #102	-> 582
/*     */     //   #244	-> 599
/*     */     //   #245	-> 614
/*     */     //   #246	-> 623
/*     */     //   #247	-> 637
/*     */     //   #248	-> 646
/*     */     //   #249	-> 661
/*     */     //   #103	-> 709
/*     */     //   #104	-> 716
/*     */     //   #106	-> 746
/*     */     //   #107	-> 785
/*     */     //   #109	-> 797
/*     */     //   #106	-> 799
/*     */     //   #109	-> 799
/*     */     //   #250	-> 802
/*     */     //   #251	-> 802
/*     */     //   #252	-> 811
/*     */     //   #103	-> 859
/*     */     //   #104	-> 866
/*     */     //   #106	-> 896
/*     */     //   #107	-> 935
/*     */     //   #109	-> 947
/*     */     //   #106	-> 949
/*     */     //   #109	-> 949
/*     */     //   #253	-> 952
/*     */     //   #254	-> 962
/*     */     //   #255	-> 966
/*     */     //   #257	-> 970
/*     */     //   #258	-> 980
/*     */     //   #111	-> 988
/*     */     //   #112	-> 1104
/*     */     //   #114	-> 1135
/*     */     //   #115	-> 1165
/*     */     //   #116	-> 1204
/*     */     //   #118	-> 1216
/*     */     //   #115	-> 1218
/*     */     //   #118	-> 1218
/*     */     //   #111	-> 1219
/*     */     //   #112	-> 1278
/*     */     //   #114	-> 1309
/*     */     //   #115	-> 1339
/*     */     //   #116	-> 1378
/*     */     //   #118	-> 1390
/*     */     //   #115	-> 1392
/*     */     //   #118	-> 1392
/*     */     //   #111	-> 1393
/*     */     //   #120	-> 1431
/*     */     //   #101	-> 1432
/*     */     //   #121	-> 1440
/*     */     //   #101	-> 1457
/*     */     //   #101	-> 1476
/*     */     //   #124	-> 1481
/*     */     //   #125	-> 1495
/*     */     //   #128	-> 1499
/*     */     //   #129	-> 1515
/*     */     //   #129	-> 1527
/*     */     //   #130	-> 1531
/*     */     //   #134	-> 1539
/*     */     //   #135	-> 1545
/*     */     //   #138	-> 1555
/*     */     //   #139	-> 1587
/*     */     //   #140	-> 1595
/*     */     //   #143	-> 1602
/*     */     //   #144	-> 1610
/*     */     //   #145	-> 1624
/*     */     //   #144	-> 1637
/*     */     //   #148	-> 1647
/*     */     //   #149	-> 1680
/*     */     //   #150	-> 1684
/*     */     //   #151	-> 1690
/*     */     //   #152	-> 1717
/*     */     //   #153	-> 1734
/*     */     //   #154	-> 1750
/*     */     //   #155	-> 1763
/*     */     //   #160	-> 1766
/*     */     //   #161	-> 1772
/*     */     //   #162	-> 1807
/*     */     //   #165	-> 1845
/*     */     //   #166	-> 1853
/*     */     //   #167	-> 1890
/*     */     //   #168	-> 1917
/*     */     //   #169	-> 1934
/*     */     //   #171	-> 1938
/*     */     //   #172	-> 1939
/*     */     //   #177	-> 1962
/*     */     //   #178	-> 1993
/*     */     //   #181	-> 1994
/*     */     //   #201	-> 1994
/*     */     //   #181	-> 1994
/*     */     //   #182	-> 1994
/*     */     //   #181	-> 1994
/*     */     //   #182	-> 2016
/*     */     //   #259	-> 2019
/*     */     //   #260	-> 2037
/*     */     //   #261	-> 2080
/*     */     //   #183	-> 2125
/*     */     //   #184	-> 2156
/*     */     //   #185	-> 2188
/*     */     //   #188	-> 2192
/*     */     //   #190	-> 2208
/*     */     //   #191	-> 2229
/*     */     //   #190	-> 2236
/*     */     //   #191	-> 2237
/*     */     //   #190	-> 2243
/*     */     //   #192	-> 2248
/*     */     //   #193	-> 2287
/*     */     //   #194	-> 2306
/*     */     //   #193	-> 2309
/*     */     //   #197	-> 2316
/*     */     //   #198	-> 2344
/*     */     //   #188	-> 2345
/*     */     //   #199	-> 2348
/*     */     //   #183	-> 2349
/*     */     //   #199	-> 2349
/*     */     //   #262	-> 2352
/*     */     //   #260	-> 2374
/*     */     //   #265	-> 2377
/*     */     //   #201	-> 2381
/*     */     //   #266	-> 2384
/*     */     //   #266	-> 2426
/*     */     //   #203	-> 2452
/*     */     //   #204	-> 2466
/*     */     //   #203	-> 2479
/*     */     //   #205	-> 2489
/*     */     //   #206	-> 2495
/*     */     //   #207	-> 2509
/*     */     //   #206	-> 2522
/*     */     //   #208	-> 2532
/*     */     //   #209	-> 2542
/*     */     //   #267	-> 2546
/*     */     //   #210	-> 2547
/*     */     //   #211	-> 2547
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   455	25	21	rayTrace	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   426	54	17	blockVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   387	93	16	eyesPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   223	265	13	$dstr$pos$block	Ljava/util/Map$Entry;
/*     */     //   223	265	19	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   223	265	20	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   226	262	14	$i$a$-filter-Nuker$onUpdate$validBlocks$1	I
/*     */     //   219	294	12	element$iv$iv	Ljava/util/Map$Entry;
/*     */     //   173	345	6	$this$filterTo$iv$iv	Ljava/util/Map;
/*     */     //   173	345	7	destination$iv$iv	Ljava/util/Map;
/*     */     //   176	342	8	$i$f$filterTo	I
/*     */     //   154	365	4	$this$filter$iv	Ljava/util/Map;
/*     */     //   157	362	5	$i$f$filter	I
/*     */     //   746	53	24	safePos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   716	83	22	distance	D
/*     */     //   668	132	14	$dstr$pos$block	Ljava/util/Map$Entry;
/*     */     //   668	132	20	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   668	132	21	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   671	129	16	$i$a$-minBy-Nuker$onUpdate$1	I
/*     */     //   896	53	29	safePos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   866	83	27	distance	D
/*     */     //   818	132	17	$dstr$pos$block	Ljava/util/Map$Entry;
/*     */     //   818	132	25	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   818	132	26	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   821	129	19	$i$a$-minBy-Nuker$onUpdate$1	I
/*     */     //   952	28	17	v$iv$iv	D
/*     */     //   811	169	16	e$iv$iv	Ljava/lang/Object;
/*     */     //   802	180	14	minValue$iv$iv	D
/*     */     //   646	336	13	minElem$iv$iv	Ljava/lang/Object;
/*     */     //   623	359	12	iterator$iv$iv	Ljava/util/Iterator;
/*     */     //   611	371	10	$this$minBy$iv$iv	Ljava/lang/Iterable;
/*     */     //   614	368	11	$i$f$minBy	I
/*     */     //   596	389	8	$this$minBy$iv	Ljava/util/Map;
/*     */     //   599	386	9	$i$f$minBy	I
/*     */     //   1165	53	24	safePos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1135	83	22	hardness	D
/*     */     //   1063	156	14	$dstr$pos$block	Ljava/util/Map$Entry;
/*     */     //   1063	156	20	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1063	156	21	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1066	153	16	$i$a$-maxBy-Nuker$onUpdate$2	I
/*     */     //   1339	53	29	safePos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1309	83	27	hardness	D
/*     */     //   1237	156	17	$dstr$pos$block	Ljava/util/Map$Entry;
/*     */     //   1237	156	25	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1237	156	26	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1240	153	19	$i$a$-maxBy-Nuker$onUpdate$2	I
/*     */     //   1531	8	6	rotation	Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   1587	372	6	autoTool	Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoTool;
/*     */     //   1481	478	5	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1481	478	4	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   523	1436	3	validBlocks	Ljava/util/Map;
/*     */     //   2316	25	20	rayTrace	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   2287	54	16	blockVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   2248	93	14	eyesPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   2084	265	12	$dstr$pos$block	Ljava/util/Map$Entry;
/*     */     //   2084	265	17	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   2084	265	19	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   2087	262	13	$i$a$-filter-Nuker$onUpdate$3	I
/*     */     //   2080	294	11	element$iv$iv	Ljava/util/Map$Entry;
/*     */     //   2034	345	5	$this$filterTo$iv$iv	Ljava/util/Map;
/*     */     //   2034	345	6	destination$iv$iv	Ljava/util/Map;
/*     */     //   2037	342	7	$i$f$filterTo	I
/*     */     //   2016	364	3	$this$filter$iv	Ljava/util/Map;
/*     */     //   2019	361	4	$i$f$filter	I
/*     */     //   2430	112	9	$dstr$pos$_u24__u24	Ljava/util/Map$Entry;
/*     */     //   2430	112	13	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   2433	109	10	$i$a$-forEach-Nuker$onUpdate$4	I
/*     */     //   2426	117	8	element$iv	Ljava/util/Map$Entry;
/*     */     //   2381	166	3	$this$forEach$iv	Ljava/util/Map;
/*     */     //   2384	163	4	$i$f$forEach	I
/*     */     //   115	2433	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	2548	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Nuker;
/*     */     //   0	2548	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 216 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (!((Boolean)this.layerValue.get()).booleanValue()) {
/* 217 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  WBlockPos safePos = new WBlockPos(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY() - true, MinecraftInstance.mc.getThePlayer().getPosZ());
/* 218 */       IBlock safeBlock = BlockUtils.getBlock(safePos);
/* 219 */       if (safeBlock != null && validBlock(safeBlock)) {
/* 220 */         RenderUtils.drawBlockBox(safePos, Color.GREEN, true);
/*     */       }
/*     */     } 
/*     */     
/* 224 */     for (WBlockPos blockPos : this.attackedBlocks) {
/* 225 */       RenderUtils.drawBlockBox(blockPos, Color.RED, true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private final boolean validBlock(IBlock block) {
/* 231 */     return (!MinecraftInstance.classProvider.isBlockAir(block) && !MinecraftInstance.classProvider.isBlockLiquid(block) && !MinecraftInstance.classProvider.isBlockBedrock(block));
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Nuker$Companion;", "", "()V", "currentDamage", "", "getCurrentDamage", "()F", "setCurrentDamage", "(F)V", "XSJClient"})
/*     */   public static final class Companion {
/* 234 */     public final void setCurrentDamage(float <set-?>) { Nuker.currentDamage = <set-?>; } private Companion() {} public final float getCurrentDamage() { return Nuker.currentDamage; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Nuker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */