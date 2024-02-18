package net.ccbluex.liquidbounce.api.minecraft.network;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.network.handshake.client.ICPacketHandshake;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketChatMessage;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketCustomPayload;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketHeldItemChange;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ISPacketCloseWindow;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketAnimation;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketChat;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketEntity;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketEntityVelocity;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketPosLook;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketResourcePackSend;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketTabComplete;
import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketWindowItems;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000j\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\b\020\002\032\0020\003H&J\b\020\004\032\0020\005H&J\b\020\006\032\0020\007H&J\b\020\b\032\0020\tH&J\b\020\n\032\0020\013H&J\b\020\f\032\0020\rH&J\b\020\016\032\0020\017H&J\b\020\020\032\0020\021H&J\b\020\022\032\0020\023H&J\b\020\024\032\0020\025H&J\b\020\026\032\0020\027H&J\b\020\030\032\0020\031H&J\b\020\032\032\0020\033H&J\b\020\034\032\0020\035H&J\b\020\036\032\0020\037H&J\b\020 \032\0020!H&¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "", "asCPacketChatMessage", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketChatMessage;", "asCPacketCustomPayload", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCustomPayload;", "asCPacketHandshake", "Lnet/ccbluex/liquidbounce/api/minecraft/network/handshake/client/ICPacketHandshake;", "asCPacketHeldItemChange", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;", "asCPacketPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "asCPacketPlayerDigging", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging;", "asCPacketUseEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;", "asSPacketAnimation", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketAnimation;", "asSPacketChat", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketChat;", "asSPacketCloseWindow", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ISPacketCloseWindow;", "asSPacketEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntity;", "asSPacketEntityVelocity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;", "asSPacketPosLook", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketPosLook;", "asSPacketResourcePackSend", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketResourcePackSend;", "asSPacketTabComplete", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketTabComplete;", "asSPacketWindowItems", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketWindowItems;", "XSJClient"})
public interface IPacket {
  @NotNull
  ISPacketChat asSPacketChat();
  
  @NotNull
  ISPacketAnimation asSPacketAnimation();
  
  @NotNull
  ISPacketEntity asSPacketEntity();
  
  @NotNull
  ICPacketPlayer asCPacketPlayer();
  
  @NotNull
  ICPacketUseEntity asCPacketUseEntity();
  
  @NotNull
  ISPacketEntityVelocity asSPacketEntityVelocity();
  
  @NotNull
  ICPacketChatMessage asCPacketChatMessage();
  
  @NotNull
  ISPacketCloseWindow asSPacketCloseWindow();
  
  @NotNull
  ISPacketTabComplete asSPacketTabComplete();
  
  @NotNull
  ISPacketPosLook asSPacketPosLook();
  
  @NotNull
  ISPacketResourcePackSend asSPacketResourcePackSend();
  
  @NotNull
  ICPacketHeldItemChange asCPacketHeldItemChange();
  
  @NotNull
  ISPacketWindowItems asSPacketWindowItems();
  
  @NotNull
  ICPacketCustomPayload asCPacketCustomPayload();
  
  @NotNull
  ICPacketHandshake asCPacketHandshake();
  
  @NotNull
  ICPacketPlayerDigging asCPacketPlayerDigging();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\IPacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */