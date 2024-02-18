/*    */ package net.ccbluex.liquidbounce.api.minecraft.util;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\017\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\004\030\0002\0020\001B\017\b\026\022\006\020\002\032\0020\003¢\006\002\020\004B\035\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\006¢\006\002\020\tJ\021\020\016\032\0020\0002\006\020\017\032\0020\000H\bJ!\020\020\032\0020\0002\006\020\021\032\0020\0062\006\020\022\032\0020\0062\006\020\023\032\0020\006H\bJ\016\020\024\032\0020\0062\006\020\017\032\0020\000J\023\020\025\032\0020\0262\b\020\027\032\004\030\0010\001H\002J\b\020\030\032\0020\031H\026J\016\020\032\032\0020\0002\006\020\033\032\0020\034J\016\020\035\032\0020\0002\006\020\036\032\0020\034J\021\020\037\032\0020\0062\006\020\017\032\0020\000H\bR\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\n\020\013R\021\020\007\032\0020\006¢\006\b\n\000\032\004\b\f\020\013R\021\020\b\032\0020\006¢\006\b\n\000\032\004\b\r\020\013¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V", "xCoord", "", "yCoord", "zCoord", "(DDD)V", "getXCoord", "()D", "getYCoord", "getZCoord", "add", "vec", "addVector", "x", "y", "z", "distanceTo", "equals", "", "other", "hashCode", "", "rotatePitch", "pitch", "", "rotateYaw", "yaw", "squareDistanceTo", "XSJClient"})
/*    */ public final class WVec3 {
/*    */   private final double xCoord;
/*    */   
/*  8 */   public WVec3(double xCoord, double yCoord, double zCoord) { this.xCoord = xCoord; this.yCoord = yCoord; this.zCoord = zCoord; } private final double yCoord; private final double zCoord; public final double getXCoord() {
/*  9 */     return this.xCoord; }
/* 10 */   public final double getYCoord() { return this.yCoord; }
/* 11 */   public final double getZCoord() { return this.zCoord; } @NotNull
/*    */   public final WVec3 addVector(double x, double y, double z) {
/* 13 */     int $i$f$addVector = 0; return new WVec3(getXCoord() + x, getYCoord() + y, getZCoord() + z);
/*    */   }
/*    */   public final double distanceTo(@NotNull WVec3 vec) {
/* 16 */     Intrinsics.checkParameterIsNotNull(vec, "vec"); double d0 = vec.xCoord - this.xCoord;
/* 17 */     double d1 = vec.yCoord - this.yCoord;
/* 18 */     double d2 = vec.zCoord - this.zCoord;
/*    */     
/* 20 */     double d3 = d0 * d0 + d1 * d1 + d2 * d2; boolean bool = false; return Math.sqrt(d3);
/*    */   }
/*    */   
/*    */   public final double squareDistanceTo(@NotNull WVec3 vec) {
/* 24 */     int $i$f$squareDistanceTo = 0; Intrinsics.checkParameterIsNotNull(vec, "vec"); double d0 = vec.getXCoord() - getXCoord();
/* 25 */     double d1 = vec.getYCoord() - getYCoord();
/* 26 */     double d2 = vec.getZCoord() - getZCoord();
/*    */     
/* 28 */     return d0 * d0 + d1 * d1 + d2 * d2;
/*    */   } @NotNull
/*    */   public final WVec3 add(@NotNull WVec3 vec) {
/* 31 */     int $i$f$add = 0; Intrinsics.checkParameterIsNotNull(vec, "vec"); WVec3 wVec3 = this; double d1 = vec.getXCoord(), d2 = vec.getYCoord(), z$iv = vec.getZCoord(); int $i$f$addVector = 0; return 
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
/* 75 */       new WVec3(wVec3.getXCoord() + d1, wVec3.getYCoord() + d2, wVec3.getZCoord() + z$iv);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final WVec3 rotatePitch(float pitch) {
/*    */     boolean bool1 = false;
/*    */     float f = (float)Math.cos(pitch);
/*    */     boolean bool2 = false;
/*    */     float f1 = (float)Math.sin(pitch);
/*    */     double d0 = this.xCoord;
/*    */     double d1 = this.yCoord * f + this.zCoord * f1;
/*    */     double d2 = this.zCoord * f - this.yCoord * f1;
/*    */     return new WVec3(d0, d1, d2);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final WVec3 rotateYaw(float yaw) {
/*    */     boolean bool1 = false;
/*    */     float f = (float)Math.cos(yaw);
/*    */     boolean bool2 = false;
/*    */     float f1 = (float)Math.sin(yaw);
/*    */     double d0 = this.xCoord * f + this.zCoord * f1;
/*    */     double d1 = this.yCoord;
/*    */     double d2 = this.zCoord * f - this.xCoord * f1;
/*    */     return new WVec3(d0, d1, d2);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     if (this == other)
/*    */       return true; 
/*    */     if ((Intrinsics.areEqual(getClass(), (other != null) ? other.getClass() : null) ^ true) != 0)
/*    */       return false; 
/*    */     if (other == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.util.WVec3"); 
/*    */     (WVec3)other;
/*    */     if (this.xCoord != ((WVec3)other).xCoord)
/*    */       return false; 
/*    */     if (this.yCoord != ((WVec3)other).yCoord)
/*    */       return false; 
/*    */     if (this.zCoord != ((WVec3)other).zCoord)
/*    */       return false; 
/*    */     return true;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     int result = Double.hashCode(this.xCoord);
/*    */     result = 31 * result + Double.hashCode(this.yCoord);
/*    */     result = 31 * result + Double.hashCode(this.zCoord);
/*    */     return result;
/*    */   }
/*    */   
/*    */   public WVec3(@NotNull WVec3i blockPos) {
/*    */     this(blockPos.getX(), blockPos.getY(), blockPos.getZ());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\WVec3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */