/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*    */ import net.minecraft.network.play.client.CPacketUseEntity;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketUseEntityImpl;", "T", "Lnet/minecraft/network/play/client/CPacketUseEntity;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;", "wrapped", "(Lnet/minecraft/network/play/client/CPacketUseEntity;)V", "action", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "getAction", "()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "XSJClient"})
/*    */ public final class CPacketUseEntityImpl<T extends CPacketUseEntity> extends PacketImpl<T> implements ICPacketUseEntity {
/*  8 */   public CPacketUseEntityImpl(@NotNull CPacketUseEntity wrapped) { super((T)wrapped); } @NotNull
/*    */   public ICPacketUseEntity.WAction getAction() {
/* 10 */     Intrinsics.checkExpressionValueIsNotNull(((CPacketUseEntity)getWrapped()).func_149565_c(), "wrapped.action"); CPacketUseEntity.Action $this$wrap$iv = ((CPacketUseEntity)getWrapped()).func_149565_c(); int $i$f$wrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 15 */     switch (BackendExtentionsKt.WhenMappings.$EnumSwitchMapping$7[$this$wrap$iv.ordinal()]) { case 1: 
/*    */       case 2: 
/*    */       case 3:
/* 18 */        }  throw new NoWhenBranchMatchedException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketUseEntityImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */