/*    */ package net.ccbluex.liquidbounce.utils.render.blur;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlurUtils
/*    */ {
/*    */   public static void blurArea(float x, float y, float width, float height) {
/* 14 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 15 */     StencilUtil.initStencilToWrite();
/* 16 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 17 */     StencilUtil.readStencilBuffer(1);
/* 18 */     GaussianBlur.renderBlur(((Integer)BlurSettings.hudradius.get()).floatValue());
/* 19 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void CustomBlurArea(float x, float y, float width, float height, float BlurStrength) {
/* 24 */     StencilUtil.initStencilToWrite();
/* 25 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 26 */     StencilUtil.readStencilBuffer(1);
/* 27 */     GaussianBlur.renderBlur(BlurStrength);
/* 28 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   
/*    */   public static void CustomBlurRoundArea(float x, float y, float width, float height, float radius, float BlurStrength) {
/* 32 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 33 */     StencilUtil.initStencilToWrite();
/* 34 */     RenderUtils.drawRoundedRect2(x, y, x + width, y + height, radius, 6, (new Color(-2)).getRGB());
/* 35 */     StencilUtil.readStencilBuffer(1);
/* 36 */     GaussianBlur.renderBlur(BlurStrength);
/* 37 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   
/*    */   public static void shapeBlur(Runnable content) {
/* 41 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 42 */     StencilUtil.initStencilToWrite();
/* 43 */     content.run();
/* 44 */     StencilUtil.readStencilBuffer(1);
/* 45 */     GaussianBlur.renderBlur(((Integer)BlurSettings.hudradius.get()).floatValue());
/* 46 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void blurRoundArea(float x, float y, float width, float height, float radius) {
/* 51 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 52 */     StencilUtil.initStencilToWrite();
/* 53 */     RenderUtils.drawRoundedRect2(x, y, x + width, y + height, radius, 6, (new Color(-2)).getRGB());
/* 54 */     StencilUtil.readStencilBuffer(1);
/* 55 */     GaussianBlur.renderBlur(((Integer)BlurSettings.hudradius.get()).floatValue());
/* 56 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\blur\BlurUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */