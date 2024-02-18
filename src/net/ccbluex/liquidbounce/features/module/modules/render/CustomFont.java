/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ 
/*    */ @ModuleInfo(name = "CustomFont", description = "CustomFont", category = ModuleCategory.RENDER)
/*    */ public class CustomFont
/*    */   extends Module {
/* 13 */   public static final ListValue shadowValue = new ListValue("ShadowMode", new String[] { "LiquidBounce", "Outline", "Default", "Custom" }, "Default");
/*    */   
/* 15 */   public static final IntegerValue fontWidthValue = new IntegerValue("FontWidth", 7, 5, 10);
/* 16 */   public static final FloatValue shadowstrenge = new FloatValue("ShadowStrengh", 0.1F, 0.1F, 1.0F);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\CustomFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */