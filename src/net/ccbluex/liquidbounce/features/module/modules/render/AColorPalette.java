/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;@ModuleInfo(name = "AColorPalette", description = "调色板", category = ModuleCategory.RENDER, canEnable = false) @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\003\b\007\030\000 \0032\0020\001:\001\003B\005¢\006\002\020\002¨\006\004"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/AColorPalette;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Companion", "XSJClient"}) public final class AColorPalette extends Module { @JvmField @NotNull public static final ListValue colorModeValue; @JvmField @NotNull public static final IntegerValue r; @JvmField @NotNull public static final IntegerValue g; @JvmField @NotNull public static final IntegerValue b; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue r2; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue g2; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue b2; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue r3; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue g3; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue b3; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue RA; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue GA; @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue BA; @JvmField
/*    */   @NotNull
/* 21 */   public static final IntegerValue RA2; public static final Companion Companion = new Companion(null); @JvmField @NotNull public static final IntegerValue GA2; @JvmField @NotNull public static final IntegerValue BA2; @JvmField @NotNull public static final IntegerValue a; @NotNull private static final IntegerValue a2; @NotNull private static final FloatValue ra; @NotNull private static final FloatValue line; @NotNull private static final FloatValue office; @NotNull private static final FloatValue radius; @NotNull private static final IntegerValue gradientLoopValue; @NotNull private static final IntegerValue gradientDistanceValue; @NotNull private static final FloatValue saturationValue; @NotNull private static final FloatValue brightnessValue; @NotNull private static final IntegerValue waveSecondValue; @JvmField @NotNull public static final IntegerValue gradientSpeed; static { colorModeValue = new ListValue("Novo-Line-Color", new String[] { "Custom", "Rainbow", "Gident", "Sky", "Slowly", "Fade", "Health" }, "Gident");
/*    */     
/* 23 */     r = new IntegerValue("Red", 255, 0, 255);
/*    */     
/* 25 */     g = new IntegerValue("Green", 255, 0, 255);
/*    */     
/* 27 */     b = new IntegerValue("Blue", 255, 0, 255);
/*    */     
/* 29 */     r2 = new IntegerValue("Red2", 255, 0, 255);
/*    */     
/* 31 */     g2 = new IntegerValue("Green2", 255, 0, 255);
/*    */     
/* 33 */     b2 = new IntegerValue("Blue2", 255, 0, 255);
/*    */     
/* 35 */     r3 = new IntegerValue("Red3", 255, 0, 255);
/*    */     
/* 37 */     g3 = new IntegerValue("Green3", 255, 0, 255);
/*    */     
/* 39 */     b3 = new IntegerValue("Blue3", 255, 0, 255);
/*    */     
/* 41 */     RA = new IntegerValue("GuiRed", 105, 0, 255);
/*    */     
/* 43 */     GA = new IntegerValue("GuiGreen", 25, 0, 255);
/*    */     
/* 45 */     BA = new IntegerValue("GuiBlue", 255, 0, 255);
/*    */     
/* 47 */     RA2 = new IntegerValue("GuiRed2", 255, 0, 255);
/*    */     
/* 49 */     GA2 = new IntegerValue("GuiGreen2", 55, 0, 255);
/*    */     
/* 51 */     BA2 = new IntegerValue("GuiBlue2", 255, 0, 255);
/*    */     
/* 53 */     a = new IntegerValue("A", 100, 0, 255);
/* 54 */     a2 = new IntegerValue("A2", 100, 0, 255);
/* 55 */     ra = new FloatValue("Radius", 6.44F, 0.1F, 10.0F);
/* 56 */     line = new FloatValue("Line", 2.0F, 0.0F, 5.0F);
/* 57 */     office = new FloatValue("Office", 3.0F, 0.0F, 5.0F);
/* 58 */     radius = new FloatValue("radius", 3.0F, 0.0F, 10.0F);
/* 59 */     gradientLoopValue = new IntegerValue("NewNovoline-GradientLoop", 7, 1, 40);
/* 60 */     gradientDistanceValue = new IntegerValue("NewNovoline-GradientDistance", 56, 1, 200);
/* 61 */     saturationValue = new FloatValue("NewNovoline-Saturation", 1.0F, 0.0F, 1.0F);
/* 62 */     brightnessValue = new FloatValue("NewNovoline-Brightness", 1.0F, 0.0F, 1.0F);
/* 63 */     waveSecondValue = new IntegerValue("NewNovoline-Seconds", 2, 1, 10);
/*    */     
/* 65 */     gradientSpeed = new IntegerValue("ColorSpeed", 100, 10, 1000); }
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\r\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\030\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\020\020\005\032\0020\0048\006X\004¢\006\002\n\000R\020\020\006\032\0020\0048\006X\004¢\006\002\n\000R\020\020\007\032\0020\0048\006X\004¢\006\002\n\000R\020\020\b\032\0020\0048\006X\004¢\006\002\n\000R\020\020\t\032\0020\0048\006X\004¢\006\002\n\000R\020\020\n\032\0020\0048\006X\004¢\006\002\n\000R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\rR\020\020\016\032\0020\0048\006X\004¢\006\002\n\000R\020\020\017\032\0020\0048\006X\004¢\006\002\n\000R\020\020\020\032\0020\0048\006X\004¢\006\002\n\000R\021\020\021\032\0020\022¢\006\b\n\000\032\004\b\023\020\024R\020\020\025\032\0020\0268\006X\004¢\006\002\n\000R\020\020\027\032\0020\0048\006X\004¢\006\002\n\000R\020\020\030\032\0020\0048\006X\004¢\006\002\n\000R\020\020\031\032\0020\0048\006X\004¢\006\002\n\000R\021\020\032\032\0020\004¢\006\b\n\000\032\004\b\033\020\rR\021\020\034\032\0020\004¢\006\b\n\000\032\004\b\035\020\rR\020\020\036\032\0020\0048\006X\004¢\006\002\n\000R\021\020\037\032\0020\022¢\006\b\n\000\032\004\b \020\024R\021\020!\032\0020\022¢\006\b\n\000\032\004\b\"\020\024R\020\020#\032\0020\0048\006X\004¢\006\002\n\000R\020\020$\032\0020\0048\006X\004¢\006\002\n\000R\020\020%\032\0020\0048\006X\004¢\006\002\n\000R\021\020&\032\0020\022¢\006\b\n\000\032\004\b'\020\024R\021\020(\032\0020\022¢\006\b\n\000\032\004\b)\020\024R\021\020*\032\0020\022¢\006\b\n\000\032\004\b+\020\024R\021\020,\032\0020\004¢\006\b\n\000\032\004\b-\020\r¨\006."}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/AColorPalette$Companion;", "", "()V", "BA", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "BA2", "GA", "GA2", "RA", "RA2", "a", "a2", "getA2", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b", "b2", "b3", "brightnessValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getBrightnessValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "g", "g2", "g3", "gradientDistanceValue", "getGradientDistanceValue", "gradientLoopValue", "getGradientLoopValue", "gradientSpeed", "line", "getLine", "office", "getOffice", "r", "r2", "r3", "ra", "getRa", "radius", "getRadius", "saturationValue", "getSaturationValue", "waveSecondValue", "getWaveSecondValue", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {}
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getA2() {
/*    */       return AColorPalette.a2;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getRa() {
/*    */       return AColorPalette.ra;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getLine() {
/*    */       return AColorPalette.line;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getOffice() {
/*    */       return AColorPalette.office;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getRadius() {
/*    */       return AColorPalette.radius;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getGradientLoopValue() {
/*    */       return AColorPalette.gradientLoopValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getGradientDistanceValue() {
/*    */       return AColorPalette.gradientDistanceValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getSaturationValue() {
/*    */       return AColorPalette.saturationValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final FloatValue getBrightnessValue() {
/*    */       return AColorPalette.brightnessValue;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final IntegerValue getWaveSecondValue() {
/*    */       return AColorPalette.waveSecondValue;
/*    */     }
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\AColorPalette.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */