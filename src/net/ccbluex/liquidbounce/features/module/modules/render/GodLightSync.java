/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "GodLightSync", description = "神光同步", category = ModuleCategory.RENDER, canEnable = false)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\r\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006R\021\020\r\032\0020\004¢\006\b\n\000\032\004\b\016\020\006R\021\020\017\032\0020\004¢\006\b\n\000\032\004\b\020\020\006¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/GodLightSync;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "b", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getB", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "b2", "getB2", "g", "getG", "g2", "getG2", "r", "getR", "r2", "getR2", "XSJClient"})
/*    */ public final class GodLightSync
/*    */   extends Module
/*    */ {
/*    */   @NotNull
/* 17 */   private final IntegerValue r = new IntegerValue("Red", 229, 0, 255); @NotNull public final IntegerValue getR() { return this.r; } @NotNull
/* 18 */   private final IntegerValue g = new IntegerValue("Green", 100, 0, 255); @NotNull public final IntegerValue getG() { return this.g; } @NotNull
/* 19 */   private final IntegerValue b = new IntegerValue("Blue", 173, 0, 255); @NotNull public final IntegerValue getB() { return this.b; }
/*    */    @NotNull
/* 21 */   private final IntegerValue r2 = new IntegerValue("Red2", 109, 0, 255); @NotNull public final IntegerValue getR2() { return this.r2; } @NotNull
/* 22 */   private final IntegerValue g2 = new IntegerValue("Green2", 255, 0, 255); @NotNull public final IntegerValue getG2() { return this.g2; } @NotNull
/* 23 */   private final IntegerValue b2 = new IntegerValue("Blue2", 255, 0, 255); @NotNull public final IntegerValue getB2() { return this.b2; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\GodLightSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */