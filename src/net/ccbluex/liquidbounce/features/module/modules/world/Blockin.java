/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "Blockin", category = ModuleCategory.WORLD, description = "仙法：结界展开(自动包围自己/偷家用)")
/*    */ public class Blockin
/*    */   extends Module
/*    */ {
/* 17 */   public final BoolValue smart = new BoolValue("Smart", false);
/*    */   
/* 19 */   public final IntegerValue delay = new IntegerValue("Delay/Place", 50, 0, 250);
/* 20 */   public final IntegerValue blocksPerTick = new IntegerValue("Block/Place", 8, 1, 20);
/* 21 */   public final BoolValue rotate = new BoolValue("Rotate", true);
/* 22 */   public final BoolValue disable = new BoolValue("Disable", true);
/* 23 */   public final IntegerValue disableTime = new IntegerValue("Ms/Disable", 200, 1, 250);
/* 24 */   public final BoolValue offhand = new BoolValue("OffHand", true);
/* 25 */   public final BoolValue onlySafe = new BoolValue("OnlySafe", true);
/* 26 */   public final BoolValue highWeb = new BoolValue("HighWeb", false);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 32 */     if (shouldPlaceTrap()) {
/* 33 */       placeTrap();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean shouldPlaceTrap() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   private void placeTrap() {}
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Blockin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */