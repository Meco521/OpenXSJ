/*     */ package net.ccbluex.liquidbounce.ui.client.clickgui.style.styles;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
/*     */ import net.ccbluex.liquidbounce.ui.font.AWTFontRenderer;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.FontValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.input.Mouse;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class LiquidBounceStyle
/*     */   extends Style
/*     */ {
/*     */   private boolean mouseDown;
/*     */   private boolean rightMouseDown;
/*     */   
/*     */   public void drawPanel(int mouseX, int mouseY, Panel panel) {
/*  41 */     RenderUtils.drawBorderedRect(panel.getX(), panel.getY() - 3.0F, panel.getX() + panel.getWidth(), panel.getY() + 17.0F, 3.0F, (new Color(97, 95, 95, 34)).getRGB(), (new Color(20, 20, 20, 174)).getRGB());
/*     */     
/*  43 */     float textWidth = Fonts.font35.getStringWidth("§f" + StringUtils.func_76338_a(panel.getName()));
/*  44 */     Fonts.font35.drawString("§f" + panel.getName(), (int)(panel.getX() - (textWidth - 100.0F) / 2.0F), panel.getY() + 7, -16777216);
/*     */     
/*  46 */     if (panel.getScrollbar() && panel.getFade() > 0) {
/*  47 */       RenderUtils.drawRect((panel.getX() - 2), (panel.getY() + 21), panel.getX(), (panel.getY() + 16 + panel.getFade()), 2147483647);
/*  48 */       RenderUtils.drawRect((panel.getX() - 2), (panel.getY() + 30) + (panel.getFade() - 24.0F) / (panel.getElements().size() - ((Integer)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).maxElementsValue.get()).intValue()) * panel.getDragged() - 10.0F, panel.getX(), (panel.getY() + 40) + (panel.getFade() - 24.0F) / (panel.getElements().size() - ((Integer)((ClickGUI)Objects.requireNonNull((T)Retreat.moduleManager.getModule(ClickGUI.class))).maxElementsValue.get()).intValue()) * panel.getDragged(), -2147483648);
/*     */ 
/*     */       
/*  51 */       RenderUtils.drawBorderedRect(panel.getX(), panel.getY() + 17.0F, panel.getX() + panel.getWidth(), (panel.getY() + 19 + panel.getFade()), 3.0F, (new Color(33, 33, 33, 65)).getRGB(), (new Color(29, 29, 29, 86)).getRGB());
/*  52 */       RenderUtils.drawBorderedRect(panel.getX(), (panel.getY() + 17 + panel.getFade()), panel.getX() + panel.getWidth(), (panel.getY() + 19 + panel.getFade() + 5), 3.0F, (new Color(47, 46, 46, 0)).getRGB(), (new Color(20, 20, 20, 0)).getRGB());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawDescription(int mouseX, int mouseY, String text) {
/*  58 */     int textWidth = Fonts.font35.getStringWidth(text);
/*     */ 
/*     */     
/*  61 */     RenderUtils.drawBorderedRect((mouseX + 9), mouseY, (mouseX + textWidth + 14), (mouseY + Fonts.font35.getFontHeight() + 3), 1.0F, (new Color(255, 255, 255, 89)).getRGB(), -2147483648);
/*  62 */     GlStateManager.func_179117_G();
/*  63 */     Fonts.font35.drawString(text, mouseX + 12, mouseY + Fonts.font35.getFontHeight() / 2, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawButtonElement(int mouseX, int mouseY, ButtonElement buttonElement) {
/*  68 */     GlStateManager.func_179117_G();
/*  69 */     Fonts.font35.drawString(buttonElement.getDisplayName(), (int)(buttonElement.getX() - (Fonts.font35.getStringWidth(buttonElement.getDisplayName()) - 100.0F) / 2.0F), buttonElement.getY() + 6, buttonElement.getColor());
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawModuleElement(int mouseX, int mouseY, ModuleElement moduleElement) {
/*  74 */     int guiColor = ClickGUI.generateColor().getRGB();
/*  75 */     GlStateManager.func_179117_G();
/*  76 */     Fonts.font35.drawString(moduleElement.getDisplayName(), (int)(moduleElement.getX() - (Fonts.font35.getStringWidth(moduleElement.getDisplayName()) - 100.0F) / 2.0F), moduleElement.getY() + 6, moduleElement.getModule().getState() ? guiColor : Integer.MAX_VALUE);
/*     */     
/*  78 */     List<Value<?>> moduleValues = moduleElement.getModule().getValues();
/*     */     
/*  80 */     if (!moduleValues.isEmpty()) {
/*  81 */       Fonts.font35.drawString("+", moduleElement.getX() + moduleElement.getWidth() - 8, moduleElement.getY() + moduleElement.getHeight() / 2, Color.WHITE.getRGB());
/*     */       
/*  83 */       if (moduleElement.isShowSettings()) {
/*  84 */         int yPos = moduleElement.getY() + 4;
/*  85 */         for (Value<?> value : moduleValues) {
/*  86 */           boolean isNumber = value.get() instanceof Number;
/*     */           
/*  88 */           if (isNumber) {
/*  89 */             AWTFontRenderer.Companion.setAssumeNonVolatile(false);
/*     */           }
/*     */           
/*  92 */           if (value instanceof BoolValue) {
/*  93 */             String text = value.getName();
/*  94 */             float textWidth = Fonts.font35.getStringWidth(text);
/*     */             
/*  96 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/*  97 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/*     */             
/* 100 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */             
/* 102 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 103 */               Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 104 */               BoolValue boolValue = (BoolValue)value;
/*     */               
/* 106 */               boolValue.set(Boolean.valueOf(!((Boolean)boolValue.get()).booleanValue()));
/* 107 */               mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */             } 
/*     */ 
/*     */             
/* 111 */             GlStateManager.func_179117_G();
/* 112 */             Fonts.font35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, ((Boolean)((BoolValue)value).get()).booleanValue() ? guiColor : Integer.MAX_VALUE);
/* 113 */             yPos += 12;
/* 114 */           } else if (value instanceof ListValue) {
/* 115 */             ListValue listValue = (ListValue)value;
/*     */             
/* 117 */             String text = value.getName();
/* 118 */             float textWidth = Fonts.font35.getStringWidth(text);
/*     */             
/* 120 */             if (moduleElement.getSettingsWidth() < textWidth + 16.0F) {
/* 121 */               moduleElement.setSettingsWidth(textWidth + 16.0F);
/*     */             }
/*     */             
/* 124 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */             
/* 126 */             GlStateManager.func_179117_G();
/* 127 */             Fonts.font35.drawString("§c" + text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 128 */             Fonts.font35.drawString(listValue.openList ? "-" : "+", (int)((moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - (listValue.openList ? 5 : 6)), yPos + 4, 16777215);
/*     */             
/* 130 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 131 */               Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 132 */               listValue.openList = !listValue.openList;
/* 133 */               mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */             } 
/*     */ 
/*     */             
/* 137 */             yPos += 12;
/*     */             
/* 139 */             for (String valueOfList : listValue.getValues()) {
/* 140 */               float textWidth2 = Fonts.font35.getStringWidth(">" + valueOfList);
/*     */               
/* 142 */               if (moduleElement.getSettingsWidth() < textWidth2 + 8.0F) {
/* 143 */                 moduleElement.setSettingsWidth(textWidth2 + 8.0F);
/*     */               }
/* 145 */               if (listValue.openList) {
/*     */                 
/* 147 */                 RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */                 
/* 149 */                 if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 150 */                   Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 151 */                   listValue.set(valueOfList);
/* 152 */                   mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                 } 
/*     */ 
/*     */                 
/* 156 */                 GlStateManager.func_179117_G();
/* 157 */                 Fonts.font35.drawString(">", moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 2147483647);
/* 158 */                 Fonts.font35.drawString(valueOfList, moduleElement.getX() + moduleElement.getWidth() + 14, yPos + 4, (listValue.get() != null && ((String)listValue.get()).equalsIgnoreCase(valueOfList)) ? guiColor : Integer.MAX_VALUE);
/* 159 */                 yPos += 12;
/*     */               } 
/*     */             } 
/* 162 */           } else if (value instanceof FloatValue) {
/* 163 */             FloatValue floatValue = (FloatValue)value;
/* 164 */             String text = value.getName() + "§f: §c" + round(((Float)floatValue.get()).floatValue());
/* 165 */             float textWidth = Fonts.font35.getStringWidth(text);
/*     */             
/* 167 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 168 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/*     */ 
/*     */             
/* 172 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 24), -2147483648);
/* 173 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 8), (yPos + 18), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F, (yPos + 19), 2147483647);
/*     */             
/* 175 */             float sliderValue = (moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.getSettingsWidth() - 12.0F) * (((Float)floatValue.get()).floatValue() - floatValue.getMinimum()) / (floatValue.getMaximum() - floatValue.getMinimum());
/*     */             
/* 177 */             RenderUtils.drawRect(8.0F + sliderValue, (yPos + 15), sliderValue + 11.0F, (yPos + 21), guiColor);
/*     */             
/* 179 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F && mouseY >= yPos + 15 && mouseY <= yPos + 21 && 
/* 180 */               Mouse.isButtonDown(0)) {
/* 181 */               double i = WMathHelper.clamp_double(((mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement.getSettingsWidth() - 12.0F)), 0.0D, 1.0D);
/* 182 */               floatValue.set(Float.valueOf(round((float)(floatValue.getMinimum() + (floatValue.getMaximum() - floatValue.getMinimum()) * i)).floatValue()));
/*     */             } 
/*     */ 
/*     */             
/* 186 */             GlStateManager.func_179117_G();
/* 187 */             Fonts.font35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 188 */             yPos += 22;
/* 189 */           } else if (value instanceof IntegerValue) {
/* 190 */             IntegerValue integerValue = (IntegerValue)value;
/* 191 */             String text = value.getName() + "§f: §c" + ((value instanceof net.ccbluex.liquidbounce.value.BlockValue) ? (BlockUtils.getBlockName(((Integer)integerValue.get()).intValue()) + " (" + integerValue.get() + ")") : (String)integerValue.get());
/* 192 */             float textWidth = Fonts.font35.getStringWidth(text);
/*     */             
/* 194 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 195 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/*     */ 
/*     */             
/* 199 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 24), -2147483648);
/* 200 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 8), (yPos + 18), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F, (yPos + 19), 2147483647);
/*     */             
/* 202 */             float sliderValue = (moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.getSettingsWidth() - 12.0F) * (((Integer)integerValue.get()).intValue() - integerValue.getMinimum()) / (integerValue.getMaximum() - integerValue.getMinimum());
/*     */             
/* 204 */             RenderUtils.drawRect(8.0F + sliderValue, (yPos + 15), sliderValue + 11.0F, (yPos + 21), guiColor);
/*     */             
/* 206 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 15 && mouseY <= yPos + 21 && 
/* 207 */               Mouse.isButtonDown(0)) {
/* 208 */               double i = WMathHelper.clamp_double(((mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement.getSettingsWidth() - 12.0F)), 0.0D, 1.0D);
/* 209 */               integerValue.set(Integer.valueOf((int)(integerValue.getMinimum() + (integerValue.getMaximum() - integerValue.getMinimum()) * i)));
/*     */             } 
/*     */ 
/*     */             
/* 213 */             GlStateManager.func_179117_G();
/* 214 */             Fonts.font35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 215 */             yPos += 22;
/* 216 */           } else if (value instanceof FontValue) {
/* 217 */             FontValue fontValue = (FontValue)value;
/* 218 */             IFontRenderer fontRenderer = (IFontRenderer)fontValue.get();
/*     */ 
/*     */             
/* 221 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */ 
/*     */             
/* 224 */             String displayString = "Font: Unknown";
/*     */             
/* 226 */             if (fontRenderer.isGameFontRenderer()) {
/* 227 */               GameFontRenderer liquidFontRenderer = fontRenderer.getGameFontRenderer();
/*     */               
/* 229 */               displayString = "Font: " + liquidFontRenderer.getDefaultFont().getFont().getName() + " - " + liquidFontRenderer.getDefaultFont().getFont().getSize();
/* 230 */             } else if (fontRenderer == Fonts.minecraftFont) {
/* 231 */               displayString = "Font: Minecraft";
/*     */             } else {
/* 233 */               Fonts.FontInfo fontInfo = Fonts.getFontDetails(fontRenderer);
/*     */               
/* 235 */               if (fontInfo != null) {
/* 236 */                 displayString = fontInfo.getName() + ((fontInfo.getFontSize() != -1) ? (" - " + fontInfo.getFontSize()) : "");
/*     */               }
/*     */             } 
/*     */             
/* 240 */             Fonts.font35.drawString(displayString, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, Color.WHITE.getRGB());
/* 241 */             int stringWidth = Fonts.font35.getStringWidth(displayString);
/*     */             
/* 243 */             if (moduleElement.getSettingsWidth() < (stringWidth + 8)) {
/* 244 */               moduleElement.setSettingsWidth((stringWidth + 8));
/*     */             }
/* 246 */             if (((Mouse.isButtonDown(0) && !this.mouseDown) || (Mouse.isButtonDown(1) && !this.rightMouseDown)) && mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 4 && mouseY <= yPos + 12) {
/* 247 */               List<IFontRenderer> fonts = Fonts.getFonts();
/*     */               
/* 249 */               if (Mouse.isButtonDown(0)) {
/* 250 */                 for (int i = 0; i < fonts.size(); i++) {
/* 251 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 253 */                   if (font.equals(fontRenderer)) {
/* 254 */                     i++;
/*     */                     
/* 256 */                     if (i >= fonts.size()) {
/* 257 */                       i = 0;
/*     */                     }
/* 259 */                     fontValue.set(fonts.get(i));
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 264 */                 for (int i = fonts.size() - 1; i >= 0; i--) {
/* 265 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 267 */                   if (font.equals(fontRenderer)) {
/* 268 */                     i--;
/*     */                     
/* 270 */                     if (i >= fonts.size()) {
/* 271 */                       i = 0;
/*     */                     }
/* 273 */                     if (i < 0) {
/* 274 */                       i = fonts.size() - 1;
/*     */                     }
/* 276 */                     fontValue.set(fonts.get(i));
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/* 283 */             yPos += 11;
/*     */           } else {
/* 285 */             String text = value.getName() + "§f: §c" + value.get();
/* 286 */             float textWidth = Fonts.font35.getStringWidth(text);
/*     */             
/* 288 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 289 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/*     */             
/* 292 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */             
/* 294 */             GlStateManager.func_179117_G();
/* 295 */             Fonts.font35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 296 */             yPos += 12;
/*     */           } 
/*     */           
/* 299 */           if (isNumber) {
/* 300 */             AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */           }
/*     */         } 
/*     */         
/* 304 */         moduleElement.updatePressed();
/* 305 */         this.mouseDown = Mouse.isButtonDown(0);
/* 306 */         this.rightMouseDown = Mouse.isButtonDown(1);
/*     */         
/* 308 */         if (moduleElement.getSettingsWidth() > 0.0F && yPos > moduleElement.getY() + 4)
/*     */         {
/* 310 */           RenderUtils.drawBorderedRect((moduleElement.getX() + moduleElement.getWidth() + 4), (moduleElement.getY() + 6), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 2), 1.0F, -2147483648, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private BigDecimal round(float f) {
/* 317 */     BigDecimal bd = new BigDecimal(Float.toString(f));
/* 318 */     bd = bd.setScale(2, 4);
/* 319 */     return bd;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\style\styles\LiquidBounceStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */