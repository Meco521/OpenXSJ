/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.impl.Fonts;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ @ElementInfo(name = "NovoKeyBinds")
/*    */ public class NovoKeyBinds
/*    */   extends Element {
/* 17 */   public final BoolValue onlyState = new BoolValue("OnlyModuleState", false);
/* 18 */   public final IntegerValue alpha2 = new IntegerValue("New-BG-Alpha", 40, 0, 255);
/*    */ 
/*    */ 
/*    */   
/*    */   public void shader() {
/* 23 */     RenderUtils.drawRoundedRect2(0.0F, 0.0F, 84.0F, (17 + getmoduley()), 0.0F, -1);
/*    */   }
/*    */   
/*    */   public Border drawElement() {
/* 27 */     int y2 = 0;
/*    */     
/* 29 */     RenderUtils.drawRoundedRect2(0.0F, 0.0F, 84.0F, (17 + getmoduley()), 0.0F, (new Color(0, 0, 0, ((Integer)this.alpha2.get()).intValue())).getRGB());
/*    */     
/* 31 */     Fonts.CsgoIcon.csgoicon_20.csgoicon_20.drawString("a", 3.0F, 6.5F, -1, true);
/* 32 */     Fonts.SFBOLD.SFBOLD_20.SFBOLD_20.drawString("KeyBinds", 23.0F, 5.5F, -1, true);
/*    */ 
/*    */     
/* 35 */     for (Module module : Retreat.moduleManager.getModules()) {
/* 36 */       if (module.getKeyBind() == 0 || ((
/* 37 */         (Boolean)this.onlyState.get()).booleanValue() && 
/* 38 */         !module.getState())) {
/*    */         continue;
/*    */       }
/* 41 */       Fonts.SFBOLD.SFBOLD_14.SFBOLD_14.drawString(module.getName(), 3.0F, y2 + 21.0F, -1, true);
/*    */       
/* 43 */       Fonts.SFBOLD.SFBOLD_14.SFBOLD_14.drawString("[Toggle]", (78 - Fonts.Tahoma.Tahoma_14.Tahoma_14.stringWidth("[Toggle]")), y2 + 21.0F, module.getState() ? (new Color(255, 255, 255)).getRGB() : (new Color(100, 100, 100)).getRGB(), true);
/* 44 */       y2 += 12;
/*    */     } 
/*    */     
/* 47 */     return new Border(0.0F, 0.0F, 84.0F, (17 + getmoduley()));
/*    */   }
/*    */   
/*    */   public int getmoduley() {
/* 51 */     int y = 0;
/* 52 */     for (Module module : Retreat.moduleManager.getModules()) {
/* 53 */       if (module.getKeyBind() == 0 || ((
/* 54 */         (Boolean)this.onlyState.get()).booleanValue() && 
/* 55 */         !module.getState()))
/*    */         continue; 
/* 57 */       y += 12;
/*    */     } 
/*    */     
/* 60 */     return y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\NovoKeyBinds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */