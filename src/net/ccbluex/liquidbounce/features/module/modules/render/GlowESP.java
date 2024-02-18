/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.Animation;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations.impl.DecelerateAnimation;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.MathUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ShaderUtil;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.culling.Frustum;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "GlowESP", description = "Tenacity.", category = ModuleCategory.RENDER)
/*     */ public class GlowESP
/*     */   extends Module
/*     */ {
/*  42 */   public final FloatValue radius = new FloatValue("Radius", 2.0F, 1.0F, 30.0F);
/*  43 */   public final FloatValue exposure = new FloatValue("Exposure", 2.2F, 1.0F, 3.5F);
/*  44 */   public final BoolValue seperate = new BoolValue("Seperate Texture", false);
/*  45 */   public final BoolValue Players = new BoolValue("Players", true);
/*  46 */   public final BoolValue Animals = new BoolValue("Animals", false);
/*  47 */   public final BoolValue Mobs = new BoolValue("Mobs", false);
/*     */   
/*     */   public static boolean renderNameTags = true;
/*  50 */   private final ShaderUtil outlineShader = new ShaderUtil("shaders/outline.frag");
/*  51 */   private final ShaderUtil glowShader = new ShaderUtil("shaders/glow.frag");
/*     */   
/*     */   public Framebuffer framebuffer;
/*     */   public Framebuffer outlineFrameBuffer;
/*     */   public Framebuffer glowFrameBuffer;
/*  56 */   private final Frustum frustum = new Frustum();
/*     */   
/*  58 */   private final List<Entity> entities = new ArrayList<>();
/*     */   
/*     */   public static Animation fadeIn;
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  64 */     super.onEnable();
/*  65 */     fadeIn = (Animation)new DecelerateAnimation(250, 1.0D);
/*     */   }
/*     */   
/*     */   public void createFrameBuffers() {
/*  69 */     this.framebuffer = RenderUtils.createFrameBuffer(this.framebuffer);
/*  70 */     this.outlineFrameBuffer = RenderUtils.createFrameBuffer(this.outlineFrameBuffer);
/*  71 */     this.glowFrameBuffer = RenderUtils.createFrameBuffer(this.glowFrameBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onrender3D(Render3DEvent event) {
/*  77 */     createFrameBuffers();
/*  78 */     collectEntities();
/*  79 */     this.framebuffer.func_147614_f();
/*  80 */     this.framebuffer.func_147610_a(true);
/*  81 */     renderEntities(event.getPartialTicks());
/*  82 */     this.framebuffer.func_147609_e();
/*  83 */     mc.getFramebuffer().bindFramebuffer(true);
/*  84 */     GlStateManager.func_179140_f();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onrender2D(Render2DEvent event) {
/*  90 */     ScaledResolution sr = new ScaledResolution(mc2);
/*  91 */     if (this.framebuffer != null && this.outlineFrameBuffer != null && this.entities.size() > 0) {
/*  92 */       GlStateManager.func_179141_d();
/*  93 */       GlStateManager.func_179092_a(516, 0.0F);
/*  94 */       GlStateManager.func_179147_l();
/*  95 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */       
/*  97 */       this.outlineFrameBuffer.func_147614_f();
/*  98 */       this.outlineFrameBuffer.func_147610_a(true);
/*  99 */       this.outlineShader.init();
/* 100 */       setupOutlineUniforms(0.0F, 1.0F);
/* 101 */       RenderUtils.bindTexture(this.framebuffer.field_147617_g);
/* 102 */       ShaderUtil.drawQuads();
/* 103 */       this.outlineShader.init();
/* 104 */       setupOutlineUniforms(1.0F, 0.0F);
/* 105 */       RenderUtils.bindTexture(this.framebuffer.field_147617_g);
/* 106 */       ShaderUtil.drawQuads();
/* 107 */       this.outlineShader.unload();
/* 108 */       this.outlineFrameBuffer.func_147609_e();
/*     */       
/* 110 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 111 */       this.glowFrameBuffer.func_147614_f();
/* 112 */       this.glowFrameBuffer.func_147610_a(true);
/* 113 */       this.glowShader.init();
/* 114 */       setupGlowUniforms(1.0F, 0.0F);
/* 115 */       RenderUtils.bindTexture(this.outlineFrameBuffer.field_147617_g);
/* 116 */       ShaderUtil.drawQuads();
/* 117 */       this.glowShader.unload();
/* 118 */       this.glowFrameBuffer.func_147609_e();
/*     */       
/* 120 */       mc.getFramebuffer().bindFramebuffer(true);
/* 121 */       this.glowShader.init();
/* 122 */       setupGlowUniforms(0.0F, 1.0F);
/* 123 */       if (((Boolean)this.seperate.get()).booleanValue()) {
/* 124 */         GL13.glActiveTexture(34000);
/* 125 */         RenderUtils.bindTexture(this.framebuffer.field_147617_g);
/*     */       } 
/* 127 */       GL13.glActiveTexture(33984);
/* 128 */       RenderUtils.bindTexture(this.glowFrameBuffer.field_147617_g);
/* 129 */       ShaderUtil.drawQuads();
/* 130 */       this.glowShader.unload();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupGlowUniforms(float dir1, float dir2) {
/* 138 */     Color color = getColor();
/*     */     
/* 140 */     this.glowShader.setUniformi("texture", new int[] { 0 });
/* 141 */     if (((Boolean)this.seperate.get()).booleanValue()) {
/* 142 */       this.glowShader.setUniformi("textureToCheck", new int[] { 16 });
/*     */     }
/* 144 */     this.glowShader.setUniformf("radius", new float[] { ((Float)this.radius.get()).floatValue() });
/* 145 */     this.glowShader.setUniformf("texelSize", new float[] { 1.0F / mc.getDisplayWidth(), 1.0F / mc.getDisplayHeight() });
/* 146 */     this.glowShader.setUniformf("direction", new float[] { dir1, dir2 });
/* 147 */     this.glowShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F });
/* 148 */     this.glowShader.setUniformf("exposure", new float[] { (float)(((Float)this.exposure.get()).floatValue() * fadeIn.getOutput()) });
/* 149 */     this.glowShader.setUniformi("avoidTexture", new int[] { ((Boolean)this.seperate.get()).booleanValue() ? 1 : 0 });
/*     */     
/* 151 */     FloatBuffer buffer = BufferUtils.createFloatBuffer(256);
/* 152 */     for (int i = 1; i <= ((Float)this.radius.getValue()).floatValue(); i++) {
/* 153 */       buffer.put(MathUtils.calculateGaussianValue(i, ((Float)this.radius.get()).floatValue() / 2.0F));
/*     */     }
/* 155 */     buffer.rewind();
/*     */     
/* 157 */     GL20.glUniform1(this.glowShader.getUniform("weights"), buffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupOutlineUniforms(float dir1, float dir2) {
/* 162 */     Color color = getColor();
/* 163 */     this.outlineShader.setUniformi("texture", new int[] { 0 });
/* 164 */     this.outlineShader.setUniformf("radius", new float[] { ((Float)this.radius.get()).floatValue() / 1.5F });
/* 165 */     this.outlineShader.setUniformf("texelSize", new float[] { 1.0F / mc.getDisplayWidth(), 1.0F / mc.getDisplayHeight() });
/* 166 */     this.outlineShader.setUniformf("direction", new float[] { dir1, dir2 });
/* 167 */     this.outlineShader.setUniformf("color", new float[] { color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F });
/*     */   }
/*     */   
/*     */   public void renderEntities(float ticks) {
/* 171 */     this.entities.forEach(entity -> {
/*     */           renderNameTags = false;
/*     */           mc2.func_175598_ae().func_188388_a(entity, ticks, false);
/*     */           renderNameTags = true;
/*     */         });
/*     */   }
/*     */   
/*     */   private Color getColor() {
/* 179 */     HUD hudMod = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 180 */     Color[] colors = hudMod.getClientColors();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     return ColorUtil.interpolateColorsBackAndForth(15, 0, colors[0], colors[1], ((Boolean)hudMod.getHueInterpolation().get()).booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void collectEntities() {
/* 191 */     this.entities.clear();
/* 192 */     for (Entity entity : mc2.field_71441_e.func_72910_y()) {
/*     */       
/* 194 */       if (!GlowESPHelper.isInView(entity) || (
/* 195 */         entity == mc2.field_71439_g && mc2.field_71474_y.field_74320_O == 0))
/* 196 */         continue;  if (entity instanceof net.minecraft.entity.passive.EntityAnimal && ((Boolean)this.Animals.get()).booleanValue()) {
/* 197 */         this.entities.add(entity);
/*     */       }
/*     */       
/* 200 */       if (entity instanceof net.minecraft.entity.player.EntityPlayer && ((Boolean)this.Players.get()).booleanValue()) {
/* 201 */         this.entities.add(entity);
/*     */       }
/*     */       
/* 204 */       if (entity instanceof net.minecraft.entity.monster.EntityMob && ((Boolean)this.Mobs.get()).booleanValue())
/* 205 */         this.entities.add(entity); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\GlowESP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */