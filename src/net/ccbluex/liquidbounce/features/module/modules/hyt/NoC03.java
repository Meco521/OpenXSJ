/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ 
/*    */ @ModuleInfo(name = "NoC03", description = "No C03", category = ModuleCategory.HYT)
/*    */ public class NoC03 extends Module {
/*    */   @EventTarget
/*    */   public void onPacket(PacketEvent event) {
/* 15 */     IPacket packet = event.getPacket();
/* 16 */     if (classProvider.isCPacketPlayer(packet))
/* 17 */       event.cancelEvent(); 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onMove(MoveEvent event) {
/* 22 */     event.zero();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\NoC03.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */