/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/enchantment/Enchantment;", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "wrap", "XSJClient"})
/*    */ public final class EnchantmentImplKt
/*    */ {
/*    */   @NotNull
/*    */   public static final Enchantment unwrap(@NotNull IEnchantment $this$unwrap) {
/* 15 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((EnchantmentImpl)$this$unwrap).getWrapped(); } @NotNull
/* 16 */   public static final IEnchantment wrap(@NotNull Enchantment $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new EnchantmentImpl($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\EnchantmentImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */