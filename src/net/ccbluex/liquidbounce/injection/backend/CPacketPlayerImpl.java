/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.minecraft.network.play.client.CPacketPlayer;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\005\n\002\020\007\n\002\b\b\n\002\020\006\n\002\b\017\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR$\020\017\032\0020\0162\006\020\007\032\0020\0168V@VX\016¢\006\f\032\004\b\020\020\021\"\004\b\022\020\023R$\020\024\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\025\020\013\"\004\b\026\020\rR$\020\030\032\0020\0272\006\020\007\032\0020\0278V@VX\016¢\006\f\032\004\b\031\020\032\"\004\b\033\020\034R$\020\035\032\0020\0272\006\020\007\032\0020\0278V@VX\016¢\006\f\032\004\b\036\020\032\"\004\b\037\020\034R$\020 \032\0020\0162\006\020\007\032\0020\0168V@VX\016¢\006\f\032\004\b!\020\021\"\004\b\"\020\023R$\020#\032\0020\0272\006\020\007\032\0020\0278V@VX\016¢\006\f\032\004\b$\020\032\"\004\b%\020\034¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketPlayerImpl;", "T", "Lnet/minecraft/network/play/client/CPacketPlayer;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "wrapped", "(Lnet/minecraft/network/play/client/CPacketPlayer;)V", "value", "", "onGround", "getOnGround", "()Z", "setOnGround", "(Z)V", "", "pitch", "getPitch", "()F", "setPitch", "(F)V", "rotating", "getRotating", "setRotating", "", "x", "getX", "()D", "setX", "(D)V", "y", "getY", "setY", "yaw", "getYaw", "setYaw", "z", "getZ", "setZ", "XSJClient"})
/*    */ public final class CPacketPlayerImpl<T extends CPacketPlayer> extends PacketImpl<T> implements ICPacketPlayer {
/*    */   public CPacketPlayerImpl(@NotNull CPacketPlayer wrapped) {
/*  7 */     super((T)wrapped);
/*    */   } public double getX() {
/*  9 */     return ((CPacketPlayer)getWrapped()).field_149479_a;
/*    */   } public void setX(double value) {
/* 11 */     ((CPacketPlayer)getWrapped()).field_149479_a = value;
/*    */   }
/*    */   public double getY() {
/* 14 */     return ((CPacketPlayer)getWrapped()).field_149477_b;
/*    */   } public void setY(double value) {
/* 16 */     ((CPacketPlayer)getWrapped()).field_149477_b = value;
/*    */   }
/*    */   public double getZ() {
/* 19 */     return ((CPacketPlayer)getWrapped()).field_149478_c;
/*    */   } public void setZ(double value) {
/* 21 */     ((CPacketPlayer)getWrapped()).field_149478_c = value;
/*    */   }
/*    */   public float getYaw() {
/* 24 */     return ((CPacketPlayer)getWrapped()).field_149476_e;
/*    */   } public void setYaw(float value) {
/* 26 */     ((CPacketPlayer)getWrapped()).field_149476_e = value;
/*    */   }
/*    */   public float getPitch() {
/* 29 */     return ((CPacketPlayer)getWrapped()).field_149473_f;
/*    */   } public void setPitch(float value) {
/* 31 */     ((CPacketPlayer)getWrapped()).field_149473_f = value;
/*    */   }
/*    */   public boolean getOnGround() {
/* 34 */     return ((CPacketPlayer)getWrapped()).field_149474_g;
/*    */   } public void setOnGround(boolean value) {
/* 36 */     ((CPacketPlayer)getWrapped()).field_149474_g = value;
/*    */   }
/*    */   public boolean getRotating() {
/* 39 */     return ((CPacketPlayer)getWrapped()).field_149481_i;
/*    */   } public void setRotating(boolean value) {
/* 41 */     ((CPacketPlayer)getWrapped()).field_149481_i = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketPlayerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */