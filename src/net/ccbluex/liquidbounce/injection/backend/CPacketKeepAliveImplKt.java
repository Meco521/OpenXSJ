/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketKeepAlive;
/*    */ import net.minecraft.network.play.client.CPacketKeepAlive;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/network/play/client/CPacketKeepAlive;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketKeepAlive;", "wrap", "XSJClient"})
/*    */ public final class CPacketKeepAliveImplKt {
/*    */   @NotNull
/* 11 */   public static final CPacketKeepAlive unwrap(@NotNull ICPacketKeepAlive $this$unwrap) { int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((CPacketKeepAliveImpl<CPacketKeepAlive>)$this$unwrap).getWrapped(); } @NotNull
/* 12 */   public static final ICPacketKeepAlive wrap(@NotNull CPacketKeepAlive $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new CPacketKeepAliveImpl<>($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketKeepAliveImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */