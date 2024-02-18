/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\022\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\002*\0020\004H\b¨\006\005"}, d2 = {"unwrap", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "wrap", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "XSJClient"})
/*    */ public final class INetHandlerPlayClientImplKt
/*    */ {
/*    */   @NotNull
/*    */   public static final INetHandlerPlayClient unwrap(@NotNull IINetHandlerPlayClient $this$unwrap) {
/* 29 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return (INetHandlerPlayClient)((INetHandlerPlayClientImpl)$this$unwrap).getWrapped(); } @NotNull
/* 30 */   public static final IINetHandlerPlayClient wrap(@NotNull NetHandlerPlayClient $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new INetHandlerPlayClientImpl($this$wrap); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\INetHandlerPlayClientImplKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */