package net.ccbluex.liquidbounce.api.minecraft.client.render.entity;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\020\000\n\000\n\002\020\007\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\000\bf\030\0002\0020\001J \020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\016\032\0020\rH&J \020\017\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\016\032\0020\rH&J(\020\020\032\0020\t2\006\020\021\032\0020\0222\006\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\016\032\0020\rH&R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\004\020\005\"\004\b\006\020\007¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/render/entity/IRenderItem;", "", "zLevel", "", "getZLevel", "()F", "setZLevel", "(F)V", "renderItemAndEffectIntoGUI", "", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "x", "", "y", "renderItemIntoGUI", "renderItemOverlays", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "XSJClient"})
public interface IRenderItem {
  float getZLevel();
  
  void setZLevel(float paramFloat);
  
  void renderItemAndEffectIntoGUI(@NotNull IItemStack paramIItemStack, int paramInt1, int paramInt2);
  
  void renderItemIntoGUI(@NotNull IItemStack paramIItemStack, int paramInt1, int paramInt2);
  
  void renderItemOverlays(@NotNull IFontRenderer paramIFontRenderer, @NotNull IItemStack paramIItemStack, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\render\entity\IRenderItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */