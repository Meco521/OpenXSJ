package net.ccbluex.liquidbounce.api.minecraft.client.renderer;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.shader.IShaderGroup;
import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\007\n\000\n\002\020\b\n\002\b\003\bf\030\0002\0020\001J\b\020\006\032\0020\007H&J\b\020\b\032\0020\tH&J\020\020\n\032\0020\0072\006\020\013\032\0020\fH&J\020\020\r\032\0020\0072\006\020\013\032\0020\016H&J\030\020\017\032\0020\0072\006\020\020\032\0020\0212\006\020\022\032\0020\023H&J\b\020\024\032\0020\007H&J\b\020\025\032\0020\007H&R\024\020\002\032\004\030\0010\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IEntityRenderer;", "", "shaderGroup", "Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IShaderGroup;", "getShaderGroup", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IShaderGroup;", "disableLightmap", "", "isShaderActive", "", "loadShader", "resourceLocation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "loadShader2", "Lnet/minecraft/util/ResourceLocation;", "setupCameraTransform", "partialTicks", "", "i", "", "setupOverlayRendering", "stopUseShader", "XSJClient"})
public interface IEntityRenderer {
  @Nullable
  IShaderGroup getShaderGroup();
  
  void disableLightmap();
  
  boolean isShaderActive();
  
  void loadShader(@NotNull IResourceLocation paramIResourceLocation);
  
  void loadShader2(@NotNull ResourceLocation paramResourceLocation);
  
  void stopUseShader();
  
  void setupCameraTransform(float paramFloat, int paramInt);
  
  void setupOverlayRendering();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\renderer\IEntityRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */