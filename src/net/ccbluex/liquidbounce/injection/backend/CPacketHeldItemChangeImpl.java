/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ import net.minecraft.network.play.client.CPacketHeldItemChange;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketHeldItemChangeImpl;", "T", "Lnet/minecraft/network/play/client/CPacketHeldItemChange;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;", "wrapped", "(Lnet/minecraft/network/play/client/CPacketHeldItemChange;)V", "slotId", "", "getSlotId", "()I", "XSJClient"})
/*   */ public final class CPacketHeldItemChangeImpl<T extends CPacketHeldItemChange> extends PacketImpl<T> implements ICPacketHeldItemChange {
/*   */   public CPacketHeldItemChangeImpl(@NotNull CPacketHeldItemChange wrapped) {
/* 7 */     super((T)wrapped);
/*   */   } public int getSlotId() {
/* 9 */     return ((CPacketHeldItemChange)getWrapped()).func_149614_c();
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketHeldItemChangeImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */