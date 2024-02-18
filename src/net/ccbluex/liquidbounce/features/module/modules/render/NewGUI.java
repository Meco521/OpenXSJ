/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import op.lbp.newVer.NewUi;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "NewGUI", description = "next generation clickgui.", category = ModuleCategory.RENDER, keyBind = 25, canEnable = false)
/*    */ public class NewGUI
/*    */   extends Module
/*    */ {
/* 25 */   public static final BoolValue fastRenderValue = new BoolValue("FastRender", true);
/*    */   
/* 27 */   private static final ListValue colorModeValue = new ListValue("Color", new String[] { "Custom", "Sky", "Rainbow", "LiquidSlowly", "Fade" }, "Custom");
/* 28 */   private static final IntegerValue colorRedValue = new IntegerValue("Red", 0, 0, 255);
/* 29 */   private static final IntegerValue colorGreenValue = new IntegerValue("Green", 140, 0, 255);
/* 30 */   private static final IntegerValue colorBlueValue = new IntegerValue("Blue", 255, 0, 255);
/* 31 */   private static final FloatValue saturationValue = new FloatValue("Saturation", 1.0F, 0.0F, 1.0F);
/* 32 */   private static final FloatValue brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/* 33 */   private static final IntegerValue mixerSecondsValue = new IntegerValue("Seconds", 2, 1, 10);
/* 34 */   public double progress = 0.0D; public double slide;
/*    */   
/*    */   public void onEnable() {
/* 37 */     this.slide = this.progress = 0.0D;
/* 38 */     mc2.func_147108_a((GuiScreen)NewUi.getInstance());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static Color getAccentColor() {
/* 44 */     Color c = new Color(255, 255, 255, 255);
/* 45 */     switch (((String)colorModeValue.get()).toLowerCase()) {
/*    */       case "custom":
/* 47 */         c = new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue());
/*    */         break;
/*    */       case "rainbow":
/* 50 */         c = new Color(RenderUtils.getRainbowOpaque(((Integer)mixerSecondsValue.get()).intValue(), ((Float)saturationValue.get()).floatValue(), ((Float)brightnessValue.get()).floatValue(), 0));
/*    */         break;
/*    */       case "sky":
/* 53 */         c = RenderUtils.skyRainbow(0, ((Float)saturationValue.get()).floatValue(), ((Float)brightnessValue.get()).floatValue());
/*    */         break;
/*    */       case "liquidslowly":
/* 56 */         c = ColorUtils.LiquidSlowly(System.nanoTime(), 0, ((Float)saturationValue.get()).floatValue(), ((Float)brightnessValue.get()).floatValue());
/*    */         break;
/*    */       case "fade":
/* 59 */         c = ColorUtils.fade(new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue()), 0, 100);
/*    */         break;
/*    */     } 
/* 62 */     return c;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\NewGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */