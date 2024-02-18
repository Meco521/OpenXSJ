/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPSCounter
/*    */ {
/*    */   private static final int MAX_CPS = 50;
/*  8 */   private static final RollingArrayLongBuffer[] TIMESTAMP_BUFFERS = new RollingArrayLongBuffer[(MouseButton.values()).length];
/*    */   
/*    */   static {
/* 11 */     for (int i = 0; i < TIMESTAMP_BUFFERS.length; i++) {
/* 12 */       TIMESTAMP_BUFFERS[i] = new RollingArrayLongBuffer(50);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void registerClick(MouseButton button) {
/* 22 */     TIMESTAMP_BUFFERS[button.getIndex()].add(System.currentTimeMillis());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getCPS(MouseButton button) {
/* 32 */     return TIMESTAMP_BUFFERS[button.getIndex()].getTimestampsSince(System.currentTimeMillis() - 1000L);
/*    */   }
/*    */   
/*    */   public enum MouseButton {
/* 36 */     LEFT(0), MIDDLE(1), RIGHT(2);
/*    */     
/*    */     private int index;
/*    */     
/*    */     MouseButton(int index) {
/* 41 */       this.index = index;
/*    */     }
/*    */     
/*    */     private int getIndex() {
/* 45 */       return this.index;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\CPSCounter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */