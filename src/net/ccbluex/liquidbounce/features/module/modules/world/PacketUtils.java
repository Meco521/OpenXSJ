/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*    */ import net.minecraft.network.play.client.CPacketKeepAlive;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PacketUtils
/*    */   extends MinecraftInstance
/*    */ {
/* 19 */   public static List<IPacket> pList = new ArrayList<>();
/*    */   
/*    */   public static void send(IPacket pac) {
/* 22 */     pList.add(pac);
/* 23 */     mc.getNetHandler().getNetworkManager().sendPacket(pac);
/*    */   }
/*    */   
/*    */   public static void send(@NotNull CPacketKeepAlive cPacketKeepAlive) {}
/*    */   
/*    */   public static void send(@NotNull CPacketConfirmTransaction cPacketConfirmTransaction) {}
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\PacketUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */