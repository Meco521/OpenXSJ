/*    */ package net.ccbluex.liquidbounce.api.util;@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\000\n\002\020\034\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\002\n\002\b\004\bf\030\000 \013*\004\b\000\020\0012\b\022\004\022\002H\0010\002:\001\013J\026\020\003\032\0028\0002\006\020\004\032\0020\005H¦\002¢\006\002\020\006J\036\020\007\032\0020\b2\006\020\004\032\0020\0052\006\020\t\032\0028\000H¦\002¢\006\002\020\n¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;", "T", "", "get", "index", "", "(I)Ljava/lang/Object;", "set", "", "value", "(ILjava/lang/Object;)V", "Companion", "XSJClient"})
/*    */ public interface IWrappedArray<T> extends Iterable<T>, KMappedMarker { public static final Companion Companion = Companion.$$INSTANCE;
/*    */   T get(int paramInt);
/*    */   void set(int paramInt, T paramT);
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\b\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002JD\020\003\032\0020\004\"\004\b\001\020\005*\n\022\006\b\001\022\002H\0050\0062'\020\007\032#\022\023\022\0210\t¢\006\f\b\n\022\b\b\013\022\004\b\b(\f\022\004\022\002H\005\022\004\022\0020\0040\bH\b¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/IWrappedArray$Companion;", "", "()V", "forEachIndexed", "", "T", "Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;", "action", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "XSJClient"})
/*    */   public static final class Companion { static {
/*  8 */       Companion companion = new Companion();
/*    */     } public final <T> void forEachIndexed(@NotNull IWrappedArray $this$forEachIndexed, @NotNull Function2 action) {
/* 10 */       int $i$f$forEachIndexed = 0; Intrinsics.checkParameterIsNotNull($this$forEachIndexed, "$this$forEachIndexed"); Intrinsics.checkParameterIsNotNull(action, "action"); int index = 0;
/* 11 */       for (Object item : $this$forEachIndexed) { index++; action.invoke(Integer.valueOf(index), item); }
/*    */     
/*    */     } }
/*    */    }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\IWrappedArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */