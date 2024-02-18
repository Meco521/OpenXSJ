package net.ccbluex.liquidbounce.api.minecraft.client.renderer.vertex;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\bf\030\0002\0020\001J\b\020\002\032\0020\003H&J\020\020\004\032\0020\0032\006\020\005\032\0020\006H&J\b\020\007\032\0020\003H&J\020\020\b\032\0020\0032\006\020\t\032\0020\nH&J\b\020\013\032\0020\003H&¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/vertex/IVertexBuffer;", "", "bindBuffer", "", "bufferData", "buffer", "Ljava/nio/ByteBuffer;", "deleteGlBuffers", "drawArrays", "mode", "", "unbindBuffer", "XSJClient"})
public interface IVertexBuffer {
  void deleteGlBuffers();
  
  void bindBuffer();
  
  void drawArrays(int paramInt);
  
  void unbindBuffer();
  
  void bufferData(@NotNull ByteBuffer paramByteBuffer);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\renderer\vertex\IVertexBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */