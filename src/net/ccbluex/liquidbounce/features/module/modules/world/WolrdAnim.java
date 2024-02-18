/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ 
/*    */ @ModuleInfo(name = "WorldAnim", description = "Animation for blocking.", category = ModuleCategory.WORLD)
/*    */ public class WolrdAnim extends Module {
/* 11 */   public static final ListValue animmode = new ListValue("Mode", new String[] { "UP", "Down", "Slide" }, "UP");
/* 12 */   public static final IntegerValue chunkAnimationDurationValue = new IntegerValue("ChunkAnimationDuration", 2000, 500, 5000);
/* 13 */   public static final IntegerValue chunkPositionValue = new IntegerValue("ChunkPosition", 50, 10, 256);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\WolrdAnim.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */