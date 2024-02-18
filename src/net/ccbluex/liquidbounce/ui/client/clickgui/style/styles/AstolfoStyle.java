/*     */ package net.ccbluex.liquidbounce.ui.client.clickgui.style.styles;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ClickGUI;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
/*     */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
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
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.input.Mouse;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class AstolfoStyle
/*     */   extends Style {
/*     */   private boolean mouseDown;
/*     */   private boolean rightMouseDown;
/*     */   
/*     */   private Color getCategoryColor(String categoryName) {
/*  36 */     categoryName = categoryName.toLowerCase();
/*  37 */     if (categoryName.equals("combat")) {
/*  38 */       return new Color(231, 75, 58, 175);
/*     */     }
/*  40 */     if (categoryName.equals("player")) {
/*  41 */       return new Color(142, 69, 174, 175);
/*     */     }
/*  43 */     if (categoryName.equals("movement")) {
/*  44 */       return new Color(46, 205, 111, 175);
/*     */     }
/*  46 */     if (categoryName.equals("render")) {
/*  47 */       return new Color(76, 143, 200, 175);
/*     */     }
/*  49 */     if (categoryName.equals("world")) {
/*  50 */       return new Color(233, 215, 100, 175);
/*     */     }
/*  52 */     if (categoryName.equals("misc")) {
/*  53 */       return new Color(244, 157, 19, 175);
/*     */     }
/*  55 */     return ClickGUI.generateColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPanel(int mouseX, int mouseY, Panel panel) {
/*  60 */     RenderUtils.drawRect(panel.getX() - 3.0F, panel.getY() - 1.0F, panel.getX() + panel.getWidth() + 3.0F, (panel
/*  61 */         .getY() + 22 + panel.getFade()), getCategoryColor(panel.getName()).getRGB());
/*  62 */     RenderUtils.drawRect(panel.getX() - 2, panel.getY(), panel.getX() + panel.getWidth() + 2, panel.getY() + 21 + panel.getFade(), (new Color(17, 17, 17))
/*  63 */         .getRGB());
/*  64 */     RenderUtils.drawRect(panel.getX() + 1.0F, panel.getY() + 19.0F, panel.getX() + panel.getWidth() - 1.0F, (panel
/*  65 */         .getY() + 18 + panel.getFade()), (new Color(26, 26, 26)).getRGB());
/*     */     
/*  67 */     GlStateManager.func_179117_G();
/*  68 */     Fonts.posterama35.drawString("§l" + panel.getName().toLowerCase(), panel.getX() + 2, panel.getY() + 6, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawDescription(int mouseX, int mouseY, String text) {
/*  73 */     int textWidth = Fonts.posterama35.getStringWidth(text);
/*     */     
/*  75 */     RenderUtils.drawRect(mouseX + 9, mouseY, mouseX + textWidth + 14, mouseY + Fonts.posterama35.getFontHeight() + 3, (new Color(26, 26, 26)).getRGB());
/*  76 */     GlStateManager.func_179117_G();
/*  77 */     Fonts.posterama35.drawString(text.toLowerCase(), mouseX + 12, mouseY + Fonts.posterama35.getFontHeight() / 2, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawButtonElement(int mouseX, int mouseY, ButtonElement buttonElement) {
/*  82 */     Gui.func_73734_a(buttonElement.getX() - 1, buttonElement.getY() + 1, buttonElement.getX() + buttonElement.getWidth() + 1, buttonElement
/*  83 */         .getY() + buttonElement.getHeight() + 2, hoverColor((buttonElement.getColor() != Integer.MAX_VALUE) ? 
/*  84 */           ClickGUI.generateColor() : new Color(26, 26, 26), buttonElement.hoverTime).getRGB());
/*     */     
/*  86 */     GlStateManager.func_179117_G();
/*  87 */     Fonts.posterama35.drawString(buttonElement.getDisplayName().toLowerCase(), buttonElement.getX() + 3, buttonElement
/*  88 */         .getY() + 6, Color.RED.getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawModuleElement(int mouseX, int mouseY, ModuleElement moduleElement) {
/*  93 */     Gui.func_73734_a(moduleElement.getX() + 1, moduleElement.getY() + 1, moduleElement.getX() + moduleElement.getWidth() - 1, moduleElement
/*  94 */         .getY() + moduleElement.getHeight() + 2, hoverColor(new Color(26, 26, 26), moduleElement.hoverTime).getRGB());
/*  95 */     Gui.func_73734_a(moduleElement.getX() + 1, moduleElement.getY() + 1, moduleElement.getX() + moduleElement
/*  96 */         .getWidth() - 1, moduleElement.getY() + moduleElement.getHeight() + 2, hoverColor(new Color(
/*  97 */             getCategoryColor(moduleElement.getModule().getCategory().getDisplayName()).getRed(), getCategoryColor(moduleElement.getModule().getCategory().getDisplayName()).getGreen(), getCategoryColor(moduleElement.getModule().getCategory().getDisplayName()).getBlue(), moduleElement.slowlyFade), moduleElement.hoverTime).getRGB());
/*     */     
/*  99 */     int guiColor = ClickGUI.generateColor().getRGB();
/*     */     
/* 101 */     GlStateManager.func_179117_G();
/* 102 */     Fonts.posterama35.drawString(moduleElement.getDisplayName().toLowerCase(), (moduleElement.getX() + 3), (moduleElement
/* 103 */         .getY() + 7), 2147483647, true);
/*     */     
/* 105 */     List<Value<?>> moduleValues = moduleElement.getModule().getValues();
/*     */     
/* 107 */     if (!moduleValues.isEmpty()) {
/* 108 */       Fonts.posterama35.drawString("+", moduleElement.getX() + moduleElement.getWidth() - 8, moduleElement
/* 109 */           .getY() + moduleElement.getHeight() / 2, (new Color(255, 255, 255, 200)).getRGB());
/*     */       
/* 111 */       if (moduleElement.isShowSettings()) {
/* 112 */         int yPos = moduleElement.getY() + 4;
/*     */         
/* 114 */         for (Value<?> value : moduleValues) {
/*     */           
/* 116 */           if (value instanceof BoolValue) {
/* 117 */             String str = value.getName();
/* 118 */             float f = Fonts.posterama35.getStringWidth(str);
/*     */             
/* 120 */             if (moduleElement.getSettingsWidth() < f + 8.0F) {
/* 121 */               moduleElement.setSettingsWidth(f + 8.0F);
/*     */             }
/* 123 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement
/* 124 */                 .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), (new Color(26, 26, 26)).getRGB());
/*     */             
/* 126 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement
/* 127 */               .getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 128 */               Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 129 */               BoolValue boolValue = (BoolValue)value;
/*     */               
/* 131 */               boolValue.set(Boolean.valueOf(!((Boolean)boolValue.get()).booleanValue()));
/*     */             } 
/*     */ 
/*     */             
/* 135 */             GlStateManager.func_179117_G();
/* 136 */             Fonts.posterama35.drawString(str.toLowerCase(), moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 
/* 137 */                 ((Boolean)((BoolValue)value).get()).booleanValue() ? guiColor : Integer.MAX_VALUE);
/*     */             
/* 139 */             yPos += 12; continue;
/* 140 */           }  if (value instanceof ListValue) {
/* 141 */             ListValue listValue = (ListValue)value;
/* 142 */             String str = value.getName();
/* 143 */             float f = Fonts.posterama35.getStringWidth(str);
/*     */             
/* 145 */             if (moduleElement.getSettingsWidth() < f + 16.0F) {
/* 146 */               moduleElement.setSettingsWidth(f + 16.0F);
/*     */             }
/* 148 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement
/* 149 */                 .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), (new Color(26, 26, 26)).getRGB());
/* 150 */             GlStateManager.func_179117_G();
/* 151 */             Fonts.posterama35.drawString("§c" + str.toLowerCase(), moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 152 */             Fonts.posterama35.drawString(listValue.openList ? "-" : "+", 
/* 153 */                 (int)((moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - (listValue.openList ? 5 : 6)), yPos + 4, 16777215);
/*     */             
/* 155 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement
/* 156 */               .getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 157 */               Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 158 */               listValue.openList = !listValue.openList;
/*     */             }
/*     */ 
/*     */             
/* 162 */             yPos += 12;
/*     */             
/* 164 */             for (String valueOfList : listValue.getValues()) {
/* 165 */               float textWidth2 = Fonts.posterama35.getStringWidth(">" + valueOfList);
/*     */               
/* 167 */               if (moduleElement.getSettingsWidth() < textWidth2 + 12.0F) {
/* 168 */                 moduleElement.setSettingsWidth(textWidth2 + 12.0F);
/*     */               }
/* 170 */               if (listValue.openList) {
/* 171 */                 RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement
/* 172 */                     .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), (new Color(26, 26, 26)).getRGB());
/*     */                 
/* 174 */                 if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement
/* 175 */                   .getSettingsWidth() && mouseY >= yPos + 2 && mouseY <= yPos + 14 && 
/* 176 */                   Mouse.isButtonDown(0) && moduleElement.isntPressed()) {
/* 177 */                   listValue.set(valueOfList);
/*     */                 }
/*     */ 
/*     */                 
/* 181 */                 GlStateManager.func_179117_G();
/* 182 */                 Fonts.posterama35.drawString(">", moduleElement.getX() + moduleElement
/* 183 */                     .getWidth() + 6, yPos + 4, 2147483647);
/* 184 */                 Fonts.posterama35.drawString(valueOfList.toLowerCase(), moduleElement.getX() + moduleElement.getWidth() + 14, yPos + 4, (listValue
/* 185 */                     .get() != null && ((String)listValue.get()).equalsIgnoreCase(valueOfList)) ? guiColor : Integer.MAX_VALUE);
/* 186 */                 yPos += 12;
/*     */               } 
/*     */             }  continue;
/* 189 */           }  if (value instanceof FloatValue) {
/* 190 */             FloatValue floatValue = (FloatValue)value;
/* 191 */             String str = value.getName() + "§f: §c" + round(((Float)floatValue.get()).floatValue());
/* 192 */             float f1 = Fonts.posterama35.getStringWidth(str);
/*     */             
/* 194 */             if (moduleElement.getSettingsWidth() < f1 + 8.0F) {
/* 195 */               moduleElement.setSettingsWidth(f1 + 8.0F);
/*     */             }
/* 197 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement
/* 198 */                 .getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth(), (yPos + 24), (new Color(26, 26, 26)).getRGB());
/* 199 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 8), (yPos + 18), (moduleElement
/* 200 */                 .getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F, (yPos + 19), 2147483647);
/*     */             
/* 202 */             float sliderValue = (moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.getSettingsWidth() - 12.0F) * (((Float)floatValue.get()).floatValue() - floatValue.getMinimum()) / (floatValue.getMaximum() - floatValue.getMinimum());
/* 203 */             RenderUtils.drawRect(8.0F + sliderValue, (yPos + 15), sliderValue + 11.0F, (yPos + 21), guiColor);
/*     */ 
/*     */             
/* 206 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() - 4.0F && mouseY >= yPos + 15 && mouseY <= yPos + 21 && 
/* 207 */               Mouse.isButtonDown(0)) {
/* 208 */               double i = MathHelper.func_76131_a((mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement
/* 209 */                   .getSettingsWidth() - 12.0F), 0.0F, 1.0F);
/* 210 */               floatValue.set(Float.valueOf(round((float)(floatValue.getMinimum() + (floatValue.getMaximum() - floatValue.getMinimum()) * i)).floatValue()));
/*     */             } 
/*     */ 
/*     */             
/* 214 */             GlStateManager.func_179117_G();
/* 215 */             Fonts.posterama35.drawString(str.toLowerCase(), moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 216 */             yPos += 22; continue;
/* 217 */           }  if (value instanceof IntegerValue) {
/* 218 */             IntegerValue integerValue = (IntegerValue)value;
/* 219 */             String str = value.getName() + "§f: §c" + ((value instanceof net.ccbluex.liquidbounce.value.BlockValue) ? (BlockUtils.getBlockName(((Integer)integerValue.get()).intValue()) + " (" + integerValue.get() + ")") : (String)integerValue.get());
/* 220 */             float f1 = Fonts.posterama35.getStringWidth(str);
/*     */             
/* 222 */             if (moduleElement.getSettingsWidth() < f1 + 8.0F) {
/* 223 */               moduleElement.setSettingsWidth(f1 + 8.0F);
/*     */             }
/* 225 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement
/* 226 */                 .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 24), (new Color(26, 26, 26)).getRGB());
/* 227 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 8), (yPos + 18), (moduleElement.getX() + moduleElement
/* 228 */                 .getWidth()) + moduleElement.getSettingsWidth() - 4.0F, (yPos + 19), 2147483647);
/*     */             
/* 230 */             float sliderValue = (moduleElement.getX() + moduleElement.getWidth()) + (moduleElement.getSettingsWidth() - 12.0F) * (((Integer)integerValue.get()).intValue() - integerValue.getMinimum()) / (integerValue.getMaximum() - integerValue.getMinimum());
/* 231 */             RenderUtils.drawRect(8.0F + sliderValue, (yPos + 15), sliderValue + 11.0F, (yPos + 21), guiColor);
/* 232 */             if (mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement.getX() + moduleElement.getWidth()) + moduleElement
/* 233 */               .getSettingsWidth() && mouseY >= yPos + 15 && mouseY <= yPos + 21 && 
/* 234 */               Mouse.isButtonDown(0)) {
/* 235 */               double i = MathHelper.func_76131_a((mouseX - moduleElement.getX() - moduleElement.getWidth() - 8) / (moduleElement
/* 236 */                   .getSettingsWidth() - 12.0F), 0.0F, 1.0F);
/* 237 */               integerValue.set(Integer.valueOf((int)(integerValue.getMinimum() + (integerValue.getMaximum() - integerValue.getMinimum()) * i)));
/*     */             } 
/*     */ 
/*     */             
/* 241 */             GlStateManager.func_179117_G();
/* 242 */             Fonts.posterama35.drawString(str.toLowerCase(), moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 243 */             yPos += 22; continue;
/* 244 */           }  if (value instanceof FontValue) {
/* 245 */             FontValue fontValue = (FontValue)value;
/* 246 */             IFontRenderer fontRenderer = (IFontRenderer)fontValue.get();
/*     */             
/* 248 */             RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement
/* 249 */                 .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), (new Color(26, 26, 26)).getRGB());
/*     */ 
/*     */ 
/*     */             
/* 253 */             String displayString = "Font: " + Fonts.getFontDetails((IFontRenderer)fontValue.get()).getName();
/*     */             
/* 255 */             assert Fonts.posterama35 != null;
/* 256 */             Fonts.posterama35.drawString(displayString.toLowerCase(), moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, Color.WHITE.getRGB());
/* 257 */             int stringWidth = Fonts.posterama35.getStringWidth(displayString);
/*     */             
/* 259 */             if (moduleElement.getSettingsWidth() < (stringWidth + 8)) {
/* 260 */               moduleElement.setSettingsWidth((stringWidth + 8));
/*     */             }
/* 262 */             if (((Mouse.isButtonDown(0) && !this.mouseDown) || (Mouse.isButtonDown(1) && !this.rightMouseDown)) && mouseX >= moduleElement.getX() + moduleElement.getWidth() + 4 && mouseX <= (moduleElement
/* 263 */               .getX() + moduleElement.getWidth()) + moduleElement.getSettingsWidth() && mouseY >= yPos + 4 && mouseY <= yPos + 12) {
/* 264 */               List<IFontRenderer> fonts = Fonts.getFonts();
/*     */               
/* 266 */               if (Mouse.isButtonDown(0)) {
/* 267 */                 for (int i = 0; i < fonts.size(); i++) {
/* 268 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 270 */                   if (font == fontRenderer) {
/* 271 */                     i++;
/*     */                     
/* 273 */                     if (i >= fonts.size()) {
/* 274 */                       i = 0;
/*     */                     }
/* 276 */                     fontValue.set(fonts.get(i));
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } else {
/* 281 */                 for (int i = fonts.size() - 1; i >= 0; i--) {
/* 282 */                   IFontRenderer font = fonts.get(i);
/*     */                   
/* 284 */                   if (font == fontRenderer) {
/* 285 */                     i--;
/*     */                     
/* 287 */                     if (i >= fonts.size()) {
/* 288 */                       i = 0;
/*     */                     }
/* 290 */                     if (i < 0) {
/* 291 */                       i = fonts.size() - 1;
/*     */                     }
/* 293 */                     fontValue.set(fonts.get(i));
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/* 299 */             yPos += 11; continue;
/*     */           } 
/* 301 */           String text = value.getName() + "§f: §c" + value.get();
/* 302 */           float textWidth = Fonts.posterama35.getStringWidth(text);
/*     */           
/* 304 */           if (moduleElement.getSettingsWidth() < textWidth + 8.0F) {
/* 305 */             moduleElement.setSettingsWidth(textWidth + 8.0F);
/*     */           }
/* 307 */           RenderUtils.drawRect((moduleElement.getX() + moduleElement.getWidth() + 4), (yPos + 2), (moduleElement.getX() + moduleElement
/* 308 */               .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 14), (new Color(26, 26, 26)).getRGB());
/* 309 */           GlStateManager.func_179117_G();
/* 310 */           Fonts.posterama35.drawString(text, moduleElement.getX() + moduleElement.getWidth() + 6, yPos + 4, 16777215);
/* 311 */           yPos += 12;
/*     */         } 
/*     */ 
/*     */         
/* 315 */         moduleElement.updatePressed();
/* 316 */         this.mouseDown = Mouse.isButtonDown(0);
/* 317 */         this.rightMouseDown = Mouse.isButtonDown(1);
/*     */         
/* 319 */         if (moduleElement.getSettingsWidth() > 0.0F && yPos > moduleElement.getY() + 4)
/* 320 */           RenderUtils.drawBorderedRect((moduleElement.getX() + moduleElement.getWidth() + 4), (moduleElement.getY() + 6), (moduleElement.getX() + moduleElement
/* 321 */               .getWidth()) + moduleElement.getSettingsWidth(), (yPos + 2), 1.0F, (new Color(26, 26, 26)).getRGB(), 0); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private BigDecimal round(float f) {
/* 327 */     BigDecimal bd = new BigDecimal(Float.toString(f));
/* 328 */     bd = bd.setScale(2, RoundingMode.HALF_UP);
/* 329 */     return bd;
/*     */   }
/*     */   
/*     */   private Color hoverColor(Color color, int hover) {
/* 333 */     int r = color.getRed() - hover * 2;
/* 334 */     int g = color.getGreen() - hover * 2;
/* 335 */     int b = color.getBlue() - hover * 2;
/*     */     
/* 337 */     return new Color(Math.max(r, 0), Math.max(g, 0), Math.max(b, 0), color.getAlpha());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\style\styles\AstolfoStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */