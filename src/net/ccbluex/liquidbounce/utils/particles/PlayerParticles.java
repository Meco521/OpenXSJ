/*     */ package net.ccbluex.liquidbounce.utils.particles;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.vecmath.Vector3f;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
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
/*     */ 
/*     */ 
/*     */ public class PlayerParticles
/*     */ {
/*  36 */   private static Minecraft mc = Minecraft.func_71410_x();
/*     */   
/*     */   public static float[] getRotations(Entity ent) {
/*  39 */     double x = ent.field_70165_t;
/*  40 */     double z = ent.field_70161_v;
/*  41 */     double y = ent.field_70163_u + (ent.func_70047_e() / 4.0F);
/*  42 */     return getRotationFromPosition(x, z, y);
/*     */   }
/*     */   public static Block getBlock(double offsetX, double offsetY, double offsetZ) {
/*  45 */     return mc.field_71441_e.func_180495_p(new BlockPos(offsetX, offsetY, offsetZ)).func_177230_c();
/*     */   }
/*     */   
/*     */   private static float[] getRotationFromPosition(double x, double z, double y) {
/*  49 */     double xDiff = x - mc.field_71439_g.field_70165_t;
/*  50 */     double zDiff = z - mc.field_71439_g.field_70161_v;
/*  51 */     double yDiff = y - mc.field_71439_g.field_70163_u - 0.6D;
/*  52 */     double dist = MathHelper.func_76133_a(xDiff * xDiff + zDiff * zDiff);
/*  53 */     float yaw = (float)(Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F;
/*  54 */     float pitch = (float)-(Math.atan2(yDiff, dist) * 180.0D / Math.PI);
/*  55 */     return new float[] { yaw, pitch };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getDirection() {
/*  61 */     float yaw = mc.field_71439_g.field_70759_as;
/*  62 */     float forward = mc.field_71439_g.field_191988_bg;
/*  63 */     float strafe = mc.field_71439_g.field_70702_br;
/*  64 */     yaw += ((forward < 0.0F) ? '´' : false);
/*  65 */     if (strafe < 0.0F) {
/*  66 */       yaw += ((forward < 0.0F) ? -45 : ((forward == 0.0F) ? 90 : 45));
/*     */     }
/*  68 */     if (strafe > 0.0F) {
/*  69 */       yaw -= ((forward < 0.0F) ? -45 : ((forward == 0.0F) ? 90 : 45));
/*     */     }
/*  71 */     return yaw * 0.017453292F;
/*     */   }
/*     */   
/*     */   public static boolean isInWater() {
/*  75 */     return (mc.field_71441_e.func_180495_p(new BlockPos(mc.field_71439_g.field_70165_t, mc.field_71439_g.field_70163_u, mc.field_71439_g.field_70161_v)).func_185904_a() == Material.field_151586_h);
/*     */   }
/*     */   
/*     */   public static Block getBlock(BlockPos pos) {
/*  79 */     return mc.field_71441_e.func_180495_p(pos).func_177230_c();
/*     */   }
/*     */   
/*     */   public static Block getBlockAtPosC(EntityPlayer inPlayer, double x, double y, double z) {
/*  83 */     return getBlock(new BlockPos(inPlayer.field_70165_t - x, inPlayer.field_70163_u - y, inPlayer.field_70161_v - z));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayList<Vector3f> vanillaTeleportPositions(double tpX, double tpY, double tpZ, double speed) {
/*  88 */     ArrayList<Vector3f> positions = new ArrayList();
/*  89 */     double posX = tpX - mc.field_71439_g.field_70165_t;
/*  90 */     double posY = tpY - mc.field_71439_g.field_70163_u + mc.field_71439_g.func_70047_e() + 1.1D;
/*  91 */     double posZ = tpZ - mc.field_71439_g.field_70161_v;
/*  92 */     float yaw = (float)(Math.atan2(posZ, posX) * 180.0D / Math.PI - 90.0D);
/*  93 */     float pitch = (float)(-Math.atan2(posY, Math.sqrt(posX * posX + posZ * posZ)) * 180.0D / Math.PI);
/*  94 */     double tmpX = mc.field_71439_g.field_70165_t;
/*  95 */     double tmpY = mc.field_71439_g.field_70163_u;
/*  96 */     double tmpZ = mc.field_71439_g.field_70161_v;
/*  97 */     double steps = 1.0D; double d;
/*  98 */     for (d = speed; d < getDistance(mc.field_71439_g.field_70165_t, mc.field_71439_g.field_70163_u, mc.field_71439_g.field_70161_v, tpX, tpY, tpZ); d += speed) {
/*  99 */       steps++;
/*     */     }
/* 101 */     for (d = speed; d < getDistance(mc.field_71439_g.field_70165_t, mc.field_71439_g.field_70163_u, mc.field_71439_g.field_70161_v, tpX, tpY, tpZ); d += speed) {
/* 102 */       tmpX = mc.field_71439_g.field_70165_t - Math.sin(getDirection(yaw)) * d;
/* 103 */       tmpZ = mc.field_71439_g.field_70161_v + Math.cos(getDirection(yaw)) * d;
/* 104 */       positions.add(new Vector3f((float)tmpX, (float)(tmpY -= (mc.field_71439_g.field_70163_u - tpY) / steps), (float)tmpZ));
/*     */     } 
/* 106 */     positions.add(new Vector3f((float)tpX, (float)tpY, (float)tpZ));
/* 107 */     return positions;
/*     */   }
/*     */   
/*     */   public static float getDirection(float yaw) {
/* 111 */     if (mc.field_71439_g.field_191988_bg < 0.0F) {
/* 112 */       yaw += 180.0F;
/*     */     }
/* 114 */     float forward = 1.0F;
/* 115 */     if (mc.field_71439_g.field_191988_bg < 0.0F) {
/* 116 */       forward = -0.5F;
/* 117 */     } else if (mc.field_71439_g.field_191988_bg > 0.0F) {
/* 118 */       forward = 0.5F;
/*     */     } 
/* 120 */     if (mc.field_71439_g.field_70702_br > 0.0F) {
/* 121 */       yaw -= 90.0F * forward;
/*     */     }
/* 123 */     if (mc.field_71439_g.field_70702_br < 0.0F) {
/* 124 */       yaw += 90.0F * forward;
/*     */     }
/* 126 */     return yaw *= 0.017453292F;
/*     */   }
/*     */   
/*     */   public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
/* 130 */     double d0 = x1 - x2;
/* 131 */     double d2 = y1 - y2;
/* 132 */     double d3 = z1 - z2;
/* 133 */     return MathHelper.func_76133_a(d0 * d0 + d2 * d2 + d3 * d3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hotbarIsFull() {
/* 140 */     for (int i = 0; i <= 36; ) {
/* 141 */       ItemStack itemstack = mc.field_71439_g.field_71071_by.func_70301_a(i);
/* 142 */       if (itemstack != null) { i++; continue; }
/* 143 */        return false;
/*     */     } 
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   public static Vec3 getLook(float p_174806_1_, float p_174806_2_) {
/* 149 */     float var3 = MathHelper.func_76134_b(-p_174806_2_ * 0.017453292F - 3.1415927F);
/* 150 */     float var4 = MathHelper.func_76126_a(-p_174806_2_ * 0.017453292F - 3.1415927F);
/* 151 */     float var5 = -MathHelper.func_76134_b(-p_174806_1_ * 0.017453292F);
/* 152 */     float var6 = MathHelper.func_76126_a(-p_174806_1_ * 0.017453292F);
/* 153 */     return new Vec3((var4 * var5), var6, (var3 * var5));
/*     */   }
/*     */   
/*     */   public static boolean isMoving() {
/* 157 */     if (!mc.field_71439_g.field_70123_F && !mc.field_71439_g.func_70093_af()) {
/* 158 */       return (mc.field_71439_g.field_71158_b.field_192832_b != 0.0F || mc.field_71439_g.field_71158_b.field_78902_a != 0.0F);
/*     */     }
/* 160 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityLivingBase getEntity() {
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   public static double getIncremental(double val, double inc) {
/* 169 */     double one = 1.0D / inc;
/* 170 */     return Math.round(val * one) / one;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\particles\PlayerParticles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */