/*    */ package tomk.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ 
/*    */ 
/*    */ public class PlayerUtil
/*    */ {
/* 12 */   private static Minecraft mc = Minecraft.func_71410_x();
/*    */ 
/*    */   
/*    */   public static boolean isBlockUnder() {
/* 16 */     if (MinecraftInstance.mc2.field_71439_g.field_70163_u < 0.0D)
/* 17 */       return false; 
/* 18 */     for (int off = 0; off < (int)mc.field_71439_g.field_70163_u + 2; off += 2) {
/* 19 */       AxisAlignedBB bb = mc.field_71439_g.func_174813_aQ().func_72317_d(0.0D, -off, 0.0D);
/* 20 */       if (!mc.field_71441_e.func_184144_a((Entity)mc.field_71439_g, bb).isEmpty()) {
/* 21 */         return true;
/*    */       }
/*    */     } 
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
/* 31 */     double d0 = x1 - x2;
/* 32 */     double d2 = y1 - y2;
/* 33 */     double d3 = z1 - z2;
/* 34 */     return Math.sqrt(d0 * d0 + d2 * d2 + d3 * d3);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isMoving() {
/* 39 */     if (!mc.field_71439_g.field_70123_F && !mc.field_71439_g.func_70093_af()) {
/* 40 */       return (mc.field_71439_g.field_71158_b.field_192832_b != 0.0F || mc.field_71439_g.field_71158_b.field_78902_a != 0.0F);
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityLivingBase getEntity() {
/* 47 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\PlayerUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */