package net.ccbluex.liquidbounce.api.minecraft;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.minecraft.util.EnumParticleTypes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\006\n\002\b\007\bf\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\007H&JH\020\b\032\0020\0032\006\020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\f2\006\020\016\032\0020\f2\006\020\017\032\0020\f2\006\020\020\032\0020\f2\006\020\021\032\0020\f2\006\020\022\032\0020\nH&¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/IParticleManager;", "", "emitParticleAtEntity", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "buffer", "Lnet/minecraft/util/EnumParticleTypes;", "spawnEffectParticle", "particleID", "", "posX", "", "posY", "posZ", "motionX", "motionY", "motionZ", "StateId", "XSJClient"})
public interface IParticleManager {
  void emitParticleAtEntity(@NotNull IEntity paramIEntity, @NotNull EnumParticleTypes paramEnumParticleTypes);
  
  void spawnEffectParticle(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, int paramInt2);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\IParticleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */