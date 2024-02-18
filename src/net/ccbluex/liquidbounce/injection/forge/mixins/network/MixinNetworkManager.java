/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.network;
/*    */ 
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.injection.backend.PacketImplKt;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.Packet;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({NetworkManager.class})
/*    */ public class MixinNetworkManager {
/*    */   @Inject(method = {"channelRead0"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void read(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callback) {
/* 19 */     PacketEvent event = new PacketEvent(PacketImplKt.wrap(packet));
/* 20 */     Retreat.eventManager.callEvent((Event)event);
/*    */     
/* 22 */     if (event.isCancelled())
/* 23 */       callback.cancel(); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"sendPacket(Lnet/minecraft/network/Packet;)V"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void send(Packet<?> packet, CallbackInfo callback) {
/* 28 */     PacketEvent event = new PacketEvent(PacketImplKt.wrap(packet));
/* 29 */     Retreat.eventManager.callEvent((Event)event);
/*    */     
/* 31 */     if (event.isCancelled())
/* 32 */       callback.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\network\MixinNetworkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */