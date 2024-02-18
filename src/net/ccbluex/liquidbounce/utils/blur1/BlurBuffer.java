/*    */ package net.ccbluex.liquidbounce.utils.blur1;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.utils.blur.GaussianBlur;
/*    */ import net.ccbluex.liquidbounce.utils.blur.StencilUtil;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlurBuffer
/*    */ {
/*    */   public static void blurArea(float x, float y, float width, float height) {
/* 17 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 18 */     StencilUtil.initStencilToWrite();
/* 19 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 20 */     StencilUtil.readStencilBuffer(1);
/* 21 */     GaussianBlur.renderBlur(((Float)hud.getBlurStrength().getValue()).floatValue());
/* 22 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void CustomBlurArea(float x, float y, float width, float height, float BlurStrength) {
/* 25 */     StencilUtil.initStencilToWrite();
/* 26 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 27 */     StencilUtil.readStencilBuffer(1);
/* 28 */     GaussianBlur.renderBlur(BlurStrength);
/* 29 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void blurArea2(float x, float y, float x2, float y2) {
/* 32 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 33 */     StencilUtil.initStencilToWrite();
/*    */     
/* 35 */     RenderUtils.drawRect(x, y, x + x2 - x, y + y2 - y, (new Color(-2)).getRGB());
/*    */     
/* 37 */     StencilUtil.readStencilBuffer(1);
/* 38 */     GaussianBlur.renderBlur(((Integer)hud.getRadius().getValue()).floatValue());
/* 39 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void CustomBlurRoundArea(float x, float y, float width, float height, float radius, float BlurStrength) {
/* 42 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 43 */     StencilUtil.initStencilToWrite();
/* 44 */     RoundedUtil.drawRound(x, y, width, height, radius, new Color(-2));
/* 45 */     StencilUtil.readStencilBuffer(1);
/* 46 */     GaussianBlur.renderBlur(BlurStrength);
/* 47 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void blurRoundArea(float x, float y, float width, float height, float radius) {
/* 50 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 51 */     StencilUtil.initStencilToWrite();
/* 52 */     RenderUtils.drawRoundedRect2(x, y, x + width, y + height, radius, 6, (new Color(-2)).getRGB());
/* 53 */     StencilUtil.readStencilBuffer(1);
/* 54 */     GaussianBlur.renderBlur(((Float)hud.getBlurStrength().getValue()).floatValue());
/* 55 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\blur1\BlurBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */