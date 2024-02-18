/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\007\n\002\020\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\021\032\0020\0222\006\020\023\032\0020\001H\026J\020\020\024\032\0020\0222\006\020\025\032\0020\nH\026J\023\020\026\032\0020\0272\b\020\030\032\004\030\0010\031H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\n8VX\004¢\006\006\032\004\b\016\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\017\020\020¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/IChatComponentImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "wrapped", "Lnet/minecraft/util/text/ITextComponent;", "(Lnet/minecraft/util/text/ITextComponent;)V", "chatStyle", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IChatStyle;", "getChatStyle", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IChatStyle;", "formattedText", "", "getFormattedText", "()Ljava/lang/String;", "unformattedText", "getUnformattedText", "getWrapped", "()Lnet/minecraft/util/text/ITextComponent;", "appendSibling", "", "component", "appendText", "text", "equals", "", "other", "", "XSJClient"})
/*    */ public final class IChatComponentImpl implements IIChatComponent {
/*    */   @NotNull
/*  8 */   public final ITextComponent getWrapped() { return this.wrapped; } @NotNull private final ITextComponent wrapped; public IChatComponentImpl(@NotNull ITextComponent wrapped) { this.wrapped = wrapped; }
/*    */   @NotNull
/* 10 */   public String getUnformattedText() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_150260_c(), "wrapped.unformattedText"); return this.wrapped.func_150260_c(); }
/*    */   @NotNull
/* 12 */   public IChatStyle getChatStyle() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_150256_b(), "wrapped.style"); Style $this$wrap$iv = this.wrapped.func_150256_b(); int $i$f$wrap = 0; return 
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
/* 31 */       new ChatStyleImpl($this$wrap$iv); } public void appendSibling(@NotNull IIChatComponent component) { Intrinsics.checkParameterIsNotNull(component, "component"); IIChatComponent iIChatComponent = component; ITextComponent iTextComponent1 = this.wrapped; int $i$f$unwrap = 0;
/* 32 */     ITextComponent iTextComponent2 = ((IChatComponentImpl)iIChatComponent).getWrapped(); iTextComponent1.func_150257_a(iTextComponent2); }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getFormattedText() {
/*    */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_150254_d(), "wrapped.formattedText");
/*    */     return this.wrapped.func_150254_d();
/*    */   }
/*    */   
/*    */   public void appendText(@NotNull String text) {
/*    */     Intrinsics.checkParameterIsNotNull(text, "text");
/*    */     this.wrapped.func_150258_a(text);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof IChatComponentImpl && Intrinsics.areEqual(((IChatComponentImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\IChatComponentImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */