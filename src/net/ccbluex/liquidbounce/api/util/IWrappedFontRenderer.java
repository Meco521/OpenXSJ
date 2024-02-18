package net.ccbluex.liquidbounce.api.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\n\002\020\007\n\002\b\003\n\002\020\013\n\002\b\006\n\002\020\f\n\002\b\004\bf\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\0072\006\020\t\032\0020\003H&J0\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\0072\006\020\t\032\0020\0032\006\020\n\032\0020\013H&J(\020\f\032\0020\0032\006\020\r\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\0072\006\020\t\032\0020\003H&J*\020\016\032\0020\0032\b\020\004\032\004\030\0010\0052\006\020\006\032\0020\0072\006\020\b\032\0020\0072\006\020\t\032\0020\003H&J2\020\016\032\0020\0032\b\020\r\032\004\030\0010\0052\006\020\006\032\0020\0072\006\020\b\032\0020\0072\006\020\t\032\0020\0032\006\020\n\032\0020\013H&J*\020\017\032\0020\0032\b\020\r\032\004\030\0010\0052\006\020\006\032\0020\0072\006\020\b\032\0020\0072\006\020\t\032\0020\003H&J\020\020\020\032\0020\0032\006\020\021\032\0020\022H&J\020\020\023\032\0020\0032\006\020\024\032\0020\022H&J\022\020\025\032\0020\0032\b\020\r\032\004\030\0010\005H&¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;", "", "drawCenteredString", "", "s", "", "x", "", "y", "color", "shadow", "", "drawCenteredStringWithShadow", "text", "drawString", "drawStringWithShadow", "getCharWidth", "character", "", "getColorCode", "charCode", "getStringWidth", "XSJClient"})
public interface IWrappedFontRenderer {
  int drawString(@Nullable String paramString, float paramFloat1, float paramFloat2, int paramInt);
  
  int drawStringWithShadow(@Nullable String paramString, float paramFloat1, float paramFloat2, int paramInt);
  
  int drawCenteredString(@NotNull String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  int drawCenteredString(@NotNull String paramString, float paramFloat1, float paramFloat2, int paramInt);
  
  int drawString(@Nullable String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  int drawCenteredStringWithShadow(@NotNull String paramString, float paramFloat1, float paramFloat2, int paramInt);
  
  int getColorCode(char paramChar);
  
  int getStringWidth(@Nullable String paramString);
  
  int getCharWidth(char paramChar);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\IWrappedFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */