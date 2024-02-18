/*    */ package tomk.betterfps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RivensMath
/*    */ {
/* 16 */   private static final int BF_SIN_BITS = 12;
/* 17 */   private static final int BF_SIN_MASK = -1 << BF_SIN_BITS ^ 0xFFFFFFFF;
/* 18 */   private static final int BF_SIN_COUNT = BF_SIN_MASK + 1;
/*    */   
/* 20 */   private static final float BF_radFull = 6.2831855F; private static final float BF_radToIndex;
/* 21 */   private static final float BF_degFull = 360.0F; private static final float BF_degToIndex; static {
/* 22 */     BF_radToIndex = BF_SIN_COUNT / BF_radFull;
/* 23 */     BF_degToIndex = BF_SIN_COUNT / BF_degFull;
/*    */     
/* 25 */     BF_sin = new float[BF_SIN_COUNT];
/* 26 */     BF_cos = new float[BF_SIN_COUNT];
/*    */     int i;
/* 28 */     for (i = 0; i < BF_SIN_COUNT; i++) {
/* 29 */       BF_sin[i] = (float)Math.sin(((i + 0.5F) / BF_SIN_COUNT * BF_radFull));
/* 30 */       BF_cos[i] = (float)Math.cos(((i + 0.5F) / BF_SIN_COUNT * BF_radFull));
/*    */     } 
/*    */     
/* 33 */     for (i = 0; i < 360; i += 90) {
/* 34 */       BF_sin[(int)(i * BF_degToIndex) & BF_SIN_MASK] = (float)Math.sin(i * Math.PI / 180.0D);
/* 35 */       BF_cos[(int)(i * BF_degToIndex) & BF_SIN_MASK] = (float)Math.cos(i * Math.PI / 180.0D);
/*    */     } 
/*    */   }
/*    */   private static final float[] BF_sin; private static final float[] BF_cos;
/*    */   public float sin(float rad) {
/* 40 */     return BF_sin[(int)(rad * BF_radToIndex) & BF_SIN_MASK];
/*    */   }
/*    */   
/*    */   public float cos(float rad) {
/* 44 */     return BF_cos[(int)(rad * BF_radToIndex) & BF_SIN_MASK];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\betterfps\RivensMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */