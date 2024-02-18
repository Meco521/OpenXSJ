package net.ccbluex.liquidbounce.api;

import com.mojang.authlib.GameProfile;
import java.util.Collection;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
import net.ccbluex.liquidbounce.api.minecraft.entity.IEnumCreatureAttribute;
import net.ccbluex.liquidbounce.api.minecraft.inventory.ISlot;
import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
import net.ccbluex.liquidbounce.api.minecraft.scoreboard.ITeam;
import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\020\016\n\002\b\002\n\002\020\021\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\004\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\bf\030\0002\0020\001J \020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\003H&J\b\020\t\032\0020\nH&J\b\020\013\032\0020\nH&J\b\020\f\032\0020\nH&J)\020\r\032\0020\0162\006\020\017\032\0020\0162\022\020\020\032\n\022\006\b\001\022\0020\0160\021\"\0020\016H&¢\006\002\020\022J\022\020\023\032\004\030\0010\0242\006\020\025\032\0020\026H&J\022\020\027\032\004\030\0010\0242\006\020\030\032\0020\016H&J\016\020\031\032\b\022\004\022\0020\0330\032H&J\022\020\034\032\004\030\0010\0352\006\020\036\032\0020\026H&J\022\020\037\032\004\030\0010\0352\006\020 \032\0020\016H&J\016\020!\032\b\022\004\022\0020\0330\032H&J\020\020\"\032\0020\0262\006\020#\032\0020\024H&J\020\020$\032\0020\0262\006\020%\032\0020&H&J\022\020'\032\004\030\0010&2\006\020\025\032\0020\026H&J\022\020(\032\004\030\0010&2\006\020\030\032\0020\016H&J\016\020)\032\b\022\004\022\0020\0330\032H&J\032\020*\032\0020+2\b\020,\032\004\030\0010\0072\006\020-\032\0020.H&J\022\020/\032\004\030\0010&2\006\0200\032\0020\033H&J\020\0201\032\002022\006\0203\032\0020\026H&J\020\0204\032\002052\006\0206\032\0020\016H&J \0207\032\0020\n2\006\0208\032\002092\006\020:\032\0020+2\006\020;\032\0020\026H&J\032\020<\032\0020\0162\b\020=\032\004\030\0010>2\006\020?\032\0020\016H&J \020@\032\0020\n2\006\020A\032\0020B2\006\020C\032\0020\0162\006\020D\032\0020\016H&J\b\020E\032\0020\nH&J\b\020F\032\0020\nH&¨\006G"}, d2 = {"Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;", "", "canAddItemToSlot", "", "slotIn", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "stackSizeMatters", "disableFastRender", "", "disableStandardItemLighting", "enableStandardItemLighting", "formatI18n", "", "key", "values", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getBlockById", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "id", "", "getBlockFromName", "name", "getBlockRegistryKeys", "", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "getEnchantmentById", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "enchantID", "getEnchantmentByLocation", "location", "getEnchantments", "getIdFromBlock", "block", "getIdFromItem", "sb", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getItemById", "getItemByName", "getItemRegistryKeys", "getModifierForCreature", "", "heldItem", "creatureAttribute", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "getObjectFromItemRegistry", "res", "getPotionById", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "potionID", "jsonToComponent", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "toString", "renderTileEntity", "tileEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "partialTicks", "destroyStage", "scoreboardFormatPlayerName", "scorePlayerTeam", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "playerName", "sessionServiceJoinServer", "profile", "Lcom/mojang/authlib/GameProfile;", "token", "sessionHash", "setActiveTextureDefaultTexUnit", "setActiveTextureLightMapTexUnit", "XSJClient"})
public interface IExtractedFunctions {
  @Nullable
  IBlock getBlockById(int paramInt);
  
  int getIdFromBlock(@NotNull IBlock paramIBlock);
  
  float getModifierForCreature(@Nullable IItemStack paramIItemStack, @NotNull IEnumCreatureAttribute paramIEnumCreatureAttribute);
  
  @Nullable
  IItem getObjectFromItemRegistry(@NotNull IResourceLocation paramIResourceLocation);
  
  void renderTileEntity(@NotNull ITileEntity paramITileEntity, float paramFloat, int paramInt);
  
  @Nullable
  IBlock getBlockFromName(@NotNull String paramString);
  
  @Nullable
  IItem getItemByName(@NotNull String paramString);
  
  @Nullable
  IEnchantment getEnchantmentByLocation(@NotNull String paramString);
  
  @Nullable
  IEnchantment getEnchantmentById(int paramInt);
  
  @NotNull
  Collection<IResourceLocation> getEnchantments();
  
  @NotNull
  Collection<IResourceLocation> getItemRegistryKeys();
  
  @NotNull
  Collection<IResourceLocation> getBlockRegistryKeys();
  
  void disableStandardItemLighting();
  
  @NotNull
  String formatI18n(@NotNull String paramString, @NotNull String... paramVarArgs);
  
  void sessionServiceJoinServer(@NotNull GameProfile paramGameProfile, @NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  IPotion getPotionById(int paramInt);
  
  void enableStandardItemLighting();
  
  @NotNull
  String scoreboardFormatPlayerName(@Nullable ITeam paramITeam, @NotNull String paramString);
  
  void disableFastRender();
  
  @NotNull
  IIChatComponent jsonToComponent(@NotNull String paramString);
  
  void setActiveTextureLightMapTexUnit();
  
  void setActiveTextureDefaultTexUnit();
  
  @Nullable
  IItem getItemById(int paramInt);
  
  int getIdFromItem(@NotNull IItem paramIItem);
  
  boolean canAddItemToSlot(@NotNull ISlot paramISlot, @NotNull IItemStack paramIItemStack, boolean paramBoolean);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\IExtractedFunctions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */