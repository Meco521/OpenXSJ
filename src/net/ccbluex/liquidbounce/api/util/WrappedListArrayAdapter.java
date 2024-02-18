/*    */ package net.ccbluex.liquidbounce.api.util;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020!\n\000\n\002\030\002\n\002\b\t\n\002\020\b\n\002\b\002\n\002\020(\n\000\n\002\020\002\n\002\b\003\030\000*\004\b\000\020\001*\004\b\001\020\0022\b\022\004\022\002H\0020\003B;\022\f\020\004\032\b\022\004\022\0028\0000\005\022\022\020\006\032\016\022\004\022\0028\001\022\004\022\0028\0000\007\022\022\020\b\032\016\022\004\022\0028\000\022\004\022\0028\0010\007¢\006\002\020\tJ\026\020\017\032\0028\0012\006\020\020\032\0020\021H\002¢\006\002\020\022J\017\020\023\032\b\022\004\022\0028\0010\024H\002J\036\020\025\032\0020\0262\006\020\020\032\0020\0212\006\020\027\032\0028\001H\002¢\006\002\020\030R\035\020\006\032\016\022\004\022\0028\001\022\004\022\0028\0000\007¢\006\b\n\000\032\004\b\n\020\013R\027\020\004\032\b\022\004\022\0028\0000\005¢\006\b\n\000\032\004\b\f\020\rR\035\020\b\032\016\022\004\022\0028\000\022\004\022\0028\0010\007¢\006\b\n\000\032\004\b\016\020\013¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedListArrayAdapter;", "O", "T", "Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;", "wrapped", "", "unwrapper", "Lkotlin/Function1;", "wrapper", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getUnwrapper", "()Lkotlin/jvm/functions/Function1;", "getWrapped", "()Ljava/util/List;", "getWrapper", "get", "index", "", "(I)Ljava/lang/Object;", "iterator", "", "set", "", "value", "(ILjava/lang/Object;)V", "XSJClient"})
/*    */ public final class WrappedListArrayAdapter<O, T> implements IWrappedArray<T> { @NotNull
/*    */   private final List<O> wrapped; @NotNull
/*  4 */   public final List<O> getWrapped() { return this.wrapped; } @NotNull private final Function1<T, O> unwrapper; @NotNull private final Function1<O, T> wrapper; @NotNull public final Function1<T, O> getUnwrapper() { return this.unwrapper; } @NotNull public final Function1<O, T> getWrapper() { return this.wrapper; } public WrappedListArrayAdapter(@NotNull List<O> wrapped, @NotNull Function1<T, O> unwrapper, @NotNull Function1<O, T> wrapper) { this.wrapped = wrapped; this.unwrapper = unwrapper; this.wrapper = wrapper; } public T get(int index) {
/*  5 */     return (T)this.wrapper.invoke(this.wrapped.get(index));
/*    */   }
/*    */   public void set(int index, Object value) {
/*  8 */     this.wrapped.set(index, (O)this.unwrapper.invoke(value));
/*    */   } @NotNull
/*    */   public Iterator<T> iterator() {
/* 11 */     return new WrappedCollection.WrappedCollectionIterator<>(this.wrapped.iterator(), this.wrapper);
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedListArrayAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */