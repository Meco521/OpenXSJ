/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import me.utils.PacketUtils;
/*     */ import me.utils.timer.TimeHelper;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketPlayer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "BugUP", category = ModuleCategory.MOVEMENT, description = "无虚空")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\002\b\004\n\002\020\023\n\002\b\005\n\002\020\006\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\f\n\002\030\002\n\002\b\t\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\027\030\0002\0020\001B\005¢\006\002\020\002J\b\0200\032\0020\006H\002J\b\0201\032\0020\006H\026J\b\0202\032\00203H\026J\020\0204\032\002032\006\0205\032\00206H\007J\020\0207\032\002032\006\0205\032\00208H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\006X\016¢\006\002\n\000R\016\020\b\032\0020\006X\016¢\006\002\n\000R\016\020\t\032\0020\006X\016¢\006\002\n\000R\032\020\n\032\0020\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\016\020\020\032\0020\021X\016¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\016\020\024\032\0020\025X\004¢\006\002\n\000R\016\020\026\032\0020\021X\016¢\006\002\n\000R\016\020\027\032\0020\021X\016¢\006\002\n\000R\016\020\030\032\0020\021X\016¢\006\002\n\000R\036\020\031\032\022\022\004\022\0020\0330\032j\b\022\004\022\0020\033`\034X\004¢\006\002\n\000R*\020\035\032\022\022\004\022\0020\0330\032j\b\022\004\022\0020\033`\034X\016¢\006\016\n\000\032\004\b\036\020\037\"\004\b \020!R\016\020\"\032\0020\021X\016¢\006\002\n\000R\016\020#\032\0020\021X\016¢\006\002\n\000R\016\020$\032\0020\021X\016¢\006\002\n\000R\016\020%\032\0020\023X\004¢\006\002\n\000R\016\020&\032\0020\004X\004¢\006\002\n\000R\016\020'\032\0020\023X\004¢\006\002\n\000R\032\020(\032\0020)X\016¢\006\016\n\000\032\004\b*\020+\"\004\b,\020-R\016\020.\032\0020\006X\016¢\006\002\n\000R\016\020/\032\0020\004X\004¢\006\002\n\000¨\0069"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/BugUP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoScaffoldValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "blink", "", "canBlink", "canSpoof", "flagged", "lastGroundPos", "", "getLastGroundPos", "()[D", "setLastGroundPos", "([D)V", "lastRecY", "", "maxFallDistValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "motionX", "motionY", "motionZ", "packetCache", "Ljava/util/ArrayList;", "Lnet/minecraft/network/play/client/CPacketPlayer;", "Lkotlin/collections/ArrayList;", "packets", "getPackets", "()Ljava/util/ArrayList;", "setPackets", "(Ljava/util/ArrayList;)V", "posX", "posY", "posZ", "pullbackTime", "resetMotionValue", "startFallDistValue", "timer", "Lme/utils/timer/TimeHelper;", "getTimer", "()Lme/utils/timer/TimeHelper;", "setTimer", "(Lme/utils/timer/TimeHelper;)V", "tried", "voidOnlyValue", "checkVoid", "isInVoid", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public class BugUP extends Module {
/*  31 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Hypixel", "Blink", "TPBack", "MotionFlag", "PacketFlag", "GroundSpoof", "OldHypixel", "Jartex", "OldCubecraft" }, "Blink");
/*  32 */   private final FloatValue pullbackTime = new FloatValue("Hypixel-PullbackTime", 800.0F, 800.0F, 1800.0F);
/*  33 */   private final FloatValue maxFallDistValue = new FloatValue("MaxFallDistance", 10.0F, 5.0F, 20.0F);
/*  34 */   private final BoolValue resetMotionValue = new BoolValue("ResetMotion", false);
/*  35 */   private final FloatValue startFallDistValue = new FloatValue("BlinkStartFallDistance", 2.0F, 0.0F, 5.0F);
/*  36 */   private final BoolValue autoScaffoldValue = new BoolValue("BlinkAutoScaffold", true);
/*  37 */   private final BoolValue voidOnlyValue = new BoolValue("OnlyVoid", true);
/*     */   
/*  39 */   private final ArrayList<CPacketPlayer> packetCache = new ArrayList<>();
/*     */   
/*     */   private boolean blink;
/*     */   private boolean canBlink;
/*     */   private boolean canSpoof;
/*     */   private boolean tried;
/*     */   private boolean flagged;
/*     */   private double posX;
/*     */   private double posY;
/*     */   private double posZ;
/*     */   private double motionX;
/*     */   private double motionY;
/*     */   private double motionZ;
/*     */   private double lastRecY;
/*     */   @NotNull
/*  54 */   private TimeHelper timer = new TimeHelper(); @NotNull public final TimeHelper getTimer() { return this.timer; } public final void setTimer(@NotNull TimeHelper <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.timer = <set-?>; } @NotNull
/*  55 */   private double[] lastGroundPos = new double[3]; @NotNull public final double[] getLastGroundPos() { return this.lastGroundPos; } public final void setLastGroundPos(@NotNull double[] <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.lastGroundPos = <set-?>; } @NotNull
/*  56 */   private ArrayList<CPacketPlayer> packets = new ArrayList<>(); @NotNull public final ArrayList<CPacketPlayer> getPackets() { return this.packets; } public final void setPackets(@NotNull ArrayList<CPacketPlayer> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.packets = <set-?>; } public boolean isInVoid() {
/*     */     byte b;
/*     */     char c;
/*  59 */     for (b = 0, c = ''; b <= c; b++) {
/*  60 */       if (MovementUtils.INSTANCE.isOnGround(b)) {
/*  61 */         return false;
/*     */       }
/*     */     } 
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/*  68 */     this.blink = false;
/*  69 */     this.canBlink = false;
/*  70 */     this.canSpoof = false;
/*  71 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastRecY = MinecraftInstance.mc.getThePlayer().getPosY();
/*  72 */     this.tried = false;
/*  73 */     this.flagged = false;
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
/*     */     //   15: ifnonnull -> 21
/*     */     //   18: invokestatic throwNpe : ()V
/*     */     //   21: invokeinterface getOnGround : ()Z
/*     */     //   26: ifeq -> 39
/*     */     //   29: aload_0
/*     */     //   30: iconst_0
/*     */     //   31: putfield tried : Z
/*     */     //   34: aload_0
/*     */     //   35: iconst_0
/*     */     //   36: putfield flagged : Z
/*     */     //   39: aload_0
/*     */     //   40: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   43: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   46: checkcast java/lang/String
/*     */     //   49: astore_2
/*     */     //   50: iconst_0
/*     */     //   51: istore_3
/*     */     //   52: aload_2
/*     */     //   53: dup
/*     */     //   54: ifnonnull -> 67
/*     */     //   57: new kotlin/TypeCastException
/*     */     //   60: dup
/*     */     //   61: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   63: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   66: athrow
/*     */     //   67: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   70: dup
/*     */     //   71: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   73: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   76: astore_2
/*     */     //   77: aload_2
/*     */     //   78: invokevirtual hashCode : ()I
/*     */     //   81: lookupswitch default -> 2300, -1167184852 -> 148, -867535517 -> 172, -720374750 -> 208, -529978910 -> 184, 93826908 -> 196, 155895796 -> 220, 1438074052 -> 160
/*     */     //   148: aload_2
/*     */     //   149: ldc 'jartex'
/*     */     //   151: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   154: ifeq -> 2300
/*     */     //   157: goto -> 960
/*     */     //   160: aload_2
/*     */     //   161: ldc 'oldcubecraft'
/*     */     //   163: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   166: ifeq -> 2300
/*     */     //   169: goto -> 1226
/*     */     //   172: aload_2
/*     */     //   173: ldc 'tpback'
/*     */     //   175: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   178: ifeq -> 2300
/*     */     //   181: goto -> 596
/*     */     //   184: aload_2
/*     */     //   185: ldc 'groundspoof'
/*     */     //   187: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   190: ifeq -> 2300
/*     */     //   193: goto -> 232
/*     */     //   196: aload_2
/*     */     //   197: ldc 'blink'
/*     */     //   199: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   202: ifeq -> 2300
/*     */     //   205: goto -> 1573
/*     */     //   208: aload_2
/*     */     //   209: ldc 'motionflag'
/*     */     //   211: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   214: ifeq -> 2300
/*     */     //   217: goto -> 304
/*     */     //   220: aload_2
/*     */     //   221: ldc 'packetflag'
/*     */     //   223: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   226: ifeq -> 2300
/*     */     //   229: goto -> 429
/*     */     //   232: aload_0
/*     */     //   233: getfield voidOnlyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   236: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   239: checkcast java/lang/Boolean
/*     */     //   242: invokevirtual booleanValue : ()Z
/*     */     //   245: ifeq -> 255
/*     */     //   248: aload_0
/*     */     //   249: invokespecial checkVoid : ()Z
/*     */     //   252: ifeq -> 2300
/*     */     //   255: aload_0
/*     */     //   256: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   259: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   264: dup
/*     */     //   265: ifnonnull -> 271
/*     */     //   268: invokestatic throwNpe : ()V
/*     */     //   271: invokeinterface getFallDistance : ()F
/*     */     //   276: aload_0
/*     */     //   277: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   280: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   283: checkcast java/lang/Number
/*     */     //   286: invokevirtual floatValue : ()F
/*     */     //   289: fcmpl
/*     */     //   290: ifle -> 297
/*     */     //   293: iconst_1
/*     */     //   294: goto -> 298
/*     */     //   297: iconst_0
/*     */     //   298: putfield canSpoof : Z
/*     */     //   301: goto -> 2300
/*     */     //   304: aload_0
/*     */     //   305: getfield voidOnlyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   308: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   311: checkcast java/lang/Boolean
/*     */     //   314: invokevirtual booleanValue : ()Z
/*     */     //   317: ifeq -> 327
/*     */     //   320: aload_0
/*     */     //   321: invokespecial checkVoid : ()Z
/*     */     //   324: ifeq -> 2300
/*     */     //   327: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   330: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   335: dup
/*     */     //   336: ifnonnull -> 342
/*     */     //   339: invokestatic throwNpe : ()V
/*     */     //   342: invokeinterface getFallDistance : ()F
/*     */     //   347: aload_0
/*     */     //   348: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   351: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   354: checkcast java/lang/Number
/*     */     //   357: invokevirtual floatValue : ()F
/*     */     //   360: fcmpl
/*     */     //   361: ifle -> 2300
/*     */     //   364: aload_0
/*     */     //   365: getfield tried : Z
/*     */     //   368: ifne -> 2300
/*     */     //   371: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   374: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   379: dup
/*     */     //   380: ifnonnull -> 386
/*     */     //   383: invokestatic throwNpe : ()V
/*     */     //   386: dup
/*     */     //   387: invokeinterface getMotionY : ()D
/*     */     //   392: iconst_1
/*     */     //   393: i2d
/*     */     //   394: dadd
/*     */     //   395: invokeinterface setMotionY : (D)V
/*     */     //   400: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   403: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   408: dup
/*     */     //   409: ifnonnull -> 415
/*     */     //   412: invokestatic throwNpe : ()V
/*     */     //   415: fconst_0
/*     */     //   416: invokeinterface setFallDistance : (F)V
/*     */     //   421: aload_0
/*     */     //   422: iconst_1
/*     */     //   423: putfield tried : Z
/*     */     //   426: goto -> 2300
/*     */     //   429: aload_0
/*     */     //   430: getfield voidOnlyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   433: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   436: checkcast java/lang/Boolean
/*     */     //   439: invokevirtual booleanValue : ()Z
/*     */     //   442: ifeq -> 452
/*     */     //   445: aload_0
/*     */     //   446: invokespecial checkVoid : ()Z
/*     */     //   449: ifeq -> 2300
/*     */     //   452: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   455: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   460: dup
/*     */     //   461: ifnonnull -> 467
/*     */     //   464: invokestatic throwNpe : ()V
/*     */     //   467: invokeinterface getFallDistance : ()F
/*     */     //   472: aload_0
/*     */     //   473: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   476: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   479: checkcast java/lang/Number
/*     */     //   482: invokevirtual floatValue : ()F
/*     */     //   485: fcmpl
/*     */     //   486: ifle -> 2300
/*     */     //   489: aload_0
/*     */     //   490: getfield tried : Z
/*     */     //   493: ifne -> 2300
/*     */     //   496: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   499: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   504: getstatic net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   507: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   510: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   515: dup
/*     */     //   516: ifnonnull -> 522
/*     */     //   519: invokestatic throwNpe : ()V
/*     */     //   522: invokeinterface getPosX : ()D
/*     */     //   527: iconst_1
/*     */     //   528: i2d
/*     */     //   529: dadd
/*     */     //   530: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   533: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   538: dup
/*     */     //   539: ifnonnull -> 545
/*     */     //   542: invokestatic throwNpe : ()V
/*     */     //   545: invokeinterface getPosY : ()D
/*     */     //   550: iconst_1
/*     */     //   551: i2d
/*     */     //   552: dadd
/*     */     //   553: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   556: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   561: dup
/*     */     //   562: ifnonnull -> 568
/*     */     //   565: invokestatic throwNpe : ()V
/*     */     //   568: invokeinterface getPosZ : ()D
/*     */     //   573: iconst_1
/*     */     //   574: i2d
/*     */     //   575: dadd
/*     */     //   576: iconst_0
/*     */     //   577: invokevirtual createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   580: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   583: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   588: aload_0
/*     */     //   589: iconst_1
/*     */     //   590: putfield tried : Z
/*     */     //   593: goto -> 2300
/*     */     //   596: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   599: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   604: dup
/*     */     //   605: ifnonnull -> 611
/*     */     //   608: invokestatic throwNpe : ()V
/*     */     //   611: invokeinterface getOnGround : ()Z
/*     */     //   616: ifeq -> 769
/*     */     //   619: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   622: dup
/*     */     //   623: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   626: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   631: dup
/*     */     //   632: ifnonnull -> 638
/*     */     //   635: invokestatic throwNpe : ()V
/*     */     //   638: invokeinterface getPosX : ()D
/*     */     //   643: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   646: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   651: dup
/*     */     //   652: ifnonnull -> 658
/*     */     //   655: invokestatic throwNpe : ()V
/*     */     //   658: invokeinterface getPosY : ()D
/*     */     //   663: dconst_1
/*     */     //   664: dsub
/*     */     //   665: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   668: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   673: dup
/*     */     //   674: ifnonnull -> 680
/*     */     //   677: invokestatic throwNpe : ()V
/*     */     //   680: invokeinterface getPosZ : ()D
/*     */     //   685: invokespecial <init> : (DDD)V
/*     */     //   688: invokestatic getBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   691: instanceof net/minecraft/block/BlockAir
/*     */     //   694: ifne -> 769
/*     */     //   697: aload_0
/*     */     //   698: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   701: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   706: dup
/*     */     //   707: ifnonnull -> 713
/*     */     //   710: invokestatic throwNpe : ()V
/*     */     //   713: invokeinterface getPrevPosX : ()D
/*     */     //   718: putfield posX : D
/*     */     //   721: aload_0
/*     */     //   722: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   725: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   730: dup
/*     */     //   731: ifnonnull -> 737
/*     */     //   734: invokestatic throwNpe : ()V
/*     */     //   737: invokeinterface getPrevPosY : ()D
/*     */     //   742: putfield posY : D
/*     */     //   745: aload_0
/*     */     //   746: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   749: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   754: dup
/*     */     //   755: ifnonnull -> 761
/*     */     //   758: invokestatic throwNpe : ()V
/*     */     //   761: invokeinterface getPrevPosZ : ()D
/*     */     //   766: putfield posZ : D
/*     */     //   769: aload_0
/*     */     //   770: getfield voidOnlyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   773: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   776: checkcast java/lang/Boolean
/*     */     //   779: invokevirtual booleanValue : ()Z
/*     */     //   782: ifeq -> 792
/*     */     //   785: aload_0
/*     */     //   786: invokespecial checkVoid : ()Z
/*     */     //   789: ifeq -> 2300
/*     */     //   792: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   795: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   800: dup
/*     */     //   801: ifnonnull -> 807
/*     */     //   804: invokestatic throwNpe : ()V
/*     */     //   807: invokeinterface getFallDistance : ()F
/*     */     //   812: aload_0
/*     */     //   813: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   816: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   819: checkcast java/lang/Number
/*     */     //   822: invokevirtual floatValue : ()F
/*     */     //   825: fcmpl
/*     */     //   826: ifle -> 2300
/*     */     //   829: aload_0
/*     */     //   830: getfield tried : Z
/*     */     //   833: ifne -> 2300
/*     */     //   836: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   839: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   844: dup
/*     */     //   845: ifnonnull -> 851
/*     */     //   848: invokestatic throwNpe : ()V
/*     */     //   851: aload_0
/*     */     //   852: getfield posX : D
/*     */     //   855: aload_0
/*     */     //   856: getfield posY : D
/*     */     //   859: aload_0
/*     */     //   860: getfield posZ : D
/*     */     //   863: invokeinterface setPositionAndUpdate : (DDD)V
/*     */     //   868: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   871: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   876: dup
/*     */     //   877: ifnonnull -> 883
/*     */     //   880: invokestatic throwNpe : ()V
/*     */     //   883: fconst_0
/*     */     //   884: invokeinterface setFallDistance : (F)V
/*     */     //   889: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   892: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   897: dup
/*     */     //   898: ifnonnull -> 904
/*     */     //   901: invokestatic throwNpe : ()V
/*     */     //   904: dconst_0
/*     */     //   905: invokeinterface setMotionX : (D)V
/*     */     //   910: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   913: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   918: dup
/*     */     //   919: ifnonnull -> 925
/*     */     //   922: invokestatic throwNpe : ()V
/*     */     //   925: dconst_0
/*     */     //   926: invokeinterface setMotionY : (D)V
/*     */     //   931: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   934: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   939: dup
/*     */     //   940: ifnonnull -> 946
/*     */     //   943: invokestatic throwNpe : ()V
/*     */     //   946: dconst_0
/*     */     //   947: invokeinterface setMotionZ : (D)V
/*     */     //   952: aload_0
/*     */     //   953: iconst_1
/*     */     //   954: putfield tried : Z
/*     */     //   957: goto -> 2300
/*     */     //   960: aload_0
/*     */     //   961: iconst_0
/*     */     //   962: putfield canSpoof : Z
/*     */     //   965: aload_0
/*     */     //   966: getfield voidOnlyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   969: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   972: checkcast java/lang/Boolean
/*     */     //   975: invokevirtual booleanValue : ()Z
/*     */     //   978: ifeq -> 988
/*     */     //   981: aload_0
/*     */     //   982: invokespecial checkVoid : ()Z
/*     */     //   985: ifeq -> 1199
/*     */     //   988: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   991: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   996: dup
/*     */     //   997: ifnonnull -> 1003
/*     */     //   1000: invokestatic throwNpe : ()V
/*     */     //   1003: invokeinterface getFallDistance : ()F
/*     */     //   1008: aload_0
/*     */     //   1009: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1012: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1015: checkcast java/lang/Number
/*     */     //   1018: invokevirtual floatValue : ()F
/*     */     //   1021: fcmpl
/*     */     //   1022: ifle -> 1199
/*     */     //   1025: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1028: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1033: dup
/*     */     //   1034: ifnonnull -> 1040
/*     */     //   1037: invokestatic throwNpe : ()V
/*     */     //   1040: invokeinterface getPosY : ()D
/*     */     //   1045: aload_0
/*     */     //   1046: getfield lastRecY : D
/*     */     //   1049: ldc2_w 0.01
/*     */     //   1052: dadd
/*     */     //   1053: dcmpg
/*     */     //   1054: ifge -> 1199
/*     */     //   1057: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1060: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1065: dup
/*     */     //   1066: ifnonnull -> 1072
/*     */     //   1069: invokestatic throwNpe : ()V
/*     */     //   1072: invokeinterface getMotionY : ()D
/*     */     //   1077: iconst_0
/*     */     //   1078: i2d
/*     */     //   1079: dcmpg
/*     */     //   1080: ifgt -> 1199
/*     */     //   1083: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1086: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1091: dup
/*     */     //   1092: ifnonnull -> 1098
/*     */     //   1095: invokestatic throwNpe : ()V
/*     */     //   1098: invokeinterface getOnGround : ()Z
/*     */     //   1103: ifne -> 1199
/*     */     //   1106: aload_0
/*     */     //   1107: getfield flagged : Z
/*     */     //   1110: ifne -> 1199
/*     */     //   1113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1116: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1121: dup
/*     */     //   1122: ifnonnull -> 1128
/*     */     //   1125: invokestatic throwNpe : ()V
/*     */     //   1128: dconst_0
/*     */     //   1129: invokeinterface setMotionY : (D)V
/*     */     //   1134: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1137: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1142: dup
/*     */     //   1143: ifnonnull -> 1149
/*     */     //   1146: invokestatic throwNpe : ()V
/*     */     //   1149: dup
/*     */     //   1150: invokeinterface getMotionZ : ()D
/*     */     //   1155: ldc2_w 0.838
/*     */     //   1158: dmul
/*     */     //   1159: invokeinterface setMotionZ : (D)V
/*     */     //   1164: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1167: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1172: dup
/*     */     //   1173: ifnonnull -> 1179
/*     */     //   1176: invokestatic throwNpe : ()V
/*     */     //   1179: dup
/*     */     //   1180: invokeinterface getMotionX : ()D
/*     */     //   1185: ldc2_w 0.838
/*     */     //   1188: dmul
/*     */     //   1189: invokeinterface setMotionX : (D)V
/*     */     //   1194: aload_0
/*     */     //   1195: iconst_1
/*     */     //   1196: putfield canSpoof : Z
/*     */     //   1199: aload_0
/*     */     //   1200: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1203: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1208: dup
/*     */     //   1209: ifnonnull -> 1215
/*     */     //   1212: invokestatic throwNpe : ()V
/*     */     //   1215: invokeinterface getPosY : ()D
/*     */     //   1220: putfield lastRecY : D
/*     */     //   1223: goto -> 2300
/*     */     //   1226: aload_0
/*     */     //   1227: iconst_0
/*     */     //   1228: putfield canSpoof : Z
/*     */     //   1231: aload_0
/*     */     //   1232: getfield voidOnlyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1235: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1238: checkcast java/lang/Boolean
/*     */     //   1241: invokevirtual booleanValue : ()Z
/*     */     //   1244: ifeq -> 1254
/*     */     //   1247: aload_0
/*     */     //   1248: invokespecial checkVoid : ()Z
/*     */     //   1251: ifeq -> 1546
/*     */     //   1254: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1257: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1262: dup
/*     */     //   1263: ifnonnull -> 1269
/*     */     //   1266: invokestatic throwNpe : ()V
/*     */     //   1269: invokeinterface getFallDistance : ()F
/*     */     //   1274: aload_0
/*     */     //   1275: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1278: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1281: checkcast java/lang/Number
/*     */     //   1284: invokevirtual floatValue : ()F
/*     */     //   1287: fcmpl
/*     */     //   1288: ifle -> 1546
/*     */     //   1291: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1294: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1299: dup
/*     */     //   1300: ifnonnull -> 1306
/*     */     //   1303: invokestatic throwNpe : ()V
/*     */     //   1306: invokeinterface getPosY : ()D
/*     */     //   1311: aload_0
/*     */     //   1312: getfield lastRecY : D
/*     */     //   1315: ldc2_w 0.01
/*     */     //   1318: dadd
/*     */     //   1319: dcmpg
/*     */     //   1320: ifge -> 1546
/*     */     //   1323: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1326: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1331: dup
/*     */     //   1332: ifnonnull -> 1338
/*     */     //   1335: invokestatic throwNpe : ()V
/*     */     //   1338: invokeinterface getMotionY : ()D
/*     */     //   1343: iconst_0
/*     */     //   1344: i2d
/*     */     //   1345: dcmpg
/*     */     //   1346: ifgt -> 1546
/*     */     //   1349: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1352: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1357: dup
/*     */     //   1358: ifnonnull -> 1364
/*     */     //   1361: invokestatic throwNpe : ()V
/*     */     //   1364: invokeinterface getOnGround : ()Z
/*     */     //   1369: ifne -> 1546
/*     */     //   1372: aload_0
/*     */     //   1373: getfield flagged : Z
/*     */     //   1376: ifne -> 1546
/*     */     //   1379: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1382: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1387: dup
/*     */     //   1388: ifnonnull -> 1394
/*     */     //   1391: invokestatic throwNpe : ()V
/*     */     //   1394: dconst_0
/*     */     //   1395: invokeinterface setMotionY : (D)V
/*     */     //   1400: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1403: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1408: dup
/*     */     //   1409: ifnonnull -> 1415
/*     */     //   1412: invokestatic throwNpe : ()V
/*     */     //   1415: dconst_0
/*     */     //   1416: invokeinterface setMotionZ : (D)V
/*     */     //   1421: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1424: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1429: dup
/*     */     //   1430: ifnonnull -> 1436
/*     */     //   1433: invokestatic throwNpe : ()V
/*     */     //   1436: dconst_0
/*     */     //   1437: invokeinterface setMotionX : (D)V
/*     */     //   1442: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1445: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1450: dup
/*     */     //   1451: ifnonnull -> 1457
/*     */     //   1454: invokestatic throwNpe : ()V
/*     */     //   1457: fconst_0
/*     */     //   1458: invokeinterface setJumpMovementFactor : (F)V
/*     */     //   1463: aload_0
/*     */     //   1464: iconst_1
/*     */     //   1465: putfield canSpoof : Z
/*     */     //   1468: aload_0
/*     */     //   1469: getfield tried : Z
/*     */     //   1472: ifne -> 1546
/*     */     //   1475: aload_0
/*     */     //   1476: iconst_1
/*     */     //   1477: putfield tried : Z
/*     */     //   1480: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1483: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1488: getstatic net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   1491: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1494: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1499: dup
/*     */     //   1500: ifnonnull -> 1506
/*     */     //   1503: invokestatic throwNpe : ()V
/*     */     //   1506: invokeinterface getPosX : ()D
/*     */     //   1511: ldc2_w 32000.0
/*     */     //   1514: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1517: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1522: dup
/*     */     //   1523: ifnonnull -> 1529
/*     */     //   1526: invokestatic throwNpe : ()V
/*     */     //   1529: invokeinterface getPosZ : ()D
/*     */     //   1534: iconst_0
/*     */     //   1535: invokevirtual createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1538: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1541: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1546: aload_0
/*     */     //   1547: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1550: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1555: dup
/*     */     //   1556: ifnonnull -> 1562
/*     */     //   1559: invokestatic throwNpe : ()V
/*     */     //   1562: invokeinterface getPosY : ()D
/*     */     //   1567: putfield lastRecY : D
/*     */     //   1570: goto -> 2300
/*     */     //   1573: aload_0
/*     */     //   1574: getfield blink : Z
/*     */     //   1577: ifne -> 1901
/*     */     //   1580: new me/utils/FallingPlayer
/*     */     //   1583: dup
/*     */     //   1584: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1587: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1592: dup
/*     */     //   1593: ifnonnull -> 1599
/*     */     //   1596: invokestatic throwNpe : ()V
/*     */     //   1599: invokeinterface getPosX : ()D
/*     */     //   1604: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1607: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1612: dup
/*     */     //   1613: ifnonnull -> 1619
/*     */     //   1616: invokestatic throwNpe : ()V
/*     */     //   1619: invokeinterface getPosY : ()D
/*     */     //   1624: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1627: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1632: dup
/*     */     //   1633: ifnonnull -> 1639
/*     */     //   1636: invokestatic throwNpe : ()V
/*     */     //   1639: invokeinterface getPosZ : ()D
/*     */     //   1644: dconst_0
/*     */     //   1645: dconst_0
/*     */     //   1646: dconst_0
/*     */     //   1647: fconst_0
/*     */     //   1648: fconst_0
/*     */     //   1649: fconst_0
/*     */     //   1650: fconst_0
/*     */     //   1651: invokespecial <init> : (DDDDDDFFFF)V
/*     */     //   1654: bipush #60
/*     */     //   1656: invokevirtual findCollision : (I)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1659: astore_3
/*     */     //   1660: aload_0
/*     */     //   1661: getfield canBlink : Z
/*     */     //   1664: ifeq -> 1870
/*     */     //   1667: aload_3
/*     */     //   1668: ifnull -> 1714
/*     */     //   1671: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1674: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1679: dup
/*     */     //   1680: ifnonnull -> 1686
/*     */     //   1683: invokestatic throwNpe : ()V
/*     */     //   1686: invokeinterface getPosY : ()D
/*     */     //   1691: aload_3
/*     */     //   1692: invokevirtual getY : ()I
/*     */     //   1695: i2d
/*     */     //   1696: dsub
/*     */     //   1697: aload_0
/*     */     //   1698: getfield startFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1701: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1704: checkcast java/lang/Number
/*     */     //   1707: invokevirtual doubleValue : ()D
/*     */     //   1710: dcmpl
/*     */     //   1711: ifle -> 1870
/*     */     //   1714: aload_0
/*     */     //   1715: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1718: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1723: dup
/*     */     //   1724: ifnonnull -> 1730
/*     */     //   1727: invokestatic throwNpe : ()V
/*     */     //   1730: invokeinterface getPosX : ()D
/*     */     //   1735: putfield posX : D
/*     */     //   1738: aload_0
/*     */     //   1739: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1742: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1747: dup
/*     */     //   1748: ifnonnull -> 1754
/*     */     //   1751: invokestatic throwNpe : ()V
/*     */     //   1754: invokeinterface getPosY : ()D
/*     */     //   1759: putfield posY : D
/*     */     //   1762: aload_0
/*     */     //   1763: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1766: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1771: dup
/*     */     //   1772: ifnonnull -> 1778
/*     */     //   1775: invokestatic throwNpe : ()V
/*     */     //   1778: invokeinterface getPosZ : ()D
/*     */     //   1783: putfield posZ : D
/*     */     //   1786: aload_0
/*     */     //   1787: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1790: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1795: dup
/*     */     //   1796: ifnonnull -> 1802
/*     */     //   1799: invokestatic throwNpe : ()V
/*     */     //   1802: invokeinterface getMotionX : ()D
/*     */     //   1807: putfield motionX : D
/*     */     //   1810: aload_0
/*     */     //   1811: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1814: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1819: dup
/*     */     //   1820: ifnonnull -> 1826
/*     */     //   1823: invokestatic throwNpe : ()V
/*     */     //   1826: invokeinterface getMotionY : ()D
/*     */     //   1831: putfield motionY : D
/*     */     //   1834: aload_0
/*     */     //   1835: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1838: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1843: dup
/*     */     //   1844: ifnonnull -> 1850
/*     */     //   1847: invokestatic throwNpe : ()V
/*     */     //   1850: invokeinterface getMotionZ : ()D
/*     */     //   1855: putfield motionZ : D
/*     */     //   1858: aload_0
/*     */     //   1859: getfield packetCache : Ljava/util/ArrayList;
/*     */     //   1862: invokevirtual clear : ()V
/*     */     //   1865: aload_0
/*     */     //   1866: iconst_1
/*     */     //   1867: putfield blink : Z
/*     */     //   1870: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1873: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1878: dup
/*     */     //   1879: ifnonnull -> 1885
/*     */     //   1882: invokestatic throwNpe : ()V
/*     */     //   1885: invokeinterface getOnGround : ()Z
/*     */     //   1890: ifeq -> 2300
/*     */     //   1893: aload_0
/*     */     //   1894: iconst_1
/*     */     //   1895: putfield canBlink : Z
/*     */     //   1898: goto -> 2300
/*     */     //   1901: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1904: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1909: dup
/*     */     //   1910: ifnonnull -> 1916
/*     */     //   1913: invokestatic throwNpe : ()V
/*     */     //   1916: invokeinterface getFallDistance : ()F
/*     */     //   1921: aload_0
/*     */     //   1922: getfield maxFallDistValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1925: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1928: checkcast java/lang/Number
/*     */     //   1931: invokevirtual floatValue : ()F
/*     */     //   1934: fcmpl
/*     */     //   1935: ifle -> 2225
/*     */     //   1938: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1941: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1946: dup
/*     */     //   1947: ifnonnull -> 1953
/*     */     //   1950: invokestatic throwNpe : ()V
/*     */     //   1953: aload_0
/*     */     //   1954: getfield posX : D
/*     */     //   1957: aload_0
/*     */     //   1958: getfield posY : D
/*     */     //   1961: aload_0
/*     */     //   1962: getfield posZ : D
/*     */     //   1965: invokeinterface setPositionAndUpdate : (DDD)V
/*     */     //   1970: aload_0
/*     */     //   1971: getfield resetMotionValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1974: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1977: checkcast java/lang/Boolean
/*     */     //   1980: invokevirtual booleanValue : ()Z
/*     */     //   1983: ifeq -> 2073
/*     */     //   1986: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1989: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1994: dup
/*     */     //   1995: ifnonnull -> 2001
/*     */     //   1998: invokestatic throwNpe : ()V
/*     */     //   2001: dconst_0
/*     */     //   2002: invokeinterface setMotionX : (D)V
/*     */     //   2007: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2010: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2015: dup
/*     */     //   2016: ifnonnull -> 2022
/*     */     //   2019: invokestatic throwNpe : ()V
/*     */     //   2022: dconst_0
/*     */     //   2023: invokeinterface setMotionY : (D)V
/*     */     //   2028: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2031: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2036: dup
/*     */     //   2037: ifnonnull -> 2043
/*     */     //   2040: invokestatic throwNpe : ()V
/*     */     //   2043: dconst_0
/*     */     //   2044: invokeinterface setMotionZ : (D)V
/*     */     //   2049: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2052: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2057: dup
/*     */     //   2058: ifnonnull -> 2064
/*     */     //   2061: invokestatic throwNpe : ()V
/*     */     //   2064: fconst_0
/*     */     //   2065: invokeinterface setJumpMovementFactor : (F)V
/*     */     //   2070: goto -> 2166
/*     */     //   2073: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2076: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2081: dup
/*     */     //   2082: ifnonnull -> 2088
/*     */     //   2085: invokestatic throwNpe : ()V
/*     */     //   2088: aload_0
/*     */     //   2089: getfield motionX : D
/*     */     //   2092: invokeinterface setMotionX : (D)V
/*     */     //   2097: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2100: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2105: dup
/*     */     //   2106: ifnonnull -> 2112
/*     */     //   2109: invokestatic throwNpe : ()V
/*     */     //   2112: aload_0
/*     */     //   2113: getfield motionY : D
/*     */     //   2116: invokeinterface setMotionY : (D)V
/*     */     //   2121: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2124: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2129: dup
/*     */     //   2130: ifnonnull -> 2136
/*     */     //   2133: invokestatic throwNpe : ()V
/*     */     //   2136: aload_0
/*     */     //   2137: getfield motionZ : D
/*     */     //   2140: invokeinterface setMotionZ : (D)V
/*     */     //   2145: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2148: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2153: dup
/*     */     //   2154: ifnonnull -> 2160
/*     */     //   2157: invokestatic throwNpe : ()V
/*     */     //   2160: fconst_0
/*     */     //   2161: invokeinterface setJumpMovementFactor : (F)V
/*     */     //   2166: aload_0
/*     */     //   2167: getfield autoScaffoldValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2170: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2173: checkcast java/lang/Boolean
/*     */     //   2176: invokevirtual booleanValue : ()Z
/*     */     //   2179: ifeq -> 2205
/*     */     //   2182: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   2185: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   2188: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold
/*     */     //   2191: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   2194: dup
/*     */     //   2195: ifnonnull -> 2201
/*     */     //   2198: invokestatic throwNpe : ()V
/*     */     //   2201: iconst_1
/*     */     //   2202: invokevirtual setState : (Z)V
/*     */     //   2205: aload_0
/*     */     //   2206: getfield packetCache : Ljava/util/ArrayList;
/*     */     //   2209: invokevirtual clear : ()V
/*     */     //   2212: aload_0
/*     */     //   2213: iconst_0
/*     */     //   2214: putfield blink : Z
/*     */     //   2217: aload_0
/*     */     //   2218: iconst_0
/*     */     //   2219: putfield canBlink : Z
/*     */     //   2222: goto -> 2300
/*     */     //   2225: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2228: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2233: dup
/*     */     //   2234: ifnonnull -> 2240
/*     */     //   2237: invokestatic throwNpe : ()V
/*     */     //   2240: invokeinterface getOnGround : ()Z
/*     */     //   2245: ifeq -> 2300
/*     */     //   2248: aload_0
/*     */     //   2249: iconst_0
/*     */     //   2250: putfield blink : Z
/*     */     //   2253: aload_0
/*     */     //   2254: getfield packetCache : Ljava/util/ArrayList;
/*     */     //   2257: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   2260: astore #4
/*     */     //   2262: aload #4
/*     */     //   2264: invokeinterface hasNext : ()Z
/*     */     //   2269: ifeq -> 2300
/*     */     //   2272: aload #4
/*     */     //   2274: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   2279: checkcast net/minecraft/network/play/client/CPacketPlayer
/*     */     //   2282: astore_3
/*     */     //   2283: aload_3
/*     */     //   2284: dup
/*     */     //   2285: ldc_w 'packet'
/*     */     //   2288: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2291: checkcast net/minecraft/network/Packet
/*     */     //   2294: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   2297: goto -> 2262
/*     */     //   2300: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #78	-> 6
/*     */     //   #79	-> 29
/*     */     //   #80	-> 34
/*     */     //   #83	-> 39
/*     */     //   #127	-> 148
/*     */     //   #140	-> 160
/*     */     //   #109	-> 172
/*     */     //   #84	-> 184
/*     */     //   #158	-> 196
/*     */     //   #90	-> 208
/*     */     //   #100	-> 220
/*     */     //   #85	-> 232
/*     */     //   #86	-> 255
/*     */     //   #91	-> 304
/*     */     //   #92	-> 327
/*     */     //   #93	-> 371
/*     */     //   #94	-> 400
/*     */     //   #95	-> 421
/*     */     //   #101	-> 429
/*     */     //   #102	-> 452
/*     */     //   #103	-> 496
/*     */     //   #104	-> 588
/*     */     //   #110	-> 596
/*     */     //   #111	-> 697
/*     */     //   #112	-> 721
/*     */     //   #113	-> 745
/*     */     //   #115	-> 769
/*     */     //   #116	-> 792
/*     */     //   #117	-> 836
/*     */     //   #118	-> 868
/*     */     //   #119	-> 889
/*     */     //   #120	-> 910
/*     */     //   #121	-> 931
/*     */     //   #122	-> 952
/*     */     //   #128	-> 960
/*     */     //   #129	-> 965
/*     */     //   #130	-> 988
/*     */     //   #131	-> 1113
/*     */     //   #132	-> 1134
/*     */     //   #133	-> 1164
/*     */     //   #134	-> 1194
/*     */     //   #137	-> 1199
/*     */     //   #141	-> 1226
/*     */     //   #142	-> 1231
/*     */     //   #143	-> 1254
/*     */     //   #144	-> 1379
/*     */     //   #145	-> 1400
/*     */     //   #146	-> 1421
/*     */     //   #147	-> 1442
/*     */     //   #148	-> 1463
/*     */     //   #149	-> 1468
/*     */     //   #150	-> 1475
/*     */     //   #151	-> 1480
/*     */     //   #155	-> 1546
/*     */     //   #159	-> 1573
/*     */     //   #160	-> 1580
/*     */     //   #161	-> 1660
/*     */     //   #162	-> 1714
/*     */     //   #163	-> 1738
/*     */     //   #164	-> 1762
/*     */     //   #165	-> 1786
/*     */     //   #166	-> 1810
/*     */     //   #167	-> 1834
/*     */     //   #169	-> 1858
/*     */     //   #170	-> 1865
/*     */     //   #173	-> 1870
/*     */     //   #174	-> 1893
/*     */     //   #177	-> 1901
/*     */     //   #178	-> 1938
/*     */     //   #179	-> 1970
/*     */     //   #180	-> 1986
/*     */     //   #181	-> 2007
/*     */     //   #182	-> 2028
/*     */     //   #183	-> 2049
/*     */     //   #185	-> 2073
/*     */     //   #186	-> 2097
/*     */     //   #187	-> 2121
/*     */     //   #188	-> 2145
/*     */     //   #189	-> 2166
/*     */     //   #191	-> 2166
/*     */     //   #192	-> 2182
/*     */     //   #195	-> 2205
/*     */     //   #196	-> 2212
/*     */     //   #197	-> 2217
/*     */     //   #198	-> 2225
/*     */     //   #199	-> 2248
/*     */     //   #201	-> 2253
/*     */     //   #202	-> 2283
/*     */     //   #201	-> 2297
/*     */     //   #204	-> 2300
/*     */     //   #205	-> 2300
/*     */     //   #207	-> 2300
/*     */     //   #208	-> 2300
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   1660	238	3	collide	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   2283	14	3	packet	Lnet/minecraft/network/play/client/CPacketPlayer;
/*     */     //   0	2301	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/BugUP;
/*     */     //   0	2301	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean checkVoid() {
/* 211 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  int i = (int)-(MinecraftInstance.mc.getThePlayer().getPosY() - 1.4857625D);
/* 212 */     boolean dangerous = true;
/* 213 */     while (i <= 0) {
/* 214 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  dangerous = MinecraftInstance.mc.getTheWorld().getCollisionBoxes(MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().offset(MinecraftInstance.mc.getThePlayer().getMotionX() * 0.5D, i, MinecraftInstance.mc.getThePlayer().getMotionZ() * 0.5D)).isEmpty();
/* 215 */       i++;
/* 216 */       if (!dangerous)
/*     */         break; 
/* 218 */     }  return dangerous;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 223 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*     */     
/* 225 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1167184852:
/* 239 */         if (str.equals("jartex")) {
/* 240 */           if (this.canSpoof && packet instanceof CPacketPlayer) {
/* 241 */             ((CPacketPlayer)packet).field_149474_g = true;
/*     */           }
/* 243 */           if (this.canSpoof && packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook)
/* 244 */             this.flagged = true; 
/*     */         } 
/*     */         break;
/*     */       case 1438074052:
/* 248 */         if (str.equals("oldcubecraft")) {
/* 249 */           if (this.canSpoof && packet instanceof CPacketPlayer && 
/* 250 */             ((CPacketPlayer)packet).field_149477_b < 1145.14191981D) event.cancelEvent();
/*     */           
/* 252 */           if (this.canSpoof && packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook)
/* 253 */             this.flagged = true; 
/*     */         } 
/*     */         break;
/*     */       case 1594535950:
/* 257 */         if (str.equals("oldhypixel"))
/* 258 */         { if (packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > 3.125D) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setFallDistance(3.125F); }
/*     */              }
/* 260 */            if (packet instanceof CPacketPlayer)
/* 261 */           { if (((Boolean)this.voidOnlyValue.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() >= ((Number)this.maxFallDistValue.get()).floatValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionY() <= false && checkVoid())
/* 262 */                   ((CPacketPlayer)packet).field_149477_b += 11.0D;  }
/*     */                }
/* 264 */              if (!((Boolean)this.voidOnlyValue.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() >= ((Number)this.maxFallDistValue.get()).floatValue()) ((CPacketPlayer)packet).field_149477_b += 11.0D;  }  }  }  break;
/*     */       case 93826908: if (str.equals("blink") && this.blink && packet instanceof CPacketPlayer) { this.packetCache.add(packet); event.cancelEvent(); }  break;
/*     */       case -529978910: if (str.equals("groundspoof") && this.canSpoof && packet instanceof CPacketPlayer)
/*     */           ((CPacketPlayer)packet).field_149474_g = true;  break;
/* 268 */       case 1381910549: if (str.equals("hypixel")) {
/* 269 */           if (Retreat.INSTANCE.getModuleManager().getModule(Fly.class) == null) Intrinsics.throwNpe();  if (!Retreat.INSTANCE.getModuleManager().getModule(Fly.class).getState()) { if (Retreat.INSTANCE.getModuleManager().getModule(
/* 270 */                 Scaffold.class) == null) Intrinsics.throwNpe();  if (!Retreat.INSTANCE.getModuleManager().getModule(Scaffold.class).getState()) {
/* 271 */               if (!this.packets.isEmpty()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getTicksExisted() < 100) this.packets.clear();  }
/* 272 */                if (packet instanceof CPacketPlayer) {
/* 273 */                 if (isInVoid()) {
/* 274 */                   event.cancelEvent();
/* 275 */                   this.packets.add(packet);
/* 276 */                   if (this.timer.delay(((Number)this.pullbackTime.get()).floatValue())) {
/* 277 */                     PacketUtils.sendPacketNoEvent(
/* 278 */                         (Packet)new CPacketPlayer.Position(
/* 279 */                           this.lastGroundPos[0], this.lastGroundPos[1] - 1.0D, 
/* 280 */                           this.lastGroundPos[2], true));
/*     */                   }
/*     */                 }
/*     */                 else {
/*     */                   
/* 285 */                   if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastGroundPos[0] = MinecraftInstance.mc.getThePlayer().getPosX();
/* 286 */                   if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastGroundPos[1] = MinecraftInstance.mc.getThePlayer().getPosY();
/* 287 */                   if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastGroundPos[2] = MinecraftInstance.mc.getThePlayer().getPosZ();
/* 288 */                   if (!this.packets.isEmpty()) {
/* 289 */                     Intrinsics.checkExpressionValueIsNotNull(this.packets.iterator(), "packets.iterator()"); Iterator<CPacketPlayer> var3 = this.packets.iterator();
/* 290 */                     ClientUtils.displayChatMessage("[AntiVoid] Release Packets - " + this.packets.size());
/* 291 */                     while (var3.hasNext()) {
/* 292 */                       if (var3.next() == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayer");  CPacketPlayer p = var3.next();
/* 293 */                       PacketUtils.sendPacketNoEvent((Packet)p);
/*     */                     } 
/* 295 */                     this.packets.clear();
/*     */                   } 
/* 297 */                   this.timer.reset();
/*     */                 } 
/*     */               }
/*     */             }  }
/*     */           
/* 302 */           if (packet instanceof net.minecraft.network.play.server.SPacketPlayerPosLook && this.packets.size() > 1) {
/* 303 */             ClientUtils.displayChatMessage("[AntiVoid] Pullbacks Detected, clear packets list!");
/* 304 */             this.packets.clear();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\BugUP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */