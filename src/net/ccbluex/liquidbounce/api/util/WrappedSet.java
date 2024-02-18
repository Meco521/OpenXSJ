/*   */ package net.ccbluex.liquidbounce.api.util;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\036\n\002\020\"\n\002\b\002\n\002\030\002\n\002\b\003\030\000*\004\b\000\020\001*\004\b\001\020\0022\032\022\004\022\002H\001\022\004\022\002H\002\022\n\022\b\022\004\022\002H\0010\0040\0032\b\022\004\022\002H\0020\005B;\022\f\020\006\032\b\022\004\022\0028\0000\005\022\022\020\007\032\016\022\004\022\0028\001\022\004\022\0028\0000\b\022\022\020\t\032\016\022\004\022\0028\000\022\004\022\0028\0010\b¢\006\002\020\n¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedSet;", "O", "T", "Lnet/ccbluex/liquidbounce/api/util/WrappedCollection;", "", "", "wrapped", "unwrapper", "Lkotlin/Function1;", "wrapper", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "XSJClient"})
/*   */ public final class WrappedSet<O, T> extends WrappedCollection<O, T, Collection<? extends O>> implements Set<T>, KMappedMarker {
/*   */   public WrappedSet(@NotNull Set<? extends O> wrapped, @NotNull Function1<? super T, ? extends O> unwrapper, @NotNull Function1<? super O, ? extends T> wrapper) {
/* 4 */     super(wrapped, unwrapper, wrapper);
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */