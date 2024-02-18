/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketEntityVelocity;
/*    */ import net.minecraft.network.play.server.SPacketEntityVelocity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/network/play/server/SPacketEntityVelocity;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;", "wrap", "XSJClient"})
/*    */ public final class SPacketEntityVelocityImplKt
/*    */ {
/*    */   @NotNull
/*    */   public static final SPacketEntityVelocity unwrap(@NotNull ISPacketEntityVelocity $this$unwrap) {
/* 28 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((SPacketEntityVelocityImpl<SPacketEntityVelocity>)$this$unwrap).getWrapped(); } @NotNull
/* 29 */   public static final ISPacketEntityVelocity wrap(@NotNull SPacketEntityVelocity $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new SPacketEntityVelocityImpl<>($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketEntityVelocityImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */