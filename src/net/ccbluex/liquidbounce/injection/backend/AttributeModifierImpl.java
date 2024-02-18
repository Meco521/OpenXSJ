/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ 
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b\005\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/AttributeModifierImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier;", "wrapped", "Lnet/minecraft/entity/ai/attributes/AttributeModifier;", "(Lnet/minecraft/entity/ai/attributes/AttributeModifier;)V", "amount", "", "getAmount", "()D", "getWrapped", "()Lnet/minecraft/entity/ai/attributes/AttributeModifier;", "XSJClient"})
/*   */ public final class AttributeModifierImpl implements IAttributeModifier {
/* 6 */   public AttributeModifierImpl(@NotNull AttributeModifier wrapped) { this.wrapped = wrapped; } @NotNull private final AttributeModifier wrapped; @NotNull public final AttributeModifier getWrapped() { return this.wrapped; }
/*   */    public double getAmount() {
/* 8 */     return this.wrapped.func_111164_d();
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\AttributeModifierImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */