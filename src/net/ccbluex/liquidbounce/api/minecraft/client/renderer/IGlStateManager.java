package net.ccbluex.liquidbounce.api.minecraft.client.renderer;

import kotlin.Metadata;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\024\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\b\020\006\032\0020\003H&J\b\020\007\032\0020\003H&J\b\020\b\032\0020\003H&J\b\020\t\032\0020\003H&J\b\020\n\032\0020\003H&J\b\020\013\032\0020\003H&J\b\020\f\032\0020\003H&J\b\020\r\032\0020\003H&J\b\020\016\032\0020\003H&J\b\020\017\032\0020\003H&J\b\020\020\032\0020\003H&J\b\020\021\032\0020\003H&J\b\020\022\032\0020\003H&J\b\020\023\032\0020\003H&J(\020\024\032\0020\0032\006\020\025\032\0020\0052\006\020\026\032\0020\0052\006\020\027\032\0020\0052\006\020\030\032\0020\005H&¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;", "", "bindTexture", "", "textureID", "", "disableBlend", "disableCull", "disableLighting", "disableRescaleNormal", "disableTexture2D", "enableAlpha", "enableBlend", "enableColorMaterial", "enableTexture2D", "popAttrib", "popMatrix", "pushAttrib", "pushMatrix", "resetColor", "tryBlendFuncSeparate", "glSrcAlpha", "glOneMinusSrcAlpha", "glOne", "glZero", "XSJClient"})
public interface IGlStateManager {
  void bindTexture(int paramInt);
  
  void resetColor();
  
  void enableTexture2D();
  
  void enableBlend();
  
  void tryBlendFuncSeparate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void disableTexture2D();
  
  void disableBlend();
  
  void enableAlpha();
  
  void disableLighting();
  
  void disableCull();
  
  void enableColorMaterial();
  
  void disableRescaleNormal();
  
  void pushMatrix();
  
  void pushAttrib();
  
  void popMatrix();
  
  void popAttrib();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\renderer\IGlStateManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */