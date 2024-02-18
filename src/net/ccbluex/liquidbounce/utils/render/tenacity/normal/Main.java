/*    */ package net.ccbluex.liquidbounce.utils.render.tenacity.normal;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */ {
/*    */   public static int categoryCount;
/*    */   public static boolean reloadModules;
/* 16 */   public static float allowedClickGuiHeight = 300.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<Module> getModulesInCategory(ModuleCategory c, ModuleManager moduleManager) {
/* 23 */     return (List<Module>)moduleManager.getModules().stream().filter(m -> (m.getCategory() == c)).collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\tenacity\normal\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */