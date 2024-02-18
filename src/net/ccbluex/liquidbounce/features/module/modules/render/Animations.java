/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ 
/*    */ @ModuleInfo(name = "Animations", description = "Blocking animations", category = ModuleCategory.RENDER)
/*    */ public class Animations extends Module {
/* 13 */   public static final FloatValue xValue = new FloatValue("Blocking-X", 0.0F, -2.0F, 2.0F);
/* 14 */   public static final FloatValue yValue = new FloatValue("Blocking-Y", 0.0F, -2.0F, 2.0F);
/* 15 */   public static final FloatValue zValue = new FloatValue("Blocking-Z", 0.0F, -2.0F, 2.0F);
/* 16 */   public static final FloatValue scaleValue = new FloatValue("Blocking-scale", 0.8F, 0.1F, 1.0F);
/* 17 */   public static final FloatValue xhValue = new FloatValue("Held-X", 0.0F, -2.0F, 2.0F);
/* 18 */   public static final FloatValue yhValue = new FloatValue("Held-Y", 0.0F, -2.0F, 2.0F);
/* 19 */   public static final FloatValue zhValue = new FloatValue("Held-Z", 0.0F, -2.0F, 2.0F);
/* 20 */   public static final FloatValue scalehValue = new FloatValue("Held-scale", 0.8F, 0.1F, 1.0F);
/* 21 */   public static final BoolValue heldValue = new BoolValue("Held", true);
/* 22 */   public static final BoolValue SPValue = new BoolValue("Progress", true);
/* 23 */   public static final BoolValue oldSPValue = new BoolValue("Progress1.8", true);
/*    */ 
/*    */   
/* 26 */   public static final FloatValue SpeedRotate = new FloatValue("Rotate-Speed", 1.0F, 0.0F, 10.0F);
/*    */ 
/*    */   
/* 29 */   public static final ListValue transformFirstPersonRotate = new ListValue("RotateMode", new String[] { "RotateY", "RotateXY", "Custom", "None" }, "RotateY");
/*    */   
/* 31 */   public static final FloatValue customRotate1 = new FloatValue("CustomRotateXAxis", 0.0F, -180.0F, 180.0F);
/* 32 */   public static final FloatValue customRotate2 = new FloatValue("CustomRotateYAxis", 0.0F, -180.0F, 180.0F);
/* 33 */   public static final FloatValue customRotate3 = new FloatValue("CustomRotateZAxis", 0.0F, -180.0F, 180.0F);
/*    */   
/* 35 */   public static final IntegerValue SpeedSwing = new IntegerValue("Swing-Speed", 4, 0, 20);
/* 36 */   public static final ListValue tabAnimations = new ListValue("Tab-Animation", new String[] { "None", "Zoom", "Slide" }, "Zoom");
/* 37 */   public static final ListValue Sword = new ListValue("Sword", new String[] { "Old", "1.7", "WindMill", "Push", "Smooth", "SigmaOld", "BigGod", "Jello" }, "1.7");
/*    */ 
/*    */   
/*    */   public String getTag() {
/* 41 */     return (String)Sword.get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Animations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */