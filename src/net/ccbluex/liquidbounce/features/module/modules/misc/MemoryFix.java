/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.event.TickEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "MemoryFix", description = "修复主播少得可怜的内存", category = ModuleCategory.MISC)
/*    */ public class MemoryFix
/*    */   extends Module
/*    */ {
/* 19 */   private final FloatValue delay = new FloatValue("Delay", 120.0F, 10.0F, 600.0F);
/* 20 */   private final FloatValue limit = new FloatValue("Limit", 80.0F, 20.0F, 95.0F);
/*    */   
/* 22 */   private final FloatValue Speed = new FloatValue("Speed", 0.05F, 0.0F, 1.0F);
/* 23 */   public MSTimer timer = new MSTimer();
/*    */   
/*    */   @EventTarget
/*    */   public void onTick(TickEvent event) {
/* 27 */     long maxMem = Runtime.getRuntime().maxMemory();
/* 28 */     long totalMem = Runtime.getRuntime().totalMemory();
/* 29 */     long freeMem = Runtime.getRuntime().freeMemory();
/* 30 */     long usedMem = totalMem - freeMem;
/* 31 */     float pct = (float)(usedMem * 100L / maxMem);
/* 32 */     if (this.timer.hasReached(((Float)this.delay.get()).floatValue() * 1000.0D) && ((Float)this.limit.get()).floatValue() <= pct) {
/* 33 */       Runtime.getRuntime().gc();
/* 34 */       this.timer.resetTwo();
/*    */     } 
/*    */   }
/*    */   @EventTarget
/*    */   public void onMotion(MotionEvent event) {
/* 39 */     if (mc.getGameSettings().getKeyBindForward().getPressed() || mc.getGameSettings().getKeyBindLeft().getPressed() || mc.getGameSettings().getKeyBindRight().getPressed() || mc.getGameSettings().getKeyBindBack().getPressed()) {
/* 40 */       if (mc.getThePlayer().getOnGround()) {
/* 41 */         mc.getThePlayer().setCameraPitch(((Float)this.Speed.get()).floatValue());
/*    */       }
/*    */     } else {
/* 44 */       mc.getThePlayer().setCameraPitch(0.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\MemoryFix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */