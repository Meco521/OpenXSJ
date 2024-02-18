/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "FastPlace", description = "Allows you to place blocks faster.", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/FastPlace;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onlyBlockValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getOnlyBlockValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "speedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getSpeedValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "XSJClient"})
/*    */ public final class FastPlace extends Module {
/*    */   @NotNull
/* 12 */   private final IntegerValue speedValue = new IntegerValue("Speed", 0, 0, 4); @NotNull public final IntegerValue getSpeedValue() { return this.speedValue; } @NotNull
/* 13 */   private final BoolValue onlyBlockValue = new BoolValue("OnlyBlock", true); @NotNull public final BoolValue getOnlyBlockValue() { return this.onlyBlockValue; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\FastPlace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */