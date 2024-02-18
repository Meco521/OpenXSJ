/*    */ package net.ccbluex.liquidbounce.utils.render.particle.util;
/*    */ 
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class RenderUtils
/*    */ {
/*    */   public static void connectPoints(float xOne, float yOne, float xTwo, float yTwo) {
/*  8 */     GL11.glPushMatrix();
/*  9 */     GL11.glEnable(2848);
/* 10 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
/* 11 */     GL11.glDisable(3553);
/* 12 */     GL11.glBlendFunc(770, 771);
/* 13 */     GL11.glEnable(3042);
/* 14 */     GL11.glLineWidth(0.5F);
/* 15 */     GL11.glBegin(1);
/* 16 */     GL11.glVertex2f(xOne, yOne);
/* 17 */     GL11.glVertex2f(xTwo, yTwo);
/* 18 */     GL11.glEnd();
/* 19 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 20 */     GL11.glDisable(2848);
/* 21 */     GL11.glEnable(3553);
/* 22 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public static void drawCircle(float x, float y, float radius, int color) {
/* 26 */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/* 27 */     float red = (color >> 16 & 0xFF) / 255.0F;
/* 28 */     float green = (color >> 8 & 0xFF) / 255.0F;
/* 29 */     float blue = (color & 0xFF) / 255.0F;
/*    */     
/* 31 */     GL11.glColor4f(red, green, blue, alpha);
/* 32 */     GL11.glEnable(3042);
/* 33 */     GL11.glDisable(3553);
/* 34 */     GL11.glBlendFunc(770, 771);
/* 35 */     GL11.glEnable(2848);
/* 36 */     GL11.glPushMatrix();
/* 37 */     GL11.glLineWidth(1.0F);
/* 38 */     GL11.glBegin(9);
/* 39 */     for (int i = 0; i <= 360; i++)
/* 40 */       GL11.glVertex2d(x + Math.sin(i * Math.PI / 180.0D) * radius, y + Math.cos(i * Math.PI / 180.0D) * radius); 
/* 41 */     GL11.glEnd();
/* 42 */     GL11.glPopMatrix();
/* 43 */     GL11.glEnable(3553);
/* 44 */     GL11.glDisable(2848);
/* 45 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\particl\\util\RenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */