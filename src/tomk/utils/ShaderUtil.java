/*     */ package tomk.utils;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.FileUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.normal.Utils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ public class ShaderUtil
/*     */   implements Utils
/*     */ {
/*     */   private final int programID;
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc, String vertexShaderLoc) {
/*  22 */     int program = GL20.glCreateProgram();
/*     */     try {
/*     */       int fragmentShaderID;
/*  25 */       switch (fragmentShaderLoc) {
/*     */         case "kawaseUpGlow":
/*  27 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.kawaseUpGlow.getBytes()), 35632);
/*     */           break;
/*     */         case "glow":
/*  30 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.glowShader.getBytes()), 35632);
/*     */           break;
/*     */         case "chams":
/*  33 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.chams.getBytes()), 35632);
/*     */           break;
/*     */         case "roundRectTexture":
/*  36 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.roundRectTexture.getBytes()), 35632);
/*     */           break;
/*     */         case "roundRectOutline":
/*  39 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.roundRectOutline.getBytes()), 35632);
/*     */           break;
/*     */         case "kawaseUpBloom":
/*  42 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.kawaseUpBloom.getBytes()), 35632);
/*     */           break;
/*     */         case "kawaseDownBloom":
/*  45 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.kawaseDownBloom.getBytes()), 35632);
/*     */           break;
/*     */         case "kawaseUp":
/*  48 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.kawaseUp.getBytes()), 35632);
/*     */           break;
/*     */         case "kawaseDown":
/*  51 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.kawaseDown.getBytes()), 35632);
/*     */           break;
/*     */         case "gradientMask":
/*  54 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.gradientMask.getBytes()), 35632);
/*     */           break;
/*     */         case "mask":
/*  57 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.mask.getBytes()), 35632);
/*     */           break;
/*     */         case "gradient":
/*  60 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.gradient.getBytes()), 35632);
/*     */           break;
/*     */         case "roundedRect":
/*  63 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.roundedRect.getBytes()), 35632);
/*     */           break;
/*     */         case "roundedRectGradient":
/*  66 */           fragmentShaderID = createShader(new ByteArrayInputStream(this.roundedRectGradient.getBytes()), 35632);
/*     */           break;
/*     */         default:
/*  69 */           fragmentShaderID = createShader(MinecraftInstance.mc2.func_110442_L().func_110536_a(new ResourceLocation(fragmentShaderLoc)).func_110527_b(), 35632);
/*     */           break;
/*     */       } 
/*  72 */       GL20.glAttachShader(program, fragmentShaderID);
/*     */       
/*  74 */       int vertexShaderID = createShader(MinecraftInstance.mc2.func_110442_L().func_110536_a(new ResourceLocation(vertexShaderLoc)).func_110527_b(), 35633);
/*  75 */       GL20.glAttachShader(program, vertexShaderID);
/*     */     
/*     */     }
/*  78 */     catch (IOException e) {
/*  79 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  82 */     GL20.glLinkProgram(program);
/*  83 */     int status = GL20.glGetProgrami(program, 35714);
/*     */     
/*  85 */     if (status == 0) {
/*  86 */       throw new IllegalStateException("Shader failed to link!");
/*     */     }
/*  88 */     this.programID = program;
/*     */   }
/*     */   
/*     */   public ShaderUtil(String fragmentShadersrc, boolean notUsed) {
/*  92 */     int program = GL20.glCreateProgram();
/*  93 */     int fragmentShaderID = createShader(new ByteArrayInputStream(fragmentShadersrc.getBytes()), 35632);
/*  94 */     int vertexShaderID = 0;
/*     */     try {
/*  96 */       vertexShaderID = createShader(MinecraftInstance.mc2.func_110442_L().func_110536_a(new ResourceLocation("Tenacity/Shaders/vertex.vsh")).func_110527_b(), 35633);
/*  97 */     } catch (IOException e) {
/*  98 */       throw new RuntimeException(e);
/*     */     } 
/*     */     
/* 101 */     GL20.glAttachShader(program, fragmentShaderID);
/* 102 */     GL20.glAttachShader(program, vertexShaderID);
/*     */ 
/*     */ 
/*     */     
/* 106 */     GL20.glLinkProgram(program);
/* 107 */     int status = GL20.glGetProgrami(program, 35714);
/* 108 */     if (status == 0) {
/* 109 */       throw new IllegalStateException("Shader failed to link!");
/*     */     }
/* 111 */     this.programID = program;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ShaderUtil(String fragmentShaderLoc) {
/* 117 */     this(fragmentShaderLoc, "Tenacity/Shaders/vertex.vsh");
/*     */   }
/*     */   
/*     */   public void init() {
/* 121 */     GL20.glUseProgram(this.programID);
/*     */   }
/*     */   
/*     */   public void unload() {
/* 125 */     GL20.glUseProgram(0);
/*     */   }
/*     */   
/*     */   public int getUniform(String name) {
/* 129 */     return GL20.glGetUniformLocation(this.programID, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUniformf(String name, float... args) {
/* 134 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/* 135 */     switch (args.length) {
/*     */       case 1:
/* 137 */         GL20.glUniform1f(loc, args[0]);
/*     */         break;
/*     */       case 2:
/* 140 */         GL20.glUniform2f(loc, args[0], args[1]);
/*     */         break;
/*     */       case 3:
/* 143 */         GL20.glUniform3f(loc, args[0], args[1], args[2]);
/*     */         break;
/*     */       case 4:
/* 146 */         GL20.glUniform4f(loc, args[0], args[1], args[2], args[3]);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setUniformi(String name, int... args) {
/* 152 */     int loc = GL20.glGetUniformLocation(this.programID, name);
/* 153 */     if (args.length > 1) { GL20.glUniform2i(loc, args[0], args[1]); }
/* 154 */     else { GL20.glUniform1i(loc, args[0]); }
/*     */   
/*     */   }
/*     */   public static void drawQuads(float x, float y, float width, float height) {
/* 158 */     GL11.glBegin(7);
/* 159 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 160 */     GL11.glVertex2f(x, y);
/* 161 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 162 */     GL11.glVertex2f(x, y + height);
/* 163 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 164 */     GL11.glVertex2f(x + width, y + height);
/* 165 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 166 */     GL11.glVertex2f(x + width, y);
/* 167 */     GL11.glEnd();
/*     */   }
/*     */   
/*     */   public static void drawQuads() {
/* 171 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 172 */     float width = (float)sr.func_78327_c();
/* 173 */     float height = (float)sr.func_78324_d();
/* 174 */     GL11.glBegin(7);
/* 175 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 176 */     GL11.glVertex2f(0.0F, 0.0F);
/* 177 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 178 */     GL11.glVertex2f(0.0F, height);
/* 179 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 180 */     GL11.glVertex2f(width, height);
/* 181 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 182 */     GL11.glVertex2f(width, 0.0F);
/* 183 */     GL11.glEnd();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawQuads(float width, float height) {
/* 188 */     GL11.glBegin(7);
/* 189 */     GL11.glTexCoord2f(0.0F, 1.0F);
/* 190 */     GL11.glVertex2f(0.0F, 0.0F);
/* 191 */     GL11.glTexCoord2f(0.0F, 0.0F);
/* 192 */     GL11.glVertex2f(0.0F, height);
/* 193 */     GL11.glTexCoord2f(1.0F, 0.0F);
/* 194 */     GL11.glVertex2f(width, height);
/* 195 */     GL11.glTexCoord2f(1.0F, 1.0F);
/* 196 */     GL11.glVertex2f(width, 0.0F);
/* 197 */     GL11.glEnd();
/*     */   }
/*     */   
/*     */   private int createShader(InputStream inputStream, int shaderType) {
/* 201 */     int shader = GL20.glCreateShader(shaderType);
/* 202 */     GL20.glShaderSource(shader, FileUtils.readInputStream(inputStream));
/* 203 */     GL20.glCompileShader(shader);
/*     */ 
/*     */     
/* 206 */     if (GL20.glGetShaderi(shader, 35713) == 0) {
/* 207 */       System.out.println(GL20.glGetShaderInfoLog(shader, 4096));
/* 208 */       throw new IllegalStateException(String.format("Shader (%s) failed to compile!", new Object[] { Integer.valueOf(shaderType) }));
/*     */     } 
/*     */     
/* 211 */     return shader;
/*     */   }
/*     */   
/* 214 */   private String kawaseUpGlow = "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform bool check;\nuniform float lastPass;\nuniform float exposure;\n\nvoid main() {\n    if(check && texture2D(textureToCheck, gl_TexCoord[0].st).a != 0.0) discard;\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum.rgb *= sum.a;\n    vec4 smpl1 =  texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset);\n    smpl1.rgb *= smpl1.a;\n    sum += smpl1 * 2.0;\n    vec4 smp2 = texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3 * 2.0;\n    vec4 smp4 = texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 smp5 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp5.rgb *= smp5.a;\n    sum += smp5 * 2.0;\n    vec4 smp6 = texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    smp6.rgb *= smp6.a;\n    sum += smp6;\n    vec4 smp7 = texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset);\n    smp7.rgb *= smp7.a;\n    sum += smp7 * 2.0;\n    vec4 result = sum / 12.0;\n    gl_FragColor = vec4(result.rgb / result.a, mix(result.a, 1.0 - exp(-result.a * exposure), step(0.0, lastPass)));\n}";
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
/* 253 */   private String glowShader = "#version 120\n\nuniform sampler2D textureIn, textureToCheck;\nuniform vec2 texelSize, direction;\nuniform vec3 color;\nuniform bool avoidTexture;\nuniform float exposure, radius;\nuniform float weights[256];\n\n#define offset direction * texelSize\n\nvoid main() {\n    if (direction.y == 1 && avoidTexture) {\n        if (texture2D(textureToCheck, gl_TexCoord[0].st).a != 0.0) discard;\n    }\n    vec4 innerColor = texture2D(textureIn, gl_TexCoord[0].st);\n    innerColor.rgb *= innerColor.a;\n    innerColor *= weights[0];\n    for (float r = 1.0; r <= radius; r++) {\n        vec4 colorCurrent1 = texture2D(textureIn, gl_TexCoord[0].st + offset * r);\n        vec4 colorCurrent2 = texture2D(textureIn, gl_TexCoord[0].st - offset * r);\n\n        colorCurrent1.rgb *= colorCurrent1.a;\n        colorCurrent2.rgb *= colorCurrent2.a;\n\n        innerColor += (colorCurrent1 + colorCurrent2) * weights[int(r)];\n    }\n\n    gl_FragColor = vec4(innerColor.rgb / innerColor.a, mix(innerColor.a, 1.0 - exp(-innerColor.a * exposure), step(0.0, direction.y)));\n}\n";
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
/*     */ 
/*     */   
/* 284 */   private String chams = "#version 120\n\nuniform sampler2D textureIn;\nuniform vec4 color;\nvoid main() {\n    float alpha = texture2D(textureIn, gl_TexCoord[0].st).a;\n    gl_FragColor = vec4(color.rgb, color.a * mix(0.0, alpha, step(0.0, alpha)));\n}\n";
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
/* 295 */   private String roundRectTexture = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D textureIn;\nuniform float radius, alpha;\n\nfloat roundedBoxSDF(vec2 centerPos, vec2 size, float radius) {\n    return length(max(abs(centerPos) -size, 0.)) - radius;\n}\n\n\nvoid main() {\n    float distance = roundedBoxSDF((rectSize * .5) - (gl_TexCoord[0].st * rectSize), (rectSize * .5) - radius - 1., radius);\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2.0, distance)) * alpha;\n    gl_FragColor = vec4(texture2D(textureIn, gl_TexCoord[0].st).rgb, smoothedAlpha);\n}";
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
/* 312 */   private String roundRectOutline = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color, outlineColor;\nuniform float radius, outlineThickness;\n\nfloat roundedSDF(vec2 centerPos, vec2 size, float radius) {\n    return length(max(abs(centerPos) - size + radius, 0.0)) - radius;\n}\n\nvoid main() {\n    float distance = roundedSDF(gl_FragCoord.xy - location - (rectSize * .5), (rectSize * .5) + (outlineThickness *.5) - 1.0, radius);\n\n    float blendAmount = smoothstep(0., 2., abs(distance) - (outlineThickness * .5));\n\n    vec4 insideColor = (distance < 0.) ? color : vec4(outlineColor.rgb,  0.0);\n    gl_FragColor = mix(outlineColor, insideColor, blendAmount);\n\n}";
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
/* 332 */   private String kawaseUpBloom = "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform int check;\n\nvoid main() {\n  //  if(check && texture2D(textureToCheck, gl_TexCoord[0].st).a > 0.0) discard;\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum.rgb *= sum.a;\n    vec4 smpl1 =  texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset);\n    smpl1.rgb *= smpl1.a;\n    sum += smpl1 * 2.0;\n    vec4 smp2 = texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3 * 2.0;\n    vec4 smp4 = texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 smp5 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp5.rgb *= smp5.a;\n    sum += smp5 * 2.0;\n    vec4 smp6 = texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    smp6.rgb *= smp6.a;\n    sum += smp6;\n    vec4 smp7 = texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset);\n    smp7.rgb *= smp7.a;\n    sum += smp7 * 2.0;\n    vec4 result = sum / 12.0;\n    gl_FragColor = vec4(result.rgb / result.a, mix(result.a, result.a * (1.0 - texture2D(textureToCheck, gl_TexCoord[0].st).a),check));\n}";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 369 */   private String kawaseDownBloom = "#version 120\n\nuniform sampler2D inTexture;\nuniform vec2 offset, halfpixel, iResolution;\n\nvoid main() {\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n    vec4 sum = texture2D(inTexture, gl_TexCoord[0].st);\n    sum.rgb *= sum.a;\n    sum *= 4.0;\n    vec4 smp1 = texture2D(inTexture, uv - halfpixel.xy * offset);\n    smp1.rgb *= smp1.a;\n    sum += smp1;\n    vec4 smp2 = texture2D(inTexture, uv + halfpixel.xy * offset);\n    smp2.rgb *= smp2.a;\n    sum += smp2;\n    vec4 smp3 = texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp3.rgb *= smp3.a;\n    sum += smp3;\n    vec4 smp4 = texture2D(inTexture, uv - vec2(halfpixel.x, -halfpixel.y) * offset);\n    smp4.rgb *= smp4.a;\n    sum += smp4;\n    vec4 result = sum / 8.0;\n    gl_FragColor = vec4(result.rgb / result.a, result.a);\n}";
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
/* 395 */   private String kawaseUp = "#version 120\n\nuniform sampler2D inTexture, textureToCheck;\nuniform vec2 halfpixel, offset, iResolution;\nuniform int check;\n\nvoid main() {\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n    vec4 sum = texture2D(inTexture, uv + vec2(-halfpixel.x * 2.0, 0.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(-halfpixel.x, halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(0.0, halfpixel.y * 2.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x * 2.0, 0.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset) * 2.0;\n    sum += texture2D(inTexture, uv + vec2(0.0, -halfpixel.y * 2.0) * offset);\n    sum += texture2D(inTexture, uv + vec2(-halfpixel.x, -halfpixel.y) * offset) * 2.0;\n\n    gl_FragColor = vec4(sum.rgb /12.0, mix(1.0, texture2D(textureToCheck, gl_TexCoord[0].st).a, check));\n}\n";
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
/* 415 */   private String kawaseDown = "#version 120\n\nuniform sampler2D inTexture;\nuniform vec2 offset, halfpixel, iResolution;\n\nvoid main() {\n    vec2 uv = vec2(gl_FragCoord.xy / iResolution);\n    vec4 sum = texture2D(inTexture, gl_TexCoord[0].st) * 4.0;\n    sum += texture2D(inTexture, uv - halfpixel.xy * offset);\n    sum += texture2D(inTexture, uv + halfpixel.xy * offset);\n    sum += texture2D(inTexture, uv + vec2(halfpixel.x, -halfpixel.y) * offset);\n    sum += texture2D(inTexture, uv - vec2(halfpixel.x, -halfpixel.y) * offset);\n    gl_FragColor = vec4(sum.rgb * .125, 1.0);\n}\n";
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
/* 430 */   private String gradientMask = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D tex;\nuniform vec3 color1, color2, color3, color4;\nuniform float alpha;\n\n#define NOISE .5/255.0\n\nvec3 createGradient(vec2 coords, vec3 color1, vec3 color2, vec3 color3, vec3 color4){\n    vec3 color = mix(mix(color1.rgb, color2.rgb, coords.y), mix(color3.rgb, color4.rgb, coords.y), coords.x);\n    //Dithering the color from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898,78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    float texColorAlpha = texture2D(tex, gl_TexCoord[0].st).a;\n    gl_FragColor = vec4(createGradient(coords, color1, color2, color3, color4), texColorAlpha * alpha);\n}";
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
/* 452 */   private String mask = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D u_texture, u_texture2;\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    float texColorAlpha = texture2D(u_texture, gl_TexCoord[0].st).a;\n    vec3 tex2Color = texture2D(u_texture2, gl_TexCoord[0].st).rgb;\n    gl_FragColor = vec4(tex2Color, texColorAlpha);\n}";
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
/* 464 */   private String gradient = "#version 120\n\nuniform vec2 location, rectSize;\nuniform sampler2D tex;\nuniform vec4 color1, color2, color3, color4;\n#define NOISE .5/255.0\n\nvec4 createGradient(vec2 coords, vec4 color1, vec4 color2, vec4 color3, vec4 color4){\n    vec4 color = mix(mix(color1, color2, coords.y), mix(color3, color4, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 coords = (gl_FragCoord.xy - location) / rectSize;\n    gl_FragColor = createGradient(coords, color1, color2, color3, color4);\n}";
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
/* 484 */   private String roundedRectGradient = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color1, color2, color3, color4;\nuniform float radius;\n\n#define NOISE .5/255.0\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b , 0.0)) - r;\n}\n\nvec4 createGradient(vec2 coords, vec4 color1, vec4 color2, vec4 color3, vec4 color4){\n    vec4 color = mix(mix(color1, color2, coords.y), mix(color3, color4, coords.y), coords.x);\n    //Dithering the color\n    // from https://shader-tutorial.dev/advanced/color-banding-dithering/\n    color += mix(NOISE, -NOISE, fract(sin(dot(coords.xy, vec2(12.9898, 78.233))) * 43758.5453));\n    return color;\n}\n\nvoid main() {\n    vec2 st = gl_TexCoord[0].st;\n    vec2 halfSize = rectSize * .5;\n    \n   // use the bottom leftColor as the alpha\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 2., roundSDF(halfSize - (gl_TexCoord[0].st * rectSize), halfSize - radius - 1., radius)));\n    vec4 gradient = createGradient(st, color1, color2, color3, color4);    gl_FragColor = vec4(gradient.rgb, gradient.a * smoothedAlpha);\n}";
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
/*     */ 
/*     */   
/* 515 */   private String roundedRect = "#version 120\n\nuniform vec2 location, rectSize;\nuniform vec4 color;\nuniform float radius;\nuniform bool blur;\n\nfloat roundSDF(vec2 p, vec2 b, float r) {\n    return length(max(abs(p) - b, 0.0)) - r;\n}\n\n\nvoid main() {\n    vec2 rectHalf = rectSize * .5;\n    // Smooth the result (free antialiasing).\n    float smoothedAlpha =  (1.0-smoothstep(0.0, 1.0, roundSDF(rectHalf - (gl_TexCoord[0].st * rectSize), rectHalf - radius - 1., radius))) * color.a;\n    gl_FragColor = vec4(color.rgb, smoothedAlpha);// mix(quadColor, shadowColor, 0.0);\n\n}";
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\ShaderUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */