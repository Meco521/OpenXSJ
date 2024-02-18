/*    */ package net.ccbluex.liquidbounce.utils.render.shader.shaders;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.render.shader.FramebufferShader;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ 
/*    */ public final class OutlineShader
/*    */   extends FramebufferShader {
/*  8 */   public static final OutlineShader OUTLINE_SHADER = new OutlineShader();
/*    */   
/*    */   public OutlineShader() {
/* 11 */     super("outline.frag");
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupUniforms() {
/* 16 */     setupUniform("texture");
/* 17 */     setupUniform("texelSize");
/* 18 */     setupUniform("color");
/* 19 */     setupUniform("divider");
/* 20 */     setupUniform("radius");
/* 21 */     setupUniform("maxSample");
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateUniforms() {
/* 26 */     GL20.glUniform1i(getUniform("texture"), 0);
/* 27 */     GL20.glUniform2f(getUniform("texelSize"), 1.0F / mc.getDisplayWidth() * this.radius * this.quality, 1.0F / mc.getDisplayHeight() * this.radius * this.quality);
/* 28 */     GL20.glUniform4f(getUniform("color"), this.red, this.green, this.blue, this.alpha);
/* 29 */     GL20.glUniform1f(getUniform("radius"), this.radius);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\shader\shaders\OutlineShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */