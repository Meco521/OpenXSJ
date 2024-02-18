/*    */ package net.ccbluex.liquidbounce.utils.render.shader.shaders;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\007\n\002\b\017\n\002\020\002\n\002\b\005\bÆ\002\030\0002\0020\0012\0020\002B\007\b\002¢\006\002\020\003J)\020\024\032\0020\0002\006\020\025\032\0020\0052\006\020\026\032\0020\t2\006\020\027\032\0020\t2\006\020\b\032\0020\tH\bJ\b\020\030\032\0020\031H\026J\b\020\032\032\0020\031H\026J\b\020\033\032\0020\031H\026J\b\020\034\032\0020\031H\026J\b\020\035\032\0020\031H\026R\036\020\006\032\0020\0052\006\020\004\032\0020\005@BX\016¢\006\b\n\000\032\004\b\006\020\007R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\032\020\016\032\0020\tX\016¢\006\016\n\000\032\004\b\017\020\013\"\004\b\020\020\rR\032\020\021\032\0020\tX\016¢\006\016\n\000\032\004\b\022\020\013\"\004\b\023\020\r¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;", "Lnet/ccbluex/liquidbounce/utils/render/shader/Shader;", "Ljava/io/Closeable;", "()V", "<set-?>", "", "isInUse", "()Z", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "strengthX", "getStrengthX", "setStrengthX", "strengthY", "getStrengthY", "setStrengthY", "begin", "enable", "x", "y", "close", "", "setupUniforms", "startShader", "stopShader", "updateUniforms", "XSJClient"})
/*    */ public final class RainbowFontShader extends Shader implements Closeable {
/*    */   private static boolean isInUse;
/*    */   private static float strengthX;
/*    */   
/*  7 */   private RainbowFontShader() { super("rainbow_font_shader.frag"); } private static float strengthY; private static float offset; public static final RainbowFontShader INSTANCE; static { RainbowFontShader rainbowFontShader = new RainbowFontShader(); } public final boolean isInUse() {
/*  8 */     return isInUse;
/*    */   }
/*    */   
/* 11 */   public final float getStrengthX() { return strengthX; } public final void setStrengthX(float <set-?>) { strengthX = <set-?>; }
/* 12 */   public final float getStrengthY() { return strengthY; } public final void setStrengthY(float <set-?>) { strengthY = <set-?>; }
/* 13 */   public final float getOffset() { return offset; } public final void setOffset(float <set-?>) { offset = <set-?>; }
/*    */   
/*    */   public void setupUniforms() {
/* 16 */     setupUniform("offset");
/* 17 */     setupUniform("strength");
/*    */   }
/*    */   
/*    */   public void updateUniforms() {
/* 21 */     GL20.glUniform2f(getUniform("strength"), strengthX, strengthY);
/* 22 */     GL20.glUniform1f(getUniform("offset"), offset);
/*    */   }
/*    */   
/*    */   public void startShader() {
/* 26 */     super.startShader();
/*    */     
/* 28 */     isInUse = true;
/*    */   }
/*    */   
/*    */   public void stopShader() {
/* 32 */     super.stopShader();
/*    */     
/* 34 */     isInUse = false;
/*    */   }
/*    */   
/*    */   public void close() {
/* 38 */     if (isInUse)
/* 39 */       stopShader(); 
/*    */   }
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final RainbowFontShader begin(boolean enable, float x, float y, float offset) {
/* 45 */     int $i$f$begin = 0; if (enable) {
/* 46 */       INSTANCE.setStrengthX(x);
/* 47 */       INSTANCE.setStrengthY(y);
/* 48 */       INSTANCE.setOffset(offset);
/*    */       
/* 50 */       INSTANCE.startShader();
/*    */     } 
/*    */     
/* 53 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\shader\shaders\RainbowFontShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */