/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
/*    */ import net.ccbluex.liquidbounce.event.ClientShutdownEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "Fullbright", description = "Brightens up the world around you.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\007\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\0020\bH\026J\b\020\t\032\0020\bH\026J\022\020\n\032\0020\b2\b\020\013\032\004\030\0010\fH\007J\022\020\r\032\0020\b2\b\020\013\032\004\030\0010\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Fullbright;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "prevGamma", "", "onDisable", "", "onEnable", "onShutdown", "event", "Lnet/ccbluex/liquidbounce/event/ClientShutdownEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Fullbright extends Module {
/* 15 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Gamma", "NightVision" }, "Gamma");
/* 16 */   private float prevGamma = -1.0F;
/*    */   
/*    */   public void onEnable() {
/* 19 */     this.prevGamma = MinecraftInstance.mc.getGameSettings().getGammaSetting();
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 23 */     if (this.prevGamma == -1.0F) {
/*    */       return;
/*    */     }
/* 26 */     MinecraftInstance.mc.getGameSettings().setGammaSetting(this.prevGamma);
/* 27 */     this.prevGamma = -1.0F;
/*    */     
/* 29 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().removePotionEffectClient(MinecraftInstance.classProvider.getPotionEnum(PotionType.NIGHT_VISION).getId()); } else { MinecraftInstance.mc.getThePlayer(); }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget(ignoreCondition = true)
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual getState : ()Z
/*    */     //   4: ifne -> 31
/*    */     //   7: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   10: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   13: ldc net/ccbluex/liquidbounce/features/module/modules/render/XRay
/*    */     //   15: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   18: dup
/*    */     //   19: ifnonnull -> 25
/*    */     //   22: invokestatic throwNpe : ()V
/*    */     //   25: invokevirtual getState : ()Z
/*    */     //   28: ifeq -> 218
/*    */     //   31: aload_0
/*    */     //   32: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   35: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   38: checkcast java/lang/String
/*    */     //   41: astore_2
/*    */     //   42: iconst_0
/*    */     //   43: istore_3
/*    */     //   44: aload_2
/*    */     //   45: dup
/*    */     //   46: ifnonnull -> 59
/*    */     //   49: new kotlin/TypeCastException
/*    */     //   52: dup
/*    */     //   53: ldc 'null cannot be cast to non-null type java.lang.String'
/*    */     //   55: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   58: athrow
/*    */     //   59: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   62: dup
/*    */     //   63: ldc '(this as java.lang.String).toLowerCase()'
/*    */     //   65: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   68: astore_2
/*    */     //   69: aload_2
/*    */     //   70: invokevirtual hashCode : ()I
/*    */     //   73: lookupswitch default -> 215, -820818432 -> 100, 98120615 -> 112
/*    */     //   100: aload_2
/*    */     //   101: ldc 'nightvision'
/*    */     //   103: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   106: ifeq -> 251
/*    */     //   109: goto -> 166
/*    */     //   112: aload_2
/*    */     //   113: ldc 'gamma'
/*    */     //   115: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   118: ifeq -> 251
/*    */     //   121: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   124: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   129: invokeinterface getGammaSetting : ()F
/*    */     //   134: ldc 100.0
/*    */     //   136: fcmpg
/*    */     //   137: ifgt -> 163
/*    */     //   140: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   143: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   148: dup
/*    */     //   149: invokeinterface getGammaSetting : ()F
/*    */     //   154: dup
/*    */     //   155: fstore_3
/*    */     //   156: fconst_1
/*    */     //   157: fadd
/*    */     //   158: invokeinterface setGammaSetting : (F)V
/*    */     //   163: goto -> 251
/*    */     //   166: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   169: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   174: dup
/*    */     //   175: ifnull -> 214
/*    */     //   178: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   181: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   184: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.NIGHT_VISION : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*    */     //   187: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*    */     //   192: invokeinterface getId : ()I
/*    */     //   197: sipush #1337
/*    */     //   200: iconst_1
/*    */     //   201: invokeinterface createPotionEffect : (III)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;
/*    */     //   206: invokeinterface addPotionEffect : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;)V
/*    */     //   211: goto -> 215
/*    */     //   214: pop
/*    */     //   215: goto -> 251
/*    */     //   218: aload_0
/*    */     //   219: getfield prevGamma : F
/*    */     //   222: ldc -1.0
/*    */     //   224: fcmpg
/*    */     //   225: ifeq -> 251
/*    */     //   228: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   231: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   236: aload_0
/*    */     //   237: getfield prevGamma : F
/*    */     //   240: invokeinterface setGammaSetting : (F)V
/*    */     //   245: aload_0
/*    */     //   246: ldc -1.0
/*    */     //   248: putfield prevGamma : F
/*    */     //   251: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #34	-> 0
/*    */     //   #35	-> 31
/*    */     //   #39	-> 100
/*    */     //   #36	-> 112
/*    */     //   #37	-> 121
/*    */     //   #38	-> 163
/*    */     //   #39	-> 166
/*    */     //   #40	-> 215
/*    */     //   #41	-> 218
/*    */     //   #42	-> 228
/*    */     //   #43	-> 245
/*    */     //   #44	-> 251
/*    */     //   #45	-> 251
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	252	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/Fullbright;
/*    */     //   0	252	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget(ignoreCondition = true)
/*    */   public final void onShutdown(@Nullable ClientShutdownEvent event) {
/* 49 */     onDisable();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Fullbright.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */