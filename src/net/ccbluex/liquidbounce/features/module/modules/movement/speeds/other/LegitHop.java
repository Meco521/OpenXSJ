/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LegitHop
/*    */   extends SpeedMode
/*    */ {
/*    */   public LegitHop() {
/* 13 */     super("LegitHop");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onMotion() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onUpdate() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 29 */     if (minecraft.field_71439_g.field_70122_E)
/* 30 */       minecraft.field_71439_g.func_70664_aZ(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\other\LegitHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */