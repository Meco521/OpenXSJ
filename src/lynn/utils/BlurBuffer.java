/*    */ package lynn.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.blur.GaussianBlur;
/*    */ import net.ccbluex.liquidbounce.utils.render.blur.StencilUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlurBuffer
/*    */ {
/*    */   public static void CustomBlurArea(float x, float y, float width, float height, float BlurStrength) {
/* 16 */     StencilUtil.initStencilToWrite();
/* 17 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 18 */     StencilUtil.readStencilBuffer(1);
/* 19 */     GaussianBlur.renderBlur(BlurStrength);
/* 20 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void blurArea(float x, float y, float width, float height) {
/* 23 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 24 */     StencilUtil.initStencilToWrite();
/* 25 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 26 */     StencilUtil.readStencilBuffer(1);
/* 27 */     GaussianBlur.renderBlur(((Integer)BlurSettings.radius.get()).floatValue());
/*    */     
/* 29 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void blurArea2(float x, float y, float x2, float y2) {
/* 32 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 33 */     StencilUtil.initStencilToWrite();
/*    */     
/* 35 */     RenderUtils.drawRect(x, y, x + x2 - x, y + y2 - y, (new Color(-2)).getRGB());
/*    */     
/* 37 */     StencilUtil.readStencilBuffer(1);
/* 38 */     GaussianBlur.renderBlur(((Integer)BlurSettings.radius.get()).floatValue());
/* 39 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   
/*    */   public static void CustomBlurRoundArea(float x, float y, float width, float height, float radius, float blurStrength) {
/* 43 */     StencilUtil.initStencilToWrite();
/* 44 */     RenderUtils.drawRoundedRect2(x, y, x + width, y + height, radius, 6, (new Color(-2)).getRGB());
/* 45 */     StencilUtil.readStencilBuffer(1);
/* 46 */     GaussianBlur.renderBlur(blurStrength);
/* 47 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void blurAreacustomradius(float x, float y, float width, float height, float radius, float blurStrength) {
/* 50 */     StencilUtil.initStencilToWrite();
/* 51 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 52 */     StencilUtil.readStencilBuffer(1);
/* 53 */     GaussianBlur.renderBlur(radius);
/* 54 */     GaussianBlur.renderBlur(blurStrength);
/* 55 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   
/*    */   public static void blurRoundArea(float x, float y, float width, float height, int radius) {
/* 59 */     StencilUtil.initStencilToWrite();
/* 60 */     RenderUtils.drawRoundedRect2(x, y, x + width, y + height, radius, 6, (new Color(-2)).getRGB());
/* 61 */     StencilUtil.readStencilBuffer(1);
/* 62 */     GaussianBlur.renderBlur(8.0F);
/*    */     
/* 64 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\BlurBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */