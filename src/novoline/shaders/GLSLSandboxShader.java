/*    */ package novoline.shaders;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.lwjgl.opengl.GL20;
/*    */ 
/*    */ public class GLSLSandboxShader
/*    */ {
/*    */   private final int programId;
/*    */   private final int timeUniform;
/*    */   private final int mouseUniform;
/*    */   private final int resolutionUniform;
/*    */   
/*    */   public GLSLSandboxShader(String fragmentShaderLocation) throws IOException {
/* 17 */     int program = GL20.glCreateProgram();
/*    */ 
/*    */     
/* 20 */     GL20.glAttachShader(program, createShader(GLSLSandboxShader.class.getResourceAsStream(fragmentShaderLocation), 35632));
/*    */     
/* 22 */     GL20.glLinkProgram(program);
/*    */     
/* 24 */     int linked = GL20.glGetProgrami(program, 35714);
/*    */ 
/*    */     
/* 27 */     if (linked == 0) {
/* 28 */       System.err.println(GL20.glGetProgramInfoLog(program, GL20.glGetProgrami(program, 35716)));
/*    */       
/* 30 */       throw new IllegalStateException("link");
/*    */     } 
/*    */     
/* 33 */     this.programId = program;
/*    */ 
/*    */     
/* 36 */     GL20.glUseProgram(program);
/*    */     
/* 38 */     this.timeUniform = GL20.glGetUniformLocation(program, "time");
/* 39 */     this.mouseUniform = GL20.glGetUniformLocation(program, "mouse");
/* 40 */     this.resolutionUniform = GL20.glGetUniformLocation(program, "resolution");
/*    */     
/* 42 */     GL20.glUseProgram(0);
/*    */   }
/*    */   
/*    */   public void useShader(int width, int height, float mouseX, float mouseY, float time) {
/* 46 */     GL20.glUseProgram(this.programId);
/*    */     
/* 48 */     GL20.glUniform2f(this.resolutionUniform, width, height);
/* 49 */     GL20.glUniform2f(this.mouseUniform, mouseX / width, 1.0F - mouseY / height);
/* 50 */     GL20.glUniform1f(this.timeUniform, time);
/*    */   }
/*    */   
/*    */   private int createShader(InputStream inputStream, int shaderType) throws IOException {
/* 54 */     int shader = GL20.glCreateShader(shaderType);
/*    */     
/* 56 */     GL20.glShaderSource(shader, readStreamToString(inputStream));
/*    */     
/* 58 */     GL20.glCompileShader(shader);
/*    */     
/* 60 */     int compiled = GL20.glGetShaderi(shader, 35713);
/*    */ 
/*    */     
/* 63 */     if (compiled == 0) {
/* 64 */       System.err.println(GL20.glGetShaderInfoLog(shader, GL20.glGetShaderi(shader, 35716)));
/*    */       
/* 66 */       throw new IllegalStateException("compile");
/*    */     } 
/*    */     
/* 69 */     return shader;
/*    */   }
/*    */   
/*    */   private String readStreamToString(InputStream inputStream) throws IOException {
/* 73 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/*    */     
/* 75 */     byte[] buffer = new byte[512];
/*    */     
/*    */     int read;
/*    */     
/* 79 */     while ((read = inputStream.read(buffer, 0, buffer.length)) != -1) {
/* 80 */       out.write(buffer, 0, read);
/*    */     }
/*    */     
/* 83 */     return new String(out.toByteArray(), StandardCharsets.UTF_8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\shaders\GLSLSandboxShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */