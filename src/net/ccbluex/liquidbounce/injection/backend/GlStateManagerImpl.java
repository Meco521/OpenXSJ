/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\002\b\024\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026J\b\020\007\032\0020\004H\026J\b\020\b\032\0020\004H\026J\b\020\t\032\0020\004H\026J\b\020\n\032\0020\004H\026J\b\020\013\032\0020\004H\026J\b\020\f\032\0020\004H\026J\b\020\r\032\0020\004H\026J\b\020\016\032\0020\004H\026J\b\020\017\032\0020\004H\026J\b\020\020\032\0020\004H\026J\b\020\021\032\0020\004H\026J\b\020\022\032\0020\004H\026J\b\020\023\032\0020\004H\026J\b\020\024\032\0020\004H\026J(\020\025\032\0020\0042\006\020\026\032\0020\0062\006\020\027\032\0020\0062\006\020\030\032\0020\0062\006\020\031\032\0020\006H\026¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GlStateManagerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;", "()V", "bindTexture", "", "textureID", "", "disableBlend", "disableCull", "disableLighting", "disableRescaleNormal", "disableTexture2D", "enableAlpha", "enableBlend", "enableColorMaterial", "enableTexture2D", "popAttrib", "popMatrix", "pushAttrib", "pushMatrix", "resetColor", "tryBlendFuncSeparate", "glSrcAlpha", "glOneMinusSrcAlpha", "glOne", "glZero", "XSJClient"})
/*    */ public final class GlStateManagerImpl implements IGlStateManager {
/*  6 */   static { GlStateManagerImpl glStateManagerImpl = new GlStateManagerImpl(); } public static final GlStateManagerImpl INSTANCE; public void bindTexture(int textureID) {
/*  7 */     GlStateManager.func_179144_i(textureID); } public void resetColor() {
/*  8 */     GlStateManager.func_179117_G();
/*    */   } public void enableTexture2D() {
/* 10 */     GlStateManager.func_179098_w();
/*    */   } public void enableBlend() {
/* 12 */     GlStateManager.func_179147_l();
/*    */   } public void tryBlendFuncSeparate(int glSrcAlpha, int glOneMinusSrcAlpha, int glOne, int glZero) {
/* 14 */     GlStateManager.func_179120_a(glSrcAlpha, glOneMinusSrcAlpha, glOne, glZero);
/*    */   } public void disableTexture2D() {
/* 16 */     GlStateManager.func_179090_x();
/*    */   } public void disableBlend() {
/* 18 */     GlStateManager.func_179084_k();
/*    */   } public void enableAlpha() {
/* 20 */     GlStateManager.func_179141_d();
/*    */   } public void disableLighting() {
/* 22 */     GlStateManager.func_179140_f();
/*    */   } public void disableCull() {
/* 24 */     GlStateManager.func_179129_p();
/*    */   } public void enableColorMaterial() {
/* 26 */     GlStateManager.func_179142_g();
/*    */   } public void disableRescaleNormal() {
/* 28 */     GlStateManager.func_179101_C();
/*    */   } public void pushMatrix() {
/* 30 */     GlStateManager.func_179094_E();
/*    */   } public void pushAttrib() {
/* 32 */     GlStateManager.func_179123_a();
/*    */   } public void popMatrix() {
/* 34 */     GlStateManager.func_179121_F();
/*    */   } public void popAttrib() {
/* 36 */     GlStateManager.func_179099_b();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GlStateManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */