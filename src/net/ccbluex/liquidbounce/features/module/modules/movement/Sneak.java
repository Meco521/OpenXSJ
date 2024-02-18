/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ import kotlin.jvm.JvmField;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Sneak", description = "Automatically sneaks all the time.", category = ModuleCategory.MOVEMENT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\t\032\0020\nH\026J\b\020\013\032\0020\nH\026J\020\020\f\032\0020\n2\006\020\r\032\0020\016H\007R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\020\020\007\032\0020\b8\006X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Sneak;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "sneaked", "", "stopMoveValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "onDisable", "", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "XSJClient"})
/*    */ public final class Sneak extends Module {
/*    */   @JvmField
/*    */   @NotNull
/* 17 */   public final ListValue modeValue = new ListValue("Mode", new String[] { "Legit", "Vanilla", "Switch", "MineSecure" }, "MineSecure");
/*    */   @JvmField
/*    */   @NotNull
/* 20 */   public final BoolValue stopMoveValue = new BoolValue("StopMove", false); private boolean sneaked;
/*    */   
/*    */   public void onEnable() {
/* 23 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 25 */       if (StringsKt.equals("vanilla", (String)this.modeValue.get(), true))
/* 26 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)thePlayer, ICPacketEntityAction.WAction.START_SNEAKING)); 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   } @EventTarget
/*    */   public final void onMotion(@NotNull MotionEvent event) {
/* 32 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.stopMoveValue.get()).booleanValue() && MovementUtils.isMoving()) {
/* 33 */       if (this.sneaked) {
/* 34 */         onDisable();
/* 35 */         this.sneaked = false;
/*    */       } 
/*    */       return;
/*    */     } 
/* 39 */     this.sneaked = true;
/* 40 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
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
/*    */       case 518567306:
/* 55 */         if (str.equals("minesecure")) {
/* 56 */           if (event.getEventState() == EventState.PRE) {
/*    */             return;
/*    */           }
/* 59 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SNEAKING));
/*    */         } 
/*    */         break;
/*    */       case 102851513:
/*    */         if (str.equals("legit"))
/*    */           MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(true); 
/*    */         break;
/*    */       case -889473228:
/*    */         if (str.equals("switch"))
/*    */           switch (Sneak$WhenMappings.$EnumSwitchMapping$0[event.getEventState().ordinal()]) {
/*    */             case 1:
/*    */               if (!MovementUtils.isMoving())
/*    */                 return; 
/*    */               if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SNEAKING));
/*    */               if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SNEAKING));
/*    */               break;
/*    */             case 2:
/*    */               if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SNEAKING));
/*    */               if (MinecraftInstance.mc.getThePlayer() == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SNEAKING));
/*    */               break;
/*    */           }  
/*    */         break;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onDisable() {
/*    */     // Byte code:
/*    */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   8: dup
/*    */     //   9: ifnull -> 15
/*    */     //   12: goto -> 17
/*    */     //   15: pop
/*    */     //   16: return
/*    */     //   17: astore_1
/*    */     //   18: aload_0
/*    */     //   19: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   22: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   25: checkcast java/lang/String
/*    */     //   28: astore_2
/*    */     //   29: iconst_0
/*    */     //   30: istore_3
/*    */     //   31: aload_2
/*    */     //   32: dup
/*    */     //   33: ifnonnull -> 46
/*    */     //   36: new kotlin/TypeCastException
/*    */     //   39: dup
/*    */     //   40: ldc 'null cannot be cast to non-null type java.lang.String'
/*    */     //   42: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   45: athrow
/*    */     //   46: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   49: dup
/*    */     //   50: ldc '(this as java.lang.String).toLowerCase()'
/*    */     //   52: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   55: astore_2
/*    */     //   56: aload_2
/*    */     //   57: invokevirtual hashCode : ()I
/*    */     //   60: lookupswitch default -> 234, -889473228 -> 140, 102851513 -> 116, 233102203 -> 128, 518567306 -> 104
/*    */     //   104: aload_2
/*    */     //   105: ldc 'minesecure'
/*    */     //   107: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   110: ifeq -> 234
/*    */     //   113: goto -> 203
/*    */     //   116: aload_2
/*    */     //   117: ldc 'legit'
/*    */     //   119: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   122: ifeq -> 234
/*    */     //   125: goto -> 152
/*    */     //   128: aload_2
/*    */     //   129: ldc 'vanilla'
/*    */     //   131: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   134: ifeq -> 234
/*    */     //   137: goto -> 203
/*    */     //   140: aload_2
/*    */     //   141: ldc 'switch'
/*    */     //   143: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   146: ifeq -> 234
/*    */     //   149: goto -> 203
/*    */     //   152: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   155: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   160: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   163: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   168: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   173: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*    */     //   178: ifne -> 234
/*    */     //   181: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   184: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   189: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   194: iconst_0
/*    */     //   195: invokeinterface setPressed : (Z)V
/*    */     //   200: goto -> 234
/*    */     //   203: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   206: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   211: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   214: aload_1
/*    */     //   215: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   218: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*    */     //   221: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*    */     //   226: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   229: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   234: aload_0
/*    */     //   235: invokespecial onDisable : ()V
/*    */     //   238: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #65	-> 0
/*    */     //   #65	-> 15
/*    */     //   #67	-> 18
/*    */     //   #73	-> 104
/*    */     //   #68	-> 116
/*    */     //   #73	-> 128
/*    */     //   #69	-> 152
/*    */     //   #70	-> 181
/*    */     //   #74	-> 203
/*    */     //   #76	-> 234
/*    */     //   #77	-> 234
/*    */     //   #78	-> 238
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   18	221	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	239	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/Sneak;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\Sneak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */