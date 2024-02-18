/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.minecraft.network.play.server.SPacketAnimation;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\005\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR\024\020\013\032\0020\b8VX\004¢\006\006\032\004\b\f\020\n¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SPacketAnimationImpl;", "T", "Lnet/minecraft/network/play/server/SPacketAnimation;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketAnimation;", "wrapped", "(Lnet/minecraft/network/play/server/SPacketAnimation;)V", "animationType", "", "getAnimationType", "()I", "entityID", "getEntityID", "XSJClient"})
/*    */ public final class SPacketAnimationImpl<T extends SPacketAnimation> extends PacketImpl<T> implements ISPacketAnimation {
/*    */   public SPacketAnimationImpl(@NotNull SPacketAnimation wrapped) {
/*  7 */     super((T)wrapped);
/*    */   } public int getAnimationType() {
/*  9 */     return ((SPacketAnimation)getWrapped()).func_148977_d();
/*    */   } public int getEntityID() {
/* 11 */     return ((SPacketAnimation)getWrapped()).func_148978_c();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketAnimationImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */