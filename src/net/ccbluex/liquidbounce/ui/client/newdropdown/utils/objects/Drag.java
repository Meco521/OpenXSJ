/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.objects;
/*    */ 
/*    */ 
/*    */ public class Drag
/*    */ {
/*    */   private float xPos;
/*    */   private float yPos;
/*    */   
/*    */   public Drag(float initialXVal, float initialYVal) {
/* 10 */     this.xPos = initialXVal;
/* 11 */     this.yPos = initialYVal;
/*    */   }
/*    */   private float startX; private float startY; private boolean dragging;
/*    */   public float getX() {
/* 15 */     return this.xPos;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 19 */     this.xPos = x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 23 */     return this.yPos;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 27 */     this.yPos = y;
/*    */   }
/*    */   
/*    */   public final void onDraw(int mouseX, int mouseY) {
/* 31 */     if (this.dragging) {
/* 32 */       this.xPos = mouseX - this.startX;
/* 33 */       this.yPos = mouseY - this.startY;
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void onDrawNegX(int mouseX, int mouseY) {
/* 38 */     if (this.dragging) {
/* 39 */       this.xPos = -(mouseX - this.startX);
/* 40 */       this.yPos = mouseY - this.startY;
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void onClick(int mouseX, int mouseY, int button, boolean canDrag) {
/* 45 */     if (button == 0 && canDrag) {
/* 46 */       this.dragging = true;
/* 47 */       this.startX = (int)(mouseX - this.xPos);
/* 48 */       this.startY = (int)(mouseY - this.yPos);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void onClickAddX(int mouseX, int mouseY, int button, boolean canDrag) {
/* 53 */     if (button == 0 && canDrag) {
/* 54 */       this.dragging = true;
/* 55 */       this.startX = (int)(mouseX + this.xPos);
/* 56 */       this.startY = (int)(mouseY - this.yPos);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void onRelease(int button) {
/* 61 */     if (button == 0) this.dragging = false; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\objects\Drag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */