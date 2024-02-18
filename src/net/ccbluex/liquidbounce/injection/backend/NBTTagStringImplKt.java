/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagString;
/*    */ import net.minecraft.nbt.NBTTagString;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/nbt/NBTTagString;", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagString;", "wrap", "XSJClient"})
/*    */ public final class NBTTagStringImplKt {
/*    */   @NotNull
/*  9 */   public static final NBTTagString unwrap(@NotNull INBTTagString $this$unwrap) { int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((NBTTagStringImpl<NBTTagString>)$this$unwrap).getWrapped(); } @NotNull
/* 10 */   public static final INBTTagString wrap(@NotNull NBTTagString $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new NBTTagStringImpl<>($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\NBTTagStringImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */