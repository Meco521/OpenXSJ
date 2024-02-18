/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "NoFOV", description = "Disables FOV changes caused by speed effect, etc.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/NoFOV;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "fovValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getFovValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "XSJClient"})
/*    */ public final class NoFOV extends Module {
/*    */   @NotNull
/* 10 */   private final FloatValue fovValue = new FloatValue("FOV", 1.0F, 0.0F, 1.5F); @NotNull public final FloatValue getFovValue() { return this.fovValue; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\NoFOV.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */