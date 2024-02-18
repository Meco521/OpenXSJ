/*     */ package net.ccbluex.liquidbounce.ui.client.clickgui.style.styles;
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class NullStyle extends Style {
/*     */   private boolean mouseDown;
/*     */   
/*     */   public void drawPanel(int mouseX, int mouseY, Panel panel) {
/*  34 */     RenderUtils.drawRect(panel.getX() - 3.0F, panel.getY(), panel.getX() + panel.getWidth() + 3.0F, panel.getY() + 19.0F, ClickGUI.generateColor().getRGB());
/*  35 */     if (panel.getFade() > 0)
/*  36 */       RenderUtils.drawBorderedRect(panel.getX(), panel.getY() + 19.0F, panel.getX() + panel.getWidth(), (panel.getY() + 19 + panel.getFade()), 1.0F, -2147483648, -2147483648); 
/*  37 */     GlStateManager.func_179117_G();
/*  38 */     float textWidth = Fonts.roboto35.getStringWidth("§f" + StringUtils.func_76338_a(panel.getName()));
/*  39 */     Fonts.roboto35.drawString("§f" + panel.getName(), (int)(panel.getX() - (textWidth - 100.0F) / 2.0F), panel.getY() + 7, 2147483647);
/*     */   }
/*     */   private boolean rightMouseDown;
/*     */   
/*     */   public void drawDescription(int mouseX, int mouseY, String text) {
/*  44 */     int textWidth = Fonts.roboto35.getStringWidth(text);
/*     */     
/*  46 */     RenderUtils.drawRect(mouseX + 9, mouseY, mouseX + textWidth + 14, mouseY + Fonts.roboto35.getFontHeight() + 3, ClickGUI.generateColor().getRGB());
/*  47 */     GlStateManager.func_179117_G();
/*  48 */     Fonts.roboto35.drawString(text, mouseX + 12, mouseY + Fonts.roboto35.getFontHeight() / 2, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawButtonElement(int mouseX, int mouseY, ButtonElement buttonElement) {
/*  53 */     GlStateManager.func_179117_G();
/*  54 */     Fonts.roboto35.drawString(buttonElement.getDisplayName(), (int)(buttonElement.getX() - (Fonts.roboto35.getStringWidth(buttonElement.getDisplayName()) - 100.0F) / 2.0F), buttonElement.getY() + 6, buttonElement.getColor());
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawModuleElement(int mouseX, int mouseY, ModuleElement moduleElement) {
/*  59 */     int guiColor = ClickGUI.generateColor().getRGB();
/*  60 */     GlStateManager.func_179117_G();
/*  61 */     Fonts.roboto35.drawString(moduleElement.getDisplayName(), (int)(moduleElement.getX() - (Fonts.roboto35.getStringWidth(moduleElement.getDisplayName()) - 100.0F) / 2.0F), moduleElement.getY() + 6, moduleElement.getModule().getState() ? guiColor : Integer.MAX_VALUE);
/*     */     
/*  63 */     List<Value<?>> moduleValues = moduleElement.getModule().getValues();
/*     */     
/*  65 */     if (!moduleValues.isEmpty()) {
/*  66 */       Fonts.roboto35.drawString("+", moduleElement.getX() + moduleElement.getWidth() - 8, moduleElement.getY() + moduleElement.getHeight() / 2, Color.WHITE.getRGB());
/*     */       
/*  68 */       if (moduleElement.isShowSettings()) {
/*  69 */         int yPos = moduleElement.getY() + 4;
/*  70 */         for (Value<?> value : moduleValues) {
/*  71 */           boolean isNumber = value.get() instanceof Number;
/*     */           
/*  73 */           if (isNumber) {
/*  74 */             AWTFontRenderer.Companion.setAssumeNonVolatile(false);
/*     */           }
/*     */           
/*  77 */           if (value instanceof BoolValue) {
/*  78 */             String text = value.getName();
/*  79 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/*  81 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/*  82 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/*  84 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */             
/*  86 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/*  87 */               Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/*  88 */               BoolValue boolValue = (BoolValue)value;
/*     */               
/*  90 */               boolValue.set(Boolean.valueOf(!((Boolean)boolValue.get()).booleanValue()));
/*  91 */               mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */             } 
/*     */ 
/*     */             
/*  95 */             GlStateManager.func_179117_G();
/*  96 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, ((Boolean)((BoolValue)value).get()).booleanValue() ? guiColor : Integer.MAX_VALUE);
/*  97 */             yPos += 12;
/*  98 */           } else if (value instanceof ListValue) {
/*  99 */             ListValue listValue = (ListValue)value;
/*     */             
/* 101 */             String text = value.getName();
/* 102 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 104 */             if (moduleElement.getSettingsWidth() < textWidth + 16.0F) {
/* 105 */               moduleElement.setSettingsWidth(textWidth + 16.0F);
/*     */             }
/* 107 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/* 108 */             GlStateManager.func_179117_G();
/* 109 */             Fonts.roboto35.drawString("§c" + text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 110 */             Fonts.roboto35.drawString(listValue.openList ? "-" : "+", (int)((moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - (listValue.openList ? 5 : 6)), yPos + 4, 16777215);
/*     */             
/* 112 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 113 */               Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 114 */               listValue.openList = !listValue.openList;
/* 115 */               mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */             } 
/*     */ 
/*     */             
/* 119 */             yPos += 12;
/*     */             
/* 121 */             for (String valueOfList : listValue.getValues()) {
/* 122 */               float textWidth2 = Fonts.roboto35.getStringWidth(">" + valueOfList);
/*     */               
/* 124 */               if (moduleElement.getSettingsWidth() < textWidth2 + 12.0F) {
/* 125 */                 moduleElement.setSettingsWidth(textWidth2 + 12.0F);
/*     */               }
/* 127 */               if (listValue.openList) {
/* 128 */                 RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */                 
/* 130 */                 if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 131 */                   Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 132 */                   listValue.set(valueOfList);
/* 133 */                   mc.getSoundHandler().playSound("gui.button.press", 1.0F);
/*     */                 } 
/*     */ 
/*     */                 
/* 137 */                 GlStateManager.func_179117_G();
/* 138 */                 Fonts.roboto35.drawString(">", moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 2147483647);
/* 139 */                 Fonts.roboto35.drawString(valueOfList, moduleElement.getX() + moduleElement.getWidth() + 14, yPos + 4, (listValue.get() != null && ((String)listValue.get()).equalsIgnoreCase(valueOfList)) ? guiColor : Integer.MAX_VALUE);
/* 140 */                 yPos += 12;
/*     */               } 
/*     */             } 
/* 143 */           } else if (value instanceof FloatValue) {
/* 144 */             FloatValue floatValue = (FloatValue)value;
/* 145 */             String text = value.getName() + "§f: §c" + round(((Float)floatValue.get()).floatValue());
/* 146 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 148 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 149 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 151 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 24), -2147483648);
/* 152 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 8), (yPos + 18), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F, (yPos + 19), 2147483647);
/* 153 */             float sliderValue = (moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.getSettingsWidth() - 12.0F) * (((Float)floatValue.get()).floatValue() - floatValue.getMinimum()) / (floatValue.getMaximum() - floatValue.getMinimum());
/* 154 */             RenderUtils.drawRect(8.0F + sliderValue, (yPos + 15), sliderValue + 11.0F, (yPos + 21), guiColor);
/*     */             
/* 156 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F && mouseY >= yPos + 15 && mouseY <= yPos + 21 && 
/* 157 */               Mouse.isButtonDown(0)) {
/* 158 */               double i = WMathHelper.clamp_double(((mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement.getSettingsWidth() - 12.0F)), 0.0D, 1.0D);
/* 159 */               floatValue.set(Float.valueOf(round((float)(floatValue.getMinimum() + (floatValue.getMaximum() - floatValue.getMinimum()) * i)).floatValue()));
/*     */             } 
/*     */ 
/*     */             
/* 163 */             GlStateManager.func_179117_G();
/* 164 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 165 */             yPos += 22;
/* 166 */           } else if (value instanceof IntegerValue) {
/* 167 */             IntegerValue integerValue = (IntegerValue)value;
/* 168 */             String text = value.getName() + "§f: §c" + ((value instanceof net.ccbluex.liquidbounce.value.BlockValue) ? (BlockUtils.getBlockName(((Integer)integerValue.get()).intValue()) + " (" + integerValue.get() + ")") : (String)integerValue.get());
/* 169 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 171 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 172 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 174 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 24), -2147483648);
/* 175 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 8), (yPos + 18), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F, (yPos + 19), 2147483647);
/* 176 */             float sliderValue = (moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.getSettingsWidth() - 12.0F) * (((Integer)integerValue.get()).intValue() - integerValue.getMinimum()) / (integerValue.getMaximum() - integerValue.getMinimum());
/* 177 */             RenderUtils.drawRect(8.0F + sliderValue, (yPos + 15), sliderValue + 11.0F, (yPos + 21), guiColor);
/*     */             
/* 179 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 15 && mouseY <= yPos + 21 && 
/* 180 */               Mouse.isButtonDown(0)) {
/* 181 */               double i = WMathHelper.clamp_double(((mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement.getSettingsWidth() - 12.0F)), 0.0D, 1.0D);
/* 182 */               integerValue.set(Integer.valueOf((int)(integerValue.getMinimum() + (integerValue.getMaximum() - integerValue.getMinimum()) * i)));
/*     */             } 
/*     */ 
/*     */             
/* 186 */             GlStateManager.func_179117_G();
/* 187 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 188 */             yPos += 22;
/* 189 */           } else if (value instanceof FontValue) {
/* 190 */             FontValue fontValue = (FontValue)value;
/* 191 */             IFontRenderer fontRenderer = (IFontRenderer)fontValue.get();
/*     */             
/* 193 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/*     */             
/* 195 */             String displayString = "Font: Unknown";
/*     */             
/* 197 */             if (fontRenderer.isGameFontRenderer()) {
/* 198 */               GameFontRenderer liquidFontRenderer = fontRenderer.getGameFontRenderer();
/*     */               
/* 200 */               displayString = "Font: " + liquidFontRenderer.getDefaultFont().getFont().getName() + " - " + liquidFontRenderer.getDefaultFont().getFont().getSize();
/* 201 */             } else if (fontRenderer == Fonts.minecraftFont) {
/* 202 */               displayString = "Font: Minecraft";
/*     */             } else {
/* 204 */               Fonts.FontInfo objects = Fonts.getFontDetails(fontRenderer);
/*     */               
/* 206 */               if (objects != null) {
/* 207 */                 displayString = objects.getName() + ((objects.getFontSize() != -1) ? (" - " + objects.getFontSize()) : "");
/*     */               }
/*     */             } 
/*     */             
/* 211 */             Fonts.roboto35.drawString(displayString, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, Color.WHITE.getRGB());
/* 212 */             int stringWidth = Fonts.roboto35.getStringWidth(displayString);
/*     */             
/* 214 */             if (moduleElement.getSettingsWidth() < (stringWidth + 8)) {
/* 215 */               moduleElement.setSettingsWidth((stringWidth + 8));
/*     */             }
/* 217 */             if (((Mouse.isButtonDown(0) && !this.mouseDown) || (Mouse.isButtonDown(1) && !this.rightMouseDown)) && mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 4 && mouseY <= yPos + 12) {
/* 218 */               List<IFontRenderer> fonts = Fonts.getFonts();
/*     */               
/* 220 */               if (Mouse.isButtonDown(0)) {
/* 221 */                 for (int i = 0; i < fonts.size(); i++) {
/* 222 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 224 */                   if (font.equals(fontRenderer)) {
/* 225 */                     i++;
/*     */                     
/* 227 */                     if (i >= fonts.size()) {
/* 228 */                       i = 0;
/*     */                     }
/* 230 */                     fontValue.set(fonts.get(i));
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 235 */                 for (int i = fonts.size() - 1; i >= 0; i--) {
/* 236 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 238 */                   if (font.equals(fontRenderer)) {
/* 239 */                     i--;
/*     */                     
/* 241 */                     if (i >= fonts.size()) {
/* 242 */                       i = 0;
/*     */                     }
/* 244 */                     if (i < 0) {
/* 245 */                       i = fonts.size() - 1;
/*     */                     }
/* 247 */                     fontValue.set(fonts.get(i));
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/* 254 */             yPos += 11;
/*     */           } else {
/* 256 */             String text = value.getName() + "§f: §c" + value.get();
/* 257 */             float textWidth = Fonts.roboto35.getStringWidth(text);
/*     */             
/* 259 */             if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 260 */               moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */             }
/* 262 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), -2147483648);
/* 263 */             GlStateManager.func_179117_G();
/* 264 */             Fonts.roboto35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 265 */             yPos += 12;
/*     */           } 
/*     */           
/* 268 */           if (isNumber)
/*     */           {
/* 270 */             AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */           }
/*     */         } 
/*     */         
/* 274 */         moduleElement.updatePressed();
/* 275 */         this.mouseDown = Mouse.isButtonDown(0);
/* 276 */         this.rightMouseDown = Mouse.isButtonDown(1);
/*     */         
/* 278 */         if (moduleElement.getSettingsWidth() > 0.0F && yPos > moduleElement.getY() + 4)
/* 279 */           RenderUtils.drawBorderedRect((moduleElement.getX() + moduleElement.getWidth() + 4), (moduleElement.getY() + 6), (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 2), 1.0F, -2147483648, 0); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private BigDecimal round(float f) {
/* 285 */     BigDecimal bd = new BigDecimal(Float.toString(f));
/* 286 */     bd = bd.setScale(2, 4);
/* 287 */     return bd;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\style\styles\NullStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */