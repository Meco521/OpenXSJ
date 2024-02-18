/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.vecmath.Vector3d;
/*    */ 
/*    */ public final class PathUtils
/*    */   extends MinecraftInstance {
/*    */   public static List<Vector3d> findBlinkPath(double tpX, double tpY, double tpZ) {
/* 10 */     List<Vector3d> positions = new ArrayList<>();
/*    */     
/* 12 */     double curX = mc.getThePlayer().getPosX();
/* 13 */     double curY = mc.getThePlayer().getPosY();
/* 14 */     double curZ = mc.getThePlayer().getPosZ();
/* 15 */     double distance = Math.abs(curX - tpX) + Math.abs(curY - tpY) + Math.abs(curZ - tpZ);
/*    */     
/* 17 */     for (int count = 0; distance > 0.0D; count++) {
/* 18 */       distance = Math.abs(curX - tpX) + Math.abs(curY - tpY) + Math.abs(curZ - tpZ);
/*    */       
/* 20 */       double diffX = curX - tpX;
/* 21 */       double diffY = curY - tpY;
/* 22 */       double diffZ = curZ - tpZ;
/* 23 */       double offset = ((count & 0x1) == 0) ? 0.4D : 0.1D;
/*    */       
/* 25 */       double minX = Math.min(Math.abs(diffX), offset);
/* 26 */       if (diffX < 0.0D) curX += minX; 
/* 27 */       if (diffX > 0.0D) curX -= minX;
/*    */       
/* 29 */       double minY = Math.min(Math.abs(diffY), 0.25D);
/* 30 */       if (diffY < 0.0D) curY += minY; 
/* 31 */       if (diffY > 0.0D) curY -= minY;
/*    */       
/* 33 */       double minZ = Math.min(Math.abs(diffZ), offset);
/* 34 */       if (diffZ < 0.0D) curZ += minZ; 
/* 35 */       if (diffZ > 0.0D) curZ -= minZ;
/*    */       
/* 37 */       positions.add(new Vector3d(curX, curY, curZ));
/*    */     } 
/*    */     
/* 40 */     return positions;
/*    */   }
/*    */   
/*    */   public static List<Vector3d> findPath(double tpX, double tpY, double tpZ, double offset) {
/* 44 */     List<Vector3d> positions = new ArrayList<>();
/* 45 */     double steps = Math.ceil(getDistance(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY(), mc.getThePlayer().getPosZ(), tpX, tpY, tpZ) / offset);
/*    */     
/* 47 */     double dX = tpX - mc.getThePlayer().getPosX();
/* 48 */     double dY = tpY - mc.getThePlayer().getPosY();
/* 49 */     double dZ = tpZ - mc.getThePlayer().getPosZ();
/*    */     double d;
/* 51 */     for (d = 1.0D; d <= steps; d++) {
/* 52 */       positions.add(new Vector3d(mc.getThePlayer().getPosX() + dX * d / steps, mc.getThePlayer().getPosY() + dY * d / steps, mc.getThePlayer().getPosZ() + dZ * d / steps));
/*    */     }
/*    */     
/* 55 */     return positions;
/*    */   }
/*    */   
/*    */   private static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
/* 59 */     double xDiff = x1 - x2;
/* 60 */     double yDiff = y1 - y2;
/* 61 */     double zDiff = z1 - z2;
/*    */     
/* 63 */     return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\PathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */