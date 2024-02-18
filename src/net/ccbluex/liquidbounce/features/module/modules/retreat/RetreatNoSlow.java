/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import java.util.LinkedList;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl;
/*     */ import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "XSJNoSlow", description = "Skid", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\b\n\002\b\003\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\r\032\0020\016J\006\020\017\032\0020\016J\b\020\020\032\0020\016H\026J\b\020\021\032\0020\016H\026J\020\020\022\032\0020\0162\006\020\023\032\0020\024H\007J\020\020\025\032\0020\0162\006\020\023\032\0020\026H\007J\020\020\027\032\0020\0162\006\020\023\032\0020\030H\007R\032\020\003\032\016\022\n\022\b\022\004\022\0020\0060\0050\004X\016¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\021\020\t\032\0020\n8F¢\006\006\032\004\b\013\020\f¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/RetreatNoSlow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "packetBuf", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "slow", "", "windowId", "", "getWindowId", "()I", "blink", "", "flush_inv", "onDisable", "onEnable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onSlowDown", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "XSJClient"})
/*     */ public final class RetreatNoSlow extends Module {
/*  23 */   private LinkedList<Packet<INetHandlerPlayClient>> packetBuf = new LinkedList<>();
/*     */   private boolean slow;
/*     */   
/*     */   public void onEnable() {
/*  27 */     this.slow = false;
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  31 */     blink();
/*     */   } @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
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
/*     */     //   40: ifeq -> 167
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
/*     */     //   117: instanceof net/minecraft/item/ItemSword
/*     */     //   120: ifne -> 158
/*     */     //   123: aload_3
/*     */     //   124: instanceof net/minecraft/item/ItemFood
/*     */     //   127: ifne -> 158
/*     */     //   130: aload_3
/*     */     //   131: instanceof net/minecraft/item/ItemPotion
/*     */     //   134: ifne -> 158
/*     */     //   137: aload_3
/*     */     //   138: instanceof net/minecraft/item/ItemBucketMilk
/*     */     //   141: ifne -> 158
/*     */     //   144: aload_3
/*     */     //   145: instanceof net/minecraft/item/ItemBow
/*     */     //   148: ifne -> 158
/*     */     //   151: aload_3
/*     */     //   152: instanceof net/minecraft/item/ItemShield
/*     */     //   155: ifeq -> 167
/*     */     //   158: aload_0
/*     */     //   159: iconst_1
/*     */     //   160: putfield slow : Z
/*     */     //   163: aload_0
/*     */     //   164: invokevirtual flush_inv : ()V
/*     */     //   167: aload_2
/*     */     //   168: instanceof net/minecraft/network/play/server/SPacketWindowItems
/*     */     //   171: ifeq -> 274
/*     */     //   174: aload_2
/*     */     //   175: checkcast net/minecraft/network/play/server/SPacketWindowItems
/*     */     //   178: invokevirtual func_148911_c : ()I
/*     */     //   181: ifne -> 274
/*     */     //   184: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   187: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   192: dup
/*     */     //   193: ifnull -> 238
/*     */     //   196: astore_3
/*     */     //   197: iconst_0
/*     */     //   198: istore #4
/*     */     //   200: aload_3
/*     */     //   201: dup
/*     */     //   202: ifnonnull -> 215
/*     */     //   205: new kotlin/TypeCastException
/*     */     //   208: dup
/*     */     //   209: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>'
/*     */     //   211: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   214: athrow
/*     */     //   215: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*     */     //   218: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   221: checkcast net/minecraft/client/entity/EntityPlayerSP
/*     */     //   224: dup
/*     */     //   225: ifnull -> 238
/*     */     //   228: invokevirtual func_184607_cu : ()Lnet/minecraft/item/ItemStack;
/*     */     //   231: dup
/*     */     //   232: ifnull -> 238
/*     */     //   235: goto -> 242
/*     */     //   238: pop
/*     */     //   239: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   242: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   245: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   248: iconst_1
/*     */     //   249: ixor
/*     */     //   250: ifeq -> 266
/*     */     //   253: aload_0
/*     */     //   254: getfield packetBuf : Ljava/util/LinkedList;
/*     */     //   257: aload_2
/*     */     //   258: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   261: pop
/*     */     //   262: aload_1
/*     */     //   263: invokevirtual cancelEvent : ()V
/*     */     //   266: aload_0
/*     */     //   267: iconst_0
/*     */     //   268: putfield slow : Z
/*     */     //   271: goto -> 512
/*     */     //   274: aload_2
/*     */     //   275: instanceof net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   278: ifeq -> 399
/*     */     //   281: aload_2
/*     */     //   282: checkcast net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   285: invokevirtual func_149175_c : ()I
/*     */     //   288: ifeq -> 314
/*     */     //   291: aload_2
/*     */     //   292: checkcast net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   295: invokevirtual func_149175_c : ()I
/*     */     //   298: iconst_m1
/*     */     //   299: if_icmpeq -> 314
/*     */     //   302: aload_2
/*     */     //   303: checkcast net/minecraft/network/play/server/SPacketSetSlot
/*     */     //   306: invokevirtual func_149175_c : ()I
/*     */     //   309: bipush #-2
/*     */     //   311: if_icmpne -> 399
/*     */     //   314: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   317: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   322: dup
/*     */     //   323: ifnull -> 368
/*     */     //   326: astore_3
/*     */     //   327: iconst_0
/*     */     //   328: istore #4
/*     */     //   330: aload_3
/*     */     //   331: dup
/*     */     //   332: ifnonnull -> 345
/*     */     //   335: new kotlin/TypeCastException
/*     */     //   338: dup
/*     */     //   339: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>'
/*     */     //   341: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   344: athrow
/*     */     //   345: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*     */     //   348: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   351: checkcast net/minecraft/client/entity/EntityPlayerSP
/*     */     //   354: dup
/*     */     //   355: ifnull -> 368
/*     */     //   358: invokevirtual func_184607_cu : ()Lnet/minecraft/item/ItemStack;
/*     */     //   361: dup
/*     */     //   362: ifnull -> 368
/*     */     //   365: goto -> 372
/*     */     //   368: pop
/*     */     //   369: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   372: getstatic net/minecraft/item/ItemStack.field_190927_a : Lnet/minecraft/item/ItemStack;
/*     */     //   375: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   378: iconst_1
/*     */     //   379: ixor
/*     */     //   380: ifeq -> 399
/*     */     //   383: aload_0
/*     */     //   384: getfield packetBuf : Ljava/util/LinkedList;
/*     */     //   387: aload_2
/*     */     //   388: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   391: pop
/*     */     //   392: aload_1
/*     */     //   393: invokevirtual cancelEvent : ()V
/*     */     //   396: goto -> 512
/*     */     //   399: aload_2
/*     */     //   400: instanceof net/minecraft/network/play/server/SPacketConfirmTransaction
/*     */     //   403: ifeq -> 512
/*     */     //   406: aload_2
/*     */     //   407: checkcast net/minecraft/network/play/server/SPacketConfirmTransaction
/*     */     //   410: invokevirtual func_148889_c : ()I
/*     */     //   413: ifne -> 512
/*     */     //   416: aload_2
/*     */     //   417: checkcast net/minecraft/network/play/server/SPacketConfirmTransaction
/*     */     //   420: invokevirtual func_148890_d : ()S
/*     */     //   423: sipush #11451
/*     */     //   426: i2s
/*     */     //   427: if_icmpeq -> 512
/*     */     //   430: aload_0
/*     */     //   431: getfield slow : Z
/*     */     //   434: ifeq -> 512
/*     */     //   437: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   440: dup
/*     */     //   441: ldc 'mc'
/*     */     //   443: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   446: astore #4
/*     */     //   448: iconst_0
/*     */     //   449: istore #5
/*     */     //   451: aload #4
/*     */     //   453: dup
/*     */     //   454: ifnonnull -> 467
/*     */     //   457: new kotlin/TypeCastException
/*     */     //   460: dup
/*     */     //   461: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl'
/*     */     //   463: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   466: athrow
/*     */     //   467: checkcast net/ccbluex/liquidbounce/injection/backend/MinecraftImpl
/*     */     //   470: invokevirtual getWrapped : ()Lnet/minecraft/client/Minecraft;
/*     */     //   473: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   476: dup
/*     */     //   477: ifnull -> 483
/*     */     //   480: goto -> 485
/*     */     //   483: pop
/*     */     //   484: return
/*     */     //   485: dup
/*     */     //   486: ldc 'mc.unwrap().connection ?: return'
/*     */     //   488: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   491: astore_3
/*     */     //   492: aload_3
/*     */     //   493: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   496: dup
/*     */     //   497: iconst_0
/*     */     //   498: sipush #11451
/*     */     //   501: i2s
/*     */     //   502: iconst_1
/*     */     //   503: invokespecial <init> : (ISZ)V
/*     */     //   506: checkcast net/minecraft/network/Packet
/*     */     //   509: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   512: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #47	-> 6
/*     */     //   #107	-> 14
/*     */     //   #47	-> 35
/*     */     //   #48	-> 36
/*     */     //   #49	-> 43
/*     */     //   #108	-> 60
/*     */     //   #49	-> 89
/*     */     //   #49	-> 113
/*     */     //   #50	-> 116
/*     */     //   #51	-> 158
/*     */     //   #52	-> 163
/*     */     //   #56	-> 167
/*     */     //   #57	-> 184
/*     */     //   #109	-> 200
/*     */     //   #57	-> 238
/*     */     //   #57	-> 239
/*     */     //   #58	-> 253
/*     */     //   #59	-> 262
/*     */     //   #61	-> 266
/*     */     //   #62	-> 274
/*     */     //   #110	-> 330
/*     */     //   #62	-> 368
/*     */     //   #62	-> 369
/*     */     //   #63	-> 383
/*     */     //   #64	-> 392
/*     */     //   #65	-> 399
/*     */     //   #66	-> 437
/*     */     //   #111	-> 451
/*     */     //   #66	-> 483
/*     */     //   #66	-> 484
/*     */     //   #67	-> 492
/*     */     //   #68	-> 512
/*     */     //   #69	-> 512
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   14	21	4	$i$f$unwrap	I
/*     */     //   57	28	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   60	25	5	$i$f$unwrap	I
/*     */     //   116	51	3	stack	Lnet/minecraft/item/Item;
/*     */     //   197	27	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   200	24	4	$i$f$unwrap	I
/*     */     //   327	27	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   330	24	4	$i$f$unwrap	I
/*     */     //   448	25	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   451	22	5	$i$f$unwrap	I
/*     */     //   492	20	3	connection	Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   36	477	2	pw	Lnet/minecraft/network/Packet;
/*     */     //   0	513	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/RetreatNoSlow;
/*     */     //   0	513	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*     */   } @EventTarget
/*  36 */   public final void onTick(@NotNull TickEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP $this$unwrap$iv = MinecraftInstance.mc.getThePlayer(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 106 */       if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>");  if ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped() != null && ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).func_184607_cu() != null) { ItemStack stack = ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).func_184607_cu(); if (Intrinsics.areEqual(stack, ItemStack.field_190927_a)) blink();  if (this.slow) flush_inv();  return; }  }  ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).func_184607_cu(); }
/*     */   @EventTarget public final void onSlowDown(@NotNull SlowDownEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (this.slow) {
/*     */       event.setForward(0.2F); event.setStrafe(0.2F);
/*     */     } else {
/*     */       event.setForward(1.0F); event.setStrafe(1.0F);
/*     */     }  } public final void blink() { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft $this$unwrap$iv = MinecraftInstance.mc; int $i$f$unwrap = 0;
/* 112 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  if (((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u() != null) { Intrinsics.checkExpressionValueIsNotNull(((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(), "mc.unwrap().connection ?: return"); NetHandlerPlayClient connection = ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); for (Packet<INetHandlerPlayClient> i : this.packetBuf) i.func_148833_a((INetHandler)connection);  }  ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); } public final void flush_inv() { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft $this$unwrap$iv = MinecraftInstance.mc; int $i$f$unwrap = 0;
/* 113 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  if (((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u() != null) { Intrinsics.checkExpressionValueIsNotNull(((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(), "mc.unwrap().connection ?: return"); NetHandlerPlayClient connection = ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); if (getWindowId() == 0) connection.func_147297_a((Packet)new CPacketClickWindow(0, 36, 0, ClickType.SWAP, new ItemStack(Block.func_149729_e(166)), (short)11451));  }  ((MinecraftImpl)$this$unwrap$iv).getWrapped().func_147114_u(); }
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
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\RetreatNoSlow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */