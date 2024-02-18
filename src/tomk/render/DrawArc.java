/*    */ package tomk.render;
/*    */ 
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class DrawArc {
/*  6 */   public static String helper = "";
/*    */   public static void drawArc(float n, float n2, double n3, int n4, int n5, double n6, float n7) {
/*  8 */     n3 *= 2.0D;
/*  9 */     n *= 2.0F;
/* 10 */     n2 *= 2.0F;
/* 11 */     float n8 = (n4 >> 24 & 0xFF) / 255.0F;
/* 12 */     float n9 = (n4 >> 16 & 0xFF) / 255.0F;
/* 13 */     float n10 = (n4 >> 8 & 0xFF) / 255.0F;
/* 14 */     float n11 = (n4 & 0xFF) / 255.0F;
/* 15 */     GL11.glDisable(2929);
/* 16 */     GL11.glEnable(3042);
/* 17 */     GL11.glDisable(3553);
/* 18 */     GL11.glBlendFunc(770, 771);
/* 19 */     GL11.glDepthMask(true);
/* 20 */     GL11.glEnable(2848);
/* 21 */     GL11.glHint(3154, 4354);
/* 22 */     GL11.glHint(3155, 4354);
/* 23 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 24 */     GL11.glLineWidth(n7);
/* 25 */     GL11.glEnable(2848);
/* 26 */     GL11.glColor4f(n9, n10, n11, n8);
/* 27 */     GL11.glBegin(3);
/* 28 */     int n12 = n5;
/* 29 */     while (n12 <= n6) {
/* 30 */       GL11.glVertex2d(n + Math.sin(n12 * Math.PI / 180.0D) * n3, n2 + Math.cos(n12 * Math.PI / 180.0D) * n3);
/* 31 */       n12++;
/*    */     } 
/* 33 */     GL11.glEnd();
/* 34 */     GL11.glDisable(2848);
/* 35 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 36 */     GL11.glEnable(3553);
/* 37 */     GL11.glDisable(3042);
/* 38 */     GL11.glEnable(2929);
/* 39 */     GL11.glDisable(2848);
/* 40 */     GL11.glHint(3154, 4352);
/* 41 */     GL11.glHint(3155, 4352);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\render\DrawArc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */