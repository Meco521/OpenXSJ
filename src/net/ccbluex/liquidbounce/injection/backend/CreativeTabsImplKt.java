/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.creativetabs.ICreativeTabs;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/creativetab/CreativeTabs;", "Lnet/ccbluex/liquidbounce/api/minecraft/creativetabs/ICreativeTabs;", "wrap", "XSJClient"})
/*    */ public final class CreativeTabsImplKt
/*    */ {
/*    */   @NotNull
/*    */   public static final CreativeTabs unwrap(@NotNull ICreativeTabs $this$unwrap) {
/* 19 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((CreativeTabsImpl)$this$unwrap).getWrapped(); } @NotNull
/* 20 */   public static final ICreativeTabs wrap(@NotNull CreativeTabs $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new CreativeTabsImpl($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CreativeTabsImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */