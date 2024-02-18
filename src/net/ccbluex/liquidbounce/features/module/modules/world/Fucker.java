/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.DoubleCompanionObject;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BlockValue;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "Fucker", description = "Destroys selected blocks around you. (aka.  IDNuker)", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000l\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\006\n\002\020\013\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020'\032\004\030\0010\0232\006\020(\032\0020\006J\020\020)\032\0020*2\006\020+\032\0020\023H\002J\020\020,\032\0020-2\006\020.\032\0020/H\007J\020\0200\032\0020-2\006\020.\032\00201H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\020X\004¢\006\002\n\000R\020\020\022\032\004\030\0010\023X\016¢\006\002\n\000R\034\020\024\032\004\030\0010\023X\016¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\020X\004¢\006\002\n\000R\016\020\034\032\0020\020X\004¢\006\002\n\000R\016\020\035\032\0020\020X\004¢\006\002\n\000R\016\020\036\032\0020\037X\004¢\006\002\n\000R\016\020 \032\0020!X\004¢\006\002\n\000R\024\020\"\032\0020#8VX\004¢\006\006\032\004\b$\020%R\016\020&\032\0020\004X\004¢\006\002\n\000¨\0062"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Fucker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "actionValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "blockHitDelay", "", "blockValue", "Lnet/ccbluex/liquidbounce/value/BlockValue;", "currentDamage", "", "getCurrentDamage", "()F", "setCurrentDamage", "(F)V", "instantValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "noHitValue", "oldPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "pos", "getPos", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "setPos", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)V", "rangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "rotationsValue", "surroundingsValue", "swingValue", "switchTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "switchValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "tag", "", "getTag", "()Ljava/lang/String;", "throughWallsValue", "find", "targetID", "isHitable", "", "blockPos", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class Fucker extends Module {
/*     */   static {
/*  32 */     Fucker fucker = new Fucker();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   private static final BlockValue blockValue = new BlockValue("Block", 26);
/*  39 */   private static final ListValue throughWallsValue = new ListValue("ThroughWalls", new String[] { "None", "Raycast", "Around" }, "None");
/*  40 */   private static final FloatValue rangeValue = new FloatValue("Range", 5.0F, 1.0F, 7.0F);
/*  41 */   private static final ListValue actionValue = new ListValue("Action", new String[] { "Destroy", "Use" }, "Destroy");
/*  42 */   private static final BoolValue instantValue = new BoolValue("Instant", false);
/*  43 */   private static final IntegerValue switchValue = new IntegerValue("SwitchDelay", 250, 0, 1000);
/*  44 */   private static final BoolValue swingValue = new BoolValue("Swing", true);
/*  45 */   private static final BoolValue rotationsValue = new BoolValue("Rotations", true);
/*  46 */   private static final BoolValue surroundingsValue = new BoolValue("Surroundings", true);
/*  47 */   private static final BoolValue noHitValue = new BoolValue("NoHit", false);
/*     */   @Nullable
/*     */   private static WBlockPos pos;
/*     */   private static WBlockPos oldPos;
/*     */   private static int blockHitDelay;
/*     */   
/*     */   @Nullable
/*     */   public final WBlockPos getPos() {
/*  55 */     return pos; } public final void setPos(@Nullable WBlockPos <set-?>) { pos = <set-?>; }
/*     */ 
/*     */   
/*  58 */   private static final MSTimer switchTimer = new MSTimer();
/*  59 */   private static float currentDamage; public static final Fucker INSTANCE; public final float getCurrentDamage() { return currentDamage; } public final void setCurrentDamage(float <set-?>) { currentDamage = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     //   24: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.noHitValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   27: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   30: checkcast java/lang/Boolean
/*     */     //   33: invokevirtual booleanValue : ()Z
/*     */     //   36: ifeq -> 83
/*     */     //   39: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   42: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   45: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   47: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   50: dup
/*     */     //   51: ifnonnull -> 64
/*     */     //   54: new kotlin/TypeCastException
/*     */     //   57: dup
/*     */     //   58: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   60: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   63: athrow
/*     */     //   64: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   67: astore_3
/*     */     //   68: aload_3
/*     */     //   69: invokevirtual getState : ()Z
/*     */     //   72: ifeq -> 83
/*     */     //   75: aload_3
/*     */     //   76: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   79: ifnull -> 83
/*     */     //   82: return
/*     */     //   83: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.blockValue : Lnet/ccbluex/liquidbounce/value/BlockValue;
/*     */     //   86: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   89: checkcast java/lang/Number
/*     */     //   92: invokevirtual intValue : ()I
/*     */     //   95: istore_3
/*     */     //   96: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   99: ifnull -> 163
/*     */     //   102: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   105: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   108: dup
/*     */     //   109: ifnonnull -> 115
/*     */     //   112: invokestatic throwNpe : ()V
/*     */     //   115: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   118: dup
/*     */     //   119: ifnonnull -> 125
/*     */     //   122: invokestatic throwNpe : ()V
/*     */     //   125: invokeinterface getIdFromBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)I
/*     */     //   130: iload_3
/*     */     //   131: if_icmpne -> 163
/*     */     //   134: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   137: dup
/*     */     //   138: ifnonnull -> 144
/*     */     //   141: invokestatic throwNpe : ()V
/*     */     //   144: invokestatic getCenterDistance : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)D
/*     */     //   147: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   150: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   153: checkcast java/lang/Number
/*     */     //   156: invokevirtual doubleValue : ()D
/*     */     //   159: dcmpl
/*     */     //   160: ifle -> 171
/*     */     //   163: aload_0
/*     */     //   164: iload_3
/*     */     //   165: invokevirtual find : (I)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   168: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   171: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   174: ifnonnull -> 182
/*     */     //   177: fconst_0
/*     */     //   178: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   181: return
/*     */     //   182: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   185: dup
/*     */     //   186: ifnull -> 192
/*     */     //   189: goto -> 194
/*     */     //   192: pop
/*     */     //   193: return
/*     */     //   194: astore #4
/*     */     //   196: aload #4
/*     */     //   198: invokestatic faceBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   201: dup
/*     */     //   202: ifnull -> 208
/*     */     //   205: goto -> 210
/*     */     //   208: pop
/*     */     //   209: return
/*     */     //   210: astore #5
/*     */     //   212: iconst_0
/*     */     //   213: istore #6
/*     */     //   215: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.surroundingsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   218: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   221: checkcast java/lang/Boolean
/*     */     //   224: invokevirtual booleanValue : ()Z
/*     */     //   227: ifeq -> 380
/*     */     //   230: aload_2
/*     */     //   231: fconst_1
/*     */     //   232: invokeinterface getPositionEyes : (F)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   237: astore #7
/*     */     //   239: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   242: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   247: dup
/*     */     //   248: ifnonnull -> 254
/*     */     //   251: invokestatic throwNpe : ()V
/*     */     //   254: aload #7
/*     */     //   256: aload #5
/*     */     //   258: invokevirtual getVec : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   261: iconst_0
/*     */     //   262: iconst_0
/*     */     //   263: iconst_1
/*     */     //   264: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   269: dup
/*     */     //   270: ifnull -> 281
/*     */     //   273: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   278: goto -> 283
/*     */     //   281: pop
/*     */     //   282: aconst_null
/*     */     //   283: astore #8
/*     */     //   285: aload #8
/*     */     //   287: ifnull -> 380
/*     */     //   290: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   293: aload #8
/*     */     //   295: invokeinterface isBlockAir : (Ljava/lang/Object;)Z
/*     */     //   300: ifne -> 380
/*     */     //   303: aload #4
/*     */     //   305: invokevirtual getX : ()I
/*     */     //   308: aload #8
/*     */     //   310: invokevirtual getX : ()I
/*     */     //   313: if_icmpne -> 342
/*     */     //   316: aload #4
/*     */     //   318: invokevirtual getY : ()I
/*     */     //   321: aload #8
/*     */     //   323: invokevirtual getY : ()I
/*     */     //   326: if_icmpne -> 342
/*     */     //   329: aload #4
/*     */     //   331: invokevirtual getZ : ()I
/*     */     //   334: aload #8
/*     */     //   336: invokevirtual getZ : ()I
/*     */     //   339: if_icmpeq -> 345
/*     */     //   342: iconst_1
/*     */     //   343: istore #6
/*     */     //   345: aload #8
/*     */     //   347: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   350: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   353: dup
/*     */     //   354: ifnull -> 360
/*     */     //   357: goto -> 362
/*     */     //   360: pop
/*     */     //   361: return
/*     */     //   362: astore #4
/*     */     //   364: aload #4
/*     */     //   366: invokestatic faceBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   369: dup
/*     */     //   370: ifnull -> 376
/*     */     //   373: goto -> 378
/*     */     //   376: pop
/*     */     //   377: return
/*     */     //   378: astore #5
/*     */     //   380: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.oldPos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   383: ifnull -> 409
/*     */     //   386: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.oldPos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   389: aload #4
/*     */     //   391: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   394: iconst_1
/*     */     //   395: ixor
/*     */     //   396: ifeq -> 409
/*     */     //   399: fconst_0
/*     */     //   400: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   403: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.switchTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   406: invokevirtual reset : ()V
/*     */     //   409: aload #4
/*     */     //   411: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.oldPos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   414: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.switchTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   417: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.switchValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   420: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   423: checkcast java/lang/Number
/*     */     //   426: invokevirtual intValue : ()I
/*     */     //   429: i2l
/*     */     //   430: invokevirtual hasTimePassed : (J)Z
/*     */     //   433: ifne -> 437
/*     */     //   436: return
/*     */     //   437: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.blockHitDelay : I
/*     */     //   440: ifle -> 455
/*     */     //   443: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.blockHitDelay : I
/*     */     //   446: dup
/*     */     //   447: istore #7
/*     */     //   449: iconst_m1
/*     */     //   450: iadd
/*     */     //   451: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.blockHitDelay : I
/*     */     //   454: return
/*     */     //   455: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.rotationsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   458: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   461: checkcast java/lang/Boolean
/*     */     //   464: invokevirtual booleanValue : ()Z
/*     */     //   467: ifeq -> 478
/*     */     //   470: aload #5
/*     */     //   472: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   475: invokestatic setTargetRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)V
/*     */     //   478: nop
/*     */     //   479: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.actionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   482: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   485: checkcast java/lang/String
/*     */     //   488: ldc_w 'destroy'
/*     */     //   491: iconst_1
/*     */     //   492: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   495: ifne -> 503
/*     */     //   498: iload #6
/*     */     //   500: ifeq -> 1033
/*     */     //   503: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   506: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   509: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/AutoTool
/*     */     //   512: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   515: dup
/*     */     //   516: ifnonnull -> 530
/*     */     //   519: new kotlin/TypeCastException
/*     */     //   522: dup
/*     */     //   523: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoTool'
/*     */     //   526: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   529: athrow
/*     */     //   530: checkcast net/ccbluex/liquidbounce/features/module/modules/player/AutoTool
/*     */     //   533: astore #7
/*     */     //   535: aload #7
/*     */     //   537: invokevirtual getState : ()Z
/*     */     //   540: ifeq -> 550
/*     */     //   543: aload #7
/*     */     //   545: aload #4
/*     */     //   547: invokevirtual switchSlot : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)V
/*     */     //   550: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.instantValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   553: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   556: checkcast java/lang/Boolean
/*     */     //   559: invokevirtual booleanValue : ()Z
/*     */     //   562: ifeq -> 665
/*     */     //   565: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   568: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   573: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   576: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.START_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   579: aload #4
/*     */     //   581: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   584: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   587: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   592: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   597: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   602: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   605: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   608: checkcast java/lang/Boolean
/*     */     //   611: invokevirtual booleanValue : ()Z
/*     */     //   614: ifeq -> 623
/*     */     //   617: aload_2
/*     */     //   618: invokeinterface swingItem : ()V
/*     */     //   623: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   626: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   631: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   634: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.STOP_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   637: aload #4
/*     */     //   639: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   642: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   645: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   650: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   655: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   660: fconst_0
/*     */     //   661: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   664: return
/*     */     //   665: aload #4
/*     */     //   667: invokevirtual getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   670: dup
/*     */     //   671: ifnull -> 677
/*     */     //   674: goto -> 679
/*     */     //   677: pop
/*     */     //   678: return
/*     */     //   679: astore #8
/*     */     //   681: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   684: fconst_0
/*     */     //   685: fcmpg
/*     */     //   686: ifne -> 849
/*     */     //   689: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   692: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   697: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   700: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.START_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   703: aload #4
/*     */     //   705: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   708: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   711: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   716: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   721: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   726: aload_2
/*     */     //   727: invokeinterface getCapabilities : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;
/*     */     //   732: invokeinterface isCreativeMode : ()Z
/*     */     //   737: ifne -> 781
/*     */     //   740: aload #8
/*     */     //   742: aload_2
/*     */     //   743: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   746: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   751: dup
/*     */     //   752: ifnonnull -> 758
/*     */     //   755: invokestatic throwNpe : ()V
/*     */     //   758: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   761: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   764: dup
/*     */     //   765: ifnonnull -> 771
/*     */     //   768: invokestatic throwNpe : ()V
/*     */     //   771: invokeinterface getPlayerRelativeBlockHardness : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)F
/*     */     //   776: fconst_1
/*     */     //   777: fcmpl
/*     */     //   778: iflt -> 849
/*     */     //   781: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   784: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   787: checkcast java/lang/Boolean
/*     */     //   790: invokevirtual booleanValue : ()Z
/*     */     //   793: ifeq -> 802
/*     */     //   796: aload_2
/*     */     //   797: invokeinterface swingItem : ()V
/*     */     //   802: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   805: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   810: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   813: dup
/*     */     //   814: ifnonnull -> 820
/*     */     //   817: invokestatic throwNpe : ()V
/*     */     //   820: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   823: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   826: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   831: invokeinterface onPlayerDestroyBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Z
/*     */     //   836: pop
/*     */     //   837: fconst_0
/*     */     //   838: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   841: aconst_null
/*     */     //   842: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   845: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   848: return
/*     */     //   849: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   852: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   855: checkcast java/lang/Boolean
/*     */     //   858: invokevirtual booleanValue : ()Z
/*     */     //   861: ifeq -> 870
/*     */     //   864: aload_2
/*     */     //   865: invokeinterface swingItem : ()V
/*     */     //   870: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   873: aload #8
/*     */     //   875: aload_2
/*     */     //   876: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   879: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   884: dup
/*     */     //   885: ifnonnull -> 891
/*     */     //   888: invokestatic throwNpe : ()V
/*     */     //   891: checkcast net/ccbluex/liquidbounce/api/minecraft/world/IWorld
/*     */     //   894: aload #4
/*     */     //   896: invokeinterface getPlayerRelativeBlockHardness : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)F
/*     */     //   901: fadd
/*     */     //   902: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   905: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   908: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   913: dup
/*     */     //   914: ifnonnull -> 920
/*     */     //   917: invokestatic throwNpe : ()V
/*     */     //   920: aload_2
/*     */     //   921: invokeinterface getEntityId : ()I
/*     */     //   926: aload #4
/*     */     //   928: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   931: ldc_w 10.0
/*     */     //   934: fmul
/*     */     //   935: f2i
/*     */     //   936: iconst_1
/*     */     //   937: isub
/*     */     //   938: invokeinterface sendBlockBreakProgress : (ILnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;I)V
/*     */     //   943: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   946: fconst_1
/*     */     //   947: fcmpl
/*     */     //   948: iflt -> 1179
/*     */     //   951: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   954: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   959: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   962: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.STOP_DESTROY_BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   965: aload #4
/*     */     //   967: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   970: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   973: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   978: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   983: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   988: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   991: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   996: aload #4
/*     */     //   998: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1001: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1004: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1009: invokeinterface onPlayerDestroyBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Z
/*     */     //   1014: pop
/*     */     //   1015: iconst_4
/*     */     //   1016: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.blockHitDelay : I
/*     */     //   1019: fconst_0
/*     */     //   1020: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   1023: aconst_null
/*     */     //   1024: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1027: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1030: goto -> 1179
/*     */     //   1033: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.actionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1036: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1039: checkcast java/lang/String
/*     */     //   1042: ldc_w 'use'
/*     */     //   1045: iconst_1
/*     */     //   1046: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1049: ifeq -> 1179
/*     */     //   1052: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1055: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   1060: aload_2
/*     */     //   1061: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1064: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   1069: dup
/*     */     //   1070: ifnonnull -> 1076
/*     */     //   1073: invokestatic throwNpe : ()V
/*     */     //   1076: aload_2
/*     */     //   1077: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1082: dup
/*     */     //   1083: ifnonnull -> 1089
/*     */     //   1086: invokestatic throwNpe : ()V
/*     */     //   1089: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1092: dup
/*     */     //   1093: ifnonnull -> 1099
/*     */     //   1096: invokestatic throwNpe : ()V
/*     */     //   1099: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1102: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1105: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1110: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   1113: dup
/*     */     //   1114: aload #4
/*     */     //   1116: invokevirtual getX : ()I
/*     */     //   1119: i2d
/*     */     //   1120: aload #4
/*     */     //   1122: invokevirtual getY : ()I
/*     */     //   1125: i2d
/*     */     //   1126: aload #4
/*     */     //   1128: invokevirtual getZ : ()I
/*     */     //   1131: i2d
/*     */     //   1132: invokespecial <init> : (DDD)V
/*     */     //   1135: invokeinterface onPlayerRightClick : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)Z
/*     */     //   1140: ifeq -> 1179
/*     */     //   1143: getstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1146: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1149: checkcast java/lang/Boolean
/*     */     //   1152: invokevirtual booleanValue : ()Z
/*     */     //   1155: ifeq -> 1164
/*     */     //   1158: aload_2
/*     */     //   1159: invokeinterface swingItem : ()V
/*     */     //   1164: iconst_4
/*     */     //   1165: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.blockHitDelay : I
/*     */     //   1168: fconst_0
/*     */     //   1169: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.currentDamage : F
/*     */     //   1172: aconst_null
/*     */     //   1173: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1176: putstatic net/ccbluex/liquidbounce/features/module/modules/world/Fucker.pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1179: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #73	-> 6
/*     */     //   #73	-> 21
/*     */     //   #77	-> 24
/*     */     //   #78	-> 39
/*     */     //   #80	-> 68
/*     */     //   #81	-> 82
/*     */     //   #84	-> 83
/*     */     //   #86	-> 96
/*     */     //   #87	-> 96
/*     */     //   #86	-> 102
/*     */     //   #87	-> 134
/*     */     //   #88	-> 163
/*     */     //   #91	-> 171
/*     */     //   #92	-> 177
/*     */     //   #93	-> 181
/*     */     //   #96	-> 182
/*     */     //   #96	-> 192
/*     */     //   #97	-> 196
/*     */     //   #97	-> 208
/*     */     //   #100	-> 212
/*     */     //   #102	-> 215
/*     */     //   #103	-> 230
/*     */     //   #104	-> 239
/*     */     //   #105	-> 239
/*     */     //   #104	-> 239
/*     */     //   #105	-> 262
/*     */     //   #104	-> 264
/*     */     //   #107	-> 285
/*     */     //   #108	-> 303
/*     */     //   #109	-> 342
/*     */     //   #111	-> 345
/*     */     //   #112	-> 350
/*     */     //   #112	-> 360
/*     */     //   #113	-> 364
/*     */     //   #113	-> 376
/*     */     //   #118	-> 380
/*     */     //   #119	-> 399
/*     */     //   #120	-> 403
/*     */     //   #123	-> 409
/*     */     //   #125	-> 414
/*     */     //   #126	-> 436
/*     */     //   #129	-> 437
/*     */     //   #130	-> 443
/*     */     //   #131	-> 454
/*     */     //   #135	-> 455
/*     */     //   #136	-> 470
/*     */     //   #138	-> 478
/*     */     //   #140	-> 479
/*     */     //   #142	-> 503
/*     */     //   #143	-> 535
/*     */     //   #144	-> 543
/*     */     //   #147	-> 550
/*     */     //   #149	-> 565
/*     */     //   #150	-> 579
/*     */     //   #149	-> 592
/*     */     //   #152	-> 602
/*     */     //   #153	-> 617
/*     */     //   #155	-> 623
/*     */     //   #156	-> 637
/*     */     //   #155	-> 650
/*     */     //   #157	-> 660
/*     */     //   #158	-> 664
/*     */     //   #162	-> 665
/*     */     //   #162	-> 677
/*     */     //   #164	-> 681
/*     */     //   #165	-> 689
/*     */     //   #166	-> 703
/*     */     //   #165	-> 716
/*     */     //   #168	-> 726
/*     */     //   #169	-> 726
/*     */     //   #170	-> 781
/*     */     //   #171	-> 796
/*     */     //   #172	-> 802
/*     */     //   #174	-> 837
/*     */     //   #175	-> 841
/*     */     //   #176	-> 848
/*     */     //   #180	-> 849
/*     */     //   #181	-> 864
/*     */     //   #183	-> 870
/*     */     //   #184	-> 905
/*     */     //   #186	-> 943
/*     */     //   #187	-> 951
/*     */     //   #188	-> 965
/*     */     //   #187	-> 978
/*     */     //   #189	-> 988
/*     */     //   #190	-> 1015
/*     */     //   #191	-> 1019
/*     */     //   #192	-> 1023
/*     */     //   #197	-> 1033
/*     */     //   #198	-> 1060
/*     */     //   #199	-> 1110
/*     */     //   #197	-> 1135
/*     */     //   #200	-> 1143
/*     */     //   #201	-> 1158
/*     */     //   #203	-> 1164
/*     */     //   #204	-> 1168
/*     */     //   #205	-> 1172
/*     */     //   #207	-> 1179
/*     */     //   #208	-> 1179
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   68	15	3	killAura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   285	95	8	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   239	141	7	eyes	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   681	349	8	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   535	495	7	autoTool	Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoTool;
/*     */     //   215	965	6	surroundings	Z
/*     */     //   212	968	5	rotations	Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   196	984	4	currentPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   96	1084	3	targetId	I
/*     */     //   24	1156	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1180	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Fucker;
/*     */     //   0	1180	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 212 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (pos != null) { RenderUtils.drawBlockBox(pos, Color.RED, true);
/*     */       return; }
/*     */   
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
/*     */   @Nullable
/*     */   public final WBlockPos find(int targetID) {
/* 229 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 231 */       int radius = (int)((Number)rangeValue.get()).floatValue() + 1;
/*     */       
/* 233 */       double nearestBlockDistance = DoubleCompanionObject.INSTANCE.getMAX_VALUE();
/* 234 */       WBlockPos nearestBlock = (WBlockPos)null;
/*     */       
/* 236 */       int i = radius, j = -radius + 1; if (i >= j)
/* 237 */         while (true) { int k = radius, m = -radius + 1; if (k >= m)
/* 238 */             while (true) { int n = radius, i1 = -radius + 1; if (n >= i1)
/* 239 */                 while (true) { WBlockPos blockPos = new WBlockPos((int)thePlayer.getPosX() + i, (int)thePlayer.getPosY() + k, 
/* 240 */                       (int)thePlayer.getPosZ() + n);
/* 241 */                   if (BlockUtils.getBlock(blockPos) != null) { IBlock block = BlockUtils.getBlock(blockPos);
/*     */                     
/* 243 */                     if (access$getFunctions$p$s1046033730().getIdFromBlock(block) == targetID)
/*     */                     
/* 245 */                     { double distance = BlockUtils.getCenterDistance(blockPos);
/* 246 */                       if (distance <= ((Number)rangeValue.get()).doubleValue() && 
/* 247 */                         nearestBlockDistance >= distance && (
/* 248 */                         isHitable(blockPos) || ((Boolean)surroundingsValue.get()).booleanValue()))
/*     */                       
/* 250 */                       { nearestBlockDistance = distance;
/* 251 */                         nearestBlock = blockPos; }  }  } else { BlockUtils.getBlock(blockPos); }  if (n != i1) { n--; continue; }  break; }
/*     */                   if (k != m) { k--; continue; }
/*     */                break; }
/*     */               if (i != j) { i--; continue; }
/*     */            break; }
/* 256 */           return nearestBlock; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */     return null;
/*     */   }
/*     */   
/*     */   private final boolean isHitable(WBlockPos blockPos) {
/* 263 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 265 */       String str = (String)throughWallsValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 988024425:
/* 266 */           if (str.equals("raycast"))
/* 267 */           { WVec3 eyesPos = new WVec3(thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY() + 
/* 268 */                 thePlayer.getEyeHeight(), thePlayer.getPosZ());
/* 269 */             if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IMovingObjectPosition movingObjectPosition = MinecraftInstance.mc.getTheWorld().rayTraceBlocks(eyesPos, 
/* 270 */                 new WVec3(blockPos.getX() + 0.5D, blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D), false, 
/* 271 */                 true, false);
/*     */             
/* 273 */             return (movingObjectPosition != null && Intrinsics.areEqual(movingObjectPosition.getBlockPos(), blockPos)); }  break;
/*     */         case -1409235507:
/* 275 */           if (str.equals("around")) return (!BlockUtils.isFullBlock(blockPos.down()) || !BlockUtils.isFullBlock(blockPos.up()) || !BlockUtils.isFullBlock(blockPos.north()) || 
/* 276 */               !BlockUtils.isFullBlock(blockPos.east()) || !BlockUtils.isFullBlock(blockPos.south()) || !BlockUtils.isFullBlock(blockPos.west())); 
/*     */           break; }
/*     */       
/*     */       return true; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/* 282 */     return false; } @NotNull public String getTag() { return BlockUtils.getBlockName(((Number)blockValue.get()).intValue()); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Fucker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */