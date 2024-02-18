/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.impl.ModuleRect;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.DecelerateAnimation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Main;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Screen;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.DrRenderUtils;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.StencilUtil;
/*     */ import net.ccbluex.liquidbounce.utils.MathUtils;
/*     */ import tomk.fonts.impl.Fonts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MainScreen
/*     */   implements Screen
/*     */ {
/*     */   private final ModuleCategory category;
/*  32 */   private final float rectWidth = 110.0F;
/*  33 */   private final float categoryRectHeight = 18.0F;
/*     */   public Animation animation;
/*  35 */   public HashMap<ModuleRect, Animation> moduleAnimMap = new HashMap<>();
/*     */   public Animation openingAnimation;
/*     */   private List<ModuleRect> moduleRects;
/*     */   
/*     */   public MainScreen(ModuleCategory category) {
/*  40 */     this.category = category;
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  45 */     if (this.moduleRects == null) {
/*  46 */       this.moduleRects = new ArrayList<>();
/*  47 */       for (Module module : Main.getModulesInCategory(this.category, Retreat.moduleManager).stream().sorted(Comparator.comparing(Module::getName)).collect(Collectors.toList())) {
/*  48 */         ModuleRect moduleRect = new ModuleRect(module);
/*  49 */         this.moduleRects.add(moduleRect);
/*  50 */         this.moduleAnimMap.put(moduleRect, new DecelerateAnimation(250, 1.0D));
/*     */       } 
/*     */     } 
/*     */     
/*  54 */     if (this.moduleRects != null) {
/*  55 */       this.moduleRects.forEach(ModuleRect::initGui);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/*  62 */     if (this.moduleRects != null) {
/*  63 */       this.moduleRects.forEach(moduleRect -> moduleRect.keyTyped(typedChar, keyCode));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY) {
/*  69 */     float animClamp = (float)Math.max(0.0D, Math.min(255.0D, 255.0D * this.animation.getOutput()));
/*  70 */     int alphaAnimation = (int)animClamp;
/*  71 */     int categoryRectColor = (new Color(29, 29, 29, alphaAnimation)).getRGB();
/*  72 */     int textColor = (new Color(255, 255, 255, alphaAnimation)).getRGB();
/*     */     
/*  74 */     this.category.getDrag().onDraw(mouseX, mouseY);
/*  75 */     float x = this.category.getDrag().getX(), y = this.category.getDrag().getY();
/*  76 */     DrRenderUtils.drawRect2(x, y, 110.0D, 18.0D, categoryRectColor);
/*  77 */     DrRenderUtils.setAlphaLimit(0.0F);
/*  78 */     Fonts.SFBOLD.SFBOLD_26.SFBOLD_26.drawString(this.category.name(), x + 5.0F, y + Fonts.SFBOLD.SFBOLD_26.SFBOLD_26.getMiddleOfBox(18.0F), textColor);
/*     */ 
/*     */ 
/*     */     
/*  82 */     String l = "";
/*  83 */     if (this.category.name().equalsIgnoreCase("Combat")) {
/*  84 */       l = "D";
/*  85 */     } else if (this.category.name().equalsIgnoreCase("Movement")) {
/*  86 */       l = "A";
/*  87 */     } else if (this.category.name().equalsIgnoreCase("Player")) {
/*  88 */       l = "B";
/*  89 */     } else if (this.category.name().equalsIgnoreCase("Render")) {
/*  90 */       l = "C";
/*  91 */     } else if (this.category.name().equalsIgnoreCase("Exploit")) {
/*  92 */       l = "G";
/*  93 */     } else if (this.category.name().equalsIgnoreCase("Misc")) {
/*  94 */       l = "F";
/*     */     } 
/*     */ 
/*     */     
/*  98 */     DrRenderUtils.setAlphaLimit(0.0F);
/*  99 */     DrRenderUtils.resetColor();
/* 100 */     Fonts.ICONFONT.ICONFONT_20.ICONFONT_20.drawString(l, x + 110.0F - (Fonts.ICONFONT.ICONFONT_20.ICONFONT_20.stringWidth(l) + 5), y + Fonts.ICONFONT.ICONFONT_20.ICONFONT_20
/* 101 */         .getMiddleOfBox(18.0F), textColor);
/*     */     
/* 103 */     if (this.category.name().equalsIgnoreCase("World")) {
/* 104 */       Fonts.CheckFont.CheckFont_20.CheckFont_20.drawString("b", x + 110.0F - (Fonts.CheckFont.CheckFont_20.CheckFont_20.stringWidth("b") + 5), y + Fonts.ICONFONT.ICONFONT_20.ICONFONT_20
/* 105 */           .getMiddleOfBox(18.0F), textColor);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 110 */     if (((String)ClickGUI.scrollMode.get()).equals("Value")) {
/* 111 */       Main.allowedClickGuiHeight = ((Integer)ClickGUI.clickHeight.get()).floatValue();
/*     */     } else {
/* 113 */       IScaledResolution sr = Retreat.INSTANCE.getWrapper().getClassProvider().createScaledResolution(mc);
/* 114 */       Main.allowedClickGuiHeight = (2 * sr.getScaledHeight()) / 3.0F;
/*     */     } 
/*     */     
/* 117 */     float allowedHeight = Main.allowedClickGuiHeight;
/*     */ 
/*     */     
/* 120 */     boolean hoveringMods = DrRenderUtils.isHovering(x, y + 18.0F, 110.0F, allowedHeight, mouseX, mouseY);
/*     */ 
/*     */     
/* 123 */     float scaleAnim = Math.max(1.0F, (float)this.openingAnimation.getOutput() + 0.7F);
/* 124 */     float width = 110.0F;
/*     */     
/* 126 */     StencilUtil.initStencilToWrite();
/* 127 */     DrRenderUtils.drawRect2((x - 100.0F), (y + 18.0F), 260.0D, allowedHeight, -1);
/* 128 */     StencilUtil.readStencilBuffer(1);
/*     */     
/* 130 */     double scroll = this.category.getScroll().getScroll();
/* 131 */     double count = 0.0D;
/* 132 */     for (ModuleRect moduleRect : this.moduleRects) {
/* 133 */       Animation animation = this.moduleAnimMap.get(moduleRect);
/* 134 */       animation.setDirection(moduleRect.module.getExpanded() ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */       
/* 136 */       moduleRect.settingAnimation = animation;
/* 137 */       moduleRect.alphaAnimation = alphaAnimation;
/* 138 */       moduleRect.x = x;
/* 139 */       moduleRect.height = 17.0F;
/* 140 */       moduleRect.panelLimitY = y;
/* 141 */       moduleRect.openingAnimation = this.openingAnimation;
/* 142 */       moduleRect.y = (float)((y + 18.0F) + count * 17.0D + MathUtils.roundToHalf(scroll));
/* 143 */       moduleRect.width = 110.0F;
/* 144 */       moduleRect.drawScreen(mouseX, mouseY);
/*     */ 
/*     */       
/* 147 */       count += 1.0D + moduleRect.getSettingSize();
/*     */     } 
/*     */     
/* 150 */     if (hoveringMods) {
/* 151 */       this.category.getScroll().onScroll(30);
/* 152 */       float hiddenHeight = (float)(count * 17.0D - allowedHeight);
/* 153 */       this.category.getScroll().setMaxScroll(Math.max(0.0F, hiddenHeight));
/*     */     } 
/*     */     
/* 156 */     StencilUtil.uninitStencilBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int button) {
/* 162 */     boolean canDrag = DrRenderUtils.isHovering(this.category.getDrag().getX(), this.category.getDrag().getY(), 110.0F, 18.0F, mouseX, mouseY);
/* 163 */     this.category.getDrag().onClick(mouseX, mouseY, button, canDrag);
/* 164 */     this.moduleRects.forEach(moduleRect -> moduleRect.mouseClicked(mouseX, mouseY, button));
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 169 */     this.category.getDrag().onRelease(state);
/* 170 */     this.moduleRects.forEach(moduleRect -> moduleRect.mouseReleased(mouseX, mouseY, state));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdown\MainScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */