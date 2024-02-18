/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*     */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.features.command.Command;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "XRay", description = "Allows you to see ores through walls.", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\013\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\b\032\0020\t2\006\020\n\032\0020\013H\026R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "xrayBlocks", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getXrayBlocks", "()Ljava/util/List;", "onToggle", "", "state", "", "XSJClient"})
/*     */ public final class XRay extends Module {
/*     */   public XRay() {
/*  13 */     this.xrayBlocks = CollectionsKt.mutableListOf((Object[])new IBlock[] { 
/*  14 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.COAL_ORE), 
/*  15 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.IRON_ORE), 
/*  16 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.GOLD_ORE), 
/*  17 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.REDSTONE_ORE), 
/*  18 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.LAPIS_ORE), 
/*  19 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.DIAMOND_ORE), 
/*  20 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.EMERALD_ORE), 
/*  21 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.QUARTZ_ORE), 
/*  22 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.CLAY), 
/*  23 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.GLOWSTONE), 
/*  24 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.CRAFTING_TABLE), 
/*  25 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.TORCH), 
/*  26 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.LADDER), 
/*  27 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.TNT), 
/*  28 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.COAL_BLOCK), 
/*  29 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.IRON_BLOCK), 
/*  30 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.GOLD_BLOCK), 
/*  31 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.DIAMOND_BLOCK), 
/*  32 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.EMERALD_BLOCK), 
/*  33 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.REDSTONE_BLOCK), 
/*  34 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.LAPIS_BLOCK), 
/*  35 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.FIRE), 
/*  36 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.MOSSY_COBBLESTONE), 
/*  37 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.MOB_SPAWNER), 
/*  38 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.END_PORTAL_FRAME), 
/*  39 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.ENCHANTING_TABLE), 
/*  40 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.BOOKSHELF), 
/*  41 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.COMMAND_BLOCK), 
/*  42 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.LAVA), 
/*  43 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.FLOWING_LAVA), 
/*  44 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.WATER), 
/*  45 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.FLOWING_WATER), 
/*  46 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.FURNACE), 
/*  47 */           MinecraftInstance.classProvider.getBlockEnum(BlockType.LIT_FURNACE) });
/*     */ 
/*     */ 
/*     */     
/*  51 */     Retreat.INSTANCE.getCommandManager().registerCommand(new Command("xray", new String[0])
/*     */         {
/*     */           public void execute(@NotNull String[] args) {
/*     */             // Byte code:
/*     */             //   0: aload_1
/*     */             //   1: ldc 'args'
/*     */             //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */             //   6: aload_1
/*     */             //   7: arraylength
/*     */             //   8: iconst_1
/*     */             //   9: if_icmple -> 597
/*     */             //   12: aload_1
/*     */             //   13: iconst_1
/*     */             //   14: aaload
/*     */             //   15: ldc 'add'
/*     */             //   17: iconst_1
/*     */             //   18: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */             //   21: ifeq -> 244
/*     */             //   24: aload_1
/*     */             //   25: arraylength
/*     */             //   26: iconst_2
/*     */             //   27: if_icmple -> 237
/*     */             //   30: nop
/*     */             //   31: nop
/*     */             //   32: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   35: aload_1
/*     */             //   36: iconst_2
/*     */             //   37: aaload
/*     */             //   38: astore_3
/*     */             //   39: astore #8
/*     */             //   41: iconst_0
/*     */             //   42: istore #4
/*     */             //   44: aload_3
/*     */             //   45: invokestatic parseInt : (Ljava/lang/String;)I
/*     */             //   48: istore #9
/*     */             //   50: aload #8
/*     */             //   52: iload #9
/*     */             //   54: invokeinterface getBlockById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   59: astore_3
/*     */             //   60: goto -> 130
/*     */             //   63: astore #4
/*     */             //   65: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   68: aload_1
/*     */             //   69: iconst_2
/*     */             //   70: aaload
/*     */             //   71: invokeinterface getBlockFromName : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   76: astore #5
/*     */             //   78: aload #5
/*     */             //   80: ifnull -> 96
/*     */             //   83: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   86: aload #5
/*     */             //   88: invokeinterface getIdFromBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)I
/*     */             //   93: ifgt -> 127
/*     */             //   96: aload_0
/*     */             //   97: new java/lang/StringBuilder
/*     */             //   100: dup
/*     */             //   101: invokespecial <init> : ()V
/*     */             //   104: ldc '§7Block §8'
/*     */             //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   109: aload_1
/*     */             //   110: iconst_2
/*     */             //   111: aaload
/*     */             //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   115: ldc '§7 does not exist!'
/*     */             //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   120: invokevirtual toString : ()Ljava/lang/String;
/*     */             //   123: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   126: return
/*     */             //   127: aload #5
/*     */             //   129: astore_3
/*     */             //   130: aload_3
/*     */             //   131: astore_2
/*     */             //   132: aload_2
/*     */             //   133: ifnull -> 152
/*     */             //   136: aload_0
/*     */             //   137: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;
/*     */             //   140: invokevirtual getXrayBlocks : ()Ljava/util/List;
/*     */             //   143: aload_2
/*     */             //   144: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */             //   149: ifeq -> 159
/*     */             //   152: aload_0
/*     */             //   153: ldc 'This block is already on the list.'
/*     */             //   155: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   158: return
/*     */             //   159: aload_0
/*     */             //   160: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;
/*     */             //   163: invokevirtual getXrayBlocks : ()Ljava/util/List;
/*     */             //   166: aload_2
/*     */             //   167: invokeinterface add : (Ljava/lang/Object;)Z
/*     */             //   172: pop
/*     */             //   173: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */             //   176: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */             //   179: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */             //   182: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */             //   185: getfield xrayConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */             //   188: invokevirtual saveConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */             //   191: aload_0
/*     */             //   192: new java/lang/StringBuilder
/*     */             //   195: dup
/*     */             //   196: invokespecial <init> : ()V
/*     */             //   199: ldc '§7Added block §8'
/*     */             //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   204: aload_2
/*     */             //   205: invokeinterface getLocalizedName : ()Ljava/lang/String;
/*     */             //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   213: ldc '§7.'
/*     */             //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   218: invokevirtual toString : ()Ljava/lang/String;
/*     */             //   221: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   224: aload_0
/*     */             //   225: invokevirtual playEdit : ()V
/*     */             //   228: goto -> 236
/*     */             //   231: astore_2
/*     */             //   232: aload_0
/*     */             //   233: invokevirtual chatSyntaxError : ()V
/*     */             //   236: return
/*     */             //   237: aload_0
/*     */             //   238: ldc 'xray add <block_id>'
/*     */             //   240: invokevirtual chatSyntax : (Ljava/lang/String;)V
/*     */             //   243: return
/*     */             //   244: aload_1
/*     */             //   245: iconst_1
/*     */             //   246: aaload
/*     */             //   247: ldc 'remove'
/*     */             //   249: iconst_1
/*     */             //   250: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */             //   253: ifeq -> 476
/*     */             //   256: aload_1
/*     */             //   257: arraylength
/*     */             //   258: iconst_2
/*     */             //   259: if_icmple -> 469
/*     */             //   262: nop
/*     */             //   263: nop
/*     */             //   264: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   267: aload_1
/*     */             //   268: iconst_2
/*     */             //   269: aaload
/*     */             //   270: astore_3
/*     */             //   271: astore #8
/*     */             //   273: iconst_0
/*     */             //   274: istore #4
/*     */             //   276: aload_3
/*     */             //   277: invokestatic parseInt : (Ljava/lang/String;)I
/*     */             //   280: istore #9
/*     */             //   282: aload #8
/*     */             //   284: iload #9
/*     */             //   286: invokeinterface getBlockById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   291: astore_3
/*     */             //   292: goto -> 362
/*     */             //   295: astore #4
/*     */             //   297: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   300: aload_1
/*     */             //   301: iconst_2
/*     */             //   302: aaload
/*     */             //   303: invokeinterface getBlockFromName : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   308: astore #5
/*     */             //   310: aload #5
/*     */             //   312: ifnull -> 328
/*     */             //   315: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   318: aload #5
/*     */             //   320: invokeinterface getIdFromBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)I
/*     */             //   325: ifgt -> 359
/*     */             //   328: aload_0
/*     */             //   329: new java/lang/StringBuilder
/*     */             //   332: dup
/*     */             //   333: invokespecial <init> : ()V
/*     */             //   336: ldc '§7Block §8'
/*     */             //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   341: aload_1
/*     */             //   342: iconst_2
/*     */             //   343: aaload
/*     */             //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   347: ldc '§7 does not exist!'
/*     */             //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   352: invokevirtual toString : ()Ljava/lang/String;
/*     */             //   355: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   358: return
/*     */             //   359: aload #5
/*     */             //   361: astore_3
/*     */             //   362: aload_3
/*     */             //   363: astore_2
/*     */             //   364: aload_2
/*     */             //   365: ifnull -> 384
/*     */             //   368: aload_0
/*     */             //   369: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;
/*     */             //   372: invokevirtual getXrayBlocks : ()Ljava/util/List;
/*     */             //   375: aload_2
/*     */             //   376: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */             //   381: ifne -> 391
/*     */             //   384: aload_0
/*     */             //   385: ldc 'This block is not on the list.'
/*     */             //   387: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   390: return
/*     */             //   391: aload_0
/*     */             //   392: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;
/*     */             //   395: invokevirtual getXrayBlocks : ()Ljava/util/List;
/*     */             //   398: aload_2
/*     */             //   399: invokeinterface remove : (Ljava/lang/Object;)Z
/*     */             //   404: pop
/*     */             //   405: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */             //   408: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */             //   411: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */             //   414: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */             //   417: getfield xrayConfig : Lnet/ccbluex/liquidbounce/file/FileConfig;
/*     */             //   420: invokevirtual saveConfig : (Lnet/ccbluex/liquidbounce/file/FileConfig;)V
/*     */             //   423: aload_0
/*     */             //   424: new java/lang/StringBuilder
/*     */             //   427: dup
/*     */             //   428: invokespecial <init> : ()V
/*     */             //   431: ldc '§7Removed block §8'
/*     */             //   433: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   436: aload_2
/*     */             //   437: invokeinterface getLocalizedName : ()Ljava/lang/String;
/*     */             //   442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   445: ldc '§7.'
/*     */             //   447: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   450: invokevirtual toString : ()Ljava/lang/String;
/*     */             //   453: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   456: aload_0
/*     */             //   457: invokevirtual playEdit : ()V
/*     */             //   460: goto -> 468
/*     */             //   463: astore_2
/*     */             //   464: aload_0
/*     */             //   465: invokevirtual chatSyntaxError : ()V
/*     */             //   468: return
/*     */             //   469: aload_0
/*     */             //   470: ldc 'xray remove <block_id>'
/*     */             //   472: invokevirtual chatSyntax : (Ljava/lang/String;)V
/*     */             //   475: return
/*     */             //   476: aload_1
/*     */             //   477: iconst_1
/*     */             //   478: aaload
/*     */             //   479: ldc 'list'
/*     */             //   481: iconst_1
/*     */             //   482: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */             //   485: ifeq -> 597
/*     */             //   488: aload_0
/*     */             //   489: ldc '§8Xray blocks:'
/*     */             //   491: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   494: aload_0
/*     */             //   495: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay;
/*     */             //   498: invokevirtual getXrayBlocks : ()Ljava/util/List;
/*     */             //   501: checkcast java/lang/Iterable
/*     */             //   504: astore_2
/*     */             //   505: iconst_0
/*     */             //   506: istore_3
/*     */             //   507: aload_2
/*     */             //   508: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */             //   513: astore #4
/*     */             //   515: aload #4
/*     */             //   517: invokeinterface hasNext : ()Z
/*     */             //   522: ifeq -> 595
/*     */             //   525: aload #4
/*     */             //   527: invokeinterface next : ()Ljava/lang/Object;
/*     */             //   532: astore #5
/*     */             //   534: aload #5
/*     */             //   536: checkcast net/ccbluex/liquidbounce/api/minecraft/client/block/IBlock
/*     */             //   539: astore #6
/*     */             //   541: iconst_0
/*     */             //   542: istore #7
/*     */             //   544: aload_0
/*     */             //   545: new java/lang/StringBuilder
/*     */             //   548: dup
/*     */             //   549: invokespecial <init> : ()V
/*     */             //   552: ldc '§8'
/*     */             //   554: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   557: aload #6
/*     */             //   559: invokeinterface getLocalizedName : ()Ljava/lang/String;
/*     */             //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   567: ldc ' §7-§c '
/*     */             //   569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */             //   572: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */             //   575: aload #6
/*     */             //   577: invokeinterface getIdFromBlock : (Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)I
/*     */             //   582: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */             //   585: invokevirtual toString : ()Ljava/lang/String;
/*     */             //   588: invokevirtual chat : (Ljava/lang/String;)V
/*     */             //   591: nop
/*     */             //   592: goto -> 515
/*     */             //   595: nop
/*     */             //   596: return
/*     */             //   597: aload_0
/*     */             //   598: ldc 'xray <add, remove, list>'
/*     */             //   600: invokevirtual chatSyntax : (Ljava/lang/String;)V
/*     */             //   603: return
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #54	-> 6
/*     */             //   #55	-> 12
/*     */             //   #56	-> 24
/*     */             //   #57	-> 30
/*     */             //   #58	-> 31
/*     */             //   #59	-> 32
/*     */             //   #59	-> 54
/*     */             //   #60	-> 63
/*     */             //   #61	-> 65
/*     */             //   #63	-> 78
/*     */             //   #64	-> 96
/*     */             //   #65	-> 126
/*     */             //   #68	-> 127
/*     */             //   #58	-> 130
/*     */             //   #71	-> 132
/*     */             //   #72	-> 152
/*     */             //   #73	-> 158
/*     */             //   #76	-> 159
/*     */             //   #77	-> 173
/*     */             //   #78	-> 191
/*     */             //   #79	-> 224
/*     */             //   #80	-> 231
/*     */             //   #81	-> 232
/*     */             //   #82	-> 236
/*     */             //   #84	-> 236
/*     */             //   #87	-> 237
/*     */             //   #88	-> 243
/*     */             //   #91	-> 244
/*     */             //   #92	-> 256
/*     */             //   #93	-> 262
/*     */             //   #94	-> 263
/*     */             //   #95	-> 264
/*     */             //   #95	-> 286
/*     */             //   #96	-> 295
/*     */             //   #97	-> 297
/*     */             //   #99	-> 310
/*     */             //   #100	-> 328
/*     */             //   #101	-> 358
/*     */             //   #104	-> 359
/*     */             //   #94	-> 362
/*     */             //   #107	-> 364
/*     */             //   #108	-> 384
/*     */             //   #109	-> 390
/*     */             //   #112	-> 391
/*     */             //   #113	-> 405
/*     */             //   #114	-> 423
/*     */             //   #115	-> 456
/*     */             //   #116	-> 463
/*     */             //   #117	-> 464
/*     */             //   #118	-> 468
/*     */             //   #120	-> 468
/*     */             //   #122	-> 469
/*     */             //   #123	-> 475
/*     */             //   #126	-> 476
/*     */             //   #127	-> 488
/*     */             //   #128	-> 494
/*     */             //   #143	-> 507
/*     */             //   #128	-> 544
/*     */             //   #144	-> 595
/*     */             //   #129	-> 596
/*     */             //   #133	-> 597
/*     */             //   #134	-> 603
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   78	51	5	tmpBlock	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   65	65	4	exception	Ljava/lang/NumberFormatException;
/*     */             //   132	96	2	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   232	4	2	exception	Ljava/lang/NumberFormatException;
/*     */             //   310	51	5	b	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   297	65	4	exception	Ljava/lang/NumberFormatException;
/*     */             //   364	96	2	block	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   464	4	2	exception	Ljava/lang/NumberFormatException;
/*     */             //   541	50	6	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */             //   544	47	7	$i$a$-forEach-XRay$1$execute$1	I
/*     */             //   534	58	5	element$iv	Ljava/lang/Object;
/*     */             //   505	91	2	$this$forEach$iv	Ljava/lang/Iterable;
/*     */             //   507	89	3	$i$f$forEach	I
/*     */             //   0	604	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/XRay$1;
/*     */             //   0	604	1	args	[Ljava/lang/String;
/*     */             // Exception table:
/*     */             //   from	to	target	type
/*     */             //   30	228	231	java/lang/NumberFormatException
/*     */             //   31	60	63	java/lang/NumberFormatException
/*     */             //   262	460	463	java/lang/NumberFormatException
/*     */             //   263	292	295	java/lang/NumberFormatException
/*     */           }
/*     */         });
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
/*     */   @NotNull
/*     */   private final List<IBlock> xrayBlocks;
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
/*     */   @NotNull
/*     */   public final List<IBlock> getXrayBlocks() {
/*     */     return this.xrayBlocks;
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
/*     */   public void onToggle(boolean state) {
/* 139 */     MinecraftInstance.mc.getRenderGlobal().loadRenderers();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\XRay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */