/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModuleUtils
/*    */ {
/*    */   @SafeVarargs
/*    */   public static void disableModules(Class<? extends Module>... modules) {
/* 13 */     for (Class<? extends Module> module : modules)
/* 14 */       Retreat.moduleManager.getModule(module).setState(false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\ModuleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */