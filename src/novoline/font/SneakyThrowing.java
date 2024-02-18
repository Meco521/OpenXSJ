/*    */ package novoline.font;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SneakyThrowing
/*    */ {
/*    */   public static RuntimeException sneakyThrow(Throwable throwable) {
/* 11 */     return sneakyThrow0(throwable);
/*    */   }
/*    */ 
/*    */   
/*    */   private static <T extends Throwable> T sneakyThrow0(Throwable throwable) throws T {
/* 16 */     throw (T)throwable;
/*    */   }
/*    */   
/*    */   private SneakyThrowing() {
/* 20 */     throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\font\SneakyThrowing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */