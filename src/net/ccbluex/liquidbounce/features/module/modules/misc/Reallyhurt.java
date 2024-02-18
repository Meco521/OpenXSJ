/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "Reallyhurt", category = ModuleCategory.MISC, description = "skid")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\b\n\000\n\002\020\013\n\002\b\004\n\002\020\007\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\016\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020'\032\0020(2\006\020)\032\0020*H\007J\b\020+\032\0020(H\026J\020\020,\032\0020(2\006\020)\032\0020-H\007J\020\020.\032\0020(2\006\020)\032\0020/H\007J\020\0200\032\0020(2\006\020)\032\00201H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\013X\016¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\004X\004¢\006\002\n\000R\016\020\021\032\0020\022X\016¢\006\002\n\000R\016\020\023\032\0020\022X\016¢\006\002\n\000R\016\020\024\032\0020\022X\016¢\006\002\n\000R\016\020\025\032\0020\rX\016¢\006\002\n\000R\016\020\026\032\0020\027X\004¢\006\002\n\000R\032\020\030\032\0020\031X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035R\032\020\036\032\0020\031X\016¢\006\016\n\000\032\004\b\037\020\033\"\004\b \020\035R\016\020!\032\0020\rX\016¢\006\002\n\000R\032\020\"\032\0020\031X\016¢\006\016\n\000\032\004\b#\020\033\"\004\b$\020\035R\016\020%\032\0020\031X\004¢\006\002\n\000R\016\020&\032\0020\013X\016¢\006\002\n\000¨\0062"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/Reallyhurt;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Heal", "autodis", "autohub", "autorange", "autosafe", "b", "", "change", "", "cooldown", "faceHeal", "faceentidyHeal", "facehealth", "", "health", "health2", "hit", "nohurtValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "normalairrangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getNormalairrangeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "setNormalairrangeValue", "(Lnet/ccbluex/liquidbounce/value/FloatValue;)V", "normalgroundrangeValue", "getNormalgroundrangeValue", "setNormalgroundrangeValue", "rest", "safeValue", "getSafeValue", "setSafeValue", "saferangeValue", "ticks", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onEnable", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Reallyhurt
/*    */   extends Module
/*    */ {
/* 32 */   private final IntegerValue nohurtValue = new IntegerValue("nohurtValue", 3, 1, 100);
/* 33 */   private final FloatValue saferangeValue = new FloatValue("saferangeValue", 3.0F, 3.0F, 6.0F); @NotNull
/* 34 */   private FloatValue normalgroundrangeValue = new FloatValue("normalgroundrangeValue", 3.0F, 3.0F, 6.0F); @NotNull public final FloatValue getNormalgroundrangeValue() { return this.normalgroundrangeValue; } public final void setNormalgroundrangeValue(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.normalgroundrangeValue = <set-?>; } @NotNull
/* 35 */   private FloatValue normalairrangeValue = new FloatValue("normalairrangeValue", 3.0F, 3.0F, 6.0F); @NotNull public final FloatValue getNormalairrangeValue() { return this.normalairrangeValue; } public final void setNormalairrangeValue(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.normalairrangeValue = <set-?>; } @NotNull
/* 36 */   private FloatValue safeValue = new FloatValue("maxsafeValue", 3.0F, 3.0F, 6.0F); @NotNull public final FloatValue getSafeValue() { return this.safeValue; } public final void setSafeValue(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.safeValue = <set-?>; }
/* 37 */    private final BoolValue Debug = new BoolValue("Debug", true);
/* 38 */   private final BoolValue Heal = new BoolValue("Heal", true);
/* 39 */   private final BoolValue faceHeal = new BoolValue("faceHeal", true);
/* 40 */   private final BoolValue faceentidyHeal = new BoolValue("faceentidyHeal", true);
/* 41 */   private final BoolValue autorange = new BoolValue("autorange", true);
/* 42 */   private final BoolValue autohub = new BoolValue("autohub", true);
/* 43 */   private final BoolValue autosafe = new BoolValue("autosafe", true);
/* 44 */   private final BoolValue autodis = new BoolValue("autodis", true);
/*    */   private boolean hit;
/*    */   private boolean change;
/*    */   private boolean rest;
/*    */   private int b;
/* 49 */   private float health = 20.0F;
/* 50 */   private float facehealth = 20.0F;
/* 51 */   private float health2 = 20.0F;
/*    */   
/*    */   private int ticks;
/*    */   private int cooldown;
/*    */   
/*    */   public void onEnable() {
/* 57 */     this.hit = false;
/* 58 */     this.rest = false;
/* 59 */     this.cooldown = 0;
/* 60 */     this.b = 0;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 65 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.hit = true;
/* 66 */     this.cooldown = 0;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender(@NotNull Render3DEvent event) {
/* 71 */     Intrinsics.checkParameterIsNotNull(event, "event"); IMovingObjectPosition objectMouseOver = MinecraftInstance.mc.getObjectMouseOver();
/*    */ 
/*    */     
/* 74 */     if (objectMouseOver != null && EntityUtils.isSelected(objectMouseOver.getEntityHit(), true)) {
/* 75 */       IEntity entityHit = objectMouseOver.getEntityHit();
/* 76 */       if (entityHit instanceof IEntityLivingBase)
/* 77 */         this.health2 = ((IEntityLivingBase)entityHit).getHealth(); 
/*    */     } 
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
/*    */     //   36: aload_2
/*    */     //   37: instanceof net/minecraft/network/play/server/SPacketChat
/*    */     //   40: ifeq -> 310
/*    */     //   43: aload_2
/*    */     //   44: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   47: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   50: dup
/*    */     //   51: ldc 'packet.chatComponent'
/*    */     //   53: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   56: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   61: dup
/*    */     //   62: ldc 'packet.chatComponent.unformattedText'
/*    */     //   64: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   67: checkcast java/lang/CharSequence
/*    */     //   70: ldc ':'
/*    */     //   72: checkcast java/lang/CharSequence
/*    */     //   75: iconst_0
/*    */     //   76: iconst_2
/*    */     //   77: aconst_null
/*    */     //   78: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*    */     //   81: ifne -> 310
/*    */     //   84: aload_2
/*    */     //   85: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   88: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   91: dup
/*    */     //   92: ldc 'packet.chatComponent'
/*    */     //   94: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   97: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   102: dup
/*    */     //   103: ldc 'packet.chatComponent.unformattedText'
/*    */     //   105: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   108: ldc '起床战争'
/*    */     //   110: iconst_0
/*    */     //   111: iconst_2
/*    */     //   112: aconst_null
/*    */     //   113: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   116: ifne -> 189
/*    */     //   119: aload_2
/*    */     //   120: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   123: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   126: dup
/*    */     //   127: ldc 'packet.chatComponent'
/*    */     //   129: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   132: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   137: dup
/*    */     //   138: ldc 'packet.chatComponent.unformattedText'
/*    */     //   140: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   143: ldc '[起床战争'
/*    */     //   145: iconst_0
/*    */     //   146: iconst_2
/*    */     //   147: aconst_null
/*    */     //   148: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   151: ifne -> 189
/*    */     //   154: aload_2
/*    */     //   155: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   158: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   161: dup
/*    */     //   162: ldc 'packet.chatComponent'
/*    */     //   164: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   167: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   172: dup
/*    */     //   173: ldc 'packet.chatComponent.unformattedText'
/*    */     //   175: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   178: ldc '花雨庭'
/*    */     //   180: iconst_0
/*    */     //   181: iconst_2
/*    */     //   182: aconst_null
/*    */     //   183: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   186: ifeq -> 310
/*    */     //   189: aload_2
/*    */     //   190: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   193: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   196: dup
/*    */     //   197: ldc 'packet.chatComponent'
/*    */     //   199: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   202: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   207: astore_3
/*    */     //   208: ldc '游戏开始'
/*    */     //   210: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*    */     //   213: aload_3
/*    */     //   214: checkcast java/lang/CharSequence
/*    */     //   217: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*    */     //   220: astore #4
/*    */     //   222: ldc '恭喜'
/*    */     //   224: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*    */     //   227: aload_3
/*    */     //   228: checkcast java/lang/CharSequence
/*    */     //   231: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*    */     //   234: astore #5
/*    */     //   236: ldc '加入游戏'
/*    */     //   238: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*    */     //   241: aload_3
/*    */     //   242: checkcast java/lang/CharSequence
/*    */     //   245: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*    */     //   248: astore #6
/*    */     //   250: aload #4
/*    */     //   252: invokevirtual find : ()Z
/*    */     //   255: ifne -> 274
/*    */     //   258: aload #5
/*    */     //   260: invokevirtual find : ()Z
/*    */     //   263: ifne -> 274
/*    */     //   266: aload #6
/*    */     //   268: invokevirtual find : ()Z
/*    */     //   271: ifeq -> 310
/*    */     //   274: aload_0
/*    */     //   275: iconst_0
/*    */     //   276: putfield b : I
/*    */     //   279: aload_0
/*    */     //   280: iconst_0
/*    */     //   281: putfield hit : Z
/*    */     //   284: aload_0
/*    */     //   285: iconst_0
/*    */     //   286: putfield rest : Z
/*    */     //   289: aload_0
/*    */     //   290: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   293: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   296: checkcast java/lang/Boolean
/*    */     //   299: invokevirtual booleanValue : ()Z
/*    */     //   302: ifeq -> 310
/*    */     //   305: ldc '§8[§c§lRetreat§8]§c§d空刀检测还原'
/*    */     //   307: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   310: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #85	-> 6
/*    */     //   #178	-> 14
/*    */     //   #85	-> 35
/*    */     //   #86	-> 36
/*    */     //   #88	-> 36
/*    */     //   #86	-> 36
/*    */     //   #87	-> 108
/*    */     //   #86	-> 113
/*    */     //   #88	-> 119
/*    */     //   #90	-> 189
/*    */     //   #91	-> 208
/*    */     //   #92	-> 222
/*    */     //   #93	-> 236
/*    */     //   #94	-> 250
/*    */     //   #95	-> 274
/*    */     //   #96	-> 279
/*    */     //   #97	-> 284
/*    */     //   #98	-> 289
/*    */     //   #99	-> 305
/*    */     //   #103	-> 310
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   11	24	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   14	21	4	$i$f$unwrap	I
/*    */     //   250	60	6	matcher3	Ljava/util/regex/Matcher;
/*    */     //   236	74	5	matcher2	Ljava/util/regex/Matcher;
/*    */     //   222	88	4	matcher	Ljava/util/regex/Matcher;
/*    */     //   208	102	3	chat	Ljava/lang/String;
/*    */     //   36	275	2	packet	Lnet/minecraft/network/Packet;
/*    */     //   0	311	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/misc/Reallyhurt;
/*    */     //   0	311	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: dup
/*    */     //   8: getfield ticks : I
/*    */     //   11: iconst_1
/*    */     //   12: iadd
/*    */     //   13: putfield ticks : I
/*    */     //   16: aload_0
/*    */     //   17: dup
/*    */     //   18: getfield cooldown : I
/*    */     //   21: iconst_1
/*    */     //   22: iadd
/*    */     //   23: putfield cooldown : I
/*    */     //   26: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   29: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   32: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   35: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   38: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   41: astore_2
/*    */     //   42: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   45: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   48: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/Safeauramode
/*    */     //   51: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   54: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/Safeauramode
/*    */     //   57: astore_3
/*    */     //   58: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   61: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   64: ldc_w net/ccbluex/liquidbounce/features/module/modules/exploit/NoC0B
/*    */     //   67: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   70: checkcast net/ccbluex/liquidbounce/features/module/modules/exploit/NoC0B
/*    */     //   73: astore #4
/*    */     //   75: aload_2
/*    */     //   76: dup
/*    */     //   77: ifnonnull -> 83
/*    */     //   80: invokestatic throwNpe : ()V
/*    */     //   83: invokevirtual getState : ()Z
/*    */     //   86: ifeq -> 96
/*    */     //   89: aload_2
/*    */     //   90: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   93: ifnonnull -> 101
/*    */     //   96: aload_0
/*    */     //   97: iconst_0
/*    */     //   98: putfield hit : Z
/*    */     //   101: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   104: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   109: dup
/*    */     //   110: ifnonnull -> 116
/*    */     //   113: invokestatic throwNpe : ()V
/*    */     //   116: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*    */     //   121: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   126: astore #6
/*    */     //   128: aload #6
/*    */     //   130: invokeinterface hasNext : ()Z
/*    */     //   135: ifeq -> 180
/*    */     //   138: aload #6
/*    */     //   140: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   145: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   148: astore #5
/*    */     //   150: aload #5
/*    */     //   152: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   157: astore #7
/*    */     //   159: aload_0
/*    */     //   160: getfield hit : Z
/*    */     //   163: ifne -> 177
/*    */     //   166: aload_0
/*    */     //   167: aload #7
/*    */     //   169: invokeinterface getHealth : ()F
/*    */     //   174: putfield health : F
/*    */     //   177: goto -> 128
/*    */     //   180: aload_2
/*    */     //   181: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   184: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   187: ldc2_w 0.05
/*    */     //   190: invokestatic isFaced : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;D)Z
/*    */     //   193: ifeq -> 239
/*    */     //   196: aload_0
/*    */     //   197: getfield faceHeal : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   200: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   203: checkcast java/lang/Boolean
/*    */     //   206: invokevirtual booleanValue : ()Z
/*    */     //   209: ifeq -> 239
/*    */     //   212: aload_0
/*    */     //   213: getfield hit : Z
/*    */     //   216: ifne -> 239
/*    */     //   219: aload_0
/*    */     //   220: aload_2
/*    */     //   221: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   224: dup
/*    */     //   225: ifnonnull -> 231
/*    */     //   228: invokestatic throwNpe : ()V
/*    */     //   231: invokeinterface getHealth : ()F
/*    */     //   236: putfield facehealth : F
/*    */     //   239: aload_0
/*    */     //   240: getfield hit : Z
/*    */     //   243: ifeq -> 284
/*    */     //   246: aload_2
/*    */     //   247: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   250: dup
/*    */     //   251: ifnonnull -> 257
/*    */     //   254: invokestatic throwNpe : ()V
/*    */     //   257: invokeinterface getHurtTime : ()I
/*    */     //   262: ifne -> 284
/*    */     //   265: aload_2
/*    */     //   266: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   269: dup
/*    */     //   270: ifnonnull -> 276
/*    */     //   273: invokestatic throwNpe : ()V
/*    */     //   276: invokeinterface getHurtResistantTime : ()I
/*    */     //   281: ifeq -> 425
/*    */     //   284: aload_0
/*    */     //   285: getfield Heal : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   288: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   291: checkcast java/lang/Boolean
/*    */     //   294: invokevirtual booleanValue : ()Z
/*    */     //   297: ifeq -> 331
/*    */     //   300: aload_0
/*    */     //   301: getfield hit : Z
/*    */     //   304: ifeq -> 331
/*    */     //   307: aload_2
/*    */     //   308: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   311: dup
/*    */     //   312: ifnonnull -> 318
/*    */     //   315: invokestatic throwNpe : ()V
/*    */     //   318: invokeinterface getHealth : ()F
/*    */     //   323: aload_0
/*    */     //   324: getfield health : F
/*    */     //   327: fcmpg
/*    */     //   328: ifeq -> 425
/*    */     //   331: aload_0
/*    */     //   332: getfield hit : Z
/*    */     //   335: ifeq -> 378
/*    */     //   338: aload_0
/*    */     //   339: getfield faceHeal : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   342: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   345: checkcast java/lang/Boolean
/*    */     //   348: invokevirtual booleanValue : ()Z
/*    */     //   351: ifeq -> 378
/*    */     //   354: aload_2
/*    */     //   355: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   358: dup
/*    */     //   359: ifnonnull -> 365
/*    */     //   362: invokestatic throwNpe : ()V
/*    */     //   365: invokeinterface getHealth : ()F
/*    */     //   370: aload_0
/*    */     //   371: getfield facehealth : F
/*    */     //   374: fcmpg
/*    */     //   375: ifeq -> 425
/*    */     //   378: aload_0
/*    */     //   379: getfield hit : Z
/*    */     //   382: ifeq -> 676
/*    */     //   385: aload_0
/*    */     //   386: getfield faceentidyHeal : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   389: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   392: checkcast java/lang/Boolean
/*    */     //   395: invokevirtual booleanValue : ()Z
/*    */     //   398: ifeq -> 676
/*    */     //   401: aload_2
/*    */     //   402: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   405: dup
/*    */     //   406: ifnonnull -> 412
/*    */     //   409: invokestatic throwNpe : ()V
/*    */     //   412: invokeinterface getHealth : ()F
/*    */     //   417: aload_0
/*    */     //   418: getfield health2 : F
/*    */     //   421: fcmpg
/*    */     //   422: ifne -> 676
/*    */     //   425: aload_0
/*    */     //   426: dup
/*    */     //   427: getfield b : I
/*    */     //   430: iconst_1
/*    */     //   431: iadd
/*    */     //   432: putfield b : I
/*    */     //   435: aload_0
/*    */     //   436: iconst_0
/*    */     //   437: putfield hit : Z
/*    */     //   440: aload_0
/*    */     //   441: getfield autorange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   444: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   447: checkcast java/lang/Boolean
/*    */     //   450: invokevirtual booleanValue : ()Z
/*    */     //   453: ifeq -> 559
/*    */     //   456: aload_0
/*    */     //   457: getfield ticks : I
/*    */     //   460: ifle -> 559
/*    */     //   463: aload_3
/*    */     //   464: dup
/*    */     //   465: ifnonnull -> 471
/*    */     //   468: invokestatic throwNpe : ()V
/*    */     //   471: invokevirtual getNormalgroundrangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   474: aload_0
/*    */     //   475: getfield saferangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   478: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   481: invokevirtual set : (Ljava/lang/Object;)V
/*    */     //   484: aload_3
/*    */     //   485: invokevirtual getNormalairrangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   488: aload_0
/*    */     //   489: getfield saferangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   492: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   495: invokevirtual set : (Ljava/lang/Object;)V
/*    */     //   498: aload_0
/*    */     //   499: iconst_0
/*    */     //   500: putfield ticks : I
/*    */     //   503: aload_0
/*    */     //   504: iconst_1
/*    */     //   505: putfield change : Z
/*    */     //   508: aload_0
/*    */     //   509: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   512: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   515: checkcast java/lang/Boolean
/*    */     //   518: invokevirtual booleanValue : ()Z
/*    */     //   521: ifeq -> 559
/*    */     //   524: new java/lang/StringBuilder
/*    */     //   527: dup
/*    */     //   528: invokespecial <init> : ()V
/*    */     //   531: ldc_w '§8[§c§lRetreat§8]§c§d检测到空刀，已自动切换至安全距离'
/*    */     //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   537: aload_0
/*    */     //   538: getfield saferangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   541: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   544: checkcast java/lang/Number
/*    */     //   547: invokevirtual floatValue : ()F
/*    */     //   550: invokevirtual append : (F)Ljava/lang/StringBuilder;
/*    */     //   553: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   556: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   559: aload_0
/*    */     //   560: getfield autodis : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   563: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   566: checkcast java/lang/Boolean
/*    */     //   569: invokevirtual booleanValue : ()Z
/*    */     //   572: ifeq -> 625
/*    */     //   575: aload_0
/*    */     //   576: getfield ticks : I
/*    */     //   579: ifle -> 625
/*    */     //   582: aload_0
/*    */     //   583: iconst_0
/*    */     //   584: putfield ticks : I
/*    */     //   587: aload #4
/*    */     //   589: ifnull -> 598
/*    */     //   592: aload #4
/*    */     //   594: iconst_0
/*    */     //   595: invokevirtual setState : (Z)V
/*    */     //   598: aload_2
/*    */     //   599: iconst_0
/*    */     //   600: invokevirtual setState : (Z)V
/*    */     //   603: aload_0
/*    */     //   604: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   607: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   610: checkcast java/lang/Boolean
/*    */     //   613: invokevirtual booleanValue : ()Z
/*    */     //   616: ifeq -> 625
/*    */     //   619: ldc_w '§8[§c§lRetreat§8]§c§d检测到空刀，已自动关闭杀戮'
/*    */     //   622: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   625: aload_0
/*    */     //   626: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   629: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   632: checkcast java/lang/Boolean
/*    */     //   635: invokevirtual booleanValue : ()Z
/*    */     //   638: ifeq -> 737
/*    */     //   641: new java/lang/StringBuilder
/*    */     //   644: dup
/*    */     //   645: invokespecial <init> : ()V
/*    */     //   648: ldc_w '§8[§c§lRetreat§8]§c§d空刀数:'
/*    */     //   651: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   654: aload_0
/*    */     //   655: getfield b : I
/*    */     //   658: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   661: ldc_w '!!!'
/*    */     //   664: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   667: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   670: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   673: goto -> 737
/*    */     //   676: aload_0
/*    */     //   677: getfield hit : Z
/*    */     //   680: ifeq -> 737
/*    */     //   683: aload_0
/*    */     //   684: iconst_0
/*    */     //   685: putfield hit : Z
/*    */     //   688: aload_0
/*    */     //   689: getfield autorange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   692: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   695: checkcast java/lang/Boolean
/*    */     //   698: invokevirtual booleanValue : ()Z
/*    */     //   701: ifeq -> 737
/*    */     //   704: aload_0
/*    */     //   705: getfield ticks : I
/*    */     //   708: ifle -> 737
/*    */     //   711: aload_2
/*    */     //   712: invokevirtual getGroundRangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   715: aload_0
/*    */     //   716: getfield normalgroundrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   719: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   722: iconst_1
/*    */     //   723: ixor
/*    */     //   724: ifeq -> 737
/*    */     //   727: aload_0
/*    */     //   728: iconst_1
/*    */     //   729: putfield change : Z
/*    */     //   732: aload_0
/*    */     //   733: iconst_0
/*    */     //   734: putfield ticks : I
/*    */     //   737: aload_0
/*    */     //   738: getfield ticks : I
/*    */     //   741: bipush #40
/*    */     //   743: if_icmpne -> 831
/*    */     //   746: aload_0
/*    */     //   747: getfield autorange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   750: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   753: checkcast java/lang/Boolean
/*    */     //   756: invokevirtual booleanValue : ()Z
/*    */     //   759: ifeq -> 831
/*    */     //   762: aload_0
/*    */     //   763: getfield change : Z
/*    */     //   766: ifeq -> 831
/*    */     //   769: aload_3
/*    */     //   770: dup
/*    */     //   771: ifnonnull -> 777
/*    */     //   774: invokestatic throwNpe : ()V
/*    */     //   777: invokevirtual getNormalgroundrangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   780: aload_0
/*    */     //   781: getfield normalgroundrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   784: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   787: invokevirtual set : (Ljava/lang/Object;)V
/*    */     //   790: aload_3
/*    */     //   791: invokevirtual getNormalairrangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   794: aload_0
/*    */     //   795: getfield normalairrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   798: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   801: invokevirtual set : (Ljava/lang/Object;)V
/*    */     //   804: aload_0
/*    */     //   805: iconst_0
/*    */     //   806: putfield change : Z
/*    */     //   809: aload_0
/*    */     //   810: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   813: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   816: checkcast java/lang/Boolean
/*    */     //   819: invokevirtual booleanValue : ()Z
/*    */     //   822: ifeq -> 831
/*    */     //   825: ldc_w '§8[§c§lRetreat§8]§c§d单位时间内未检出空刀，已自动切换至正常距离'
/*    */     //   828: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   831: aload_0
/*    */     //   832: getfield b : I
/*    */     //   835: aload_0
/*    */     //   836: getfield nohurtValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   839: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   842: checkcast java/lang/Number
/*    */     //   845: invokevirtual intValue : ()I
/*    */     //   848: if_icmplt -> 917
/*    */     //   851: aload_0
/*    */     //   852: getfield autohub : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   855: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   858: checkcast java/lang/Boolean
/*    */     //   861: invokevirtual booleanValue : ()Z
/*    */     //   864: ifeq -> 917
/*    */     //   867: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   870: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   875: dup
/*    */     //   876: ifnonnull -> 882
/*    */     //   879: invokestatic throwNpe : ()V
/*    */     //   882: ldc_w '/hub'
/*    */     //   885: invokeinterface sendChatMessage : (Ljava/lang/String;)V
/*    */     //   890: aload_0
/*    */     //   891: iconst_0
/*    */     //   892: putfield b : I
/*    */     //   895: aload_0
/*    */     //   896: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   899: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   902: checkcast java/lang/Boolean
/*    */     //   905: invokevirtual booleanValue : ()Z
/*    */     //   908: ifeq -> 917
/*    */     //   911: ldc_w '§8[§c§lRetreat§8]§c§d空刀数达到上限，您已自动hub'
/*    */     //   914: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   917: aload_0
/*    */     //   918: getfield b : I
/*    */     //   921: aload_0
/*    */     //   922: getfield nohurtValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   925: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   928: checkcast java/lang/Number
/*    */     //   931: invokevirtual intValue : ()I
/*    */     //   934: if_icmplt -> 1022
/*    */     //   937: aload_0
/*    */     //   938: getfield autosafe : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   941: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   944: checkcast java/lang/Boolean
/*    */     //   947: invokevirtual booleanValue : ()Z
/*    */     //   950: ifeq -> 1022
/*    */     //   953: aload_0
/*    */     //   954: getfield rest : Z
/*    */     //   957: ifne -> 1022
/*    */     //   960: aload_3
/*    */     //   961: dup
/*    */     //   962: ifnonnull -> 968
/*    */     //   965: invokestatic throwNpe : ()V
/*    */     //   968: invokevirtual getNormalgroundrangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   971: aload_0
/*    */     //   972: getfield safeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   975: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   978: invokevirtual set : (Ljava/lang/Object;)V
/*    */     //   981: aload_3
/*    */     //   982: invokevirtual getNormalairrangeValue : ()Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   985: aload_0
/*    */     //   986: getfield safeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   989: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   992: invokevirtual set : (Ljava/lang/Object;)V
/*    */     //   995: aload_0
/*    */     //   996: iconst_1
/*    */     //   997: putfield rest : Z
/*    */     //   1000: aload_0
/*    */     //   1001: getfield Debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   1004: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   1007: checkcast java/lang/Boolean
/*    */     //   1010: invokevirtual booleanValue : ()Z
/*    */     //   1013: ifeq -> 1022
/*    */     //   1016: ldc_w '§8[§c§lRetreat§8]§c§d空刀数达到上限，您的距离已设为最安全范围'
/*    */     //   1019: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*    */     //   1022: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #107	-> 6
/*    */     //   #108	-> 16
/*    */     //   #109	-> 26
/*    */     //   #110	-> 42
/*    */     //   #111	-> 58
/*    */     //   #112	-> 75
/*    */     //   #113	-> 101
/*    */     //   #114	-> 150
/*    */     //   #115	-> 159
/*    */     //   #113	-> 177
/*    */     //   #117	-> 180
/*    */     //   #118	-> 239
/*    */     //   #119	-> 239
/*    */     //   #118	-> 284
/*    */     //   #119	-> 338
/*    */     //   #120	-> 425
/*    */     //   #121	-> 435
/*    */     //   #122	-> 440
/*    */     //   #123	-> 463
/*    */     //   #124	-> 484
/*    */     //   #125	-> 498
/*    */     //   #126	-> 503
/*    */     //   #127	-> 508
/*    */     //   #128	-> 524
/*    */     //   #131	-> 559
/*    */     //   #132	-> 582
/*    */     //   #133	-> 587
/*    */     //   #134	-> 592
/*    */     //   #137	-> 598
/*    */     //   #138	-> 603
/*    */     //   #139	-> 619
/*    */     //   #142	-> 625
/*    */     //   #143	-> 641
/*    */     //   #145	-> 676
/*    */     //   #146	-> 683
/*    */     //   #147	-> 688
/*    */     //   #148	-> 727
/*    */     //   #149	-> 732
/*    */     //   #151	-> 737
/*    */     //   #153	-> 737
/*    */     //   #154	-> 769
/*    */     //   #155	-> 790
/*    */     //   #156	-> 804
/*    */     //   #157	-> 809
/*    */     //   #158	-> 825
/*    */     //   #161	-> 831
/*    */     //   #162	-> 867
/*    */     //   #163	-> 890
/*    */     //   #164	-> 895
/*    */     //   #165	-> 911
/*    */     //   #168	-> 917
/*    */     //   #169	-> 960
/*    */     //   #170	-> 981
/*    */     //   #171	-> 995
/*    */     //   #172	-> 1000
/*    */     //   #173	-> 1016
/*    */     //   #176	-> 1022
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   159	18	7	entityLiving	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   150	27	5	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   75	948	4	noc0b	Lnet/ccbluex/liquidbounce/features/module/modules/exploit/NoC0B;
/*    */     //   58	965	3	safeauramode	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Safeauramode;
/*    */     //   42	981	2	aura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*    */     //   0	1023	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/misc/Reallyhurt;
/*    */     //   0	1023	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\Reallyhurt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */