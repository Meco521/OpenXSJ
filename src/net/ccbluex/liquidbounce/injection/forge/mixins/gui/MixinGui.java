package net.ccbluex.liquidbounce.injection.forge.mixins.gui;

import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({Gui.class})
public abstract class MixinGui {
  @Shadow
  protected float field_73735_i;
  
  @Shadow
  public abstract void func_73729_b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */