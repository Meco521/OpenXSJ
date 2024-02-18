/*    */ package net.ccbluex.liquidbounce.script.remapper.injection.utils;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.InsnList;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\037\020\003\032\0020\0042\022\020\005\032\n\022\006\b\001\022\0020\0070\006\"\0020\007¢\006\002\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/script/remapper/injection/utils/NodeUtils;", "", "()V", "toNodes", "Lorg/objectweb/asm/tree/InsnList;", "nodes", "", "Lorg/objectweb/asm/tree/AbstractInsnNode;", "([Lorg/objectweb/asm/tree/AbstractInsnNode;)Lorg/objectweb/asm/tree/InsnList;", "XSJClient"})
/*    */ public final class NodeUtils {
/*    */   static {
/* 11 */     NodeUtils nodeUtils = new NodeUtils();
/*    */   }
/*    */   public static final NodeUtils INSTANCE;
/*    */   
/*    */   @NotNull
/*    */   public final InsnList toNodes(@NotNull AbstractInsnNode... nodes) {
/* 17 */     Intrinsics.checkParameterIsNotNull(nodes, "nodes"); InsnList insnList = new InsnList();
/* 18 */     for (AbstractInsnNode node : nodes)
/* 19 */       insnList.add(node); 
/* 20 */     return insnList;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\remapper\injectio\\utils\NodeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */