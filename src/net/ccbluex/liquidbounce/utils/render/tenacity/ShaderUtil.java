/*     */ package net.ccbluex.liquidbounce.utils.render.tenacity;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.normal.Utils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShaderUtil
/*     */   implements Utils
/*     */ {
/*     */   private final int programID;
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc, String vertexShaderLoc) {
/*  21 */     int program = GL20.glCreateProgram();
/*     */     try {
/*     */       int fragmentShaderID;
/*  24 */       switch (fragmentShaderLoc) {
/*     */         case "roundedRect":
/*  26 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.roundedRect.getBytes()), 35632);
/*     */           break;
/*     */         case "roundedRectGradient":
/*  29 */           fragmentShaderID = createShader(new ByteArrayInputStream("#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}".getBytes()), 35632);
/*     */           break;
/*     */         default:
/*  32 */           fragmentShaderID = createShader(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(fragmentShaderLoc)).func_110527_b(), 35632);
/*     */           break;
/*     */       } 
/*  35 */       GL20.glAttachShader(program, fragmentShaderID);
/*     */       
/*  37 */       int vertexShaderID = createShader(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(vertexShaderLoc)).func_110527_b(), 35633);
/*  38 */       GL20.glAttachShader(program, vertexShaderID);
/*     */     
/*     */     }
/*  41 */     catch (IOException e) {
/*  42 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  45 */     GL20.glLinkProgram(program);
/*  46 */     int status = GL20.glGetProgrami(program, 35714);
/*     */     
/*  48 */     if (status == 0) {
/*  49 */       throw new IllegalStateException("Shader failed to link!");
/*     */     }
/*  51 */     this.programID = program;
/*     */   }
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc) {
/*  55 */     this(fragmentShaderLoc, "tomk/shader/vertex.vsh");
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  60 */     GL20.glUseProgram(this.programID);
/*     */   }
/*     */   
/*     */   public void unload() {
/*  64 */     GL20.glUseProgram(0);
/*     */   }
/*     */   
/*     */   public int getUniform(String name) {
/*  68 */     return GL20.glGetUniformLocation(this.programID, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUniformf(String name, float... args) {
/*  73 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/*  74 */     switch (args.length) {
/*     */       case 1:
/*  76 */         GL20.glUniform1f(loc, args[0]);
/*     */         break;
/*     */       case 2:
/*  79 */         GL20.glUniform2f(loc, args[0], args[1]);
/*     */         break;
/*     */       case 3:
/*  82 */         GL20.glUniform3f(loc, args[0], args[1], args[2]);
/*     */         break;
/*     */       case 4:
/*  85 */         GL20.glUniform4f(loc, args[0], args[1], args[2], args[3]);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setUniformi(String name, int... args) {
/*  91 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/*  92 */     if (args.length > 1) { GL20.glUniform2i(loc, args[0], args[1]); }
/*  93 */     else { GL20.glUniform1i(loc, args[0]); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void drawQuads(float x, float y, float width, float height) {
/*  98 */     GL11.glBegin(7);
/*  99 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 100 */     GL11.glVertex2f(x, y);
/* 101 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 102 */     GL11.glVertex2f(x, y + height);
/* 103 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 104 */     GL11.glVertex2f(x + width, y + height);
/* 105 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 106 */     GL11.glVertex2f(x + width, y);
/* 107 */     GL11.glEnd();
/*     */   }
/*     */   public static void drawQuads(ScaledResolution sr) {
/* 110 */     float width = (float)sr.func_78327_c();
/* 111 */     float height = (float)sr.func_78324_d();
/* 112 */     GL11.glBegin(7);
/* 113 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 114 */     GL11.glVertex2f(0.0F, 0.0F);
/* 115 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 116 */     GL11.glVertex2f(0.0F, height);
/* 117 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 118 */     GL11.glVertex2f(width, height);
/* 119 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 120 */     GL11.glVertex2f(width, 0.0F);
/* 121 */     GL11.glEnd();
/*     */   }
/*     */   
/*     */   public static void drawQuads() {
/* 125 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 126 */     float width = (float)sr.func_78327_c();
/* 127 */     float height = (float)sr.func_78324_d();
/* 128 */     GL11.glBegin(7);
/* 129 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 130 */     GL11.glVertex2f(0.0F, 0.0F);
/* 131 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 132 */     GL11.glVertex2f(0.0F, height);
/* 133 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 134 */     GL11.glVertex2f(width, height);
/* 135 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 136 */     GL11.glVertex2f(width, 0.0F);
/* 137 */     GL11.glEnd();
/*     */   }
/*     */   
/*     */   private int createShader(InputStream inputStream, int shaderType) {
/* 141 */     int shader = GL20.glCreateShader(shaderType);
/* 142 */     GL20.glShaderSource(shader, FileUtils.readInputStream(inputStream));
/* 143 */     GL20.glCompileShader(shader);
/*     */ 
/*     */     
/* 146 */     if (GL20.glGetShaderi(shader, 35713) == 0) {
/* 147 */       System.out.println(GL20.glGetShaderInfoLog(shader, 4096));
/* 148 */       throw new IllegalStateException(String.format("Shader (%s) failed to compile!", new Object[] { Integer.valueOf(shaderType) }));
/*     */     } 
/*     */     
/* 151 */     return shader;
/*     */   }
/*     */ 
/*     */   
/* 155 */   private final String roundedRectGradient = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 184 */   private String roundedRect = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    // Smooth the result (free antialiasing).\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);// mix(quadColor, shadowColor, 0.0);\n\n}";
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\ShaderUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */