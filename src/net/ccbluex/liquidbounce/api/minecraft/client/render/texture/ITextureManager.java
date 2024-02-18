package net.ccbluex.liquidbounce.api.minecraft.client.render.texture;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\020\020\006\032\0020\0032\006\020\004\032\0020\007H&J\030\020\b\032\0020\t2\006\020\n\032\0020\0052\006\020\013\032\0020\fH&¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;", "", "bindTexture", "", "image", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "bindTexture2", "Lnet/minecraft/util/ResourceLocation;", "loadTexture", "", "textureLocation", "textureObj", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/IAbstractTexture;", "XSJClient"})
public interface ITextureManager {
  boolean loadTexture(@NotNull IResourceLocation paramIResourceLocation, @NotNull IAbstractTexture paramIAbstractTexture);
  
  void bindTexture(@NotNull IResourceLocation paramIResourceLocation);
  
  void bindTexture2(@NotNull ResourceLocation paramResourceLocation);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\render\texture\ITextureManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */