package net.ccbluex.liquidbounce.api.minecraft.client.render;

import java.awt.image.BufferedImage;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\bf\030\0002\0020\001J\024\020\002\032\004\030\0010\0032\b\020\004\032\004\030\0010\003H&J\b\020\005\032\0020\006H&¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/render/WIImageBuffer;", "", "parseUserSkin", "Ljava/awt/image/BufferedImage;", "image", "skinAvailable", "", "XSJClient"})
public interface WIImageBuffer {
  @Nullable
  BufferedImage parseUserSkin(@Nullable BufferedImage paramBufferedImage);
  
  void skinAvailable();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\render\WIImageBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */