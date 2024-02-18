/*    */ package net.ccbluex.liquidbounce.injection.transformers;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.special.AntiForge;
/*    */ import net.ccbluex.liquidbounce.script.remapper.injection.utils.ClassUtils;
/*    */ import net.ccbluex.liquidbounce.script.remapper.injection.utils.NodeUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ import org.objectweb.asm.tree.AbstractInsnNode;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ import org.objectweb.asm.tree.InsnNode;
/*    */ import org.objectweb.asm.tree.JumpInsnNode;
/*    */ import org.objectweb.asm.tree.LabelNode;
/*    */ import org.objectweb.asm.tree.MethodInsnNode;
/*    */ import org.objectweb.asm.tree.MethodNode;
/*    */ 
/*    */ public class ForgeNetworkTransformer implements IClassTransformer {
/*    */   public static boolean returnMethod() {
/* 18 */     return (AntiForge.enabled && AntiForge.blockFML && !Minecraft.func_71410_x().func_71387_A());
/*    */   }
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
/*    */   public byte[] transform(String name, String transformedName, byte[] basicClass) {
/* 31 */     if (name.equals("net.minecraftforge.fml.common.network.handshake.NetworkDispatcher")) {
/*    */       try {
/* 33 */         ClassNode classNode = ClassUtils.INSTANCE.toClassNode(basicClass);
/*    */         
/* 35 */         classNode.methods.stream().filter(methodNode -> methodNode.name.equals("handleVanilla")).forEach(methodNode -> {
/*    */               LabelNode labelNode = new LabelNode();
/*    */ 
/*    */ 
/*    */ 
/*    */               
/*    */               methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), NodeUtils.INSTANCE.toNodes(new AbstractInsnNode[] { (AbstractInsnNode)new MethodInsnNode(184, "net/ccbluex/liquidbounce/injection/transformers/ForgeNetworkTransformer", "returnMethod", "()Z", false), (AbstractInsnNode)new JumpInsnNode(153, labelNode), (AbstractInsnNode)new InsnNode(3), (AbstractInsnNode)new InsnNode(172), (AbstractInsnNode)labelNode }));
/*    */             });
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 47 */         return ClassUtils.INSTANCE.toBytes(classNode);
/* 48 */       } catch (Throwable throwable) {
/* 49 */         throwable.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/* 53 */     if (name.equals("net.minecraftforge.fml.common.network.handshake.HandshakeMessageHandler")) {
/*    */       try {
/* 55 */         ClassNode classNode = ClassUtils.INSTANCE.toClassNode(basicClass);
/*    */         
/* 57 */         classNode.methods.stream().filter(method -> method.name.equals("channelRead0")).forEach(methodNode -> {
/*    */               LabelNode labelNode = new LabelNode();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */               
/*    */               methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), NodeUtils.INSTANCE.toNodes(new AbstractInsnNode[] { (AbstractInsnNode)new MethodInsnNode(184, "net/ccbluex/liquidbounce/injection/transformers/ForgeNetworkTransformer", "returnMethod", "()Z", false), (AbstractInsnNode)new JumpInsnNode(153, labelNode), (AbstractInsnNode)new InsnNode(177), (AbstractInsnNode)labelNode }));
/*    */             });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 71 */         return ClassUtils.INSTANCE.toBytes(classNode);
/* 72 */       } catch (Throwable throwable) {
/* 73 */         throwable.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/* 77 */     return basicClass;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\transformers\ForgeNetworkTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */