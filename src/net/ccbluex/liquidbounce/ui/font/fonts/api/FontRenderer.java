/*    */ package net.ccbluex.liquidbounce.ui.font.fonts.api;
/*    */ 
/*    */ public interface FontRenderer {
/*    */   float drawString(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
/*    */   
/*    */   float drawString(CharSequence paramCharSequence, double paramDouble1, double paramDouble2, int paramInt, boolean paramBoolean);
/*    */   
/*    */   String trimStringToWidth(CharSequence paramCharSequence, int paramInt, boolean paramBoolean);
/*    */   
/*    */   int stringWidth(CharSequence paramCharSequence);
/*    */   
/*    */   float charWidth(char paramChar);
/*    */   
/*    */   String getName();
/*    */   
/*    */   int getHeight();
/*    */   
/*    */   boolean isAntiAlias();
/*    */   
/*    */   boolean isFractionalMetrics();
/*    */   
/*    */   default float drawString(CharSequence text, float x, float y, int color) {
/* 23 */     return drawString(text, x, y, color, false);
/*    */   }
/*    */   default float drawString(CharSequence text, int x, int y, int color) {
/* 26 */     return drawString(text, x, y, color, false);
/*    */   }
/*    */   default String trimStringToWidth(CharSequence text, int width) {
/* 29 */     return trimStringToWidth(text, width, false);
/*    */   }
/*    */   
/*    */   default float drawCenteredString(CharSequence text, float x, float y, int color, boolean dropShadow) {
/* 33 */     return drawString(text, x - stringWidth(text) / 2.0F, y, color, dropShadow);
/*    */   }
/*    */   default float getMiddleOfBox(float boxHeight) {
/* 36 */     return boxHeight / 2.0F - getHeight() / 2.0F;
/*    */   }
/*    */   
/*    */   default float drawCenteredString(CharSequence text, float x, float y, int color) {
/* 40 */     return drawCenteredString(text, x, y, color, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\fonts\api\FontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */