/*    */ package tomk;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\bÆ\002\030\0002\0020\001:\001\024B\007\b\002¢\006\002\020\002J\024\020\b\032\0020\t2\n\020\n\032\006\022\002\b\0030\005H\007J\024\020\013\032\0020\f2\n\020\n\032\006\022\002\b\0030\005H\007J\016\020\r\032\0020\0162\006\020\017\032\0020\020J\016\020\r\032\0020\0162\006\020\021\032\0020\022J\026\020\023\032\0020\0162\f\020\n\032\b\022\004\022\0020\0060\005H\007R*\020\003\032\036\022\n\022\b\022\004\022\0020\0060\0050\004j\016\022\n\022\b\022\004\022\0020\0060\005`\007X\004¢\006\002\n\000¨\006\025"}, d2 = {"Ltomk/PacketUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "packets", "Ljava/util/ArrayList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "Lkotlin/collections/ArrayList;", "getPacketType", "Ltomk/PacketUtils$PacketType;", "packet", "handleSendPacket", "", "send", "", "cPacketConfirmTransaction", "Lnet/minecraft/network/play/client/CPacketConfirmTransaction;", "cPacketKeepAlive", "Lnet/minecraft/network/play/client/CPacketKeepAlive;", "sendPacketNoEvent", "PacketType", "XSJClient"})
/*    */ public final class PacketUtils extends MinecraftInstance {
/*    */   static {
/* 10 */     PacketUtils packetUtils = new PacketUtils();
/* 11 */   } private static final ArrayList<Packet<INetHandlerPlayServer>> packets = new ArrayList<>(); public static final PacketUtils INSTANCE;
/*    */   
/*    */   @JvmStatic
/*    */   public static final boolean handleSendPacket(@NotNull Packet packet) {
/* 15 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); if (CollectionsKt.contains(packets, packet)) {
/* 16 */       ArrayList<Packet<INetHandlerPlayServer>> arrayList = packets; boolean bool = false; if (arrayList == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");  TypeIntrinsics.asMutableCollection(arrayList).remove(packet);
/* 17 */       return true;
/*    */     } 
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   @JvmStatic
/*    */   public static final void sendPacketNoEvent(@NotNull Packet<INetHandlerPlayServer> packet) {
/* 24 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); packets.add(packet);
/* 25 */     MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)packet);
/*    */   }
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final PacketType getPacketType(@NotNull Packet packet) {
/* 30 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); String className = packet.getClass().getSimpleName();
/* 31 */     Intrinsics.checkExpressionValueIsNotNull(className, "className"); if (StringsKt.startsWith(className, "C", true))
/* 32 */       return PacketType.CLIENTSIDE; 
/* 33 */     if (StringsKt.startsWith(className, "S", true)) {
/* 34 */       return PacketType.SERVERSIDE;
/*    */     }
/* 36 */     return PacketType.UNKNOWN;
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Ltomk/PacketUtils$PacketType;", "", "(Ljava/lang/String;I)V", "SERVERSIDE", "CLIENTSIDE", "UNKNOWN", "XSJClient"})
/*    */   public enum PacketType {
/*    */     SERVERSIDE, CLIENTSIDE, UNKNOWN; }
/*    */   
/*    */   public final void send(@NotNull CPacketKeepAlive cPacketKeepAlive) {
/* 44 */     Intrinsics.checkParameterIsNotNull(cPacketKeepAlive, "cPacketKeepAlive");
/*    */   } public final void send(@NotNull CPacketConfirmTransaction cPacketConfirmTransaction) {
/* 46 */     Intrinsics.checkParameterIsNotNull(cPacketConfirmTransaction, "cPacketConfirmTransaction");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\PacketUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */