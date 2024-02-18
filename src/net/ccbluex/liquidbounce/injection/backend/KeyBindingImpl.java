/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\013\n\002\020\000\n\000\n\002\020\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\023\032\0020\0062\b\020\024\032\004\030\0010\025H\002J\020\020\026\032\0020\0272\006\020\b\032\0020\tH\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\005\020\007R\024\020\b\032\0020\t8VX\004¢\006\006\032\004\b\n\020\013R$\020\r\032\0020\0062\006\020\f\032\0020\0068V@VX\016¢\006\f\032\004\b\016\020\007\"\004\b\017\020\020R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\021\020\022¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/KeyBindingImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "wrapped", "Lnet/minecraft/client/settings/KeyBinding;", "(Lnet/minecraft/client/settings/KeyBinding;)V", "isKeyDown", "", "()Z", "keyCode", "", "getKeyCode", "()I", "value", "pressed", "getPressed", "setPressed", "(Z)V", "getWrapped", "()Lnet/minecraft/client/settings/KeyBinding;", "equals", "other", "", "onTick", "", "XSJClient"})
/*    */ public final class KeyBindingImpl implements IKeyBinding {
/*    */   @NotNull
/*  7 */   public final KeyBinding getWrapped() { return this.wrapped; } @NotNull private final KeyBinding wrapped; public KeyBindingImpl(@NotNull KeyBinding wrapped) { this.wrapped = wrapped; }
/*    */    public int getKeyCode() {
/*  9 */     return this.wrapped.func_151463_i();
/*    */   } public boolean getPressed() {
/* 11 */     return this.wrapped.field_74513_e;
/*    */   } public void setPressed(boolean value) {
/* 13 */     this.wrapped.field_74513_e = value;
/*    */   }
/*    */   public boolean isKeyDown() {
/* 16 */     return this.wrapped.func_151470_d();
/*    */   } public void onTick(int keyCode) {
/* 18 */     KeyBinding.func_74507_a(keyCode);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 21 */     return (other instanceof KeyBindingImpl && Intrinsics.areEqual(((KeyBindingImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\KeyBindingImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */