/*     */ package net.ccbluex.liquidbounce.utils.render;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import lynn.utils.blur.MathHelper;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ public class ShaderUtil
/*     */   extends MinecraftInstance {
/*  18 */   static final ShaderUtil roundedGradientShader = new ShaderUtil("roundedRectGradient");
/*  19 */   private static final ShaderUtil roundedTexturedShader = new ShaderUtil("soar/shader/fragment/roundrecttextured.frag");
/*     */   private final int programID;
/*  21 */   private final String roundedRectGradient = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}";
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
/*  48 */   private final String roundedRect = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    // Smooth the result (free antialiasing).\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);// mix(quadColor, shadowColor, 0.0);\n\n}";
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
/*  67 */   private String circle = "uniform vec2 location, rectSize;\nuniform float radius;\nuniform vec4 color;\nfloat circle(vec2 pos)\n{\n    float d = length(pos);\n    return d;\n}\nvoid main() {\n  vec2 st = gl_FragCoord.xy - location - (rectSize * .5);\n  float distance = circle(st);\n  float blendAmount =  (1.0 - smoothstep(0.,2.,distance - radius)) * color.a;\ngl_FragColor = vec4(color.rgb, blendAmount);\n}";
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
/*     */   public ShaderUtil(String fragmentShaderLoc, String vertexShaderLoc) {
/*  83 */     int program = GL20.glCreateProgram();
/*     */     try {
/*     */       int fragmentShaderID;
/*  86 */       switch (fragmentShaderLoc) {
/*     */         case "roundedRect":
/*  88 */           fragmentShaderID = createShader(new ByteArrayInputStream("#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    // Smooth the result (free antialiasing).\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);// mix(quadColor, shadowColor, 0.0);\n\n}".getBytes()), 35632);
/*     */           break;
/*     */         case "roundedRectGradient":
/*  91 */           fragmentShaderID = createShader(new ByteArrayInputStream("#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius))) * color1.a;\n    gl_FragColor = vec4(createGradient(st, color1.rgb, color2.rgb, color3.rgb, color4.rgb), smoothedAlpha);\n}".getBytes()), 35632);
/*     */           break;
/*     */         case "circle":
/*  94 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.circle.getBytes()), 35632);
/*     */           break;
/*     */         default:
/*  97 */           fragmentShaderID = createShader(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(fragmentShaderLoc)).func_110527_b(), 35632);
/*     */           break;
/*     */       } 
/* 100 */       GL20.glAttachShader(program, fragmentShaderID);
/*     */       
/* 102 */       int vertexShaderID = createShader(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation(vertexShaderLoc)).func_110527_b(), 35633);
/* 103 */       GL20.glAttachShader(program, vertexShaderID);
/*     */     
/*     */     }
/* 106 */     catch (IOException e) {
/* 107 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 110 */     GL20.glLinkProgram(program);
/* 111 */     int status = GL20.glGetProgrami(program, 35714);
/*     */     
/* 113 */     if (status == 0) {
/* 114 */       throw new IllegalStateException("Shader failed to link!");
/*     */     }
/* 116 */     this.programID = program;
/*     */   }
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc) {
/* 120 */     this(fragmentShaderLoc, "soar/shader/vertex.vsh");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawQuads(float x, float y, float width, float height) {
/* 125 */     GL11.glBegin(7);
/* 126 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 127 */     GL11.glVertex2f(x, y);
/* 128 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 129 */     GL11.glVertex2f(x, y + height);
/* 130 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 131 */     GL11.glVertex2f(x + width, y + height);
/* 132 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 133 */     GL11.glVertex2f(x + width, y);
/* 134 */     GL11.glEnd();
/*     */   }
/*     */   public static void drawRoundedRect(float x, float y, float width, float height, float radius) {
/* 137 */     GL11.glEnable(3042);
/* 138 */     GL11.glEnable(2881);
/* 139 */     GL11.glHint(3155, 4354);
/*     */     
/* 141 */     float x1 = x + width;
/* 142 */     float y1 = y + height;
/*     */     
/* 144 */     GL11.glPushAttrib(0);
/*     */     
/* 146 */     x *= 1.0F;
/* 147 */     y *= 1.0F;
/* 148 */     x1 *= 1.0F;
/* 149 */     y1 *= 1.0F;
/*     */     
/* 151 */     GL11.glBegin(9);
/*     */     
/* 153 */     GL11.glDisable(3553);
/*     */     
/* 155 */     GlStateManager.func_179147_l();
/*     */     
/* 157 */     GL11.glEnable(2848);
/* 158 */     double v = 0.017453292519943295D;
/*     */     int i;
/* 160 */     for (i = 0; i <= 90; i += 3) {
/* 161 */       GL11.glVertex2d((x + radius + MathHelper.sin((float)(i * 0.017453292519943295D)) * radius * -1.0F), (y + radius + MathHelper.cos((float)(i * 0.017453292519943295D)) * radius * -1.0F));
/*     */     }
/*     */     
/* 164 */     for (i = 90; i <= 180; i += 3) {
/* 165 */       GL11.glVertex2d((x + radius + MathHelper.sin((float)(i * 0.017453292519943295D)) * radius * -1.0F), (y1 - radius + MathHelper.cos((float)(i * 0.017453292519943295D)) * radius * -1.0F));
/*     */     }
/*     */     
/* 168 */     for (i = 0; i <= 90; i += 3) {
/* 169 */       GL11.glVertex2d((x1 - radius + MathHelper.sin((float)(i * 0.017453292519943295D)) * radius), (y1 - radius + MathHelper.cos((float)(i * 0.017453292519943295D)) * radius));
/*     */     }
/*     */     
/* 172 */     for (i = 90; i <= 180; i += 3) {
/* 173 */       GL11.glVertex2d((x1 - radius + MathHelper.sin((float)(i * 0.017453292519943295D)) * radius), (y + radius + MathHelper.cos((float)(i * 0.017453292519943295D)) * radius));
/*     */     }
/*     */     
/* 176 */     GL11.glEnable(3553);
/*     */     
/* 178 */     GL11.glDisable(2848);
/*     */     
/* 180 */     GL11.glEnable(3553);
/*     */     
/* 182 */     GL11.glPopAttrib();
/* 183 */     GL11.glEnd();
/* 184 */     GL11.glDisable(3042);
/* 185 */     GL11.glDisable(2881);
/*     */   }
/*     */   
/*     */   public static String readInputStream(InputStream inputStream) {
/* 189 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*     */     try {
/* 192 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*     */       String line;
/* 194 */       while ((line = bufferedReader.readLine()) != null) {
/* 195 */         stringBuilder.append(line).append('\n');
/*     */       }
/* 197 */     } catch (Exception e) {
/* 198 */       e.printStackTrace();
/*     */     } 
/* 200 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public void init() {
/* 204 */     GL20.glUseProgram(this.programID);
/*     */   }
/*     */   
/*     */   public void unload() {
/* 208 */     GL20.glUseProgram(0);
/*     */   }
/*     */   
/*     */   public int getUniform(String name) {
/* 212 */     return GL20.glGetUniformLocation(this.programID, name);
/*     */   }
/*     */   
/*     */   public void setUniformf(String name, float... args) {
/* 216 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/* 217 */     switch (args.length) {
/*     */       case 1:
/* 219 */         GL20.glUniform1f(loc, args[0]);
/*     */         break;
/*     */       case 2:
/* 222 */         GL20.glUniform2f(loc, args[0], args[1]);
/*     */         break;
/*     */       case 3:
/* 225 */         GL20.glUniform3f(loc, args[0], args[1], args[2]);
/*     */         break;
/*     */       case 4:
/* 228 */         GL20.glUniform4f(loc, args[0], args[1], args[2], args[3]);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setUniformi(String name, int... args) {
/* 234 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/* 235 */     if (args.length > 1) { GL20.glUniform2i(loc, args[0], args[1]); }
/* 236 */     else { GL20.glUniform1i(loc, args[0]); }
/*     */   
/*     */   }
/*     */   private int createShader(InputStream inputStream, int shaderType) {
/* 240 */     int shader = GL20.glCreateShader(shaderType);
/* 241 */     GL20.glShaderSource(shader, readInputStream(inputStream));
/* 242 */     GL20.glCompileShader(shader);
/*     */ 
/*     */     
/* 245 */     if (GL20.glGetShaderi(shader, 35713) == 0) {
/* 246 */       System.out.println(GL20.glGetShaderInfoLog(shader, 4096));
/* 247 */       throw new IllegalStateException(String.format("Shader (%s) failed to compile!", new Object[] { Integer.valueOf(shaderType) }));
/*     */     } 
/*     */     
/* 250 */     return shader;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\ShaderUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */