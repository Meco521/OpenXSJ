/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\016\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\022H\002J\b\020\023\032\0020\024H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\0068VX\004¢\006\006\032\004\b\n\020\bR\024\020\013\032\0020\0068VX\004¢\006\006\032\004\b\f\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/PotionEffectImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "wrapped", "Lnet/minecraft/potion/PotionEffect;", "(Lnet/minecraft/potion/PotionEffect;)V", "amplifier", "", "getAmplifier", "()I", "duration", "getDuration", "potionID", "getPotionID", "getWrapped", "()Lnet/minecraft/potion/PotionEffect;", "equals", "", "other", "", "getDurationString", "", "XSJClient"})
/*    */ public final class PotionEffectImpl implements IPotionEffect {
/*    */   @NotNull
/*  8 */   public final PotionEffect getWrapped() { return this.wrapped; } @NotNull private final PotionEffect wrapped; public PotionEffectImpl(@NotNull PotionEffect wrapped) { this.wrapped = wrapped; } @NotNull
/*  9 */   public String getDurationString() { Intrinsics.checkExpressionValueIsNotNull(Potion.func_188410_a(this.wrapped, 1.0F), "Potion.getPotionDurationString(wrapped, 1.0f)"); return Potion.func_188410_a(this.wrapped, 1.0F); }
/*    */   
/*    */   public int getAmplifier() {
/* 12 */     return this.wrapped.func_76458_c();
/*    */   } public int getDuration() {
/* 14 */     return this.wrapped.func_76459_b();
/*    */   } public int getPotionID() {
/* 16 */     return Potion.func_188409_a(this.wrapped.func_188419_a());
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 19 */     return (other instanceof PotionEffectImpl && Intrinsics.areEqual(((PotionEffectImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\PotionEffectImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */