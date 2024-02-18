/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\b\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\021H\002R$\020\007\032\0020\0062\006\020\005\032\0020\0068V@VX\016¢\006\f\032\004\b\b\020\t\"\004\b\n\020\013R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\f\020\r¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CreativeTabsImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/creativetabs/ICreativeTabs;", "wrapped", "Lnet/minecraft/creativetab/CreativeTabs;", "(Lnet/minecraft/creativetab/CreativeTabs;)V", "value", "", "backgroundImageName", "getBackgroundImageName", "()Ljava/lang/String;", "setBackgroundImageName", "(Ljava/lang/String;)V", "getWrapped", "()Lnet/minecraft/creativetab/CreativeTabs;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class CreativeTabsImpl implements ICreativeTabs {
/*    */   @NotNull
/*  7 */   public final CreativeTabs getWrapped() { return this.wrapped; } @NotNull private final CreativeTabs wrapped; public CreativeTabsImpl(@NotNull CreativeTabs wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public String getBackgroundImageName() {
/*  9 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_78015_f(), "wrapped.backgroundImageName"); return this.wrapped.func_78015_f();
/*    */   } public void setBackgroundImageName(@NotNull String value) {
/* 11 */     Intrinsics.checkParameterIsNotNull(value, "value"); this.wrapped.func_78025_a(value);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 15 */     return (other instanceof CreativeTabsImpl && Intrinsics.areEqual(((CreativeTabsImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CreativeTabsImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */