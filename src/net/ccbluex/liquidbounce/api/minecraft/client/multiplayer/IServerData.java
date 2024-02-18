package net.ccbluex.liquidbounce.api.minecraft.client.multiplayer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\003\n\002\020\t\n\002\b\013\n\002\020\b\n\002\b\003\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\003X¦\004¢\006\006\032\004\b\013\020\005R\022\020\f\032\0020\003X¦\004¢\006\006\032\004\b\r\020\005R\022\020\016\032\0020\003X¦\004¢\006\006\032\004\b\017\020\005R\022\020\020\032\0020\003X¦\004¢\006\006\032\004\b\021\020\005R\022\020\022\032\0020\023X¦\004¢\006\006\032\004\b\024\020\025¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "", "gameVersion", "", "getGameVersion", "()Ljava/lang/String;", "pingToServer", "", "getPingToServer", "()J", "populationInfo", "getPopulationInfo", "serverIP", "getServerIP", "serverMOTD", "getServerMOTD", "serverName", "getServerName", "version", "", "getVersion", "()I", "XSJClient"})
public interface IServerData {
  long getPingToServer();
  
  int getVersion();
  
  @NotNull
  String getGameVersion();
  
  @NotNull
  String getServerMOTD();
  
  @NotNull
  String getPopulationInfo();
  
  @NotNull
  String getServerName();
  
  @NotNull
  String getServerIP();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\multiplayer\IServerData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */