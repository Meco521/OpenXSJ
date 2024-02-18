/*    */ package net.ccbluex.liquidbounce.management;
/*    */ 
/*    */ import java.lang.management.ManagementFactory;
/*    */ import java.lang.management.MemoryMXBean;
/*    */ import java.lang.management.MemoryUsage;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Listenable;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ 
/*    */ public class MemoryManager
/*    */   implements Listenable {
/* 12 */   public static float maxMemorySize = 0.0F, usedMemorySize = 0.0F;
/*    */   
/*    */   public static float getMemory() {
/* 15 */     return maxMemorySize / usedMemorySize;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean handleEvents() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(UpdateEvent event) {
/* 25 */     MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
/* 26 */     MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
/* 27 */     maxMemorySize = (float)memoryUsage.getMax() / 1048576.0F;
/* 28 */     usedMemorySize = (float)memoryUsage.getUsed() / 1048576.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\management\MemoryManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */