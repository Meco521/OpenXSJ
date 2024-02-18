/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "PictureColor", description = "全局颜色1", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/PictureColor;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorBlueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getColorBlueValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorGreenValue", "getColorGreenValue", "colorRedValue", "getColorRedValue", "coloralpha", "getColoralpha", "XSJClient"})
/*    */ public final class PictureColor extends Module {
/*    */   @NotNull
/* 11 */   private final IntegerValue colorRedValue = new IntegerValue("R", 0, 0, 255); @NotNull public final IntegerValue getColorRedValue() { return this.colorRedValue; } @NotNull
/* 12 */   private final IntegerValue colorGreenValue = new IntegerValue("G", 0, 0, 255); @NotNull public final IntegerValue getColorGreenValue() { return this.colorGreenValue; } @NotNull
/* 13 */   private final IntegerValue colorBlueValue = new IntegerValue("B", 0, 0, 255); @NotNull public final IntegerValue getColorBlueValue() { return this.colorBlueValue; } @NotNull
/* 14 */   private final IntegerValue coloralpha = new IntegerValue("alpha", 255, 0, 255); @NotNull public final IntegerValue getColoralpha() { return this.coloralpha; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\PictureColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */