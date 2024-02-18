/*     */ package net.ccbluex.liquidbounce.utils.render.shader;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.lwjgl.opengl.ARBShaderObjects;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ public abstract class Shader
/*     */   extends MinecraftInstance {
/*     */   private int program;
/*     */   private Map<String, Integer> uniformsMap;
/*     */   
/*     */   public Shader(String fragmentShader) {
/*     */     int vertexShaderID, fragmentShaderID;
/*     */     try {
/*  21 */       InputStream vertexStream = getClass().getResourceAsStream("/assets/minecraft/tomk/shader/vertex.vert");
/*  22 */       vertexShaderID = createShader(IOUtils.toString(vertexStream), 35633);
/*  23 */       IOUtils.closeQuietly(vertexStream);
/*     */       
/*  25 */       InputStream fragmentStream = getClass().getResourceAsStream("/assets/minecraft/tomk/shader/fragment/" + fragmentShader);
/*  26 */       fragmentShaderID = createShader(IOUtils.toString(fragmentStream), 35632);
/*  27 */       IOUtils.closeQuietly(fragmentStream);
/*  28 */     } catch (Exception e) {
/*  29 */       e.printStackTrace();
/*     */       
/*     */       return;
/*     */     } 
/*  33 */     if (vertexShaderID == 0 || fragmentShaderID == 0) {
/*     */       return;
/*     */     }
/*  36 */     this.program = ARBShaderObjects.glCreateProgramObjectARB();
/*     */     
/*  38 */     if (this.program == 0) {
/*     */       return;
/*     */     }
/*  41 */     ARBShaderObjects.glAttachObjectARB(this.program, vertexShaderID);
/*  42 */     ARBShaderObjects.glAttachObjectARB(this.program, fragmentShaderID);
/*     */     
/*  44 */     ARBShaderObjects.glLinkProgramARB(this.program);
/*  45 */     ARBShaderObjects.glValidateProgramARB(this.program);
/*     */     
/*  47 */     ClientUtils.getLogger().info("[Shader] Successfully loaded: " + fragmentShader);
/*     */   }
/*     */   
/*     */   public void startShader() {
/*  51 */     GL11.glPushMatrix();
/*  52 */     GL20.glUseProgram(this.program);
/*     */     
/*  54 */     if (this.uniformsMap == null) {
/*  55 */       this.uniformsMap = new HashMap<>();
/*  56 */       setupUniforms();
/*     */     } 
/*     */     
/*  59 */     updateUniforms();
/*     */   }
/*     */   
/*     */   public void stopShader() {
/*  63 */     GL20.glUseProgram(0);
/*  64 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public abstract void setupUniforms();
/*     */   
/*     */   public abstract void updateUniforms();
/*     */   
/*     */   private int createShader(String shaderSource, int shaderType) {
/*  72 */     int shader = 0;
/*     */     
/*     */     try {
/*  75 */       shader = ARBShaderObjects.glCreateShaderObjectARB(shaderType);
/*     */       
/*  77 */       if (shader == 0) {
/*  78 */         return 0;
/*     */       }
/*  80 */       ARBShaderObjects.glShaderSourceARB(shader, shaderSource);
/*  81 */       ARBShaderObjects.glCompileShaderARB(shader);
/*     */       
/*  83 */       if (ARBShaderObjects.glGetObjectParameteriARB(shader, 35713) == 0) {
/*  84 */         throw new RuntimeException("Error creating shader: " + getLogInfo(shader));
/*     */       }
/*  86 */       return shader;
/*  87 */     } catch (Exception e) {
/*  88 */       ARBShaderObjects.glDeleteObjectARB(shader);
/*  89 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String getLogInfo(int i) {
/*  95 */     return ARBShaderObjects.glGetInfoLogARB(i, ARBShaderObjects.glGetObjectParameteriARB(i, 35716));
/*     */   }
/*     */   
/*     */   public void setUniform(String uniformName, int location) {
/*  99 */     this.uniformsMap.put(uniformName, Integer.valueOf(location));
/*     */   }
/*     */   
/*     */   public void setupUniform(String uniformName) {
/* 103 */     setUniform(uniformName, GL20.glGetUniformLocation(this.program, uniformName));
/*     */   }
/*     */   
/*     */   public int getUniform(String uniformName) {
/* 107 */     return ((Integer)this.uniformsMap.get(uniformName)).intValue();
/*     */   }
/*     */   
/*     */   public int getProgramId() {
/* 111 */     return this.program;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\shader\Shader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */