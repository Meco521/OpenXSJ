package net.ccbluex.liquidbounce.api.minecraft.client.render;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\bf\030\0002\0020\001J\b\020\006\032\0020\007H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/render/ITessellator;", "", "worldRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IWorldRenderer;", "getWorldRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IWorldRenderer;", "draw", "", "XSJClient"})
public interface ITessellator {
  @NotNull
  IWorldRenderer getWorldRenderer();
  
  void draw();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\render\ITessellator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */