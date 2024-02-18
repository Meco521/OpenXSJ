/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.network.INetworkPlayerInfo;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.client.network.NetworkPlayerInfo;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\036\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\002\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\020\032\0020\0212\006\020\022\032\0020\023H\026J\023\020\024\032\0020\0252\b\020\026\032\004\030\0010\027H\002J\022\020\030\032\004\030\0010\0132\006\020\031\032\0020\032H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\032\020\t\032\b\022\004\022\0020\0130\n8VX\004¢\006\006\032\004\b\f\020\rR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\016\020\017¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/INetHandlerPlayClientImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "wrapped", "Lnet/minecraft/client/network/NetHandlerPlayClient;", "(Lnet/minecraft/client/network/NetHandlerPlayClient;)V", "networkManager", "Lnet/ccbluex/liquidbounce/api/minecraft/INetworkManager;", "getNetworkManager", "()Lnet/ccbluex/liquidbounce/api/minecraft/INetworkManager;", "playerInfoMap", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;", "getPlayerInfoMap", "()Ljava/util/Collection;", "getWrapped", "()Lnet/minecraft/client/network/NetHandlerPlayClient;", "addToSendQueue", "", "packet", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "equals", "", "other", "", "getPlayerInfo", "uuid", "Ljava/util/UUID;", "XSJClient"})
/*    */ public final class INetHandlerPlayClientImpl implements IINetHandlerPlayClient {
/*    */   @NotNull
/* 14 */   public final NetHandlerPlayClient getWrapped() { return this.wrapped; } @NotNull private final NetHandlerPlayClient wrapped; public INetHandlerPlayClientImpl(@NotNull NetHandlerPlayClient wrapped) { this.wrapped = wrapped; }
/*    */   @NotNull
/* 16 */   public INetworkManager getNetworkManager() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_147298_b(), "wrapped.networkManager"); NetworkManager $this$wrap$iv = this.wrapped.func_147298_b(); int $i$f$wrap = 0; return 
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
/*    */ 
/*    */       
/* 31 */       new NetworkManagerImpl($this$wrap$iv); } @NotNull public Collection<INetworkPlayerInfo> getPlayerInfoMap() { return (Collection<INetworkPlayerInfo>)new WrappedCollection(this.wrapped.func_175106_d(), INetHandlerPlayClientImpl$playerInfoMap$1.INSTANCE, INetHandlerPlayClientImpl$playerInfoMap$2.INSTANCE); }
/* 32 */   @Nullable public INetworkPlayerInfo getPlayerInfo(@NotNull UUID uuid) { Intrinsics.checkParameterIsNotNull(uuid, "uuid"); NetworkPlayerInfo $this$wrap$iv = this.wrapped.func_175102_a(uuid); int $i$f$wrap = 0; this.wrapped.func_175102_a(uuid); return (this.wrapped.func_175102_a(uuid) != null) ? new NetworkPlayerInfoImpl($this$wrap$iv) : null; } public void addToSendQueue(@NotNull IPacket packet) { Intrinsics.checkParameterIsNotNull(packet, "packet"); IPacket iPacket = packet; NetHandlerPlayClient netHandlerPlayClient = this.wrapped; int $i$f$unwrap = 0;
/* 33 */     Packet packet1 = (Packet)((PacketImpl<Object>)iPacket).getWrapped(); netHandlerPlayClient.func_147297_a(packet1); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof INetHandlerPlayClientImpl && Intrinsics.areEqual(((INetHandlerPlayClientImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\INetHandlerPlayClientImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */