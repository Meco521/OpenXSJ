/*     */ package tomk.utils.blur;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.client.shader.Shader;
/*     */ import net.minecraft.client.shader.ShaderUniform;
/*     */ import net.minecraft.client.util.JsonException;
/*     */ import net.minecraft.util.JsonUtils;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Matrix4f;
/*     */ 
/*     */ public class ShaderGroup {
/*  27 */   private final List<Shader> listShaders = Lists.newArrayList();
/*  28 */   private final Map<String, Framebuffer> mapFramebuffers = Maps.newHashMap();
/*  29 */   private final List<Framebuffer> listFramebuffers = Lists.newArrayList();
/*     */   private final Framebuffer mainFramebuffer;
/*     */   private final IResourceManager resourceManager;
/*     */   private final String shaderGroupName;
/*     */   private Matrix4f projectionMatrix;
/*     */   private int mainFramebufferWidth;
/*     */   private int mainFramebufferHeight;
/*     */   private float field_148036_j;
/*     */   private float field_148037_k;
/*     */   
/*     */   public ShaderGroup(TextureManager p_i1050_1_, IResourceManager p_i1050_2_, Framebuffer p_i1050_3_, ResourceLocation p_i1050_4_) throws IOException, JsonSyntaxException {
/*  40 */     this.resourceManager = p_i1050_2_;
/*  41 */     this.mainFramebuffer = p_i1050_3_;
/*  42 */     this.field_148036_j = 0.0F;
/*  43 */     this.field_148037_k = 0.0F;
/*  44 */     this.mainFramebufferWidth = p_i1050_3_.field_147621_c;
/*  45 */     this.mainFramebufferHeight = p_i1050_3_.field_147618_d;
/*  46 */     this.shaderGroupName = p_i1050_4_.toString();
/*  47 */     resetProjectionMatrix();
/*  48 */     parseGroup(p_i1050_1_, p_i1050_4_);
/*     */   }
/*     */   
/*     */   public void parseGroup(TextureManager p_152765_1_, ResourceLocation p_152765_2_) throws IOException, JsonSyntaxException {
/*  52 */     JsonParser jsonparser = new JsonParser();
/*  53 */     InputStream inputstream = null;
/*     */     
/*     */     try {
/*  56 */       IResource iresource = this.resourceManager.func_110536_a(p_152765_2_);
/*  57 */       inputstream = iresource.func_110527_b();
/*  58 */       JsonObject jsonobject = jsonparser.parse(IOUtils.toString(inputstream, Charsets.UTF_8)).getAsJsonObject();
/*     */       
/*  60 */       if (JsonUtils.func_151202_d(jsonobject, "targets")) {
/*  61 */         JsonArray jsonarray = jsonobject.getAsJsonArray("targets");
/*  62 */         int i = 0;
/*     */         
/*  64 */         for (JsonElement jsonelement : jsonarray) {
/*     */           try {
/*  66 */             initTarget(jsonelement);
/*  67 */           } catch (Exception exception1) {
/*  68 */             JsonException jsonexception1 = JsonException.func_151379_a(exception1);
/*  69 */             jsonexception1.func_151380_a("targets[" + i + "]");
/*  70 */             throw jsonexception1;
/*     */           } 
/*     */           
/*  73 */           i++;
/*     */         } 
/*     */       } 
/*     */       
/*  77 */       if (JsonUtils.func_151202_d(jsonobject, "passes")) {
/*  78 */         JsonArray jsonarray1 = jsonobject.getAsJsonArray("passes");
/*  79 */         int j = 0;
/*     */         
/*  81 */         for (JsonElement jsonelement1 : jsonarray1) {
/*     */           try {
/*  83 */             parsePass(p_152765_1_, jsonelement1);
/*  84 */           } catch (Exception exception) {
/*  85 */             JsonException jsonexception2 = JsonException.func_151379_a(exception);
/*  86 */             jsonexception2.func_151380_a("passes[" + j + "]");
/*  87 */             throw jsonexception2;
/*     */           } 
/*     */           
/*  90 */           j++;
/*     */         } 
/*     */       } 
/*  93 */     } catch (Exception exception2) {
/*  94 */       JsonException jsonexception = JsonException.func_151379_a(exception2);
/*  95 */       jsonexception.func_151381_b(p_152765_2_.func_110623_a());
/*  96 */       throw jsonexception;
/*     */     } finally {
/*  98 */       IOUtils.closeQuietly(inputstream);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void initTarget(JsonElement p_148027_1_) throws JsonException {
/* 103 */     if (JsonUtils.func_151211_a(p_148027_1_)) {
/* 104 */       addFramebuffer(p_148027_1_.getAsString(), this.mainFramebufferWidth, this.mainFramebufferHeight);
/*     */     } else {
/* 106 */       JsonObject jsonobject = JsonUtils.func_151210_l(p_148027_1_, "target");
/* 107 */       String s = JsonUtils.func_151200_h(jsonobject, "name");
/* 108 */       int i = JsonUtils.func_151208_a(jsonobject, "width", this.mainFramebufferWidth);
/* 109 */       int j = JsonUtils.func_151208_a(jsonobject, "height", this.mainFramebufferHeight);
/*     */       
/* 111 */       if (this.mapFramebuffers.containsKey(s)) {
/* 112 */         throw new JsonException(s + " is already defined");
/*     */       }
/*     */       
/* 115 */       addFramebuffer(s, i, j);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void parsePass(TextureManager p_152764_1_, JsonElement p_152764_2_) throws IOException {
/* 120 */     JsonObject jsonobject = JsonUtils.func_151210_l(p_152764_2_, "pass");
/* 121 */     String s = JsonUtils.func_151200_h(jsonobject, "name");
/* 122 */     String s1 = JsonUtils.func_151200_h(jsonobject, "intarget");
/* 123 */     String s2 = JsonUtils.func_151200_h(jsonobject, "outtarget");
/* 124 */     Framebuffer framebuffer = getFramebuffer(s1);
/* 125 */     Framebuffer framebuffer1 = getFramebuffer(s2);
/*     */     
/* 127 */     if (framebuffer == null)
/* 128 */       throw new JsonException("Input target '" + s1 + "' does not exist"); 
/* 129 */     if (framebuffer1 == null) {
/* 130 */       throw new JsonException("Output target '" + s2 + "' does not exist");
/*     */     }
/* 132 */     Shader shader = addShader(s, framebuffer, framebuffer1);
/* 133 */     JsonArray jsonarray = JsonUtils.func_151213_a(jsonobject, "auxtargets", null);
/*     */     
/* 135 */     if (jsonarray != null) {
/* 136 */       int i = 0;
/*     */       
/* 138 */       for (JsonElement jsonelement : jsonarray) {
/*     */         try {
/* 140 */           JsonObject jsonobject1 = JsonUtils.func_151210_l(jsonelement, "auxtarget");
/* 141 */           String s4 = JsonUtils.func_151200_h(jsonobject1, "name");
/* 142 */           String s3 = JsonUtils.func_151200_h(jsonobject1, "id");
/* 143 */           Framebuffer framebuffer2 = getFramebuffer(s3);
/*     */           
/* 145 */           if (framebuffer2 == null) {
/* 146 */             ResourceLocation resourcelocation = new ResourceLocation("textures/effect/" + s3 + "Scare.png");
/*     */             
/*     */             try {
/* 149 */               this.resourceManager.func_110536_a(resourcelocation);
/* 150 */             } catch (FileNotFoundException var24) {
/* 151 */               throw new JsonException("Render target or texture '" + s3 + "' does not exist");
/*     */             } 
/*     */             
/* 154 */             p_152764_1_.func_110577_a(resourcelocation);
/* 155 */             ITextureObject itextureobject = p_152764_1_.func_110581_b(resourcelocation);
/* 156 */             int j = JsonUtils.func_151203_m(jsonobject1, "width");
/* 157 */             int k = JsonUtils.func_151203_m(jsonobject1, "height");
/* 158 */             boolean flag = JsonUtils.func_151212_i(jsonobject1, "bilinear");
/*     */             
/* 160 */             if (flag) {
/* 161 */               GL11.glTexParameteri(3553, 10241, 9729);
/* 162 */               GL11.glTexParameteri(3553, 10240, 9729);
/*     */             } else {
/* 164 */               GL11.glTexParameteri(3553, 10241, 9728);
/* 165 */               GL11.glTexParameteri(3553, 10240, 9728);
/*     */             } 
/*     */             
/* 168 */             shader.func_148041_a(s4, Integer.valueOf(itextureobject.func_110552_b()), j, k);
/*     */           } else {
/* 170 */             shader.func_148041_a(s4, framebuffer2, framebuffer2.field_147622_a, framebuffer2.field_147620_b);
/*     */           } 
/* 172 */         } catch (Exception exception1) {
/* 173 */           JsonException jsonexception = JsonException.func_151379_a(exception1);
/* 174 */           jsonexception.func_151381_b("auxtargets[" + i + "]");
/* 175 */           throw jsonexception;
/*     */         } 
/*     */         
/* 178 */         i++;
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     JsonArray jsonarray1 = JsonUtils.func_151213_a(jsonobject, "uniforms", null);
/*     */     
/* 184 */     if (jsonarray1 != null) {
/* 185 */       int l = 0;
/*     */       
/* 187 */       for (JsonElement jsonelement1 : jsonarray1) {
/*     */         try {
/* 189 */           initUniform(jsonelement1);
/* 190 */         } catch (Exception exception) {
/* 191 */           JsonException jsonexception1 = JsonException.func_151379_a(exception);
/* 192 */           jsonexception1.func_151380_a("uniforms[" + l + "]");
/* 193 */           throw jsonexception1;
/*     */         } 
/*     */         
/* 196 */         l++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void initUniform(JsonElement p_148028_1_) throws JsonException {
/* 203 */     JsonObject jsonobject = JsonUtils.func_151210_l(p_148028_1_, "uniform");
/* 204 */     String s = JsonUtils.func_151200_h(jsonobject, "name");
/* 205 */     ShaderUniform shaderuniform = ((Shader)this.listShaders.get(this.listShaders.size() - 1)).func_148043_c().func_147991_a(s);
/*     */     
/* 207 */     if (shaderuniform == null) {
/* 208 */       throw new JsonException("Uniform '" + s + "' does not exist");
/*     */     }
/* 210 */     float[] afloat = new float[4];
/* 211 */     int i = 0;
/*     */     
/* 213 */     for (JsonElement jsonelement : JsonUtils.func_151214_t(jsonobject, "values")) {
/*     */       try {
/* 215 */         afloat[i] = JsonUtils.func_151220_d(jsonelement, "value");
/* 216 */       } catch (Exception exception) {
/* 217 */         JsonException jsonexception = JsonException.func_151379_a(exception);
/* 218 */         jsonexception.func_151380_a("values[" + i + "]");
/* 219 */         throw jsonexception;
/*     */       } 
/*     */       
/* 222 */       i++;
/*     */     } 
/*     */     
/* 225 */     switch (i) {
/*     */       default:
/*     */         return;
/*     */ 
/*     */       
/*     */       case 1:
/* 231 */         shaderuniform.func_148090_a(afloat[0]);
/*     */ 
/*     */       
/*     */       case 2:
/* 235 */         shaderuniform.func_148087_a(afloat[0], afloat[1]);
/*     */ 
/*     */       
/*     */       case 3:
/* 239 */         shaderuniform.func_148095_a(afloat[0], afloat[1], afloat[2]);
/*     */       case 4:
/*     */         break;
/*     */     } 
/* 243 */     shaderuniform.func_148081_a(afloat[0], afloat[1], afloat[2], afloat[3]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Framebuffer getFramebufferRaw(String p_177066_1_) {
/* 249 */     return this.mapFramebuffers.get(p_177066_1_);
/*     */   }
/*     */   
/*     */   public void addFramebuffer(String p_148020_1_, int p_148020_2_, int p_148020_3_) {
/* 253 */     Framebuffer framebuffer = new Framebuffer(p_148020_2_, p_148020_3_, true);
/* 254 */     framebuffer.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
/* 255 */     this.mapFramebuffers.put(p_148020_1_, framebuffer);
/*     */     
/* 257 */     if (p_148020_2_ == this.mainFramebufferWidth && p_148020_3_ == this.mainFramebufferHeight) {
/* 258 */       this.listFramebuffers.add(framebuffer);
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteShaderGroup() {
/* 263 */     for (Framebuffer framebuffer : this.mapFramebuffers.values()) {
/* 264 */       framebuffer.func_147608_a();
/*     */     }
/*     */     
/* 267 */     for (Shader shader : this.listShaders) {
/* 268 */       shader.func_148044_b();
/*     */     }
/*     */     
/* 271 */     this.listShaders.clear();
/*     */   }
/*     */   
/*     */   public Shader addShader(String p_148023_1_, Framebuffer p_148023_2_, Framebuffer p_148023_3_) throws IOException {
/* 275 */     Shader shader = new Shader(this.resourceManager, p_148023_1_, p_148023_2_, p_148023_3_);
/* 276 */     this.listShaders.add(this.listShaders.size(), shader);
/* 277 */     return shader;
/*     */   }
/*     */   
/*     */   private void resetProjectionMatrix() {
/* 281 */     this.projectionMatrix = new Matrix4f();
/* 282 */     this.projectionMatrix.setIdentity();
/* 283 */     this.projectionMatrix.m00 = 2.0F / this.mainFramebuffer.field_147622_a;
/* 284 */     this.projectionMatrix.m11 = 2.0F / -this.mainFramebuffer.field_147620_b;
/* 285 */     this.projectionMatrix.m22 = -0.0020001999F;
/* 286 */     this.projectionMatrix.m33 = 1.0F;
/* 287 */     this.projectionMatrix.m03 = -1.0F;
/* 288 */     this.projectionMatrix.m13 = 1.0F;
/* 289 */     this.projectionMatrix.m23 = -1.0001999F;
/*     */   }
/*     */   
/*     */   public void createBindFramebuffers(int width, int height) {
/* 293 */     this.mainFramebufferWidth = this.mainFramebuffer.field_147622_a;
/* 294 */     this.mainFramebufferHeight = this.mainFramebuffer.field_147620_b;
/* 295 */     resetProjectionMatrix();
/*     */     
/* 297 */     for (Shader shader : this.listShaders) {
/* 298 */       shader.func_148045_a(this.projectionMatrix);
/*     */     }
/*     */     
/* 301 */     for (Framebuffer framebuffer : this.listFramebuffers) {
/* 302 */       framebuffer.func_147613_a(width, height);
/*     */     }
/*     */   }
/*     */   
/*     */   public void loadShaderGroup(float partialTicks) {
/* 307 */     if (partialTicks < this.field_148037_k) {
/* 308 */       this.field_148036_j += 1.0F - this.field_148037_k;
/* 309 */       this.field_148036_j += partialTicks;
/*     */     } else {
/* 311 */       this.field_148036_j += partialTicks - this.field_148037_k;
/*     */     } 
/*     */     
/* 314 */     for (this.field_148037_k = partialTicks; this.field_148036_j > 20.0F; this.field_148036_j -= 20.0F);
/*     */ 
/*     */     
/* 317 */     for (Shader shader : this.listShaders) {
/* 318 */       shader.func_148042_a(this.field_148036_j / 20.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public final String getShaderGroupName() {
/* 323 */     return this.shaderGroupName;
/*     */   }
/*     */   
/*     */   private Framebuffer getFramebuffer(String p_148017_1_) {
/* 327 */     return (p_148017_1_ == null) ? null : (p_148017_1_.equals("minecraft:main") ? this.mainFramebuffer : this.mapFramebuffers.get(p_148017_1_));
/*     */   }
/*     */   
/*     */   public List<Shader> getShaders() {
/* 331 */     return this.listShaders;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\blur\ShaderGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */