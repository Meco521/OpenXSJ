/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.vulcan;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\020\020\007\032\0020\0062\006\020\b\032\0020\tH\026J\b\020\n\032\0020\006H\026J\b\020\013\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanHopSpeed;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "wasTimer", "", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class VulcanHopSpeed extends SpeedMode {
/*    */   public VulcanHopSpeed() {
/*  9 */     super("VulcanHopSpeed");
/*    */   } private boolean wasTimer;
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 14 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */   
/*    */   public void onUpdate() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield wasTimer : Z
/*    */     //   4: ifeq -> 26
/*    */     //   7: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   10: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*    */     //   15: fconst_1
/*    */     //   16: invokeinterface setTimerSpeed : (F)V
/*    */     //   21: aload_0
/*    */     //   22: iconst_0
/*    */     //   23: putfield wasTimer : Z
/*    */     //   26: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.targetRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   29: ifnonnull -> 63
/*    */     //   32: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   35: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   40: dup
/*    */     //   41: ifnonnull -> 47
/*    */     //   44: invokestatic throwNpe : ()V
/*    */     //   47: invokeinterface getMoveStrafing : ()F
/*    */     //   52: invokestatic abs : (F)F
/*    */     //   55: f2d
/*    */     //   56: ldc2_w 0.1
/*    */     //   59: dcmpg
/*    */     //   60: iflt -> 93
/*    */     //   63: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.targetRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   66: ifnull -> 118
/*    */     //   69: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*    */     //   72: invokevirtual getMovingYaw : ()F
/*    */     //   75: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.targetRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*    */     //   78: invokevirtual getYaw : ()F
/*    */     //   81: invokestatic getAngleDifferencee : (FF)F
/*    */     //   84: invokestatic abs : (F)F
/*    */     //   87: ldc 45.0
/*    */     //   89: fcmpg
/*    */     //   90: ifge -> 118
/*    */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   96: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   101: dup
/*    */     //   102: ifnonnull -> 108
/*    */     //   105: invokestatic throwNpe : ()V
/*    */     //   108: ldc 0.026499
/*    */     //   110: invokeinterface setJumpMovementFactor : (F)V
/*    */     //   115: goto -> 140
/*    */     //   118: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   121: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   126: dup
/*    */     //   127: ifnonnull -> 133
/*    */     //   130: invokestatic throwNpe : ()V
/*    */     //   133: ldc 0.0244
/*    */     //   135: invokeinterface setJumpMovementFactor : (F)V
/*    */     //   140: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   143: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   148: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   153: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   156: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   161: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   164: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   169: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   174: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   179: invokeinterface setPressed : (Z)V
/*    */     //   184: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*    */     //   187: invokevirtual getSpeed : ()F
/*    */     //   190: ldc 0.215
/*    */     //   192: fcmpg
/*    */     //   193: ifge -> 224
/*    */     //   196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   199: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   204: dup
/*    */     //   205: ifnonnull -> 211
/*    */     //   208: invokestatic throwNpe : ()V
/*    */     //   211: invokeinterface getOnGround : ()Z
/*    */     //   216: ifne -> 224
/*    */     //   219: ldc 0.215
/*    */     //   221: invokestatic strafe : (F)V
/*    */     //   224: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   227: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   232: dup
/*    */     //   233: ifnonnull -> 239
/*    */     //   236: invokestatic throwNpe : ()V
/*    */     //   239: invokeinterface getOnGround : ()Z
/*    */     //   244: ifeq -> 362
/*    */     //   247: invokestatic isMoving : ()Z
/*    */     //   250: ifeq -> 362
/*    */     //   253: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   256: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   261: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   266: iconst_0
/*    */     //   267: invokeinterface setPressed : (Z)V
/*    */     //   272: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   275: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   280: dup
/*    */     //   281: ifnonnull -> 287
/*    */     //   284: invokestatic throwNpe : ()V
/*    */     //   287: invokeinterface jump : ()V
/*    */     //   292: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   295: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   300: dup
/*    */     //   301: ifnonnull -> 307
/*    */     //   304: invokestatic throwNpe : ()V
/*    */     //   307: invokeinterface isAirBorne : ()Z
/*    */     //   312: ifne -> 316
/*    */     //   315: return
/*    */     //   316: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   319: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*    */     //   324: ldc 1.25
/*    */     //   326: invokeinterface setTimerSpeed : (F)V
/*    */     //   331: aload_0
/*    */     //   332: iconst_1
/*    */     //   333: putfield wasTimer : Z
/*    */     //   336: fconst_0
/*    */     //   337: iconst_1
/*    */     //   338: aconst_null
/*    */     //   339: invokestatic strafe$default : (FILjava/lang/Object;)V
/*    */     //   342: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*    */     //   345: invokevirtual getSpeed : ()F
/*    */     //   348: ldc 0.5
/*    */     //   350: fcmpg
/*    */     //   351: ifge -> 424
/*    */     //   354: ldc 0.4849
/*    */     //   356: invokestatic strafe : (F)V
/*    */     //   359: goto -> 424
/*    */     //   362: invokestatic isMoving : ()Z
/*    */     //   365: ifne -> 424
/*    */     //   368: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   371: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*    */     //   376: fconst_1
/*    */     //   377: invokeinterface setTimerSpeed : (F)V
/*    */     //   382: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   385: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   390: dup
/*    */     //   391: ifnonnull -> 397
/*    */     //   394: invokestatic throwNpe : ()V
/*    */     //   397: dconst_0
/*    */     //   398: invokeinterface setMotionX : (D)V
/*    */     //   403: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   406: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   411: dup
/*    */     //   412: ifnonnull -> 418
/*    */     //   415: invokestatic throwNpe : ()V
/*    */     //   418: dconst_0
/*    */     //   419: invokeinterface setMotionZ : (D)V
/*    */     //   424: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #16	-> 0
/*    */     //   #17	-> 7
/*    */     //   #18	-> 21
/*    */     //   #20	-> 26
/*    */     //   #21	-> 93
/*    */     //   #23	-> 118
/*    */     //   #24	-> 140
/*    */     //   #25	-> 140
/*    */     //   #27	-> 184
/*    */     //   #28	-> 219
/*    */     //   #30	-> 224
/*    */     //   #31	-> 253
/*    */     //   #32	-> 272
/*    */     //   #33	-> 292
/*    */     //   #34	-> 315
/*    */     //   #36	-> 316
/*    */     //   #37	-> 331
/*    */     //   #38	-> 336
/*    */     //   #39	-> 342
/*    */     //   #40	-> 354
/*    */     //   #42	-> 362
/*    */     //   #43	-> 368
/*    */     //   #44	-> 382
/*    */     //   #45	-> 403
/*    */     //   #46	-> 424
/*    */     //   #47	-> 424
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	425	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanHopSpeed;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\vulcan\VulcanHopSpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */