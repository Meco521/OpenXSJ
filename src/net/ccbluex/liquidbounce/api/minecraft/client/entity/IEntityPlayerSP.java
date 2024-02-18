package net.ccbluex.liquidbounce.api.minecraft.client.entity;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
import net.ccbluex.liquidbounce.api.minecraft.util.IMovementInput;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\005\n\002\020\b\n\002\b\005\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\000\bf\030\0002\0020\001J\020\020\035\032\0020\0362\006\020\037\032\0020 H&J\b\020!\032\0020\036H&J\b\020\"\032\0020\036H&J\020\020#\032\0020\0362\006\020$\032\0020%H&R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\030\020\b\032\0020\tX¦\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR\022\020\016\032\0020\017X¦\004¢\006\006\032\004\b\016\020\020R\022\020\021\032\0020\022X¦\004¢\006\006\032\004\b\023\020\024R\022\020\025\032\0020\026X¦\004¢\006\006\032\004\b\027\020\030R\030\020\031\032\0020\017X¦\016¢\006\f\032\004\b\032\020\020\"\004\b\033\020\034¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IAbstractClientPlayer;", "horseJumpPower", "", "getHorseJumpPower", "()F", "setHorseJumpPower", "(F)V", "horseJumpPowerCounter", "", "getHorseJumpPowerCounter", "()I", "setHorseJumpPowerCounter", "(I)V", "isHandActive", "", "()Z", "movementInput", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;", "getMovementInput", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;", "sendQueue", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "getSendQueue", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "serverSprintState", "getServerSprintState", "setServerSprintState", "(Z)V", "addChatMessage", "", "component", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "closeScreen", "respawnPlayer", "sendChatMessage", "msg", "", "XSJClient"})
public interface IEntityPlayerSP extends IAbstractClientPlayer {
  int getHorseJumpPowerCounter();
  
  void setHorseJumpPowerCounter(int paramInt);
  
  float getHorseJumpPower();
  
  void setHorseJumpPower(float paramFloat);
  
  @NotNull
  IINetHandlerPlayClient getSendQueue();
  
  @NotNull
  IMovementInput getMovementInput();
  
  boolean isHandActive();
  
  boolean getServerSprintState();
  
  void setServerSprintState(boolean paramBoolean);
  
  void sendChatMessage(@NotNull String paramString);
  
  void respawnPlayer();
  
  void addChatMessage(@NotNull IIChatComponent paramIIChatComponent);
  
  void closeScreen();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\entity\IEntityPlayerSP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */