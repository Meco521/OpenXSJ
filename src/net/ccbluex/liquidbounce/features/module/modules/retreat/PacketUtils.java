/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ import java.util.ArrayList;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\005\bÆ\002\030\0002\0020\001:\001\025B\007\b\002¢\006\002\020\002J\024\020\013\032\0020\f2\n\020\r\032\006\022\002\b\0030\007H\007J\024\020\016\032\0020\0172\n\020\r\032\006\022\002\b\0030\007H\007J\026\020\020\032\0020\0212\f\020\r\032\b\022\002\b\003\030\0010\007H\007J\b\020\022\032\0020\021H\007J\026\020\023\032\0020\0212\f\020\r\032\b\022\004\022\0020\b0\007H\007J\022\020\024\032\0020\0212\n\020\r\032\006\022\002\b\0030\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R*\020\005\032\036\022\n\022\b\022\004\022\0020\b0\0070\006j\016\022\n\022\b\022\004\022\0020\b0\007`\tX\004¢\006\002\n\000R&\020\n\032\032\022\b\022\006\022\002\b\0030\0070\006j\f\022\b\022\006\022\002\b\0030\007`\tX\004¢\006\002\n\000¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/PacketUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "disabler", "Lnet/ccbluex/liquidbounce/features/module/modules/exploit/Clip;", "packets", "Ljava/util/ArrayList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayServer;", "Lkotlin/collections/ArrayList;", "packets2", "getPacketType", "Lnet/ccbluex/liquidbounce/features/module/modules/retreat/PacketUtils$PacketType;", "packet", "handleSendPacket", "", "send", "", "sendPacketC0F", "sendPacketNoEvent", "sendPacketNoEvent2", "PacketType", "XSJClient"})
/*    */ public final class PacketUtils extends MinecraftInstance {
/*    */   static {
/* 11 */     PacketUtils packetUtils = new PacketUtils();
/* 12 */   } private static final ArrayList<Packet<INetHandlerPlayServer>> packets = new ArrayList<>();
/* 13 */   private static final ArrayList<Packet<?>> packets2 = new ArrayList<>();
/* 14 */   private static Clip disabler = (Clip)Retreat.INSTANCE.getModuleManager().getModule(Clip.class); public static final PacketUtils INSTANCE; static { if (Retreat.INSTANCE.getModuleManager().getModule(Clip.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.exploit.Clip");  }
/*    */    @JvmStatic
/*    */   public static final void send(@Nullable Packet packet) {
/* 17 */     if (MinecraftInstance.mc.getThePlayer() != null) {
/* 18 */       Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); if (Minecraft.func_71410_x().func_147114_u() == null) Intrinsics.throwNpe();  Minecraft.func_71410_x().func_147114_u().func_147297_a(packet);
/*    */     } 
/*    */   }
/*    */   @JvmStatic
/*    */   public static final boolean handleSendPacket(@NotNull Packet packet) {
/* 23 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); if (CollectionsKt.contains(packets, packet)) {
/* 24 */       ArrayList<Packet<INetHandlerPlayServer>> arrayList = packets; boolean bool = false; if (arrayList == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");  TypeIntrinsics.asMutableCollection(arrayList).remove(packet);
/* 25 */       return true;
/*    */     } 
/* 27 */     return false;
/*    */   }
/*    */   public final void sendPacketNoEvent2(@NotNull Packet<?> packet) {
/* 30 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); packets2.add(packet);
/* 31 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a(packet);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   public static final void sendPacketC0F() {
/* 38 */     send(
/* 39 */         (Packet)new CPacketConfirmTransaction(
/* 40 */           MathUtil.getRandom(102, 1000024123), 
/* 41 */           (short)MathUtil.getRandom(102, 1000024123), true));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   public static final void sendPacketNoEvent(@NotNull Packet<INetHandlerPlayServer> packet) {
/* 48 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); packets.add(packet);
/* 49 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a(packet);
/*    */   }
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final PacketType getPacketType(@NotNull Packet packet) {
/* 54 */     Intrinsics.checkParameterIsNotNull(packet, "packet"); String className = packet.getClass().getSimpleName();
/* 55 */     Intrinsics.checkExpressionValueIsNotNull(className, "className"); if (StringsKt.startsWith(className, "C", true))
/* 56 */       return PacketType.CLIENTSIDE; 
/* 57 */     if (StringsKt.startsWith(className, "S", true)) {
/* 58 */       return PacketType.SERVERSIDE;
/*    */     }
/* 60 */     return PacketType.UNKNOWN;
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/PacketUtils$PacketType;", "", "(Ljava/lang/String;I)V", "SERVERSIDE", "CLIENTSIDE", "UNKNOWN", "XSJClient"})
/*    */   public enum PacketType {
/*    */     SERVERSIDE, CLIENTSIDE, UNKNOWN;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\PacketUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */