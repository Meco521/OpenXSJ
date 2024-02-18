/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\b\003\n\002\020!\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\000\n\002\020\036\n\002\b\006\n\002\020+\n\002\b\b\030\000*\004\b\000\020\001*\004\b\001\020\002*\016\b\002\020\003*\b\022\004\022\002H\0010\0042\024\022\004\022\002H\001\022\004\022\002H\002\022\004\022\002H\0030\0052\b\022\004\022\002H\0020\004:\001\"B5\022\006\020\006\032\0028\002\022\022\020\007\032\016\022\004\022\0028\001\022\004\022\0028\0000\b\022\022\020\t\032\016\022\004\022\0028\000\022\004\022\0028\0010\b¢\006\002\020\nJ\035\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0028\001H\026¢\006\002\020\020J\036\020\021\032\0020\0222\006\020\r\032\0020\0162\f\020\023\032\b\022\004\022\0028\0010\024H\026J\026\020\025\032\0028\0012\006\020\r\032\0020\016H\002¢\006\002\020\026J\025\020\027\032\0020\0162\006\020\017\032\0028\001H\026¢\006\002\020\030J\025\020\031\032\0020\0162\006\020\017\032\0028\001H\026¢\006\002\020\030J\016\020\032\032\b\022\004\022\0028\0010\033H\026J\026\020\032\032\b\022\004\022\0028\0010\0332\006\020\r\032\0020\016H\026J\025\020\034\032\0028\0012\006\020\r\032\0020\016H\026¢\006\002\020\026J\036\020\035\032\0028\0012\006\020\r\032\0020\0162\006\020\017\032\0028\001H\002¢\006\002\020\036J\036\020\037\032\b\022\004\022\0028\0010\0042\006\020 \032\0020\0162\006\020!\032\0020\016H\026¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedMutableList;", "O", "T", "C", "", "Lnet/ccbluex/liquidbounce/api/util/WrappedMutableCollection;", "wrapped", "unwrapper", "Lkotlin/Function1;", "wrapper", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "addAll", "", "elements", "", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "WrappedMutableCollectionIterator", "XSJClient"})
/*    */ public final class WrappedMutableList<O, T, C extends List<O>> extends WrappedMutableCollection<O, T, C> implements List<T>, KMutableList {
/*  4 */   public WrappedMutableList(@NotNull List wrapped, @NotNull Function1<? super T, ? extends O> unwrapper, @NotNull Function1<? super O, ? extends T> wrapper) { super((C)wrapped, unwrapper, wrapper); } public T get(int index) {
/*  5 */     return (T)getWrapper().invoke(((List)getWrapped()).get(index));
/*    */   } public int indexOf(Object element) {
/*  7 */     return ((List)getWrapped()).indexOf(getUnwrapper().invoke(element));
/*    */   } public int lastIndexOf(Object element) {
/*  9 */     return ((List)getWrapped()).lastIndexOf(getUnwrapper().invoke(element));
/*    */   } public void add(int index, Object element) {
/* 11 */     ((List<Object>)getWrapped()).add(index, getUnwrapper().invoke(element));
/*    */   } public boolean addAll(int index, @NotNull Collection elements) {
/* 13 */     Intrinsics.checkParameterIsNotNull(elements, "elements"); Collection collection1 = elements; Function1<T, O> function1 = getUnwrapper(); int i = index; List list1 = (List)getWrapped(); int $i$f$map = 0;
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
/* 44 */     Collection collection2 = collection1; Collection<Object> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection1, 10)); int $i$f$mapTo = 0;
/* 45 */     for (Object item$iv$iv : collection2)
/* 46 */       destination$iv$iv.add(function1.invoke(item$iv$iv)); 
/* 47 */     List list2 = (List)destination$iv$iv; return list1.addAll(i, list2);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ListIterator<T> listIterator() {
/*    */     return new WrappedMutableCollectionIterator<>(((List<O>)getWrapped()).listIterator(), getWrapper(), getUnwrapper());
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ListIterator<T> listIterator(int index) {
/*    */     return new WrappedMutableCollectionIterator<>(((List<O>)getWrapped()).listIterator(index), getWrapper(), getUnwrapper());
/*    */   }
/*    */   
/*    */   public T removeAt(int index) {
/*    */     return (T)getWrapper().invoke(((List)getWrapped()).remove(index));
/*    */   }
/*    */   
/*    */   public T set(int index, Object element) {
/*    */     return (T)getWrapper().invoke(((List<Object>)getWrapped()).set(index, getUnwrapper().invoke(element)));
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<T> subList(int fromIndex, int toIndex) {
/*    */     return new WrappedMutableList((C)((List)getWrapped()).subList(fromIndex, toIndex), getUnwrapper(), getWrapper());
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\b\002\n\002\020+\n\002\b\002\n\002\030\002\n\002\b\b\n\002\020\002\n\002\b\003\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\005\030\000*\004\b\003\020\001*\004\b\004\020\0022\b\022\004\022\002H\0020\003B;\022\f\020\004\032\b\022\004\022\0028\0030\003\022\022\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006\022\022\020\007\032\016\022\004\022\0028\004\022\004\022\0028\0030\006¢\006\002\020\bJ\025\020\016\032\0020\0172\006\020\020\032\0028\004H\026¢\006\002\020\021J\t\020\022\032\0020\023H\002J\b\020\024\032\0020\023H\026J\016\020\025\032\0028\004H\002¢\006\002\020\026J\b\020\027\032\0020\030H\026J\r\020\031\032\0028\004H\026¢\006\002\020\026J\b\020\032\032\0020\030H\026J\b\020\033\032\0020\017H\026J\025\020\034\032\0020\0172\006\020\020\032\0028\004H\026¢\006\002\020\021R\035\020\007\032\016\022\004\022\0028\004\022\004\022\0028\0030\006¢\006\b\n\000\032\004\b\t\020\nR\027\020\004\032\b\022\004\022\0028\0030\003¢\006\b\n\000\032\004\b\013\020\fR\035\020\005\032\016\022\004\022\0028\003\022\004\022\0028\0040\006¢\006\b\n\000\032\004\b\r\020\n¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedMutableList$WrappedMutableCollectionIterator;", "O", "T", "", "wrapped", "wrapper", "Lkotlin/Function1;", "unwrapper", "(Ljava/util/ListIterator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getUnwrapper", "()Lkotlin/jvm/functions/Function1;", "getWrapped", "()Ljava/util/ListIterator;", "getWrapper", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "remove", "set", "XSJClient"})
/*    */   public static final class WrappedMutableCollectionIterator<O, T> implements ListIterator<T>, KMutableListIterator {
/*    */     @NotNull
/*    */     private final ListIterator<O> wrapped;
/*    */     @NotNull
/*    */     private final Function1<O, T> wrapper;
/*    */     @NotNull
/*    */     private final Function1<T, O> unwrapper;
/*    */     
/*    */     @NotNull
/*    */     public final ListIterator<O> getWrapped() {
/*    */       return this.wrapped;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final Function1<O, T> getWrapper() {
/*    */       return this.wrapper;
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final Function1<T, O> getUnwrapper() {
/*    */       return this.unwrapper;
/*    */     }
/*    */     
/*    */     public WrappedMutableCollectionIterator(@NotNull ListIterator<O> wrapped, @NotNull Function1<O, T> wrapper, @NotNull Function1<T, O> unwrapper) {
/*    */       this.wrapped = wrapped;
/*    */       this.wrapper = wrapper;
/*    */       this.unwrapper = unwrapper;
/*    */     }
/*    */     
/*    */     public boolean hasNext() {
/*    */       return this.wrapped.hasNext();
/*    */     }
/*    */     
/*    */     public boolean hasPrevious() {
/*    */       return this.wrapped.hasPrevious();
/*    */     }
/*    */     
/*    */     public T next() {
/*    */       return (T)this.wrapper.invoke(this.wrapped.next());
/*    */     }
/*    */     
/*    */     public int nextIndex() {
/*    */       return this.wrapped.nextIndex();
/*    */     }
/*    */     
/*    */     public T previous() {
/*    */       return (T)this.wrapper.invoke(this.wrapped.previous());
/*    */     }
/*    */     
/*    */     public int previousIndex() {
/*    */       return this.wrapped.previousIndex();
/*    */     }
/*    */     
/*    */     public void add(Object element) {
/*    */       this.wrapped.add((O)this.unwrapper.invoke(element));
/*    */     }
/*    */     
/*    */     public void remove() {
/*    */       this.wrapped.remove();
/*    */     }
/*    */     
/*    */     public void set(Object element) {
/*    */       this.wrapped.set((O)this.unwrapper.invoke(element));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedMutableList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */