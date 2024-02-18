/*    */ package net.ccbluex.liquidbounce.injection.forge;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.ccbluex.liquidbounce.injection.transformers.ForgeNetworkTransformer;
/*    */ import net.ccbluex.liquidbounce.script.remapper.injection.transformers.AbstractJavaLinkerTransformer;
/*    */ import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransformerLoader
/*    */   implements IFMLLoadingPlugin
/*    */ {
/*    */   public String[] getASMTransformerClass() {
/* 18 */     return new String[] { ForgeNetworkTransformer.class.getName(), AbstractJavaLinkerTransformer.class.getName() };
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
/*    */ 
/*    */   
/*    */   public String getModContainerClass() {
/* 33 */     return null;
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
/*    */   public String getSetupClass() {
/* 45 */     return null;
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
/*    */   
/*    */   public void injectData(Map<String, Object> data) {}
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
/*    */   public String getAccessTransformerClass() {
/* 70 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\TransformerLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */