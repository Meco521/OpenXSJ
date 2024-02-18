/*    */ package novoline.module;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ 
/*    */ @ModuleInfo(name = "TianKengHelper", description = "ee", category = ModuleCategory.RENDER)
/*    */ public class TianKengHelper
/*    */   extends Module
/*    */ {
/*    */   @EventTarget
/*    */   public void OnUpdate(UpdateEvent event) {
/* 15 */     if (mc.getThePlayer().getHealth() <= 3.0F && mc.getThePlayer().getHurtTime() > 0) {
/* 16 */       mc.getThePlayer().sendChatMessage("草你妈");
/* 17 */       mc.getThePlayer().sendChatMessage("/hub");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\module\TianKengHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */