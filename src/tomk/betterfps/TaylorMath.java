/*    */ package tomk.betterfps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaylorMath
/*    */ {
/*    */   private static final float BF_SIN_TO_COS = 1.5707964F;
/*    */   private static final double TAU = 6.283185307179586D;
/*    */   
/*    */   public float sin(float rad) {
/* 13 */     long n = (long)(rad / 6.283185307179586D);
/* 14 */     double x = rad - n * 6.283185307179586D;
/*    */     
/* 16 */     double x2 = x * x;
/* 17 */     double x3 = x2 * x;
/* 18 */     double x5 = x2 * x3;
/* 19 */     double x7 = x2 * x5;
/* 20 */     double x9 = x2 * x7;
/* 21 */     double x11 = x2 * x9;
/* 22 */     double x13 = x2 * x11;
/* 23 */     double x15 = x2 * x13;
/* 24 */     double x17 = x2 * x15;
/*    */     
/* 26 */     x -= x3 * 0.16666666666666666D;
/* 27 */     x += x5 * 0.008333333333333333D;
/* 28 */     x -= x7 * 1.984126984126984E-4D;
/* 29 */     x += x9 * 2.7557319223985893E-6D;
/* 30 */     x -= x11 * 2.505210838544172E-8D;
/* 31 */     x += x13 * 1.6059043836821613E-10D;
/* 32 */     x -= x15 * 7.647163731819816E-13D;
/* 33 */     x += x17 * 2.8114572543455206E-15D;
/* 34 */     return (float)x;
/*    */   }
/*    */   
/*    */   public float cos(float rad) {
/* 38 */     return sin(rad + 1.5707964F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\betterfps\TaylorMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */