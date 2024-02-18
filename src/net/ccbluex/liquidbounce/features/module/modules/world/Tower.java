/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.math.MathKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.StatType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.block.PlaceInfo;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "Tower", description = "Automatically builds a tower beneath you.", category = ModuleCategory.WORLD, keyBind = 24)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\020\016\n\002\b\007\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020+\032\0020,H\002J\b\020-\032\0020,H\002J\b\020.\032\0020,H\026J\020\020/\032\0020,2\006\0200\032\00201H\007J\020\0202\032\0020,2\006\0200\032\00203H\007J\020\0204\032\0020,2\006\0200\032\00205H\007J\020\0206\032\0020,2\006\0200\032\00207H\007J\b\0208\032\0020,H\002J\020\0209\032\0020:2\006\020;\032\0020<H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\024\020\005\032\0020\0068BX\004¢\006\006\032\004\b\007\020\bR\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\nX\004¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\020X\016¢\006\002\n\000R\016\020\021\032\0020\nX\004¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000R\020\020\023\032\004\030\0010\024X\016¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\004X\004¢\006\002\n\000R\020\020\030\032\004\030\0010\031X\016¢\006\002\n\000R\016\020\032\032\0020\026X\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\006X\016¢\006\002\n\000R\016\020\035\032\0020\004X\004¢\006\002\n\000R\016\020\036\032\0020\004X\004¢\006\002\n\000R\016\020\037\032\0020\004X\004¢\006\002\n\000R\024\020 \032\0020!8VX\004¢\006\006\032\004\b\"\020#R\016\020$\032\0020\016X\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\nX\004¢\006\002\n\000R\016\020'\032\0020\004X\004¢\006\002\n\000R\016\020(\032\0020)X\004¢\006\002\n\000R\016\020*\032\0020\nX\004¢\006\002\n\000¨\006="}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Tower;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoBlockValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "blocksAmount", "", "getBlocksAmount", "()I", "constantMotionJumpGroundValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "constantMotionValue", "counterDisplayValue", "jumpDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "jumpGround", "", "jumpMotionValue", "keepRotationValue", "lockRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "onJumpValue", "placeInfo", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "placeModeValue", "rotationsValue", "slot", "stayAutoBlock", "stopWhenBlockAbove", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "teleportDelayValue", "teleportGroundValue", "teleportHeightValue", "teleportNoMotionValue", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "timerValue", "fakeJump", "", "move", "onDisable", "onJump", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "place", "search", "", "blockPosition", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"})
/*     */ public final class Tower
/*     */   extends Module
/*     */ {
/*  47 */   private final ListValue modeValue = new ListValue("Mode", new String[] {
/*  48 */         "Jump", "Motion", "ConstantMotion", "MotionTP", "Packet", "Teleport", "AAC3.3.9", "AAC3.6.4"
/*  49 */       }, "Motion");
/*  50 */   private final BoolValue autoBlockValue = new BoolValue("AutoBlock", true);
/*  51 */   private final BoolValue stayAutoBlock = new BoolValue("StayAutoBlock", false);
/*  52 */   private final BoolValue swingValue = new BoolValue("Swing", true);
/*  53 */   private final BoolValue stopWhenBlockAbove = new BoolValue("StopWhenBlockAbove", false);
/*  54 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/*  55 */   private final BoolValue keepRotationValue = new BoolValue("KeepRotation", false);
/*  56 */   private final BoolValue onJumpValue = new BoolValue("OnJump", false);
/*  57 */   private final ListValue placeModeValue = new ListValue("PlaceTiming", new String[] { "Pre", "Post" }, "Post");
/*  58 */   private final FloatValue timerValue = new FloatValue("Timer", 1.0F, 0.0F, 10.0F);
/*     */ 
/*     */   
/*  61 */   private final FloatValue jumpMotionValue = new FloatValue("JumpMotion", 0.42F, 0.3681289F, 0.79F);
/*  62 */   private final IntegerValue jumpDelayValue = new IntegerValue("JumpDelay", 0, 0, 20);
/*     */ 
/*     */   
/*  65 */   private final FloatValue constantMotionValue = new FloatValue("ConstantMotion", 0.42F, 0.1F, 1.0F);
/*  66 */   private final FloatValue constantMotionJumpGroundValue = new FloatValue("ConstantMotionJumpGround", 0.79F, 0.76F, 1.0F);
/*     */ 
/*     */   
/*  69 */   private final FloatValue teleportHeightValue = new FloatValue("TeleportHeight", 1.15F, 0.1F, 5.0F);
/*  70 */   private final IntegerValue teleportDelayValue = new IntegerValue("TeleportDelay", 0, 0, 20);
/*  71 */   private final BoolValue teleportGroundValue = new BoolValue("TeleportGround", true);
/*  72 */   private final BoolValue teleportNoMotionValue = new BoolValue("TeleportNoMotion", false);
/*     */ 
/*     */   
/*  75 */   private final BoolValue counterDisplayValue = new BoolValue("Counter", true);
/*     */ 
/*     */ 
/*     */   
/*     */   private PlaceInfo placeInfo;
/*     */ 
/*     */ 
/*     */   
/*     */   private Rotation lockRotation;
/*     */ 
/*     */ 
/*     */   
/*  87 */   private final TickTimer timer = new TickTimer();
/*     */   
/*     */   private double jumpGround;
/*     */   private int slot;
/*     */   
/*     */   public void onDisable() {
/*  93 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  95 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*  96 */       this.lockRotation = (Rotation)null;
/*     */       
/*  98 */       if (this.slot != thePlayer.getInventory().getCurrentItem()) {
/*  99 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(thePlayer.getInventory().getCurrentItem()));
/*     */       }
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
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
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield onJumpValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   13: checkcast java/lang/Boolean
/*     */     //   16: invokevirtual booleanValue : ()Z
/*     */     //   19: ifeq -> 44
/*     */     //   22: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   25: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   30: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   35: invokeinterface isKeyDown : ()Z
/*     */     //   40: ifne -> 44
/*     */     //   43: return
/*     */     //   44: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   47: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   52: dup
/*     */     //   53: ifnull -> 59
/*     */     //   56: goto -> 61
/*     */     //   59: pop
/*     */     //   60: return
/*     */     //   61: astore_2
/*     */     //   62: aload_0
/*     */     //   63: getfield rotationsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   66: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   69: checkcast java/lang/Boolean
/*     */     //   72: invokevirtual booleanValue : ()Z
/*     */     //   75: ifeq -> 108
/*     */     //   78: aload_0
/*     */     //   79: getfield keepRotationValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   82: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   85: checkcast java/lang/Boolean
/*     */     //   88: invokevirtual booleanValue : ()Z
/*     */     //   91: ifeq -> 108
/*     */     //   94: aload_0
/*     */     //   95: getfield lockRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   98: ifnull -> 108
/*     */     //   101: aload_0
/*     */     //   102: getfield lockRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   105: invokestatic setTargetRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)V
/*     */     //   108: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   111: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   116: aload_0
/*     */     //   117: getfield timerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   120: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   123: checkcast java/lang/Number
/*     */     //   126: invokevirtual floatValue : ()F
/*     */     //   129: invokeinterface setTimerSpeed : (F)V
/*     */     //   134: aload_1
/*     */     //   135: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   138: astore_3
/*     */     //   139: aload_0
/*     */     //   140: getfield placeModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   146: checkcast java/lang/String
/*     */     //   149: aload_3
/*     */     //   150: invokevirtual getStateName : ()Ljava/lang/String;
/*     */     //   153: iconst_1
/*     */     //   154: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   157: ifeq -> 164
/*     */     //   160: aload_0
/*     */     //   161: invokespecial place : ()V
/*     */     //   164: aload_3
/*     */     //   165: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   168: if_acmpne -> 498
/*     */     //   171: aload_0
/*     */     //   172: aconst_null
/*     */     //   173: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*     */     //   176: putfield placeInfo : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   179: aload_0
/*     */     //   180: getfield timer : Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;
/*     */     //   183: invokevirtual update : ()V
/*     */     //   186: aload_0
/*     */     //   187: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   190: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   193: checkcast java/lang/Boolean
/*     */     //   196: invokevirtual booleanValue : ()Z
/*     */     //   199: ifeq -> 255
/*     */     //   202: invokestatic findAutoBlockBlock : ()I
/*     */     //   205: iconst_m1
/*     */     //   206: if_icmpne -> 247
/*     */     //   209: aload_2
/*     */     //   210: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   215: ifnull -> 251
/*     */     //   218: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   221: aload_2
/*     */     //   222: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   227: dup
/*     */     //   228: ifnonnull -> 234
/*     */     //   231: invokestatic throwNpe : ()V
/*     */     //   234: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   239: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   244: ifeq -> 251
/*     */     //   247: iconst_1
/*     */     //   248: goto -> 298
/*     */     //   251: iconst_0
/*     */     //   252: goto -> 298
/*     */     //   255: aload_2
/*     */     //   256: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   261: ifnull -> 297
/*     */     //   264: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   267: aload_2
/*     */     //   268: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   273: dup
/*     */     //   274: ifnonnull -> 280
/*     */     //   277: invokestatic throwNpe : ()V
/*     */     //   280: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   285: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   290: ifeq -> 297
/*     */     //   293: iconst_1
/*     */     //   294: goto -> 298
/*     */     //   297: iconst_0
/*     */     //   298: istore #4
/*     */     //   300: iload #4
/*     */     //   302: ifeq -> 498
/*     */     //   305: aload_0
/*     */     //   306: getfield stopWhenBlockAbove : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   309: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   312: checkcast java/lang/Boolean
/*     */     //   315: invokevirtual booleanValue : ()Z
/*     */     //   318: ifeq -> 363
/*     */     //   321: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   324: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   327: dup
/*     */     //   328: aload_2
/*     */     //   329: invokeinterface getPosX : ()D
/*     */     //   334: aload_2
/*     */     //   335: invokeinterface getPosY : ()D
/*     */     //   340: iconst_2
/*     */     //   341: i2d
/*     */     //   342: dadd
/*     */     //   343: aload_2
/*     */     //   344: invokeinterface getPosZ : ()D
/*     */     //   349: invokespecial <init> : (DDD)V
/*     */     //   352: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   355: invokeinterface isBlockAir : (Ljava/lang/Object;)Z
/*     */     //   360: ifeq -> 367
/*     */     //   363: aload_0
/*     */     //   364: invokespecial move : ()V
/*     */     //   367: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   370: dup
/*     */     //   371: aload_2
/*     */     //   372: invokeinterface getPosX : ()D
/*     */     //   377: aload_2
/*     */     //   378: invokeinterface getPosY : ()D
/*     */     //   383: dconst_1
/*     */     //   384: dsub
/*     */     //   385: aload_2
/*     */     //   386: invokeinterface getPosZ : ()D
/*     */     //   391: invokespecial <init> : (DDD)V
/*     */     //   394: astore #5
/*     */     //   396: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   399: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   402: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   407: dup
/*     */     //   408: ifnonnull -> 414
/*     */     //   411: invokestatic throwNpe : ()V
/*     */     //   414: aload #5
/*     */     //   416: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   421: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   426: invokeinterface isBlockAir : (Ljava/lang/Object;)Z
/*     */     //   431: ifeq -> 498
/*     */     //   434: aload_0
/*     */     //   435: aload #5
/*     */     //   437: invokespecial search : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Z
/*     */     //   440: ifeq -> 498
/*     */     //   443: aload_0
/*     */     //   444: getfield rotationsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   447: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   450: checkcast java/lang/Boolean
/*     */     //   453: invokevirtual booleanValue : ()Z
/*     */     //   456: ifeq -> 498
/*     */     //   459: aload #5
/*     */     //   461: invokestatic faceBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   464: astore #6
/*     */     //   466: aload #6
/*     */     //   468: ifnull -> 498
/*     */     //   471: aload #6
/*     */     //   473: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   476: invokestatic setTargetRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)V
/*     */     //   479: aload_0
/*     */     //   480: getfield placeInfo : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   483: dup
/*     */     //   484: ifnonnull -> 490
/*     */     //   487: invokestatic throwNpe : ()V
/*     */     //   490: aload #6
/*     */     //   492: invokevirtual getVec : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   495: invokevirtual setVec3 : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)V
/*     */     //   498: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #105	-> 6
/*     */     //   #106	-> 44
/*     */     //   #106	-> 59
/*     */     //   #109	-> 62
/*     */     //   #110	-> 101
/*     */     //   #113	-> 108
/*     */     //   #114	-> 134
/*     */     //   #116	-> 139
/*     */     //   #117	-> 160
/*     */     //   #120	-> 164
/*     */     //   #121	-> 171
/*     */     //   #122	-> 179
/*     */     //   #124	-> 186
/*     */     //   #125	-> 202
/*     */     //   #127	-> 255
/*     */     //   #124	-> 298
/*     */     //   #130	-> 300
/*     */     //   #131	-> 305
/*     */     //   #132	-> 363
/*     */     //   #134	-> 367
/*     */     //   #135	-> 396
/*     */     //   #136	-> 434
/*     */     //   #137	-> 459
/*     */     //   #138	-> 466
/*     */     //   #139	-> 471
/*     */     //   #140	-> 479
/*     */     //   #146	-> 498
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   466	32	6	vecRotation	Lnet/ccbluex/liquidbounce/utils/VecRotation;
/*     */     //   396	102	5	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   300	198	4	update	Z
/*     */     //   139	360	3	eventState	Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   62	437	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	499	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Tower;
/*     */     //   0	499	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*     */   private final void fakeJump() {
/* 150 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setAirBorne(true);
/* 151 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().triggerAchievement(MinecraftInstance.classProvider.getStatEnum(StatType.JUMP_STAT));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void move() {
/* 158 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 160 */       String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 325228192:
/* 210 */           if (str.equals("aac3.3.9"))
/* 211 */           { if (thePlayer.getOnGround()) {
/* 212 */               fakeJump();
/* 213 */               thePlayer.setMotionY(0.4001D);
/*     */             } 
/* 215 */             MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 216 */             if (thePlayer.getMotionY() < false)
/* 217 */             { thePlayer.setMotionY(thePlayer.getMotionY() - 9.45E-6D);
/* 218 */               MinecraftInstance.mc.getTimer().setTimerSpeed(1.6F); }  }  break;case -157173582: if (str.equals("motiontp")) { if (thePlayer.getOnGround()) { fakeJump(); thePlayer.setMotionY(0.42D); break; }  if (thePlayer.getMotionY() < 0.23D)
/*     */               thePlayer.setPosition(thePlayer.getPosX(), MathKt.truncate(thePlayer.getPosY()), thePlayer.getPosZ());  }  break;case -1068318794: if (str.equals("motion")) { if (thePlayer.getOnGround()) { fakeJump(); thePlayer.setMotionY(0.42D); break; }  if (thePlayer.getMotionY() < 0.1D)
/*     */               thePlayer.setMotionY(-0.3D);  }  break;case -1360201941: if (str.equals("teleport")) { if (((Boolean)this.teleportNoMotionValue.get()).booleanValue())
/* 221 */               thePlayer.setMotionY(0.0D);  if ((thePlayer.getOnGround() || !((Boolean)this.teleportGroundValue.get()).booleanValue()) && this.timer.hasTimePassed(((Number)this.teleportDelayValue.get()).intValue())) { fakeJump(); thePlayer.setPositionAndUpdate(thePlayer.getPosX(), thePlayer.getPosY() + ((Number)this.teleportHeightValue.get()).doubleValue(), thePlayer.getPosZ()); this.timer.reset(); }  }  break;case 792877146: if (str.equals("constantmotion")) { if (thePlayer.getOnGround()) { fakeJump(); this.jumpGround = thePlayer.getPosY(); thePlayer.setMotionY(((Number)this.constantMotionValue.get()).floatValue()); }  if (thePlayer.getPosY() > this.jumpGround + ((Number)this.constantMotionJumpGroundValue.get()).doubleValue()) { fakeJump(); thePlayer.setPosition(thePlayer.getPosX(), MathKt.truncate(thePlayer.getPosY()), thePlayer.getPosZ()); thePlayer.setMotionY(((Number)this.constantMotionValue.get()).floatValue()); this.jumpGround = thePlayer.getPosY(); }  }  break;case -995865464: if (str.equals("packet") && thePlayer.getOnGround() && this.timer.hasTimePassed(2)) { fakeJump(); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 0.42D, thePlayer.getPosZ(), false)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(thePlayer.getPosX(), thePlayer.getPosY() + 0.753D, thePlayer.getPosZ(), false)); thePlayer.setPosition(thePlayer.getPosX(), thePlayer.getPosY() + 1.0D, thePlayer.getPosZ()); this.timer.reset(); }  break;case 325231070: if (str.equals("aac3.6.4")) { if (thePlayer.getTicksExisted() % 4 == 1) {
/* 222 */               thePlayer.setMotionY(0.4195464D);
/* 223 */               thePlayer.setPosition(thePlayer.getPosX() - 0.035D, thePlayer.getPosY(), thePlayer.getPosZ()); break;
/* 224 */             }  if (thePlayer.getTicksExisted() % 4 == 0) {
/* 225 */               thePlayer.setMotionY(-0.5D);
/* 226 */               thePlayer.setPosition(thePlayer.getPosX() + 0.035D, thePlayer.getPosY(), thePlayer.getPosZ());
/*     */             }  }
/*     */            break;
/*     */         case 3273774:
/*     */           if (str.equals("jump") && thePlayer.getOnGround() && this.timer.hasTimePassed(((Number)this.jumpDelayValue.get()).intValue())) {
/*     */             fakeJump(); thePlayer.setMotionY(((Number)this.jumpMotionValue.get()).floatValue()); this.timer.reset();
/*     */           }  break;
/*     */       }  return; }
/*     */     
/* 235 */     MinecraftInstance.mc.getThePlayer(); } private final void place() { if (this.placeInfo == null)
/* 236 */       return;  if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */ 
/*     */       
/* 239 */       int blockSlot = -1;
/* 240 */       IItemStack itemStack = thePlayer.getHeldItem();
/* 241 */       if (itemStack == null || !MinecraftInstance.classProvider.isItemBlock(itemStack.getItem())) {
/* 242 */         if (!((Boolean)this.autoBlockValue.get()).booleanValue())
/*     */           return; 
/* 244 */         blockSlot = InventoryUtils.findAutoBlockBlock();
/* 245 */         if (blockSlot == -1)
/*     */           return; 
/* 247 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(blockSlot - 36));
/* 248 */         itemStack = thePlayer.getInventoryContainer().getSlot(blockSlot).getStack();
/*     */       } 
/*     */ 
/*     */       
/* 252 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (itemStack == null) Intrinsics.throwNpe();  if (this.placeInfo == null) Intrinsics.throwNpe();  if (this.placeInfo == null) Intrinsics.throwNpe();  if (this.placeInfo == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getPlayerController().onPlayerRightClick(thePlayer, MinecraftInstance.mc.getTheWorld(), itemStack, this.placeInfo.getBlockPos(), this.placeInfo.getEnumFacing(), this.placeInfo.getVec3())) {
/* 253 */         if (((Boolean)this.swingValue.get()).booleanValue()) {
/* 254 */           thePlayer.swingItem();
/*     */         } else {
/* 256 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketAnimation());
/*     */         } 
/*     */       }
/* 259 */       this.placeInfo = (PlaceInfo)null;
/*     */ 
/*     */       
/* 262 */       if (!((Boolean)this.stayAutoBlock.get()).booleanValue() && blockSlot >= 0) {
/* 263 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(thePlayer.getInventory().getCurrentItem()));
/*     */       }
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean search(WBlockPos blockPosition) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnull -> 15
/*     */     //   12: goto -> 18
/*     */     //   15: pop
/*     */     //   16: iconst_0
/*     */     //   17: ireturn
/*     */     //   18: astore_2
/*     */     //   19: iconst_0
/*     */     //   20: istore_3
/*     */     //   21: aload_1
/*     */     //   22: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   25: dup
/*     */     //   26: ifnull -> 37
/*     */     //   29: invokeinterface isReplaceable : ()Z
/*     */     //   34: goto -> 39
/*     */     //   37: pop
/*     */     //   38: iconst_0
/*     */     //   39: ifne -> 44
/*     */     //   42: iconst_0
/*     */     //   43: ireturn
/*     */     //   44: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   47: dup
/*     */     //   48: aload_2
/*     */     //   49: invokeinterface getPosX : ()D
/*     */     //   54: aload_2
/*     */     //   55: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   60: invokeinterface getMinY : ()D
/*     */     //   65: aload_2
/*     */     //   66: invokeinterface getEyeHeight : ()F
/*     */     //   71: f2d
/*     */     //   72: dadd
/*     */     //   73: aload_2
/*     */     //   74: invokeinterface getPosZ : ()D
/*     */     //   79: invokespecial <init> : (DDD)V
/*     */     //   82: astore_3
/*     */     //   83: aconst_null
/*     */     //   84: checkcast net/ccbluex/liquidbounce/utils/PlaceRotation
/*     */     //   87: astore #4
/*     */     //   89: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   92: astore #7
/*     */     //   94: aload #7
/*     */     //   96: arraylength
/*     */     //   97: istore #8
/*     */     //   99: iconst_0
/*     */     //   100: istore #6
/*     */     //   102: iload #6
/*     */     //   104: iload #8
/*     */     //   106: if_icmpge -> 1055
/*     */     //   109: aload #7
/*     */     //   111: iload #6
/*     */     //   113: aaload
/*     */     //   114: astore #5
/*     */     //   116: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   119: aload #5
/*     */     //   121: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   126: astore #9
/*     */     //   128: aload_1
/*     */     //   129: aload #9
/*     */     //   131: iconst_0
/*     */     //   132: iconst_2
/*     */     //   133: aconst_null
/*     */     //   134: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   137: astore #10
/*     */     //   139: aload #10
/*     */     //   141: invokestatic canBeClicked : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Z
/*     */     //   144: ifne -> 150
/*     */     //   147: goto -> 1049
/*     */     //   150: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   153: dup
/*     */     //   154: aload #9
/*     */     //   156: invokeinterface getDirectionVec : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;
/*     */     //   161: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*     */     //   164: astore #11
/*     */     //   166: ldc2_w 0.1
/*     */     //   169: dstore #12
/*     */     //   171: dload #12
/*     */     //   173: ldc2_w 0.9
/*     */     //   176: dcmpg
/*     */     //   177: ifge -> 1049
/*     */     //   180: ldc2_w 0.1
/*     */     //   183: dstore #14
/*     */     //   185: dload #14
/*     */     //   187: ldc2_w 0.9
/*     */     //   190: dcmpg
/*     */     //   191: ifge -> 1038
/*     */     //   194: ldc2_w 0.1
/*     */     //   197: dstore #16
/*     */     //   199: dload #16
/*     */     //   201: ldc2_w 0.9
/*     */     //   204: dcmpg
/*     */     //   205: ifge -> 1027
/*     */     //   208: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   211: dup
/*     */     //   212: aload_1
/*     */     //   213: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WVec3i
/*     */     //   216: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*     */     //   219: astore #19
/*     */     //   221: iconst_0
/*     */     //   222: istore #20
/*     */     //   224: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   227: dup
/*     */     //   228: aload #19
/*     */     //   230: invokevirtual getXCoord : ()D
/*     */     //   233: dload #12
/*     */     //   235: dadd
/*     */     //   236: aload #19
/*     */     //   238: invokevirtual getYCoord : ()D
/*     */     //   241: dload #14
/*     */     //   243: dadd
/*     */     //   244: aload #19
/*     */     //   246: invokevirtual getZCoord : ()D
/*     */     //   249: dload #16
/*     */     //   251: dadd
/*     */     //   252: invokespecial <init> : (DDD)V
/*     */     //   255: astore #18
/*     */     //   257: aload_3
/*     */     //   258: astore #21
/*     */     //   260: iconst_0
/*     */     //   261: istore #22
/*     */     //   263: aload #18
/*     */     //   265: invokevirtual getXCoord : ()D
/*     */     //   268: aload #21
/*     */     //   270: invokevirtual getXCoord : ()D
/*     */     //   273: dsub
/*     */     //   274: dstore #23
/*     */     //   276: aload #18
/*     */     //   278: invokevirtual getYCoord : ()D
/*     */     //   281: aload #21
/*     */     //   283: invokevirtual getYCoord : ()D
/*     */     //   286: dsub
/*     */     //   287: dstore #25
/*     */     //   289: aload #18
/*     */     //   291: invokevirtual getZCoord : ()D
/*     */     //   294: aload #21
/*     */     //   296: invokevirtual getZCoord : ()D
/*     */     //   299: dsub
/*     */     //   300: dstore #27
/*     */     //   302: dload #23
/*     */     //   304: dload #23
/*     */     //   306: dmul
/*     */     //   307: dload #25
/*     */     //   309: dload #25
/*     */     //   311: dmul
/*     */     //   312: dadd
/*     */     //   313: dload #27
/*     */     //   315: dload #27
/*     */     //   317: dmul
/*     */     //   318: dadd
/*     */     //   319: dstore #19
/*     */     //   321: aload #18
/*     */     //   323: astore #22
/*     */     //   325: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   328: dup
/*     */     //   329: aload #11
/*     */     //   331: invokevirtual getXCoord : ()D
/*     */     //   334: ldc2_w 0.5
/*     */     //   337: dmul
/*     */     //   338: aload #11
/*     */     //   340: invokevirtual getYCoord : ()D
/*     */     //   343: ldc2_w 0.5
/*     */     //   346: dmul
/*     */     //   347: aload #11
/*     */     //   349: invokevirtual getZCoord : ()D
/*     */     //   352: ldc2_w 0.5
/*     */     //   355: dmul
/*     */     //   356: invokespecial <init> : (DDD)V
/*     */     //   359: astore #23
/*     */     //   361: iconst_0
/*     */     //   362: istore #24
/*     */     //   364: aload #22
/*     */     //   366: astore #25
/*     */     //   368: aload #23
/*     */     //   370: invokevirtual getXCoord : ()D
/*     */     //   373: dstore #26
/*     */     //   375: aload #23
/*     */     //   377: invokevirtual getYCoord : ()D
/*     */     //   380: dstore #28
/*     */     //   382: aload #23
/*     */     //   384: invokevirtual getZCoord : ()D
/*     */     //   387: dstore #30
/*     */     //   389: iconst_0
/*     */     //   390: istore #32
/*     */     //   392: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   395: dup
/*     */     //   396: aload #25
/*     */     //   398: invokevirtual getXCoord : ()D
/*     */     //   401: dload #26
/*     */     //   403: dadd
/*     */     //   404: aload #25
/*     */     //   406: invokevirtual getYCoord : ()D
/*     */     //   409: dload #28
/*     */     //   411: dadd
/*     */     //   412: aload #25
/*     */     //   414: invokevirtual getZCoord : ()D
/*     */     //   417: dload #30
/*     */     //   419: dadd
/*     */     //   420: invokespecial <init> : (DDD)V
/*     */     //   423: nop
/*     */     //   424: astore #21
/*     */     //   426: aload_3
/*     */     //   427: astore #22
/*     */     //   429: iconst_0
/*     */     //   430: istore #23
/*     */     //   432: aload #21
/*     */     //   434: invokevirtual getXCoord : ()D
/*     */     //   437: aload #22
/*     */     //   439: invokevirtual getXCoord : ()D
/*     */     //   442: dsub
/*     */     //   443: dstore #24
/*     */     //   445: aload #21
/*     */     //   447: invokevirtual getYCoord : ()D
/*     */     //   450: aload #22
/*     */     //   452: invokevirtual getYCoord : ()D
/*     */     //   455: dsub
/*     */     //   456: dstore #26
/*     */     //   458: aload #21
/*     */     //   460: invokevirtual getZCoord : ()D
/*     */     //   463: aload #22
/*     */     //   465: invokevirtual getZCoord : ()D
/*     */     //   468: dsub
/*     */     //   469: dstore #28
/*     */     //   471: dload #24
/*     */     //   473: dload #24
/*     */     //   475: dmul
/*     */     //   476: dload #26
/*     */     //   478: dload #26
/*     */     //   480: dmul
/*     */     //   481: dadd
/*     */     //   482: dload #28
/*     */     //   484: dload #28
/*     */     //   486: dmul
/*     */     //   487: dadd
/*     */     //   488: ldc2_w 18.0
/*     */     //   491: dcmpl
/*     */     //   492: ifgt -> 677
/*     */     //   495: dload #19
/*     */     //   497: aload_3
/*     */     //   498: astore #22
/*     */     //   500: aload #18
/*     */     //   502: astore #23
/*     */     //   504: dstore #41
/*     */     //   506: iconst_0
/*     */     //   507: istore #24
/*     */     //   509: aload #23
/*     */     //   511: astore #25
/*     */     //   513: aload #11
/*     */     //   515: invokevirtual getXCoord : ()D
/*     */     //   518: dstore #26
/*     */     //   520: aload #11
/*     */     //   522: invokevirtual getYCoord : ()D
/*     */     //   525: dstore #28
/*     */     //   527: aload #11
/*     */     //   529: invokevirtual getZCoord : ()D
/*     */     //   532: dstore #30
/*     */     //   534: iconst_0
/*     */     //   535: istore #32
/*     */     //   537: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   540: dup
/*     */     //   541: aload #25
/*     */     //   543: invokevirtual getXCoord : ()D
/*     */     //   546: dload #26
/*     */     //   548: dadd
/*     */     //   549: aload #25
/*     */     //   551: invokevirtual getYCoord : ()D
/*     */     //   554: dload #28
/*     */     //   556: dadd
/*     */     //   557: aload #25
/*     */     //   559: invokevirtual getZCoord : ()D
/*     */     //   562: dload #30
/*     */     //   564: dadd
/*     */     //   565: invokespecial <init> : (DDD)V
/*     */     //   568: nop
/*     */     //   569: astore #43
/*     */     //   571: dload #41
/*     */     //   573: aload #43
/*     */     //   575: astore #23
/*     */     //   577: dstore #41
/*     */     //   579: iconst_0
/*     */     //   580: istore #24
/*     */     //   582: aload #23
/*     */     //   584: invokevirtual getXCoord : ()D
/*     */     //   587: aload #22
/*     */     //   589: invokevirtual getXCoord : ()D
/*     */     //   592: dsub
/*     */     //   593: dstore #25
/*     */     //   595: aload #23
/*     */     //   597: invokevirtual getYCoord : ()D
/*     */     //   600: aload #22
/*     */     //   602: invokevirtual getYCoord : ()D
/*     */     //   605: dsub
/*     */     //   606: dstore #27
/*     */     //   608: aload #23
/*     */     //   610: invokevirtual getZCoord : ()D
/*     */     //   613: aload #22
/*     */     //   615: invokevirtual getZCoord : ()D
/*     */     //   618: dsub
/*     */     //   619: dstore #29
/*     */     //   621: dload #25
/*     */     //   623: dload #25
/*     */     //   625: dmul
/*     */     //   626: dload #27
/*     */     //   628: dload #27
/*     */     //   630: dmul
/*     */     //   631: dadd
/*     */     //   632: dload #29
/*     */     //   634: dload #29
/*     */     //   636: dmul
/*     */     //   637: dadd
/*     */     //   638: dstore #43
/*     */     //   640: dload #41
/*     */     //   642: dload #43
/*     */     //   644: dcmpl
/*     */     //   645: ifgt -> 677
/*     */     //   648: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   651: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   656: dup
/*     */     //   657: ifnonnull -> 663
/*     */     //   660: invokestatic throwNpe : ()V
/*     */     //   663: aload_3
/*     */     //   664: aload #21
/*     */     //   666: iconst_0
/*     */     //   667: iconst_1
/*     */     //   668: iconst_0
/*     */     //   669: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   674: ifnull -> 688
/*     */     //   677: dload #16
/*     */     //   679: ldc2_w 0.1
/*     */     //   682: dadd
/*     */     //   683: dstore #16
/*     */     //   685: goto -> 199
/*     */     //   688: aload #21
/*     */     //   690: invokevirtual getXCoord : ()D
/*     */     //   693: aload_3
/*     */     //   694: invokevirtual getXCoord : ()D
/*     */     //   697: dsub
/*     */     //   698: dstore #22
/*     */     //   700: aload #21
/*     */     //   702: invokevirtual getYCoord : ()D
/*     */     //   705: aload_3
/*     */     //   706: invokevirtual getYCoord : ()D
/*     */     //   709: dsub
/*     */     //   710: dstore #24
/*     */     //   712: aload #21
/*     */     //   714: invokevirtual getZCoord : ()D
/*     */     //   717: aload_3
/*     */     //   718: invokevirtual getZCoord : ()D
/*     */     //   721: dsub
/*     */     //   722: dstore #26
/*     */     //   724: dload #22
/*     */     //   726: dload #22
/*     */     //   728: dmul
/*     */     //   729: dload #26
/*     */     //   731: dload #26
/*     */     //   733: dmul
/*     */     //   734: dadd
/*     */     //   735: dstore #30
/*     */     //   737: iconst_0
/*     */     //   738: istore #32
/*     */     //   740: dload #30
/*     */     //   742: invokestatic sqrt : (D)D
/*     */     //   745: dstore #28
/*     */     //   747: iconst_0
/*     */     //   748: istore #31
/*     */     //   750: dload #26
/*     */     //   752: dload #22
/*     */     //   754: invokestatic atan2 : (DD)D
/*     */     //   757: dstore #43
/*     */     //   759: dload #43
/*     */     //   761: invokestatic toDegrees : (D)D
/*     */     //   764: d2f
/*     */     //   765: ldc_w 90.0
/*     */     //   768: fsub
/*     */     //   769: invokestatic wrapAngleTo180_float : (F)F
/*     */     //   772: fstore #43
/*     */     //   774: iconst_0
/*     */     //   775: istore #31
/*     */     //   777: dload #24
/*     */     //   779: dload #28
/*     */     //   781: invokestatic atan2 : (DD)D
/*     */     //   784: dstore #44
/*     */     //   786: fload #43
/*     */     //   788: dload #44
/*     */     //   790: invokestatic toDegrees : (D)D
/*     */     //   793: dneg
/*     */     //   794: d2f
/*     */     //   795: invokestatic wrapAngleTo180_float : (F)F
/*     */     //   798: fstore #46
/*     */     //   800: fstore #47
/*     */     //   802: new net/ccbluex/liquidbounce/utils/Rotation
/*     */     //   805: dup
/*     */     //   806: fload #47
/*     */     //   808: fload #46
/*     */     //   810: invokespecial <init> : (FF)V
/*     */     //   813: astore #30
/*     */     //   815: aload #30
/*     */     //   817: invokestatic getVectorForRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   820: astore #31
/*     */     //   822: aload_3
/*     */     //   823: astore #33
/*     */     //   825: aload #31
/*     */     //   827: invokevirtual getXCoord : ()D
/*     */     //   830: iconst_4
/*     */     //   831: i2d
/*     */     //   832: dmul
/*     */     //   833: dstore #34
/*     */     //   835: aload #31
/*     */     //   837: invokevirtual getYCoord : ()D
/*     */     //   840: iconst_4
/*     */     //   841: i2d
/*     */     //   842: dmul
/*     */     //   843: dstore #36
/*     */     //   845: aload #31
/*     */     //   847: invokevirtual getZCoord : ()D
/*     */     //   850: iconst_4
/*     */     //   851: i2d
/*     */     //   852: dmul
/*     */     //   853: dstore #38
/*     */     //   855: iconst_0
/*     */     //   856: istore #40
/*     */     //   858: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*     */     //   861: dup
/*     */     //   862: aload #33
/*     */     //   864: invokevirtual getXCoord : ()D
/*     */     //   867: dload #34
/*     */     //   869: dadd
/*     */     //   870: aload #33
/*     */     //   872: invokevirtual getYCoord : ()D
/*     */     //   875: dload #36
/*     */     //   877: dadd
/*     */     //   878: aload #33
/*     */     //   880: invokevirtual getZCoord : ()D
/*     */     //   883: dload #38
/*     */     //   885: dadd
/*     */     //   886: invokespecial <init> : (DDD)V
/*     */     //   889: astore #32
/*     */     //   891: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   894: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   899: dup
/*     */     //   900: ifnonnull -> 906
/*     */     //   903: invokestatic throwNpe : ()V
/*     */     //   906: aload_3
/*     */     //   907: aload #32
/*     */     //   909: iconst_0
/*     */     //   910: iconst_0
/*     */     //   911: iconst_1
/*     */     //   912: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   917: astore #33
/*     */     //   919: aload #33
/*     */     //   921: dup
/*     */     //   922: ifnonnull -> 928
/*     */     //   925: invokestatic throwNpe : ()V
/*     */     //   928: invokeinterface getTypeOfHit : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;
/*     */     //   933: getstatic net/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType.BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;
/*     */     //   936: if_acmpne -> 954
/*     */     //   939: aload #33
/*     */     //   941: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   946: aload #10
/*     */     //   948: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   951: ifne -> 965
/*     */     //   954: dload #16
/*     */     //   956: ldc2_w 0.1
/*     */     //   959: dadd
/*     */     //   960: dstore #16
/*     */     //   962: goto -> 199
/*     */     //   965: aload #4
/*     */     //   967: ifnull -> 987
/*     */     //   970: aload #30
/*     */     //   972: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/utils/Rotation;)D
/*     */     //   975: aload #4
/*     */     //   977: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   980: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/utils/Rotation;)D
/*     */     //   983: dcmpg
/*     */     //   984: ifge -> 1016
/*     */     //   987: new net/ccbluex/liquidbounce/utils/PlaceRotation
/*     */     //   990: dup
/*     */     //   991: new net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*     */     //   994: dup
/*     */     //   995: aload #10
/*     */     //   997: aload #9
/*     */     //   999: invokeinterface getOpposite : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1004: aload #21
/*     */     //   1006: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)V
/*     */     //   1009: aload #30
/*     */     //   1011: invokespecial <init> : (Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;Lnet/ccbluex/liquidbounce/utils/Rotation;)V
/*     */     //   1014: astore #4
/*     */     //   1016: dload #16
/*     */     //   1018: ldc2_w 0.1
/*     */     //   1021: dadd
/*     */     //   1022: dstore #16
/*     */     //   1024: goto -> 199
/*     */     //   1027: dload #14
/*     */     //   1029: ldc2_w 0.1
/*     */     //   1032: dadd
/*     */     //   1033: dstore #14
/*     */     //   1035: goto -> 185
/*     */     //   1038: dload #12
/*     */     //   1040: ldc2_w 0.1
/*     */     //   1043: dadd
/*     */     //   1044: dstore #12
/*     */     //   1046: goto -> 171
/*     */     //   1049: iinc #6, 1
/*     */     //   1052: goto -> 102
/*     */     //   1055: aload #4
/*     */     //   1057: ifnonnull -> 1062
/*     */     //   1060: iconst_0
/*     */     //   1061: ireturn
/*     */     //   1062: aload_0
/*     */     //   1063: getfield rotationsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1066: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1069: checkcast java/lang/Boolean
/*     */     //   1072: invokevirtual booleanValue : ()Z
/*     */     //   1075: ifeq -> 1096
/*     */     //   1078: aload #4
/*     */     //   1080: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   1083: iconst_0
/*     */     //   1084: invokestatic setTargetRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;I)V
/*     */     //   1087: aload_0
/*     */     //   1088: aload #4
/*     */     //   1090: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   1093: putfield lockRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   1096: aload_0
/*     */     //   1097: aload #4
/*     */     //   1099: invokevirtual getPlaceInfo : ()Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   1102: putfield placeInfo : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   1105: iconst_1
/*     */     //   1106: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #274	-> 0
/*     */     //   #274	-> 15
/*     */     //   #275	-> 19
/*     */     //   #403	-> 21
/*     */     //   #403	-> 37
/*     */     //   #275	-> 42
/*     */     //   #277	-> 44
/*     */     //   #278	-> 83
/*     */     //   #279	-> 89
/*     */     //   #280	-> 116
/*     */     //   #281	-> 128
/*     */     //   #283	-> 139
/*     */     //   #284	-> 147
/*     */     //   #286	-> 150
/*     */     //   #288	-> 166
/*     */     //   #289	-> 171
/*     */     //   #290	-> 180
/*     */     //   #291	-> 185
/*     */     //   #292	-> 194
/*     */     //   #293	-> 199
/*     */     //   #294	-> 208
/*     */     //   #404	-> 224
/*     */     //   #294	-> 255
/*     */     //   #295	-> 257
/*     */     //   #405	-> 263
/*     */     //   #406	-> 276
/*     */     //   #407	-> 289
/*     */     //   #409	-> 302
/*     */     //   #295	-> 319
/*     */     //   #296	-> 321
/*     */     //   #410	-> 364
/*     */     //   #411	-> 392
/*     */     //   #410	-> 423
/*     */     //   #296	-> 424
/*     */     //   #297	-> 426
/*     */     //   #412	-> 432
/*     */     //   #413	-> 445
/*     */     //   #414	-> 458
/*     */     //   #416	-> 471
/*     */     //   #297	-> 497
/*     */     //   #417	-> 509
/*     */     //   #418	-> 537
/*     */     //   #417	-> 568
/*     */     //   #297	-> 577
/*     */     //   #419	-> 582
/*     */     //   #420	-> 595
/*     */     //   #421	-> 608
/*     */     //   #423	-> 621
/*     */     //   #297	-> 648
/*     */     //   #298	-> 667
/*     */     //   #297	-> 669
/*     */     //   #299	-> 677
/*     */     //   #300	-> 685
/*     */     //   #304	-> 688
/*     */     //   #305	-> 700
/*     */     //   #306	-> 712
/*     */     //   #307	-> 724
/*     */     //   #307	-> 745
/*     */     //   #309	-> 747
/*     */     //   #310	-> 747
/*     */     //   #310	-> 761
/*     */     //   #311	-> 772
/*     */     //   #311	-> 790
/*     */     //   #309	-> 798
/*     */     //   #313	-> 815
/*     */     //   #314	-> 822
/*     */     //   #424	-> 858
/*     */     //   #314	-> 889
/*     */     //   #315	-> 891
/*     */     //   #316	-> 910
/*     */     //   #315	-> 912
/*     */     //   #317	-> 919
/*     */     //   #318	-> 954
/*     */     //   #319	-> 962
/*     */     //   #321	-> 965
/*     */     //   #322	-> 965
/*     */     //   #321	-> 970
/*     */     //   #322	-> 975
/*     */     //   #323	-> 1016
/*     */     //   #293	-> 1024
/*     */     //   #325	-> 1027
/*     */     //   #291	-> 1035
/*     */     //   #327	-> 1038
/*     */     //   #289	-> 1046
/*     */     //   #279	-> 1049
/*     */     //   #330	-> 1055
/*     */     //   #331	-> 1062
/*     */     //   #332	-> 1078
/*     */     //   #333	-> 1087
/*     */     //   #335	-> 1096
/*     */     //   #336	-> 1105
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   21	18	3	$i$f$isReplaceable	I
/*     */     //   221	34	19	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   224	31	20	$i$f$addVector	I
/*     */     //   302	17	27	d2$iv	D
/*     */     //   289	30	25	d1$iv	D
/*     */     //   276	43	23	d0$iv	D
/*     */     //   260	59	21	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   263	56	22	$i$f$squareDistanceTo	I
/*     */     //   389	34	25	this_$iv$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   389	34	26	x$iv$iv	D
/*     */     //   389	34	28	y$iv$iv	D
/*     */     //   389	34	30	z$iv$iv	D
/*     */     //   392	31	32	$i$f$addVector	I
/*     */     //   361	63	22	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   361	63	23	vec$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   364	60	24	$i$f$add	I
/*     */     //   471	17	28	d2$iv	D
/*     */     //   458	30	26	d1$iv	D
/*     */     //   445	43	24	d0$iv	D
/*     */     //   429	59	22	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   432	56	23	$i$f$squareDistanceTo	I
/*     */     //   534	34	25	this_$iv$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   534	34	26	x$iv$iv	D
/*     */     //   534	34	28	y$iv$iv	D
/*     */     //   534	34	30	z$iv$iv	D
/*     */     //   537	31	32	$i$f$addVector	I
/*     */     //   506	63	23	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   509	60	24	$i$f$add	I
/*     */     //   621	17	29	d2$iv	D
/*     */     //   608	30	27	d1$iv	D
/*     */     //   595	43	25	d0$iv	D
/*     */     //   579	59	22	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   579	59	23	vec$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   582	56	24	$i$f$squareDistanceTo	I
/*     */     //   855	34	33	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   855	34	34	x$iv	D
/*     */     //   855	34	36	y$iv	D
/*     */     //   855	34	38	z$iv	D
/*     */     //   858	31	40	$i$f$addVector	I
/*     */     //   919	105	33	obj	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   891	133	32	vector	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   822	202	31	rotationVector	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   815	209	30	rotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   747	277	28	diffXZ	D
/*     */     //   724	300	26	diffZ	D
/*     */     //   712	312	24	diffY	D
/*     */     //   700	324	22	diffX	D
/*     */     //   426	598	21	hitVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   321	703	19	distanceSqPosVec	D
/*     */     //   257	767	18	posVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   199	836	16	zSearch	D
/*     */     //   185	861	14	ySearch	D
/*     */     //   171	878	12	xSearch	D
/*     */     //   166	883	11	dirVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   139	910	10	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   128	921	9	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   116	936	5	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   89	1018	4	placeRotation	Lnet/ccbluex/liquidbounce/utils/PlaceRotation;
/*     */     //   83	1024	3	eyesPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   19	1088	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1107	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Tower;
/*     */     //   0	1107	1	blockPosition	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 341 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null)
/* 342 */       return;  IPacket packet = event.getPacket();
/* 343 */     if (MinecraftInstance.classProvider.isCPacketHeldItemChange(packet)) {
/* 344 */       this.slot = packet.asCPacketHeldItemChange().getSlotId();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender2D(@NotNull Render2DEvent event) {
/* 355 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.counterDisplayValue.get()).booleanValue()) {
/* 356 */       GL11.glPushMatrix();
/* 357 */       if (Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay");  BlockOverlay blockOverlay = (BlockOverlay)Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class);
/* 358 */       if (blockOverlay.getState() && ((Boolean)blockOverlay.getInfoValue().get()).booleanValue() && blockOverlay.getCurrentBlock() != null) {
/* 359 */         GL11.glTranslatef(0.0F, 15.0F, 0.0F);
/*     */       }
/* 361 */       String info = "Blocks: §7" + getBlocksAmount();
/* 362 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IScaledResolution scaledResolution = MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 367 */       Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawBorderedRect((scaledResolution.getScaledWidth() / 2) - 2, (scaledResolution.getScaledHeight() / 2) + 5, (scaledResolution.getScaledWidth() / 2 + Fonts.font40.getStringWidth(info)) + 2, (scaledResolution.getScaledHeight() / 2) + 16, 3.0F, Color.BLACK.getRGB(), Color.BLACK.getRGB());
/*     */       
/* 369 */       MinecraftInstance.classProvider.getGlStateManager().resetColor();
/*     */ 
/*     */       
/* 372 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(info, scaledResolution.getScaledWidth() / 2, (scaledResolution.getScaledHeight() / 2) + 7, Color.WHITE.getRGB());
/* 373 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 379 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.onJumpValue.get()).booleanValue()) event.cancelEvent();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int getBlocksAmount() {
/* 387 */     int amount = 0;
/* 388 */     for (byte b1 = 36, b2 = 44; b1 <= b2; b1++) {
/* 389 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getStack();
/* 390 */       if (itemStack != null && MinecraftInstance.classProvider.isItemBlock(itemStack.getItem())) {
/* 391 */         if (itemStack.getItem() == null) Intrinsics.throwNpe();  IBlock block = itemStack.getItem().asItemBlock().getBlock();
/* 392 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (Intrinsics.areEqual(MinecraftInstance.mc.getThePlayer().getHeldItem(), itemStack) || !InventoryUtils.BLOCK_BLACKLIST.contains(block)) {
/* 393 */           amount += itemStack.getStackSize();
/*     */         }
/*     */       } 
/*     */     } 
/* 397 */     return amount;
/*     */   }
/*     */   @NotNull
/*     */   public String getTag() {
/* 401 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Tower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */