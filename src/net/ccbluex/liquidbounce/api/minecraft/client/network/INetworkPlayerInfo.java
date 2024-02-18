package net.ccbluex.liquidbounce.api.minecraft.client.network;

import com.mojang.authlib.GameProfile;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.scoreboard.ITeam;
import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\003\bf\030\0002\0020\001R\024\020\002\032\004\030\0010\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\013X¦\004¢\006\006\032\004\b\f\020\rR\024\020\016\032\004\030\0010\017X¦\004¢\006\006\032\004\b\020\020\021R\022\020\022\032\0020\023X¦\004¢\006\006\032\004\b\024\020\025¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;", "", "displayName", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "getDisplayName", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "getGameProfile", "()Lcom/mojang/authlib/GameProfile;", "locationSkin", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "getLocationSkin", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "playerTeam", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "getPlayerTeam", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "responseTime", "", "getResponseTime", "()I", "XSJClient"})
public interface INetworkPlayerInfo {
  @NotNull
  IResourceLocation getLocationSkin();
  
  int getResponseTime();
  
  @NotNull
  GameProfile getGameProfile();
  
  @Nullable
  ITeam getPlayerTeam();
  
  @Nullable
  IIChatComponent getDisplayName();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\network\INetworkPlayerInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */