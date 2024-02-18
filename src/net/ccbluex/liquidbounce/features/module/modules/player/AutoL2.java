/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "AutoL2", category = ModuleCategory.PLAYER, description = "击杀计数2")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000P\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\007\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\037\032\0020\016J\020\020 \032\0020!2\006\020\"\032\0020#H\007J\020\020$\032\0020!2\006\020\"\032\0020%H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\013\020\fR\032\020\r\032\0020\016X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\021\020\023\032\0020\n¢\006\b\n\000\032\004\b\024\020\fR\026\020\025\032\004\030\0010\0268VX\004¢\006\006\032\004\b\027\020\030R\034\020\031\032\004\030\0010\032X\016¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AutoLmsg", "Lnet/ccbluex/liquidbounce/value/TextValue;", "L", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Volume", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "diedmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getDiedmodeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "kill", "", "getKill", "()I", "setKill", "(I)V", "killmodeValue", "getKillmodeValue", "tag", "", "getTag", "()Ljava/lang/String;", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "kills", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoL2 extends Module {
/* 18 */   private final BoolValue L = new BoolValue("L", true); @NotNull
/* 19 */   private final ListValue killmodeValue = new ListValue("KillSoundMode", new String[] { "银狼", "刃", "None" }, "银狼"); @NotNull public final ListValue getKillmodeValue() { return this.killmodeValue; } @NotNull
/* 20 */   private final ListValue diedmodeValue = new ListValue("DiedSoundMode", new String[] { "银狼", "刃", "甘雨", "None" }, "银狼"); @NotNull public final ListValue getDiedmodeValue() { return this.diedmodeValue; }
/* 21 */    private final FloatValue Volume = new FloatValue("Volume", 50.0F, 0.0F, 100.0F);
/* 22 */   private final TextValue AutoLmsg = new TextValue("AutoLmsg", "@");
/*    */   @Nullable
/*    */   private IEntityLivingBase target; private int kill; @Nullable
/* 25 */   public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; }
/* 26 */   public final int getKill() { return this.kill; } public final void setKill(int <set-?>) { this.kill = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 30 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.target = (IEntityLivingBase)event.getTargetEntity();
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
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   10: dup
/*    */     //   11: ifnonnull -> 17
/*    */     //   14: invokestatic throwNpe : ()V
/*    */     //   17: invokeinterface getHealth : ()F
/*    */     //   22: f2d
/*    */     //   23: ldc2_w 0.1
/*    */     //   26: dcmpg
/*    */     //   27: ifgt -> 268
/*    */     //   30: aload_0
/*    */     //   31: dup
/*    */     //   32: getfield kill : I
/*    */     //   35: iconst_1
/*    */     //   36: iadd
/*    */     //   37: putfield kill : I
/*    */     //   40: aload_0
/*    */     //   41: getfield killmodeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   44: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   47: checkcast java/lang/String
/*    */     //   50: astore_2
/*    */     //   51: iconst_0
/*    */     //   52: istore_3
/*    */     //   53: aload_2
/*    */     //   54: dup
/*    */     //   55: ifnonnull -> 68
/*    */     //   58: new kotlin/TypeCastException
/*    */     //   61: dup
/*    */     //   62: ldc 'null cannot be cast to non-null type java.lang.String'
/*    */     //   64: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   67: athrow
/*    */     //   68: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   71: dup
/*    */     //   72: ldc '(this as java.lang.String).toLowerCase()'
/*    */     //   74: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   77: astore_2
/*    */     //   78: aload_2
/*    */     //   79: invokevirtual hashCode : ()I
/*    */     //   82: lookupswitch default -> 184, 20995 -> 108, 1211590 -> 120
/*    */     //   108: aload_2
/*    */     //   109: ldc '刃'
/*    */     //   111: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   114: ifeq -> 184
/*    */     //   117: goto -> 158
/*    */     //   120: aload_2
/*    */     //   121: ldc '银狼'
/*    */     //   123: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   126: ifeq -> 184
/*    */     //   129: new me/sound/SoundPlayer
/*    */     //   132: dup
/*    */     //   133: invokespecial <init> : ()V
/*    */     //   136: getstatic me/sound/SoundPlayer$SoundType.YINLANKILL : Lme/sound/SoundPlayer$SoundType;
/*    */     //   139: aload_0
/*    */     //   140: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   146: checkcast java/lang/Number
/*    */     //   149: invokevirtual floatValue : ()F
/*    */     //   152: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   155: goto -> 184
/*    */     //   158: new me/sound/SoundPlayer
/*    */     //   161: dup
/*    */     //   162: invokespecial <init> : ()V
/*    */     //   165: getstatic me/sound/SoundPlayer$SoundType.LENGKILL : Lme/sound/SoundPlayer$SoundType;
/*    */     //   168: aload_0
/*    */     //   169: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   172: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   175: checkcast java/lang/Number
/*    */     //   178: invokevirtual floatValue : ()F
/*    */     //   181: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   184: aload_0
/*    */     //   185: getfield L : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   188: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   191: checkcast java/lang/Boolean
/*    */     //   194: invokevirtual booleanValue : ()Z
/*    */     //   197: ifeq -> 260
/*    */     //   200: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   203: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   208: dup
/*    */     //   209: ifnonnull -> 215
/*    */     //   212: invokestatic throwNpe : ()V
/*    */     //   215: new java/lang/StringBuilder
/*    */     //   218: dup
/*    */     //   219: invokespecial <init> : ()V
/*    */     //   222: aload_0
/*    */     //   223: getfield AutoLmsg : Lnet/ccbluex/liquidbounce/value/TextValue;
/*    */     //   226: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   229: checkcast java/lang/String
/*    */     //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   235: ldc '我已经击杀了'
/*    */     //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   240: aload_0
/*    */     //   241: getfield kill : I
/*    */     //   244: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   247: ldc '人 '
/*    */     //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   252: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   255: invokeinterface sendChatMessage : (Ljava/lang/String;)V
/*    */     //   260: aload_0
/*    */     //   261: aconst_null
/*    */     //   262: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   265: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   268: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   271: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   276: dup
/*    */     //   277: ifnonnull -> 283
/*    */     //   280: invokestatic throwNpe : ()V
/*    */     //   283: invokeinterface isDead : ()Z
/*    */     //   288: ifne -> 319
/*    */     //   291: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   294: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   299: dup
/*    */     //   300: ifnonnull -> 306
/*    */     //   303: invokestatic throwNpe : ()V
/*    */     //   306: invokeinterface getHealth : ()F
/*    */     //   311: f2d
/*    */     //   312: ldc2_w 0.1
/*    */     //   315: dcmpg
/*    */     //   316: ifgt -> 516
/*    */     //   319: aload_0
/*    */     //   320: getfield diedmodeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*    */     //   323: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   326: checkcast java/lang/String
/*    */     //   329: astore_2
/*    */     //   330: iconst_0
/*    */     //   331: istore_3
/*    */     //   332: aload_2
/*    */     //   333: dup
/*    */     //   334: ifnonnull -> 347
/*    */     //   337: new kotlin/TypeCastException
/*    */     //   340: dup
/*    */     //   341: ldc 'null cannot be cast to non-null type java.lang.String'
/*    */     //   343: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   346: athrow
/*    */     //   347: invokevirtual toLowerCase : ()Ljava/lang/String;
/*    */     //   350: dup
/*    */     //   351: ldc '(this as java.lang.String).toLowerCase()'
/*    */     //   353: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   356: astore_2
/*    */     //   357: aload_2
/*    */     //   358: invokevirtual hashCode : ()I
/*    */     //   361: lookupswitch default -> 516, 20995 -> 396, 967888 -> 420, 1211590 -> 408
/*    */     //   396: aload_2
/*    */     //   397: ldc '刃'
/*    */     //   399: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   402: ifeq -> 516
/*    */     //   405: goto -> 461
/*    */     //   408: aload_2
/*    */     //   409: ldc '银狼'
/*    */     //   411: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   414: ifeq -> 516
/*    */     //   417: goto -> 432
/*    */     //   420: aload_2
/*    */     //   421: ldc '甘雨'
/*    */     //   423: invokevirtual equals : (Ljava/lang/Object;)Z
/*    */     //   426: ifeq -> 516
/*    */     //   429: goto -> 490
/*    */     //   432: new me/sound/SoundPlayer
/*    */     //   435: dup
/*    */     //   436: invokespecial <init> : ()V
/*    */     //   439: getstatic me/sound/SoundPlayer$SoundType.YINLANDIED : Lme/sound/SoundPlayer$SoundType;
/*    */     //   442: aload_0
/*    */     //   443: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   446: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   449: checkcast java/lang/Number
/*    */     //   452: invokevirtual floatValue : ()F
/*    */     //   455: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   458: goto -> 516
/*    */     //   461: new me/sound/SoundPlayer
/*    */     //   464: dup
/*    */     //   465: invokespecial <init> : ()V
/*    */     //   468: getstatic me/sound/SoundPlayer$SoundType.LENGDIED : Lme/sound/SoundPlayer$SoundType;
/*    */     //   471: aload_0
/*    */     //   472: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   475: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   478: checkcast java/lang/Number
/*    */     //   481: invokevirtual floatValue : ()F
/*    */     //   484: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   487: goto -> 516
/*    */     //   490: new me/sound/SoundPlayer
/*    */     //   493: dup
/*    */     //   494: invokespecial <init> : ()V
/*    */     //   497: getstatic me/sound/SoundPlayer$SoundType.GANYUDIED : Lme/sound/SoundPlayer$SoundType;
/*    */     //   500: aload_0
/*    */     //   501: getfield Volume : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*    */     //   504: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   507: checkcast java/lang/Number
/*    */     //   510: invokevirtual floatValue : ()F
/*    */     //   513: invokevirtual playSound : (Lme/sound/SoundPlayer$SoundType;F)V
/*    */     //   516: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #35	-> 6
/*    */     //   #36	-> 30
/*    */     //   #37	-> 40
/*    */     //   #39	-> 108
/*    */     //   #38	-> 120
/*    */     //   #39	-> 158
/*    */     //   #40	-> 184
/*    */     //   #41	-> 184
/*    */     //   #42	-> 200
/*    */     //   #44	-> 260
/*    */     //   #46	-> 268
/*    */     //   #47	-> 319
/*    */     //   #49	-> 396
/*    */     //   #48	-> 408
/*    */     //   #50	-> 420
/*    */     //   #48	-> 432
/*    */     //   #49	-> 461
/*    */     //   #50	-> 490
/*    */     //   #51	-> 516
/*    */     //   #53	-> 516
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	517	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL2;
/*    */     //   0	517	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*    */   public final int kills() {
/* 56 */     return this.kill;
/*    */   } @Nullable
/*    */   public String getTag() {
/* 59 */     return "Kill " + this.kill;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AutoL2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */