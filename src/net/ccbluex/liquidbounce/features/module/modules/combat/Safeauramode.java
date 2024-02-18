/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "Safeauramode", description = "Skid", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\013\n\000\n\002\030\002\n\002\b\013\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\036\032\0020\0372\006\020 \032\0020!H\007J\020\020\"\032\0020\0372\006\020 \032\0020#H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\004X\016¢\006\002\n\000R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\032\020\r\032\0020\bX\016¢\006\016\n\000\032\004\b\016\020\n\"\004\b\017\020\fR\016\020\020\032\0020\021X\016¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\016\020\024\032\0020\023X\004¢\006\002\n\000R\016\020\025\032\0020\023X\004¢\006\002\n\000R\016\020\026\032\0020\023X\004¢\006\002\n\000R\016\020\027\032\0020\023X\004¢\006\002\n\000R\016\020\030\032\0020\023X\004¢\006\002\n\000R\016\020\031\032\0020\023X\004¢\006\002\n\000R\021\020\032\032\0020\b¢\006\b\n\000\032\004\b\033\020\nR\016\020\034\032\0020\023X\004¢\006\002\n\000R\016\020\035\032\0020\021X\016¢\006\002\n\000¨\006$"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Safeauramode;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "b", "diggingtime", "normalairrangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getNormalairrangeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "setNormalairrangeValue", "(Lnet/ccbluex/liquidbounce/value/FloatValue;)V", "normalgroundrangeValue", "getNormalgroundrangeValue", "setNormalgroundrangeValue", "onice", "", "safePlace", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "safeStairs", "safeSwimmer", "safeantifireball", "safeclimb", "safedigging", "safeonice", "saferangeValue", "getSaferangeValue", "strict", "walkingDown", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class Safeauramode extends Module {
/*     */   private int a;
/*     */   private int b;
/*     */   private int diggingtime;
/*  26 */   private final BoolValue strict = new BoolValue("strict", false);
/*  27 */   private final BoolValue safeonice = new BoolValue("safeonice", true);
/*  28 */   private final BoolValue safeclimb = new BoolValue("safeclimb", true);
/*  29 */   private final BoolValue safedigging = new BoolValue("safedigging", true);
/*  30 */   private final BoolValue safeSwimmer = new BoolValue("safeSwimmer", true);
/*  31 */   private final BoolValue safeStairs = new BoolValue("safeStairs", true);
/*  32 */   private final BoolValue safePlace = new BoolValue("safePlace", true);
/*  33 */   private final BoolValue safeantifireball = new BoolValue("safeantifireball", true); @NotNull
/*  34 */   private final FloatValue saferangeValue = new FloatValue("saferangeValue", 3.19F, 3.0F, 6.0F); @NotNull public final FloatValue getSaferangeValue() { return this.saferangeValue; } @NotNull
/*  35 */   private FloatValue normalgroundrangeValue = new FloatValue("normalgroundrangeValue", 3.0F, 3.0F, 6.0F); @NotNull public final FloatValue getNormalgroundrangeValue() { return this.normalgroundrangeValue; } public final void setNormalgroundrangeValue(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.normalgroundrangeValue = <set-?>; } private boolean walkingDown; @NotNull
/*  36 */   private FloatValue normalairrangeValue = new FloatValue("normalairrangeValue", 3.0F, 3.0F, 6.0F); private boolean onice; @NotNull public final FloatValue getNormalairrangeValue() { return this.normalairrangeValue; } public final void setNormalairrangeValue(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.normalairrangeValue = <set-?>; }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  41 */     Intrinsics.checkParameterIsNotNull(event, "event"); KillAura aura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/*  42 */     IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
/*     */     if (packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook)
/*     */       this.a = 5; 
/*     */     if ((packet instanceof net.minecraft.network.play.client.CPacketPlayerDigging || this.diggingtime > 3) && ((Boolean)this.safedigging.get()).booleanValue()) {
/*     */       if (MinecraftInstance.mc.getTheWorld() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getObjectMouseOver() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getObjectMouseOver().getBlockPos() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if ((Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getBlockState(MinecraftInstance.mc.getObjectMouseOver().getBlockPos()).getBlock(), MinecraftInstance.classProvider.getBlockEnum(BlockType.AIR)) ^ true) != 0) {
/*     */         if (aura == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         aura.getSwitchDelayValue().set(Integer.valueOf(2000));
/*     */         aura.getGroundRangeValue().set(this.saferangeValue.get());
/*     */         aura.getAirRangeValue().set(this.saferangeValue.get());
/*     */         this.b = 0;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     if (this.b >= 20 && ((Boolean)this.safedigging.get()).booleanValue()) {
/*     */       if (aura == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       aura.getSwitchDelayValue().set(Integer.valueOf(0));
/*     */       aura.getGroundRangeValue().set(this.normalgroundrangeValue.get());
/*     */       aura.getAirRangeValue().set(this.normalairrangeValue.get());
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield a : I
/*     */     //   10: iflt -> 23
/*     */     //   13: aload_0
/*     */     //   14: dup
/*     */     //   15: getfield a : I
/*     */     //   18: iconst_1
/*     */     //   19: isub
/*     */     //   20: putfield a : I
/*     */     //   23: aload_0
/*     */     //   24: dup
/*     */     //   25: getfield b : I
/*     */     //   28: iconst_1
/*     */     //   29: iadd
/*     */     //   30: putfield b : I
/*     */     //   33: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   36: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   41: dup
/*     */     //   42: ifnull -> 48
/*     */     //   45: goto -> 50
/*     */     //   48: pop
/*     */     //   49: return
/*     */     //   50: astore_2
/*     */     //   51: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   54: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   59: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   64: invokeinterface isKeyDown : ()Z
/*     */     //   69: ifeq -> 156
/*     */     //   72: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   75: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   80: dup
/*     */     //   81: ifnonnull -> 87
/*     */     //   84: invokestatic throwNpe : ()V
/*     */     //   87: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   90: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*     */     //   95: dup
/*     */     //   96: ifnonnull -> 102
/*     */     //   99: invokestatic throwNpe : ()V
/*     */     //   102: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   107: dup
/*     */     //   108: ifnonnull -> 114
/*     */     //   111: invokestatic throwNpe : ()V
/*     */     //   114: invokeinterface getBlockState : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;
/*     */     //   119: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   127: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   130: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   135: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   138: iconst_1
/*     */     //   139: ixor
/*     */     //   140: ifeq -> 156
/*     */     //   143: aload_0
/*     */     //   144: dup
/*     */     //   145: getfield diggingtime : I
/*     */     //   148: iconst_1
/*     */     //   149: iadd
/*     */     //   150: putfield diggingtime : I
/*     */     //   153: goto -> 161
/*     */     //   156: aload_0
/*     */     //   157: iconst_0
/*     */     //   158: putfield diggingtime : I
/*     */     //   161: aload_2
/*     */     //   162: invokeinterface getOnGround : ()Z
/*     */     //   167: ifeq -> 288
/*     */     //   170: aload_2
/*     */     //   171: invokeinterface isOnLadder : ()Z
/*     */     //   176: ifne -> 288
/*     */     //   179: aload_2
/*     */     //   180: invokeinterface isSneaking : ()Z
/*     */     //   185: ifne -> 288
/*     */     //   188: aload_2
/*     */     //   189: invokeinterface getSprinting : ()Z
/*     */     //   194: ifeq -> 288
/*     */     //   197: aload_2
/*     */     //   198: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   203: invokeinterface getMoveForward : ()F
/*     */     //   208: f2d
/*     */     //   209: dconst_0
/*     */     //   210: dcmpl
/*     */     //   211: ifle -> 288
/*     */     //   214: aload_2
/*     */     //   215: invokeinterface getPosition : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   220: invokevirtual down : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   223: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   226: astore_3
/*     */     //   227: iconst_0
/*     */     //   228: istore #4
/*     */     //   230: iconst_0
/*     */     //   231: istore #5
/*     */     //   233: aload_3
/*     */     //   234: astore #6
/*     */     //   236: iconst_0
/*     */     //   237: istore #7
/*     */     //   239: aload_0
/*     */     //   240: aload #6
/*     */     //   242: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   245: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.ICE : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   248: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   253: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   256: ifne -> 278
/*     */     //   259: aload #6
/*     */     //   261: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   264: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.ICE_PACKED : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   267: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   272: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   275: ifeq -> 282
/*     */     //   278: iconst_1
/*     */     //   279: goto -> 283
/*     */     //   282: iconst_0
/*     */     //   283: putfield onice : Z
/*     */     //   286: nop
/*     */     //   287: nop
/*     */     //   288: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   291: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   294: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   296: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   299: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   302: astore_3
/*     */     //   303: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   306: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   309: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew
/*     */     //   312: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   315: checkcast net/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew
/*     */     //   318: astore #4
/*     */     //   320: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   323: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   326: ldc_w net/ccbluex/liquidbounce/features/module/modules/hyt/HytAntiFireBall
/*     */     //   329: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   332: checkcast net/ccbluex/liquidbounce/features/module/modules/hyt/HytAntiFireBall
/*     */     //   335: astore #5
/*     */     //   337: aload_0
/*     */     //   338: getfield safeantifireball : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   341: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   344: checkcast java/lang/Boolean
/*     */     //   347: invokevirtual booleanValue : ()Z
/*     */     //   350: ifeq -> 383
/*     */     //   353: aload_3
/*     */     //   354: dup
/*     */     //   355: ifnonnull -> 361
/*     */     //   358: invokestatic throwNpe : ()V
/*     */     //   361: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   364: ifnull -> 383
/*     */     //   367: aload #5
/*     */     //   369: dup
/*     */     //   370: ifnonnull -> 376
/*     */     //   373: invokestatic throwNpe : ()V
/*     */     //   376: iconst_0
/*     */     //   377: invokevirtual setState : (Z)V
/*     */     //   380: goto -> 412
/*     */     //   383: aload_0
/*     */     //   384: getfield safeantifireball : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   387: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   390: checkcast java/lang/Boolean
/*     */     //   393: invokevirtual booleanValue : ()Z
/*     */     //   396: ifeq -> 412
/*     */     //   399: aload #5
/*     */     //   401: dup
/*     */     //   402: ifnonnull -> 408
/*     */     //   405: invokestatic throwNpe : ()V
/*     */     //   408: iconst_1
/*     */     //   409: invokevirtual setState : (Z)V
/*     */     //   412: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   415: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   418: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   423: dup
/*     */     //   424: ifnonnull -> 430
/*     */     //   427: invokestatic throwNpe : ()V
/*     */     //   430: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   435: dup
/*     */     //   436: ifnonnull -> 442
/*     */     //   439: invokestatic throwNpe : ()V
/*     */     //   442: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   447: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   452: ifeq -> 471
/*     */     //   455: aload_0
/*     */     //   456: getfield safePlace : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   459: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   462: checkcast java/lang/Boolean
/*     */     //   465: invokevirtual booleanValue : ()Z
/*     */     //   468: ifne -> 494
/*     */     //   471: aload_0
/*     */     //   472: getfield a : I
/*     */     //   475: iconst_3
/*     */     //   476: if_icmpge -> 494
/*     */     //   479: aload #4
/*     */     //   481: dup
/*     */     //   482: ifnonnull -> 488
/*     */     //   485: invokestatic throwNpe : ()V
/*     */     //   488: invokevirtual getState : ()Z
/*     */     //   491: ifeq -> 503
/*     */     //   494: aload_3
/*     */     //   495: ifnull -> 503
/*     */     //   498: aload_3
/*     */     //   499: iconst_0
/*     */     //   500: invokevirtual setState : (Z)V
/*     */     //   503: aload_2
/*     */     //   504: invokeinterface getFallDistance : ()F
/*     */     //   509: iconst_0
/*     */     //   510: i2f
/*     */     //   511: fcmpl
/*     */     //   512: ifle -> 530
/*     */     //   515: aload_0
/*     */     //   516: getfield walkingDown : Z
/*     */     //   519: ifne -> 530
/*     */     //   522: aload_0
/*     */     //   523: iconst_1
/*     */     //   524: putfield walkingDown : Z
/*     */     //   527: goto -> 551
/*     */     //   530: aload_2
/*     */     //   531: invokeinterface getPosY : ()D
/*     */     //   536: aload_2
/*     */     //   537: invokeinterface getPrevChasingPosY : ()D
/*     */     //   542: dcmpl
/*     */     //   543: ifle -> 551
/*     */     //   546: aload_0
/*     */     //   547: iconst_0
/*     */     //   548: putfield walkingDown : Z
/*     */     //   551: aload_0
/*     */     //   552: getfield safeclimb : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   555: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   558: checkcast java/lang/Boolean
/*     */     //   561: invokevirtual booleanValue : ()Z
/*     */     //   564: ifeq -> 585
/*     */     //   567: aload_2
/*     */     //   568: invokeinterface isCollidedHorizontally : ()Z
/*     */     //   573: ifeq -> 585
/*     */     //   576: aload_2
/*     */     //   577: invokeinterface isOnLadder : ()Z
/*     */     //   582: ifne -> 720
/*     */     //   585: aload_0
/*     */     //   586: getfield safeSwimmer : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   589: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   592: checkcast java/lang/Boolean
/*     */     //   595: invokevirtual booleanValue : ()Z
/*     */     //   598: ifeq -> 630
/*     */     //   601: aload_2
/*     */     //   602: invokeinterface isInWater : ()Z
/*     */     //   607: ifeq -> 630
/*     */     //   610: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   613: aload_2
/*     */     //   614: invokeinterface getPosition : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   619: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   622: invokeinterface isBlockLiquid : (Ljava/lang/Object;)Z
/*     */     //   627: ifne -> 720
/*     */     //   630: aload_0
/*     */     //   631: getfield safeStairs : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   634: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   637: checkcast java/lang/Boolean
/*     */     //   640: invokevirtual booleanValue : ()Z
/*     */     //   643: ifeq -> 697
/*     */     //   646: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   649: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   652: dup
/*     */     //   653: aload_2
/*     */     //   654: invokeinterface getPosX : ()D
/*     */     //   659: aload_2
/*     */     //   660: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   665: invokeinterface getMinY : ()D
/*     */     //   670: aload_2
/*     */     //   671: invokeinterface getPosZ : ()D
/*     */     //   676: invokespecial <init> : (DDD)V
/*     */     //   679: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   682: invokeinterface isBlockStairs : (Ljava/lang/Object;)Z
/*     */     //   687: ifeq -> 697
/*     */     //   690: aload_0
/*     */     //   691: getfield walkingDown : Z
/*     */     //   694: ifeq -> 720
/*     */     //   697: aload_0
/*     */     //   698: getfield safeonice : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   701: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   704: checkcast java/lang/Boolean
/*     */     //   707: invokevirtual booleanValue : ()Z
/*     */     //   710: ifeq -> 783
/*     */     //   713: aload_0
/*     */     //   714: getfield onice : Z
/*     */     //   717: ifeq -> 783
/*     */     //   720: aload_0
/*     */     //   721: getfield strict : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   724: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   727: checkcast java/lang/Boolean
/*     */     //   730: invokevirtual booleanValue : ()Z
/*     */     //   733: ifeq -> 745
/*     */     //   736: aload_3
/*     */     //   737: ifnull -> 745
/*     */     //   740: aload_3
/*     */     //   741: iconst_0
/*     */     //   742: invokevirtual setState : (Z)V
/*     */     //   745: aload_3
/*     */     //   746: dup
/*     */     //   747: ifnonnull -> 753
/*     */     //   750: invokestatic throwNpe : ()V
/*     */     //   753: invokevirtual getGroundRangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   756: aload_0
/*     */     //   757: getfield saferangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   760: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   763: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   766: aload_3
/*     */     //   767: invokevirtual getAirRangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   770: aload_0
/*     */     //   771: getfield saferangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   774: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   777: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   780: goto -> 834
/*     */     //   783: aload_0
/*     */     //   784: getfield safedigging : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   787: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   790: checkcast java/lang/Boolean
/*     */     //   793: invokevirtual booleanValue : ()Z
/*     */     //   796: ifne -> 834
/*     */     //   799: aload_3
/*     */     //   800: dup
/*     */     //   801: ifnonnull -> 807
/*     */     //   804: invokestatic throwNpe : ()V
/*     */     //   807: invokevirtual getGroundRangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   810: aload_0
/*     */     //   811: getfield normalgroundrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   814: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   817: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   820: aload_3
/*     */     //   821: invokevirtual getAirRangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   824: aload_0
/*     */     //   825: getfield normalairrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   828: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   831: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   834: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #60	-> 6
/*     */     //   #61	-> 23
/*     */     //   #62	-> 33
/*     */     //   #62	-> 48
/*     */     //   #63	-> 51
/*     */     //   #64	-> 143
/*     */     //   #66	-> 156
/*     */     //   #67	-> 161
/*     */     //   #68	-> 161
/*     */     //   #69	-> 214
/*     */     //   #70	-> 239
/*     */     //   #71	-> 286
/*     */     //   #69	-> 287
/*     */     //   #73	-> 288
/*     */     //   #75	-> 303
/*     */     //   #76	-> 320
/*     */     //   #77	-> 337
/*     */     //   #78	-> 367
/*     */     //   #79	-> 383
/*     */     //   #80	-> 399
/*     */     //   #81	-> 412
/*     */     //   #82	-> 412
/*     */     //   #83	-> 494
/*     */     //   #84	-> 498
/*     */     //   #88	-> 503
/*     */     //   #89	-> 522
/*     */     //   #90	-> 530
/*     */     //   #91	-> 546
/*     */     //   #92	-> 551
/*     */     //   #94	-> 551
/*     */     //   #95	-> 551
/*     */     //   #92	-> 551
/*     */     //   #93	-> 613
/*     */     //   #92	-> 622
/*     */     //   #94	-> 630
/*     */     //   #95	-> 697
/*     */     //   #96	-> 720
/*     */     //   #97	-> 736
/*     */     //   #98	-> 740
/*     */     //   #102	-> 745
/*     */     //   #103	-> 766
/*     */     //   #104	-> 783
/*     */     //   #105	-> 799
/*     */     //   #106	-> 820
/*     */     //   #107	-> 834
/*     */     //   #108	-> 834
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   236	50	6	it	Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   239	47	7	$i$a$-let-Safeauramode$onUpdate$1	I
/*     */     //   337	498	5	antiFireBall	Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytAntiFireBall;
/*     */     //   320	515	4	ScaHelperNew	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew;
/*     */     //   303	532	3	aura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   51	784	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	835	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Safeauramode;
/*     */     //   0	835	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Safeauramode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */