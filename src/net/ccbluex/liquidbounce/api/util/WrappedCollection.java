/*    */ package net.ccbluex.liquidbounce.api.util;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\b\003\n\002\020\036\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\t\n\002\020\013\n\002\b\006\n\002\020(\n\002\b\002\b\026\030\000*\004\b\000\020\001*\004\b\001\020\002*\016\b\002\020\003*\b\022\004\022\002H\0010\0042\b\022\004\022\002H\0020\004:\001\035B5\022\006\020\005\032\0028\002\022\022\020\006\032\016\022\004\022\0028\001\022\004\022\0028\0000\007\022\022\020\b\032\016\022\004\022\0028\000\022\004\022\0028\0010\007¢\006\002\020\tJ\026\020\024\032\0020\0252\006\020\026\032\0028\001H\002¢\006\002\020\027J\026\020\030\032\0020\0252\f\020\031\032\b\022\004\022\0028\0010\004H\026J\b\020\032\032\0020\025H\026J\017\020\033\032\b\022\004\022\0028\0010\034H\002R\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\035\020\006\032\016\022\004\022\0028\001\022\004\022\0028\0000\007¢\006\b\n\000\032\004\b\016\020\017R\023\020\005\032\0028\002¢\006\n\n\002\020\022\032\004\b\020\020\021R\035\020\b\032\016\022\004\022\0028\000\022\004\022\0028\0010\007¢\006\b\n\000\032\004\b\023\020\017¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedCollection;", "O", "T", "C", "", "wrapped", "unwrapper", "Lkotlin/Function1;", "wrapper", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "size", "", "getSize", "()I", "getUnwrapper", "()Lkotlin/jvm/functions/Function1;", "getWrapped", "()Ljava/util/Collection;", "Ljava/util/Collection;", "getWrapper", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "WrappedCollectionIterator", "XSJClient"})
/*    */ public class WrappedCollection<O, T, C extends Collection<? extends O>> implements Collection<T>, KMappedMarker { @NotNull
/*    */   private final C wrapped; @NotNull
/*  4 */   public final C getWrapped() { return this.wrapped; } @NotNull private final Function1<T, O> unwrapper; @NotNull private final Function1<O, T> wrapper; @NotNull public final Function1<T, O> getUnwrapper() { return this.unwrapper; } @NotNull public final Function1<O, T> getWrapper() { return this.wrapper; } public WrappedCollection(@NotNull Collection wrapped, @NotNull Function1<T, O> unwrapper, @NotNull Function1<O, T> wrapper) { this.wrapped = (C)wrapped; this.unwrapper = unwrapper; this.wrapper = wrapper; }
/*    */    public int getSize() {
/*  6 */     return this.wrapped.size();
/*    */   } public boolean contains(Object element) {
/*  8 */     return this.wrapped.contains(this.unwrapper.invoke(element));
/*    */   }
/*    */   public boolean containsAll(@NotNull Collection elements) {
/* 11 */     Intrinsics.checkParameterIsNotNull(elements, "elements"); Iterable $this$forEach$iv = elements; int $i$f$forEach = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(), it = element$iv; int $i$a$-forEach-WrappedCollection$containsAll$1 = 0;
/*    */       if (this.wrapped.contains(this.unwrapper.invoke(it)))
/*    */         return true;  }
/*    */     
/*    */     return false;
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/*    */     return this.wrapped.isEmpty();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Iterator<T> iterator() {
/*    */     return new WrappedCollectionIterator<>(this.wrapped.iterator(), this.wrapper);
/*    */   }
/*    */   
/*    */   public boolean add(T paramT) {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public boolean addAll(Collection<? extends T> paramCollection) {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public void clear() {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public boolean remove(Object paramObject) {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public boolean removeAll(Collection<? extends Object> paramCollection) {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public boolean removeIf(Predicate<? super T> paramPredicate) {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public boolean retainAll(Collection<? extends Object> paramCollection) {
/*    */     throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */   }
/*    */   
/*    */   public Object[] toArray() {
/*    */     return CollectionToArray.toArray(this);
/*    */   }
/*    */   
/*    */   public <T> T[] toArray(T[] paramArrayOfT) {
/*    */     return (T[])CollectionToArray.toArray(this, (Object[])paramArrayOfT);
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\b\002\n\002\020(\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\003\030\000*\004\b\003\020\001*\004\b\004\020\0022\b\022\004\022\002H\0020\003B'\022\f\020\004\032\b\022\004\022\0028\0030\003\022\022\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\002\020\007J\t\020\f\032\0020\rH\002J\016\020\016\032\0028\004H\002¢\006\002\020\017R\035\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\b\n\000\032\004\b\b\020\tR\027\020\004\032\b\022\004\022\0028\0030\003¢\006\b\n\000\032\004\b\n\020\013¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedCollection$WrappedCollectionIterator;", "O", "T", "", "wrapped", "unwrapper", "Lkotlin/Function1;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "getUnwrapper", "()Lkotlin/jvm/functions/Function1;", "getWrapped", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "XSJClient"})
/*    */   public static final class WrappedCollectionIterator<O, T> implements Iterator<T>, KMappedMarker {
/*    */     @NotNull
/*    */     private final Iterator<O> wrapped;
/*    */     @NotNull
/*    */     private final Function1<O, T> unwrapper;
/*    */     
/*    */     @NotNull
/*    */     public final Iterator<O> getWrapped() {
/*    */       return this.wrapped;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final Function1<O, T> getUnwrapper() {
/*    */       return this.unwrapper;
/*    */     }
/*    */     
/*    */     public WrappedCollectionIterator(@NotNull Iterator<O> wrapped, @NotNull Function1<O, T> unwrapper) {
/*    */       this.wrapped = wrapped;
/*    */       this.unwrapper = unwrapper;
/*    */     }
/*    */     
/*    */     public boolean hasNext() {
/*    */       return this.wrapped.hasNext();
/*    */     }
/*    */     
/*    */     public T next() {
/*    */       return (T)this.unwrapper.invoke(this.wrapped.next());
/*    */     }
/*    */     
/*    */     public void remove() {
/*    */       throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */     }
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedCollection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */