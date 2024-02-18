/*     */ package tomk.utils.blur;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.FileUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShaderUtil
/*     */ {
/*     */   private final int programID;
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc, String vertexShaderLoc) {
/*  20 */     int program = GL20.glCreateProgram();
/*     */     try {
/*     */       int fragmentShaderID;
/*  23 */       String roundedRectGradient = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}";
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
/*  50 */       String roundedRect = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    // Smooth the result (free antialiasing).\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);// mix(quadColor, shadowColor, 0.0);\n\n}";
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
/*  69 */       switch (fragmentShaderLoc) {
/*     */         case "roundedRect":
/*  71 */           fragmentShaderID = createShader(new ByteArrayInputStream(roundedRect.getBytes()), 35632);
/*     */           break;
/*     */         case "roundedRectGradient":
/*  74 */           fragmentShaderID = createShader(new ByteArrayInputStream(roundedRectGradient.getBytes()), 35632);
/*     */           break;
/*     */         default:
/*  77 */           fragmentShaderID = createShader(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(fragmentShaderLoc)).func_110527_b(), 35632);
/*     */           break;
/*     */       } 
/*  80 */       GL20.glAttachShader(program, fragmentShaderID);
/*     */       
/*  82 */       int vertexShaderID = createShader(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(vertexShaderLoc)).func_110527_b(), 35633);
/*  83 */       GL20.glAttachShader(program, vertexShaderID);
/*     */     
/*     */     }
/*  86 */     catch (IOException e) {
/*  87 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  90 */     GL20.glLinkProgram(program);
/*  91 */     int status = GL20.glGetProgrami(program, 35714);
/*     */     
/*  93 */     if (status == 0) {
/*  94 */       throw new IllegalStateException("Shader failed to link!");
/*     */     }
/*  96 */     this.programID = program;
/*     */   }
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc) {
/* 100 */     this(fragmentShaderLoc, "shaders/vertex.vsh");
/*     */   }
/*     */   
/*     */   public static void drawQuads() {
/* 104 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 105 */     float width = (float)sr.func_78327_c();
/* 106 */     float height = (float)sr.func_78324_d();
/* 107 */     GL11.glBegin(7);
/* 108 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 109 */     GL11.glVertex2f(0.0F, 0.0F);
/* 110 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 111 */     GL11.glVertex2f(0.0F, height);
/* 112 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 113 */     GL11.glVertex2f(width, height);
/* 114 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 115 */     GL11.glVertex2f(width, 0.0F);
/* 116 */     GL11.glEnd();
/*     */   }
/*     */   public static void drawQuads(ScaledResolution sr) {
/* 119 */     float width = (float)sr.func_78327_c();
/* 120 */     float height = (float)sr.func_78324_d();
/* 121 */     GL11.glBegin(7);
/* 122 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 123 */     GL11.glVertex2f(0.0F, 0.0F);
/* 124 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 125 */     GL11.glVertex2f(0.0F, height);
/* 126 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 127 */     GL11.glVertex2f(width, height);
/* 128 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 129 */     GL11.glVertex2f(width, 0.0F);
/* 130 */     GL11.glEnd();
/*     */   }
/*     */   
/*     */   public void init() {
/* 134 */     GL20.glUseProgram(this.programID);
/*     */   }
/*     */   
/*     */   public void unload() {
/* 138 */     GL20.glUseProgram(0);
/*     */   }
/*     */   
/*     */   public int getUniform(String name) {
/* 142 */     return GL20.glGetUniformLocation(this.programID, name);
/*     */   }
/*     */   
/*     */   public void setUniformf(String name, float... args) {
/* 146 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/* 147 */     switch (args.length) {
/*     */       case 1:
/* 149 */         GL20.glUniform1f(loc, args[0]);
/*     */         break;
/*     */       case 2:
/* 152 */         GL20.glUniform2f(loc, args[0], args[1]);
/*     */         break;
/*     */       case 3:
/* 155 */         GL20.glUniform3f(loc, args[0], args[1], args[2]);
/*     */         break;
/*     */       case 4:
/* 158 */         GL20.glUniform4f(loc, args[0], args[1], args[2], args[3]);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setUniformi(String name, int... args) {
/* 164 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/* 165 */     if (args.length > 1) { GL20.glUniform2i(loc, args[0], args[1]); }
/* 166 */     else { GL20.glUniform1i(loc, args[0]); }
/*     */   
/*     */   }
/*     */   private int createShader(InputStream inputStream, int shaderType) {
/* 170 */     int shader = GL20.glCreateShader(shaderType);
/* 171 */     GL20.glShaderSource(shader, FileUtils.readInputStream(inputStream));
/* 172 */     GL20.glCompileShader(shader);
/*     */ 
/*     */     
/* 175 */     if (GL20.glGetShaderi(shader, 35713) == 0) {
/* 176 */       System.out.println(GL20.glGetShaderInfoLog(shader, 4096));
/* 177 */       throw new IllegalStateException(String.format("Shader (%s) failed to compile!", new Object[] { Integer.valueOf(shaderType) }));
/*     */     } 
/*     */     
/* 180 */     return shader;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\blur\ShaderUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */