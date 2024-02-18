/*     */ package tomk.utils;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
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
/*     */ public final class MovementUtils
/*     */   extends MinecraftInstance
/*     */ {
/*     */   public static void setMotion(MoveEvent event, double speed, double motion, boolean smoothStrafe) {
/*  20 */     double forward = mc2.field_71439_g.field_71158_b.field_192832_b;
/*  21 */     double strafe = mc2.field_71439_g.field_71158_b.field_78902_a;
/*  22 */     double yaw = mc2.field_71439_g.field_70177_z;
/*  23 */     int direction = smoothStrafe ? 45 : 90;
/*     */     
/*  25 */     if (forward == 0.0D && strafe == 0.0D) {
/*  26 */       event.setX(0.0D);
/*  27 */       event.setZ(0.0D);
/*     */     } else {
/*  29 */       if (forward != 0.0D) {
/*  30 */         if (strafe > 0.0D) {
/*  31 */           yaw += ((forward > 0.0D) ? -direction : direction);
/*  32 */         } else if (strafe < 0.0D) {
/*  33 */           yaw += ((forward > 0.0D) ? direction : -direction);
/*     */         } 
/*  35 */         strafe = 0.0D;
/*  36 */         if (forward > 0.0D) {
/*  37 */           forward = 1.0D;
/*  38 */         } else if (forward < 0.0D) {
/*  39 */           forward = -1.0D;
/*     */         } 
/*     */       } 
/*     */       
/*  43 */       double cos = Math.cos(Math.toRadians(yaw + 90.0D));
/*  44 */       double sin = Math.sin(Math.toRadians(yaw + 90.0D));
/*  45 */       event.setX((forward * speed * cos + strafe * speed * sin) * motion);
/*  46 */       event.setZ((forward * speed * sin - strafe * speed * cos) * motion);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setMotion(double speed, boolean smoothStrafe) {
/*  51 */     double forward = mc2.field_71439_g.field_71158_b.field_192832_b;
/*  52 */     double strafe = mc2.field_71439_g.field_71158_b.field_78902_a;
/*  53 */     float yaw = mc2.field_71439_g.field_70177_z;
/*  54 */     int direction = smoothStrafe ? 45 : 90;
/*     */     
/*  56 */     if (forward == 0.0D && strafe == 0.0D) {
/*  57 */       mc2.field_71439_g.field_70159_w = 0.0D;
/*  58 */       mc2.field_71439_g.field_70179_y = 0.0D;
/*     */     } else {
/*  60 */       if (forward != 0.0D) {
/*  61 */         if (strafe > 0.0D) {
/*  62 */           yaw += ((forward > 0.0D) ? -direction : direction);
/*  63 */         } else if (strafe < 0.0D) {
/*  64 */           yaw += ((forward > 0.0D) ? direction : -direction);
/*     */         } 
/*  66 */         strafe = 0.0D;
/*  67 */         if (forward > 0.0D) {
/*  68 */           forward = 1.0D;
/*  69 */         } else if (forward < 0.0D) {
/*  70 */           forward = -1.0D;
/*     */         } 
/*     */       } 
/*     */       
/*  74 */       mc2.field_71439_g.field_70159_w = forward * speed * -Math.sin(Math.toRadians(yaw)) + strafe * speed * Math.cos(Math.toRadians(yaw));
/*  75 */       mc2.field_71439_g.field_70179_y = forward * speed * Math.cos(Math.toRadians(yaw)) - strafe * speed * -Math.sin(Math.toRadians(yaw));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static float getSpeed() {
/*  80 */     return (float)Math.sqrt(mc2.field_71439_g.field_70159_w * mc2.field_71439_g.field_70159_w + mc2.field_71439_g.field_70179_y * mc2.field_71439_g.field_70179_y);
/*     */   }
/*     */   
/*     */   public static void strafe() {
/*  84 */     strafe(getSpeed());
/*     */   }
/*     */   
/*     */   public static boolean isMoving() {
/*  88 */     return (mc2.field_71439_g != null && (mc2.field_71439_g.field_71158_b.field_192832_b != 0.0F || mc2.field_71439_g.field_71158_b.field_78902_a != 0.0F));
/*     */   }
/*     */   
/*     */   public static boolean hasMotion() {
/*  92 */     return (mc2.field_71439_g.field_70159_w != 0.0D && mc2.field_71439_g.field_70179_y != 0.0D && mc2.field_71439_g.field_70181_x != 0.0D);
/*     */   }
/*     */   
/*     */   public static void strafe(float speed) {
/*  96 */     if (!isMoving()) {
/*     */       return;
/*     */     }
/*  99 */     double yaw = getDirection();
/* 100 */     mc2.field_71439_g.field_70159_w = -Math.sin(yaw) * speed;
/* 101 */     mc2.field_71439_g.field_70179_y = Math.cos(yaw) * speed;
/*     */   }
/*     */   
/*     */   public static void forward(double length) {
/* 105 */     double yaw = Math.toRadians(mc2.field_71439_g.field_70177_z);
/* 106 */     mc2.field_71439_g.func_70107_b(mc2.field_71439_g.field_70165_t + -Math.sin(yaw) * length, mc2.field_71439_g.field_70163_u, mc2.field_71439_g.field_70161_v + Math.cos(yaw) * length);
/*     */   }
/*     */   
/*     */   public static double getDirection() {
/* 110 */     float rotationYaw = mc2.field_71439_g.field_70177_z;
/*     */     
/* 112 */     if (mc2.field_71439_g.field_191988_bg < 0.0F) {
/* 113 */       rotationYaw += 180.0F;
/*     */     }
/* 115 */     float forward = 1.0F;
/* 116 */     if (mc2.field_71439_g.field_191988_bg < 0.0F) {
/* 117 */       forward = -0.5F;
/* 118 */     } else if (mc2.field_71439_g.field_191988_bg > 0.0F) {
/* 119 */       forward = 0.5F;
/*     */     } 
/* 121 */     if (mc2.field_71439_g.field_70702_br > 0.0F) {
/* 122 */       rotationYaw -= 90.0F * forward;
/*     */     }
/* 124 */     if (mc2.field_71439_g.field_70702_br < 0.0F) {
/* 125 */       rotationYaw += 90.0F * forward;
/*     */     }
/* 127 */     return Math.toRadians(rotationYaw);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\MovementUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */