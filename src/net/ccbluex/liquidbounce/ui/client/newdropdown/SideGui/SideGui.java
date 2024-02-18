/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown.SideGui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.HashMap;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.DecelerateAnimation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.TimerUtil;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.objects.Drag;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.DrRenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import tomk.fonts.impl.Fonts;
/*     */ import tomk.utils.LiYingUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SideGui
/*     */   extends GuiPanel
/*     */ {
/*  25 */   private final String[] categories = new String[] { "Scripts", "Configs" };
/*     */   public boolean focused;
/*     */   public Animation clickAnimation;
/*     */   private Animation hoverAnimation;
/*     */   private Animation textAnimation;
/*     */   private Animation moveOverGradientAnimation;
/*  31 */   private HashMap<String, Animation[]> categoryAnimation = (HashMap)new HashMap<>();
/*     */   private Drag drag;
/*  33 */   private String currentCategory = "Configs";
/*     */ 
/*     */   
/*     */   private TimerUtil timerUtil;
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  40 */     this.focused = false;
/*  41 */     this.timerUtil = new TimerUtil();
/*  42 */     this.rectWidth = 550.0F;
/*  43 */     this.rectHeight = 350.0F;
/*  44 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*  45 */     this.drag = new Drag((sr.func_78326_a() - 30), sr.func_78328_b() / 2.0F - this.rectHeight / 2.0F);
/*  46 */     this.textAnimation = (Animation)new DecelerateAnimation(500, 1.0D);
/*  47 */     this.textAnimation.setDirection(Direction.BACKWARDS);
/*  48 */     this.clickAnimation = (Animation)new DecelerateAnimation(325, 1.0D);
/*  49 */     this.clickAnimation.setDirection(Direction.BACKWARDS);
/*  50 */     this.categoryAnimation = (HashMap)new HashMap<>();
/*  51 */     for (String category : this.categories) {
/*  52 */       this.categoryAnimation.put(category, new Animation[] { (Animation)new DecelerateAnimation(250, 1.0D), (Animation)new DecelerateAnimation(250, 1.0D) });
/*     */     } 
/*     */     
/*  55 */     this.moveOverGradientAnimation = (Animation)new DecelerateAnimation(250, 1.0D);
/*  56 */     this.moveOverGradientAnimation.setDirection(Direction.BACKWARDS);
/*     */     
/*  58 */     this.hoverAnimation = (Animation)new DecelerateAnimation(250, 1.0D);
/*  59 */     this.hoverAnimation.setDirection(Direction.BACKWARDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/*  66 */     switch (this.currentCategory) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks, int alpha) {
/*  86 */     this.clickAnimation.setDirection(this.focused ? Direction.FORWARDS : Direction.BACKWARDS);
/*  87 */     boolean hovering = DrRenderUtils.isHovering(this.drag.getX(), this.drag.getY(), this.rectWidth, this.rectHeight, mouseX, mouseY);
/*  88 */     this.hoverAnimation.setDirection(hovering ? Direction.FORWARDS : Direction.BACKWARDS);
/*  89 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*     */     
/*  91 */     boolean setDirection = (!this.focused && (!this.timerUtil.hasTimeElapsed(6000L) || !this.hoverAnimation.isDone() || (this.hoverAnimation.isDone() && this.hoverAnimation.getDirection().equals(Direction.FORWARDS))));
/*  92 */     this.textAnimation.setDirection(setDirection ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */ 
/*     */     
/*  95 */     if (!this.textAnimation.isDone() || !this.textAnimation.getDirection().equals(Direction.FORWARDS) || this.textAnimation.isDone());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     if (!this.clickAnimation.isDone()) {
/* 104 */       this.drag.setX(LiYingUtil.interpolateFloat((sr.func_78326_a() - 30), this.focused ? (sr.func_78326_a() / 2.0F - this.rectWidth / 2.0F) : this.drag.getX(), (float)this.clickAnimation.getOutput()));
/* 105 */       this.drag.setY(LiYingUtil.interpolateFloat(sr.func_78328_b() / 2.0F - this.rectHeight / 2.0F, this.drag.getY(), (float)this.clickAnimation.getOutput()));
/*     */     } 
/*     */     
/* 108 */     boolean gradient = (this.drag.getX() + this.rectWidth > sr.func_78326_a() && this.focused && this.clickAnimation.isDone() && this.clickAnimation.getDirection().equals(Direction.FORWARDS));
/* 109 */     this.moveOverGradientAnimation.setDirection(gradient ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */ 
/*     */     
/* 112 */     float rectAlpha = (float)Math.min((float)(185.0D + 30.0D * this.hoverAnimation.getOutput() + 70.0D * this.clickAnimation.getOutput()) - 70.0D * this.moveOverGradientAnimation.getOutput(), 255.0D);
/* 113 */     rectAlpha *= alpha / 255.0F;
/*     */     
/* 115 */     Color mainRectColor = new Color(30, 30, 30, (int)rectAlpha);
/*     */     
/* 117 */     if (this.focused) {
/* 118 */       this.drag.onDraw(mouseX, mouseY);
/*     */     }
/*     */     
/* 121 */     float x = this.drag.getX(), y = this.drag.getY();
/* 122 */     RoundedUtil.drawRound(x, y, this.rectWidth, this.rectHeight, 9.0F, mainRectColor);
/* 123 */     if (!this.focused)
/* 124 */       return;  int textColor = DrRenderUtils.applyOpacity(-1, alpha / 255.0F);
/* 125 */     int seperation = 0;
/* 126 */     for (String category : this.categories) {
/* 127 */       float xVal = x + this.rectWidth / 2.0F - 50.0F + seperation;
/* 128 */       float yVal = y + 15.0F;
/*     */       
/* 130 */       boolean hovered = DrRenderUtils.isHovering(xVal - 30.0F, yVal - 5.0F, 60.0F, (Fonts.SFBOLD.SFBOLD_26.SFBOLD_26.getHeight() + 10), mouseX, mouseY);
/* 131 */       Animation hoverAnimation = ((Animation[])this.categoryAnimation.get(category))[0];
/* 132 */       Animation enableAnimation = ((Animation[])this.categoryAnimation.get(category))[1];
/*     */       
/* 134 */       hoverAnimation.setDirection(hovered ? Direction.FORWARDS : Direction.BACKWARDS);
/* 135 */       enableAnimation.setDirection(this.currentCategory.equals(category) ? Direction.FORWARDS : Direction.BACKWARDS);
/* 136 */       ClickGUI clickGUI = (ClickGUI)Retreat.moduleManager.getModule(ClickGUI.class);
/* 137 */       Color color22 = ClickGUI.generateColor();
/* 138 */       Color categoryColor = new Color(45, 45, 45, alpha);
/* 139 */       Color hoverColor = DrRenderUtils.interpolateColorC(categoryColor, DrRenderUtils.brighter(categoryColor, 0.8F), (float)hoverAnimation.getOutput());
/* 140 */       Color finalColor = DrRenderUtils.interpolateColorC(hoverColor, DrRenderUtils.applyOpacity(color22, alpha / 255.0F), (float)enableAnimation.getOutput());
/*     */       
/* 142 */       RoundedUtil.drawRound(xVal - 30.0F, yVal - 5.0F, 60.0F, (Fonts.SFBOLD.SFBOLD_26.SFBOLD_26.getHeight() + 10), 6.0F, finalColor);
/*     */       
/* 144 */       DrRenderUtils.resetColor();
/* 145 */       Fonts.SFBOLD.SFBOLD_26.SFBOLD_26.drawCenteredString(category, xVal, y + 15.0F, textColor);
/* 146 */       seperation += 100;
/*     */     } 
/*     */     
/* 149 */     DrRenderUtils.drawRect2((x + 20.0F), (y + 50.0F), (this.rectWidth - 40.0F), 1.0D, (new Color(45, 45, 45, alpha)).getRGB());
/*     */ 
/*     */     
/* 152 */     if (this.currentCategory.equals("Scripts"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     DrRenderUtils.setAlphaLimit(0.0F);
/* 166 */     DrRenderUtils.drawGradientRect2((x + 20.0F), (y + 51.0F), (this.rectWidth - 40.0F), 8.0D, (new Color(0, 0, 0, (int)(60.0F * alpha / 255.0F))).getRGB(), (new Color(0, 0, 0, 0)).getRGB());
/*     */     
/* 168 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 169 */     DrRenderUtils.setAlphaLimit(0.0F);
/* 170 */     DrRenderUtils.drawGradientRectSideways2((sr.func_78326_a() - 40), 0.0D, 40.0D, sr.func_78328_b(), 
/* 171 */         DrRenderUtils.applyOpacity(ClickGUI.generateColor().getRGB(), 0.0F), 
/* 172 */         DrRenderUtils.applyOpacity(ClickGUI.generateColor().getRGB(), (float)(0.4D * this.moveOverGradientAnimation.getOutput())));
/*     */     
/* 174 */     DrRenderUtils.setAlphaLimit(1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int button) {
/* 179 */     boolean hovering = DrRenderUtils.isHovering(this.drag.getX(), this.drag.getY(), this.rectWidth, this.rectHeight, mouseX, mouseY);
/* 180 */     if (hovering && button == 0 && !this.focused) {
/* 181 */       this.focused = true;
/*     */       
/*     */       return;
/*     */     } 
/* 185 */     if (this.focused) {
/*     */       
/* 187 */       boolean canDrag = (DrRenderUtils.isHovering(this.drag.getX(), this.drag.getY(), this.rectWidth, 50.0F, mouseX, mouseY) || DrRenderUtils.isHovering(this.drag.getX(), this.drag.getY(), 20.0F, this.rectHeight, mouseX, mouseY));
/* 188 */       this.drag.onClick(mouseX, mouseY, button, canDrag);
/*     */       
/* 190 */       float x = this.drag.getX(), y = this.drag.getY();
/* 191 */       int seperation = 0;
/* 192 */       for (String category : this.categories) {
/* 193 */         float xVal = x + this.rectWidth / 2.0F - 50.0F + seperation;
/* 194 */         float yVal = y + 15.0F;
/*     */         
/* 196 */         boolean hovered = DrRenderUtils.isHovering(xVal - 30.0F, yVal - 5.0F, 60.0F, (Fonts.SFBOLD.SFBOLD_26.SFBOLD_26.getHeight() + 10), mouseX, mouseY);
/*     */         
/* 198 */         if (hovered) {
/* 199 */           this.currentCategory = category;
/*     */           return;
/*     */         } 
/* 202 */         seperation += 100;
/*     */       } 
/*     */       
/* 205 */       if (this.currentCategory.equals("Configs"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseReleased(int mouseX, int mouseY, int button) {
/* 217 */     if (this.focused) {
/* 218 */       this.drag.onRelease(button);
/* 219 */       ScaledResolution sr = new ScaledResolution(this.mc);
/* 220 */       if (this.drag.getX() + this.rectWidth > sr.func_78326_a() && this.clickAnimation.isDone()) {
/* 221 */         this.focused = false;
/*     */       }
/* 223 */       if (this.currentCategory.equals("Configs"));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdown\SideGui\SideGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */