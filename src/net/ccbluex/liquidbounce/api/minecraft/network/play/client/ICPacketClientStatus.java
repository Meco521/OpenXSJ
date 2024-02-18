/*   */ package net.ccbluex.liquidbounce.api.minecraft.network.play.client;
/*   */ 
/*   */ import kotlin.Metadata;
/*   */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bf\030\0002\0020\001:\001\002¨\006\003"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "WEnumState", "XSJClient"})
/*   */ public interface ICPacketClientStatus extends IPacket {
/*   */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus$WEnumState;", "", "(Ljava/lang/String;I)V", "PERFORM_RESPAWN", "REQUEST_STATS", "OPEN_INVENTORY_ACHIEVEMENT", "XSJClient"})
/*   */   public enum WEnumState {
/*   */     PERFORM_RESPAWN, REQUEST_STATS, OPEN_INVENTORY_ACHIEVEMENT;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\client\ICPacketClientStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */