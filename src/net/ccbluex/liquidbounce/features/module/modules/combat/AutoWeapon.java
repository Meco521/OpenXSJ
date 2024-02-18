/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AutoWeapon", description = "Automatically selects the best weapon in your hotbar.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\013\032\0020\f2\006\020\r\032\0020\016H\007J\020\020\017\032\0020\f2\006\020\r\032\0020\020H\007J\020\020\021\032\0020\f2\006\020\022\032\0020\023H\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoWeapon;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "attackEnemy", "", "silentValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "spoofedSlot", "", "ticksValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "update", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoWeapon extends Module {
/* 19 */   private final BoolValue silentValue = new BoolValue("SpoofItem", false);
/* 20 */   private final IntegerValue ticksValue = new IntegerValue("SpoofTicks", 10, 1, 20);
/*    */   
/*    */   private boolean attackEnemy;
/*    */   private int spoofedSlot;
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 27 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.attackEnemy = true;
/*    */   }
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
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   9: aload_1
/*    */     //   10: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   13: invokeinterface isCPacketUseEntity : (Ljava/lang/Object;)Z
/*    */     //   18: ifne -> 22
/*    */     //   21: return
/*    */     //   22: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   25: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   30: dup
/*    */     //   31: ifnull -> 37
/*    */     //   34: goto -> 39
/*    */     //   37: pop
/*    */     //   38: return
/*    */     //   39: astore_2
/*    */     //   40: aload_1
/*    */     //   41: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   44: invokeinterface asCPacketUseEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*    */     //   49: astore_3
/*    */     //   50: aload_3
/*    */     //   51: invokeinterface getAction : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*    */     //   56: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*    */     //   59: if_acmpne -> 771
/*    */     //   62: aload_0
/*    */     //   63: getfield attackEnemy : Z
/*    */     //   66: ifeq -> 771
/*    */     //   69: aload_0
/*    */     //   70: iconst_0
/*    */     //   71: putfield attackEnemy : Z
/*    */     //   74: iconst_0
/*    */     //   75: istore #6
/*    */     //   77: new kotlin/ranges/IntRange
/*    */     //   80: dup
/*    */     //   81: iload #6
/*    */     //   83: bipush #8
/*    */     //   85: invokespecial <init> : (II)V
/*    */     //   88: checkcast java/lang/Iterable
/*    */     //   91: astore #6
/*    */     //   93: iconst_0
/*    */     //   94: istore #7
/*    */     //   96: aload #6
/*    */     //   98: astore #8
/*    */     //   100: new java/util/ArrayList
/*    */     //   103: dup
/*    */     //   104: aload #6
/*    */     //   106: bipush #10
/*    */     //   108: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
/*    */     //   111: invokespecial <init> : (I)V
/*    */     //   114: checkcast java/util/Collection
/*    */     //   117: astore #9
/*    */     //   119: iconst_0
/*    */     //   120: istore #10
/*    */     //   122: aload #8
/*    */     //   124: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   129: astore #12
/*    */     //   131: aload #12
/*    */     //   133: invokeinterface hasNext : ()Z
/*    */     //   138: ifeq -> 202
/*    */     //   141: aload #12
/*    */     //   143: checkcast kotlin/collections/IntIterator
/*    */     //   146: invokevirtual nextInt : ()I
/*    */     //   149: istore #13
/*    */     //   151: aload #9
/*    */     //   153: iload #13
/*    */     //   155: istore #15
/*    */     //   157: astore #17
/*    */     //   159: iconst_0
/*    */     //   160: istore #16
/*    */     //   162: new kotlin/Pair
/*    */     //   165: dup
/*    */     //   166: iload #15
/*    */     //   168: invokestatic valueOf : (I)Ljava/lang/Integer;
/*    */     //   171: aload_2
/*    */     //   172: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*    */     //   177: iload #15
/*    */     //   179: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   184: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
/*    */     //   187: astore #18
/*    */     //   189: aload #17
/*    */     //   191: aload #18
/*    */     //   193: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   198: pop
/*    */     //   199: goto -> 131
/*    */     //   202: aload #9
/*    */     //   204: checkcast java/util/List
/*    */     //   207: checkcast java/lang/Iterable
/*    */     //   210: astore #6
/*    */     //   212: iconst_0
/*    */     //   213: istore #7
/*    */     //   215: aload #6
/*    */     //   217: astore #8
/*    */     //   219: new java/util/ArrayList
/*    */     //   222: dup
/*    */     //   223: invokespecial <init> : ()V
/*    */     //   226: checkcast java/util/Collection
/*    */     //   229: astore #9
/*    */     //   231: iconst_0
/*    */     //   232: istore #10
/*    */     //   234: aload #8
/*    */     //   236: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   241: astore #12
/*    */     //   243: aload #12
/*    */     //   245: invokeinterface hasNext : ()Z
/*    */     //   250: ifeq -> 367
/*    */     //   253: aload #12
/*    */     //   255: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   260: astore #13
/*    */     //   262: aload #13
/*    */     //   264: checkcast kotlin/Pair
/*    */     //   267: astore #15
/*    */     //   269: iconst_0
/*    */     //   270: istore #16
/*    */     //   272: aload #15
/*    */     //   274: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   277: ifnull -> 350
/*    */     //   280: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   283: aload #15
/*    */     //   285: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   288: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   291: dup
/*    */     //   292: ifnull -> 303
/*    */     //   295: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*    */     //   300: goto -> 305
/*    */     //   303: pop
/*    */     //   304: aconst_null
/*    */     //   305: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*    */     //   310: ifne -> 346
/*    */     //   313: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   316: aload #15
/*    */     //   318: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   321: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   324: dup
/*    */     //   325: ifnull -> 336
/*    */     //   328: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*    */     //   333: goto -> 338
/*    */     //   336: pop
/*    */     //   337: aconst_null
/*    */     //   338: invokeinterface isItemTool : (Ljava/lang/Object;)Z
/*    */     //   343: ifeq -> 350
/*    */     //   346: iconst_1
/*    */     //   347: goto -> 351
/*    */     //   350: iconst_0
/*    */     //   351: ifeq -> 243
/*    */     //   354: aload #9
/*    */     //   356: aload #13
/*    */     //   358: invokeinterface add : (Ljava/lang/Object;)Z
/*    */     //   363: pop
/*    */     //   364: goto -> 243
/*    */     //   367: aload #9
/*    */     //   369: checkcast java/util/List
/*    */     //   372: checkcast java/lang/Iterable
/*    */     //   375: astore #6
/*    */     //   377: iconst_0
/*    */     //   378: istore #7
/*    */     //   380: aload #6
/*    */     //   382: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   387: astore #8
/*    */     //   389: aload #8
/*    */     //   391: invokeinterface hasNext : ()Z
/*    */     //   396: ifne -> 403
/*    */     //   399: aconst_null
/*    */     //   400: goto -> 618
/*    */     //   403: aload #8
/*    */     //   405: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   410: astore #9
/*    */     //   412: aload #8
/*    */     //   414: invokeinterface hasNext : ()Z
/*    */     //   419: ifne -> 427
/*    */     //   422: aload #9
/*    */     //   424: goto -> 618
/*    */     //   427: aload #9
/*    */     //   429: checkcast kotlin/Pair
/*    */     //   432: astore #10
/*    */     //   434: iconst_0
/*    */     //   435: istore #12
/*    */     //   437: aload #10
/*    */     //   439: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   442: dup
/*    */     //   443: ifnonnull -> 449
/*    */     //   446: invokestatic throwNpe : ()V
/*    */     //   449: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   452: ldc 'generic.attackDamage'
/*    */     //   454: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*    */     //   459: checkcast java/lang/Iterable
/*    */     //   462: invokestatic first : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*    */     //   465: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*    */     //   468: invokeinterface getAmount : ()D
/*    */     //   473: ldc2_w 1.25
/*    */     //   476: aload #10
/*    */     //   478: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   481: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   484: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   487: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*    */     //   490: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*    */     //   495: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*    */     //   498: i2d
/*    */     //   499: dmul
/*    */     //   500: dadd
/*    */     //   501: dstore #10
/*    */     //   503: aload #8
/*    */     //   505: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   510: astore #12
/*    */     //   512: aload #12
/*    */     //   514: checkcast kotlin/Pair
/*    */     //   517: astore #13
/*    */     //   519: iconst_0
/*    */     //   520: istore #15
/*    */     //   522: aload #13
/*    */     //   524: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   527: dup
/*    */     //   528: ifnonnull -> 534
/*    */     //   531: invokestatic throwNpe : ()V
/*    */     //   534: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   537: ldc 'generic.attackDamage'
/*    */     //   539: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*    */     //   544: checkcast java/lang/Iterable
/*    */     //   547: invokestatic first : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*    */     //   550: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*    */     //   553: invokeinterface getAmount : ()D
/*    */     //   558: ldc2_w 1.25
/*    */     //   561: aload #13
/*    */     //   563: invokevirtual getSecond : ()Ljava/lang/Object;
/*    */     //   566: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*    */     //   569: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   572: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*    */     //   575: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*    */     //   580: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*    */     //   583: i2d
/*    */     //   584: dmul
/*    */     //   585: dadd
/*    */     //   586: dstore #13
/*    */     //   588: dload #10
/*    */     //   590: dload #13
/*    */     //   592: invokestatic compare : (DD)I
/*    */     //   595: ifge -> 606
/*    */     //   598: aload #12
/*    */     //   600: astore #9
/*    */     //   602: dload #13
/*    */     //   604: dstore #10
/*    */     //   606: aload #8
/*    */     //   608: invokeinterface hasNext : ()Z
/*    */     //   613: ifne -> 503
/*    */     //   616: aload #9
/*    */     //   618: checkcast kotlin/Pair
/*    */     //   621: dup
/*    */     //   622: ifnull -> 628
/*    */     //   625: goto -> 630
/*    */     //   628: pop
/*    */     //   629: return
/*    */     //   630: astore #5
/*    */     //   632: aload #5
/*    */     //   634: invokevirtual component1 : ()Ljava/lang/Object;
/*    */     //   637: checkcast java/lang/Number
/*    */     //   640: invokevirtual intValue : ()I
/*    */     //   643: istore #4
/*    */     //   645: iload #4
/*    */     //   647: aload_2
/*    */     //   648: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*    */     //   653: invokeinterface getCurrentItem : ()I
/*    */     //   658: if_icmpne -> 662
/*    */     //   661: return
/*    */     //   662: aload_0
/*    */     //   663: getfield silentValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   666: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   669: checkcast java/lang/Boolean
/*    */     //   672: invokevirtual booleanValue : ()Z
/*    */     //   675: ifeq -> 724
/*    */     //   678: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   681: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   686: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   689: iload #4
/*    */     //   691: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*    */     //   696: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   699: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   704: aload_0
/*    */     //   705: aload_0
/*    */     //   706: getfield ticksValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   709: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   712: checkcast java/lang/Number
/*    */     //   715: invokevirtual intValue : ()I
/*    */     //   718: putfield spoofedSlot : I
/*    */     //   721: goto -> 750
/*    */     //   724: aload_2
/*    */     //   725: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*    */     //   730: iload #4
/*    */     //   732: invokeinterface setCurrentItem : (I)V
/*    */     //   737: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   740: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*    */     //   745: invokeinterface updateController : ()V
/*    */     //   750: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   753: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   758: aload_3
/*    */     //   759: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   762: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   767: aload_1
/*    */     //   768: invokevirtual cancelEvent : ()V
/*    */     //   771: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #32	-> 6
/*    */     //   #33	-> 21
/*    */     //   #35	-> 22
/*    */     //   #35	-> 37
/*    */     //   #37	-> 40
/*    */     //   #39	-> 50
/*    */     //   #40	-> 50
/*    */     //   #41	-> 69
/*    */     //   #44	-> 74
/*    */     //   #47	-> 74
/*    */     //   #44	-> 74
/*    */     //   #46	-> 74
/*    */     //   #44	-> 74
/*    */     //   #45	-> 74
/*    */     //   #44	-> 74
/*    */     //   #45	-> 93
/*    */     //   #79	-> 96
/*    */     //   #80	-> 122
/*    */     //   #81	-> 151
/*    */     //   #45	-> 162
/*    */     //   #80	-> 199
/*    */     //   #82	-> 202
/*    */     //   #46	-> 212
/*    */     //   #83	-> 215
/*    */     //   #84	-> 234
/*    */     //   #46	-> 272
/*    */     //   #85	-> 367
/*    */     //   #47	-> 377
/*    */     //   #86	-> 380
/*    */     //   #87	-> 389
/*    */     //   #88	-> 403
/*    */     //   #89	-> 412
/*    */     //   #90	-> 427
/*    */     //   #48	-> 437
/*    */     //   #91	-> 503
/*    */     //   #92	-> 503
/*    */     //   #93	-> 512
/*    */     //   #48	-> 522
/*    */     //   #94	-> 588
/*    */     //   #95	-> 598
/*    */     //   #96	-> 602
/*    */     //   #98	-> 606
/*    */     //   #99	-> 616
/*    */     //   #49	-> 629
/*    */     //   #44	-> 637
/*    */     //   #51	-> 645
/*    */     //   #52	-> 661
/*    */     //   #55	-> 662
/*    */     //   #56	-> 678
/*    */     //   #57	-> 704
/*    */     //   #59	-> 724
/*    */     //   #60	-> 737
/*    */     //   #61	-> 750
/*    */     //   #64	-> 750
/*    */     //   #65	-> 767
/*    */     //   #67	-> 771
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   159	28	15	it	I
/*    */     //   162	25	16	$i$a$-map-AutoWeapon$onPacket$1	I
/*    */     //   151	48	13	item$iv$iv	I
/*    */     //   119	85	8	$this$mapTo$iv$iv	Ljava/lang/Iterable;
/*    */     //   119	85	9	destination$iv$iv	Ljava/util/Collection;
/*    */     //   122	82	10	$i$f$mapTo	I
/*    */     //   93	114	6	$this$map$iv	Ljava/lang/Iterable;
/*    */     //   96	111	7	$i$f$map	I
/*    */     //   269	82	15	it	Lkotlin/Pair;
/*    */     //   272	79	16	$i$a$-filter-AutoWeapon$onPacket$2	I
/*    */     //   262	102	13	element$iv$iv	Ljava/lang/Object;
/*    */     //   231	138	8	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*    */     //   231	138	9	destination$iv$iv	Ljava/util/Collection;
/*    */     //   234	135	10	$i$f$filterTo	I
/*    */     //   212	160	6	$this$filter$iv	Ljava/lang/Iterable;
/*    */     //   215	157	7	$i$f$filter	I
/*    */     //   434	67	10	it	Lkotlin/Pair;
/*    */     //   437	64	12	$i$a$-maxBy-AutoWeapon$onPacket$3	I
/*    */     //   519	67	13	it	Lkotlin/Pair;
/*    */     //   522	64	15	$i$a$-maxBy-AutoWeapon$onPacket$3	I
/*    */     //   588	28	13	v$iv	D
/*    */     //   512	104	12	e$iv	Ljava/lang/Object;
/*    */     //   503	115	10	maxValue$iv	D
/*    */     //   412	206	9	maxElem$iv	Ljava/lang/Object;
/*    */     //   389	229	8	iterator$iv	Ljava/util/Iterator;
/*    */     //   377	241	6	$this$maxBy$iv	Ljava/lang/Iterable;
/*    */     //   380	238	7	$i$f$maxBy	I
/*    */     //   645	126	4	slot	I
/*    */     //   50	722	3	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*    */     //   40	732	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   0	772	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoWeapon;
/*    */     //   0	772	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*    */   }
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
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent update) {
/* 72 */     Intrinsics.checkParameterIsNotNull(update, "update"); if (this.spoofedSlot > 0) {
/* 73 */       if (this.spoofedSlot == 1) {
/* 74 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/* 75 */       }  int i; this.spoofedSlot = (i = this.spoofedSlot) + -1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoWeapon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */