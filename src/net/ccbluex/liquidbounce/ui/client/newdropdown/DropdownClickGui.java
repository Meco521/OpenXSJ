/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.impl.SettingComponents;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.DecelerateAnimation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.EaseBackIn;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Main;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.DrRenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.ClientMain;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.input.Mouse;
/*     */ 
/*     */ public class DropdownClickGui
/*     */   extends WrappedGuiScreen {
/*     */   private Animation openingAnimation;
/*     */   private EaseBackIn fadeAnimation;
/*  27 */   private final IResourceLocation hudIcon = classProvider.createResourceLocation("tomk/custom_hud_icon.png");
/*     */   
/*     */   private DecelerateAnimation configHover;
/*     */   
/*     */   public List<MainScreen> categoryPanels;
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  35 */     if (this.categoryPanels == null || Main.reloadModules) {
/*  36 */       this.categoryPanels = new ArrayList<MainScreen>()
/*     */         {
/*     */         
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*  43 */       Main.reloadModules = false;
/*     */     } 
/*  45 */     ClientMain.getInstance().getSideGui().initGui();
/*  46 */     this.fadeAnimation = new EaseBackIn(400, 1.0D, 2.0F);
/*  47 */     this.openingAnimation = (Animation)new EaseBackIn(400, 0.4000000059604645D, 2.0F);
/*  48 */     this.configHover = new DecelerateAnimation(250, 1.0D);
/*     */     
/*  50 */     for (MainScreen catPanels : this.categoryPanels) {
/*  51 */       catPanels.animation = (Animation)this.fadeAnimation;
/*  52 */       catPanels.openingAnimation = this.openingAnimation;
/*  53 */       catPanels.initGui();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/*  59 */     if (keyCode == 1) {
/*  60 */       this.openingAnimation.setDirection(Direction.BACKWARDS);
/*  61 */       (ClientMain.getInstance().getSideGui()).focused = false;
/*  62 */       this.fadeAnimation.setDirection(this.openingAnimation.getDirection());
/*     */     } 
/*  64 */     ClientMain.getInstance().getSideGui().keyTyped(typedChar, keyCode);
/*  65 */     this.categoryPanels.forEach(categoryPanel -> categoryPanel.keyTyped(typedChar, keyCode));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/*  70 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  75 */     if (Mouse.isButtonDown(0) && mouseX >= 5 && mouseX <= 50 && mouseY <= this.representedScreen.getHeight() - 5 && mouseY >= this.representedScreen.getHeight() - 50)
/*  76 */       mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiHudDesigner())); 
/*  77 */     RenderUtils.drawImage(this.hudIcon, 9, this.representedScreen.getHeight() - 41, 32, 32);
/*     */     
/*  79 */     if (Main.reloadModules) {
/*  80 */       initGui();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     if (this.openingAnimation.isDone() && this.openingAnimation.getDirection().equals(Direction.BACKWARDS)) {
/*  88 */       mc.displayGuiScreen(null);
/*     */       
/*     */       return;
/*     */     } 
/*  92 */     boolean focusedConfigGui = (ClientMain.getInstance().getSideGui()).focused;
/*  93 */     int fakeMouseX = focusedConfigGui ? 0 : mouseX, fakeMouseY = focusedConfigGui ? 0 : mouseY;
/*  94 */     IScaledResolution sr = Retreat.INSTANCE.getWrapper().getClassProvider().createScaledResolution(mc);
/*     */     
/*  96 */     boolean hoveringConfig = DrRenderUtils.isHovering((this.representedScreen.getWidth() - 120), (this.representedScreen.getHeight() - 65), 75.0F, 25.0F, fakeMouseX, fakeMouseY);
/*     */     
/*  98 */     this.configHover.setDirection(hoveringConfig ? Direction.FORWARDS : Direction.BACKWARDS);
/*  99 */     int alphaAnimation = Math.max(0, Math.min(255, (int)(255.0D * this.fadeAnimation.getOutput())));
/*     */     
/* 101 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 103 */     SettingComponents.scale = (float)(this.openingAnimation.getOutput() + 0.6000000238418579D);
/* 104 */     DrRenderUtils.scale(sr.getScaledWidth() / 2.0F, sr.getScaledHeight() / 2.0F, (float)this.openingAnimation.getOutput() + 0.6F, () -> {
/*     */           for (MainScreen catPanels : this.categoryPanels) {
/*     */             catPanels.drawScreen(fakeMouseX, fakeMouseY);
/*     */           }
/*     */           ClientMain.getInstance().getSideGui().drawScreen(mouseX, mouseY, partialTicks, alphaAnimation);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 117 */     boolean focused = (ClientMain.getInstance().getSideGui()).focused;
/* 118 */     ClientMain.getInstance().getSideGui().mouseClicked(mouseX, mouseY, mouseButton);
/* 119 */     if (!focused) {
/* 120 */       this.categoryPanels.forEach(cat -> cat.mouseClicked(mouseX, mouseY, mouseButton));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 126 */     boolean focused = (ClientMain.getInstance().getSideGui()).focused;
/* 127 */     ClientMain.getInstance().getSideGui().mouseReleased(mouseX, mouseY, state);
/* 128 */     if (!focused)
/* 129 */       this.categoryPanels.forEach(cat -> cat.mouseReleased(mouseX, mouseY, state)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdown\DropdownClickGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */