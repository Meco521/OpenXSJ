/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Chams", description = "Allows you to see targets through blocks.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Chams;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "chestsValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getChestsValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "itemsValue", "getItemsValue", "targetsValue", "getTargetsValue", "XSJClient"})
/*    */ public final class Chams extends Module {
/*    */   @NotNull
/* 10 */   private final BoolValue targetsValue = new BoolValue("Targets", true); @NotNull public final BoolValue getTargetsValue() { return this.targetsValue; } @NotNull
/* 11 */   private final BoolValue chestsValue = new BoolValue("Chests", true); @NotNull public final BoolValue getChestsValue() { return this.chestsValue; } @NotNull
/* 12 */   private final BoolValue itemsValue = new BoolValue("Items", true); @NotNull public final BoolValue getItemsValue() { return this.itemsValue; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Chams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */