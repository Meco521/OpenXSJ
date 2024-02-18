/*    */ package net.ccbluex.liquidbounce.utils.particles;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class EvictingList<T>
/*    */   extends LinkedList<T>
/*    */ {
/*    */   private final int maxSize;
/*    */   
/*    */   public EvictingList(int maxSize) {
/* 16 */     this.maxSize = maxSize;
/*    */   }
/*    */   
/*    */   public EvictingList(Collection<? extends T> c, int maxSize) {
/* 20 */     super(c);
/* 21 */     this.maxSize = maxSize;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean add(T t) {
/* 26 */     if (size() >= this.maxSize) removeFirst(); 
/* 27 */     return super.add(t);
/*    */   }
/*    */   
/*    */   public boolean isFull() {
/* 31 */     return (size() >= this.maxSize);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\particles\EvictingList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */