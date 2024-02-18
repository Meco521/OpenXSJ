package net.ccbluex.liquidbounce.api.minecraft.client.entity.player;

import com.mojang.authlib.GameProfile;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import net.ccbluex.liquidbounce.api.MinecraftVersion;
import net.ccbluex.liquidbounce.api.SupportsMinecraftVersions;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
import net.ccbluex.liquidbounce.api.minecraft.entity.player.IInventoryPlayer;
import net.ccbluex.liquidbounce.api.minecraft.entity.player.IPlayerCapabilities;
import net.ccbluex.liquidbounce.api.minecraft.inventory.IContainer;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import net.ccbluex.liquidbounce.api.minecraft.stats.IStatBase;
import net.ccbluex.liquidbounce.api.minecraft.util.IFoodStats;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000x\n\002\030\002\n\002\030\002\n\000\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\006\n\002\020\b\n\002\b\t\n\002\020\006\n\002\b\017\n\002\020\002\n\002\b\r\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020I\032\0020J2\006\020K\032\0020\021H&J\030\020L\032\0020J2\006\020M\032\0020\0032\006\020N\032\0020\003H&J\020\020O\032\0020\0032\006\020P\032\0020\003H'J\b\020Q\032\0020JH&J\020\020R\032\0020J2\006\020K\032\0020\021H&J\020\020S\032\0020J2\006\020K\032\0020\001H&J\b\020T\032\0020JH&J\b\020U\032\0020JH&J\020\020V\032\0020J2\006\020W\032\0020XH&R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007R\022\020\b\032\0020\tX¦\004¢\006\006\032\004\b\n\020\013R\022\020\f\032\0020\rX¦\004¢\006\006\032\004\b\016\020\017R\024\020\020\032\004\030\0010\021X¦\004¢\006\006\032\004\b\022\020\023R\022\020\024\032\0020\025X¦\004¢\006\006\032\004\b\026\020\027R\022\020\030\032\0020\031X¦\004¢\006\006\032\004\b\032\020\033R\024\020\034\032\004\030\0010\035X¦\004¢\006\006\032\004\b\036\020\037R\022\020 \032\0020!X¦\004¢\006\006\032\004\b\"\020#R\022\020$\032\0020%X¦\004¢\006\006\032\004\b&\020'R\024\020(\032\0020)8gX¦\004¢\006\006\032\004\b(\020*R\022\020+\032\0020)X¦\004¢\006\006\032\004\b+\020*R\022\020,\032\0020)X¦\004¢\006\006\032\004\b,\020*R\024\020-\032\004\030\0010\035X¦\004¢\006\006\032\004\b.\020\037R\030\020/\032\00200X¦\016¢\006\f\032\004\b1\0202\"\004\b3\0204R\022\0205\032\00200X¦\004¢\006\006\032\004\b6\0202R\024\0207\032\004\030\0010%X¦\004¢\006\006\032\004\b8\020'R\022\0209\032\0020:X¦\004¢\006\006\032\004\b;\020<R\030\020=\032\00200X¦\016¢\006\f\032\004\b>\0202\"\004\b?\0204R\030\020@\032\0020)X¦\016¢\006\f\032\004\bA\020*\"\004\bB\020CR\024\020D\032\0020)8gX¦\004¢\006\006\032\004\bE\020*R\030\020F\032\0020\003X¦\016¢\006\f\032\004\bG\020\005\"\004\bH\020\007¨\006Y"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "cameraYaw", "", "getCameraYaw", "()F", "setCameraYaw", "(F)V", "capabilities", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;", "getCapabilities", "()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IPlayerCapabilities;", "displayNameString", "", "getDisplayNameString", "()Ljava/lang/String;", "fishEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getFishEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "foodStats", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IFoodStats;", "getFoodStats", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IFoodStats;", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "getGameProfile", "()Lcom/mojang/authlib/GameProfile;", "heldItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "getHeldItem", "()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "inventory", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;", "getInventory", "()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;", "inventoryContainer", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "getInventoryContainer", "()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "isBlocking", "", "()Z", "isPlayerSleeping", "isUsingItem", "itemInUse", "getItemInUse", "itemInUseCount", "", "getItemInUseCount", "()I", "setItemInUseCount", "(I)V", "itemInUseDuration", "getItemInUseDuration", "openContainer", "getOpenContainer", "prevChasingPosY", "", "getPrevChasingPosY", "()D", "sleepTimer", "getSleepTimer", "setSleepTimer", "sleeping", "getSleeping", "setSleeping", "(Z)V", "spectator", "isSpectator", "speedInAir", "getSpeedInAir", "setSpeedInAir", "attackTargetEntityWithCurrentItem", "", "entity", "fall", "distance", "damageMultiplier", "getCooledAttackStrength", "fl", "jump", "onCriticalHit", "onEnchantmentCritical", "resetCooldown", "stopUsingItem", "triggerAchievement", "stat", "Lnet/ccbluex/liquidbounce/api/minecraft/stats/IStatBase;", "XSJClient"})
public interface IEntityPlayer extends IEntityLivingBase {
  @NotNull
  GameProfile getGameProfile();
  
  @Nullable
  IEntity getFishEntity();
  
  @NotNull
  IFoodStats getFoodStats();
  
  double getPrevChasingPosY();
  
  int getSleepTimer();
  
  void setSleepTimer(int paramInt);
  
  boolean getSleeping();
  
  void setSleeping(boolean paramBoolean);
  
  boolean isPlayerSleeping();
  
  float getSpeedInAir();
  
  void setSpeedInAir(float paramFloat);
  
  float getCameraYaw();
  
  void setCameraYaw(float paramFloat);
  
  @JvmName(name = "isBlocking")
  boolean isBlocking();
  
  int getItemInUseCount();
  
  void setItemInUseCount(int paramInt);
  
  @Nullable
  IItemStack getItemInUse();
  
  @NotNull
  IPlayerCapabilities getCapabilities();
  
  @Nullable
  IItemStack getHeldItem();
  
  boolean isUsingItem();
  
  @NotNull
  IContainer getInventoryContainer();
  
  @NotNull
  IInventoryPlayer getInventory();
  
  @Nullable
  IContainer getOpenContainer();
  
  int getItemInUseDuration();
  
  @NotNull
  String getDisplayNameString();
  
  @JvmName(name = "isSpectator")
  boolean isSpectator();
  
  void stopUsingItem();
  
  void onCriticalHit(@NotNull IEntity paramIEntity);
  
  void onEnchantmentCritical(@NotNull IEntityLivingBase paramIEntityLivingBase);
  
  void attackTargetEntityWithCurrentItem(@NotNull IEntity paramIEntity);
  
  void fall(float paramFloat1, float paramFloat2);
  
  void triggerAchievement(@NotNull IStatBase paramIStatBase);
  
  void jump();
  
  @SupportsMinecraftVersions({MinecraftVersion.MC_1_12})
  float getCooledAttackStrength(float paramFloat);
  
  void resetCooldown();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\entity\player\IEntityPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */