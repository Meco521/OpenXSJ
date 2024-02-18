/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.util.EnumHandSide;
/*    */ 
/*    */ public class BlockAnimationUtils extends MinecraftInstance {
/*  8 */   public static Boolean thePlayerisBlocking = Boolean.valueOf(false);
/*    */   public static void doOld(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 10 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/* 11 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/* 12 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/* 13 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 14 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 15 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/* 16 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 17 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 18 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/* 19 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/* 20 */     GlStateManager.func_179114_b((float)(f1 * -80.0D), 1.0F, 0.0F, 0.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\BlockAnimationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */