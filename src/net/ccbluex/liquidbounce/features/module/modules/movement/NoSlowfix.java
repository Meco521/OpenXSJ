/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.util.LinkedList;
/*     */ import java.util.concurrent.LinkedBlockingDeque;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import net.minecraft.network.play.client.CPacketClickWindow;
/*     */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*     */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*     */ import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
/*     */ import net.minecraft.network.play.server.SPacketWindowItems;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "XSJNoSlowfix", description = "fix版noslow by：凡哥", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\003\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\032\020&\032\0020'2\b\020(\032\004\030\0010)2\006\020*\032\0020\tH\002J\b\020+\032\0020,H\026J\020\020-\032\0020,2\006\020.\032\0020/H\007J\020\0200\032\0020,2\006\020.\032\00201H\007J\020\0202\032\0020,2\006\020.\032\00203H\007J\020\0204\032\0020,2\006\020.\032\00205H\007R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\013X\004¢\006\002\n\000R\016\020\r\032\0020\013X\004¢\006\002\n\000R\016\020\016\032\0020\013X\004¢\006\002\n\000R\020\020\017\032\004\030\0010\020X\016¢\006\002\n\000R\016\020\021\032\0020\013X\004¢\006\002\n\000R\016\020\022\032\0020\013X\004¢\006\002\n\000R\016\020\023\032\0020\007X\004¢\006\002\n\000R\016\020\024\032\0020\tX\016¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\016\020\031\032\0020\tX\016¢\006\002\n\000R\032\020\032\032\016\022\n\022\b\022\004\022\0020\0350\0340\033X\016¢\006\002\n\000R\016\020\036\032\0020\tX\016¢\006\002\n\000R\021\020\037\032\0020\007¢\006\b\n\000\032\004\b \020!R\024\020\"\032\0020#8VX\004¢\006\006\032\004\b$\020%¨\0066"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlowfix;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "badPacket", "Ljava/util/concurrent/LinkedBlockingDeque;", "Lnet/minecraft/network/play/server/SPacketWindowItems;", "better", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "blinking", "", "blockForwardMultiplier", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "blockStrafeMultiplier", "bowForwardMultiplier", "bowStrafeMultiplier", "c08", "Lnet/minecraft/network/play/client/CPacketPlayerTryUseItem;", "consumeForwardMultiplier", "consumeStrafeMultiplier", "debug", "lastBlockingStat", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "noRev", "packetBuf", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "send", "soulsandValue", "getSoulsandValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "getMultiplier", "", "item", "Lnet/minecraft/item/Item;", "isForward", "onEnable", "", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class NoSlowfix extends Module {
/*  39 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Basic", "NoPacket", "GrimAC", "HuaYuTing", "Spoof", "Watchdog", "NewNCP", "HYTPit" }, "Basic");
/*     */ 
/*     */ 
/*     */   
/*  43 */   private final FloatValue blockForwardMultiplier = new FloatValue("BlockForwardMultiplier", 1.0F, 0.2F, 1.0F);
/*  44 */   private final FloatValue blockStrafeMultiplier = new FloatValue("BlockStrafeMultiplier", 1.0F, 0.2F, 1.0F);
/*     */   
/*  46 */   private final FloatValue consumeForwardMultiplier = new FloatValue("ConsumeForwardMultiplier", 1.0F, 0.2F, 1.0F);
/*  47 */   private final FloatValue consumeStrafeMultiplier = new FloatValue("ConsumeStrafeMultiplier", 1.0F, 0.2F, 1.0F);
/*     */   
/*  49 */   private final FloatValue bowForwardMultiplier = new FloatValue("BowForwardMultiplier", 1.0F, 0.2F, 1.0F);
/*  50 */   private final FloatValue bowStrafeMultiplier = new FloatValue("BowStrafeMultiplier", 1.0F, 0.2F, 1.0F);
/*     */   
/*  52 */   private final BoolValue better = new BoolValue("Better-Check", false);
/*  53 */   private final BoolValue debug = new BoolValue("Debug", false);
/*     */   
/*  55 */   private final MSTimer msTimer = new MSTimer();
/*  56 */   private final LinkedBlockingDeque<SPacketWindowItems> badPacket = new LinkedBlockingDeque<>();
/*  57 */   private LinkedList<Packet<INetHandlerPlayServer>> packetBuf = new LinkedList<>();
/*     */   
/*     */   private CPacketPlayerTryUseItem c08;
/*     */   private boolean send;
/*     */   private boolean noRev;
/*     */   private boolean lastBlockingStat;
/*     */   private boolean blinking;
/*     */   @NotNull
/*  65 */   private final BoolValue soulsandValue = new BoolValue("Soulsand", true); @NotNull public final BoolValue getSoulsandValue() { return this.soulsandValue; }
/*     */   
/*     */   public void onEnable() {
/*  68 */     this.msTimer.reset();
/*  69 */     this.c08 = (CPacketPlayerTryUseItem)null;
/*  70 */     this.send = false;
/*  71 */     this.blinking = false;
/*  72 */     this.noRev = false;
/*  73 */     this.badPacket.clear();
/*  74 */     this.packetBuf.clear();
/*  75 */     this.lastBlockingStat = false;
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
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   9: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   12: dup
/*     */     //   13: ldc 'mc2.player'
/*     */     //   15: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   18: invokevirtual func_184585_cz : ()Z
/*     */     //   21: ifne -> 42
/*     */     //   24: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   27: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   30: dup
/*     */     //   31: ldc 'mc2.player'
/*     */     //   33: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   36: invokevirtual func_184587_cr : ()Z
/*     */     //   39: ifeq -> 48
/*     */     //   42: invokestatic isMoving : ()Z
/*     */     //   45: ifne -> 65
/*     */     //   48: aload_0
/*     */     //   49: getfield better : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   52: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   55: checkcast java/lang/Boolean
/*     */     //   58: invokevirtual booleanValue : ()Z
/*     */     //   61: ifeq -> 65
/*     */     //   64: return
/*     */     //   65: aload_0
/*     */     //   66: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   69: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   72: checkcast java/lang/Boolean
/*     */     //   75: invokevirtual booleanValue : ()Z
/*     */     //   78: ifeq -> 126
/*     */     //   81: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   84: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   87: getfield field_70173_aa : I
/*     */     //   90: bipush #10
/*     */     //   92: irem
/*     */     //   93: ifne -> 126
/*     */     //   96: new java/lang/StringBuilder
/*     */     //   99: dup
/*     */     //   100: invokespecial <init> : ()V
/*     */     //   103: ldc 'NoSlow -> Slowdown:'
/*     */     //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   108: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   111: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   114: getfield field_70173_aa : I
/*     */     //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   120: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   123: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   126: aload_0
/*     */     //   127: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   130: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   133: checkcast java/lang/String
/*     */     //   136: astore_2
/*     */     //   137: iconst_0
/*     */     //   138: istore_3
/*     */     //   139: aload_2
/*     */     //   140: dup
/*     */     //   141: ifnonnull -> 154
/*     */     //   144: new kotlin/TypeCastException
/*     */     //   147: dup
/*     */     //   148: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   150: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   153: athrow
/*     */     //   154: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   157: dup
/*     */     //   158: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   160: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   163: astore_2
/*     */     //   164: aload_2
/*     */     //   165: invokevirtual hashCode : ()I
/*     */     //   168: lookupswitch default -> 922, -1777040898 -> 236, -1048831045 -> 224, 93508654 -> 248, 545151501 -> 212
/*     */     //   212: aload_2
/*     */     //   213: ldc 'watchdog'
/*     */     //   215: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   218: ifeq -> 922
/*     */     //   221: goto -> 656
/*     */     //   224: aload_2
/*     */     //   225: ldc 'newncp'
/*     */     //   227: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   230: ifeq -> 922
/*     */     //   233: goto -> 819
/*     */     //   236: aload_2
/*     */     //   237: ldc 'huayuting'
/*     */     //   239: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   242: ifeq -> 922
/*     */     //   245: goto -> 305
/*     */     //   248: aload_2
/*     */     //   249: ldc 'basic'
/*     */     //   251: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   254: ifeq -> 922
/*     */     //   257: aload_1
/*     */     //   258: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   261: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   264: if_acmpne -> 922
/*     */     //   267: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   270: dup
/*     */     //   271: ldc 'mc2'
/*     */     //   273: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   276: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   279: dup
/*     */     //   280: ifnonnull -> 286
/*     */     //   283: invokestatic throwNpe : ()V
/*     */     //   286: new net/minecraft/network/play/client/CPacketPlayerTryUseItem
/*     */     //   289: dup
/*     */     //   290: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   293: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*     */     //   296: checkcast net/minecraft/network/Packet
/*     */     //   299: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   302: goto -> 922
/*     */     //   305: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   308: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   313: dup
/*     */     //   314: ifnonnull -> 320
/*     */     //   317: invokestatic throwNpe : ()V
/*     */     //   320: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   325: dup
/*     */     //   326: ifnonnull -> 332
/*     */     //   329: invokestatic throwNpe : ()V
/*     */     //   332: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   337: ifnull -> 410
/*     */     //   340: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   343: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   348: dup
/*     */     //   349: ifnonnull -> 355
/*     */     //   352: invokestatic throwNpe : ()V
/*     */     //   355: invokeinterface isUsingItem : ()Z
/*     */     //   360: ifeq -> 410
/*     */     //   363: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   366: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   369: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   374: dup
/*     */     //   375: ifnonnull -> 381
/*     */     //   378: invokestatic throwNpe : ()V
/*     */     //   381: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   386: dup
/*     */     //   387: ifnonnull -> 393
/*     */     //   390: invokestatic throwNpe : ()V
/*     */     //   393: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   398: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   403: ifeq -> 410
/*     */     //   406: iconst_1
/*     */     //   407: goto -> 411
/*     */     //   410: iconst_0
/*     */     //   411: istore_3
/*     */     //   412: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   415: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   420: dup
/*     */     //   421: ifnonnull -> 427
/*     */     //   424: invokestatic throwNpe : ()V
/*     */     //   427: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   432: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   437: astore #5
/*     */     //   439: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.MAIN_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   442: astore #6
/*     */     //   444: iconst_0
/*     */     //   445: istore #7
/*     */     //   447: nop
/*     */     //   448: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   451: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   454: aload #6
/*     */     //   456: invokeinterface createCPacketTryUseItem : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;
/*     */     //   461: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   464: nop
/*     */     //   465: astore #4
/*     */     //   467: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   470: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   475: dup
/*     */     //   476: ifnonnull -> 482
/*     */     //   479: invokestatic throwNpe : ()V
/*     */     //   482: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   487: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   492: astore #6
/*     */     //   494: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.OFF_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   497: astore #7
/*     */     //   499: iconst_0
/*     */     //   500: istore #8
/*     */     //   502: nop
/*     */     //   503: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   506: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   509: aload #7
/*     */     //   511: invokeinterface createCPacketTryUseItem : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;
/*     */     //   516: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   519: nop
/*     */     //   520: astore #5
/*     */     //   522: aload_1
/*     */     //   523: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   526: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   529: if_acmpne -> 577
/*     */     //   532: iload_3
/*     */     //   533: ifeq -> 577
/*     */     //   536: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   539: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   544: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   547: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   550: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*     */     //   553: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   556: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   559: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   562: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   567: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   572: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   577: aload_1
/*     */     //   578: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   581: getstatic net/ccbluex/liquidbounce/event/EventState.POST : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   584: if_acmpne -> 922
/*     */     //   587: iload_3
/*     */     //   588: ifeq -> 922
/*     */     //   591: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   594: dup
/*     */     //   595: ldc 'mc2'
/*     */     //   597: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   600: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   603: dup
/*     */     //   604: ifnonnull -> 610
/*     */     //   607: invokestatic throwNpe : ()V
/*     */     //   610: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   613: dup
/*     */     //   614: invokespecial <init> : ()V
/*     */     //   617: checkcast net/minecraft/network/Packet
/*     */     //   620: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   623: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   626: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   631: aload #4
/*     */     //   633: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   638: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   641: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   646: aload #5
/*     */     //   648: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   653: goto -> 922
/*     */     //   656: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   659: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   662: dup
/*     */     //   663: ldc 'mc2.player'
/*     */     //   665: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   668: invokevirtual func_184585_cz : ()Z
/*     */     //   671: ifne -> 675
/*     */     //   674: return
/*     */     //   675: aload_1
/*     */     //   676: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   679: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   682: if_acmpne -> 781
/*     */     //   685: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   688: dup
/*     */     //   689: ldc 'mc2'
/*     */     //   691: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   694: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   697: dup
/*     */     //   698: ifnonnull -> 704
/*     */     //   701: invokestatic throwNpe : ()V
/*     */     //   704: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   707: dup
/*     */     //   708: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   711: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   714: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   717: getfield field_70461_c : I
/*     */     //   720: bipush #8
/*     */     //   722: irem
/*     */     //   723: iconst_1
/*     */     //   724: iadd
/*     */     //   725: invokespecial <init> : (I)V
/*     */     //   728: checkcast net/minecraft/network/Packet
/*     */     //   731: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   734: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   737: dup
/*     */     //   738: ldc 'mc2'
/*     */     //   740: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   743: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   746: dup
/*     */     //   747: ifnonnull -> 753
/*     */     //   750: invokestatic throwNpe : ()V
/*     */     //   753: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   756: dup
/*     */     //   757: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   760: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   763: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   766: getfield field_70461_c : I
/*     */     //   769: invokespecial <init> : (I)V
/*     */     //   772: checkcast net/minecraft/network/Packet
/*     */     //   775: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   778: goto -> 922
/*     */     //   781: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   784: dup
/*     */     //   785: ldc 'mc2'
/*     */     //   787: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   790: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   793: dup
/*     */     //   794: ifnonnull -> 800
/*     */     //   797: invokestatic throwNpe : ()V
/*     */     //   800: new net/minecraft/network/play/client/CPacketPlayerTryUseItem
/*     */     //   803: dup
/*     */     //   804: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   807: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*     */     //   810: checkcast net/minecraft/network/Packet
/*     */     //   813: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   816: goto -> 922
/*     */     //   819: aload_1
/*     */     //   820: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   823: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   826: if_acmpne -> 922
/*     */     //   829: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   832: dup
/*     */     //   833: ldc 'mc2'
/*     */     //   835: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   838: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   841: dup
/*     */     //   842: ifnonnull -> 848
/*     */     //   845: invokestatic throwNpe : ()V
/*     */     //   848: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   851: dup
/*     */     //   852: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   855: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   858: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   861: getfield field_70461_c : I
/*     */     //   864: bipush #8
/*     */     //   866: irem
/*     */     //   867: iconst_1
/*     */     //   868: iadd
/*     */     //   869: invokespecial <init> : (I)V
/*     */     //   872: checkcast net/minecraft/network/Packet
/*     */     //   875: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   878: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   881: dup
/*     */     //   882: ldc 'mc2'
/*     */     //   884: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   887: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   890: dup
/*     */     //   891: ifnonnull -> 897
/*     */     //   894: invokestatic throwNpe : ()V
/*     */     //   897: new net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   900: dup
/*     */     //   901: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   904: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   907: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*     */     //   910: getfield field_70461_c : I
/*     */     //   913: invokespecial <init> : (I)V
/*     */     //   916: checkcast net/minecraft/network/Packet
/*     */     //   919: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   922: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #80	-> 6
/*     */     //   #81	-> 64
/*     */     //   #83	-> 65
/*     */     //   #85	-> 126
/*     */     //   #117	-> 212
/*     */     //   #126	-> 224
/*     */     //   #89	-> 236
/*     */     //   #86	-> 248
/*     */     //   #87	-> 257
/*     */     //   #90	-> 305
/*     */     //   #91	-> 305
/*     */     //   #90	-> 411
/*     */     //   #92	-> 412
/*     */     //   #93	-> 412
/*     */     //   #94	-> 412
/*     */     //   #95	-> 439
/*     */     //   #93	-> 444
/*     */     //   #253	-> 447
/*     */     //   #254	-> 447
/*     */     //   #257	-> 448
/*     */     //   #254	-> 464
/*     */     //   #92	-> 465
/*     */     //   #97	-> 467
/*     */     //   #98	-> 467
/*     */     //   #99	-> 467
/*     */     //   #100	-> 494
/*     */     //   #98	-> 499
/*     */     //   #258	-> 502
/*     */     //   #259	-> 502
/*     */     //   #262	-> 503
/*     */     //   #259	-> 519
/*     */     //   #97	-> 520
/*     */     //   #103	-> 522
/*     */     //   #104	-> 536
/*     */     //   #105	-> 544
/*     */     //   #106	-> 547
/*     */     //   #107	-> 550
/*     */     //   #105	-> 567
/*     */     //   #104	-> 572
/*     */     //   #111	-> 577
/*     */     //   #112	-> 591
/*     */     //   #113	-> 623
/*     */     //   #114	-> 638
/*     */     //   #118	-> 656
/*     */     //   #119	-> 675
/*     */     //   #120	-> 685
/*     */     //   #121	-> 734
/*     */     //   #123	-> 781
/*     */     //   #124	-> 816
/*     */     //   #127	-> 819
/*     */     //   #128	-> 829
/*     */     //   #129	-> 878
/*     */     //   #132	-> 922
/*     */     //   #133	-> 922
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   444	21	5	itemStack$iv	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   444	21	6	hand$iv	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   447	18	7	$i$f$createUseItemPacket	I
/*     */     //   499	21	6	itemStack$iv	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   499	21	7	hand$iv	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   502	18	8	$i$f$createUseItemPacket	I
/*     */     //   522	131	5	blockPlace2	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   467	186	4	blockPlace1	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   412	241	3	item	Z
/*     */     //   0	923	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoSlowfix;
/*     */     //   0	923	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 137 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1237647439:
/* 138 */         if (str.equals("grimac")) {
/* 139 */           if (this.msTimer.hasTimePassed(230L) && this.blinking) {
/* 140 */             this.blinking = false;
/* 141 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -1, -1), EnumFacing.DOWN));
/* 142 */             LinkedList<Packet<INetHandlerPlayServer>> linkedList = this.packetBuf; boolean bool1 = false; if (!linkedList.isEmpty()) {
/* 143 */               boolean canAttack = false;
/* 144 */               for (Packet<INetHandlerPlayServer> packet : this.packetBuf) {
/* 145 */                 if (packet instanceof net.minecraft.network.play.client.CPacketPlayer) {
/* 146 */                   canAttack = true;
/*     */                 }
/* 148 */                 if ((!(packet instanceof net.minecraft.network.play.client.CPacketUseEntity) && !(packet instanceof net.minecraft.network.play.client.CPacketAnimation)) || canAttack) {
/* 149 */                   Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a(packet);
/*     */                 } 
/*     */               } 
/* 152 */               this.packetBuf.clear();
/*     */             } 
/*     */           } 
/*     */           
/* 156 */           if (!this.blinking) {
/* 157 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); this.lastBlockingStat = MinecraftInstance.mc2.field_71439_g.func_184585_cz();
/* 158 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (!MinecraftInstance.mc2.field_71439_g.func_184585_cz()) {
/*     */               return;
/*     */             }
/* 161 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
/* 162 */             this.blinking = true;
/* 163 */             this.msTimer.reset();
/*     */           } 
/*     */         } 
/*     */         break; }
/*     */   
/*     */   }
/*     */   @EventTarget
/*     */   public final void onSlowDown(@NotNull SlowDownEvent event) {
/* 171 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc2.field_71439_g == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_184614_ca(), "mc2.player!!.heldItemMainhand"); Item heldItemMainhand = MinecraftInstance.mc2.field_71439_g.func_184614_ca().func_77973_b();
/*     */     
/* 173 */     event.setForward(getMultiplier(heldItemMainhand, true));
/* 174 */     event.setStrafe(getMultiplier(heldItemMainhand, false));
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 179 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null || MinecraftInstance.mc.getTheWorld() == null)
/*     */       return; 
/* 181 */     IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0; Packet<INetHandlerPlayServer> packet = (
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 263 */       (PacketImpl)$this$unwrap$iv).getWrapped();
/*     */     String str = (String)this.modeValue.get();
/*     */     $i$f$unwrap = 0;
/*     */     if (str == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str = str.toLowerCase();
/*     */     switch (str.hashCode()) {
/*     */       case 109651721:
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_184614_ca(), "mc2.player.heldItemMainhand");
/*     */         if (str.equals("spoof") && packet instanceof CPacketPlayerTryUseItem && ((CPacketPlayerTryUseItem)packet).func_187028_a() == EnumHand.MAIN_HAND && MinecraftInstance.mc2.field_71439_g.func_184614_ca().func_77973_b() instanceof net.minecraft.item.ItemSword)
/*     */           event.cancelEvent(); 
/*     */         break;
/*     */       case -1777040898:
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_184614_ca(), "mc2.player.heldItemMainhand");
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_184614_ca(), "mc2.player.heldItemMainhand");
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g.func_184614_ca(), "mc2.player.heldItemMainhand");
/*     */         if (str.equals("huayuting") && (MinecraftInstance.mc2.field_71439_g.func_184614_ca().func_77973_b() instanceof net.minecraft.item.ItemFood || MinecraftInstance.mc2.field_71439_g.func_184614_ca().func_77973_b() instanceof net.minecraft.item.ItemBow || MinecraftInstance.mc2.field_71439_g.func_184614_ca().func_77973_b() instanceof net.minecraft.item.ItemPotion)) {
/*     */           if (packet instanceof CPacketPlayerTryUseItem && !this.noRev) {
/*     */             event.cancelEvent();
/*     */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */             if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketClickWindow(0, 36, 0, ClickType.SWAP, new ItemStack(Block.func_149729_e(166)), (short)0));
/*     */             this.c08 = (CPacketPlayerTryUseItem)packet;
/*     */           } 
/*     */           if (packet instanceof CPacketPlayerDigging && ((CPacketPlayerDigging)packet).func_180762_c() == CPacketPlayerDigging.Action.RELEASE_USE_ITEM)
/*     */             this.send = true; 
/*     */           if (packet instanceof SPacketWindowItems) {
/*     */             event.cancelEvent();
/*     */             this.badPacket.add(packet);
/*     */             if (this.c08 != null) {
/*     */               this.noRev = true;
/*     */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */               if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketConfirmTransaction());
/*     */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */               if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               if (this.c08 == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)this.c08);
/*     */               this.noRev = false;
/*     */               this.c08 = (CPacketPlayerTryUseItem)null;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       case -1237647439:
/*     */         if (str.equals("grimac") && this.blinking) {
/*     */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player");
/*     */           if ((packet instanceof CPacketPlayerDigging || packet instanceof CPacketPlayerTryUseItem) && MinecraftInstance.mc2.field_71439_g.func_184585_cz()) {
/*     */             event.cancelEvent();
/*     */             break;
/*     */           } 
/*     */           if (packet instanceof net.minecraft.network.play.client.CPacketPlayer || packet instanceof net.minecraft.network.play.client.CPacketAnimation || packet instanceof net.minecraft.network.play.client.CPacketEntityAction || packet instanceof net.minecraft.network.play.client.CPacketUseEntity || packet instanceof CPacketPlayerDigging || packet instanceof CPacketPlayerTryUseItem) {
/*     */             this.packetBuf.add(packet);
/*     */             event.cancelEvent();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private final float getMultiplier(Item item, boolean isForward) {
/*     */     Item item1 = item;
/*     */     return (item1 instanceof net.minecraft.item.ItemFood || item1 instanceof net.minecraft.item.ItemPotion || item1 instanceof net.minecraft.item.ItemBucketMilk) ? (isForward ? ((Number)this.consumeForwardMultiplier.get()).floatValue() : ((Number)this.consumeStrafeMultiplier.get()).floatValue()) : ((item1 instanceof net.minecraft.item.ItemSword) ? (isForward ? ((Number)this.blockForwardMultiplier.get()).floatValue() : ((Number)this.blockStrafeMultiplier.get()).floatValue()) : ((item1 instanceof net.minecraft.item.ItemBow) ? (isForward ? ((Number)this.bowForwardMultiplier.get()).floatValue() : ((Number)this.bowStrafeMultiplier.get()).floatValue()) : 0.2F));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\NoSlowfix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */