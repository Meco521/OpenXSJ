/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "EnchantEffect", description = "Change Sword Color", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\004\030\0010\004J\b\020\b\032\004\030\0010\004J\b\020\t\032\004\030\0010\006J\b\020\n\032\004\030\0010\004J\b\020\013\032\004\030\0010\004R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/EnchantEffect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "alphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "rainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getBlueValue", "getGreenValue", "getRainbow", "getRedValue", "getalphaValue", "XSJClient"})
/*    */ public final class EnchantEffect extends Module {
/* 12 */   private final IntegerValue alphaValue = new IntegerValue("Alpha", 255, 0, 255);
/* 13 */   private final BoolValue rainbow = new BoolValue("RainBow", false);
/*    */   @Nullable
/*    */   public final IntegerValue getRedValue() {
/* 16 */     return AColorPalette.r;
/*    */   }
/*    */   @Nullable
/*    */   public final BoolValue getRainbow() {
/* 20 */     return this.rainbow;
/*    */   }
/*    */   @Nullable
/*    */   public final IntegerValue getGreenValue() {
/* 24 */     return AColorPalette.g;
/*    */   }
/*    */   @Nullable
/*    */   public final IntegerValue getBlueValue() {
/* 28 */     return AColorPalette.b;
/*    */   }
/*    */   @Nullable
/*    */   public final IntegerValue getalphaValue() {
/* 32 */     return this.alphaValue;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\EnchantEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */