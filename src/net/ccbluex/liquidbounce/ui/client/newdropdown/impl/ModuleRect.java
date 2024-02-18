/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown.impl;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.DecelerateAnimation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.EaseInOutQuad;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Main;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.DrRenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.ClientMain;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tomk.fonts.impl.Fonts;
/*     */ 
/*     */ public class ModuleRect
/*     */   extends Component
/*     */ {
/*  22 */   public final ClientMain client = ClientMain.getInstance();
/*     */   public final Module module;
/*     */   private final SettingComponents settingComponents;
/*  25 */   private final Animation animation = (Animation)new EaseInOutQuad(300, 1.0D, Direction.BACKWARDS);
/*  26 */   private final Animation arrowAnimation = (Animation)new EaseInOutQuad(250, 1.0D, Direction.BACKWARDS);
/*  27 */   private final Animation hoverAnimation = (Animation)new DecelerateAnimation(250, 1.0D, Direction.BACKWARDS);
/*     */   
/*     */   public Animation settingAnimation;
/*     */   public Animation openingAnimation;
/*     */   public float x;
/*     */   public float y;
/*     */   public float width;
/*     */   
/*     */   public ModuleRect(Module module) {
/*  36 */     this.module = module;
/*  37 */     this.settingComponents = new SettingComponents(module);
/*     */   }
/*     */   public float height; public float panelLimitY; public int alphaAnimation; int clickX; int clickY; private double settingSize;
/*     */   
/*     */   public void initGui() {
/*  42 */     this.animation.setDirection(this.module.getState() ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/*  47 */     if (this.module.getExpanded()) {
/*  48 */       this.settingComponents.keyTyped(typedChar, keyCode);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY) {
/*  54 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*  55 */     Color rectColor = new Color(43, 45, 50, this.alphaAnimation);
/*  56 */     Color textColor = new Color(255, 255, 255, this.alphaAnimation);
/*  57 */     Color debcolor = new Color(ClickGUI.generateRGB());
/*     */     
/*  59 */     Color clickModColor = DrRenderUtils.applyOpacity(debcolor, this.alphaAnimation / 255.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     float alpha = this.alphaAnimation / 255.0F;
/*     */     
/*  66 */     boolean hoveringModule = DrRenderUtils.isHovering(this.x, this.y, this.width, this.height, mouseX, mouseY);
/*  67 */     this.hoverAnimation.setDirection(hoveringModule ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */ 
/*     */     
/*  70 */     DrRenderUtils.drawRect2(this.x, this.y, this.width, this.height, DrRenderUtils.interpolateColor(rectColor.getRGB(), DrRenderUtils.brighter(rectColor, 0.8F).getRGB(), (float)this.hoverAnimation.getOutput()));
/*     */     
/*  72 */     DrRenderUtils.drawRect2(this.x, this.y, this.width, this.height, DrRenderUtils.applyOpacity(clickModColor, (float)this.animation.getOutput()).getRGB());
/*     */     
/*  74 */     Fonts.SF.SF_20.SF_20.drawString(this.module.getName(), this.x + 5.0F, this.y + Fonts.SF.SF_20.SF_20.getMiddleOfBox(this.height), textColor.getRGB());
/*     */     
/*  76 */     if (Keyboard.isKeyDown(15) && this.module.getKeyBind() != 0) {
/*  77 */       String keyName = Keyboard.getKeyName(this.module.getKeyBind());
/*  78 */       Fonts.SF.SF_20.SF_20.drawString(keyName, this.x + this.width - Fonts.SF.SF_20.SF_20.stringWidth(keyName) - 5.0F, this.y + Fonts.SF.SF_20.SF_20.getMiddleOfBox(this.height), textColor.getRGB());
/*     */     } else {
/*  80 */       float arrowSize = 6.0F;
/*  81 */       this.arrowAnimation.setDirection(this.module.getExpanded() ? Direction.FORWARDS : Direction.BACKWARDS);
/*  82 */       DrRenderUtils.setAlphaLimit(0.0F);
/*  83 */       DrRenderUtils.resetColor();
/*  84 */       DrRenderUtils.drawClickGuiArrow(this.x + this.width - arrowSize + 5.0F, this.y + this.height / 2.0F - 2.0F, arrowSize, this.arrowAnimation, textColor.getRGB());
/*     */     } 
/*     */     
/*  87 */     Color settingRectColor = new Color(32, 32, 32, this.alphaAnimation);
/*     */ 
/*     */     
/*  90 */     double settingHeight = this.settingComponents.settingSize * this.settingAnimation.getOutput();
/*  91 */     if (this.module.getExpanded() || !this.settingAnimation.isDone()) {
/*     */       
/*  93 */       DrRenderUtils.drawRect2(this.x, (this.y + this.height), this.width, settingHeight * this.height, settingRectColor.getRGB());
/*     */       
/*  95 */       boolean hoveringSettingsOrModule = DrRenderUtils.isHovering(this.x, this.y, this.width, (float)(this.height + settingHeight * this.height), mouseX, mouseY);
/*     */ 
/*     */       
/*  98 */       if (((Boolean)ClickGUI.backback.get()).booleanValue()) {
/*     */         
/* 100 */         DrRenderUtils.resetColor();
/*     */         
/* 102 */         float accentAlpha = (float)(0.85D * this.animation.getOutput()) * alpha;
/*     */         
/* 104 */         DrRenderUtils.drawRect2(this.x, (this.y + this.height), this.width, (float)(settingHeight * this.height), DrRenderUtils.applyOpacity(clickModColor, accentAlpha).getRGB());
/*     */       } 
/*     */ 
/*     */       
/* 108 */       this.settingComponents.x = this.x;
/* 109 */       this.settingComponents.y = this.y + this.height;
/* 110 */       this.settingComponents.width = this.width;
/* 111 */       this.settingComponents.rectHeight = this.height;
/* 112 */       this.settingComponents.panelLimitY = this.panelLimitY;
/* 113 */       this.settingComponents.alphaAnimation = this.alphaAnimation;
/* 114 */       this.settingComponents.settingHeightScissor = this.settingAnimation;
/* 115 */       if (!this.settingAnimation.isDone()) {
/* 116 */         GL11.glEnable(3089);
/* 117 */         DrRenderUtils.scissor(this.x, (this.y + this.height), this.width, settingHeight * this.height);
/*     */         
/* 119 */         this.settingComponents.drawScreen(mouseX, mouseY);
/* 120 */         DrRenderUtils.drawGradientRect2(this.x, (this.y + this.height), this.width, 6.0D, (new Color(0, 0, 0, 60)).getRGB(), (new Color(0, 0, 0, 0)).getRGB());
/* 121 */         DrRenderUtils.drawGradientRect2(this.x, (this.y + 11.0F) + settingHeight * this.height, this.width, 6.0D, (new Color(0, 0, 0, 0)).getRGB(), (new Color(0, 0, 0, 60)).getRGB());
/* 122 */         GL11.glDisable(3089);
/*     */       } else {
/* 124 */         this.settingComponents.drawScreen(mouseX, mouseY);
/* 125 */         DrRenderUtils.drawGradientRect2(this.x, (this.y + this.height), this.width, 6.0D, (new Color(0, 0, 0, 60)).getRGB(), (new Color(0, 0, 0, 0)).getRGB());
/* 126 */         DrRenderUtils.drawGradientRect2(this.x, (this.y + 11.0F) + settingHeight * this.height, this.width, 6.0D, (new Color(0, 0, 0, 0)).getRGB(), (new Color(0, 0, 0, 60)).getRGB());
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     this.settingSize = settingHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int button) {
/* 137 */     boolean hoveringModule = (isClickable(this.y, this.panelLimitY) && DrRenderUtils.isHovering(this.x, this.y, this.width, this.height, mouseX, mouseY));
/* 138 */     if (hoveringModule) {
/* 139 */       switch (button) {
/*     */         case 0:
/* 141 */           this.clickX = mouseX;
/* 142 */           this.clickY = mouseY;
/* 143 */           this.animation.setDirection(!this.module.getState() ? Direction.FORWARDS : Direction.BACKWARDS);
/* 144 */           this.module.toggle();
/*     */           break;
/*     */         case 1:
/* 147 */           this.module.setExpanded(!this.module.getExpanded());
/*     */           break;
/*     */       } 
/*     */     }
/* 151 */     if (this.module.getExpanded()) {
/* 152 */       this.settingComponents.mouseClicked(mouseX, mouseY, button);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 158 */     if (this.module.getExpanded()) {
/* 159 */       this.settingComponents.mouseReleased(mouseX, mouseY, state);
/*     */     }
/*     */   }
/*     */   
/*     */   public double getSettingSize() {
/* 164 */     return this.settingSize;
/*     */   }
/*     */   
/*     */   public boolean isClickable(float y, float panelLimitY) {
/* 168 */     return (y > panelLimitY && y < panelLimitY + Main.allowedClickGuiHeight + 17.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdown\impl\ModuleRect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */