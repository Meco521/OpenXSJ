/*    */ package tomk.utils.info;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\b\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\016\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020!\032\0020\"H\026J\020\020#\032\0020$2\006\020%\032\0020&H\007J\020\020'\032\0020$2\006\020%\032\0020(H\003J\020\020)\032\0020$2\006\020%\032\0020*H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\034\020\022\032\004\030\0010\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\032\020\030\032\0020\004X\016¢\006\016\n\000\032\004\b\031\020\006\"\004\b\032\020\bR\032\020\033\032\0020\004X\016¢\006\016\n\000\032\004\b\034\020\006\"\004\b\035\020\bR\032\020\036\032\0020\004X\016¢\006\016\n\000\032\004\b\037\020\006\"\004\b \020\b¨\006+"}, d2 = {"Ltomk/utils/info/Recorder;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "ban", "", "getBan", "()I", "setBan", "(I)V", "killCounts", "getKillCounts", "setKillCounts", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "syncEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getSyncEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setSyncEntity", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "totalPlayed", "getTotalPlayed", "setTotalPlayed", "totalPlayed2", "getTotalPlayed2", "setTotalPlayed2", "win", "getWin", "setWin", "handleEvents", "", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Recorder implements Listenable {
/*    */   @Nullable
/*    */   private static IEntityLivingBase syncEntity;
/*    */   private static int killCounts;
/*    */   private static int totalPlayed;
/*    */   
/*  9 */   static { Recorder recorder = new Recorder(); } private static int totalPlayed2; private static int win; private static int ban; @Nullable
/* 10 */   public final IEntityLivingBase getSyncEntity() { return syncEntity; } public final void setSyncEntity(@Nullable IEntityLivingBase <set-?>) { syncEntity = <set-?>; }
/* 11 */   public final int getKillCounts() { return killCounts; } public final void setKillCounts(int <set-?>) { killCounts = <set-?>; }
/* 12 */   public final int getTotalPlayed() { return totalPlayed; } public final void setTotalPlayed(int <set-?>) { totalPlayed = <set-?>; }
/* 13 */   public final int getTotalPlayed2() { return totalPlayed2; } public final void setTotalPlayed2(int <set-?>) { totalPlayed2 = <set-?>; }
/* 14 */   public final int getWin() { return win; } public final void setWin(int <set-?>) { win = <set-?>; }
/* 15 */   public final int getBan() { return ban; } public final void setBan(int <set-?>) { ban = <set-?>; }
/* 16 */    private static long startTime = System.currentTimeMillis(); public static final Recorder INSTANCE; public final long getStartTime() { return startTime; } public final void setStartTime(long <set-?>) { startTime = <set-?>; }
/*    */    @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 19 */     Intrinsics.checkParameterIsNotNull(event, "event"); syncEntity = (IEntityLivingBase)event.getTargetEntity();
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 23 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (syncEntity == null) Intrinsics.throwNpe();  if (syncEntity.isDead()) {
/* 24 */       killCounts++;
/* 25 */       syncEntity = (IEntityLivingBase)null;
/*    */     } 
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
/*    */   @EventTarget
/*    */   private final void onPacket(PacketEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   4: instanceof net/minecraft/network/handshake/client/C00Handshake
/*    */     //   7: ifeq -> 16
/*    */     //   10: invokestatic currentTimeMillis : ()J
/*    */     //   13: putstatic tomk/utils/info/Recorder.startTime : J
/*    */     //   16: aload_1
/*    */     //   17: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   20: dup
/*    */     //   21: ifnonnull -> 34
/*    */     //   24: new kotlin/TypeCastException
/*    */     //   27: dup
/*    */     //   28: ldc 'null cannot be cast to non-null type net.minecraft.network.play.server.SPacketChat'
/*    */     //   30: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   33: athrow
/*    */     //   34: checkcast net/minecraft/network/play/server/SPacketChat
/*    */     //   37: invokevirtual func_148915_c : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   40: dup
/*    */     //   41: ldc '(event.packet as SPacketChat).chatComponent'
/*    */     //   43: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   46: invokeinterface func_150260_c : ()Ljava/lang/String;
/*    */     //   51: astore_2
/*    */     //   52: aload_1
/*    */     //   53: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   56: astore_3
/*    */     //   57: aload_3
/*    */     //   58: instanceof net/minecraft/network/play/server/SPacketTitle
/*    */     //   61: ifeq -> 319
/*    */     //   64: aload_3
/*    */     //   65: checkcast net/minecraft/network/play/server/SPacketTitle
/*    */     //   68: invokevirtual func_179805_b : ()Lnet/minecraft/util/text/ITextComponent;
/*    */     //   71: dup
/*    */     //   72: ifnull -> 78
/*    */     //   75: goto -> 80
/*    */     //   78: pop
/*    */     //   79: return
/*    */     //   80: invokeinterface func_150254_d : ()Ljava/lang/String;
/*    */     //   85: astore #4
/*    */     //   87: aload #4
/*    */     //   89: dup
/*    */     //   90: ldc 'title'
/*    */     //   92: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   95: ldc '§6§l'
/*    */     //   97: iconst_0
/*    */     //   98: iconst_2
/*    */     //   99: aconst_null
/*    */     //   100: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   103: ifeq -> 119
/*    */     //   106: aload #4
/*    */     //   108: ldc '§r'
/*    */     //   110: iconst_0
/*    */     //   111: iconst_2
/*    */     //   112: aconst_null
/*    */     //   113: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   116: ifne -> 223
/*    */     //   119: aload #4
/*    */     //   121: ldc '§c§lYOU'
/*    */     //   123: iconst_0
/*    */     //   124: iconst_2
/*    */     //   125: aconst_null
/*    */     //   126: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   129: ifeq -> 145
/*    */     //   132: aload #4
/*    */     //   134: ldc '§r'
/*    */     //   136: iconst_0
/*    */     //   137: iconst_2
/*    */     //   138: aconst_null
/*    */     //   139: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   142: ifne -> 223
/*    */     //   145: aload #4
/*    */     //   147: ldc '§c§lGame'
/*    */     //   149: iconst_0
/*    */     //   150: iconst_2
/*    */     //   151: aconst_null
/*    */     //   152: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   155: ifeq -> 171
/*    */     //   158: aload #4
/*    */     //   160: ldc '§r'
/*    */     //   162: iconst_0
/*    */     //   163: iconst_2
/*    */     //   164: aconst_null
/*    */     //   165: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   168: ifne -> 223
/*    */     //   171: aload #4
/*    */     //   173: ldc '§c§lWITH'
/*    */     //   175: iconst_0
/*    */     //   176: iconst_2
/*    */     //   177: aconst_null
/*    */     //   178: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   181: ifeq -> 197
/*    */     //   184: aload #4
/*    */     //   186: ldc '§r'
/*    */     //   188: iconst_0
/*    */     //   189: iconst_2
/*    */     //   190: aconst_null
/*    */     //   191: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   194: ifne -> 223
/*    */     //   197: aload #4
/*    */     //   199: ldc '§c§lYARR'
/*    */     //   201: iconst_0
/*    */     //   202: iconst_2
/*    */     //   203: aconst_null
/*    */     //   204: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   207: ifeq -> 234
/*    */     //   210: aload #4
/*    */     //   212: ldc '§r'
/*    */     //   214: iconst_0
/*    */     //   215: iconst_2
/*    */     //   216: aconst_null
/*    */     //   217: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   220: ifeq -> 234
/*    */     //   223: getstatic tomk/utils/info/Recorder.totalPlayed : I
/*    */     //   226: dup
/*    */     //   227: istore #5
/*    */     //   229: iconst_1
/*    */     //   230: iadd
/*    */     //   231: putstatic tomk/utils/info/Recorder.totalPlayed : I
/*    */     //   234: aload #4
/*    */     //   236: ldc '§6§l'
/*    */     //   238: iconst_0
/*    */     //   239: iconst_2
/*    */     //   240: aconst_null
/*    */     //   241: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   244: ifeq -> 271
/*    */     //   247: aload #4
/*    */     //   249: ldc '§r'
/*    */     //   251: iconst_0
/*    */     //   252: iconst_2
/*    */     //   253: aconst_null
/*    */     //   254: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   257: ifeq -> 271
/*    */     //   260: getstatic tomk/utils/info/Recorder.win : I
/*    */     //   263: dup
/*    */     //   264: istore #5
/*    */     //   266: iconst_1
/*    */     //   267: iadd
/*    */     //   268: putstatic tomk/utils/info/Recorder.win : I
/*    */     //   271: getstatic tomk/utils/info/Recorder.totalPlayed2 : I
/*    */     //   274: dup
/*    */     //   275: istore #5
/*    */     //   277: iconst_1
/*    */     //   278: iadd
/*    */     //   279: putstatic tomk/utils/info/Recorder.totalPlayed2 : I
/*    */     //   282: aload #4
/*    */     //   284: ldc '§6§l'
/*    */     //   286: iconst_0
/*    */     //   287: iconst_2
/*    */     //   288: aconst_null
/*    */     //   289: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   292: ifeq -> 319
/*    */     //   295: aload #4
/*    */     //   297: ldc '§r'
/*    */     //   299: iconst_0
/*    */     //   300: iconst_2
/*    */     //   301: aconst_null
/*    */     //   302: invokestatic endsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
/*    */     //   305: ifeq -> 319
/*    */     //   308: getstatic tomk/utils/info/Recorder.win : I
/*    */     //   311: dup
/*    */     //   312: istore #5
/*    */     //   314: iconst_1
/*    */     //   315: iadd
/*    */     //   316: putstatic tomk/utils/info/Recorder.win : I
/*    */     //   319: aload_2
/*    */     //   320: dup
/*    */     //   321: ldc 'message'
/*    */     //   323: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   326: checkcast java/lang/CharSequence
/*    */     //   329: ldc 'Reason'
/*    */     //   331: checkcast java/lang/CharSequence
/*    */     //   334: iconst_0
/*    */     //   335: iconst_2
/*    */     //   336: aconst_null
/*    */     //   337: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*    */     //   340: ifeq -> 354
/*    */     //   343: getstatic tomk/utils/info/Recorder.ban : I
/*    */     //   346: dup
/*    */     //   347: istore #4
/*    */     //   349: iconst_1
/*    */     //   350: iadd
/*    */     //   351: putstatic tomk/utils/info/Recorder.ban : I
/*    */     //   354: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #30	-> 0
/*    */     //   #31	-> 16
/*    */     //   #32	-> 52
/*    */     //   #33	-> 57
/*    */     //   #34	-> 64
/*    */     //   #34	-> 78
/*    */     //   #35	-> 87
/*    */     //   #37	-> 87
/*    */     //   #39	-> 87
/*    */     //   #35	-> 87
/*    */     //   #36	-> 134
/*    */     //   #35	-> 139
/*    */     //   #37	-> 145
/*    */     //   #38	-> 186
/*    */     //   #37	-> 191
/*    */     //   #39	-> 197
/*    */     //   #40	-> 223
/*    */     //   #41	-> 234
/*    */     //   #42	-> 271
/*    */     //   #43	-> 282
/*    */     //   #45	-> 319
/*    */     //   #46	-> 343
/*    */     //   #48	-> 354
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   87	232	4	title	Ljava/lang/String;
/*    */     //   57	298	3	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*    */     //   52	303	2	message	Ljava/lang/String;
/*    */     //   0	355	0	this	Ltomk/utils/info/Recorder;
/*    */     //   0	355	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*    */   public boolean handleEvents() {
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\info\Recorder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */