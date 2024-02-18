/*     */ package net.ccbluex.liquidbounce.ui.client.clickgui.style.styles;
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
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
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.input.Mouse;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SlowlyStyle extends Style {
/*     */   private boolean mouseDown;
/*     */   
/*     */   public static float drawSlider(float value, float min, float max, int x, int y, int width, int mouseX, int mouseY, Color color) {
/*  33 */     float displayValue = Math.max(min, Math.min(value, max));
/*     */     
/*  35 */     float sliderValue = x + width * (displayValue - min) / (max - min);
/*     */     
/*  37 */     RenderUtils.drawRect(x, y, x + width, y + 2, 2147483647);
/*  38 */     RenderUtils.drawRect(x, y, sliderValue, (y + 2), color);
/*  39 */     RenderUtils.drawFilledCircle((int)sliderValue, y + 1, 3.0F, color);
/*     */     
/*  41 */     if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 3 && Mouse.isButtonDown(0)) {
/*  42 */       double i = WMathHelper.clamp_double((mouseX - x) / (width - 3.0D), 0.0D, 1.0D);
/*     */       
/*  44 */       BigDecimal bigDecimal = new BigDecimal(Double.toString(min + (max - min) * i));
/*  45 */       bigDecimal = bigDecimal.setScale(2, 4);
/*  46 */       return bigDecimal.floatValue();
/*     */     } 
/*     */     
/*  49 */     return value;
/*     */   }
/*     */   private boolean rightMouseDown;
/*     */   
/*     */   public void drawPanel(int mouseX, int mouseY, Panel panel) {
/*  54 */     RenderUtils.drawBorderedRect(panel.getX(), panel.getY() - 3.0F, panel.getX() + panel.getWidth(), panel.getY() + 17.0F, 3.0F, (new Color(42, 57, 79)).getRGB(), (new Color(42, 57, 79)).getRGB());
/*  55 */     if (panel.getFade() > 0) {
/*  56 */       RenderUtils.drawBorderedRect(panel.getX(), panel.getY() + 17.0F, panel.getX() + panel.getWidth(), (panel.getY() + 19 + panel.getFade()), 3.0F, (new Color(54, 71, 96)).getRGB(), (new Color(54, 71, 96)).getRGB());
/*  57 */       RenderUtils.drawBorderedRect(panel.getX(), (panel.getY() + 17 + panel.getFade()), panel.getX() + panel.getWidth(), (panel.getY() + 19 + panel.getFade() + 5), 3.0F, (new Color(42, 57, 79)).getRGB(), (new Color(42, 57, 79)).getRGB());
/*     */     } 
/*  59 */     GlStateManager.func_179117_G();
/*  60 */     float textWidth = Fonts.roboto35.getStringWidth("§f" + StringUtils.func_76338_a(panel.getName()));
/*  61 */     Fonts.roboto35.drawString(panel.getName(), (int)(panel.getX() - (textWidth - 100.0F) / 2.0F), panel.getY() + 7 - 3, Color.WHITE.getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawDescription(int mouseX, int mouseY, String text) {
/*  66 */     int textWidth = Fonts.roboto35.getStringWidth(text);
/*     */     
/*  68 */     RenderUtils.drawBorderedRect((mouseX + 9), mouseY, (mouseX + textWidth + 14), (mouseY + Fonts.roboto35.getFontHeight() + 3), 3.0F, (new Color(42, 57, 79)).getRGB(), (new Color(42, 57, 79)).getRGB());
/*  69 */     GlStateManager.func_179117_G();
/*  70 */     Fonts.roboto35.drawString(text, mouseX + 12, mouseY + Fonts.roboto35.getFontHeight() / 2, Color.WHITE.getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawButtonElement(int mouseX, int mouseY, ButtonElement buttonElement) {
/*  75 */     Gui.func_73734_a(buttonElement.getX() - 1, buttonElement.getY() - 1, buttonElement.getX() + buttonElement.getWidth() + 1, buttonElement.getY() + buttonElement.getHeight() + 1, hoverColor((buttonElement.getColor() != Integer.MAX_VALUE) ? new Color(7, 152, 252) : new Color(54, 71, 96), buttonElement.hoverTime).getRGB());
/*     */     
/*  77 */     GlStateManager.func_179117_G();
/*     */     
/*  79 */     Fonts.roboto35.drawString(buttonElement.getDisplayName(), buttonElement.getX() + 5, buttonElement.getY() + 5, Color.WHITE.getRGB());
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
/*     */   public void drawModuleElement(int mouseX, int mouseY, ModuleElement moduleElement) {
/*  94 */     Gui.func_73734_a(moduleElement.getX() - 1, moduleElement.getY() - 1, moduleElement.getX() + moduleElement.getWidth() + 1, moduleElement.getY() + moduleElement.getHeight() + 1, hoverColor(new Color(54, 71, 96), moduleElement.hoverTime).getRGB());
/*  95 */     Gui.func_73734_a(moduleElement.getX() - 1, moduleElement.getY() - 1, moduleElement.getX() + moduleElement.getWidth() + 1, moduleElement.getY() + moduleElement.getHeight() + 1, hoverColor(new Color(7, 152, 252, moduleElement.slowlyFade), moduleElement.hoverTime).getRGB());
/*  96 */     GlStateManager.func_179117_G();
/*  97 */     Fonts.roboto35.drawString(moduleElement.getDisplayName(), moduleElement.getX() + 5, moduleElement.getY() + 5, Color.WHITE.getRGB());
/*     */ 
/*     */     
/* 100 */     List<Value<?>> moduleValues = moduleElement.getModule().getValues();
/*     */     
/* 102 */     if (!moduleValues.isEmpty()) {
/* 103 */       Fonts.roboto35.drawString(">", moduleElement.getX() + moduleElement.getWidth() - 8, moduleElement.getY() + 5, Color.WHITE.getRGB());
/*     */       
/* 105 */       if (moduleElement.isShowSettings()) {
/* 106 */         if (moduleElement.getSettingsWidth() > 0.0F && moduleElement.slowlySettingsYPos > moduleElement.getY() + 6) {
/* 107 */           RenderUtils.drawBorderedRect((moduleElement.getX() + moduleElement.getWidth() + 4), (moduleElement.getY() + 6), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (moduleElement.slowlySettingsYPos + 2), 3.0F, (new Color(54, 71, 96)).getRGB(), (new Color(54, 71, 96)).getRGB());
/*     */         }
/* 109 */         moduleElement.slowlySettingsYPos = moduleElement.getY() + 6;
/* 110 */         for (Value<?> value : moduleValues) {
/* 111 */           boolean isNumber = value.get() instanceof Number;
/*     */           
/* 113 */           if (isNumber) {
/* 114 */             AWTFontRenderer.Companion.setAssumeNonVolatile(false);
/*     */           }
/*     */           
/* 117 */           if (value instanceof BoolValue) {
/* 118 */             String text = value.getName();
/* 119 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 121 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 122 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 124 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= moduleElement.slowlySettingsYPos && mouseY <= moduleElement.slowlySettingsYPos + 12 && Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 125 */               BoolValue boolValue = (BoolValue)value;
/*     */               
/* 127 */               boolValue.set(Boolean.valueOf(!((Boolean)boolValue.get()).booleanValue()));
/* 128 */               mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */             } 
/*     */             
/* 131 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 2, ((Boolean)((BoolValue)value).get()).booleanValue() ? Color.WHITE.getRGB() : Integer.MAX_VALUE);
/* 132 */             moduleElement.slowlySettingsYPos += 11;
/* 133 */           } else if (value instanceof ListValue) {
/* 134 */             ListValue listValue = (ListValue)value;
/*     */             
/* 136 */             String text = value.getName();
/* 137 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 139 */             if (moduleElement.getSettingsWidth() < textWidth + 16.0F) {
/* 140 */               moduleElement.setSettingsWidth(textWidth + 16.0F);
/*     */             }
/* 142 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 2, 16777215);
/* 143 */             Fonts.roboto35.drawString(listValue.openList ? "-" : "+", (int)((moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - (listValue.openList ? 5 : 6)), moduleElement.slowlySettingsYPos + 2, 16777215);
/*     */             
/* 145 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= moduleElement.slowlySettingsYPos && mouseY <= moduleElement.slowlySettingsYPos + Fonts.roboto35.getFontHeight() && Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 146 */               listValue.openList = !listValue.openList;
/* 147 */               mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */             } 
/*     */             
/* 150 */             moduleElement.slowlySettingsYPos += Fonts.roboto35.getFontHeight() + 1;
/*     */             
/* 152 */             for (String valueOfList : listValue.getValues()) {
/* 153 */               float textWidth2 = Fonts.roboto35.getStringWidth("> " + valueOfList);
/*     */               
/* 155 */               if (moduleElement.getSettingsWidth() < textWidth2 + 12.0F) {
/* 156 */                 moduleElement.setSettingsWidth(textWidth2 + 12.0F);
/*     */               }
/* 158 */               if (listValue.openList) {
/* 159 */                 if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= moduleElement.slowlySettingsYPos + 2 && mouseY <= moduleElement.slowlySettingsYPos + 14 && Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 160 */                   listValue.set(valueOfList);
/* 161 */                   mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                 } 
/*     */                 
/* 164 */                 GlStateManager.func_179117_G();
/* 165 */                 Fonts.roboto35.drawString("> " + valueOfList, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 2, (listValue.get() != null && ((String)listValue.get()).equalsIgnoreCase(valueOfList)) ? Color.WHITE.getRGB() : Integer.MAX_VALUE);
/* 166 */                 moduleElement.slowlySettingsYPos += Fonts.roboto35.getFontHeight() + 1;
/*     */               } 
/*     */             } 
/*     */             
/* 170 */             if (!listValue.openList) {
/* 171 */               moduleElement.slowlySettingsYPos++;
/*     */             }
/* 173 */           } else if (value instanceof FloatValue) {
/* 174 */             FloatValue floatValue = (FloatValue)value;
/* 175 */             String text = value.getName() + "§f: " + round(((Float)floatValue.get()).floatValue());
/* 176 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 178 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 179 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 181 */             float valueOfSlide = drawSlider(((Float)floatValue.get()).floatValue(), floatValue.getMinimum(), floatValue.getMaximum(), moduleElement.getX() + moduleElement.getWidth() + 8, moduleElement.slowlySettingsYPos + 14, (int)moduleElement.getSettingsWidth() - 12, mouseX, mouseY, new Color(7, 152, 252));
/*     */             
/* 183 */             if (valueOfSlide != ((Float)floatValue.get()).floatValue()) {
/* 184 */               floatValue.set(Float.valueOf(valueOfSlide));
/*     */             }
/* 186 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 3, 16777215);
/* 187 */             moduleElement.slowlySettingsYPos += 19;
/* 188 */           } else if (value instanceof IntegerValue) {
/* 189 */             IntegerValue integerValue = (IntegerValue)value;
/* 190 */             String text = value.getName() + "§f: " + ((value instanceof net.ccbluex.liquidbounce.value.BlockValue) ? (BlockUtils.getBlockName(((Integer)integerValue.get()).intValue()) + " (" + integerValue.get() + ")") : (String)integerValue.get());
/* 191 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 193 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 194 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 196 */             float valueOfSlide = drawSlider(((Integer)integerValue.get()).intValue(), integerValue.getMinimum(), integerValue.getMaximum(), moduleElement.getX() + moduleElement.getWidth() + 8, moduleElement.slowlySettingsYPos + 14, (int)moduleElement.getSettingsWidth() - 12, mouseX, mouseY, new Color(7, 152, 252));
/*     */             
/* 198 */             if (valueOfSlide != ((Integer)integerValue.get()).intValue()) {
/* 199 */               integerValue.set(Integer.valueOf((int)valueOfSlide));
/*     */             }
/* 201 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 3, 16777215);
/* 202 */             moduleElement.slowlySettingsYPos += 19;
/* 203 */           } else if (value instanceof FontValue) {
/* 204 */             FontValue fontValue = (FontValue)value;
/* 205 */             IFontRenderer fontRenderer = (IFontRenderer)fontValue.get();
/*     */             
/* 207 */             String displayString = "Font: Unknown";
/*     */             
/* 209 */             if (fontRenderer.isGameFontRenderer()) {
/* 210 */               GameFontRenderer liquidFontRenderer = fontRenderer.getGameFontRenderer();
/*     */               
/* 212 */               displayString = "Font: " + liquidFontRenderer.getDefaultFont().getFont().getName() + " - " + liquidFontRenderer.getDefaultFont().getFont().getSize();
/* 213 */             } else if (fontRenderer == Fonts.minecraftFont) {
/* 214 */               displayString = "Font: Minecraft";
/*     */             } else {
/* 216 */               Fonts.FontInfo objects = Fonts.getFontDetails(fontRenderer);
/*     */               
/* 218 */               if (objects != null) {
/* 219 */                 displayString = objects.getName() + ((objects.getFontSize() != -1) ? (" - " + objects.getFontSize()) : "");
/*     */               }
/*     */             } 
/*     */             
/* 223 */             Fonts.roboto35.drawString(displayString, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 2, Color.WHITE.getRGB());
/* 224 */             int stringWidth = Fonts.roboto35.getStringWidth(displayString);
/*     */             
/* 226 */             if (moduleElement.getSettingsWidth() < (stringWidth + 8)) {
/* 227 */               moduleElement.setSettingsWidth((stringWidth + 8));
/*     */             }
/* 229 */             if (((Mouse.isButtonDown(0) && !this.mouseDown) || (Mouse.isButtonDown(1) && !this.rightMouseDown)) && mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= moduleElement.slowlySettingsYPos && mouseY <= moduleElement.slowlySettingsYPos + 12) {
/* 230 */               List<IFontRenderer> fonts = Fonts.getFonts();
/*     */               
/* 232 */               if (Mouse.isButtonDown(0)) {
/* 233 */                 for (int i = 0; i < fonts.size(); i++) {
/* 234 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 236 */                   if (font.equals(fontRenderer)) {
/* 237 */                     i++;
/*     */                     
/* 239 */                     if (i >= fonts.size()) {
/* 240 */                       i = 0;
/*     */                     }
/* 242 */                     fontValue.set(fonts.get(i));
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 247 */                 for (int i = fonts.size() - 1; i >= 0; i--) {
/* 248 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 250 */                   if (font.equals(fontRenderer)) {
/* 251 */                     i--;
/*     */                     
/* 253 */                     if (i >= fonts.size()) {
/* 254 */                       i = 0;
/*     */                     }
/* 256 */                     if (i < 0) {
/* 257 */                       i = fonts.size() - 1;
/*     */                     }
/* 259 */                     fontValue.set(fonts.get(i));
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/* 266 */             moduleElement.slowlySettingsYPos += 11;
/*     */           } else {
/* 268 */             String text = value.getName() + "§f: " + value.get();
/* 269 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 271 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 272 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 274 */             GlStateManager.func_179117_G();
/* 275 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, moduleElement.slowlySettingsYPos + 4, 16777215);
/* 276 */             moduleElement.slowlySettingsYPos += 12;
/*     */           } 
/*     */           
/* 279 */           if (isNumber) {
/* 280 */             AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */           }
/*     */         } 
/*     */         
/* 284 */         moduleElement.updatePressed();
/* 285 */         this.mouseDown = Mouse.isButtonDown(0);
/* 286 */         this.rightMouseDown = Mouse.isButtonDown(1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private BigDecimal round(float v) {
/* 292 */     BigDecimal bigDecimal = new BigDecimal(Float.toString(v));
/* 293 */     bigDecimal = bigDecimal.setScale(2, 4);
/* 294 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   private Color hoverColor(Color color, int hover) {
/* 298 */     int r = color.getRed() - hover * 2;
/* 299 */     int g = color.getGreen() - hover * 2;
/* 300 */     int b = color.getBlue() - hover * 2;
/*     */     
/* 302 */     return new Color(Math.max(r, 0), Math.max(g, 0), Math.max(b, 0), color.getAlpha());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\style\styles\SlowlyStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */