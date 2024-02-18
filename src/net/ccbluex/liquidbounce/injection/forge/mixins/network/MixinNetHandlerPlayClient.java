/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.network;
/*    */ 
/*    */ import io.netty.buffer.Unpooled;
/*    */ import java.net.URI;
/*    */ import java.net.URISyntaxException;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EntityMovementEvent;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.features.special.AntiForge;
/*    */ import net.ccbluex.liquidbounce.injection.backend.EntityImplKt;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.minecraft.client.ClientBrandRetriever;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiDownloadTerrain;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.PacketThreadUtil;
/*    */ import net.minecraft.network.play.client.CPacketCustomPayload;
/*    */ import net.minecraft.network.play.client.CPacketResourcePackStatus;
/*    */ import net.minecraft.network.play.server.SPacketEntity;
/*    */ import net.minecraft.network.play.server.SPacketJoinGame;
/*    */ import net.minecraft.network.play.server.SPacketResourcePackSend;
/*    */ import net.minecraft.util.IThreadListener;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({NetHandlerPlayClient.class})
/*    */ public abstract class MixinNetHandlerPlayClient {
/*    */   @Shadow
/*    */   public int field_147304_c;
/*    */   @Shadow
/*    */   @Final
/*    */   private NetworkManager field_147302_e;
/*    */   
/*    */   @Inject(method = {"handleResourcePack"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void handleResourcePack(SPacketResourcePackSend p_handleResourcePack_1_, CallbackInfo callbackInfo) {
/* 50 */     String url = p_handleResourcePack_1_.func_179783_a();
/* 51 */     String hash = p_handleResourcePack_1_.func_179784_b();
/*    */     
/*    */     try {
/* 54 */       String scheme = (new URI(url)).getScheme();
/* 55 */       boolean isLevelProtocol = "level".equals(scheme);
/*    */       
/* 57 */       if (!"http".equals(scheme) && !"https".equals(scheme) && !isLevelProtocol) {
/* 58 */         throw new URISyntaxException(url, "Wrong protocol");
/*    */       }
/* 60 */       if (isLevelProtocol && (url.contains("..") || !url.endsWith("/resources.zip")))
/* 61 */         throw new URISyntaxException(url, "Invalid levelstorage resourcepack path"); 
/* 62 */     } catch (URISyntaxException e) {
/* 63 */       ClientUtils.getLogger().error("Failed to handle resource pack", e);
/* 64 */       this.field_147302_e.func_179290_a((Packet)new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
/* 65 */       callbackInfo.cancel();
/*    */     } 
/*    */   } @Shadow
/*    */   private Minecraft field_147299_f; @Shadow
/*    */   private WorldClient field_147300_g; @Inject(method = {"handleJoinGame"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void handleJoinGameWithAntiForge(SPacketJoinGame packetIn, CallbackInfo callbackInfo) {
/* 71 */     if (!AntiForge.enabled || !AntiForge.blockFML || Minecraft.func_71410_x().func_71387_A()) {
/*    */       return;
/*    */     }
/* 74 */     PacketThreadUtil.func_180031_a((Packet)packetIn, (INetHandler)this, (IThreadListener)this.field_147299_f);
/* 75 */     this.field_147299_f.field_71442_b = new PlayerControllerMP(this.field_147299_f, (NetHandlerPlayClient)this);
/* 76 */     this.field_147300_g = new WorldClient((NetHandlerPlayClient)this, new WorldSettings(0L, packetIn.func_149198_e(), false, packetIn.func_149195_d(), packetIn.func_149196_i()), packetIn.func_149194_f(), packetIn.func_149192_g(), this.field_147299_f.field_71424_I);
/* 77 */     this.field_147299_f.field_71474_y.field_74318_M = packetIn.func_149192_g();
/* 78 */     this.field_147299_f.func_71403_a(this.field_147300_g);
/* 79 */     this.field_147299_f.field_71439_g.field_71093_bK = packetIn.func_149194_f();
/* 80 */     this.field_147299_f.func_147108_a((GuiScreen)new GuiDownloadTerrain());
/* 81 */     this.field_147299_f.field_71439_g.func_145769_d(packetIn.func_149197_c());
/* 82 */     this.field_147304_c = packetIn.func_149193_h();
/* 83 */     this.field_147299_f.field_71439_g.func_175150_k(packetIn.func_179744_h());
/* 84 */     this.field_147299_f.field_71442_b.func_78746_a(packetIn.func_149198_e());
/* 85 */     this.field_147299_f.field_71474_y.func_82879_c();
/* 86 */     this.field_147302_e.func_179290_a((Packet)new CPacketCustomPayload("MC|Brand", (new PacketBuffer(Unpooled.buffer())).func_180714_a(ClientBrandRetriever.getClientModName())));
/* 87 */     callbackInfo.cancel();
/*    */   }
/*    */   
/*    */   @Inject(method = {"handleEntityMovement"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;onGround:Z")})
/*    */   private void handleEntityMovementEvent(SPacketEntity packetIn, CallbackInfo callbackInfo) {
/* 92 */     Entity entity = packetIn.func_149065_a((World)this.field_147300_g);
/*    */     
/* 94 */     if (entity != null)
/* 95 */       Retreat.eventManager.callEvent((Event)new EntityMovementEvent(EntityImplKt.wrap(entity))); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\network\MixinNetHandlerPlayClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */