package net.ccbluex.liquidbounce.api.minecraft.renderer.entity;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\004\n\002\020\007\n\002\b\007\n\002\020\006\n\002\b\r\n\002\020\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\006\bf\030\0002\0020\001J0\020\035\032\0020\0362\006\020\037\032\0020 2\006\020!\032\0020\0202\006\020\"\032\0020\0202\006\020#\032\0020\0202\006\020$\032\0020\bH&J \020%\032\0020\0032\006\020\037\032\0020&2\006\020'\032\0020\b2\006\020(\032\0020\003H&J8\020)\032\0020\0032\006\020*\032\0020+2\006\020,\032\0020\0202\006\020-\032\0020\0202\006\020.\032\0020\0202\006\020/\032\0020\b2\006\0200\032\0020\bH&R\030\020\002\032\0020\003X¦\016¢\006\f\032\004\b\002\020\004\"\004\b\005\020\006R\022\020\007\032\0020\bX¦\004¢\006\006\032\004\b\t\020\nR\030\020\013\032\0020\bX¦\016¢\006\f\032\004\b\f\020\n\"\004\b\r\020\016R\022\020\017\032\0020\020X¦\004¢\006\006\032\004\b\021\020\022R\022\020\023\032\0020\020X¦\004¢\006\006\032\004\b\024\020\022R\022\020\025\032\0020\020X¦\004¢\006\006\032\004\b\026\020\022R\022\020\027\032\0020\020X¦\004¢\006\006\032\004\b\030\020\022R\022\020\031\032\0020\020X¦\004¢\006\006\032\004\b\032\020\022R\022\020\033\032\0020\020X¦\004¢\006\006\032\004\b\034\020\022¨\0061"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;", "", "isRenderShadow", "", "()Z", "setRenderShadow", "(Z)V", "playerViewX", "", "getPlayerViewX", "()F", "playerViewY", "getPlayerViewY", "setPlayerViewY", "(F)V", "renderPosX", "", "getRenderPosX", "()D", "renderPosY", "getRenderPosY", "renderPosZ", "getRenderPosZ", "viewerPosX", "getViewerPosX", "viewerPosY", "getViewerPosY", "viewerPosZ", "getViewerPosZ", "renderEntityAt", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "x", "y", "z", "partialTicks", "renderEntityStatic", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "renderPartialTicks", "hideDebugBox", "renderEntityWithPosYaw", "entityLivingBase", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "d", "d1", "d2", "fl", "fl1", "XSJClient"})
public interface IRenderManager {
  boolean isRenderShadow();
  
  void setRenderShadow(boolean paramBoolean);
  
  double getViewerPosX();
  
  double getViewerPosY();
  
  double getViewerPosZ();
  
  float getPlayerViewX();
  
  float getPlayerViewY();
  
  void setPlayerViewY(float paramFloat);
  
  double getRenderPosX();
  
  double getRenderPosY();
  
  double getRenderPosZ();
  
  boolean renderEntityStatic(@NotNull IEntity paramIEntity, float paramFloat, boolean paramBoolean);
  
  void renderEntityAt(@NotNull ITileEntity paramITileEntity, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat);
  
  boolean renderEntityWithPosYaw(@NotNull IEntityLivingBase paramIEntityLivingBase, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\renderer\entity\IRenderManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */