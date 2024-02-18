/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\006\n\002\020*\n\002\b\005\b\026\030\000*\004\b\000\020\001*\004\b\001\020\002*\016\b\002\020\003*\b\022\004\022\002H\0010\0042\024\022\004\022\002H\001\022\004\022\002H\002\022\004\022\002H\0030\0052\b\022\004\022\002H\0020\004:\001\030B5\022\006\020\006\032\0028\002\022\022\020\007\032\016\022\004\022\0028\001\022\004\022\0028\0000\b\022\022\020\t\032\016\022\004\022\0028\000\022\004\022\0028\0010\b¢\006\002\020\nJ\026\020\013\032\0028\0012\006\020\f\032\0020\rH\002¢\006\002\020\016J\025\020\017\032\0020\r2\006\020\020\032\0028\001H\026¢\006\002\020\021J\025\020\022\032\0020\r2\006\020\020\032\0028\001H\026¢\006\002\020\021J\016\020\023\032\b\022\004\022\0028\0010\024H\026J\026\020\023\032\b\022\004\022\0028\0010\0242\006\020\f\032\0020\rH\026J\036\020\025\032\b\022\004\022\0028\0010\0042\006\020\026\032\0020\r2\006\020\027\032\0020\rH\026¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedList;", "O", "T", "C", "", "Lnet/ccbluex/liquidbounce/api/util/WrappedCollection;", "wrapped", "unwrapper", "Lkotlin/Function1;", "wrapper", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "get", "index", "", "(I)Ljava/lang/Object;", "indexOf", "element", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "WrappedCollectionIterator", "XSJClient"})
/*    */ public class WrappedList<O, T, C extends List<? extends O>> extends WrappedCollection<O, T, C> implements List<T>, KMappedMarker {
/*  4 */   public WrappedList(@NotNull List wrapped, @NotNull Function1<? super T, ? extends O> unwrapper, @NotNull Function1<? super O, ? extends T> wrapper) { super((C)wrapped, unwrapper, wrapper); } public T get(int index) {
/*  5 */     return (T)getWrapper().invoke(((List)getWrapped()).get(index));
/*    */   } public int indexOf(Object element) {
/*  7 */     return ((List)getWrapped()).indexOf(getUnwrapper().invoke(element));
/*    */   }
/*  9 */   public int lastIndexOf(Object element) { return ((List)getWrapped()).indexOf(getUnwrapper().invoke(element)); }
/*    */   @NotNull
/* 11 */   public ListIterator<T> listIterator() { return new WrappedCollectionIterator<>(((List<? extends O>)getWrapped()).listIterator(), getWrapper()); }
/*    */   @NotNull
/* 13 */   public ListIterator<T> listIterator(int index) { return new WrappedCollectionIterator<>(((List<? extends O>)getWrapped()).listIterator(index), getWrapper()); }
/*    */   public void add(int paramInt, T paramT) { throw new UnsupportedOperationException("Operation is not supported for read-only collection"); }
/* 15 */   public boolean addAll(int paramInt, Collection<? extends T> paramCollection) { throw new UnsupportedOperationException("Operation is not supported for read-only collection"); } public T remove(int paramInt) { throw new UnsupportedOperationException("Operation is not supported for read-only collection"); } @NotNull public List<T> subList(int fromIndex, int toIndex) { return new WrappedList((C)((List)getWrapped()).subList(fromIndex, toIndex), getUnwrapper(), getWrapper()); } public void replaceAll(UnaryOperator<T> paramUnaryOperator) { throw new UnsupportedOperationException("Operation is not supported for read-only collection"); } public T set(int paramInt, T paramT) { throw new UnsupportedOperationException("Operation is not supported for read-only collection"); } public void sort(Comparator<? super T> paramComparator) { throw new UnsupportedOperationException("Operation is not supported for read-only collection"); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\b\002\n\002\020*\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\003\030\000*\004\b\003\020\001*\004\b\004\020\0022\b\022\004\022\002H\0020\003B'\022\f\020\004\032\b\022\004\022\0028\0030\003\022\022\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\002\020\007J\t\020\f\032\0020\rH\002J\b\020\016\032\0020\rH\026J\016\020\017\032\0028\004H\002¢\006\002\020\020J\b\020\021\032\0020\022H\026J\r\020\023\032\0028\004H\026¢\006\002\020\020J\b\020\024\032\0020\022H\026R\027\020\004\032\b\022\004\022\0028\0030\003¢\006\b\n\000\032\004\b\b\020\tR\035\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\b\n\000\032\004\b\n\020\013¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedList$WrappedCollectionIterator;", "O", "T", "", "wrapped", "wrapper", "Lkotlin/Function1;", "(Ljava/util/ListIterator;Lkotlin/jvm/functions/Function1;)V", "getWrapped", "()Ljava/util/ListIterator;", "getWrapper", "()Lkotlin/jvm/functions/Function1;", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "XSJClient"}) public static final class WrappedCollectionIterator<O, T> implements ListIterator<T>, KMappedMarker
/*    */   {
/* 17 */     @NotNull private final ListIterator<O> wrapped; @NotNull private final Function1<O, T> wrapper; @NotNull public final ListIterator<O> getWrapped() { return this.wrapped; } @NotNull public final Function1<O, T> getWrapper() { return this.wrapper; } public WrappedCollectionIterator(@NotNull ListIterator<O> wrapped, @NotNull Function1<O, T> wrapper) { this.wrapped = wrapped; this.wrapper = wrapper; } public boolean hasNext() {
/* 18 */       return this.wrapped.hasNext();
/*    */     } public boolean hasPrevious() {
/* 20 */       return this.wrapped.hasPrevious();
/*    */     } public T next() {
/* 22 */       return (T)this.wrapper.invoke(this.wrapped.next());
/*    */     } public int nextIndex() {
/* 24 */       return this.wrapped.nextIndex();
/*    */     } public T previous() {
/* 26 */       return (T)this.wrapper.invoke(this.wrapped.previous());
/*    */     } public int previousIndex() {
/* 28 */       return this.wrapped.previousIndex();
/*    */     }
/*    */     
/*    */     public void add(T param1T) {
/*    */       throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */     }
/*    */     
/*    */     public void remove() {
/*    */       throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */     }
/*    */     
/*    */     public void set(T param1T) {
/*    */       throw new UnsupportedOperationException("Operation is not supported for read-only collection");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */