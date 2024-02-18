/*     */ package me.utils.render;
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
/*     */ 
/*     */ 
/*     */ public class GLUtils
/*     */ {
/*     */   private static FloatBuffer colorBuffer;
/*     */   
/*     */   public static void disableStandardItemLighting() {
/*  23 */     GlStateManager.func_179140_f();
/*  24 */     GlStateManager.func_179122_b(0);
/*  25 */     GlStateManager.func_179122_b(1);
/*  26 */     GlStateManager.func_179119_h();
/*     */   }
/*     */   public static void enableGUIStandardItemLighting() {
/*  29 */     GlStateManager.func_179094_E();
/*  30 */     GlStateManager.func_179114_b(-30.0F, 0.0F, 1.0F, 0.0F);
/*  31 */     GlStateManager.func_179114_b(165.0F, 1.0F, 0.0F, 0.0F);
/*  32 */     enableStandardItemLighting();
/*  33 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public static void enableStandardItemLighting() {
/*  37 */     GlStateManager.func_179145_e();
/*  38 */     GlStateManager.func_179085_a(0);
/*  39 */     GlStateManager.func_179085_a(1);
/*  40 */     GlStateManager.func_179142_g();
/*  41 */     GlStateManager.func_179104_a(1032, 5634);
/*  42 */     float n = 0.4F;
/*  43 */     float n2 = 0.6F;
/*  44 */     GL11.glLight(16384, 4609, setColorBuffer(0.6F, 0.6F, 0.6F, 1.0F));
/*  45 */     GL11.glLight(16384, 4608, setColorBuffer(0.0F, 0.0F, 0.0F, 1.0F));
/*     */     
/*  47 */     GL11.glLight(16385, 4609, setColorBuffer(0.6F, 0.6F, 0.6F, 1.0F));
/*  48 */     GL11.glLight(16385, 4608, setColorBuffer(0.0F, 0.0F, 0.0F, 1.0F));
/*     */     
/*  50 */     GlStateManager.func_179103_j(7424);
/*  51 */     GL11.glLightModel(2899, setColorBuffer(0.4F, 0.4F, 0.4F, 1.0F));
/*     */   }
/*     */   public static void startSmooth() {
/*  54 */     GL11.glEnable(2848);
/*  55 */     GL11.glEnable(2881);
/*  56 */     GL11.glEnable(2832);
/*  57 */     GL11.glEnable(3042);
/*  58 */     GL11.glBlendFunc(770, 771);
/*  59 */     GL11.glHint(3154, 4354);
/*  60 */     GL11.glHint(3155, 4354);
/*  61 */     GL11.glHint(3153, 4354);
/*     */   }
/*     */   
/*     */   public static void endSmooth() {
/*  65 */     GL11.glDisable(2848);
/*  66 */     GL11.glDisable(2881);
/*  67 */     GL11.glEnable(2832);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static FloatBuffer setColorBuffer(double p_setColorBuffer_0_, double p_setColorBuffer_2_, double p_setColorBuffer_4_, double p_setColorBuffer_6_) {
/*  73 */     return setColorBuffer((float)p_setColorBuffer_0_, (float)p_setColorBuffer_2_, (float)p_setColorBuffer_4_, (float)p_setColorBuffer_6_);
/*     */   }
/*     */   
/*     */   private static FloatBuffer setColorBuffer(float p_setColorBuffer_0_, float p_setColorBuffer_1_, float p_setColorBuffer_2_, float p_setColorBuffer_3_) {
/*  77 */     colorBuffer.clear();
/*  78 */     colorBuffer.put(p_setColorBuffer_0_).put(p_setColorBuffer_1_).put(p_setColorBuffer_2_).put(p_setColorBuffer_3_);
/*  79 */     colorBuffer.flip();
/*  80 */     return colorBuffer;
/*     */   }
/*     */   
/*     */   public static void setGLCap(int cap, boolean flag) {
/*  84 */     glCapMap.put(Integer.valueOf(cap), Boolean.valueOf(GL11.glGetBoolean(cap)));
/*  85 */     if (flag) {
/*  86 */       GL11.glEnable(cap);
/*     */     } else {
/*  88 */       GL11.glDisable(cap);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void revertGLCap(int cap) {
/*  93 */     Boolean origCap = glCapMap.get(Integer.valueOf(cap));
/*  94 */     if (origCap != null) {
/*  95 */       if (origCap.booleanValue()) {
/*  96 */         GL11.glEnable(cap);
/*     */       } else {
/*  98 */         GL11.glDisable(cap);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static void glEnable(int cap) {
/* 104 */     setGLCap(cap, true);
/*     */   }
/*     */   
/*     */   public static void glDisable(int cap) {
/* 108 */     setGLCap(cap, false);
/*     */   }
/*     */   
/*     */   public static void revertAllCaps() {
/* 112 */     for (Iterator<Integer> localIterator = glCapMap.keySet().iterator(); localIterator.hasNext(); ) {
/* 113 */       int cap = ((Integer)localIterator.next()).intValue();
/* 114 */       revertGLCap(cap);
/*     */     } 
/*     */   }
/*     */   
/* 118 */   private static Map<Integer, Boolean> glCapMap = new HashMap<>();
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\render\GLUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */