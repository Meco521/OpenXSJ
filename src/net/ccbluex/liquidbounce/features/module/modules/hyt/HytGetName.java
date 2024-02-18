/*     */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*     */ import kotlin.Metadata;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "HytGetName", description = "fix by cool", category = ModuleCategory.HYT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\002J\b\020\007\032\0020\006H\026J\020\020\b\032\0020\0062\006\020\t\032\0020\nH\007J\022\020\013\032\0020\0062\b\020\t\032\004\030\0010\fH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytGetName;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "mode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "clearAll", "", "onDisable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*     */ public final class HytGetName extends Module {
/*  17 */   private final ListValue mode = new ListValue("GetNameMode", new String[] { "4V4/1V1", "32/64", "16V16" }, "4V4/1V1");
/*     */   
/*     */   public void onDisable() {
/*  20 */     clearAll();
/*  21 */     super.onDisable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   10: astore_2
/*     */     //   11: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   14: aload_2
/*     */     //   15: invokeinterface isSPacketChat : (Ljava/lang/Object;)Z
/*     */     //   20: ifeq -> 748
/*     */     //   23: aload_0
/*     */     //   24: getfield mode : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   27: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   30: checkcast java/lang/String
/*     */     //   33: astore_3
/*     */     //   34: iconst_0
/*     */     //   35: istore #4
/*     */     //   37: aload_3
/*     */     //   38: dup
/*     */     //   39: ifnonnull -> 52
/*     */     //   42: new kotlin/TypeCastException
/*     */     //   45: dup
/*     */     //   46: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   48: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   51: athrow
/*     */     //   52: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   55: dup
/*     */     //   56: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   58: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   61: astore_3
/*     */     //   62: aload_3
/*     */     //   63: invokevirtual hashCode : ()I
/*     */     //   66: lookupswitch default -> 748, -1961702257 -> 124, 46976214 -> 112, 48636014 -> 100
/*     */     //   100: aload_3
/*     */     //   101: ldc '32/64'
/*     */     //   103: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   106: ifeq -> 748
/*     */     //   109: goto -> 133
/*     */     //   112: aload_3
/*     */     //   113: ldc '16v16'
/*     */     //   115: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   118: ifeq -> 748
/*     */     //   121: goto -> 442
/*     */     //   124: aload_3
/*     */     //   125: ldc '4v4/1v1'
/*     */     //   127: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   130: ifeq -> 748
/*     */     //   133: ldc '杀死了 (.*?)\('
/*     */     //   135: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   138: aload_2
/*     */     //   139: invokeinterface asSPacketChat : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;
/*     */     //   144: invokeinterface getChatComponent : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   149: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   154: checkcast java/lang/CharSequence
/*     */     //   157: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   160: astore #4
/*     */     //   162: ldc '起床战争>> (.*?) (\((((.*?)死了!)))'
/*     */     //   164: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   167: aload_2
/*     */     //   168: invokeinterface asSPacketChat : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;
/*     */     //   173: invokeinterface getChatComponent : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   178: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   183: checkcast java/lang/CharSequence
/*     */     //   186: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   189: astore #5
/*     */     //   191: aload #4
/*     */     //   193: invokevirtual find : ()Z
/*     */     //   196: ifeq -> 315
/*     */     //   199: aload #4
/*     */     //   201: iconst_1
/*     */     //   202: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   205: dup
/*     */     //   206: ldc 'matcher.group(1)'
/*     */     //   208: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   211: astore #7
/*     */     //   213: iconst_0
/*     */     //   214: istore #8
/*     */     //   216: aload #7
/*     */     //   218: dup
/*     */     //   219: ifnonnull -> 232
/*     */     //   222: new kotlin/TypeCastException
/*     */     //   225: dup
/*     */     //   226: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   228: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   231: athrow
/*     */     //   232: checkcast java/lang/CharSequence
/*     */     //   235: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   238: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   241: astore #6
/*     */     //   243: aload #6
/*     */     //   245: ldc ''
/*     */     //   247: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   250: iconst_1
/*     */     //   251: ixor
/*     */     //   252: ifeq -> 315
/*     */     //   255: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   258: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   261: getfield friendsConfig : Lnet/ccbluex/liquidbounce/file/configs/FriendsConfig;
/*     */     //   264: aload #6
/*     */     //   266: invokevirtual addFriend : (Ljava/lang/String;)Z
/*     */     //   269: pop
/*     */     //   270: new java/lang/StringBuilder
/*     */     //   273: dup
/*     */     //   274: invokespecial <init> : ()V
/*     */     //   277: ldc '§bXSJClient§7>> §f添加无敌人：§a'
/*     */     //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   282: aload #6
/*     */     //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   287: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   290: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   293: new java/lang/Thread
/*     */     //   296: dup
/*     */     //   297: new net/ccbluex/liquidbounce/features/module/modules/hyt/HytGetName$onPacket$1
/*     */     //   300: dup
/*     */     //   301: aload #6
/*     */     //   303: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   306: checkcast java/lang/Runnable
/*     */     //   309: invokespecial <init> : (Ljava/lang/Runnable;)V
/*     */     //   312: invokevirtual start : ()V
/*     */     //   315: aload #5
/*     */     //   317: invokevirtual find : ()Z
/*     */     //   320: ifeq -> 748
/*     */     //   323: aload #5
/*     */     //   325: iconst_1
/*     */     //   326: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   329: dup
/*     */     //   330: ldc 'matcher2.group(1)'
/*     */     //   332: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   335: astore #7
/*     */     //   337: iconst_0
/*     */     //   338: istore #8
/*     */     //   340: aload #7
/*     */     //   342: dup
/*     */     //   343: ifnonnull -> 356
/*     */     //   346: new kotlin/TypeCastException
/*     */     //   349: dup
/*     */     //   350: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   352: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   355: athrow
/*     */     //   356: checkcast java/lang/CharSequence
/*     */     //   359: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   362: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   365: astore #6
/*     */     //   367: aload #6
/*     */     //   369: ldc ''
/*     */     //   371: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   374: iconst_1
/*     */     //   375: ixor
/*     */     //   376: ifeq -> 748
/*     */     //   379: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   382: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   385: getfield friendsConfig : Lnet/ccbluex/liquidbounce/file/configs/FriendsConfig;
/*     */     //   388: aload #6
/*     */     //   390: invokevirtual addFriend : (Ljava/lang/String;)Z
/*     */     //   393: pop
/*     */     //   394: new java/lang/StringBuilder
/*     */     //   397: dup
/*     */     //   398: invokespecial <init> : ()V
/*     */     //   401: ldc '§bXSJtClient§7>> §f添加无敌人：§a'
/*     */     //   403: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   406: aload #6
/*     */     //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   411: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   414: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   417: new java/lang/Thread
/*     */     //   420: dup
/*     */     //   421: new net/ccbluex/liquidbounce/features/module/modules/hyt/HytGetName$onPacket$2
/*     */     //   424: dup
/*     */     //   425: aload #6
/*     */     //   427: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   430: checkcast java/lang/Runnable
/*     */     //   433: invokespecial <init> : (Ljava/lang/Runnable;)V
/*     */     //   436: invokevirtual start : ()V
/*     */     //   439: goto -> 748
/*     */     //   442: ldc '击败了 (.*?)!'
/*     */     //   444: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   447: aload_2
/*     */     //   448: invokeinterface asSPacketChat : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;
/*     */     //   453: invokeinterface getChatComponent : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   458: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   463: checkcast java/lang/CharSequence
/*     */     //   466: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   469: astore #4
/*     */     //   471: ldc '玩家 (.*?)死了！'
/*     */     //   473: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
/*     */     //   476: aload_2
/*     */     //   477: invokeinterface asSPacketChat : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;
/*     */     //   482: invokeinterface getChatComponent : ()Lnet/minecraft/util/text/ITextComponent;
/*     */     //   487: invokeinterface func_150260_c : ()Ljava/lang/String;
/*     */     //   492: checkcast java/lang/CharSequence
/*     */     //   495: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   498: astore #5
/*     */     //   500: aload #4
/*     */     //   502: invokevirtual find : ()Z
/*     */     //   505: ifeq -> 624
/*     */     //   508: aload #4
/*     */     //   510: iconst_1
/*     */     //   511: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   514: dup
/*     */     //   515: ldc 'matcher.group(1)'
/*     */     //   517: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   520: astore #7
/*     */     //   522: iconst_0
/*     */     //   523: istore #8
/*     */     //   525: aload #7
/*     */     //   527: dup
/*     */     //   528: ifnonnull -> 541
/*     */     //   531: new kotlin/TypeCastException
/*     */     //   534: dup
/*     */     //   535: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   537: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   540: athrow
/*     */     //   541: checkcast java/lang/CharSequence
/*     */     //   544: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   547: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   550: astore #6
/*     */     //   552: aload #6
/*     */     //   554: ldc ''
/*     */     //   556: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   559: iconst_1
/*     */     //   560: ixor
/*     */     //   561: ifeq -> 624
/*     */     //   564: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   567: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   570: getfield friendsConfig : Lnet/ccbluex/liquidbounce/file/configs/FriendsConfig;
/*     */     //   573: aload #6
/*     */     //   575: invokevirtual addFriend : (Ljava/lang/String;)Z
/*     */     //   578: pop
/*     */     //   579: new java/lang/StringBuilder
/*     */     //   582: dup
/*     */     //   583: invokespecial <init> : ()V
/*     */     //   586: ldc '§bXSJtClient§7>> §f添加无敌人：§a'
/*     */     //   588: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   591: aload #6
/*     */     //   593: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   596: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   599: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   602: new java/lang/Thread
/*     */     //   605: dup
/*     */     //   606: new net/ccbluex/liquidbounce/features/module/modules/hyt/HytGetName$onPacket$3
/*     */     //   609: dup
/*     */     //   610: aload #6
/*     */     //   612: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   615: checkcast java/lang/Runnable
/*     */     //   618: invokespecial <init> : (Ljava/lang/Runnable;)V
/*     */     //   621: invokevirtual start : ()V
/*     */     //   624: aload #5
/*     */     //   626: invokevirtual find : ()Z
/*     */     //   629: ifeq -> 748
/*     */     //   632: aload #5
/*     */     //   634: iconst_1
/*     */     //   635: invokevirtual group : (I)Ljava/lang/String;
/*     */     //   638: dup
/*     */     //   639: ldc 'matcher2.group(1)'
/*     */     //   641: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   644: astore #7
/*     */     //   646: iconst_0
/*     */     //   647: istore #8
/*     */     //   649: aload #7
/*     */     //   651: dup
/*     */     //   652: ifnonnull -> 665
/*     */     //   655: new kotlin/TypeCastException
/*     */     //   658: dup
/*     */     //   659: ldc 'null cannot be cast to non-null type kotlin.CharSequence'
/*     */     //   661: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   664: athrow
/*     */     //   665: checkcast java/lang/CharSequence
/*     */     //   668: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
/*     */     //   671: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   674: astore #6
/*     */     //   676: aload #6
/*     */     //   678: ldc ''
/*     */     //   680: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   683: iconst_1
/*     */     //   684: ixor
/*     */     //   685: ifeq -> 748
/*     */     //   688: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   691: invokevirtual getFileManager : ()Lnet/ccbluex/liquidbounce/file/FileManager;
/*     */     //   694: getfield friendsConfig : Lnet/ccbluex/liquidbounce/file/configs/FriendsConfig;
/*     */     //   697: aload #6
/*     */     //   699: invokevirtual addFriend : (Ljava/lang/String;)Z
/*     */     //   702: pop
/*     */     //   703: new java/lang/StringBuilder
/*     */     //   706: dup
/*     */     //   707: invokespecial <init> : ()V
/*     */     //   710: ldc '§bXSJClient§7>> §f添加无敌人：§a'
/*     */     //   712: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   715: aload #6
/*     */     //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   720: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   723: invokestatic displayChatMessage : (Ljava/lang/String;)V
/*     */     //   726: new java/lang/Thread
/*     */     //   729: dup
/*     */     //   730: new net/ccbluex/liquidbounce/features/module/modules/hyt/HytGetName$onPacket$4
/*     */     //   733: dup
/*     */     //   734: aload #6
/*     */     //   736: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   739: checkcast java/lang/Runnable
/*     */     //   742: invokespecial <init> : (Ljava/lang/Runnable;)V
/*     */     //   745: invokevirtual start : ()V
/*     */     //   748: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #26	-> 6
/*     */     //   #27	-> 11
/*     */     //   #28	-> 23
/*     */     //   #29	-> 100
/*     */     //   #65	-> 112
/*     */     //   #29	-> 124
/*     */     //   #30	-> 133
/*     */     //   #31	-> 162
/*     */     //   #32	-> 191
/*     */     //   #33	-> 199
/*     */     //   #33	-> 241
/*     */     //   #34	-> 243
/*     */     //   #35	-> 255
/*     */     //   #36	-> 270
/*     */     //   #37	-> 293
/*     */     //   #45	-> 293
/*     */     //   #37	-> 293
/*     */     //   #45	-> 312
/*     */     //   #48	-> 315
/*     */     //   #49	-> 323
/*     */     //   #49	-> 365
/*     */     //   #50	-> 367
/*     */     //   #51	-> 379
/*     */     //   #52	-> 394
/*     */     //   #53	-> 417
/*     */     //   #61	-> 417
/*     */     //   #53	-> 417
/*     */     //   #61	-> 436
/*     */     //   #66	-> 442
/*     */     //   #67	-> 471
/*     */     //   #68	-> 500
/*     */     //   #69	-> 508
/*     */     //   #69	-> 550
/*     */     //   #70	-> 552
/*     */     //   #71	-> 564
/*     */     //   #72	-> 579
/*     */     //   #73	-> 602
/*     */     //   #81	-> 602
/*     */     //   #73	-> 602
/*     */     //   #81	-> 621
/*     */     //   #84	-> 624
/*     */     //   #85	-> 632
/*     */     //   #85	-> 674
/*     */     //   #86	-> 676
/*     */     //   #87	-> 688
/*     */     //   #88	-> 703
/*     */     //   #89	-> 726
/*     */     //   #97	-> 726
/*     */     //   #89	-> 726
/*     */     //   #97	-> 745
/*     */     //   #101	-> 748
/*     */     //   #103	-> 748
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   243	72	6	name	Ljava/lang/String;
/*     */     //   367	72	6	name	Ljava/lang/String;
/*     */     //   191	248	5	matcher2	Ljava/util/regex/Matcher;
/*     */     //   162	277	4	matcher	Ljava/util/regex/Matcher;
/*     */     //   552	72	6	name	Ljava/lang/String;
/*     */     //   676	72	6	name	Ljava/lang/String;
/*     */     //   500	248	5	matcher2	Ljava/util/regex/Matcher;
/*     */     //   471	277	4	matcher	Ljava/util/regex/Matcher;
/*     */     //   11	738	2	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   0	749	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytGetName;
/*     */     //   0	749	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*     */   static final class HytGetName$onPacket$1
/*     */     implements Runnable
/*     */   {
/*     */     public final void run() {
/*     */       try {
/*  39 */         Thread.sleep(5000L);
/*  40 */         (Retreat.INSTANCE.getFileManager()).friendsConfig.removeFriend(this.$name);
/*  41 */         ClientUtils.displayChatMessage("§bXSJtClient§7>> §f删除无敌人：§a" + this.$name);
/*  42 */       } catch (InterruptedException ex) {
/*  43 */         ex.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*     */     HytGetName$onPacket$1(String param1String) {}
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*     */   static final class HytGetName$onPacket$2
/*     */     implements Runnable {
/*     */     public final void run() {
/*     */       try {
/*  55 */         Thread.sleep(5000L);
/*  56 */         (Retreat.INSTANCE.getFileManager()).friendsConfig.removeFriend(this.$name);
/*  57 */         ClientUtils.displayChatMessage("§bXSJtClient§7>> §f删除无敌人：§a" + this.$name);
/*  58 */       } catch (InterruptedException ex) {
/*  59 */         ex.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     HytGetName$onPacket$2(String param1String) {}
/*     */   }
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*     */   static final class HytGetName$onPacket$3
/*     */     implements Runnable
/*     */   {
/*     */     public final void run() {
/*     */       try {
/*  75 */         Thread.sleep(10000L);
/*  76 */         (Retreat.INSTANCE.getFileManager()).friendsConfig.removeFriend(this.$name);
/*  77 */         ClientUtils.displayChatMessage("§bXSJtClient§7>> §f删除无敌人：§a" + this.$name);
/*  78 */       } catch (InterruptedException ex) {
/*  79 */         ex.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*     */     HytGetName$onPacket$3(String param1String) {}
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*     */   static final class HytGetName$onPacket$4
/*     */     implements Runnable {
/*     */     public final void run() {
/*     */       try {
/*  91 */         Thread.sleep(10000L);
/*  92 */         (Retreat.INSTANCE.getFileManager()).friendsConfig.removeFriend(this.$name);
/*  93 */         ClientUtils.displayChatMessage("§bXSJClient§7>> §f删除无敌人：§a" + this.$name);
/*  94 */       } catch (InterruptedException ex) {
/*  95 */         ex.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     HytGetName$onPacket$4(String param1String) {}
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onWorld(@Nullable WorldEvent event) {
/* 106 */     clearAll();
/*     */   }
/*     */   private final void clearAll() {
/* 109 */     (Retreat.INSTANCE.getFileManager()).friendsConfig.clearFriends();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytGetName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */