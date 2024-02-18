/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketEntityAction;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "XSJAntiKB", description = "Test", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b'\030\0002\0020\001B\005¢\006\002\020\002J\020\020\n\032\0020\0132\006\020\f\032\0020\rH\007J\020\020\016\032\0020\0132\006\020\f\032\0020\017H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\030\020\005\032\0020\004X¦\016¢\006\f\032\004\b\006\020\007\"\004\b\b\020\t¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/XSJAntiKB;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "isvel", "getIsvel", "()Z", "setIsvel", "(Z)V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public abstract class XSJAntiKB
/*    */   extends Module
/*    */ {
/*    */   private boolean a;
/*    */   
/*    */   public abstract boolean getIsvel();
/*    */   
/*    */   public abstract void setIsvel(boolean paramBoolean);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   9: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*    */     //   12: getfield field_72996_f : Ljava/util/List;
/*    */     //   15: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   20: astore_3
/*    */     //   21: aload_3
/*    */     //   22: invokeinterface hasNext : ()Z
/*    */     //   27: ifeq -> 449
/*    */     //   30: aload_3
/*    */     //   31: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   36: checkcast net/minecraft/entity/Entity
/*    */     //   39: astore_2
/*    */     //   40: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   43: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   46: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   48: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   51: dup
/*    */     //   52: ifnonnull -> 65
/*    */     //   55: new kotlin/TypeCastException
/*    */     //   58: dup
/*    */     //   59: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*    */     //   61: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   64: athrow
/*    */     //   65: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   68: astore #4
/*    */     //   70: aload #4
/*    */     //   72: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   75: ifnull -> 446
/*    */     //   78: aload_2
/*    */     //   79: dup
/*    */     //   80: ldc 'entity'
/*    */     //   82: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   85: invokevirtual func_145782_y : ()I
/*    */     //   88: aload #4
/*    */     //   90: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   93: dup
/*    */     //   94: ifnonnull -> 100
/*    */     //   97: invokestatic throwNpe : ()V
/*    */     //   100: invokeinterface getEntityId : ()I
/*    */     //   105: if_icmpne -> 446
/*    */     //   108: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   111: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   114: getfield field_70737_aN : I
/*    */     //   117: bipush #9
/*    */     //   119: if_icmpne -> 446
/*    */     //   122: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   125: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   128: getfield field_175171_bO : Z
/*    */     //   131: ifne -> 190
/*    */     //   134: aload_0
/*    */     //   135: getfield a : Z
/*    */     //   138: ifne -> 190
/*    */     //   141: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   144: dup
/*    */     //   145: ldc 'mc2'
/*    */     //   147: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   150: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*    */     //   153: dup
/*    */     //   154: ifnonnull -> 160
/*    */     //   157: invokestatic throwNpe : ()V
/*    */     //   160: new net/minecraft/network/play/client/CPacketEntityAction
/*    */     //   163: dup
/*    */     //   164: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   167: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   170: checkcast net/minecraft/entity/Entity
/*    */     //   173: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*    */     //   176: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*    */     //   179: checkcast net/minecraft/network/Packet
/*    */     //   182: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*    */     //   185: aload_0
/*    */     //   186: iconst_1
/*    */     //   187: putfield a : Z
/*    */     //   190: iconst_5
/*    */     //   191: istore #5
/*    */     //   193: iconst_0
/*    */     //   194: istore #6
/*    */     //   196: iconst_0
/*    */     //   197: istore #7
/*    */     //   199: iconst_0
/*    */     //   200: istore #7
/*    */     //   202: iload #5
/*    */     //   204: istore #8
/*    */     //   206: iload #7
/*    */     //   208: iload #8
/*    */     //   210: if_icmpge -> 329
/*    */     //   213: iload #7
/*    */     //   215: istore #9
/*    */     //   217: iconst_0
/*    */     //   218: istore #10
/*    */     //   220: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   223: dup
/*    */     //   224: ldc 'mc2'
/*    */     //   226: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   229: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*    */     //   232: dup
/*    */     //   233: ifnonnull -> 239
/*    */     //   236: invokestatic throwNpe : ()V
/*    */     //   239: new net/minecraft/network/play/client/CPacketUseEntity
/*    */     //   242: dup
/*    */     //   243: aload_2
/*    */     //   244: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*    */     //   247: checkcast net/minecraft/network/Packet
/*    */     //   250: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*    */     //   253: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   256: dup
/*    */     //   257: ldc 'mc2'
/*    */     //   259: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   262: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*    */     //   265: dup
/*    */     //   266: ifnonnull -> 272
/*    */     //   269: invokestatic throwNpe : ()V
/*    */     //   272: new net/minecraft/network/play/client/CPacketAnimation
/*    */     //   275: dup
/*    */     //   276: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*    */     //   279: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*    */     //   282: checkcast net/minecraft/network/Packet
/*    */     //   285: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*    */     //   288: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   291: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   294: dup
/*    */     //   295: getfield field_70159_w : D
/*    */     //   298: ldc2_w 0.6
/*    */     //   301: dmul
/*    */     //   302: putfield field_70159_w : D
/*    */     //   305: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   308: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   311: dup
/*    */     //   312: getfield field_70179_y : D
/*    */     //   315: ldc2_w 0.6
/*    */     //   318: dmul
/*    */     //   319: putfield field_70179_y : D
/*    */     //   322: nop
/*    */     //   323: iinc #7, 1
/*    */     //   326: goto -> 206
/*    */     //   329: aload_0
/*    */     //   330: getfield a : Z
/*    */     //   333: ifeq -> 443
/*    */     //   336: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   339: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*    */     //   342: getfield field_74370_x : Lnet/minecraft/client/settings/KeyBinding;
/*    */     //   345: dup
/*    */     //   346: ldc 'mc2.gameSettings.keyBindLeft'
/*    */     //   348: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   351: invokevirtual func_151470_d : ()Z
/*    */     //   354: ifne -> 399
/*    */     //   357: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   360: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*    */     //   363: getfield field_74366_z : Lnet/minecraft/client/settings/KeyBinding;
/*    */     //   366: dup
/*    */     //   367: ldc 'mc2.gameSettings.keyBindRight'
/*    */     //   369: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   372: invokevirtual func_151470_d : ()Z
/*    */     //   375: ifne -> 399
/*    */     //   378: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   381: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*    */     //   384: getfield field_74368_y : Lnet/minecraft/client/settings/KeyBinding;
/*    */     //   387: dup
/*    */     //   388: ldc 'mc2.gameSettings.keyBindBack'
/*    */     //   390: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   393: invokevirtual func_151470_d : ()Z
/*    */     //   396: ifeq -> 443
/*    */     //   399: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   402: dup
/*    */     //   403: ldc 'mc2'
/*    */     //   405: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   408: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*    */     //   411: dup
/*    */     //   412: ifnonnull -> 418
/*    */     //   415: invokestatic throwNpe : ()V
/*    */     //   418: new net/minecraft/network/play/client/CPacketEntityAction
/*    */     //   421: dup
/*    */     //   422: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   425: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   428: checkcast net/minecraft/entity/Entity
/*    */     //   431: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*    */     //   434: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*    */     //   437: checkcast net/minecraft/network/Packet
/*    */     //   440: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*    */     //   443: goto -> 449
/*    */     //   446: goto -> 21
/*    */     //   449: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #27	-> 6
/*    */     //   #28	-> 40
/*    */     //   #29	-> 70
/*    */     //   #30	-> 78
/*    */     //   #31	-> 108
/*    */     //   #32	-> 122
/*    */     //   #33	-> 141
/*    */     //   #34	-> 160
/*    */     //   #35	-> 164
/*    */     //   #36	-> 173
/*    */     //   #34	-> 176
/*    */     //   #33	-> 182
/*    */     //   #39	-> 185
/*    */     //   #41	-> 190
/*    */     //   #42	-> 220
/*    */     //   #43	-> 253
/*    */     //   #44	-> 288
/*    */     //   #45	-> 305
/*    */     //   #46	-> 322
/*    */     //   #41	-> 323
/*    */     //   #47	-> 329
/*    */     //   #48	-> 399
/*    */     //   #49	-> 418
/*    */     //   #50	-> 422
/*    */     //   #51	-> 431
/*    */     //   #49	-> 434
/*    */     //   #48	-> 440
/*    */     //   #55	-> 443
/*    */     //   #27	-> 446
/*    */     //   #61	-> 449
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   217	105	9	it	I
/*    */     //   220	102	10	$i$a$-repeat-XSJAntiKB$onUpdate$1	I
/*    */     //   70	376	4	killaura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*    */     //   40	406	2	entity	Lnet/minecraft/entity/Entity;
/*    */     //   0	450	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/XSJAntiKB;
/*    */     //   0	450	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 64 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0; Packet packet = (
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 70 */       (PacketImpl)$this$unwrap$iv).getWrapped();
/*    */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74351_w, "mc2.gameSettings.keyBindForward");
/*    */     if ((packet instanceof CPacketEntityAction && ((CPacketEntityAction)packet).func_180764_b().equals(CPacketEntityAction.Action.STOP_SPRINTING)) || MinecraftInstance.mc2.field_71474_y.field_74351_w.func_151470_d())
/*    */       this.a = false; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\XSJAntiKB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */