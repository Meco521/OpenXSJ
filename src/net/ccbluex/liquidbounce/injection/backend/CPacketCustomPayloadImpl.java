/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.network.IPacketBuffer;
/*    */ import net.minecraft.network.play.client.CPacketCustomPayload;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\006\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR$\020\r\032\0020\f2\006\020\013\032\0020\f8V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketCustomPayloadImpl;", "T", "Lnet/minecraft/network/play/client/CPacketCustomPayload;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCustomPayload;", "wrapped", "(Lnet/minecraft/network/play/client/CPacketCustomPayload;)V", "channelName", "", "getChannelName", "()Ljava/lang/String;", "value", "Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "data", "getData", "()Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "setData", "(Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;)V", "XSJClient"})
/*    */ public final class CPacketCustomPayloadImpl<T extends CPacketCustomPayload> extends PacketImpl<T> implements ICPacketCustomPayload {
/*  8 */   public CPacketCustomPayloadImpl(@NotNull CPacketCustomPayload wrapped) { super((T)wrapped); }
/*    */   @NotNull
/* 10 */   public IPacketBuffer getData() { Intrinsics.checkExpressionValueIsNotNull(((CPacketCustomPayload)getWrapped()).field_149561_c, "wrapped.data"); PacketBuffer $this$wrap$iv = ((CPacketCustomPayload)getWrapped()).field_149561_c; int $i$f$wrap = 0; return 
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
/* 21 */       new PacketBufferImpl($this$wrap$iv); } public void setData(@NotNull IPacketBuffer value) { Intrinsics.checkParameterIsNotNull(value, "value"); IPacketBuffer iPacketBuffer = value; CPacketCustomPayload cPacketCustomPayload = (CPacketCustomPayload)getWrapped(); int $i$f$unwrap = 0;
/* 22 */     PacketBuffer packetBuffer = ((PacketBufferImpl)iPacketBuffer).getWrapped(); }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getChannelName() {
/*    */     Intrinsics.checkExpressionValueIsNotNull(((CPacketCustomPayload)getWrapped()).func_149559_c(), "wrapped.channelName");
/*    */     return ((CPacketCustomPayload)getWrapped()).func_149559_c();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketCustomPayloadImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */