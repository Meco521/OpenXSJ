package net.ccbluex.liquidbounce.injection.forge.mixins.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.FoodStats;
import net.minecraft.util.SoundEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({EntityPlayer.class})
public abstract class MixinEntityPlayer extends MixinEntityLivingBase {
  @Shadow
  @Final
  protected static DataParameter<Byte> field_184828_bq;
  
  @Shadow
  public PlayerCapabilities field_71075_bZ;
  
  @Shadow
  protected int field_71101_bC;
  
  @Shadow
  public abstract ItemStack func_184582_a(EntityEquipmentSlot paramEntityEquipmentSlot);
  
  @Shadow
  public abstract GameProfile func_146103_bH();
  
  @Shadow
  protected abstract boolean func_70041_e_();
  
  @Shadow
  protected abstract SoundEvent func_184184_Z();
  
  @Shadow
  public abstract FoodStats func_71024_bL();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\entity\MixinEntityPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */