/*    */ package net.ccbluex.liquidbounce.ui.client.newdropdown.utils.animations;
/*    */ 
/*    */ public enum Direction {
/*  4 */   FORWARDS,
/*  5 */   BACKWARDS;
/*    */   
/*    */   public Direction opposite() {
/*  8 */     if (this == FORWARDS)
/*  9 */       return BACKWARDS; 
/* 10 */     return FORWARDS;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\newdropdow\\utils\animations\Direction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */