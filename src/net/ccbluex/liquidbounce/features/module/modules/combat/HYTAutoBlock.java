/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventState;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.minecraft.network.Packet;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "HYTAutoBlock", description = "HYT自动防砍", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\007\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\023\032\0020\0242\006\020\025\032\0020\026H\007J\020\020\027\032\0020\0242\006\020\025\032\0020\030H\007J\020\020\031\032\0020\0242\006\020\025\032\0020\032H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\016\020\013\032\0020\fX\016¢\006\002\n\000R\016\020\r\032\0020\006X\016¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\006X\016¢\006\002\n\000R\016\020\021\032\0020\006X\016¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/HYTAutoBlock;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "aim", "", "getAim", "()Z", "setAim", "(Z)V", "blockRange", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "blocking", "fake", "fullab", "hitable", "safeice", "sendc08", "onMotion", "", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class HYTAutoBlock extends Module {
/* 23 */   private FloatValue blockRange = new FloatValue("BlockRange", 5.0F, 0.0F, 8.0F);
/*    */   private boolean blocking;
/* 25 */   private final BoolValue fullab = new BoolValue("Alwaysab", true);
/* 26 */   private final BoolValue fake = new BoolValue("fake", true);
/* 27 */   private final BoolValue sendc08 = new BoolValue("sendc08", true);
/*    */   private boolean hitable; private boolean safeice; private boolean aim;
/*    */   
/* 30 */   public final boolean getAim() { return this.aim; } public final void setAim(boolean <set-?>) { this.aim = <set-?>; }
/* 31 */    private final BoolValue Debug = new BoolValue("Debug", true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   9: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   12: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   14: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   17: dup
/*    */     //   18: ifnonnull -> 31
/*    */     //   21: new kotlin/TypeCastException
/*    */     //   24: dup
/*    */     //   25: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*    */     //   27: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   30: athrow
/*    */     //   31: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   34: astore_2
/*    */     //   35: aload_0
/*    */     //   36: aload_2
/*    */     //   37: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   40: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   43: ldc2_w 0.05
/*    */     //   46: invokestatic isFaced : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;D)Z
/*    */     //   49: putfield hitable : Z
/*    */     //   52: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   55: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   60: dup
/*    */     //   61: ifnull -> 67
/*    */     //   64: goto -> 69
/*    */     //   67: pop
/*    */     //   68: return
/*    */     //   69: astore_3
/*    */     //   70: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   73: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   76: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   81: dup
/*    */     //   82: ifnonnull -> 88
/*    */     //   85: invokestatic throwNpe : ()V
/*    */     //   88: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   93: dup
/*    */     //   94: ifnonnull -> 100
/*    */     //   97: invokestatic throwNpe : ()V
/*    */     //   100: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*    */     //   105: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*    */     //   110: ifne -> 157
/*    */     //   113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   116: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   121: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   126: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   129: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   134: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   137: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   142: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   147: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   152: invokeinterface setPressed : (Z)V
/*    */     //   157: aload_3
/*    */     //   158: invokeinterface getOnGround : ()Z
/*    */     //   163: ifeq -> 286
/*    */     //   166: aload_3
/*    */     //   167: invokeinterface isOnLadder : ()Z
/*    */     //   172: ifne -> 286
/*    */     //   175: aload_3
/*    */     //   176: invokeinterface isSneaking : ()Z
/*    */     //   181: ifne -> 286
/*    */     //   184: aload_3
/*    */     //   185: invokeinterface getSprinting : ()Z
/*    */     //   190: ifeq -> 286
/*    */     //   193: aload_3
/*    */     //   194: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*    */     //   199: invokeinterface getMoveForward : ()F
/*    */     //   204: f2d
/*    */     //   205: dconst_0
/*    */     //   206: dcmpl
/*    */     //   207: ifle -> 286
/*    */     //   210: aload_3
/*    */     //   211: invokeinterface getPosition : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*    */     //   216: invokevirtual down : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*    */     //   219: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*    */     //   222: astore #4
/*    */     //   224: iconst_0
/*    */     //   225: istore #5
/*    */     //   227: iconst_0
/*    */     //   228: istore #6
/*    */     //   230: aload #4
/*    */     //   232: astore #7
/*    */     //   234: iconst_0
/*    */     //   235: istore #8
/*    */     //   237: aload_0
/*    */     //   238: aload #7
/*    */     //   240: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   243: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.ICE : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*    */     //   246: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*    */     //   251: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   254: ifne -> 276
/*    */     //   257: aload #7
/*    */     //   259: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   262: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.ICE_PACKED : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*    */     //   265: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*    */     //   270: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   273: ifeq -> 280
/*    */     //   276: iconst_1
/*    */     //   277: goto -> 281
/*    */     //   280: iconst_0
/*    */     //   281: putfield safeice : Z
/*    */     //   284: nop
/*    */     //   285: nop
/*    */     //   286: aload_0
/*    */     //   287: getfield fullab : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   290: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   293: checkcast java/lang/Boolean
/*    */     //   296: invokevirtual booleanValue : ()Z
/*    */     //   299: ifeq -> 309
/*    */     //   302: aload_2
/*    */     //   303: invokevirtual getState : ()Z
/*    */     //   306: ifne -> 323
/*    */     //   309: aload_2
/*    */     //   310: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   313: ifnonnull -> 323
/*    */     //   316: aload_2
/*    */     //   317: invokevirtual getCurrentTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   320: ifnull -> 470
/*    */     //   323: aload_2
/*    */     //   324: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   327: dup
/*    */     //   328: ifnonnull -> 334
/*    */     //   331: invokestatic throwNpe : ()V
/*    */     //   334: invokeinterface isDead : ()Z
/*    */     //   339: ifne -> 470
/*    */     //   342: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   345: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   348: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   353: dup
/*    */     //   354: ifnonnull -> 360
/*    */     //   357: invokestatic throwNpe : ()V
/*    */     //   360: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   365: dup
/*    */     //   366: ifnonnull -> 372
/*    */     //   369: invokestatic throwNpe : ()V
/*    */     //   372: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*    */     //   377: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*    */     //   382: ifeq -> 470
/*    */     //   385: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   388: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   393: dup
/*    */     //   394: ifnonnull -> 400
/*    */     //   397: invokestatic throwNpe : ()V
/*    */     //   400: aload_2
/*    */     //   401: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   404: dup
/*    */     //   405: ifnonnull -> 411
/*    */     //   408: invokestatic throwNpe : ()V
/*    */     //   411: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   414: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*    */     //   419: aload_0
/*    */     //   420: getfield blockRange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   423: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   426: checkcast java/lang/Number
/*    */     //   429: invokevirtual floatValue : ()F
/*    */     //   432: fcmpg
/*    */     //   433: ifgt -> 519
/*    */     //   436: aload_0
/*    */     //   437: getfield safeice : Z
/*    */     //   440: ifne -> 519
/*    */     //   443: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   446: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   451: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   456: iconst_1
/*    */     //   457: invokeinterface setPressed : (Z)V
/*    */     //   462: aload_0
/*    */     //   463: iconst_1
/*    */     //   464: putfield blocking : Z
/*    */     //   467: goto -> 519
/*    */     //   470: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   473: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   478: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   486: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   491: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   494: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   499: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   504: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   509: invokeinterface setPressed : (Z)V
/*    */     //   514: aload_0
/*    */     //   515: iconst_0
/*    */     //   516: putfield blocking : Z
/*    */     //   519: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   522: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*    */     //   527: astore #4
/*    */     //   529: aload #4
/*    */     //   531: ifnull -> 570
/*    */     //   534: aload #4
/*    */     //   536: invokeinterface getEntityHit : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   541: iconst_1
/*    */     //   542: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*    */     //   545: ifeq -> 570
/*    */     //   548: aload_0
/*    */     //   549: getfield blocking : Z
/*    */     //   552: ifeq -> 570
/*    */     //   555: aload_0
/*    */     //   556: getfield hitable : Z
/*    */     //   559: ifne -> 570
/*    */     //   562: aload_0
/*    */     //   563: iconst_1
/*    */     //   564: putfield aim : Z
/*    */     //   567: goto -> 575
/*    */     //   570: aload_0
/*    */     //   571: iconst_0
/*    */     //   572: putfield aim : Z
/*    */     //   575: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #35	-> 6
/*    */     //   #36	-> 35
/*    */     //   #37	-> 52
/*    */     //   #37	-> 67
/*    */     //   #38	-> 70
/*    */     //   #39	-> 113
/*    */     //   #42	-> 157
/*    */     //   #43	-> 210
/*    */     //   #44	-> 237
/*    */     //   #45	-> 284
/*    */     //   #43	-> 285
/*    */     //   #47	-> 286
/*    */     //   #48	-> 385
/*    */     //   #49	-> 436
/*    */     //   #50	-> 443
/*    */     //   #51	-> 462
/*    */     //   #55	-> 470
/*    */     //   #56	-> 514
/*    */     //   #57	-> 519
/*    */     //   #58	-> 519
/*    */     //   #59	-> 529
/*    */     //   #60	-> 529
/*    */     //   #61	-> 529
/*    */     //   #60	-> 534
/*    */     //   #62	-> 562
/*    */     //   #64	-> 570
/*    */     //   #65	-> 575
/*    */     //   #66	-> 575
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   234	50	7	it	Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*    */     //   237	47	8	$i$a$-let-HYTAutoBlock$onUpdate$1	I
/*    */     //   529	47	4	objectMouseOver	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*    */     //   70	506	3	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   35	541	2	aura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*    */     //   0	576	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/HYTAutoBlock;
/*    */     //   0	576	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 69 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 96 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet e = ((PacketImpl)$this$unwrap$iv).getWrapped();
/*    */     if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura"); 
/*    */     KillAura aura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/*    */     if (!this.aim && e instanceof net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock) {
/*    */       if (MinecraftInstance.mc.getThePlayer() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       if (MinecraftInstance.classProvider.isItemSword(MinecraftInstance.mc.getThePlayer().getHeldItem().getItem()) && this.blocking && !this.hitable && aura.getState()) {
/*    */         event.cancelEvent();
/*    */         if (((Boolean)this.Debug.get()).booleanValue())
/*    */           ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d取消onblock"); 
/*    */       } 
/*    */     } 
/*    */     if (((Boolean)this.fake.get()).booleanValue() && e instanceof net.minecraft.network.play.client.CPacketPlayerTryUseItem) {
/*    */       if (MinecraftInstance.mc.getThePlayer() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       if (MinecraftInstance.classProvider.isItemSword(MinecraftInstance.mc.getThePlayer().getHeldItem().getItem())) {
/*    */         event.cancelEvent();
/*    */         if (((Boolean)this.Debug.get()).booleanValue())
/*    */           ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d取消use"); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onMotion(@NotNull MotionEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */     if (!MovementUtils.isMoving())
/*    */       return; 
/*    */     if (((Boolean)this.sendc08.get()).booleanValue() && event.getEventState() == EventState.PRE) {
/*    */       if (MinecraftInstance.mc.getThePlayer() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null)
/*    */         Intrinsics.throwNpe(); 
/*    */       if (MinecraftInstance.classProvider.isItemSword(MinecraftInstance.mc.getThePlayer().getHeldItem().getItem())) {
/*    */         if (MinecraftInstance.mc.getThePlayer() == null)
/*    */           Intrinsics.throwNpe(); 
/*    */         if (MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand() == null)
/*    */           throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemStack"); 
/*    */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand()));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\HYTAutoBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */