/*     */ package tomk.utils.render;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLUtils
/*     */ {
/*     */   private static FloatBuffer colorBuffer;
/*     */   
/*     */   public static void disableStandardItemLighting() {
/*  21 */     GlStateManager.func_179140_f();
/*  22 */     GlStateManager.func_179122_b(0);
/*  23 */     GlStateManager.func_179122_b(1);
/*  24 */     GlStateManager.func_179119_h();
/*     */   }
/*     */   public static void enableGUIStandardItemLighting() {
/*  27 */     GlStateManager.func_179094_E();
/*  28 */     GlStateManager.func_179114_b(-30.0F, 0.0F, 1.0F, 0.0F);
/*  29 */     GlStateManager.func_179114_b(165.0F, 1.0F, 0.0F, 0.0F);
/*  30 */     enableStandardItemLighting();
/*  31 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public static void enableStandardItemLighting() {
/*  35 */     GlStateManager.func_179145_e();
/*  36 */     GlStateManager.func_179085_a(0);
/*  37 */     GlStateManager.func_179085_a(1);
/*  38 */     GlStateManager.func_179142_g();
/*  39 */     GlStateManager.func_179104_a(1032, 5634);
/*  40 */     float n = 0.4F;
/*  41 */     float n2 = 0.6F;
/*  42 */     GL11.glLight(16384, 4609, setColorBuffer(0.6F, 0.6F, 0.6F, 1.0F));
/*  43 */     GL11.glLight(16384, 4608, setColorBuffer(0.0F, 0.0F, 0.0F, 1.0F));
/*     */     
/*  45 */     GL11.glLight(16385, 4609, setColorBuffer(0.6F, 0.6F, 0.6F, 1.0F));
/*  46 */     GL11.glLight(16385, 4608, setColorBuffer(0.0F, 0.0F, 0.0F, 1.0F));
/*     */     
/*  48 */     GlStateManager.func_179103_j(7424);
/*  49 */     GL11.glLightModel(2899, setColorBuffer(0.4F, 0.4F, 0.4F, 1.0F));
/*     */   }
/*     */   public static void startSmooth() {
/*  52 */     GL11.glEnable(2848);
/*  53 */     GL11.glEnable(2881);
/*  54 */     GL11.glEnable(2832);
/*  55 */     GL11.glEnable(3042);
/*  56 */     GL11.glBlendFunc(770, 771);
/*  57 */     GL11.glHint(3154, 4354);
/*  58 */     GL11.glHint(3155, 4354);
/*  59 */     GL11.glHint(3153, 4354);
/*     */   }
/*     */   
/*     */   public static void endSmooth() {
/*  63 */     GL11.glDisable(2848);
/*  64 */     GL11.glDisable(2881);
/*  65 */     GL11.glEnable(2832);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static FloatBuffer setColorBuffer(double p_setColorBuffer_0_, double p_setColorBuffer_2_, double p_setColorBuffer_4_, double p_setColorBuffer_6_) {
/*  71 */     return setColorBuffer((float)p_setColorBuffer_0_, (float)p_setColorBuffer_2_, (float)p_setColorBuffer_4_, (float)p_setColorBuffer_6_);
/*     */   }
/*     */   
/*     */   private static FloatBuffer setColorBuffer(float p_setColorBuffer_0_, float p_setColorBuffer_1_, float p_setColorBuffer_2_, float p_setColorBuffer_3_) {
/*  75 */     colorBuffer.clear();
/*  76 */     colorBuffer.put(p_setColorBuffer_0_).put(p_setColorBuffer_1_).put(p_setColorBuffer_2_).put(p_setColorBuffer_3_);
/*  77 */     colorBuffer.flip();
/*  78 */     return colorBuffer;
/*     */   }
/*     */   
/*     */   public static void setGLCap(int cap, boolean flag) {
/*  82 */     glCapMap.put(Integer.valueOf(cap), Boolean.valueOf(GL11.glGetBoolean(cap)));
/*  83 */     if (flag) {
/*  84 */       GL11.glEnable(cap);
/*     */     } else {
/*  86 */       GL11.glDisable(cap);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void revertGLCap(int cap) {
/*  91 */     Boolean origCap = glCapMap.get(Integer.valueOf(cap));
/*  92 */     if (origCap != null) {
/*  93 */       if (origCap.booleanValue()) {
/*  94 */         GL11.glEnable(cap);
/*     */       } else {
/*  96 */         GL11.glDisable(cap);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static void glEnable(int cap) {
/* 102 */     setGLCap(cap, true);
/*     */   }
/*     */   
/*     */   public static void glDisable(int cap) {
/* 106 */     setGLCap(cap, false);
/*     */   }
/*     */   
/*     */   public static void revertAllCaps() {
/* 110 */     for (Iterator<Integer> localIterator = glCapMap.keySet().iterator(); localIterator.hasNext(); ) {
/* 111 */       int cap = ((Integer)localIterator.next()).intValue();
/* 112 */       revertGLCap(cap);
/*     */     } 
/*     */   }
/*     */   
/* 116 */   private static Map<Integer, Boolean> glCapMap = new HashMap<>();
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\render\GLUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */