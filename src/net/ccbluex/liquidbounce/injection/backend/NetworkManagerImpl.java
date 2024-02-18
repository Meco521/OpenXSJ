/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002J\020\020\017\032\0020\b2\006\020\020\032\0020\021H\026J\036\020\017\032\0020\b2\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\0020\b0\023H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/NetworkManagerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/INetworkManager;", "wrapped", "Lnet/minecraft/network/NetworkManager;", "(Lnet/minecraft/network/NetworkManager;)V", "getWrapped", "()Lnet/minecraft/network/NetworkManager;", "enableEncryption", "", "secretKey", "Ljavax/crypto/SecretKey;", "equals", "", "other", "", "sendPacket", "packet", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "listener", "Lkotlin/Function0;", "XSJClient"})
/*    */ public final class NetworkManagerImpl implements INetworkManager {
/*    */   @NotNull
/* 10 */   public final NetworkManager getWrapped() { return this.wrapped; } @NotNull private final NetworkManager wrapped; public NetworkManagerImpl(@NotNull NetworkManager wrapped) { this.wrapped = wrapped; }
/* 11 */   public void sendPacket(@NotNull IPacket packet) { Intrinsics.checkParameterIsNotNull(packet, "packet"); IPacket iPacket = packet; NetworkManager networkManager = this.wrapped; int $i$f$unwrap = 0;
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
/* 24 */     Packet packet1 = (Packet)((PacketImpl<Object>)iPacket).getWrapped(); networkManager.func_179290_a(packet1); } public void sendPacket(@NotNull IPacket packet, @NotNull Function0 listener) { Intrinsics.checkParameterIsNotNull(packet, "packet"); Intrinsics.checkParameterIsNotNull(listener, "listener"); IPacket iPacket = packet; NetworkManager networkManager = this.wrapped; int $i$f$unwrap = 0;
/* 25 */     Packet packet1 = (Packet)((PacketImpl<Object>)iPacket).getWrapped(); networkManager.func_179288_a(packet1, new NetworkManagerImpl$sendPacket$1<>(listener), new GenericFutureListener[0]); }
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\024\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\020\000\032\0020\0012.\020\002\032*\022\016\b\000\022\n \005*\004\030\0010\0040\004 \005*\024\022\016\b\000\022\n \005*\004\030\0010\0040\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "it", "Lio/netty/util/concurrent/Future;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "operationComplete"})
/*    */   static final class NetworkManagerImpl$sendPacket$1<F extends Future<?>> implements GenericFutureListener<Future<? super Void>> {
/*    */     public final void operationComplete(Future it) {
/*    */       this.$listener.invoke();
/*    */     }
/*    */     
/*    */     NetworkManagerImpl$sendPacket$1(Function0 param1Function0) {}
/*    */   }
/*    */   
/*    */   public void enableEncryption(@NotNull SecretKey secretKey) {
/*    */     Intrinsics.checkParameterIsNotNull(secretKey, "secretKey");
/*    */     this.wrapped.func_150727_a(secretKey);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof NetworkManagerImpl && Intrinsics.areEqual(((NetworkManagerImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\NetworkManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */