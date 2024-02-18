/*    */ package net.ccbluex.liquidbounce.script.remapper.injection.utils;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.objectweb.asm.ClassReader;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.ClassWriter;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\022\n\000\n\002\030\002\n\002\b\003\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006J\016\020\007\032\0020\0062\006\020\b\032\0020\004¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/script/remapper/injection/utils/ClassUtils;", "", "()V", "toBytes", "", "classNode", "Lorg/objectweb/asm/tree/ClassNode;", "toClassNode", "bytes", "XSJClient"})
/*    */ public final class ClassUtils {
/*    */   static {
/* 12 */     ClassUtils classUtils = new ClassUtils();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final ClassUtils INSTANCE;
/*    */   
/*    */   @NotNull
/*    */   public final ClassNode toClassNode(@NotNull byte[] bytes) {
/* 20 */     Intrinsics.checkParameterIsNotNull(bytes, "bytes"); ClassReader classReader = new ClassReader(bytes);
/* 21 */     ClassNode classNode = new ClassNode();
/* 22 */     classReader.accept((ClassVisitor)classNode, 0);
/*    */     
/* 24 */     return classNode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final byte[] toBytes(@NotNull ClassNode classNode) {
/* 33 */     Intrinsics.checkParameterIsNotNull(classNode, "classNode"); ClassWriter classWriter = new ClassWriter(3);
/* 34 */     classNode.accept((ClassVisitor)classWriter);
/*    */     
/* 36 */     Intrinsics.checkExpressionValueIsNotNull(classWriter.toByteArray(), "classWriter.toByteArray()"); return classWriter.toByteArray();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\remapper\injectio\\utils\ClassUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */