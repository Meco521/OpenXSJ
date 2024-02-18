/*     */ package net.ccbluex.liquidbounce.ui.client.clickgui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.Element;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.styles.SlowlyStyle;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
/*     */ import net.ccbluex.liquidbounce.ui.font.AWTFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ClickGui
/*     */   extends WrappedGuiScreen {
/*  30 */   public final List<Panel> panels = new ArrayList<>();
/*  31 */   private final IResourceLocation hudIcon = classProvider.createResourceLocation("tomk/custom_hud_icon.png");
/*  32 */   public Style style = (Style)new SlowlyStyle();
/*     */   private Panel clickedPanel;
/*     */   private int mouseX;
/*     */   private int mouseY;
/*     */   private double slide;
/*  37 */   private double progress = 0.0D;
/*     */   public ClickGui() {
/*  39 */     int width = 100;
/*  40 */     int height = 18;
/*     */     
/*  42 */     int yPos = 5;
/*  43 */     for (ModuleCategory category : ModuleCategory.values()) {
/*  44 */       this.panels.add(new Panel(category.getDisplayName(), 100, yPos, 100, 18, false)
/*     */           {
/*     */             public void setupItems()
/*     */             {
/*  48 */               for (Module module : Retreat.moduleManager.getModules()) {
/*  49 */                 if (module.getCategory() == category)
/*  50 */                   getElements().add(new ModuleElement(module)); 
/*     */               } 
/*     */             }
/*     */           });
/*  54 */       yPos += 20;
/*     */     } 
/*     */     
/*  57 */     yPos += 20;
/*     */     
/*  59 */     this.panels.add(new Panel("Targets", 100, yPos, 100, 18, false)
/*     */         {
/*     */           public void setupItems()
/*     */           {
/*  63 */             getElements().add(new ButtonElement("Players")
/*     */                 {
/*     */                   public void createButton(String displayName)
/*     */                   {
/*  67 */                     this.color = EntityUtils.targetPlayer ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/*  68 */                     super.createButton(displayName);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public String getDisplayName() {
/*  73 */                     this.displayName = "Players";
/*  74 */                     this.color = EntityUtils.targetPlayer ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/*  75 */                     return super.getDisplayName();
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/*  80 */                     if (mouseButton == 0 && isHovering(mouseX, mouseY) && isVisible()) {
/*  81 */                       EntityUtils.targetPlayer = !EntityUtils.targetPlayer;
/*  82 */                       this.displayName = "Players";
/*  83 */                       this.color = EntityUtils.targetPlayer ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/*  84 */                       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                     } 
/*     */                   }
/*     */                 });
/*     */             
/*  89 */             getElements().add(new ButtonElement("Mobs")
/*     */                 {
/*     */                   public void createButton(String displayName)
/*     */                   {
/*  93 */                     this.color = EntityUtils.targetMobs ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/*  94 */                     super.createButton(displayName);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public String getDisplayName() {
/*  99 */                     this.displayName = "Mobs";
/* 100 */                     this.color = EntityUtils.targetMobs ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 101 */                     return super.getDisplayName();
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 106 */                     if (mouseButton == 0 && isHovering(mouseX, mouseY) && isVisible()) {
/* 107 */                       EntityUtils.targetMobs = !EntityUtils.targetMobs;
/* 108 */                       this.displayName = "Mobs";
/* 109 */                       this.color = EntityUtils.targetMobs ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 110 */                       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                     } 
/*     */                   }
/*     */                 });
/*     */             
/* 115 */             getElements().add(new ButtonElement("Animals")
/*     */                 {
/*     */                   public void createButton(String displayName)
/*     */                   {
/* 119 */                     this.color = EntityUtils.targetAnimals ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 120 */                     super.createButton(displayName);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public String getDisplayName() {
/* 125 */                     this.displayName = "Animals";
/* 126 */                     this.color = EntityUtils.targetAnimals ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 127 */                     return super.getDisplayName();
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 132 */                     if (mouseButton == 0 && isHovering(mouseX, mouseY) && isVisible()) {
/* 133 */                       EntityUtils.targetAnimals = !EntityUtils.targetAnimals;
/* 134 */                       this.displayName = "Animals";
/* 135 */                       this.color = EntityUtils.targetAnimals ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 136 */                       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                     } 
/*     */                   }
/*     */                 });
/*     */             
/* 141 */             getElements().add(new ButtonElement("Invisible")
/*     */                 {
/*     */                   public void createButton(String displayName)
/*     */                   {
/* 145 */                     this.color = EntityUtils.targetInvisible ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 146 */                     super.createButton(displayName);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public String getDisplayName() {
/* 151 */                     this.displayName = "Invisible";
/* 152 */                     this.color = EntityUtils.targetInvisible ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 153 */                     return super.getDisplayName();
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 158 */                     if (mouseButton == 0 && isHovering(mouseX, mouseY) && isVisible()) {
/* 159 */                       EntityUtils.targetInvisible = !EntityUtils.targetInvisible;
/* 160 */                       this.displayName = "Invisible";
/* 161 */                       this.color = EntityUtils.targetInvisible ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 162 */                       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                     } 
/*     */                   }
/*     */                 });
/*     */             
/* 167 */             getElements().add(new ButtonElement("Dead")
/*     */                 {
/*     */                   public void createButton(String displayName)
/*     */                   {
/* 171 */                     this.color = EntityUtils.targetDead ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 172 */                     super.createButton(displayName);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public String getDisplayName() {
/* 177 */                     this.displayName = "Dead";
/* 178 */                     this.color = EntityUtils.targetDead ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 179 */                     return super.getDisplayName();
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/* 184 */                     if (mouseButton == 0 && isHovering(mouseX, mouseY) && isVisible()) {
/* 185 */                       EntityUtils.targetDead = !EntityUtils.targetDead;
/* 186 */                       this.displayName = "Dead";
/* 187 */                       this.color = EntityUtils.targetDead ? ClickGUI.generateColor().getRGB() : Integer.MAX_VALUE;
/* 188 */                       mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                     } 
/*     */                   }
/*     */                 });
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 198 */     if (Mouse.isButtonDown(0) && mouseX >= 5 && mouseX <= 50 && mouseY <= this.representedScreen.getHeight() - 5 && mouseY >= this.representedScreen.getHeight() - 50) {
/* 199 */       mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiHudDesigner()));
/*     */     }
/*     */     
/* 202 */     AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */     
/* 204 */     double scale = ((Float)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).scaleValue.get()).floatValue();
/* 205 */     GlStateManager.func_179137_b(0.0D, this.slide, 0.0D);
/*     */ 
/*     */     
/* 208 */     mouseX = (int)(mouseX / scale);
/* 209 */     mouseY = (int)(mouseY / scale);
/*     */     
/* 211 */     this.mouseX = mouseX;
/* 212 */     this.mouseY = mouseY;
/*     */     
/* 214 */     ScaledResolution sr = new ScaledResolution(minecraft);
/* 215 */     RenderUtils.drawRect(0.0F, 0.0F, sr.func_78326_a(), sr.func_78328_b(), new Color(0, 0, 0, 150));
/* 216 */     RenderUtils.drawImage(this.hudIcon, 9, this.representedScreen.getHeight() - 41, 32, 32);
/*     */     
/* 218 */     GL11.glScaled(scale, scale, scale);
/*     */     
/* 220 */     for (Panel panel : this.panels) {
/* 221 */       panel.updateFade(RenderUtils.deltaTime);
/* 222 */       panel.drawScreen(mouseX, mouseY, partialTicks);
/*     */     } 
/*     */     
/* 225 */     for (Panel panel : this.panels) {
/* 226 */       for (Element element : panel.getElements()) {
/* 227 */         if (element instanceof ModuleElement) {
/* 228 */           ModuleElement moduleElement = (ModuleElement)element;
/*     */           
/* 230 */           if (mouseX != 0 && mouseY != 0 && moduleElement.isHovering(mouseX, mouseY) && moduleElement.isVisible() && element.getY() <= panel.getY() + panel.getFade()) {
/* 231 */             this.style.drawDescription(mouseX, mouseY, moduleElement.getModule().getDescription());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 236 */     if (Mouse.hasWheel()) {
/* 237 */       int wheel = Mouse.getDWheel();
/* 238 */       boolean handledScroll = false;
/* 239 */       for (int i = this.panels.size() - 1; i >= 0; i--) {
/* 240 */         if (((Panel)this.panels.get(i)).handleScroll(mouseX, mouseY, wheel)) {
/* 241 */           handledScroll = true; break;
/*     */         } 
/*     */       } 
/* 244 */       if (!handledScroll) {
/* 245 */         hand(wheel);
/*     */       }
/*     */     } 
/*     */     
/* 249 */     classProvider.getGlStateManager().disableLighting();
/* 250 */     functions.disableStandardItemLighting();
/* 251 */     GL11.glScaled(1.0D, 1.0D, 1.0D);
/*     */     
/* 253 */     AWTFontRenderer.Companion.setAssumeNonVolatile(false);
/*     */     
/* 255 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */   private void hand(int wheel) {
/* 259 */     if (wheel == 0) {
/*     */       return;
/*     */     }
/* 262 */     for (Panel panel : this.panels) {
/* 263 */       panel.setY(panel.getY() + wheel);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 269 */     double scale = ((Float)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).scaleValue.get()).floatValue();
/* 270 */     mouseX = (int)(mouseX / scale);
/* 271 */     mouseY = (int)(mouseY / scale);
/*     */     
/* 273 */     for (Panel panel : this.panels) {
/* 274 */       panel.mouseClicked(mouseX, mouseY, mouseButton);
/*     */       
/* 276 */       panel.drag = false;
/*     */       
/* 278 */       if (mouseButton == 0 && panel.isHovering(mouseX, mouseY)) {
/* 279 */         this.clickedPanel = panel;
/*     */       }
/*     */     } 
/* 282 */     if (this.clickedPanel != null) {
/* 283 */       this.clickedPanel.x2 = this.clickedPanel.x - mouseX;
/* 284 */       this.clickedPanel.y2 = this.clickedPanel.y - mouseY;
/* 285 */       this.clickedPanel.drag = true;
/*     */       
/* 287 */       this.panels.remove(this.clickedPanel);
/* 288 */       this.panels.add(this.clickedPanel);
/* 289 */       this.clickedPanel = null;
/*     */     } 
/*     */     
/* 292 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 297 */     double scale = ((Float)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).scaleValue.get()).floatValue();
/* 298 */     mouseX = (int)(mouseX / scale);
/* 299 */     mouseY = (int)(mouseY / scale);
/*     */     
/* 301 */     for (Panel panel : this.panels) {
/* 302 */       panel.mouseReleased(mouseX, mouseY, state);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 308 */     for (Panel panel : this.panels) {
/* 309 */       for (Element element : panel.getElements()) {
/* 310 */         if (element instanceof ButtonElement) {
/* 311 */           ButtonElement buttonElement = (ButtonElement)element;
/*     */           
/* 313 */           if (buttonElement.isHovering(this.mouseX, this.mouseY)) {
/* 314 */             if (buttonElement.hoverTime < 7)
/* 315 */               buttonElement.hoverTime++; 
/* 316 */           } else if (buttonElement.hoverTime > 0) {
/* 317 */             buttonElement.hoverTime--;
/*     */           } 
/*     */         } 
/* 320 */         if (element instanceof ModuleElement) {
/* 321 */           if (((ModuleElement)element).getModule().getState()) {
/* 322 */             if (((ModuleElement)element).slowlyFade < 255)
/* 323 */               ((ModuleElement)element).slowlyFade += 20; 
/* 324 */           } else if (((ModuleElement)element).slowlyFade > 0) {
/* 325 */             ((ModuleElement)element).slowlyFade -= 20;
/*     */           } 
/* 327 */           if (((ModuleElement)element).slowlyFade > 255) {
/* 328 */             ((ModuleElement)element).slowlyFade = 255;
/*     */           }
/* 330 */           if (((ModuleElement)element).slowlyFade < 0)
/* 331 */             ((ModuleElement)element).slowlyFade = 0; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 335 */     super.updateScreen();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 340 */     Retreat.fileManager.saveConfig(Retreat.fileManager.clickGuiConfig);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/* 345 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\ClickGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */