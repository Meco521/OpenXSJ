/*    */ package net.ccbluex.liquidbounce.ui.client.clickgui.elements;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ public class Element
/*    */   extends MinecraftInstance {
/*    */   private int x;
/*    */   private int y;
/*    */   private int width;
/*    */   private int height;
/*    */   private boolean visible;
/*    */   
/*    */   public void setLocation(int x, int y) {
/* 14 */     this.x = x;
/* 15 */     this.y = y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float button) {}
/*    */ 
/*    */   
/*    */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {}
/*    */ 
/*    */   
/*    */   public void mouseReleased(int mouseX, int mouseY, int state) {}
/*    */   
/*    */   public int getX() {
/* 28 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(int x) {
/* 32 */     this.x = x;
/*    */   }
/*    */   
/*    */   public int getY() {
/* 36 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(int y) {
/* 40 */     this.y = y;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 44 */     return this.width;
/*    */   }
/*    */   
/*    */   public void setWidth(int width) {
/* 48 */     this.width = width;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 52 */     return this.height;
/*    */   }
/*    */   
/*    */   public void setHeight(int height) {
/* 56 */     this.height = height;
/*    */   }
/*    */   
/*    */   public boolean isVisible() {
/* 60 */     return this.visible;
/*    */   }
/*    */   
/*    */   public void setVisible(boolean visible) {
/* 64 */     this.visible = visible;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\elements\Element.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */