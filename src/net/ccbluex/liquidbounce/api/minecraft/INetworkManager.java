package net.ccbluex.liquidbounce.api.minecraft;

import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\020\020\006\032\0020\0032\006\020\007\032\0020\bH&J\036\020\006\032\0020\0032\006\020\007\032\0020\b2\f\020\t\032\b\022\004\022\0020\0030\nH&¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/INetworkManager;", "", "enableEncryption", "", "secretKey", "Ljavax/crypto/SecretKey;", "sendPacket", "packet", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "any", "Lkotlin/Function0;", "XSJClient"})
public interface INetworkManager {
  void sendPacket(@NotNull IPacket paramIPacket);
  
  void enableEncryption(@NotNull SecretKey paramSecretKey);
  
  void sendPacket(@NotNull IPacket paramIPacket, @NotNull Function0<Unit> paramFunction0);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\INetworkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */