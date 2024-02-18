/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render;
/*    */ 
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLUtil
/*    */ {
/*    */   public static void render(int mode, Runnable render) {
/* 11 */     GL11.glBegin(mode);
/* 12 */     render.run();
/* 13 */     GL11.glEnd();
/*    */   }
/*    */   public static void endBlend() {
/* 16 */     GlStateManager.func_179084_k();
/*    */   }
/*    */   public static void startBlend() {
/* 19 */     GlStateManager.func_179147_l();
/* 20 */     GlStateManager.func_179112_b(770, 771);
/*    */   }
/*    */   
/*    */   public static void setup2DRendering(Runnable f) {
/* 24 */     GL11.glEnable(3042);
/* 25 */     GL11.glBlendFunc(770, 771);
/* 26 */     GL11.glDisable(3553);
/* 27 */     f.run();
/* 28 */     GL11.glEnable(3553);
/* 29 */     GlStateManager.func_179084_k();
/*    */   }
/*    */   
/*    */   public static void rotate(float x, float y, float rotate, Runnable f) {
/* 33 */     GlStateManager.func_179094_E();
/* 34 */     GlStateManager.func_179109_b(x, y, 0.0F);
/* 35 */     GlStateManager.func_179114_b(rotate, 0.0F, 0.0F, -1.0F);
/* 36 */     GlStateManager.func_179109_b(-x, -y, 0.0F);
/* 37 */     f.run();
/* 38 */     GlStateManager.func_179121_F();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\render\GLUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */