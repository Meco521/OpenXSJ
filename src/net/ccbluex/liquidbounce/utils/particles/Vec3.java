/*     */ package net.ccbluex.liquidbounce.utils.particles;
/*     */ 
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.math.Vec3i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vec3
/*     */ {
/*     */   public double xCoord;
/*     */   public double yCoord;
/*     */   public double zCoord;
/*     */   
/*     */   public Vec3(double x, double y, double z) {
/*  30 */     if (x == -0.0D) {
/*  31 */       x = 0.0D;
/*     */     }
/*     */     
/*  34 */     if (y == -0.0D) {
/*  35 */       y = 0.0D;
/*     */     }
/*     */     
/*  38 */     if (z == -0.0D) {
/*  39 */       z = 0.0D;
/*     */     }
/*     */     
/*  42 */     this.xCoord = x;
/*  43 */     this.yCoord = y;
/*  44 */     this.zCoord = z;
/*     */   }
/*     */   
/*     */   public Vec3(Vec3i p_i46377_1_) {
/*  48 */     this(p_i46377_1_.func_177958_n(), p_i46377_1_.func_177956_o(), p_i46377_1_.func_177952_p());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 subtractReverse(Vec3 vec) {
/*  55 */     return new Vec3(vec.xCoord - this.xCoord, vec.yCoord - this.yCoord, vec.zCoord - this.zCoord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 normalize() {
/*  62 */     double d0 = MathHelper.func_76133_a(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
/*  63 */     return (d0 < 1.0E-4D) ? new Vec3(0.0D, 0.0D, 0.0D) : new Vec3(this.xCoord / d0, this.yCoord / d0, this.zCoord / d0);
/*     */   }
/*     */   
/*     */   public double dotProduct(Vec3 vec) {
/*  67 */     return this.xCoord * vec.xCoord + this.yCoord * vec.yCoord + this.zCoord * vec.zCoord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 crossProduct(Vec3 vec) {
/*  74 */     return new Vec3(this.yCoord * vec.zCoord - this.zCoord * vec.yCoord, this.zCoord * vec.xCoord - this.xCoord * vec.zCoord, this.xCoord * vec.yCoord - this.yCoord * vec.xCoord);
/*     */   }
/*     */   
/*     */   public Vec3 subtract(Vec3 vec) {
/*  78 */     return subtract(vec.xCoord, vec.yCoord, vec.zCoord);
/*     */   }
/*     */   
/*     */   public Vec3 subtract(double x, double y, double z) {
/*  82 */     return addVector(-x, -y, -z);
/*     */   }
/*     */   
/*     */   public Vec3 add(Vec3 vec) {
/*  86 */     return addVector(vec.xCoord, vec.yCoord, vec.zCoord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 addVector(double x, double y, double z) {
/*  94 */     return new Vec3(this.xCoord + x, this.yCoord + y, this.zCoord + z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double distanceTo(Vec3 vec) {
/* 101 */     double d0 = vec.xCoord - this.xCoord;
/* 102 */     double d1 = vec.yCoord - this.yCoord;
/* 103 */     double d2 = vec.zCoord - this.zCoord;
/* 104 */     return MathHelper.func_76133_a(d0 * d0 + d1 * d1 + d2 * d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double squareDistanceTo(Vec3 vec) {
/* 111 */     double d0 = vec.xCoord - this.xCoord;
/* 112 */     double d1 = vec.yCoord - this.yCoord;
/* 113 */     double d2 = vec.zCoord - this.zCoord;
/* 114 */     return d0 * d0 + d1 * d1 + d2 * d2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double lengthVector() {
/* 121 */     return MathHelper.func_76133_a(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getIntermediateWithXValue(Vec3 vec, double x) {
/* 129 */     double d0 = vec.xCoord - this.xCoord;
/* 130 */     double d1 = vec.yCoord - this.yCoord;
/* 131 */     double d2 = vec.zCoord - this.zCoord;
/*     */     
/* 133 */     if (d0 * d0 < 1.0000000116860974E-7D) {
/* 134 */       return null;
/*     */     }
/* 136 */     double d3 = (x - this.xCoord) / d0;
/* 137 */     return (d3 >= 0.0D && d3 <= 1.0D) ? new Vec3(this.xCoord + d0 * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getIntermediateWithYValue(Vec3 vec, double y) {
/* 146 */     double d0 = vec.xCoord - this.xCoord;
/* 147 */     double d1 = vec.yCoord - this.yCoord;
/* 148 */     double d2 = vec.zCoord - this.zCoord;
/*     */     
/* 150 */     if (d1 * d1 < 1.0000000116860974E-7D) {
/* 151 */       return null;
/*     */     }
/* 153 */     double d3 = (y - this.yCoord) / d1;
/* 154 */     return (d3 >= 0.0D && d3 <= 1.0D) ? new Vec3(this.xCoord + d0 * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getIntermediateWithZValue(Vec3 vec, double z) {
/* 163 */     double d0 = vec.xCoord - this.xCoord;
/* 164 */     double d1 = vec.yCoord - this.yCoord;
/* 165 */     double d2 = vec.zCoord - this.zCoord;
/*     */     
/* 167 */     if (d2 * d2 < 1.0000000116860974E-7D) {
/* 168 */       return null;
/*     */     }
/* 170 */     double d3 = (z - this.zCoord) / d2;
/* 171 */     return (d3 >= 0.0D && d3 <= 1.0D) ? new Vec3(this.xCoord + d0 * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     return "(" + this.xCoord + ", " + this.yCoord + ", " + this.zCoord + ")";
/*     */   }
/*     */   
/*     */   public Vec3 rotatePitch(float pitch) {
/* 180 */     float f = MathHelper.func_76134_b(pitch);
/* 181 */     float f1 = MathHelper.func_76126_a(pitch);
/* 182 */     double d0 = this.xCoord;
/* 183 */     double d1 = this.yCoord * f + this.zCoord * f1;
/* 184 */     double d2 = this.zCoord * f - this.yCoord * f1;
/* 185 */     return new Vec3(d0, d1, d2);
/*     */   }
/*     */   
/*     */   public Vec3 rotateYaw(float yaw) {
/* 189 */     float f = MathHelper.func_76134_b(yaw);
/* 190 */     float f1 = MathHelper.func_76126_a(yaw);
/* 191 */     double d0 = this.xCoord * f + this.zCoord * f1;
/* 192 */     double d1 = this.yCoord;
/* 193 */     double d2 = this.zCoord * f - this.xCoord * f1;
/* 194 */     return new Vec3(d0, d1, d2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\particles\Vec3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */