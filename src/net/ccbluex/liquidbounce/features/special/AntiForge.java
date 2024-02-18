/*    */ package net.ccbluex.liquidbounce.features.special;
/*    */ 
/*    */ import io.netty.buffer.Unpooled;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketCustomPayload;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Listenable;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ public class AntiForge
/*    */   extends MinecraftInstance implements Listenable {
/*    */   public static boolean enabled = true;
/*    */   public static boolean blockFML = true;
/*    */   public static boolean blockProxyPacket = true;
/*    */   public static boolean blockPayloadPackets = true;
/*    */   
/*    */   @EventTarget
/*    */   public void onPacket(PacketEvent event) {
/* 20 */     IPacket packet = event.getPacket();
/*    */     
/* 22 */     if (enabled && !mc.isIntegratedServerRunning()) {
/*    */       try {
/* 24 */         if (blockProxyPacket && packet.getClass().getName().equals("net.minecraftforge.fml.common.network.internal.FMLProxyPacket")) {
/* 25 */           event.cancelEvent();
/*    */         }
/* 27 */         if (blockPayloadPackets && classProvider.isCPacketCustomPayload(packet)) {
/* 28 */           ICPacketCustomPayload customPayload = packet.asCPacketCustomPayload();
/*    */           
/* 30 */           if (!customPayload.getChannelName().startsWith("MC|"))
/* 31 */           { event.cancelEvent(); }
/* 32 */           else if (customPayload.getChannelName().equalsIgnoreCase("MC|Brand"))
/* 33 */           { customPayload.setData(classProvider.createPacketBuffer(Unpooled.buffer()).writeString("vanilla")); } 
/*    */         } 
/* 35 */       } catch (Exception e) {
/* 36 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean handleEvents() {
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\special\AntiForge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */