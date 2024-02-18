/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import java.util.LinkedList;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl;
/*     */ import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "WarNoSlow", description = "WAR EDIT", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000n\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\004\n\002\020\016\n\002\b\003\n\002\020\b\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\032\032\0020\033J\006\020\034\032\0020\033J\032\020\035\032\0020\0362\b\020\037\032\004\030\0010 2\006\020!\032\0020\016H\002J\b\020\"\032\0020\033H\026J\b\020#\032\0020\033H\026J\020\020$\032\0020\0332\006\020%\032\0020&H\007J\020\020'\032\0020\0332\006\020%\032\0020(H\007J\020\020)\032\0020\0332\006\020%\032\0020*H\007J\020\020+\032\0020\0332\006\020%\032\0020,H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\bX\004¢\006\002\n\000R\032\020\t\032\016\022\n\022\b\022\004\022\0020\f0\0130\nX\016¢\006\002\n\000R\016\020\r\032\0020\016X\016¢\006\002\n\000R\021\020\017\032\0020\b¢\006\b\n\000\032\004\b\020\020\021R\024\020\022\032\0020\0238VX\004¢\006\006\032\004\b\024\020\025R\021\020\026\032\0020\0278F¢\006\006\032\004\b\030\020\031¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/WarNoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "packet", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "packetBuf", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "slow", "", "soulsandValue", "getSoulsandValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "windowId", "", "getWindowId", "()I", "blink", "", "flush_inv", "getMultiplier", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "isForward", "onDisable", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "XSJClient"})
/*     */ public final class WarNoSlow extends Module {
/*     */   @NotNull
/*  29 */   private final ListValue modeValue = new ListValue("PacketMode", new String[] { "GrimAC" }, "GrimAC"); @NotNull public final ListValue getModeValue() { return this.modeValue; }
/*  30 */    private LinkedList<Packet<INetHandlerPlayClient>> packetBuf = new LinkedList<>();
/*     */   private boolean slow;
/*  32 */   private final BoolValue packet = new BoolValue("Packet", true); @NotNull
/*  33 */   private final BoolValue soulsandValue = new BoolValue("Soulsand", true); @NotNull public final BoolValue getSoulsandValue() { return this.soulsandValue; }
/*     */   
/*  35 */   public void onEnable() { this.slow = false; }
/*     */   @EventTarget public final void onPacket(@NotNull PacketEvent event) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   10: astore_3
/*     */     //   11: iconst_0
/*     */     //   12: istore #4
/*     */     //   14: aload_3
/*     */     //   15: dup
/*     */     //   16: ifnonnull -> 29
/*     */     //   19: new kotlin/TypeCastException
/*     */     //   22: dup
/*     */     //   23: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*     */     //   25: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   28: athrow
/*     */     //   29: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   32: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*     */     //   35: astore_2
/*     */     //   36: aload_2
/*     */     //   37: instanceof net/minecraft/network/play/client/CPacketPlayerTryUseItem
/*     */     //   40: ifeq -> 153
/*     */     //   43: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   46: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   51: dup
/*     */     //   52: ifnull -> 113
/*     */     //   55: astore #4
/*     */     //   57: iconst_0
/*     */     //   58: istore #5
/*     */     //   60: aload #4
/*     */     //   62: dup
/*     */     //   63: ifnonnull -> 76
/*     */     //   66: new kotlin/TypeCastException
/*     */     //   69: dup
/*     */     //   70: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>'
/*     */     //   72: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   75: athrow
/*     */     //   76: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*     */     //   79: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   82: checkcast net/minecraft/client/entity/EntityPlayerSP
/*     */     //   85: dup
/*     */     //   86: ifnull -> 113
/*     */     //   89: aload_2
/*     */     //   90: checkcast net/minecraft/network/play/client/CPacketPlayerTryUseItem
/*     */     //   93: invokevirtual func_187028_a : ()Lnet/minecraft/util/EnumHand;
/*     */     //   96: invokevirtual func_184586_b : (Lnet/minecraft/util/EnumHand;)Lnet/minecraft/item/ItemStack;
/*     */     //   99: dup
/*     */     //   100: ifnull -> 113
/*     */     //   103: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
/*     */     //   106: dup
/*     */     //   107: ifnull -> 113
/*     */     //   110: goto -> 115
/*     */     //   113: pop
/*     */     //   114: return
/*     */     //   115: astore_3
/*     */     //   116: aload_3
/*     */     //   117: instanceof net/minecraft/item/ItemFood
/*     */     //   120: ifne -> 144
/*     */     //   123: aload_3
/*     */     //   124: instanceof net/minecraft/item/ItemPotion
/*     */     //   127: ifne -> 144
/*     */     //   130: aload_3
/*     */     //   131: instanceof net/minecraft/item/ItemBucketMilk
/*     */     //   134: ifne -> 144
/*     */     //   137: aload_3
/*     */     //   138: instanceof net/minecraft/item/ItemBow
/*     */     //   141: ifeq -> 153
/*     */     //   144: aload_0
/*     */     //   145: iconst_1
/*     */     //   146: putfield slow : Z
/*     */     //   149: aload_0
/*     */     //   150: invokevirtual flush_inv : ()V
/*     */     //   153: aload_2
/*     */     //   154: instanceof net/minecraft/network/play/server/SPacketWindowItems
/*     */     //   157: ifeq -> 260
/*     */     //   160: aload_2
/*     */     //   161: checkcast net/minecraft/network/play/server/SPacketWindowItems
/*     */     //   164: invokevirtual func_148911_c : ()I
/*     */     //   167: ifne -> 260
/*     */     //   170: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   173: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   178: dup
/*     */     //   179: ifnull -> 224
/*     */     //   182: astore_3
/*     */     //   183: iconst_0
/*     */     //   184: istore #4
/*     */     //   186: aload_3
/*     */     //   187: dup
/*     */     //   188: ifnonnull -> 201
/*     */     //   191: new kotlin/TypeCastException
/*     */     //   194: dup
/*     */     //   195: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>'
/*     */     //   197: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   200: athrow
/*     */     //   201: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*     */     //   204: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   207: checkcast net/minecraft/client/entity/EntityPlayerSP
/*     */     //   210: dup
/*     */     //   211: ifnull -> 224
/*     */     //   214: invokevirtual func_184607_cu : ()Lnet/minecraft/item/ItemStack;
/*     */     //   217: dup
/*     */     //   218: ifnull -> 224
/*     */     //   221: goto -> 228
/*     */     //   224: pop
/*     */     //   225: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   228: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   231: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   234: iconst_1
/*     */     //   235: ixor
/*     */     //   236: ifeq -> 252
/*     */     //   239: aload_0
/*     */     //   240: getfield packetBuf : Ljava/util/LinkedList;
/*     */     //   243: aload_2
/*     */     //   244: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   247: pop
/*     */     //   248: aload_1
/*     */     //   249: invokevirtual cancelEvent : ()V
/*     */     //   252: aload_0
/*     */     //   253: iconst_0
/*     */     //   254: putfield slow : Z
/*     */     //   257: goto -> 498
/*     */     //   260: aload_2
/*     */     //   261: instanceof net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   264: ifeq -> 385
/*     */     //   267: aload_2
/*     */     //   268: checkcast net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   271: invokevirtual func_149175_c : ()I
/*     */     //   274: ifeq -> 300
/*     */     //   277: aload_2
/*     */     //   278: checkcast net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   281: invokevirtual func_149175_c : ()I
/*     */     //   284: iconst_m1
/*     */     //   285: if_icmpeq -> 300
/*     */     //   288: aload_2
/*     */     //   289: checkcast net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   292: invokevirtual func_149175_c : ()I
/*     */     //   295: bipush #-2
/*     */     //   297: if_icmpne -> 385
/*     */     //   300: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   303: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   308: dup
/*     */     //   309: ifnull -> 354
/*     */     //   312: astore_3
/*     */     //   313: iconst_0
/*     */     //   314: istore #4
/*     */     //   316: aload_3
/*     */     //   317: dup
/*     */     //   318: ifnonnull -> 331
/*     */     //   321: new kotlin/TypeCastException
/*     */     //   324: dup
/*     */     //   325: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>'
/*     */     //   327: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   330: athrow
/*     */     //   331: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*     */     //   334: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   337: checkcast net/minecraft/client/entity/EntityPlayerSP
/*     */     //   340: dup
/*     */     //   341: ifnull -> 354
/*     */     //   344: invokevirtual func_184607_cu : ()Lnet/minecraft/item/ItemStack;
/*     */     //   347: dup
/*     */     //   348: ifnull -> 354
/*     */     //   351: goto -> 358
/*     */     //   354: pop
/*     */     //   355: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   358: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   361: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   364: iconst_1
/*     */     //   365: ixor
/*     */     //   366: ifeq -> 385
/*     */     //   369: aload_0
/*     */     //   370: getfield packetBuf : Ljava/util/LinkedList;
/*     */     //   373: aload_2
/*     */     //   374: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   377: pop
/*     */     //   378: aload_1
/*     */     //   379: invokevirtual cancelEvent : ()V
/*     */     //   382: goto -> 498
/*     */     //   385: aload_2
/*     */     //   386: instanceof net/minecraft/network/play/server/SPacketConfirmTransaction
/*     */     //   389: ifeq -> 498
/*     */     //   392: aload_2
/*     */     //   393: checkcast net/minecraft/network/play/server/SPacketConfirmTransaction
/*     */     //   396: invokevirtual func_148889_c : ()I
/*     */     //   399: ifne -> 498
/*     */     //   402: aload_2
/*     */     //   403: checkcast net/minecraft/network/play/server/SPacketConfirmTransaction
/*     */     //   406: invokevirtual func_148890_d : ()S
/*     */     //   409: sipush #11451
/*     */     //   412: i2s
/*     */     //   413: if_icmpeq -> 498
/*     */     //   416: aload_0
/*     */     //   417: getfield slow : Z
/*     */     //   420: ifeq -> 498
/*     */     //   423: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   426: dup
/*     */     //   427: ldc 'mc'
/*     */     //   429: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   432: astore #4
/*     */     //   434: iconst_0
/*     */     //   435: istore #5
/*     */     //   437: aload #4
/*     */     //   439: dup
/*     */     //   440: ifnonnull -> 453
/*     */     //   443: new kotlin/TypeCastException
/*     */     //   446: dup
/*     */     //   447: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl'
/*     */     //   449: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   452: athrow
/*     */     //   453: checkcast net/ccbluex/liquidbounce/injection/backend/MinecraftImpl
/*     */     //   456: invokevirtual getWrapped : ()Lnet/minecraft/client/Minecraft;
/*     */     //   459: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   462: dup
/*     */     //   463: ifnull -> 469
/*     */     //   466: goto -> 471
/*     */     //   469: pop
/*     */     //   470: return
/*     */     //   471: dup
/*     */     //   472: ldc 'mc.unwrap().connection ?: return'
/*     */     //   474: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   477: astore_3
/*     */     //   478: aload_3
/*     */     //   479: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   482: dup
/*     */     //   483: iconst_0
/*     */     //   484: sipush #11451
/*     */     //   487: i2s
/*     */     //   488: iconst_1
/*     */     //   489: invokespecial <init> : (ISZ)V
/*     */     //   492: checkcast net/minecraft/network/Packet
/*     */     //   495: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   498: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #58	-> 6
/*     */     //   #184	-> 14
/*     */     //   #58	-> 35
/*     */     //   #59	-> 36
/*     */     //   #60	-> 43
/*     */     //   #185	-> 60
/*     */     //   #60	-> 89
/*     */     //   #60	-> 113
/*     */     //   #61	-> 116
/*     */     //   #62	-> 144
/*     */     //   #63	-> 149
/*     */     //   #67	-> 153
/*     */     //   #68	-> 170
/*     */     //   #186	-> 186
/*     */     //   #68	-> 224
/*     */     //   #68	-> 225
/*     */     //   #69	-> 239
/*     */     //   #70	-> 248
/*     */     //   #72	-> 252
/*     */     //   #73	-> 260
/*     */     //   #74	-> 260
/*     */     //   #73	-> 260
/*     */     //   #187	-> 316
/*     */     //   #74	-> 355
/*     */     //   #76	-> 369
/*     */     //   #77	-> 378
/*     */     //   #78	-> 385
/*     */     //   #79	-> 423
/*     */     //   #188	-> 437
/*     */     //   #79	-> 469
/*     */     //   #79	-> 470
/*     */     //   #80	-> 478
/*     */     //   #81	-> 498
/*     */     //   #82	-> 498
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   14	21	4	$i$f$unwrap	I
/*     */     //   57	28	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   60	25	5	$i$f$unwrap	I
/*     */     //   116	37	3	stack	Lnet/minecraft/item/Item;
/*     */     //   183	27	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   186	24	4	$i$f$unwrap	I
/*     */     //   313	27	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   316	24	4	$i$f$unwrap	I
/*     */     //   434	25	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   437	22	5	$i$f$unwrap	I
/*     */     //   478	20	3	connection	Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   36	463	2	pw	Lnet/minecraft/network/Packet;
/*     */     //   0	499	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/WarNoSlow;
/*     */     //   0	499	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent; }
/*     */   @EventTarget public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer(); IItemStack heldItem = thePlayer.getHeldItem(); if (heldItem == null || !MinecraftInstance.classProvider.isItemSword(heldItem.getItem()) || !MovementUtils.isMoving()) return;  if (!MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().isKeyDown()) return;  if (((Boolean)this.packet.get()).booleanValue()) { String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 2141186001: if (str.equals("GrimAC") && event.getEventState() == EventState.PRE) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null)
/*     */                 Intrinsics.throwNpe();  if (MinecraftInstance.classProvider.isItemSword(MinecraftInstance.mc.getThePlayer().getHeldItem().getItem())) { MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN))); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand() == null)
/*  41 */                   throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemStack");  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand())); }  }  break; }  }  return; }  MinecraftInstance.mc.getThePlayer(); } public void onDisable() { blink(); }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onTick(@NotNull TickEvent event) {
/*  47 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP $this$unwrap$iv = MinecraftInstance.mc.getThePlayer(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>");  if ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped() != null && ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).func_184607_cu() != null) { ItemStack stack = ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).func_184607_cu(); if (Intrinsics.areEqual(stack, ItemStack.field_190927_a)) blink();  if (this.slow) flush_inv();  return; }  }  ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).func_184607_cu(); } @EventTarget public final void onSlowDown(@NotNull SlowDownEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (this.slow) {
/*     */       event.setForward(0.2F); event.setStrafe(0.2F);
/*     */     } else {
/*     */       event.setForward(1.0F); event.setStrafe(1.0F);
/*     */     }  }
/*     */   public final void blink() { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft $this$unwrap$iv = MinecraftInstance.mc; int $i$f$unwrap = 0;
/* 189 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  if (((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u() != null) { Intrinsics.checkExpressionValueIsNotNull(((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(), "mc.unwrap().connection ?: return"); NetHandlerPlayClient connection = ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); for (Packet<INetHandlerPlayClient> i : this.packetBuf) i.func_148833_a((INetHandler)connection);  }  ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); } public final void flush_inv() { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft $this$unwrap$iv = MinecraftInstance.mc; int $i$f$unwrap = 0;
/* 190 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  if (((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u() != null) { Intrinsics.checkExpressionValueIsNotNull(((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(), "mc.unwrap().connection ?: return"); NetHandlerPlayClient connection = ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); if (getWindowId() == 0) connection.func_147297_a((Packet)new CPacketClickWindow(0, 36, 0, ClickType.SWAP, new ItemStack(Block.func_149729_e(166)), (short)11451));  }  ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); }
/*     */ 
/*     */   
/*     */   public final int getWindowId() {
/*     */     int id = 0;
/*     */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer().getOpenContainer() != null) {
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (MinecraftInstance.mc.getThePlayer().getOpenContainer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         id = MinecraftInstance.mc.getThePlayer().getOpenContainer().getWindowId();
/*     */       } 
/*     */     } 
/*     */     return id;
/*     */   }
/*     */   
/*     */   private final float getMultiplier(IItem item, boolean isForward) {
/*     */     if (Intrinsics.areEqual(this.modeValue.get(), "GrimAC"))
/*     */       return MinecraftInstance.classProvider.isItemSword(item) ? (isForward ? 1.0F : 1.0F) : 0.79F; 
/*     */     return MinecraftInstance.classProvider.isItemSword(item) ? (isForward ? 1.0F : 1.0F) : 0.0F;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\WarNoSlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */