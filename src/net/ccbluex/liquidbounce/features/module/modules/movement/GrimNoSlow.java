/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.util.Random;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "GrimNoSlow", description = "Noslow", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\\\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\020\016\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\007\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\025\032\0020\026H\002J\032\020\027\032\0020\0302\b\020\031\032\004\030\0010\0322\006\020\033\032\0020\034H\002J\b\020\035\032\0020\036H\026J\020\020\037\032\0020\0362\006\020 \032\0020!H\007J\020\020\"\032\0020\0362\006\020 \032\0020#H\007J\020\020$\032\0020\0362\006\020 \032\0020%H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R\016\020\020\032\0020\013X\004¢\006\002\n\000R\021\020\021\032\0020\022¢\006\b\n\000\032\004\b\023\020\024¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/GrimNoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "blockForwardMultiplier", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "blockStrafeMultiplier", "bowForwardMultiplier", "bowStrafeMultiplier", "consumeForwardMultiplier", "consumeStrafeMultiplier", "packet", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "test", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getHytBlockpos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getMultiplier", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isForward", "", "onDisable", "", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "XSJClient"})
/*     */ public final class GrimNoSlow extends Module {
/*  24 */   private final FloatValue blockForwardMultiplier = new FloatValue("Block Forward Multiplier", 1.0F, 0.2F, 1.0F);
/*  25 */   private final FloatValue blockStrafeMultiplier = new FloatValue("Block Strafe Multiplier", 1.0F, 0.2F, 1.0F);
/*     */   
/*  27 */   private final FloatValue consumeForwardMultiplier = new FloatValue("Consume Forward Multiplier", 1.0F, 0.2F, 1.0F);
/*  28 */   private final FloatValue consumeStrafeMultiplier = new FloatValue("Consume Strafe Multiplier", 1.0F, 0.2F, 1.0F);
/*     */   
/*  30 */   private final FloatValue bowForwardMultiplier = new FloatValue("Bow Forward Multiplier", 1.0F, 0.2F, 1.0F);
/*  31 */   private final FloatValue bowStrafeMultiplier = new FloatValue("Bow Strafe Multiplier", 1.0F, 0.2F, 1.0F);
/*     */   
/*  33 */   private final BoolValue packet = new BoolValue("Packet Fix", true);
/*  34 */   private final BoolValue test = new BoolValue("SendC08", true);
/*     */   
/*     */   @NotNull
/*  37 */   private final MSTimer timer = new MSTimer(); @NotNull public final MSTimer getTimer() { return this.timer; }
/*     */   
/*     */   public void onDisable() {
/*  40 */     this.timer.reset();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  45 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.packet.get()).booleanValue()) {
/*  46 */       IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 121 */       if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  if (((PacketImpl)$this$unwrap$iv).getWrapped() instanceof net.minecraft.network.play.server.SPacketWindowItems) {
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (MinecraftInstance.mc.getThePlayer().isUsingItem())
/*     */           event.cancelEvent(); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: invokestatic isMoving : ()Z
/*     */     //   9: ifne -> 13
/*     */     //   12: return
/*     */     //   13: aload_0
/*     */     //   14: getfield packet : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   17: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   20: checkcast java/lang/Boolean
/*     */     //   23: invokevirtual booleanValue : ()Z
/*     */     //   26: ifeq -> 680
/*     */     //   29: aload_1
/*     */     //   30: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   33: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   36: if_acmpne -> 494
/*     */     //   39: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   42: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   47: dup
/*     */     //   48: ifnonnull -> 54
/*     */     //   51: invokestatic throwNpe : ()V
/*     */     //   54: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   59: dup
/*     */     //   60: ifnull -> 71
/*     */     //   63: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   68: goto -> 73
/*     */     //   71: pop
/*     */     //   72: aconst_null
/*     */     //   73: ifnull -> 494
/*     */     //   76: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   79: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   82: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   87: dup
/*     */     //   88: ifnonnull -> 94
/*     */     //   91: invokestatic throwNpe : ()V
/*     */     //   94: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   99: dup
/*     */     //   100: ifnull -> 111
/*     */     //   103: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   108: goto -> 113
/*     */     //   111: pop
/*     */     //   112: aconst_null
/*     */     //   113: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   118: ifne -> 142
/*     */     //   121: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   124: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   129: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   134: invokeinterface isKeyDown : ()Z
/*     */     //   139: ifeq -> 494
/*     */     //   142: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   145: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   148: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   153: dup
/*     */     //   154: ifnonnull -> 160
/*     */     //   157: invokestatic throwNpe : ()V
/*     */     //   160: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   165: dup
/*     */     //   166: ifnull -> 177
/*     */     //   169: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   174: goto -> 179
/*     */     //   177: pop
/*     */     //   178: aconst_null
/*     */     //   179: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   184: ifne -> 208
/*     */     //   187: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   190: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   195: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   200: invokeinterface isKeyDown : ()Z
/*     */     //   205: ifeq -> 494
/*     */     //   208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   211: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   214: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   219: dup
/*     */     //   220: ifnonnull -> 226
/*     */     //   223: invokestatic throwNpe : ()V
/*     */     //   226: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   231: dup
/*     */     //   232: ifnull -> 243
/*     */     //   235: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   240: goto -> 245
/*     */     //   243: pop
/*     */     //   244: aconst_null
/*     */     //   245: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   250: ifne -> 274
/*     */     //   253: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   256: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   261: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   266: invokeinterface isKeyDown : ()Z
/*     */     //   271: ifeq -> 494
/*     */     //   274: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   277: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   280: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   285: dup
/*     */     //   286: ifnonnull -> 292
/*     */     //   289: invokestatic throwNpe : ()V
/*     */     //   292: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   297: dup
/*     */     //   298: ifnull -> 309
/*     */     //   301: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   306: goto -> 311
/*     */     //   309: pop
/*     */     //   310: aconst_null
/*     */     //   311: invokeinterface isItemBucketMilk : (Ljava/lang/Object;)Z
/*     */     //   316: ifne -> 340
/*     */     //   319: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   322: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   327: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   332: invokeinterface isKeyDown : ()Z
/*     */     //   337: ifeq -> 494
/*     */     //   340: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   343: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   346: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   351: dup
/*     */     //   352: ifnonnull -> 358
/*     */     //   355: invokestatic throwNpe : ()V
/*     */     //   358: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   363: dup
/*     */     //   364: ifnull -> 375
/*     */     //   367: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   372: goto -> 377
/*     */     //   375: pop
/*     */     //   376: aconst_null
/*     */     //   377: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   382: ifne -> 406
/*     */     //   385: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   388: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   393: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   398: invokeinterface isKeyDown : ()Z
/*     */     //   403: ifeq -> 494
/*     */     //   406: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   409: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   414: dup
/*     */     //   415: ifnonnull -> 421
/*     */     //   418: invokestatic throwNpe : ()V
/*     */     //   421: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   426: invokeinterface getCurrentItem : ()I
/*     */     //   431: istore_2
/*     */     //   432: iload_2
/*     */     //   433: ifne -> 440
/*     */     //   436: iconst_1
/*     */     //   437: goto -> 441
/*     */     //   440: iconst_m1
/*     */     //   441: istore_3
/*     */     //   442: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   445: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   450: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   453: iload_2
/*     */     //   454: iload_3
/*     */     //   455: iadd
/*     */     //   456: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   461: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   464: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   469: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   472: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   477: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   480: iload_2
/*     */     //   481: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   486: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   489: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   494: aload_1
/*     */     //   495: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   498: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   501: if_acmpne -> 680
/*     */     //   504: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   507: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   510: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   515: dup
/*     */     //   516: ifnonnull -> 522
/*     */     //   519: invokestatic throwNpe : ()V
/*     */     //   522: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   527: dup
/*     */     //   528: ifnull -> 539
/*     */     //   531: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   536: goto -> 541
/*     */     //   539: pop
/*     */     //   540: aconst_null
/*     */     //   541: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   546: ifne -> 570
/*     */     //   549: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   552: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   557: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   562: invokeinterface isKeyDown : ()Z
/*     */     //   567: ifeq -> 680
/*     */     //   570: aload_0
/*     */     //   571: getfield test : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   574: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   577: checkcast java/lang/Boolean
/*     */     //   580: invokevirtual booleanValue : ()Z
/*     */     //   583: ifeq -> 680
/*     */     //   586: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   589: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   594: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   597: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   600: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   605: dup
/*     */     //   606: ifnonnull -> 612
/*     */     //   609: invokestatic throwNpe : ()V
/*     */     //   612: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   617: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   622: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*     */     //   627: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   630: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   635: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   638: dup
/*     */     //   639: ldc 'mc2'
/*     */     //   641: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   644: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   647: dup
/*     */     //   648: ifnonnull -> 654
/*     */     //   651: invokestatic throwNpe : ()V
/*     */     //   654: new net/ccbluex/liquidbounce/utils/block/C08PacketPlayerBlockPlacement
/*     */     //   657: dup
/*     */     //   658: aload_0
/*     */     //   659: invokespecial getHytBlockpos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   662: sipush #255
/*     */     //   665: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   668: fconst_0
/*     */     //   669: fconst_0
/*     */     //   670: fconst_0
/*     */     //   671: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;ILnet/minecraft/util/EnumHand;FFF)V
/*     */     //   674: checkcast net/minecraft/network/Packet
/*     */     //   677: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   680: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #56	-> 6
/*     */     //   #57	-> 12
/*     */     //   #59	-> 13
/*     */     //   #60	-> 29
/*     */     //   #61	-> 29
/*     */     //   #62	-> 29
/*     */     //   #63	-> 29
/*     */     //   #64	-> 29
/*     */     //   #65	-> 29
/*     */     //   #61	-> 76
/*     */     //   #62	-> 142
/*     */     //   #63	-> 208
/*     */     //   #64	-> 274
/*     */     //   #65	-> 340
/*     */     //   #66	-> 406
/*     */     //   #67	-> 432
/*     */     //   #68	-> 442
/*     */     //   #69	-> 469
/*     */     //   #72	-> 494
/*     */     //   #73	-> 570
/*     */     //   #74	-> 586
/*     */     //   #75	-> 635
/*     */     //   #76	-> 654
/*     */     //   #77	-> 658
/*     */     //   #78	-> 665
/*     */     //   #76	-> 671
/*     */     //   #75	-> 677
/*     */     //   #84	-> 680
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   442	52	3	spoof	I
/*     */     //   432	62	2	curSlot	I
/*     */     //   0	681	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/GrimNoSlow;
/*     */     //   0	681	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onSlowDown(@NotNull SlowDownEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     MinecraftInstance.mc.getThePlayer().getHeldItem();
/*     */     IItem heldItem = (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) ? MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() : null;
/*     */     event.setForward(getMultiplier(heldItem, true));
/*     */     event.setStrafe(getMultiplier(heldItem, false));
/*     */   }
/*     */   
/*     */   private final float getMultiplier(IItem item, boolean isForward) {
/*     */     return (MinecraftInstance.classProvider.isItemFood(item) || MinecraftInstance.classProvider.isItemPotion(item) || MinecraftInstance.classProvider.isItemBucketMilk(item)) ? (isForward ? ((Number)this.consumeForwardMultiplier.get()).floatValue() : ((Number)this.consumeStrafeMultiplier.get()).floatValue()) : (MinecraftInstance.classProvider.isItemSword(item) ? (isForward ? ((Number)this.blockForwardMultiplier.get()).floatValue() : ((Number)this.blockStrafeMultiplier.get()).floatValue()) : (MinecraftInstance.classProvider.isItemBow(item) ? (isForward ? ((Number)this.bowForwardMultiplier.get()).floatValue() : ((Number)this.bowStrafeMultiplier.get()).floatValue()) : 0.2F));
/*     */   }
/*     */   
/*     */   private final WBlockPos getHytBlockpos() {
/*     */     Random random = new Random();
/*     */     int dx = WMathHelper.floor_double(random.nextDouble() / 'Ϩ' + '଄');
/*     */     int jy = WMathHelper.floor_double(random.nextDouble() / 100 * 0.20000000298023224D);
/*     */     int kz = WMathHelper.floor_double(random.nextDouble() / 'Ϩ' + '଄');
/*     */     return new WBlockPos(dx, -jy % 255, kz);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return "GrimAC";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\GrimNoSlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */