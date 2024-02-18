/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.minecraft.network.play.server.SPacketEntityVelocity;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\016\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR$\020\f\032\0020\b2\006\020\013\032\0020\b8V@VX\016¢\006\f\032\004\b\r\020\n\"\004\b\016\020\017R$\020\020\032\0020\b2\006\020\013\032\0020\b8V@VX\016¢\006\f\032\004\b\021\020\n\"\004\b\022\020\017R$\020\023\032\0020\b2\006\020\013\032\0020\b8V@VX\016¢\006\f\032\004\b\024\020\n\"\004\b\025\020\017¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SPacketEntityVelocityImpl;", "T", "Lnet/minecraft/network/play/server/SPacketEntityVelocity;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;", "wrapped", "(Lnet/minecraft/network/play/server/SPacketEntityVelocity;)V", "entityID", "", "getEntityID", "()I", "value", "motionX", "getMotionX", "setMotionX", "(I)V", "motionY", "getMotionY", "setMotionY", "motionZ", "getMotionZ", "setMotionZ", "XSJClient"})
/*    */ public final class SPacketEntityVelocityImpl<T extends SPacketEntityVelocity> extends PacketImpl<T> implements ISPacketEntityVelocity {
/*    */   public SPacketEntityVelocityImpl(@NotNull SPacketEntityVelocity wrapped) {
/*  7 */     super((T)wrapped);
/*    */   } public int getMotionX() {
/*  9 */     return ((SPacketEntityVelocity)getWrapped()).field_149415_b;
/*    */   } public void setMotionX(int value) {
/* 11 */     ((SPacketEntityVelocity)getWrapped()).field_149415_b = value;
/*    */   }
/*    */   public int getMotionY() {
/* 14 */     return ((SPacketEntityVelocity)getWrapped()).field_149416_c;
/*    */   } public void setMotionY(int value) {
/* 16 */     ((SPacketEntityVelocity)getWrapped()).field_149416_c = value;
/*    */   }
/*    */   public int getMotionZ() {
/* 19 */     return ((SPacketEntityVelocity)getWrapped()).field_149414_d;
/*    */   } public void setMotionZ(int value) {
/* 21 */     ((SPacketEntityVelocity)getWrapped()).field_149414_d = value;
/*    */   }
/*    */   public int getEntityID() {
/* 24 */     return ((SPacketEntityVelocity)getWrapped()).func_149412_c();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketEntityVelocityImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */