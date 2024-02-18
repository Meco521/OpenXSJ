/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "LegitAutoBlock", description = "合法自动防砍", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\004X\016¢\006\002\n\000¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/LegitAutoBlock;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "blockRange", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "extraRange", "sblockRange", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class LegitAutoBlock extends Module {
/* 14 */   private FloatValue blockRange = new FloatValue("StartBlockRange", 2.99F, 0.0F, 6.0F);
/* 15 */   private FloatValue sblockRange = new FloatValue("StopBlockRange", 1.75F, 0.0F, 6.0F);
/* 16 */   private FloatValue extraRange = new FloatValue("CooldownRange", 3.05F, 0.0F, 5.0F);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   14: dup
/*    */     //   15: ifnull -> 21
/*    */     //   18: goto -> 23
/*    */     //   21: pop
/*    */     //   22: return
/*    */     //   23: astore_2
/*    */     //   24: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   27: invokeinterface getObjectMouseOver : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*    */     //   32: astore_3
/*    */     //   33: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   36: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   41: dup
/*    */     //   42: ifnonnull -> 48
/*    */     //   45: invokestatic throwNpe : ()V
/*    */     //   48: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*    */     //   53: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   58: astore #5
/*    */     //   60: aload #5
/*    */     //   62: invokeinterface hasNext : ()Z
/*    */     //   67: ifeq -> 476
/*    */     //   70: aload #5
/*    */     //   72: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   77: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   80: astore #4
/*    */     //   82: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   85: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   90: dup
/*    */     //   91: ifnonnull -> 97
/*    */     //   94: invokestatic throwNpe : ()V
/*    */     //   97: invokeinterface getOnGround : ()Z
/*    */     //   102: ifeq -> 429
/*    */     //   105: aload_3
/*    */     //   106: ifnull -> 382
/*    */     //   109: aload_3
/*    */     //   110: invokeinterface getEntityHit : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   115: iconst_1
/*    */     //   116: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*    */     //   119: ifeq -> 382
/*    */     //   122: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   125: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   128: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   133: dup
/*    */     //   134: ifnonnull -> 140
/*    */     //   137: invokestatic throwNpe : ()V
/*    */     //   140: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   145: dup
/*    */     //   146: ifnonnull -> 152
/*    */     //   149: invokestatic throwNpe : ()V
/*    */     //   152: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*    */     //   157: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*    */     //   162: ifeq -> 382
/*    */     //   165: aload #4
/*    */     //   167: invokeinterface getHurtResistantTime : ()I
/*    */     //   172: ifeq -> 382
/*    */     //   175: aload #4
/*    */     //   177: invokeinterface getPosY : ()D
/*    */     //   182: d2i
/*    */     //   183: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   186: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   189: getfield field_70163_u : D
/*    */     //   192: d2i
/*    */     //   193: if_icmplt -> 382
/*    */     //   196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   199: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   204: dup
/*    */     //   205: ifnonnull -> 211
/*    */     //   208: invokestatic throwNpe : ()V
/*    */     //   211: aload #4
/*    */     //   213: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*    */     //   218: aload_0
/*    */     //   219: getfield blockRange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   222: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   225: checkcast java/lang/Number
/*    */     //   228: invokevirtual floatValue : ()F
/*    */     //   231: fcmpg
/*    */     //   232: ifge -> 296
/*    */     //   235: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   238: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   243: dup
/*    */     //   244: ifnonnull -> 250
/*    */     //   247: invokestatic throwNpe : ()V
/*    */     //   250: aload #4
/*    */     //   252: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*    */     //   257: aload_0
/*    */     //   258: getfield sblockRange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   261: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   264: checkcast java/lang/Number
/*    */     //   267: invokevirtual floatValue : ()F
/*    */     //   270: fcmpl
/*    */     //   271: ifle -> 296
/*    */     //   274: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   277: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   282: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   287: iconst_1
/*    */     //   288: invokeinterface setPressed : (Z)V
/*    */     //   293: goto -> 473
/*    */     //   296: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   299: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   304: dup
/*    */     //   305: ifnonnull -> 311
/*    */     //   308: invokestatic throwNpe : ()V
/*    */     //   311: aload #4
/*    */     //   313: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*    */     //   318: aload_0
/*    */     //   319: getfield extraRange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   322: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   325: checkcast java/lang/Number
/*    */     //   328: invokevirtual floatValue : ()F
/*    */     //   331: fcmpg
/*    */     //   332: ifgt -> 379
/*    */     //   335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   338: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   343: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   348: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   351: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   356: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   359: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   364: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   369: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   374: invokeinterface setPressed : (Z)V
/*    */     //   379: goto -> 473
/*    */     //   382: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   385: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   390: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   395: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   398: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   403: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   406: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   411: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   416: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   421: invokeinterface setPressed : (Z)V
/*    */     //   426: goto -> 473
/*    */     //   429: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   432: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   437: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   442: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   445: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   450: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   453: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   458: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   463: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   468: invokeinterface setPressed : (Z)V
/*    */     //   473: goto -> 60
/*    */     //   476: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #21	-> 6
/*    */     //   #21	-> 21
/*    */     //   #22	-> 24
/*    */     //   #23	-> 33
/*    */     //   #24	-> 82
/*    */     //   #25	-> 105
/*    */     //   #26	-> 105
/*    */     //   #27	-> 105
/*    */     //   #28	-> 105
/*    */     //   #26	-> 109
/*    */     //   #27	-> 122
/*    */     //   #28	-> 175
/*    */     //   #30	-> 196
/*    */     //   #31	-> 274
/*    */     //   #32	-> 296
/*    */     //   #33	-> 335
/*    */     //   #34	-> 379
/*    */     //   #36	-> 382
/*    */     //   #37	-> 426
/*    */     //   #39	-> 429
/*    */     //   #40	-> 473
/*    */     //   #23	-> 473
/*    */     //   #42	-> 476
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   82	391	4	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   33	444	3	objectMouseOver	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*    */     //   24	453	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	477	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/LegitAutoBlock;
/*    */     //   0	477	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\LegitAutoBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */