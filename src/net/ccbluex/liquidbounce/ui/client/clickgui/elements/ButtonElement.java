/*    */ package net.ccbluex.liquidbounce.ui.client.clickgui.elements;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ButtonElement
/*    */   extends Element {
/*    */   protected String displayName;
/* 11 */   protected int color = 16777215;
/*    */   
/*    */   public int hoverTime;
/*    */   
/*    */   public ButtonElement(String displayName) {
/* 16 */     createButton(displayName);
/*    */   }
/*    */   
/*    */   public void createButton(String displayName) {
/* 20 */     this.displayName = displayName;
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float button) {
/* 25 */     Retreat.clickGui.style.drawButtonElement(mouseX, mouseY, this);
/* 26 */     super.drawScreen(mouseX, mouseY, button);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 31 */     return 16;
/*    */   }
/*    */   
/*    */   public boolean isHovering(int mouseX, int mouseY) {
/* 35 */     return (mouseX >= getX() && mouseX <= getX() + getWidth() && mouseY >= getY() && mouseY <= getY() + 16);
/*    */   }
/*    */   
/*    */   public String getDisplayName() {
/* 39 */     return this.displayName;
/*    */   }
/*    */   
/*    */   public void setColor(int color) {
/* 43 */     this.color = color;
/*    */   }
/*    */   
/*    */   public int getColor() {
/* 47 */     return this.color;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\elements\ButtonElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */