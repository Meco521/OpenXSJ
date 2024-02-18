package net.ccbluex.liquidbounce.api.minecraft.client.multiplayer;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
import net.ccbluex.liquidbounce.api.minecraft.world.IWorldSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000f\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\005\n\002\020\007\n\002\b\007\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\b\bf\030\0002\0020\001J\030\020\030\032\0020\0252\006\020\031\032\0020\0322\006\020\033\032\0020\034H&J\b\020\035\032\0020\025H&J\030\020\036\032\0020\0252\006\020\031\032\0020\0322\006\020\033\032\0020\034H&J:\020\037\032\0020\0252\006\020 \032\0020!2\006\020\"\032\0020#2\b\020$\032\004\030\0010%2\006\020&\032\0020\0322\006\020'\032\0020\0342\006\020(\032\0020)H&J\020\020*\032\0020+2\006\020,\032\0020!H&J \020-\032\0020\0252\006\020 \032\0020.2\006\020\"\032\0020/2\006\020$\032\0020%H&J\b\0200\032\0020+H&J0\0201\032\0020+2\006\0202\032\0020\0032\006\0203\032\0020\0032\006\0204\032\0020\0032\006\0205\032\0020\0032\006\0206\032\0020!H&R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\022\020\b\032\0020\tX¦\004¢\006\006\032\004\b\n\020\013R\030\020\f\032\0020\tX¦\016¢\006\f\032\004\b\r\020\013\"\004\b\016\020\017R\022\020\020\032\0020\021X¦\004¢\006\006\032\004\b\022\020\023R\022\020\024\032\0020\025X¦\004¢\006\006\032\004\b\024\020\026R\022\020\027\032\0020\025X¦\004¢\006\006\032\004\b\027\020\026¨\0067"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;", "", "blockHitDelay", "", "getBlockHitDelay", "()I", "setBlockHitDelay", "(I)V", "blockReachDistance", "", "getBlockReachDistance", "()F", "curBlockDamageMP", "getCurBlockDamageMP", "setCurBlockDamageMP", "(F)V", "currentGameType", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;", "getCurrentGameType", "()Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;", "isInCreativeMode", "", "()Z", "isNotCreative", "clickBlock", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "enumFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "extendedReach", "onPlayerDestroyBlock", "onPlayerRightClick", "playerSP", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "theWorld", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "itemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "position", "sideOpposite", "hitVec", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "onStoppedUsingItem", "", "thePlayer", "sendUseItem", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "updateController", "windowClick", "windowId", "slot", "mouseButton", "mode", "player", "XSJClient"})
public interface IPlayerControllerMP {
  boolean isNotCreative();
  
  float getBlockReachDistance();
  
  @NotNull
  IWorldSettings.WGameType getCurrentGameType();
  
  boolean isInCreativeMode();
  
  float getCurBlockDamageMP();
  
  void setCurBlockDamageMP(float paramFloat);
  
  int getBlockHitDelay();
  
  void setBlockHitDelay(int paramInt);
  
  void windowClick(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NotNull IEntityPlayerSP paramIEntityPlayerSP);
  
  void updateController();
  
  boolean sendUseItem(@NotNull IEntityPlayer paramIEntityPlayer, @NotNull IWorld paramIWorld, @NotNull IItemStack paramIItemStack);
  
  boolean onPlayerRightClick(@NotNull IEntityPlayerSP paramIEntityPlayerSP, @NotNull IWorldClient paramIWorldClient, @Nullable IItemStack paramIItemStack, @NotNull WBlockPos paramWBlockPos, @NotNull IEnumFacing paramIEnumFacing, @NotNull WVec3 paramWVec3);
  
  void onStoppedUsingItem(@NotNull IEntityPlayerSP paramIEntityPlayerSP);
  
  boolean clickBlock(@NotNull WBlockPos paramWBlockPos, @NotNull IEnumFacing paramIEnumFacing);
  
  boolean onPlayerDestroyBlock(@NotNull WBlockPos paramWBlockPos, @NotNull IEnumFacing paramIEnumFacing);
  
  boolean extendedReach();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\multiplayer\IPlayerControllerMP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */