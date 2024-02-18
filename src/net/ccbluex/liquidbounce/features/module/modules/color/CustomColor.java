/*    */ package net.ccbluex.liquidbounce.features.module.modules.color;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ @ModuleInfo(name = "CustomColor", description = "CustomColor", category = ModuleCategory.COLOR)
/*    */ public class CustomColor
/*    */   extends Module
/*    */ {
/* 13 */   public static final IntegerValue r = new IntegerValue("Red", 5, 0, 255);
/* 14 */   public static final IntegerValue g = new IntegerValue("Green", 97, 0, 255);
/* 15 */   public static final IntegerValue b = new IntegerValue("Blue", 157, 0, 255);
/* 16 */   public static final IntegerValue a = new IntegerValue("Alpha", 100, 0, 255);
/* 17 */   public static final IntegerValue gradientSpeed = new IntegerValue("ColorSpeed", 100, 10, 1000);
/* 18 */   public static final IntegerValue a2 = new IntegerValue("A2", 100, 0, 255);
/* 19 */   public static final IntegerValue r2 = new IntegerValue("Red-2", 255, 0, 255);
/* 20 */   public static final IntegerValue g2 = new IntegerValue("Green-2", 255, 0, 255);
/* 21 */   public static final IntegerValue b2 = new IntegerValue("Blue-2", 255, 0, 255);
/*    */   
/* 23 */   public static final FloatValue ra = new FloatValue("Radius", 6.44F, 0.1F, 10.0F);
/* 24 */   public static final FloatValue line = new FloatValue("Line", 2.0F, 0.0F, 5.0F);
/*    */   
/* 26 */   public static final FloatValue office = new FloatValue("Office", 3.0F, 0.0F, 5.0F);
/* 27 */   public static final FloatValue radius = new FloatValue("radius", 3.0F, 0.0F, 10.0F);
/*    */   
/*    */   public CustomColor() {
/* 30 */     setState(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\color\CustomColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */