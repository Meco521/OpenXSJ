/*    */ package net.ccbluex.liquidbounce.utils.pathfinder;
/*    */ 
/*    */ import net.minecraft.util.math.Vec3d;
/*    */ 
/*    */ public class Vec3 {
/*    */   private double x;
/*    */   
/*    */   public Vec3(double x, double y, double z) {
/*  9 */     this.x = x;
/* 10 */     this.y = y;
/* 11 */     this.z = z;
/*    */   }
/*    */   private double y; private double z;
/*    */   public double getX() {
/* 15 */     return this.x;
/*    */   }
/*    */   
/*    */   public double getY() {
/* 19 */     return this.y;
/*    */   }
/*    */   
/*    */   public double getZ() {
/* 23 */     return this.z;
/*    */   }
/*    */   
/*    */   public Vec3 addVector(double x, double y, double z) {
/* 27 */     return new Vec3(this.x + x, this.y + y, this.z + z);
/*    */   }
/*    */   
/*    */   public Vec3 floor() {
/* 31 */     return new Vec3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
/*    */   }
/*    */   
/*    */   public double squareDistanceTo(Vec3 v) {
/* 35 */     return Math.pow(v.x - this.x, 2.0D) + Math.pow(v.y - this.y, 2.0D) + Math.pow(v.z - this.z, 2.0D);
/*    */   }
/*    */   
/*    */   public Vec3 add(Vec3 v) {
/* 39 */     return addVector(v.getX(), v.getY(), v.getZ());
/*    */   }
/*    */   
/*    */   public Vec3d mc() {
/* 43 */     return new Vec3d(this.x, this.y, this.z);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return "[" + this.x + ";" + this.y + ";" + this.z + "]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\pathfinder\Vec3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */