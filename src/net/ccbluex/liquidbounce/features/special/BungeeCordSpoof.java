/*    */ package net.ccbluex.liquidbounce.features.special;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.handshake.client.ICPacketHandshake;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\030\000 \f2\0020\0012\0020\002:\001\fB\005¢\006\002\020\003J\b\020\004\032\0020\005H\002J\b\020\006\032\0020\007H\026J\020\020\b\032\0020\t2\006\020\n\032\0020\013H\007¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/special/BungeeCordSpoof;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "getRandomIpPart", "", "handleEvents", "", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "Companion", "XSJClient"})
/*    */ public final class BungeeCordSpoof extends MinecraftInstance implements Listenable {
/*    */   private static final Random RANDOM;
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 12 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 13 */     if (MinecraftInstance.classProvider.isCPacketHandshake(packet) && enabled && packet.asCPacketHandshake().getRequestedState().isHandshake()) {
/* 14 */       ICPacketHandshake handshake = packet.asCPacketHandshake();
/*    */       
/* 16 */       StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE; String str1 = "%d.%d.%d.%d"; Object[] arrayOfObject = { getRandomIpPart(), getRandomIpPart(), getRandomIpPart(), getRandomIpPart() }; StringBuilder stringBuilder = (new StringBuilder()).append(handshake.getIp()).append("\000"); ICPacketHandshake iCPacketHandshake1 = handshake; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(format, *args)"); String str2 = String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)); iCPacketHandshake1.setIp(stringBuilder.append(str2).append("\000").append(StringsKt.replace$default(MinecraftInstance.mc.getSession().getPlayerId(), "-", "", false, 4, null)).toString());
/*    */     } 
/*    */   } @JvmField
/*    */   public static boolean enabled; private final String getRandomIpPart() {
/* 20 */     return String.valueOf(RANDOM.nextInt(256));
/*    */   }
/*    */   public boolean handleEvents() {
/* 23 */     return true;
/*    */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/special/BungeeCordSpoof$Companion;", "", "()V", "RANDOM", "Ljava/util/Random;", "enabled", "", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {} }
/* 27 */   public static final Companion Companion = new Companion(null); static { RANDOM = new Random(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\special\BungeeCordSpoof.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */