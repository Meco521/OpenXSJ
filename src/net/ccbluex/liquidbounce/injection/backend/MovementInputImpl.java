/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\007\n\002\b\b\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\021\032\0020\0062\b\020\022\032\004\030\0010\023H\002R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\n8VX\004¢\006\006\032\004\b\016\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\017\020\020¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/MovementInputImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;", "wrapped", "Lnet/minecraft/util/MovementInput;", "(Lnet/minecraft/util/MovementInput;)V", "jump", "", "getJump", "()Z", "moveForward", "", "getMoveForward", "()F", "moveStrafe", "getMoveStrafe", "getWrapped", "()Lnet/minecraft/util/MovementInput;", "equals", "other", "", "XSJClient"})
/*    */ public final class MovementInputImpl implements IMovementInput {
/*    */   @NotNull
/*  7 */   public final MovementInput getWrapped() { return this.wrapped; } @NotNull private final MovementInput wrapped; public MovementInputImpl(@NotNull MovementInput wrapped) { this.wrapped = wrapped; }
/*    */    public float getMoveForward() {
/*  9 */     return this.wrapped.field_192832_b;
/*    */   } public float getMoveStrafe() {
/* 11 */     return this.wrapped.field_78902_a;
/*    */   } public boolean getJump() {
/* 13 */     return this.wrapped.field_78901_c;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 17 */     return (other instanceof MovementInputImpl && Intrinsics.areEqual(((MovementInputImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\MovementInputImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */