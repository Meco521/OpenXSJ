/*    */ package tomk.module.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.BlurUtils;
/*    */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class Hotbar
/*    */ {
/* 16 */   static HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*    */   public static void render(ScaledResolution sr, int itemX, float partialTicks) {
/* 18 */     if (((Boolean)hud.getColorItem().get()).booleanValue()) {
/* 19 */       RenderUtils.drawRect(itemX, sr.func_78328_b() - 23, itemX + 22, sr.func_78328_b() - 21, ColorManager.astolfoRainbow(0, 0, 0));
/*    */     }
/*    */   }
/*    */   
/*    */   public static void drawGuiBackground(double s) {
/* 24 */     if (s <= 0.1D || s > 1.0D)
/* 25 */       return;  ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
/* 26 */     GL11.glPushMatrix();
/* 27 */     if (!((Boolean)hud.getBlurValue().get()).booleanValue())
/* 28 */       BlurUtils.blurArea(0.0F, 0.0F, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), (float)(70.0D * s)); 
/* 29 */     RenderUtils.drawGradientSidewaysV((-4 * scaledResolution.func_78328_b()), (scaledResolution.func_78328_b() / 2), (scaledResolution.func_78326_a() * 4), (scaledResolution.func_78328_b() + 150) + (2 * scaledResolution.func_78328_b()) * (1.0D - s), (new Color(0, 0, 0, 0)).getRGB(), (new Color(0, 165, 255, (int)(255.0D * s))).getRGB());
/* 30 */     FontLoaders.C24.drawCenteredString("XSJ Client CN", (scaledResolution.func_78326_a() / 2), scaledResolution.func_78328_b() - 40.0D, (new Color(255, 255, 255, (int)(255.0D * s))).getRGB());
/* 31 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\Hotbar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */