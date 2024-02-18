/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "视觉坐标助手", description = "RenderPosHelperSpoofs your ping to a given value.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\021\b\007\030\0002\0020\001B\005¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\004X\016¢\006\016\n\000\032\004\b\r\020\006\"\004\b\016\020\bR\032\020\017\032\0020\004X\016¢\006\016\n\000\032\004\b\020\020\006\"\004\b\021\020\bR\032\020\022\032\0020\004X\016¢\006\016\n\000\032\004\b\023\020\006\"\004\b\024\020\b¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/RenderPosHelper;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "x1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getX1", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "setX1", "(Lnet/ccbluex/liquidbounce/value/FloatValue;)V", "x2", "getX2", "setX2", "x3", "getX3", "setX3", "x4", "getX4", "setX4", "x5", "getX5", "setX5", "XSJClient"})
/*    */ public final class RenderPosHelper
/*    */   extends Module
/*    */ {
/*    */   @NotNull
/* 33 */   private FloatValue x1 = new FloatValue("x1", 2.0F, 0.0F, 100.0F); @NotNull public final FloatValue getX1() { return this.x1; } public final void setX1(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.x1 = <set-?>; } @NotNull
/* 34 */   private FloatValue x2 = new FloatValue("x2", 2.0F, 0.0F, 100.0F); @NotNull public final FloatValue getX2() { return this.x2; } public final void setX2(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.x2 = <set-?>; } @NotNull
/* 35 */   private FloatValue x3 = new FloatValue("x3", 2.0F, 0.0F, 5.0F); @NotNull public final FloatValue getX3() { return this.x3; } public final void setX3(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.x3 = <set-?>; } @NotNull
/* 36 */   private FloatValue x4 = new FloatValue("x4", 2.0F, 0.0F, 100.0F); @NotNull public final FloatValue getX4() { return this.x4; } public final void setX4(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.x4 = <set-?>; } @NotNull
/* 37 */   private FloatValue x5 = new FloatValue("x5", 2.0F, 1.0F, 10.0F); @NotNull public final FloatValue getX5() { return this.x5; } public final void setX5(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.x5 = <set-?>; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\RenderPosHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */