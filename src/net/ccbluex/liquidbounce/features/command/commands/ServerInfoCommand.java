/*    */ package net.ccbluex.liquidbounce.features.command.commands;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IServerData;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.handshake.client.ICPacketHandshake;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020\b\n\000\n\002\020\002\n\000\n\002\020\021\n\002\b\002\n\002\020\013\n\002\b\002\n\002\030\002\n\000\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\033\020\b\032\0020\t2\f\020\n\032\b\022\004\022\0020\0050\013H\026¢\006\002\020\fJ\b\020\r\032\0020\016H\026J\020\020\017\032\0020\t2\006\020\020\032\0020\021H\007R\016\020\004\032\0020\005X\016¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/command/commands/ServerInfoCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "ip", "", "port", "", "execute", "", "args", "", "([Ljava/lang/String;)V", "handleEvents", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class ServerInfoCommand extends Command implements Listenable {
/*    */   public ServerInfoCommand() {
/*  9 */     super("serverinfo", new String[0]);
/*    */     
/* 11 */     Retreat.INSTANCE.getEventManager().registerListener(this);
/*    */ 
/*    */     
/* 14 */     this.ip = "";
/*    */   }
/*    */   
/*    */   private String ip;
/*    */   private int port;
/*    */   
/*    */   public void execute(@NotNull String[] args) {
/* 21 */     Intrinsics.checkParameterIsNotNull(args, "args"); if (MinecraftInstance.mc.getCurrentServerData() == null) {
/* 22 */       chat("This command does not work in single player.");
/*    */       
/*    */       return;
/*    */     } 
/* 26 */     if (MinecraftInstance.mc.getCurrentServerData() != null) { IServerData data = MinecraftInstance.mc.getCurrentServerData();
/*    */       
/* 28 */       chat("Server infos:");
/* 29 */       chat("§7Name: §8" + data.getServerName());
/* 30 */       chat("§7IP: §8" + this.ip + ':' + this.port);
/* 31 */       chat("§7Players: §8" + data.getPopulationInfo());
/* 32 */       chat("§7MOTD: §8" + data.getServerMOTD());
/* 33 */       chat("§7ServerVersion: §8" + data.getGameVersion());
/* 34 */       chat("§7ProtocolVersion: §8" + data.getVersion());
/* 35 */       chat("§7Ping: §8" + data.getPingToServer());
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getCurrentServerData(); } @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 40 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*    */     
/* 42 */     if (MinecraftInstance.classProvider.isCPacketHandshake(packet)) {
/* 43 */       ICPacketHandshake handshake = packet.asCPacketHandshake();
/*    */       
/* 45 */       this.ip = handshake.getIp();
/* 46 */       this.port = handshake.getPort();
/*    */     } 
/*    */   }
/*    */   public boolean handleEvents() {
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\command\commands\ServerInfoCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */