/*    */ package tomk.betterfps;
/*    */ 
/*    */ public class NewMCMath {
/*    */   static {
/*  5 */     SIN_TABLE = MiscUtils.INSTANCE.<float[]>make(new float[65536], e -> {
/*    */           for (int i = 0; i < e.length; i++)
/*    */             e[i] = (float)Math.sin(i * Math.PI * 2.0D / 65536.0D); 
/*    */         });
/*    */   }
/*    */   
/*    */   private static final float[] SIN_TABLE;
/*    */   
/*    */   public float sin(float rad) {
/* 14 */     return SIN_TABLE[(int)(rad * 10430.378F) & 0xFFFF];
/*    */   }
/*    */   
/*    */   public float cos(float rad) {
/* 18 */     return SIN_TABLE[(int)(rad * 10430.378F + 16384.0F) & 0xFFFF];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\betterfps\NewMCMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */