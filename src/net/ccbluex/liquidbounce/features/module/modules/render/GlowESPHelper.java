/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.tenacity.MathUtils;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.renderer.GLAllocation;
/*    */ import net.minecraft.client.renderer.culling.Frustum;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.lwjgl.util.glu.GLU;
/*    */ import org.lwjgl.util.vector.Vector3f;
/*    */ import org.lwjgl.util.vector.Vector4f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GlowESPHelper
/*    */ {
/* 27 */   private static final Frustum frustum = new Frustum();
/* 28 */   private static final FloatBuffer windPos = BufferUtils.createFloatBuffer(4);
/* 29 */   private static final IntBuffer intBuffer = GLAllocation.func_74527_f(16);
/* 30 */   private static final FloatBuffer floatBuffer1 = GLAllocation.func_74529_h(16);
/* 31 */   private static final FloatBuffer floatBuffer2 = GLAllocation.func_74529_h(16);
/*    */   
/*    */   public static boolean isInView(Entity ent) {
/* 34 */     frustum.func_78547_a(MinecraftInstance.mc.getRenderViewEntity().getPosX(), MinecraftInstance.mc.getRenderViewEntity().getPosY(), MinecraftInstance.mc.getRenderViewEntity().getPosZ());
/* 35 */     return (frustum.func_78546_a(ent.func_174813_aQ()) || ent.field_70158_ak);
/*    */   }
/*    */   
/*    */   public static Vector3f projectOn2D(float x, float y, float z, int scaleFactor) {
/* 39 */     GL11.glGetFloat(2982, floatBuffer1);
/* 40 */     GL11.glGetFloat(2983, floatBuffer2);
/* 41 */     GL11.glGetInteger(2978, intBuffer);
/* 42 */     if (GLU.gluProject(x, y, z, floatBuffer1, floatBuffer2, intBuffer, windPos)) {
/* 43 */       return new Vector3f(windPos.get(0) / scaleFactor, (MinecraftInstance.mc2.field_71440_d - windPos.get(1)) / scaleFactor, windPos.get(2));
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */   
/*    */   public static double[] getInterpolatedPos(Entity entity) {
/* 49 */     float ticks = MinecraftInstance.mc2.field_71428_T.field_194147_b;
/* 50 */     return new double[] {
/* 51 */         MathUtils.interpolate(entity.field_70142_S, entity.field_70165_t, ticks).doubleValue() - MinecraftInstance.mc.getRenderManager().getRenderPosX(), 
/* 52 */         MathUtils.interpolate(entity.field_70137_T, entity.field_70163_u, ticks).doubleValue() - MinecraftInstance.mc.getRenderManager().getRenderPosY(), 
/* 53 */         MathUtils.interpolate(entity.field_70136_U, entity.field_70161_v, ticks).doubleValue() - MinecraftInstance.mc.getRenderManager().getRenderPosZ()
/*    */       };
/*    */   }
/*    */   
/*    */   public static Vector4f getEntityPositionsOn2D(Entity entity) {
/* 58 */     double[] renderingEntityPos = getInterpolatedPos(entity);
/* 59 */     double entityRenderWidth = entity.field_70130_N / 1.5D;
/*    */ 
/*    */     
/* 62 */     AxisAlignedBB bb = (new AxisAlignedBB(renderingEntityPos[0] - entityRenderWidth, renderingEntityPos[1], renderingEntityPos[2] - entityRenderWidth, renderingEntityPos[0] + entityRenderWidth, renderingEntityPos[1] + entity.field_70131_O + (entity.func_70093_af() ? -0.3D : 0.18D), renderingEntityPos[2] + entityRenderWidth)).func_72321_a(0.15D, 0.15D, 0.15D);
/*    */     
/* 64 */     List<Vector3f> vectors = Arrays.asList(new Vector3f[] { new Vector3f((float)bb.field_72340_a, (float)bb.field_72338_b, (float)bb.field_72339_c), new Vector3f((float)bb.field_72340_a, (float)bb.field_72337_e, (float)bb.field_72339_c), new Vector3f((float)bb.field_72336_d, (float)bb.field_72338_b, (float)bb.field_72339_c), new Vector3f((float)bb.field_72336_d, (float)bb.field_72337_e, (float)bb.field_72339_c), new Vector3f((float)bb.field_72340_a, (float)bb.field_72338_b, (float)bb.field_72334_f), new Vector3f((float)bb.field_72340_a, (float)bb.field_72337_e, (float)bb.field_72334_f), new Vector3f((float)bb.field_72336_d, (float)bb.field_72338_b, (float)bb.field_72334_f), new Vector3f((float)bb.field_72336_d, (float)bb.field_72337_e, (float)bb.field_72334_f) });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 74 */     Vector4f entityPos = new Vector4f(Float.MAX_VALUE, Float.MAX_VALUE, -1.0F, -1.0F);
/* 75 */     ScaledResolution sr = new ScaledResolution(MinecraftInstance.mc2);
/* 76 */     for (Vector3f vector3f : vectors) {
/* 77 */       vector3f = projectOn2D(vector3f.x, vector3f.y, vector3f.z, sr.func_78325_e());
/* 78 */       if (vector3f != null && vector3f.z >= 0.0D && vector3f.z < 1.0D) {
/* 79 */         entityPos.x = Math.min(vector3f.x, entityPos.x);
/* 80 */         entityPos.y = Math.min(vector3f.y, entityPos.y);
/* 81 */         entityPos.z = Math.max(vector3f.x, entityPos.z);
/* 82 */         entityPos.w = Math.max(vector3f.y, entityPos.w);
/*    */       } 
/*    */     } 
/* 85 */     return entityPos;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\GlowESPHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */