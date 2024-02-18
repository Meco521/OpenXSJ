/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ 
/*    */ import java.util.Timer;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "XSJAutoRun", description = "", category = ModuleCategory.HYT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000R\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\b\n\002\020\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020\033\032\0020\0342\006\020\035\032\0020\0362\006\020\037\032\0020\023H\002J\020\020 \032\0020\0342\006\020!\032\0020\"H\007J\020\020#\032\0020\0342\006\020!\032\0020$H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\026\020\n\032\004\030\0010\0138VX\004¢\006\006\032\004\b\f\020\rR\021\020\016\032\0020\017¢\006\b\n\000\032\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\032\020\030\032\0020\023X\016¢\006\016\n\000\032\004\b\031\020\025\"\004\b\032\020\027¨\006%"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytAutoLeos;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "healths", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "keepArmor", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "message", "messages", "Lnet/ccbluex/liquidbounce/value/TextValue;", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "wating", "", "getWating", "()Z", "setWating", "(Z)V", "wating2", "getWating2", "setWating2", "move", "", "item", "", "isArmorSlot", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*    */ public final class HytAutoLeos extends Module {
/*    */   private final FloatValue healths;
/*    */   private final BoolValue keepArmor;
/*    */   private final BoolValue message;
/*    */   
/* 22 */   public HytAutoLeos() { this.healths = new FloatValue("Health", 5.0F, 1.0F, 20.0F);
/* 23 */     this.keepArmor = new BoolValue("KeepArmor", false);
/* 24 */     this.message = new BoolValue("Message", false);
/* 25 */     this.messages = new TextValue("Messages", "[XSJClient]bye~~~");
/*    */     
/* 27 */     setState(true);
/*    */     
/* 29 */     this.wating = true;
/* 30 */     this.wating2 = true;
/* 31 */     this.timer = new Timer(); } private final TextValue messages; private boolean wating; private boolean wating2; @NotNull private final Timer timer; public final boolean getWating() { return this.wating; } public final void setWating(boolean <set-?>) { this.wating = <set-?>; } @NotNull public final Timer getTimer() { return this.timer; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean getWating2() {
/*    */     return this.wating2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setWating2(boolean <set-?>) {
/*    */     this.wating2 = <set-?>;
/*    */   }
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
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   14: dup
/*    */     //   15: ifnonnull -> 21
/*    */     //   18: invokestatic throwNpe : ()V
/*    */     //   21: invokeinterface getHealth : ()F
/*    */     //   26: aload_0
/*    */     //   27: getfield healths : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   30: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   33: checkcast java/lang/Number
/*    */     //   36: invokevirtual floatValue : ()F
/*    */     //   39: fcmpg
/*    */     //   40: ifgt -> 312
/*    */     //   43: aload_0
/*    */     //   44: getfield keepArmor : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   47: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   50: checkcast java/lang/Boolean
/*    */     //   53: invokevirtual booleanValue : ()Z
/*    */     //   56: ifeq -> 175
/*    */     //   59: iconst_0
/*    */     //   60: istore_2
/*    */     //   61: iconst_3
/*    */     //   62: istore_3
/*    */     //   63: iload_2
/*    */     //   64: iload_3
/*    */     //   65: if_icmpgt -> 89
/*    */     //   68: iconst_3
/*    */     //   69: iload_2
/*    */     //   70: isub
/*    */     //   71: istore #4
/*    */     //   73: aload_0
/*    */     //   74: bipush #8
/*    */     //   76: iload #4
/*    */     //   78: isub
/*    */     //   79: iconst_1
/*    */     //   80: invokespecial move : (IZ)V
/*    */     //   83: iinc #2, 1
/*    */     //   86: goto -> 63
/*    */     //   89: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   92: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   97: dup
/*    */     //   98: ifnonnull -> 104
/*    */     //   101: invokestatic throwNpe : ()V
/*    */     //   104: astore_2
/*    */     //   105: iconst_0
/*    */     //   106: istore_3
/*    */     //   107: aload_2
/*    */     //   108: dup
/*    */     //   109: ifnonnull -> 122
/*    */     //   112: new kotlin/TypeCastException
/*    */     //   115: dup
/*    */     //   116: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>'
/*    */     //   118: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   121: athrow
/*    */     //   122: checkcast net/ccbluex/liquidbounce/injection/backend/EntityPlayerSPImpl
/*    */     //   125: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*    */     //   128: checkcast net/minecraft/client/entity/EntityPlayerSP
/*    */     //   131: invokevirtual func_70658_aO : ()I
/*    */     //   134: iconst_4
/*    */     //   135: if_icmpge -> 209
/*    */     //   138: aload_0
/*    */     //   139: getfield wating2 : Z
/*    */     //   142: ifeq -> 209
/*    */     //   145: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   148: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   153: dup
/*    */     //   154: ifnonnull -> 160
/*    */     //   157: invokestatic throwNpe : ()V
/*    */     //   160: ldc '/hub'
/*    */     //   162: invokeinterface sendChatMessage : (Ljava/lang/String;)V
/*    */     //   167: aload_0
/*    */     //   168: iconst_0
/*    */     //   169: putfield wating2 : Z
/*    */     //   172: goto -> 209
/*    */     //   175: aload_0
/*    */     //   176: getfield wating2 : Z
/*    */     //   179: ifeq -> 209
/*    */     //   182: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   185: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   190: dup
/*    */     //   191: ifnonnull -> 197
/*    */     //   194: invokestatic throwNpe : ()V
/*    */     //   197: ldc '/hub'
/*    */     //   199: invokeinterface sendChatMessage : (Ljava/lang/String;)V
/*    */     //   204: aload_0
/*    */     //   205: iconst_0
/*    */     //   206: putfield wating2 : Z
/*    */     //   209: aload_0
/*    */     //   210: getfield message : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   213: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   216: checkcast java/lang/Boolean
/*    */     //   219: invokevirtual booleanValue : ()Z
/*    */     //   222: ifeq -> 267
/*    */     //   225: aload_0
/*    */     //   226: getfield wating : Z
/*    */     //   229: ifeq -> 267
/*    */     //   232: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   235: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   240: dup
/*    */     //   241: ifnonnull -> 247
/*    */     //   244: invokestatic throwNpe : ()V
/*    */     //   247: aload_0
/*    */     //   248: getfield messages : Lnet/ccbluex/liquidbounce/value/TextValue;
/*    */     //   251: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   254: checkcast java/lang/String
/*    */     //   257: invokeinterface sendChatMessage : (Ljava/lang/String;)V
/*    */     //   262: aload_0
/*    */     //   263: iconst_0
/*    */     //   264: putfield wating : Z
/*    */     //   267: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   270: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   273: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*    */     //   275: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   278: iconst_0
/*    */     //   279: invokevirtual setState : (Z)V
/*    */     //   282: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   285: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   288: ldc net/ccbluex/liquidbounce/features/module/modules/combat/GrimVelocity
/*    */     //   290: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   293: iconst_0
/*    */     //   294: invokevirtual setState : (Z)V
/*    */     //   297: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   300: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   303: ldc net/ccbluex/liquidbounce/features/module/modules/combat/Velocity
/*    */     //   305: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   308: iconst_0
/*    */     //   309: invokevirtual setState : (Z)V
/*    */     //   312: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #35	-> 6
/*    */     //   #36	-> 43
/*    */     //   #37	-> 59
/*    */     //   #38	-> 68
/*    */     //   #39	-> 73
/*    */     //   #37	-> 83
/*    */     //   #42	-> 89
/*    */     //   #96	-> 107
/*    */     //   #43	-> 145
/*    */     //   #44	-> 167
/*    */     //   #47	-> 175
/*    */     //   #48	-> 182
/*    */     //   #49	-> 204
/*    */     //   #51	-> 209
/*    */     //   #52	-> 209
/*    */     //   #53	-> 232
/*    */     //   #54	-> 262
/*    */     //   #57	-> 267
/*    */     //   #58	-> 282
/*    */     //   #59	-> 297
/*    */     //   #61	-> 312
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   73	10	4	armorSlot	I
/*    */     //   68	18	2	i	I
/*    */     //   105	26	2	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   107	24	3	$i$f$unwrap	I
/*    */     //   0	313	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytAutoLeos;
/*    */     //   0	313	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final void move(int item, boolean isArmorSlot) {
/* 64 */     if (item != -1) {
/* 65 */       boolean openInventory = !MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen());
/* 66 */       if (openInventory) {
/*    */         
/* 68 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), 
/* 69 */             ICPacketEntityAction.WAction.OPEN_INVENTORY);
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 74 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*    */ 
/*    */ 
/*    */       
/* 78 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getPlayerController().windowClick(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(), isArmorSlot ? item : ((item < 9) ? (item + 36) : item), 0, 1, MinecraftInstance.mc.getThePlayer());
/*    */ 
/*    */       
/* 81 */       if (openInventory) {
/* 82 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow());
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onWorld(@NotNull WorldEvent event) {
/* 89 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.wating = true;
/* 90 */     this.wating2 = true;
/*    */   }
/*    */   @Nullable
/*    */   public String getTag() {
/* 94 */     return "Health " + ((Number)this.healths.get()).floatValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytAutoLeos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */