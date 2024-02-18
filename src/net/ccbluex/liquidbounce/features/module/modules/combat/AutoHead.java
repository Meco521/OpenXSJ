/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.settings.IKeyBinding;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.entity.player.IInventoryPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "AutoHead", description = "faq", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\025\032\0020\0222\006\020\026\032\0020\022H\002J\b\020\027\032\0020\030H\026J\b\020\031\032\0020\030H\026J\022\020\032\032\0020\0302\b\020\033\032\004\030\0010\034H\007J\b\020\035\032\0020\030H\002J\b\020\036\032\0020\030H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\fX\004¢\006\002\n\000R\016\020\016\032\0020\006X\016¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\022X\016¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoHead;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "doingStuff", "", "getDoingStuff", "()Z", "setDoingStuff", "(Z)V", "eatApples", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "eatHeads", "eatingApple", "health", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "switched", "", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/TimeUtils;", "getItemFromHotbar", "id", "onDisable", "", "onEnable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "repairItemPress", "repairItemSwitch", "XSJClient"})
/*     */ public final class AutoHead extends Module {
/*     */   private boolean eatingApple;
/*  27 */   private int switched = -1;
/*  28 */   private boolean doingStuff; public final boolean getDoingStuff() { return this.doingStuff; } public final void setDoingStuff(boolean <set-?>) { this.doingStuff = <set-?>; }
/*  29 */    private final TimeUtils timer = new TimeUtils();
/*  30 */   private final BoolValue eatHeads = new BoolValue("EatHead", true);
/*  31 */   private final BoolValue eatApples = new BoolValue("EatApples", true);
/*  32 */   private final FloatValue health = new FloatValue("Health", 10.0F, 1.0F, 20.0F);
/*  33 */   private final IntegerValue delay = new IntegerValue("Delay", 750, 100, 2000);
/*     */   
/*     */   public void onEnable() {
/*  36 */     this.doingStuff = false;
/*  37 */     this.eatingApple = this.doingStuff;
/*  38 */     this.switched = -1;
/*  39 */     this.timer.reset();
/*  40 */     super.onEnable();
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  44 */     this.doingStuff = false;
/*  45 */     if (this.eatingApple) {
/*  46 */       repairItemPress();
/*  47 */       repairItemSwitch();
/*     */     } 
/*  49 */     super.onDisable();
/*     */   }
/*     */   
/*     */   private final void repairItemPress() {
/*  53 */     if (MinecraftInstance.mc.getGameSettings() != null) {
/*  54 */       IKeyBinding keyBindUseItem = MinecraftInstance.mc.getGameSettings().getKeyBindUseItem();
/*  55 */       if (keyBindUseItem != null) keyBindUseItem.setPressed(false);
/*     */     
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable MotionEvent event) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: ifnonnull -> 12
/*     */     //   11: return
/*     */     //   12: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   15: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   20: dup
/*     */     //   21: ifnonnull -> 27
/*     */     //   24: invokestatic throwNpe : ()V
/*     */     //   27: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   32: dup
/*     */     //   33: ifnull -> 39
/*     */     //   36: goto -> 41
/*     */     //   39: pop
/*     */     //   40: return
/*     */     //   41: astore_2
/*     */     //   42: aload_0
/*     */     //   43: iconst_0
/*     */     //   44: putfield doingStuff : Z
/*     */     //   47: iconst_0
/*     */     //   48: invokestatic isButtonDown : (I)Z
/*     */     //   51: ifne -> 528
/*     */     //   54: iconst_1
/*     */     //   55: invokestatic isButtonDown : (I)Z
/*     */     //   58: ifne -> 528
/*     */     //   61: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   64: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   69: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   74: astore_3
/*     */     //   75: aload_0
/*     */     //   76: getfield timer : Lnet/ccbluex/liquidbounce/utils/timer/TimeUtils;
/*     */     //   79: aload_0
/*     */     //   80: getfield delay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   83: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   86: checkcast java/lang/Number
/*     */     //   89: invokevirtual intValue : ()I
/*     */     //   92: i2d
/*     */     //   93: invokevirtual hasReached : (D)Z
/*     */     //   96: ifne -> 113
/*     */     //   99: aload_0
/*     */     //   100: iconst_0
/*     */     //   101: putfield eatingApple : Z
/*     */     //   104: aload_0
/*     */     //   105: invokespecial repairItemPress : ()V
/*     */     //   108: aload_0
/*     */     //   109: invokespecial repairItemSwitch : ()V
/*     */     //   112: return
/*     */     //   113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   116: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   121: dup
/*     */     //   122: ifnonnull -> 128
/*     */     //   125: invokestatic throwNpe : ()V
/*     */     //   128: invokeinterface getCapabilities : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;
/*     */     //   133: invokeinterface isCreativeMode : ()Z
/*     */     //   138: ifne -> 212
/*     */     //   141: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   144: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   149: dup
/*     */     //   150: ifnonnull -> 156
/*     */     //   153: invokestatic throwNpe : ()V
/*     */     //   156: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   159: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.REGENERATION : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*     */     //   162: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   167: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*     */     //   172: ifne -> 212
/*     */     //   175: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   178: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   183: dup
/*     */     //   184: ifnonnull -> 190
/*     */     //   187: invokestatic throwNpe : ()V
/*     */     //   190: invokeinterface getHealth : ()F
/*     */     //   195: aload_0
/*     */     //   196: getfield health : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   199: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   202: checkcast java/lang/Number
/*     */     //   205: invokevirtual floatValue : ()F
/*     */     //   208: fcmpl
/*     */     //   209: iflt -> 240
/*     */     //   212: aload_0
/*     */     //   213: getfield timer : Lnet/ccbluex/liquidbounce/utils/timer/TimeUtils;
/*     */     //   216: invokevirtual reset : ()V
/*     */     //   219: aload_0
/*     */     //   220: getfield eatingApple : Z
/*     */     //   223: ifeq -> 239
/*     */     //   226: aload_0
/*     */     //   227: iconst_0
/*     */     //   228: putfield eatingApple : Z
/*     */     //   231: aload_0
/*     */     //   232: invokespecial repairItemPress : ()V
/*     */     //   235: aload_0
/*     */     //   236: invokespecial repairItemSwitch : ()V
/*     */     //   239: return
/*     */     //   240: iconst_0
/*     */     //   241: istore #4
/*     */     //   243: iconst_1
/*     */     //   244: istore #5
/*     */     //   246: iload #4
/*     */     //   248: iload #5
/*     */     //   250: if_icmpgt -> 528
/*     */     //   253: iload #4
/*     */     //   255: ifeq -> 262
/*     */     //   258: iconst_1
/*     */     //   259: goto -> 263
/*     */     //   262: iconst_0
/*     */     //   263: istore #6
/*     */     //   265: iload #6
/*     */     //   267: ifeq -> 289
/*     */     //   270: aload_0
/*     */     //   271: getfield eatHeads : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   274: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   277: checkcast java/lang/Boolean
/*     */     //   280: invokevirtual booleanValue : ()Z
/*     */     //   283: ifne -> 321
/*     */     //   286: goto -> 522
/*     */     //   289: aload_0
/*     */     //   290: getfield eatApples : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   293: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   296: checkcast java/lang/Boolean
/*     */     //   299: invokevirtual booleanValue : ()Z
/*     */     //   302: ifne -> 321
/*     */     //   305: aload_0
/*     */     //   306: iconst_0
/*     */     //   307: putfield eatingApple : Z
/*     */     //   310: aload_0
/*     */     //   311: invokespecial repairItemPress : ()V
/*     */     //   314: aload_0
/*     */     //   315: invokespecial repairItemSwitch : ()V
/*     */     //   318: goto -> 522
/*     */     //   321: iconst_0
/*     */     //   322: istore #7
/*     */     //   324: iload #6
/*     */     //   326: ifeq -> 339
/*     */     //   329: aload_0
/*     */     //   330: sipush #397
/*     */     //   333: invokespecial getItemFromHotbar : (I)I
/*     */     //   336: goto -> 346
/*     */     //   339: aload_0
/*     */     //   340: sipush #322
/*     */     //   343: invokespecial getItemFromHotbar : (I)I
/*     */     //   346: istore #7
/*     */     //   348: iload #7
/*     */     //   350: iconst_m1
/*     */     //   351: if_icmpne -> 357
/*     */     //   354: goto -> 522
/*     */     //   357: aload_2
/*     */     //   358: invokeinterface getCurrentItem : ()I
/*     */     //   363: istore #8
/*     */     //   365: aload_0
/*     */     //   366: iconst_1
/*     */     //   367: putfield doingStuff : Z
/*     */     //   370: iload #6
/*     */     //   372: ifeq -> 486
/*     */     //   375: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   378: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   383: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   386: iload #7
/*     */     //   388: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   393: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   396: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   401: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   404: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   409: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   412: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   415: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   420: dup
/*     */     //   421: ifnonnull -> 427
/*     */     //   424: invokestatic throwNpe : ()V
/*     */     //   427: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   432: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   437: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*     */     //   442: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   445: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   450: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   453: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   458: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   461: iload #8
/*     */     //   463: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   468: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   471: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   476: aload_0
/*     */     //   477: getfield timer : Lnet/ccbluex/liquidbounce/utils/timer/TimeUtils;
/*     */     //   480: invokevirtual reset : ()V
/*     */     //   483: goto -> 522
/*     */     //   486: aload_2
/*     */     //   487: iload #7
/*     */     //   489: invokeinterface setCurrentItem : (I)V
/*     */     //   494: aload_3
/*     */     //   495: iconst_1
/*     */     //   496: invokeinterface setPressed : (Z)V
/*     */     //   501: aload_0
/*     */     //   502: getfield eatingApple : Z
/*     */     //   505: ifeq -> 511
/*     */     //   508: goto -> 522
/*     */     //   511: aload_0
/*     */     //   512: iconst_1
/*     */     //   513: putfield eatingApple : Z
/*     */     //   516: aload_0
/*     */     //   517: iload #8
/*     */     //   519: putfield switched : I
/*     */     //   522: iinc #4, 1
/*     */     //   525: goto -> 246
/*     */     //   528: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #61	-> 0
/*     */     //   #62	-> 12
/*     */     //   #62	-> 39
/*     */     //   #63	-> 42
/*     */     //   #64	-> 47
/*     */     //   #65	-> 61
/*     */     //   #66	-> 75
/*     */     //   #67	-> 99
/*     */     //   #68	-> 104
/*     */     //   #69	-> 108
/*     */     //   #70	-> 112
/*     */     //   #72	-> 113
/*     */     //   #73	-> 212
/*     */     //   #74	-> 219
/*     */     //   #75	-> 226
/*     */     //   #76	-> 231
/*     */     //   #77	-> 235
/*     */     //   #79	-> 239
/*     */     //   #81	-> 240
/*     */     //   #82	-> 253
/*     */     //   #83	-> 265
/*     */     //   #84	-> 270
/*     */     //   #86	-> 289
/*     */     //   #87	-> 305
/*     */     //   #88	-> 310
/*     */     //   #89	-> 314
/*     */     //   #90	-> 318
/*     */     //   #92	-> 321
/*     */     //   #93	-> 321
/*     */     //   #94	-> 324
/*     */     //   #95	-> 329
/*     */     //   #97	-> 339
/*     */     //   #94	-> 346
/*     */     //   #99	-> 348
/*     */     //   #100	-> 357
/*     */     //   #101	-> 365
/*     */     //   #102	-> 370
/*     */     //   #103	-> 375
/*     */     //   #104	-> 401
/*     */     //   #105	-> 450
/*     */     //   #106	-> 476
/*     */     //   #108	-> 486
/*     */     //   #109	-> 494
/*     */     //   #110	-> 501
/*     */     //   #111	-> 511
/*     */     //   #112	-> 516
/*     */     //   #113	-> 522
/*     */     //   #81	-> 522
/*     */     //   #116	-> 528
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   365	157	8	tempSlot	I
/*     */     //   324	198	7	slot	I
/*     */     //   265	257	6	doEatHeads	Z
/*     */     //   253	272	4	i	I
/*     */     //   75	453	3	useItem	Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   42	487	2	inventory	Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   0	529	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoHead;
/*     */     //   0	529	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void repairItemSwitch() {
/* 119 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP p = MinecraftInstance.mc.getThePlayer();
/* 120 */       if (p.getInventory() != null) { IInventoryPlayer inventory = p.getInventory();
/* 121 */         int switched = this.switched;
/* 122 */         if (switched == -1)
/* 123 */           return;  inventory.setCurrentItem(switched);
/* 124 */         switched = -1;
/* 125 */         this.switched = switched; return; }
/*     */        p.getInventory();
/*     */       return; }
/*     */     
/* 129 */     MinecraftInstance.mc.getThePlayer(); } private final int getItemFromHotbar(int id) { for (byte b1 = 0, b2 = 8; b1 <= b2; b1++) {
/* 130 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventory().getMainInventory().get(b1) != null) {
/* 131 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IItemStack a = (IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getMainInventory().get(b1);
/* 132 */         if (a == null) Intrinsics.throwNpe();  IItem item = a.getItem();
/* 133 */         if (item == null) Intrinsics.throwNpe();  if (access$getFunctions$p$s1046033730().getIdFromItem(item) == id) {
/* 134 */           return b1;
/*     */         }
/*     */       } 
/*     */     } 
/* 138 */     return -1; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoHead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */