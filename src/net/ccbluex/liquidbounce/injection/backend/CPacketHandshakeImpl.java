/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.minecraft.network.handshake.client.C00Handshake;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\006\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR\024\020\016\032\0020\0178VX\004¢\006\006\032\004\b\020\020\021R\024\020\022\032\0020\0238VX\004¢\006\006\032\004\b\024\020\025¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketHandshakeImpl;", "T", "Lnet/minecraft/network/handshake/client/C00Handshake;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/handshake/client/ICPacketHandshake;", "wrapped", "(Lnet/minecraft/network/handshake/client/C00Handshake;)V", "value", "", "ip", "getIp", "()Ljava/lang/String;", "setIp", "(Ljava/lang/String;)V", "port", "", "getPort", "()I", "requestedState", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IEnumConnectionState;", "getRequestedState", "()Lnet/ccbluex/liquidbounce/api/minecraft/network/IEnumConnectionState;", "XSJClient"})
/*    */ public final class CPacketHandshakeImpl<T extends C00Handshake> extends PacketImpl<T> implements ICPacketHandshake {
/*    */   public CPacketHandshakeImpl(@NotNull C00Handshake wrapped) {
/*  8 */     super((T)wrapped);
/*    */   }
/* 10 */   public int getPort() { return ((C00Handshake)getWrapped()).field_149599_c; } @NotNull
/*    */   public String getIp() {
/* 12 */     Intrinsics.checkExpressionValueIsNotNull(((C00Handshake)getWrapped()).field_149598_b, "wrapped.ip"); return ((C00Handshake)getWrapped()).field_149598_b;
/*    */   } public void setIp(@NotNull String value) {
/* 14 */     Intrinsics.checkParameterIsNotNull(value, "value"); ((C00Handshake)getWrapped()).field_149598_b = value;
/*    */   } @NotNull
/*    */   public IEnumConnectionState getRequestedState() {
/* 17 */     Intrinsics.checkExpressionValueIsNotNull(((C00Handshake)getWrapped()).func_149594_c(), "wrapped.requestedState"); EnumConnectionState $this$wrap$iv = ((C00Handshake)getWrapped()).func_149594_c(); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 22 */       new EnumConnectionStateImpl($this$wrap$iv);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketHandshakeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */