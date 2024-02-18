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
/*    */ public class RivensHalfMath
/*    */ {
/* 16 */   private static final float BF_SIN_TO_COS = 1.5707964F;
/*    */   
/* 18 */   private static final int BF_SIN_BITS = 12;
/* 19 */   private static final int BF_SIN_MASK = -1 << BF_SIN_BITS ^ 0xFFFFFFFF;
/* 20 */   private static final int BF_SIN_MASK2 = BF_SIN_MASK >> 1;
/* 21 */   private static final int BF_SIN_COUNT = BF_SIN_MASK + 1;
/* 22 */   private static final int BF_SIN_COUNT2 = BF_SIN_MASK2 + 1;
/*    */   
/* 24 */   private static final float BF_radFull = 6.2831855F;
/* 25 */   private static final float BF_radToIndex = BF_SIN_COUNT / BF_radFull;
/*    */   
/* 27 */   private static final float[] BF_sinHalf = new float[BF_SIN_COUNT2]; static {
/* 28 */     for (int i = 0; i < BF_SIN_COUNT2; i++) {
/* 29 */       BF_sinHalf[i] = (float)Math.sin((i + Math.min(1, i % BF_SIN_COUNT / 4) * 0.5D) / BF_SIN_COUNT * BF_radFull);
/*    */     }
/*    */     
/* 32 */     float[] hardcodedAngles = { 1.5707964F, 1.5707964F + BF_SIN_TO_COS };
/*    */ 
/*    */ 
/*    */     
/* 36 */     for (float angle : hardcodedAngles) {
/* 37 */       int index1 = (int)(angle * BF_radToIndex) & BF_SIN_MASK;
/* 38 */       int index2 = index1 & BF_SIN_MASK2;
/* 39 */       int mul = (index1 == index2) ? 1 : -1;
/* 40 */       BF_sinHalf[index2] = (float)(Math.sin(angle) / mul);
/*    */     } 
/*    */   }
/*    */   
/*    */   public float sin(float rad) {
/* 45 */     int index1 = (int)(rad * BF_radToIndex) & BF_SIN_MASK;
/* 46 */     int index2 = index1 & BF_SIN_MASK2;
/* 47 */     int mul = (index1 == index2) ? 1 : -1;
/* 48 */     return BF_sinHalf[index2] * mul;
/*    */   }
/*    */   
/*    */   public float cos(float rad) {
/* 52 */     return sin(rad + BF_SIN_TO_COS);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\betterfps\RivensHalfMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */