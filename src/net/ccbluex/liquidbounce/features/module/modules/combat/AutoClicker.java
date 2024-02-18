/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import kotlin.random.Random;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*    */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.Value;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "AutoClicker", description = "Constantly clicks when holding down a mouse button.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\t\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\023\032\0020\0242\006\020\025\032\0020\026H\007J\020\020\027\032\0020\0242\006\020\025\032\0020\030H\007R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\tX\016¢\006\002\n\000R\016\020\013\032\0020\007X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\rX\004¢\006\002\n\000R\024\020\017\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\020\032\0020\tX\016¢\006\002\n\000R\016\020\021\032\0020\tX\016¢\006\002\n\000R\016\020\022\032\0020\007X\004¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoClicker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "breakBlockValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "jitterValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "leftDelay", "", "leftLastSwing", "leftValue", "maxCPSValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "minCPSValue", "onlyBlockValue", "rightDelay", "rightLastSwing", "rightValue", "onRender", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoClicker
/*    */   extends Module
/*    */ {
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*    */   static final class AutoClicker$breakBlockValue$1
/*    */     extends Lambda
/*    */     implements Function0<Boolean>
/*    */   {
/*    */     public final boolean invoke() {
/* 41 */       return ((Boolean)AutoClicker.this.leftValue.get()).booleanValue();
/* 42 */     } AutoClicker$breakBlockValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class AutoClicker$onlyBlockValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)AutoClicker.this.rightValue.get()).booleanValue(); } AutoClicker$onlyBlockValue$1() { super(0); } } private final IntegerValue maxCPSValue = new AutoClicker$maxCPSValue$1("MaxCPS", 8, 1, 20); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/AutoClicker$maxCPSValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class AutoClicker$maxCPSValue$1 extends IntegerValue { AutoClicker$maxCPSValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(int oldValue, int newValue) { int minCPS = ((Number)AutoClicker.this.minCPSValue.get()).intValue(); if (minCPS > newValue) set(Integer.valueOf(minCPS));  } } private final IntegerValue minCPSValue = new AutoClicker$minCPSValue$1("MinCPS", 5, 1, 20); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/AutoClicker$minCPSValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class AutoClicker$minCPSValue$1 extends IntegerValue { AutoClicker$minCPSValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(int oldValue, int newValue) { int maxCPS = ((Number)AutoClicker.this.maxCPSValue.get()).intValue(); if (maxCPS < newValue) set(Integer.valueOf(maxCPS));  } } private final Value<Boolean> onlyBlockValue = (new BoolValue("RightOnlyBlocks", false)).displayable(new AutoClicker$onlyBlockValue$1()); private final BoolValue rightValue = new BoolValue("Right", true); private final BoolValue leftValue = new BoolValue("Left", true); private final BoolValue jitterValue = new BoolValue("Jitter", false);
/*    */   private final Value<Boolean> breakBlockValue = (new BoolValue("LeftBreakBlocks", false)).displayable(new AutoClicker$breakBlockValue$1());
/* 44 */   private long rightDelay = TimeUtils.randomClickDelay(((Number)this.minCPSValue.get()).intValue(), ((Number)this.maxCPSValue.get()).intValue());
/*    */   private long rightLastSwing;
/* 46 */   private long leftDelay = TimeUtils.randomClickDelay(((Number)this.minCPSValue.get()).intValue(), ((Number)this.maxCPSValue.get()).intValue());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private long leftLastSwing;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender(@NotNull Render3DEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   9: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   14: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   19: invokeinterface isKeyDown : ()Z
/*    */     //   24: ifeq -> 187
/*    */     //   27: aload_0
/*    */     //   28: getfield leftValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   31: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   34: checkcast java/lang/Boolean
/*    */     //   37: invokevirtual booleanValue : ()Z
/*    */     //   40: ifeq -> 187
/*    */     //   43: invokestatic currentTimeMillis : ()J
/*    */     //   46: aload_0
/*    */     //   47: getfield leftLastSwing : J
/*    */     //   50: lsub
/*    */     //   51: aload_0
/*    */     //   52: getfield leftDelay : J
/*    */     //   55: lcmp
/*    */     //   56: iflt -> 187
/*    */     //   59: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   62: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*    */     //   67: invokeinterface getCurBlockDamageMP : ()F
/*    */     //   72: fconst_0
/*    */     //   73: fcmpg
/*    */     //   74: ifne -> 187
/*    */     //   77: aload_0
/*    */     //   78: getfield breakBlockValue : Lnet/ccbluex/liquidbounce/value/Value;
/*    */     //   81: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   84: checkcast java/lang/Boolean
/*    */     //   87: invokevirtual booleanValue : ()Z
/*    */     //   90: ifeq -> 111
/*    */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   96: getfield field_71442_b : Lnet/minecraft/client/multiplayer/PlayerControllerMP;
/*    */     //   99: dup
/*    */     //   100: ldc 'mc2.playerController'
/*    */     //   102: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   105: invokevirtual func_181040_m : ()Z
/*    */     //   108: ifeq -> 147
/*    */     //   111: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   114: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   119: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   127: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   132: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   137: invokeinterface getKeyCode : ()I
/*    */     //   142: invokeinterface onTick : (I)V
/*    */     //   147: aload_0
/*    */     //   148: invokestatic currentTimeMillis : ()J
/*    */     //   151: putfield leftLastSwing : J
/*    */     //   154: aload_0
/*    */     //   155: aload_0
/*    */     //   156: getfield minCPSValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   159: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   162: checkcast java/lang/Number
/*    */     //   165: invokevirtual intValue : ()I
/*    */     //   168: aload_0
/*    */     //   169: getfield maxCPSValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   172: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   175: checkcast java/lang/Number
/*    */     //   178: invokevirtual intValue : ()I
/*    */     //   181: invokestatic randomClickDelay : (II)J
/*    */     //   184: putfield leftDelay : J
/*    */     //   187: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   190: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   195: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   200: invokeinterface isKeyDown : ()Z
/*    */     //   205: ifeq -> 400
/*    */     //   208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   211: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   216: dup
/*    */     //   217: ifnonnull -> 223
/*    */     //   220: invokestatic throwNpe : ()V
/*    */     //   223: invokeinterface isUsingItem : ()Z
/*    */     //   228: ifne -> 400
/*    */     //   231: aload_0
/*    */     //   232: getfield rightValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   235: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   238: checkcast java/lang/Boolean
/*    */     //   241: invokevirtual booleanValue : ()Z
/*    */     //   244: ifeq -> 400
/*    */     //   247: invokestatic currentTimeMillis : ()J
/*    */     //   250: aload_0
/*    */     //   251: getfield rightLastSwing : J
/*    */     //   254: lsub
/*    */     //   255: aload_0
/*    */     //   256: getfield rightDelay : J
/*    */     //   259: lcmp
/*    */     //   260: iflt -> 400
/*    */     //   263: aload_0
/*    */     //   264: getfield onlyBlockValue : Lnet/ccbluex/liquidbounce/value/Value;
/*    */     //   267: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   270: checkcast java/lang/Boolean
/*    */     //   273: invokevirtual booleanValue : ()Z
/*    */     //   276: ifeq -> 324
/*    */     //   279: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   282: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   285: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   290: dup
/*    */     //   291: ifnonnull -> 297
/*    */     //   294: invokestatic throwNpe : ()V
/*    */     //   297: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   302: dup
/*    */     //   303: ifnull -> 314
/*    */     //   306: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*    */     //   311: goto -> 316
/*    */     //   314: pop
/*    */     //   315: aconst_null
/*    */     //   316: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*    */     //   321: ifeq -> 360
/*    */     //   324: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   327: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   332: invokeinterface getKeyBindAttack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   337: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   340: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*    */     //   345: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*    */     //   350: invokeinterface getKeyCode : ()I
/*    */     //   355: invokeinterface onTick : (I)V
/*    */     //   360: aload_0
/*    */     //   361: invokestatic currentTimeMillis : ()J
/*    */     //   364: putfield rightLastSwing : J
/*    */     //   367: aload_0
/*    */     //   368: aload_0
/*    */     //   369: getfield minCPSValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   372: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   375: checkcast java/lang/Number
/*    */     //   378: invokevirtual intValue : ()I
/*    */     //   381: aload_0
/*    */     //   382: getfield maxCPSValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   385: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   388: checkcast java/lang/Number
/*    */     //   391: invokevirtual intValue : ()I
/*    */     //   394: invokestatic randomClickDelay : (II)J
/*    */     //   397: putfield rightDelay : J
/*    */     //   400: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #52	-> 6
/*    */     //   #53	-> 6
/*    */     //   #52	-> 27
/*    */     //   #53	-> 43
/*    */     //   #55	-> 77
/*    */     //   #57	-> 147
/*    */     //   #58	-> 154
/*    */     //   #62	-> 187
/*    */     //   #63	-> 187
/*    */     //   #62	-> 231
/*    */     //   #63	-> 247
/*    */     //   #64	-> 263
/*    */     //   #65	-> 360
/*    */     //   #66	-> 367
/*    */     //   #68	-> 400
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	401	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoClicker;
/*    */     //   0	401	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 72 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 74 */       if (((Boolean)this.jitterValue.get()).booleanValue() && ((((Boolean)this.leftValue.get()).booleanValue() && MinecraftInstance.mc.getGameSettings().getKeyBindAttack().isKeyDown() && MinecraftInstance.mc.getPlayerController().getCurBlockDamageMP() == 0.0F) || ((
/* 75 */         (Boolean)this.rightValue.get()).booleanValue() && MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().isKeyDown() && !thePlayer.isUsingItem()))) {
/* 76 */         if (Random.Default.nextBoolean()) thePlayer.setRotationYaw(thePlayer.getRotationYaw() + (Random.Default.nextBoolean() ? -RandomUtils.INSTANCE.nextFloat(0.0F, 1.0F) : RandomUtils.INSTANCE.nextFloat(0.0F, 1.0F)));
/*    */         
/* 78 */         if (Random.Default.nextBoolean()) {
/* 79 */           thePlayer.setRotationPitch(thePlayer.getRotationPitch() + (Random.Default.nextBoolean() ? -RandomUtils.INSTANCE.nextFloat(0.0F, 1.0F) : RandomUtils.INSTANCE.nextFloat(0.0F, 1.0F)));
/*    */ 
/*    */           
/* 82 */           if (thePlayer.getRotationPitch() > 90) {
/* 83 */             thePlayer.setRotationPitch(90.0F);
/* 84 */           } else if (thePlayer.getRotationPitch() < -90) {
/* 85 */             thePlayer.setRotationPitch(-90.0F);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoClicker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */