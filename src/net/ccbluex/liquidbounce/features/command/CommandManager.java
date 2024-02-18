/*     */ package net.ccbluex.liquidbounce.features.command;
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\003\n\002\020\021\n\002\020\016\n\002\b\006\n\002\020\f\n\002\b\005\n\002\020\013\n\002\b\002\n\002\020\002\n\002\b\t\030\0002\0020\001B\005¢\006\002\020\002J\016\020\026\032\0020\0272\006\020\030\032\0020\nJ\016\020\031\032\0020\0322\006\020\030\032\0020\nJ\020\020\033\032\004\030\0010\0052\006\020\034\032\0020\nJ\035\020\035\032\n\022\004\022\0020\n\030\0010\t2\006\020\030\032\0020\nH\002¢\006\002\020\036J\016\020\037\032\0020\0272\006\020 \032\0020\005J\006\020!\032\0020\032J\020\020\"\032\0020\0272\b\020 \032\004\030\0010\005R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007R\"\020\b\032\b\022\004\022\0020\n0\tX\016¢\006\020\n\002\020\017\032\004\b\013\020\f\"\004\b\r\020\016R\032\020\020\032\0020\021X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/CommandManager;", "", "()V", "commands", "", "Lnet/ccbluex/liquidbounce/features/command/Command;", "getCommands", "()Ljava/util/List;", "latestAutoComplete", "", "", "getLatestAutoComplete", "()[Ljava/lang/String;", "setLatestAutoComplete", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "prefix", "", "getPrefix", "()C", "setPrefix", "(C)V", "autoComplete", "", "input", "executeCommands", "", "getCommand", "name", "getCompletions", "(Ljava/lang/String;)[Ljava/lang/String;", "registerCommand", "command", "registerCommands", "unregisterCommand", "XSJClient"})
/*     */ public final class CommandManager {
/*     */   @NotNull
/*     */   private final List<Command> commands;
/*     */   
/*   7 */   public CommandManager() { CommandManager commandManager = this; boolean bool = false; ArrayList<Command> arrayList = new ArrayList();
/*   8 */     commandManager = this; String[] arrayOfString = new String[0];
/*     */     
/*  10 */     this.prefix = '.'; } @NotNull private String[] latestAutoComplete; private char prefix; @NotNull public final List<Command> getCommands() { return this.commands; } @NotNull public final String[] getLatestAutoComplete() { return this.latestAutoComplete; } public final void setLatestAutoComplete(@NotNull String[] <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.latestAutoComplete = <set-?>; } public final char getPrefix() { return this.prefix; } public final void setPrefix(char <set-?>) { this.prefix = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void registerCommands() {
/*  16 */     registerCommand((Command)new BindCommand());
/*  17 */     registerCommand((Command)new VClipCommand());
/*  18 */     registerCommand((Command)new HClipCommand());
/*  19 */     registerCommand((Command)new HelpCommand());
/*  20 */     registerCommand((Command)new SayCommand());
/*  21 */     registerCommand((Command)new FriendCommand());
/*  22 */     registerCommand((Command)new ServerInfoCommand());
/*  23 */     registerCommand((Command)new ToggleCommand());
/*  24 */     registerCommand((Command)new TargetCommand());
/*  25 */     registerCommand((Command)new BindsCommand());
/*  26 */     registerCommand((Command)new PingCommand());
/*  27 */     registerCommand((Command)new RenameCommand());
/*  28 */     registerCommand((Command)new ReloadCommand());
/*  29 */     registerCommand((Command)new ScriptManagerCommand());
/*  30 */     registerCommand((Command)new RemoteViewCommand());
/*  31 */     registerCommand((Command)new PrefixCommand());
/*  32 */     registerCommand((Command)new HideCommand());
/*  33 */     registerCommand((Command)new ConfigCommand());
/*  34 */     registerCommand((Command)new HudCommand());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void executeCommands(@NotNull String input) {
/*  41 */     Intrinsics.checkParameterIsNotNull(input, "input"); for (Command command : this.commands) {
/*  42 */       Collection $this$toTypedArray$iv = StringsKt.split$default(input, new String[] { " " }, false, 0, 6, null); int $i$f$toTypedArray = 0;
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
/*     */ 
/*     */ 
/*     */       
/* 130 */       Collection thisCollection$iv = $this$toTypedArray$iv;
/* 131 */       if (thisCollection$iv.toArray((Object[])new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  String[] args = (String[])thisCollection$iv.toArray((Object[])new String[0]);
/*     */       if (StringsKt.equals(args[0], String.valueOf(this.prefix) + command.getCommand(), true)) {
/*     */         command.execute(args);
/*     */         return;
/*     */       } 
/*     */       String[] arrayOfString1;
/*     */       int i;
/*     */       for (arrayOfString1 = command.getAlias(), i = arrayOfString1.length, $i$f$toTypedArray = 0; $i$f$toTypedArray < i; ) {
/*     */         String alias = arrayOfString1[$i$f$toTypedArray];
/*     */         if (!StringsKt.equals(args[0], String.valueOf(this.prefix) + alias, true)) {
/*     */           $i$f$toTypedArray++;
/*     */           continue;
/*     */         } 
/*     */         command.execute(args);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     ClientUtils.displayChatMessage("§cCommand not found. Type " + this.prefix + "help to view all commands.");
/*     */   }
/*     */   
/*     */   public final boolean autoComplete(@NotNull String input) {
/*     */     Intrinsics.checkParameterIsNotNull(input, "input");
/*     */     if (getCompletions(input) == null) {
/*     */       getCompletions(input);
/*     */       CommandManager commandManager = this;
/*     */       String[] arrayOfString = new String[0];
/*     */     } 
/*     */     commandManager.latestAutoComplete = arrayOfString;
/*     */     if (StringsKt.startsWith$default(input, this.prefix, false, 2, null)) {
/*     */       String[] arrayOfString1 = this.latestAutoComplete;
/*     */       boolean bool1 = false;
/*     */       String[] arrayOfString2 = arrayOfString1;
/*     */       boolean bool2 = false;
/*     */       if (!((arrayOfString2.length == 0) ? 1 : 0));
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private final String[] getCompletions(String input) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: checkcast java/lang/CharSequence
/*     */     //   4: astore_2
/*     */     //   5: iconst_0
/*     */     //   6: istore_3
/*     */     //   7: aload_2
/*     */     //   8: invokeinterface length : ()I
/*     */     //   13: ifle -> 20
/*     */     //   16: iconst_1
/*     */     //   17: goto -> 21
/*     */     //   20: iconst_0
/*     */     //   21: ifeq -> 761
/*     */     //   24: aload_1
/*     */     //   25: astore_2
/*     */     //   26: iconst_0
/*     */     //   27: istore_3
/*     */     //   28: aload_2
/*     */     //   29: dup
/*     */     //   30: ifnonnull -> 43
/*     */     //   33: new kotlin/TypeCastException
/*     */     //   36: dup
/*     */     //   37: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   39: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   42: athrow
/*     */     //   43: invokevirtual toCharArray : ()[C
/*     */     //   46: dup
/*     */     //   47: ldc '(this as java.lang.String).toCharArray()'
/*     */     //   49: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   52: iconst_0
/*     */     //   53: caload
/*     */     //   54: aload_0
/*     */     //   55: getfield prefix : C
/*     */     //   58: if_icmpne -> 761
/*     */     //   61: aload_1
/*     */     //   62: checkcast java/lang/CharSequence
/*     */     //   65: iconst_1
/*     */     //   66: anewarray java/lang/String
/*     */     //   69: dup
/*     */     //   70: iconst_0
/*     */     //   71: ldc ' '
/*     */     //   73: aastore
/*     */     //   74: iconst_0
/*     */     //   75: iconst_0
/*     */     //   76: bipush #6
/*     */     //   78: aconst_null
/*     */     //   79: invokestatic split$default : (Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
/*     */     //   82: astore_2
/*     */     //   83: aload_2
/*     */     //   84: invokeinterface size : ()I
/*     */     //   89: iconst_1
/*     */     //   90: if_icmple -> 277
/*     */     //   93: aload_0
/*     */     //   94: aload_2
/*     */     //   95: iconst_0
/*     */     //   96: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   101: checkcast java/lang/String
/*     */     //   104: astore #4
/*     */     //   106: iconst_1
/*     */     //   107: istore #5
/*     */     //   109: astore #22
/*     */     //   111: iconst_0
/*     */     //   112: istore #6
/*     */     //   114: aload #4
/*     */     //   116: dup
/*     */     //   117: ifnonnull -> 130
/*     */     //   120: new kotlin/TypeCastException
/*     */     //   123: dup
/*     */     //   124: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   126: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   129: athrow
/*     */     //   130: iload #5
/*     */     //   132: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   135: dup
/*     */     //   136: ldc_w '(this as java.lang.String).substring(startIndex)'
/*     */     //   139: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   142: astore #23
/*     */     //   144: aload #22
/*     */     //   146: aload #23
/*     */     //   148: invokevirtual getCommand : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/features/command/Command;
/*     */     //   151: astore_3
/*     */     //   152: aload_3
/*     */     //   153: dup
/*     */     //   154: ifnull -> 219
/*     */     //   157: aload_2
/*     */     //   158: checkcast java/lang/Iterable
/*     */     //   161: iconst_1
/*     */     //   162: invokestatic drop : (Ljava/lang/Iterable;I)Ljava/util/List;
/*     */     //   165: checkcast java/util/Collection
/*     */     //   168: astore #5
/*     */     //   170: astore #22
/*     */     //   172: iconst_0
/*     */     //   173: istore #6
/*     */     //   175: aload #5
/*     */     //   177: astore #7
/*     */     //   179: aload #7
/*     */     //   181: iconst_0
/*     */     //   182: anewarray java/lang/String
/*     */     //   185: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   190: dup
/*     */     //   191: ifnonnull -> 204
/*     */     //   194: new kotlin/TypeCastException
/*     */     //   197: dup
/*     */     //   198: ldc 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   200: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   203: athrow
/*     */     //   204: astore #23
/*     */     //   206: aload #22
/*     */     //   208: aload #23
/*     */     //   210: checkcast [Ljava/lang/String;
/*     */     //   213: invokevirtual tabComplete : ([Ljava/lang/String;)Ljava/util/List;
/*     */     //   216: goto -> 221
/*     */     //   219: pop
/*     */     //   220: aconst_null
/*     */     //   221: astore #4
/*     */     //   223: aload #4
/*     */     //   225: dup
/*     */     //   226: ifnull -> 272
/*     */     //   229: checkcast java/util/Collection
/*     */     //   232: astore #5
/*     */     //   234: iconst_0
/*     */     //   235: istore #6
/*     */     //   237: aload #5
/*     */     //   239: astore #7
/*     */     //   241: aload #7
/*     */     //   243: iconst_0
/*     */     //   244: anewarray java/lang/String
/*     */     //   247: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   252: dup
/*     */     //   253: ifnonnull -> 266
/*     */     //   256: new kotlin/TypeCastException
/*     */     //   259: dup
/*     */     //   260: ldc 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   262: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   265: athrow
/*     */     //   266: checkcast [Ljava/lang/String;
/*     */     //   269: goto -> 760
/*     */     //   272: pop
/*     */     //   273: aconst_null
/*     */     //   274: goto -> 760
/*     */     //   277: aload_1
/*     */     //   278: astore #4
/*     */     //   280: iconst_1
/*     */     //   281: istore #5
/*     */     //   283: iconst_0
/*     */     //   284: istore #6
/*     */     //   286: aload #4
/*     */     //   288: dup
/*     */     //   289: ifnonnull -> 302
/*     */     //   292: new kotlin/TypeCastException
/*     */     //   295: dup
/*     */     //   296: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   298: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   301: athrow
/*     */     //   302: iload #5
/*     */     //   304: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   307: dup
/*     */     //   308: ldc_w '(this as java.lang.String).substring(startIndex)'
/*     */     //   311: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   314: astore_3
/*     */     //   315: aload_0
/*     */     //   316: getfield commands : Ljava/util/List;
/*     */     //   319: checkcast java/lang/Iterable
/*     */     //   322: astore #4
/*     */     //   324: iconst_0
/*     */     //   325: istore #5
/*     */     //   327: aload #4
/*     */     //   329: astore #6
/*     */     //   331: new java/util/ArrayList
/*     */     //   334: dup
/*     */     //   335: invokespecial <init> : ()V
/*     */     //   338: checkcast java/util/Collection
/*     */     //   341: astore #7
/*     */     //   343: iconst_0
/*     */     //   344: istore #8
/*     */     //   346: aload #6
/*     */     //   348: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   353: astore #9
/*     */     //   355: aload #9
/*     */     //   357: invokeinterface hasNext : ()Z
/*     */     //   362: ifeq -> 485
/*     */     //   365: aload #9
/*     */     //   367: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   372: astore #10
/*     */     //   374: aload #10
/*     */     //   376: checkcast net/ccbluex/liquidbounce/features/command/Command
/*     */     //   379: astore #11
/*     */     //   381: iconst_0
/*     */     //   382: istore #12
/*     */     //   384: aload #11
/*     */     //   386: invokevirtual getCommand : ()Ljava/lang/String;
/*     */     //   389: aload_3
/*     */     //   390: iconst_1
/*     */     //   391: invokestatic startsWith : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   394: ifne -> 464
/*     */     //   397: aload #11
/*     */     //   399: invokevirtual getAlias : ()[Ljava/lang/String;
/*     */     //   402: astore #13
/*     */     //   404: iconst_0
/*     */     //   405: istore #14
/*     */     //   407: aload #13
/*     */     //   409: astore #15
/*     */     //   411: aload #15
/*     */     //   413: arraylength
/*     */     //   414: istore #16
/*     */     //   416: iconst_0
/*     */     //   417: istore #17
/*     */     //   419: iload #17
/*     */     //   421: iload #16
/*     */     //   423: if_icmpge -> 460
/*     */     //   426: aload #15
/*     */     //   428: iload #17
/*     */     //   430: aaload
/*     */     //   431: astore #18
/*     */     //   433: aload #18
/*     */     //   435: astore #19
/*     */     //   437: iconst_0
/*     */     //   438: istore #20
/*     */     //   440: aload #19
/*     */     //   442: aload_3
/*     */     //   443: iconst_1
/*     */     //   444: invokestatic startsWith : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   447: ifeq -> 454
/*     */     //   450: iconst_1
/*     */     //   451: goto -> 461
/*     */     //   454: iinc #17, 1
/*     */     //   457: goto -> 419
/*     */     //   460: iconst_0
/*     */     //   461: ifeq -> 468
/*     */     //   464: iconst_1
/*     */     //   465: goto -> 469
/*     */     //   468: iconst_0
/*     */     //   469: ifeq -> 355
/*     */     //   472: aload #7
/*     */     //   474: aload #10
/*     */     //   476: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   481: pop
/*     */     //   482: goto -> 355
/*     */     //   485: aload #7
/*     */     //   487: checkcast java/util/List
/*     */     //   490: checkcast java/lang/Iterable
/*     */     //   493: astore #4
/*     */     //   495: iconst_0
/*     */     //   496: istore #5
/*     */     //   498: aload #4
/*     */     //   500: astore #6
/*     */     //   502: new java/util/ArrayList
/*     */     //   505: dup
/*     */     //   506: aload #4
/*     */     //   508: bipush #10
/*     */     //   510: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
/*     */     //   513: invokespecial <init> : (I)V
/*     */     //   516: checkcast java/util/Collection
/*     */     //   519: astore #7
/*     */     //   521: iconst_0
/*     */     //   522: istore #8
/*     */     //   524: aload #6
/*     */     //   526: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   531: astore #9
/*     */     //   533: aload #9
/*     */     //   535: invokeinterface hasNext : ()Z
/*     */     //   540: ifeq -> 715
/*     */     //   543: aload #9
/*     */     //   545: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   550: astore #10
/*     */     //   552: aload #7
/*     */     //   554: aload #10
/*     */     //   556: checkcast net/ccbluex/liquidbounce/features/command/Command
/*     */     //   559: astore #11
/*     */     //   561: astore #22
/*     */     //   563: iconst_0
/*     */     //   564: istore #12
/*     */     //   566: aload #11
/*     */     //   568: invokevirtual getCommand : ()Ljava/lang/String;
/*     */     //   571: aload_3
/*     */     //   572: iconst_1
/*     */     //   573: invokestatic startsWith : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   576: ifeq -> 587
/*     */     //   579: aload #11
/*     */     //   581: invokevirtual getCommand : ()Ljava/lang/String;
/*     */     //   584: goto -> 665
/*     */     //   587: aload #11
/*     */     //   589: invokevirtual getAlias : ()[Ljava/lang/String;
/*     */     //   592: astore #13
/*     */     //   594: iconst_0
/*     */     //   595: istore #14
/*     */     //   597: aload #13
/*     */     //   599: astore #15
/*     */     //   601: aload #15
/*     */     //   603: arraylength
/*     */     //   604: istore #16
/*     */     //   606: iconst_0
/*     */     //   607: istore #17
/*     */     //   609: iload #17
/*     */     //   611: iload #16
/*     */     //   613: if_icmpge -> 651
/*     */     //   616: aload #15
/*     */     //   618: iload #17
/*     */     //   620: aaload
/*     */     //   621: astore #18
/*     */     //   623: aload #18
/*     */     //   625: astore #19
/*     */     //   627: iconst_0
/*     */     //   628: istore #20
/*     */     //   630: aload #19
/*     */     //   632: aload_3
/*     */     //   633: iconst_1
/*     */     //   634: invokestatic startsWith : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   637: ifeq -> 645
/*     */     //   640: aload #18
/*     */     //   642: goto -> 665
/*     */     //   645: iinc #17, 1
/*     */     //   648: goto -> 609
/*     */     //   651: new java/util/NoSuchElementException
/*     */     //   654: dup
/*     */     //   655: ldc_w 'Array contains no element matching the predicate.'
/*     */     //   658: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   661: checkcast java/lang/Throwable
/*     */     //   664: athrow
/*     */     //   665: astore #21
/*     */     //   667: aload_0
/*     */     //   668: getfield prefix : C
/*     */     //   671: istore #13
/*     */     //   673: iconst_0
/*     */     //   674: istore #14
/*     */     //   676: new java/lang/StringBuilder
/*     */     //   679: dup
/*     */     //   680: invokespecial <init> : ()V
/*     */     //   683: iload #13
/*     */     //   685: invokestatic valueOf : (C)Ljava/lang/String;
/*     */     //   688: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   691: aload #21
/*     */     //   693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   696: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   699: nop
/*     */     //   700: astore #23
/*     */     //   702: aload #22
/*     */     //   704: aload #23
/*     */     //   706: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   711: pop
/*     */     //   712: goto -> 533
/*     */     //   715: aload #7
/*     */     //   717: checkcast java/util/List
/*     */     //   720: checkcast java/util/Collection
/*     */     //   723: astore #4
/*     */     //   725: iconst_0
/*     */     //   726: istore #5
/*     */     //   728: aload #4
/*     */     //   730: astore #6
/*     */     //   732: aload #6
/*     */     //   734: iconst_0
/*     */     //   735: anewarray java/lang/String
/*     */     //   738: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   743: dup
/*     */     //   744: ifnonnull -> 757
/*     */     //   747: new kotlin/TypeCastException
/*     */     //   750: dup
/*     */     //   751: ldc 'null cannot be cast to non-null type kotlin.Array<T>'
/*     */     //   753: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   756: athrow
/*     */     //   757: checkcast [Ljava/lang/String;
/*     */     //   760: areturn
/*     */     //   761: aconst_null
/*     */     //   762: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #79	-> 0
/*     */     //   #79	-> 24
/*     */     //   #80	-> 61
/*     */     //   #82	-> 83
/*     */     //   #83	-> 93
/*     */     //   #83	-> 148
/*     */     //   #84	-> 152
/*     */     //   #132	-> 175
/*     */     //   #133	-> 179
/*     */     //   #84	-> 213
/*     */     //   #86	-> 223
/*     */     //   #134	-> 237
/*     */     //   #135	-> 241
/*     */     //   #88	-> 277
/*     */     //   #88	-> 314
/*     */     //   #89	-> 315
/*     */     //   #103	-> 315
/*     */     //   #89	-> 315
/*     */     //   #94	-> 315
/*     */     //   #89	-> 315
/*     */     //   #90	-> 315
/*     */     //   #89	-> 315
/*     */     //   #90	-> 324
/*     */     //   #136	-> 327
/*     */     //   #137	-> 346
/*     */     //   #91	-> 384
/*     */     //   #92	-> 384
/*     */     //   #91	-> 384
/*     */     //   #92	-> 397
/*     */     //   #138	-> 407
/*     */     //   #92	-> 440
/*     */     //   #139	-> 460
/*     */     //   #92	-> 469
/*     */     //   #140	-> 485
/*     */     //   #94	-> 495
/*     */     //   #141	-> 498
/*     */     //   #142	-> 524
/*     */     //   #143	-> 552
/*     */     //   #95	-> 566
/*     */     //   #96	-> 579
/*     */     //   #98	-> 587
/*     */     //   #144	-> 597
/*     */     //   #98	-> 630
/*     */     //   #145	-> 651
/*     */     //   #95	-> 665
/*     */     //   #101	-> 667
/*     */     //   #101	-> 699
/*     */     //   #142	-> 712
/*     */     //   #146	-> 715
/*     */     //   #103	-> 725
/*     */     //   #147	-> 728
/*     */     //   #148	-> 732
/*     */     //   #82	-> 760
/*     */     //   #106	-> 761
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   179	25	7	thisCollection$iv	Ljava/util/Collection;
/*     */     //   172	32	5	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   175	29	6	$i$f$toTypedArray	I
/*     */     //   241	25	7	thisCollection$iv	Ljava/util/Collection;
/*     */     //   234	32	5	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   237	29	6	$i$f$toTypedArray	I
/*     */     //   223	51	4	tabCompletions	Ljava/util/List;
/*     */     //   152	122	3	command	Lnet/ccbluex/liquidbounce/features/command/Command;
/*     */     //   437	10	19	alias	Ljava/lang/String;
/*     */     //   440	7	20	$i$a$-any-CommandManager$getCompletions$1$1	I
/*     */     //   433	24	18	element$iv	Ljava/lang/Object;
/*     */     //   404	57	13	$this$any$iv	[Ljava/lang/Object;
/*     */     //   407	54	14	$i$f$any	I
/*     */     //   381	88	11	it	Lnet/ccbluex/liquidbounce/features/command/Command;
/*     */     //   384	85	12	$i$a$-filter-CommandManager$getCompletions$1	I
/*     */     //   374	108	10	element$iv$iv	Ljava/lang/Object;
/*     */     //   343	144	6	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   343	144	7	destination$iv$iv	Ljava/util/Collection;
/*     */     //   346	141	8	$i$f$filterTo	I
/*     */     //   324	166	4	$this$filter$iv	Ljava/lang/Iterable;
/*     */     //   327	163	5	$i$f$filter	I
/*     */     //   627	10	19	alias	Ljava/lang/String;
/*     */     //   630	7	20	$i$a$-first-CommandManager$getCompletions$2$alias$1	I
/*     */     //   623	25	18	element$iv	Ljava/lang/Object;
/*     */     //   594	71	13	$this$first$iv	[Ljava/lang/Object;
/*     */     //   597	68	14	$i$f$first	I
/*     */     //   667	32	21	alias	Ljava/lang/String;
/*     */     //   563	137	11	it	Lnet/ccbluex/liquidbounce/features/command/Command;
/*     */     //   566	134	12	$i$a$-map-CommandManager$getCompletions$2	I
/*     */     //   552	160	10	item$iv$iv	Ljava/lang/Object;
/*     */     //   521	196	6	$this$mapTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   521	196	7	destination$iv$iv	Ljava/util/Collection;
/*     */     //   524	193	8	$i$f$mapTo	I
/*     */     //   495	225	4	$this$map$iv	Ljava/lang/Iterable;
/*     */     //   498	222	5	$i$f$map	I
/*     */     //   732	25	6	thisCollection$iv	Ljava/util/Collection;
/*     */     //   725	32	4	$this$toTypedArray$iv	Ljava/util/Collection;
/*     */     //   728	29	5	$i$f$toTypedArray	I
/*     */     //   315	445	3	rawInput	Ljava/lang/String;
/*     */     //   83	678	2	args	Ljava/util/List;
/*     */     //   0	763	0	this	Lnet/ccbluex/liquidbounce/features/command/CommandManager;
/*     */     //   0	763	1	input	Ljava/lang/String;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final Command getCommand(@NotNull String name) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'name'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield commands : Ljava/util/List;
/*     */     //   11: checkcast java/lang/Iterable
/*     */     //   14: astore_2
/*     */     //   15: iconst_0
/*     */     //   16: istore_3
/*     */     //   17: aload_2
/*     */     //   18: astore #4
/*     */     //   20: iconst_0
/*     */     //   21: istore #5
/*     */     //   23: aload #4
/*     */     //   25: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   30: astore #6
/*     */     //   32: aload #6
/*     */     //   34: invokeinterface hasNext : ()Z
/*     */     //   39: ifeq -> 155
/*     */     //   42: aload #6
/*     */     //   44: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   49: astore #7
/*     */     //   51: aload #7
/*     */     //   53: checkcast net/ccbluex/liquidbounce/features/command/Command
/*     */     //   56: astore #8
/*     */     //   58: iconst_0
/*     */     //   59: istore #9
/*     */     //   61: aload #8
/*     */     //   63: invokevirtual getCommand : ()Ljava/lang/String;
/*     */     //   66: aload_1
/*     */     //   67: iconst_1
/*     */     //   68: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   71: ifne -> 141
/*     */     //   74: aload #8
/*     */     //   76: invokevirtual getAlias : ()[Ljava/lang/String;
/*     */     //   79: astore #10
/*     */     //   81: iconst_0
/*     */     //   82: istore #11
/*     */     //   84: aload #10
/*     */     //   86: astore #12
/*     */     //   88: aload #12
/*     */     //   90: arraylength
/*     */     //   91: istore #13
/*     */     //   93: iconst_0
/*     */     //   94: istore #14
/*     */     //   96: iload #14
/*     */     //   98: iload #13
/*     */     //   100: if_icmpge -> 137
/*     */     //   103: aload #12
/*     */     //   105: iload #14
/*     */     //   107: aaload
/*     */     //   108: astore #15
/*     */     //   110: aload #15
/*     */     //   112: astore #16
/*     */     //   114: iconst_0
/*     */     //   115: istore #17
/*     */     //   117: aload #16
/*     */     //   119: aload_1
/*     */     //   120: iconst_1
/*     */     //   121: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   124: ifeq -> 131
/*     */     //   127: iconst_1
/*     */     //   128: goto -> 138
/*     */     //   131: iinc #14, 1
/*     */     //   134: goto -> 96
/*     */     //   137: iconst_0
/*     */     //   138: ifeq -> 145
/*     */     //   141: iconst_1
/*     */     //   142: goto -> 146
/*     */     //   145: iconst_0
/*     */     //   146: nop
/*     */     //   147: ifeq -> 32
/*     */     //   150: aload #7
/*     */     //   152: goto -> 156
/*     */     //   155: aconst_null
/*     */     //   156: checkcast net/ccbluex/liquidbounce/features/command/Command
/*     */     //   159: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #113	-> 7
/*     */     //   #114	-> 61
/*     */     //   #115	-> 61
/*     */     //   #114	-> 61
/*     */     //   #115	-> 74
/*     */     //   #149	-> 84
/*     */     //   #115	-> 117
/*     */     //   #150	-> 137
/*     */     //   #115	-> 146
/*     */     //   #113	-> 147
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   114	10	16	alias	Ljava/lang/String;
/*     */     //   117	7	17	$i$a$-any-CommandManager$getCommand$1$1	I
/*     */     //   110	24	15	element$iv	Ljava/lang/Object;
/*     */     //   81	57	10	$this$any$iv	[Ljava/lang/Object;
/*     */     //   84	54	11	$i$f$any	I
/*     */     //   58	89	8	it	Lnet/ccbluex/liquidbounce/features/command/Command;
/*     */     //   61	86	9	$i$a$-find-CommandManager$getCommand$1	I
/*     */     //   0	160	0	this	Lnet/ccbluex/liquidbounce/features/command/CommandManager;
/*     */     //   0	160	1	name	Ljava/lang/String;
/*     */   }
/*     */   
/*     */   public final boolean registerCommand(@NotNull Command command) {
/*     */     Intrinsics.checkParameterIsNotNull(command, "command");
/*     */     return this.commands.add(command);
/*     */   }
/*     */   
/*     */   public final boolean unregisterCommand(@Nullable Command command) {
/*     */     List<Command> list = this.commands;
/*     */     boolean bool = false;
/*     */     if (list == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>"); 
/*     */     return TypeIntrinsics.asMutableCollection(list).remove(command);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\CommandManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */