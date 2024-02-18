/*    */ package tomk.module.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "GradientColor", description = "Custom your Target and Text GidentColor", category = ModuleCategory.RENDER, canEnable = true, array = false)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\r\n\002\030\002\n\002\b\013\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006R\021\020\r\032\0020\004¢\006\b\n\000\032\004\b\016\020\006R\021\020\017\032\0020\004¢\006\b\n\000\032\004\b\020\020\006R\021\020\021\032\0020\022¢\006\b\n\000\032\004\b\023\020\024R\021\020\025\032\0020\022¢\006\b\n\000\032\004\b\026\020\024R\021\020\027\032\0020\004¢\006\b\n\000\032\004\b\030\020\006R\021\020\031\032\0020\004¢\006\b\n\000\032\004\b\032\020\006R\021\020\033\032\0020\004¢\006\b\n\000\032\004\b\034\020\006¨\006\035"}, d2 = {"Ltomk/module/render/GradientColor;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Alpha", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getAlpha", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "Alpha1", "getAlpha1", "Alpha2", "getAlpha2", "Alpha3", "getAlpha3", "RainbowDistance", "getRainbowDistance", "SecValue", "getSecValue", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getColorModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "colormode", "getColormode", "distanceValue", "getDistanceValue", "gradientAmountValue", "getGradientAmountValue", "speed", "getSpeed", "XSJClient"})
/*    */ public final class GradientColor extends Module {
/* 10 */   static { GradientColor gradientColor = new GradientColor(); } @NotNull
/* 11 */   private static final ListValue colorModeValue = new ListValue("ColorStyle", new String[] { "Rainbow", "ColorMixer" }, "ColorMixer"); @NotNull public final ListValue getColorModeValue() { return colorModeValue; } @NotNull
/* 12 */   private static final ListValue colormode = new ListValue("MixerChange", new String[] { "Blue&Purple", "Purple&Gold", "PurpleBlue", "Flux", "Blue&Gold", "Tenacity", "Orange", "Custom" }, "Custom"); @NotNull public final ListValue getColormode() { return colormode; } @NotNull
/* 13 */   private static final IntegerValue gradientAmountValue = new IntegerValue("Gradient-Amount", 30, 1, 50); @NotNull public final IntegerValue getGradientAmountValue() { return gradientAmountValue; } @NotNull
/* 14 */   private static final IntegerValue SecValue = new IntegerValue("Seconds", 2, 1, 10); @NotNull public final IntegerValue getSecValue() { return SecValue; } @NotNull
/* 15 */   private static final IntegerValue distanceValue = new IntegerValue("Line-Distance", 100, 0, 200); @NotNull public final IntegerValue getDistanceValue() { return distanceValue; } @NotNull
/* 16 */   private static final IntegerValue RainbowDistance = new IntegerValue("Rainbow-Distance", 10, 1, 90); @NotNull public final IntegerValue getRainbowDistance() { return RainbowDistance; } @NotNull
/* 17 */   private static final IntegerValue Alpha = new IntegerValue("Text-Alpha", 20, 0, 255); @NotNull public final IntegerValue getAlpha() { return Alpha; } @NotNull
/* 18 */   private static final IntegerValue Alpha1 = new IntegerValue("SessionInfo-Alpha", 20, 0, 255); @NotNull public final IntegerValue getAlpha1() { return Alpha1; } @NotNull
/* 19 */   private static final IntegerValue Alpha2 = new IntegerValue("Scoreboard-Alpha", 60, 0, 255); @NotNull public final IntegerValue getAlpha2() { return Alpha2; } @NotNull
/* 20 */   private static final IntegerValue Alpha3 = new IntegerValue("KeyStateShow-Alpha", 40, 0, 255); @NotNull public final IntegerValue getAlpha3() { return Alpha3; } @NotNull
/* 21 */   private static final IntegerValue speed = new IntegerValue("HotbarSpeed", 0, 0, 400); public static final GradientColor INSTANCE; @NotNull public final IntegerValue getSpeed() { return speed; }
/*    */    static {
/* 23 */     gradientColor.setState(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\GradientColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */