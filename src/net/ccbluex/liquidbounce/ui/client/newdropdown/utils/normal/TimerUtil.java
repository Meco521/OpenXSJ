/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.normal;
/*    */ 
/*    */ public class TimerUtil
/*    */ {
/*  5 */   public long lastMS = System.currentTimeMillis();
/*    */ 
/*    */   
/*    */   public void reset() {
/*  9 */     this.lastMS = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasTimeElapsed(long time, boolean reset) {
/* 14 */     if (System.currentTimeMillis() - this.lastMS > time) {
/* 15 */       if (reset) reset(); 
/* 16 */       return true;
/*    */     } 
/*    */     
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasTimeElapsed(long time) {
/* 24 */     return (System.currentTimeMillis() - this.lastMS > time);
/*    */   }
/*    */ 
/*    */   
/*    */   public long getTime() {
/* 29 */     return System.currentTimeMillis() - this.lastMS;
/*    */   }
/*    */   
/*    */   public void setTime(long time) {
/* 33 */     this.lastMS = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\normal\TimerUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */