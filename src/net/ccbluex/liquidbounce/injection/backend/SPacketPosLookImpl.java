/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.minecraft.network.play.server.SPacketPlayerPosLook;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\t\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR$\020\016\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\017\020\013\"\004\b\020\020\r¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SPacketPosLookImpl;", "T", "Lnet/minecraft/network/play/server/SPacketPlayerPosLook;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketPosLook;", "wrapped", "(Lnet/minecraft/network/play/server/SPacketPlayerPosLook;)V", "value", "", "pitch", "getPitch", "()F", "setPitch", "(F)V", "yaw", "getYaw", "setYaw", "XSJClient"})
/*    */ public final class SPacketPosLookImpl<T extends SPacketPlayerPosLook> extends PacketImpl<T> implements ISPacketPosLook {
/*    */   public SPacketPosLookImpl(@NotNull SPacketPlayerPosLook wrapped) {
/*  7 */     super((T)wrapped);
/*    */   } public float getYaw() {
/*  9 */     return ((SPacketPlayerPosLook)getWrapped()).field_148936_d;
/*    */   } public void setYaw(float value) {
/* 11 */     ((SPacketPlayerPosLook)getWrapped()).field_148936_d = value;
/*    */   }
/*    */   public float getPitch() {
/* 14 */     return ((SPacketPlayerPosLook)getWrapped()).field_148937_e;
/*    */   } public void setPitch(float value) {
/* 16 */     ((SPacketPlayerPosLook)getWrapped()).field_148937_e = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketPosLookImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */