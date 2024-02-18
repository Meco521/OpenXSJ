/*   */ package net.ccbluex.liquidbounce.ui.client.newdropdown.impl;
/*   */ 
/*   */ import net.minecraft.client.Minecraft;
/*   */ 
/*   */ public abstract class Component
/*   */ {
/* 7 */   public Minecraft mc = Minecraft.func_71410_x();
/*   */   
/*   */   public abstract void initGui();
/*   */   
/*   */   public abstract void keyTyped(char paramChar, int paramInt);
/*   */   
/*   */   public abstract void drawScreen(int paramInt1, int paramInt2);
/*   */   
/*   */   public abstract void mouseClicked(int paramInt1, int paramInt2, int paramInt3);
/*   */   
/*   */   public abstract void mouseReleased(int paramInt1, int paramInt2, int paramInt3);
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdown\impl\Component.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */