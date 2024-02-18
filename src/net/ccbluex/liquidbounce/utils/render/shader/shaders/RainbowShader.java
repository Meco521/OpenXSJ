/*    */ package net.ccbluex.liquidbounce.utils.render.shader.shaders;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\007\n\002\b\013\n\002\020\002\n\002\b\006\030\000 \0322\0020\0012\0020\002:\001\032B\005¢\006\002\020\003J\b\020\024\032\0020\025H\026J\b\020\026\032\0020\025H\026J\b\020\027\032\0020\025H\026J\b\020\030\032\0020\025H\026J\b\020\031\032\0020\025H\026R\036\020\006\032\0020\0052\006\020\004\032\0020\005@BX\016¢\006\b\n\000\032\004\b\006\020\007R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\032\020\016\032\0020\tX\016¢\006\016\n\000\032\004\b\017\020\013\"\004\b\020\020\rR\032\020\021\032\0020\tX\016¢\006\016\n\000\032\004\b\022\020\013\"\004\b\023\020\r¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowShader;", "Lnet/ccbluex/liquidbounce/utils/render/shader/Shader;", "Ljava/io/Closeable;", "()V", "<set-?>", "", "isInUse", "()Z", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "strengthX", "getStrengthX", "setStrengthX", "strengthY", "getStrengthY", "setStrengthY", "close", "", "setupUniforms", "startShader", "stopShader", "updateUniforms", "Companion", "XSJClient"})
/*    */ public final class RainbowShader extends Shader implements Closeable {
/*    */   private boolean isInUse;
/*    */   private float strengthX;
/*    */   
/*  7 */   public RainbowShader() { super("rainbow_shader.frag"); } private float strengthY; private float offset; @JvmField @NotNull
/*  8 */   public static final RainbowShader INSTANCE; public final boolean isInUse() { return this.isInUse; }
/*    */ 
/*    */   
/* 11 */   public final float getStrengthX() { return this.strengthX; } public final void setStrengthX(float <set-?>) { this.strengthX = <set-?>; }
/* 12 */   public final float getStrengthY() { return this.strengthY; } public final void setStrengthY(float <set-?>) { this.strengthY = <set-?>; }
/* 13 */   public final float getOffset() { return this.offset; } public final void setOffset(float <set-?>) { this.offset = <set-?>; }
/*    */   
/*    */   public void setupUniforms() {
/* 16 */     setupUniform("offset");
/* 17 */     setupUniform("strength");
/*    */   }
/*    */   
/*    */   public void updateUniforms() {
/* 21 */     GL20.glUniform2f(getUniform("strength"), this.strengthX, this.strengthY);
/* 22 */     GL20.glUniform1f(getUniform("offset"), this.offset);
/*    */   }
/*    */   
/*    */   public void startShader() {
/* 26 */     super.startShader();
/*    */     
/* 28 */     this.isInUse = true;
/*    */   }
/*    */   
/*    */   public void stopShader() {
/* 32 */     super.stopShader();
/*    */     
/* 34 */     this.isInUse = false;
/*    */   }
/*    */   
/*    */   public void close() {
/* 38 */     if (this.isInUse) {
/* 39 */       stopShader();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 44 */   public static final Companion Companion = new Companion(null); static { INSTANCE = new RainbowShader(); }
/*    */    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\007\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J)\020\005\032\0020\0042\006\020\006\032\0020\0072\006\020\b\032\0020\t2\006\020\n\032\0020\t2\006\020\013\032\0020\tH\bR\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowShader$Companion;", "", "()V", "INSTANCE", "Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowShader;", "begin", "enable", "", "x", "", "y", "offset", "XSJClient"})
/*    */   public static final class Companion { private Companion() {} @NotNull
/*    */     public final RainbowShader begin(boolean enable, float x, float y, float offset) {
/* 48 */       int $i$f$begin = 0; RainbowShader instance = RainbowShader.INSTANCE;
/*    */       
/* 50 */       if (enable) {
/* 51 */         instance.setStrengthX(x);
/* 52 */         instance.setStrengthY(y);
/* 53 */         instance.setOffset(offset);
/*    */         
/* 55 */         instance.startShader();
/*    */       } 
/*    */       
/* 58 */       return instance;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\shader\shaders\RainbowShader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */