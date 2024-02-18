/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.network.play.client.CPacketChatMessage;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\006\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\r¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketChatMessageImpl;", "T", "Lnet/minecraft/network/play/client/CPacketChatMessage;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketChatMessage;", "wrapped", "(Lnet/minecraft/network/play/client/CPacketChatMessage;)V", "value", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "XSJClient"})
/*    */ public final class CPacketChatMessageImpl<T extends CPacketChatMessage> extends PacketImpl<T> implements ICPacketChatMessage {
/*  7 */   public CPacketChatMessageImpl(@NotNull CPacketChatMessage wrapped) { super((T)wrapped); } @NotNull
/*    */   public String getMessage() {
/*  9 */     Intrinsics.checkExpressionValueIsNotNull(((CPacketChatMessage)getWrapped()).field_149440_a, "wrapped.message"); return ((CPacketChatMessage)getWrapped()).field_149440_a;
/*    */   } public void setMessage(@NotNull String value) {
/* 11 */     Intrinsics.checkParameterIsNotNull(value, "value"); ((CPacketChatMessage)getWrapped()).field_149440_a = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketChatMessageImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */