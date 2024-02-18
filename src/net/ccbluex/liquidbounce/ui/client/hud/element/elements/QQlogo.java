/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.net.URL;
/*    */ import javax.imageio.ImageIO;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo;
/*    */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*    */ import net.minecraft.client.renderer.texture.ITextureObject;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import retreat.utils.QQUtils;
/*    */ 
/*    */ @ElementInfo(name = "QQLogo")
/*    */ public class QQlogo
/*    */   extends Element {
/*    */   protected Border draw() {
/* 23 */     GL11.glDisable(2929);
/* 24 */     GL11.glEnable(3042);
/* 25 */     GL11.glDepthMask(false);
/* 26 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 27 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */ 
/*    */     
/*    */     try {
/* 31 */       if (!this.got) {
/* 32 */         mc2.func_110434_K().func_110579_a(new ResourceLocation("MAGMA"), (ITextureObject)new DynamicTexture(
/*    */               
/* 34 */               ImageIO.read(new URL("https://q.qlogo.cn/headimg_dl?dst_uin=" + QQUtils.getSubString(QQUtils.getLoginQQList().toString(), "=", "}") + "&spec=640&img_type=png"))));
/* 35 */         this.got = true;
/*    */       } 
/* 37 */     } catch (Throwable throwable) {}
/*    */ 
/*    */     
/* 40 */     mc.getTextureManager().bindTexture2(new ResourceLocation("MAGMA"));
/* 41 */     Gui.func_146110_a(0, 0, 0.0F, 0.0F, 60, 60, 60.0F, 60.0F);
/* 42 */     GL11.glDepthMask(true);
/* 43 */     GL11.glDisable(3042);
/* 44 */     GL11.glEnable(2929);
/* 45 */     int color = (new Color(45, 45, 45)).getRGB();
/* 46 */     for (float i = 26.0F; i <= 42.0F; i++) {
/* 47 */       RenderUtils.drawOutFullCircle(31.5F, 30.0F, i, color, 5.0F);
/*    */     }
/* 49 */     RenderUtils.drawOutFullCircle(31.5F, 30.0F, 27.0F, (new Color(53, 141, 204)).getRGB(), 2.0F);
/* 50 */     RenderUtils.drawGradientSideways(60.0D, 30.0D, 180.0D, 45.0D, (new Color(45, 45, 45, 255)).getRGB(), (new Color(45, 45, 45, 0)).getRGB());
/* 51 */     RenderUtils.drawOutFullCircle(31.5F, 30.0F, 44.0F, (new Color(0, 230, 0)).getRGB(), 3.0F, -7.0F, 320.0F);
/* 52 */     RenderUtils.drawGradientSideways(60.0D, 1.0D, 200.0D, 26.5D, (new Color(45, 45, 45, 255)).getRGB(), (new Color(45, 45, 45, 0)).getRGB());
/* 53 */     FontLoaders.S20.drawString("XSJ | " + Math.round(mc.getThePlayer().getHealth()) + "hp", 80.0F, 10.0F, (new Color(200, 200, 200)).getRGB());
/* 54 */     FontLoaders.S20.drawString(String.valueOf(mc.getThePlayer().getFoodStats().getFoodLevel()), 90.0F, 34.0F, -1, false);
/* 55 */     FontLoaders.S20.drawString("Food", 105.0F, 34.0F, (new Color(236, 161, 4)).getRGB(), false);
/* 56 */     return new Border(0.0F, 0.0F, 120.0F, 30.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean got = false;
/*    */   
/*    */   public Border drawElement() {
/* 63 */     return draw();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\QQlogo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */