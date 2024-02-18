/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import me.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.ui.client.clickgui.AnimationHelper;
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.impl.Fonts;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ElementInfo(name = "HealthHud")
/*    */ public class HealthHud
/*    */   extends Element
/*    */ {
/* 21 */   public final ListValue shadowValue = new ListValue("Shadow", new String[] { "None", "Basic", "Thick" }, "None");
/* 22 */   public FloatValue indx = new FloatValue("noting", 1.0E-7F, 0.0F, 4.0E-6F);
/*    */   public float animWidth;
/*    */   public float animatedCircleEnd;
/* 25 */   float Width = 41.0F;
/* 26 */   float Height = 42.0F;
/* 27 */   int x = 0;
/* 28 */   int y = 0;
/* 29 */   public Float x2 = (Float)this.indx.get();
/*    */ 
/*    */   
/*    */   public Border drawElement() {
/* 33 */     float health = mc.getThePlayer().getHealth();
/* 34 */     double hpPercentage = (health / mc.getThePlayer().getMaxHealth());
/* 35 */     hpPercentage = MathHelper.func_151237_a(hpPercentage, 0.0D, 1.0D);
/* 36 */     double newWidth = 51.0D * hpPercentage;
/*    */     
/* 38 */     this.animWidth = (float)AnimationHelper.animate(newWidth, this.animWidth, 0.0429999852180481D);
/* 39 */     RenderUtils.drawSmoothRect(this.x, this.y, (this.x + 40.0F), (this.y + 43.0F), (new Color(0, 0, 0, 100)).getRGB());
/*    */     
/* 41 */     switch ((String)this.shadowValue.get()) {
/*    */       case "Basic":
/* 43 */         RenderUtils.drawShadow1(this.x - 0.5F, this.y - 0.5F, this.x + 40.0F + 1.0F, this.y + 43.0F);
/*    */         break;
/*    */       case "Thick":
/* 46 */         RenderUtils.drawShadow1(this.x - 0.5F, this.y - 0.5F, this.x + 40.0F + 1.0F, this.y + 43.0F);
/* 47 */         RenderUtils.drawShadow1(this.x - 0.5F, this.y - 0.5F, this.x + 40.0F + 1.0F, this.y + 43.0F);
/*    */         break;
/*    */     } 
/*    */     
/* 51 */     Fonts.SFBOLD.SFBOLD_16.SFBOLD_16.drawCenteredString("HP", (this.x + 20), (this.y + 14 - 10), -1);
/* 52 */     RenderUtils.drawCircle((this.x + 15 + 5), this.y + 23.5D, 11.5D, -5.0F, 360.0F, Color.DARK_GRAY.darker().getRGB(), 5.5F);
/* 53 */     float coef = this.animWidth / 100.0F;
/* 54 */     double scoef = (mc.getThePlayer().getHealth() / mc.getThePlayer().getMaxHealth() * 100.0F);
/* 55 */     this.animatedCircleEnd = coef * 360.0F;
/* 56 */     RenderUtils.drawCircle((this.x + 15 + 5), this.y + 23.5D, 11.5D, -5.0F, this.animatedCircleEnd * 2.0F + this.x2.floatValue(), (new Color(255, 255, 255)).getRGB(), 5.5F);
/* 57 */     Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.drawCenteredString(Math.round(scoef) + "%", (this.x + 20), (this.y + 22), -1);
/* 58 */     return new Border(0.0F, 0.0F, this.Width, this.Height);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\HealthHud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */