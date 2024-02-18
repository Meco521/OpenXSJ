/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HuaHuo4
/*    */ {
/*    */   public float x;
/*    */   public float y;
/* 16 */   public TranslateUtil anima = new TranslateUtil(0.0F, 0.0F);
/*    */   
/*    */   public HuaHuo4(float x, float y) {
/* 19 */     this.x = x;
/* 20 */     this.y = y;
/* 21 */     this.anima.setXY(0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public void draw() {
/* 25 */     this.anima.interpolate(100.0F, 100.0F, 0.15F);
/*    */     
/* 27 */     double radius = (8.0F * this.anima.getX() / 100.0F);
/*    */     
/* 29 */     int alpha = (int)(255.0F - 255.0F * this.anima.getY() / 100.0F);
/* 30 */     RenderUtils.drawArc(this.x, this.y, radius, (new Color(255, 255, 255, alpha)).getRGB(), 0, 360.0D, 5);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRemove() {
/* 35 */     return (this.anima.getX() == 100.0F && this.anima.getY() == 100.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\HuaHuo4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */