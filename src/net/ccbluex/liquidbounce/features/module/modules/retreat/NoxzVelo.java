/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NoxzVelo", description = "by 理塘丁真", category = ModuleCategory.RETREAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\002\b\f\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\035\032\0020\036H\026J\020\020\037\032\0020\0362\006\020 \032\0020!H\007J\020\020\"\032\0020\0362\006\020 \032\0020#H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\016\020\016\032\0020\004X\016¢\006\002\n\000R\032\020\017\032\0020\tX\016¢\006\016\n\000\032\004\b\020\020\013\"\004\b\021\020\rR\032\020\022\032\0020\tX\016¢\006\016\n\000\032\004\b\023\020\013\"\004\b\024\020\rR\032\020\025\032\0020\026X\016¢\006\016\n\000\032\004\b\027\020\030\"\004\b\031\020\032R\016\020\033\032\0020\034X\004¢\006\002\n\000¨\006$"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NoxzVelo;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autosprint", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "c02", "disdelay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "gotvelo", "", "getGotvelo", "()Z", "setGotvelo", "(Z)V", "novelo", "sent", "getSent", "setSent", "sprint", "getSprint", "setSprint", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getVelocityTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "setVelocityTimer", "(Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;)V", "xz", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onDisable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class NoxzVelo
/*    */   extends Module
/*    */ {
/* 22 */   private BoolValue autosprint = new BoolValue("AutoSprint ", false);
/* 23 */   private BoolValue novelo = new BoolValue("NoxzVelo", false);
/* 24 */   private final FloatValue xz = new FloatValue("XZ", 0.79F, 0.0F, 1.0F);
/* 25 */   private BoolValue c02 = new BoolValue("C02", false);
/* 26 */   private IntegerValue disdelay = new IntegerValue("disdelay", 0, 0, 100); private boolean sent; private boolean gotvelo;
/* 27 */   public final boolean getSent() { return this.sent; } public final void setSent(boolean <set-?>) { this.sent = <set-?>; }
/* 28 */   public final boolean getGotvelo() { return this.gotvelo; } public final void setGotvelo(boolean <set-?>) { this.gotvelo = <set-?>; } private boolean sprint; @NotNull
/* 29 */   private MSTimer velocityTimer = new MSTimer(); @NotNull public final MSTimer getVelocityTimer() { return this.velocityTimer; } public final void setVelocityTimer(@NotNull MSTimer <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.velocityTimer = <set-?>; }
/* 30 */   public final boolean getSprint() { return this.sprint; } public final void setSprint(boolean <set-?>) { this.sprint = <set-?>; }
/*    */    public void onDisable() {
/* 32 */     this.sent = false;
/* 33 */     this.velocityTimer.reset();
/* 34 */     this.gotvelo = false;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   10: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   15: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   20: invokeinterface isKeyDown : ()Z
/*    */     //   25: ifeq -> 63
/*    */     //   28: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   31: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   36: dup
/*    */     //   37: ifnonnull -> 43
/*    */     //   40: invokestatic throwNpe : ()V
/*    */     //   43: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*    */     //   48: invokeinterface getMoveForward : ()F
/*    */     //   53: ldc 0.8
/*    */     //   55: fcmpl
/*    */     //   56: ifle -> 63
/*    */     //   59: iconst_1
/*    */     //   60: goto -> 64
/*    */     //   63: iconst_0
/*    */     //   64: putfield sprint : Z
/*    */     //   67: aload_0
/*    */     //   68: getfield gotvelo : Z
/*    */     //   71: ifeq -> 189
/*    */     //   74: aload_0
/*    */     //   75: getfield novelo : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   78: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   81: checkcast java/lang/Boolean
/*    */     //   84: invokevirtual booleanValue : ()Z
/*    */     //   87: ifeq -> 189
/*    */     //   90: aload_0
/*    */     //   91: getfield sent : Z
/*    */     //   94: ifne -> 104
/*    */     //   97: aload_0
/*    */     //   98: getfield sprint : Z
/*    */     //   101: ifeq -> 189
/*    */     //   104: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   107: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   112: dup
/*    */     //   113: ifnonnull -> 119
/*    */     //   116: invokestatic throwNpe : ()V
/*    */     //   119: dup
/*    */     //   120: invokeinterface getMotionX : ()D
/*    */     //   125: aload_0
/*    */     //   126: getfield xz : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   129: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   132: checkcast java/lang/Number
/*    */     //   135: invokevirtual doubleValue : ()D
/*    */     //   138: dmul
/*    */     //   139: invokeinterface setMotionX : (D)V
/*    */     //   144: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   147: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   152: dup
/*    */     //   153: ifnonnull -> 159
/*    */     //   156: invokestatic throwNpe : ()V
/*    */     //   159: dup
/*    */     //   160: invokeinterface getMotionZ : ()D
/*    */     //   165: aload_0
/*    */     //   166: getfield xz : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   169: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   172: checkcast java/lang/Number
/*    */     //   175: invokevirtual doubleValue : ()D
/*    */     //   178: dmul
/*    */     //   179: invokeinterface setMotionZ : (D)V
/*    */     //   184: aload_0
/*    */     //   185: iconst_0
/*    */     //   186: putfield gotvelo : Z
/*    */     //   189: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #39	-> 6
/*    */     //   #40	-> 67
/*    */     //   #41	-> 104
/*    */     //   #42	-> 144
/*    */     //   #43	-> 184
/*    */     //   #45	-> 189
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	190	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NoxzVelo;
/*    */     //   0	190	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_1
/*    */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   10: astore_3
/*    */     //   11: iconst_0
/*    */     //   12: istore #4
/*    */     //   14: aload_3
/*    */     //   15: dup
/*    */     //   16: ifnonnull -> 29
/*    */     //   19: new kotlin/TypeCastException
/*    */     //   22: dup
/*    */     //   23: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*    */     //   25: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   28: athrow
/*    */     //   29: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*    */     //   32: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*    */     //   35: astore_2
/*    */     //   36: aload_1
/*    */     //   37: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   40: astore_3
/*    */     //   41: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   44: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   47: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   49: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   52: dup
/*    */     //   53: ifnonnull -> 66
/*    */     //   56: new kotlin/TypeCastException
/*    */     //   59: dup
/*    */     //   60: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*    */     //   62: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   65: athrow
/*    */     //   66: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   69: astore #4
/*    */     //   71: aload_0
/*    */     //   72: getfield sent : Z
/*    */     //   75: ifeq -> 114
/*    */     //   78: aload_0
/*    */     //   79: getfield sprint : Z
/*    */     //   82: ifeq -> 114
/*    */     //   85: aload_2
/*    */     //   86: instanceof net/minecraft/network/play/client/CPacketEntityAction
/*    */     //   89: ifeq -> 114
/*    */     //   92: aload_2
/*    */     //   93: checkcast net/minecraft/network/play/client/CPacketEntityAction
/*    */     //   96: invokevirtual func_180764_b : ()Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*    */     //   99: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*    */     //   102: if_acmpne -> 114
/*    */     //   105: aload_1
/*    */     //   106: invokevirtual cancelEvent : ()V
/*    */     //   109: aload_0
/*    */     //   110: iconst_0
/*    */     //   111: putfield sent : Z
/*    */     //   114: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   117: aload_3
/*    */     //   118: invokeinterface isSPacketEntityVelocity : (Ljava/lang/Object;)Z
/*    */     //   123: ifeq -> 491
/*    */     //   126: aload_3
/*    */     //   127: invokeinterface asSPacketEntityVelocity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*    */     //   132: astore #5
/*    */     //   134: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   137: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   142: dup
/*    */     //   143: ifnull -> 165
/*    */     //   146: aload #5
/*    */     //   148: invokeinterface getEntityID : ()I
/*    */     //   153: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   158: dup
/*    */     //   159: ifnull -> 165
/*    */     //   162: goto -> 167
/*    */     //   165: pop
/*    */     //   166: return
/*    */     //   167: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   170: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   175: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   178: iconst_1
/*    */     //   179: ixor
/*    */     //   180: ifeq -> 184
/*    */     //   183: return
/*    */     //   184: aload_0
/*    */     //   185: getfield sprint : Z
/*    */     //   188: ifne -> 276
/*    */     //   191: aload_0
/*    */     //   192: getfield sent : Z
/*    */     //   195: ifne -> 276
/*    */     //   198: aload_0
/*    */     //   199: getfield autosprint : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   202: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   205: checkcast java/lang/Boolean
/*    */     //   208: invokevirtual booleanValue : ()Z
/*    */     //   211: ifeq -> 276
/*    */     //   214: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   217: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   222: dup
/*    */     //   223: ifnonnull -> 229
/*    */     //   226: invokestatic throwNpe : ()V
/*    */     //   229: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   234: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   237: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   240: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   245: dup
/*    */     //   246: ifnonnull -> 252
/*    */     //   249: invokestatic throwNpe : ()V
/*    */     //   252: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   255: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SPRINTING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*    */     //   258: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*    */     //   263: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   266: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   271: aload_0
/*    */     //   272: iconst_1
/*    */     //   273: putfield sent : Z
/*    */     //   276: aload_0
/*    */     //   277: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   280: invokevirtual reset : ()V
/*    */     //   283: aload_0
/*    */     //   284: getfield c02 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   287: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   290: checkcast java/lang/Boolean
/*    */     //   293: invokevirtual booleanValue : ()Z
/*    */     //   296: ifeq -> 491
/*    */     //   299: aload #4
/*    */     //   301: invokevirtual getState : ()Z
/*    */     //   304: ifeq -> 491
/*    */     //   307: aload #4
/*    */     //   309: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   312: ifnull -> 491
/*    */     //   315: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   318: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   323: dup
/*    */     //   324: ifnonnull -> 330
/*    */     //   327: invokestatic throwNpe : ()V
/*    */     //   330: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   333: aload #4
/*    */     //   335: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   338: dup
/*    */     //   339: ifnonnull -> 345
/*    */     //   342: invokestatic throwNpe : ()V
/*    */     //   345: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   348: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   351: ldc2_w 3.0
/*    */     //   354: dcmpg
/*    */     //   355: ifgt -> 491
/*    */     //   358: bipush #6
/*    */     //   360: istore #6
/*    */     //   362: iconst_0
/*    */     //   363: istore #7
/*    */     //   365: iconst_0
/*    */     //   366: istore #8
/*    */     //   368: iconst_0
/*    */     //   369: istore #8
/*    */     //   371: iload #6
/*    */     //   373: istore #9
/*    */     //   375: iload #8
/*    */     //   377: iload #9
/*    */     //   379: if_icmpge -> 486
/*    */     //   382: iload #8
/*    */     //   384: istore #10
/*    */     //   386: iconst_0
/*    */     //   387: istore #11
/*    */     //   389: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   392: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   397: dup
/*    */     //   398: ifnonnull -> 404
/*    */     //   401: invokestatic throwNpe : ()V
/*    */     //   404: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   409: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   412: aload #4
/*    */     //   414: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   417: dup
/*    */     //   418: ifnonnull -> 424
/*    */     //   421: invokestatic throwNpe : ()V
/*    */     //   424: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   427: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*    */     //   430: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*    */     //   435: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   438: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   443: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   446: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   451: dup
/*    */     //   452: ifnonnull -> 458
/*    */     //   455: invokestatic throwNpe : ()V
/*    */     //   458: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   463: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   466: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*    */     //   471: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   474: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   479: nop
/*    */     //   480: iinc #8, 1
/*    */     //   483: goto -> 375
/*    */     //   486: aload_0
/*    */     //   487: iconst_1
/*    */     //   488: putfield gotvelo : Z
/*    */     //   491: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #49	-> 6
/*    */     //   #85	-> 14
/*    */     //   #49	-> 35
/*    */     //   #50	-> 36
/*    */     //   #51	-> 41
/*    */     //   #52	-> 71
/*    */     //   #53	-> 85
/*    */     //   #54	-> 92
/*    */     //   #55	-> 105
/*    */     //   #56	-> 109
/*    */     //   #60	-> 114
/*    */     //   #61	-> 126
/*    */     //   #62	-> 134
/*    */     //   #62	-> 165
/*    */     //   #63	-> 184
/*    */     //   #64	-> 214
/*    */     //   #65	-> 271
/*    */     //   #67	-> 276
/*    */     //   #68	-> 283
/*    */     //   #69	-> 358
/*    */     //   #70	-> 389
/*    */     //   #71	-> 409
/*    */     //   #72	-> 412
/*    */     //   #73	-> 427
/*    */     //   #71	-> 430
/*    */     //   #70	-> 438
/*    */     //   #76	-> 443
/*    */     //   #77	-> 479
/*    */     //   #69	-> 480
/*    */     //   #78	-> 486
/*    */     //   #81	-> 491
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   14	21	4	$i$f$unwrap	I
/*    */     //   386	93	10	it	I
/*    */     //   389	90	11	$i$a$-repeat-NoxzVelo$onPacket$1	I
/*    */     //   134	357	5	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*    */     //   71	421	4	a	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*    */     //   41	451	3	p2	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   36	456	2	packet	Lnet/minecraft/network/Packet;
/*    */     //   0	492	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/NoxzVelo;
/*    */     //   0	492	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\NoxzVelo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */