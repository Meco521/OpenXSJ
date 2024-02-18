package net.ccbluex.liquidbounce.api.minecraft.client.entity;

import java.util.Collection;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.entity.IEnumCreatureAttribute;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
import net.ccbluex.liquidbounce.api.minecraft.potion.IPotionEffect;
import net.ccbluex.liquidbounce.api.minecraft.scoreboard.ITeam;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000T\n\002\030\002\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\006\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\027\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\006\bf\030\0002\0020\001J\020\0208\032\002092\006\020:\032\0020\004H&J\020\020;\032\0020\0312\006\020<\032\0020\001H&J\022\020=\032\004\030\0010\0042\006\020>\032\0020?H&J\022\020@\032\004\030\0010A2\006\020B\032\0020\025H&J\020\020C\032\0020\0312\006\020>\032\0020?H&J\020\020D\032\002092\006\020E\032\0020\025H&J\b\020F\032\00209H&R\030\020\002\032\b\022\004\022\0020\0040\003X¦\004¢\006\006\032\004\b\005\020\006R\030\020\007\032\0020\bX¦\016¢\006\f\032\004\b\t\020\n\"\004\b\013\020\fR\022\020\r\032\0020\016X¦\004¢\006\006\032\004\b\017\020\020R\030\020\021\032\0020\bX¦\016¢\006\f\032\004\b\022\020\n\"\004\b\023\020\fR\022\020\024\032\0020\025X¦\004¢\006\006\032\004\b\026\020\027R\022\020\030\032\0020\031X¦\004¢\006\006\032\004\b\030\020\032R\022\020\033\032\0020\031X¦\004¢\006\006\032\004\b\033\020\032R\030\020\034\032\0020\bX¦\016¢\006\f\032\004\b\035\020\n\"\004\b\036\020\fR\022\020\037\032\0020\bX¦\004¢\006\006\032\004\b \020\nR\022\020!\032\0020\025X¦\004¢\006\006\032\004\b\"\020\027R\022\020#\032\0020\bX¦\004¢\006\006\032\004\b$\020\nR\022\020%\032\0020\bX¦\004¢\006\006\032\004\b&\020\nR\030\020'\032\0020\bX¦\016¢\006\f\032\004\b(\020\n\"\004\b)\020\fR\030\020*\032\0020\bX¦\016¢\006\f\032\004\b+\020\n\"\004\b,\020\fR\030\020-\032\0020\bX¦\016¢\006\f\032\004\b.\020\n\"\004\b/\020\fR\024\0200\032\004\030\00101X¦\004¢\006\006\032\004\b2\0203R\022\0204\032\0020\025X¦\004¢\006\006\032\004\b5\020\027R\022\0206\032\0020\025X¦\004¢\006\006\032\004\b7\020\027¨\006G"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "activePotionEffects", "", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "getActivePotionEffects", "()Ljava/util/Collection;", "cameraPitch", "", "getCameraPitch", "()F", "setCameraPitch", "(F)V", "creatureAttribute", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "getCreatureAttribute", "()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "health", "getHealth", "setHealth", "hurtTime", "", "getHurtTime", "()I", "isOnLadder", "", "()Z", "isSwingInProgress", "jumpMovementFactor", "getJumpMovementFactor", "setJumpMovementFactor", "maxHealth", "getMaxHealth", "maxHurtTime", "getMaxHurtTime", "moveForward", "getMoveForward", "moveStrafing", "getMoveStrafing", "prevRotationYawHead", "getPrevRotationYawHead", "setPrevRotationYawHead", "renderYawOffset", "getRenderYawOffset", "setRenderYawOffset", "rotationYawHead", "getRotationYawHead", "setRotationYawHead", "team", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "getTeam", "()Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "totalArmorValue", "getTotalArmorValue", "totalArmorValue2", "getTotalArmorValue2", "addPotionEffect", "", "effect", "canEntityBeSeen", "it", "getActivePotionEffect", "potion", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "getEquipmentInSlot", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "index", "isPotionActive", "removePotionEffectClient", "id", "swingItem", "XSJClient"})
public interface IEntityLivingBase extends IEntity {
  int getMaxHurtTime();
  
  int getTotalArmorValue();
  
  int getTotalArmorValue2();
  
  float getMaxHealth();
  
  float getPrevRotationYawHead();
  
  void setPrevRotationYawHead(float paramFloat);
  
  float getRenderYawOffset();
  
  void setRenderYawOffset(float paramFloat);
  
  @NotNull
  Collection<IPotionEffect> getActivePotionEffects();
  
  boolean isSwingInProgress();
  
  float getCameraPitch();
  
  void setCameraPitch(float paramFloat);
  
  @Nullable
  ITeam getTeam();
  
  @NotNull
  IEnumCreatureAttribute getCreatureAttribute();
  
  int getHurtTime();
  
  boolean isOnLadder();
  
  float getJumpMovementFactor();
  
  void setJumpMovementFactor(float paramFloat);
  
  float getMoveStrafing();
  
  float getMoveForward();
  
  float getHealth();
  
  void setHealth(float paramFloat);
  
  float getRotationYawHead();
  
  void setRotationYawHead(float paramFloat);
  
  boolean canEntityBeSeen(@NotNull IEntity paramIEntity);
  
  boolean isPotionActive(@NotNull IPotion paramIPotion);
  
  void swingItem();
  
  @Nullable
  IPotionEffect getActivePotionEffect(@NotNull IPotion paramIPotion);
  
  void removePotionEffectClient(int paramInt);
  
  void addPotionEffect(@NotNull IPotionEffect paramIPotionEffect);
  
  @Nullable
  IItemStack getEquipmentInSlot(int paramInt);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\entity\IEntityLivingBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */