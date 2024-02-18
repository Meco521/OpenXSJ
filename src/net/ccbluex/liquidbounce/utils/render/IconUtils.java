/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.ByteBuffer;
/*    */ import javax.imageio.ImageIO;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public final class IconUtils
/*    */ {
/*    */   public static ByteBuffer[] getFavicon() {
/*    */     try {
/* 17 */       return new ByteBuffer[] { readImageToBuffer(IconUtils.class.getResourceAsStream("/assets/minecraft/tomk/icon_16x16.png")), readImageToBuffer(IconUtils.class.getResourceAsStream("/assets/minecraft/tomk/icon_32x32.png")) };
/* 18 */     } catch (IOException e) {
/* 19 */       e.printStackTrace();
/*    */       
/* 21 */       return null;
/*    */     } 
/*    */   }
/*    */   private static ByteBuffer readImageToBuffer(InputStream imageStream) throws IOException {
/* 25 */     if (imageStream == null) {
/* 26 */       return null;
/*    */     }
/* 28 */     BufferedImage bufferedImage = ImageIO.read(imageStream);
/* 29 */     int[] rgb = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
/* 30 */     ByteBuffer byteBuffer = ByteBuffer.allocate(4 * rgb.length);
/* 31 */     for (int i : rgb)
/* 32 */       byteBuffer.putInt(i << 8 | i >> 24 & 0xFF); 
/* 33 */     byteBuffer.flip();
/* 34 */     return byteBuffer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\IconUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */