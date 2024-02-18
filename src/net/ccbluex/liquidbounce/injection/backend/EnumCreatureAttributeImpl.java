/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.entity.EnumCreatureAttribute;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/EnumCreatureAttributeImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "wrapped", "Lnet/minecraft/entity/EnumCreatureAttribute;", "(Lnet/minecraft/entity/EnumCreatureAttribute;)V", "getWrapped", "()Lnet/minecraft/entity/EnumCreatureAttribute;", "equals", "", "other", "", "XSJClient"})
/*    */ public final class EnumCreatureAttributeImpl implements IEnumCreatureAttribute {
/*  7 */   public EnumCreatureAttributeImpl(@NotNull EnumCreatureAttribute wrapped) { this.wrapped = wrapped; } @NotNull private final EnumCreatureAttribute wrapped; @NotNull public final EnumCreatureAttribute getWrapped() { return this.wrapped; }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/* 10 */     return (other instanceof EnumCreatureAttributeImpl && ((EnumCreatureAttributeImpl)other).wrapped == this.wrapped);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EnumCreatureAttributeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */