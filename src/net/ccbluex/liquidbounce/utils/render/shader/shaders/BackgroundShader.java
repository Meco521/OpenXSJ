/*    */ package net.ccbluex.liquidbounce.utils.render.shader.shaders;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.shader.Shader;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ 
/*    */ public final class BackgroundShader
/*    */   extends Shader
/*    */ {
/* 11 */   public static final BackgroundShader BACKGROUND_SHADER = new BackgroundShader();
/*    */   
/*    */   private float time;
/*    */   
/*    */   public BackgroundShader() {
/* 16 */     super("background.frag");
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupUniforms() {
/* 21 */     setupUniform("iResolution");
/* 22 */     setupUniform("iTime");
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateUniforms() {
/* 27 */     IScaledResolution scaledResolution = classProvider.createScaledResolution(mc);
/*    */     
/* 29 */     int resolutionID = getUniform("iResolution");
/* 30 */     if (resolutionID > -1)
/* 31 */       GL20.glUniform2f(resolutionID, scaledResolution.getScaledWidth() * 2.0F, scaledResolution.getScaledHeight() * 2.0F); 
/* 32 */     int timeID = getUniform("iTime");
/* 33 */     if (timeID > -1) GL20.glUniform1f(timeID, this.time);
/*    */     
/* 35 */     this.time += 0.005F * RenderUtils.deltaTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\shader\shaders\BackgroundShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */