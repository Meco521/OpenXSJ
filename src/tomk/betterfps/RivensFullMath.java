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
/*    */ public class RivensFullMath
/*    */ {
/* 16 */   private static final float BF_SIN_TO_COS = 1.5707964F;
/*    */   
/* 18 */   private static final int BF_SIN_BITS = 12;
/* 19 */   private static final int BF_SIN_MASK = -1 << BF_SIN_BITS ^ 0xFFFFFFFF;
/* 20 */   private static final int BF_SIN_COUNT = BF_SIN_MASK + 1;
/*    */   
/* 22 */   private static final float BF_radFull = 6.2831855F;
/* 23 */   private static final float BF_radToIndex = BF_SIN_COUNT / BF_radFull;
/*    */   
/* 25 */   private static final float[] BF_sinFull = new float[BF_SIN_COUNT]; static {
/* 26 */     for (int i = 0; i < BF_SIN_COUNT; i++)
/* 27 */       BF_sinFull[i] = (float)Math.sin((i + Math.min(1, i % BF_SIN_COUNT / 4) * 0.5D) / BF_SIN_COUNT * BF_radFull); 
/*    */   }
/*    */   
/*    */   public float sin(float rad) {
/* 31 */     return BF_sinFull[(int)(rad * BF_radToIndex) & BF_SIN_MASK];
/*    */   }
/*    */   
/*    */   public float cos(float rad) {
/* 35 */     return sin(rad + BF_SIN_TO_COS);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\betterfps\RivensFullMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */