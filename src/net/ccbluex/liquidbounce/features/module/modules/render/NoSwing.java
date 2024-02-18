/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NoSwing", description = "Disabled swing effect when hitting an entity/mining a block.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/NoSwing;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "serverSideValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getServerSideValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "XSJClient"})
/*    */ public final class NoSwing extends Module {
/*    */   @NotNull
/* 10 */   private final BoolValue serverSideValue = new BoolValue("ServerSide", true); @NotNull public final BoolValue getServerSideValue() { return this.serverSideValue; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\NoSwing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */