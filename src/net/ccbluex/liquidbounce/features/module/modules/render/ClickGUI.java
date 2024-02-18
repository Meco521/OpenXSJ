/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.Style;
/*    */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.styles.AstolfoStyle;
/*    */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.styles.LiquidBounceStyle;
/*    */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.styles.NullStyle;
/*    */ import net.ccbluex.liquidbounce.ui.client.clickgui.style.styles.SlowlyStyle;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.DropdownClickGui;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ 
/*    */ @ModuleInfo(name = "ClickGUI", description = "Opens the ClickGUI.", category = ModuleCategory.RENDER, keyBind = 54, canEnable = false)
/*    */ public class ClickGUI extends Module {
/* 26 */   private final ListValue styleValue = new ListValue("Style", new String[] { "LiquidBounce", "Null", "Slowly", "Astolfo" }, "Slowly")
/*    */     {
/*    */       protected void onChanged(String oldValue, String newValue) {
/* 29 */         ClickGUI.this.updateStyle();
/*    */       }
/*    */     };
/*    */   
/* 33 */   private final ListValue clickguimodeValue = new ListValue("Mode", new String[] { "LiquidBounce", "Tenacity" }, "Tenacity");
/* 34 */   public static final ListValue colormode = new ListValue("Setting Accent", new String[] { "White", "Color" }, "Color");
/* 35 */   public static final ListValue scrollMode = new ListValue("Scroll Mode", new String[] { "Screen Height", "Value" }, "Value");
/* 36 */   public static final IntegerValue clickHeight = new IntegerValue("Tab Height", 250, 100, 500);
/* 37 */   public final FloatValue scaleValue = new FloatValue("Scale", 1.0F, 0.7F, 2.0F);
/* 38 */   public final IntegerValue maxElementsValue = new IntegerValue("MaxElements", 15, 1, 20);
/*    */   
/* 40 */   private static final BoolValue colorRainbow = new BoolValue("Rainbow", false);
/* 41 */   public static final BoolValue backback = new BoolValue("Background Accent", true);
/*    */   public static Color generateColor() {
/* 43 */     return ((Boolean)colorRainbow.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Integer)AColorPalette.RA.get()).intValue(), ((Integer)AColorPalette.GA.get()).intValue(), ((Integer)AColorPalette.BA.get()).intValue());
/*    */   }
/*    */   public static int generateRGB() {
/* 46 */     return ((Boolean)colorRainbow.get()).booleanValue() ? ColorUtils.rainbow().getRGB() : (new Color(((Integer)AColorPalette.RA.get()).intValue(), ((Integer)AColorPalette.GA.get()).intValue(), ((Integer)AColorPalette.BA.get()).intValue())).getRGB();
/*    */   }
/*    */   public static int generateRGB2() {
/* 49 */     return ((Boolean)colorRainbow.get()).booleanValue() ? ColorUtils.rainbow().getRGB() : (new Color(((Integer)AColorPalette.RA2.get()).intValue(), ((Integer)AColorPalette.GA2.get()).intValue(), ((Integer)AColorPalette.BA2.get()).intValue())).getRGB();
/*    */   }
/*    */   
/*    */   public void onEnable() {
/* 53 */     if (((String)this.clickguimodeValue.get()).equalsIgnoreCase("LiquidBounce")) {
/* 54 */       updateStyle();
/* 55 */       mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)Retreat.clickGui));
/*    */     } 
/* 57 */     if (((String)this.clickguimodeValue.get()).equalsIgnoreCase("Tenacity")) {
/* 58 */       mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new DropdownClickGui()));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void updateStyle() {
/* 65 */     switch (((String)this.styleValue.get()).toLowerCase()) {
/*    */       case "liquidbounce":
/* 67 */         Retreat.clickGui.style = (Style)new LiquidBounceStyle();
/*    */         break;
/*    */       case "null":
/* 70 */         Retreat.clickGui.style = (Style)new NullStyle();
/*    */         break;
/*    */       case "slowly":
/* 73 */         Retreat.clickGui.style = (Style)new SlowlyStyle();
/*    */         break;
/*    */       case "astolfo":
/* 76 */         Retreat.clickGui.style = (Style)new AstolfoStyle();
/*    */         break;
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget(ignoreCondition = true)
/*    */   public void onPacket(PacketEvent event) {
/* 83 */     IPacket packet = event.getPacket();
/*    */     
/* 85 */     if (classProvider.isSPacketCloseWindow(packet) && classProvider.isClickGui(mc.getCurrentScreen()))
/* 86 */       event.cancelEvent(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ClickGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */