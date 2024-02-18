/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import org.lwjgl.opengl.EXTFramebufferObject;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.Cylinder;
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
/*     */ public final class ESPUtils
/*     */ {
/*     */   public static void renderOne() {
/*  31 */     checkSetupFBO();
/*  32 */     GL11.glPushAttrib(1048575);
/*  33 */     GL11.glDisable(3008);
/*  34 */     GL11.glDisable(3553);
/*  35 */     GL11.glDisable(2896);
/*  36 */     GL11.glEnable(3042);
/*  37 */     GL11.glBlendFunc(770, 771);
/*  38 */     GL11.glLineWidth(2.0F);
/*  39 */     GL11.glEnable(2848);
/*  40 */     GL11.glEnable(2960);
/*  41 */     GL11.glClear(1024);
/*  42 */     GL11.glClearStencil(15);
/*  43 */     GL11.glStencilFunc(512, 1, 15);
/*  44 */     GL11.glStencilOp(7681, 7681, 7681);
/*  45 */     GL11.glPolygonMode(1032, 6913);
/*     */   }
/*     */   
/*     */   public static void checkSetupFBO() {
/*  49 */     Framebuffer fbo = Minecraft.func_71410_x().func_147110_a();
/*  50 */     if (fbo != null && fbo.field_147624_h > -1) {
/*  51 */       setupFBO(fbo);
/*  52 */       fbo.field_147624_h = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setupFBO(Framebuffer fbo) {
/*  57 */     EXTFramebufferObject.glDeleteRenderbuffersEXT(fbo.field_147624_h);
/*  58 */     int stencil_depth_buffer_ID = EXTFramebufferObject.glGenRenderbuffersEXT();
/*  59 */     EXTFramebufferObject.glBindRenderbufferEXT(36161, stencil_depth_buffer_ID);
/*  60 */     EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/*  61 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, stencil_depth_buffer_ID);
/*  62 */     EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, stencil_depth_buffer_ID);
/*     */   }
/*     */   
/*     */   public static void cylinder(Entity player, double x, double y, double z, double range, int s) {
/*  66 */     GL11.glPushMatrix();
/*  67 */     GL11.glDisable(2896);
/*  68 */     GL11.glDisable(3553);
/*  69 */     GL11.glEnable(3042);
/*  70 */     GL11.glBlendFunc(770, 771);
/*  71 */     GL11.glDisable(2929);
/*  72 */     GL11.glEnable(2848);
/*  73 */     GL11.glDepthMask(true);
/*  74 */     GlStateManager.func_179137_b(x, y, z);
/*  75 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.75F);
/*  76 */     GlStateManager.func_179114_b(180.0F, 90.0F, 0.0F, 2.0F);
/*  77 */     GlStateManager.func_179114_b(180.0F, 0.0F, 90.0F, 90.0F);
/*  78 */     Cylinder c = new Cylinder();
/*  79 */     c.setDrawStyle(100011);
/*  80 */     c.draw((float)(range - 0.5D), (float)(range - 0.5D), 0.0F, s, 0);
/*     */     
/*  82 */     GL11.glDepthMask(true);
/*  83 */     GL11.glDisable(2848);
/*  84 */     GL11.glEnable(2929);
/*  85 */     GL11.glDisable(3042);
/*  86 */     GL11.glEnable(2896);
/*  87 */     GL11.glEnable(3553);
/*  88 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public static void shadow(Entity player, double x, double y, double z, double range, int s) {
/*  92 */     GL11.glPushMatrix();
/*  93 */     GL11.glDisable(2896);
/*  94 */     GL11.glDisable(3553);
/*  95 */     GL11.glEnable(3042);
/*  96 */     GL11.glBlendFunc(770, 771);
/*  97 */     GL11.glDisable(2929);
/*  98 */     GL11.glEnable(2848);
/*  99 */     GL11.glDepthMask(true);
/* 100 */     GlStateManager.func_179137_b(x, y, z);
/* 101 */     GlStateManager.func_179131_c(0.1F, 0.1F, 0.1F, 0.75F);
/* 102 */     GlStateManager.func_179114_b(180.0F, 90.0F, 0.0F, 2.0F);
/* 103 */     GlStateManager.func_179114_b(180.0F, 0.0F, 90.0F, 90.0F);
/* 104 */     Cylinder c = new Cylinder();
/* 105 */     c.setDrawStyle(100011);
/* 106 */     c.draw((float)(range - 0.45D), (float)(range - 0.5D), 0.0F, s, 0);
/*     */     
/* 108 */     GL11.glDepthMask(true);
/* 109 */     GL11.glDisable(2848);
/* 110 */     GL11.glEnable(2929);
/* 111 */     GL11.glDisable(3042);
/* 112 */     GL11.glEnable(2896);
/* 113 */     GL11.glEnable(3553);
/* 114 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public static void drawBoundingBox(IAxisAlignedBB aa) {
/* 118 */     ITessellator tessellator = MinecraftInstance.classProvider.getTessellatorInstance();
/* 119 */     IWorldRenderer worldRenderer = tessellator.getWorldRenderer();
/* 120 */     worldRenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 121 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 122 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 123 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 124 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 125 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 126 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 127 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 128 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 129 */     tessellator.draw();
/* 130 */     worldRenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 131 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 132 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 133 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 134 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 135 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 136 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 137 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 138 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 139 */     tessellator.draw();
/* 140 */     worldRenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 141 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 142 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 143 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 144 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 145 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 146 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 147 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 148 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 149 */     tessellator.draw();
/* 150 */     worldRenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 151 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 152 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 153 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 154 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 155 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 156 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 157 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 158 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 159 */     tessellator.draw();
/* 160 */     worldRenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 161 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 162 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 163 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 164 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 165 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 166 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 167 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 168 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 169 */     tessellator.draw();
/* 170 */     worldRenderer.begin(7, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/* 171 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 172 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 173 */     worldRenderer.pos(aa.getMinX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 174 */     worldRenderer.pos(aa.getMinX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 175 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMinZ()).endVertex();
/* 176 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMinZ()).endVertex();
/* 177 */     worldRenderer.pos(aa.getMaxX(), aa.getMaxY(), aa.getMaxZ()).endVertex();
/* 178 */     worldRenderer.pos(aa.getMaxX(), aa.getMinY(), aa.getMaxZ()).endVertex();
/* 179 */     tessellator.draw();
/*     */   }
/*     */   
/*     */   public static void setColor(IEntity entity) {
/* 183 */     if (entity != null) {
/* 184 */       byte b = -1;
/*     */     }
/*     */     
/* 187 */     GL11.glDepthMask(false);
/* 188 */     GL11.glDisable(2929);
/* 189 */     GL11.glEnable(10754);
/* 190 */     GL11.glPolygonOffset(1.0F, -2000000.0F);
/* 191 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
/*     */   }
/*     */   
/*     */   public static void drawCylinderESP(EntityLivingBase entity, int color, double x, double y, double z, int s) {
/* 195 */     GL11.glPushMatrix();
/* 196 */     GL11.glTranslated(x, y, z);
/* 197 */     GL11.glRotatef(-entity.field_70130_N, 0.0F, 1.0F, 0.0F);
/* 198 */     glColor(color);
/* 199 */     enableSmoothLine(1.0F);
/* 200 */     Cylinder c = new Cylinder();
/* 201 */     GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 202 */     c.setDrawStyle(100011);
/* 203 */     c.draw(0.5F, 0.5F, entity.field_70131_O - 0.2F, s, 1);
/* 204 */     disableSmoothLine();
/* 205 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public static void glColor(int hex) {
/* 209 */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/* 210 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 211 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 212 */     float blue = (hex & 0xFF) / 255.0F;
/* 213 */     GL11.glColor4f(red, green, blue, (alpha == 0.0F) ? 1.0F : alpha);
/*     */   }
/*     */   
/*     */   public static void enableSmoothLine(float width) {
/* 217 */     GL11.glDisable(3008);
/* 218 */     GL11.glEnable(3042);
/* 219 */     GL11.glBlendFunc(770, 771);
/* 220 */     GL11.glDisable(3553);
/* 221 */     GL11.glDisable(2929);
/* 222 */     GL11.glDepthMask(false);
/* 223 */     GL11.glEnable(2884);
/* 224 */     GL11.glEnable(2848);
/* 225 */     GL11.glHint(3154, 4354);
/* 226 */     GL11.glHint(3155, 4354);
/* 227 */     GL11.glLineWidth(width);
/*     */   }
/*     */   
/*     */   public static void disableSmoothLine() {
/* 231 */     GL11.glEnable(3553);
/* 232 */     GL11.glEnable(2929);
/* 233 */     GL11.glDisable(3042);
/* 234 */     GL11.glEnable(3008);
/* 235 */     GL11.glDepthMask(true);
/* 236 */     GL11.glCullFace(1029);
/* 237 */     GL11.glDisable(2848);
/* 238 */     GL11.glHint(3154, 4352);
/* 239 */     GL11.glHint(3155, 4352);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\ESPUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */