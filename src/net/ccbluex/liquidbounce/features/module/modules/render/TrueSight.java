/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "TrueSight", description = "Allows you to see invisible entities and barriers.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/TrueSight;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "barriersValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getBarriersValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "entitiesValue", "getEntitiesValue", "XSJClient"})
/*    */ public final class TrueSight extends Module {
/*    */   @NotNull
/* 10 */   private final BoolValue barriersValue = new BoolValue("Barriers", true); @NotNull public final BoolValue getBarriersValue() { return this.barriersValue; } @NotNull
/* 11 */   private final BoolValue entitiesValue = new BoolValue("Entities", true); @NotNull public final BoolValue getEntitiesValue() { return this.entitiesValue; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\TrueSight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */