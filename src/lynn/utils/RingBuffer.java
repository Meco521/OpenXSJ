/*    */ package lynn.utils;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.NoSuchElementException;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.markers.KMappedMarker;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\000\n\002\020\034\n\000\n\002\020\b\n\002\b\002\n\002\020\021\n\002\020\000\n\002\b\n\n\002\020\002\n\002\b\006\n\002\020(\n\000\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\023\020\022\032\0020\0232\006\020\024\032\0028\000¢\006\002\020\025J\030\020\026\032\004\030\0018\0002\006\020\027\032\0020\004H\002¢\006\002\020\030J\017\020\031\032\b\022\004\022\0028\0000\032H\002R\030\020\006\032\n\022\006\022\004\030\0010\b0\007X\004¢\006\004\n\002\020\tR\024\020\n\032\0020\0048BX\004¢\006\006\032\004\b\013\020\fR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\r\020\fR\036\020\017\032\0020\0042\006\020\016\032\0020\004@BX\016¢\006\b\n\000\032\004\b\020\020\fR\016\020\021\032\0020\004X\016¢\006\002\n\000¨\006\033"}, d2 = {"Llynn/utils/RingBuffer;", "T", "", "maxCapacity", "", "(I)V", "array", "", "", "[Ljava/lang/Object;", "head", "getHead", "()I", "getMaxCapacity", "<set-?>", "size", "getSize", "tail", "add", "", "element", "(Ljava/lang/Object;)V", "get", "index", "(I)Ljava/lang/Object;", "iterator", "", "XSJClient"})
/*    */ public final class RingBuffer<T> implements Iterable<T>, KMappedMarker {
/*    */   private final Object[] array;
/*    */   private int size;
/*    */   private int tail;
/*    */   private final int maxCapacity;
/*    */   
/* 17 */   public final int getMaxCapacity() { return this.maxCapacity; } public RingBuffer(int maxCapacity) { this.maxCapacity = maxCapacity; int i; Object[] arrayOfObject1; byte b; RingBuffer ringBuffer;
/* 18 */     for (i = this.maxCapacity, ringBuffer = this, arrayOfObject1 = new Object[i], b = 0; b < i; ) { byte b1 = b, b2 = b; Object[] arrayOfObject = arrayOfObject1; int $i$a$-<init>-RingBuffer$array$1 = 0; Object object = null; arrayOfObject[b2] = object; b++; }  Object[] arrayOfObject2 = arrayOfObject1; }
/*    */    public final int getSize() {
/* 20 */     return this.size;
/*    */   }
/*    */   
/*    */   private final int getHead() {
/* 24 */     return (this.size == this.maxCapacity) ? ((this.tail + 1) % this.size) : 0;
/*    */   }
/*    */   
/*    */   public final void add(Object element) {
/* 28 */     this.tail = (this.tail + 1) % this.maxCapacity;
/* 29 */     this.array[this.tail] = element;
/* 30 */     if (this.size < this.maxCapacity) { int i; this.size = (i = this.size) + 1; }
/*    */   
/*    */   } @Nullable
/*    */   public final T get(int index) {
/* 34 */     if (!((
/* 35 */       this.size == 0 || index >= this.size || index < 0) ? null : (
/* 36 */       (this.size == this.maxCapacity) ? this.array[(getHead() + index) % this.maxCapacity] : 
/* 37 */       this.array[index]) instanceof Object)) (this.size == 0 || index >= this.size || index < 0) ? null : ((this.size == this.maxCapacity) ? this.array[(getHead() + index) % this.maxCapacity] : this.array[index]); 
/*    */     return null;
/*    */   }
/*    */   @NotNull
/* 41 */   public Iterator<T> iterator() { return new RingBuffer$iterator$1(); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\020(\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\003*\001\000\b\n\030\0002\b\022\004\022\0028\0000\001J\t\020\004\032\0020\005H\002J\016\020\006\032\0028\000H\002¢\006\002\020\007R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\b"}, d2 = {"lynn/utils/RingBuffer$iterator$1", "", "index", "Ljava/util/concurrent/atomic/AtomicInteger;", "hasNext", "", "next", "()Ljava/lang/Object;", "XSJClient"})
/* 42 */   public static final class RingBuffer$iterator$1 implements Iterator<T>, KMappedMarker { private final AtomicInteger index = new AtomicInteger(0);
/*    */     public boolean hasNext() {
/* 44 */       return (this.index.get() < RingBuffer.this.getSize());
/*    */     } public T next() {
/* 46 */       if (RingBuffer.this.get(this.index.getAndIncrement()) != null) return (T)RingBuffer.this.get(this.index.getAndIncrement());  RingBuffer.this.get(this.index.getAndIncrement()); throw (Throwable)new NoSuchElementException();
/*    */     }
/*    */     
/*    */     public void remove() {
/*    */       throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\RingBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */