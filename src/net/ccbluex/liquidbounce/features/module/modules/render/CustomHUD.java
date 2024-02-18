/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ 
/*    */ @ModuleInfo(name = "CustomHUD", description = "CustomHUD.", category = ModuleCategory.RENDER)
/*    */ public class CustomHUD
/*    */   extends Module {
/* 21 */   public static ListValue gsValue = new ListValue("NameMode", new String[] { "None", "logo", "logo2" }, "WaterMark");
/* 22 */   public static final TextValue domainValue = new TextValue("Domain", "Retreat");
/* 23 */   public static final BoolValue ChineseScore = new BoolValue("ChineseScore", false);
/* 24 */   public static final IntegerValue R = new IntegerValue("R", 0, 0, 255);
/* 25 */   public static final IntegerValue G = new IntegerValue("G", 0, 0, 255);
/* 26 */   public static final IntegerValue B = new IntegerValue("B", 0, 0, 255);
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public void onRender2D(Render2DEvent event) {
/* 31 */     ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
/* 32 */     if (Retreat.INSTANCE.getHeight() != -14.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 37 */     if (((String)gsValue.get()).equals("logo")) {
/* 38 */       String text = "XSJClient";
/*    */       
/* 40 */       Fonts.sellena100.drawString(text, 5, 8, (new Color(((Integer)R.get()).intValue(), ((Integer)G.get()).intValue(), ((Integer)B.get()).intValue(), 255)).getRGB());
/*    */     } 
/* 42 */     if (((String)gsValue.get()).equals("logo2")) {
/* 43 */       String text = "XSJClient";
/*    */       
/* 45 */       Fonts.productSans80.drawString(text, 5, 8, (new Color(((Integer)R.get()).intValue(), ((Integer)G.get()).intValue(), ((Integer)B.get()).intValue(), 255)).getRGB());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\CustomHUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */