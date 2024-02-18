/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\020\016\n\002\020\013\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\007\032\0020\0062\006\020\b\032\0020\005H\007J\006\020\t\032\0020\006R\032\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\002\n\000¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/ClassUtils;", "", "()V", "cachedClasses", "", "", "", "hasClass", "className", "hasForge", "XSJClient"})
/*  3 */ public final class ClassUtils { static { ClassUtils classUtils = new ClassUtils();
/*    */     
/*  5 */     boolean bool = false; } private static final Map<String, Boolean> cachedClasses = new LinkedHashMap<>();
/*    */   
/*    */   public static final ClassUtils INSTANCE;
/*    */   
/*    */   @JvmStatic
/*    */   public static final boolean hasClass(@NotNull String className) {
/*    */     boolean bool;
/* 12 */     Intrinsics.checkParameterIsNotNull(className, "className");
/* 13 */     if (cachedClasses.get(className) == null) Intrinsics.throwNpe(); 
/*    */     try {
/* 15 */       Class.forName(className);
/* 16 */       cachedClasses.put(className, Boolean.valueOf(true));
/*    */       
/* 18 */       bool = true;
/* 19 */     } catch (ClassNotFoundException e) {
/* 20 */       cachedClasses.put(className, Boolean.valueOf(false));
/*    */       
/* 22 */       bool = false;
/*    */     } 
/*    */     return cachedClasses.containsKey(className) ? cachedClasses.get(className).booleanValue() : bool;
/*    */   } public final boolean hasForge() {
/* 26 */     return hasClass("net.minecraftforge.common.MinecraftForge");
/*    */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\ClassUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */