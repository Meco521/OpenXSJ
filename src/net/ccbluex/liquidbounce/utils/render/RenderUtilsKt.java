/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.JvmStatic;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\020\007\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J0\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\0062\006\020\b\032\0020\0062\006\020\t\032\0020\0062\006\020\n\032\0020\006H\007¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/RenderUtilsKt;", "", "()V", "drawCircle", "", "x", "", "y", "radius", "start", "end", "XSJClient"})
/*    */ public final class RenderUtilsKt
/*    */ {
/*    */   static {
/* 18 */     RenderUtilsKt renderUtilsKt = new RenderUtilsKt();
/*    */   } public static final RenderUtilsKt INSTANCE;
/*    */   @JvmStatic
/*    */   public static final void drawCircle(float x, float y, float radius, float start, float end) {
/* 22 */     GlStateManager.func_179147_l();
/* 23 */     GlStateManager.func_179090_x();
/* 24 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 25 */     GL11.glEnable(2848);
/* 26 */     GL11.glLineWidth(2.0F);
/* 27 */     GL11.glBegin(3);
/* 28 */     float i = end;
/* 29 */     if (Retreat.INSTANCE.getModuleManager().get(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hud = (HUD)Retreat.INSTANCE.getModuleManager().get(HUD.class);
/* 30 */     while (i >= start) {
/*    */ 
/*    */ 
/*    */       
/* 34 */       double d1 = System.currentTimeMillis() / 360.0D + (i * 34 / 'Ũ' * 56 / 100); Color color2 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 1), color1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()); boolean bool1 = false; double d5 = Math.abs(d1); Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(color1, color2, d5 / 10), "RenderUtils.getGradientO… 100) / 10)\n            )"); int c = RenderUtils.getGradientOffset(color1, color2, d5 / 10).getRGB();
/*    */       
/* 36 */       float f2 = (c >> 24 & 0xFF) / 255.0F;
/* 37 */       float f22 = (c >> 16 & 0xFF) / 255.0F;
/* 38 */       float f3 = (c >> 8 & 0xFF) / 255.0F;
/* 39 */       float f4 = (c & 0xFF) / 255.0F;
/* 40 */       GlStateManager.func_179131_c(f22, f3, f4, f2);
/*    */       
/* 42 */       double d2 = i * Math.PI / '´', d3 = x; boolean bool2 = false; d5 = Math.cos(d2);
/* 43 */       d2 = i * Math.PI / '´'; double d4 = y; float f1 = (float)(d3 + d5 * (radius * 1.001F)); bool2 = false; double d6 = Math.sin(d2); GL11.glVertex2f(f1, (float)(d4 + d6 * (radius * 1.001F)));
/*    */       
/* 45 */       i -= 4.0F;
/*    */     } 
/* 47 */     GL11.glEnd();
/* 48 */     GL11.glDisable(2848);
/* 49 */     GlStateManager.func_179098_w();
/* 50 */     GlStateManager.func_179084_k();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\RenderUtilsKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */