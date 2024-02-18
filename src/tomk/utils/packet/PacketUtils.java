/*    */ package tomk.utils.packet;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*    */ import net.minecraft.network.play.client.CPacketKeepAlive;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PacketUtils
/*    */   extends MinecraftInstance
/*    */ {
/* 20 */   public static List<IPacket> pList = new ArrayList<>();
/*    */   
/*    */   public static void send(IPacket pac) {
/* 23 */     pList.add(pac);
/* 24 */     mc.getNetHandler().getNetworkManager().sendPacket(pac);
/*    */   }
/*    */   
/*    */   public static void send(@NotNull CPacketKeepAlive cPacketKeepAlive) {}
/*    */   
/*    */   public static void send(@NotNull CPacketConfirmTransaction cPacketConfirmTransaction) {}
/*    */   
/*    */   public static void sendPacketNoEvent(@NotNull Packet<INetHandlerPlayServer> packet) {}
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\packet\PacketUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */