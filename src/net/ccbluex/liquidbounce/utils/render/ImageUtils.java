/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.nio.ByteBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImageUtils
/*    */ {
/*    */   public static ByteBuffer readImageToBuffer(BufferedImage bufferedImage) {
/* 18 */     int[] rgbArray = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), (int[])null, 0, bufferedImage.getWidth());
/*    */     
/* 20 */     ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * rgbArray.length);
/* 21 */     for (int rgb : rgbArray) {
/* 22 */       byteBuffer.putInt(rgb << 8 | rgb >> 24 & 0xFF);
/*    */     }
/* 24 */     byteBuffer.flip();
/*    */     
/* 26 */     return byteBuffer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static BufferedImage resizeImage(BufferedImage image, int width, int height) {
/* 34 */     BufferedImage buffImg = new BufferedImage(width, height, 6);
/* 35 */     buffImg.getGraphics().drawImage(image.getScaledInstance(width, height, 4), 0, 0, null);
/* 36 */     return buffImg;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\ImageUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */