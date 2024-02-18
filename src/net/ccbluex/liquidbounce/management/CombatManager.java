/*    */ package net.ccbluex.liquidbounce.management;
/*    */ import java.util.ArrayList;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\007\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\0012\0020\002:\001*B\005¢\006\002\020\003J\b\020!\032\0020\017H\026J\020\020\"\032\0020#2\006\020$\032\0020%H\007J\020\020&\032\0020#2\006\020$\032\0020'H\007J\020\020(\032\0020#2\006\020$\032\0020)H\007R\036\020\004\032\022\022\004\022\0020\0060\005j\b\022\004\022\0020\006`\007X\004¢\006\002\n\000R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\032\020\016\032\0020\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\032\020\024\032\0020\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031R\016\020\032\032\0020\033X\004¢\006\002\n\000R\034\020\034\032\004\030\0010\006X\016¢\006\016\n\000\032\004\b\035\020\036\"\004\b\037\020 ¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/management/CombatManager;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "attackedList", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "Lkotlin/collections/ArrayList;", "fadeState", "Lnet/ccbluex/liquidbounce/management/CombatManager$FadeState;", "getFadeState", "()Lnet/ccbluex/liquidbounce/management/CombatManager$FadeState;", "setFadeState", "(Lnet/ccbluex/liquidbounce/management/CombatManager$FadeState;)V", "inCombat", "", "getInCombat", "()Z", "setInCombat", "(Z)V", "kills", "", "getKills", "()I", "setKills", "(I)V", "lastAttackTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "target", "getTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "handleEvents", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "FadeState", "XSJClient"})
/*    */ public final class CombatManager extends MinecraftInstance implements Listenable {
/* 15 */   private final MSTimer lastAttackTimer = new MSTimer(); private boolean inCombat; private int kills;
/* 16 */   public final boolean getInCombat() { return this.inCombat; } public final void setInCombat(boolean <set-?>) { this.inCombat = <set-?>; }
/* 17 */   public final int getKills() { return this.kills; } public final void setKills(int <set-?>) { this.kills = <set-?>; } @Nullable private IEntityLivingBase target; @NotNull
/* 18 */   private FadeState fadeState = FadeState.NO; @NotNull public final FadeState getFadeState() { return this.fadeState; } public final void setFadeState(@NotNull FadeState <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.fadeState = <set-?>; } @Nullable
/* 19 */   public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; }
/* 20 */    private final ArrayList<IEntityLivingBase> attackedList = new ArrayList<>();
/*    */   public boolean handleEvents() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 27 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getTargetEntity() instanceof IEntityLivingBase) {
/* 28 */       this.target = (IEntityLivingBase)event.getTargetEntity();
/* 29 */       this.attackedList.add(event.getTargetEntity());
/*    */     } 
/*    */   }
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
/*    */     //   6: aload_0
/*    */     //   7: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   10: ifnull -> 104
/*    */     //   13: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   16: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   21: dup
/*    */     //   22: ifnonnull -> 28
/*    */     //   25: invokestatic throwNpe : ()V
/*    */     //   28: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   31: aload_0
/*    */     //   32: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   35: dup
/*    */     //   36: ifnonnull -> 42
/*    */     //   39: invokestatic throwNpe : ()V
/*    */     //   42: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   45: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*    */     //   48: bipush #7
/*    */     //   50: i2d
/*    */     //   51: dcmpl
/*    */     //   52: ifgt -> 96
/*    */     //   55: aload_0
/*    */     //   56: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   59: dup
/*    */     //   60: ifnonnull -> 66
/*    */     //   63: invokestatic throwNpe : ()V
/*    */     //   66: invokeinterface getHealth : ()F
/*    */     //   71: iconst_0
/*    */     //   72: i2f
/*    */     //   73: fcmpg
/*    */     //   74: ifle -> 96
/*    */     //   77: aload_0
/*    */     //   78: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   81: dup
/*    */     //   82: ifnonnull -> 88
/*    */     //   85: invokestatic throwNpe : ()V
/*    */     //   88: invokeinterface isDead : ()Z
/*    */     //   93: ifeq -> 104
/*    */     //   96: aload_0
/*    */     //   97: aconst_null
/*    */     //   98: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   101: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   104: aload_0
/*    */     //   105: iconst_0
/*    */     //   106: putfield inCombat : Z
/*    */     //   109: aload_0
/*    */     //   110: getfield lastAttackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   113: ldc2_w 1000
/*    */     //   116: invokevirtual hasTimePassed : (J)Z
/*    */     //   119: ifne -> 128
/*    */     //   122: aload_0
/*    */     //   123: iconst_1
/*    */     //   124: putfield inCombat : Z
/*    */     //   127: return
/*    */     //   128: aload_0
/*    */     //   129: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   132: ifnull -> 218
/*    */     //   135: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   138: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   143: dup
/*    */     //   144: ifnonnull -> 150
/*    */     //   147: invokestatic throwNpe : ()V
/*    */     //   150: aload_0
/*    */     //   151: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   154: dup
/*    */     //   155: ifnonnull -> 161
/*    */     //   158: invokestatic throwNpe : ()V
/*    */     //   161: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   164: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*    */     //   169: bipush #7
/*    */     //   171: i2f
/*    */     //   172: fcmpl
/*    */     //   173: ifgt -> 202
/*    */     //   176: aload_0
/*    */     //   177: getfield inCombat : Z
/*    */     //   180: ifeq -> 202
/*    */     //   183: aload_0
/*    */     //   184: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   187: dup
/*    */     //   188: ifnonnull -> 194
/*    */     //   191: invokestatic throwNpe : ()V
/*    */     //   194: invokeinterface isDead : ()Z
/*    */     //   199: ifeq -> 213
/*    */     //   202: aload_0
/*    */     //   203: aconst_null
/*    */     //   204: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   207: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   210: goto -> 218
/*    */     //   213: aload_0
/*    */     //   214: iconst_1
/*    */     //   215: putfield inCombat : Z
/*    */     //   218: aload_0
/*    */     //   219: getfield attackedList : Ljava/util/ArrayList;
/*    */     //   222: checkcast java/lang/Iterable
/*    */     //   225: astore_2
/*    */     //   226: iconst_0
/*    */     //   227: istore_3
/*    */     //   228: aload_2
/*    */     //   229: astore #4
/*    */     //   231: new java/util/ArrayList
/*    */     //   234: dup
/*    */     //   235: aload_2
/*    */     //   236: bipush #10
/*    */     //   238: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
/*    */     //   241: invokespecial <init> : (I)V
/*    */     //   244: checkcast java/util/Collection
/*    */     //   247: astore #5
/*    */     //   249: iconst_0
/*    */     //   250: istore #6
/*    */     //   252: aload #4
/*    */     //   254: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   259: astore #7
/*    */     //   261: aload #7
/*    */     //   263: invokeinterface hasNext : ()Z
/*    */     //   268: ifeq -> 311
/*    */     //   271: aload #7
/*    */     //   273: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   278: astore #8
/*    */     //   280: aload #5
/*    */     //   282: aload #8
/*    */     //   284: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   287: astore #9
/*    */     //   289: astore #11
/*    */     //   291: iconst_0
/*    */     //   292: istore #10
/*    */     //   294: aload #9
/*    */     //   296: astore #12
/*    */     //   298: aload #11
/*    */     //   300: aload #12
/*    */     //   302: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   307: pop
/*    */     //   308: goto -> 261
/*    */     //   311: aload #5
/*    */     //   313: checkcast java/util/List
/*    */     //   316: checkcast java/lang/Iterable
/*    */     //   319: astore_2
/*    */     //   320: iconst_0
/*    */     //   321: istore_3
/*    */     //   322: aload_2
/*    */     //   323: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   328: astore #4
/*    */     //   330: aload #4
/*    */     //   332: invokeinterface hasNext : ()Z
/*    */     //   337: ifeq -> 427
/*    */     //   340: aload #4
/*    */     //   342: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   347: astore #5
/*    */     //   349: aload #5
/*    */     //   351: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   354: astore #6
/*    */     //   356: iconst_0
/*    */     //   357: istore #7
/*    */     //   359: aload #6
/*    */     //   361: invokeinterface isDead : ()Z
/*    */     //   366: ifne -> 382
/*    */     //   369: aload #6
/*    */     //   371: invokeinterface getHealth : ()F
/*    */     //   376: iconst_0
/*    */     //   377: i2f
/*    */     //   378: fcmpg
/*    */     //   379: ifgt -> 423
/*    */     //   382: aload_0
/*    */     //   383: getfield attackedList : Ljava/util/ArrayList;
/*    */     //   386: aload #6
/*    */     //   388: invokevirtual remove : (Ljava/lang/Object;)Z
/*    */     //   391: pop
/*    */     //   392: aload_0
/*    */     //   393: dup
/*    */     //   394: getfield kills : I
/*    */     //   397: iconst_1
/*    */     //   398: iadd
/*    */     //   399: putfield kills : I
/*    */     //   402: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   405: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*    */     //   408: new net/ccbluex/liquidbounce/event/EntityKilledEvent
/*    */     //   411: dup
/*    */     //   412: aload #6
/*    */     //   414: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*    */     //   417: checkcast net/ccbluex/liquidbounce/event/Event
/*    */     //   420: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*    */     //   423: nop
/*    */     //   424: goto -> 330
/*    */     //   427: nop
/*    */     //   428: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #36	-> 6
/*    */     //   #37	-> 96
/*    */     //   #39	-> 104
/*    */     //   #40	-> 109
/*    */     //   #41	-> 122
/*    */     //   #42	-> 127
/*    */     //   #45	-> 128
/*    */     //   #46	-> 135
/*    */     //   #47	-> 202
/*    */     //   #49	-> 213
/*    */     //   #50	-> 218
/*    */     //   #52	-> 218
/*    */     //   #67	-> 228
/*    */     //   #68	-> 252
/*    */     //   #69	-> 280
/*    */     //   #52	-> 294
/*    */     //   #68	-> 308
/*    */     //   #70	-> 311
/*    */     //   #52	-> 320
/*    */     //   #71	-> 322
/*    */     //   #53	-> 359
/*    */     //   #54	-> 382
/*    */     //   #55	-> 392
/*    */     //   #56	-> 402
/*    */     //   #58	-> 423
/*    */     //   #72	-> 427
/*    */     //   #59	-> 428
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   291	5	9	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   294	2	10	$i$a$-map-CombatManager$onUpdate$1	I
/*    */     //   280	28	8	item$iv$iv	Ljava/lang/Object;
/*    */     //   249	64	4	$this$mapTo$iv$iv	Ljava/lang/Iterable;
/*    */     //   249	64	5	destination$iv$iv	Ljava/util/Collection;
/*    */     //   252	61	6	$i$f$mapTo	I
/*    */     //   226	90	2	$this$map$iv	Ljava/lang/Iterable;
/*    */     //   228	88	3	$i$f$map	I
/*    */     //   356	67	6	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   359	64	7	$i$a$-forEach-CombatManager$onUpdate$2	I
/*    */     //   349	75	5	element$iv	Ljava/lang/Object;
/*    */     //   320	108	2	$this$forEach$iv	Ljava/lang/Iterable;
/*    */     //   322	106	3	$i$f$forEach	I
/*    */     //   0	429	0	this	Lnet/ccbluex/liquidbounce/management/CombatManager;
/*    */     //   0	429	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\b\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006j\002\b\007j\002\b\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/management/CombatManager$FadeState;", "", "(Ljava/lang/String;I)V", "FRIST", "IN", "STAY", "OUT", "END", "NO", "XSJClient"})
/*    */   public enum FadeState
/*    */   {
/*    */     FRIST, IN, STAY, OUT, END, NO;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onWorld(@NotNull WorldEvent event) {
/* 63 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.inCombat = false;
/* 64 */     this.target = (IEntityLivingBase)null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\management\CombatManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */