/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.RayTraceResult;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\033\032\0020\0342\b\020\035\032\004\030\0010\036H\002R\026\020\005\032\004\030\0010\0068VX\004¢\006\006\032\004\b\007\020\bR\026\020\t\032\004\030\0010\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R\026\020\021\032\004\030\0010\0228VX\004¢\006\006\032\004\b\023\020\024R\024\020\025\032\0020\0268VX\004¢\006\006\032\004\b\027\020\030R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\031\020\032¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/MovingObjectPositionImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "wrapped", "Lnet/minecraft/util/math/RayTraceResult;", "(Lnet/minecraft/util/math/RayTraceResult;)V", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getBlockPos", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "entityHit", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getEntityHit", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "hitVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "getHitVec", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "sideHit", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getSideHit", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "typeOfHit", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;", "getTypeOfHit", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;", "getWrapped", "()Lnet/minecraft/util/math/RayTraceResult;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class MovingObjectPositionImpl implements IMovingObjectPosition {
/*    */   @NotNull
/* 12 */   public final RayTraceResult getWrapped() { return this.wrapped; } @NotNull private final RayTraceResult wrapped; public MovingObjectPositionImpl(@NotNull RayTraceResult wrapped) { this.wrapped = wrapped; }
/*    */   @Nullable
/* 14 */   public IEntity getEntityHit() { Entity $this$wrap$iv = this.wrapped.field_72308_g; int $i$f$wrap = 0; return (this.wrapped.field_72308_g != null) ? 
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
/* 32 */       new EntityImpl<>($this$wrap$iv) : null; } @Nullable public WBlockPos getBlockPos() { if (this.wrapped.func_178782_a() != null) { BlockPos $this$wrap$iv = this.wrapped.func_178782_a(); int $i$f$wrap = 0; }
/* 33 */     else { new WBlockPos($this$wrap$iv.func_177958_n(), $this$wrap$iv.func_177956_o(), $this$wrap$iv.func_177952_p()); }  return null; } @Nullable public IEnumFacing getSideHit() { EnumFacing $this$wrap$iv = this.wrapped.field_178784_b; int $i$f$wrap = 0;
/* 34 */     return (this.wrapped.field_178784_b != null) ? new EnumFacingImpl($this$wrap$iv) : null; } @NotNull public WVec3 getHitVec() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_72307_f, "wrapped.hitVec"); Vec3d $this$wrap$iv = this.wrapped.field_72307_f; int $i$f$wrap = 0;
/* 35 */     return new WVec3($this$wrap$iv.field_72450_a, $this$wrap$iv.field_72448_b, $this$wrap$iv.field_72449_c); } @NotNull public IMovingObjectPosition.WMovingObjectType getTypeOfHit() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_72313_a, "wrapped.typeOfHit"); RayTraceResult.Type $this$wrap$iv = this.wrapped.field_72313_a; int $i$f$wrap = 0;
/* 36 */     switch (BackendExtentionsKt.WhenMappings.$EnumSwitchMapping$0[$this$wrap$iv.ordinal()]) { case 1: 
/*    */       case 2: 
/*    */       case 3:
/* 39 */        }  throw new NoWhenBranchMatchedException(); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof MovingObjectPositionImpl && Intrinsics.areEqual(((MovingObjectPositionImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\MovingObjectPositionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */