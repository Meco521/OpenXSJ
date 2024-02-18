/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "SkidHYTVelocity", description = "Allows you to modify the amount of knockback you take.", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\007\n\002\020\b\n\000\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020!\032\0020\"H\026J\b\020#\032\0020\"H\026J\020\020$\032\0020\"2\006\020%\032\0020&H\007J\020\020'\032\0020\"2\006\020%\032\0020(H\007J\020\020)\032\0020\"2\006\020%\032\0020*H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\016\020\r\032\0020\004X\004¢\006\002\n\000R\016\020\016\032\0020\bX\016¢\006\002\n\000R\016\020\017\032\0020\020X\016¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\bX\016¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\024\020\027\032\0020\0308VX\004¢\006\006\032\004\b\031\020\032R\016\020\033\032\0020\bX\016¢\006\002\n\000R\016\020\034\032\0020\bX\016¢\006\002\n\000R\016\020\035\032\0020\036X\016¢\006\002\n\000R\016\020\037\032\0020\004X\004¢\006\002\n\000R\016\020 \032\0020\006X\004¢\006\002\n\000¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SkidHYTVelocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aacPushXZReducerValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "aacPushYReducerValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "dosprint", "", "getDosprint", "()Z", "setDosprint", "(Z)V", "horizontalValue", "jump", "jumped", "", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msValue", "reverse2StrengthValue", "reverseHurt", "reverseStrengthValue", "tag", "", "getTag", "()Ljava/lang/String;", "velocityInput", "velocityInput2", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "verticalValue", "wtapreduce", "onDisable", "", "onEnable", "onJump", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class SkidHYTVelocity
/*     */   extends Module
/*     */ {
/*  28 */   private final FloatValue horizontalValue = new FloatValue("Horizontal", 0.0F, 0.0F, 1.0F);
/*  29 */   private final FloatValue verticalValue = new FloatValue("Vertical", 0.0F, 0.0F, 1.0F);
/*  30 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Simple", "AAC", "AACPush", "AACZero", 
/*  31 */         "Reverse", "SmoothReverse", "Jump", "Glitch", "Smart" }, "Smart");
/*     */ 
/*     */   
/*  34 */   private final FloatValue reverseStrengthValue = new FloatValue("ReverseStrength", 1.0F, 0.1F, 1.0F);
/*  35 */   private final FloatValue reverse2StrengthValue = new FloatValue("SmoothReverseStrength", 0.05F, 0.02F, 0.1F);
/*     */ 
/*     */   
/*  38 */   private final FloatValue aacPushXZReducerValue = new FloatValue("AACPushXZReducer", 2.0F, 1.0F, 3.0F);
/*  39 */   private final FloatValue msValue = new FloatValue("msValue", 80.0F, 1.0F, 500.0F);
/*  40 */   private final BoolValue aacPushYReducerValue = new BoolValue("AACPushYReducer", true);
/*  41 */   private final BoolValue wtapreduce = new BoolValue("Wtapreduce", true);
/*     */   
/*     */   private int jumped;
/*     */   
/*     */   private boolean dosprint = true;
/*     */ 
/*     */   
/*     */   public final boolean getDosprint() {
/*  49 */     return this.dosprint; } public final void setDosprint(boolean <set-?>) { this.dosprint = <set-?>; }
/*  50 */    private MSTimer velocityTimer = new MSTimer();
/*     */   
/*     */   private boolean velocityInput;
/*     */   
/*     */   private boolean velocityInput2;
/*     */   
/*     */   private boolean reverseHurt;
/*     */   
/*     */   private boolean jump;
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*  62 */     return (String)this.modeValue.get();
/*     */   }
/*     */   public void onDisable() {
/*  65 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); } else { MinecraftInstance.mc.getThePlayer(); }
/*  66 */      this.velocityInput = false;
/*  67 */     this.velocityInput2 = false;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/*  71 */     this.velocityInput = false;
/*  72 */     this.velocityInput2 = false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     //   24: aload_2
/*     */     //   25: invokeinterface isInWater : ()Z
/*     */     //   30: ifne -> 51
/*     */     //   33: aload_2
/*     */     //   34: invokeinterface isInLava : ()Z
/*     */     //   39: ifne -> 51
/*     */     //   42: aload_2
/*     */     //   43: invokeinterface isInWeb : ()Z
/*     */     //   48: ifeq -> 52
/*     */     //   51: return
/*     */     //   52: aload_0
/*     */     //   53: getfield wtapreduce : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   56: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   59: checkcast java/lang/Boolean
/*     */     //   62: invokevirtual booleanValue : ()Z
/*     */     //   65: ifeq -> 130
/*     */     //   68: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   71: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   76: dup
/*     */     //   77: ifnonnull -> 83
/*     */     //   80: invokestatic throwNpe : ()V
/*     */     //   83: invokeinterface getHurtTime : ()I
/*     */     //   88: bipush #9
/*     */     //   90: if_icmpge -> 125
/*     */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   96: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   101: dup
/*     */     //   102: ifnonnull -> 108
/*     */     //   105: invokestatic throwNpe : ()V
/*     */     //   108: invokeinterface getHurtTime : ()I
/*     */     //   113: iconst_3
/*     */     //   114: if_icmple -> 125
/*     */     //   117: aload_0
/*     */     //   118: iconst_0
/*     */     //   119: putfield dosprint : Z
/*     */     //   122: goto -> 130
/*     */     //   125: aload_0
/*     */     //   126: iconst_1
/*     */     //   127: putfield dosprint : Z
/*     */     //   130: aload_0
/*     */     //   131: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   134: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   137: checkcast java/lang/String
/*     */     //   140: astore_3
/*     */     //   141: iconst_0
/*     */     //   142: istore #4
/*     */     //   144: aload_3
/*     */     //   145: dup
/*     */     //   146: ifnonnull -> 159
/*     */     //   149: new kotlin/TypeCastException
/*     */     //   152: dup
/*     */     //   153: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   155: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   158: athrow
/*     */     //   159: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   162: dup
/*     */     //   163: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   165: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   168: astore_3
/*     */     //   169: aload_3
/*     */     //   170: invokevirtual hashCode : ()I
/*     */     //   173: lookupswitch default -> 1701, -1970553484 -> 332, -1243181771 -> 260, -1234547235 -> 284, -1234264725 -> 272, 96323 -> 248, 3273774 -> 320, 109549001 -> 308, 1099846370 -> 296
/*     */     //   248: aload_3
/*     */     //   249: ldc 'aac'
/*     */     //   251: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   254: ifeq -> 1701
/*     */     //   257: goto -> 1153
/*     */     //   260: aload_3
/*     */     //   261: ldc 'glitch'
/*     */     //   263: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   266: ifeq -> 1701
/*     */     //   269: goto -> 957
/*     */     //   272: aload_3
/*     */     //   273: ldc 'aaczero'
/*     */     //   275: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   278: ifeq -> 1701
/*     */     //   281: goto -> 1628
/*     */     //   284: aload_3
/*     */     //   285: ldc 'aacpush'
/*     */     //   287: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   290: ifeq -> 1701
/*     */     //   293: goto -> 1439
/*     */     //   296: aload_3
/*     */     //   297: ldc 'reverse'
/*     */     //   299: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   302: ifeq -> 1701
/*     */     //   305: goto -> 995
/*     */     //   308: aload_3
/*     */     //   309: ldc 'smart'
/*     */     //   311: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   314: ifeq -> 1701
/*     */     //   317: goto -> 465
/*     */     //   320: aload_3
/*     */     //   321: ldc 'jump'
/*     */     //   323: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   326: ifeq -> 1701
/*     */     //   329: goto -> 344
/*     */     //   332: aload_3
/*     */     //   333: ldc 'smoothreverse'
/*     */     //   335: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   338: ifeq -> 1701
/*     */     //   341: goto -> 1059
/*     */     //   344: aload_2
/*     */     //   345: invokeinterface getHurtTime : ()I
/*     */     //   350: ifle -> 1701
/*     */     //   353: aload_2
/*     */     //   354: invokeinterface getOnGround : ()Z
/*     */     //   359: ifeq -> 1701
/*     */     //   362: aload_2
/*     */     //   363: ldc2_w 0.42
/*     */     //   366: invokeinterface setMotionY : (D)V
/*     */     //   371: aload_2
/*     */     //   372: invokeinterface getRotationYaw : ()F
/*     */     //   377: ldc 0.017453292
/*     */     //   379: fmul
/*     */     //   380: fstore #4
/*     */     //   382: aload_2
/*     */     //   383: dup
/*     */     //   384: invokeinterface getMotionX : ()D
/*     */     //   389: dstore #7
/*     */     //   391: astore #6
/*     */     //   393: iconst_0
/*     */     //   394: istore #5
/*     */     //   396: fload #4
/*     */     //   398: f2d
/*     */     //   399: invokestatic sin : (D)D
/*     */     //   402: d2f
/*     */     //   403: fstore #9
/*     */     //   405: aload #6
/*     */     //   407: dload #7
/*     */     //   409: fload #9
/*     */     //   411: f2d
/*     */     //   412: ldc2_w 0.2
/*     */     //   415: dmul
/*     */     //   416: dsub
/*     */     //   417: invokeinterface setMotionX : (D)V
/*     */     //   422: aload_2
/*     */     //   423: dup
/*     */     //   424: invokeinterface getMotionZ : ()D
/*     */     //   429: dstore #7
/*     */     //   431: astore #6
/*     */     //   433: iconst_0
/*     */     //   434: istore #5
/*     */     //   436: fload #4
/*     */     //   438: f2d
/*     */     //   439: invokestatic cos : (D)D
/*     */     //   442: d2f
/*     */     //   443: fstore #9
/*     */     //   445: aload #6
/*     */     //   447: dload #7
/*     */     //   449: fload #9
/*     */     //   451: f2d
/*     */     //   452: ldc2_w 0.2
/*     */     //   455: dmul
/*     */     //   456: dadd
/*     */     //   457: invokeinterface setMotionZ : (D)V
/*     */     //   462: goto -> 1701
/*     */     //   465: aload_0
/*     */     //   466: getfield velocityInput : Z
/*     */     //   469: ifeq -> 706
/*     */     //   472: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   475: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   480: dup
/*     */     //   481: ifnonnull -> 487
/*     */     //   484: invokestatic throwNpe : ()V
/*     */     //   487: invokeinterface getOnGround : ()Z
/*     */     //   492: ifeq -> 632
/*     */     //   495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   498: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   503: dup
/*     */     //   504: ifnonnull -> 510
/*     */     //   507: invokestatic throwNpe : ()V
/*     */     //   510: invokeinterface getHurtTime : ()I
/*     */     //   515: bipush #9
/*     */     //   517: if_icmpne -> 632
/*     */     //   520: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   523: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   528: dup
/*     */     //   529: ifnonnull -> 535
/*     */     //   532: invokestatic throwNpe : ()V
/*     */     //   535: invokeinterface getSprinting : ()Z
/*     */     //   540: ifeq -> 632
/*     */     //   543: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   546: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   551: ifnonnull -> 632
/*     */     //   554: aload_0
/*     */     //   555: getfield jumped : I
/*     */     //   558: iconst_2
/*     */     //   559: if_icmple -> 570
/*     */     //   562: aload_0
/*     */     //   563: iconst_0
/*     */     //   564: putfield jumped : I
/*     */     //   567: goto -> 706
/*     */     //   570: aload_0
/*     */     //   571: dup
/*     */     //   572: dup
/*     */     //   573: getfield jumped : I
/*     */     //   576: iconst_1
/*     */     //   577: iadd
/*     */     //   578: putfield jumped : I
/*     */     //   581: getfield jumped : I
/*     */     //   584: pop
/*     */     //   585: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   588: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   593: dup
/*     */     //   594: ifnonnull -> 600
/*     */     //   597: invokestatic throwNpe : ()V
/*     */     //   600: invokeinterface getTicksExisted : ()I
/*     */     //   605: iconst_5
/*     */     //   606: irem
/*     */     //   607: ifeq -> 629
/*     */     //   610: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   613: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   618: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   623: iconst_1
/*     */     //   624: invokeinterface setPressed : (Z)V
/*     */     //   629: goto -> 706
/*     */     //   632: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   635: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   640: dup
/*     */     //   641: ifnonnull -> 647
/*     */     //   644: invokestatic throwNpe : ()V
/*     */     //   647: invokeinterface getHurtTime : ()I
/*     */     //   652: bipush #8
/*     */     //   654: if_icmpne -> 706
/*     */     //   657: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   660: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   665: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   670: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   673: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   678: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   681: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   686: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   691: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   696: invokeinterface setPressed : (Z)V
/*     */     //   701: aload_0
/*     */     //   702: iconst_0
/*     */     //   703: putfield velocityInput : Z
/*     */     //   706: aload_0
/*     */     //   707: getfield velocityInput2 : Z
/*     */     //   710: ifeq -> 820
/*     */     //   713: aload_0
/*     */     //   714: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   717: aload_0
/*     */     //   718: getfield msValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   721: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   724: checkcast java/lang/Number
/*     */     //   727: invokevirtual floatValue : ()F
/*     */     //   730: f2l
/*     */     //   731: invokevirtual hasTimePassed : (J)Z
/*     */     //   734: ifeq -> 820
/*     */     //   737: aload_2
/*     */     //   738: dup
/*     */     //   739: invokeinterface getMotionX : ()D
/*     */     //   744: aload_0
/*     */     //   745: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   748: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   751: checkcast java/lang/Number
/*     */     //   754: invokevirtual doubleValue : ()D
/*     */     //   757: dmul
/*     */     //   758: invokeinterface setMotionX : (D)V
/*     */     //   763: aload_2
/*     */     //   764: dup
/*     */     //   765: invokeinterface getMotionZ : ()D
/*     */     //   770: aload_0
/*     */     //   771: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   774: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   777: checkcast java/lang/Number
/*     */     //   780: invokevirtual doubleValue : ()D
/*     */     //   783: dmul
/*     */     //   784: invokeinterface setMotionZ : (D)V
/*     */     //   789: aload_2
/*     */     //   790: dup
/*     */     //   791: invokeinterface getMotionY : ()D
/*     */     //   796: aload_0
/*     */     //   797: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   800: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   803: checkcast java/lang/Number
/*     */     //   806: invokevirtual doubleValue : ()D
/*     */     //   809: dmul
/*     */     //   810: invokeinterface setMotionY : (D)V
/*     */     //   815: aload_0
/*     */     //   816: iconst_0
/*     */     //   817: putfield velocityInput2 : Z
/*     */     //   820: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   823: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   828: dup
/*     */     //   829: ifnonnull -> 835
/*     */     //   832: invokestatic throwNpe : ()V
/*     */     //   835: invokeinterface getHurtTime : ()I
/*     */     //   840: ifle -> 1701
/*     */     //   843: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   846: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   851: dup
/*     */     //   852: ifnonnull -> 858
/*     */     //   855: invokestatic throwNpe : ()V
/*     */     //   858: dup
/*     */     //   859: invokeinterface getMotionX : ()D
/*     */     //   864: ldc2_w -1.0E-7
/*     */     //   867: dadd
/*     */     //   868: invokeinterface setMotionX : (D)V
/*     */     //   873: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   876: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   881: dup
/*     */     //   882: ifnonnull -> 888
/*     */     //   885: invokestatic throwNpe : ()V
/*     */     //   888: dup
/*     */     //   889: invokeinterface getMotionY : ()D
/*     */     //   894: ldc2_w -1.0E-7
/*     */     //   897: dadd
/*     */     //   898: invokeinterface setMotionY : (D)V
/*     */     //   903: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   906: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   911: dup
/*     */     //   912: ifnonnull -> 918
/*     */     //   915: invokestatic throwNpe : ()V
/*     */     //   918: dup
/*     */     //   919: invokeinterface getMotionZ : ()D
/*     */     //   924: ldc2_w -1.0E-7
/*     */     //   927: dadd
/*     */     //   928: invokeinterface setMotionZ : (D)V
/*     */     //   933: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   936: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   941: dup
/*     */     //   942: ifnonnull -> 948
/*     */     //   945: invokestatic throwNpe : ()V
/*     */     //   948: iconst_1
/*     */     //   949: invokeinterface setAirBorne : (Z)V
/*     */     //   954: goto -> 1701
/*     */     //   957: aload_2
/*     */     //   958: aload_0
/*     */     //   959: getfield velocityInput : Z
/*     */     //   962: invokeinterface setNoClip : (Z)V
/*     */     //   967: aload_2
/*     */     //   968: invokeinterface getHurtTime : ()I
/*     */     //   973: bipush #7
/*     */     //   975: if_icmpne -> 987
/*     */     //   978: aload_2
/*     */     //   979: ldc2_w 0.4
/*     */     //   982: invokeinterface setMotionY : (D)V
/*     */     //   987: aload_0
/*     */     //   988: iconst_0
/*     */     //   989: putfield velocityInput : Z
/*     */     //   992: goto -> 1701
/*     */     //   995: aload_0
/*     */     //   996: getfield velocityInput : Z
/*     */     //   999: ifne -> 1003
/*     */     //   1002: return
/*     */     //   1003: aload_2
/*     */     //   1004: invokeinterface getOnGround : ()Z
/*     */     //   1009: ifne -> 1038
/*     */     //   1012: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*     */     //   1015: invokevirtual getSpeed : ()F
/*     */     //   1018: aload_0
/*     */     //   1019: getfield reverseStrengthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1022: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1025: checkcast java/lang/Number
/*     */     //   1028: invokevirtual floatValue : ()F
/*     */     //   1031: fmul
/*     */     //   1032: invokestatic strafe : (F)V
/*     */     //   1035: goto -> 1701
/*     */     //   1038: aload_0
/*     */     //   1039: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1042: ldc2_w 80
/*     */     //   1045: invokevirtual hasTimePassed : (J)Z
/*     */     //   1048: ifeq -> 1701
/*     */     //   1051: aload_0
/*     */     //   1052: iconst_0
/*     */     //   1053: putfield velocityInput : Z
/*     */     //   1056: goto -> 1701
/*     */     //   1059: aload_0
/*     */     //   1060: getfield velocityInput : Z
/*     */     //   1063: ifne -> 1075
/*     */     //   1066: aload_2
/*     */     //   1067: ldc 0.02
/*     */     //   1069: invokeinterface setSpeedInAir : (F)V
/*     */     //   1074: return
/*     */     //   1075: aload_2
/*     */     //   1076: invokeinterface getHurtTime : ()I
/*     */     //   1081: ifle -> 1089
/*     */     //   1084: aload_0
/*     */     //   1085: iconst_1
/*     */     //   1086: putfield reverseHurt : Z
/*     */     //   1089: aload_2
/*     */     //   1090: invokeinterface getOnGround : ()Z
/*     */     //   1095: ifne -> 1127
/*     */     //   1098: aload_0
/*     */     //   1099: getfield reverseHurt : Z
/*     */     //   1102: ifeq -> 1701
/*     */     //   1105: aload_2
/*     */     //   1106: aload_0
/*     */     //   1107: getfield reverse2StrengthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1110: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1113: checkcast java/lang/Number
/*     */     //   1116: invokevirtual floatValue : ()F
/*     */     //   1119: invokeinterface setSpeedInAir : (F)V
/*     */     //   1124: goto -> 1701
/*     */     //   1127: aload_0
/*     */     //   1128: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1131: ldc2_w 80
/*     */     //   1134: invokevirtual hasTimePassed : (J)Z
/*     */     //   1137: ifeq -> 1150
/*     */     //   1140: aload_0
/*     */     //   1141: iconst_0
/*     */     //   1142: putfield velocityInput : Z
/*     */     //   1145: aload_0
/*     */     //   1146: iconst_0
/*     */     //   1147: putfield reverseHurt : Z
/*     */     //   1150: goto -> 1701
/*     */     //   1153: aload_0
/*     */     //   1154: getfield velocityInput : Z
/*     */     //   1157: ifeq -> 1701
/*     */     //   1160: aload_0
/*     */     //   1161: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1164: ldc2_w 80
/*     */     //   1167: invokevirtual hasTimePassed : (J)Z
/*     */     //   1170: ifeq -> 1251
/*     */     //   1173: aload_2
/*     */     //   1174: dup
/*     */     //   1175: invokeinterface getMotionX : ()D
/*     */     //   1180: aload_0
/*     */     //   1181: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1184: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1187: checkcast java/lang/Number
/*     */     //   1190: invokevirtual doubleValue : ()D
/*     */     //   1193: dmul
/*     */     //   1194: invokeinterface setMotionX : (D)V
/*     */     //   1199: aload_2
/*     */     //   1200: dup
/*     */     //   1201: invokeinterface getMotionZ : ()D
/*     */     //   1206: aload_0
/*     */     //   1207: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1210: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1213: checkcast java/lang/Number
/*     */     //   1216: invokevirtual doubleValue : ()D
/*     */     //   1219: dmul
/*     */     //   1220: invokeinterface setMotionZ : (D)V
/*     */     //   1225: aload_2
/*     */     //   1226: dup
/*     */     //   1227: invokeinterface getMotionY : ()D
/*     */     //   1232: aload_0
/*     */     //   1233: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1236: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1239: checkcast java/lang/Number
/*     */     //   1242: invokevirtual doubleValue : ()D
/*     */     //   1245: dmul
/*     */     //   1246: invokeinterface setMotionY : (D)V
/*     */     //   1251: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1254: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1259: dup
/*     */     //   1260: ifnonnull -> 1266
/*     */     //   1263: invokestatic throwNpe : ()V
/*     */     //   1266: invokeinterface getOnGround : ()Z
/*     */     //   1271: ifeq -> 1320
/*     */     //   1274: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1277: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1282: dup
/*     */     //   1283: ifnonnull -> 1289
/*     */     //   1286: invokestatic throwNpe : ()V
/*     */     //   1289: invokeinterface getSprinting : ()Z
/*     */     //   1294: ifeq -> 1431
/*     */     //   1297: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1300: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1305: dup
/*     */     //   1306: ifnonnull -> 1312
/*     */     //   1309: invokestatic throwNpe : ()V
/*     */     //   1312: invokeinterface jump : ()V
/*     */     //   1317: goto -> 1431
/*     */     //   1320: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1323: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1328: dup
/*     */     //   1329: ifnonnull -> 1335
/*     */     //   1332: invokestatic throwNpe : ()V
/*     */     //   1335: dup
/*     */     //   1336: invokeinterface getMotionX : ()D
/*     */     //   1341: ldc2_w -1.0E-7
/*     */     //   1344: dadd
/*     */     //   1345: invokeinterface setMotionX : (D)V
/*     */     //   1350: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1353: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1358: dup
/*     */     //   1359: ifnonnull -> 1365
/*     */     //   1362: invokestatic throwNpe : ()V
/*     */     //   1365: dup
/*     */     //   1366: invokeinterface getMotionY : ()D
/*     */     //   1371: ldc2_w -1.0E-7
/*     */     //   1374: dadd
/*     */     //   1375: invokeinterface setMotionY : (D)V
/*     */     //   1380: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1383: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1388: dup
/*     */     //   1389: ifnonnull -> 1395
/*     */     //   1392: invokestatic throwNpe : ()V
/*     */     //   1395: dup
/*     */     //   1396: invokeinterface getMotionZ : ()D
/*     */     //   1401: ldc2_w -1.0E-7
/*     */     //   1404: dadd
/*     */     //   1405: invokeinterface setMotionZ : (D)V
/*     */     //   1410: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1413: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1418: dup
/*     */     //   1419: ifnonnull -> 1425
/*     */     //   1422: invokestatic throwNpe : ()V
/*     */     //   1425: iconst_1
/*     */     //   1426: invokeinterface setAirBorne : (Z)V
/*     */     //   1431: aload_0
/*     */     //   1432: iconst_0
/*     */     //   1433: putfield velocityInput : Z
/*     */     //   1436: goto -> 1701
/*     */     //   1439: aload_0
/*     */     //   1440: getfield jump : Z
/*     */     //   1443: ifeq -> 1463
/*     */     //   1446: aload_2
/*     */     //   1447: invokeinterface getOnGround : ()Z
/*     */     //   1452: ifeq -> 1567
/*     */     //   1455: aload_0
/*     */     //   1456: iconst_0
/*     */     //   1457: putfield jump : Z
/*     */     //   1460: goto -> 1567
/*     */     //   1463: aload_2
/*     */     //   1464: invokeinterface getHurtTime : ()I
/*     */     //   1469: ifle -> 1501
/*     */     //   1472: aload_2
/*     */     //   1473: invokeinterface getMotionX : ()D
/*     */     //   1478: dconst_0
/*     */     //   1479: dcmpg
/*     */     //   1480: ifeq -> 1501
/*     */     //   1483: aload_2
/*     */     //   1484: invokeinterface getMotionZ : ()D
/*     */     //   1489: dconst_0
/*     */     //   1490: dcmpg
/*     */     //   1491: ifeq -> 1501
/*     */     //   1494: aload_2
/*     */     //   1495: iconst_1
/*     */     //   1496: invokeinterface setOnGround : (Z)V
/*     */     //   1501: aload_2
/*     */     //   1502: invokeinterface getHurtResistantTime : ()I
/*     */     //   1507: ifle -> 1567
/*     */     //   1510: aload_0
/*     */     //   1511: getfield aacPushYReducerValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1514: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1517: checkcast java/lang/Boolean
/*     */     //   1520: invokevirtual booleanValue : ()Z
/*     */     //   1523: ifeq -> 1567
/*     */     //   1526: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1529: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   1532: ldc_w net/ccbluex/liquidbounce/features/module/modules/movement/Speed
/*     */     //   1535: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   1538: dup
/*     */     //   1539: ifnonnull -> 1545
/*     */     //   1542: invokestatic throwNpe : ()V
/*     */     //   1545: invokevirtual getState : ()Z
/*     */     //   1548: ifne -> 1567
/*     */     //   1551: aload_2
/*     */     //   1552: dup
/*     */     //   1553: invokeinterface getMotionY : ()D
/*     */     //   1558: ldc2_w 0.014999993
/*     */     //   1561: dsub
/*     */     //   1562: invokeinterface setMotionY : (D)V
/*     */     //   1567: aload_2
/*     */     //   1568: invokeinterface getHurtResistantTime : ()I
/*     */     //   1573: bipush #19
/*     */     //   1575: if_icmplt -> 1701
/*     */     //   1578: aload_0
/*     */     //   1579: getfield aacPushXZReducerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1582: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1585: checkcast java/lang/Number
/*     */     //   1588: invokevirtual floatValue : ()F
/*     */     //   1591: fstore #4
/*     */     //   1593: aload_2
/*     */     //   1594: dup
/*     */     //   1595: invokeinterface getMotionX : ()D
/*     */     //   1600: fload #4
/*     */     //   1602: f2d
/*     */     //   1603: ddiv
/*     */     //   1604: invokeinterface setMotionX : (D)V
/*     */     //   1609: aload_2
/*     */     //   1610: dup
/*     */     //   1611: invokeinterface getMotionZ : ()D
/*     */     //   1616: fload #4
/*     */     //   1618: f2d
/*     */     //   1619: ddiv
/*     */     //   1620: invokeinterface setMotionZ : (D)V
/*     */     //   1625: goto -> 1701
/*     */     //   1628: aload_2
/*     */     //   1629: invokeinterface getHurtTime : ()I
/*     */     //   1634: ifle -> 1696
/*     */     //   1637: aload_0
/*     */     //   1638: getfield velocityInput : Z
/*     */     //   1641: ifeq -> 1664
/*     */     //   1644: aload_2
/*     */     //   1645: invokeinterface getOnGround : ()Z
/*     */     //   1650: ifne -> 1664
/*     */     //   1653: aload_2
/*     */     //   1654: invokeinterface getFallDistance : ()F
/*     */     //   1659: fconst_2
/*     */     //   1660: fcmpl
/*     */     //   1661: ifle -> 1665
/*     */     //   1664: return
/*     */     //   1665: aload_2
/*     */     //   1666: dup
/*     */     //   1667: invokeinterface getMotionY : ()D
/*     */     //   1672: dconst_1
/*     */     //   1673: dsub
/*     */     //   1674: invokeinterface setMotionY : (D)V
/*     */     //   1679: aload_2
/*     */     //   1680: iconst_1
/*     */     //   1681: invokeinterface setAirBorne : (Z)V
/*     */     //   1686: aload_2
/*     */     //   1687: iconst_1
/*     */     //   1688: invokeinterface setOnGround : (Z)V
/*     */     //   1693: goto -> 1701
/*     */     //   1696: aload_0
/*     */     //   1697: iconst_0
/*     */     //   1698: putfield velocityInput : Z
/*     */     //   1701: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #76	-> 6
/*     */     //   #76	-> 21
/*     */     //   #77	-> 24
/*     */     //   #78	-> 51
/*     */     //   #79	-> 52
/*     */     //   #80	-> 68
/*     */     //   #81	-> 117
/*     */     //   #83	-> 125
/*     */     //   #84	-> 130
/*     */     //   #86	-> 130
/*     */     //   #162	-> 248
/*     */     //   #125	-> 260
/*     */     //   #201	-> 272
/*     */     //   #178	-> 284
/*     */     //   #134	-> 296
/*     */     //   #97	-> 308
/*     */     //   #88	-> 320
/*     */     //   #144	-> 332
/*     */     //   #88	-> 344
/*     */     //   #89	-> 362
/*     */     //   #91	-> 371
/*     */     //   #93	-> 382
/*     */     //   #93	-> 412
/*     */     //   #94	-> 422
/*     */     //   #94	-> 452
/*     */     //   #98	-> 465
/*     */     //   #99	-> 472
/*     */     //   #100	-> 554
/*     */     //   #101	-> 562
/*     */     //   #103	-> 570
/*     */     //   #104	-> 585
/*     */     //   #105	-> 629
/*     */     //   #106	-> 632
/*     */     //   #107	-> 657
/*     */     //   #108	-> 701
/*     */     //   #109	-> 706
/*     */     //   #111	-> 706
/*     */     //   #112	-> 737
/*     */     //   #113	-> 763
/*     */     //   #114	-> 789
/*     */     //   #115	-> 815
/*     */     //   #117	-> 820
/*     */     //   #118	-> 843
/*     */     //   #119	-> 873
/*     */     //   #120	-> 903
/*     */     //   #121	-> 933
/*     */     //   #126	-> 957
/*     */     //   #128	-> 967
/*     */     //   #129	-> 978
/*     */     //   #131	-> 987
/*     */     //   #135	-> 995
/*     */     //   #136	-> 1002
/*     */     //   #138	-> 1003
/*     */     //   #139	-> 1012
/*     */     //   #140	-> 1038
/*     */     //   #141	-> 1051
/*     */     //   #145	-> 1059
/*     */     //   #146	-> 1066
/*     */     //   #147	-> 1074
/*     */     //   #150	-> 1075
/*     */     //   #151	-> 1084
/*     */     //   #153	-> 1089
/*     */     //   #154	-> 1098
/*     */     //   #155	-> 1105
/*     */     //   #156	-> 1127
/*     */     //   #157	-> 1140
/*     */     //   #158	-> 1145
/*     */     //   #159	-> 1150
/*     */     //   #162	-> 1153
/*     */     //   #163	-> 1160
/*     */     //   #164	-> 1173
/*     */     //   #165	-> 1199
/*     */     //   #166	-> 1225
/*     */     //   #168	-> 1251
/*     */     //   #170	-> 1320
/*     */     //   #171	-> 1350
/*     */     //   #172	-> 1380
/*     */     //   #173	-> 1410
/*     */     //   #174	-> 1431
/*     */     //   #175	-> 1431
/*     */     //   #179	-> 1439
/*     */     //   #180	-> 1446
/*     */     //   #181	-> 1455
/*     */     //   #184	-> 1463
/*     */     //   #185	-> 1494
/*     */     //   #188	-> 1501
/*     */     //   #189	-> 1501
/*     */     //   #188	-> 1510
/*     */     //   #189	-> 1526
/*     */     //   #190	-> 1551
/*     */     //   #191	-> 1567
/*     */     //   #194	-> 1567
/*     */     //   #195	-> 1578
/*     */     //   #197	-> 1593
/*     */     //   #198	-> 1609
/*     */     //   #201	-> 1628
/*     */     //   #202	-> 1637
/*     */     //   #203	-> 1664
/*     */     //   #205	-> 1665
/*     */     //   #206	-> 1679
/*     */     //   #207	-> 1686
/*     */     //   #209	-> 1696
/*     */     //   #210	-> 1701
/*     */     //   #211	-> 1701
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   382	80	4	yaw	F
/*     */     //   1593	32	4	reduce	F
/*     */     //   24	1678	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1702	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SkidHYTVelocity;
/*     */     //   0	1702	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */     //   38: ifeq -> 457
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
/*     */     //   146: lookupswitch default -> 457, -1970553484 -> 291, -1243181771 -> 225, -1234264725 -> 238, -902286926 -> 251, 96323 -> 212, 109549001 -> 278, 1099846370 -> 265
/*     */     //   212: aload #5
/*     */     //   214: ldc 'aac'
/*     */     //   216: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   219: ifeq -> 457
/*     */     //   222: goto -> 430
/*     */     //   225: aload #5
/*     */     //   227: ldc 'glitch'
/*     */     //   229: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   232: ifeq -> 457
/*     */     //   235: goto -> 438
/*     */     //   238: aload #5
/*     */     //   240: ldc 'aaczero'
/*     */     //   242: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   245: ifeq -> 457
/*     */     //   248: goto -> 430
/*     */     //   251: aload #5
/*     */     //   253: ldc_w 'simple'
/*     */     //   256: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   259: ifeq -> 457
/*     */     //   262: goto -> 340
/*     */     //   265: aload #5
/*     */     //   267: ldc 'reverse'
/*     */     //   269: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   272: ifeq -> 457
/*     */     //   275: goto -> 430
/*     */     //   278: aload #5
/*     */     //   280: ldc 'smart'
/*     */     //   282: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   285: ifeq -> 457
/*     */     //   288: goto -> 304
/*     */     //   291: aload #5
/*     */     //   293: ldc 'smoothreverse'
/*     */     //   295: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   298: ifeq -> 457
/*     */     //   301: goto -> 430
/*     */     //   304: aload_0
/*     */     //   305: iconst_1
/*     */     //   306: putfield velocityInput : Z
/*     */     //   309: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   312: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   317: dup
/*     */     //   318: ifnonnull -> 324
/*     */     //   321: invokestatic throwNpe : ()V
/*     */     //   324: invokeinterface getOnGround : ()Z
/*     */     //   329: ifeq -> 457
/*     */     //   332: aload_0
/*     */     //   333: iconst_1
/*     */     //   334: putfield velocityInput2 : Z
/*     */     //   337: goto -> 457
/*     */     //   340: aload_0
/*     */     //   341: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   344: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   347: checkcast java/lang/Number
/*     */     //   350: invokevirtual floatValue : ()F
/*     */     //   353: fstore #6
/*     */     //   355: aload_0
/*     */     //   356: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   359: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   362: checkcast java/lang/Number
/*     */     //   365: invokevirtual floatValue : ()F
/*     */     //   368: fstore #7
/*     */     //   370: aload #4
/*     */     //   372: aload #4
/*     */     //   374: invokeinterface getMotionX : ()I
/*     */     //   379: i2f
/*     */     //   380: fload #6
/*     */     //   382: fmul
/*     */     //   383: f2i
/*     */     //   384: invokeinterface setMotionX : (I)V
/*     */     //   389: aload #4
/*     */     //   391: aload #4
/*     */     //   393: invokeinterface getMotionY : ()I
/*     */     //   398: i2f
/*     */     //   399: fload #7
/*     */     //   401: fmul
/*     */     //   402: f2i
/*     */     //   403: invokeinterface setMotionY : (I)V
/*     */     //   408: aload #4
/*     */     //   410: aload #4
/*     */     //   412: invokeinterface getMotionZ : ()I
/*     */     //   417: i2f
/*     */     //   418: fload #6
/*     */     //   420: fmul
/*     */     //   421: f2i
/*     */     //   422: invokeinterface setMotionZ : (I)V
/*     */     //   427: goto -> 457
/*     */     //   430: aload_0
/*     */     //   431: iconst_1
/*     */     //   432: putfield velocityInput : Z
/*     */     //   435: goto -> 457
/*     */     //   438: aload_2
/*     */     //   439: invokeinterface getOnGround : ()Z
/*     */     //   444: ifne -> 448
/*     */     //   447: return
/*     */     //   448: aload_0
/*     */     //   449: iconst_1
/*     */     //   450: putfield velocityInput : Z
/*     */     //   453: aload_1
/*     */     //   454: invokevirtual cancelEvent : ()V
/*     */     //   457: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #216	-> 6
/*     */     //   #216	-> 21
/*     */     //   #218	-> 24
/*     */     //   #220	-> 29
/*     */     //   #221	-> 41
/*     */     //   #223	-> 49
/*     */     //   #223	-> 80
/*     */     //   #224	-> 91
/*     */     //   #226	-> 92
/*     */     //   #228	-> 99
/*     */     //   #242	-> 212
/*     */     //   #244	-> 225
/*     */     //   #242	-> 238
/*     */     //   #233	-> 251
/*     */     //   #242	-> 265
/*     */     //   #229	-> 278
/*     */     //   #242	-> 291
/*     */     //   #230	-> 304
/*     */     //   #231	-> 309
/*     */     //   #234	-> 340
/*     */     //   #235	-> 355
/*     */     //   #237	-> 370
/*     */     //   #238	-> 389
/*     */     //   #239	-> 408
/*     */     //   #242	-> 430
/*     */     //   #245	-> 438
/*     */     //   #246	-> 447
/*     */     //   #248	-> 448
/*     */     //   #249	-> 453
/*     */     //   #251	-> 457
/*     */     //   #253	-> 457
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   370	57	7	vertical	F
/*     */     //   355	72	6	horizontal	F
/*     */     //   49	408	4	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   29	429	3	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   24	434	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	458	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SkidHYTVelocity;
/*     */     //   0	458	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 257 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 259 */     if (thePlayer == null || thePlayer.isInWater() || thePlayer.isInLava() || thePlayer.isInWeb()) {
/*     */       return;
/*     */     }
/* 262 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1234264725:
/* 269 */         if (str.equals("aaczero") && thePlayer.getHurtTime() > 0)
/* 270 */           event.cancelEvent(); 
/*     */         break;
/*     */       case -1234547235:
/*     */         if (str.equals("aacpush")) {
/*     */           this.jump = true;
/*     */           if (!thePlayer.isCollidedVertically())
/*     */             event.cancelEvent(); 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\SkidHYTVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */