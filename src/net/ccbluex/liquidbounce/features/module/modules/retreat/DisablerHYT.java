/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "DisablerHYT", description = "text skid by 凡哥", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\020\016\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\025\032\0020\0262\006\020\027\032\0020\030H\007J\b\020\031\032\0020\026H\026J\b\020\032\032\0020\026H\026J\020\020\033\032\0020\0262\006\020\027\032\0020\034H\007J\020\020\035\032\0020\0262\006\020\027\032\0020\036H\007J\020\020\037\032\0020\0262\006\020\027\032\0020 H\007J\020\020!\032\0020\0262\006\020\027\032\0020\"H\007J\020\020#\032\0020\0262\006\020\027\032\0020$H\007J\020\020%\032\0020\0262\006\020\027\032\0020&H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\bX\016¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\021\020\016\032\0020\017¢\006\b\n\000\032\004\b\020\020\021R\024\020\022\032\0020\0138VX\004¢\006\006\032\004\b\023\020\024¨\006'"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/DisablerHYT;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "bzd", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "c08", "c09", "c09Sent", "", "canSprint", "lastAction", "", "lastC09", "", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "tag", "getTag", "()Ljava/lang/String;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onEnable", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*     */ public final class DisablerHYT extends Module {
/*     */   @NotNull
/*  16 */   private final ListValue modeValue = new ListValue("DisablerMode", new String[] { "GrimACTest1", "GrimACTest2", "GrimACNew" }, "GrimACNew"); @NotNull public final ListValue getModeValue() { return this.modeValue; }
/*     */   
/*  18 */   private final BoolValue c08 = new BoolValue("C08Fix", false);
/*  19 */   private final BoolValue c09 = new BoolValue("C09Fix", false);
/*  20 */   private final BoolValue bzd = new BoolValue("HytPacketFix", false); private boolean c09Sent; private int lastC09; @NotNull
/*     */   public String getTag() {
/*  22 */     return (String)this.modeValue.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  28 */   private String lastAction = "";
/*     */ 
/*     */   
/*     */   private boolean canSprint;
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDisable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {}
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onWorld(@NotNull WorldEvent event) {
/*  44 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.lastAction = "";
/*  45 */     this.c09Sent = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent event) {
/*  53 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  59 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*  65 */     Intrinsics.checkParameterIsNotNull(event, "event");
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   10: astore_2
/*     */     //   11: aload_0
/*     */     //   12: getfield c09 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   15: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   18: checkcast java/lang/Boolean
/*     */     //   21: invokevirtual booleanValue : ()Z
/*     */     //   24: ifeq -> 103
/*     */     //   27: aload_2
/*     */     //   28: instanceof net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   31: ifeq -> 57
/*     */     //   34: aload_0
/*     */     //   35: getfield c09Sent : Z
/*     */     //   38: ifne -> 57
/*     */     //   41: aload_0
/*     */     //   42: iconst_1
/*     */     //   43: putfield c09Sent : Z
/*     */     //   46: aload_0
/*     */     //   47: aload_2
/*     */     //   48: checkcast net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   51: invokevirtual func_149614_c : ()I
/*     */     //   54: putfield lastC09 : I
/*     */     //   57: aload_0
/*     */     //   58: getfield c09Sent : Z
/*     */     //   61: ifeq -> 103
/*     */     //   64: aload_2
/*     */     //   65: instanceof net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   68: ifeq -> 103
/*     */     //   71: aload_2
/*     */     //   72: checkcast net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   75: invokevirtual func_149614_c : ()I
/*     */     //   78: aload_0
/*     */     //   79: getfield lastC09 : I
/*     */     //   82: if_icmpne -> 92
/*     */     //   85: aload_1
/*     */     //   86: invokevirtual cancelEvent : ()V
/*     */     //   89: goto -> 103
/*     */     //   92: aload_0
/*     */     //   93: aload_2
/*     */     //   94: checkcast net/minecraft/network/play/client/CPacketHeldItemChange
/*     */     //   97: invokevirtual func_149614_c : ()I
/*     */     //   100: putfield lastC09 : I
/*     */     //   103: aload_0
/*     */     //   104: getfield c08 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   107: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   110: checkcast java/lang/Boolean
/*     */     //   113: invokevirtual booleanValue : ()Z
/*     */     //   116: ifeq -> 336
/*     */     //   119: invokestatic isMoving : ()Z
/*     */     //   122: ifeq -> 248
/*     */     //   125: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   128: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   133: dup
/*     */     //   134: ifnonnull -> 140
/*     */     //   137: invokestatic throwNpe : ()V
/*     */     //   140: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   145: invokeinterface getMoveForward : ()F
/*     */     //   150: ldc 0.8
/*     */     //   152: fcmpg
/*     */     //   153: iflt -> 248
/*     */     //   156: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   159: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   164: dup
/*     */     //   165: ifnonnull -> 171
/*     */     //   168: invokestatic throwNpe : ()V
/*     */     //   171: invokeinterface isInLava : ()Z
/*     */     //   176: ifne -> 248
/*     */     //   179: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   182: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   187: dup
/*     */     //   188: ifnonnull -> 194
/*     */     //   191: invokestatic throwNpe : ()V
/*     */     //   194: invokeinterface isInWater : ()Z
/*     */     //   199: ifne -> 248
/*     */     //   202: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   205: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   210: dup
/*     */     //   211: ifnonnull -> 217
/*     */     //   214: invokestatic throwNpe : ()V
/*     */     //   217: invokeinterface isInWeb : ()Z
/*     */     //   222: ifne -> 248
/*     */     //   225: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   228: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   233: dup
/*     */     //   234: ifnonnull -> 240
/*     */     //   237: invokestatic throwNpe : ()V
/*     */     //   240: invokeinterface isOnLadder : ()Z
/*     */     //   245: ifeq -> 256
/*     */     //   248: aload_0
/*     */     //   249: iconst_0
/*     */     //   250: putfield canSprint : Z
/*     */     //   253: goto -> 261
/*     */     //   256: aload_0
/*     */     //   257: iconst_1
/*     */     //   258: putfield canSprint : Z
/*     */     //   261: aload_2
/*     */     //   262: instanceof net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   265: ifeq -> 336
/*     */     //   268: aload_2
/*     */     //   269: checkcast net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   272: invokevirtual func_180764_b : ()Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   275: invokevirtual name : ()Ljava/lang/String;
/*     */     //   278: aload_0
/*     */     //   279: getfield lastAction : Ljava/lang/String;
/*     */     //   282: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   285: ifeq -> 295
/*     */     //   288: aload_1
/*     */     //   289: invokevirtual cancelEvent : ()V
/*     */     //   292: goto -> 336
/*     */     //   295: aload_0
/*     */     //   296: getfield canSprint : Z
/*     */     //   299: ifne -> 322
/*     */     //   302: aload_2
/*     */     //   303: checkcast net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   306: invokevirtual func_180764_b : ()Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   309: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   312: if_acmpne -> 322
/*     */     //   315: aload_1
/*     */     //   316: invokevirtual cancelEvent : ()V
/*     */     //   319: goto -> 336
/*     */     //   322: aload_0
/*     */     //   323: aload_2
/*     */     //   324: checkcast net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   327: invokevirtual func_180764_b : ()Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   330: invokevirtual name : ()Ljava/lang/String;
/*     */     //   333: putfield lastAction : Ljava/lang/String;
/*     */     //   336: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #70	-> 6
/*     */     //   #71	-> 11
/*     */     //   #72	-> 27
/*     */     //   #73	-> 41
/*     */     //   #74	-> 46
/*     */     //   #76	-> 57
/*     */     //   #77	-> 64
/*     */     //   #78	-> 71
/*     */     //   #79	-> 85
/*     */     //   #81	-> 92
/*     */     //   #82	-> 103
/*     */     //   #86	-> 103
/*     */     //   #87	-> 119
/*     */     //   #88	-> 248
/*     */     //   #90	-> 256
/*     */     //   #91	-> 261
/*     */     //   #93	-> 261
/*     */     //   #96	-> 268
/*     */     //   #97	-> 288
/*     */     //   #99	-> 295
/*     */     //   #100	-> 315
/*     */     //   #102	-> 322
/*     */     //   #103	-> 336
/*     */     //   #104	-> 336
/*     */     //   #109	-> 336
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   11	326	2	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   0	337	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/DisablerHYT;
/*     */     //   0	337	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */   @EventTarget
/*     */   public final void onTick(@NotNull TickEvent event) {
/* 115 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event) {
/* 121 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\DisablerHYT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */