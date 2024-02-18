/*     */ package net.ccbluex.liquidbounce.ui.client.newdropdown.impl;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.HashMap;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Direction;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.DecelerateAnimation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.EaseInOutQuad;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal.Main;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.objects.PasswordField;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.DrRenderUtils;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.GuiEvents;
/*     */ import net.ccbluex.liquidbounce.utils.MathUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tomk.fonts.impl.Fonts;
/*     */ import tomk.utils.LiYingUtil;
/*     */ 
/*     */ public class SettingComponents
/*     */   extends Component {
/*     */   public static float scale;
/*  35 */   private final HashMap<Module, Animation[]> keySettingAnimMap = (HashMap)new HashMap<>(); private final Module module; public Animation settingHeightScissor;
/*  36 */   private final HashMap<IntegerValue, Float> sliderintMap = new HashMap<>();
/*  37 */   private final HashMap<IntegerValue, Animation[]> sliderintAnimMap = (HashMap)new HashMap<>();
/*  38 */   private final HashMap<FloatValue, Float> sliderfloatMap = new HashMap<>();
/*  39 */   private final HashMap<FloatValue, Animation[]> sliderfloatAnimMap = (HashMap)new HashMap<>();
/*  40 */   private final HashMap<BoolValue, Animation[]> toggleAnimation = (HashMap)new HashMap<>();
/*  41 */   private final HashMap<ListValue, Animation[]> modeSettingAnimMap = (HashMap)new HashMap<>();
/*  42 */   private final HashMap<ListValue, Boolean> modeSettingClick = new HashMap<>();
/*  43 */   private final HashMap<ListValue, HashMap<String, Animation>> modesHoverAnimation = new HashMap<>();
/*     */   
/*     */   public Module binding;
/*     */   
/*     */   public Value draggingNumber;
/*     */   
/*     */   public float x;
/*     */   
/*     */   public float y;
/*     */   public float width;
/*     */   public float rectHeight;
/*     */   
/*     */   public SettingComponents(Module module) {
/*  56 */     this.module = module;
/*  57 */     this.keySettingAnimMap.put(module, new Animation[] { (Animation)new EaseInOutQuad(250, 1.0D, Direction.BACKWARDS), (Animation)new DecelerateAnimation(225, 1.0D, Direction.BACKWARDS) });
/*     */ 
/*     */     
/*  60 */     for (Value setting : module.getValues()) {
/*     */       
/*  62 */       if (setting instanceof FloatValue) {
/*  63 */         this.sliderfloatMap.put((FloatValue)setting, Float.valueOf(0.0F));
/*  64 */         this.sliderfloatAnimMap.put((FloatValue)setting, new Animation[] { (Animation)new DecelerateAnimation(250, 1.0D, Direction.BACKWARDS), (Animation)new DecelerateAnimation(200, 1.0D, Direction.BACKWARDS) });
/*     */       } 
/*  66 */       if (setting instanceof IntegerValue) {
/*  67 */         this.sliderintMap.put((IntegerValue)setting, Float.valueOf(0.0F));
/*  68 */         this.sliderintAnimMap.put((IntegerValue)setting, new Animation[] { (Animation)new DecelerateAnimation(250, 1.0D, Direction.BACKWARDS), (Animation)new DecelerateAnimation(200, 1.0D, Direction.BACKWARDS) });
/*     */       } 
/*  70 */       if (setting instanceof BoolValue) {
/*  71 */         this.toggleAnimation.put((BoolValue)setting, new Animation[] { (Animation)new DecelerateAnimation(225, 1.0D, Direction.BACKWARDS), (Animation)new DecelerateAnimation(200, 1.0D, Direction.BACKWARDS) });
/*     */       }
/*     */       
/*  74 */       if (setting instanceof ListValue) {
/*  75 */         ListValue modeSetting = (ListValue)setting;
/*  76 */         this.modeSettingClick.put(modeSetting, Boolean.valueOf(false));
/*  77 */         this.modeSettingAnimMap.put(modeSetting, new Animation[] { (Animation)new DecelerateAnimation(225, 1.0D, Direction.BACKWARDS), (Animation)new EaseInOutQuad(250, 1.0D, Direction.BACKWARDS) });
/*     */ 
/*     */         
/*  80 */         HashMap<String, Animation> modeMap = new HashMap<>();
/*  81 */         for (String mode : modeSetting.getValues()) {
/*  82 */           modeMap.put(mode, new DecelerateAnimation(225, 1.0D, Direction.BACKWARDS));
/*     */         }
/*     */         
/*  85 */         this.modesHoverAnimation.put(modeSetting, modeMap);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float panelLimitY;
/*     */ 
/*     */   
/*     */   public int alphaAnimation;
/*     */ 
/*     */   
/*     */   public double settingSize;
/*     */ 
/*     */   
/*     */   private PasswordField selectedField;
/*     */ 
/*     */   
/*     */   private TextValue selectedStringSetting;
/*     */   
/*     */   private boolean hueFlag;
/*     */ 
/*     */   
/*     */   public void initGui() {}
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/* 113 */     if (this.selectedField != null) {
/* 114 */       if (keyCode == 1) {
/* 115 */         this.selectedField = null;
/* 116 */         this.selectedStringSetting = null;
/*     */         return;
/*     */       } 
/* 119 */       this.selectedField.textboxKeyTyped(typedChar, keyCode);
/* 120 */       this.selectedStringSetting.set(this.selectedField.getText());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handle(int mouseX, int mouseY, int button, GuiEvents type) {
/* 126 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/* 128 */     Color textColor = new Color(255, 255, 255, this.alphaAnimation);
/* 129 */     Color darkRectColor = new Color(48, 50, 55, this.alphaAnimation);
/* 130 */     Color darkRectColorDisabled = new Color(52, 52, 52, this.alphaAnimation);
/* 131 */     Color darkRectHover = DrRenderUtils.brighter(darkRectColor, 0.8F);
/*     */ 
/*     */ 
/*     */     
/* 135 */     Color[] colors = new Color[2];
/*     */     
/* 137 */     boolean accent = ((String)ClickGUI.colormode.get()).equalsIgnoreCase("Color");
/*     */     
/* 139 */     Color color2 = new Color(((Integer)AColorPalette.RA.get()).intValue(), ((Integer)AColorPalette.GA.get()).intValue(), ((Integer)AColorPalette.BA.get()).intValue());
/* 140 */     Color color1 = new Color(((Integer)AColorPalette.RA2.get()).intValue(), ((Integer)AColorPalette.GA2.get()).intValue(), ((Integer)AColorPalette.BA2.get()).intValue());
/* 141 */     colors = new Color[] { color2, color2 };
/*     */     
/* 143 */     Color accentedColor = DrRenderUtils.applyOpacity(colors[0], this.alphaAnimation / 255.0F);
/* 144 */     Color accentedColor2 = DrRenderUtils.applyOpacity(colors[1], this.alphaAnimation / 255.0F);
/*     */ 
/*     */     
/* 147 */     double count = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     for (Value setting : this.module.getValues()) {
/* 153 */       float settingY = (float)MathUtils.roundToHalf(this.y + count * this.rectHeight);
/* 154 */       if (setting instanceof FloatValue) {
/* 155 */         FloatValue numberSetting = (FloatValue)setting;
/*     */         
/* 157 */         String value = Float.toString((float)MathUtils.round(((Float)numberSetting.getValue()).floatValue(), 0.01D));
/* 158 */         float regularFontWidth = Fonts.SF.SF_18.SF_18.stringWidth(numberSetting.getName() + ": ");
/* 159 */         float valueFontWidth = Fonts.SF.SF_18.SF_18.stringWidth(value);
/*     */         
/* 161 */         float titleX = this.x + this.width / 2.0F - (regularFontWidth + valueFontWidth) / 2.0F;
/*     */         
/* 163 */         float titleY = settingY + Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) - Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) / 2.0F + 1.0F;
/* 164 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 166 */         Fonts.SF.SF_18.SF_18.drawString(numberSetting.getName() + ": ", titleX, titleY, textColor.getRGB());
/* 167 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 169 */         Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString(value, titleX + regularFontWidth, titleY, textColor.getRGB());
/*     */ 
/*     */         
/* 172 */         Animation hoverAnimation = ((Animation[])this.sliderfloatAnimMap.get(numberSetting))[0];
/* 173 */         Animation selectAnimtion = ((Animation[])this.sliderfloatAnimMap.get(numberSetting))[1];
/*     */         
/* 175 */         float totalSliderWidth = this.width - 10.0F;
/* 176 */         boolean hoveringSlider = (isClickable(settingY + 17.0F) && DrRenderUtils.isHovering(this.x + 5.0F, settingY + 17.0F, totalSliderWidth, 6.0F, mouseX, mouseY));
/*     */         
/* 178 */         if (type == GuiEvents.RELEASE) {
/* 179 */           this.draggingNumber = null;
/*     */         }
/* 181 */         hoverAnimation.setDirection((hoveringSlider || this.draggingNumber == numberSetting) ? Direction.FORWARDS : Direction.BACKWARDS);
/* 182 */         selectAnimtion.setDirection((this.draggingNumber == numberSetting) ? Direction.FORWARDS : Direction.BACKWARDS);
/* 183 */         if (type == GuiEvents.CLICK && hoveringSlider && button == 0) {
/* 184 */           this.draggingNumber = (Value)numberSetting;
/*     */         }
/*     */ 
/*     */         
/* 188 */         double currentValue = ((Float)numberSetting.getValue()).floatValue();
/*     */ 
/*     */         
/* 191 */         if (this.draggingNumber != null && this.draggingNumber == setting) {
/* 192 */           float percent = Math.min(1.0F, Math.max(0.0F, (mouseX - this.x + 5.0F) / totalSliderWidth));
/*     */           
/* 194 */           double newValue = (percent * (numberSetting.getMaximum() - numberSetting.getMinimum()) + numberSetting.getMinimum());
/* 195 */           numberSetting.set(Double.valueOf(newValue));
/*     */         } 
/*     */ 
/*     */         
/* 199 */         float sliderMath = (float)((currentValue - numberSetting.getMinimum()) / (numberSetting.getMaximum() - numberSetting.getMinimum()));
/*     */ 
/*     */         
/* 202 */         this.sliderfloatMap.put(numberSetting, Float.valueOf((float)DrRenderUtils.animate((totalSliderWidth * sliderMath), ((Float)this.sliderfloatMap.get(numberSetting)).floatValue(), 0.1D)));
/*     */ 
/*     */         
/* 205 */         float sliderY = settingY + 18.0F;
/* 206 */         RoundedUtil.drawRound(this.x + 5.0F, sliderY, totalSliderWidth, 3.0F, 1.5F, LiYingUtil.applyOpacity(darkRectHover, (float)(0.4000000059604645D + 0.2D * hoverAnimation.getOutput())));
/* 207 */         RoundedUtil.drawRound(this.x + 5.0F, sliderY, Math.max(4.0F, ((Float)this.sliderfloatMap.get(numberSetting)).floatValue()), 3.0F, 1.5F, accent ? accentedColor2 : textColor);
/*     */         
/* 209 */         LiYingUtil.setAlphaLimit(0.0F);
/* 210 */         LiYingUtil.fakeCircleGlow(this.x + 4.0F + Math.max(4.0F, ((Float)this.sliderfloatMap.get(numberSetting)).floatValue()), sliderY + 1.5F, 6.0F, Color.BLACK, 0.3F);
/*     */ 
/*     */         
/* 213 */         LiYingUtil.drawGoodCircle((this.x + 4.0F + Math.max(4.0F, ((Float)this.sliderfloatMap.get(numberSetting)).floatValue())), (sliderY + 1.5F), 3.75F, accent ? accentedColor2.getRGB() : textColor.getRGB());
/* 214 */         count += 0.5D;
/*     */       } 
/* 216 */       if (setting instanceof IntegerValue) {
/* 217 */         IntegerValue numberSetting = (IntegerValue)setting;
/*     */         
/* 219 */         String value = Float.toString((float)MathUtils.round(((Integer)numberSetting.getValue()).intValue(), 1.0D));
/* 220 */         float regularFontWidth = Fonts.SF.SF_18.SF_18.stringWidth(numberSetting.getName() + ": ");
/* 221 */         float valueFontWidth = Fonts.SF.SF_18.SF_18.stringWidth(value);
/*     */         
/* 223 */         float titleX = this.x + this.width / 2.0F - (regularFontWidth + valueFontWidth) / 2.0F;
/*     */         
/* 225 */         float titleY = settingY + Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) - Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) / 2.0F + 1.0F;
/* 226 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 228 */         Fonts.SF.SF_18.SF_18.drawString(numberSetting.getName() + ": ", titleX, titleY, textColor.getRGB());
/* 229 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 231 */         Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString(value, titleX + regularFontWidth, titleY, textColor.getRGB());
/*     */ 
/*     */         
/* 234 */         Animation hoverAnimation = ((Animation[])this.sliderintAnimMap.get(numberSetting))[0];
/* 235 */         Animation selectAnimtion = ((Animation[])this.sliderintAnimMap.get(numberSetting))[1];
/*     */         
/* 237 */         float totalSliderWidth = this.width - 10.0F;
/* 238 */         boolean hoveringSlider = (isClickable(settingY + 17.0F) && DrRenderUtils.isHovering(this.x + 5.0F, settingY + 17.0F, totalSliderWidth, 6.0F, mouseX, mouseY));
/*     */         
/* 240 */         if (type == GuiEvents.RELEASE) {
/* 241 */           this.draggingNumber = null;
/*     */         }
/* 243 */         hoverAnimation.setDirection((hoveringSlider || this.draggingNumber == numberSetting) ? Direction.FORWARDS : Direction.BACKWARDS);
/* 244 */         selectAnimtion.setDirection((this.draggingNumber == numberSetting) ? Direction.FORWARDS : Direction.BACKWARDS);
/* 245 */         if (type == GuiEvents.CLICK && hoveringSlider && button == 0) {
/* 246 */           this.draggingNumber = (Value)numberSetting;
/*     */         }
/*     */ 
/*     */         
/* 250 */         double currentValue = ((Integer)numberSetting.getValue()).intValue();
/*     */ 
/*     */         
/* 253 */         if (this.draggingNumber != null && this.draggingNumber == setting) {
/* 254 */           float percent = Math.min(1.0F, Math.max(0.0F, (mouseX - this.x + 5.0F) / totalSliderWidth));
/*     */           
/* 256 */           double newValue = (percent * (numberSetting.getMaximum() - numberSetting.getMinimum()) + numberSetting.getMinimum());
/* 257 */           numberSetting.set(Double.valueOf(newValue));
/*     */         } 
/*     */ 
/*     */         
/* 261 */         float sliderMath = (float)((currentValue - numberSetting.getMinimum()) / (numberSetting.getMaximum() - numberSetting.getMinimum()));
/*     */ 
/*     */         
/* 264 */         this.sliderintMap.put(numberSetting, Float.valueOf((float)DrRenderUtils.animate((totalSliderWidth * sliderMath), ((Float)this.sliderintMap.get(numberSetting)).floatValue(), 0.1D)));
/*     */ 
/*     */         
/* 267 */         float sliderY = settingY + 18.0F;
/* 268 */         RoundedUtil.drawRound(this.x + 5.0F, sliderY, totalSliderWidth, 3.0F, 1.5F, LiYingUtil.applyOpacity(darkRectHover, (float)(0.4000000059604645D + 0.2D * hoverAnimation.getOutput())));
/* 269 */         RoundedUtil.drawRound(this.x + 5.0F, sliderY, Math.max(4.0F, ((Float)this.sliderintMap.get(numberSetting)).floatValue()), 3.0F, 1.5F, accent ? accentedColor2 : textColor);
/*     */         
/* 271 */         LiYingUtil.setAlphaLimit(0.0F);
/* 272 */         LiYingUtil.fakeCircleGlow(this.x + 4.0F + Math.max(4.0F, ((Float)this.sliderintMap.get(numberSetting)).floatValue()), sliderY + 1.5F, 6.0F, Color.BLACK, 0.3F);
/*     */ 
/*     */         
/* 275 */         LiYingUtil.drawGoodCircle((this.x + 4.0F + Math.max(4.0F, ((Float)this.sliderintMap.get(numberSetting)).floatValue())), (sliderY + 1.5F), 3.75F, accent ? accentedColor2.getRGB() : textColor.getRGB());
/* 276 */         count += 0.5D;
/*     */       } 
/* 278 */       if (setting instanceof BoolValue) {
/* 279 */         BoolValue booleanSetting = (BoolValue)setting;
/*     */         
/* 281 */         Animation toggleAnimation = ((Animation[])this.toggleAnimation.get(booleanSetting))[0];
/* 282 */         Animation hoverAnimation = ((Animation[])this.toggleAnimation.get(booleanSetting))[1];
/*     */         
/* 284 */         DrRenderUtils.resetColor();
/* 285 */         OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 286 */         GlStateManager.func_179147_l();
/*     */         
/* 288 */         Fonts.SF.SF_18.SF_18.drawString(booleanSetting.getName(), (int)MathUtils.roundToHalf((this.x + 4.0F)), settingY + 5.0F, textColor
/* 289 */             .getRGB());
/*     */         
/* 291 */         float switchWidth = 16.0F;
/*     */ 
/*     */         
/* 294 */         boolean hoveringSwitch = (isClickable(settingY + Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) - 1.0F) && DrRenderUtils.isHovering(this.x + this.width - switchWidth + 6.0F, settingY + Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) - 1.0F, switchWidth, 8.0F, mouseX, mouseY));
/*     */ 
/*     */         
/* 297 */         hoverAnimation.setDirection(hoveringSwitch ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */         
/* 299 */         if (type == GuiEvents.CLICK && hoveringSwitch && button == 0) {
/* 300 */           booleanSetting.set(Boolean.valueOf(!((Boolean)booleanSetting.get()).booleanValue()));
/*     */         }
/*     */         
/* 303 */         toggleAnimation.setDirection(((Boolean)booleanSetting.get()).booleanValue() ? Direction.FORWARDS : Direction.BACKWARDS);
/* 304 */         DrRenderUtils.resetColor();
/* 305 */         Color accentCircle = accent ? DrRenderUtils.applyOpacity(accentedColor, 0.8F) : DrRenderUtils.darker(textColor, 0.8F);
/* 306 */         RoundedUtil.drawRound(this.x + this.width - switchWidth + 5.5F, settingY + Fonts.SF.SF_18.SF_18.getMiddleOfBox(this.rectHeight) + 2.0F, switchWidth, 4.5F, 2.0F, 
/* 307 */             DrRenderUtils.interpolateColorC(DrRenderUtils.applyOpacity(darkRectHover, 0.5F), accentCircle, (float)toggleAnimation.getOutput()));
/*     */         
/* 309 */         DrRenderUtils.fakeCircleGlow((float)((this.x + this.width - switchWidth + 3.0F) + (switchWidth - 5.0F) * toggleAnimation.getOutput()), settingY + Fonts.SF.SF_18.SF_18
/* 310 */             .getMiddleOfBox(this.rectHeight) + 4.0F, 6.0F, Color.BLACK, 0.3F);
/*     */         
/* 312 */         DrRenderUtils.resetColor();
/*     */         
/* 314 */         RoundedUtil.drawRound((float)((this.x + this.width - switchWidth + 6.0F) + (switchWidth - 5.0F) * toggleAnimation.getOutput()), settingY + Fonts.SF.SF_18.SF_18
/* 315 */             .getMiddleOfBox(this.rectHeight) + 1.0F, 6.5F, 6.5F, 3.0F, textColor);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 320 */       if (setting instanceof ListValue) {
/* 321 */         ListValue modeSetting = (ListValue)setting;
/* 322 */         Animation hoverAnimation = ((Animation[])this.modeSettingAnimMap.get(modeSetting))[0];
/* 323 */         Animation openAnimation = ((Animation[])this.modeSettingAnimMap.get(modeSetting))[1];
/*     */ 
/*     */         
/* 326 */         boolean hoveringModeSettingRect = (isClickable(settingY + 5.0F) && DrRenderUtils.isHovering(this.x + 5.0F, settingY + 5.0F, this.width - 10.0F, this.rectHeight + 7.0F, mouseX, mouseY));
/*     */         
/* 328 */         if (type == GuiEvents.CLICK && hoveringModeSettingRect && button == 1) {
/* 329 */           this.modeSettingClick.put(modeSetting, Boolean.valueOf(!((Boolean)this.modeSettingClick.get(modeSetting)).booleanValue()));
/*     */         }
/*     */         
/* 332 */         hoverAnimation.setDirection(hoveringModeSettingRect ? Direction.FORWARDS : Direction.BACKWARDS);
/* 333 */         openAnimation.setDirection(((Boolean)this.modeSettingClick.get(modeSetting)).booleanValue() ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */         
/* 335 */         float math = ((modeSetting.getValues()).length - 1) * this.rectHeight;
/* 336 */         RoundedUtil.drawRound(this.x + 5.0F, (float)((settingY + this.rectHeight + 2.0F) + 12.0D * openAnimation.getOutput()), this.width - 10.0F, 
/* 337 */             (float)(math * openAnimation.getOutput()), 3.0F, DrRenderUtils.applyOpacity(darkRectHover, (float)(0.3499999940395355D * openAnimation.getOutput())));
/*     */         
/* 339 */         if (!openAnimation.isDone() && type == GuiEvents.DRAW) {
/* 340 */           GL11.glEnable(3089);
/* 341 */           DrRenderUtils.scissor((this.x + 5.0F), (float)((settingY + 7.0F + this.rectHeight) + 3.0D * openAnimation.getOutput()), (this.width - 10.0F), 
/* 342 */               (float)(math * openAnimation.getOutput()));
/*     */         } 
/* 344 */         float modeCount = 0.0F;
/* 345 */         for (String mode : modeSetting.getValues()) {
/* 346 */           if (!mode.equalsIgnoreCase((String)modeSetting.get())) {
/* 347 */             float modeY = (float)((settingY + this.rectHeight + 11.0F) + (8.0F + modeCount * this.rectHeight) * openAnimation.getOutput());
/* 348 */             DrRenderUtils.resetColor();
/*     */ 
/*     */ 
/*     */             
/* 352 */             boolean hoveringMode = (isClickable(modeY - 5.0F) && openAnimation.getDirection().equals(Direction.FORWARDS) && DrRenderUtils.isHovering(this.x + 5.0F, modeY - 5.0F, this.width - 10.0F, this.rectHeight, mouseX, mouseY));
/* 353 */             Animation modeHoverAnimation = (Animation)((HashMap)this.modesHoverAnimation.get(modeSetting)).get(mode);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 358 */             modeHoverAnimation.setDirection(hoveringMode ? Direction.FORWARDS : Direction.BACKWARDS);
/*     */ 
/*     */             
/* 361 */             if (modeHoverAnimation.finished(Direction.FORWARDS) || !modeHoverAnimation.isDone()) {
/* 362 */               RoundedUtil.drawRound(this.x + 5.0F, modeY - 5.0F, this.width - 10.0F, this.rectHeight, 3.0F, 
/* 363 */                   DrRenderUtils.applyOpacity(textColor, (float)(0.20000000298023224D * modeHoverAnimation.getOutput())));
/*     */             }
/* 365 */             if (type == GuiEvents.CLICK && button == 0 && hoveringMode) {
/* 366 */               this.modeSettingClick.put(modeSetting, Boolean.valueOf(!((Boolean)this.modeSettingClick.get(modeSetting)).booleanValue()));
/* 367 */               modeSetting.set(mode);
/*     */             } 
/* 369 */             if ((openAnimation.isDone() && openAnimation.getDirection().equals(Direction.FORWARDS)) || !openAnimation.isDone())
/*     */             {
/*     */               
/* 372 */               Fonts.SF.SF_18.SF_18.drawString(mode, this.x + 13.0F, modeY, DrRenderUtils.applyOpacity(textColor, (float)openAnimation.getOutput()).getRGB());
/*     */             }
/*     */             
/* 375 */             modeCount++;
/*     */           } 
/* 377 */         }  if (!openAnimation.isDone() && type == GuiEvents.DRAW) {
/* 378 */           GL11.glDisable(3089);
/*     */         }
/* 380 */         if (this.settingHeightScissor.isDone() && openAnimation.isDone() && GL11.glIsEnabled(3089)) {
/* 381 */           GL11.glDisable(3089);
/*     */         }
/*     */         
/* 384 */         RoundedUtil.drawRound(this.x + 5.0F, settingY + 5.0F, this.width - 10.0F, this.rectHeight + 7.0F, 3.0F, DrRenderUtils.applyOpacity(darkRectHover, 0.45F));
/*     */         
/* 386 */         if (!hoverAnimation.isDone() || hoverAnimation.finished(Direction.FORWARDS)) {
/* 387 */           RoundedUtil.drawRound(this.x + 5.0F, settingY + 5.0F, this.width - 10.0F, this.rectHeight + 7.0F, 3.0F, DrRenderUtils.applyOpacity(textColor, (float)(0.20000000298023224D * hoverAnimation.getOutput())));
/*     */         }
/*     */ 
/*     */         
/* 391 */         float selectRectWidth = (float)((this.width - 10.0F) * openAnimation.getOutput());
/*     */         
/* 393 */         if ((openAnimation.isDone() && openAnimation.getDirection().equals(Direction.FORWARDS)) || !openAnimation.isDone()) {
/* 394 */           RoundedUtil.drawRound(this.x + 5.0F + (this.width - 10.0F) / 2.0F - selectRectWidth / 2.0F, settingY + this.rectHeight + 10.5F, 
/* 395 */               Math.max(2.0F, selectRectWidth), 1.5F, 0.5F, accent ? accentedColor2 : textColor);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 400 */         Fonts.SF.SF_14.SF_14.drawString(modeSetting.getName(), this.x + 13.0F, settingY + 9.0F, textColor.getRGB());
/*     */         
/* 402 */         DrRenderUtils.resetColor();
/*     */         
/* 404 */         Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString((CharSequence)modeSetting.get(), this.x + 13.0F, (float)(settingY + 17.5D), textColor.getRGB());
/*     */         
/* 406 */         DrRenderUtils.resetColor();
/* 407 */         DrRenderUtils.drawClickGuiArrow(this.x + this.width - 15.0F, settingY + 17.0F, 5.0F, openAnimation, textColor.getRGB());
/*     */ 
/*     */         
/* 410 */         count += 1.0D + (math / this.rectHeight) * openAnimation.getOutput();
/*     */       } 
/*     */       
/* 413 */       if (setting instanceof TextValue) {
/* 414 */         TextValue stringSetting = (TextValue)setting;
/*     */         
/* 416 */         DrRenderUtils.resetColor();
/* 417 */         Fonts.SF.SF_16.SF_16.drawString(stringSetting.getName(), this.x + 5.0F, settingY + 2.0F, textColor.getRGB());
/*     */         
/* 419 */         PasswordField stringSettingField = new PasswordField("Type Here...", 0, (int)(this.x + 5.0F), (int)(settingY + 15.0F), (int)(this.width - 10.0F), 10, Fonts.SF.SF_18.SF_18);
/*     */ 
/*     */         
/* 422 */         stringSettingField.setText((String)stringSetting.get());
/* 423 */         stringSettingField.setFocused((this.selectedStringSetting == stringSetting));
/* 424 */         stringSettingField.bottomBarColor = textColor.getRGB();
/* 425 */         stringSettingField.textColor = textColor.getRGB();
/* 426 */         stringSettingField.placeHolderTextX = (this.x + 30.0F);
/* 427 */         if (type == GuiEvents.CLICK) stringSettingField.mouseClicked(mouseX, mouseY, button); 
/* 428 */         if (stringSettingField.isFocused()) {
/* 429 */           this.selectedField = stringSettingField;
/* 430 */           this.selectedStringSetting = stringSetting;
/*     */         }
/* 432 */         else if (this.selectedStringSetting == stringSetting) {
/* 433 */           this.selectedStringSetting = null;
/* 434 */           this.selectedField = null;
/*     */         } 
/*     */         
/* 437 */         stringSettingField.drawTextBox();
/*     */         
/* 439 */         stringSetting.set(stringSettingField.getText());
/*     */         
/* 441 */         count++;
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 481 */       count++;
/*     */     } 
/* 483 */     this.settingSize = count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY) {
/* 490 */     handle(mouseX, mouseY, -1, GuiEvents.DRAW);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int button) {
/* 495 */     handle(mouseX, mouseY, button, GuiEvents.CLICK);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 500 */     handle(mouseX, mouseY, state, GuiEvents.RELEASE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isClickable(float y) {
/* 505 */     return (y > this.panelLimitY && y < this.panelLimitY + 17.0F + Main.allowedClickGuiHeight);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdown\impl\SettingComponents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */