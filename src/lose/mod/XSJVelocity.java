/*     */ package lose.mod;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.BlockBBEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "XSJVelocity", description = "Axe Client velocity .", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\020\007\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\004\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\032\032\0020\0332\006\020\034\032\0020\035H\007J\b\020\036\032\0020\033H\026J\b\020\037\032\0020\033H\026J\020\020 \032\0020\0332\006\020\034\032\0020!H\007J\020\020\"\032\0020\0332\006\020\034\032\0020#H\007J\020\020$\032\0020\0332\006\020\034\032\0020%H\007J\020\020&\032\0020\0332\006\020\034\032\0020'H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\034\020\005\032\004\030\0010\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\024\020\013\032\b\022\004\022\0020\r0\fX\004¢\006\002\n\000R\021\020\016\032\0020\017¢\006\b\n\000\032\004\b\020\020\021R\024\020\022\032\0020\0238VX\004¢\006\006\032\004\b\024\020\025R\016\020\026\032\0020\004X\016¢\006\002\n\000R\016\020\027\032\0020\030X\016¢\006\002\n\000R\024\020\031\032\b\022\004\022\0020\r0\fX\004¢\006\002\n\000¨\006("}, d2 = {"Llose/mod/XSJVelocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "attack", "", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "setBlock", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)V", "horizontalValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "tag", "", "getTag", "()Ljava/lang/String;", "velocityInput", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "verticalValue", "onBlockBB", "", "event", "Lnet/ccbluex/liquidbounce/event/BlockBBEvent;", "onDisable", "onEnable", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class XSJVelocity extends Module {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class XSJVelocity$horizontalValue$1 extends Lambda implements Function0<Boolean> {
/*  22 */     public final boolean invoke() { return Intrinsics.areEqual(XSJVelocity.this.getModeValue().get(), "Simple"); } XSJVelocity$horizontalValue$1() { super(0); }
/*  23 */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class XSJVelocity$verticalValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return Intrinsics.areEqual(XSJVelocity.this.getModeValue().get(), "Simple"); } XSJVelocity$verticalValue$1() { super(0); } } private final Value<Float> horizontalValue = (new FloatValue("Horizontal", 0.0F, 0.0F, 1.0F)).displayable(new XSJVelocity$horizontalValue$1()); private final Value<Float> verticalValue = (new FloatValue("Vertical", 0.0F, 0.0F, 1.0F)).displayable(new XSJVelocity$verticalValue$1()); @NotNull
/*  24 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Simple", "Jump", "Vanilla", "Axe" }, "Vanilla"); @Nullable private IBlock block; @NotNull public final ListValue getModeValue() { return this.modeValue; } @Nullable
/*  25 */   public final IBlock getBlock() { return this.block; } public final void setBlock(@Nullable IBlock <set-?>) { this.block = <set-?>; }
/*  26 */    private MSTimer velocityTimer = new MSTimer();
/*     */   private boolean attack;
/*     */   private boolean velocityInput;
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*  32 */     return (String)this.modeValue.get();
/*     */   }
/*     */   public void onDisable() {
/*  35 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); } else { MinecraftInstance.mc.getThePlayer(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEnable() {}
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  44 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  45 */       if (thePlayer.isInWater() || thePlayer.isInLava() || thePlayer.isInWeb()) {
/*     */         return;
/*     */       }
/*  48 */       String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */         case 3273774:
/*  50 */           if (str.equals("jump") && thePlayer.getHurtTime() > 0 && thePlayer.getOnGround())
/*  51 */           { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump(); }  break;
/*     */         case 66286:
/*  53 */           if (str.equals("Axe") && this.velocityInput && 
/*  54 */             this.attack) {
/*  55 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * 0.07776D);
/*  56 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() * 0.07776D);
/*  57 */             this.velocityInput = false;
/*  58 */             this.attack = false;
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @EventTarget
/*     */   public final void onBlockBB(@NotNull BlockBBEvent event) {
/*  66 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.block = event.getBlock();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/*  72 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  73 */     if (thePlayer == null || thePlayer.isInWater() || thePlayer.isInLava() || thePlayer.isInWeb()) {
/*     */       return;
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
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
/*     */     //   24: aload_1
/*     */     //   25: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   28: astore_3
/*     */     //   29: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   32: aload_3
/*     */     //   33: invokeinterface isSPacketEntityVelocity : (Ljava/lang/Object;)Z
/*     */     //   38: ifeq -> 863
/*     */     //   41: aload_3
/*     */     //   42: invokeinterface asSPacketEntityVelocity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   47: astore #4
/*     */     //   49: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   52: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   57: dup
/*     */     //   58: ifnull -> 80
/*     */     //   61: aload #4
/*     */     //   63: invokeinterface getEntityID : ()I
/*     */     //   68: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   73: dup
/*     */     //   74: ifnull -> 80
/*     */     //   77: goto -> 82
/*     */     //   80: pop
/*     */     //   81: return
/*     */     //   82: aload_2
/*     */     //   83: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   86: iconst_1
/*     */     //   87: ixor
/*     */     //   88: ifeq -> 92
/*     */     //   91: return
/*     */     //   92: aload_0
/*     */     //   93: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   96: invokevirtual reset : ()V
/*     */     //   99: aload_0
/*     */     //   100: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   103: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   106: checkcast java/lang/String
/*     */     //   109: astore #5
/*     */     //   111: iconst_0
/*     */     //   112: istore #6
/*     */     //   114: aload #5
/*     */     //   116: dup
/*     */     //   117: ifnonnull -> 130
/*     */     //   120: new kotlin/TypeCastException
/*     */     //   123: dup
/*     */     //   124: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   126: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   129: athrow
/*     */     //   130: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   133: dup
/*     */     //   134: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   136: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   139: astore #5
/*     */     //   141: aload #5
/*     */     //   143: invokevirtual hashCode : ()I
/*     */     //   146: lookupswitch default -> 863, -902286926 -> 172, 66286 -> 185
/*     */     //   172: aload #5
/*     */     //   174: ldc 'simple'
/*     */     //   176: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   179: ifeq -> 863
/*     */     //   182: goto -> 198
/*     */     //   185: aload #5
/*     */     //   187: ldc 'Axe'
/*     */     //   189: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   192: ifeq -> 863
/*     */     //   195: goto -> 306
/*     */     //   198: aload_0
/*     */     //   199: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   202: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   205: checkcast java/lang/Number
/*     */     //   208: invokevirtual floatValue : ()F
/*     */     //   211: fstore #6
/*     */     //   213: aload_0
/*     */     //   214: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   217: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   220: checkcast java/lang/Number
/*     */     //   223: invokevirtual floatValue : ()F
/*     */     //   226: fstore #7
/*     */     //   228: fload #6
/*     */     //   230: fconst_0
/*     */     //   231: fcmpg
/*     */     //   232: ifne -> 246
/*     */     //   235: fload #7
/*     */     //   237: fconst_0
/*     */     //   238: fcmpg
/*     */     //   239: ifne -> 246
/*     */     //   242: aload_1
/*     */     //   243: invokevirtual cancelEvent : ()V
/*     */     //   246: aload #4
/*     */     //   248: aload #4
/*     */     //   250: invokeinterface getMotionX : ()I
/*     */     //   255: i2f
/*     */     //   256: fload #6
/*     */     //   258: fmul
/*     */     //   259: f2i
/*     */     //   260: invokeinterface setMotionX : (I)V
/*     */     //   265: aload #4
/*     */     //   267: aload #4
/*     */     //   269: invokeinterface getMotionY : ()I
/*     */     //   274: i2f
/*     */     //   275: fload #7
/*     */     //   277: fmul
/*     */     //   278: f2i
/*     */     //   279: invokeinterface setMotionY : (I)V
/*     */     //   284: aload #4
/*     */     //   286: aload #4
/*     */     //   288: invokeinterface getMotionZ : ()I
/*     */     //   293: i2f
/*     */     //   294: fload #6
/*     */     //   296: fmul
/*     */     //   297: f2i
/*     */     //   298: invokeinterface setMotionZ : (I)V
/*     */     //   303: goto -> 863
/*     */     //   306: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   309: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   312: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   315: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   318: dup
/*     */     //   319: ifnonnull -> 333
/*     */     //   322: new kotlin/TypeCastException
/*     */     //   325: dup
/*     */     //   326: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   329: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   332: athrow
/*     */     //   333: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   336: astore #6
/*     */     //   338: aload_0
/*     */     //   339: iconst_1
/*     */     //   340: putfield velocityInput : Z
/*     */     //   343: aload #6
/*     */     //   345: invokevirtual getState : ()Z
/*     */     //   348: ifeq -> 863
/*     */     //   351: aload #6
/*     */     //   353: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   356: ifnull -> 863
/*     */     //   359: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   362: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   367: dup
/*     */     //   368: ifnonnull -> 374
/*     */     //   371: invokestatic throwNpe : ()V
/*     */     //   374: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   377: aload #6
/*     */     //   379: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   382: dup
/*     */     //   383: ifnonnull -> 389
/*     */     //   386: invokestatic throwNpe : ()V
/*     */     //   389: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   392: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   395: ldc2_w 3.0
/*     */     //   398: dcmpg
/*     */     //   399: ifgt -> 863
/*     */     //   402: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   405: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   410: dup
/*     */     //   411: ifnonnull -> 417
/*     */     //   414: invokestatic throwNpe : ()V
/*     */     //   417: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   422: invokeinterface getMoveForward : ()F
/*     */     //   427: ldc_w 0.9
/*     */     //   430: fcmpl
/*     */     //   431: ifle -> 616
/*     */     //   434: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   437: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   442: dup
/*     */     //   443: ifnonnull -> 449
/*     */     //   446: invokestatic throwNpe : ()V
/*     */     //   449: invokeinterface getSprinting : ()Z
/*     */     //   454: ifeq -> 616
/*     */     //   457: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   460: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   465: dup
/*     */     //   466: ifnonnull -> 472
/*     */     //   469: invokestatic throwNpe : ()V
/*     */     //   472: invokeinterface getServerSprintState : ()Z
/*     */     //   477: ifeq -> 616
/*     */     //   480: bipush #12
/*     */     //   482: istore #7
/*     */     //   484: iconst_0
/*     */     //   485: istore #8
/*     */     //   487: iconst_0
/*     */     //   488: istore #9
/*     */     //   490: iconst_0
/*     */     //   491: istore #9
/*     */     //   493: iload #7
/*     */     //   495: istore #10
/*     */     //   497: iload #9
/*     */     //   499: iload #10
/*     */     //   501: if_icmpge -> 608
/*     */     //   504: iload #9
/*     */     //   506: istore #11
/*     */     //   508: iconst_0
/*     */     //   509: istore #12
/*     */     //   511: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   514: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   519: dup
/*     */     //   520: ifnonnull -> 526
/*     */     //   523: invokestatic throwNpe : ()V
/*     */     //   526: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   531: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   534: aload #6
/*     */     //   536: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   539: dup
/*     */     //   540: ifnonnull -> 546
/*     */     //   543: invokestatic throwNpe : ()V
/*     */     //   546: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   549: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   552: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   557: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   560: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   565: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   568: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   573: dup
/*     */     //   574: ifnonnull -> 580
/*     */     //   577: invokestatic throwNpe : ()V
/*     */     //   580: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   585: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   588: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   593: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   596: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   601: nop
/*     */     //   602: iinc #9, 1
/*     */     //   605: goto -> 497
/*     */     //   608: aload_0
/*     */     //   609: iconst_1
/*     */     //   610: putfield attack : Z
/*     */     //   613: goto -> 863
/*     */     //   616: bipush #12
/*     */     //   618: istore #7
/*     */     //   620: iconst_0
/*     */     //   621: istore #8
/*     */     //   623: iconst_0
/*     */     //   624: istore #9
/*     */     //   626: iconst_0
/*     */     //   627: istore #9
/*     */     //   629: iload #7
/*     */     //   631: istore #10
/*     */     //   633: iload #9
/*     */     //   635: iload #10
/*     */     //   637: if_icmpge -> 858
/*     */     //   640: iload #9
/*     */     //   642: istore #11
/*     */     //   644: iconst_0
/*     */     //   645: istore #12
/*     */     //   647: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   650: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   655: dup
/*     */     //   656: ifnonnull -> 662
/*     */     //   659: invokestatic throwNpe : ()V
/*     */     //   662: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   667: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   670: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   673: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   678: dup
/*     */     //   679: ifnonnull -> 685
/*     */     //   682: invokestatic throwNpe : ()V
/*     */     //   685: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   688: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SPRINTING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   691: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   696: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   699: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   704: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   707: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   712: dup
/*     */     //   713: ifnonnull -> 719
/*     */     //   716: invokestatic throwNpe : ()V
/*     */     //   719: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   724: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   727: aload #6
/*     */     //   729: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   732: dup
/*     */     //   733: ifnonnull -> 739
/*     */     //   736: invokestatic throwNpe : ()V
/*     */     //   739: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   742: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   745: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   750: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   753: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   758: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   761: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   766: dup
/*     */     //   767: ifnonnull -> 773
/*     */     //   770: invokestatic throwNpe : ()V
/*     */     //   773: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   778: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   781: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   786: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   789: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   794: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   797: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   802: dup
/*     */     //   803: ifnonnull -> 809
/*     */     //   806: invokestatic throwNpe : ()V
/*     */     //   809: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   814: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   817: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   820: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   825: dup
/*     */     //   826: ifnonnull -> 832
/*     */     //   829: invokestatic throwNpe : ()V
/*     */     //   832: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   835: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SPRINTING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   838: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   843: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   846: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   851: nop
/*     */     //   852: iinc #9, 1
/*     */     //   855: goto -> 633
/*     */     //   858: aload_0
/*     */     //   859: iconst_1
/*     */     //   860: putfield attack : Z
/*     */     //   863: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #79	-> 6
/*     */     //   #79	-> 21
/*     */     //   #80	-> 24
/*     */     //   #81	-> 29
/*     */     //   #82	-> 41
/*     */     //   #85	-> 49
/*     */     //   #85	-> 80
/*     */     //   #86	-> 91
/*     */     //   #88	-> 92
/*     */     //   #90	-> 99
/*     */     //   #91	-> 172
/*     */     //   #102	-> 185
/*     */     //   #92	-> 198
/*     */     //   #93	-> 213
/*     */     //   #95	-> 228
/*     */     //   #96	-> 242
/*     */     //   #98	-> 246
/*     */     //   #99	-> 265
/*     */     //   #100	-> 284
/*     */     //   #103	-> 306
/*     */     //   #104	-> 338
/*     */     //   #105	-> 343
/*     */     //   #106	-> 402
/*     */     //   #107	-> 480
/*     */     //   #109	-> 511
/*     */     //   #110	-> 565
/*     */     //   #111	-> 601
/*     */     //   #107	-> 602
/*     */     //   #112	-> 608
/*     */     //   #114	-> 616
/*     */     //   #116	-> 647
/*     */     //   #117	-> 704
/*     */     //   #118	-> 758
/*     */     //   #119	-> 794
/*     */     //   #120	-> 851
/*     */     //   #114	-> 852
/*     */     //   #121	-> 858
/*     */     //   #122	-> 863
/*     */     //   #125	-> 863
/*     */     //   #127	-> 863
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   228	75	7	vertical	F
/*     */     //   213	90	6	horizontal	F
/*     */     //   508	93	11	it	I
/*     */     //   511	90	12	$i$a$-repeat-XSJVelocity$onPacket$1	I
/*     */     //   644	207	11	it	I
/*     */     //   647	204	12	$i$a$-repeat-XSJVelocity$onPacket$2	I
/*     */     //   338	525	6	killAura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   49	814	4	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   29	835	3	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   24	840	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	864	0	this	Llose/mod/XSJVelocity;
/*     */     //   0	864	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/* 131 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lose\mod\XSJVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */