/*    */ package net.ccbluex.liquidbounce.features.module.modules.color;@ModuleInfo(name = "VisualColor", category = ModuleCategory.COLOR, array = false, description = "视觉颜色")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\003\b\007\030\000 \0032\0020\001:\001\003B\005¢\006\002\020\002¨\006\004"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/color/VisualColor;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Companion", "XSJClient"})
/*    */ public final class VisualColor extends Module { @JvmField
/*    */   @NotNull
/*    */   public static final ListValue colorModeValue; @NotNull
/*    */   private static final IntegerValue gradientDistanceValue; @NotNull
/*    */   private static final IntegerValue gradientLoopValue; @NotNull
/*    */   private static final FloatValue saturationValue; @NotNull
/*    */   private static final FloatValue brightnessValue; @NotNull
/*    */   private static final IntegerValue waveSecondValue; @NotNull
/*    */   private static final BoolValue blur;
/* 12 */   public static final Companion Companion = new Companion(null); @NotNull private static final BoolValue Shadow; @NotNull private static final IntegerValue r; @NotNull private static final IntegerValue b; @NotNull private static final IntegerValue g; @NotNull private static final IntegerValue r2; @NotNull private static final IntegerValue b2; @NotNull private static final IntegerValue g2; @NotNull private static final IntegerValue gradientSpeed; static { colorModeValue = new ListValue("Novo-Line-Color", new String[] { "Custom", "Rainbow", "Gident", "Sky", "Slowly", "Fade", "Health" }, "Gident");
/* 13 */     gradientDistanceValue = new IntegerValue("NewNovoline-GradientDistance", 56, 1, 200);
/* 14 */     gradientLoopValue = new IntegerValue("NewNovoline-GradientLoop", 7, 1, 40);
/* 15 */     saturationValue = new FloatValue("NewNovoline-Saturation", 1.0F, 0.0F, 1.0F);
/* 16 */     brightnessValue = new FloatValue("NewNovoline-Brightness", 1.0F, 0.0F, 1.0F);
/* 17 */     waveSecondValue = new IntegerValue("NewNovoline-Seconds", 2, 1, 10);
/* 18 */     blur = new BoolValue("blur", false);
/* 19 */     Shadow = new BoolValue("Shadow", false);
/* 20 */     r = new IntegerValue("ClientRed", 0, 0, 255);
/* 21 */     b = new IntegerValue("ClientGreen", 255, 0, 255);
/* 22 */     g = new IntegerValue("ClientBlue", 255, 0, 255);
/* 23 */     r2 = new IntegerValue("ClientRed2", 255, 0, 255);
/* 24 */     b2 = new IntegerValue("ClientGreen2", 40, 0, 255);
/* 25 */     g2 = new IntegerValue("ClientBlue2", 255, 0, 255);
/* 26 */     gradientSpeed = new IntegerValue("DoubleColor-Speed", 100, 10, 1000); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\023\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\nR\021\020\013\032\0020\b¢\006\b\n\000\032\004\b\f\020\nR\021\020\r\032\0020\004¢\006\b\n\000\032\004\b\016\020\006R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022R\020\020\023\032\0020\0248\006X\004¢\006\002\n\000R\021\020\025\032\0020\b¢\006\b\n\000\032\004\b\026\020\nR\021\020\027\032\0020\b¢\006\b\n\000\032\004\b\030\020\nR\021\020\031\032\0020\b¢\006\b\n\000\032\004\b\032\020\nR\021\020\033\032\0020\b¢\006\b\n\000\032\004\b\034\020\nR\021\020\035\032\0020\b¢\006\b\n\000\032\004\b\036\020\nR\021\020\037\032\0020\b¢\006\b\n\000\032\004\b \020\nR\021\020!\032\0020\b¢\006\b\n\000\032\004\b\"\020\nR\021\020#\032\0020\020¢\006\b\n\000\032\004\b$\020\022R\021\020%\032\0020\b¢\006\b\n\000\032\004\b&\020\n¨\006'"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/color/VisualColor$Companion;", "", "()V", "Shadow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getShadow", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "b", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getB", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b2", "getB2", "blur", "getBlur", "brightnessValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getBrightnessValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "g", "getG", "g2", "getG2", "gradientDistanceValue", "getGradientDistanceValue", "gradientLoopValue", "getGradientLoopValue", "gradientSpeed", "getGradientSpeed", "r", "getR", "r2", "getR2", "saturationValue", "getSaturationValue", "waveSecondValue", "getWaveSecondValue", "XSJClient"}) public static final class Companion { private Companion() {} @NotNull public final IntegerValue getGradientDistanceValue() { return VisualColor.gradientDistanceValue; } @NotNull public final IntegerValue getGradientLoopValue() { return VisualColor.gradientLoopValue; } @NotNull public final IntegerValue getGradientSpeed() { return VisualColor.gradientSpeed; }
/*    */ 
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getSaturationValue() {
/*    */       return VisualColor.saturationValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getBrightnessValue() {
/*    */       return VisualColor.brightnessValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getWaveSecondValue() {
/*    */       return VisualColor.waveSecondValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final BoolValue getBlur() {
/*    */       return VisualColor.blur;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final BoolValue getShadow() {
/*    */       return VisualColor.Shadow;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getR() {
/*    */       return VisualColor.r;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getB() {
/*    */       return VisualColor.b;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getG() {
/*    */       return VisualColor.g;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getR2() {
/*    */       return VisualColor.r2;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getB2() {
/*    */       return VisualColor.b2;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getG2() {
/*    */       return VisualColor.g2;
/*    */     } }
/*    */    }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\color\VisualColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */