/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\b\003\n\002\020\037\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\004\n\002\020\036\n\000\n\002\020\002\n\000\n\002\020)\n\002\b\005\b\026\030\000*\004\b\000\020\001*\004\b\001\020\002*\016\b\002\020\003*\b\022\004\022\002H\0010\0042\024\022\004\022\002H\001\022\004\022\002H\002\022\004\022\002H\0030\0052\b\022\004\022\002H\0020\004:\001\031B5\022\006\020\006\032\0028\002\022\022\020\007\032\016\022\004\022\0028\001\022\004\022\0028\0000\b\022\022\020\t\032\016\022\004\022\0028\000\022\004\022\0028\0010\b¢\006\002\020\nJ\025\020\013\032\0020\f2\006\020\r\032\0028\001H\026¢\006\002\020\016J\026\020\017\032\0020\f2\f\020\020\032\b\022\004\022\0028\0010\021H\026J\b\020\022\032\0020\023H\026J\017\020\024\032\b\022\004\022\0028\0010\025H\002J\025\020\026\032\0020\f2\006\020\r\032\0028\001H\026¢\006\002\020\016J\026\020\027\032\0020\f2\f\020\020\032\b\022\004\022\0028\0010\021H\026J\026\020\030\032\0020\f2\f\020\020\032\b\022\004\022\0028\0010\021H\026¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedMutableCollection;", "O", "T", "C", "", "Lnet/ccbluex/liquidbounce/api/util/WrappedCollection;", "wrapped", "unwrapper", "Lkotlin/Function1;", "wrapper", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "iterator", "", "remove", "removeAll", "retainAll", "WrappedCollectionIterator", "XSJClient"})
/*    */ public class WrappedMutableCollection<O, T, C extends Collection<O>> extends WrappedCollection<O, T, C> implements Collection<T>, KMutableCollection {
/*  4 */   public WrappedMutableCollection(@NotNull Collection wrapped, @NotNull Function1<? super T, ? extends O> unwrapper, @NotNull Function1<? super O, ? extends T> wrapper) { super((C)wrapped, unwrapper, wrapper); }
/*  5 */   public boolean add(Object element) { return getWrapped().add(getUnwrapper().invoke(element)); }
/*    */   public void clear() { getWrapped().clear(); }
/*  7 */   @NotNull public Iterator<T> iterator() { return new WrappedCollectionIterator<>(getWrapped().iterator(), getWrapper()); } public boolean addAll(@NotNull Collection elements) { Intrinsics.checkParameterIsNotNull(elements, "elements"); Collection collection1 = elements; Function1<T, O> function1 = getUnwrapper(); C c = getWrapped(); int $i$f$map = 0;
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
/* 25 */     Collection collection2 = collection1; Collection<Object> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection1, 10)); int $i$f$mapTo = 0;
/* 26 */     for (Object item$iv$iv : collection2)
/* 27 */       destination$iv$iv.add(function1.invoke(item$iv$iv)); 
/* 28 */     List list = (List)destination$iv$iv; return c.addAll(list); }
/* 29 */   public boolean remove(Object element) { return getWrapped().remove(getUnwrapper().invoke(element)); } public boolean removeAll(@NotNull Collection elements) { Intrinsics.checkParameterIsNotNull(elements, "elements"); Collection collection1 = elements; Function1<T, O> function1 = getUnwrapper(); C c = getWrapped(); int $i$f$map = 0; Collection collection2 = collection1; Collection<Object> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection1, 10)); int $i$f$mapTo = 0;
/* 30 */     for (Object item$iv$iv : collection2)
/* 31 */       destination$iv$iv.add(function1.invoke(item$iv$iv)); 
/* 32 */     List list = (List)destination$iv$iv; return c.addAll(list); } public boolean retainAll(@NotNull Collection elements) { Intrinsics.checkParameterIsNotNull(elements, "elements"); Collection collection1 = elements; Function1<T, O> function1 = getUnwrapper(); C c = getWrapped(); int $i$f$map = 0;
/* 33 */     Collection collection2 = collection1; Collection<Object> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection1, 10)); int $i$f$mapTo = 0;
/* 34 */     for (Object item$iv$iv : collection2)
/* 35 */       destination$iv$iv.add(function1.invoke(item$iv$iv)); 
/* 36 */     List list = (List)destination$iv$iv; return c.addAll(list); }
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\b\002\n\002\020)\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\003\n\002\020\002\n\000\030\000*\004\b\003\020\001*\004\b\004\020\0022\b\022\004\022\002H\0020\003B'\022\f\020\004\032\b\022\004\022\0028\0030\003\022\022\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\002\020\007J\t\020\f\032\0020\rH\002J\016\020\016\032\0028\004H\002¢\006\002\020\017J\b\020\020\032\0020\021H\026R\035\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\b\n\000\032\004\b\b\020\tR\027\020\004\032\b\022\004\022\0028\0030\003¢\006\b\n\000\032\004\b\n\020\013¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedMutableCollection$WrappedCollectionIterator;", "O", "T", "", "wrapped", "unwrapper", "Lkotlin/Function1;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "getUnwrapper", "()Lkotlin/jvm/functions/Function1;", "getWrapped", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "XSJClient"})
/*    */   public static final class WrappedCollectionIterator<O, T> implements Iterator<T>, KMutableIterator {
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
/*    */       this.wrapped.remove();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedMutableCollection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */