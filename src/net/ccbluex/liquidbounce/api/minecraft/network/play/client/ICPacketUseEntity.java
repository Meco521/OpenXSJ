/*   */ package net.ccbluex.liquidbounce.api.minecraft.network.play.client;
/*   */ 
/*   */ import kotlin.Metadata;
/*   */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*   */ import org.jetbrains.annotations.NotNull;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\bf\030\0002\0020\001:\001\006R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "action", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "getAction", "()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "WAction", "XSJClient"})
/*   */ public interface ICPacketUseEntity extends IPacket {
/*   */   @NotNull
/*   */   WAction getAction();
/*   */   
/*   */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "", "(Ljava/lang/String;I)V", "INTERACT", "ATTACK", "INTERACT_AT", "XSJClient"})
/*   */   public enum WAction {
/*   */     INTERACT, ATTACK, INTERACT_AT;
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\client\ICPacketUseEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */