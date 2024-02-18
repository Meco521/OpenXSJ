/*    */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLShader
/*    */ {
/*    */   private int program;
/* 14 */   private final Map<String, Integer> uniformLocationMap = new HashMap<>();
/*    */   
/*    */   public GLShader(String vertexSource, String fragSource) {
/* 17 */     this.program = GL20.glCreateProgram();
/*    */ 
/*    */     
/* 20 */     GL20.glAttachShader(this.program, createShader(vertexSource, 35633));
/* 21 */     GL20.glAttachShader(this.program, createShader(fragSource, 35632));
/*    */     
/* 23 */     GL20.glLinkProgram(this.program);
/*    */     
/* 25 */     int status = GL20.glGetProgrami(this.program, 35714);
/*    */     
/* 27 */     if (status == 0) {
/*    */       
/* 29 */       this.program = -1;
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     setupUniforms();
/*    */   }
/*    */   
/*    */   private static int createShader(String source, int type) {
/* 37 */     int shader = GL20.glCreateShader(type);
/* 38 */     GL20.glShaderSource(shader, source);
/* 39 */     GL20.glCompileShader(shader);
/*    */     
/* 41 */     int status = GL20.glGetShaderi(shader, 35713);
/*    */     
/* 43 */     if (status == 0) {
/* 44 */       return -1;
/*    */     }
/*    */     
/* 47 */     return shader;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use() {
/* 52 */     GL20.glUseProgram(this.program);
/* 53 */     updateUniforms();
/*    */   }
/*    */   
/*    */   public int getProgram() {
/* 57 */     return this.program;
/*    */   }
/*    */   
/*    */   public void setupUniforms() {}
/*    */   
/*    */   public void updateUniforms() {}
/*    */   
/*    */   public void setupUniform(String uniform) {
/* 65 */     this.uniformLocationMap.put(uniform, Integer.valueOf(GL20.glGetUniformLocation(this.program, uniform)));
/*    */   }
/*    */   
/*    */   public int getUniformLocation(String uniform) {
/* 69 */     return ((Integer)this.uniformLocationMap.get(uniform)).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\GLShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */