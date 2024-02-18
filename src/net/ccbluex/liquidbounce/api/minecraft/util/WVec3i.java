/*    */ package net.ccbluex.liquidbounce.api.minecraft.util;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\006\n\002\b\003\n\002\020\b\n\002\b\006\n\002\020\013\n\002\b\003\b\026\030\0002\0020\001B\037\b\026\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006B\035\022\006\020\002\032\0020\007\022\006\020\004\032\0020\007\022\006\020\005\032\0020\007¢\006\002\020\bJ\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\001H\002J\b\020\020\032\0020\007H\026R\021\020\002\032\0020\007¢\006\b\n\000\032\004\b\t\020\nR\021\020\004\032\0020\007¢\006\b\n\000\032\004\b\013\020\nR\021\020\005\032\0020\007¢\006\b\n\000\032\004\b\f\020\n¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "", "x", "", "y", "z", "(DDD)V", "", "(III)V", "getX", "()I", "getY", "getZ", "equals", "", "other", "hashCode", "XSJClient"})
/*    */ public class WVec3i {
/*    */   private final int x;
/*    */   
/*  6 */   public WVec3i(int x, int y, int z) { this.x = x; this.y = y; this.z = z; } private final int y; private final int z; public final int getX() {
/*  7 */     return this.x; }
/*  8 */   public final int getY() { return this.y; } public final int getZ() {
/*  9 */     return this.z;
/*    */   } public WVec3i(double x, double y, double z) {
/* 11 */     this(i, j, (int)d3);
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 14 */     if (this == other) return true; 
/* 15 */     if ((Intrinsics.areEqual(getClass(), (other != null) ? other.getClass() : null) ^ true) != 0) return false;
/*    */     
/* 17 */     if (other == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.util.WVec3i");  (WVec3i)other;
/*    */     
/* 19 */     if (this.x != ((WVec3i)other).x) return false; 
/* 20 */     if (this.y != ((WVec3i)other).y) return false; 
/* 21 */     if (this.z != ((WVec3i)other).z) return false;
/*    */     
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 27 */     int result = this.x;
/* 28 */     result = 31 * result + this.y;
/* 29 */     result = 31 * result + this.z;
/* 30 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\WVec3i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */