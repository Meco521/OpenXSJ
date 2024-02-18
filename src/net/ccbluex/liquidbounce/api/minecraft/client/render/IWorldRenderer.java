package net.ccbluex.liquidbounce.api.minecraft.client.render;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.render.vertex.IVertexFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\007\n\002\020\006\n\002\b\007\bf\030\0002\0020\001J\030\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\006\032\0020\007H&J(\020\016\032\0020\0002\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\022\032\0020\0202\006\020\023\032\0020\020H&J\b\020\024\032\0020\013H&J\b\020\025\032\0020\013H&J \020\026\032\0020\0002\006\020\027\032\0020\0302\006\020\031\032\0020\0302\006\020\032\032\0020\030H&J\b\020\033\032\0020\013H&J\030\020\034\032\0020\0002\006\020\035\032\0020\0302\006\020\036\032\0020\030H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\t¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IWorldRenderer;", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "vertexFormat", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "getVertexFormat", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "begin", "", "mode", "", "color", "red", "", "green", "blue", "alpha", "endVertex", "finishDrawing", "pos", "x", "", "y", "z", "reset", "tex", "u", "v", "XSJClient"})
public interface IWorldRenderer {
  @NotNull
  ByteBuffer getByteBuffer();
  
  @NotNull
  IVertexFormat getVertexFormat();
  
  void begin(int paramInt, @NotNull IVertexFormat paramIVertexFormat);
  
  @NotNull
  IWorldRenderer pos(double paramDouble1, double paramDouble2, double paramDouble3);
  
  void endVertex();
  
  @NotNull
  IWorldRenderer tex(double paramDouble1, double paramDouble2);
  
  @NotNull
  IWorldRenderer color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void finishDrawing();
  
  void reset();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\render\IWorldRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */