/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketChatMessage;
/*    */ import net.minecraft.network.play.client.CPacketChatMessage;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\001H\b¨\006\004"}, d2 = {"unwrap", "Lnet/minecraft/network/play/client/CPacketChatMessage;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketChatMessage;", "wrap", "XSJClient"})
/*    */ public final class CPacketChatMessageImplKt
/*    */ {
/*    */   @NotNull
/*    */   public static final CPacketChatMessage unwrap(@NotNull ICPacketChatMessage $this$unwrap) {
/* 15 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return ((CPacketChatMessageImpl<CPacketChatMessage>)$this$unwrap).getWrapped(); } @NotNull
/* 16 */   public static final ICPacketChatMessage wrap(@NotNull CPacketChatMessage $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new CPacketChatMessageImpl<>($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketChatMessageImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */