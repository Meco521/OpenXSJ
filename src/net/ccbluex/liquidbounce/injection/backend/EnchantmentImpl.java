/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020\016\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\013\032\0020\f2\006\020\r\032\0020\006H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EnchantmentImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "wrapped", "Lnet/minecraft/enchantment/Enchantment;", "(Lnet/minecraft/enchantment/Enchantment;)V", "effectId", "", "getEffectId", "()I", "getWrapped", "()Lnet/minecraft/enchantment/Enchantment;", "getTranslatedName", "", "level", "XSJClient"})
/*    */ public final class EnchantmentImpl implements IEnchantment {
/*    */   @NotNull
/*  7 */   public final Enchantment getWrapped() { return this.wrapped; } @NotNull private final Enchantment wrapped; public EnchantmentImpl(@NotNull Enchantment wrapped) { this.wrapped = wrapped; }
/*    */   
/*  9 */   public int getEffectId() { return Enchantment.func_185258_b(this.wrapped); } @NotNull
/*    */   public String getTranslatedName(int level) {
/* 11 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_77316_c(level), "wrapped.getTranslatedName(level)"); return this.wrapped.func_77316_c(level);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EnchantmentImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */