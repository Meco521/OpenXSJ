package net.ccbluex.liquidbounce.api.minecraft.util;

import com.mojang.authlib.GameProfile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\t\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\003X¦\004¢\006\006\032\004\b\013\020\005R\022\020\f\032\0020\003X¦\004¢\006\006\032\004\b\r\020\005R\022\020\016\032\0020\003X¦\004¢\006\006\032\004\b\017\020\005¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "", "playerId", "", "getPlayerId", "()Ljava/lang/String;", "profile", "Lcom/mojang/authlib/GameProfile;", "getProfile", "()Lcom/mojang/authlib/GameProfile;", "sessionType", "getSessionType", "token", "getToken", "username", "getUsername", "XSJClient"})
public interface ISession {
  @NotNull
  GameProfile getProfile();
  
  @NotNull
  String getUsername();
  
  @NotNull
  String getPlayerId();
  
  @NotNull
  String getSessionType();
  
  @NotNull
  String getToken();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\ISession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */