/*    */ package tomk.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiIngame;
/*    */ 
/*    */ public class CodeTool
/*    */   extends MinecraftInstance {
/*    */   public static GuiIngame guiIngame;
/*    */   public static IEnumFacing enumFacing;
/*    */   
/*    */   public static void setSpeed(double speed) {
/* 15 */     (Minecraft.func_71410_x()).field_71439_g.field_70159_w = -Math.sin(MovementUtils.getDirection()) * speed;
/* 16 */     (Minecraft.func_71410_x()).field_71439_g.field_70179_y = Math.cos(MovementUtils.getDirection()) * speed;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\CodeTool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */