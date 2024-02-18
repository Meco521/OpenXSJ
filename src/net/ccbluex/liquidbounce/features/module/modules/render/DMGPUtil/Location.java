/*     */ package net.ccbluex.liquidbounce.features.module.modules.render.DMGPUtil;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ 
/*     */ 
/*     */ public class Location
/*     */ {
/*     */   private double x;
/*     */   private double y;
/*     */   private double z;
/*     */   private float yaw;
/*     */   private float pitch;
/*     */   
/*     */   public Location(double x, double y, double z, float yaw, float pitch) {
/*  16 */     this.x = x;
/*  17 */     this.y = y;
/*  18 */     this.z = z;
/*  19 */     this.yaw = yaw;
/*  20 */     this.pitch = pitch;
/*     */   }
/*     */   
/*     */   public Location(double x, double y, double z) {
/*  24 */     this.x = x;
/*  25 */     this.y = y;
/*  26 */     this.z = z;
/*  27 */     this.yaw = 0.0F;
/*  28 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location(WBlockPos pos) {
/*  32 */     this.x = pos.getX();
/*  33 */     this.y = pos.getY();
/*  34 */     this.z = pos.getZ();
/*  35 */     this.yaw = 0.0F;
/*  36 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location(int x, int y, int z) {
/*  40 */     this.x = x;
/*  41 */     this.y = y;
/*  42 */     this.z = z;
/*  43 */     this.yaw = 0.0F;
/*  44 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location(EntityLivingBase entity) {
/*  48 */     this.x = entity.field_70165_t;
/*  49 */     this.y = entity.field_70163_u;
/*  50 */     this.z = entity.field_70161_v;
/*  51 */     this.yaw = 0.0F;
/*  52 */     this.pitch = 0.0F;
/*     */   }
/*     */   
/*     */   public Location add(int x, int y, int z) {
/*  56 */     this.x += x;
/*  57 */     this.y += y;
/*  58 */     this.z += z;
/*  59 */     return this;
/*     */   }
/*     */   
/*     */   public Location add(double x, double y, double z) {
/*  63 */     this.x += x;
/*  64 */     this.y += y;
/*  65 */     this.z += z;
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public double getX() {
/*  70 */     return this.x;
/*     */   }
/*     */   
/*     */   public Location setX(double x) {
/*  74 */     this.x = x;
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public double getY() {
/*  79 */     return this.y;
/*     */   }
/*     */   
/*     */   public Location setY(double y) {
/*  83 */     this.y = y;
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public double getZ() {
/*  88 */     return this.z;
/*     */   }
/*     */   
/*     */   public Location setZ(double z) {
/*  92 */     this.z = z;
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public float getYaw() {
/*  97 */     return this.yaw;
/*     */   }
/*     */   
/*     */   public Location setYaw(float yaw) {
/* 101 */     this.yaw = yaw;
/* 102 */     return this;
/*     */   }
/*     */   
/*     */   public float getPitch() {
/* 106 */     return this.pitch;
/*     */   }
/*     */   
/*     */   public Location setPitch(float pitch) {
/* 110 */     this.pitch = pitch;
/* 111 */     return this;
/*     */   }
/*     */   
/*     */   public double distanceTo(Location loc) {
/* 115 */     double dx = loc.x - this.x;
/* 116 */     double dz = loc.z - this.z;
/* 117 */     double dy = loc.y - this.y;
/* 118 */     return Math.sqrt(dx * dx + dy * dy + dz * dz);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\DMGPUtil\Location.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */