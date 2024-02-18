/*    */ package lynn.utils.blur;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.blur.KawaseBlur;
/*    */ import net.minecraft.client.shader.Framebuffer;
/*    */ 
/*    */ 
/*    */ public class BlurBuffer
/*    */ {
/* 14 */   private static Framebuffer bloomFramebuffer = new Framebuffer(1, 1, true);
/*    */   public static void blurArea(float x, float y, float width, float height) {
/* 16 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 17 */     StencilUtil.initStencilToWrite();
/* 18 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 19 */     StencilUtil.readStencilBuffer(1);
/* 20 */     GaussianBlur.renderBlur(((Integer)BlurSettings.radius.get()).floatValue());
/* 21 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void blurArea2(float x, float y, float x2, float y2) {
/* 26 */     bloomFramebuffer = RenderUtils.TcreateFrameBuffer(bloomFramebuffer);
/* 27 */     bloomFramebuffer.func_147614_f();
/* 28 */     bloomFramebuffer.func_147610_a(false);
/* 29 */     RenderUtils.drawRect(x, y, x + x2 - x, y + y2 - y + 1.0F, (new Color(-2)).getRGB());
/* 30 */     bloomFramebuffer.func_147609_e();
/* 31 */     KawaseBlur.renderBlur(bloomFramebuffer.field_147617_g, ((Integer)BlurSettings.iterations.getValue()).intValue(), ((Integer)BlurSettings.offset.getValue()).intValue());
/*    */   }
/*    */   
/*    */   public static void blurAreacustomradius(float x, float y, float width, float height, float radius, float BlurStrength) {
/* 35 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 36 */     StencilUtil.initStencilToWrite();
/* 37 */     RenderUtils.drawRect(x, y, x + width, y + height, (new Color(-2)).getRGB());
/* 38 */     StencilUtil.readStencilBuffer(1);
/* 39 */     GaussianBlur.renderBlur(radius);
/* 40 */     GaussianBlur.renderBlur(BlurStrength);
/* 41 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */   public static void blurRoundArea(float x, float y, float width, float height, int radius) {
/* 44 */     StencilUtil.initStencilToWrite();
/* 45 */     RenderUtils.drawRoundedRect2(x, y, x + width, y + height, radius, 6, (new Color(-2)).getRGB());
/* 46 */     StencilUtil.readStencilBuffer(1);
/* 47 */     GaussianBlur.renderBlur(8.0F);
/*    */     
/* 49 */     StencilUtil.uninitStencilBuffer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\blur\BlurBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */