/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\023\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\000\n\002\b\n\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J \020\025\032\0020\0012\006\020\026\032\0020\0062\006\020\027\032\0020\0062\006\020\030\032\0020\006H\026J\032\020\031\032\004\030\0010\0322\006\020\033\032\0020\0342\006\020\035\032\0020\034H\026J\023\020\036\032\0020\0372\b\020 \032\004\030\0010!H\002J \020\"\032\0020\0012\006\020\026\032\0020\0062\006\020\027\032\0020\0062\006\020\030\032\0020\006H\026J\020\020#\032\0020\0372\006\020$\032\0020\001H\026J\020\020%\032\0020\0372\006\020&\032\0020\034H\026J \020'\032\0020\0012\006\020(\032\0020\0062\006\020)\032\0020\0062\006\020*\032\0020\006H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\0068VX\004¢\006\006\032\004\b\n\020\bR\024\020\013\032\0020\0068VX\004¢\006\006\032\004\b\f\020\bR\024\020\r\032\0020\0068VX\004¢\006\006\032\004\b\016\020\bR\024\020\017\032\0020\0068VX\004¢\006\006\032\004\b\020\020\bR\024\020\021\032\0020\0068VX\004¢\006\006\032\004\b\022\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\023\020\024¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/AxisAlignedBBImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "wrapped", "Lnet/minecraft/util/math/AxisAlignedBB;", "(Lnet/minecraft/util/math/AxisAlignedBB;)V", "maxX", "", "getMaxX", "()D", "maxY", "getMaxY", "maxZ", "getMaxZ", "minX", "getMinX", "minY", "getMinY", "minZ", "getMinZ", "getWrapped", "()Lnet/minecraft/util/math/AxisAlignedBB;", "addCoord", "x", "y", "z", "calculateIntercept", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "from", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "to", "equals", "", "other", "", "expand", "intersectsWith", "boundingBox", "isVecInside", "vec", "offset", "sx", "sy", "sz", "XSJClient"})
/*    */ public final class AxisAlignedBBImpl implements IAxisAlignedBB {
/*    */   @NotNull
/* 10 */   public final AxisAlignedBB getWrapped() { return this.wrapped; } @NotNull private final AxisAlignedBB wrapped; public AxisAlignedBBImpl(@NotNull AxisAlignedBB wrapped) { this.wrapped = wrapped; } @NotNull
/* 11 */   public IAxisAlignedBB addCoord(double x, double y, double z) { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_72321_a(x, y, z), "wrapped.expand(x, y, z)"); AxisAlignedBB $this$wrap$iv = this.wrapped.func_72321_a(x, y, z); int $i$f$wrap = 0; return 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 43 */       new AxisAlignedBBImpl($this$wrap$iv); } @NotNull public IAxisAlignedBB expand(double x, double y, double z) { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_72314_b(x, y, z), "wrapped.grow(x, y, z)"); AxisAlignedBB $this$wrap$iv = this.wrapped.func_72314_b(x, y, z); int $i$f$wrap = 0;
/* 44 */     return new AxisAlignedBBImpl($this$wrap$iv); } @Nullable public IMovingObjectPosition calculateIntercept(@NotNull WVec3 from, @NotNull WVec3 to) { Intrinsics.checkParameterIsNotNull(from, "from"); Intrinsics.checkParameterIsNotNull(to, "to"); WVec3 wVec31 = from; AxisAlignedBB axisAlignedBB = this.wrapped; int $i$f$unwrap = 0;
/* 45 */     Vec3d vec3d1 = new Vec3d(wVec31.getXCoord(), wVec31.getYCoord(), wVec31.getZCoord()); WVec3 $this$unwrap$iv = to; vec3d1 = vec3d1; axisAlignedBB = axisAlignedBB; $i$f$unwrap = 0;
/* 46 */     Vec3d vec3d2 = new Vec3d($this$unwrap$iv.getXCoord(), $this$unwrap$iv.getYCoord(), $this$unwrap$iv.getZCoord()); RayTraceResult $this$wrap$iv = axisAlignedBB.func_72327_a(vec3d1, vec3d2); int $i$f$wrap = 0; axisAlignedBB.func_72327_a(vec3d1, vec3d2); return (axisAlignedBB.func_72327_a(vec3d1, vec3d2) != null) ? 
/* 47 */       new MovingObjectPositionImpl($this$wrap$iv) : null; } public boolean isVecInside(@NotNull WVec3 vec) { Intrinsics.checkParameterIsNotNull(vec, "vec"); WVec3 wVec3 = vec; AxisAlignedBB axisAlignedBB = this.wrapped; int $i$f$unwrap = 0;
/* 48 */     Vec3d vec3d = new Vec3d(wVec3.getXCoord(), wVec3.getYCoord(), wVec3.getZCoord()); return axisAlignedBB.func_72318_a(vec3d); } @NotNull public IAxisAlignedBB offset(double sx, double sy, double sz) { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_72317_d(sx, sy, sz), "wrapped.offset(sx, sy, sz)"); AxisAlignedBB $this$wrap$iv = this.wrapped.func_72317_d(sx, sy, sz); int $i$f$wrap = 0;
/* 49 */     return new AxisAlignedBBImpl($this$wrap$iv); } public boolean intersectsWith(@NotNull IAxisAlignedBB boundingBox) { Intrinsics.checkParameterIsNotNull(boundingBox, "boundingBox"); IAxisAlignedBB iAxisAlignedBB = boundingBox; AxisAlignedBB axisAlignedBB1 = this.wrapped; int $i$f$unwrap = 0;
/* 50 */     AxisAlignedBB axisAlignedBB2 = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); return axisAlignedBB1.func_72326_a(axisAlignedBB2); }
/*    */ 
/*    */   
/*    */   public double getMinX() {
/*    */     return this.wrapped.field_72340_a;
/*    */   }
/*    */   
/*    */   public double getMinY() {
/*    */     return this.wrapped.field_72338_b;
/*    */   }
/*    */   
/*    */   public double getMinZ() {
/*    */     return this.wrapped.field_72339_c;
/*    */   }
/*    */   
/*    */   public double getMaxX() {
/*    */     return this.wrapped.field_72336_d;
/*    */   }
/*    */   
/*    */   public double getMaxY() {
/*    */     return this.wrapped.field_72337_e;
/*    */   }
/*    */   
/*    */   public double getMaxZ() {
/*    */     return this.wrapped.field_72334_f;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof AxisAlignedBBImpl && Intrinsics.areEqual(((AxisAlignedBBImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\AxisAlignedBBImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */