/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "NewHYTNoSlow", description = "Bypass Hyt", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000^\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\b\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\005\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\032\020\027\032\0020\0302\b\020\031\032\004\030\0010\0322\006\020\033\032\0020\bH\002J\b\020\034\032\0020\035H\026J\020\020\036\032\0020\0352\006\020\037\032\0020 H\007J\020\020!\032\0020\0352\006\020\037\032\0020\"H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000R\032\020\013\032\016\022\n\022\b\022\004\022\0020\0160\r0\fX\016¢\006\002\n\000R\016\020\017\032\0020\bX\016¢\006\002\n\000R\016\020\020\032\0020\bX\016¢\006\002\n\000R\024\020\021\032\0020\0228VX\004¢\006\006\032\004\b\023\020\024R\016\020\025\032\0020\006X\004¢\006\002\n\000R\016\020\026\032\0020\bX\016¢\006\002\n\000¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NewHYTNoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "nextTemp", "", "packet", "", "packetBuf", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "pendingFlagApplyPacket", "sendBuf", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "waitC03", "getMultiplier", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isForward", "onDisable", "", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "XSJClient"})
/*     */ public final class NewHYTNoSlow
/*     */   extends Module
/*     */ {
/*  28 */   private final ListValue modeValue = new ListValue(
/*  29 */       "PacketMode", 
/*  30 */       new String[] { "Hyt-Normal", "Hyt-Vanilla", "Hyt-Fast", "Hyt-Legit"
/*  31 */       }, "Hyt-Vanilla");
/*     */   
/*  33 */   private final MSTimer timer = new MSTimer();
/*     */   private boolean pendingFlagApplyPacket;
/*  35 */   private final MSTimer msTimer = new MSTimer();
/*     */   private boolean sendBuf;
/*  37 */   private LinkedList<Packet<INetHandlerPlayServer>> packetBuf = new LinkedList<>();
/*     */   
/*     */   private boolean nextTemp;
/*     */   
/*     */   public void onDisable() {
/*  42 */     this.timer.reset();
/*  43 */     this.msTimer.reset();
/*  44 */     this.pendingFlagApplyPacket = false;
/*  45 */     this.sendBuf = false;
/*  46 */     this.packetBuf.clear();
/*  47 */     this.nextTemp = false;
/*  48 */     this.waitC03 = false;
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
/*     */   private boolean waitC03;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int packet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     //   6: invokestatic isMoving : ()Z
/*     */     //   9: ifne -> 13
/*     */     //   12: return
/*     */     //   13: aload_0
/*     */     //   14: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   17: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   20: checkcast java/lang/String
/*     */     //   23: astore_2
/*     */     //   24: iconst_0
/*     */     //   25: istore_3
/*     */     //   26: aload_2
/*     */     //   27: dup
/*     */     //   28: ifnonnull -> 41
/*     */     //   31: new kotlin/TypeCastException
/*     */     //   34: dup
/*     */     //   35: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   37: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   40: athrow
/*     */     //   41: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   44: dup
/*     */     //   45: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   47: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   50: astore_2
/*     */     //   51: aload_2
/*     */     //   52: invokevirtual hashCode : ()I
/*     */     //   55: lookupswitch default -> 1571, -1602642193 -> 108, -51880346 -> 132, 1924524145 -> 96, 1931157809 -> 120
/*     */     //   96: aload_2
/*     */     //   97: ldc 'hyt-normal'
/*     */     //   99: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   102: ifeq -> 1571
/*     */     //   105: goto -> 144
/*     */     //   108: aload_2
/*     */     //   109: ldc 'hyt-legit'
/*     */     //   111: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   114: ifeq -> 1571
/*     */     //   117: goto -> 1296
/*     */     //   120: aload_2
/*     */     //   121: ldc 'hyt-vanilla'
/*     */     //   123: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   126: ifeq -> 1571
/*     */     //   129: goto -> 1457
/*     */     //   132: aload_2
/*     */     //   133: ldc 'hyt-fast'
/*     */     //   135: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   138: ifeq -> 1571
/*     */     //   141: goto -> 704
/*     */     //   144: aload_1
/*     */     //   145: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   148: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   151: if_acmpne -> 278
/*     */     //   154: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   157: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   162: dup
/*     */     //   163: ifnonnull -> 169
/*     */     //   166: invokestatic throwNpe : ()V
/*     */     //   169: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   174: ifnull -> 278
/*     */     //   177: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   180: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   185: dup
/*     */     //   186: ifnonnull -> 192
/*     */     //   189: invokestatic throwNpe : ()V
/*     */     //   192: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   197: dup
/*     */     //   198: ifnonnull -> 204
/*     */     //   201: invokestatic throwNpe : ()V
/*     */     //   204: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   209: ifnull -> 278
/*     */     //   212: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   215: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   220: dup
/*     */     //   221: ifnonnull -> 227
/*     */     //   224: invokestatic throwNpe : ()V
/*     */     //   227: invokeinterface isBlocking : ()Z
/*     */     //   232: ifne -> 278
/*     */     //   235: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   238: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   241: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   246: dup
/*     */     //   247: ifnonnull -> 253
/*     */     //   250: invokestatic throwNpe : ()V
/*     */     //   253: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   258: dup
/*     */     //   259: ifnonnull -> 265
/*     */     //   262: invokestatic throwNpe : ()V
/*     */     //   265: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   270: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   275: ifne -> 321
/*     */     //   278: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   281: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   284: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   289: dup
/*     */     //   290: ifnonnull -> 296
/*     */     //   293: invokestatic throwNpe : ()V
/*     */     //   296: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   301: dup
/*     */     //   302: ifnonnull -> 308
/*     */     //   305: invokestatic throwNpe : ()V
/*     */     //   308: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   313: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   318: ifeq -> 529
/*     */     //   321: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   324: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   329: dup
/*     */     //   330: ifnonnull -> 336
/*     */     //   333: invokestatic throwNpe : ()V
/*     */     //   336: invokeinterface getOnGround : ()Z
/*     */     //   341: ifeq -> 529
/*     */     //   344: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   347: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   352: dup
/*     */     //   353: ifnonnull -> 359
/*     */     //   356: invokestatic throwNpe : ()V
/*     */     //   359: invokeinterface isUsingItem : ()Z
/*     */     //   364: ifeq -> 529
/*     */     //   367: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   370: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   375: dup
/*     */     //   376: ifnonnull -> 382
/*     */     //   379: invokestatic throwNpe : ()V
/*     */     //   382: invokeinterface getItemInUseCount : ()I
/*     */     //   387: iconst_1
/*     */     //   388: if_icmplt -> 529
/*     */     //   391: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   394: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   399: dup
/*     */     //   400: ifnonnull -> 406
/*     */     //   403: invokestatic throwNpe : ()V
/*     */     //   406: invokeinterface getSprinting : ()Z
/*     */     //   411: ifeq -> 458
/*     */     //   414: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   417: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   422: dup
/*     */     //   423: ifnonnull -> 429
/*     */     //   426: invokestatic throwNpe : ()V
/*     */     //   429: invokeinterface getOnGround : ()Z
/*     */     //   434: ifne -> 458
/*     */     //   437: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   440: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   445: dup
/*     */     //   446: ifnonnull -> 452
/*     */     //   449: invokestatic throwNpe : ()V
/*     */     //   452: iconst_0
/*     */     //   453: invokeinterface setSprinting : (Z)V
/*     */     //   458: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   461: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   466: dup
/*     */     //   467: ifnonnull -> 473
/*     */     //   470: invokestatic throwNpe : ()V
/*     */     //   473: invokeinterface getTicksExisted : ()I
/*     */     //   478: iconst_2
/*     */     //   479: irem
/*     */     //   480: ifne -> 507
/*     */     //   483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   486: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   491: dup
/*     */     //   492: ifnonnull -> 498
/*     */     //   495: invokestatic throwNpe : ()V
/*     */     //   498: iconst_0
/*     */     //   499: invokeinterface setSprinting : (Z)V
/*     */     //   504: goto -> 528
/*     */     //   507: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   510: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   515: dup
/*     */     //   516: ifnonnull -> 522
/*     */     //   519: invokestatic throwNpe : ()V
/*     */     //   522: iconst_1
/*     */     //   523: invokeinterface setSprinting : (Z)V
/*     */     //   528: return
/*     */     //   529: aload_1
/*     */     //   530: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   533: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   536: if_acmpne -> 1571
/*     */     //   539: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   542: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   545: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   550: dup
/*     */     //   551: ifnonnull -> 557
/*     */     //   554: invokestatic throwNpe : ()V
/*     */     //   557: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   562: dup
/*     */     //   563: ifnonnull -> 569
/*     */     //   566: invokestatic throwNpe : ()V
/*     */     //   569: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   574: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   579: ifeq -> 1571
/*     */     //   582: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   585: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   590: fconst_1
/*     */     //   591: invokeinterface setTimerSpeed : (F)V
/*     */     //   596: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   599: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   604: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   607: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   610: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*     */     //   613: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   616: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   619: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   622: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   627: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   632: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   637: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   640: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   645: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   648: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   651: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   656: dup
/*     */     //   657: ifnonnull -> 663
/*     */     //   660: invokestatic throwNpe : ()V
/*     */     //   663: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   668: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   673: dup
/*     */     //   674: ifnonnull -> 688
/*     */     //   677: new kotlin/TypeCastException
/*     */     //   680: dup
/*     */     //   681: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemStack'
/*     */     //   684: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   687: athrow
/*     */     //   688: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*     */     //   693: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   696: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   701: goto -> 1571
/*     */     //   704: aload_1
/*     */     //   705: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   708: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   711: if_acmpne -> 838
/*     */     //   714: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   717: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   722: dup
/*     */     //   723: ifnonnull -> 729
/*     */     //   726: invokestatic throwNpe : ()V
/*     */     //   729: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   734: ifnull -> 838
/*     */     //   737: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   740: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   745: dup
/*     */     //   746: ifnonnull -> 752
/*     */     //   749: invokestatic throwNpe : ()V
/*     */     //   752: invokeinterface getItemInUse : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   757: dup
/*     */     //   758: ifnonnull -> 764
/*     */     //   761: invokestatic throwNpe : ()V
/*     */     //   764: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   769: ifnull -> 838
/*     */     //   772: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   775: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   780: dup
/*     */     //   781: ifnonnull -> 787
/*     */     //   784: invokestatic throwNpe : ()V
/*     */     //   787: invokeinterface isBlocking : ()Z
/*     */     //   792: ifne -> 838
/*     */     //   795: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   798: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   801: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   806: dup
/*     */     //   807: ifnonnull -> 813
/*     */     //   810: invokestatic throwNpe : ()V
/*     */     //   813: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   818: dup
/*     */     //   819: ifnonnull -> 825
/*     */     //   822: invokestatic throwNpe : ()V
/*     */     //   825: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   830: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   835: ifne -> 881
/*     */     //   838: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   841: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   844: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   849: dup
/*     */     //   850: ifnonnull -> 856
/*     */     //   853: invokestatic throwNpe : ()V
/*     */     //   856: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   861: dup
/*     */     //   862: ifnonnull -> 868
/*     */     //   865: invokestatic throwNpe : ()V
/*     */     //   868: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   873: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   878: ifeq -> 1121
/*     */     //   881: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   884: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   889: dup
/*     */     //   890: ifnonnull -> 896
/*     */     //   893: invokestatic throwNpe : ()V
/*     */     //   896: invokeinterface isUsingItem : ()Z
/*     */     //   901: ifeq -> 1121
/*     */     //   904: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   907: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   912: dup
/*     */     //   913: ifnonnull -> 919
/*     */     //   916: invokestatic throwNpe : ()V
/*     */     //   919: invokeinterface getItemInUseCount : ()I
/*     */     //   924: iconst_1
/*     */     //   925: if_icmplt -> 1121
/*     */     //   928: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   931: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   936: dup
/*     */     //   937: ifnonnull -> 943
/*     */     //   940: invokestatic throwNpe : ()V
/*     */     //   943: invokeinterface getSprinting : ()Z
/*     */     //   948: ifeq -> 995
/*     */     //   951: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   954: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   959: dup
/*     */     //   960: ifnonnull -> 966
/*     */     //   963: invokestatic throwNpe : ()V
/*     */     //   966: invokeinterface getOnGround : ()Z
/*     */     //   971: ifne -> 995
/*     */     //   974: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   977: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   982: dup
/*     */     //   983: ifnonnull -> 989
/*     */     //   986: invokestatic throwNpe : ()V
/*     */     //   989: iconst_0
/*     */     //   990: invokeinterface setSprinting : (Z)V
/*     */     //   995: aload_0
/*     */     //   996: getfield packet : I
/*     */     //   999: bipush #16
/*     */     //   1001: if_icmpeq -> 1121
/*     */     //   1004: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1007: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1012: dup
/*     */     //   1013: ifnonnull -> 1019
/*     */     //   1016: invokestatic throwNpe : ()V
/*     */     //   1019: invokeinterface getTicksExisted : ()I
/*     */     //   1024: iconst_2
/*     */     //   1025: irem
/*     */     //   1026: ifne -> 1069
/*     */     //   1029: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1032: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1037: dup
/*     */     //   1038: ifnonnull -> 1044
/*     */     //   1041: invokestatic throwNpe : ()V
/*     */     //   1044: iconst_0
/*     */     //   1045: invokeinterface setSprinting : (Z)V
/*     */     //   1050: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1053: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1058: ldc_w 0.33
/*     */     //   1061: invokeinterface setTimerSpeed : (F)V
/*     */     //   1066: goto -> 1106
/*     */     //   1069: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1072: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1077: dup
/*     */     //   1078: ifnonnull -> 1084
/*     */     //   1081: invokestatic throwNpe : ()V
/*     */     //   1084: iconst_1
/*     */     //   1085: invokeinterface setSprinting : (Z)V
/*     */     //   1090: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1093: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1098: ldc_w 0.9
/*     */     //   1101: invokeinterface setTimerSpeed : (F)V
/*     */     //   1106: new net/minecraft/network/play/client/CPacketPlayer
/*     */     //   1109: dup
/*     */     //   1110: iconst_1
/*     */     //   1111: invokespecial <init> : (Z)V
/*     */     //   1114: checkcast net/minecraft/network/Packet
/*     */     //   1117: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   1120: return
/*     */     //   1121: aload_1
/*     */     //   1122: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   1125: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   1128: if_acmpne -> 1571
/*     */     //   1131: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1134: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1137: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1142: dup
/*     */     //   1143: ifnonnull -> 1149
/*     */     //   1146: invokestatic throwNpe : ()V
/*     */     //   1149: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1154: dup
/*     */     //   1155: ifnonnull -> 1161
/*     */     //   1158: invokestatic throwNpe : ()V
/*     */     //   1161: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1166: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   1171: ifeq -> 1571
/*     */     //   1174: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1177: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1182: fconst_1
/*     */     //   1183: invokeinterface setTimerSpeed : (F)V
/*     */     //   1188: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1191: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1199: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   1202: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*     */     //   1205: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1211: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1214: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1219: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   1224: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1229: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1232: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1237: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1240: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1243: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1248: dup
/*     */     //   1249: ifnonnull -> 1255
/*     */     //   1252: invokestatic throwNpe : ()V
/*     */     //   1255: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1260: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1265: dup
/*     */     //   1266: ifnonnull -> 1280
/*     */     //   1269: new kotlin/TypeCastException
/*     */     //   1272: dup
/*     */     //   1273: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemStack'
/*     */     //   1276: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1279: athrow
/*     */     //   1280: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*     */     //   1285: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1288: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1293: goto -> 1571
/*     */     //   1296: aload_1
/*     */     //   1297: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   1300: getstatic net/ccbluex/liquidbounce/event/EventState.PRE : Lnet/ccbluex/liquidbounce/event/EventState;
/*     */     //   1303: if_acmpne -> 1571
/*     */     //   1306: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1309: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1312: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1317: dup
/*     */     //   1318: ifnonnull -> 1324
/*     */     //   1321: invokestatic throwNpe : ()V
/*     */     //   1324: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1329: dup
/*     */     //   1330: ifnonnull -> 1336
/*     */     //   1333: invokestatic throwNpe : ()V
/*     */     //   1336: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1341: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   1346: ifeq -> 1571
/*     */     //   1349: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1352: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1357: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1360: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   1363: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*     */     //   1366: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1369: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1372: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1375: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1380: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   1385: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1390: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1393: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1398: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1401: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1404: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1409: dup
/*     */     //   1410: ifnonnull -> 1416
/*     */     //   1413: invokestatic throwNpe : ()V
/*     */     //   1416: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1421: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1426: dup
/*     */     //   1427: ifnonnull -> 1441
/*     */     //   1430: new kotlin/TypeCastException
/*     */     //   1433: dup
/*     */     //   1434: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemStack'
/*     */     //   1437: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1440: athrow
/*     */     //   1441: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*     */     //   1446: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1449: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1454: goto -> 1571
/*     */     //   1457: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1460: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1465: dup
/*     */     //   1466: ifnonnull -> 1472
/*     */     //   1469: invokestatic throwNpe : ()V
/*     */     //   1472: dup
/*     */     //   1473: invokeinterface getMotionX : ()D
/*     */     //   1478: ldc_w 0.8
/*     */     //   1481: f2d
/*     */     //   1482: dmul
/*     */     //   1483: invokeinterface setMotionX : (D)V
/*     */     //   1488: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1491: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1496: dup
/*     */     //   1497: ifnonnull -> 1503
/*     */     //   1500: invokestatic throwNpe : ()V
/*     */     //   1503: dup
/*     */     //   1504: invokeinterface getMotionY : ()D
/*     */     //   1509: ldc_w 0.8
/*     */     //   1512: f2d
/*     */     //   1513: dmul
/*     */     //   1514: invokeinterface setMotionY : (D)V
/*     */     //   1519: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1522: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1527: dup
/*     */     //   1528: ifnonnull -> 1534
/*     */     //   1531: invokestatic throwNpe : ()V
/*     */     //   1534: dup
/*     */     //   1535: invokeinterface getMotionZ : ()D
/*     */     //   1540: ldc_w 0.8
/*     */     //   1543: f2d
/*     */     //   1544: dmul
/*     */     //   1545: invokeinterface setMotionZ : (D)V
/*     */     //   1550: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1553: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1558: dup
/*     */     //   1559: ifnonnull -> 1565
/*     */     //   1562: invokestatic throwNpe : ()V
/*     */     //   1565: iconst_1
/*     */     //   1566: invokeinterface setSprinting : (Z)V
/*     */     //   1571: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #52	-> 6
/*     */     //   #53	-> 12
/*     */     //   #55	-> 13
/*     */     //   #56	-> 96
/*     */     //   #121	-> 108
/*     */     //   #132	-> 120
/*     */     //   #88	-> 132
/*     */     //   #57	-> 144
/*     */     //   #59	-> 144
/*     */     //   #57	-> 235
/*     */     //   #58	-> 238
/*     */     //   #57	-> 270
/*     */     //   #59	-> 278
/*     */     //   #61	-> 321
/*     */     //   #62	-> 344
/*     */     //   #63	-> 391
/*     */     //   #64	-> 414
/*     */     //   #65	-> 437
/*     */     //   #68	-> 458
/*     */     //   #69	-> 483
/*     */     //   #71	-> 507
/*     */     //   #72	-> 528
/*     */     //   #73	-> 528
/*     */     //   #77	-> 529
/*     */     //   #78	-> 582
/*     */     //   #79	-> 596
/*     */     //   #80	-> 604
/*     */     //   #81	-> 607
/*     */     //   #82	-> 610
/*     */     //   #80	-> 627
/*     */     //   #79	-> 632
/*     */     //   #85	-> 637
/*     */     //   #89	-> 704
/*     */     //   #90	-> 881
/*     */     //   #91	-> 928
/*     */     //   #92	-> 951
/*     */     //   #93	-> 974
/*     */     //   #96	-> 995
/*     */     //   #97	-> 1004
/*     */     //   #98	-> 1029
/*     */     //   #99	-> 1050
/*     */     //   #102	-> 1069
/*     */     //   #103	-> 1090
/*     */     //   #104	-> 1106
/*     */     //   #105	-> 1106
/*     */     //   #106	-> 1120
/*     */     //   #110	-> 1121
/*     */     //   #111	-> 1174
/*     */     //   #112	-> 1188
/*     */     //   #113	-> 1196
/*     */     //   #114	-> 1199
/*     */     //   #115	-> 1202
/*     */     //   #113	-> 1219
/*     */     //   #112	-> 1224
/*     */     //   #118	-> 1229
/*     */     //   #122	-> 1296
/*     */     //   #123	-> 1349
/*     */     //   #124	-> 1357
/*     */     //   #125	-> 1360
/*     */     //   #126	-> 1363
/*     */     //   #124	-> 1380
/*     */     //   #123	-> 1385
/*     */     //   #129	-> 1390
/*     */     //   #133	-> 1457
/*     */     //   #134	-> 1488
/*     */     //   #135	-> 1519
/*     */     //   #136	-> 1550
/*     */     //   #138	-> 1571
/*     */     //   #139	-> 1571
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	1572	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NewHYTNoSlow;
/*     */     //   0	1572	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*     */   public final void onSlowDown(@NotNull SlowDownEvent event) {
/* 142 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getHeldItem(); IItem heldItem = (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) ? MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() : null;
/*     */     
/* 144 */     event.setForward(getMultiplier(heldItem, true));
/* 145 */     event.setStrafe(getMultiplier(heldItem, false));
/*     */   }
/*     */   private final float getMultiplier(IItem item, boolean isForward) {
/* 148 */     if (Intrinsics.areEqual(this.modeValue.get(), "Hyt-Vanilla")) {
/* 149 */       return 
/* 150 */         MinecraftInstance.classProvider.isItemSword(item) ? (
/* 151 */         isForward ? 0.89999F : 0.999999F) : 
/*     */ 
/*     */         
/* 154 */         0.2F;
/*     */     }
/*     */     
/* 157 */     if (Intrinsics.areEqual(this.modeValue.get(), "Hyt-Legit")) {
/* 158 */       return 
/* 159 */         MinecraftInstance.classProvider.isItemSword(item) ? (
/* 160 */         isForward ? 1.0F : 1.0F) : 
/*     */ 
/*     */         
/* 163 */         0.2F;
/*     */     }
/*     */     
/* 166 */     if (Intrinsics.areEqual(this.modeValue.get(), "Hyt-Normal")) {
/* 167 */       return 
/* 168 */         MinecraftInstance.classProvider.isItemSword(item) ? (
/* 169 */         isForward ? 1.0F : 1.0F) : 
/*     */         
/* 171 */         0.6F;
/*     */     }
/*     */     
/* 174 */     if (Intrinsics.areEqual(this.modeValue.get(), "Hyt-Fast")) {
/* 175 */       return 
/* 176 */         MinecraftInstance.classProvider.isItemSword(item) ? (
/* 177 */         isForward ? 1.0F : 1.0F) : 
/*     */         
/* 179 */         0.79F;
/*     */     }
/*     */     
/* 182 */     return 
/* 183 */       MinecraftInstance.classProvider.isItemSword(item) ? (
/* 184 */       isForward ? 1.0F : 1.0F) : 
/*     */ 
/*     */       
/* 187 */       0.0F;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/* 192 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\NewHYTNoSlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */