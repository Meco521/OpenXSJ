package net.ccbluex.liquidbounce.api.minecraft.item;

import java.util.Collection;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
import net.ccbluex.liquidbounce.api.minecraft.entity.ai.attributes.IAttributeModifier;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTBase;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagCompound;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000n\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\020\t\n\002\b\n\n\002\030\002\n\002\b\007\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\036\n\002\030\002\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\003\n\002\030\002\n\000\bf\030\0002\0020\001J\030\020)\032\0020*2\006\020+\032\0020,2\006\020-\032\0020\003H&J\026\020.\032\b\022\004\022\002000/2\006\0201\032\0020\007H&J\020\0202\032\002032\006\0204\032\00205H&J\b\0206\032\00207H&J\020\0208\032\0020\0002\006\020\006\032\0020\007H&J\030\0209\032\0020*2\006\0201\032\0020\0072\006\020:\032\0020;H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\004\030\0010\013X¦\004¢\006\006\032\004\b\f\020\rR\024\020\016\032\004\030\0010\017X¦\004¢\006\006\032\004\b\020\020\021R\030\020\022\032\0020\003X¦\016¢\006\f\032\004\b\023\020\005\"\004\b\024\020\025R\022\020\026\032\0020\027X¦\004¢\006\006\032\004\b\030\020\031R\030\020\032\032\0020\003X¦\016¢\006\f\032\004\b\033\020\005\"\004\b\034\020\025R\022\020\035\032\0020\003X¦\004¢\006\006\032\004\b\036\020\005R\022\020\037\032\0020\003X¦\004¢\006\006\032\004\b \020\005R\032\020!\032\004\030\0010\"X¦\016¢\006\f\032\004\b#\020$\"\004\b%\020&R\022\020'\032\0020\007X¦\004¢\006\006\032\004\b(\020\t¨\006<"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "", "animationsToGo", "", "getAnimationsToGo", "()I", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "enchantmentTagList", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "getEnchantmentTagList", "()Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getItem", "()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "itemDamage", "getItemDamage", "setItemDamage", "(I)V", "itemDelay", "", "getItemDelay", "()J", "maxDamage", "getMaxDamage", "setMaxDamage", "maxItemUseDuration", "getMaxItemUseDuration", "stackSize", "getStackSize", "tagCompound", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "getTagCompound", "()Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "setTagCompound", "(Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;)V", "unlocalizedName", "getUnlocalizedName", "addEnchantment", "", "enchantment", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "level", "getAttributeModifier", "", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier;", "key", "getStrVsBlock", "", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "isSplash", "", "setStackDisplayName", "setTagInfo", "nbt", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "XSJClient"})
public interface IItemStack {
  int getAnimationsToGo();
  
  @NotNull
  String getDisplayName();
  
  @NotNull
  String getUnlocalizedName();
  
  int getMaxItemUseDuration();
  
  @Nullable
  INBTTagList getEnchantmentTagList();
  
  @Nullable
  INBTTagCompound getTagCompound();
  
  void setTagCompound(@Nullable INBTTagCompound paramINBTTagCompound);
  
  int getStackSize();
  
  int getItemDamage();
  
  void setItemDamage(int paramInt);
  
  @Nullable
  IItem getItem();
  
  long getItemDelay();
  
  int getMaxDamage();
  
  void setMaxDamage(int paramInt);
  
  float getStrVsBlock(@NotNull IIBlockState paramIIBlockState);
  
  void setTagInfo(@NotNull String paramString, @NotNull INBTBase paramINBTBase);
  
  @NotNull
  IItemStack setStackDisplayName(@NotNull String paramString);
  
  void addEnchantment(@NotNull IEnchantment paramIEnchantment, int paramInt);
  
  @NotNull
  Collection<IAttributeModifier> getAttributeModifier(@NotNull String paramString);
  
  boolean isSplash();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\item\IItemStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */