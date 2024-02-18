package net.ccbluex.liquidbounce.api.minecraft.entity.player;

import kotlin.Metadata;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\007\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\003X¦\004¢\006\006\032\004\b\006\020\005R\030\020\007\032\0020\003X¦\016¢\006\f\032\004\b\007\020\005\"\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;", "", "allowFlying", "", "getAllowFlying", "()Z", "isCreativeMode", "isFlying", "setFlying", "(Z)V", "XSJClient"})
public interface IPlayerCapabilities {
  boolean getAllowFlying();
  
  boolean isFlying();
  
  void setFlying(boolean paramBoolean);
  
  boolean isCreativeMode();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\entity\player\IPlayerCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */