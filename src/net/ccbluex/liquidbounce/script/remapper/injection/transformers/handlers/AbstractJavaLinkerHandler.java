/*     */ package net.ccbluex.liquidbounce.script.remapper.injection.transformers.handlers;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Method;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.script.remapper.Remapper;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\034\020\003\032\0020\0042\n\020\005\032\006\022\002\b\0030\0062\006\020\007\032\0020\004H\007J$\020\003\032\0020\0042\n\020\005\032\006\022\002\b\0030\0062\006\020\007\032\0020\0042\006\020\b\032\0020\tH\007J\034\020\n\032\0020\0042\n\020\005\032\006\022\002\b\0030\0062\006\020\007\032\0020\004H\007¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/script/remapper/injection/transformers/handlers/AbstractJavaLinkerHandler;", "", "()V", "addMember", "", "clazz", "Ljava/lang/Class;", "name", "accessibleObject", "Ljava/lang/reflect/AccessibleObject;", "setPropertyGetter", "XSJClient"})
/*     */ public final class AbstractJavaLinkerHandler {
/*     */   static {
/*  13 */     AbstractJavaLinkerHandler abstractJavaLinkerHandler = new AbstractJavaLinkerHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final AbstractJavaLinkerHandler INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String addMember(@NotNull Class clazz, @NotNull String name, @NotNull AccessibleObject accessibleObject) {
/*  28 */     Intrinsics.checkParameterIsNotNull(clazz, "clazz"); Intrinsics.checkParameterIsNotNull(name, "name"); Intrinsics.checkParameterIsNotNull(accessibleObject, "accessibleObject"); if (!(accessibleObject instanceof Method)) {
/*  29 */       return name;
/*     */     }
/*  31 */     Class currentClass = clazz;
/*  32 */     while ((Intrinsics.areEqual(currentClass.getName(), "java.lang.Object") ^ true) != 0) {
/*  33 */       Intrinsics.checkExpressionValueIsNotNull(Type.getMethodDescriptor((Method)accessibleObject), "Type.getMethodDescriptor(accessibleObject)"); String remapped = Remapper.INSTANCE.remapMethod(currentClass, name, Type.getMethodDescriptor((Method)accessibleObject));
/*     */       
/*  35 */       if ((Intrinsics.areEqual(remapped, name) ^ true) != 0) {
/*  36 */         return remapped;
/*     */       }
/*  38 */       if (currentClass.getSuperclass() == null) {
/*     */         break;
/*     */       }
/*  41 */       Intrinsics.checkExpressionValueIsNotNull(currentClass.getSuperclass(), "currentClass.superclass"); currentClass = currentClass.getSuperclass();
/*     */     } 
/*     */     
/*  44 */     return name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String addMember(@NotNull Class clazz, @NotNull String name) {
/*  59 */     Intrinsics.checkParameterIsNotNull(clazz, "clazz"); Intrinsics.checkParameterIsNotNull(name, "name"); Class currentClass = clazz;
/*  60 */     while ((Intrinsics.areEqual(currentClass.getName(), "java.lang.Object") ^ true) != 0) {
/*  61 */       String remapped = Remapper.INSTANCE.remapField(currentClass, name);
/*     */       
/*  63 */       if ((Intrinsics.areEqual(remapped, name) ^ true) != 0) {
/*  64 */         return remapped;
/*     */       }
/*  66 */       if (currentClass.getSuperclass() == null) {
/*     */         break;
/*     */       }
/*  69 */       Intrinsics.checkExpressionValueIsNotNull(currentClass.getSuperclass(), "currentClass.superclass"); currentClass = currentClass.getSuperclass();
/*     */     } 
/*     */     
/*  72 */     return name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String setPropertyGetter(@NotNull Class clazz, @NotNull String name) {
/*  87 */     Intrinsics.checkParameterIsNotNull(clazz, "clazz"); Intrinsics.checkParameterIsNotNull(name, "name"); Class currentClass = clazz;
/*  88 */     while ((Intrinsics.areEqual(currentClass.getName(), "java.lang.Object") ^ true) != 0) {
/*  89 */       String remapped = Remapper.INSTANCE.remapField(currentClass, name);
/*     */       
/*  91 */       if ((Intrinsics.areEqual(remapped, name) ^ true) != 0) {
/*  92 */         return remapped;
/*     */       }
/*  94 */       if (currentClass.getSuperclass() == null) {
/*     */         break;
/*     */       }
/*  97 */       Intrinsics.checkExpressionValueIsNotNull(currentClass.getSuperclass(), "currentClass.superclass"); currentClass = currentClass.getSuperclass();
/*     */     } 
/*     */     
/* 100 */     return name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\remapper\injection\transformers\handlers\AbstractJavaLinkerHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */