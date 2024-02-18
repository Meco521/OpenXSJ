/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.NotImplementedError;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerBlockPlacement;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.EventState;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import tomk.utils.packet.PacketUtils;
/*     */ 
/*     */ @ModuleInfo(name = "NoSlow", description = "Cancels slowness effects caused by soulsand and using items.", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000¤\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\006\n\002\020\016\n\002\b\b\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\007\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\t\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020-\032\0020\0212\006\020.\032\0020/H\002J\020\0200\032\0020\0212\006\020.\032\0020/H\002J\020\0201\032\002022\006\0203\032\00204H\002J\016\0205\032\0020\0212\006\0206\032\00207J\032\0208\032\002092\b\020:\032\004\030\0010;2\006\020<\032\0020\021H\002J\006\020=\032\0020\021J\b\020>\032\0020?H\026J\020\020@\032\0020?2\006\020.\032\0020/H\007J\020\020A\032\0020?2\006\020.\032\0020BH\007J\020\020C\032\0020?2\006\020.\032\0020DH\007J\020\020E\032\0020?2\006\020.\032\0020FH\007JB\020G\032\0020?2\006\020H\032\0020/2\006\020I\032\0020\0212\006\020J\032\0020\0212\006\020K\032\0020\0212\006\020L\032\0020M2\006\020N\032\0020\0212\b\b\002\020O\032\0020\021H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\016\020\n\032\0020\006X\004¢\006\002\n\000R\016\020\013\032\0020\006X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\024\020\020\032\0020\0218BX\004¢\006\006\032\004\b\020\020\022R\021\020\023\032\0020\024¢\006\b\n\000\032\004\b\025\020\026R\016\020\027\032\0020\021X\016¢\006\002\n\000R\016\020\030\032\0020\031X\004¢\006\002\n\000R\016\020\032\032\0020\004X\004¢\006\002\n\000R\016\020\033\032\0020\021X\016¢\006\002\n\000R\032\020\034\032\016\022\n\022\b\022\004\022\0020\0370\0360\035X\016¢\006\002\n\000R\016\020 \032\0020\021X\016¢\006\002\n\000R\016\020!\032\0020\021X\016¢\006\002\n\000R\021\020\"\032\0020\017¢\006\b\n\000\032\004\b#\020$R\024\020%\032\0020&8VX\004¢\006\006\032\004\b'\020(R\021\020)\032\0020\004¢\006\b\n\000\032\004\b*\020+R\016\020,\032\0020\021X\016¢\006\002\n\000¨\006P"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "blockForwardMultiplier", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "blockStrafeMultiplier", "bowForwardMultiplier", "bowStrafeMultiplier", "consumeForwardMultiplier", "consumeStrafeMultiplier", "customDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "customOnGround", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "isBlocking", "", "()Z", "killAura", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "getKillAura", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "lastBlockingStat", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "nextTemp", "packetBuf", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "pendingFlagApplyPacket", "sendBuf", "soulsandValue", "getSoulsandValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "waitC03", "OnPost", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "OnPre", "createUseItemPacket", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "itemStack", "Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;", "fuckKotline", "value", "", "getMultiplier", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isForward", "isBlock", "onDisable", "", "onMotion", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "sendPacket", "Event", "SendC07", "SendC08", "Delay", "DelayValue", "", "onGround", "Hypixel", "XSJClient"})
/*     */ public final class NoSlow extends Module {
/*  42 */   private final ListValue modeValue = new ListValue(
/*  43 */       "PacketMode", 
/*  44 */       new String[] { "GrimFix", "Grim", "NoPacket", "AAC", "AAC5", "Matrix", "Vulcan", "Custom"
/*  45 */       }, "AntiCheat");
/*     */   
/*  47 */   private final FloatValue blockForwardMultiplier = new FloatValue("BlockForwardMultiplier", 1.0F, 0.2F, 1.0F);
/*  48 */   private final FloatValue blockStrafeMultiplier = new FloatValue("BlockStrafeMultiplier", 1.0F, 0.2F, 1.0F);
/*  49 */   private final FloatValue consumeForwardMultiplier = new FloatValue("ConsumeForwardMultiplier", 1.0F, 0.2F, 1.0F);
/*  50 */   private final FloatValue consumeStrafeMultiplier = new FloatValue("ConsumeStrafeMultiplier", 1.0F, 0.2F, 1.0F);
/*  51 */   private final FloatValue bowForwardMultiplier = new FloatValue("BowForwardMultiplier", 1.0F, 0.2F, 1.0F);
/*  52 */   private final FloatValue bowStrafeMultiplier = new FloatValue("BowStrafeMultiplier", 1.0F, 0.2F, 1.0F);
/*  53 */   private final BoolValue customOnGround = new BoolValue("CustomOnGround", false);
/*  54 */   private final IntegerValue customDelayValue = new IntegerValue("CustomDelay", 60, 10, 200);
/*     */   
/*     */   @NotNull
/*  57 */   private final BoolValue soulsandValue = new BoolValue("Soulsand", false); @NotNull public final BoolValue getSoulsandValue() { return this.soulsandValue; }
/*     */    @NotNull
/*  59 */   private final MSTimer timer = new MSTimer(); @NotNull public final MSTimer getTimer() { return this.timer; }
/*  60 */    private final MSTimer Timer = new MSTimer();
/*     */   private boolean pendingFlagApplyPacket;
/*  62 */   private final MSTimer msTimer = new MSTimer();
/*     */   private boolean sendBuf;
/*  64 */   private LinkedList<Packet<INetHandlerPlayServer>> packetBuf = new LinkedList<>();
/*     */   private boolean nextTemp; private boolean waitC03; private boolean lastBlockingStat; @NotNull
/*     */   private final KillAura killAura;
/*     */   
/*     */   @NotNull
/*  69 */   public final KillAura getKillAura() { return this.killAura; } public NoSlow() { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  this.killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class); }
/*     */ 
/*     */   
/*     */   public final boolean isBlock() {
/*  73 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return (MinecraftInstance.mc.getThePlayer().isBlocking() || this.killAura.getBlockingStatus());
/*     */   }
/*     */   
/*     */   public final boolean fuckKotline(int value) {
/*  77 */     return (value == 1);
/*     */   }
/*     */   
/*     */   private final boolean OnPre(MotionEvent event) {
/*  81 */     return (event.getEventState() == EventState.PRE);
/*     */   }
/*     */   
/*     */   private final boolean OnPost(MotionEvent event) {
/*  85 */     return (event.getEventState() == EventState.POST);
/*     */   }
/*     */   private final boolean isBlocking() {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnonnull -> 15
/*     */     //   12: invokestatic throwNpe : ()V
/*     */     //   15: invokeinterface isUsingItem : ()Z
/*     */     //   20: ifne -> 57
/*     */     //   23: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   26: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   29: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   31: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   34: dup
/*     */     //   35: ifnonnull -> 48
/*     */     //   38: new kotlin/TypeCastException
/*     */     //   41: dup
/*     */     //   42: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   44: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   47: athrow
/*     */     //   48: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   51: invokevirtual getBlockingStatus : ()Z
/*     */     //   54: ifeq -> 122
/*     */     //   57: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   60: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   65: dup
/*     */     //   66: ifnonnull -> 72
/*     */     //   69: invokestatic throwNpe : ()V
/*     */     //   72: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   77: ifnull -> 122
/*     */     //   80: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   83: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   88: dup
/*     */     //   89: ifnonnull -> 95
/*     */     //   92: invokestatic throwNpe : ()V
/*     */     //   95: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   100: dup
/*     */     //   101: ifnonnull -> 107
/*     */     //   104: invokestatic throwNpe : ()V
/*     */     //   107: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   112: instanceof net/minecraft/item/ItemSword
/*     */     //   115: ifeq -> 122
/*     */     //   118: iconst_1
/*     */     //   119: goto -> 123
/*     */     //   122: iconst_0
/*     */     //   123: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #89	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	124	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  92 */     this.Timer.reset();
/*  93 */     this.msTimer.reset();
/*  94 */     this.pendingFlagApplyPacket = false;
/*  95 */     this.sendBuf = false;
/*  96 */     this.packetBuf.clear();
/*  97 */     this.nextTemp = false;
/*  98 */     this.waitC03 = false;
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
/*     */   private final void sendPacket(MotionEvent Event, boolean SendC07, boolean SendC08, boolean Delay, long DelayValue, boolean onGround, boolean Hypixel) {
/* 110 */     if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura aura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (EnumFacing.DOWN == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing");  IPacket digging = MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, new WBlockPos(-1, -1, -1), (IEnumFacing)EnumFacing.DOWN);
/*     */ 
/*     */     
/* 117 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  ICPacketPlayerBlockPlacement blockPlace = MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement((IItemStack)Integer.valueOf(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/*     */ 
/*     */ 
/*     */     
/* 121 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  ICPacketPlayerBlockPlacement blockMent = MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(new WBlockPos(-1, -1, -1), 255, (IItemStack)Integer.valueOf(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()), 
/* 122 */         0.0F, 
/* 123 */         0.0F, 
/* 124 */         0.0F);
/*     */     
/* 126 */     if (onGround) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) {
/*     */         return;
/*     */       } }
/*     */     
/* 130 */     if (SendC07 && OnPre(Event)) {
/* 131 */       if (Delay && this.Timer.hasTimePassed(DelayValue)) {
/* 132 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(digging);
/* 133 */       } else if (!Delay) {
/* 134 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(digging);
/*     */       } 
/*     */     }
/* 137 */     if (SendC08 && OnPost(Event)) {
/* 138 */       if (Delay && this.Timer.hasTimePassed(DelayValue) && !Hypixel) {
/* 139 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)blockPlace);
/* 140 */         this.Timer.reset();
/* 141 */       } else if (!Delay && !Hypixel) {
/* 142 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)blockPlace);
/* 143 */       } else if (Hypixel) {
/* 144 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)blockMent);
/*     */       } 
/*     */     }
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
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'event'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   10: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   15: dup
/*     */     //   16: ifnull -> 22
/*     */     //   19: goto -> 24
/*     */     //   22: pop
/*     */     //   23: return
/*     */     //   24: astore_2
/*     */     //   25: aload_0
/*     */     //   26: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   29: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   34: dup
/*     */     //   35: ifnonnull -> 41
/*     */     //   38: invokestatic throwNpe : ()V
/*     */     //   41: invokeinterface getTicksExisted : ()I
/*     */     //   46: iconst_1
/*     */     //   47: iand
/*     */     //   48: invokevirtual fuckKotline : (I)Z
/*     */     //   51: istore_3
/*     */     //   52: aload_2
/*     */     //   53: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   58: astore #4
/*     */     //   60: invokestatic isMoving : ()Z
/*     */     //   63: ifne -> 67
/*     */     //   66: return
/*     */     //   67: aload_0
/*     */     //   68: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   71: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   74: checkcast java/lang/String
/*     */     //   77: astore #5
/*     */     //   79: iconst_0
/*     */     //   80: istore #6
/*     */     //   82: aload #5
/*     */     //   84: dup
/*     */     //   85: ifnonnull -> 99
/*     */     //   88: new kotlin/TypeCastException
/*     */     //   91: dup
/*     */     //   92: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   95: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   98: athrow
/*     */     //   99: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   102: dup
/*     */     //   103: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   106: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   109: astore #5
/*     */     //   111: aload #5
/*     */     //   113: invokevirtual hashCode : ()I
/*     */     //   116: lookupswitch default -> 1207, -1349088399 -> 196, 96323 -> 168, 2228079 -> 210, 2986066 -> 224, 287640166 -> 182
/*     */     //   168: aload #5
/*     */     //   170: ldc_w 'aac'
/*     */     //   173: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   176: ifeq -> 1207
/*     */     //   179: goto -> 1055
/*     */     //   182: aload #5
/*     */     //   184: ldc_w 'grimfix'
/*     */     //   187: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   190: ifeq -> 1207
/*     */     //   193: goto -> 403
/*     */     //   196: aload #5
/*     */     //   198: ldc_w 'custom'
/*     */     //   201: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   204: ifeq -> 1207
/*     */     //   207: goto -> 238
/*     */     //   210: aload #5
/*     */     //   212: ldc_w 'Grim'
/*     */     //   215: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   218: ifeq -> 1207
/*     */     //   221: goto -> 280
/*     */     //   224: aload #5
/*     */     //   226: ldc_w 'aac5'
/*     */     //   229: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   232: ifeq -> 1207
/*     */     //   235: goto -> 1114
/*     */     //   238: aload_0
/*     */     //   239: aload_1
/*     */     //   240: iconst_1
/*     */     //   241: iconst_1
/*     */     //   242: iconst_1
/*     */     //   243: aload_0
/*     */     //   244: getfield customDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   247: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   250: checkcast java/lang/Number
/*     */     //   253: invokevirtual intValue : ()I
/*     */     //   256: i2l
/*     */     //   257: aload_0
/*     */     //   258: getfield customOnGround : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   261: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   264: checkcast java/lang/Boolean
/*     */     //   267: invokevirtual booleanValue : ()Z
/*     */     //   270: iconst_0
/*     */     //   271: bipush #64
/*     */     //   273: aconst_null
/*     */     //   274: invokestatic sendPacket$default : (Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;Lnet/ccbluex/liquidbounce/event/MotionEvent;ZZZJZZILjava/lang/Object;)V
/*     */     //   277: goto -> 1207
/*     */     //   280: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   283: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   288: dup
/*     */     //   289: ifnonnull -> 295
/*     */     //   292: invokestatic throwNpe : ()V
/*     */     //   295: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   298: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   303: dup
/*     */     //   304: ifnonnull -> 310
/*     */     //   307: invokestatic throwNpe : ()V
/*     */     //   310: invokeinterface getMotionX : ()D
/*     */     //   315: invokeinterface setMotionX : (D)V
/*     */     //   320: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   323: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   328: dup
/*     */     //   329: ifnonnull -> 335
/*     */     //   332: invokestatic throwNpe : ()V
/*     */     //   335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   338: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   343: dup
/*     */     //   344: ifnonnull -> 350
/*     */     //   347: invokestatic throwNpe : ()V
/*     */     //   350: invokeinterface getMotionY : ()D
/*     */     //   355: invokeinterface setMotionY : (D)V
/*     */     //   360: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   363: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   368: dup
/*     */     //   369: ifnonnull -> 375
/*     */     //   372: invokestatic throwNpe : ()V
/*     */     //   375: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   378: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   383: dup
/*     */     //   384: ifnonnull -> 390
/*     */     //   387: invokestatic throwNpe : ()V
/*     */     //   390: invokeinterface getMotionZ : ()D
/*     */     //   395: invokeinterface setMotionZ : (D)V
/*     */     //   400: goto -> 1207
/*     */     //   403: aload_1
/*     */     //   404: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   407: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   410: if_acmpne -> 609
/*     */     //   413: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   416: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   421: dup
/*     */     //   422: ifnonnull -> 428
/*     */     //   425: invokestatic throwNpe : ()V
/*     */     //   428: invokeinterface isBlocking : ()Z
/*     */     //   433: ifne -> 609
/*     */     //   436: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   439: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   442: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   447: dup
/*     */     //   448: ifnonnull -> 454
/*     */     //   451: invokestatic throwNpe : ()V
/*     */     //   454: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   459: dup
/*     */     //   460: ifnonnull -> 466
/*     */     //   463: invokestatic throwNpe : ()V
/*     */     //   466: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   471: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   476: ifne -> 609
/*     */     //   479: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   482: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   485: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   490: dup
/*     */     //   491: ifnonnull -> 497
/*     */     //   494: invokestatic throwNpe : ()V
/*     */     //   497: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   502: dup
/*     */     //   503: ifnonnull -> 509
/*     */     //   506: invokestatic throwNpe : ()V
/*     */     //   509: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   514: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   519: ifne -> 609
/*     */     //   522: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   525: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   528: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   533: dup
/*     */     //   534: ifnonnull -> 540
/*     */     //   537: invokestatic throwNpe : ()V
/*     */     //   540: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   545: dup
/*     */     //   546: ifnonnull -> 552
/*     */     //   549: invokestatic throwNpe : ()V
/*     */     //   552: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   557: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   562: ifne -> 609
/*     */     //   565: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   568: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   573: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   576: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   579: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*     */     //   582: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   585: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   588: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   591: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   596: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   601: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   606: goto -> 842
/*     */     //   609: aload_1
/*     */     //   610: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   613: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   616: if_acmpne -> 842
/*     */     //   619: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   622: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   627: dup
/*     */     //   628: ifnonnull -> 634
/*     */     //   631: invokestatic throwNpe : ()V
/*     */     //   634: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   639: ifnull -> 842
/*     */     //   642: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   645: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   650: dup
/*     */     //   651: ifnonnull -> 657
/*     */     //   654: invokestatic throwNpe : ()V
/*     */     //   657: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   662: dup
/*     */     //   663: ifnonnull -> 669
/*     */     //   666: invokestatic throwNpe : ()V
/*     */     //   669: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   674: ifnull -> 842
/*     */     //   677: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   680: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   685: dup
/*     */     //   686: ifnonnull -> 692
/*     */     //   689: invokestatic throwNpe : ()V
/*     */     //   692: invokeinterface isBlocking : ()Z
/*     */     //   697: ifne -> 842
/*     */     //   700: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   703: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   708: dup
/*     */     //   709: ifnonnull -> 715
/*     */     //   712: invokestatic throwNpe : ()V
/*     */     //   715: invokeinterface isUsingItem : ()Z
/*     */     //   720: ifeq -> 842
/*     */     //   723: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   726: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   731: dup
/*     */     //   732: ifnonnull -> 738
/*     */     //   735: invokestatic throwNpe : ()V
/*     */     //   738: invokeinterface getItemInUseCount : ()I
/*     */     //   743: iconst_1
/*     */     //   744: if_icmplt -> 842
/*     */     //   747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   750: dup
/*     */     //   751: ldc_w 'mc2'
/*     */     //   754: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   757: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   760: dup
/*     */     //   761: ifnonnull -> 767
/*     */     //   764: invokestatic throwNpe : ()V
/*     */     //   767: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   770: dup
/*     */     //   771: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   774: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   777: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   780: getfield field_70461_c : I
/*     */     //   783: iconst_1
/*     */     //   784: iadd
/*     */     //   785: bipush #9
/*     */     //   787: irem
/*     */     //   788: invokespecial <init> : (I)V
/*     */     //   791: checkcast net/minecraft/network/Packet
/*     */     //   794: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   797: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   800: dup
/*     */     //   801: ldc_w 'mc2'
/*     */     //   804: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   807: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   810: dup
/*     */     //   811: ifnonnull -> 817
/*     */     //   814: invokestatic throwNpe : ()V
/*     */     //   817: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   820: dup
/*     */     //   821: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   824: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   827: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   830: getfield field_70461_c : I
/*     */     //   833: invokespecial <init> : (I)V
/*     */     //   836: checkcast net/minecraft/network/Packet
/*     */     //   839: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   842: aload_1
/*     */     //   843: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   846: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   849: if_acmpne -> 1207
/*     */     //   852: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   855: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   860: dup
/*     */     //   861: ifnonnull -> 867
/*     */     //   864: invokestatic throwNpe : ()V
/*     */     //   867: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   872: ifnull -> 1207
/*     */     //   875: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   878: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   883: dup
/*     */     //   884: ifnonnull -> 890
/*     */     //   887: invokestatic throwNpe : ()V
/*     */     //   890: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   895: dup
/*     */     //   896: ifnonnull -> 902
/*     */     //   899: invokestatic throwNpe : ()V
/*     */     //   902: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   907: ifnull -> 1207
/*     */     //   910: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   913: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   918: dup
/*     */     //   919: ifnonnull -> 925
/*     */     //   922: invokestatic throwNpe : ()V
/*     */     //   925: invokeinterface isUsingItem : ()Z
/*     */     //   930: ifeq -> 1207
/*     */     //   933: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   936: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   941: dup
/*     */     //   942: ifnonnull -> 948
/*     */     //   945: invokestatic throwNpe : ()V
/*     */     //   948: invokeinterface getItemInUseCount : ()I
/*     */     //   953: iconst_1
/*     */     //   954: if_icmplt -> 1207
/*     */     //   957: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   960: dup
/*     */     //   961: ldc_w 'mc2'
/*     */     //   964: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   967: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   970: dup
/*     */     //   971: ifnonnull -> 977
/*     */     //   974: invokestatic throwNpe : ()V
/*     */     //   977: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   980: dup
/*     */     //   981: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   984: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   987: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   990: getfield field_70461_c : I
/*     */     //   993: iconst_1
/*     */     //   994: iadd
/*     */     //   995: bipush #9
/*     */     //   997: irem
/*     */     //   998: invokespecial <init> : (I)V
/*     */     //   1001: checkcast net/minecraft/network/Packet
/*     */     //   1004: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1007: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1010: dup
/*     */     //   1011: ldc_w 'mc2'
/*     */     //   1014: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1017: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1020: dup
/*     */     //   1021: ifnonnull -> 1027
/*     */     //   1024: invokestatic throwNpe : ()V
/*     */     //   1027: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   1030: dup
/*     */     //   1031: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1034: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   1037: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   1040: getfield field_70461_c : I
/*     */     //   1043: invokespecial <init> : (I)V
/*     */     //   1046: checkcast net/minecraft/network/Packet
/*     */     //   1049: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1052: goto -> 1207
/*     */     //   1055: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1058: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1063: dup
/*     */     //   1064: ifnonnull -> 1070
/*     */     //   1067: invokestatic throwNpe : ()V
/*     */     //   1070: invokeinterface getTicksExisted : ()I
/*     */     //   1075: iconst_3
/*     */     //   1076: irem
/*     */     //   1077: ifne -> 1097
/*     */     //   1080: aload_0
/*     */     //   1081: aload_1
/*     */     //   1082: iconst_1
/*     */     //   1083: iconst_0
/*     */     //   1084: iconst_0
/*     */     //   1085: lconst_0
/*     */     //   1086: iconst_0
/*     */     //   1087: iconst_0
/*     */     //   1088: bipush #64
/*     */     //   1090: aconst_null
/*     */     //   1091: invokestatic sendPacket$default : (Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;Lnet/ccbluex/liquidbounce/event/MotionEvent;ZZZJZZILjava/lang/Object;)V
/*     */     //   1094: goto -> 1207
/*     */     //   1097: aload_0
/*     */     //   1098: aload_1
/*     */     //   1099: iconst_0
/*     */     //   1100: iconst_1
/*     */     //   1101: iconst_0
/*     */     //   1102: lconst_0
/*     */     //   1103: iconst_0
/*     */     //   1104: iconst_0
/*     */     //   1105: bipush #64
/*     */     //   1107: aconst_null
/*     */     //   1108: invokestatic sendPacket$default : (Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;Lnet/ccbluex/liquidbounce/event/MotionEvent;ZZZJZZILjava/lang/Object;)V
/*     */     //   1111: goto -> 1207
/*     */     //   1114: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1117: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1122: dup
/*     */     //   1123: ifnonnull -> 1129
/*     */     //   1126: invokestatic throwNpe : ()V
/*     */     //   1129: invokeinterface isUsingItem : ()Z
/*     */     //   1134: ifne -> 1167
/*     */     //   1137: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1140: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1145: dup
/*     */     //   1146: ifnonnull -> 1152
/*     */     //   1149: invokestatic throwNpe : ()V
/*     */     //   1152: invokeinterface isBlocking : ()Z
/*     */     //   1157: ifne -> 1167
/*     */     //   1160: aload_0
/*     */     //   1161: invokevirtual isBlock : ()Z
/*     */     //   1164: ifeq -> 1207
/*     */     //   1167: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1170: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1175: aload_0
/*     */     //   1176: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.MAIN_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   1179: invokespecial createUseItemPacket : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   1182: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1187: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1190: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1195: aload_0
/*     */     //   1196: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.OFF_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   1199: invokespecial createUseItemPacket : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   1202: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1207: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #151	-> 7
/*     */     //   #151	-> 22
/*     */     //   #152	-> 25
/*     */     //   #153	-> 52
/*     */     //   #155	-> 60
/*     */     //   #156	-> 66
/*     */     //   #159	-> 67
/*     */     //   #195	-> 168
/*     */     //   #170	-> 182
/*     */     //   #160	-> 196
/*     */     //   #164	-> 210
/*     */     //   #203	-> 224
/*     */     //   #161	-> 238
/*     */     //   #165	-> 280
/*     */     //   #166	-> 320
/*     */     //   #167	-> 360
/*     */     //   #171	-> 403
/*     */     //   #173	-> 403
/*     */     //   #171	-> 436
/*     */     //   #172	-> 482
/*     */     //   #171	-> 514
/*     */     //   #173	-> 522
/*     */     //   #175	-> 565
/*     */     //   #176	-> 573
/*     */     //   #177	-> 576
/*     */     //   #178	-> 579
/*     */     //   #176	-> 596
/*     */     //   #175	-> 601
/*     */     //   #181	-> 609
/*     */     //   #182	-> 700
/*     */     //   #183	-> 747
/*     */     //   #184	-> 797
/*     */     //   #186	-> 842
/*     */     //   #187	-> 842
/*     */     //   #188	-> 910
/*     */     //   #189	-> 957
/*     */     //   #190	-> 1007
/*     */     //   #196	-> 1055
/*     */     //   #197	-> 1080
/*     */     //   #199	-> 1097
/*     */     //   #200	-> 1111
/*     */     //   #204	-> 1114
/*     */     //   #205	-> 1167
/*     */     //   #206	-> 1175
/*     */     //   #207	-> 1176
/*     */     //   #206	-> 1179
/*     */     //   #205	-> 1182
/*     */     //   #210	-> 1187
/*     */     //   #211	-> 1195
/*     */     //   #212	-> 1196
/*     */     //   #211	-> 1199
/*     */     //   #210	-> 1202
/*     */     //   #217	-> 1207
/*     */     //   #220	-> 1207
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   60	1148	4	heldItem	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   52	1156	3	test	Z
/*     */     //   25	1183	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1208	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlow;
/*     */     //   0	1208	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*     */   private final IPacket createUseItemPacket(WEnumHand itemStack) {
/* 223 */     String str = "Not yet implemented"; boolean bool = false; throw (Throwable)new NotImplementedError("An operation is not implemented: " + str);
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 228 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 229 */     if (this.modeValue.equals("Matrix") || (this.modeValue.equals("Vulcan") && this.nextTemp)) {
/* 230 */       if ((packet instanceof net.minecraft.network.play.client.CPacketPlayerDigging || packet instanceof ICPacketPlayerBlockPlacement) && isBlocking()) {
/* 231 */         event.cancelEvent();
/*     */       }
/* 233 */       event.cancelEvent();
/* 234 */     } else if (packet instanceof net.minecraft.network.play.client.CPacketPlayer || packet instanceof net.minecraft.network.play.client.CPacketAnimation || packet instanceof net.minecraft.network.play.client.CPacketEntityAction || packet instanceof net.minecraft.network.play.client.CPacketUseEntity || packet instanceof net.minecraft.network.play.client.CPacketPlayerDigging || packet instanceof ICPacketPlayerBlockPlacement) {
/* 235 */       if (this.modeValue.equals("Vulcan") && this.waitC03 && packet instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer) {
/* 236 */         this.waitC03 = false;
/*     */         return;
/*     */       } 
/* 239 */       this.packetBuf.add((Packet<INetHandlerPlayServer>)packet);
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 245 */     Intrinsics.checkParameterIsNotNull(event, "event"); if ((this.modeValue.equals("Matrix") || this.modeValue.equals("Vulcan")) && (this.lastBlockingStat || isBlocking())) {
/* 246 */       if (this.msTimer.hasTimePassed(230L) && this.nextTemp) {
/* 247 */         this.nextTemp = false;
/*     */ 
/*     */ 
/*     */         
/* 251 */         if (EnumFacing.DOWN == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing");  MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, new WBlockPos(-1, -1, -1), (IEnumFacing)EnumFacing.DOWN);
/*     */         
/* 253 */         LinkedList<Packet<INetHandlerPlayServer>> linkedList = this.packetBuf; boolean bool = false; if (!linkedList.isEmpty()) {
/* 254 */           boolean canAttack = false;
/* 255 */           for (Packet<INetHandlerPlayServer> packet : this.packetBuf) {
/* 256 */             if (packet instanceof net.minecraft.network.play.client.CPacketPlayer) {
/* 257 */               canAttack = true;
/*     */             }
/* 259 */             if ((!(packet instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity) && !(packet instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketAnimation)) || canAttack) {
/* 260 */               PacketUtils.sendPacketNoEvent(packet);
/*     */             }
/*     */           } 
/* 263 */           this.packetBuf.clear();
/*     */         } 
/*     */       } 
/* 266 */       if (!this.nextTemp) {
/* 267 */         this.lastBlockingStat = isBlocking();
/* 268 */         if (!isBlocking()) {
/*     */           return;
/*     */         }
/* 271 */         this.nextTemp = true;
/* 272 */         this.waitC03 = this.modeValue.equals("Vulcan");
/* 273 */         this.msTimer.reset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onSlowDown(@NotNull SlowDownEvent event) {
/* 280 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getHeldItem(); IItem heldItem = (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) ? MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() : null;
/*     */     
/* 282 */     event.setForward(getMultiplier(heldItem, true));
/* 283 */     event.setStrafe(getMultiplier(heldItem, false));
/*     */   }
/*     */   
/*     */   private final float getMultiplier(IItem item, boolean isForward) {
/* 287 */     return (
/* 288 */       MinecraftInstance.classProvider.isItemFood(item) || MinecraftInstance.classProvider.isItemPotion(item) || MinecraftInstance.classProvider.isItemBucketMilk(item)) ? (
/* 289 */       isForward ? ((Number)this.consumeForwardMultiplier.get()).floatValue() : ((Number)this.consumeStrafeMultiplier.get()).floatValue()) : (
/*     */ 
/*     */       
/* 292 */       MinecraftInstance.classProvider.isItemSword(item) ? (
/* 293 */       isForward ? ((Number)this.blockForwardMultiplier.get()).floatValue() : ((Number)this.blockStrafeMultiplier.get()).floatValue()) : (
/*     */ 
/*     */       
/* 296 */       MinecraftInstance.classProvider.isItemBow(item) ? (
/* 297 */       isForward ? ((Number)this.bowForwardMultiplier.get()).floatValue() : ((Number)this.bowStrafeMultiplier.get()).floatValue()) : 
/*     */ 
/*     */       
/* 300 */       0.2F));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/* 305 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\NoSlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */