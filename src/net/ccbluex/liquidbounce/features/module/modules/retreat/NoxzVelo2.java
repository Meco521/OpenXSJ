/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.Value;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketEntityAction;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NoxzVelo2", category = ModuleCategory.RETREAT, description = "By YunQing")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\b\n\000\n\002\020\007\n\002\b\002\n\002\020\013\n\002\b\007\n\002\030\002\n\002\b\t\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\033\032\0020\034H\026J\020\020\035\032\0020\0342\006\020\036\032\0020\037H\007J\020\020 \032\0020\0342\006\020\036\032\0020!H\007R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\006\032\b\022\004\022\0020\0070\004X\004¢\006\002\n\000R\024\020\b\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\016\020\017\032\0020\nX\016¢\006\002\n\000R\016\020\020\032\0020\005X\016¢\006\002\n\000R\016\020\021\032\0020\022X\016¢\006\002\n\000R\016\020\023\032\0020\022X\016¢\006\002\n\000R\016\020\024\032\0020\022X\016¢\006\002\n\000R\016\020\025\032\0020\022X\016¢\006\002\n\000R\016\020\026\032\0020\022X\016¢\006\002\n\000R\032\020\027\032\0020\nX\016¢\006\016\n\000\032\004\b\030\020\f\"\004\b\031\020\016R\024\020\032\032\b\022\004\022\0020\0070\004X\004¢\006\002\n\000¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NoxzVelo2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "c2d", "Lnet/ccbluex/liquidbounce/value/Value;", "", "c2r", "", "cd", "gotvelo", "", "getGotvelo", "()Z", "setGotvelo", "(Z)V", "hit", "hitd", "s1", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "s2", "s3", "sf1", "sf3", "sprint", "getSprint", "setSprint", "xz", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class NoxzVelo2 extends Module {
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 27 */   static final class NoxzVelo2$c2d$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)NoxzVelo2.this.s3.get()).booleanValue(); } NoxzVelo2$c2d$1() { super(0); } }
/* 28 */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class NoxzVelo2$c2r$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)NoxzVelo2.this.s3.get()).booleanValue(); } NoxzVelo2$c2r$1() { super(0); } }
/* 29 */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class NoxzVelo2$xz$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)NoxzVelo2.this.s3.get()).booleanValue(); }
/*    */     NoxzVelo2$xz$1() { super(0); } }
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 32 */   static final class NoxzVelo2$cd$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)NoxzVelo2.this.s2.get()).booleanValue(); } NoxzVelo2$cd$1() { super(0); } } private BoolValue sf3 = new BoolValue("S08Checker", false); private BoolValue sf1 = new BoolValue("OnlyGround", false); private BoolValue s3 = new BoolValue("SendC02", false); private final Value<Integer> c2d = (new IntegerValue("SendC02Count", 0, 0, 50)).displayable(new NoxzVelo2$c2d$1()); private final Value<Integer> cd = (new IntegerValue("CancelDelay", 0, 0, 9)).displayable(new NoxzVelo2$cd$1()); private final Value<Float> c2r = (new FloatValue("SendC02Range", 3.0F, 0.0F, 6.0F)).displayable(new NoxzVelo2$c2r$1()); private final Value<Float> xz = (new FloatValue("XzVelo", 0.0F, 0.0F, 1.0F)).displayable(new NoxzVelo2$xz$1()); private BoolValue s1 = new BoolValue("SendSprintOnHurt", false); private BoolValue s2 = new BoolValue("CancelSprint", false); private boolean hit; private int hitd; private boolean sprint; private boolean gotvelo;
/*    */   
/*    */   public final boolean getSprint() {
/* 35 */     return this.sprint; } public final void setSprint(boolean <set-?>) { this.sprint = <set-?>; }
/* 36 */   public final boolean getGotvelo() { return this.gotvelo; } public final void setGotvelo(boolean <set-?>) { this.gotvelo = <set-?>; }
/*    */    public void onEnable() {
/* 38 */     this.hitd = 2;
/* 39 */     this.hit = false;
/* 40 */     this.gotvelo = false;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 45 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInWater()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInLava()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInWeb()) {
/*    */           
/* 47 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.sprint = (MinecraftInstance.mc.getThePlayer().getMovementInput().getMoveForward() > 1.0F && MinecraftInstance.mc.getGameSettings().getKeyBindForward().isKeyDown());
/* 48 */           if (this.gotvelo && (this.sprint || this.hitd == 1)) {
/* 49 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * ((Number)this.xz.get()).doubleValue());
/* 50 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() * ((Number)this.xz.get()).doubleValue());
/* 51 */             this.gotvelo = false;
/*    */           } 
/* 53 */           if (((Boolean)this.s2.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() == ((Number)this.cd.get()).intValue() && this.hitd == 1 && !this.sprint) {
/* 54 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_147114_u(), "mc2.connection!!"); MinecraftInstance.mc2.func_147114_u().func_147298_b().func_179290_a(
/* 55 */                   (Packet)new CPacketEntityAction(
/* 56 */                     (Entity)MinecraftInstance.mc2.field_71439_g, 
/* 57 */                     CPacketEntityAction.Action.STOP_SPRINTING));
/*    */ 
/*    */               
/* 60 */               this.hitd = 2;
/*    */             }  }
/*    */           
/*    */           return;
/*    */         }  }
/*    */        }
/*    */   
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getfield sf1 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   13: checkcast java/lang/Boolean
/*    */     //   16: invokevirtual booleanValue : ()Z
/*    */     //   19: ifeq -> 46
/*    */     //   22: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   25: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   30: dup
/*    */     //   31: ifnonnull -> 37
/*    */     //   34: invokestatic throwNpe : ()V
/*    */     //   37: invokeinterface getOnGround : ()Z
/*    */     //   42: ifne -> 46
/*    */     //   45: return
/*    */     //   46: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   49: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   54: dup
/*    */     //   55: ifnonnull -> 61
/*    */     //   58: invokestatic throwNpe : ()V
/*    */     //   61: invokeinterface isInWater : ()Z
/*    */     //   66: ifne -> 115
/*    */     //   69: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   72: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   77: dup
/*    */     //   78: ifnonnull -> 84
/*    */     //   81: invokestatic throwNpe : ()V
/*    */     //   84: invokeinterface isInLava : ()Z
/*    */     //   89: ifne -> 115
/*    */     //   92: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   95: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   100: dup
/*    */     //   101: ifnonnull -> 107
/*    */     //   104: invokestatic throwNpe : ()V
/*    */     //   107: invokeinterface isInWeb : ()Z
/*    */     //   112: ifeq -> 116
/*    */     //   115: return
/*    */     //   116: aload_1
/*    */     //   117: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   120: astore_3
/*    */     //   121: iconst_0
/*    */     //   122: istore #4
/*    */     //   124: aload_3
/*    */     //   125: dup
/*    */     //   126: ifnonnull -> 139
/*    */     //   129: new kotlin/TypeCastException
/*    */     //   132: dup
/*    */     //   133: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*    */     //   135: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   138: athrow
/*    */     //   139: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*    */     //   142: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*    */     //   145: astore_2
/*    */     //   146: aload_1
/*    */     //   147: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   150: astore_3
/*    */     //   151: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   154: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   157: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   160: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   163: dup
/*    */     //   164: ifnonnull -> 178
/*    */     //   167: new kotlin/TypeCastException
/*    */     //   170: dup
/*    */     //   171: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*    */     //   174: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   177: athrow
/*    */     //   178: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   181: astore #4
/*    */     //   183: aload_0
/*    */     //   184: getfield sf3 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   187: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   190: checkcast java/lang/Boolean
/*    */     //   193: invokevirtual booleanValue : ()Z
/*    */     //   196: ifeq -> 212
/*    */     //   199: aload_2
/*    */     //   200: instanceof net/minecraft/network/play/server/SPacketPlayerPosLook
/*    */     //   203: ifeq -> 212
/*    */     //   206: ldc_w '[Velocity]Check S08 Packet.'
/*    */     //   209: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   212: aload_2
/*    */     //   213: instanceof net/minecraft/network/play/client/CPacketEntityAction
/*    */     //   216: ifeq -> 256
/*    */     //   219: aload_0
/*    */     //   220: getfield hitd : I
/*    */     //   223: iconst_1
/*    */     //   224: if_icmpne -> 256
/*    */     //   227: aload_2
/*    */     //   228: checkcast net/minecraft/network/play/client/CPacketEntityAction
/*    */     //   231: invokevirtual func_180764_b : ()Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*    */     //   234: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*    */     //   237: if_acmpne -> 256
/*    */     //   240: aload_0
/*    */     //   241: getfield sprint : Z
/*    */     //   244: ifeq -> 256
/*    */     //   247: aload_1
/*    */     //   248: invokevirtual cancelEvent : ()V
/*    */     //   251: aload_0
/*    */     //   252: iconst_2
/*    */     //   253: putfield hitd : I
/*    */     //   256: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   259: aload_3
/*    */     //   260: invokeinterface isSPacketEntityVelocity : (Ljava/lang/Object;)Z
/*    */     //   265: ifeq -> 648
/*    */     //   268: aload_3
/*    */     //   269: invokeinterface asSPacketEntityVelocity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*    */     //   274: astore #5
/*    */     //   276: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   279: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   284: dup
/*    */     //   285: ifnull -> 307
/*    */     //   288: aload #5
/*    */     //   290: invokeinterface getEntityID : ()I
/*    */     //   295: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   300: dup
/*    */     //   301: ifnull -> 307
/*    */     //   304: goto -> 309
/*    */     //   307: pop
/*    */     //   308: return
/*    */     //   309: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   312: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   317: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   320: iconst_1
/*    */     //   321: ixor
/*    */     //   322: ifeq -> 326
/*    */     //   325: return
/*    */     //   326: aload #4
/*    */     //   328: invokevirtual getState : ()Z
/*    */     //   331: ifeq -> 648
/*    */     //   334: aload #4
/*    */     //   336: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   339: ifnull -> 648
/*    */     //   342: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   345: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   350: dup
/*    */     //   351: ifnonnull -> 357
/*    */     //   354: invokestatic throwNpe : ()V
/*    */     //   357: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   360: aload #4
/*    */     //   362: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   365: dup
/*    */     //   366: ifnonnull -> 372
/*    */     //   369: invokestatic throwNpe : ()V
/*    */     //   372: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   375: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   378: aload_0
/*    */     //   379: getfield c2r : Lnet/ccbluex/liquidbounce/value/Value;
/*    */     //   382: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   385: checkcast java/lang/Number
/*    */     //   388: invokevirtual doubleValue : ()D
/*    */     //   391: dcmpg
/*    */     //   392: ifgt -> 648
/*    */     //   395: aload_0
/*    */     //   396: getfield s3 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   399: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   402: checkcast java/lang/Boolean
/*    */     //   405: invokevirtual booleanValue : ()Z
/*    */     //   408: ifeq -> 648
/*    */     //   411: aload_0
/*    */     //   412: iconst_1
/*    */     //   413: putfield gotvelo : Z
/*    */     //   416: aload_0
/*    */     //   417: getfield s1 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   420: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   423: checkcast java/lang/Boolean
/*    */     //   426: invokevirtual booleanValue : ()Z
/*    */     //   429: ifeq -> 509
/*    */     //   432: aload_0
/*    */     //   433: getfield hitd : I
/*    */     //   436: iconst_2
/*    */     //   437: if_icmpne -> 509
/*    */     //   440: aload_0
/*    */     //   441: getfield sprint : Z
/*    */     //   444: ifne -> 509
/*    */     //   447: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   450: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   455: dup
/*    */     //   456: ifnonnull -> 462
/*    */     //   459: invokestatic throwNpe : ()V
/*    */     //   462: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   467: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   470: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   473: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   478: dup
/*    */     //   479: ifnonnull -> 485
/*    */     //   482: invokestatic throwNpe : ()V
/*    */     //   485: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   488: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SPRINTING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*    */     //   491: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*    */     //   496: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   499: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   504: aload_0
/*    */     //   505: iconst_1
/*    */     //   506: putfield hitd : I
/*    */     //   509: aload_0
/*    */     //   510: getfield c2d : Lnet/ccbluex/liquidbounce/value/Value;
/*    */     //   513: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   516: checkcast java/lang/Number
/*    */     //   519: invokevirtual intValue : ()I
/*    */     //   522: istore #6
/*    */     //   524: iconst_0
/*    */     //   525: istore #7
/*    */     //   527: iconst_0
/*    */     //   528: istore #8
/*    */     //   530: iconst_0
/*    */     //   531: istore #8
/*    */     //   533: iload #6
/*    */     //   535: istore #9
/*    */     //   537: iload #8
/*    */     //   539: iload #9
/*    */     //   541: if_icmpge -> 648
/*    */     //   544: iload #8
/*    */     //   546: istore #10
/*    */     //   548: iconst_0
/*    */     //   549: istore #11
/*    */     //   551: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   554: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   559: dup
/*    */     //   560: ifnonnull -> 566
/*    */     //   563: invokestatic throwNpe : ()V
/*    */     //   566: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   571: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   574: aload #4
/*    */     //   576: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   579: dup
/*    */     //   580: ifnonnull -> 586
/*    */     //   583: invokestatic throwNpe : ()V
/*    */     //   586: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   589: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*    */     //   592: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*    */     //   597: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   600: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   605: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   608: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   613: dup
/*    */     //   614: ifnonnull -> 620
/*    */     //   617: invokestatic throwNpe : ()V
/*    */     //   620: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   625: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   628: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*    */     //   633: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   636: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   641: nop
/*    */     //   642: iinc #8, 1
/*    */     //   645: goto -> 537
/*    */     //   648: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #66	-> 6
/*    */     //   #67	-> 46
/*    */     //   #68	-> 115
/*    */     //   #69	-> 116
/*    */     //   #104	-> 124
/*    */     //   #69	-> 145
/*    */     //   #70	-> 146
/*    */     //   #71	-> 151
/*    */     //   #72	-> 183
/*    */     //   #73	-> 206
/*    */     //   #75	-> 212
/*    */     //   #76	-> 227
/*    */     //   #77	-> 247
/*    */     //   #78	-> 251
/*    */     //   #81	-> 256
/*    */     //   #82	-> 268
/*    */     //   #83	-> 276
/*    */     //   #83	-> 307
/*    */     //   #84	-> 326
/*    */     //   #85	-> 411
/*    */     //   #86	-> 416
/*    */     //   #87	-> 447
/*    */     //   #88	-> 488
/*    */     //   #87	-> 491
/*    */     //   #89	-> 504
/*    */     //   #91	-> 509
/*    */     //   #92	-> 551
/*    */     //   #93	-> 571
/*    */     //   #94	-> 574
/*    */     //   #95	-> 589
/*    */     //   #93	-> 592
/*    */     //   #92	-> 600
/*    */     //   #98	-> 605
/*    */     //   #99	-> 641
/*    */     //   #91	-> 642
/*    */     //   #102	-> 648
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   121	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   124	21	4	$i$f$unwrap	I
/*    */     //   548	93	10	it	I
/*    */     //   551	90	11	$i$a$-repeat-NoxzVelo2$onPacket$1	I
/*    */     //   276	372	5	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*    */     //   183	466	4	a	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*    */     //   151	498	3	p2	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   146	503	2	packet	Lnet/minecraft/network/Packet;
/*    */     //   0	649	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NoxzVelo2;
/*    */     //   0	649	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\NoxzVelo2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */