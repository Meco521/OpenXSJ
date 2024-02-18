/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import java.net.URISyntaxException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketResourcePackStatus;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketResourcePackSend;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @ModuleInfo(name = "ResourcePackSpoof", description = "Prevents servers from forcing you to download their resource pack.", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/ResourcePackSpoof;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class ResourcePackSpoof extends Module {
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 18 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.classProvider.isSPacketResourcePackSend(event.getPacket())) {
/* 19 */       ISPacketResourcePackSend packet = event.getPacket().asSPacketResourcePackSend();
/*    */       
/* 21 */       String url = packet.getUrl();
/* 22 */       String hash = packet.getHash();
/*    */       
/*    */       try {
/* 25 */         String scheme = (new URI(url)).getScheme();
/* 26 */         boolean isLevelProtocol = Intrinsics.areEqual("level", scheme);
/*    */         
/* 28 */         if ((Intrinsics.areEqual("http", scheme) ^ true) != 0 && (Intrinsics.areEqual("https", scheme) ^ true) != 0 && !isLevelProtocol) {
/* 29 */           throw (Throwable)new URISyntaxException(url, "Wrong protocol");
/*    */         }
/* 31 */         if (isLevelProtocol && (StringsKt.contains$default(url, "..", false, 2, null) || !StringsKt.endsWith$default(url, "/resources.zip", false, 2, null))) {
/* 32 */           throw (Throwable)new URISyntaxException(url, "Invalid levelstorage resourcepack path");
/*    */         }
/* 34 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createICPacketResourcePackStatus(packet.getHash(), 
/* 35 */               ICPacketResourcePackStatus.WAction.ACCEPTED));
/* 36 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createICPacketResourcePackStatus(packet.getHash(), 
/* 37 */               ICPacketResourcePackStatus.WAction.SUCCESSFULLY_LOADED));
/* 38 */       } catch (URISyntaxException e) {
/* 39 */         ClientUtils.getLogger().error("Failed to handle resource pack", e);
/* 40 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createICPacketResourcePackStatus(hash, ICPacketResourcePackStatus.WAction.FAILED_DOWNLOAD));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\ResourcePackSpoof.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */