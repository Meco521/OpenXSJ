package net.ccbluex.liquidbounce.api.minecraft.potion;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\007\n\002\020\016\n\000\bf\030\0002\0020\001J\b\020\n\032\0020\013H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\003X¦\004¢\006\006\032\004\b\007\020\005R\022\020\b\032\0020\003X¦\004¢\006\006\032\004\b\t\020\005¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "", "amplifier", "", "getAmplifier", "()I", "duration", "getDuration", "potionID", "getPotionID", "getDurationString", "", "XSJClient"})
public interface IPotionEffect {
  @NotNull
  String getDurationString();
  
  int getAmplifier();
  
  int getDuration();
  
  int getPotionID();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\potion\IPotionEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */