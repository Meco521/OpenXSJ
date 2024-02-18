/*    */ package net.ccbluex.liquidbounce.script.remapper.injection.transformers;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.script.remapper.injection.utils.ClassUtils;
/*    */ import net.ccbluex.liquidbounce.script.remapper.injection.utils.NodeUtils;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ import org.objectweb.asm.tree.FieldInsnNode;
/*    */ import org.objectweb.asm.tree.MethodInsnNode;
/*    */ import org.objectweb.asm.tree.MethodNode;
/*    */ import org.objectweb.asm.tree.VarInsnNode;
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
/*    */ public class AbstractJavaLinkerTransformer
/*    */   implements IClassTransformer
/*    */ {
/*    */   public byte[] transform(String name, String transformedName, byte[] basicClass) {
/* 31 */     if (name.equals("jdk.internal.dynalink.beans.AbstractJavaLinker")) {
/*    */       try {
/* 33 */         ClassNode classNode = ClassUtils.INSTANCE.toClassNode(basicClass);
/*    */         
/* 35 */         classNode.methods.forEach(methodNode -> {
/*    */               switch (methodNode.name + methodNode.desc) {
/*    */                 case "addMember(Ljava/lang/String;Ljava/lang/reflect/AccessibleObject;Ljava/util/Map;)V":
/*    */                   methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), NodeUtils.INSTANCE.toNodes(new AbstractInsnNode[] { (AbstractInsnNode)new VarInsnNode(25, 0), (AbstractInsnNode)new FieldInsnNode(180, "jdk/internal/dynalink/beans/AbstractJavaLinker", "clazz", "Ljava/lang/Class;"), (AbstractInsnNode)new VarInsnNode(25, 1), (AbstractInsnNode)new VarInsnNode(25, 2), (AbstractInsnNode)new MethodInsnNode(184, "net/ccbluex/liquidbounce/script/remapper/injection/transformers/handlers/AbstractJavaLinkerHandler", "addMember", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/reflect/AccessibleObject;)Ljava/lang/String;", false), (AbstractInsnNode)new VarInsnNode(58, 1) }));
/*    */                   break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */                 
/*    */                 case "addMember(Ljava/lang/String;Ljdk/internal/dynalink/beans/SingleDynamicMethod;Ljava/util/Map;)V":
/*    */                   methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), NodeUtils.INSTANCE.toNodes(new AbstractInsnNode[] { (AbstractInsnNode)new VarInsnNode(25, 0), (AbstractInsnNode)new FieldInsnNode(180, "jdk/internal/dynalink/beans/AbstractJavaLinker", "clazz", "Ljava/lang/Class;"), (AbstractInsnNode)new VarInsnNode(25, 1), (AbstractInsnNode)new MethodInsnNode(184, "net/ccbluex/liquidbounce/script/remapper/injection/transformers/handlers/AbstractJavaLinkerHandler", "addMember", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;", false), (AbstractInsnNode)new VarInsnNode(58, 1) }));
/*    */                   break;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */                 
/*    */                 case "setPropertyGetter(Ljava/lang/String;Ljdk/internal/dynalink/beans/SingleDynamicMethod;Ljdk/internal/dynalink/beans/GuardedInvocationComponent$ValidationType;)V":
/*    */                   methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), NodeUtils.INSTANCE.toNodes(new AbstractInsnNode[] { (AbstractInsnNode)new VarInsnNode(25, 0), (AbstractInsnNode)new FieldInsnNode(180, "jdk/internal/dynalink/beans/AbstractJavaLinker", "clazz", "Ljava/lang/Class;"), (AbstractInsnNode)new VarInsnNode(25, 1), (AbstractInsnNode)new MethodInsnNode(184, "net/ccbluex/liquidbounce/script/remapper/injection/transformers/handlers/AbstractJavaLinkerHandler", "setPropertyGetter", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/String;", false), (AbstractInsnNode)new VarInsnNode(58, 1) }));
/*    */                   break;
/*    */               } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/*    */             });
/* 68 */         return ClassUtils.INSTANCE.toBytes(classNode);
/* 69 */       } catch (Throwable throwable) {
/* 70 */         throwable.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/* 74 */     return basicClass;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\remapper\injection\transformers\AbstractJavaLinkerTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */