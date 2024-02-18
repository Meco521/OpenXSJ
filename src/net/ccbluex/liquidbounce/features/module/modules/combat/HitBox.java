/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "HitBox", description = "Makes hitboxes of targets bigger.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/HitBox;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "sizeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getSizeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "XSJClient"})
/*    */ public final class HitBox extends Module {
/*    */   @NotNull
/* 11 */   private final FloatValue sizeValue = new FloatValue("Size", 0.4F, 0.0F, 1.0F); @NotNull public final FloatValue getSizeValue() { return this.sizeValue; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\HitBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */