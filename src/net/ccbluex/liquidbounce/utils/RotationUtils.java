/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3i;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Listenable;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.FastBow;
/*     */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*     */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public final class RotationUtils
/*     */   extends MinecraftInstance
/*     */   implements Listenable
/*     */ {
/*  31 */   private static final Random random = new Random();
/*     */   
/*     */   private static int keepLength;
/*  34 */   public static final float[] lastRandomDeltaRotation = new float[] { 0.0F, 0.0F };
/*     */   
/*     */   public static Rotation targetRotation;
/*     */   
/*  38 */   public static Rotation serverRotation = new Rotation(0.0F, 0.0F);
/*     */   
/*     */   private static boolean lastHitable = false;
/*     */   
/*     */   public static boolean keepCurrentRotation = false;
/*  43 */   private static double x = random.nextDouble();
/*  44 */   private static double y = random.nextDouble();
/*  45 */   private static double z = random.nextDouble();
/*     */   public static Rotation getRotationsEntity(IEntityLivingBase entity) {
/*  47 */     return getRotations(entity.getPosX(), entity.getPosY() + entity.getEyeHeight() - 0.4D, entity.getPosZ());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Rotation getRotationFromEyeHasPrev(double x, double y, double z) {
/*  52 */     double xDiff = x - mc2.field_71439_g.field_70169_q + mc2.field_71439_g.field_70165_t - mc2.field_71439_g.field_70169_q;
/*  53 */     double yDiff = y - mc2.field_71439_g.field_70167_r + mc2.field_71439_g.field_70163_u - mc2.field_71439_g.field_70167_r + (mc2.field_71439_g.func_174813_aQ()).field_72337_e - (mc2.field_71439_g.func_174813_aQ()).field_72338_b;
/*  54 */     double zDiff = z - mc2.field_71439_g.field_70166_s + mc2.field_71439_g.field_70161_v - mc2.field_71439_g.field_70166_s;
/*  55 */     double dist = MathHelper.func_76133_a(xDiff * xDiff + zDiff * zDiff);
/*  56 */     return new Rotation((float)(Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F, (float)-(Math.atan2(yDiff, dist) * 180.0D / Math.PI));
/*     */   }
/*     */   public static VecRotation hyt(IAxisAlignedBB bb, boolean outborder, boolean random, boolean predict, boolean throughWalls, float distance) {
/*  59 */     if (outborder) {
/*  60 */       WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * (x * 0.3D + 1.0D), bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * (y * 0.3D + 1.0D), bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * (z * 0.3D + 1.0D));
/*  61 */       return new VecRotation(vec3, toRotation(vec3, predict));
/*     */     } 
/*     */     
/*  64 */     WVec3 randomVec = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * x * 0.8D, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * y * 0.8D, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * z * 0.8D);
/*  65 */     Rotation randomRotation = toRotation(randomVec, predict);
/*     */     
/*  67 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/*     */     
/*  69 */     double xMin = 0.0D;
/*  70 */     double yMin = 0.0D;
/*  71 */     double zMin = 0.0D;
/*  72 */     double xMax = 0.0D;
/*  73 */     double yMax = 0.0D;
/*  74 */     double zMax = 0.0D;
/*  75 */     double xDist = 0.0D;
/*  76 */     double yDist = 0.0D;
/*  77 */     double zDist = 0.0D;
/*     */ 
/*     */     
/*  80 */     VecRotation vecRotation = null; double xSearch;
/*  81 */     for (xSearch = xMin; xSearch < xMax; xSearch += xDist) {
/*  82 */       double ySearch; for (ySearch = yMin; ySearch < yMax; ySearch += yDist) {
/*  83 */         double zSearch; for (zSearch = zMin; zSearch < zMax; zSearch += zDist) {
/*  84 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * xSearch, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * ySearch, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * zSearch);
/*     */           
/*  86 */           Rotation rotation = toRotation(vec3, predict);
/*  87 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/*  89 */           if (vecDist <= distance)
/*     */           {
/*     */             
/*  92 */             if (throughWalls || isVisible(vec3)) {
/*  93 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/*  95 */               if (vecRotation == null || (random ? (getRotationDifference(currentVec.getRotation(), randomRotation) < getRotationDifference(vecRotation.getRotation(), randomRotation)) : (getRotationDifference(currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation()))))
/*  96 */                 vecRotation = currentVec; 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 102 */     return vecRotation;
/*     */   }
/*     */   public static Rotation bestServerRotation() {
/* 105 */     return (targetRotation != null) ? targetRotation : serverRotation;
/*     */   }
/*     */   
/*     */   public static VecRotation newSearchCenter(IAxisAlignedBB bb, boolean outborder, boolean random, boolean predict, boolean throughWalls, float distance) {
/* 109 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/*     */     
/* 111 */     VecRotation vecRotation = null;
/*     */     
/* 113 */     Rotation rot = bestServerRotation().cloneSelf();
/* 114 */     WVec3 nearestPointBB = PlayerExtensionKt.getNearestPointBB(eyes, bb);
/* 115 */     if (random || outborder) {
/* 116 */       lastRandomDeltaRotation[0] = lastRandomDeltaRotation[0] * 0.5F;
/* 117 */       lastRandomDeltaRotation[1] = lastRandomDeltaRotation[1] * 0.5F;
/* 118 */       if (RotationUtils.random.nextGaussian() > 0.2D) {
/* 119 */         lastRandomDeltaRotation[0] = lastRandomDeltaRotation[0] + RandomUtils.INSTANCE.nextFloat(-5.0F, 5.0F);
/* 120 */         rot.setYaw(lastRandomDeltaRotation[0] + rot.getYaw());
/*     */       } 
/* 122 */       if (RotationUtils.random.nextGaussian() > 0.2D) {
/* 123 */         lastRandomDeltaRotation[1] = lastRandomDeltaRotation[1] + RandomUtils.INSTANCE.nextFloat(-5.0F, 5.0F);
/* 124 */         rot.setPitch(lastRandomDeltaRotation[1] + rot.getPitch());
/*     */       } 
/* 126 */       if (outborder) {
/* 127 */         return new VecRotation(nearestPointBB, rot);
/*     */       }
/*     */     } 
/*     */     
/* 131 */     Rotation nearestRot = toRotation(nearestPointBB, predict);
/*     */     double xSearch;
/* 133 */     for (xSearch = 0.45D; xSearch < 0.65D; xSearch += 0.1D) {
/* 134 */       double ySearch; for (ySearch = 0.0D; ySearch < 1.0D; ySearch += 0.02D) {
/* 135 */         double zSearch; for (zSearch = 0.45D; zSearch < 0.65D; zSearch += 0.1D) {
/*     */ 
/*     */ 
/*     */           
/* 139 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * xSearch, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * ySearch, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * zSearch);
/*     */ 
/*     */           
/* 142 */           Rotation rotation = toRotation(vec3, predict);
/* 143 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/* 145 */           if (vecDist <= distance)
/*     */           {
/* 147 */             if (throughWalls || isVisible(vec3)) {
/* 148 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/* 150 */               if (vecRotation == null || getRotationDifference(currentVec.getRotation(), rot) < getRotationDifference(vecRotation.getRotation(), rot)) {
/* 151 */                 vecRotation = currentVec;
/* 152 */               } else if (!lastHitable && (
/* 153 */                 getRotationDifference(currentVec.getRotation(), rot) + getRotationDifference(currentVec.getRotation(), nearestRot)) / 2.0D < (getRotationDifference(vecRotation.getRotation(), rot) + getRotationDifference(vecRotation.getRotation(), nearestRot)) / 2.0D) {
/* 154 */                 vecRotation = currentVec;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 161 */     if (vecRotation != null)
/* 162 */     { lastHitable = (vecRotation.getVec().distanceTo(eyes) > distance); }
/* 163 */     else { lastHitable = false; }
/* 164 */      return vecRotation;
/*     */   }
/*     */   public static Rotation getRotationFromEyeHasPrev(IEntityLivingBase target) {
/* 167 */     double x = target.getPrevPosX() + target.getPosX() - target.getPrevPosX();
/* 168 */     double y = target.getPrevPosY() + target.getPosY() - target.getPrevPosY();
/* 169 */     double z = target.getPrevPosZ() + target.getPosZ() - target.getPosZ();
/* 170 */     return getRotationFromEyeHasPrev(x, y, z);
/*     */   }
/*     */   
/*     */   public static VecRotation lockView2(IAxisAlignedBB bb, boolean outborder, boolean random, boolean predict, boolean throughWalls, float distance) {
/* 174 */     if (outborder) {
/* 175 */       WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * (x * 0.3D + 1.0D), bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * (y * 0.3D + 1.0D), bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * (z * 0.3D + 1.0D));
/* 176 */       return new VecRotation(vec3, toRotation(vec3, predict));
/*     */     } 
/*     */     
/* 179 */     WVec3 randomVec = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * x * 0.8D, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * y * 0.8D, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * z * 0.8D);
/* 180 */     Rotation randomRotation = toRotation(randomVec, predict);
/*     */     
/* 182 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/*     */     
/* 184 */     double xMin = 0.0D;
/* 185 */     double yMin = 0.0D;
/* 186 */     double zMin = 0.0D;
/* 187 */     double xMax = 0.0D;
/* 188 */     double yMax = 0.0D;
/* 189 */     double zMax = 0.0D;
/* 190 */     double xDist = 0.0D;
/* 191 */     double yDist = 0.0D;
/* 192 */     double zDist = 0.0D;
/* 193 */     VecRotation vecRotation = null;
/* 194 */     xMin = 0.45D; xMax = 0.55D; xDist = 0.0125D;
/* 195 */     yMin = 0.7D; yMax = 0.85D; yDist = 0.0125D;
/* 196 */     zMin = 0.45D; zMax = 0.55D; zDist = 0.0125D; double xSearch;
/* 197 */     for (xSearch = xMin; xSearch < xMax; xSearch += xDist) {
/* 198 */       double ySearch; for (ySearch = yMin; ySearch < yMax; ySearch += yDist) {
/* 199 */         double zSearch; for (zSearch = zMin; zSearch < zMax; zSearch += zDist) {
/* 200 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * xSearch, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * ySearch, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * zSearch);
/*     */           
/* 202 */           Rotation rotation = toRotation(vec3, predict);
/* 203 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/* 205 */           if (vecDist <= distance)
/*     */           {
/*     */             
/* 208 */             if (throughWalls || isVisible(vec3)) {
/* 209 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/* 211 */               if (vecRotation == null || (random ? (getRotationDifference(currentVec.getRotation(), randomRotation) < getRotationDifference(vecRotation.getRotation(), randomRotation)) : (getRotationDifference(currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation()))))
/* 212 */                 vecRotation = currentVec; 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 218 */     return vecRotation;
/*     */   }
/*     */   public static Rotation getRotations(double posX, double posY, double posZ) {
/* 221 */     double x = posX - mc.getThePlayer().getPosX();
/* 222 */     double y = posY - mc.getThePlayer().getPosY() + mc.getThePlayer().getEyeHeight();
/* 223 */     double z = posZ - mc.getThePlayer().getPosZ();
/* 224 */     double dist = MathHelper.func_76133_a(x * x + z * z);
/* 225 */     float yaw = (float)(Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
/* 226 */     float pitch = (float)-(Math.atan2(y, dist) * 180.0D / Math.PI);
/* 227 */     return new Rotation(yaw, pitch);
/*     */   }
/*     */   public static float getAngleDifferencee(float a, float b) {
/* 230 */     return ((a - b) % 360.0F + 540.0F) % 360.0F - 180.0F;
/*     */   }
/*     */   
/*     */   public static Rotation OtherRotation(IAxisAlignedBB bb, WVec3 vec, boolean predict, boolean throughWalls, float distance) {
/* 234 */     WVec3 eyesPos = new WVec3(mc.getThePlayer().getPosX(), mc.getThePlayer().getEntityBoundingBox().getMinY() + mc.getThePlayer().getEyeHeight(), mc.getThePlayer().getPosZ());
/* 235 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/* 236 */     VecRotation vecRotation = null; double xSearch;
/* 237 */     for (xSearch = 0.15D; xSearch < 0.85D; xSearch += 0.1D) {
/* 238 */       double ySearch; for (ySearch = 0.15D; ySearch < 1.0D; ySearch += 0.1D) {
/* 239 */         double zSearch; for (zSearch = 0.15D; zSearch < 0.85D; zSearch += 0.1D) {
/*     */           
/* 241 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * xSearch, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * ySearch, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * zSearch);
/* 242 */           Rotation rotation = toRotation(vec3, predict);
/* 243 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/* 245 */           if (vecDist <= distance)
/*     */           {
/*     */             
/* 248 */             if (throughWalls || isVisible(vec3)) {
/* 249 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/* 251 */               if (vecRotation == null)
/* 252 */                 vecRotation = currentVec; 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 258 */     if (predict) eyesPos.addVector(mc.getThePlayer().getMotionX(), mc.getThePlayer().getMotionY(), mc.getThePlayer().getMotionZ());
/*     */     
/* 260 */     double diffX = vec.getXCoord() - eyesPos.getXCoord();
/* 261 */     double diffY = vec.getYCoord() - eyesPos.getYCoord();
/* 262 */     double diffZ = vec.getZCoord() - eyesPos.getZCoord();
/*     */     
/* 264 */     return new Rotation(WMathHelper.wrapAngleTo180_float(
/* 265 */           (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0F), 
/* 266 */         WMathHelper.wrapAngleTo180_float(
/* 267 */           (float)-Math.toDegrees(Math.atan2(diffY, Math.sqrt(diffX * diffX + diffZ * diffZ)))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Rotation getNewRotations(WVec3 vec, boolean predict) {
/* 274 */     WVec3 eyesPos = new WVec3(mc2.field_71439_g.field_70165_t, (mc2.field_71439_g.func_174813_aQ()).field_72338_b + mc2.field_71439_g.func_70047_e(), mc2.field_71439_g.field_70161_v);
/* 275 */     double diffX = vec.getXCoord() - eyesPos.getXCoord();
/* 276 */     double diffY = vec.getYCoord() - eyesPos.getYCoord();
/* 277 */     double diffZ = vec.getZCoord() - eyesPos.getZCoord();
/*     */     
/* 279 */     double dist = MathHelper.func_76133_a(diffX * diffX + diffZ * diffZ);
/* 280 */     float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
/* 281 */     float pitch = (float)(-Math.atan2(diffY, dist) * 180.0D / Math.PI);
/* 282 */     return new Rotation(yaw, pitch);
/*     */   }
/*     */   
/*     */   public static VecRotation lockView(IAxisAlignedBB bb, boolean outborder, boolean random, boolean predict, boolean throughWalls, float distance) {
/* 286 */     if (outborder) {
/* 287 */       WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * (x * 0.3D + 1.0D), bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * (y * 0.3D + 1.0D), bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * (z * 0.3D + 1.0D));
/* 288 */       return new VecRotation(vec3, toRotation(vec3, predict));
/*     */     } 
/*     */     
/* 291 */     WVec3 randomVec = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * x * 0.8D, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * y * 0.8D, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * z * 0.8D);
/* 292 */     Rotation randomRotation = toRotation(randomVec, predict);
/*     */     
/* 294 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/*     */     
/* 296 */     double xMin = 0.0D;
/* 297 */     double yMin = 0.0D;
/* 298 */     double zMin = 0.0D;
/* 299 */     double xMax = 0.0D;
/* 300 */     double yMax = 0.0D;
/* 301 */     double zMax = 0.0D;
/* 302 */     double xDist = 0.0D;
/* 303 */     double yDist = 0.0D;
/* 304 */     double zDist = 0.0D;
/* 305 */     VecRotation vecRotation = null;
/* 306 */     xMin = 0.45D; xMax = 0.55D; xDist = 0.0125D;
/* 307 */     yMin = 0.65D; yMax = 0.75D; yDist = 0.0125D;
/* 308 */     zMin = 0.45D; zMax = 0.55D; zDist = 0.0125D; double xSearch;
/* 309 */     for (xSearch = xMin; xSearch < xMax; xSearch += xDist) {
/* 310 */       double ySearch; for (ySearch = yMin; ySearch < yMax; ySearch += yDist) {
/* 311 */         double zSearch; for (zSearch = zMin; zSearch < zMax; zSearch += zDist) {
/* 312 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * xSearch, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * ySearch, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * zSearch);
/*     */           
/* 314 */           Rotation rotation = toRotation(vec3, predict);
/* 315 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/* 317 */           if (vecDist <= distance)
/*     */           {
/*     */             
/* 320 */             if (throughWalls || isVisible(vec3)) {
/* 321 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/* 323 */               if (vecRotation == null || (random ? (getRotationDifference(currentVec.getRotation(), randomRotation) < getRotationDifference(vecRotation.getRotation(), randomRotation)) : (getRotationDifference(currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation()))))
/* 324 */                 vecRotation = currentVec; 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 330 */     return vecRotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static VecRotation faceBlock(WBlockPos blockPos) {
/* 338 */     if (blockPos == null) {
/* 339 */       return null;
/*     */     }
/* 341 */     VecRotation vecRotation = null;
/*     */     
/* 343 */     for (double xSearch = 0.1D; xSearch < 0.9D; xSearch += 0.1D) {
/* 344 */       double ySearch; for (ySearch = 0.1D; ySearch < 0.9D; ySearch += 0.1D) {
/* 345 */         double zSearch; for (zSearch = 0.1D; zSearch < 0.9D; zSearch += 0.1D) {
/* 346 */           WVec3 eyesPos = new WVec3(mc.getThePlayer().getPosX(), mc.getThePlayer().getEntityBoundingBox().getMinY() + mc.getThePlayer().getEyeHeight(), mc.getThePlayer().getPosZ());
/* 347 */           WVec3 posVec = (new WVec3((WVec3i)blockPos)).addVector(xSearch, ySearch, zSearch);
/* 348 */           double dist = eyesPos.distanceTo(posVec);
/*     */           
/* 350 */           double diffX = posVec.getXCoord() - eyesPos.getXCoord();
/* 351 */           double diffY = posVec.getYCoord() - eyesPos.getYCoord();
/* 352 */           double diffZ = posVec.getZCoord() - eyesPos.getZCoord();
/*     */           
/* 354 */           double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
/*     */ 
/*     */ 
/*     */           
/* 358 */           Rotation rotation = new Rotation(WMathHelper.wrapAngleTo180_float((float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0F), WMathHelper.wrapAngleTo180_float((float)-Math.toDegrees(Math.atan2(diffY, diffXZ))));
/*     */ 
/*     */           
/* 361 */           WVec3 rotationVector = getVectorForRotation(rotation);
/* 362 */           WVec3 vector = eyesPos.addVector(rotationVector.getXCoord() * dist, rotationVector.getYCoord() * dist, rotationVector
/* 363 */               .getZCoord() * dist);
/* 364 */           IMovingObjectPosition obj = mc.getTheWorld().rayTraceBlocks(eyesPos, vector, false, false, true);
/*     */ 
/*     */           
/* 367 */           if (obj != null && obj.getTypeOfHit() == IMovingObjectPosition.WMovingObjectType.BLOCK) {
/* 368 */             VecRotation currentVec = new VecRotation(posVec, rotation);
/*     */             
/* 370 */             if (vecRotation == null || getRotationDifference(currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation())) {
/* 371 */               vecRotation = currentVec;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 377 */     return vecRotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void faceBow(IEntity target, boolean silent, boolean predict, float predictSize) {
/* 389 */     IEntityPlayerSP player = mc.getThePlayer();
/*     */     
/* 391 */     double posX = target.getPosX() + (predict ? ((target.getPosX() - target.getPrevPosX()) * predictSize) : 0.0D) - player.getPosX() + (predict ? (player.getPosX() - player.getPrevPosX()) : 0.0D);
/* 392 */     double posY = target.getEntityBoundingBox().getMinY() + (predict ? ((target.getEntityBoundingBox().getMinY() - target.getPrevPosY()) * predictSize) : 0.0D) + target.getEyeHeight() - 0.15D - player.getEntityBoundingBox().getMinY() + (predict ? (player.getPosY() - player.getPrevPosY()) : 0.0D) - player.getEyeHeight();
/* 393 */     double posZ = target.getPosZ() + (predict ? ((target.getPosZ() - target.getPrevPosZ()) * predictSize) : 0.0D) - player.getPosZ() + (predict ? (player.getPosZ() - player.getPrevPosZ()) : 0.0D);
/* 394 */     double posSqrt = Math.sqrt(posX * posX + posZ * posZ);
/*     */     
/* 396 */     float velocity = Retreat.moduleManager.getModule(FastBow.class).getState() ? 1.0F : (player.getItemInUseDuration() / 20.0F);
/* 397 */     velocity = (velocity * velocity + velocity * 2.0F) / 3.0F;
/*     */     
/* 399 */     if (velocity > 1.0F) velocity = 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 403 */     Rotation rotation = new Rotation((float)(Math.atan2(posZ, posX) * 180.0D / Math.PI) - 90.0F, (float)-Math.toDegrees(Math.atan(((velocity * velocity) - Math.sqrt((velocity * velocity * velocity * velocity) - 0.006000000052154064D * (0.006000000052154064D * posSqrt * posSqrt + 2.0D * posY * (velocity * velocity)))) / 0.006000000052154064D * posSqrt)));
/*     */ 
/*     */     
/* 406 */     if (silent) {
/* 407 */       setTargetRotation(rotation);
/*     */     } else {
/* 409 */       limitAngleChange(new Rotation(player.getRotationYaw(), player.getRotationPitch()), rotation, (10 + (new Random())
/* 410 */           .nextInt(6))).toPlayer((IEntityPlayer)mc.getThePlayer());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Rotation toRotation(WVec3 vec, boolean predict) {
/* 422 */     WVec3 eyesPos = new WVec3(mc.getThePlayer().getPosX(), mc.getThePlayer().getEntityBoundingBox().getMinY() + mc.getThePlayer().getEyeHeight(), mc.getThePlayer().getPosZ());
/*     */     
/* 424 */     if (predict) {
/* 425 */       eyesPos.addVector(mc.getThePlayer().getMotionX(), mc.getThePlayer().getMotionY(), mc.getThePlayer().getMotionZ());
/*     */     }
/* 427 */     double diffX = vec.getXCoord() - eyesPos.getXCoord();
/* 428 */     double diffY = vec.getYCoord() - eyesPos.getYCoord();
/* 429 */     double diffZ = vec.getZCoord() - eyesPos.getZCoord();
/*     */     
/* 431 */     return new Rotation(WMathHelper.wrapAngleTo180_float(
/* 432 */           (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0F), 
/* 433 */         WMathHelper.wrapAngleTo180_float(
/* 434 */           (float)-Math.toDegrees(Math.atan2(diffY, Math.sqrt(diffX * diffX + diffZ * diffZ)))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WVec3 getCenter(IAxisAlignedBB bb) {
/* 445 */     return new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * 0.5D, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * 0.5D, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * 0.5D);
/*     */   }
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
/*     */   public static VecRotation searchCenter1(IAxisAlignedBB bb, boolean outborder, boolean random, boolean predict, boolean throughWalls, float distance, boolean xS, boolean yS) {
/* 460 */     if (outborder) {
/* 461 */       WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * (x * 0.3D + 1.0D), bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * (y * 0.3D + 1.0D), bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * (z * 0.3D + 1.0D));
/* 462 */       return new VecRotation(vec3, toRotation(vec3, predict));
/*     */     } 
/*     */     
/* 465 */     WVec3 randomVec = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * x * 0.8D, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * y * 0.8D, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * z * 0.8D);
/* 466 */     Rotation randomRotation = toRotation(randomVec, predict);
/*     */     
/* 468 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/*     */     
/* 470 */     VecRotation vecRotation = null;
/*     */     double xSearch;
/* 472 */     for (xSearch = 0.15D; xSearch < 0.85D; xSearch += 0.1D) {
/* 473 */       double ySearch; for (ySearch = 0.15D; ySearch < 1.0D; ySearch += 0.1D) {
/* 474 */         double zSearch; for (zSearch = 0.15D; zSearch < 0.85D; zSearch += 0.1D) {
/*     */           
/* 476 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * (xS ? xSearch : 0.5D), bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * (yS ? ySearch : 0.5D), bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * (xS ? zSearch : 0.5D));
/* 477 */           Rotation rotation = toRotation(vec3, predict);
/* 478 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/* 480 */           if (vecDist <= distance)
/*     */           {
/*     */             
/* 483 */             if (throughWalls || isVisible(vec3)) {
/* 484 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/* 486 */               if (vecRotation == null || (random ? (getRotationDifference(currentVec.getRotation(), randomRotation) < getRotationDifference(vecRotation.getRotation(), randomRotation)) : (getRotationDifference(currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation()))))
/* 487 */                 vecRotation = currentVec; 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 493 */     return vecRotation;
/*     */   }
/*     */   
/*     */   public static VecRotation searchCenter(IAxisAlignedBB bb, boolean outborder, boolean random, boolean predict, boolean throughWalls, float distance) {
/* 497 */     if (outborder) {
/* 498 */       WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * (x * 0.3D + 1.0D), bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * (y * 0.3D + 1.0D), bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * (z * 0.3D + 1.0D));
/* 499 */       return new VecRotation(vec3, toRotation(vec3, predict));
/*     */     } 
/*     */     
/* 502 */     WVec3 randomVec = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * x * 0.8D, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * y * 0.8D, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * z * 0.8D);
/* 503 */     Rotation randomRotation = toRotation(randomVec, predict);
/*     */     
/* 505 */     WVec3 eyes = mc.getThePlayer().getPositionEyes(1.0F);
/*     */     
/* 507 */     VecRotation vecRotation = null;
/*     */     double xSearch;
/* 509 */     for (xSearch = 0.15D; xSearch < 0.85D; xSearch += 0.1D) {
/* 510 */       double ySearch; for (ySearch = 0.15D; ySearch < 1.0D; ySearch += 0.1D) {
/* 511 */         double zSearch; for (zSearch = 0.15D; zSearch < 0.85D; zSearch += 0.1D) {
/*     */           
/* 513 */           WVec3 vec3 = new WVec3(bb.getMinX() + (bb.getMaxX() - bb.getMinX()) * xSearch, bb.getMinY() + (bb.getMaxY() - bb.getMinY()) * ySearch, bb.getMinZ() + (bb.getMaxZ() - bb.getMinZ()) * zSearch);
/* 514 */           Rotation rotation = toRotation(vec3, predict);
/* 515 */           double vecDist = eyes.distanceTo(vec3);
/*     */           
/* 517 */           if (vecDist <= distance)
/*     */           {
/*     */             
/* 520 */             if (throughWalls || isVisible(vec3)) {
/* 521 */               VecRotation currentVec = new VecRotation(vec3, rotation);
/*     */               
/* 523 */               if (vecRotation == null || (random ? (getRotationDifference(currentVec.getRotation(), randomRotation) < getRotationDifference(vecRotation.getRotation(), randomRotation)) : (getRotationDifference(currentVec.getRotation()) < getRotationDifference(vecRotation.getRotation()))))
/* 524 */                 vecRotation = currentVec; 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 530 */     return vecRotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getRotationDifference(IEntity entity) {
/* 540 */     Rotation rotation = toRotation(getCenter(entity.getEntityBoundingBox()), true);
/*     */     
/* 542 */     return getRotationDifference(rotation, new Rotation(mc.getThePlayer().getRotationYaw(), mc.getThePlayer().getRotationPitch()));
/*     */   }
/*     */   
/*     */   public static double getRotationDifferenceYaw(IEntity entity) {
/* 546 */     Rotation rotation = toRotation(getCenter(entity.getEntityBoundingBox()), true);
/*     */     
/* 548 */     return Math.abs(getRotationDifferenceYaw(rotation, new Rotation(mc.getThePlayer().getRotationYaw(), mc.getThePlayer().getRotationPitch())));
/*     */   }
/*     */   
/*     */   public static double getRotationDifferenceYaw(Rotation a, Rotation b) {
/* 552 */     return getAngleDifference(a.getYaw(), b.getYaw());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getRotationDifference(Rotation rotation) {
/* 562 */     return (serverRotation == null) ? 0.0D : getRotationDifference(rotation, serverRotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getRotationDifference(Rotation a, Rotation b) {
/* 573 */     return Math.hypot(getAngleDifference(a.getYaw(), b.getYaw()), (a.getPitch() - b.getPitch()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public static Rotation limitAngleChange(Rotation currentRotation, Rotation targetRotation, float turnSpeed) {
/* 586 */     float yawDifference = getAngleDifference(targetRotation.getYaw(), currentRotation.getYaw());
/* 587 */     float pitchDifference = getAngleDifference(targetRotation.getPitch(), currentRotation.getPitch());
/*     */     
/* 589 */     return new Rotation(currentRotation
/* 590 */         .getYaw() + ((yawDifference > turnSpeed) ? turnSpeed : Math.max(yawDifference, -turnSpeed)), currentRotation
/* 591 */         .getPitch() + ((pitchDifference > turnSpeed) ? turnSpeed : Math.max(pitchDifference, -turnSpeed)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float getAngleDifference(float a, float b) {
/* 603 */     return ((a - b) % 360.0F + 540.0F) % 360.0F - 180.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WVec3 getVectorForRotation(Rotation rotation) {
/* 613 */     float yawCos = (float)Math.cos((-rotation.getYaw() * 0.017453292F - 3.1415927F));
/* 614 */     float yawSin = (float)Math.sin((-rotation.getYaw() * 0.017453292F - 3.1415927F));
/* 615 */     float pitchCos = (float)-Math.cos((-rotation.getPitch() * 0.017453292F));
/* 616 */     float pitchSin = (float)Math.sin((-rotation.getPitch() * 0.017453292F));
/* 617 */     return new WVec3((yawSin * pitchCos), pitchSin, (yawCos * pitchCos));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isFaced(IEntity targetEntity, double blockReachDistance) {
/* 628 */     return (RaycastUtils.raycastEntity(blockReachDistance, entity -> (targetEntity != null && targetEntity.equals(entity))) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isVisible(WVec3 vec3) {
/* 635 */     WVec3 eyesPos = new WVec3(mc.getThePlayer().getPosX(), mc.getThePlayer().getEntityBoundingBox().getMinY() + mc.getThePlayer().getEyeHeight(), mc.getThePlayer().getPosZ());
/*     */     
/* 637 */     return (mc.getTheWorld().rayTraceBlocks(eyesPos, vec3) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onTick(TickEvent event) {
/* 647 */     if (targetRotation != null) {
/* 648 */       keepLength--;
/*     */       
/* 650 */       if (keepLength <= 0) {
/* 651 */         reset();
/*     */       }
/*     */     } 
/* 654 */     if (random.nextGaussian() > 0.8D) x = Math.random(); 
/* 655 */     if (random.nextGaussian() > 0.8D) y = Math.random(); 
/* 656 */     if (random.nextGaussian() > 0.8D) z = Math.random(); 
/*     */   }
/*     */   
/*     */   public static Rotation getNCPRotations(WVec3 vec, boolean predict) {
/* 660 */     WVec3 eyesPos = new WVec3(mc2.field_71439_g.field_70165_t, (mc2.field_71439_g.func_174813_aQ()).field_72338_b + mc2.field_71439_g.func_70047_e(), mc2.field_71439_g.field_70161_v);
/*     */     
/* 662 */     if (predict) eyesPos.addVector(mc2.field_71439_g.field_70159_w, mc2.field_71439_g.field_70181_x, mc2.field_71439_g.field_70179_y);
/*     */     
/* 664 */     double diffX = vec.getXCoord() - eyesPos.getXCoord();
/* 665 */     double diffY = vec.getYCoord() - eyesPos.getYCoord();
/* 666 */     double diffZ = vec.getZCoord() - eyesPos.getZCoord();
/* 667 */     double hypotenuse = MathHelper.func_76133_a(diffX * diffX + diffZ * diffZ);
/* 668 */     return new Rotation((float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F, (float)(-Math.atan2(diffY, hypotenuse) * 180.0D / Math.PI));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setTargetRotation(Rotation rotation, int keepLength) {
/* 677 */     if (Double.isNaN(rotation.getYaw()) || Double.isNaN(rotation.getPitch()) || rotation
/* 678 */       .getPitch() > 90.0F || rotation.getPitch() < -90.0F) {
/*     */       return;
/*     */     }
/* 681 */     rotation.fixedSensitivity(mc.getGameSettings().getMouseSensitivity());
/* 682 */     targetRotation = rotation;
/* 683 */     RotationUtils.keepLength = keepLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setTargetRotation(Rotation rotation) {
/* 692 */     setTargetRotation(rotation, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onPacket(PacketEvent event) {
/* 702 */     IPacket packet = event.getPacket();
/*     */     
/* 704 */     if (classProvider.isCPacketPlayer(packet)) {
/* 705 */       ICPacketPlayer packetPlayer = packet.asCPacketPlayer();
/*     */       
/* 707 */       if (targetRotation != null && !keepCurrentRotation && (targetRotation.getYaw() != serverRotation.getYaw() || targetRotation.getPitch() != serverRotation.getPitch())) {
/* 708 */         packetPlayer.setYaw(targetRotation.getYaw());
/* 709 */         packetPlayer.setPitch(targetRotation.getPitch());
/* 710 */         packetPlayer.setRotating(true);
/*     */       } 
/*     */       
/* 713 */       if (packetPlayer.isRotating()) {
/* 714 */         serverRotation = new Rotation(packetPlayer.getYaw(), packetPlayer.getPitch());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reset() {
/* 722 */     keepLength = 0;
/* 723 */     targetRotation = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleEvents() {
/* 731 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\RotationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */