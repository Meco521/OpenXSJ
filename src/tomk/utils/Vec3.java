/*     */ package tomk.utils;
/*     */ 
/*     */ import lynn.utils.blur.MathHelper;
/*     */ import net.minecraft.util.math.Vec3i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vec3
/*     */ {
/*     */   public final double xCoord;
/*     */   public final double yCoord;
/*     */   public final double zCoord;
/*     */   
/*     */   public Vec3(double p_i1108_1_, double p_i1108_3_, double p_i1108_5_) {
/*  17 */     if (p_i1108_1_ == -0.0D) {
/*  18 */       p_i1108_1_ = 0.0D;
/*     */     }
/*     */     
/*  21 */     if (p_i1108_3_ == -0.0D) {
/*  22 */       p_i1108_3_ = 0.0D;
/*     */     }
/*     */     
/*  25 */     if (p_i1108_5_ == -0.0D) {
/*  26 */       p_i1108_5_ = 0.0D;
/*     */     }
/*     */     
/*  29 */     this.xCoord = p_i1108_1_;
/*  30 */     this.yCoord = p_i1108_3_;
/*  31 */     this.zCoord = p_i1108_5_;
/*     */   }
/*     */   
/*     */   public Vec3(Vec3i p_i46377_1_) {
/*  35 */     this(p_i46377_1_.func_177958_n(), p_i46377_1_.func_177956_o(), p_i46377_1_.func_177952_p());
/*     */   }
/*     */   
/*     */   public Vec3 subtractReverse(Vec3 p_subtractReverse_1_) {
/*  39 */     return new Vec3(p_subtractReverse_1_.xCoord - this.xCoord, p_subtractReverse_1_.yCoord - this.yCoord, p_subtractReverse_1_.zCoord - this.zCoord);
/*     */   }
/*     */   
/*     */   public Vec3 normalize() {
/*  43 */     double d0 = MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
/*  44 */     return (d0 < 1.0E-4D) ? new Vec3(0.0D, 0.0D, 0.0D) : new Vec3(this.xCoord / d0, this.yCoord / d0, this.zCoord / d0);
/*     */   }
/*     */   
/*     */   public double dotProduct(Vec3 p_dotProduct_1_) {
/*  48 */     return this.xCoord * p_dotProduct_1_.xCoord + this.yCoord * p_dotProduct_1_.yCoord + this.zCoord * p_dotProduct_1_.zCoord;
/*     */   }
/*     */   
/*     */   public Vec3 crossProduct(Vec3 p_crossProduct_1_) {
/*  52 */     return new Vec3(this.yCoord * p_crossProduct_1_.zCoord - this.zCoord * p_crossProduct_1_.yCoord, this.zCoord * p_crossProduct_1_.xCoord - this.xCoord * p_crossProduct_1_.zCoord, this.xCoord * p_crossProduct_1_.yCoord - this.yCoord * p_crossProduct_1_.xCoord);
/*     */   }
/*     */   
/*     */   public Vec3 subtract(Vec3 p_subtract_1_) {
/*  56 */     return subtract(p_subtract_1_.xCoord, p_subtract_1_.yCoord, p_subtract_1_.zCoord);
/*     */   }
/*     */   
/*     */   public Vec3 subtract(double p_subtract_1_, double p_subtract_3_, double p_subtract_5_) {
/*  60 */     return addVector(-p_subtract_1_, -p_subtract_3_, -p_subtract_5_);
/*     */   }
/*     */   
/*     */   public Vec3 add(Vec3 p_add_1_) {
/*  64 */     return addVector(p_add_1_.xCoord, p_add_1_.yCoord, p_add_1_.zCoord);
/*     */   }
/*     */   
/*     */   public Vec3 addVector(double p_addVector_1_, double p_addVector_3_, double p_addVector_5_) {
/*  68 */     return new Vec3(this.xCoord + p_addVector_1_, this.yCoord + p_addVector_3_, this.zCoord + p_addVector_5_);
/*     */   }
/*     */   
/*     */   public double distanceTo(Vec3 p_distanceTo_1_) {
/*  72 */     double d0 = p_distanceTo_1_.xCoord - this.xCoord;
/*  73 */     double d1 = p_distanceTo_1_.yCoord - this.yCoord;
/*  74 */     double d2 = p_distanceTo_1_.zCoord - this.zCoord;
/*  75 */     return MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
/*     */   }
/*     */   
/*     */   public double squareDistanceTo(Vec3 p_squareDistanceTo_1_) {
/*  79 */     double d0 = p_squareDistanceTo_1_.xCoord - this.xCoord;
/*  80 */     double d1 = p_squareDistanceTo_1_.yCoord - this.yCoord;
/*  81 */     double d2 = p_squareDistanceTo_1_.zCoord - this.zCoord;
/*  82 */     return d0 * d0 + d1 * d1 + d2 * d2;
/*     */   }
/*     */   
/*     */   public double lengthVector() {
/*  86 */     return MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
/*     */   }
/*     */   
/*     */   public Vec3 getIntermediateWithXValue(Vec3 p_getIntermediateWithXValue_1_, double p_getIntermediateWithXValue_2_) {
/*  90 */     double d0 = p_getIntermediateWithXValue_1_.xCoord - this.xCoord;
/*  91 */     double d1 = p_getIntermediateWithXValue_1_.yCoord - this.yCoord;
/*  92 */     double d2 = p_getIntermediateWithXValue_1_.zCoord - this.zCoord;
/*  93 */     if (d0 * d0 < 1.0000000116860974E-7D) {
/*  94 */       return null;
/*     */     }
/*  96 */     double d3 = (p_getIntermediateWithXValue_2_ - this.xCoord) / d0;
/*  97 */     return (d3 >= 0.0D && d3 <= 1.0D) ? new Vec3(this.xCoord + d0 * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getIntermediateWithYValue(Vec3 p_getIntermediateWithYValue_1_, double p_getIntermediateWithYValue_2_) {
/* 102 */     double d0 = p_getIntermediateWithYValue_1_.xCoord - this.xCoord;
/* 103 */     double d1 = p_getIntermediateWithYValue_1_.yCoord - this.yCoord;
/* 104 */     double d2 = p_getIntermediateWithYValue_1_.zCoord - this.zCoord;
/* 105 */     if (d1 * d1 < 1.0000000116860974E-7D) {
/* 106 */       return null;
/*     */     }
/* 108 */     double d3 = (p_getIntermediateWithYValue_2_ - this.yCoord) / d1;
/* 109 */     return (d3 >= 0.0D && d3 <= 1.0D) ? new Vec3(this.xCoord + d0 * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getIntermediateWithZValue(Vec3 p_getIntermediateWithZValue_1_, double p_getIntermediateWithZValue_2_) {
/* 114 */     double d0 = p_getIntermediateWithZValue_1_.xCoord - this.xCoord;
/* 115 */     double d1 = p_getIntermediateWithZValue_1_.yCoord - this.yCoord;
/* 116 */     double d2 = p_getIntermediateWithZValue_1_.zCoord - this.zCoord;
/* 117 */     if (d2 * d2 < 1.0000000116860974E-7D) {
/* 118 */       return null;
/*     */     }
/* 120 */     double d3 = (p_getIntermediateWithZValue_2_ - this.zCoord) / d2;
/* 121 */     return (d3 >= 0.0D && d3 <= 1.0D) ? new Vec3(this.xCoord + d0 * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 126 */     return "(" + this.xCoord + ", " + this.yCoord + ", " + this.zCoord + ")";
/*     */   }
/*     */   
/*     */   public Vec3 rotatePitch(float p_rotatePitch_1_) {
/* 130 */     float f = MathHelper.cos(p_rotatePitch_1_);
/* 131 */     float f1 = MathHelper.sin(p_rotatePitch_1_);
/* 132 */     double d0 = this.xCoord;
/* 133 */     double d1 = this.yCoord * f + this.zCoord * f1;
/* 134 */     double d2 = this.zCoord * f - this.yCoord * f1;
/* 135 */     return new Vec3(d0, d1, d2);
/*     */   }
/*     */   
/*     */   public Vec3 rotateYaw(float p_rotateYaw_1_) {
/* 139 */     float f = MathHelper.cos(p_rotateYaw_1_);
/* 140 */     float f1 = MathHelper.sin(p_rotateYaw_1_);
/* 141 */     double d0 = this.xCoord * f + this.zCoord * f1;
/* 142 */     double d1 = this.yCoord;
/* 143 */     double d2 = this.zCoord * f - this.xCoord * f1;
/* 144 */     return new Vec3(d0, d1, d2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\Vec3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */