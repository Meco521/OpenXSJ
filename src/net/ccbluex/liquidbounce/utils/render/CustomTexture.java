/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class CustomTexture
/*    */ {
/*    */   private final BufferedImage image;
/*    */   private boolean unloaded;
/* 12 */   private int textureId = -1;
/*    */   
/*    */   public CustomTexture(BufferedImage image) {
/* 15 */     this.image = image;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTextureId() {
/* 23 */     if (this.unloaded) {
/* 24 */       throw new IllegalStateException("Texture unloaded");
/*    */     }
/* 26 */     if (this.textureId == -1) {
/* 27 */       this.textureId = TextureUtil.func_110989_a(TextureUtil.func_110996_a(), this.image, true, true);
/*    */     }
/* 29 */     return this.textureId;
/*    */   }
/*    */   
/*    */   public void unload() {
/* 33 */     if (!this.unloaded) {
/* 34 */       GL11.glDeleteTextures(this.textureId);
/* 35 */       this.unloaded = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void finalize() throws Throwable {
/* 41 */     super.finalize();
/*    */     
/* 43 */     unload();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\CustomTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */