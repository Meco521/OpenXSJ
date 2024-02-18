/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RollingArrayLongBuffer
/*    */ {
/*    */   private final long[] contents;
/* 12 */   private int currentIndex = 0;
/*    */   
/*    */   public RollingArrayLongBuffer(int length) {
/* 15 */     this.contents = new long[length];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long[] getContents() {
/* 22 */     return this.contents;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(long l) {
/* 31 */     this.currentIndex = (this.currentIndex + 1) % this.contents.length;
/* 32 */     this.contents[this.currentIndex] = l;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTimestampsSince(long l) {
/* 43 */     for (int i = 0; i < this.contents.length; i++) {
/* 44 */       if (this.contents[(this.currentIndex < i) ? (this.contents.length - i + this.currentIndex) : (this.currentIndex - i)] < l) {
/* 45 */         return i;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 50 */     return this.contents.length;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\RollingArrayLongBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */