/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.event.IClickEvent;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\t\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\032\032\0020\0222\b\020\033\032\004\030\0010\034H\002R(\020\007\032\004\030\0010\0062\b\020\005\032\004\030\0010\0068V@VX\016¢\006\f\032\004\b\b\020\t\"\004\b\n\020\013R(\020\r\032\004\030\0010\f2\b\020\005\032\004\030\0010\f8V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021R$\020\023\032\0020\0222\006\020\005\032\0020\0228V@VX\016¢\006\f\032\004\b\024\020\025\"\004\b\026\020\027R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\030\020\031¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ChatStyleImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IChatStyle;", "wrapped", "Lnet/minecraft/util/text/Style;", "(Lnet/minecraft/util/text/Style;)V", "value", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;", "chatClickEvent", "getChatClickEvent", "()Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;", "setChatClickEvent", "(Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;)V", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "color", "getColor", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "setColor", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;)V", "", "underlined", "getUnderlined", "()Z", "setUnderlined", "(Z)V", "getWrapped", "()Lnet/minecraft/util/text/Style;", "equals", "other", "", "XSJClient"})
/*    */ public final class ChatStyleImpl implements IChatStyle {
/*    */   @NotNull
/*    */   private final Style wrapped;
/*    */   
/*    */   @NotNull
/* 11 */   public final Style getWrapped() { return this.wrapped; } public ChatStyleImpl(@NotNull Style wrapped) { this.wrapped = wrapped; }
/*    */   @Nullable
/* 13 */   public IClickEvent getChatClickEvent() { ClickEvent $this$wrap$iv = this.wrapped.func_150235_h(); int $i$f$wrap = 0; this.wrapped.func_150235_h(); return (this.wrapped.func_150235_h() != null) ? 
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
/*    */ 
/*    */ 
/*    */       
/* 36 */       new ClickEventImpl($this$wrap$iv) : null; } public void setChatClickEvent(@Nullable IClickEvent value) { IClickEvent iClickEvent = value; Style style = this.wrapped; int $i$f$unwrap = 0;
/* 37 */     if (iClickEvent == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ClickEventImpl");  ClickEvent clickEvent = ((ClickEventImpl)iClickEvent).getWrapped(); this.wrapped.func_150241_a((value != null) ? clickEvent : null); }
/* 38 */   public boolean getUnderlined() { return this.wrapped.func_150234_e(); } public void setUnderlined(boolean value) { this.wrapped.func_150228_d(Boolean.valueOf(value)); } @Nullable public WEnumChatFormatting getColor() { if (this.wrapped.func_150215_a() != null) { TextFormatting $this$wrap$iv = this.wrapped.func_150215_a(); int $i$f$wrap = 0; switch (BackendExtentionsKt.WhenMappings.$EnumSwitchMapping$3[$this$wrap$iv.ordinal()]) { case 1: 
/*    */         case 2: 
/*    */         case 3: 
/*    */         case 4: 
/*    */         case 5: 
/*    */         case 6: 
/*    */         case 7: 
/*    */         case 8: 
/*    */         case 9: 
/*    */         case 10: 
/*    */         case 11: 
/*    */         case 12: 
/*    */         case 13: 
/*    */         case 14: 
/*    */         case 15: 
/*    */         case 16: 
/*    */         case 17: 
/*    */         case 18: 
/*    */         case 19: 
/*    */         case 20: 
/*    */         case 21: 
/*    */         case 22:
/* 60 */          }  throw new NoWhenBranchMatchedException(); }  return null; }
/*    */ 
/*    */   
/*    */   public void setColor(@Nullable WEnumChatFormatting value) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield wrapped : Lnet/minecraft/util/text/Style;
/*    */     //   4: aload_1
/*    */     //   5: dup
/*    */     //   6: ifnull -> 273
/*    */     //   9: astore_2
/*    */     //   10: astore #4
/*    */     //   12: iconst_0
/*    */     //   13: istore_3
/*    */     //   14: aload_2
/*    */     //   15: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$4 : [I
/*    */     //   18: swap
/*    */     //   19: invokevirtual ordinal : ()I
/*    */     //   22: iaload
/*    */     //   23: tableswitch default -> 256, 1 -> 124, 2 -> 130, 3 -> 136, 4 -> 142, 5 -> 148, 6 -> 154, 7 -> 160, 8 -> 166, 9 -> 172, 10 -> 178, 11 -> 184, 12 -> 190, 13 -> 196, 14 -> 202, 15 -> 208, 16 -> 214, 17 -> 220, 18 -> 226, 19 -> 232, 20 -> 238, 21 -> 244, 22 -> 250
/*    */     //   124: getstatic net/minecraft/util/text/TextFormatting.BLACK : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   127: goto -> 264
/*    */     //   130: getstatic net/minecraft/util/text/TextFormatting.DARK_BLUE : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   133: goto -> 264
/*    */     //   136: getstatic net/minecraft/util/text/TextFormatting.DARK_GREEN : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   139: goto -> 264
/*    */     //   142: getstatic net/minecraft/util/text/TextFormatting.DARK_AQUA : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   145: goto -> 264
/*    */     //   148: getstatic net/minecraft/util/text/TextFormatting.DARK_RED : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   151: goto -> 264
/*    */     //   154: getstatic net/minecraft/util/text/TextFormatting.DARK_PURPLE : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   157: goto -> 264
/*    */     //   160: getstatic net/minecraft/util/text/TextFormatting.GOLD : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   163: goto -> 264
/*    */     //   166: getstatic net/minecraft/util/text/TextFormatting.GRAY : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   169: goto -> 264
/*    */     //   172: getstatic net/minecraft/util/text/TextFormatting.DARK_GRAY : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   175: goto -> 264
/*    */     //   178: getstatic net/minecraft/util/text/TextFormatting.BLUE : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   181: goto -> 264
/*    */     //   184: getstatic net/minecraft/util/text/TextFormatting.GREEN : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   187: goto -> 264
/*    */     //   190: getstatic net/minecraft/util/text/TextFormatting.AQUA : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   193: goto -> 264
/*    */     //   196: getstatic net/minecraft/util/text/TextFormatting.RED : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   199: goto -> 264
/*    */     //   202: getstatic net/minecraft/util/text/TextFormatting.LIGHT_PURPLE : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   205: goto -> 264
/*    */     //   208: getstatic net/minecraft/util/text/TextFormatting.YELLOW : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   211: goto -> 264
/*    */     //   214: getstatic net/minecraft/util/text/TextFormatting.WHITE : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   217: goto -> 264
/*    */     //   220: getstatic net/minecraft/util/text/TextFormatting.OBFUSCATED : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   223: goto -> 264
/*    */     //   226: getstatic net/minecraft/util/text/TextFormatting.BOLD : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   229: goto -> 264
/*    */     //   232: getstatic net/minecraft/util/text/TextFormatting.STRIKETHROUGH : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   235: goto -> 264
/*    */     //   238: getstatic net/minecraft/util/text/TextFormatting.UNDERLINE : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   241: goto -> 264
/*    */     //   244: getstatic net/minecraft/util/text/TextFormatting.ITALIC : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   247: goto -> 264
/*    */     //   250: getstatic net/minecraft/util/text/TextFormatting.RESET : Lnet/minecraft/util/text/TextFormatting;
/*    */     //   253: goto -> 264
/*    */     //   256: new kotlin/NoWhenBranchMatchedException
/*    */     //   259: dup
/*    */     //   260: invokespecial <init> : ()V
/*    */     //   263: athrow
/*    */     //   264: astore #5
/*    */     //   266: aload #4
/*    */     //   268: aload #5
/*    */     //   270: goto -> 275
/*    */     //   273: pop
/*    */     //   274: aconst_null
/*    */     //   275: invokevirtual func_150238_a : (Lnet/minecraft/util/text/TextFormatting;)Lnet/minecraft/util/text/Style;
/*    */     //   278: pop
/*    */     //   279: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #25	-> 0
/*    */     //   #61	-> 14
/*    */     //   #62	-> 124
/*    */     //   #63	-> 130
/*    */     //   #64	-> 136
/*    */     //   #65	-> 142
/*    */     //   #66	-> 148
/*    */     //   #67	-> 154
/*    */     //   #68	-> 160
/*    */     //   #69	-> 166
/*    */     //   #70	-> 172
/*    */     //   #71	-> 178
/*    */     //   #72	-> 184
/*    */     //   #73	-> 190
/*    */     //   #74	-> 196
/*    */     //   #75	-> 202
/*    */     //   #76	-> 208
/*    */     //   #77	-> 214
/*    */     //   #78	-> 220
/*    */     //   #79	-> 226
/*    */     //   #80	-> 232
/*    */     //   #81	-> 238
/*    */     //   #82	-> 244
/*    */     //   #83	-> 250
/*    */     //   #26	-> 279
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   12	252	2	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;
/*    */     //   14	250	3	$i$f$unwrap	I
/*    */     //   0	280	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ChatStyleImpl;
/*    */     //   0	280	1	value	Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof ChatStyleImpl && Intrinsics.areEqual(((ChatStyleImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ChatStyleImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */