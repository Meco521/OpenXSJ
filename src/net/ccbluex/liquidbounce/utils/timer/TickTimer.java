/*    */ package net.ccbluex.liquidbounce.utils.timer;
/*    */ 
/*    */ public final class TickTimer
/*    */ {
/*    */   private int tick;
/*    */   
/*    */   public void update() {
/*  8 */     this.tick++;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 12 */     this.tick = 0;
/*    */   }
/*    */   
/*    */   public boolean hasTimePassed(int ticks) {
/* 16 */     return (this.tick >= ticks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\timer\TickTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */