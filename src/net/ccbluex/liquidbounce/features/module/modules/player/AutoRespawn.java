/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AutoRespawn", description = "Automatically respawns you after dying.", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoRespawn;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "instantValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoRespawn
/*    */   extends Module
/*    */ {
/* 17 */   private final BoolValue instantValue = new BoolValue("Instant", true);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   14: astore_2
/*    */     //   15: aload_2
/*    */     //   16: ifnonnull -> 20
/*    */     //   19: return
/*    */     //   20: aload_0
/*    */     //   21: getfield instantValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   24: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   27: checkcast java/lang/Boolean
/*    */     //   30: invokevirtual booleanValue : ()Z
/*    */     //   33: ifeq -> 64
/*    */     //   36: aload_2
/*    */     //   37: invokeinterface getHealth : ()F
/*    */     //   42: fconst_0
/*    */     //   43: fcmpg
/*    */     //   44: ifeq -> 56
/*    */     //   47: aload_2
/*    */     //   48: invokeinterface isDead : ()Z
/*    */     //   53: ifeq -> 60
/*    */     //   56: iconst_1
/*    */     //   57: goto -> 118
/*    */     //   60: iconst_0
/*    */     //   61: goto -> 118
/*    */     //   64: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   67: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   70: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*    */     //   75: invokeinterface isGuiGameOver : (Ljava/lang/Object;)Z
/*    */     //   80: ifeq -> 117
/*    */     //   83: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   86: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*    */     //   91: dup
/*    */     //   92: ifnonnull -> 98
/*    */     //   95: invokestatic throwNpe : ()V
/*    */     //   98: invokeinterface asGuiGameOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiGameOver;
/*    */     //   103: invokeinterface getEnableButtonsTimer : ()I
/*    */     //   108: bipush #20
/*    */     //   110: if_icmplt -> 117
/*    */     //   113: iconst_1
/*    */     //   114: goto -> 118
/*    */     //   117: iconst_0
/*    */     //   118: ifeq -> 136
/*    */     //   121: aload_2
/*    */     //   122: invokeinterface respawnPlayer : ()V
/*    */     //   127: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   130: aconst_null
/*    */     //   131: invokeinterface displayGuiScreen : (Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V
/*    */     //   136: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 6
/*    */     //   #23	-> 15
/*    */     //   #24	-> 19
/*    */     //   #26	-> 20
/*    */     //   #27	-> 64
/*    */     //   #26	-> 64
/*    */     //   #27	-> 83
/*    */     //   #26	-> 118
/*    */     //   #29	-> 121
/*    */     //   #30	-> 127
/*    */     //   #32	-> 136
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   15	122	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	137	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoRespawn;
/*    */     //   0	137	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoRespawn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */