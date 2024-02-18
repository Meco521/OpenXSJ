/*    */ package net.ccbluex.liquidbounce.ui.client.clickgui.elements;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModuleElement
/*    */   extends ButtonElement
/*    */ {
/*    */   private final Module module;
/*    */   private boolean showSettings;
/* 15 */   private float settingsWidth = 0.0F;
/*    */   
/*    */   private boolean wasPressed;
/*    */   public int slowlySettingsYPos;
/*    */   public int slowlyFade;
/*    */   
/*    */   public ModuleElement(Module module) {
/* 22 */     super((String)null);
/*    */     
/* 24 */     this.displayName = module.getName();
/* 25 */     this.module = module;
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float button) {
/* 30 */     Retreat.clickGui.style.drawModuleElement(mouseX, mouseY, this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 35 */     if (mouseButton == 0 && isHovering(mouseX, mouseY) && isVisible()) {
/* 36 */       this.module.toggle();
/* 37 */       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*    */     } 
/*    */     
/* 40 */     if (mouseButton == 1 && isHovering(mouseX, mouseY) && isVisible()) {
/* 41 */       this.showSettings = !this.showSettings;
/* 42 */       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Module getModule() {
/* 47 */     return this.module;
/*    */   }
/*    */   
/*    */   public boolean isShowSettings() {
/* 51 */     return this.showSettings;
/*    */   }
/*    */   
/*    */   public void setShowSettings(boolean showSettings) {
/* 55 */     this.showSettings = showSettings;
/*    */   }
/*    */   
/*    */   public boolean isntPressed() {
/* 59 */     return !this.wasPressed;
/*    */   }
/*    */   
/*    */   public void updatePressed() {
/* 63 */     this.wasPressed = Mouse.isButtonDown(0);
/*    */   }
/*    */   
/*    */   public float getSettingsWidth() {
/* 67 */     return this.settingsWidth;
/*    */   }
/*    */   
/*    */   public void setSettingsWidth(float settingsWidth) {
/* 71 */     this.settingsWidth = settingsWidth;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\elements\ModuleElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */