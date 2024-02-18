/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\013\n\000\n\002\020\000\n\002\b\007\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\022\032\0020\0232\b\020\024\032\004\030\0010\025H\002J\b\020\026\032\0020\023H\026J\b\020\027\032\0020\023H\026J\b\020\030\032\0020\023H\026J\b\020\031\032\0020\023H\026J\b\020\032\032\0020\023H\026J\b\020\033\032\0020\023H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0018VX\004¢\006\006\032\004\b\016\020\017R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\020\020\021¨\006\034"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EnumFacingImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "wrapped", "Lnet/minecraft/util/EnumFacing;", "(Lnet/minecraft/util/EnumFacing;)V", "axisOrdinal", "", "getAxisOrdinal", "()I", "directionVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "getDirectionVec", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "opposite", "getOpposite", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getWrapped", "()Lnet/minecraft/util/EnumFacing;", "equals", "", "other", "", "isDown", "isEast", "isNorth", "isSouth", "isUp", "isWest", "XSJClient"})
/*    */ public final class EnumFacingImpl implements IEnumFacing {
/*    */   @NotNull
/*  9 */   public final EnumFacing getWrapped() { return this.wrapped; } @NotNull private final EnumFacing wrapped; public EnumFacingImpl(@NotNull EnumFacing wrapped) { this.wrapped = wrapped; } public boolean isNorth() {
/* 10 */     return (this.wrapped == EnumFacing.NORTH);
/*    */   } public boolean isSouth() {
/* 12 */     return (this.wrapped == EnumFacing.SOUTH);
/*    */   } public boolean isEast() {
/* 14 */     return (this.wrapped == EnumFacing.EAST);
/*    */   } public boolean isWest() {
/* 16 */     return (this.wrapped == EnumFacing.WEST);
/*    */   } public boolean isUp() {
/* 18 */     return (this.wrapped == EnumFacing.UP);
/*    */   } public boolean isDown() {
/* 20 */     return (this.wrapped == EnumFacing.DOWN);
/*    */   }
/*    */   @NotNull
/* 23 */   public IEnumFacing getOpposite() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_176734_d(), "wrapped.opposite"); EnumFacing $this$wrap$iv = this.wrapped.func_176734_d(); int $i$f$wrap = 0; return 
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
/* 36 */       new EnumFacingImpl($this$wrap$iv); } @NotNull public WVec3i getDirectionVec() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_176730_m(), "wrapped.directionVec"); Vec3i $this$wrap$iv = this.wrapped.func_176730_m(); int $i$f$wrap = 0;
/* 37 */     return new WVec3i($this$wrap$iv.func_177958_n(), $this$wrap$iv.func_177956_o(), $this$wrap$iv.func_177952_p()); }
/*    */ 
/*    */   
/*    */   public int getAxisOrdinal() {
/*    */     return this.wrapped.func_176740_k().ordinal();
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof EnumFacingImpl && ((EnumFacingImpl)other).wrapped == this.wrapped);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EnumFacingImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */